package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import c.h.q.f;
import java.util.Map;
import java.util.WeakHashMap;
import v7.v7.package_13.ActionMenuItemView;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.package_13.asm.b;

public class e
  extends ActionMenuItemView
{
  final m a;
  private Map<View, f> c = new WeakHashMap();
  
  public e(m paramM)
  {
    a = paramM;
  }
  
  public b a(View paramView)
  {
    ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)c.get(paramView);
    if (localActionMenuItemView != null) {
      return localActionMenuItemView.a(paramView);
    }
    return super.a(paramView);
  }
  
  public void a(View paramView, int paramInt)
  {
    ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)c.get(paramView);
    if (localActionMenuItemView != null)
    {
      localActionMenuItemView.a(paramView, paramInt);
      return;
    }
    super.a(paramView, paramInt);
  }
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)c.get(paramView);
    if (localActionMenuItemView != null)
    {
      localActionMenuItemView.a(paramView, paramAccessibilityEvent);
      return;
    }
    super.a(paramView, paramAccessibilityEvent);
  }
  
  public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if ((!a.g()) && (a.l.getLayoutManager() != null))
    {
      a.l.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)c.get(paramView);
      if (localActionMenuItemView != null)
      {
        localActionMenuItemView.a(paramView, paramAccessibilityNodeInfoCompat);
        return;
      }
      super.a(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    super.a(paramView, paramAccessibilityNodeInfoCompat);
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if ((!a.g()) && (a.l.getLayoutManager() != null))
    {
      ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)c.get(paramView);
      if (localActionMenuItemView != null)
      {
        if (localActionMenuItemView.a(paramView, paramInt, paramBundle)) {
          return true;
        }
      }
      else if (super.a(paramView, paramInt, paramBundle)) {
        return true;
      }
      return a.l.getLayoutManager().performAccessibilityAction(paramView, paramInt, paramBundle);
    }
    return super.a(paramView, paramInt, paramBundle);
  }
  
  public boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)c.get(paramViewGroup);
    if (localActionMenuItemView != null) {
      return localActionMenuItemView.a(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    return super.a(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  ActionMenuItemView b(View paramView)
  {
    return (ActionMenuItemView)c.remove(paramView);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)c.get(paramView);
    if (localActionMenuItemView != null) {
      return localActionMenuItemView.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void initialize(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)c.get(paramView);
    if (localActionMenuItemView != null)
    {
      localActionMenuItemView.initialize(paramView, paramAccessibilityEvent);
      return;
    }
    super.initialize(paramView, paramAccessibilityEvent);
  }
  
  void onSaveInstanceState(View paramView)
  {
    ActionMenuItemView localActionMenuItemView = ViewCompat.a(paramView);
    if ((localActionMenuItemView != null) && (localActionMenuItemView != this)) {
      c.put(paramView, localActionMenuItemView);
    }
  }
  
  public void setTitle(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)c.get(paramView);
    if (localActionMenuItemView != null)
    {
      localActionMenuItemView.setTitle(paramView, paramAccessibilityEvent);
      return;
    }
    super.setTitle(paramView, paramAccessibilityEvent);
  }
}
