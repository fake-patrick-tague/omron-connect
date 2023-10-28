package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.l.a;
import androidx.appcompat.view.menu.p;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import v7.internal.R.attr;
import v7.internal.R.styleable;
import v7.internal.view.CollapsibleActionView;
import v7.internal.view.SupportMenuInflater;
import v7.v7.package_13.GravityCompat;
import v7.v7.package_13.Log;
import v7.v7.package_13.Translation;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.h;
import v7.v7.package_13.i;

public class Toolbar
  extends ViewGroup
  implements Translation
{
  private ArrayList<MenuItem> a = new ArrayList();
  private int after;
  private int before;
  final i c = new i(new MonthByWeekFragment.2(this));
  private l.a mActionMenuPresenterCallback;
  int mButtonGravity;
  MenuBuilder.Callback mCallback;
  ImageButton mCollapseButtonView;
  private CharSequence mCollapseDescription;
  private Drawable mCollapseIcon;
  private boolean mCollapsible;
  private RtlSpacingHelper mContentInsets;
  private boolean mEatingHover;
  private boolean mEatingTouch;
  android.view.View mExpandedActionView;
  private f mExpandedMenuPresenter;
  private int mGravity = 8388627;
  private final ArrayList<android.view.View> mHiddenViews = new ArrayList();
  private ImageView mLogoView;
  private int mMaxButtonHeight;
  g mMenuItemClickListener;
  ActionMenuView mMenuView;
  private final ActionMenuView.d mMenuViewItemClickListener = new a();
  private ImageButton mNavButtonView;
  private ActionMenuPresenter mOuterActionMenuPresenter;
  private Context mPopupContext;
  private int mPopupTheme;
  private final Runnable mShowOverflowMenuRunnable = new b();
  private CharSequence mSubtitleText;
  private int mSubtitleTextAppearance;
  private ColorStateList mSubtitleTextColor;
  private TextView mSubtitleTextView;
  private final int[] mTempMargins = new int[2];
  private final ArrayList<android.view.View> mTempViews = new ArrayList();
  private int mTitleMarginBottom;
  private int mTitleMarginEnd;
  private int mTitleMarginStart;
  private int mTitleMarginTop;
  private CharSequence mTitleText;
  private int mTitleTextAppearance;
  private ColorStateList mTitleTextColor;
  private TextView mTitleTextView;
  private ToolbarWidgetWrapper mWrapper;
  private OnBackInvokedCallback q;
  private boolean v;
  private OnBackInvokedDispatcher x;
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.seekBarPreferenceStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getContext();
    int[] arrayOfInt = R.styleable.Toolbar;
    localObject = TintTypedArray.obtainStyledAttributes((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    ViewCompat.obtainStyledAttributes(this, paramContext, arrayOfInt, paramAttributeSet, ((TintTypedArray)localObject).getResourceId(), paramInt, 0);
    mTitleTextAppearance = ((TintTypedArray)localObject).getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
    mSubtitleTextAppearance = ((TintTypedArray)localObject).getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
    mGravity = ((TintTypedArray)localObject).getInteger(R.styleable.Toolbar_android_gravity, mGravity);
    mButtonGravity = ((TintTypedArray)localObject).getInteger(R.styleable.MaterialRippleLayout_mrl_rippleFadeDuration, 48);
    int i = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.MaterialRippleLayout_mrl_rippleBackground, 0);
    paramInt = i;
    int j = R.styleable.MaterialRippleLayout_mrl_ripplePersistent;
    if (((TintTypedArray)localObject).hasValue(j)) {
      paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(j, i);
    }
    mTitleMarginBottom = paramInt;
    mTitleMarginTop = paramInt;
    mTitleMarginEnd = paramInt;
    mTitleMarginStart = paramInt;
    paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.MaterialRippleLayout_mrl_rippleInAdapter, -1);
    if (paramInt >= 0) {
      mTitleMarginStart = paramInt;
    }
    paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      mTitleMarginEnd = paramInt;
    }
    paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      mTitleMarginTop = paramInt;
    }
    paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, -1);
    if (paramInt >= 0) {
      mTitleMarginBottom = paramInt;
    }
    mMaxButtonHeight = ((TintTypedArray)localObject).getDimensionPixelSize(R.styleable.Toolbar_titleMarginStart, -1);
    paramInt = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, Integer.MIN_VALUE);
    i = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
    j = ((TintTypedArray)localObject).getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
    int k = ((TintTypedArray)localObject).getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
    setSubtitle();
    mContentInsets.setAbsolute(j, k);
    if ((paramInt != Integer.MIN_VALUE) || (i != Integer.MIN_VALUE)) {
      mContentInsets.setRelative(paramInt, i);
    }
    after = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_collapseIcon, Integer.MIN_VALUE);
    before = ((TintTypedArray)localObject).getDimensionPixelOffset(R.styleable.Toolbar_collapseContentDescription, Integer.MIN_VALUE);
    mCollapseIcon = ((TintTypedArray)localObject).getDrawable(R.styleable.Toolbar_title);
    mCollapseDescription = ((TintTypedArray)localObject).getText(R.styleable.Toolbar_subtitle);
    paramContext = ((TintTypedArray)localObject).getText(R.styleable.Toolbar_popupTheme);
    if (!android.text.TextUtils.isEmpty(paramContext)) {
      setTitle(paramContext);
    }
    paramContext = ((TintTypedArray)localObject).getText(R.styleable.Toolbar_navigationIcon);
    if (!android.text.TextUtils.isEmpty(paramContext)) {
      setSubtitle(paramContext);
    }
    mPopupContext = getContext();
    setPopupTheme(((TintTypedArray)localObject).getResourceId(R.styleable.Toolbar_navigationContentDescription, 0));
    paramContext = ((TintTypedArray)localObject).getDrawable(R.styleable.Toolbar_logo);
    if (paramContext != null) {
      setNavigationIcon(paramContext);
    }
    paramContext = ((TintTypedArray)localObject).getText(R.styleable.Toolbar_logoDescription);
    if (!android.text.TextUtils.isEmpty(paramContext)) {
      setNavigationContentDescription(paramContext);
    }
    paramContext = ((TintTypedArray)localObject).getDrawable(R.styleable.Toolbar_titleTextColor);
    if (paramContext != null) {
      setLogo(paramContext);
    }
    paramContext = ((TintTypedArray)localObject).getText(R.styleable.Toolbar_subtitleTextColor);
    if (!android.text.TextUtils.isEmpty(paramContext)) {
      setLogoDescription(paramContext);
    }
    paramInt = R.styleable.TabLayout_tabSelectedTextColor;
    if (((TintTypedArray)localObject).hasValue(paramInt)) {
      setTitleTextColor(((TintTypedArray)localObject).getColor(paramInt));
    }
    paramInt = R.styleable.SnackbarLayout_elevation;
    if (((TintTypedArray)localObject).hasValue(paramInt)) {
      setSubtitleTextColor(((TintTypedArray)localObject).getColor(paramInt));
    }
    paramInt = R.styleable.NavigationView_headerLayout;
    if (((TintTypedArray)localObject).hasValue(paramInt)) {
      inflateMenu(((TintTypedArray)localObject).getResourceId(paramInt, 0));
    }
    ((TintTypedArray)localObject).recycle();
  }
  
  private void addCustomViewsWithGravity(List paramList, int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    int j = 0;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int m = getChildCount();
    int k = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    paramList.clear();
    paramInt = j;
    android.view.View localView;
    LayoutParams localLayoutParams;
    if (i != 0)
    {
      paramInt = m - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((mViewType == 0) && (shouldLayout(localView)) && (getChildHorizontalGravity(gravity) == k)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
    }
    while (paramInt < m)
    {
      localView = getChildAt(paramInt);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((mViewType == 0) && (shouldLayout(localView)) && (getChildHorizontalGravity(gravity) == k)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private void addSystemView(android.view.View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = generateLayoutParams();
    } else if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
      localObject = updateEditTextMargin((ViewGroup.LayoutParams)localObject);
    } else {
      localObject = (LayoutParams)localObject;
    }
    mViewType = 1;
    if ((paramBoolean) && (mExpandedActionView != null))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      mHiddenViews.add(paramView);
      return;
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void ensureLogoView()
  {
    if (mLogoView == null) {
      mLogoView = new AppCompatImageView(getContext());
    }
  }
  
  private void ensureMenu()
  {
    ensureMenuView();
    if (mMenuView.peekMenu() == null)
    {
      f localF = (f)mMenuView.getMenu();
      if (mExpandedMenuPresenter == null) {
        mExpandedMenuPresenter = new f();
      }
      mMenuView.setExpandedActionViewsExclusive(true);
      localF.addMenuPresenter(mExpandedMenuPresenter, mPopupContext);
      a();
    }
  }
  
  private void ensureMenuView()
  {
    if (mMenuView == null)
    {
      Object localObject = new ActionMenuView(getContext());
      mMenuView = ((ActionMenuView)localObject);
      ((ActionMenuView)localObject).setPopupTheme(mPopupTheme);
      mMenuView.setOnMenuItemClickListener(mMenuViewItemClickListener);
      mMenuView.setMenuCallbacks(mActionMenuPresenterCallback, new c());
      localObject = generateLayoutParams();
      gravity = (0x800005 | mButtonGravity & 0x70);
      mMenuView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addSystemView(mMenuView, false);
    }
  }
  
  private void ensureNavButtonView()
  {
    if (mNavButtonView == null)
    {
      mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      LayoutParams localLayoutParams = generateLayoutParams();
      gravity = (0x800003 | mButtonGravity & 0x70);
      mNavButtonView.setLayoutParams(localLayoutParams);
    }
  }
  
  private int getChildHorizontalGravity(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, i) & 0x7;
    if ((paramInt != 1) && (paramInt != 3) && (paramInt != 5))
    {
      if (i == 1) {
        return 5;
      }
    }
    else {
      return paramInt;
    }
    return 3;
  }
  
  private int getChildTop(android.view.View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = paramView.getMeasuredHeight();
    if (paramInt > 0) {
      paramInt = (j - paramInt) / 2;
    } else {
      paramInt = 0;
    }
    int i = getChildVerticalGravity(gravity);
    if (i != 48)
    {
      if (i != 80)
      {
        int k = getPaddingTop();
        int m = getPaddingBottom();
        int n = getHeight();
        i = (n - k - m - j) / 2;
        paramInt = topMargin;
        if (i >= paramInt)
        {
          j = n - m - j - i - k;
          m = bottomMargin;
          paramInt = i;
          if (j < m) {
            paramInt = Math.max(0, i - (m - j));
          }
        }
        return k + paramInt;
      }
      return getHeight() - getPaddingBottom() - j - bottomMargin - paramInt;
    }
    return getPaddingTop() - paramInt;
  }
  
  private int getChildVerticalGravity(int paramInt)
  {
    int i = paramInt & 0x70;
    paramInt = i;
    if (i != 16)
    {
      paramInt = i;
      if (i != 48)
      {
        paramInt = i;
        if (i != 80) {
          paramInt = mGravity & 0x70;
        }
      }
    }
    return paramInt;
  }
  
  private ArrayList getCurrentMenuItems()
  {
    ArrayList localArrayList = new ArrayList();
    Menu localMenu = getMenu();
    int i = 0;
    while (i < localMenu.size())
    {
      localArrayList.add(localMenu.getItem(i));
      i += 1;
    }
    return localArrayList;
  }
  
  private int getHorizontalMargins(android.view.View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return Log.getLayoutDirection(paramView) + Log.getMarginEnd(paramView);
  }
  
  private MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(getContext());
  }
  
  private int getVerticalMargins(android.view.View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return topMargin + bottomMargin;
  }
  
  private int getViewListMeasuredWidth(List paramList, int[] paramArrayOfInt)
  {
    int m = paramArrayOfInt[0];
    int k = paramArrayOfInt[1];
    int n = paramList.size();
    int i = 0;
    int j = 0;
    while (i < n)
    {
      paramArrayOfInt = (android.view.View)paramList.get(i);
      LayoutParams localLayoutParams = (LayoutParams)paramArrayOfInt.getLayoutParams();
      m = leftMargin - m;
      k = rightMargin - k;
      int i1 = Math.max(0, m);
      int i2 = Math.max(0, k);
      m = Math.max(0, -m);
      k = Math.max(0, -k);
      j += i1 + paramArrayOfInt.getMeasuredWidth() + i2;
      i += 1;
    }
    return j;
  }
  
  private boolean isChildOrHidden(android.view.View paramView)
  {
    return (paramView.getParent() == this) || (mHiddenViews.contains(paramView));
  }
  
  private int layoutChildLeft(android.view.View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = leftMargin - paramArrayOfInt[0];
    paramInt1 += Math.max(0, i);
    paramArrayOfInt[0] = Math.max(0, -i);
    paramInt2 = getChildTop(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 + (i + rightMargin);
  }
  
  private int layoutChildRight(android.view.View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    paramInt2 = getChildTop(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (i + leftMargin);
  }
  
  private int measureChildCollapseMargins(android.view.View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = leftMargin - paramArrayOfInt[0];
    int j = rightMargin - paramArrayOfInt[1];
    int k = Math.max(0, i) + Math.max(0, j);
    paramArrayOfInt[0] = Math.max(0, -i);
    paramArrayOfInt[1] = Math.max(0, -j);
    paramView.measure(ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + k + paramInt2, width), ViewGroup.getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + topMargin + bottomMargin + paramInt4, height));
    return paramView.getMeasuredWidth() + k;
  }
  
  private void measureChildConstrained(android.view.View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin + paramInt2, width);
    paramInt3 = ViewGroup.getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + topMargin + bottomMargin + paramInt4, height);
    paramInt1 = paramInt3;
    paramInt4 = View.MeasureSpec.getMode(paramInt3);
    paramInt2 = paramInt1;
    if (paramInt4 != 1073741824)
    {
      paramInt2 = paramInt1;
      if (paramInt5 >= 0)
      {
        paramInt1 = paramInt5;
        if (paramInt4 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt3), paramInt5);
        }
        paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i, paramInt2);
  }
  
  private void postShowOverflowMenu()
  {
    removeCallbacks(mShowOverflowMenuRunnable);
    post(mShowOverflowMenuRunnable);
  }
  
  private void setSubtitle()
  {
    if (mContentInsets == null) {
      mContentInsets = new RtlSpacingHelper();
    }
  }
  
  private void setTitle()
  {
    Object localObject = getMenu();
    ArrayList localArrayList = getCurrentMenuItems();
    c.a((Menu)localObject, getMenuInflater());
    localObject = getCurrentMenuItems();
    ((ArrayList)localObject).removeAll(localArrayList);
    a = ((ArrayList)localObject);
  }
  
  private boolean shouldCollapse()
  {
    if (!mCollapsible) {
      return false;
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      android.view.View localView = getChildAt(i);
      if ((shouldLayout(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean shouldLayout(android.view.View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  void a()
  {
    if (Build.VERSION.SDK_INT >= 33)
    {
      OnBackInvokedDispatcher localOnBackInvokedDispatcher = e.a(this);
      int i;
      if ((hasExpandedActionView()) && (localOnBackInvokedDispatcher != null) && (ViewCompat.d(this)) && (v)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (x == null))
      {
        if (q == null) {
          q = e.a(new NumberPicker.BeginSoftInputOnLongPressCommand(this));
        }
        e.put(localOnBackInvokedDispatcher, q);
        x = localOnBackInvokedDispatcher;
        return;
      }
      if (i == 0)
      {
        localOnBackInvokedDispatcher = x;
        if (localOnBackInvokedDispatcher != null)
        {
          e.append(localOnBackInvokedDispatcher, q);
          x = null;
        }
      }
    }
  }
  
  void addChildrenForExpandedActionView()
  {
    int i = mHiddenViews.size() - 1;
    while (i >= 0)
    {
      addView((android.view.View)mHiddenViews.get(i));
      i -= 1;
    }
    mHiddenViews.clear();
  }
  
  public void addMenuProvider(h paramH)
  {
    c.l(paramH);
  }
  
  public boolean canShowOverflowMenu()
  {
    if (getVisibility() == 0)
    {
      ActionMenuView localActionMenuView = mMenuView;
      if ((localActionMenuView != null) && (localActionMenuView.isOverflowReserved())) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public void collapseActionView()
  {
    Object localObject = mExpandedMenuPresenter;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = mCurrentExpandedItem;
    }
    if (localObject != null) {
      ((MenuItemImpl)localObject).collapseActionView();
    }
  }
  
  public void dismissPopupMenus()
  {
    ActionMenuView localActionMenuView = mMenuView;
    if (localActionMenuView != null) {
      localActionMenuView.dismissPopupMenus();
    }
  }
  
  void ensureCollapseButtonView()
  {
    if (mCollapseButtonView == null)
    {
      Object localObject = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      mCollapseButtonView = ((ImageButton)localObject);
      ((ImageView)localObject).setImageDrawable(mCollapseIcon);
      mCollapseButtonView.setContentDescription(mCollapseDescription);
      localObject = generateLayoutParams();
      gravity = (0x800003 | mButtonGravity & 0x70);
      mViewType = 2;
      mCollapseButtonView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      mCollapseButtonView.setOnClickListener(new d());
    }
  }
  
  protected LayoutParams generateLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public CharSequence getCollapseContentDescription()
  {
    ImageButton localImageButton = mCollapseButtonView;
    if (localImageButton != null) {
      return localImageButton.getContentDescription();
    }
    return null;
  }
  
  public Drawable getCollapseIcon()
  {
    ImageButton localImageButton = mCollapseButtonView;
    if (localImageButton != null) {
      return localImageButton.getDrawable();
    }
    return null;
  }
  
  public int getContentInsetEnd()
  {
    RtlSpacingHelper localRtlSpacingHelper = mContentInsets;
    if (localRtlSpacingHelper != null) {
      return localRtlSpacingHelper.getEnd();
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    int i = before;
    if (i != Integer.MIN_VALUE) {
      return i;
    }
    return getContentInsetEnd();
  }
  
  public int getContentInsetLeft()
  {
    RtlSpacingHelper localRtlSpacingHelper = mContentInsets;
    if (localRtlSpacingHelper != null) {
      return localRtlSpacingHelper.getLeft();
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    RtlSpacingHelper localRtlSpacingHelper = mContentInsets;
    if (localRtlSpacingHelper != null) {
      return localRtlSpacingHelper.getRight();
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    RtlSpacingHelper localRtlSpacingHelper = mContentInsets;
    if (localRtlSpacingHelper != null) {
      return localRtlSpacingHelper.getStart();
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    int i = after;
    if (i != Integer.MIN_VALUE) {
      return i;
    }
    return getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd()
  {
    Object localObject = mMenuView;
    if (localObject != null)
    {
      localObject = ((ActionMenuView)localObject).peekMenu();
      if ((localObject != null) && (((f)localObject).hasVisibleItems()))
      {
        i = 1;
        break label32;
      }
    }
    int i = 0;
    label32:
    if (i != 0) {
      return Math.max(getContentInsetEnd(), Math.max(before, 0));
    }
    return getContentInsetEnd();
  }
  
  public int getCurrentContentInsetLeft()
  {
    if (ViewCompat.getLayoutDirection(this) == 1) {
      return getCurrentContentInsetEnd();
    }
    return getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight()
  {
    if (ViewCompat.getLayoutDirection(this) == 1) {
      return getCurrentContentInsetStart();
    }
    return getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart()
  {
    if (getNavigationIcon() != null) {
      return Math.max(getContentInsetStart(), Math.max(after, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    ImageView localImageView = mLogoView;
    if (localImageView != null) {
      return localImageView.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    ImageView localImageView = mLogoView;
    if (localImageView != null) {
      return localImageView.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    ensureMenu();
    return mMenuView.getMenu();
  }
  
  android.view.View getNavButtonView()
  {
    return mNavButtonView;
  }
  
  public CharSequence getNavigationContentDescription()
  {
    ImageButton localImageButton = mNavButtonView;
    if (localImageButton != null) {
      return localImageButton.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    ImageButton localImageButton = mNavButtonView;
    if (localImageButton != null) {
      return localImageButton.getDrawable();
    }
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return mOuterActionMenuPresenter;
  }
  
  public Drawable getOverflowIcon()
  {
    ensureMenu();
    return mMenuView.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return mPopupContext;
  }
  
  public int getPopupTheme()
  {
    return mPopupTheme;
  }
  
  public CharSequence getSubtitle()
  {
    return mSubtitleText;
  }
  
  final TextView getSubtitleTextView()
  {
    return mSubtitleTextView;
  }
  
  public CharSequence getTitle()
  {
    return mTitleText;
  }
  
  public int getTitleMarginBottom()
  {
    return mTitleMarginBottom;
  }
  
  public int getTitleMarginEnd()
  {
    return mTitleMarginEnd;
  }
  
  public int getTitleMarginStart()
  {
    return mTitleMarginStart;
  }
  
  public int getTitleMarginTop()
  {
    return mTitleMarginTop;
  }
  
  final TextView getTitleTextView()
  {
    return mTitleTextView;
  }
  
  public DecorToolbar getWrapper()
  {
    if (mWrapper == null) {
      mWrapper = new ToolbarWidgetWrapper(this, true);
    }
    return mWrapper;
  }
  
  public boolean hasExpandedActionView()
  {
    f localF = mExpandedMenuPresenter;
    return (localF != null) && (mCurrentExpandedItem != null);
  }
  
  public boolean hideOverflowMenu()
  {
    ActionMenuView localActionMenuView = mMenuView;
    return (localActionMenuView != null) && (localActionMenuView.hideOverflowMenu());
  }
  
  public void inflateMenu(int paramInt)
  {
    getMenuInflater().inflate(paramInt, getMenu());
  }
  
  public boolean isOverflowMenuShowPending()
  {
    ActionMenuView localActionMenuView = mMenuView;
    return (localActionMenuView != null) && (localActionMenuView.isOverflowMenuShowPending());
  }
  
  public boolean isOverflowMenuShowing()
  {
    ActionMenuView localActionMenuView = mMenuView;
    return (localActionMenuView != null) && (localActionMenuView.isOverflowMenuShowing());
  }
  
  public LayoutParams loadFromAttributes(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(mShowOverflowMenuRunnable);
    a();
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      mEatingHover = false;
    }
    if (!mEatingHover)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        mEatingHover = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      mEatingHover = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (ViewCompat.getLayoutDirection(this) == 1) {
      k = 1;
    } else {
      k = 0;
    }
    int i1 = getWidth();
    int i4 = getHeight();
    paramInt3 = getPaddingLeft();
    int i2 = getPaddingRight();
    int i3 = getPaddingTop();
    int i5 = getPaddingBottom();
    int m = i1 - i2;
    int[] arrayOfInt = mTempMargins;
    arrayOfInt[1] = 0;
    arrayOfInt[0] = 0;
    paramInt1 = ViewCompat.getMinimumHeight(this);
    int j;
    if (paramInt1 >= 0) {
      j = Math.min(paramInt1, paramInt4 - paramInt2);
    } else {
      j = 0;
    }
    if (shouldLayout(mNavButtonView))
    {
      if (k != 0)
      {
        paramInt4 = layoutChildRight(mNavButtonView, m, arrayOfInt, j);
        i = paramInt3;
        break label167;
      }
      i = layoutChildLeft(mNavButtonView, paramInt3, arrayOfInt, j);
    }
    else
    {
      i = paramInt3;
    }
    paramInt4 = m;
    label167:
    paramInt1 = paramInt4;
    paramInt2 = i;
    if (shouldLayout(mCollapseButtonView)) {
      if (k != 0)
      {
        paramInt1 = layoutChildRight(mCollapseButtonView, paramInt4, arrayOfInt, j);
        paramInt2 = i;
      }
      else
      {
        paramInt2 = layoutChildLeft(mCollapseButtonView, i, arrayOfInt, j);
        paramInt1 = paramInt4;
      }
    }
    paramInt4 = paramInt1;
    int i = paramInt2;
    if (shouldLayout(mMenuView)) {
      if (k != 0)
      {
        i = layoutChildLeft(mMenuView, paramInt2, arrayOfInt, j);
        paramInt4 = paramInt1;
      }
      else
      {
        paramInt4 = layoutChildRight(mMenuView, paramInt1, arrayOfInt, j);
        i = paramInt2;
      }
    }
    paramInt2 = getCurrentContentInsetLeft();
    paramInt1 = getCurrentContentInsetRight();
    arrayOfInt[0] = Math.max(0, paramInt2 - i);
    arrayOfInt[1] = Math.max(0, paramInt1 - (m - paramInt4));
    int n = Math.max(i, paramInt2);
    paramInt2 = n;
    m = Math.min(paramInt4, m - paramInt1);
    paramInt4 = m;
    paramInt1 = paramInt2;
    i = paramInt4;
    if (shouldLayout(mExpandedActionView)) {
      if (k != 0)
      {
        i = layoutChildRight(mExpandedActionView, m, arrayOfInt, j);
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = layoutChildLeft(mExpandedActionView, n, arrayOfInt, j);
        i = paramInt4;
      }
    }
    paramInt4 = paramInt1;
    paramInt2 = i;
    if (shouldLayout(mLogoView)) {
      if (k != 0)
      {
        paramInt2 = layoutChildRight(mLogoView, i, arrayOfInt, j);
        paramInt4 = paramInt1;
      }
      else
      {
        paramInt4 = layoutChildLeft(mLogoView, paramInt1, arrayOfInt, j);
        paramInt2 = i;
      }
    }
    paramBoolean = shouldLayout(mTitleTextView);
    boolean bool = shouldLayout(mSubtitleTextView);
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = (LayoutParams)mTitleTextView.getLayoutParams();
      paramInt1 = topMargin + mTitleTextView.getMeasuredHeight() + bottomMargin + 0;
    }
    else
    {
      paramInt1 = 0;
    }
    m = paramInt1;
    if (bool)
    {
      localObject1 = (LayoutParams)mSubtitleTextView.getLayoutParams();
      m = paramInt1 + (topMargin + mSubtitleTextView.getMeasuredHeight() + bottomMargin);
    }
    if ((!paramBoolean) && (!bool)) {}
    for (;;)
    {
      paramInt1 = paramInt4;
      paramInt4 = paramInt2;
      break label1304;
      if (paramBoolean) {
        localObject1 = mTitleTextView;
      } else {
        localObject1 = mSubtitleTextView;
      }
      if (bool) {
        localObject2 = mSubtitleTextView;
      } else {
        localObject2 = mTitleTextView;
      }
      localObject1 = (LayoutParams)((android.view.View)localObject1).getLayoutParams();
      Object localObject2 = (LayoutParams)((android.view.View)localObject2).getLayoutParams();
      if (((paramBoolean) && (mTitleTextView.getMeasuredWidth() > 0)) || ((bool) && (mSubtitleTextView.getMeasuredWidth() > 0))) {
        i = 1;
      } else {
        i = 0;
      }
      paramInt1 = mGravity & 0x70;
      if (paramInt1 != 48)
      {
        if (paramInt1 != 80)
        {
          n = (i4 - i3 - i5 - m) / 2;
          paramInt1 = topMargin;
          int i6 = mTitleMarginTop;
          if (n < paramInt1 + i6)
          {
            paramInt1 += i6;
          }
          else
          {
            m = i4 - i5 - m - n - i3;
            i4 = bottomMargin;
            i5 = mTitleMarginBottom;
            paramInt1 = n;
            if (m < i4 + i5) {
              paramInt1 = Math.max(0, n - (bottomMargin + i5 - m));
            }
          }
          paramInt1 = i3 + paramInt1;
        }
        else
        {
          paramInt1 = i4 - i5 - bottomMargin - mTitleMarginBottom - m;
        }
      }
      else {
        paramInt1 = getPaddingTop() + topMargin + mTitleMarginTop;
      }
      if (k == 0) {
        break;
      }
      if (i != 0) {
        k = mTitleMarginStart;
      } else {
        k = 0;
      }
      k -= arrayOfInt[1];
      paramInt2 -= Math.max(0, k);
      arrayOfInt[1] = Math.max(0, -k);
      if (paramBoolean)
      {
        localObject1 = (LayoutParams)mTitleTextView.getLayoutParams();
        k = paramInt2 - mTitleTextView.getMeasuredWidth();
        m = mTitleTextView.getMeasuredHeight() + paramInt1;
        mTitleTextView.layout(k, paramInt1, paramInt2, m);
        k -= mTitleMarginEnd;
        paramInt1 = m + bottomMargin;
      }
      else
      {
        k = paramInt2;
      }
      if (bool)
      {
        paramInt1 += mSubtitleTextView.getLayoutParams()).topMargin;
        m = mSubtitleTextView.getMeasuredWidth();
        n = mSubtitleTextView.getMeasuredHeight();
        mSubtitleTextView.layout(paramInt2 - m, paramInt1, paramInt2, n + paramInt1);
        paramInt1 = paramInt2 - mTitleMarginEnd;
      }
      else
      {
        paramInt1 = paramInt2;
      }
      if (i != 0) {
        paramInt2 = Math.min(k, paramInt1);
      }
    }
    if (i != 0) {
      k = mTitleMarginStart;
    } else {
      k = 0;
    }
    k -= arrayOfInt[0];
    paramInt4 += Math.max(0, k);
    arrayOfInt[0] = Math.max(0, -k);
    if (paramBoolean)
    {
      localObject1 = (LayoutParams)mTitleTextView.getLayoutParams();
      k = mTitleTextView.getMeasuredWidth() + paramInt4;
      m = mTitleTextView.getMeasuredHeight() + paramInt1;
      mTitleTextView.layout(paramInt4, paramInt1, k, m);
      k += mTitleMarginEnd;
      paramInt1 = m + bottomMargin;
    }
    else
    {
      k = paramInt4;
    }
    if (bool)
    {
      paramInt1 += mSubtitleTextView.getLayoutParams()).topMargin;
      m = mSubtitleTextView.getMeasuredWidth() + paramInt4;
      n = mSubtitleTextView.getMeasuredHeight();
      mSubtitleTextView.layout(paramInt4, paramInt1, m, n + paramInt1);
      m += mTitleMarginEnd;
    }
    else
    {
      m = paramInt4;
    }
    paramInt1 = paramInt4;
    paramInt4 = paramInt2;
    if (i != 0)
    {
      paramInt1 = Math.max(k, m);
      paramInt4 = paramInt2;
    }
    label1304:
    i = paramInt3;
    paramInt3 = 0;
    addCustomViewsWithGravity(mTempViews, 3);
    int k = mTempViews.size();
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      paramInt1 = layoutChildLeft((android.view.View)mTempViews.get(paramInt2), paramInt1, arrayOfInt, j);
      paramInt2 += 1;
    }
    addCustomViewsWithGravity(mTempViews, 5);
    k = mTempViews.size();
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      paramInt4 = layoutChildRight((android.view.View)mTempViews.get(paramInt2), paramInt4, arrayOfInt, j);
      paramInt2 += 1;
    }
    addCustomViewsWithGravity(mTempViews, 1);
    k = getViewListMeasuredWidth(mTempViews, arrayOfInt);
    paramInt2 = i + (i1 - i - i2) / 2 - k / 2;
    i = k + paramInt2;
    if (paramInt2 >= paramInt1) {
      if (i > paramInt4) {
        paramInt1 = paramInt2 - (i - paramInt4);
      } else {
        paramInt1 = paramInt2;
      }
    }
    paramInt4 = mTempViews.size();
    paramInt2 = paramInt1;
    paramInt1 = paramInt3;
    while (paramInt1 < paramInt4)
    {
      paramInt2 = layoutChildLeft((android.view.View)mTempViews.get(paramInt1), paramInt2, arrayOfInt, j);
      paramInt1 += 1;
    }
    mTempViews.clear();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = mTempMargins;
    boolean bool = ViewUtils.isLayoutRtl(this);
    int i4 = 0;
    if (bool)
    {
      i2 = 1;
      i1 = 0;
    }
    else
    {
      i1 = 1;
      i2 = 0;
    }
    if (shouldLayout(mNavButtonView))
    {
      measureChildConstrained(mNavButtonView, paramInt1, 0, paramInt2, 0, mMaxButtonHeight);
      n = mNavButtonView.getMeasuredWidth() + getHorizontalMargins(mNavButtonView);
      m = Math.max(0, mNavButtonView.getMeasuredHeight() + getVerticalMargins(mNavButtonView));
      k = android.view.View.combineMeasuredStates(0, mNavButtonView.getMeasuredState());
    }
    else
    {
      n = 0;
      m = 0;
      k = 0;
    }
    int j = m;
    int i = k;
    if (shouldLayout(mCollapseButtonView))
    {
      measureChildConstrained(mCollapseButtonView, paramInt1, 0, paramInt2, 0, mMaxButtonHeight);
      n = mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(mCollapseButtonView);
      j = Math.max(m, mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(mCollapseButtonView));
      i = android.view.View.combineMeasuredStates(k, mCollapseButtonView.getMeasuredState());
    }
    int k = getCurrentContentInsetStart();
    int m = 0 + Math.max(k, n);
    arrayOfInt[i2] = Math.max(0, k - n);
    if (shouldLayout(mMenuView))
    {
      measureChildConstrained(mMenuView, paramInt1, m, paramInt2, 0, mMaxButtonHeight);
      k = mMenuView.getMeasuredWidth() + getHorizontalMargins(mMenuView);
      j = Math.max(j, mMenuView.getMeasuredHeight() + getVerticalMargins(mMenuView));
      i = android.view.View.combineMeasuredStates(i, mMenuView.getMeasuredState());
    }
    else
    {
      k = 0;
    }
    int i2 = getCurrentContentInsetEnd();
    int n = m + Math.max(i2, k);
    arrayOfInt[i1] = Math.max(0, i2 - k);
    int i1 = j;
    k = i;
    m = n;
    if (shouldLayout(mExpandedActionView))
    {
      m = n + measureChildCollapseMargins(mExpandedActionView, paramInt1, n, paramInt2, 0, arrayOfInt);
      i1 = Math.max(j, mExpandedActionView.getMeasuredHeight() + getVerticalMargins(mExpandedActionView));
      k = android.view.View.combineMeasuredStates(i, mExpandedActionView.getMeasuredState());
    }
    j = i1;
    i = k;
    n = m;
    if (shouldLayout(mLogoView))
    {
      n = m + measureChildCollapseMargins(mLogoView, paramInt1, m, paramInt2, 0, arrayOfInt);
      j = Math.max(i1, mLogoView.getMeasuredHeight() + getVerticalMargins(mLogoView));
      i = android.view.View.combineMeasuredStates(k, mLogoView.getMeasuredState());
    }
    int i3 = getChildCount();
    k = 0;
    m = j;
    while (k < i3)
    {
      android.view.View localView = getChildAt(k);
      i2 = m;
      i1 = i;
      j = n;
      if (getLayoutParamsmViewType == 0) {
        if (!shouldLayout(localView))
        {
          i2 = m;
          i1 = i;
          j = n;
        }
        else
        {
          j = n + measureChildCollapseMargins(localView, paramInt1, n, paramInt2, 0, arrayOfInt);
          i2 = Math.max(m, localView.getMeasuredHeight() + getVerticalMargins(localView));
          i1 = android.view.View.combineMeasuredStates(i, localView.getMeasuredState());
        }
      }
      k += 1;
      m = i2;
      i = i1;
      n = j;
    }
    int i5 = mTitleMarginTop + mTitleMarginBottom;
    int i6 = mTitleMarginStart + mTitleMarginEnd;
    if (shouldLayout(mTitleTextView))
    {
      measureChildCollapseMargins(mTitleTextView, paramInt1, n + i6, paramInt2, i5, arrayOfInt);
      k = mTitleTextView.getMeasuredWidth() + getHorizontalMargins(mTitleTextView);
      j = mTitleTextView.getMeasuredHeight() + getVerticalMargins(mTitleTextView);
      i = android.view.View.combineMeasuredStates(i, mTitleTextView.getMeasuredState());
    }
    else
    {
      j = 0;
      k = 0;
    }
    i1 = i;
    i3 = j;
    i2 = k;
    if (shouldLayout(mSubtitleTextView))
    {
      i2 = Math.max(k, measureChildCollapseMargins(mSubtitleTextView, paramInt1, n + i6, paramInt2, j + i5, arrayOfInt));
      i3 = j + (mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(mSubtitleTextView));
      i1 = android.view.View.combineMeasuredStates(i, mSubtitleTextView.getMeasuredState());
    }
    i = Math.max(m, i3);
    m = getPaddingLeft();
    i3 = getPaddingRight();
    j = getPaddingTop();
    k = getPaddingBottom();
    m = android.view.View.resolveSizeAndState(Math.max(n + i2 + (m + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i1);
    paramInt1 = android.view.View.resolveSizeAndState(Math.max(i + (j + k), getSuggestedMinimumHeight()), paramInt2, i1 << 16);
    if (shouldCollapse()) {
      paramInt1 = i4;
    }
    setMeasuredDimension(m, paramInt1);
  }
  
  public void onPrepareOptionsMenu()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      getMenu().removeItem(localMenuItem.getItemId());
    }
    setTitle();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    paramParcelable = mMenuView;
    if (paramParcelable != null) {
      paramParcelable = paramParcelable.peekMenu();
    } else {
      paramParcelable = null;
    }
    int i = expandedMenuItemId;
    if ((i != 0) && (mExpandedMenuPresenter != null) && (paramParcelable != null))
    {
      paramParcelable = paramParcelable.findItem(i);
      if (paramParcelable != null) {
        paramParcelable.expandActionView();
      }
    }
    if (isOverflowOpen) {
      postShowOverflowMenu();
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    setSubtitle();
    RtlSpacingHelper localRtlSpacingHelper = mContentInsets;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    localRtlSpacingHelper.setDirection(bool);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Object localObject = mExpandedMenuPresenter;
    if (localObject != null)
    {
      localObject = mCurrentExpandedItem;
      if (localObject != null) {
        expandedMenuItemId = ((MenuItemImpl)localObject).getItemId();
      }
    }
    isOverflowOpen = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      mEatingTouch = false;
    }
    if (!mEatingTouch)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        mEatingTouch = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      mEatingTouch = false;
    }
    return true;
  }
  
  void removeChildrenForExpandedActionView()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      android.view.View localView = getChildAt(i);
      if ((getLayoutParamsmViewType != 2) && (localView != mMenuView))
      {
        removeViewAt(i);
        mHiddenViews.add(localView);
      }
      i -= 1;
    }
  }
  
  public void removeMenuProvider(h paramH)
  {
    c.a(paramH);
  }
  
  public void setBackInvokedCallbackEnabled(boolean paramBoolean)
  {
    if (v != paramBoolean)
    {
      v = paramBoolean;
      a();
    }
  }
  
  public void setCollapseContentDescription(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setCollapseContentDescription(localCharSequence);
  }
  
  public void setCollapseContentDescription(CharSequence paramCharSequence)
  {
    if (!android.text.TextUtils.isEmpty(paramCharSequence)) {
      ensureCollapseButtonView();
    }
    ImageButton localImageButton = mCollapseButtonView;
    if (localImageButton != null) {
      localImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setCollapseIcon(int paramInt)
  {
    setCollapseIcon(v7.internal.transition.util.View.getDrawable(getContext(), paramInt));
  }
  
  public void setCollapseIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureCollapseButtonView();
      mCollapseButtonView.setImageDrawable(paramDrawable);
      return;
    }
    paramDrawable = mCollapseButtonView;
    if (paramDrawable != null) {
      paramDrawable.setImageDrawable(mCollapseIcon);
    }
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    mCollapsible = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = Integer.MIN_VALUE;
    }
    if (i != before)
    {
      before = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetStartWithNavigation(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = Integer.MIN_VALUE;
    }
    if (i != after)
    {
      after = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetsRelative(int paramInt1, int paramInt2)
  {
    setSubtitle();
    mContentInsets.setRelative(paramInt1, paramInt2);
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(v7.internal.transition.util.View.getDrawable(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureLogoView();
      if (!isChildOrHidden(mLogoView)) {
        addSystemView(mLogoView, true);
      }
    }
    else
    {
      localImageView = mLogoView;
      if ((localImageView != null) && (isChildOrHidden(localImageView)))
      {
        removeView(mLogoView);
        mHiddenViews.remove(mLogoView);
      }
    }
    ImageView localImageView = mLogoView;
    if (localImageView != null) {
      localImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!android.text.TextUtils.isEmpty(paramCharSequence)) {
      ensureLogoView();
    }
    ImageView localImageView = mLogoView;
    if (localImageView != null) {
      localImageView.setContentDescription(paramCharSequence);
    }
  }
  
  public void setMenu(f paramF, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramF == null) && (mMenuView == null)) {
      return;
    }
    ensureMenuView();
    f localF = mMenuView.peekMenu();
    if (localF == paramF) {
      return;
    }
    if (localF != null)
    {
      localF.b(mOuterActionMenuPresenter);
      localF.b(mExpandedMenuPresenter);
    }
    if (mExpandedMenuPresenter == null) {
      mExpandedMenuPresenter = new f();
    }
    paramActionMenuPresenter.setExpandedActionViewsExclusive(true);
    if (paramF != null)
    {
      paramF.addMenuPresenter(paramActionMenuPresenter, mPopupContext);
      paramF.addMenuPresenter(mExpandedMenuPresenter, mPopupContext);
    }
    else
    {
      paramActionMenuPresenter.initForMenu(mPopupContext, null);
      mExpandedMenuPresenter.initForMenu(mPopupContext, null);
      paramActionMenuPresenter.updateMenuView(true);
      mExpandedMenuPresenter.updateMenuView(true);
    }
    mMenuView.setPopupTheme(mPopupTheme);
    mMenuView.setPresenter(paramActionMenuPresenter);
    mOuterActionMenuPresenter = paramActionMenuPresenter;
    a();
  }
  
  public void setMenuCallbacks(l.a paramA, MenuBuilder.Callback paramCallback)
  {
    mActionMenuPresenterCallback = paramA;
    mCallback = paramCallback;
    ActionMenuView localActionMenuView = mMenuView;
    if (localActionMenuView != null) {
      localActionMenuView.setMenuCallbacks(paramA, paramCallback);
    }
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setNavigationContentDescription(localCharSequence);
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!android.text.TextUtils.isEmpty(paramCharSequence)) {
      ensureNavButtonView();
    }
    ImageButton localImageButton = mNavButtonView;
    if (localImageButton != null)
    {
      localImageButton.setContentDescription(paramCharSequence);
      TextUtils.setText(mNavButtonView, paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(v7.internal.transition.util.View.getDrawable(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureNavButtonView();
      if (!isChildOrHidden(mNavButtonView)) {
        addSystemView(mNavButtonView, true);
      }
    }
    else
    {
      localImageButton = mNavButtonView;
      if ((localImageButton != null) && (isChildOrHidden(localImageButton)))
      {
        removeView(mNavButtonView);
        mHiddenViews.remove(mNavButtonView);
      }
    }
    ImageButton localImageButton = mNavButtonView;
    if (localImageButton != null) {
      localImageButton.setImageDrawable(paramDrawable);
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    ensureNavButtonView();
    mNavButtonView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(g paramG)
  {
    mMenuItemClickListener = paramG;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    ensureMenu();
    mMenuView.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (mPopupTheme != paramInt)
    {
      mPopupTheme = paramInt;
      if (paramInt == 0)
      {
        mPopupContext = getContext();
        return;
      }
      mPopupContext = new ContextThemeWrapper(getContext(), paramInt);
    }
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!android.text.TextUtils.isEmpty(paramCharSequence))
    {
      if (mSubtitleTextView == null)
      {
        localObject = getContext();
        AppCompatTextView localAppCompatTextView = new AppCompatTextView((Context)localObject);
        mSubtitleTextView = localAppCompatTextView;
        localAppCompatTextView.setSingleLine();
        mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int i = mSubtitleTextAppearance;
        if (i != 0) {
          mSubtitleTextView.setTextAppearance((Context)localObject, i);
        }
        localObject = mSubtitleTextColor;
        if (localObject != null) {
          mSubtitleTextView.setTextColor((ColorStateList)localObject);
        }
      }
      if (!isChildOrHidden(mSubtitleTextView)) {
        addSystemView(mSubtitleTextView, true);
      }
    }
    else
    {
      localObject = mSubtitleTextView;
      if ((localObject != null) && (isChildOrHidden((android.view.View)localObject)))
      {
        removeView(mSubtitleTextView);
        mHiddenViews.remove(mSubtitleTextView);
      }
    }
    Object localObject = mSubtitleTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    mSubtitleText = paramCharSequence;
  }
  
  public void setSubtitleTextAppearance(Context paramContext, int paramInt)
  {
    mSubtitleTextAppearance = paramInt;
    TextView localTextView = mSubtitleTextView;
    if (localTextView != null) {
      localTextView.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    setSubtitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setSubtitleTextColor(ColorStateList paramColorStateList)
  {
    mSubtitleTextColor = paramColorStateList;
    TextView localTextView = mSubtitleTextView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!android.text.TextUtils.isEmpty(paramCharSequence))
    {
      if (mTitleTextView == null)
      {
        localObject = getContext();
        AppCompatTextView localAppCompatTextView = new AppCompatTextView((Context)localObject);
        mTitleTextView = localAppCompatTextView;
        localAppCompatTextView.setSingleLine();
        mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int i = mTitleTextAppearance;
        if (i != 0) {
          mTitleTextView.setTextAppearance((Context)localObject, i);
        }
        localObject = mTitleTextColor;
        if (localObject != null) {
          mTitleTextView.setTextColor((ColorStateList)localObject);
        }
      }
      if (!isChildOrHidden(mTitleTextView)) {
        addSystemView(mTitleTextView, true);
      }
    }
    else
    {
      localObject = mTitleTextView;
      if ((localObject != null) && (isChildOrHidden((android.view.View)localObject)))
      {
        removeView(mTitleTextView);
        mHiddenViews.remove(mTitleTextView);
      }
    }
    Object localObject = mTitleTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    mTitleText = paramCharSequence;
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    mTitleMarginBottom = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    mTitleMarginEnd = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    mTitleMarginStart = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    mTitleMarginTop = paramInt;
    requestLayout();
  }
  
  public void setTitleTextAppearance(Context paramContext, int paramInt)
  {
    mTitleTextAppearance = paramInt;
    TextView localTextView = mTitleTextView;
    if (localTextView != null) {
      localTextView.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setTitleTextColor(int paramInt)
  {
    setTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setTitleTextColor(ColorStateList paramColorStateList)
  {
    mTitleTextColor = paramColorStateList;
    TextView localTextView = mTitleTextView;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public boolean showOverflowMenu()
  {
    ActionMenuView localActionMenuView = mMenuView;
    return (localActionMenuView != null) && (localActionMenuView.showOverflowMenu());
  }
  
  protected LayoutParams updateEditTextMargin(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams)) {
      return new LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int mViewType = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      gravity = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      copyMarginsFromCompat(paramMarginLayoutParams);
    }
    
    public LayoutParams(ActionBar.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      mViewType = mViewType;
    }
    
    void copyMarginsFromCompat(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      leftMargin = leftMargin;
      topMargin = topMargin;
      rightMargin = rightMargin;
      bottomMargin = bottomMargin;
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    int expandedMenuItemId;
    boolean isOverflowOpen;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      expandedMenuItemId = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      isOverflowOpen = bool;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<Toolbar.SavedState>
    {
      a() {}
      
      public Toolbar.SavedState[] a(int paramInt)
      {
        return new Toolbar.SavedState[paramInt];
      }
      
      public Toolbar.SavedState getInstance(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new Toolbar.SavedState(paramParcel, paramClassLoader);
      }
      
      public Toolbar.SavedState readDate(Parcel paramParcel)
      {
        return new Toolbar.SavedState(paramParcel, null);
      }
    }
  }
  
  class a
    implements ActionMenuView.d
  {
    a() {}
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      if (c.a(paramMenuItem)) {
        return true;
      }
      Toolbar.g localG = mMenuItemClickListener;
      if (localG != null) {
        return localG.onMenuItemClick(paramMenuItem);
      }
      return false;
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      showOverflowMenu();
    }
  }
  
  class c
    implements MenuBuilder.Callback
  {
    c() {}
    
    public boolean onMenuItemSelected(f paramF, MenuItem paramMenuItem)
    {
      MenuBuilder.Callback localCallback = mCallback;
      return (localCallback != null) && (localCallback.onMenuItemSelected(paramF, paramMenuItem));
    }
    
    public void onMenuModeChange(f paramF)
    {
      if (!mMenuView.isOverflowMenuShowing()) {
        c.a(paramF);
      }
      MenuBuilder.Callback localCallback = mCallback;
      if (localCallback != null) {
        localCallback.onMenuModeChange(paramF);
      }
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(android.view.View paramView)
    {
      collapseActionView();
    }
  }
  
  static class e
  {
    static OnBackInvokedCallback a(Runnable paramRunnable)
    {
      Objects.requireNonNull(paramRunnable);
      return new LayoutManager(paramRunnable);
    }
    
    static OnBackInvokedDispatcher a(android.view.View paramView)
    {
      return paramView.findOnBackInvokedDispatcher();
    }
    
    static void append(Object paramObject1, Object paramObject2)
    {
      ((OnBackInvokedDispatcher)paramObject1).unregisterOnBackInvokedCallback((OnBackInvokedCallback)paramObject2);
    }
    
    static void put(Object paramObject1, Object paramObject2)
    {
      ((OnBackInvokedDispatcher)paramObject1).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback)paramObject2);
    }
  }
  
  private class f
    implements l
  {
    MenuItemImpl mCurrentExpandedItem;
    f mMenu;
    
    f() {}
    
    public void a(f paramF, boolean paramBoolean) {}
    
    public boolean a(p paramP)
    {
      return false;
    }
    
    public boolean collapseItemActionView(f paramF, MenuItemImpl paramMenuItemImpl)
    {
      paramF = mExpandedActionView;
      if ((paramF instanceof CollapsibleActionView)) {
        ((CollapsibleActionView)paramF).onActionViewCollapsed();
      }
      paramF = Toolbar.this;
      paramF.removeView(mExpandedActionView);
      paramF = Toolbar.this;
      paramF.removeView(mCollapseButtonView);
      paramF = Toolbar.this;
      mExpandedActionView = null;
      paramF.addChildrenForExpandedActionView();
      mCurrentExpandedItem = null;
      requestLayout();
      paramMenuItemImpl.setActionViewExpanded(false);
      a();
      return true;
    }
    
    public boolean expandItemActionView(f paramF, MenuItemImpl paramMenuItemImpl)
    {
      ensureCollapseButtonView();
      paramF = mCollapseButtonView.getParent();
      Toolbar localToolbar = Toolbar.this;
      if (paramF != localToolbar)
      {
        if ((paramF instanceof ViewGroup)) {
          ((ViewGroup)paramF).removeView(mCollapseButtonView);
        }
        paramF = Toolbar.this;
        paramF.addView(mCollapseButtonView);
      }
      mExpandedActionView = paramMenuItemImpl.getActionView();
      mCurrentExpandedItem = paramMenuItemImpl;
      paramF = mExpandedActionView.getParent();
      localToolbar = Toolbar.this;
      if (paramF != localToolbar)
      {
        if ((paramF instanceof ViewGroup)) {
          ((ViewGroup)paramF).removeView(mExpandedActionView);
        }
        paramF = generateLayoutParams();
        localToolbar = Toolbar.this;
        gravity = (0x800003 | mButtonGravity & 0x70);
        mViewType = 2;
        mExpandedActionView.setLayoutParams(paramF);
        paramF = Toolbar.this;
        paramF.addView(mExpandedActionView);
      }
      removeChildrenForExpandedActionView();
      requestLayout();
      paramMenuItemImpl.setActionViewExpanded(true);
      paramF = mExpandedActionView;
      if ((paramF instanceof CollapsibleActionView)) {
        ((CollapsibleActionView)paramF).onActionViewExpanded();
      }
      a();
      return true;
    }
    
    public boolean flagActionItems()
    {
      return false;
    }
    
    public int getId()
    {
      return 0;
    }
    
    public void initForMenu(Context paramContext, f paramF)
    {
      paramContext = mMenu;
      if (paramContext != null)
      {
        MenuItemImpl localMenuItemImpl = mCurrentExpandedItem;
        if (localMenuItemImpl != null) {
          paramContext.collapseItemActionView(localMenuItemImpl);
        }
      }
      mMenu = paramF;
    }
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public void updateMenuView(boolean paramBoolean)
    {
      if (mCurrentExpandedItem != null)
      {
        f localF = mMenu;
        int k = 0;
        int j = k;
        if (localF != null)
        {
          int m = localF.size();
          int i = 0;
          for (;;)
          {
            j = k;
            if (i >= m) {
              break;
            }
            if (mMenu.getItem(i) == mCurrentExpandedItem)
            {
              j = 1;
              break;
            }
            i += 1;
          }
        }
        if (j == 0) {
          collapseItemActionView(mMenu, mCurrentExpandedItem);
        }
      }
    }
  }
  
  public static abstract interface g
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}
