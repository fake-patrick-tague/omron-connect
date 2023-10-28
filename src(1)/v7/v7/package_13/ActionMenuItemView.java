package v7.v7.package_13;

import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import v7.v7.R.id;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.package_13.asm.Label;
import v7.v7.package_13.asm.b;

public class ActionMenuItemView
{
  private static final View.AccessibilityDelegate h = new View.AccessibilityDelegate();
  private final View.AccessibilityDelegate b;
  private final View.AccessibilityDelegate c;
  
  public ActionMenuItemView()
  {
    this(h);
  }
  
  public ActionMenuItemView(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    c = paramAccessibilityDelegate;
    b = new AccessibilityDelegateCompatJellyBean.1(this);
  }
  
  private boolean a(int paramInt, View paramView)
  {
    Object localObject = (SparseArray)paramView.getTag(R.id.g);
    if (localObject != null)
    {
      localObject = (WeakReference)((SparseArray)localObject).get(paramInt);
      if (localObject != null)
      {
        localObject = (ClickableSpan)((WeakReference)localObject).get();
        if (a((ClickableSpan)localObject, paramView))
        {
          ((ClickableSpan)localObject).onClick(paramView);
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(ClickableSpan paramClickableSpan, View paramView)
  {
    if (paramClickableSpan != null)
    {
      paramView = AccessibilityNodeInfoCompat.next(paramView.createAccessibilityNodeInfo().getText());
      int i = 0;
      while ((paramView != null) && (i < paramView.length))
      {
        if (paramClickableSpan.equals(paramView[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  static List filter(View paramView)
  {
    List localList = (List)paramView.getTag(R.id.right);
    paramView = localList;
    if (localList == null) {
      paramView = Collections.emptyList();
    }
    return paramView;
  }
  
  public b a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView = Snackbar.getAccessibilityNodeProvider(c, paramView);
      if (paramView != null) {
        return new b(paramView);
      }
    }
    return null;
  }
  
  public void a(View paramView, int paramInt)
  {
    c.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    c.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    c.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat.getInfo());
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    List localList = filter(paramView);
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= localList.size()) {
        break;
      }
      Label localLabel = (Label)localList.get(i);
      if (localLabel.a() == paramInt)
      {
        bool1 = localLabel.a(paramView, paramBundle);
        break;
      }
      i += 1;
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 16) {
        bool2 = Snackbar.performAccessibilityAction(c, paramView, paramInt, paramBundle);
      }
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (paramInt == R.id.width)
      {
        bool1 = bool2;
        if (paramBundle != null) {
          bool1 = a(paramBundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), paramView);
        }
      }
    }
    return bool1;
  }
  
  public boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return c.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  View.AccessibilityDelegate b()
  {
    return b;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return c.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void initialize(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    c.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void setTitle(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    c.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
}
