package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import v7.v7.package_13.CoordinatorLayout.LayoutParams;
import v7.v7.package_13.NestedScrollingChild;
import v7.v7.package_13.NestedScrollingChildHelper;
import v7.v7.package_13.NestedScrollingParent;
import v7.v7.package_13.NestedScrollingParentHelper;
import v7.v7.package_13.ViewCompat;

public class SwipeRefreshLayout
  extends ViewGroup
  implements v7.v7.package_13.Object, CoordinatorLayout.LayoutParams, NestedScrollingChild, NestedScrollingParent
{
  private static final int[] LAYOUT_ATTRS = { 16842766 };
  private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
  private int density;
  private int mActivePointerId = -1;
  private Animation mAlphaMaxAnimation;
  private Animation mAlphaStartAnimation;
  private final Animation mAnimateToCorrectPosition = new f();
  private final Animation mAnimateToStartPosition = new g();
  CircleImageView mCircleView;
  private int mCircleViewIndex = -1;
  int mCurrentTargetOffsetTop;
  private final DecelerateInterpolator mDecelerateInterpolator;
  int mDownX;
  protected int mFrom;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private float mLastMotionY;
  j mListener;
  private int mMediumAnimationDuration;
  private boolean mNestedScrollInProgress;
  private final NestedScrollingChildHelper mNestedScrollingChildHelper;
  private final NestedScrollingParentHelper mNestedScrollingParentHelper;
  boolean mNotify;
  protected int mOriginalOffsetTop;
  private final int[] mParentOffsetInWindow = new int[2];
  private final int[] mParentScrollConsumed = new int[2];
  private i mPrevY;
  MaterialProgressDrawable mProgress;
  private Animation.AnimationListener mRefreshListener = new a();
  boolean mRefreshing = false;
  private boolean mReturningToStart;
  private boolean mReverse;
  boolean mScale;
  private Animation mScaleAnimation;
  private Animation mScaleDownAnimation;
  private Animation mScaleDownToStartAnimation;
  int mSpinnerFinalOffset;
  float mStartingScale;
  private android.view.View mTarget;
  private float mTotalDragDistance = -1.0F;
  private float mTotalUnconsumed;
  private int mTouchSlop;
  boolean mUsingCustomStart;
  private final int[] y = new int[2];
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    mMediumAnimationDuration = getResources().getInteger(17694721);
    setWillNotDraw(false);
    mDecelerateInterpolator = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    density = ((int)(density * 40.0F));
    createProgressView();
    setChildrenDrawingOrderEnabled(true);
    int i = (int)(density * 64.0F);
    mSpinnerFinalOffset = i;
    mTotalDragDistance = i;
    mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
    setNestedScrollingEnabled(true);
    i = -density;
    mCurrentTargetOffsetTop = i;
    mOriginalOffsetTop = i;
    reset(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void animateOffsetToCorrectPosition(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    mFrom = paramInt;
    mAnimateToCorrectPosition.reset();
    mAnimateToCorrectPosition.setDuration(200L);
    mAnimateToCorrectPosition.setInterpolator(mDecelerateInterpolator);
    if (paramAnimationListener != null) {
      mCircleView.setAnimationListener(paramAnimationListener);
    }
    mCircleView.clearAnimation();
    mCircleView.startAnimation(mAnimateToCorrectPosition);
  }
  
  private void animateOffsetToStartPosition(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (mScale)
    {
      startScaleDownReturnToStartAnimation(paramInt, paramAnimationListener);
      return;
    }
    mFrom = paramInt;
    mAnimateToStartPosition.reset();
    mAnimateToStartPosition.setDuration(200L);
    mAnimateToStartPosition.setInterpolator(mDecelerateInterpolator);
    if (paramAnimationListener != null) {
      mCircleView.setAnimationListener(paramAnimationListener);
    }
    mCircleView.clearAnimation();
    mCircleView.startAnimation(mAnimateToStartPosition);
  }
  
  private void createProgressView()
  {
    mCircleView = new CircleImageView(getContext());
    MaterialProgressDrawable localMaterialProgressDrawable = new MaterialProgressDrawable(getContext());
    mProgress = localMaterialProgressDrawable;
    localMaterialProgressDrawable.updateSizes(1);
    mCircleView.setImageDrawable(mProgress);
    mCircleView.setVisibility(8);
    addView(mCircleView);
  }
  
  private void ensureTarget()
  {
    if (mTarget == null)
    {
      int i = 0;
      while (i < getChildCount())
      {
        android.view.View localView = getChildAt(i);
        if (!localView.equals(mCircleView))
        {
          mTarget = localView;
          return;
        }
        i += 1;
      }
    }
  }
  
  private void finishSpinner(float paramFloat)
  {
    if (paramFloat > mTotalDragDistance)
    {
      setRefreshing(true, true);
      return;
    }
    mRefreshing = false;
    mProgress.setStartEndTrim(0.0F, 0.0F);
    e localE = null;
    if (!mScale) {
      localE = new e();
    }
    animateOffsetToStartPosition(mCurrentTargetOffsetTop, localE);
    mProgress.showArrow(false);
  }
  
  private boolean isAnimationRunning(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void moveSpinner(float paramFloat)
  {
    mProgress.showArrow(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / mTotalDragDistance));
    float f2 = (float)Math.max(f1 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = mTotalDragDistance;
    int i = mDownX;
    if (i > 0) {}
    float f3;
    for (;;)
    {
      f3 = i;
      break;
      if (mUsingCustomStart) {
        i = mSpinnerFinalOffset - mOriginalOffsetTop;
      } else {
        i = mSpinnerFinalOffset;
      }
    }
    double d = Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3) / 4.0F;
    f4 = (float)(d - Math.pow(d, 2.0D)) * 2.0F;
    i = mOriginalOffsetTop;
    int j = (int)(f3 * f1 + f3 * f4 * 2.0F);
    if (mCircleView.getVisibility() != 0) {
      mCircleView.setVisibility(0);
    }
    if (!mScale)
    {
      mCircleView.setScaleX(1.0F);
      mCircleView.setScaleY(1.0F);
    }
    if (mScale) {
      setAnimationProgress(Math.min(1.0F, paramFloat / mTotalDragDistance));
    }
    if (paramFloat < mTotalDragDistance)
    {
      if ((mProgress.getAlpha() > 76) && (!isAnimationRunning(mAlphaStartAnimation))) {
        startProgressAlphaStartAnimation();
      }
    }
    else if ((mProgress.getAlpha() < 255) && (!isAnimationRunning(mAlphaMaxAnimation))) {
      startProgressAlphaMaxAnimation();
    }
    mProgress.setStartEndTrim(0.0F, Math.min(0.8F, f2 * 0.8F));
    mProgress.setArrowScale(Math.min(1.0F, f2));
    mProgress.setProgressRotation((f2 * 0.4F - 0.25F + f4 * 2.0F) * 0.5F);
    setTargetOffsetTopAndBottom(i + j - mCurrentTargetOffsetTop);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == mActivePointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      mActivePointerId = paramMotionEvent.getPointerId(i);
    }
  }
  
  private void onTouchEvent(float paramFloat)
  {
    float f = mInitialMotionY;
    int i = mTouchSlop;
    if ((paramFloat - f > i) && (!mIsBeingDragged))
    {
      mLastMotionY = (f + i);
      mIsBeingDragged = true;
      mProgress.setAlpha(76);
    }
  }
  
  private void setColorViewAlpha(int paramInt)
  {
    mCircleView.getBackground().setAlpha(paramInt);
    mProgress.setAlpha(paramInt);
  }
  
  private void setRefreshing(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mRefreshing != paramBoolean1)
    {
      mNotify = paramBoolean2;
      ensureTarget();
      mRefreshing = paramBoolean1;
      if (paramBoolean1)
      {
        animateOffsetToCorrectPosition(mCurrentTargetOffsetTop, mRefreshListener);
        return;
      }
      startScaleDownAnimation(mRefreshListener);
    }
  }
  
  private Animation startAlphaAnimation(final int paramInt1, final int paramInt2)
  {
    d localD = new d(paramInt1, paramInt2);
    localD.setDuration(300L);
    mCircleView.setAnimationListener(null);
    mCircleView.clearAnimation();
    mCircleView.startAnimation(localD);
    return localD;
  }
  
  private void startProgressAlphaMaxAnimation()
  {
    mAlphaMaxAnimation = startAlphaAnimation(mProgress.getAlpha(), 255);
  }
  
  private void startProgressAlphaStartAnimation()
  {
    mAlphaStartAnimation = startAlphaAnimation(mProgress.getAlpha(), 76);
  }
  
  private void startScaleDownReturnToStartAnimation(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    mFrom = paramInt;
    mStartingScale = mCircleView.getScaleX();
    h localH = new h();
    mScaleDownToStartAnimation = localH;
    localH.setDuration(150L);
    if (paramAnimationListener != null) {
      mCircleView.setAnimationListener(paramAnimationListener);
    }
    mCircleView.clearAnimation();
    mCircleView.startAnimation(mScaleDownToStartAnimation);
  }
  
  private void startScaleUpAnimation(Animation.AnimationListener paramAnimationListener)
  {
    mCircleView.setVisibility(0);
    mProgress.setAlpha(255);
    b localB = new b();
    mScaleAnimation = localB;
    localB.setDuration(mMediumAnimationDuration);
    if (paramAnimationListener != null) {
      mCircleView.setAnimationListener(paramAnimationListener);
    }
    mCircleView.clearAnimation();
    mCircleView.startAnimation(mScaleAnimation);
  }
  
  public void a(android.view.View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    if (paramInt5 != 0) {
      return;
    }
    int i = paramArrayOfInt[1];
    setNestedScrollingEnabled(paramInt1, paramInt2, paramInt3, paramInt4, mParentOffsetInWindow, paramInt5, paramArrayOfInt);
    paramInt2 = paramInt4 - (paramArrayOfInt[1] - i);
    if (paramInt2 == 0) {
      paramInt1 = paramInt4 + mParentOffsetInWindow[1];
    } else {
      paramInt1 = paramInt2;
    }
    if ((paramInt1 < 0) && (!canChildScrollUp()))
    {
      float f = mTotalUnconsumed + Math.abs(paramInt1);
      mTotalUnconsumed = f;
      moveSpinner(f);
      paramArrayOfInt[1] += paramInt2;
    }
  }
  
  public boolean a(android.view.View paramView1, android.view.View paramView2, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return onStartNestedScroll(paramView1, paramView2, paramInt1);
    }
    return false;
  }
  
  public boolean canChildScrollUp()
  {
    Object localObject = mPrevY;
    if (localObject != null) {
      return ((i)localObject).canScrollVertically(this, mTarget);
    }
    localObject = mTarget;
    if ((localObject instanceof ListView)) {
      return androidx.core.widget.View.update((ListView)localObject, -1);
    }
    return ((android.view.View)localObject).canScrollVertically(-1);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return mNestedScrollingChildHelper.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return mNestedScrollingChildHelper.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return mNestedScrollingChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return mNestedScrollingChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = mCircleViewIndex;
    if (i < 0) {
      return paramInt2;
    }
    if (paramInt2 == paramInt1 - 1) {
      return i;
    }
    if (paramInt2 >= i) {
      return paramInt2 + 1;
    }
    return paramInt2;
  }
  
  public int getNestedScrollAxes()
  {
    return mNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  public int getProgressCircleDiameter()
  {
    return density;
  }
  
  public int getProgressViewEndOffset()
  {
    return mSpinnerFinalOffset;
  }
  
  public int getProgressViewStartOffset()
  {
    return mOriginalOffsetTop;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return mNestedScrollingChildHelper.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return mNestedScrollingChildHelper.isNestedScrollingEnabled();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public void onDraw(android.view.View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 0) {
      onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ensureTarget();
    int i = paramMotionEvent.getActionMasked();
    if ((mReturningToStart) && (i == 0)) {
      mReturningToStart = false;
    }
    if ((isEnabled()) && (!mReturningToStart) && (!canChildScrollUp()) && (!mRefreshing))
    {
      if (mNestedScrollInProgress) {
        return false;
      }
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 6) {
                break label210;
              }
              onSecondaryPointerUp(paramMotionEvent);
              break label210;
            }
          }
          else
          {
            i = mActivePointerId;
            if (i == -1)
            {
              Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
              return false;
            }
            i = paramMotionEvent.findPointerIndex(i);
            if (i < 0) {
              return false;
            }
            onTouchEvent(paramMotionEvent.getY(i));
            break label210;
          }
        }
        mIsBeingDragged = false;
        mActivePointerId = -1;
      }
      else
      {
        setTargetOffsetTopAndBottom(mOriginalOffsetTop - mCircleView.getTop());
        i = paramMotionEvent.getPointerId(0);
        mActivePointerId = i;
        mIsBeingDragged = false;
        i = paramMotionEvent.findPointerIndex(i);
        if (i < 0) {
          return false;
        }
        mInitialMotionY = paramMotionEvent.getY(i);
      }
      label210:
      return mIsBeingDragged;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0) {
      return;
    }
    if (mTarget == null) {
      ensureTarget();
    }
    Object localObject = mTarget;
    if (localObject == null) {
      return;
    }
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    ((android.view.View)localObject).layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt3 = mCircleView.getMeasuredWidth();
    paramInt2 = mCircleView.getMeasuredHeight();
    localObject = mCircleView;
    paramInt1 /= 2;
    paramInt3 /= 2;
    paramInt4 = mCurrentTargetOffsetTop;
    ((android.view.View)localObject).layout(paramInt1 - paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (mTarget == null) {
      ensureTarget();
    }
    android.view.View localView = mTarget;
    if (localView == null) {
      return;
    }
    localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    mCircleView.measure(View.MeasureSpec.makeMeasureSpec(density, 1073741824), View.MeasureSpec.makeMeasureSpec(density, 1073741824));
    mCircleViewIndex = -1;
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      if (getChildAt(paramInt1) == mCircleView)
      {
        mCircleViewIndex = paramInt1;
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public boolean onNestedFling(android.view.View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(android.view.View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(android.view.View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (paramInt2 > 0)
    {
      float f1 = mTotalUnconsumed;
      if (f1 > 0.0F)
      {
        float f2 = paramInt2;
        if (f2 > f1)
        {
          paramArrayOfInt[1] = ((int)f1);
          mTotalUnconsumed = 0.0F;
        }
        else
        {
          mTotalUnconsumed = (f1 - f2);
          paramArrayOfInt[1] = paramInt2;
        }
        moveSpinner(mTotalUnconsumed);
      }
    }
    if ((mUsingCustomStart) && (paramInt2 > 0) && (mTotalUnconsumed == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
      mCircleView.setVisibility(8);
    }
    paramView = mParentScrollConsumed;
    if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
    {
      paramArrayOfInt[0] += paramView[0];
      paramArrayOfInt[1] += paramView[1];
    }
  }
  
  public void onNestedScroll(android.view.View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0, y);
  }
  
  public void onNestedScroll(android.view.View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, y);
  }
  
  public void onNestedScrollAccepted(android.view.View paramView1, android.view.View paramView2, int paramInt)
  {
    mNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    startNestedScroll(paramInt & 0x2);
    mTotalUnconsumed = 0.0F;
    mNestedScrollInProgress = true;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setRefreshing(b);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    return new SavedState(super.onSaveInstanceState(), mRefreshing);
  }
  
  public boolean onStartNestedScroll(android.view.View paramView1, android.view.View paramView2, int paramInt)
  {
    return (isEnabled()) && (!mReturningToStart) && (!mRefreshing) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(android.view.View paramView)
  {
    mNestedScrollingParentHelper.onStopNestedScroll(paramView);
    mNestedScrollInProgress = false;
    float f = mTotalUnconsumed;
    if (f > 0.0F)
    {
      finishSpinner(f);
      mTotalUnconsumed = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((mReturningToStart) && (i == 0)) {
      mReturningToStart = false;
    }
    if ((isEnabled()) && (!mReturningToStart) && (!canChildScrollUp()) && (!mRefreshing))
    {
      if (mNestedScrollInProgress) {
        return false;
      }
      if (i != 0)
      {
        float f1;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 5)
              {
                if (i != 6) {
                  return true;
                }
                onSecondaryPointerUp(paramMotionEvent);
                return true;
              }
              i = paramMotionEvent.getActionIndex();
              if (i < 0)
              {
                Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                return false;
              }
              mActivePointerId = paramMotionEvent.getPointerId(i);
              return true;
            }
            return false;
          }
          i = paramMotionEvent.findPointerIndex(mActivePointerId);
          if (i < 0)
          {
            Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
            return false;
          }
          f1 = paramMotionEvent.getY(i);
          onTouchEvent(f1);
          if (mIsBeingDragged)
          {
            f1 = (f1 - mLastMotionY) * 0.5F;
            if (f1 > 0.0F)
            {
              getParent().requestDisallowInterceptTouchEvent(true);
              moveSpinner(f1);
              return true;
            }
            return false;
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(mActivePointerId);
          if (i < 0)
          {
            Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
            return false;
          }
          if (mIsBeingDragged)
          {
            f1 = paramMotionEvent.getY(i);
            float f2 = mLastMotionY;
            mIsBeingDragged = false;
            finishSpinner((f1 - f2) * 0.5F);
          }
          mActivePointerId = -1;
          return false;
        }
      }
      else
      {
        mActivePointerId = paramMotionEvent.getPointerId(0);
        mIsBeingDragged = false;
        return true;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public void performIntercept(android.view.View paramView, int paramInt)
  {
    if (paramInt == 0) {
      onStopNestedScroll(paramView);
    }
  }
  
  public void performIntercept(android.view.View paramView1, android.view.View paramView2, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      onNestedScrollAccepted(paramView1, paramView2, paramInt1);
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    Object localObject;
    if ((Build.VERSION.SDK_INT >= 21) || (!(mTarget instanceof AbsListView)))
    {
      localObject = mTarget;
      if ((localObject == null) || (ViewCompat.isNestedScrollingEnabled((android.view.View)localObject))) {}
    }
    else
    {
      if (mReverse) {
        return;
      }
      localObject = getParent();
      if (localObject == null) {
        return;
      }
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(paramBoolean);
      return;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  void reset()
  {
    mCircleView.clearAnimation();
    mProgress.stop();
    mCircleView.setVisibility(8);
    setColorViewAlpha(255);
    if (mScale) {
      setAnimationProgress(0.0F);
    } else {
      setTargetOffsetTopAndBottom(mOriginalOffsetTop - mCurrentTargetOffsetTop);
    }
    mCurrentTargetOffsetTop = mCircleView.getTop();
  }
  
  void reset(float paramFloat)
  {
    int i = mFrom;
    setTargetOffsetTopAndBottom(i + (int)((mOriginalOffsetTop - i) * paramFloat) - mCircleView.getTop());
  }
  
  void setAnimationProgress(float paramFloat)
  {
    mCircleView.setScaleX(paramFloat);
    mCircleView.setScaleY(paramFloat);
  }
  
  public void setColorScheme(int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    ensureTarget();
    mProgress.setColorSchemeColors(paramVarArgs);
  }
  
  public void setColorSchemeResources(int... paramVarArgs)
  {
    Context localContext = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfInt[i] = ContextCompat.getColor(localContext, paramVarArgs[i]);
      i += 1;
    }
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    mTotalDragDistance = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (!paramBoolean) {
      reset();
    }
  }
  
  public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean paramBoolean)
  {
    mReverse = paramBoolean;
  }
  
  public void setNestedScrollingEnabled(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, int[] paramArrayOfInt2)
  {
    if (paramInt5 == 0) {
      mNestedScrollingChildHelper.setNestedScrollingEnabled(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    mNestedScrollingChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(i paramI)
  {
    mPrevY = paramI;
  }
  
  public void setOnRefreshListener(j paramJ)
  {
    mListener = paramJ;
  }
  
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    mCircleView.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (mRefreshing != paramBoolean))
    {
      mRefreshing = paramBoolean;
      int i;
      if (!mUsingCustomStart) {
        i = mSpinnerFinalOffset + mOriginalOffsetTop;
      } else {
        i = mSpinnerFinalOffset;
      }
      setTargetOffsetTopAndBottom(i - mCurrentTargetOffsetTop);
      mNotify = false;
      startScaleUpAnimation(mRefreshListener);
      return;
    }
    setRefreshing(paramBoolean, false);
  }
  
  public void setSize(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if (paramInt == 0) {
      density = ((int)(density * 56.0F));
    } else {
      density = ((int)(density * 40.0F));
    }
    mCircleView.setImageDrawable(null);
    mProgress.updateSizes(paramInt);
    mCircleView.setImageDrawable(mProgress);
  }
  
  public void setSlingshotDistance(int paramInt)
  {
    mDownX = paramInt;
  }
  
  void setTargetOffsetTopAndBottom(int paramInt)
  {
    mCircleView.bringToFront();
    ViewCompat.offsetTopAndBottom(mCircleView, paramInt);
    mCurrentTargetOffsetTop = mCircleView.getTop();
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return mNestedScrollingChildHelper.startNestedScroll(paramInt);
  }
  
  void startScaleDownAnimation(Animation.AnimationListener paramAnimationListener)
  {
    c localC = new c();
    mScaleDownAnimation = localC;
    localC.setDuration(150L);
    mCircleView.setAnimationListener(paramAnimationListener);
    mCircleView.clearAnimation();
    mCircleView.startAnimation(mScaleDownAnimation);
  }
  
  public void stopNestedScroll()
  {
    mNestedScrollingChildHelper.stopNestedScroll();
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    final boolean b;
    
    SavedState(Parcel paramParcel)
    {
      super();
      boolean bool;
      if (paramParcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      b = bool;
    }
    
    SavedState(Parcelable paramParcelable, boolean paramBoolean)
    {
      super();
      b = paramBoolean;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeByte((byte)b);
    }
    
    class a
      implements Parcelable.Creator<SwipeRefreshLayout.SavedState>
    {
      a() {}
      
      public SwipeRefreshLayout.SavedState[] a(int paramInt)
      {
        return new SwipeRefreshLayout.SavedState[paramInt];
      }
      
      public SwipeRefreshLayout.SavedState readDate(Parcel paramParcel)
      {
        return new SwipeRefreshLayout.SavedState(paramParcel);
      }
    }
  }
  
  class a
    implements Animation.AnimationListener
  {
    a() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      paramAnimation = SwipeRefreshLayout.this;
      if (mRefreshing)
      {
        mProgress.setAlpha(255);
        mProgress.start();
        paramAnimation = SwipeRefreshLayout.this;
        if (mNotify)
        {
          paramAnimation = mListener;
          if (paramAnimation != null) {
            paramAnimation.onRefresh();
          }
        }
        paramAnimation = SwipeRefreshLayout.this;
        mCurrentTargetOffsetTop = mCircleView.getTop();
        return;
      }
      paramAnimation.reset();
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  class b
    extends Animation
  {
    b() {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      setAnimationProgress(paramFloat);
    }
  }
  
  class c
    extends Animation
  {
    c() {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      setAnimationProgress(1.0F - paramFloat);
    }
  }
  
  class d
    extends Animation
  {
    d(int paramInt1, int paramInt2) {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramTransformation = mProgress;
      int i = paramInt1;
      paramTransformation.setAlpha((int)(i + (paramInt2 - i) * paramFloat));
    }
  }
  
  class e
    implements Animation.AnimationListener
  {
    e() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      paramAnimation = SwipeRefreshLayout.this;
      if (!mScale) {
        paramAnimation.startScaleDownAnimation(null);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  class f
    extends Animation
  {
    f() {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramTransformation = SwipeRefreshLayout.this;
      if (!mUsingCustomStart) {
        i = mSpinnerFinalOffset - Math.abs(mOriginalOffsetTop);
      } else {
        i = mSpinnerFinalOffset;
      }
      paramTransformation = SwipeRefreshLayout.this;
      int j = mFrom;
      int i = (int)((i - j) * paramFloat);
      int k = mCircleView.getTop();
      setTargetOffsetTopAndBottom(j + i - k);
      mProgress.setArrowScale(1.0F - paramFloat);
    }
  }
  
  class g
    extends Animation
  {
    g() {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      reset(paramFloat);
    }
  }
  
  class h
    extends Animation
  {
    h() {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramTransformation = SwipeRefreshLayout.this;
      float f = mStartingScale;
      paramTransformation.setAnimationProgress(f + -f * paramFloat);
      reset(paramFloat);
    }
  }
  
  public static abstract interface i
  {
    public abstract boolean canScrollVertically(SwipeRefreshLayout paramSwipeRefreshLayout, android.view.View paramView);
  }
  
  public static abstract interface j
  {
    public abstract void onRefresh();
  }
}
