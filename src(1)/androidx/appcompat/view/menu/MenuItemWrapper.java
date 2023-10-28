package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

public class MenuItemWrapper
  extends BaseMenuWrapper
  implements android.view.MenuItem
{
  private final v7.v7.internal.app.MenuItem mNativeItem;
  private Method mSetExclusiveCheckableMethod;
  
  public MenuItemWrapper(Context paramContext, v7.v7.internal.app.MenuItem paramMenuItem)
  {
    super(paramContext);
    if (paramMenuItem != null)
    {
      mNativeItem = paramMenuItem;
      return;
    }
    throw new IllegalArgumentException("Wrapped Object can not be null.");
  }
  
  public boolean collapseActionView()
  {
    return mNativeItem.collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return mNativeItem.expandActionView();
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    v7.v7.package_13.ActionProvider localActionProvider = mNativeItem.getSupportActionProvider();
    if ((localActionProvider instanceof MenuItemWrapperICS.ActionProviderWrapper)) {
      return mInner;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = mNativeItem.getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof MenuItemWrapperICS.CollapsibleActionViewWrapper)) {
      localView1 = ((MenuItemWrapperICS.CollapsibleActionViewWrapper)localView2).getWrappedView();
    }
    return localView1;
  }
  
  public int getAlphabeticModifiers()
  {
    return mNativeItem.getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return mNativeItem.getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return mNativeItem.getContentDescription();
  }
  
  public int getGroupId()
  {
    return mNativeItem.getGroupId();
  }
  
  public Drawable getIcon()
  {
    return mNativeItem.getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return mNativeItem.getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return mNativeItem.getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return mNativeItem.getIntent();
  }
  
  public int getItemId()
  {
    return mNativeItem.getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return mNativeItem.getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return mNativeItem.getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return mNativeItem.getNumericShortcut();
  }
  
  public int getOrder()
  {
    return mNativeItem.getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return getSubMenuWrapper(mNativeItem.getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return mNativeItem.getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return mNativeItem.getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return mNativeItem.getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return mNativeItem.hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return mNativeItem.isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return mNativeItem.isCheckable();
  }
  
  public boolean isChecked()
  {
    return mNativeItem.isChecked();
  }
  
  public boolean isEnabled()
  {
    return mNativeItem.isEnabled();
  }
  
  public boolean isVisible()
  {
    return mNativeItem.isVisible();
  }
  
  public android.view.MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a3 = a2\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  public android.view.MenuItem setActionView(int paramInt)
  {
    mNativeItem.setActionView(paramInt);
    View localView = mNativeItem.getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      mNativeItem.setActionView(new MenuItemWrapperICS.CollapsibleActionViewWrapper(localView));
    }
    return this;
  }
  
  public android.view.MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new MenuItemWrapperICS.CollapsibleActionViewWrapper(paramView);
    }
    mNativeItem.setActionView((View)localObject);
    return this;
  }
  
  public android.view.MenuItem setAlphabeticShortcut(char paramChar)
  {
    mNativeItem.setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public android.view.MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    mNativeItem.setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public android.view.MenuItem setCheckable(boolean paramBoolean)
  {
    mNativeItem.setCheckable(paramBoolean);
    return this;
  }
  
  public android.view.MenuItem setChecked(boolean paramBoolean)
  {
    mNativeItem.setChecked(paramBoolean);
    return this;
  }
  
  public android.view.MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    mNativeItem.setContentDescription(paramCharSequence);
    return this;
  }
  
  public android.view.MenuItem setEnabled(boolean paramBoolean)
  {
    mNativeItem.setEnabled(paramBoolean);
    return this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean)
  {
    Object localObject1;
    if (mSetExclusiveCheckableMethod == null) {
      localObject1 = mNativeItem;
    }
    try
    {
      localObject1 = localObject1.getClass();
      Object localObject2 = Boolean.TYPE;
      localObject1 = ((Class)localObject1).getDeclaredMethod("setExclusiveCheckable", new Class[] { localObject2 });
      mSetExclusiveCheckableMethod = ((Method)localObject1);
      localObject1 = mSetExclusiveCheckableMethod;
      localObject2 = mNativeItem;
      ((Method)localObject1).invoke(localObject2, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
    }
  }
  
  public android.view.MenuItem setIcon(int paramInt)
  {
    mNativeItem.setIcon(paramInt);
    return this;
  }
  
  public android.view.MenuItem setIcon(Drawable paramDrawable)
  {
    mNativeItem.setIcon(paramDrawable);
    return this;
  }
  
  public android.view.MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    mNativeItem.setIconTintList(paramColorStateList);
    return this;
  }
  
  public android.view.MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    mNativeItem.setIconTintMode(paramMode);
    return this;
  }
  
  public android.view.MenuItem setIntent(Intent paramIntent)
  {
    mNativeItem.setIntent(paramIntent);
    return this;
  }
  
  public android.view.MenuItem setNumericShortcut(char paramChar)
  {
    mNativeItem.setNumericShortcut(paramChar);
    return this;
  }
  
  public android.view.MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    mNativeItem.setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public android.view.MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    v7.v7.internal.app.MenuItem localMenuItem = mNativeItem;
    if (paramOnActionExpandListener != null) {
      paramOnActionExpandListener = new MenuItemCompatIcs.OnActionExpandListenerWrapper(this, paramOnActionExpandListener);
    } else {
      paramOnActionExpandListener = null;
    }
    localMenuItem.setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public android.view.MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    v7.v7.internal.app.MenuItem localMenuItem = mNativeItem;
    if (paramOnMenuItemClickListener != null) {
      paramOnMenuItemClickListener = new MenuItemWrapperICS.OnMenuItemClickListenerWrapper(this, paramOnMenuItemClickListener);
    } else {
      paramOnMenuItemClickListener = null;
    }
    localMenuItem.setOnMenuItemClickListener(paramOnMenuItemClickListener);
    return this;
  }
  
  public android.view.MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    mNativeItem.setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public android.view.MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    mNativeItem.setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    mNativeItem.setShowAsAction(paramInt);
  }
  
  public android.view.MenuItem setShowAsActionFlags(int paramInt)
  {
    mNativeItem.setShowAsActionFlags(paramInt);
    return this;
  }
  
  public android.view.MenuItem setTitle(int paramInt)
  {
    mNativeItem.setTitle(paramInt);
    return this;
  }
  
  public android.view.MenuItem setTitle(CharSequence paramCharSequence)
  {
    mNativeItem.setTitle(paramCharSequence);
    return this;
  }
  
  public android.view.MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    mNativeItem.setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public android.view.MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    mNativeItem.setTooltipText(paramCharSequence);
    return this;
  }
  
  public android.view.MenuItem setVisible(boolean paramBoolean)
  {
    return mNativeItem.setVisible(paramBoolean);
  }
}
