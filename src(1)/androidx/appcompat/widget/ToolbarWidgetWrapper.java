package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l.a;
import v7.internal.R.attr;
import v7.internal.R.drawable;
import v7.internal.R.id;
import v7.internal.R.styleable;
import v7.internal.i;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.ViewPropertyAnimatorCompat;

public class ToolbarWidgetWrapper
  implements DecorToolbar
{
  private ActionMenuPresenter mActionMenuPresenter;
  private android.view.View mCustomView;
  private int mDefaultNavigationContentDescription = 0;
  private Drawable mDefaultNavigationIcon;
  private int mDisplayOpts;
  private CharSequence mHomeDescription;
  private Drawable mIcon;
  private Drawable mLogo;
  boolean mMenuPrepared;
  private Drawable mNavIcon;
  private int mNavigationMode = 0;
  private CharSequence mSubtitle;
  private android.view.View mTabView;
  CharSequence mTitle;
  private boolean mTitleSet;
  Toolbar mToolbar;
  Window.Callback mWindowCallback;
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, i.r, R.drawable.size);
  }
  
  public ToolbarWidgetWrapper(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    mToolbar = paramToolbar;
    mTitle = paramToolbar.getTitle();
    mSubtitle = paramToolbar.getSubtitle();
    boolean bool;
    if (mTitle != null) {
      bool = true;
    } else {
      bool = false;
    }
    mTitleSet = bool;
    mNavIcon = paramToolbar.getNavigationIcon();
    paramToolbar = TintTypedArray.obtainStyledAttributes(paramToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    mDefaultNavigationIcon = paramToolbar.getDrawable(R.styleable.ActionBar_title);
    if (paramBoolean)
    {
      Object localObject = paramToolbar.getText(R.styleable.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setTitle((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(R.styleable.ActionBar_logo);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setSubtitle((CharSequence)localObject);
      }
      localObject = paramToolbar.getDrawable(R.styleable.ActionBar_icon);
      if (localObject != null) {
        setLogo((Drawable)localObject);
      }
      localObject = paramToolbar.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
      if (localObject != null) {
        setIcon((Drawable)localObject);
      }
      if (mNavIcon == null)
      {
        localObject = mDefaultNavigationIcon;
        if (localObject != null) {
          setNavigationIcon((Drawable)localObject);
        }
      }
      setDisplayOptions(paramToolbar.getInt(R.styleable.SlidingMenu_mode, 0));
      paramInt2 = paramToolbar.getResourceId(R.styleable.SlidingMenu_viewAbove, 0);
      if (paramInt2 != 0)
      {
        setCustomView(LayoutInflater.from(mToolbar.getContext()).inflate(paramInt2, mToolbar, false));
        setDisplayOptions(mDisplayOpts | 0x10);
      }
      paramInt2 = paramToolbar.getLayoutDimension(R.styleable.ActionBar_height, 0);
      if (paramInt2 > 0)
      {
        localObject = mToolbar.getLayoutParams();
        height = paramInt2;
        mToolbar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramInt2 = paramToolbar.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
      int i = paramToolbar.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
      if ((paramInt2 >= 0) || (i >= 0)) {
        mToolbar.setContentInsetsRelative(Math.max(paramInt2, 0), Math.max(i, 0));
      }
      paramInt2 = paramToolbar.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
      if (paramInt2 != 0)
      {
        localObject = mToolbar;
        ((Toolbar)localObject).setTitleTextAppearance(((android.view.View)localObject).getContext(), paramInt2);
      }
      paramInt2 = paramToolbar.getResourceId(R.styleable.ActionBar_popupTheme, 0);
      if (paramInt2 != 0)
      {
        localObject = mToolbar;
        ((Toolbar)localObject).setSubtitleTextAppearance(((android.view.View)localObject).getContext(), paramInt2);
      }
      paramInt2 = paramToolbar.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
      if (paramInt2 != 0) {
        mToolbar.setPopupTheme(paramInt2);
      }
    }
    else
    {
      mDisplayOpts = detectDisplayOptions();
    }
    paramToolbar.recycle();
    setDefaultNavigationContentDescription(paramInt1);
    mHomeDescription = mToolbar.getNavigationContentDescription();
    mToolbar.setNavigationOnClickListener(new o0.a(this));
  }
  
  private int detectDisplayOptions()
  {
    if (mToolbar.getNavigationIcon() != null)
    {
      mDefaultNavigationIcon = mToolbar.getNavigationIcon();
      return 15;
    }
    return 11;
  }
  
  private void setTitleInt(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    if ((mDisplayOpts & 0x8) != 0)
    {
      mToolbar.setTitle(paramCharSequence);
      if (mTitleSet) {
        ViewCompat.b(mToolbar.getRootView(), paramCharSequence);
      }
    }
  }
  
  private void updateHomeAccessibility()
  {
    if ((mDisplayOpts & 0x4) != 0)
    {
      if (TextUtils.isEmpty(mHomeDescription))
      {
        mToolbar.setNavigationContentDescription(mDefaultNavigationContentDescription);
        return;
      }
      mToolbar.setNavigationContentDescription(mHomeDescription);
    }
  }
  
  private void updateNavigationIcon()
  {
    if ((mDisplayOpts & 0x4) != 0)
    {
      Toolbar localToolbar = mToolbar;
      Drawable localDrawable = mNavIcon;
      if (localDrawable == null) {
        localDrawable = mDefaultNavigationIcon;
      }
      localToolbar.setNavigationIcon(localDrawable);
      return;
    }
    mToolbar.setNavigationIcon(null);
  }
  
  private void updateToolbarLogo()
  {
    int i = mDisplayOpts;
    Drawable localDrawable;
    if ((i & 0x2) != 0)
    {
      if ((i & 0x1) != 0)
      {
        localDrawable = mLogo;
        if (localDrawable == null) {
          localDrawable = mIcon;
        }
      }
      else
      {
        localDrawable = mIcon;
      }
    }
    else {
      localDrawable = null;
    }
    mToolbar.setLogo(localDrawable);
  }
  
  public boolean canShowOverflowMenu()
  {
    return mToolbar.canShowOverflowMenu();
  }
  
  public void collapseActionView()
  {
    mToolbar.collapseActionView();
  }
  
  public void dismissPopupMenus()
  {
    mToolbar.dismissPopupMenus();
  }
  
  public Context getContext()
  {
    return mToolbar.getContext();
  }
  
  public android.view.View getCustomView()
  {
    return mCustomView;
  }
  
  public int getDisplayOptions()
  {
    return mDisplayOpts;
  }
  
  public int getHeight()
  {
    return mToolbar.getHeight();
  }
  
  public Menu getMenu()
  {
    return mToolbar.getMenu();
  }
  
  public int getNavigationMode()
  {
    return mNavigationMode;
  }
  
  public CharSequence getTitle()
  {
    return mToolbar.getTitle();
  }
  
  public ViewGroup getViewGroup()
  {
    return mToolbar;
  }
  
  public boolean hasExpandedActionView()
  {
    return mToolbar.hasExpandedActionView();
  }
  
  public boolean hideOverflowMenu()
  {
    return mToolbar.hideOverflowMenu();
  }
  
  public void initIndeterminateProgress()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public void initProgress()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public boolean isOverflowMenuShowPending()
  {
    return mToolbar.isOverflowMenuShowPending();
  }
  
  public boolean isOverflowMenuShowing()
  {
    return mToolbar.isOverflowMenuShowing();
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    ViewCompat.setBackgroundDrawable(mToolbar, paramDrawable);
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    mToolbar.setCollapsible(paramBoolean);
  }
  
  public void setCustomView(android.view.View paramView)
  {
    android.view.View localView = mCustomView;
    if ((localView != null) && ((mDisplayOpts & 0x10) != 0)) {
      mToolbar.removeView(localView);
    }
    mCustomView = paramView;
    if ((paramView != null) && ((mDisplayOpts & 0x10) != 0)) {
      mToolbar.addView(paramView);
    }
  }
  
  public void setDefaultNavigationContentDescription(int paramInt)
  {
    if (paramInt == mDefaultNavigationContentDescription) {
      return;
    }
    mDefaultNavigationContentDescription = paramInt;
    if (TextUtils.isEmpty(mToolbar.getNavigationContentDescription())) {
      setNavigationContentDescription(mDefaultNavigationContentDescription);
    }
  }
  
  public void setDisplayOptions(int paramInt)
  {
    int i = mDisplayOpts ^ paramInt;
    mDisplayOpts = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          updateHomeAccessibility();
        }
        updateNavigationIcon();
      }
      if ((i & 0x3) != 0) {
        updateToolbarLogo();
      }
      if ((i & 0x8) != 0) {
        if ((paramInt & 0x8) != 0)
        {
          mToolbar.setTitle(mTitle);
          mToolbar.setSubtitle(mSubtitle);
        }
        else
        {
          mToolbar.setTitle(null);
          mToolbar.setSubtitle(null);
        }
      }
      if ((i & 0x10) != 0)
      {
        android.view.View localView = mCustomView;
        if (localView != null)
        {
          if ((paramInt & 0x10) != 0)
          {
            mToolbar.addView(localView);
            return;
          }
          mToolbar.removeView(localView);
        }
      }
    }
  }
  
  public void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    Object localObject = mTabView;
    if (localObject != null)
    {
      localObject = ((android.view.View)localObject).getParent();
      Toolbar localToolbar = mToolbar;
      if (localObject == localToolbar) {
        localToolbar.removeView(mTabView);
      }
    }
    mTabView = paramScrollingTabContainerView;
    if ((paramScrollingTabContainerView != null) && (mNavigationMode == 2))
    {
      mToolbar.addView(paramScrollingTabContainerView, 0);
      localObject = (Toolbar.LayoutParams)mTabView.getLayoutParams();
      width = -2;
      height = -2;
      gravity = 8388691;
      paramScrollingTabContainerView.setAllowCollapse(true);
    }
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean) {}
  
  public void setIcon(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = v7.internal.transition.util.View.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setIcon(localDrawable);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    mIcon = paramDrawable;
    updateToolbarLogo();
  }
  
  public void setLogo(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = v7.internal.transition.util.View.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setLogo(localDrawable);
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    mLogo = paramDrawable;
    updateToolbarLogo();
  }
  
  public void setMenu(Menu paramMenu, l.a paramA)
  {
    if (mActionMenuPresenter == null)
    {
      ActionMenuPresenter localActionMenuPresenter = new ActionMenuPresenter(mToolbar.getContext());
      mActionMenuPresenter = localActionMenuPresenter;
      localActionMenuPresenter.a(R.id.action_menu_presenter);
    }
    mActionMenuPresenter.setCallback(paramA);
    mToolbar.setMenu((f)paramMenu, mActionMenuPresenter);
  }
  
  public void setMenuCallbacks(l.a paramA, MenuBuilder.Callback paramCallback)
  {
    mToolbar.setMenuCallbacks(paramA, paramCallback);
  }
  
  public void setMenuPrepared()
  {
    mMenuPrepared = true;
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      str = null;
    } else {
      str = getContext().getString(paramInt);
    }
    setNavigationContentDescription(str);
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    mHomeDescription = paramCharSequence;
    updateHomeAccessibility();
  }
  
  public void setNavigationIcon(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = v7.internal.transition.util.View.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setNavigationIcon(localDrawable);
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    mNavIcon = paramDrawable;
    updateNavigationIcon();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    mSubtitle = paramCharSequence;
    if ((mDisplayOpts & 0x8) != 0) {
      mToolbar.setSubtitle(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mTitleSet = true;
    setTitleInt(paramCharSequence);
  }
  
  public void setVisibility(int paramInt)
  {
    mToolbar.setVisibility(paramInt);
  }
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    mWindowCallback = paramCallback;
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!mTitleSet) {
      setTitleInt(paramCharSequence);
    }
  }
  
  public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int paramInt, long paramLong)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(mToolbar);
    float f;
    if (paramInt == 0) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    return localViewPropertyAnimatorCompat.alpha(f).setDuration(paramLong).setListener(new o0.b(this, paramInt));
  }
  
  public boolean showOverflowMenu()
  {
    return mToolbar.showOverflowMenu();
  }
}
