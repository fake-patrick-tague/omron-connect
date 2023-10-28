package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.Label;
import com.google.android.material.internal.c;
import com.google.android.material.internal.i;
import com.google.android.material.theme.utils.Effect;
import org.org.org.ui.Plot;
import org.org.org.ui.R.raw;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import org.org.org.ui.asm.ByteVector;
import org.org.org.ui.compound.Log;
import v7.internal.view.SupportMenuInflater;

public class BottomNavigationView
  extends FrameLayout
{
  private static final int ROW = R.string.actionBarStyle;
  private c d;
  final BottomNavigationMenuView mGLSurfaceView;
  private final androidx.appcompat.view.menu.f mMenu;
  private MenuInflater mMenuInflater;
  private final BottomNavigationPresenter mPresenter;
  private d mTitleView;
  private ColorStateList vibrator;
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, org.org.org.ui.ClassWriter.CLASS);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(Effect.a(paramContext, paramAttributeSet, paramInt, ROW), paramAttributeSet, paramInt);
    Object localObject = new BottomNavigationPresenter();
    mPresenter = ((BottomNavigationPresenter)localObject);
    paramContext = getContext();
    MenuWrapper localMenuWrapper = new MenuWrapper(paramContext);
    mMenu = localMenuWrapper;
    BottomNavigationMenuView localBottomNavigationMenuView = new BottomNavigationMenuView(paramContext);
    mGLSurfaceView = localBottomNavigationMenuView;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    gravity = 17;
    localBottomNavigationMenuView.setLayoutParams(localLayoutParams);
    ((BottomNavigationPresenter)localObject).setOnTimeChangedListener(localBottomNavigationMenuView);
    ((BottomNavigationPresenter)localObject).bindView(1);
    localBottomNavigationMenuView.setPresenter((BottomNavigationPresenter)localObject);
    localMenuWrapper.addMenuPresenter((l)localObject);
    ((BottomNavigationPresenter)localObject).initForMenu(getContext(), localMenuWrapper);
    localObject = R.styleable.SherlockActionBar;
    int k = R.string.actionBarStyle;
    int i = R.styleable.NavigationView_itemTextAppearance;
    int j = R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
    paramAttributeSet = Label.obtainStyledAttrsFromThemeAttr(paramContext, paramAttributeSet, (int[])localObject, paramInt, k, new int[] { i, j });
    paramInt = R.styleable.NavigationView_itemIconTint;
    if (paramAttributeSet.hasValue(paramInt)) {
      localBottomNavigationMenuView.setIconTintList(paramAttributeSet.getColor(paramInt));
    } else {
      localBottomNavigationMenuView.setIconTintList(localBottomNavigationMenuView.createDefaultColorStateList(16842808));
    }
    setItemIconSize(paramAttributeSet.getDimensionPixelSize(R.styleable.Switch_bpThumbTextPadding, getResources().getDimensionPixelSize(R.raw.Switch_bpSwitchMinWidth)));
    if (paramAttributeSet.hasValue(i)) {
      setItemTextAppearanceInactive(paramAttributeSet.getResourceId(i, 0));
    }
    if (paramAttributeSet.hasValue(j)) {
      setItemTextAppearanceActive(paramAttributeSet.getResourceId(j, 0));
    }
    paramInt = R.styleable.Toolbar_subtitleTextColor;
    if (paramAttributeSet.hasValue(paramInt)) {
      setItemTextColor(paramAttributeSet.getColor(paramInt));
    }
    if ((getBackground() == null) || ((getBackground() instanceof ColorDrawable))) {
      v7.v7.package_13.ViewCompat.setBackgroundDrawable(this, process(paramContext));
    }
    paramInt = R.styleable.CoordinatorLayout_LayoutParams_layout_behavior;
    if (paramAttributeSet.hasValue(paramInt)) {
      setElevation(paramAttributeSet.getDimensionPixelSize(paramInt, 0));
    }
    localObject = org.org.org.ui.menu.ClassWriter.a(paramContext, paramAttributeSet, R.styleable.GoogleProgressBar_type);
    DrawableCompat.append(getBackground().mutate(), (ColorStateList)localObject);
    setLabelVisibilityMode(paramAttributeSet.getInteger(R.styleable.default_type, -1));
    setItemHorizontalTranslationEnabled(paramAttributeSet.getBoolean(R.styleable.SwitchCompat_track, true));
    paramInt = paramAttributeSet.getResourceId(R.styleable.CoordinatorLayout_LayoutParams_layout_anchor, 0);
    if (paramInt != 0) {
      localBottomNavigationMenuView.setItemBackgroundRes(paramInt);
    } else {
      setItemRippleColor(org.org.org.ui.menu.ClassWriter.a(paramContext, paramAttributeSet, R.styleable.Preference_shouldDisableView));
    }
    paramInt = R.styleable.Preference_android_defaultValue;
    if (paramAttributeSet.hasValue(paramInt)) {
      inflateMenu(paramAttributeSet.getResourceId(paramInt, 0));
    }
    paramAttributeSet.recycle();
    addView(localBottomNavigationMenuView, localLayoutParams);
    if (process()) {
      init(paramContext);
    }
    localMenuWrapper.setCallback(new a());
    b();
  }
  
  private void b()
  {
    com.google.android.material.internal.ViewCompat.a(this, new b());
  }
  
  private MenuInflater getMenuInflater()
  {
    if (mMenuInflater == null) {
      mMenuInflater = new SupportMenuInflater(getContext());
    }
    return mMenuInflater;
  }
  
  private void init(Context paramContext)
  {
    View localView = new View(paramContext);
    localView.setBackgroundColor(ContextCompat.getColor(paramContext, Plot.TAG));
    localView.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.raw.p)));
    addView(localView);
  }
  
  private org.org.org.ui.asm.f process(Context paramContext)
  {
    org.org.org.ui.asm.f localF = new org.org.org.ui.asm.f();
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof ColorDrawable)) {
      localF.setColor(ColorStateList.valueOf(((ColorDrawable)localDrawable).getColor()));
    }
    localF.d(paramContext);
    return localF;
  }
  
  private boolean process()
  {
    return (Build.VERSION.SDK_INT < 21) && (!(getBackground() instanceof org.org.org.ui.asm.f));
  }
  
  public Drawable getItemBackground()
  {
    return mGLSurfaceView.getItemBackground();
  }
  
  public int getItemBackgroundResource()
  {
    return mGLSurfaceView.getItemBackgroundRes();
  }
  
  public int getItemIconSize()
  {
    return mGLSurfaceView.getItemIconSize();
  }
  
  public ColorStateList getItemIconTintList()
  {
    return mGLSurfaceView.getIconTintList();
  }
  
  public ColorStateList getItemRippleColor()
  {
    return vibrator;
  }
  
  public int getItemTextAppearanceActive()
  {
    return mGLSurfaceView.getItemTextAppearanceActive();
  }
  
  public int getItemTextAppearanceInactive()
  {
    return mGLSurfaceView.getItemTextAppearanceInactive();
  }
  
  public ColorStateList getItemTextColor()
  {
    return mGLSurfaceView.getItemTextColor();
  }
  
  public int getLabelVisibilityMode()
  {
    return mGLSurfaceView.getLabelVisibilityMode();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  public Menu getMenu()
  {
    return mMenu;
  }
  
  public int getSelectedItemId()
  {
    return mGLSurfaceView.getSelectedItemId();
  }
  
  public void inflateMenu(int paramInt)
  {
    mPresenter.a(true);
    getMenuInflater().inflate(paramInt, mMenu);
    mPresenter.a(false);
    mPresenter.updateMenuView(true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ByteVector.a(this);
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
    mMenu.restorePresenterStates(menuState);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Bundle localBundle = new Bundle();
    menuState = localBundle;
    mMenu.savePresenterStates(localBundle);
    return localSavedState;
  }
  
  public void setElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      super.setElevation(paramFloat);
    }
    ByteVector.a(this, paramFloat);
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    mGLSurfaceView.setItemBackground(paramDrawable);
    vibrator = null;
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    mGLSurfaceView.setItemBackgroundRes(paramInt);
    vibrator = null;
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    if (mGLSurfaceView.f() != paramBoolean)
    {
      mGLSurfaceView.setItemHorizontalTranslationEnabled(paramBoolean);
      mPresenter.updateMenuView(false);
    }
  }
  
  public void setItemIconSize(int paramInt)
  {
    mGLSurfaceView.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    mGLSurfaceView.setIconTintList(paramColorStateList);
  }
  
  public void setItemRippleColor(ColorStateList paramColorStateList)
  {
    if (vibrator == paramColorStateList)
    {
      if ((paramColorStateList == null) && (mGLSurfaceView.getItemBackground() != null)) {
        mGLSurfaceView.setItemBackground(null);
      }
    }
    else
    {
      vibrator = paramColorStateList;
      if (paramColorStateList == null)
      {
        mGLSurfaceView.setItemBackground(null);
        return;
      }
      paramColorStateList = Log.build(paramColorStateList);
      if (Build.VERSION.SDK_INT >= 21)
      {
        mGLSurfaceView.setItemBackground(new RippleDrawable(paramColorStateList, null, null));
        return;
      }
      Object localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(1.0E-5F);
      localObject = DrawableCompat.getDrawable((Drawable)localObject);
      DrawableCompat.append((Drawable)localObject, paramColorStateList);
      mGLSurfaceView.setItemBackground((Drawable)localObject);
    }
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    mGLSurfaceView.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    mGLSurfaceView.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    mGLSurfaceView.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (mGLSurfaceView.getLabelVisibilityMode() != paramInt)
    {
      mGLSurfaceView.setLabelVisibilityMode(paramInt);
      mPresenter.updateMenuView(false);
    }
  }
  
  public void setOnNavigationItemReselectedListener(c paramC)
  {
    d = paramC;
  }
  
  public void setOnNavigationItemSelectedListener(d paramD)
  {
    mTitleView = paramD;
  }
  
  public void setSelectedItemId(int paramInt)
  {
    MenuItem localMenuItem = mMenu.findItem(paramInt);
    if ((localMenuItem != null) && (!mMenu.a(localMenuItem, mPresenter, 0))) {
      localMenuItem.setChecked(true);
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    Bundle menuState;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = SavedState.class.getClassLoader();
      }
      readFromParcel(paramParcel, localClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    private void readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      menuState = paramParcel.readBundle(paramClassLoader);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(menuState);
    }
    
    static final class a
      implements Parcelable.ClassLoaderCreator<BottomNavigationView.SavedState>
    {
      a() {}
      
      public BottomNavigationView.SavedState[] a(int paramInt)
      {
        return new BottomNavigationView.SavedState[paramInt];
      }
      
      public BottomNavigationView.SavedState readDate(Parcel paramParcel)
      {
        return new BottomNavigationView.SavedState(paramParcel, null);
      }
      
      public BottomNavigationView.SavedState readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new BottomNavigationView.SavedState(paramParcel, paramClassLoader);
      }
    }
  }
  
  class a
    implements MenuBuilder.Callback
  {
    a() {}
    
    public boolean onMenuItemSelected(androidx.appcompat.view.menu.f paramF, MenuItem paramMenuItem)
    {
      if ((BottomNavigationView.p(BottomNavigationView.this) != null) && (paramMenuItem.getItemId() == getSelectedItemId()))
      {
        BottomNavigationView.p(BottomNavigationView.this).a(paramMenuItem);
        return true;
      }
      return (BottomNavigationView.access$getMTitleView(BottomNavigationView.this) != null) && (!BottomNavigationView.access$getMTitleView(BottomNavigationView.this).showAbout(paramMenuItem));
    }
    
    public void onMenuModeChange(androidx.appcompat.view.menu.f paramF) {}
  }
  
  class b
    implements c
  {
    b() {}
    
    public v7.v7.package_13.f a(View paramView, v7.v7.package_13.f paramF, i paramI)
    {
      b += paramF.size();
      int j = v7.v7.package_13.ViewCompat.getLayoutDirection(paramView);
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      int m = paramF.getHeight();
      j = m;
      int k = paramF.getWidth();
      int n = c;
      if (i != 0) {
        m = k;
      }
      c = (n + m);
      m = a;
      if (i == 0) {
        j = k;
      }
      a = (m + j);
      paramI.b(paramView);
      return paramF;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(MenuItem paramMenuItem);
  }
  
  public static abstract interface d
  {
    public abstract boolean showAbout(MenuItem paramMenuItem);
  }
}
