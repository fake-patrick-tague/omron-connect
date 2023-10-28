package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.SubMenu;
import c.e.g;
import c.h.j.a.b;
import c.h.j.a.c;
import v7.util.SimpleArrayMap;
import v7.v7.internal.app.SupportSubMenu;

abstract class BaseMenuWrapper
{
  final Context mContext;
  private g<b, android.view.MenuItem> mMenuItems;
  private g<c, SubMenu> mSubMenus;
  
  BaseMenuWrapper(Context paramContext)
  {
    mContext = paramContext;
  }
  
  final void a(int paramInt)
  {
    if (mMenuItems == null) {
      return;
    }
    int j;
    for (int i = 0; i < mMenuItems.size(); i = j + 1)
    {
      j = i;
      if (((v7.v7.internal.app.MenuItem)mMenuItems.size(i)).getGroupId() == paramInt)
      {
        mMenuItems.removeAt(i);
        j = i - 1;
      }
    }
  }
  
  final void c(int paramInt)
  {
    if (mMenuItems == null) {
      return;
    }
    int i = 0;
    while (i < mMenuItems.size())
    {
      if (((v7.v7.internal.app.MenuItem)mMenuItems.size(i)).getItemId() == paramInt)
      {
        mMenuItems.removeAt(i);
        return;
      }
      i += 1;
    }
  }
  
  final android.view.MenuItem getMenuItemWrapper(android.view.MenuItem paramMenuItem)
  {
    android.view.MenuItem localMenuItem = paramMenuItem;
    if ((paramMenuItem instanceof v7.v7.internal.app.MenuItem))
    {
      v7.v7.internal.app.MenuItem localMenuItem1 = (v7.v7.internal.app.MenuItem)paramMenuItem;
      if (mMenuItems == null) {
        mMenuItems = new SimpleArrayMap();
      }
      paramMenuItem = (android.view.MenuItem)mMenuItems.get(localMenuItem1);
      localMenuItem = paramMenuItem;
      if (paramMenuItem == null)
      {
        paramMenuItem = new MenuItemWrapper(mContext, localMenuItem1);
        mMenuItems.put(localMenuItem1, paramMenuItem);
        return paramMenuItem;
      }
    }
    return localMenuItem;
  }
  
  final SubMenu getSubMenuWrapper(SubMenu paramSubMenu)
  {
    SubMenu localSubMenu = paramSubMenu;
    if ((paramSubMenu instanceof SupportSubMenu))
    {
      SupportSubMenu localSupportSubMenu = (SupportSubMenu)paramSubMenu;
      if (mSubMenus == null) {
        mSubMenus = new SimpleArrayMap();
      }
      paramSubMenu = (SubMenu)mSubMenus.get(localSupportSubMenu);
      localSubMenu = paramSubMenu;
      if (paramSubMenu == null)
      {
        paramSubMenu = new SubMenuWrapper(mContext, localSupportSubMenu);
        mSubMenus.put(localSupportSubMenu, paramSubMenu);
        return paramSubMenu;
      }
    }
    return localSubMenu;
  }
  
  final void internalClear()
  {
    SimpleArrayMap localSimpleArrayMap = mMenuItems;
    if (localSimpleArrayMap != null) {
      localSimpleArrayMap.clear();
    }
    localSimpleArrayMap = mSubMenus;
    if (localSimpleArrayMap != null) {
      localSimpleArrayMap.clear();
    }
  }
}
