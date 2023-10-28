package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.s;
import java.util.Locale;

final class h
  extends RecyclerView.s
{
  private boolean a;
  private boolean b;
  private int c;
  private ViewPager2.i d;
  private int e;
  private final RecyclerView g;
  private Frame h;
  private int i;
  private int j;
  private final ViewPager2 l;
  private boolean m;
  private boolean p;
  private final LinearLayoutManager this$0;
  
  h(ViewPager2 paramViewPager2)
  {
    l = paramViewPager2;
    paramViewPager2 = mRecyclerView;
    g = paramViewPager2;
    this$0 = ((LinearLayoutManager)paramViewPager2.getLayoutManager());
    h = new Frame();
    d();
  }
  
  private void a()
  {
    Frame localFrame = h;
    int k = this$0.getValue();
    e = k;
    if (k == -1)
    {
      localFrame.a();
      return;
    }
    View localView = this$0.findViewByPosition(k);
    if (localView == null)
    {
      localFrame.a();
      return;
    }
    int i6 = this$0.c(localView);
    int n = i6;
    int i5 = this$0.next(localView);
    int i1 = i5;
    int i4 = this$0.f(localView);
    k = i4;
    int i3 = this$0.a(localView);
    int i2 = i3;
    Object localObject = localView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      n = i6 + leftMargin;
      i1 = i5 + rightMargin;
      k = i4 + topMargin;
      i2 = i3 + bottomMargin;
    }
    i3 = localView.getHeight() + k + i2;
    i4 = localView.getWidth();
    if (this$0.getOrientation() == 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (i2 != 0)
    {
      i2 = localView.getLeft() - n - g.getPaddingLeft();
      k = i2;
      if (l.a()) {
        k = -i2;
      }
      i1 = i4 + n + i1;
      n = k;
      k = i1;
    }
    else
    {
      n = localView.getTop() - k - g.getPaddingTop();
      k = i3;
    }
    n = -n;
    b = n;
    if (n < 0)
    {
      if (new Label(this$0).a()) {
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
      }
      throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[] { Integer.valueOf(b) }));
    }
    float f;
    if (k == 0) {
      f = 0.0F;
    } else {
      f = n / k;
    }
    g = f;
  }
  
  private void a(int paramInt)
  {
    if ((i == 3) && (j == 0)) {
      return;
    }
    if (j == paramInt) {
      return;
    }
    j = paramInt;
    ViewPager2.i localI = d;
    if (localI != null) {
      localI.b(paramInt);
    }
  }
  
  private void a(int paramInt1, float paramFloat, int paramInt2)
  {
    ViewPager2.i localI = d;
    if (localI != null) {
      localI.a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    m = paramBoolean;
    if (paramBoolean) {
      k = 4;
    } else {
      k = 1;
    }
    i = k;
    int k = c;
    if (k != -1)
    {
      e = k;
      c = -1;
    }
    else if (e == -1)
    {
      e = f();
    }
    a(1);
  }
  
  private void c(int paramInt)
  {
    ViewPager2.i localI = d;
    if (localI != null) {
      localI.a(paramInt);
    }
  }
  
  private void d()
  {
    i = 0;
    j = 0;
    h.a();
    e = -1;
    c = -1;
    a = false;
    p = false;
    m = false;
    b = false;
  }
  
  private int f()
  {
    return this$0.getValue();
  }
  
  private boolean g()
  {
    int k = i;
    if (k != 1) {
      return k == 4;
    }
    return true;
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      k = 2;
    } else {
      k = 3;
    }
    i = k;
    int k = 0;
    m = false;
    if (c != paramInt) {
      k = 1;
    }
    c = paramInt;
    a(2);
    if (k != 0) {
      c(paramInt);
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    p = true;
    a();
    if (a)
    {
      a = false;
      if (paramInt2 <= 0) {
        if (paramInt2 == 0)
        {
          int k;
          if (paramInt1 < 0) {
            k = 1;
          } else {
            k = 0;
          }
          if (k == l.a()) {}
        }
        else
        {
          paramInt1 = 0;
          break label64;
        }
      }
      paramInt1 = 1;
      label64:
      if (paramInt1 != 0)
      {
        paramRecyclerView = h;
        if (b != 0)
        {
          paramInt1 = e + 1;
          break label98;
        }
      }
      paramInt1 = h.e;
      label98:
      c = paramInt1;
      if (e != paramInt1) {
        c(paramInt1);
      }
    }
    else if (i == 0)
    {
      paramInt2 = h.e;
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = 0;
      }
      c(paramInt1);
    }
    paramRecyclerView = h;
    paramInt2 = e;
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = 0;
    }
    a(paramInt1, g, b);
    paramRecyclerView = h;
    paramInt1 = e;
    paramInt2 = c;
    if (((paramInt1 == paramInt2) || (paramInt2 == -1)) && (b == 0) && (j != 1))
    {
      a(0);
      d();
    }
  }
  
  void a(ViewPager2.i paramI)
  {
    d = paramI;
  }
  
  double b()
  {
    a();
    Frame localFrame = h;
    return e + g;
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    int k = i;
    int n = 1;
    if (((k != 1) || (j != 1)) && (paramInt == 1))
    {
      b(false);
      return;
    }
    if ((g()) && (paramInt == 2))
    {
      if (p)
      {
        a(2);
        a = true;
      }
    }
    else
    {
      if ((g()) && (paramInt == 0))
      {
        a();
        int i1;
        if (!p)
        {
          i1 = h.e;
          k = n;
          if (i1 != -1)
          {
            a(i1, 0.0F, 0);
            k = n;
          }
        }
        else
        {
          paramRecyclerView = h;
          if (b == 0)
          {
            i1 = e;
            int i2 = e;
            k = n;
            if (i1 != i2)
            {
              c(i2);
              k = n;
            }
          }
          else
          {
            k = 0;
          }
        }
        if (k != 0)
        {
          a(0);
          d();
        }
      }
      if ((i == 2) && (paramInt == 0) && (b))
      {
        a();
        paramRecyclerView = h;
        if (b == 0)
        {
          paramInt = c;
          k = e;
          if (paramInt != k)
          {
            paramInt = k;
            if (k == -1) {
              paramInt = 0;
            }
            c(paramInt);
          }
          a(0);
          d();
        }
      }
    }
  }
  
  boolean c()
  {
    return m;
  }
  
  void e()
  {
    b = true;
  }
  
  int h()
  {
    return j;
  }
  
  boolean k()
  {
    return j == 0;
  }
}
