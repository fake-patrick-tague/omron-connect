package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.f;

public final class MenuWrapper
  extends f
{
  public MenuWrapper(Context paramContext)
  {
    super(paramContext);
  }
  
  protected MenuItem addInternal(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    if (size() + 1 <= 5)
    {
      stopDispatchingItemsChanged();
      paramCharSequence = super.addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
      if ((paramCharSequence instanceof MenuItemImpl)) {
        ((MenuItemImpl)paramCharSequence).setExclusiveCheckable(true);
      }
      startDispatchingItemsChanged();
      return paramCharSequence;
    }
    throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
  }
}
