package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  implements l
{
  private int g;
  private l.a mCallback;
  protected Context mContext;
  protected LayoutInflater mInflater;
  private int mItemLayoutRes;
  protected f mMenu;
  private int mMenuLayoutRes;
  protected MenuView mMenuView;
  protected Context mSystemContext;
  protected LayoutInflater mSystemInflater;
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    mSystemContext = paramContext;
    mSystemInflater = LayoutInflater.from(paramContext);
    mMenuLayoutRes = paramInt1;
    mItemLayoutRes = paramInt2;
  }
  
  public void a(int paramInt)
  {
    g = paramInt;
  }
  
  public void a(f paramF, boolean paramBoolean)
  {
    l.a localA = mCallback;
    if (localA != null) {
      localA.onCloseMenu(paramF, paramBoolean);
    }
  }
  
  public boolean a(p paramP)
  {
    l.a localA = mCallback;
    if (localA != null)
    {
      if (paramP == null) {
        paramP = mMenu;
      }
      return localA.onOpenSubMenu(paramP);
    }
    return false;
  }
  
  protected void addItemView(View paramView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramView);
    }
    ((ViewGroup)mMenuView).addView(paramView, paramInt);
  }
  
  public abstract void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView);
  
  public boolean collapseItemActionView(f paramF, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public MenuView.ItemView createItemView(ViewGroup paramViewGroup)
  {
    return (MenuView.ItemView)mSystemInflater.inflate(mItemLayoutRes, paramViewGroup, false);
  }
  
  public boolean expandItemActionView(f paramF, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  protected boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public l.a getCallback()
  {
    return mCallback;
  }
  
  public int getId()
  {
    return g;
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof MenuView.ItemView)) {
      paramView = (MenuView.ItemView)paramView;
    } else {
      paramView = createItemView(paramViewGroup);
    }
    bindItemView(paramMenuItemImpl, paramView);
    return (View)paramView;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (mMenuView == null)
    {
      paramViewGroup = (MenuView)mSystemInflater.inflate(mMenuLayoutRes, paramViewGroup, false);
      mMenuView = paramViewGroup;
      paramViewGroup.initialize(mMenu);
      updateMenuView(true);
    }
    return mMenuView;
  }
  
  public void initForMenu(Context paramContext, f paramF)
  {
    mContext = paramContext;
    mInflater = LayoutInflater.from(paramContext);
    mMenu = paramF;
  }
  
  public void setCallback(l.a paramA)
  {
    mCallback = paramA;
  }
  
  public abstract boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl);
  
  public void updateMenuView(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)mMenuView;
    if (localViewGroup == null) {
      return;
    }
    Object localObject = mMenu;
    int i = 0;
    if (localObject != null)
    {
      ((f)localObject).flagActionItems();
      ArrayList localArrayList = mMenu.getVisibleItems();
      int m = localArrayList.size();
      int j = 0;
      int k;
      for (i = 0; j < m; i = k)
      {
        MenuItemImpl localMenuItemImpl = (MenuItemImpl)localArrayList.get(j);
        k = i;
        if (shouldIncludeItem(i, localMenuItemImpl))
        {
          View localView1 = localViewGroup.getChildAt(i);
          if ((localView1 instanceof MenuView.ItemView)) {
            localObject = ((MenuView.ItemView)localView1).getItemData();
          } else {
            localObject = null;
          }
          View localView2 = getItemView(localMenuItemImpl, localView1, localViewGroup);
          if (localMenuItemImpl != localObject)
          {
            localView2.setPressed(false);
            localView2.jumpDrawablesToCurrentState();
          }
          if (localView2 != localView1) {
            addItemView(localView2, i);
          }
          k = i + 1;
        }
        j += 1;
      }
    }
    while (i < localViewGroup.getChildCount()) {
      if (!filterLeftoverView(localViewGroup, i)) {
        i += 1;
      }
    }
  }
}
