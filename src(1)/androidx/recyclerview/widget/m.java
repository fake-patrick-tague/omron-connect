package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import v7.v7.package_13.ActionMenuItemView;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;

public class m
  extends ActionMenuItemView
{
  private final e a;
  final RecyclerView l;
  
  public m(RecyclerView paramRecyclerView)
  {
    l = paramRecyclerView;
    paramRecyclerView = a();
    if ((paramRecyclerView != null) && ((paramRecyclerView instanceof e)))
    {
      a = ((e)paramRecyclerView);
      return;
    }
    a = new e(this);
  }
  
  public ActionMenuItemView a()
  {
    return a;
  }
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    if (((paramView instanceof RecyclerView)) && (!g()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().onInitializeAccessibilityEvent(paramAccessibilityEvent);
      }
    }
  }
  
  public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.a(paramView, paramAccessibilityNodeInfoCompat);
    if ((!g()) && (l.getLayoutManager() != null)) {
      l.getLayoutManager().onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfoCompat);
    }
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.a(paramView, paramInt, paramBundle)) {
      return true;
    }
    if ((!g()) && (l.getLayoutManager() != null)) {
      return l.getLayoutManager().b(paramInt, paramBundle);
    }
    return false;
  }
  
  boolean g()
  {
    return l.hasPendingAdapterUpdates();
  }
}
