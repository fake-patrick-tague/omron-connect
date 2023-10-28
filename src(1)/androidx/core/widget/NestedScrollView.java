package androidx.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;
import v7.v7.Rings;
import v7.v7.package_13.ActionMenuItemView;
import v7.v7.package_13.NestedScrollingChild;
import v7.v7.package_13.NestedScrollingChildHelper;
import v7.v7.package_13.NestedScrollingParentHelper;
import v7.v7.package_13.RecyclerView.LayoutManager;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.package_13.asm.ClassReader;
import v7.v7.package_13.asm.Label;

public class NestedScrollView
  extends FrameLayout
  implements v7.v7.package_13.Object, NestedScrollingChild
{
  private static final int[] a = { 16843130 };
  private static final a d;
  private static final float i = (float)(Math.log(0.78D) / Math.log(0.9D));
  private final float bottom;
  private int mActivePointerId = -1;
  private final NestedScrollingChildHelper mChildHelper;
  private View mChildToScrollTo = null;
  public EdgeEffect mEdgeGlowBottom;
  public EdgeEffect mEdgeGlowTop;
  private boolean mFillViewport;
  private boolean mIsBeingDragged = false;
  private boolean mIsLaidOut = false;
  private boolean mIsLayoutDirty = true;
  private int mLastMotionY;
  private long mLastScroll;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private int mNestedYOffset;
  private c mOnScrollChangeListener;
  private final NestedScrollingParentHelper mParentHelper;
  private SavedState mSavedState;
  private final int[] mScrollConsumed = new int[2];
  private final int[] mScrollOffset = new int[2];
  private OverScroller mScroller;
  private boolean mSmoothScrollingEnabled = true;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private float mVerticalScrollFactor;
  private int x;
  
  static
  {
    d = new a();
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, Rings.height);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mEdgeGlowBottom = EdgeEffectCompat.a(paramContext, paramAttributeSet);
    mEdgeGlowTop = EdgeEffectCompat.a(paramContext, paramAttributeSet);
    bottom = (getResourcesgetDisplayMetricsdensity * 160.0F * 386.0878F * 0.84F);
    initScrollView();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a, paramInt, 0);
    setFillViewport(paramContext.getBoolean(0, false));
    paramContext.recycle();
    mParentHelper = new NestedScrollingParentHelper(this);
    mChildHelper = new NestedScrollingChildHelper(this);
    setNestedScrollingEnabled(true);
    ViewCompat.a(this, d);
  }
  
  private static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < paramInt3) && (paramInt1 >= 0))
    {
      int j = paramInt1;
      if (paramInt2 + paramInt1 > paramInt3) {
        j = paramInt3 - paramInt2;
      }
      return j;
    }
    return 0;
  }
  
  private void doScrollY(int paramInt)
  {
    if (paramInt != 0)
    {
      if (mSmoothScrollingEnabled)
      {
        smoothScrollBy(0, paramInt);
        return;
      }
      scrollBy(0, paramInt);
    }
  }
  
  private int draw(int paramInt, float paramFloat)
  {
    float f1 = paramFloat / getWidth();
    float f2 = paramInt / getHeight();
    float f3 = EdgeEffectCompat.draw(mEdgeGlowBottom);
    paramFloat = 0.0F;
    if (f3 != 0.0F)
    {
      f1 = -EdgeEffectCompat.add(mEdgeGlowBottom, -f2, f1);
      paramFloat = f1;
      if (EdgeEffectCompat.draw(mEdgeGlowBottom) == 0.0F)
      {
        mEdgeGlowBottom.onRelease();
        paramFloat = f1;
      }
    }
    for (;;)
    {
      break;
      if (EdgeEffectCompat.draw(mEdgeGlowTop) == 0.0F) {
        break;
      }
      f1 = EdgeEffectCompat.add(mEdgeGlowTop, f2, 1.0F - f1);
      paramFloat = f1;
      if (EdgeEffectCompat.draw(mEdgeGlowTop) == 0.0F)
      {
        mEdgeGlowTop.onRelease();
        paramFloat = f1;
      }
    }
    paramInt = Math.round(paramFloat * getHeight());
    if (paramInt != 0) {
      invalidate();
    }
    return paramInt;
  }
  
  private void draw(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int j = getScrollY();
    scrollBy(0, paramInt1);
    j = getScrollY() - j;
    if (paramArrayOfInt != null) {
      paramArrayOfInt[1] += j;
    }
    mChildHelper.setNestedScrollingEnabled(0, j, 0, paramInt1 - j, null, paramInt2, paramArrayOfInt);
  }
  
  private void draw(boolean paramBoolean)
  {
    if (paramBoolean) {
      startNestedScroll(2, 1);
    } else {
      setNestedScrollingEnabled(1);
    }
    x = getScrollY();
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  private boolean draw(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (EdgeEffectCompat.draw(mEdgeGlowBottom) != 0.0F)
    {
      EdgeEffectCompat.add(mEdgeGlowBottom, 0.0F, paramMotionEvent.getX() / getWidth());
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (EdgeEffectCompat.draw(mEdgeGlowTop) != 0.0F)
    {
      EdgeEffectCompat.add(mEdgeGlowTop, 0.0F, 1.0F - paramMotionEvent.getX() / getWidth());
      return true;
    }
    return bool;
  }
  
  private boolean draw(EdgeEffect paramEdgeEffect, int paramInt)
  {
    if (paramInt > 0) {
      return true;
    }
    float f1 = EdgeEffectCompat.draw(paramEdgeEffect);
    float f2 = getHeight();
    return evaluate(-paramInt) < f1 * f2;
  }
  
  private void endDrag()
  {
    mIsBeingDragged = false;
    recycleVelocityTracker();
    setNestedScrollingEnabled(0);
    mEdgeGlowBottom.onRelease();
    mEdgeGlowTop.onRelease();
  }
  
  private float evaluate(int paramInt)
  {
    double d1 = Math.log(Math.abs(paramInt) * 0.35F / (bottom * 0.015F));
    float f = i;
    double d2 = f;
    return (float)(bottom * 0.015F * Math.exp(f / (d2 - 1.0D) * d1));
  }
  
  private View findFocusableViewInBounds(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = getFocusables(2);
    int i2 = localArrayList.size();
    java.lang.Object localObject2 = null;
    int m = 0;
    int k;
    for (int n = 0; m < i2; n = k)
    {
      View localView = (View)localArrayList.get(m);
      int i1 = localView.getTop();
      int i3 = localView.getBottom();
      java.lang.Object localObject1 = localObject2;
      k = n;
      if (paramInt1 < i3)
      {
        localObject1 = localObject2;
        k = n;
        if (i1 < paramInt2)
        {
          int j;
          if ((paramInt1 < i1) && (i3 < paramInt2)) {
            j = 1;
          } else {
            j = 0;
          }
          if (localObject2 == null)
          {
            localObject1 = localView;
            k = j;
          }
          else
          {
            if (((paramBoolean) && (i1 < localObject2.getTop())) || ((!paramBoolean) && (i3 > localObject2.getBottom()))) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (n != 0)
            {
              localObject1 = localObject2;
              k = n;
              if (j == 0) {
                break label232;
              }
              localObject1 = localObject2;
              k = n;
              if (i1 == 0) {
                break label232;
              }
            }
            else
            {
              if (j != 0)
              {
                localObject1 = localView;
                k = 1;
                break label232;
              }
              localObject1 = localObject2;
              k = n;
              if (i1 == 0) {
                break label232;
              }
            }
            localObject1 = localView;
            k = n;
          }
        }
      }
      label232:
      m += 1;
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  private void fling()
  {
    mScroller.abortAnimation();
    setNestedScrollingEnabled(1);
  }
  
  private float getVerticalScrollFactorCompat()
  {
    if (mVerticalScrollFactor == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      Context localContext = getContext();
      if (localContext.getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        mVerticalScrollFactor = localTypedValue.getDimension(localContext.getResources().getDisplayMetrics());
      } else {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
    }
    return mVerticalScrollFactor;
  }
  
  private boolean inChild(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      int j = getScrollY();
      View localView = getChildAt(0);
      if ((paramInt2 >= localView.getTop() - j) && (paramInt2 < localView.getBottom() - j) && (paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight())) {
        return true;
      }
    }
    return false;
  }
  
  private void initOrResetVelocityTracker()
  {
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker == null)
    {
      mVelocityTracker = VelocityTracker.obtain();
      return;
    }
    localVelocityTracker.clear();
  }
  
  private void initScrollView()
  {
    mScroller = new OverScroller(getContext());
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private boolean isOffScreen(View paramView)
  {
    return isWithinDeltaOfScreen(paramView, 0, getHeight()) ^ true;
  }
  
  private static boolean isViewDescendantOf(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    return ((paramView1 instanceof ViewGroup)) && (isViewDescendantOf((View)paramView1, paramView2));
  }
  
  private boolean isWithinDeltaOfScreen(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(mTempRect);
    offsetDescendantRectToMyCoords(paramView, mTempRect);
    return (mTempRect.bottom + paramInt1 >= getScrollY()) && (mTempRect.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(j) == mActivePointerId)
    {
      if (j == 0) {
        j = 1;
      } else {
        j = 0;
      }
      mLastMotionY = ((int)paramMotionEvent.getY(j));
      mActivePointerId = paramMotionEvent.getPointerId(j);
      paramMotionEvent = mVelocityTracker;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  private boolean onTouchEvent(int paramInt)
  {
    if (EdgeEffectCompat.draw(mEdgeGlowBottom) != 0.0F)
    {
      if (draw(mEdgeGlowBottom, paramInt)) {
        mEdgeGlowBottom.onAbsorb(paramInt);
      } else {
        fling(-paramInt);
      }
    }
    else
    {
      if (EdgeEffectCompat.draw(mEdgeGlowTop) == 0.0F) {
        break label91;
      }
      EdgeEffect localEdgeEffect = mEdgeGlowTop;
      paramInt = -paramInt;
      if (draw(localEdgeEffect, paramInt)) {
        mEdgeGlowTop.onAbsorb(paramInt);
      } else {
        fling(paramInt);
      }
    }
    return true;
    label91:
    return false;
  }
  
  private boolean overScrollByCompat()
  {
    int j = getOverScrollMode();
    if (j != 0) {
      return (j == 1) && (getScrollRange() > 0);
    }
    return true;
  }
  
  private void recycleVelocityTracker()
  {
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      mVelocityTracker = null;
    }
  }
  
  private boolean scrollAndFocus(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = getHeight();
    int j = getScrollY();
    k += j;
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 == 33) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    View localView = findFocusableViewInBounds(bool1, paramInt2, paramInt3);
    java.lang.Object localObject = localView;
    if (localView == null) {
      localObject = this;
    }
    if ((paramInt2 >= j) && (paramInt3 <= k))
    {
      bool1 = bool2;
    }
    else
    {
      if (bool1) {
        paramInt2 -= j;
      } else {
        paramInt2 = paramInt3 - k;
      }
      doScrollY(paramInt2);
      bool1 = true;
    }
    if (localObject != findFocus()) {
      ((View)localObject).requestFocus(paramInt1);
    }
    return bool1;
  }
  
  private void scrollToChild(View paramView)
  {
    paramView.getDrawingRect(mTempRect);
    offsetDescendantRectToMyCoords(paramView, mTempRect);
    int j = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
    if (j != 0) {
      scrollBy(0, j);
    }
  }
  
  private boolean scrollToChildRect(Rect paramRect, boolean paramBoolean)
  {
    int j = computeScrollDeltaToGetChildRectOnScreen(paramRect);
    boolean bool;
    if (j != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      if (paramBoolean)
      {
        scrollBy(0, j);
        return bool;
      }
      smoothScrollBy(0, j);
    }
    return bool;
  }
  
  private boolean show()
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      if (localView.getHeight() + topMargin + bottomMargin > getHeight() - getPaddingTop() - getPaddingBottom()) {
        return true;
      }
    }
    return false;
  }
  
  private void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - mLastScroll > 250L)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int j = localView.getHeight();
      int k = topMargin;
      int m = bottomMargin;
      int n = getHeight();
      int i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt2 + paramInt1, Math.max(0, j + k + m - (n - i1 - i2))));
      mScroller.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1, paramInt3);
      draw(paramBoolean);
    }
    else
    {
      if (!mScroller.isFinished()) {
        fling();
      }
      scrollBy(paramInt1, paramInt2);
    }
    mLastScroll = AnimationUtils.currentAnimationTimeMillis();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    draw(paramInt4, paramInt5, paramArrayOfInt);
  }
  
  public boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    return (paramInt1 & 0x2) != 0;
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int m = getMaxScrollAmount();
    int k = m;
    if ((localView2 != null) && (isWithinDeltaOfScreen(localView2, m, getHeight())))
    {
      localView2.getDrawingRect(mTempRect);
      offsetDescendantRectToMyCoords(localView2, mTempRect);
      doScrollY(computeScrollDeltaToGetChildRectOnScreen(mTempRect));
      localView2.requestFocus(paramInt);
    }
    else
    {
      int j;
      if ((paramInt == 33) && (getScrollY() < m))
      {
        j = getScrollY();
      }
      else
      {
        j = k;
        if (paramInt == 130)
        {
          j = k;
          if (getChildCount() > 0)
          {
            localView2 = getChildAt(0);
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView2.getLayoutParams();
            j = Math.min(localView2.getBottom() + bottomMargin - (getScrollY() + getHeight() - getPaddingBottom()), m);
          }
        }
      }
      if (j == 0) {
        return false;
      }
      if (paramInt != 130) {
        j = -j;
      }
      doScrollY(j);
    }
    if ((localView1 != null) && (localView1.isFocused()) && (isOffScreen(localView1)))
    {
      paramInt = getDescendantFocusability();
      setDescendantFocusability(131072);
      requestFocus();
      setDescendantFocusability(paramInt);
    }
    return true;
  }
  
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll()
  {
    if (mScroller.isFinished()) {
      return;
    }
    mScroller.computeScrollOffset();
    int k = mScroller.getCurrY();
    int j = draw(k - x);
    x = k;
    int[] arrayOfInt = mScrollConsumed;
    int m = 0;
    arrayOfInt[1] = 0;
    dispatchNestedPreScroll(0, j, arrayOfInt, null, 1);
    k = j - mScrollConsumed[1];
    int n = getScrollRange();
    j = k;
    if (k != 0)
    {
      j = getScrollY();
      overScrollByCompat(0, k, getScrollX(), j, 0, n, 0, 0, false);
      j = getScrollY() - j;
      k -= j;
      arrayOfInt = mScrollConsumed;
      arrayOfInt[1] = 0;
      dispatchNestedPreScroll(0, j, 0, k, mScrollOffset, 1, arrayOfInt);
      j = k - mScrollConsumed[1];
    }
    if (j != 0)
    {
      int i1 = getOverScrollMode();
      if (i1 != 0)
      {
        k = m;
        if (i1 == 1)
        {
          k = m;
          if (n <= 0) {}
        }
      }
      else
      {
        k = 1;
      }
      if (k != 0) {
        if (j < 0)
        {
          if (mEdgeGlowBottom.isFinished()) {
            mEdgeGlowBottom.onAbsorb((int)mScroller.getCurrVelocity());
          }
        }
        else if (mEdgeGlowTop.isFinished()) {
          mEdgeGlowTop.onAbsorb((int)mScroller.getCurrVelocity());
        }
      }
      fling();
    }
    if (!mScroller.isFinished())
    {
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    setNestedScrollingEnabled(1);
  }
  
  protected int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int n = getHeight();
    int k = getScrollY();
    int j = k;
    int m = k + n;
    int i1 = getVerticalFadingEdgeLength();
    if (top > 0) {
      j = k + i1;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    if (bottom < localView.getHeight() + topMargin + bottomMargin) {
      k = m - i1;
    } else {
      k = m;
    }
    i1 = bottom;
    if ((i1 > k) && (top > j))
    {
      if (paramRect.height() > n) {
        j = top - j;
      } else {
        j = bottom - k;
      }
      return Math.min(j + 0, localView.getBottom() + bottomMargin - m);
    }
    if ((top < j) && (i1 < k))
    {
      if (paramRect.height() > n) {
        j = 0 - (k - bottom);
      } else {
        j = 0 - (j - top);
      }
      return Math.max(j, -getScrollY());
    }
    return 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  public int computeVerticalScrollRange()
  {
    int k = getChildCount();
    int j = getHeight() - getPaddingBottom() - getPaddingTop();
    if (k == 0) {
      return j;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    k = localView.getBottom() + bottomMargin;
    int m = getScrollY();
    int n = Math.max(0, k - j);
    if (m < 0) {
      return k - m;
    }
    j = k;
    if (m > n) {
      j = k + (m - n);
    }
    return j;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return mChildHelper.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return mChildHelper.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void dispatchNestedPreScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, int[] paramArrayOfInt2)
  {
    mChildHelper.setNestedScrollingEnabled(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return mChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return mChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  int draw(int paramInt)
  {
    int k = getHeight();
    float f1;
    if ((paramInt > 0) && (EdgeEffectCompat.draw(mEdgeGlowBottom) != 0.0F))
    {
      f1 = -paramInt * 4.0F / k;
      j = Math.round(-k / 4.0F * EdgeEffectCompat.add(mEdgeGlowBottom, f1, 0.5F));
      if (j != paramInt) {
        mEdgeGlowBottom.finish();
      }
      return paramInt - j;
    }
    int j = paramInt;
    if (paramInt < 0)
    {
      j = paramInt;
      if (EdgeEffectCompat.draw(mEdgeGlowTop) != 0.0F)
      {
        float f2 = paramInt;
        f1 = k;
        f2 = f2 * 4.0F / f1;
        j = Math.round(f1 / 4.0F * EdgeEffectCompat.add(mEdgeGlowTop, f2, 0.5F));
        if (j != paramInt) {
          mEdgeGlowTop.finish();
        }
        j = paramInt - j;
      }
    }
    return j;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i6 = getScrollY();
    boolean bool = mEdgeGlowBottom.isFinished();
    int i3 = 0;
    int m;
    int n;
    int i5;
    int j;
    int i4;
    int k;
    int i2;
    int i1;
    if (!bool)
    {
      int i7 = paramCanvas.save();
      m = getWidth();
      n = m;
      i5 = getHeight();
      j = i5;
      i4 = Math.min(0, i6);
      k = i4;
      int i8 = Build.VERSION.SDK_INT;
      if ((i8 >= 21) && (!b.a(this)))
      {
        m = 0;
      }
      else
      {
        n = m - (getPaddingLeft() + getPaddingRight());
        m = getPaddingLeft() + 0;
      }
      i2 = j;
      i1 = k;
      if (i8 >= 21)
      {
        i2 = j;
        i1 = k;
        if (b.a(this))
        {
          i2 = i5 - (getPaddingTop() + getPaddingBottom());
          i1 = i4 + getPaddingTop();
        }
      }
      paramCanvas.translate(m, i1);
      mEdgeGlowBottom.setSize(n, i2);
      if (mEdgeGlowBottom.draw(paramCanvas)) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      paramCanvas.restoreToCount(i7);
    }
    if (!mEdgeGlowTop.isFinished())
    {
      i5 = paramCanvas.save();
      n = getWidth();
      m = n;
      i2 = getHeight();
      j = i2;
      i4 = Math.max(getScrollRange(), i6) + i2;
      i6 = Build.VERSION.SDK_INT;
      if (i6 >= 21)
      {
        k = i3;
        if (!b.a(this)) {}
      }
      else
      {
        m = n - (getPaddingLeft() + getPaddingRight());
        k = 0 + getPaddingLeft();
      }
      i1 = i4;
      n = j;
      if (i6 >= 21)
      {
        i1 = i4;
        n = j;
        if (b.a(this))
        {
          n = i2 - (getPaddingTop() + getPaddingBottom());
          i1 = i4 - getPaddingBottom();
        }
      }
      paramCanvas.translate(k - m, i1);
      paramCanvas.rotate(180.0F, m, 0.0F);
      mEdgeGlowTop.setSize(m, n);
      if (mEdgeGlowTop.draw(paramCanvas)) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      paramCanvas.restoreToCount(i5);
    }
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    mTempRect.setEmpty();
    boolean bool = show();
    int j = 130;
    if (!bool)
    {
      if ((isFocused()) && (paramKeyEvent.getKeyCode() != 4))
      {
        View localView = findFocus();
        paramKeyEvent = localView;
        if (localView == this) {
          paramKeyEvent = null;
        }
        paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
        if ((paramKeyEvent != null) && (paramKeyEvent != this) && (paramKeyEvent.requestFocus(130))) {
          return true;
        }
      }
    }
    else if (paramKeyEvent.getAction() == 0)
    {
      int k = paramKeyEvent.getKeyCode();
      if (k != 19)
      {
        if (k != 20)
        {
          if (k != 62) {
            return false;
          }
          if (paramKeyEvent.isShiftPressed()) {
            j = 33;
          }
          pageScroll(j);
          return false;
        }
        if (!paramKeyEvent.isAltPressed()) {
          return arrowScroll(130);
        }
        return fullScroll(130);
      }
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(33);
      }
      return fullScroll(33);
    }
    return false;
  }
  
  public void fling(int paramInt)
  {
    if (getChildCount() > 0)
    {
      mScroller.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
      draw(true);
    }
  }
  
  public boolean fullScroll(int paramInt)
  {
    int j;
    if (paramInt == 130) {
      j = 1;
    } else {
      j = 0;
    }
    int k = getHeight();
    java.lang.Object localObject = mTempRect;
    top = 0;
    bottom = k;
    if (j != 0)
    {
      j = getChildCount();
      if (j > 0)
      {
        localObject = getChildAt(j - 1);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        mTempRect.bottom = (((View)localObject).getBottom() + bottomMargin + getPaddingBottom());
        localObject = mTempRect;
        top = (bottom - k);
      }
    }
    localObject = mTempRect;
    return scrollAndFocus(paramInt, top, bottom);
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    int j = getVerticalFadingEdgeLength();
    int k = getHeight();
    int m = getPaddingBottom();
    k = localView.getBottom() + bottomMargin - getScrollY() - (k - m);
    if (k < j) {
      return k / j;
    }
    return 1.0F;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)(getHeight() * 0.5F);
  }
  
  public int getNestedScrollAxes()
  {
    return mParentHelper.getNestedScrollAxes();
  }
  
  int getScrollRange()
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      return Math.max(0, localView.getHeight() + topMargin + bottomMargin - (getHeight() - getPaddingTop() - getPaddingBottom()));
    }
    return 0;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int j = getVerticalFadingEdgeLength();
    int k = getScrollY();
    if (k < j) {
      return k / j;
    }
    return 1.0F;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return hasNestedScrollingParent(0);
  }
  
  public boolean hasNestedScrollingParent(int paramInt)
  {
    return mChildHelper.hasNestedScrollingParent(paramInt);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return mChildHelper.isNestedScrollingEnabled();
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin + paramInt2, width), View.MeasureSpec.makeMeasureSpec(topMargin + bottomMargin, 0));
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    mIsLaidOut = false;
  }
  
  public void onDraw(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    int m = 0;
    boolean bool = false;
    if ((j == 8) && (!mIsBeingDragged))
    {
      float f;
      if (RecyclerView.LayoutManager.process(paramMotionEvent, 2)) {
        f = paramMotionEvent.getAxisValue(9);
      } else if (RecyclerView.LayoutManager.process(paramMotionEvent, 4194304)) {
        f = paramMotionEvent.getAxisValue(26);
      } else {
        f = 0.0F;
      }
      if (f != 0.0F)
      {
        j = (int)(f * getVerticalScrollFactorCompat());
        int n = getScrollRange();
        int i1 = getScrollY();
        int k = i1 - j;
        if (k < 0)
        {
          if ((overScrollByCompat()) && (!RecyclerView.LayoutManager.process(paramMotionEvent, 8194))) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0)
          {
            EdgeEffectCompat.add(mEdgeGlowBottom, -k / getHeight(), 0.5F);
            mEdgeGlowBottom.onRelease();
            invalidate();
            bool = true;
            j = m;
          }
          else
          {
            bool = false;
            j = m;
          }
        }
        else if (k > n)
        {
          if ((overScrollByCompat()) && (!RecyclerView.LayoutManager.process(paramMotionEvent, 8194))) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0)
          {
            EdgeEffectCompat.add(mEdgeGlowTop, (k - n) / getHeight(), 0.5F);
            mEdgeGlowTop.onRelease();
            invalidate();
            bool = true;
          }
          j = n;
        }
        else
        {
          bool = false;
          j = k;
        }
        if (j != i1)
        {
          super.scrollTo(getScrollX(), j);
          return true;
        }
        return bool;
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    boolean bool3 = true;
    boolean bool2 = true;
    if ((j == 2) && (mIsBeingDragged)) {
      return true;
    }
    j &= 0xFF;
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 6) {
              break label407;
            }
            onSecondaryPointerUp(paramMotionEvent);
            break label407;
          }
        }
        else
        {
          j = mActivePointerId;
          if (j == -1) {
            break label407;
          }
          int k = paramMotionEvent.findPointerIndex(j);
          if (k == -1)
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("Invalid pointerId=");
            paramMotionEvent.append(j);
            paramMotionEvent.append(" in onInterceptTouchEvent");
            Log.e("NestedScrollView", paramMotionEvent.toString());
            break label407;
          }
          j = (int)paramMotionEvent.getY(k);
          if ((Math.abs(j - mLastMotionY) <= mTouchSlop) || ((0x2 & getNestedScrollAxes()) != 0)) {
            break label407;
          }
          mIsBeingDragged = true;
          mLastMotionY = j;
          initVelocityTrackerIfNotExists();
          mVelocityTracker.addMovement(paramMotionEvent);
          mNestedYOffset = 0;
          paramMotionEvent = getParent();
          if (paramMotionEvent == null) {
            break label407;
          }
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          break label407;
        }
      }
      mIsBeingDragged = false;
      mActivePointerId = -1;
      recycleVelocityTracker();
      if (mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      setNestedScrollingEnabled(0);
    }
    else
    {
      j = (int)paramMotionEvent.getY();
      boolean bool1;
      if (!inChild((int)paramMotionEvent.getX(), j))
      {
        bool1 = bool2;
        if (!draw(paramMotionEvent)) {
          if (!mScroller.isFinished()) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        mIsBeingDragged = bool1;
        recycleVelocityTracker();
      }
      else
      {
        mLastMotionY = j;
        mActivePointerId = paramMotionEvent.getPointerId(0);
        initOrResetVelocityTracker();
        mVelocityTracker.addMovement(paramMotionEvent);
        mScroller.computeScrollOffset();
        bool1 = bool3;
        if (!draw(paramMotionEvent)) {
          if (!mScroller.isFinished()) {
            bool1 = bool3;
          } else {
            bool1 = false;
          }
        }
        mIsBeingDragged = bool1;
        startNestedScroll(2, 0);
      }
    }
    label407:
    return mIsBeingDragged;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    mIsLayoutDirty = false;
    View localView = mChildToScrollTo;
    if ((localView != null) && (isViewDescendantOf(localView, this))) {
      scrollToChild(mChildToScrollTo);
    }
    mChildToScrollTo = null;
    if (!mIsLaidOut)
    {
      if (mSavedState != null)
      {
        scrollTo(getScrollX(), mSavedState.scrollPosition);
        mSavedState = null;
      }
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        paramInt1 = localView.getMeasuredHeight() + topMargin + bottomMargin;
      }
      int j = getPaddingTop();
      int k = getPaddingBottom();
      paramInt3 = getScrollY();
      paramInt1 = clamp(paramInt3, paramInt4 - paramInt2 - j - k, paramInt1);
      if (paramInt1 != paramInt3) {
        scrollTo(getScrollX(), paramInt1);
      }
    }
    scrollTo(getScrollX(), getScrollY());
    mIsLaidOut = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!mFillViewport) {
      return;
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      return;
    }
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      paramInt2 = localView.getMeasuredHeight();
      int j = getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - topMargin - bottomMargin;
      if (paramInt2 < j) {
        localView.measure(ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin, width), View.MeasureSpec.makeMeasureSpec(j, 1073741824));
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      dispatchNestedFling(0.0F, paramFloat2, true);
      fling((int)paramFloat2);
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    onDraw(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    draw(paramInt4, 0, null);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    draw(paramInt4, paramInt5, null);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    performIntercept(paramView1, paramView2, paramInt, 0);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int j;
    if (paramInt == 2)
    {
      j = 130;
    }
    else
    {
      j = paramInt;
      if (paramInt == 1) {
        j = 33;
      }
    }
    View localView;
    if (paramRect == null) {
      localView = FocusFinder.getInstance().findNextFocus(this, null, j);
    } else {
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, j);
    }
    if (localView == null) {
      return false;
    }
    if (isOffScreen(localView)) {
      return false;
    }
    return localView.requestFocus(j, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    mSavedState = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    scrollPosition = getScrollY();
    return localSavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    c localC = mOnScrollChangeListener;
    if (localC != null) {
      localC.onScrollChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if (localView != null)
    {
      if (this == localView) {
        return;
      }
      if (isWithinDeltaOfScreen(localView, 0, paramInt4))
      {
        localView.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(localView, mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(mTempRect));
      }
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return a(paramView1, paramView2, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    performIntercept(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    initVelocityTrackerIfNotExists();
    int j = paramMotionEvent.getActionMasked();
    int n = 0;
    if (j == 0) {
      mNestedYOffset = 0;
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.offsetLocation(0.0F, mNestedYOffset);
    java.lang.Object localObject;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 5)
            {
              if (j == 6)
              {
                onSecondaryPointerUp(paramMotionEvent);
                mLastMotionY = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(mActivePointerId)));
              }
            }
            else
            {
              j = paramMotionEvent.getActionIndex();
              mLastMotionY = ((int)paramMotionEvent.getY(j));
              mActivePointerId = paramMotionEvent.getPointerId(j);
            }
          }
          else
          {
            if ((mIsBeingDragged) && (getChildCount() > 0) && (mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))) {
              ViewCompat.postInvalidateOnAnimation(this);
            }
            mActivePointerId = -1;
            endDrag();
          }
        }
        else
        {
          int i1 = paramMotionEvent.findPointerIndex(mActivePointerId);
          if (i1 == -1)
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("Invalid pointerId=");
            paramMotionEvent.append(mActivePointerId);
            paramMotionEvent.append(" in onTouchEvent");
            Log.e("NestedScrollView", paramMotionEvent.toString());
          }
          else
          {
            int m = (int)paramMotionEvent.getY(i1);
            j = mLastMotionY - m;
            int k = j - draw(j, paramMotionEvent.getX(i1));
            j = k;
            if (!mIsBeingDragged)
            {
              j = k;
              if (Math.abs(k) > mTouchSlop)
              {
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
                mIsBeingDragged = true;
                if (k > 0) {
                  j = k - mTouchSlop;
                } else {
                  j = k + mTouchSlop;
                }
              }
            }
            k = j;
            if (mIsBeingDragged)
            {
              if (dispatchNestedPreScroll(0, j, mScrollConsumed, mScrollOffset, 0))
              {
                k = j - mScrollConsumed[1];
                mNestedYOffset += mScrollOffset[1];
              }
              mLastMotionY = (m - mScrollOffset[1]);
              int i3 = getScrollY();
              int i2 = getScrollRange();
              j = getOverScrollMode();
              if ((j != 0) && ((j != 1) || (i2 <= 0))) {
                m = 0;
              } else {
                m = 1;
              }
              if ((overScrollByCompat(0, k, 0, getScrollY(), 0, i2, 0, 0, true)) && (!hasNestedScrollingParent(0))) {
                j = 1;
              } else {
                j = 0;
              }
              int i4 = getScrollY() - i3;
              localObject = mScrollConsumed;
              localObject[1] = 0;
              dispatchNestedPreScroll(0, i4, 0, k - i4, mScrollOffset, 0, (int[])localObject);
              i4 = mLastMotionY;
              localObject = mScrollOffset;
              mLastMotionY = (i4 - localObject[1]);
              mNestedYOffset += localObject[1];
              if (m != 0)
              {
                k -= mScrollConsumed[1];
                m = i3 + k;
                if (m < 0)
                {
                  EdgeEffectCompat.add(mEdgeGlowBottom, -k / getHeight(), paramMotionEvent.getX(i1) / getWidth());
                  if (!mEdgeGlowTop.isFinished()) {
                    mEdgeGlowTop.onRelease();
                  }
                }
                else if (m > i2)
                {
                  EdgeEffectCompat.add(mEdgeGlowTop, k / getHeight(), 1.0F - paramMotionEvent.getX(i1) / getWidth());
                  if (!mEdgeGlowBottom.isFinished()) {
                    mEdgeGlowBottom.onRelease();
                  }
                }
                if ((!mEdgeGlowBottom.isFinished()) || (!mEdgeGlowTop.isFinished()))
                {
                  ViewCompat.postInvalidateOnAnimation(this);
                  j = n;
                }
              }
              if (j != 0) {
                mVelocityTracker.clear();
              }
            }
          }
        }
      }
      else
      {
        paramMotionEvent = mVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000, mMaximumVelocity);
        j = (int)paramMotionEvent.getYVelocity(mActivePointerId);
        if (Math.abs(j) >= mMinimumVelocity)
        {
          if (!onTouchEvent(j))
          {
            j = -j;
            float f = j;
            if (!dispatchNestedPreFling(0.0F, f))
            {
              dispatchNestedFling(0.0F, f, true);
              fling(j);
            }
          }
        }
        else if (mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
          ViewCompat.postInvalidateOnAnimation(this);
        }
        mActivePointerId = -1;
        endDrag();
      }
    }
    else
    {
      if (getChildCount() == 0) {
        return false;
      }
      if (mIsBeingDragged)
      {
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
      }
      if (!mScroller.isFinished()) {
        fling();
      }
      mLastMotionY = ((int)paramMotionEvent.getY());
      mActivePointerId = paramMotionEvent.getPointerId(0);
      startNestedScroll(2, 0);
    }
    paramMotionEvent = mVelocityTracker;
    if (paramMotionEvent != null) {
      paramMotionEvent.addMovement(localMotionEvent);
    }
    localMotionEvent.recycle();
    return true;
  }
  
  boolean overScrollByCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int m = getOverScrollMode();
    int j;
    if (computeHorizontalScrollRange() > computeHorizontalScrollExtent()) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
      k = 1;
    } else {
      k = 0;
    }
    if ((m != 0) && ((m != 1) || (j == 0))) {
      j = 0;
    } else {
      j = 1;
    }
    if ((m != 0) && ((m != 1) || (k == 0))) {
      k = 0;
    } else {
      k = 1;
    }
    paramInt3 += paramInt1;
    if (j == 0) {
      paramInt1 = 0;
    } else {
      paramInt1 = paramInt7;
    }
    paramInt4 += paramInt2;
    if (k == 0) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramInt8;
    }
    paramInt7 = -paramInt1;
    paramInt1 += paramInt5;
    paramInt5 = -paramInt2;
    paramInt2 += paramInt6;
    if (paramInt3 > paramInt1)
    {
      paramBoolean = true;
    }
    else if (paramInt3 < paramInt7)
    {
      paramBoolean = true;
      paramInt1 = paramInt7;
    }
    else
    {
      paramBoolean = false;
      paramInt1 = paramInt3;
    }
    boolean bool;
    if (paramInt4 > paramInt2)
    {
      bool = true;
    }
    else if (paramInt4 < paramInt5)
    {
      bool = true;
      paramInt2 = paramInt5;
    }
    else
    {
      bool = false;
      paramInt2 = paramInt4;
    }
    if ((bool) && (!hasNestedScrollingParent(1))) {
      mScroller.springBack(paramInt1, paramInt2, 0, 0, 0, getScrollRange());
    }
    onOverScrolled(paramInt1, paramInt2, paramBoolean, bool);
    return (paramBoolean) || (bool);
  }
  
  public boolean pageScroll(int paramInt)
  {
    if (paramInt == 130) {
      j = 1;
    } else {
      j = 0;
    }
    int k = getHeight();
    if (j != 0)
    {
      mTempRect.top = (getScrollY() + k);
      j = getChildCount();
      if (j > 0)
      {
        localObject = getChildAt(j - 1);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        j = ((View)localObject).getBottom() + bottomMargin + getPaddingBottom();
        localObject = mTempRect;
        if (top + k > j) {
          top = (j - k);
        }
      }
    }
    else
    {
      mTempRect.top = (getScrollY() - k);
      localObject = mTempRect;
      if (top < 0) {
        top = 0;
      }
    }
    java.lang.Object localObject = mTempRect;
    int j = top;
    k += j;
    bottom = k;
    return scrollAndFocus(paramInt, j, k);
  }
  
  public void performIntercept(View paramView, int paramInt)
  {
    mParentHelper.onStopNestedScroll(paramView, paramInt);
    setNestedScrollingEnabled(paramInt);
  }
  
  public void performIntercept(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    mParentHelper.onStopNestedScroll(paramView1, paramView2, paramInt1, paramInt2);
    startNestedScroll(2, paramInt2);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!mIsLayoutDirty) {
      scrollToChild(paramView2);
    } else {
      mChildToScrollTo = paramView2;
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    return scrollToChildRect(paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      recycleVelocityTracker();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    mIsLayoutDirty = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i3 = getWidth();
      int i4 = getPaddingLeft();
      int i5 = getPaddingRight();
      int i6 = localView.getWidth();
      int i7 = leftMargin;
      int i8 = rightMargin;
      int j = getHeight();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      int n = localView.getHeight();
      int i1 = topMargin;
      int i2 = bottomMargin;
      paramInt1 = clamp(paramInt1, i3 - i4 - i5, i6 + i7 + i8);
      paramInt2 = clamp(paramInt2, j - k - m, n + i1 + i2);
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  void scrollTo(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    smoothScrollTo(paramInt1, paramInt2, 250, paramBoolean);
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != mFillViewport)
    {
      mFillViewport = paramBoolean;
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(int paramInt)
  {
    mChildHelper.stopNestedScroll(paramInt);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    mChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnScrollChangeListener(c paramC)
  {
    mOnScrollChangeListener = paramC;
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    mSmoothScrollingEnabled = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, 250, false);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    smoothScrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY(), paramInt3, paramBoolean);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return startNestedScroll(paramInt, 0);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2)
  {
    return mChildHelper.startNestedScroll(paramInt1, paramInt2);
  }
  
  public void stopNestedScroll()
  {
    setNestedScrollingEnabled(0);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    public int scrollPosition;
    
    SavedState(Parcel paramParcel)
    {
      super();
      scrollPosition = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HorizontalScrollView.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" scrollPosition=");
      localStringBuilder.append(scrollPosition);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(scrollPosition);
    }
    
    class a
      implements Parcelable.Creator<NestedScrollView.SavedState>
    {
      a() {}
      
      public NestedScrollView.SavedState[] a(int paramInt)
      {
        return new NestedScrollView.SavedState[paramInt];
      }
      
      public NestedScrollView.SavedState readDate(Parcel paramParcel)
      {
        return new NestedScrollView.SavedState(paramParcel);
      }
    }
  }
  
  static class a
    extends ActionMenuItemView
  {
    a() {}
    
    public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.a(paramView, paramAccessibilityEvent);
      paramView = (NestedScrollView)paramView;
      paramAccessibilityEvent.setClassName(ScrollView.class.getName());
      boolean bool;
      if (paramView.getScrollRange() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramAccessibilityEvent.setScrollable(bool);
      paramAccessibilityEvent.setScrollX(paramView.getScrollX());
      paramAccessibilityEvent.setScrollY(paramView.getScrollY());
      ClassReader.a(paramAccessibilityEvent, paramView.getScrollX());
      ClassReader.b(paramAccessibilityEvent, paramView.getScrollRange());
    }
    
    public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.a(paramView, paramAccessibilityNodeInfoCompat);
      paramView = (NestedScrollView)paramView;
      paramAccessibilityNodeInfoCompat.getText(ScrollView.class.getName());
      if (paramView.isEnabled())
      {
        int i = paramView.getScrollRange();
        if (i > 0)
        {
          paramAccessibilityNodeInfoCompat.setScrollable(true);
          if (paramView.getScrollY() > 0)
          {
            paramAccessibilityNodeInfoCompat.b(Label.b);
            paramAccessibilityNodeInfoCompat.b(Label.k);
          }
          if (paramView.getScrollY() < i)
          {
            paramAccessibilityNodeInfoCompat.b(Label.a);
            paramAccessibilityNodeInfoCompat.b(Label.i);
          }
        }
      }
    }
    
    public boolean a(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.a(paramView, paramInt, paramBundle)) {
        return true;
      }
      paramView = (NestedScrollView)paramView;
      if (!paramView.isEnabled()) {
        return false;
      }
      int j = paramView.getHeight();
      paramBundle = new Rect();
      int i = j;
      if (paramView.getMatrix().isIdentity())
      {
        i = j;
        if (paramView.getGlobalVisibleRect(paramBundle)) {
          i = paramBundle.height();
        }
      }
      if (paramInt != 4096) {
        if ((paramInt != 8192) && (paramInt != 16908344))
        {
          if (paramInt != 16908346) {
            return false;
          }
        }
        else
        {
          paramInt = paramView.getPaddingBottom();
          j = paramView.getPaddingTop();
          paramInt = Math.max(paramView.getScrollY() - (i - paramInt - j), 0);
          if (paramInt != paramView.getScrollY())
          {
            paramView.scrollTo(0, paramInt, true);
            return true;
          }
          return false;
        }
      }
      paramInt = paramView.getPaddingBottom();
      j = paramView.getPaddingTop();
      paramInt = Math.min(paramView.getScrollY() + (i - paramInt - j), paramView.getScrollRange());
      if (paramInt != paramView.getScrollY())
      {
        paramView.scrollTo(0, paramInt, true);
        return true;
      }
      return false;
    }
  }
  
  static class b
  {
    static boolean a(ViewGroup paramViewGroup)
    {
      return paramViewGroup.getClipToPadding();
    }
  }
  
  public static abstract interface c
  {
    public abstract void onScrollChange(NestedScrollView paramNestedScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}
