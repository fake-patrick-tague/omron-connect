package v7.view.asm;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityRecord;
import c.e.h;
import c.h.q.p0.c;
import c.j.a.b.a;
import c.j.a.b.b;
import java.util.ArrayList;
import java.util.List;
import v7.util.Label;
import v7.v7.package_13.ActionMenuItemView;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.ViewParentCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.package_13.asm.ClassReader;
import v7.v7.package_13.asm.b;

public abstract class i
  extends ActionMenuItemView
{
  private static final b.a<c> c = new Type();
  private static final b.b<h<c>, c> d = new e();
  private static final Rect r = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
  private final View a;
  private final int[] b = new int[2];
  private final Rect e = new Rect();
  private final Rect f = new Rect();
  private final Rect g = new Rect();
  private final AccessibilityManager h;
  int j = Integer.MIN_VALUE;
  int k = Integer.MIN_VALUE;
  private int n = Integer.MIN_VALUE;
  private f o;
  
  public i(View paramView)
  {
    if (paramView != null)
    {
      a = paramView;
      h = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
      paramView.setFocusable(true);
      if (ViewCompat.getImportantForAccessibility(paramView) == 0) {
        ViewCompat.get(paramView, 1);
      }
    }
    else
    {
      throw new IllegalArgumentException("View may not be null");
    }
  }
  
  private static Rect a(View paramView, int paramInt, Rect paramRect)
  {
    int i = paramView.getWidth();
    int m = paramView.getHeight();
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130)
          {
            paramRect.set(0, -1, i, -1);
            return paramRect;
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        paramRect.set(-1, 0, -1, m);
        return paramRect;
      }
      paramRect.set(0, m, i, m);
      return paramRect;
    }
    paramRect.set(i, 0, i, m);
    return paramRect;
  }
  
  private Label a()
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList);
    Label localLabel = new Label();
    int i = 0;
    while (i < localArrayList.size())
    {
      localLabel.a(i, a(i));
      i += 1;
    }
    return localLabel;
  }
  
  private AccessibilityNodeInfoCompat a(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    localAccessibilityNodeInfoCompat.setEnabled(true);
    localAccessibilityNodeInfoCompat.getText(true);
    localAccessibilityNodeInfoCompat.getText("android.view.View");
    Object localObject = r;
    localAccessibilityNodeInfoCompat.setText((Rect)localObject);
    localAccessibilityNodeInfoCompat.setBoundsInScreen((Rect)localObject);
    localAccessibilityNodeInfoCompat.addChild(a);
    a(paramInt, localAccessibilityNodeInfoCompat);
    if ((localAccessibilityNodeInfoCompat.getText() == null) && (localAccessibilityNodeInfoCompat.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    localAccessibilityNodeInfoCompat.getBoundsInParent(g);
    if (!g.equals(localObject))
    {
      int i = localAccessibilityNodeInfoCompat.getActions();
      if ((i & 0x40) == 0)
      {
        if ((i & 0x80) == 0)
        {
          localAccessibilityNodeInfoCompat.setPackageName(a.getContext().getPackageName());
          localAccessibilityNodeInfoCompat.obtain(a, paramInt);
          if (j == paramInt)
          {
            localAccessibilityNodeInfoCompat.isEnabled(true);
            localAccessibilityNodeInfoCompat.addAction(128);
          }
          else
          {
            localAccessibilityNodeInfoCompat.isEnabled(false);
            localAccessibilityNodeInfoCompat.addAction(64);
          }
          boolean bool;
          if (k == paramInt) {
            bool = true;
          } else {
            bool = false;
          }
          if (bool) {
            localAccessibilityNodeInfoCompat.addAction(2);
          } else if (localAccessibilityNodeInfoCompat.isFocusable()) {
            localAccessibilityNodeInfoCompat.addAction(1);
          }
          localAccessibilityNodeInfoCompat.setFocused(bool);
          a.getLocationOnScreen(b);
          localAccessibilityNodeInfoCompat.getBoundsInScreen(f);
          if (f.equals(localObject))
          {
            localAccessibilityNodeInfoCompat.getBoundsInParent(f);
            if (b != -1)
            {
              localObject = AccessibilityNodeInfoCompat.obtain();
              for (paramInt = b; paramInt != -1; paramInt = b)
              {
                ((AccessibilityNodeInfoCompat)localObject).setParent(a, -1);
                ((AccessibilityNodeInfoCompat)localObject).setText(r);
                a(paramInt, (AccessibilityNodeInfoCompat)localObject);
                ((AccessibilityNodeInfoCompat)localObject).getBoundsInParent(g);
                Rect localRect1 = f;
                Rect localRect2 = g;
                localRect1.offset(left, top);
              }
              ((AccessibilityNodeInfoCompat)localObject).recycle();
            }
            f.offset(b[0] - a.getScrollX(), b[1] - a.getScrollY());
          }
          if (a.getLocalVisibleRect(e))
          {
            e.offset(b[0] - a.getScrollX(), b[1] - a.getScrollY());
            if (f.intersect(e))
            {
              localAccessibilityNodeInfoCompat.setBoundsInScreen(f);
              if (intersectVisibleToUser(f))
              {
                localAccessibilityNodeInfoCompat.setVisibleToUser(true);
                return localAccessibilityNodeInfoCompat;
              }
            }
          }
        }
        else
        {
          throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
      }
      else {
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
      }
    }
    else
    {
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }
    return localAccessibilityNodeInfoCompat;
  }
  
  private boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 64)
        {
          if (paramInt2 != 128) {
            return b(paramInt1, paramInt2, paramBundle);
          }
          return add(paramInt1);
        }
        return f(paramInt1);
      }
      return b(paramInt1);
    }
    return c(paramInt1);
  }
  
  private boolean a(int paramInt, Rect paramRect)
  {
    Label localLabel = a();
    int m = k;
    int i = Integer.MIN_VALUE;
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat;
    if (m == Integer.MIN_VALUE) {
      localAccessibilityNodeInfoCompat = null;
    } else {
      localAccessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)localLabel.get(m);
    }
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 17) && (paramInt != 33) && (paramInt != 66) && (paramInt != 130)) {
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      }
      Rect localRect = new Rect();
      m = k;
      if (m != Integer.MIN_VALUE) {
        add(m, localRect);
      } else if (paramRect != null) {
        localRect.set(paramRect);
      } else {
        a(a, paramInt, localRect);
      }
      paramRect = (AccessibilityNodeInfoCompat)ByteVector.a(localLabel, d, c, localAccessibilityNodeInfoCompat, localRect, paramInt);
    }
    else
    {
      boolean bool;
      if (ViewCompat.getLayoutDirection(a) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramRect = (AccessibilityNodeInfoCompat)ByteVector.a(localLabel, d, c, localAccessibilityNodeInfoCompat, paramInt, bool, false);
    }
    if (paramRect == null) {
      paramInt = i;
    } else {
      paramInt = localLabel.toString(localLabel.a(paramRect));
    }
    return c(paramInt);
  }
  
  private AccessibilityNodeInfoCompat add()
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(a);
    ViewCompat.onInitializeAccessibilityNodeInfo(a, localAccessibilityNodeInfoCompat);
    ArrayList localArrayList = new ArrayList();
    a(localArrayList);
    if ((localAccessibilityNodeInfoCompat.getChildCount() > 0) && (localArrayList.size() > 0)) {
      throw new RuntimeException("Views cannot have both real and virtual children");
    }
    int i = 0;
    int m = localArrayList.size();
    while (i < m)
    {
      localAccessibilityNodeInfoCompat.addChild(a, ((Integer)localArrayList.get(i)).intValue());
      i += 1;
    }
    return localAccessibilityNodeInfoCompat;
  }
  
  private void add(int paramInt, Rect paramRect)
  {
    obtain(paramInt).getBoundsInParent(paramRect);
  }
  
  private boolean add(int paramInt)
  {
    if (j == paramInt)
    {
      j = Integer.MIN_VALUE;
      a.invalidate();
      a(paramInt, 65536);
      return true;
    }
    return false;
  }
  
  private boolean b(int paramInt, Bundle paramBundle)
  {
    return ViewCompat.c(a, paramInt, paramBundle);
  }
  
  private AccessibilityEvent createEvent(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {
      return createEventForChild(paramInt1, paramInt2);
    }
    return createEventForHost(paramInt2);
  }
  
  private AccessibilityEvent createEventForChild(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = obtain(paramInt1);
    localAccessibilityEvent.getText().add(localAccessibilityNodeInfoCompat.getText());
    localAccessibilityEvent.setContentDescription(localAccessibilityNodeInfoCompat.getContentDescription());
    localAccessibilityEvent.setScrollable(localAccessibilityNodeInfoCompat.isScrollable());
    localAccessibilityEvent.setPassword(localAccessibilityNodeInfoCompat.isPassword());
    localAccessibilityEvent.setEnabled(localAccessibilityNodeInfoCompat.isEnabled());
    localAccessibilityEvent.setChecked(localAccessibilityNodeInfoCompat.isChecked());
    add(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }
    localAccessibilityEvent.setClassName(localAccessibilityNodeInfoCompat.getClassName());
    ClassReader.a(localAccessibilityEvent, a, paramInt1);
    localAccessibilityEvent.setPackageName(a.getContext().getPackageName());
    return localAccessibilityEvent;
  }
  
  private AccessibilityEvent createEventForHost(int paramInt)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
    a.onInitializeAccessibilityEvent(localAccessibilityEvent);
    return localAccessibilityEvent;
  }
  
  private void d(int paramInt)
  {
    int i = n;
    if (i == paramInt) {
      return;
    }
    n = paramInt;
    a(paramInt, 128);
    a(i, 256);
  }
  
  private boolean f(int paramInt)
  {
    if (h.isEnabled())
    {
      if (!h.isTouchExplorationEnabled()) {
        return false;
      }
      int i = j;
      if (i != paramInt)
      {
        if (i != Integer.MIN_VALUE) {
          add(i);
        }
        j = paramInt;
        a.invalidate();
        a(paramInt, 32768);
        return true;
      }
    }
    return false;
  }
  
  private boolean g()
  {
    int i = k;
    return (i != Integer.MIN_VALUE) && (b(i, 16, null));
  }
  
  private static int getAction(int paramInt)
  {
    if (paramInt != 19)
    {
      if (paramInt != 21)
      {
        if (paramInt != 22) {
          return 130;
        }
        return 66;
      }
      return 17;
    }
    return 33;
  }
  
  private boolean intersectVisibleToUser(Rect paramRect)
  {
    if (paramRect != null)
    {
      if (paramRect.isEmpty()) {
        return false;
      }
      if (a.getWindowVisibility() != 0) {
        return false;
      }
      paramRect = a.getParent();
      while ((paramRect instanceof View))
      {
        paramRect = (View)paramRect;
        if (paramRect.getAlpha() > 0.0F)
        {
          if (paramRect.getVisibility() != 0) {
            return false;
          }
          paramRect = paramRect.getParent();
        }
        else
        {
          return false;
        }
      }
      if (paramRect != null) {
        return true;
      }
    }
    return false;
  }
  
  protected abstract int a(float paramFloat1, float paramFloat2);
  
  public b a(View paramView)
  {
    if (o == null) {
      o = new f(this);
    }
    return o;
  }
  
  protected abstract void a(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    add(paramAccessibilityEvent);
  }
  
  public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.a(paramView, paramAccessibilityNodeInfoCompat);
    a(paramAccessibilityNodeInfoCompat);
  }
  
  protected abstract void a(List paramList);
  
  protected void a(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != Integer.MIN_VALUE)
    {
      if (!h.isEnabled()) {
        return false;
      }
      ViewParent localViewParent = a.getParent();
      if (localViewParent == null) {
        return false;
      }
      AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, paramInt2);
      return ViewParentCompat.requestSendAccessibilityEvent(localViewParent, a, localAccessibilityEvent);
    }
    return false;
  }
  
  public final boolean a(KeyEvent paramKeyEvent)
  {
    int m = paramKeyEvent.getAction();
    int i = 0;
    if (m != 1)
    {
      m = paramKeyEvent.getKeyCode();
      if (m != 61)
      {
        if (m != 66)
        {
          switch (m)
          {
          default: 
            return false;
          case 19: 
          case 20: 
          case 21: 
          case 22: 
            if (!paramKeyEvent.hasNoModifiers()) {
              break;
            }
            m = getAction(m);
            int i1 = paramKeyEvent.getRepeatCount();
            for (boolean bool = false; (i < i1 + 1) && (a(m, null)); bool = true) {
              i += 1;
            }
            return bool;
          }
        }
        else if ((paramKeyEvent.hasNoModifiers()) && (paramKeyEvent.getRepeatCount() == 0))
        {
          g();
          return true;
        }
      }
      else
      {
        if (paramKeyEvent.hasNoModifiers()) {
          return a(2, null);
        }
        if (paramKeyEvent.hasModifiers(1)) {
          return a(1, null);
        }
      }
    }
    return false;
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    if (h.isEnabled())
    {
      if (!h.isTouchExplorationEnabled()) {
        return false;
      }
      int i = paramMotionEvent.getAction();
      if ((i != 7) && (i != 9))
      {
        if (i != 10) {
          return false;
        }
        if (n != Integer.MIN_VALUE)
        {
          d(Integer.MIN_VALUE);
          return true;
        }
        return false;
      }
      i = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      d(i);
      if (i != Integer.MIN_VALUE) {
        return true;
      }
    }
    return false;
  }
  
  protected void add(int paramInt, AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void add(AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void b(int paramInt, boolean paramBoolean) {}
  
  public final boolean b(int paramInt)
  {
    if (k != paramInt) {
      return false;
    }
    k = Integer.MIN_VALUE;
    b(paramInt, false);
    a(paramInt, 8);
    return true;
  }
  
  protected abstract boolean b(int paramInt1, int paramInt2, Bundle paramBundle);
  
  public final boolean c(int paramInt)
  {
    if ((!a.isFocused()) && (!a.requestFocus())) {
      return false;
    }
    int i = k;
    if (i == paramInt) {
      return false;
    }
    if (i != Integer.MIN_VALUE) {
      b(i);
    }
    k = paramInt;
    b(paramInt, true);
    a(paramInt, 8);
    return true;
  }
  
  public final void clear(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    int i = k;
    if (i != Integer.MIN_VALUE) {
      b(i);
    }
    if (paramBoolean) {
      a(paramInt, paramRect);
    }
  }
  
  boolean d(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 != -1) {
      return a(paramInt1, paramInt2, paramBundle);
    }
    return b(paramInt2, paramBundle);
  }
  
  public final int h()
  {
    return j;
  }
  
  public final int i()
  {
    return k;
  }
  
  AccessibilityNodeInfoCompat obtain(int paramInt)
  {
    if (paramInt == -1) {
      return add();
    }
    return a(paramInt);
  }
}
