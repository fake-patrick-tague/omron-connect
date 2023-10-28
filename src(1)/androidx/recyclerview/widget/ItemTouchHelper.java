package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;
import v7.cardview.R.dimen;
import v7.v7.package_13.GestureDetectorCompat;
import v7.v7.package_13.ViewCompat;

public class ItemTouchHelper
  extends RecyclerView.n
  implements RecyclerView.p
{
  private int mActionState = 0;
  int mActivePointerId = -1;
  Callback mCallback;
  private RecyclerView.j mChildDrawingOrderCallback = null;
  private List<Integer> mDistances;
  private long mDragScrollStartTimeInMs;
  float mDx;
  float mDy;
  GestureDetectorCompat mGestureDetector;
  float mInitialTouchX;
  float mInitialTouchY;
  private ItemTouchHelperGestureListener mListener;
  private float mMaxSwipeVelocity;
  private final RecyclerView.r mOnItemTouchListener = new RecyclerView.r()
  {
    public boolean onInterceptTouchEvent(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      int i = paramAnonymousMotionEvent.getActionMasked();
      Object localObject2;
      if (i == 0)
      {
        mActivePointerId = paramAnonymousMotionEvent.getPointerId(0);
        mInitialTouchX = paramAnonymousMotionEvent.getX();
        mInitialTouchY = paramAnonymousMotionEvent.getY();
        obtainVelocityTracker();
        localObject2 = ItemTouchHelper.this;
        localObject1 = this;
        paramAnonymousRecyclerView = (RecyclerView)localObject1;
        if (mSelected == null)
        {
          localObject2 = ((ItemTouchHelper)localObject2).findAnimation(paramAnonymousMotionEvent);
          paramAnonymousRecyclerView = (RecyclerView)localObject1;
          if (localObject2 != null)
          {
            paramAnonymousRecyclerView = this$0;
            mInitialTouchX -= mX;
            mInitialTouchY -= mY;
            paramAnonymousRecyclerView.endRecoverAnimation(mViewHolder, true);
            paramAnonymousRecyclerView = this$0;
            if (mPendingCleanup.remove(mViewHolder.itemView))
            {
              paramAnonymousRecyclerView = this$0;
              mCallback.clearView(mRecyclerView, mViewHolder);
            }
            paramAnonymousRecyclerView = this;
            this$0.select(mViewHolder, mActionState);
            localObject1 = this$0;
            ((ItemTouchHelper)localObject1).updateDxDy(paramAnonymousMotionEvent, mSelectedFlags, 0);
          }
        }
      }
      else if ((i != 3) && (i != 1))
      {
        paramAnonymousRecyclerView = ItemTouchHelper.this;
        localObject1 = this;
        int j = mActivePointerId;
        paramAnonymousRecyclerView = (RecyclerView)localObject1;
        if (j != -1)
        {
          j = paramAnonymousMotionEvent.findPointerIndex(j);
          paramAnonymousRecyclerView = (RecyclerView)localObject1;
          if (j >= 0)
          {
            localObject2 = this$0;
            paramAnonymousRecyclerView = (RecyclerView)localObject1;
            ((ItemTouchHelper)localObject2).checkSelectForSwipe(i, paramAnonymousMotionEvent, j);
          }
        }
      }
      else
      {
        localObject1 = ItemTouchHelper.this;
        paramAnonymousRecyclerView = this;
        mActivePointerId = -1;
        ((ItemTouchHelper)localObject1).select(null, 0);
      }
      Object localObject1 = this$0.mVelocityTracker;
      if (localObject1 != null) {
        ((VelocityTracker)localObject1).addMovement(paramAnonymousMotionEvent);
      }
      return this$0.mSelected != null;
    }
    
    public void onRequestDisallowInterceptTouchEvent(boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        return;
      }
      select(null, 0);
    }
    
    public void onTouchEvent(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      paramAnonymousRecyclerView = mVelocityTracker;
      if (paramAnonymousRecyclerView != null) {
        paramAnonymousRecyclerView.addMovement(paramAnonymousMotionEvent);
      }
      if (mActivePointerId == -1) {
        return;
      }
      int j = paramAnonymousMotionEvent.getActionMasked();
      int k = paramAnonymousMotionEvent.findPointerIndex(mActivePointerId);
      if (k >= 0) {
        checkSelectForSwipe(j, paramAnonymousMotionEvent, k);
      }
      paramAnonymousRecyclerView = ItemTouchHelper.this;
      RecyclerView.b0 localB0 = mSelected;
      if (localB0 == null) {
        return;
      }
      int i = 0;
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 6) {
              return;
            }
            j = paramAnonymousMotionEvent.getActionIndex();
            k = paramAnonymousMotionEvent.getPointerId(j);
            paramAnonymousRecyclerView = ItemTouchHelper.this;
            if (k != mActivePointerId) {
              return;
            }
            if (j == 0) {
              i = 1;
            }
            mActivePointerId = paramAnonymousMotionEvent.getPointerId(i);
            paramAnonymousRecyclerView = ItemTouchHelper.this;
            paramAnonymousRecyclerView.updateDxDy(paramAnonymousMotionEvent, mSelectedFlags, j);
            return;
          }
          paramAnonymousRecyclerView = mVelocityTracker;
          if (paramAnonymousRecyclerView != null) {
            paramAnonymousRecyclerView.clear();
          }
        }
        else
        {
          if (k < 0) {
            return;
          }
          paramAnonymousRecyclerView.updateDxDy(paramAnonymousMotionEvent, mSelectedFlags, k);
          moveIfNecessary(localB0);
          paramAnonymousRecyclerView = ItemTouchHelper.this;
          mRecyclerView.removeCallbacks(r);
          r.run();
          mRecyclerView.invalidate();
          return;
        }
      }
      select(null, 0);
      mActivePointerId = -1;
    }
  };
  View mOverdrawChild = null;
  int mOverdrawChildPosition = -1;
  final List<View> mPendingCleanup = new ArrayList();
  List<k.h> mRecoverAnimations = new ArrayList();
  RecyclerView mRecyclerView;
  RecyclerView.b0 mSelected = null;
  int mSelectedFlags;
  private float mSelectedStartX;
  private float mSelectedStartY;
  private int mSlop;
  private List<RecyclerView.b0> mSwapTargets;
  private float mSwipeEscapeVelocity;
  private final float[] mTmpPosition = new float[2];
  private Rect mTmpRect;
  VelocityTracker mVelocityTracker;
  final Runnable r = new EventInfoFragment.1(this);
  
  public ItemTouchHelper(Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  private void addChildDrawingOrderCallback()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return;
    }
    if (mChildDrawingOrderCallback == null) {
      mChildDrawingOrderCallback = new SwipeRefreshLayout(this);
    }
    mRecyclerView.setChildDrawingOrderCallback(mChildDrawingOrderCallback);
  }
  
  private int checkHorizontalSwipe(RecyclerView.b0 paramB0, int paramInt)
  {
    if ((paramInt & 0xC) != 0)
    {
      float f1 = mDx;
      int j = 8;
      int i;
      if (f1 > 0.0F) {
        i = 8;
      } else {
        i = 4;
      }
      VelocityTracker localVelocityTracker = mVelocityTracker;
      if ((localVelocityTracker != null) && (mActivePointerId > -1))
      {
        localVelocityTracker.computeCurrentVelocity(1000, mCallback.getSwipeVelocityThreshold(mMaxSwipeVelocity));
        f2 = mVelocityTracker.getXVelocity(mActivePointerId);
        f1 = mVelocityTracker.getYVelocity(mActivePointerId);
        if (f2 <= 0.0F) {
          j = 4;
        }
        f2 = Math.abs(f2);
        if (((j & paramInt) != 0) && (i == j) && (f2 >= mCallback.getSwipeEscapeVelocity(mSwipeEscapeVelocity)) && (f2 > Math.abs(f1))) {
          return j;
        }
      }
      f1 = mRecyclerView.getWidth();
      float f2 = mCallback.getSwipeThreshold(paramB0);
      if (((paramInt & i) != 0) && (Math.abs(mDx) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private int checkVerticalSwipe(RecyclerView.b0 paramB0, int paramInt)
  {
    if ((paramInt & 0x3) != 0)
    {
      float f1 = mDy;
      int j = 2;
      int i;
      if (f1 > 0.0F) {
        i = 2;
      } else {
        i = 1;
      }
      VelocityTracker localVelocityTracker = mVelocityTracker;
      if ((localVelocityTracker != null) && (mActivePointerId > -1))
      {
        localVelocityTracker.computeCurrentVelocity(1000, mCallback.getSwipeVelocityThreshold(mMaxSwipeVelocity));
        f1 = mVelocityTracker.getXVelocity(mActivePointerId);
        f2 = mVelocityTracker.getYVelocity(mActivePointerId);
        if (f2 <= 0.0F) {
          j = 1;
        }
        f2 = Math.abs(f2);
        if (((j & paramInt) != 0) && (j == i) && (f2 >= mCallback.getSwipeEscapeVelocity(mSwipeEscapeVelocity)) && (f2 > Math.abs(f1))) {
          return j;
        }
      }
      f1 = mRecyclerView.getHeight();
      float f2 = mCallback.getSwipeThreshold(paramB0);
      if (((paramInt & i) != 0) && (Math.abs(mDy) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private void destroyCallbacks()
  {
    mRecyclerView.removeItemDecoration(this);
    mRecyclerView.removeOnItemTouchListener(mOnItemTouchListener);
    mRecyclerView.removeOnChildAttachStateChangeListener(this);
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)mRecoverAnimations.get(0);
      localRecoverAnimation.cancel();
      mCallback.clearView(mRecyclerView, mViewHolder);
      i -= 1;
    }
    mRecoverAnimations.clear();
    mOverdrawChild = null;
    mOverdrawChildPosition = -1;
    releaseVelocityTracker();
    select();
  }
  
  private List findSwapTargets(RecyclerView.b0 paramB0)
  {
    Object localObject = mSwapTargets;
    if (localObject == null)
    {
      mSwapTargets = new ArrayList();
      mDistances = new ArrayList();
    }
    else
    {
      ((List)localObject).clear();
      mDistances.clear();
    }
    int j = mCallback.getBoundingBoxMargin();
    int m = Math.round(mSelectedStartX + mDx) - j;
    int n = Math.round(mSelectedStartY + mDy) - j;
    int i = itemView.getWidth();
    j *= 2;
    int i1 = i + m + j;
    int i2 = itemView.getHeight() + n + j;
    int i3 = (m + i1) / 2;
    int i4 = (n + i2) / 2;
    localObject = mRecyclerView.getLayoutManager();
    int i5 = ((RecyclerView.o)localObject).getChildCount();
    i = 0;
    while (i < i5)
    {
      View localView = ((RecyclerView.o)localObject).getChildAt(i);
      if ((localView != itemView) && (localView.getBottom() >= n) && (localView.getTop() <= i2) && (localView.getRight() >= m) && (localView.getLeft() <= i1))
      {
        RecyclerView.b0 localB0 = mRecyclerView.getChildViewHolder(localView);
        if (mCallback.canDropOver(mRecyclerView, mSelected, localB0))
        {
          j = Math.abs(i3 - (localView.getLeft() + localView.getRight()) / 2);
          int k = Math.abs(i4 - (localView.getTop() + localView.getBottom()) / 2);
          int i6 = j * j + k * k;
          int i7 = mSwapTargets.size();
          j = 0;
          k = 0;
          while ((j < i7) && (i6 > ((Integer)mDistances.get(j)).intValue()))
          {
            k += 1;
            j += 1;
          }
          mSwapTargets.add(k, localB0);
          mDistances.add(k, Integer.valueOf(i6));
        }
      }
      i += 1;
    }
    return mSwapTargets;
  }
  
  private RecyclerView.b0 findSwipedView(MotionEvent paramMotionEvent)
  {
    RecyclerView.o localO = mRecyclerView.getLayoutManager();
    int i = mActivePointerId;
    if (i == -1) {
      return null;
    }
    i = paramMotionEvent.findPointerIndex(i);
    float f3 = paramMotionEvent.getX(i);
    float f4 = mInitialTouchX;
    float f1 = paramMotionEvent.getY(i);
    float f2 = mInitialTouchY;
    f3 = Math.abs(f3 - f4);
    f1 = Math.abs(f1 - f2);
    i = mSlop;
    if ((f3 < i) && (f1 < i)) {
      return null;
    }
    if ((f3 > f1) && (localO.canScrollHorizontally())) {
      return null;
    }
    if ((f1 > f3) && (localO.canScrollVertically())) {
      return null;
    }
    paramMotionEvent = findChildView(paramMotionEvent);
    if (paramMotionEvent == null) {
      return null;
    }
    return mRecyclerView.getChildViewHolder(paramMotionEvent);
  }
  
  private void getSelectedDxDy(float[] paramArrayOfFloat)
  {
    if ((mSelectedFlags & 0xC) != 0) {
      paramArrayOfFloat[0] = (mSelectedStartX + mDx - mSelected.itemView.getLeft());
    } else {
      paramArrayOfFloat[0] = mSelected.itemView.getTranslationX();
    }
    if ((mSelectedFlags & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (mSelectedStartY + mDy - mSelected.itemView.getTop());
      return;
    }
    paramArrayOfFloat[1] = mSelected.itemView.getTranslationY();
  }
  
  private static boolean hitTest(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramFloat3 + paramView.getWidth()) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramFloat4 + paramView.getHeight());
  }
  
  private void initGestureDetector()
  {
    mListener = new ItemTouchHelperGestureListener();
    mGestureDetector = new GestureDetectorCompat(mRecyclerView.getContext(), mListener);
  }
  
  private void releaseVelocityTracker()
  {
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      mVelocityTracker = null;
    }
  }
  
  private void select()
  {
    ItemTouchHelperGestureListener localItemTouchHelperGestureListener = mListener;
    if (localItemTouchHelperGestureListener != null)
    {
      localItemTouchHelperGestureListener.onLongPress();
      mListener = null;
    }
    if (mGestureDetector != null) {
      mGestureDetector = null;
    }
  }
  
  private void setupCallbacks()
  {
    mSlop = ViewConfiguration.get(mRecyclerView.getContext()).getScaledTouchSlop();
    mRecyclerView.addItemDecoration(this);
    mRecyclerView.addOnItemTouchListener(mOnItemTouchListener);
    mRecyclerView.addOnChildAttachStateChangeListener(this);
    initGestureDetector();
  }
  
  private int swipeIfNecessary(RecyclerView.b0 paramB0)
  {
    if (mActionState == 2) {
      return 0;
    }
    int j = mCallback.getMovementFlags(mRecyclerView, paramB0);
    int i = (mCallback.convertToAbsoluteDirection(j, ViewCompat.getLayoutDirection(mRecyclerView)) & 0xFF00) >> 8;
    if (i == 0) {
      return 0;
    }
    j = (j & 0xFF00) >> 8;
    int k;
    if (Math.abs(mDx) > Math.abs(mDy))
    {
      k = checkHorizontalSwipe(paramB0, i);
      if (k > 0)
      {
        if ((j & k) == 0) {
          return Callback.convertToRelativeDirection(k, ViewCompat.getLayoutDirection(mRecyclerView));
        }
        return k;
      }
      i = checkVerticalSwipe(paramB0, i);
      if (i > 0) {
        return i;
      }
    }
    else
    {
      k = checkVerticalSwipe(paramB0, i);
      if (k > 0) {
        return k;
      }
      i = checkHorizontalSwipe(paramB0, i);
      if (i > 0)
      {
        if ((j & i) != 0) {
          return i;
        }
        return Callback.convertToRelativeDirection(i, ViewCompat.getLayoutDirection(mRecyclerView));
      }
    }
    return 0;
    return i;
  }
  
  public void attachToRecyclerView(RecyclerView paramRecyclerView)
  {
    RecyclerView localRecyclerView = mRecyclerView;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      destroyCallbacks();
    }
    mRecyclerView = paramRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getResources();
      mSwipeEscapeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
      mMaxSwipeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
      setupCallbacks();
    }
  }
  
  public void bindView(View paramView) {}
  
  void checkSelectForSwipe(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if ((mSelected == null) && (paramInt1 == 2) && (mActionState != 2))
    {
      if (!mCallback.isItemViewSwipeEnabled()) {
        return;
      }
      if (mRecyclerView.getScrollState() == 1) {
        return;
      }
      RecyclerView.b0 localB0 = findSwipedView(paramMotionEvent);
      if (localB0 == null) {
        return;
      }
      paramInt1 = (mCallback.getAbsoluteMovementFlags(mRecyclerView, localB0) & 0xFF00) >> 8;
      if (paramInt1 == 0) {
        return;
      }
      float f1 = paramMotionEvent.getX(paramInt2);
      float f2 = paramMotionEvent.getY(paramInt2);
      f1 -= mInitialTouchX;
      f2 -= mInitialTouchY;
      float f3 = Math.abs(f1);
      float f4 = Math.abs(f2);
      paramInt2 = mSlop;
      if ((f3 < paramInt2) && (f4 < paramInt2)) {
        return;
      }
      if (f3 > f4)
      {
        if ((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) {
          return;
        }
        if ((f1 <= 0.0F) || ((paramInt1 & 0x8) != 0)) {}
      }
      else
      {
        if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
          return;
        }
        if ((f2 > 0.0F) && ((paramInt1 & 0x2) == 0)) {
          return;
        }
      }
      mDy = 0.0F;
      mDx = 0.0F;
      mActivePointerId = paramMotionEvent.getPointerId(0);
      select(localB0, 1);
    }
  }
  
  void endRecoverAnimation(RecyclerView.b0 paramB0, boolean paramBoolean)
  {
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)mRecoverAnimations.get(i);
      if (mViewHolder == paramB0)
      {
        mOverridden |= paramBoolean;
        if (!mEnded) {
          localRecoverAnimation.cancel();
        }
        mRecoverAnimations.remove(i);
        return;
      }
      i -= 1;
    }
  }
  
  RecoverAnimation findAnimation(MotionEvent paramMotionEvent)
  {
    if (mRecoverAnimations.isEmpty()) {
      return null;
    }
    paramMotionEvent = findChildView(paramMotionEvent);
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)mRecoverAnimations.get(i);
      if (mViewHolder.itemView == paramMotionEvent) {
        return localRecoverAnimation;
      }
      i -= 1;
    }
    return null;
  }
  
  View findChildView(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent = mSelected;
    if (paramMotionEvent != null)
    {
      paramMotionEvent = itemView;
      if (hitTest(paramMotionEvent, f1, f2, mSelectedStartX + mDx, mSelectedStartY + mDy)) {
        return paramMotionEvent;
      }
    }
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (RecoverAnimation)mRecoverAnimations.get(i);
      View localView = mViewHolder.itemView;
      if (hitTest(localView, f1, f2, mX, mY)) {
        return localView;
      }
      i -= 1;
    }
    return mRecyclerView.findChildViewUnder(f1, f2);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.y paramY)
  {
    paramRect.setEmpty();
  }
  
  boolean hasRunningRecoverAnim()
  {
    int j = mRecoverAnimations.size();
    int i = 0;
    while (i < j)
    {
      if (!mRecoverAnimations.get(i)).mEnded) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  void moveIfNecessary(RecyclerView.b0 paramB0)
  {
    if (mRecyclerView.isLayoutRequested()) {
      return;
    }
    if (mActionState != 2) {
      return;
    }
    float f = mCallback.getMoveThreshold(paramB0);
    int i = (int)(mSelectedStartX + mDx);
    int j = (int)(mSelectedStartY + mDy);
    if ((Math.abs(j - itemView.getTop()) < itemView.getHeight() * f) && (Math.abs(i - itemView.getLeft()) < itemView.getWidth() * f)) {
      return;
    }
    Object localObject = findSwapTargets(paramB0);
    if (((List)localObject).size() == 0) {
      return;
    }
    localObject = mCallback.chooseDropTarget(paramB0, (List)localObject, i, j);
    if (localObject == null)
    {
      mSwapTargets.clear();
      mDistances.clear();
      return;
    }
    int k = ((RecyclerView.b0)localObject).getAbsoluteAdapterPosition();
    int m = paramB0.getAbsoluteAdapterPosition();
    if (mCallback.onMove(mRecyclerView, paramB0, (RecyclerView.b0)localObject)) {
      mCallback.onMoved(mRecyclerView, paramB0, m, (RecyclerView.b0)localObject, k, i, j);
    }
  }
  
  void obtainVelocityTracker()
  {
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    mVelocityTracker = VelocityTracker.obtain();
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    removeChildDrawingOrderCallbackIfNecessary(paramView);
    paramView = mRecyclerView.getChildViewHolder(paramView);
    if (paramView == null) {
      return;
    }
    RecyclerView.b0 localB0 = mSelected;
    if ((localB0 != null) && (paramView == localB0))
    {
      select(null, 0);
      return;
    }
    endRecoverAnimation(paramView, false);
    if (mPendingCleanup.remove(itemView)) {
      mCallback.clearView(mRecyclerView, paramView);
    }
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.y paramY)
  {
    mOverdrawChildPosition = -1;
    float f1;
    float f2;
    if (mSelected != null)
    {
      getSelectedDxDy(mTmpPosition);
      paramY = mTmpPosition;
      f1 = paramY[1];
      f2 = paramY[0];
    }
    else
    {
      f2 = 0.0F;
      f1 = 0.0F;
    }
    mCallback.onDraw(paramCanvas, paramRecyclerView, mSelected, mRecoverAnimations, mActionState, f2, f1);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.y paramY)
  {
    float f1;
    float f2;
    if (mSelected != null)
    {
      getSelectedDxDy(mTmpPosition);
      paramY = mTmpPosition;
      f1 = paramY[1];
      f2 = paramY[0];
    }
    else
    {
      f2 = 0.0F;
      f1 = 0.0F;
    }
    mCallback.onDrawOver(paramCanvas, paramRecyclerView, mSelected, mRecoverAnimations, mActionState, f2, f1);
  }
  
  void postDispatchSwipe(RecoverAnimation paramRecoverAnimation, int paramInt)
  {
    mRecyclerView.post(new ItemTouchHelper.4(this, paramRecoverAnimation, paramInt));
  }
  
  void removeChildDrawingOrderCallbackIfNecessary(View paramView)
  {
    if (paramView == mOverdrawChild)
    {
      mOverdrawChild = null;
      if (mChildDrawingOrderCallback != null) {
        mRecyclerView.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  boolean scrollIfNecessary()
  {
    if (mSelected == null)
    {
      mDragScrollStartTimeInMs = Long.MIN_VALUE;
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l1 = mDragScrollStartTimeInMs;
    if (l1 == Long.MIN_VALUE) {
      l1 = 0L;
    } else {
      l1 = l2 - l1;
    }
    RecyclerView.o localO = mRecyclerView.getLayoutManager();
    if (mTmpRect == null) {
      mTmpRect = new Rect();
    }
    localO.calculateItemDecorationsForChild(mSelected.itemView, mTmpRect);
    float f;
    if (localO.canScrollHorizontally())
    {
      j = (int)(mSelectedStartX + mDx);
      i = j - mTmpRect.left - mRecyclerView.getPaddingLeft();
      f = mDx;
      if ((f < 0.0F) && (i < 0)) {
        break label199;
      }
      if (f > 0.0F)
      {
        i = j + mSelected.itemView.getWidth() + mTmpRect.right - (mRecyclerView.getWidth() - mRecyclerView.getPaddingRight());
        if (i > 0) {
          break label199;
        }
      }
    }
    int i = 0;
    label199:
    if (localO.canScrollVertically())
    {
      k = (int)(mSelectedStartY + mDy);
      j = k - mTmpRect.top - mRecyclerView.getPaddingTop();
      f = mDy;
      if ((f < 0.0F) && (j < 0)) {
        break label309;
      }
      if (f > 0.0F)
      {
        j = k + mSelected.itemView.getHeight() + mTmpRect.bottom - (mRecyclerView.getHeight() - mRecyclerView.getPaddingBottom());
        if (j > 0) {
          break label309;
        }
      }
    }
    int j = 0;
    label309:
    int k = i;
    if (i != 0) {
      k = mCallback.interpolateOutOfBoundsScroll(mRecyclerView, mSelected.itemView.getWidth(), i, mRecyclerView.getWidth(), l1);
    }
    i = j;
    if (j != 0) {
      i = mCallback.interpolateOutOfBoundsScroll(mRecyclerView, mSelected.itemView.getHeight(), j, mRecyclerView.getHeight(), l1);
    }
    if ((k == 0) && (i == 0))
    {
      mDragScrollStartTimeInMs = Long.MIN_VALUE;
      return false;
    }
    if (mDragScrollStartTimeInMs == Long.MIN_VALUE) {
      mDragScrollStartTimeInMs = l2;
    }
    mRecyclerView.scrollBy(k, i);
    return true;
  }
  
  void select(RecyclerView.b0 paramB0, int paramInt)
  {
    if ((paramB0 == mSelected) && (paramInt == mActionState)) {
      return;
    }
    mDragScrollStartTimeInMs = Long.MIN_VALUE;
    int k = mActionState;
    endRecoverAnimation(paramB0, true);
    mActionState = paramInt;
    if (paramInt == 2) {
      if (paramB0 != null)
      {
        mOverdrawChild = itemView;
        addChildDrawingOrderCallback();
      }
      else
      {
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
      }
    }
    Object localObject = mSelected;
    int i;
    if (localObject != null)
    {
      if (itemView.getParent() != null)
      {
        int j;
        if (k == 2) {
          j = 0;
        } else {
          j = swipeIfNecessary((RecyclerView.b0)localObject);
        }
        releaseVelocityTracker();
        float f1;
        float f2;
        if ((j != 1) && (j != 2))
        {
          if ((j != 4) && (j != 8) && (j != 16) && (j != 32))
          {
            f1 = 0.0F;
            f2 = 0.0F;
          }
          else
          {
            f1 = Math.signum(mDx);
            f3 = mRecyclerView.getWidth();
            f2 = 0.0F;
            f1 *= f3;
          }
        }
        else
        {
          f2 = Math.signum(mDy);
          f3 = mRecyclerView.getHeight();
          f1 = 0.0F;
          f2 *= f3;
        }
        if (k == 2) {
          i = 8;
        } else if (j > 0) {
          i = 2;
        } else {
          i = 4;
        }
        getSelectedDxDy(mTmpPosition);
        float[] arrayOfFloat = mTmpPosition;
        float f3 = arrayOfFloat[0];
        float f4 = arrayOfFloat[1];
        localObject = new ItemTouchHelper.3(this, (RecyclerView.b0)localObject, i, k, f3, f4, f1, f2, j, (RecyclerView.b0)localObject);
        ((RecoverAnimation)localObject).setDuration(mCallback.getAnimationDuration(mRecyclerView, i, f1 - f3, f2 - f4));
        mRecoverAnimations.add(localObject);
        ((RecoverAnimation)localObject).start();
        i = 1;
      }
      else
      {
        removeChildDrawingOrderCallbackIfNecessary(itemView);
        mCallback.clearView(mRecyclerView, (RecyclerView.b0)localObject);
        i = 0;
      }
      mSelected = null;
    }
    else
    {
      i = 0;
    }
    if (paramB0 != null)
    {
      mSelectedFlags = ((mCallback.getAbsoluteMovementFlags(mRecyclerView, paramB0) & (1 << paramInt * 8 + 8) - 1) >> mActionState * 8);
      mSelectedStartX = itemView.getLeft();
      mSelectedStartY = itemView.getTop();
      mSelected = paramB0;
      if (paramInt == 2) {
        itemView.performHapticFeedback(0);
      }
    }
    paramB0 = mRecyclerView.getParent();
    if (paramB0 != null)
    {
      boolean bool;
      if (mSelected != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramB0.requestDisallowInterceptTouchEvent(bool);
    }
    if (i == 0) {
      mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
    }
    mCallback.onSelectedChanged(mSelected, mActionState);
    mRecyclerView.invalidate();
  }
  
  void updateDxDy(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f2 = paramMotionEvent.getX(paramInt2);
    float f1 = paramMotionEvent.getY(paramInt2);
    f2 -= mInitialTouchX;
    mDx = f2;
    mDy = (f1 - mInitialTouchY);
    if ((paramInt1 & 0x4) == 0) {
      mDx = Math.max(0.0F, f2);
    }
    if ((paramInt1 & 0x8) == 0) {
      mDx = Math.min(0.0F, mDx);
    }
    if ((paramInt1 & 0x1) == 0) {
      mDy = Math.max(0.0F, mDy);
    }
    if ((paramInt1 & 0x2) == 0) {
      mDy = Math.min(0.0F, mDy);
    }
  }
  
  public abstract class Callback
  {
    private static final Interpolator sDragScrollInterpolator = new k.f.a();
    private static final Interpolator sDragViewScrollCapInterpolator = new k.f.b();
    private int mCachedMaxScrollSpeed = -1;
    
    public Callback() {}
    
    public static int convertToRelativeDirection(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0xC0C0C;
      if (i == 0) {
        return paramInt1;
      }
      paramInt1 &= i;
      if (paramInt2 == 0) {}
      for (paramInt2 = i << 2;; paramInt2 = (paramInt2 & 0xC0C0C) << 2)
      {
        return paramInt1 | paramInt2;
        paramInt2 = i << 1;
        paramInt1 |= 0xFFF3F3F3 & paramInt2;
      }
    }
    
    private int getMaxDragScroll(RecyclerView paramRecyclerView)
    {
      if (mCachedMaxScrollSpeed == -1) {
        mCachedMaxScrollSpeed = paramRecyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
      }
      return mCachedMaxScrollSpeed;
    }
    
    public static int makeFlag(int paramInt1, int paramInt2)
    {
      return paramInt2 << paramInt1 * 8;
    }
    
    public static int makeMovementFlags(int paramInt1, int paramInt2)
    {
      int i = makeFlag(0, paramInt2 | paramInt1);
      paramInt2 = makeFlag(1, paramInt2);
      return makeFlag(2, paramInt1) | paramInt2 | i;
    }
    
    public boolean canDropOver(RecyclerView paramRecyclerView, RecyclerView.b0 paramB01, RecyclerView.b0 paramB02)
    {
      return true;
    }
    
    public RecyclerView.b0 chooseDropTarget(RecyclerView.b0 paramB0, List paramList, int paramInt1, int paramInt2)
    {
      int n = itemView.getWidth();
      int i1 = itemView.getHeight();
      int i2 = paramInt1 - itemView.getLeft();
      Object localObject1 = itemView;
      int i3 = paramInt2 - ((View)localObject1).getTop();
      int i4 = paramList.size();
      Object localObject4 = null;
      int j = -1;
      int k = 0;
      Object localObject2 = paramB0;
      while (k < i4)
      {
        paramB0 = (RecyclerView.b0)paramList.get(k);
        Object localObject3 = localObject4;
        int i = j;
        localObject1 = localObject2;
        int m;
        int i5;
        View localView;
        if (i2 > 0)
        {
          m = itemView.getRight() - (paramInt1 + n);
          localObject3 = localObject4;
          i = j;
          localObject1 = localObject2;
          if (m < 0)
          {
            i5 = itemView.getRight();
            localView = itemView;
            localObject3 = localObject4;
            i = j;
            localObject1 = localObject2;
            if (i5 > localView.getRight())
            {
              m = Math.abs(m);
              localObject3 = localObject4;
              i = j;
              localObject1 = localObject2;
              if (m > j)
              {
                localObject3 = paramB0;
                i = m;
                localObject1 = localObject2;
              }
            }
          }
        }
        localObject4 = localObject3;
        j = i;
        localObject2 = localObject1;
        if (i2 < 0)
        {
          m = itemView.getLeft() - paramInt1;
          localObject4 = localObject3;
          j = i;
          localObject2 = localObject1;
          if (m > 0)
          {
            i5 = itemView.getLeft();
            localView = itemView;
            localObject4 = localObject3;
            j = i;
            localObject2 = localObject1;
            if (i5 < localView.getLeft())
            {
              m = Math.abs(m);
              localObject4 = localObject3;
              j = i;
              localObject2 = localObject1;
              if (m > i)
              {
                localObject4 = paramB0;
                j = m;
                localObject2 = localObject1;
              }
            }
          }
        }
        localObject3 = localObject4;
        i = j;
        localObject1 = localObject2;
        if (i3 < 0)
        {
          m = itemView.getTop() - paramInt2;
          localObject3 = localObject4;
          i = j;
          localObject1 = localObject2;
          if (m > 0)
          {
            i5 = itemView.getTop();
            localView = itemView;
            localObject3 = localObject4;
            i = j;
            localObject1 = localObject2;
            if (i5 < localView.getTop())
            {
              m = Math.abs(m);
              localObject3 = localObject4;
              i = j;
              localObject1 = localObject2;
              if (m > j)
              {
                localObject3 = paramB0;
                i = m;
                localObject1 = localObject2;
              }
            }
          }
        }
        localObject4 = localObject3;
        j = i;
        localObject2 = localObject1;
        if (i3 > 0)
        {
          m = itemView.getBottom() - (paramInt2 + i1);
          localObject4 = localObject3;
          j = i;
          localObject2 = localObject1;
          if (m < 0)
          {
            i5 = itemView.getBottom();
            localView = itemView;
            localObject4 = localObject3;
            j = i;
            localObject2 = localObject1;
            if (i5 > localView.getBottom())
            {
              m = Math.abs(m);
              localObject4 = localObject3;
              j = i;
              localObject2 = localObject1;
              if (m > i)
              {
                j = m;
                localObject2 = localObject1;
                localObject4 = paramB0;
              }
            }
          }
        }
        k += 1;
      }
      return localObject4;
    }
    
    public void clearView(RecyclerView paramRecyclerView, RecyclerView.b0 paramB0)
    {
      ItemTouchUIUtilImpl.Gingerbread.sUICallback.clearView(itemView);
    }
    
    public int convertToAbsoluteDirection(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0x303030;
      if (i == 0) {
        return paramInt1;
      }
      paramInt1 &= i;
      if (paramInt2 == 0) {}
      for (paramInt2 = i >> 2;; paramInt2 = (paramInt2 & 0x303030) >> 2)
      {
        return paramInt1 | paramInt2;
        paramInt2 = i >> 1;
        paramInt1 |= 0xFFCFCFCF & paramInt2;
      }
    }
    
    final int getAbsoluteMovementFlags(RecyclerView paramRecyclerView, RecyclerView.b0 paramB0)
    {
      return convertToAbsoluteDirection(getMovementFlags(paramRecyclerView, paramB0), ViewCompat.getLayoutDirection(paramRecyclerView));
    }
    
    public long getAnimationDuration(RecyclerView paramRecyclerView, int paramInt, float paramFloat1, float paramFloat2)
    {
      paramRecyclerView = paramRecyclerView.getItemAnimator();
      if (paramRecyclerView == null)
      {
        if (paramInt == 8) {
          return 200L;
        }
        return 250L;
      }
      if (paramInt == 8) {
        return paramRecyclerView.getMoveDuration();
      }
      return paramRecyclerView.getRemoveDuration();
    }
    
    public int getBoundingBoxMargin()
    {
      return 0;
    }
    
    public float getMoveThreshold(RecyclerView.b0 paramB0)
    {
      return 0.5F;
    }
    
    public abstract int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.b0 paramB0);
    
    public float getSwipeEscapeVelocity(float paramFloat)
    {
      return paramFloat;
    }
    
    public float getSwipeThreshold(RecyclerView.b0 paramB0)
    {
      return 0.5F;
    }
    
    public float getSwipeVelocityThreshold(float paramFloat)
    {
      return paramFloat;
    }
    
    boolean hasDragFlag(RecyclerView paramRecyclerView, RecyclerView.b0 paramB0)
    {
      return (getAbsoluteMovementFlags(paramRecyclerView, paramB0) & 0xFF0000) != 0;
    }
    
    public int interpolateOutOfBoundsScroll(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      paramInt3 = getMaxDragScroll(paramRecyclerView);
      int i = Math.abs(paramInt2);
      int j = (int)Math.signum(paramInt2);
      float f2 = i;
      float f1 = 1.0F;
      f2 = Math.min(1.0F, f2 * 1.0F / paramInt1);
      paramInt1 = (int)(j * paramInt3 * sDragViewScrollCapInterpolator.getInterpolation(f2));
      if (paramLong <= 2000L) {
        f1 = (float)paramLong / 2000.0F;
      }
      paramInt1 = (int)(paramInt1 * sDragScrollInterpolator.getInterpolation(f1));
      if (paramInt1 == 0)
      {
        if (paramInt2 > 0) {
          return 1;
        }
        return -1;
      }
      return paramInt1;
    }
    
    public boolean isItemViewSwipeEnabled()
    {
      return true;
    }
    
    public abstract boolean isLongPressDragEnabled();
    
    public void onChildDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.b0 paramB0, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      ItemTouchUIUtilImpl.Gingerbread.sUICallback.onDraw(paramCanvas, paramRecyclerView, itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
    
    public void onChildDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.b0 paramB0, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      ItemTouchUIUtilImpl.Gingerbread.sUICallback.onDrawOver(paramCanvas, paramRecyclerView, itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
    
    void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.b0 paramB0, List paramList, int paramInt, float paramFloat1, float paramFloat2)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
        localRecoverAnimation.update();
        int k = paramCanvas.save();
        onChildDraw(paramCanvas, paramRecyclerView, mViewHolder, mX, mY, mActionState, false);
        paramCanvas.restoreToCount(k);
        i += 1;
      }
      if (paramB0 != null)
      {
        i = paramCanvas.save();
        onChildDraw(paramCanvas, paramRecyclerView, paramB0, paramFloat1, paramFloat2, paramInt, true);
        paramCanvas.restoreToCount(i);
      }
    }
    
    void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.b0 paramB0, List paramList, int paramInt, float paramFloat1, float paramFloat2)
    {
      int k = paramList.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
        int m = paramCanvas.save();
        onChildDrawOver(paramCanvas, paramRecyclerView, mViewHolder, mX, mY, mActionState, false);
        paramCanvas.restoreToCount(m);
        i += 1;
      }
      if (paramB0 != null)
      {
        i = paramCanvas.save();
        onChildDrawOver(paramCanvas, paramRecyclerView, paramB0, paramFloat1, paramFloat2, paramInt, true);
        paramCanvas.restoreToCount(i);
      }
      paramInt = k - 1;
      i = j;
      while (paramInt >= 0)
      {
        paramCanvas = (ItemTouchHelper.RecoverAnimation)paramList.get(paramInt);
        boolean bool = mEnded;
        if ((bool) && (!mIsPendingCleanup)) {
          paramList.remove(paramInt);
        } else if (!bool) {
          i = 1;
        }
        paramInt -= 1;
      }
      if (i != 0) {
        paramRecyclerView.invalidate();
      }
    }
    
    public abstract boolean onMove(RecyclerView paramRecyclerView, RecyclerView.b0 paramB01, RecyclerView.b0 paramB02);
    
    public void onMoved(RecyclerView paramRecyclerView, RecyclerView.b0 paramB01, int paramInt1, RecyclerView.b0 paramB02, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.o localO = paramRecyclerView.getLayoutManager();
      if ((localO instanceof ItemTouchHelper.ViewDropHandler))
      {
        ((ItemTouchHelper.ViewDropHandler)localO).prepareForDrop(itemView, itemView, paramInt3, paramInt4);
        return;
      }
      if (localO.canScrollHorizontally())
      {
        if (localO.getDecoratedLeft(itemView) <= paramRecyclerView.getPaddingLeft()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
        if (localO.getDecoratedRight(itemView) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
      }
      if (localO.canScrollVertically())
      {
        if (localO.getDecoratedTop(itemView) <= paramRecyclerView.getPaddingTop()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
        if (localO.getDecoratedBottom(itemView) >= paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
      }
    }
    
    public void onSelectedChanged(RecyclerView.b0 paramB0, int paramInt)
    {
      if (paramB0 != null) {
        ItemTouchUIUtilImpl.Gingerbread.sUICallback.onSelected(itemView);
      }
    }
    
    public abstract void onSwiped(RecyclerView.b0 paramB0, int paramInt);
  }
  
  class ItemTouchHelperGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    private boolean p = true;
    
    ItemTouchHelperGestureListener() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    void onLongPress()
    {
      p = false;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      if (!p) {
        return;
      }
      Object localObject = findChildView(paramMotionEvent);
      if (localObject != null)
      {
        localObject = mRecyclerView.getChildViewHolder((View)localObject);
        if (localObject != null)
        {
          ItemTouchHelper localItemTouchHelper = ItemTouchHelper.this;
          if (!mCallback.hasDragFlag(mRecyclerView, (RecyclerView.b0)localObject)) {
            return;
          }
          int i = paramMotionEvent.getPointerId(0);
          int j = mActivePointerId;
          if (i == j)
          {
            i = paramMotionEvent.findPointerIndex(j);
            float f1 = paramMotionEvent.getX(i);
            float f2 = paramMotionEvent.getY(i);
            paramMotionEvent = ItemTouchHelper.this;
            mInitialTouchX = f1;
            mInitialTouchY = f2;
            mDy = 0.0F;
            mDx = 0.0F;
            if (mCallback.isLongPressDragEnabled()) {
              select((RecyclerView.b0)localObject, 2);
            }
          }
        }
      }
    }
  }
  
  class RecoverAnimation
    implements Animator.AnimatorListener
  {
    final int mActionState;
    final int mAnimationType;
    boolean mEnded = false;
    private float mFraction;
    boolean mIsPendingCleanup;
    boolean mOverridden = false;
    final float mStartDx;
    final float mStartDy;
    final float mTargetX;
    final float mTargetY;
    final ValueAnimator mValueAnimator;
    float mX;
    float mY;
    
    RecoverAnimation(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      mActionState = paramInt2;
      mAnimationType = paramInt1;
      mTargetY = paramFloat1;
      mStartDx = paramFloat2;
      mStartDy = paramFloat3;
      mTargetX = paramFloat4;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      mValueAnimator = localValueAnimator;
      localValueAnimator.addUpdateListener(new k.h.a(this));
      localValueAnimator.setTarget(itemView);
      localValueAnimator.addListener(this);
      setFraction(0.0F);
    }
    
    public void cancel()
    {
      mValueAnimator.cancel();
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      setFraction(1.0F);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!mEnded) {
        setIsRecyclable(true);
      }
      mEnded = true;
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
    
    public void setDuration(long paramLong)
    {
      mValueAnimator.setDuration(paramLong);
    }
    
    public void setFraction(float paramFloat)
    {
      mFraction = paramFloat;
    }
    
    public void start()
    {
      setIsRecyclable(false);
      mValueAnimator.start();
    }
    
    public void update()
    {
      float f1 = mTargetY;
      float f2 = mStartDy;
      if (f1 == f2) {
        mX = itemView.getTranslationX();
      } else {
        mX = (f1 + mFraction * (f2 - f1));
      }
      f1 = mStartDx;
      f2 = mTargetX;
      if (f1 == f2)
      {
        mY = itemView.getTranslationY();
        return;
      }
      mY = (f1 + mFraction * (f2 - f1));
    }
  }
  
  public abstract interface ViewDropHandler
  {
    public abstract void prepareForDrop(View paramView1, View paramView2, int paramInt1, int paramInt2);
  }
}
