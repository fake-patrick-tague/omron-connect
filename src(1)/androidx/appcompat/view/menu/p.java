package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class p
  extends f
  implements SubMenu
{
  private MenuItemImpl mItem;
  private f mParentMenu;
  
  public p(Context paramContext, f paramF, MenuItemImpl paramMenuItemImpl)
  {
    super(paramContext);
    mParentMenu = paramF;
    mItem = paramMenuItemImpl;
  }
  
  public String a()
  {
    Object localObject = mItem;
    int i;
    if (localObject != null) {
      i = ((MenuItemImpl)localObject).getItemId();
    } else {
      i = 0;
    }
    if (i == 0) {
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(super.a());
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(i);
    return ((StringBuilder)localObject).toString();
  }
  
  public boolean c()
  {
    return mParentMenu.c();
  }
  
  public boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    return mParentMenu.collapseItemActionView(paramMenuItemImpl);
  }
  
  boolean dispatchMenuItemSelected(f paramF, MenuItem paramMenuItem)
  {
    return (super.dispatchMenuItemSelected(paramF, paramMenuItem)) || (mParentMenu.dispatchMenuItemSelected(paramF, paramMenuItem));
  }
  
  public boolean expandItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    return mParentMenu.expandItemActionView(paramMenuItemImpl);
  }
  
  public MenuItem getItem()
  {
    return mItem;
  }
  
  public f getRootMenu()
  {
    return mParentMenu.getRootMenu();
  }
  
  public boolean isQwertyMode()
  {
    return mParentMenu.isQwertyMode();
  }
  
  public boolean isShortcutsVisible()
  {
    return mParentMenu.isShortcutsVisible();
  }
  
  public Menu s()
  {
    return mParentMenu;
  }
  
  public void setCallback(MenuBuilder.Callback paramCallback)
  {
    mParentMenu.setCallback(paramCallback);
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    mParentMenu.setGroupDividerEnabled(paramBoolean);
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    return (SubMenu)super.setHeaderIconInt(paramInt);
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    return (SubMenu)super.setHeaderIconInt(paramDrawable);
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    return (SubMenu)super.setHeaderTitleInt(paramInt);
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    return (SubMenu)super.setHeaderTitleInt(paramCharSequence);
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    return (SubMenu)super.setHeaderViewInt(paramView);
  }
  
  public SubMenu setIcon(int paramInt)
  {
    mItem.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    mItem.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    mParentMenu.setQwertyMode(paramBoolean);
  }
}
