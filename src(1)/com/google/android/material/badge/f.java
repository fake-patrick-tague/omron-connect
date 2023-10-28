package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import com.google.android.material.internal.ParcelableSparseArray;

public class f
{
  public static final boolean c;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = true;
    } else {
      bool = false;
    }
    c = bool;
  }
  
  public static SparseArray a(Context paramContext, ParcelableSparseArray paramParcelableSparseArray)
  {
    SparseArray localSparseArray = new SparseArray(paramParcelableSparseArray.size());
    int i = 0;
    while (i < paramParcelableSparseArray.size())
    {
      int j = paramParcelableSparseArray.keyAt(i);
      BadgeDrawable.SavedState localSavedState = (BadgeDrawable.SavedState)paramParcelableSparseArray.valueAt(i);
      if (localSavedState != null)
      {
        localSparseArray.put(j, BadgeDrawable.f(paramContext, localSavedState));
        i += 1;
      }
      else
      {
        throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
      }
    }
    return localSparseArray;
  }
  
  public static ParcelableSparseArray a(SparseArray paramSparseArray)
  {
    ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      BadgeDrawable localBadgeDrawable = (BadgeDrawable)paramSparseArray.valueAt(i);
      if (localBadgeDrawable != null)
      {
        localParcelableSparseArray.put(j, localBadgeDrawable.p());
        i += 1;
      }
      else
      {
        throw new IllegalArgumentException("badgeDrawable cannot be null");
      }
    }
    return localParcelableSparseArray;
  }
  
  public static void a(BadgeDrawable paramBadgeDrawable, View paramView, FrameLayout paramFrameLayout)
  {
    Rect localRect = new Rect();
    paramView.getDrawingRect(localRect);
    paramBadgeDrawable.setBounds(localRect);
    paramBadgeDrawable.b(paramView, paramFrameLayout);
  }
  
  public static void add(Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramRect.set((int)(paramFloat1 - paramFloat3), (int)(paramFloat2 - paramFloat4), (int)(paramFloat1 + paramFloat3), (int)(paramFloat2 + paramFloat4));
  }
  
  public static void b(BadgeDrawable paramBadgeDrawable, View paramView)
  {
    if (paramBadgeDrawable == null) {
      return;
    }
    if ((!c) && (paramBadgeDrawable.c() == null))
    {
      paramView.getOverlay().remove(paramBadgeDrawable);
      return;
    }
    paramBadgeDrawable.c().setForeground(null);
  }
  
  public static void b(BadgeDrawable paramBadgeDrawable, View paramView, FrameLayout paramFrameLayout)
  {
    a(paramBadgeDrawable, paramView, paramFrameLayout);
    if (paramBadgeDrawable.c() != null)
    {
      paramBadgeDrawable.c().setForeground(paramBadgeDrawable);
      return;
    }
    if (!c)
    {
      paramView.getOverlay().add(paramBadgeDrawable);
      return;
    }
    throw new IllegalArgumentException("Trying to reference null customBadgeParent");
  }
}
