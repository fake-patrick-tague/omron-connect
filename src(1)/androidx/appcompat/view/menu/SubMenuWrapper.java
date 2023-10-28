package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import v7.v7.internal.app.SupportSubMenu;

class SubMenuWrapper
  extends MenuWrapper
  implements SubMenu
{
  private final SupportSubMenu mNativeSubMenu;
  
  SubMenuWrapper(Context paramContext, SupportSubMenu paramSupportSubMenu)
  {
    super(paramContext, paramSupportSubMenu);
    mNativeSubMenu = paramSupportSubMenu;
  }
  
  public void clearHeader()
  {
    mNativeSubMenu.clearHeader();
  }
  
  public MenuItem getItem()
  {
    return getMenuItemWrapper(mNativeSubMenu.getItem());
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    mNativeSubMenu.setHeaderIcon(paramInt);
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    mNativeSubMenu.setHeaderIcon(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    mNativeSubMenu.setHeaderTitle(paramInt);
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    mNativeSubMenu.setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    mNativeSubMenu.setHeaderView(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    mNativeSubMenu.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    mNativeSubMenu.setIcon(paramDrawable);
    return this;
  }
}
