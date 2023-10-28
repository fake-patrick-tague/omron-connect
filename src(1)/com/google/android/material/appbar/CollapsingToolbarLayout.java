package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.Label;
import com.google.android.material.internal.ViewGroupUtils;
import com.google.android.material.theme.utils.Effect;
import org.org.org.ui.ClassWriter;
import org.org.org.ui.R.id;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import org.org.org.ui.utils.AnimationUtils;
import v7.internal.R.style;
import v7.v7.package_13.MethodVisitor;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.f;
import v7.v7.widget.MathUtils;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  private static final int b = R.string.b;
  private long mAnimationDuration;
  final CollapsingTextHelper mCollapsingTextHelper;
  private boolean mCollapsingTitleEnabled;
  private Drawable mContentScrim;
  int mCurrentOffset;
  private boolean mDrawCollapsingTitle;
  private View mDummyView;
  private int mExpandedMarginBottom;
  private int mExpandedMarginEnd;
  private int mExpandedMarginStart;
  private int mExpandedMarginTop;
  f mLastInsets;
  private AppBarLayout.d mOnOffsetChangedListener;
  private int mPanelHeight = -1;
  private boolean mRefreshToolbar = true;
  private int mScrimAlpha;
  private ValueAnimator mScrimAnimator;
  private boolean mScrimsAreShown;
  Drawable mStatusBarScrim;
  private final Rect mTmpRect = new Rect();
  private ViewGroup mToolbar;
  private View mToolbarDirectChild;
  private int mToolbarId;
  
  public CollapsingToolbarLayout(android.content.Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, ClassWriter.v);
  }
  
  public CollapsingToolbarLayout(android.content.Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(Effect.a(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    android.content.Context localContext = getContext();
    paramContext = new CollapsingTextHelper(this);
    mCollapsingTextHelper = paramContext;
    paramContext.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
    paramAttributeSet = Label.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.CollapsingToolbarLayout, paramInt, i, new int[0]);
    paramContext.setExpandedTextGravity(paramAttributeSet.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388691));
    paramContext.setCollapsedTextGravity(paramAttributeSet.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 8388627));
    paramInt = paramAttributeSet.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
    mExpandedMarginBottom = paramInt;
    mExpandedMarginEnd = paramInt;
    mExpandedMarginTop = paramInt;
    mExpandedMarginStart = paramInt;
    paramInt = R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
    if (paramAttributeSet.hasValue(paramInt)) {
      mExpandedMarginStart = paramAttributeSet.getDimensionPixelSize(paramInt, 0);
    }
    paramInt = R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
    if (paramAttributeSet.hasValue(paramInt)) {
      mExpandedMarginEnd = paramAttributeSet.getDimensionPixelSize(paramInt, 0);
    }
    paramInt = R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
    if (paramAttributeSet.hasValue(paramInt)) {
      mExpandedMarginTop = paramAttributeSet.getDimensionPixelSize(paramInt, 0);
    }
    paramInt = R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
    if (paramAttributeSet.hasValue(paramInt)) {
      mExpandedMarginBottom = paramAttributeSet.getDimensionPixelSize(paramInt, 0);
    }
    mCollapsingTitleEnabled = paramAttributeSet.getBoolean(R.styleable.PagerSlidingTabStrip_pstsTabTextAllCaps, true);
    setTitle(paramAttributeSet.getText(R.styleable.Switch_bpTextOff));
    paramContext.a(R.string.l);
    paramContext.b(R.style.e);
    paramInt = R.styleable.NavigationView_headerLayout;
    if (paramAttributeSet.hasValue(paramInt)) {
      paramContext.a(paramAttributeSet.getResourceId(paramInt, 0));
    }
    paramInt = R.styleable.SlidingMenu_viewAbove;
    if (paramAttributeSet.hasValue(paramInt)) {
      paramContext.b(paramAttributeSet.getResourceId(paramInt, 0));
    }
    mPanelHeight = paramAttributeSet.getDimensionPixelSize(R.styleable.SlidingMenu_viewBehind, -1);
    paramInt = R.styleable.SlidingMenu_touchModeAbove;
    if (paramAttributeSet.hasValue(paramInt)) {
      paramContext.setText(paramAttributeSet.getInt(paramInt, 1));
    }
    mAnimationDuration = paramAttributeSet.getInt(R.styleable.SlidingMenu_touchModeBehind, 600);
    setContentScrim(paramAttributeSet.getDrawable(R.styleable.TitlePageIndicator_android_background));
    setStatusBarScrim(paramAttributeSet.getDrawable(R.styleable.StickyListHeadersListView_android_divider));
    mToolbarId = paramAttributeSet.getResourceId(R.styleable.DragSortListView_click_remove_id, -1);
    paramAttributeSet.recycle();
    setWillNotDraw(false);
    ViewCompat.b(this, new a());
  }
  
  private static CharSequence a(View paramView)
  {
    if ((paramView instanceof androidx.appcompat.widget.Toolbar)) {
      return ((androidx.appcompat.widget.Toolbar)paramView).getTitle();
    }
    if ((Build.VERSION.SDK_INT >= 21) && ((paramView instanceof android.widget.Toolbar))) {
      return ((android.widget.Toolbar)paramView).getTitle();
    }
    return null;
  }
  
  private void a()
  {
    setContentDescription(getTitle());
  }
  
  private void animateScrim(int paramInt)
  {
    ensureToolbar();
    Object localObject = mScrimAnimator;
    if (localObject == null)
    {
      localObject = new ValueAnimator();
      mScrimAnimator = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setDuration(mAnimationDuration);
      ValueAnimator localValueAnimator = mScrimAnimator;
      if (paramInt > mScrimAlpha) {
        localObject = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
      } else {
        localObject = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
      }
      localValueAnimator.setInterpolator((TimeInterpolator)localObject);
      mScrimAnimator.addUpdateListener(new b());
    }
    else if (((ValueAnimator)localObject).isRunning())
    {
      mScrimAnimator.cancel();
    }
    mScrimAnimator.setIntValues(new int[] { mScrimAlpha, paramInt });
    mScrimAnimator.start();
  }
  
  private boolean draw(View paramView)
  {
    View localView = mToolbarDirectChild;
    if ((localView != null) && (localView != this))
    {
      if (paramView == localView) {
        return true;
      }
    }
    else if (paramView == mToolbar) {
      return true;
    }
    return false;
  }
  
  private void ensureToolbar()
  {
    if (!mRefreshToolbar) {
      return;
    }
    Object localObject2 = null;
    mToolbar = null;
    mToolbarDirectChild = null;
    int i = mToolbarId;
    Object localObject1;
    if (i != -1)
    {
      localObject1 = (ViewGroup)findViewById(i);
      mToolbar = ((ViewGroup)localObject1);
      if (localObject1 != null) {
        mToolbarDirectChild = findDirectChild((View)localObject1);
      }
    }
    if (mToolbar == null)
    {
      int j = getChildCount();
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        localObject1 = getChildAt(i);
        if (evaluate((View)localObject1))
        {
          localObject1 = (ViewGroup)localObject1;
          break;
        }
        i += 1;
      }
      mToolbar = ((ViewGroup)localObject1);
    }
    updateDummyView();
    mRefreshToolbar = false;
  }
  
  private static boolean evaluate(View paramView)
  {
    return ((paramView instanceof androidx.appcompat.widget.Toolbar)) || ((Build.VERSION.SDK_INT >= 21) && ((paramView instanceof android.widget.Toolbar)));
  }
  
  private View findDirectChild(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != this) && (paramView != null); paramView = paramView.getParent()) {
      if ((paramView instanceof View)) {
        localView = (View)paramView;
      }
    }
    return localView;
  }
  
  private static int getHeightWithMargins(View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      return paramView.getMeasuredHeight() + topMargin + bottomMargin;
    }
    return paramView.getMeasuredHeight();
  }
  
  static ViewOffsetHelper getViewOffsetHelper(View paramView)
  {
    int i = R.id.view_offset_helper;
    ViewOffsetHelper localViewOffsetHelper2 = (ViewOffsetHelper)paramView.getTag(i);
    ViewOffsetHelper localViewOffsetHelper1 = localViewOffsetHelper2;
    if (localViewOffsetHelper2 == null)
    {
      localViewOffsetHelper1 = new ViewOffsetHelper(paramView);
      paramView.setTag(i, localViewOffsetHelper1);
    }
    return localViewOffsetHelper1;
  }
  
  private void onLayout(boolean paramBoolean)
  {
    Object localObject = mToolbarDirectChild;
    if (localObject == null) {
      localObject = mToolbar;
    }
    int i1 = getHeight((View)localObject);
    ViewGroupUtils.getDescendantRect(this, mDummyView, mTmpRect);
    localObject = mToolbar;
    boolean bool = localObject instanceof androidx.appcompat.widget.Toolbar;
    int i = 0;
    int j;
    int k;
    int m;
    if (bool)
    {
      localObject = (androidx.appcompat.widget.Toolbar)localObject;
      i = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginStart();
      j = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginEnd();
      k = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginTop();
      m = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginBottom();
    }
    else if ((Build.VERSION.SDK_INT >= 24) && ((localObject instanceof android.widget.Toolbar)))
    {
      localObject = (android.widget.Toolbar)localObject;
      i = ((android.widget.Toolbar)localObject).getTitleMarginStart();
      j = ((android.widget.Toolbar)localObject).getTitleMarginEnd();
      k = ((android.widget.Toolbar)localObject).getTitleMarginTop();
      m = ((android.widget.Toolbar)localObject).getTitleMarginBottom();
    }
    else
    {
      m = 0;
      j = 0;
      k = 0;
    }
    localObject = mCollapsingTextHelper;
    Rect localRect = mTmpRect;
    int i2 = left;
    int n;
    if (paramBoolean) {
      n = j;
    } else {
      n = i;
    }
    int i3 = top;
    int i4 = right;
    if (!paramBoolean) {
      i = j;
    }
    ((CollapsingTextHelper)localObject).setCollapsedBounds(i2 + n, i3 + i1 + k, i4 - i, bottom + i1 - m);
  }
  
  private void updateDummyView()
  {
    if (!mCollapsingTitleEnabled)
    {
      Object localObject = mDummyView;
      if (localObject != null)
      {
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(mDummyView);
        }
      }
    }
    if ((mCollapsingTitleEnabled) && (mToolbar != null))
    {
      if (mDummyView == null) {
        mDummyView = new View(getContext());
      }
      if (mDummyView.getParent() == null) {
        mToolbar.addView(mDummyView, -1, -1);
      }
    }
  }
  
  f a(f paramF)
  {
    f localF;
    if (ViewCompat.getFitsSystemWindows(this)) {
      localF = paramF;
    } else {
      localF = null;
    }
    if (!v7.v7.util.Context.equals(mLastInsets, localF))
    {
      mLastInsets = localF;
      requestLayout();
    }
    return paramF.c();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  final void draw()
  {
    if ((mContentScrim != null) || (mStatusBarScrim != null))
    {
      boolean bool;
      if (getHeight() + mCurrentOffset < getScrimVisibleHeightTrigger()) {
        bool = true;
      } else {
        bool = false;
      }
      setScrimsShown(bool);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    ensureToolbar();
    Object localObject;
    if (mToolbar == null)
    {
      localObject = mContentScrim;
      if ((localObject != null) && (mScrimAlpha > 0))
      {
        ((Drawable)localObject).mutate().setAlpha(mScrimAlpha);
        mContentScrim.draw(paramCanvas);
      }
    }
    if ((mCollapsingTitleEnabled) && (mDrawCollapsingTitle)) {
      mCollapsingTextHelper.draw(paramCanvas);
    }
    if ((mStatusBarScrim != null) && (mScrimAlpha > 0))
    {
      localObject = mLastInsets;
      int i;
      if (localObject != null) {
        i = ((f)localObject).getSystemWindowInsetTop();
      } else {
        i = 0;
      }
      if (i > 0)
      {
        mStatusBarScrim.setBounds(0, -mCurrentOffset, getWidth(), i - mCurrentOffset);
        mStatusBarScrim.mutate().setAlpha(mScrimAlpha);
        mStatusBarScrim.draw(paramCanvas);
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i;
    if ((mContentScrim != null) && (mScrimAlpha > 0) && (draw(paramView)))
    {
      mContentScrim.mutate().setAlpha(mScrimAlpha);
      mContentScrim.draw(paramCanvas);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (!super.drawChild(paramCanvas, paramView, paramLong)) {
      return i != 0;
    }
    return true;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Object localObject = mStatusBarScrim;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Drawable)localObject).isStateful()) {
        bool1 = false | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = mContentScrim;
    bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((Drawable)localObject).isStateful()) {
        bool2 = bool1 | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = mCollapsingTextHelper;
    bool1 = bool2;
    if (localObject != null) {
      bool1 = bool2 | ((CollapsingTextHelper)localObject).setText(arrayOfInt);
    }
    if (bool1) {
      invalidate();
    }
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getCollapsedTitleGravity()
  {
    return mCollapsingTextHelper.getCollapsedTextGravity();
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    return mCollapsingTextHelper.getCollapsedTypeface();
  }
  
  public Drawable getContentScrim()
  {
    return mContentScrim;
  }
  
  public int getExpandedTitleGravity()
  {
    return mCollapsingTextHelper.getExpandedTextGravity();
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return mExpandedMarginBottom;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return mExpandedMarginEnd;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return mExpandedMarginStart;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return mExpandedMarginTop;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    return mCollapsingTextHelper.getExpandedTypeface();
  }
  
  final int getHeight(View paramView)
  {
    ViewOffsetHelper localViewOffsetHelper = getViewOffsetHelper(paramView);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    return getHeight() - localViewOffsetHelper.getLeftAndRightOffset() - paramView.getHeight() - bottomMargin;
  }
  
  public int getMaxLines()
  {
    return mCollapsingTextHelper.getTypeface();
  }
  
  int getScrimAlpha()
  {
    return mScrimAlpha;
  }
  
  public long getScrimAnimationDuration()
  {
    return mAnimationDuration;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    int i = mPanelHeight;
    if (i >= 0) {
      return i;
    }
    f localF = mLastInsets;
    if (localF != null) {
      i = localF.getSystemWindowInsetTop();
    } else {
      i = 0;
    }
    int j = ViewCompat.getMinimumHeight(this);
    if (j > 0) {
      return Math.min(j * 2 + i, getHeight());
    }
    return getHeight() / 3;
  }
  
  public Drawable getStatusBarScrim()
  {
    return mStatusBarScrim;
  }
  
  public CharSequence getTitle()
  {
    if (mCollapsingTitleEnabled) {
      return mCollapsingTextHelper.getText();
    }
    return null;
  }
  
  protected FrameLayout.LayoutParams init(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View)localViewParent));
      if (mOnOffsetChangedListener == null) {
        mOnOffsetChangedListener = new c();
      }
      ((AppBarLayout)localViewParent).onAttachedToWindow(mOnOffsetChangedListener);
      ViewCompat.requestApplyInsets(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    ViewParent localViewParent = getParent();
    AppBarLayout.d localD = mOnOffsetChangedListener;
    if ((localD != null) && ((localViewParent instanceof AppBarLayout))) {
      ((AppBarLayout)localViewParent).onLayout(localD);
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = mLastInsets;
    int k = 0;
    int m;
    if (localObject != null)
    {
      j = ((f)localObject).getSystemWindowInsetTop();
      m = getChildCount();
      i = 0;
      while (i < m)
      {
        localObject = getChildAt(i);
        if ((!ViewCompat.getFitsSystemWindows((View)localObject)) && (((View)localObject).getTop() < j)) {
          ViewCompat.offsetTopAndBottom((View)localObject, j);
        }
        i += 1;
      }
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getViewOffsetHelper(getChildAt(i)).onViewLayout();
      i += 1;
    }
    if (mCollapsingTitleEnabled)
    {
      localObject = mDummyView;
      if (localObject != null)
      {
        paramBoolean = ViewCompat.d((View)localObject);
        boolean bool = true;
        if ((paramBoolean) && (mDummyView.getVisibility() == 0)) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        mDrawCollapsingTitle = paramBoolean;
        if (paramBoolean)
        {
          if (ViewCompat.getLayoutDirection(this) == 1) {
            paramBoolean = bool;
          } else {
            paramBoolean = false;
          }
          onLayout(paramBoolean);
          localObject = mCollapsingTextHelper;
          if (paramBoolean) {
            i = mExpandedMarginEnd;
          } else {
            i = mExpandedMarginStart;
          }
          m = mTmpRect.top;
          int n = mExpandedMarginTop;
          if (paramBoolean) {
            j = mExpandedMarginStart;
          } else {
            j = mExpandedMarginEnd;
          }
          ((CollapsingTextHelper)localObject).setExpandedBounds(i, m + n, paramInt3 - paramInt1 - j, paramInt4 - paramInt2 - mExpandedMarginBottom);
          mCollapsingTextHelper.recalculate();
        }
      }
    }
    if ((mToolbar != null) && (mCollapsingTitleEnabled) && (TextUtils.isEmpty(mCollapsingTextHelper.getText()))) {
      setTitle(a(mToolbar));
    }
    draw();
    paramInt2 = getChildCount();
    paramInt1 = k;
    while (paramInt1 < paramInt2)
    {
      getViewOffsetHelper(getChildAt(paramInt1)).updateOffsets();
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ensureToolbar();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    Object localObject = mLastInsets;
    if (localObject != null) {
      paramInt2 = ((f)localObject).getSystemWindowInsetTop();
    } else {
      paramInt2 = 0;
    }
    if ((i == 0) && (paramInt2 > 0)) {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + paramInt2, 1073741824));
    }
    localObject = mToolbar;
    if (localObject != null)
    {
      View localView = mToolbarDirectChild;
      if ((localView != null) && (localView != this))
      {
        setMinimumHeight(getHeightWithMargins(localView));
        return;
      }
      setMinimumHeight(getHeightWithMargins((View)localObject));
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable = mContentScrim;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    mCollapsingTextHelper.setCollapsedTextGravity(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    mCollapsingTextHelper.b(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    mCollapsingTextHelper.setCollapsedTextColor(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    mCollapsingTextHelper.setCollapsedTypeface(paramTypeface);
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable2 = mContentScrim;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      mContentScrim = localDrawable1;
      if (localDrawable1 != null)
      {
        localDrawable1.setBounds(0, 0, getWidth(), getHeight());
        mContentScrim.setCallback(this);
        mContentScrim.setAlpha(mScrimAlpha);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setContentScrimColor(int paramInt)
  {
    setContentScrim(new ColorDrawable(paramInt));
  }
  
  public void setContentScrimResource(int paramInt)
  {
    setContentScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setExpandedTitleColor(int paramInt)
  {
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setExpandedTitleGravity(int paramInt)
  {
    mCollapsingTextHelper.setExpandedTextGravity(paramInt);
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    mExpandedMarginBottom = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    mExpandedMarginEnd = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    mExpandedMarginStart = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    mExpandedMarginTop = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    mCollapsingTextHelper.a(paramInt);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    mCollapsingTextHelper.setExpandedTextColor(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    mCollapsingTextHelper.setExpandedTypeface(paramTypeface);
  }
  
  public void setMaxLines(int paramInt)
  {
    mCollapsingTextHelper.setText(paramInt);
  }
  
  void setScrimAlpha(int paramInt)
  {
    if (paramInt != mScrimAlpha)
    {
      if (mContentScrim != null)
      {
        ViewGroup localViewGroup = mToolbar;
        if (localViewGroup != null) {
          ViewCompat.postInvalidateOnAnimation(localViewGroup);
        }
      }
      mScrimAlpha = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    mAnimationDuration = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    if (mPanelHeight != paramInt)
    {
      mPanelHeight = paramInt;
      draw();
    }
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    boolean bool;
    if ((ViewCompat.set(this)) && (!isInEditMode())) {
      bool = true;
    } else {
      bool = false;
    }
    setScrimsShown(paramBoolean, bool);
  }
  
  public void setScrimsShown(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mScrimsAreShown != paramBoolean1)
    {
      int i = 255;
      if (paramBoolean2)
      {
        if (!paramBoolean1) {
          i = 0;
        }
        animateScrim(i);
      }
      else
      {
        if (!paramBoolean1) {
          i = 0;
        }
        setScrimAlpha(i);
      }
      mScrimsAreShown = paramBoolean1;
    }
  }
  
  public void setStatusBarScrim(Drawable paramDrawable)
  {
    Drawable localDrawable2 = mStatusBarScrim;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      mStatusBarScrim = localDrawable1;
      if (localDrawable1 != null)
      {
        if (localDrawable1.isStateful()) {
          mStatusBarScrim.setState(getDrawableState());
        }
        DrawableCompat.a(mStatusBarScrim, ViewCompat.getLayoutDirection(this));
        paramDrawable = mStatusBarScrim;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        mStatusBarScrim.setCallback(this);
        mStatusBarScrim.setAlpha(mScrimAlpha);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setStatusBarScrimColor(int paramInt)
  {
    setStatusBarScrim(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarScrimResource(int paramInt)
  {
    setStatusBarScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mCollapsingTextHelper.setText(paramCharSequence);
    a();
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != mCollapsingTitleEnabled)
    {
      mCollapsingTitleEnabled = paramBoolean;
      a();
      updateDummyView();
      requestLayout();
    }
  }
  
  protected LayoutParams setVisibility()
  {
    return new LayoutParams(-1, -1);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = mStatusBarScrim;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      mStatusBarScrim.setVisible(bool, false);
    }
    localDrawable = mContentScrim;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      mContentScrim.setVisible(bool, false);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == mContentScrim) || (paramDrawable == mStatusBarScrim);
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    int mCollapseMode = 0;
    float mParallaxMult = 0.5F;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(android.content.Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout);
      mCollapseMode = paramContext.getInt(R.styleable.FlowLayout_Layout_android_layout_gravity, 0);
      setParallaxMultiplier(paramContext.getFloat(R.styleable.DragSortListView_drag_scroll_start, 0.5F));
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public void setParallaxMultiplier(float paramFloat)
    {
      mParallaxMult = paramFloat;
    }
  }
  
  class a
    implements MethodVisitor
  {
    a() {}
    
    public f a(View paramView, f paramF)
    {
      return a(paramF);
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      setScrimAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
  
  private class c
    implements AppBarLayout.d
  {
    c() {}
    
    public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      paramAppBarLayout = CollapsingToolbarLayout.this;
      mCurrentOffset = paramInt;
      paramAppBarLayout = mLastInsets;
      int i;
      if (paramAppBarLayout != null) {
        i = paramAppBarLayout.getSystemWindowInsetTop();
      } else {
        i = 0;
      }
      Object localObject1 = CollapsingToolbarLayout.this;
      paramAppBarLayout = this;
      int k = ((ViewGroup)localObject1).getChildCount();
      int j = 0;
      while (j < k)
      {
        Object localObject2 = this$0;
        localObject1 = paramAppBarLayout;
        localObject2 = ((ViewGroup)localObject2).getChildAt(j);
        CollapsingToolbarLayout.LayoutParams localLayoutParams = (CollapsingToolbarLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ViewOffsetHelper localViewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper((View)localObject2);
        int m = mCollapseMode;
        if (m != 1)
        {
          if (m == 2) {
            localViewOffsetHelper.setTopAndBottomOffset(Math.round(-paramInt * mParallaxMult));
          }
        }
        else {
          localViewOffsetHelper.setTopAndBottomOffset(MathUtils.constrain(-paramInt, 0, this$0.getHeight((View)localObject2)));
        }
        j += 1;
      }
      this$0.draw();
      localObject1 = this$0;
      if ((mStatusBarScrim != null) && (i > 0)) {
        ViewCompat.postInvalidateOnAnimation((View)localObject1);
      }
      j = this$0.getHeight();
      k = ViewCompat.getMinimumHeight(this$0);
      this$0.mCollapsingTextHelper.setExpansionFraction(Math.abs(paramInt) / (j - k - i));
    }
  }
}
