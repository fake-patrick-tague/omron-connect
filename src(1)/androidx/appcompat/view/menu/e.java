package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import v7.internal.R.layout;

public class e
  implements l, AdapterView.OnItemClickListener
{
  int a;
  int b;
  f c;
  ExpandedMenuView d;
  int f;
  a g;
  private l.a k;
  private int l;
  Context mContext;
  LayoutInflater mInflater;
  
  public e(int paramInt1, int paramInt2)
  {
    f = paramInt1;
    b = paramInt2;
  }
  
  public e(Context paramContext, int paramInt)
  {
    this(paramInt, 0);
    mContext = paramContext;
    mInflater = LayoutInflater.from(paramContext);
  }
  
  public ListAdapter a()
  {
    if (g == null) {
      g = new a();
    }
    return g;
  }
  
  public void a(f paramF, boolean paramBoolean)
  {
    l.a localA = k;
    if (localA != null) {
      localA.onCloseMenu(paramF, paramBoolean);
    }
  }
  
  public boolean a(p paramP)
  {
    if (!paramP.hasVisibleItems()) {
      return false;
    }
    new g(paramP).a(null);
    l.a localA = k;
    if (localA != null) {
      localA.onOpenSubMenu(paramP);
    }
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:list");
    if (paramBundle != null) {
      d.restoreHierarchyState(paramBundle);
    }
  }
  
  public boolean collapseItemActionView(f paramF, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean expandItemActionView(f paramF, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return l;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (d == null)
    {
      d = ((ExpandedMenuView)mInflater.inflate(R.layout.abc_expanded_menu_layout, paramViewGroup, false));
      if (g == null) {
        g = new a();
      }
      d.setAdapter(g);
      d.setOnItemClickListener(this);
    }
    return d;
  }
  
  public void initForMenu(Context paramContext, f paramF)
  {
    if (b != 0)
    {
      paramContext = new ContextThemeWrapper(paramContext, b);
      mContext = paramContext;
      mInflater = LayoutInflater.from(paramContext);
    }
    else if (mContext != null)
    {
      mContext = paramContext;
      if (mInflater == null) {
        mInflater = LayoutInflater.from(paramContext);
      }
    }
    c = paramF;
    paramContext = g;
    if (paramContext != null) {
      paramContext.notifyDataSetChanged();
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    c.a(g.a(paramInt), this, 0);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    b((Bundle)paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (d == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    onSaveInstanceState(localBundle);
    return localBundle;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    SparseArray localSparseArray = new SparseArray();
    ExpandedMenuView localExpandedMenuView = d;
    if (localExpandedMenuView != null) {
      localExpandedMenuView.saveHierarchyState(localSparseArray);
    }
    paramBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
  }
  
  public void setCallback(l.a paramA)
  {
    k = paramA;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    a localA = g;
    if (localA != null) {
      localA.notifyDataSetChanged();
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private int b = -1;
    
    public a()
    {
      a();
    }
    
    public MenuItemImpl a(int paramInt)
    {
      ArrayList localArrayList = c.getNonActionItems();
      int i = paramInt + a;
      int j = b;
      paramInt = i;
      if (j >= 0)
      {
        paramInt = i;
        if (i >= j) {
          paramInt = i + 1;
        }
      }
      return (MenuItemImpl)localArrayList.get(paramInt);
    }
    
    void a()
    {
      MenuItemImpl localMenuItemImpl = c.getExpandedItem();
      if (localMenuItemImpl != null)
      {
        ArrayList localArrayList = c.getNonActionItems();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((MenuItemImpl)localArrayList.get(i) == localMenuItemImpl)
          {
            b = i;
            return;
          }
          i += 1;
        }
      }
      b = -1;
    }
    
    public int getCount()
    {
      int i = c.getNonActionItems().size() - a;
      if (b < 0) {
        return i;
      }
      return i - 1;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null)
      {
        paramView = e.this;
        localView = mInflater.inflate(f, paramViewGroup, false);
      }
      ((MenuView.ItemView)localView).initialize(a(paramInt), 0);
      return localView;
    }
    
    public void notifyDataSetChanged()
    {
      a();
      super.notifyDataSetChanged();
    }
  }
}
