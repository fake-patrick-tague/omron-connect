package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import v7.v7.package_13.ViewCompat;

public class ViewPager
  extends ViewGroup
{
  private static final Comparator<d> COMPARATOR = new a();
  static final int[] LAYOUT_ATTRS = { 16842931 };
  private static final Interpolator sInterpolator = new b();
  private static final i sPositionComparator = new i();
  private int 0;
  private int mActivePointerId;
  PagerAdapter mAdapter;
  private int mBottomPageBounds;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private final Runnable mEndScrollRunnable;
  private int mExpectedAdapterCount;
  private boolean mFakeDragging;
  private boolean mFirstLayout;
  private float mFirstOffset;
  private List<e> mGroups;
  private int mGutterSize;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private f mInternalPageChangeListener;
  private boolean mIsBeingDragged;
  private boolean mIsScrollStarted;
  private boolean mIsUnableToDrag;
  private final ArrayList<d> mItems;
  private float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset;
  private EdgeEffect mLeftEdge;
  private Drawable mMarginDrawable;
  private h mObserver;
  private int mOffscreenPageLimit;
  private f mOnPageChangeListener;
  private List<f> mOnPageChangeListeners;
  private int mPageMargin;
  private g mPageTransformer;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState;
  private ClassLoader mRestoredClassLoader;
  private int mRestoredCurItem;
  private EdgeEffect mRightEdge;
  private int mScrollState;
  private Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private final Rect mTempRect;
  private int mTopPageBounds;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private final d offset;
  
  private static boolean add(View paramView)
  {
    return paramView.getClass().getAnnotation(c.class) != null;
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    if (mScrollState == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      setScrollingCacheEnabled(false);
      if ((mScroller.isFinished() ^ true))
      {
        mScroller.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = mScroller.getCurrX();
        int n = mScroller.getCurrY();
        if ((j != m) || (k != n))
        {
          scrollTo(m, n);
          if (m != j) {
            pageScrolled(m);
          }
        }
      }
    }
    mPopulatePending = false;
    int k = 0;
    int j = i;
    int i = k;
    while (i < mItems.size())
    {
      d localD = (d)mItems.get(i);
      if (scrolling)
      {
        scrolling = false;
        j = 1;
      }
      i += 1;
    }
    if (j != 0)
    {
      if (paramBoolean)
      {
        ViewCompat.postOnAnimation(this, mEndScrollRunnable);
        return;
      }
      mEndScrollRunnable.run();
    }
  }
  
  private void dispatchOnPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = mOnPageChangeListener;
    if (localObject != null) {
      ((f)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    localObject = mOnPageChangeListeners;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (f)mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((f)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
        i += 1;
      }
    }
    localObject = mInternalPageChangeListener;
    if (localObject != null) {
      ((f)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void dispatchOnPageSelected(int paramInt)
  {
    Object localObject = mOnPageChangeListener;
    if (localObject != null) {
      ((f)localObject).onPageSelected(paramInt);
    }
    localObject = mOnPageChangeListeners;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (f)mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((f)localObject).onPageSelected(paramInt);
        }
        i += 1;
      }
    }
    localObject = mInternalPageChangeListener;
    if (localObject != null) {
      ((f)localObject).onPageSelected(paramInt);
    }
  }
  
  private void dispatchOnScrollStateChanged(int paramInt)
  {
    Object localObject = mOnPageChangeListener;
    if (localObject != null) {
      ((f)localObject).onPageScrollStateChanged(paramInt);
    }
    localObject = mOnPageChangeListeners;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (f)mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((f)localObject).onPageScrollStateChanged(paramInt);
        }
        i += 1;
      }
    }
    localObject = mInternalPageChangeListener;
    if (localObject != null) {
      ((f)localObject).onPageScrollStateChanged(paramInt);
    }
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      int j;
      if (paramBoolean) {
        j = 0;
      } else {
        j = 0;
      }
      getChildAt(i).setLayerType(j, null);
      i += 1;
    }
  }
  
  private void endDrag()
  {
    mIsBeingDragged = false;
    mIsUnableToDrag = false;
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      mVelocityTracker = null;
    }
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null)
    {
      localRect.set(0, 0, 0, 0);
      return localRect;
    }
    left = paramView.getLeft();
    right = paramView.getRight();
    top = paramView.getTop();
    bottom = paramView.getBottom();
    for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
    {
      paramRect = (ViewGroup)paramRect;
      left += paramRect.getLeft();
      right += paramRect.getRight();
      top += paramRect.getTop();
      bottom += paramRect.getBottom();
    }
    return localRect;
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private d infoForCurrentScrollPosition()
  {
    int i = getClientWidth();
    float f3 = 0.0F;
    float f1;
    if (i > 0) {
      f1 = getScrollX() / i;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (i > 0) {
      f2 = mPageMargin / i;
    } else {
      f2 = 0.0F;
    }
    int k = -1;
    float f4 = 0.0F;
    i = 0;
    Object localObject = null;
    int j = 1;
    while (i < mItems.size())
    {
      d localD = (d)mItems.get(i);
      if (j == 0)
      {
        int m = position;
        k += 1;
        if (m != k)
        {
          localObject = offset;
          offset = (f3 + f4 + f2);
          position = k;
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
      }
      f3 = offset;
      f4 = widthFactor;
      if ((j == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (i == mItems.size() - 1) {
          return localD;
        }
        k = position;
        f4 = widthFactor;
        i += 1;
        j = 0;
        localObject = localD;
      }
      else
      {
        return localD;
      }
    }
    return localObject;
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - mGutterSize) && (paramFloat2 < 0.0F));
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
      mLastMotionX = paramMotionEvent.getX(i);
      mActivePointerId = paramMotionEvent.getPointerId(i);
      paramMotionEvent = mVelocityTracker;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  private boolean onTouchEvent()
  {
    mActivePointerId = -1;
    endDrag();
    mLeftEdge.onRelease();
    mRightEdge.onRelease();
    return (mLeftEdge.isFinished()) || (mRightEdge.isFinished());
  }
  
  private boolean pageScrolled(int paramInt)
  {
    if (mItems.size() == 0)
    {
      if (mFirstLayout) {
        return false;
      }
      mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (mCalledSuper) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    d localD = infoForCurrentScrollPosition();
    int j = getClientWidth();
    int k = mPageMargin;
    float f2 = k;
    float f1 = j;
    f2 /= f1;
    int i = position;
    f1 = (paramInt / f1 - offset) / (widthFactor + f2);
    paramInt = (int)((j + k) * f1);
    mCalledSuper = false;
    onPageScrolled(i, f1, paramInt);
    if (mCalledSuper) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  private boolean performDrag(float paramFloat)
  {
    mLastMotionX = paramFloat;
    getScrollX();
    getClientWidth();
    d localD = (d)mItems.get(0);
    Object localObject = mItems;
    localObject = (d)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    int i = position;
    i = position;
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!mItems.isEmpty()))
    {
      if (!mScroller.isFinished())
      {
        mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
      }
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      scrollTo((int)(getScrollX() / (paramInt2 - k - m + paramInt4) * (paramInt1 - i - j + paramInt3)), getScrollY());
      return;
    }
    d localD = infoForPosition(mCurItem);
    float f;
    if (localD != null) {
      f = Math.min(offset, mLastOffset);
    } else {
      f = 0.0F;
    }
    paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
    if (paramInt1 != getScrollX())
    {
      completeScroll(false);
      scrollTo(paramInt1, getScrollY());
    }
  }
  
  private void requestParentDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    d localD = infoForPosition(paramInt1);
    int i;
    if (localD != null) {
      i = (int)(getClientWidth() * Math.max(mFirstOffset, Math.min(offset, mLastOffset)));
    } else {
      i = 0;
    }
    if (paramBoolean1)
    {
      smoothScrollTo(i, 0, paramInt2);
      if (paramBoolean2) {
        dispatchOnPageSelected(paramInt1);
      }
    }
    else
    {
      if (paramBoolean2) {
        dispatchOnPageSelected(paramInt1);
      }
      completeScroll(false);
      scrollTo(i, 0);
      pageScrolled(i);
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (mScrollingCacheEnabled != paramBoolean) {
      mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrder()
  {
    if (mDrawingOrder != 0)
    {
      Object localObject = mDrawingOrderedChildren;
      if (localObject == null) {
        mDrawingOrderedChildren = new ArrayList();
      } else {
        ((ArrayList)localObject).clear();
      }
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = getChildAt(i);
        mDrawingOrderedChildren.add(localObject);
        i += 1;
      }
      Collections.sort(mDrawingOrderedChildren, sPositionComparator);
    }
  }
  
  public void addFocusables(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          d localD = infoForChild(localView);
          if ((localD != null) && (position == mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if ((k != 262144) || (j == paramArrayList.size()))
    {
      if (!isFocusable()) {
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
        return;
      }
      paramArrayList.add(this);
    }
  }
  
  public void addOnPageChangeListener(e paramE)
  {
    if (mGroups == null) {
      mGroups = new ArrayList();
    }
    mGroups.add(paramE);
  }
  
  public void addOnPageChangeListener(f paramF)
  {
    if (mOnPageChangeListeners == null) {
      mOnPageChangeListeners = new ArrayList();
    }
    mOnPageChangeListeners.add(paramF);
  }
  
  public void addTouchables(ArrayList paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        d localD = infoForChild(localView);
        if ((localD != null) && (position == mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (LayoutParams)localLayoutParams;
    boolean bool = isDecor | add(paramView);
    isDecor = bool;
    if (mInLayout)
    {
      if (!bool)
      {
        needsMeasure = true;
        addViewInLayout(paramView, paramInt, localLayoutParams);
        return;
      }
      throw new IllegalStateException("Cannot add pager decor view during layout");
    }
    super.addView(paramView, paramInt, localLayoutParams);
  }
  
  boolean arrowScroll()
  {
    if (mAdapter == null) {
      return false;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject1 = localView;
    boolean bool = false;
    if (localView == this) {}
    Object localObject2;
    int i;
    for (;;)
    {
      localObject2 = null;
      break;
      localObject2 = localObject1;
      if (localView == null) {
        break;
      }
      for (localObject2 = localView.getParent(); (localObject2 instanceof ViewGroup); localObject2 = ((ViewParent)localObject2).getParent()) {
        if (localObject2 == this)
        {
          i = 1;
          break label74;
        }
      }
      i = 0;
      label74:
      localObject2 = localObject1;
      if (i != 0) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localView.getClass().getSimpleName());
      for (localObject1 = localView.getParent(); (localObject1 instanceof ViewGroup); localObject1 = ((ViewParent)localObject1).getParent())
      {
        ((StringBuilder)localObject2).append(" => ");
        ((StringBuilder)localObject2).append(localObject1.getClass().getSimpleName());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("arrowScroll tried to find focus based on non-child current focused view ");
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      Log.e("ViewPager", ((StringBuilder)localObject1).toString());
    }
    localObject1 = FocusFinder.getInstance().findNextFocus(this, (View)localObject2, paramInt);
    int j;
    if ((localObject1 != null) && (localObject1 != localObject2)) {
      if (paramInt == 17)
      {
        i = getChildRectInPagerCoordinatesmTempRect, (View)localObject1).left;
        j = getChildRectInPagerCoordinatesmTempRect, (View)localObject2).left;
        if ((localObject2 != null) && (i >= j)) {
          bool = pageLeft();
        } else {
          bool = ((View)localObject1).requestFocus();
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt == 66)
      {
        i = getChildRectInPagerCoordinatesmTempRect, (View)localObject1).left;
        j = getChildRectInPagerCoordinatesmTempRect, (View)localObject2).left;
        if ((localObject2 != null) && (i <= j))
        {
          bool = arrowScroll();
        }
        else
        {
          bool = ((View)localObject1).requestFocus();
          continue;
          if ((paramInt != 17) && (paramInt != 1))
          {
            if ((paramInt == 66) || (paramInt == 2)) {
              bool = arrowScroll();
            }
          }
          else {
            bool = pageLeft();
          }
        }
      }
    }
    if (bool) {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    }
    return bool;
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        int m = paramInt2 + j;
        if ((m >= localView.getLeft()) && (m < localView.getRight()))
        {
          int n = paramInt3 + k;
          if ((n >= localView.getTop()) && (n < localView.getBottom()) && (canScroll(localView, true, paramInt1, m - localView.getLeft(), n - localView.getTop()))) {
            return true;
          }
        }
        i -= 1;
      }
    }
    return (paramBoolean) && (paramView.canScrollHorizontally(-paramInt1));
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (mAdapter == null) {
      return false;
    }
    int i = getClientWidth();
    int j = getScrollX();
    if (paramInt < 0)
    {
      if (j > (int)(i * mFirstOffset)) {
        return true;
      }
    }
    else if ((paramInt > 0) && (j < (int)(i * mLastOffset))) {
      return true;
    }
    return false;
  }
  
  void cancel()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    mIsScrollStarted = true;
    if ((!mScroller.isFinished()) && (mScroller.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = mScroller.getCurrX();
      int m = mScroller.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!pageScrolled(k))
        {
          mScroller.abortAnimation();
          scrollTo(0, m);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    completeScroll(true);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 4096) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        d localD = infoForChild(localView);
        if ((localD != null) && (position == mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.47123894F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int m = getOverScrollMode();
    int k = 0;
    int i = 0;
    boolean bool;
    if (m != 0)
    {
      if ((m == 1) && (mAdapter != null)) {
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
      mLeftEdge.finish();
      mRightEdge.finish();
    }
    else
    {
      int j;
      if (!mLeftEdge.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), mFirstOffset * m);
        mLeftEdge.setSize(i, m);
        j = false | mLeftEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!mRightEdge.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(mLastOffset + 1.0F) * k);
        mRightEdge.setSize(n - i1 - i2, k);
        bool = j | mRightEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    if (bool) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      int i = paramKeyEvent.getKeyCode();
      if (i != 21)
      {
        if (i != 22)
        {
          if (i == 61)
          {
            if (paramKeyEvent.hasNoModifiers()) {
              return arrowScroll(2);
            }
            if (paramKeyEvent.hasModifiers(1)) {
              return arrowScroll(1);
            }
          }
        }
        else
        {
          if (paramKeyEvent.hasModifiers(2)) {
            return arrowScroll();
          }
          return arrowScroll(66);
        }
      }
      else
      {
        if (paramKeyEvent.hasModifiers(2)) {
          return pageLeft();
        }
        return arrowScroll(17);
      }
    }
    return false;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (mDrawingOrder == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return mDrawingOrderedChildren.get(i)).getLayoutParams()).childIndex;
  }
  
  public int getCurrentItem()
  {
    return mCurItem;
  }
  
  public int getOffscreenPageLimit()
  {
    return mOffscreenPageLimit;
  }
  
  public int getPageMargin()
  {
    return mPageMargin;
  }
  
  d infoForChild(View paramView)
  {
    if (mItems.size() <= 0) {
      return null;
    }
    paramView = mItems.get(0)).object;
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  d infoForPosition(int paramInt)
  {
    int i = 0;
    while (i < mItems.size())
    {
      d localD = (d)mItems.get(i);
      if (position == paramInt) {
        return localD;
      }
      i += 1;
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(mEndScrollRunnable);
    Scroller localScroller = mScroller;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      mScroller.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((mPageMargin > 0) && (mMarginDrawable != null) && (mItems.size() > 0) && (mAdapter != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f1 = m;
      Object localObject = mItems;
      int j = 0;
      localObject = (d)((ArrayList)localObject).get(0);
      float f2 = offset;
      int n = mItems.size();
      int i = position;
      int i1 = mItems.get(n - 1)).position;
      while (i < i1)
      {
        int i2;
        for (;;)
        {
          i2 = position;
          if ((i <= i2) || (j >= n)) {
            break;
          }
          localObject = mItems;
          j += 1;
          localObject = (d)((ArrayList)localObject).get(j);
        }
        if (i == i2)
        {
          f2 = (offset + widthFactor) * f1;
          if (mPageMargin + f2 > k)
          {
            mMarginDrawable.setBounds(Math.round(f2), mTopPageBounds, Math.round(mPageMargin + f2), mBottomPageBounds);
            mMarginDrawable.draw(paramCanvas);
          }
          if (f2 > k + m) {
            return;
          }
          i += 1;
        }
        else
        {
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i != 3) && (i != 1))
    {
      if (i != 0)
      {
        if (mIsBeingDragged) {
          return true;
        }
        if (mIsUnableToDrag) {
          return false;
        }
      }
      float f1;
      if (i != 0)
      {
        if (i != 2)
        {
          if (i == 6) {
            onSecondaryPointerUp(paramMotionEvent);
          }
        }
        else
        {
          i = mActivePointerId;
          if (i != -1)
          {
            i = paramMotionEvent.findPointerIndex(i);
            float f2 = paramMotionEvent.getX(i);
            f1 = f2 - mLastMotionX;
            float f4 = Math.abs(f1);
            float f3 = paramMotionEvent.getY(i);
            float f5 = Math.abs(f3 - mInitialMotionY);
            boolean bool = f1 < 0.0F;
            if ((bool) && (!isGutterDrag(mLastMotionX, f1)) && (canScroll(this, false, (int)f1, (int)f2, (int)f3)))
            {
              mLastMotionX = f2;
              mLastMotionY = f3;
              mIsUnableToDrag = true;
              return false;
            }
            int j = mTouchSlop;
            if ((f4 > j) && (f4 * 0.5F > f5))
            {
              mIsBeingDragged = true;
              requestParentDisallowInterceptTouchEvent(true);
              setScrollState(1);
              f1 = mInitialMotionX;
              f4 = mTouchSlop;
              if (bool) {
                f1 += f4;
              } else {
                f1 -= f4;
              }
              mLastMotionX = f1;
              mLastMotionY = f3;
              setScrollingCacheEnabled(true);
            }
            else if (f5 > j)
            {
              mIsUnableToDrag = true;
            }
            if ((mIsBeingDragged) && (performDrag(f2))) {
              ViewCompat.postInvalidateOnAnimation(this);
            }
          }
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        mInitialMotionX = f1;
        mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        mInitialMotionY = f1;
        mLastMotionY = f1;
        mActivePointerId = paramMotionEvent.getPointerId(0);
        mIsUnableToDrag = false;
        mIsScrollStarted = true;
        mScroller.computeScrollOffset();
        if ((mScrollState == 2) && (Math.abs(mScroller.getFinalX() - mScroller.getCurrX()) > mCloseEnough))
        {
          mScroller.abortAnimation();
          mPopulatePending = false;
          populate();
          mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
        }
        else
        {
          completeScroll(false);
          mIsBeingDragged = false;
        }
      }
      if (mVelocityTracker == null) {
        mVelocityTracker = VelocityTracker.obtain();
      }
      mVelocityTracker.addMovement(paramMotionEvent);
      return mIsBeingDragged;
    }
    onTouchEvent();
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = getChildCount();
    int i4 = paramInt3 - paramInt1;
    int i5 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i6 = getScrollX();
    int k = 0;
    int j = 0;
    View localView;
    LayoutParams localLayoutParams;
    while (k < i3)
    {
      localView = getChildAt(k);
      int i2 = paramInt2;
      i = paramInt4;
      int i1 = paramInt1;
      int n = j;
      int m = paramInt3;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i2 = paramInt2;
        i = paramInt4;
        i1 = paramInt1;
        n = j;
        m = paramInt3;
        if (isDecor)
        {
          m = gravity;
          i = m & 0x7;
          i1 = m & 0x70;
          if (i != 1)
          {
            if (i != 3)
            {
              if (i != 5)
              {
                n = paramInt2;
                m = paramInt2;
                i = paramInt4;
                paramInt2 = n;
                break label258;
              }
              i = i4 - paramInt4 - localView.getMeasuredWidth();
              paramInt4 += localView.getMeasuredWidth();
            }
            else
            {
              n = localView.getMeasuredWidth() + paramInt2;
              m = paramInt2;
              i = paramInt4;
              paramInt2 = n;
              break label258;
            }
          }
          else {
            i = Math.max((i4 - localView.getMeasuredWidth()) / 2, paramInt2);
          }
          m = i;
          i = paramInt4;
          label258:
          if (i1 != 16)
          {
            if (i1 != 48)
            {
              if (i1 != 80)
              {
                paramInt4 = paramInt1;
                n = paramInt1;
                break label352;
              }
              paramInt4 = i5 - paramInt3 - localView.getMeasuredHeight();
              paramInt3 += localView.getMeasuredHeight();
            }
            else
            {
              paramInt4 = localView.getMeasuredHeight() + paramInt1;
              n = paramInt1;
              break label352;
            }
          }
          else {
            paramInt4 = Math.max((i5 - localView.getMeasuredHeight()) / 2, paramInt1);
          }
          n = paramInt4;
          paramInt4 = paramInt1;
          label352:
          paramInt1 = m + i6;
          localView.layout(paramInt1, n, localView.getMeasuredWidth() + paramInt1, n + localView.getMeasuredHeight());
          n = j + 1;
          m = paramInt3;
          i1 = paramInt4;
          i2 = paramInt2;
        }
      }
      k += 1;
      paramInt2 = i2;
      paramInt4 = i;
      paramInt1 = i1;
      j = n;
      paramInt3 = m;
    }
    int i = 0;
    while (i < i3)
    {
      localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!isDecor)
        {
          d localD = infoForChild(localView);
          if (localD != null)
          {
            float f = i4 - paramInt2 - paramInt4;
            k = (int)(offset * f) + paramInt2;
            if (needsMeasure)
            {
              needsMeasure = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f * widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec(i5 - paramInt1 - paramInt3, 1073741824));
            }
            localView.layout(k, paramInt1, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
      i += 1;
    }
    mTopPageBounds = paramInt1;
    mBottomPageBounds = (i5 - paramInt3);
    mDecorChildCount = j;
    if (mFirstLayout) {
      scrollToItem(mCurItem, false, 0, false);
    }
    mFirstLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = 0;
    setMeasuredDimension(View.getDefaultSize(0, paramInt1), View.getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    mGutterSize = Math.min(paramInt1 / 10, mDefaultGutterSize);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i6 = getChildCount();
    int k = 0;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      int i1 = 1;
      int i3 = 1073741824;
      if (k >= i6) {
        break;
      }
      localView = getChildAt(k);
      i = paramInt1;
      int j = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localLayoutParams != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (isDecor)
          {
            j = gravity;
            i = j & 0x7;
            j &= 0x70;
            int n;
            if ((j != 48) && (j != 80)) {
              n = 0;
            } else {
              n = 1;
            }
            int m = i1;
            if (i != 3) {
              if (i == 5) {
                m = i1;
              } else {
                m = 0;
              }
            }
            j = Integer.MIN_VALUE;
            if (n != 0)
            {
              i = Integer.MIN_VALUE;
              j = 1073741824;
            }
            else if (m != 0)
            {
              i = 1073741824;
            }
            else
            {
              i = Integer.MIN_VALUE;
            }
            i1 = width;
            int i2;
            if (i1 != -2)
            {
              if (i1 != -1) {
                j = i1;
              } else {
                j = paramInt1;
              }
              i1 = 1073741824;
              i2 = j;
            }
            else
            {
              i2 = paramInt1;
              i1 = j;
            }
            int i5 = height;
            if (i5 != -2)
            {
              if (i5 != -1)
              {
                j = i3;
                i = i5;
              }
              else
              {
                i = paramInt2;
                j = i3;
              }
            }
            else
            {
              j = paramInt2;
              i3 = i;
              i = j;
              j = i3;
            }
            localView.measure(View.MeasureSpec.makeMeasureSpec(i2, i1), View.MeasureSpec.makeMeasureSpec(i, j));
            if (n != 0)
            {
              j = paramInt2 - localView.getMeasuredHeight();
              i = paramInt1;
            }
            else
            {
              i = paramInt1;
              j = paramInt2;
              if (m != 0)
              {
                i = paramInt1 - localView.getMeasuredWidth();
                j = paramInt2;
              }
            }
          }
        }
      }
      k += 1;
      paramInt1 = i;
      paramInt2 = j;
    }
    mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    mInLayout = true;
    populate();
    mInLayout = false;
    int i = getChildCount();
    paramInt2 = i4;
    while (paramInt2 < i)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams == null) || (!isDecor)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * widthFactor), 1073741824), mChildHeightMeasureSpec);
        }
      }
      paramInt2 += 1;
    }
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i = mDecorChildCount;
    int i1 = 0;
    View localView;
    if (i > 0)
    {
      int i2 = getScrollX();
      i = getPaddingLeft();
      int j = getPaddingRight();
      int i3 = getWidth();
      int i4 = getChildCount();
      int m = 0;
      while (m < i4)
      {
        localView = getChildAt(m);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (isDecor)
        {
          int k = gravity & 0x7;
          if (k != 1)
          {
            int n;
            if (k != 3)
            {
              if (k != 5)
              {
                n = i;
                k = i;
                i = n;
              }
              else
              {
                k = i3 - j - localView.getMeasuredWidth();
                j += localView.getMeasuredWidth();
              }
            }
            else
            {
              n = localView.getWidth() + i;
              k = i;
              i = n;
            }
          }
          else
          {
            k = Math.max((i3 - localView.getMeasuredWidth()) / 2, i);
          }
          k = k + i2 - localView.getLeft();
          if (k != 0) {
            localView.offsetLeftAndRight(k);
          }
        }
        m += 1;
      }
    }
    dispatchOnPageScrolled(paramInt1, paramFloat, paramInt2);
    if (mPageTransformer != null)
    {
      paramInt2 = getScrollX();
      i = getChildCount();
      paramInt1 = i1;
      while (paramInt1 < i)
      {
        localView = getChildAt(paramInt1);
        if (!getLayoutParamsisDecor)
        {
          paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
          mPageTransformer.transformPage(localView, paramFloat);
        }
        paramInt1 += 1;
      }
    }
    mCalledSuper = true;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i = getChildCount();
    int j = -1;
    int k;
    if ((paramInt & 0x2) != 0)
    {
      j = i;
      i = 0;
      k = 1;
    }
    else
    {
      i -= 1;
      k = -1;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        d localD = infoForChild(localView);
        if ((localD != null) && (position == mCurItem) && (localView.requestFocus(paramInt, paramRect))) {
          return true;
        }
      }
      i += k;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (mAdapter == null)
    {
      mRestoredCurItem = position;
      mRestoredAdapterState = adapterState;
      mRestoredClassLoader = loader;
      return;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    position = mCurItem;
    if (mAdapter == null) {
      return localSavedState;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = mPageMargin;
      recomputeScrollPosition(paramInt1, paramInt3, paramInt2, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (mFakeDragging) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if (mAdapter == null) {
      return false;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  boolean pageLeft()
  {
    int i = mCurItem;
    if (i > 0)
    {
      setCurrentItem(i - 1, true);
      return true;
    }
    return false;
  }
  
  void populate()
  {
    populate(mCurItem);
  }
  
  void populate(int paramInt)
  {
    int i = mCurItem;
    if (i != paramInt)
    {
      infoForPosition(i);
      mCurItem = paramInt;
    }
    if (mAdapter == null)
    {
      sortChildDrawingOrder();
      return;
    }
    if (mPopulatePending)
    {
      sortChildDrawingOrder();
      return;
    }
    if (getWindowToken() == null) {
      return;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void removeView(View paramView)
  {
    if (mInLayout)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    PagerAdapter localPagerAdapter = mAdapter;
    if (localPagerAdapter == null)
    {
      int i = 0;
      mExpectedAdapterCount = 0;
      if (paramPagerAdapter != null)
      {
        if (mObserver == null) {
          mObserver = new h();
        }
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
      List localList = mGroups;
      if (localList != null)
      {
        if (localList.isEmpty()) {
          return;
        }
        int j = mGroups.size();
        while (i < j)
        {
          ((e)mGroups.get(i)).setAdapter(this, localPagerAdapter, paramPagerAdapter);
          i += 1;
        }
      }
    }
    else
    {
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
  }
  
  public void setAdapter(e paramE)
  {
    List localList = mGroups;
    if (localList != null) {
      localList.remove(paramE);
    }
  }
  
  public void setAdapter(f paramF)
  {
    List localList = mOnPageChangeListeners;
    if (localList != null) {
      localList.remove(paramF);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    mPopulatePending = false;
    setCurrentItemInternal(paramInt, mFirstLayout ^ true, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (mAdapter == null)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to ");
      localStringBuilder.append(1);
      Log.w("ViewPager", localStringBuilder.toString());
      i = 1;
    }
    if (i != mOffscreenPageLimit)
    {
      mOffscreenPageLimit = i;
      populate();
    }
  }
  
  public void setOnPageChangeListener(f paramF)
  {
    mOnPageChangeListener = paramF;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = mPageMargin;
    mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    boolean bool;
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    }
    setWillNotDraw(bool);
    invalidate();
  }
  
  void setScrollState(int paramInt)
  {
    if (mScrollState == paramInt) {
      return;
    }
    mScrollState = paramInt;
    if (mPageTransformer != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      enableLayers(bool);
    }
    dispatchOnScrollStateChanged(paramInt);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    Scroller localScroller = mScroller;
    int i;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (mIsScrollStarted) {
        i = mScroller.getCurrX();
      } else {
        i = mScroller.getStartX();
      }
      mScroller.abortAnimation();
      setScrollingCacheEnabled(false);
    }
    else
    {
      i = getScrollX();
    }
    int j = getScrollY();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      completeScroll(false);
      populate();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    int k = getClientWidth();
    int m = k / 2;
    float f2 = Math.min(1.0F, Math.abs(paramInt1) * 1.0F / k);
    float f1 = m;
    f2 = distanceInfluenceForSnapDuration(f2);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0)
    {
      paramInt3 = Math.min(Math.round(Math.abs((f1 + f2 * f1) / paramInt3) * 1000.0F) * 4, 600);
      mIsScrollStarted = false;
      mScroller.startScroll(i, j, paramInt1, paramInt2, paramInt3);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == mMarginDrawable);
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    int childIndex;
    public int gravity;
    public boolean isDecor;
    boolean needsMeasure;
    int position;
    float widthFactor = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.LAYOUT_ATTRS);
      gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    Parcelable adapterState;
    ClassLoader loader;
    int position;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = SavedState.class.getClassLoader();
      }
      position = paramParcel.readInt();
      adapterState = paramParcel.readParcelable(localClassLoader);
      loader = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FragmentPager.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" position=");
      localStringBuilder.append(position);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(position);
      paramParcel.writeParcelable(adapterState, paramInt);
    }
    
    static final class a
      implements Parcelable.ClassLoaderCreator<ViewPager.SavedState>
    {
      a() {}
      
      public ViewPager.SavedState[] a(int paramInt)
      {
        return new ViewPager.SavedState[paramInt];
      }
      
      public ViewPager.SavedState getInstance(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new ViewPager.SavedState(paramParcel, paramClassLoader);
      }
      
      public ViewPager.SavedState readDate(Parcel paramParcel)
      {
        return new ViewPager.SavedState(paramParcel, null);
      }
    }
  }
  
  static final class a
    implements Comparator<ViewPager.d>
  {
    a() {}
    
    public int replace(ViewPager.d paramD1, ViewPager.d paramD2)
    {
      return position - position;
    }
  }
  
  static final class b
    implements Interpolator
  {
    b() {}
    
    public float getInterpolation(float paramFloat)
    {
      paramFloat -= 1.0F;
      return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
    }
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface c {}
  
  static class d
  {
    Object object;
    float offset;
    int position;
    boolean scrolling;
    float widthFactor;
    
    d() {}
  }
  
  public static abstract interface e
  {
    public abstract void setAdapter(ViewPager paramViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2);
  }
  
  public static abstract interface f
  {
    public abstract void onPageScrollStateChanged(int paramInt);
    
    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
  
  public static abstract interface g
  {
    public abstract void transformPage(View paramView, float paramFloat);
  }
  
  private class h
    extends DataSetObserver
  {
    h() {}
    
    public void onChanged()
    {
      cancel();
    }
    
    public void onInvalidated()
    {
      cancel();
    }
  }
  
  static class i
    implements Comparator<View>
  {
    i() {}
    
    public int compare(View paramView1, View paramView2)
    {
      paramView1 = (ViewPager.LayoutParams)paramView1.getLayoutParams();
      paramView2 = (ViewPager.LayoutParams)paramView2.getLayoutParams();
      boolean bool = isDecor;
      if (bool != isDecor)
      {
        if (bool) {
          return 1;
        }
        return -1;
      }
      return position - position;
    }
  }
}
