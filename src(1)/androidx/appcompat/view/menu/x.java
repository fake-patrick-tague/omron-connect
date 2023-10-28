package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class x
  extends BaseAdapter
{
  private final boolean a;
  f b;
  private int c = -1;
  private final int d;
  private boolean f;
  private final LayoutInflater i;
  
  public x(f paramF, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    a = paramBoolean;
    i = paramLayoutInflater;
    b = paramF;
    d = paramInt;
    a();
  }
  
  public MenuItemImpl a(int paramInt)
  {
    ArrayList localArrayList;
    if (a) {
      localArrayList = b.getNonActionItems();
    } else {
      localArrayList = b.getVisibleItems();
    }
    int k = c;
    int j = paramInt;
    if (k >= 0)
    {
      j = paramInt;
      if (paramInt >= k) {
        j = paramInt + 1;
      }
    }
    return (MenuItemImpl)localArrayList.get(j);
  }
  
  void a()
  {
    MenuItemImpl localMenuItemImpl = b.getExpandedItem();
    if (localMenuItemImpl != null)
    {
      ArrayList localArrayList = b.getNonActionItems();
      int k = localArrayList.size();
      int j = 0;
      while (j < k)
      {
        if ((MenuItemImpl)localArrayList.get(j) == localMenuItemImpl)
        {
          c = j;
          return;
        }
        j += 1;
      }
    }
    c = -1;
  }
  
  public void a(boolean paramBoolean)
  {
    f = paramBoolean;
  }
  
  public int getCount()
  {
    ArrayList localArrayList;
    if (a) {
      localArrayList = b.getNonActionItems();
    } else {
      localArrayList = b.getVisibleItems();
    }
    if (c < 0) {
      return localArrayList.size();
    }
    return localArrayList.size() - 1;
  }
  
  public f getItem()
  {
    return b;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = i.inflate(d, paramViewGroup, false);
    }
    int k = a(paramInt).getGroupId();
    int j = paramInt - 1;
    if (j >= 0) {
      j = a(j).getGroupId();
    } else {
      j = k;
    }
    paramView = (ListMenuItemView)localView;
    boolean bool;
    if ((b.c()) && (k != j)) {
      bool = true;
    } else {
      bool = false;
    }
    paramView.setGroupDividerEnabled(bool);
    paramViewGroup = (MenuView.ItemView)localView;
    if (f) {
      paramView.setForceShowIcon(true);
    }
    paramViewGroup.initialize(a(paramInt), 0);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}
