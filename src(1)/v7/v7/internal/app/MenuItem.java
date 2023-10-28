package v7.v7.internal.app;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import v7.v7.package_13.ActionProvider;

public abstract interface MenuItem
  extends android.view.MenuItem
{
  public abstract boolean collapseActionView();
  
  public abstract boolean expandActionView();
  
  public abstract View getActionView();
  
  public abstract int getAlphabeticModifiers();
  
  public abstract CharSequence getContentDescription();
  
  public abstract ColorStateList getIconTintList();
  
  public abstract PorterDuff.Mode getIconTintMode();
  
  public abstract int getNumericModifiers();
  
  public abstract ActionProvider getSupportActionProvider();
  
  public abstract CharSequence getTooltipText();
  
  public abstract boolean isActionViewExpanded();
  
  public abstract android.view.MenuItem setActionView(int paramInt);
  
  public abstract android.view.MenuItem setActionView(View paramView);
  
  public abstract android.view.MenuItem setAlphabeticShortcut(char paramChar, int paramInt);
  
  public abstract MenuItem setContentDescription(CharSequence paramCharSequence);
  
  public abstract android.view.MenuItem setIconTintList(ColorStateList paramColorStateList);
  
  public abstract android.view.MenuItem setIconTintMode(PorterDuff.Mode paramMode);
  
  public abstract android.view.MenuItem setNumericShortcut(char paramChar, int paramInt);
  
  public abstract android.view.MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2);
  
  public abstract void setShowAsAction(int paramInt);
  
  public abstract android.view.MenuItem setShowAsActionFlags(int paramInt);
  
  public abstract MenuItem setSupportActionProvider(ActionProvider paramActionProvider);
  
  public abstract MenuItem setTooltipText(CharSequence paramCharSequence);
}
