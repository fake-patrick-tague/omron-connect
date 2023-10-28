package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import com.google.android.material.internal.ParcelableSparseArray;

public class BottomNavigationPresenter
  implements l
{
  private BottomNavigationMenuView b;
  private boolean h = false;
  private androidx.appcompat.view.menu.f mMenu;
  private int profileId;
  
  public BottomNavigationPresenter() {}
  
  public void a(androidx.appcompat.view.menu.f paramF, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    h = paramBoolean;
  }
  
  public boolean a(p paramP)
  {
    return false;
  }
  
  public void bindView(int paramInt)
  {
    profileId = paramInt;
  }
  
  public boolean collapseItemActionView(androidx.appcompat.view.menu.f paramF, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean expandItemActionView(androidx.appcompat.view.menu.f paramF, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return profileId;
  }
  
  public void initForMenu(Context paramContext, androidx.appcompat.view.menu.f paramF)
  {
    mMenu = paramF;
    b.initialize(paramF);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      BottomNavigationMenuView localBottomNavigationMenuView = b;
      paramParcelable = (SavedState)paramParcelable;
      localBottomNavigationMenuView.b(a);
      paramParcelable = com.google.android.material.badge.f.a(b.getContext(), b);
      b.setBadgeDrawables(paramParcelable);
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    a = b.getSelectedItemId();
    b = com.google.android.material.badge.f.a(b.getBadgeDrawables());
    return localSavedState;
  }
  
  public void setOnTimeChangedListener(BottomNavigationMenuView paramBottomNavigationMenuView)
  {
    b = paramBottomNavigationMenuView;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (h) {
      return;
    }
    if (paramBoolean)
    {
      b.a();
      return;
    }
    b.c();
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    int a;
    ParcelableSparseArray b;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      a = paramParcel.readInt();
      b = ((ParcelableSparseArray)paramParcel.readParcelable(SavedState.class.getClassLoader()));
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(a);
      paramParcel.writeParcelable(b, 0);
    }
    
    static final class a
      implements Parcelable.Creator<BottomNavigationPresenter.SavedState>
    {
      a() {}
      
      public BottomNavigationPresenter.SavedState[] a(int paramInt)
      {
        return new BottomNavigationPresenter.SavedState[paramInt];
      }
      
      public BottomNavigationPresenter.SavedState readDate(Parcel paramParcel)
      {
        return new BottomNavigationPresenter.SavedState(paramParcel);
      }
    }
  }
}
