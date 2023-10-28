package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.l.a;
import androidx.core.graphics.Item;
import v7.internal.R.attr;
import v7.internal.R.id;
import v7.v7.package_13.CoordinatorLayout.LayoutParams;
import v7.v7.package_13.NestedScrollingParent;
import v7.v7.package_13.NestedScrollingParentHelper;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.f;
import v7.v7.package_13.n0.b;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements DecorContentParent, NestedScrollingParent, CoordinatorLayout.LayoutParams, v7.v7.package_13.Object
{
  static final int[] ATTRS = { R.attr.actionBarSize, 16842841 };
  private f left;
  private int mActionBarHeight;
  ActionBarContainer mActionBarTop;
  private d mActionBarVisibilityCallback;
  private final Runnable mAddActionBarHideOffset;
  boolean mAnimatingForFling;
  private final Rect mBaseContentInsets = new Rect();
  private final Rect mBaseInnerInsets = new Rect();
  private ContentFrameLayout mContent;
  private final Rect mContentInsets = new Rect();
  ViewPropertyAnimator mCurrentActionBarTopAnimator;
  private DecorToolbar mDecorToolbar;
  private OverScroller mFlingEstimator;
  private boolean mHasNonEmbeddedTabs;
  private boolean mHideOnContentScroll;
  private int mHideOnContentScrollReference;
  private boolean mIgnoreWindowContentOverlay;
  private final Rect mInnerInsets = new Rect();
  private final Rect mLastBaseContentInsets = new Rect();
  private int mLastSystemUiVisibility;
  private boolean mOverlayMode;
  private final NestedScrollingParentHelper mParentHelper;
  private final Rect mPosition = new Rect();
  private final Runnable mRemoveActionBarHideOffset;
  final AnimatorListenerAdapter mStartTime;
  private Drawable mWindowContentOverlay;
  private int mWindowVisibility = 0;
  private f right;
  private final Rect this$0 = new Rect();
  private f x;
  private f y;
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = f.c;
    left = paramAttributeSet;
    right = paramAttributeSet;
    y = paramAttributeSet;
    x = paramAttributeSet;
    mStartTime = new a();
    mRemoveActionBarHideOffset = new b();
    mAddActionBarHideOffset = new c();
    init(paramContext);
    mParentHelper = new NestedScrollingParentHelper(this);
  }
  
  private void addActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    mAddActionBarHideOffset.run();
  }
  
  private boolean applyInsets(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    int i;
    int j;
    if (paramBoolean1)
    {
      i = leftMargin;
      j = left;
      if (i != j)
      {
        leftMargin = j;
        bool = true;
        break label46;
      }
    }
    boolean bool = false;
    label46:
    paramBoolean1 = bool;
    if (paramBoolean2)
    {
      i = topMargin;
      j = top;
      paramBoolean1 = bool;
      if (i != j)
      {
        topMargin = j;
        paramBoolean1 = true;
      }
    }
    paramBoolean2 = paramBoolean1;
    if (paramBoolean4)
    {
      i = rightMargin;
      j = right;
      paramBoolean2 = paramBoolean1;
      if (i != j)
      {
        rightMargin = j;
        paramBoolean2 = true;
      }
    }
    if (paramBoolean3)
    {
      i = bottomMargin;
      j = bottom;
      if (i != j)
      {
        bottomMargin = j;
        return true;
      }
    }
    return paramBoolean2;
  }
  
  private DecorToolbar getDecorToolbar(View paramView)
  {
    if ((paramView instanceof DecorToolbar)) {
      return (DecorToolbar)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Can't make a decor toolbar out of ");
    localStringBuilder.append(paramView.getClass().getSimpleName());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void init(Context paramContext)
  {
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(ATTRS);
    boolean bool2 = false;
    mActionBarHeight = localTypedArray.getDimensionPixelSize(0, 0);
    Drawable localDrawable = localTypedArray.getDrawable(1);
    mWindowContentOverlay = localDrawable;
    if (localDrawable == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    localTypedArray.recycle();
    boolean bool1 = bool2;
    if (getApplicationInfotargetSdkVersion < 19) {
      bool1 = true;
    }
    mIgnoreWindowContentOverlay = bool1;
    mFlingEstimator = new OverScroller(paramContext);
  }
  
  private void postAddActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    postDelayed(mAddActionBarHideOffset, 600L);
  }
  
  private void postRemoveActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    postDelayed(mRemoveActionBarHideOffset, 600L);
  }
  
  private void removeActionBarHideOffset()
  {
    haltActionBarHideOffsetAnimations();
    mRemoveActionBarHideOffset.run();
  }
  
  private boolean shouldHideActionBarOnFling(float paramFloat)
  {
    mFlingEstimator.fling(0, 0, 0, (int)paramFloat, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return mFlingEstimator.getFinalY() > mActionBarTop.getHeight();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    return (paramInt2 == 0) && (onStartNestedScroll(paramView1, paramView2, paramInt1));
  }
  
  public boolean canShowOverflowMenu()
  {
    pullChildren();
    return mDecorToolbar.canShowOverflowMenu();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dismissPopups()
  {
    pullChildren();
    mDecorToolbar.dismissPopupMenus();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((mWindowContentOverlay != null) && (!mIgnoreWindowContentOverlay))
    {
      int i;
      if (mActionBarTop.getVisibility() == 0) {
        i = (int)(mActionBarTop.getBottom() + mActionBarTop.getTranslationY() + 0.5F);
      } else {
        i = 0;
      }
      mWindowContentOverlay.setBounds(0, i, getWidth(), mWindowContentOverlay.getIntrinsicHeight() + i);
      mWindowContentOverlay.draw(paramCanvas);
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return super.fitSystemWindows(paramRect);
    }
    pullChildren();
    boolean bool = applyInsets(mActionBarTop, paramRect, true, true, false, true);
    mBaseInnerInsets.set(paramRect);
    ViewUtils.computeFitSystemWindows(this, mBaseInnerInsets, mBaseContentInsets);
    if (!mInnerInsets.equals(mBaseInnerInsets))
    {
      mInnerInsets.set(mBaseInnerInsets);
      bool = true;
    }
    if (!mLastBaseContentInsets.equals(mBaseContentInsets))
    {
      mLastBaseContentInsets.set(mBaseContentInsets);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  protected LayoutParams generateLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public int getActionBarHideOffset()
  {
    ActionBarContainer localActionBarContainer = mActionBarTop;
    if (localActionBarContainer != null) {
      return -(int)localActionBarContainer.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return mParentHelper.getNestedScrollAxes();
  }
  
  public CharSequence getTitle()
  {
    pullChildren();
    return mDecorToolbar.getTitle();
  }
  
  void haltActionBarHideOffsetAnimations()
  {
    removeCallbacks(mRemoveActionBarHideOffset);
    removeCallbacks(mAddActionBarHideOffset);
    ViewPropertyAnimator localViewPropertyAnimator = mCurrentActionBarTopAnimator;
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
    }
  }
  
  public boolean hideOverflowMenu()
  {
    pullChildren();
    return mDecorToolbar.hideOverflowMenu();
  }
  
  public LayoutParams init(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public void initFeature(int paramInt)
  {
    pullChildren();
    if (paramInt != 2)
    {
      if (paramInt != 5)
      {
        if (paramInt != 109) {
          return;
        }
        setOverlayMode(true);
        return;
      }
      mDecorToolbar.initIndeterminateProgress();
      return;
    }
    mDecorToolbar.initProgress();
  }
  
  public boolean isInOverlayMode()
  {
    return mOverlayMode;
  }
  
  public boolean isOverflowMenuShowPending()
  {
    pullChildren();
    return mDecorToolbar.isOverflowMenuShowPending();
  }
  
  public boolean isOverflowMenuShowing()
  {
    pullChildren();
    return mDecorToolbar.isOverflowMenuShowing();
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    pullChildren();
    paramWindowInsets = f.a(paramWindowInsets, this);
    Object localObject = new Rect(paramWindowInsets.getHeight(), paramWindowInsets.getSystemWindowInsetTop(), paramWindowInsets.getWidth(), paramWindowInsets.size());
    boolean bool1 = applyInsets(mActionBarTop, (Rect)localObject, true, true, false, true);
    ViewCompat.a(this, paramWindowInsets, mBaseContentInsets);
    localObject = mBaseContentInsets;
    localObject = paramWindowInsets.a(left, top, right, bottom);
    left = ((f)localObject);
    boolean bool3 = right.equals(localObject);
    boolean bool2 = true;
    if (!bool3)
    {
      right = left;
      bool1 = true;
    }
    if (!mLastBaseContentInsets.equals(mBaseContentInsets))
    {
      mLastBaseContentInsets.set(mBaseContentInsets);
      bool1 = bool2;
    }
    if (bool1) {
      requestLayout();
    }
    return paramWindowInsets.e().c().a().unwrap();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    init(getContext());
    ViewCompat.requestApplyInsets(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    haltActionBarHideOffsetAnimations();
  }
  
  public void onDraw(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 0) {
      onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i = localView.getMeasuredWidth();
        int j = localView.getMeasuredHeight();
        int k = leftMargin + paramInt3;
        int m = topMargin + paramInt4;
        localView.layout(k, m, i + k, j + m);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    pullChildren();
    measureChildWithMargins(mActionBarTop, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)mActionBarTop.getLayoutParams();
    int i1 = Math.max(0, mActionBarTop.getMeasuredWidth() + leftMargin + rightMargin);
    int n = Math.max(0, mActionBarTop.getMeasuredHeight() + topMargin + bottomMargin);
    int m = View.combineMeasuredStates(0, mActionBarTop.getMeasuredState());
    if ((ViewCompat.setElevation(this) & 0x100) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      k = mActionBarHeight;
      i = k;
      if (mHasNonEmbeddedTabs)
      {
        i = k;
        if (mActionBarTop.getTabContainer() != null) {
          i = k + mActionBarHeight;
        }
      }
    }
    else if (mActionBarTop.getVisibility() != 8)
    {
      i = mActionBarTop.getMeasuredHeight();
    }
    else
    {
      i = 0;
    }
    mContentInsets.set(mBaseContentInsets);
    int k = Build.VERSION.SDK_INT;
    if (k >= 21) {
      y = left;
    } else {
      this$0.set(mBaseInnerInsets);
    }
    if ((!mOverlayMode) && (j == 0))
    {
      localObject = mContentInsets;
      top += i;
      bottom += 0;
      if (k >= 21) {
        y = y.a(0, i, 0, 0);
      }
    }
    else if (k >= 21)
    {
      localObject = Item.set(y.getHeight(), y.getSystemWindowInsetTop() + i, y.getWidth(), y.size() + 0);
      y = new n0.b(y).a((Item)localObject).a();
    }
    else
    {
      localObject = this$0;
      top += i;
      bottom += 0;
    }
    applyInsets(mContent, mContentInsets, true, true, true, true);
    if ((k >= 21) && (!x.equals(y)))
    {
      localObject = y;
      x = ((f)localObject);
      ViewCompat.b(mContent, (f)localObject);
    }
    else if ((k < 21) && (!mPosition.equals(this$0)))
    {
      mPosition.set(this$0);
      mContent.dispatchFitSystemWindows(this$0);
    }
    measureChildWithMargins(mContent, paramInt1, 0, paramInt2, 0);
    localObject = (LayoutParams)mContent.getLayoutParams();
    int i = Math.max(i1, mContent.getMeasuredWidth() + leftMargin + rightMargin);
    int j = Math.max(n, mContent.getMeasuredHeight() + topMargin + bottomMargin);
    k = View.combineMeasuredStates(m, mContent.getMeasuredState());
    m = getPaddingLeft();
    n = getPaddingRight();
    j = Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (m + n), getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((mHideOnContentScroll) && (paramBoolean))
    {
      if (shouldHideActionBarOnFling(paramFloat2)) {
        addActionBarHideOffset();
      } else {
        removeActionBarHideOffset();
      }
      mAnimatingForFling = true;
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = mHideOnContentScrollReference + paramInt2;
    mHideOnContentScrollReference = paramInt1;
    setActionBarHideOffset(paramInt1);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    mParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    mHideOnContentScrollReference = getActionBarHideOffset();
    haltActionBarHideOffsetAnimations();
    paramView1 = mActionBarVisibilityCallback;
    if (paramView1 != null) {
      paramView1.onContentScrollStarted();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) != 0) && (mActionBarTop.getVisibility() == 0)) {
      return mHideOnContentScroll;
    }
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((mHideOnContentScroll) && (!mAnimatingForFling)) {
      if (mHideOnContentScrollReference <= mActionBarTop.getHeight()) {
        postRemoveActionBarHideOffset();
      } else {
        postAddActionBarHideOffset();
      }
    }
    paramView = mActionBarVisibilityCallback;
    if (paramView != null) {
      paramView.onContentScrollStopped();
    }
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    pullChildren();
    int k = mLastSystemUiVisibility;
    mLastSystemUiVisibility = paramInt;
    int j = 0;
    int i;
    if ((paramInt & 0x4) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt & 0x100) != 0) {
      j = 1;
    }
    d localD = mActionBarVisibilityCallback;
    if (localD != null)
    {
      localD.enableContentAnimations(j ^ 0x1);
      if ((i == 0) && (j != 0)) {
        mActionBarVisibilityCallback.hideForSystem();
      } else {
        mActionBarVisibilityCallback.showForSystem();
      }
    }
    if ((((k ^ paramInt) & 0x100) != 0) && (mActionBarVisibilityCallback != null)) {
      ViewCompat.requestApplyInsets(this);
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    mWindowVisibility = paramInt;
    d localD = mActionBarVisibilityCallback;
    if (localD != null) {
      localD.onWindowVisibilityChanged(paramInt);
    }
  }
  
  public void performIntercept(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      onStopNestedScroll(paramView);
    }
  }
  
  public void performIntercept(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      onNestedScrollAccepted(paramView1, paramView2, paramInt1);
    }
  }
  
  void pullChildren()
  {
    if (mContent == null)
    {
      mContent = ((ContentFrameLayout)findViewById(R.id.action_bar_activity_content));
      mActionBarTop = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      mDecorToolbar = getDecorToolbar(findViewById(R.id.action_bar));
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    haltActionBarHideOffsetAnimations();
    paramInt = Math.max(0, Math.min(paramInt, mActionBarTop.getHeight()));
    mActionBarTop.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(d paramD)
  {
    mActionBarVisibilityCallback = paramD;
    if (getWindowToken() != null)
    {
      mActionBarVisibilityCallback.onWindowVisibilityChanged(mWindowVisibility);
      int i = mLastSystemUiVisibility;
      if (i != 0)
      {
        onWindowSystemUiVisibilityChanged(i);
        ViewCompat.requestApplyInsets(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    mHasNonEmbeddedTabs = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != mHideOnContentScroll)
    {
      mHideOnContentScroll = paramBoolean;
      if (!paramBoolean)
      {
        haltActionBarHideOffsetAnimations();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    pullChildren();
    mDecorToolbar.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    pullChildren();
    mDecorToolbar.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    pullChildren();
    mDecorToolbar.setLogo(paramInt);
  }
  
  public void setMenu(Menu paramMenu, l.a paramA)
  {
    pullChildren();
    mDecorToolbar.setMenu(paramMenu, paramA);
  }
  
  public void setMenuPrepared()
  {
    pullChildren();
    mDecorToolbar.setMenuPrepared();
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    mOverlayMode = paramBoolean;
    if ((paramBoolean) && (getContextgetApplicationInfotargetSdkVersion < 19)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    mIgnoreWindowContentOverlay = paramBoolean;
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    pullChildren();
    mDecorToolbar.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    pullChildren();
    mDecorToolbar.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public boolean showOverflowMenu()
  {
    pullChildren();
    return mDecorToolbar.showOverflowMenu();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      paramAnimator = ActionBarOverlayLayout.this;
      mCurrentActionBarTopAnimator = null;
      mAnimatingForFling = false;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = ActionBarOverlayLayout.this;
      mCurrentActionBarTopAnimator = null;
      mAnimatingForFling = false;
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      haltActionBarHideOffsetAnimations();
      ActionBarOverlayLayout localActionBarOverlayLayout = ActionBarOverlayLayout.this;
      mCurrentActionBarTopAnimator = mActionBarTop.animate().translationY(0.0F).setListener(mStartTime);
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      haltActionBarHideOffsetAnimations();
      ActionBarOverlayLayout localActionBarOverlayLayout = ActionBarOverlayLayout.this;
      mCurrentActionBarTopAnimator = mActionBarTop.animate().translationY(-mActionBarTop.getHeight()).setListener(mStartTime);
    }
  }
  
  public static abstract interface d
  {
    public abstract void enableContentAnimations(boolean paramBoolean);
    
    public abstract void hideForSystem();
    
    public abstract void onContentScrollStarted();
    
    public abstract void onContentScrollStopped();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
    
    public abstract void showForSystem();
  }
}
