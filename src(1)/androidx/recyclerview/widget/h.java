package androidx.recyclerview.widget;

public class h
  implements a
{
  Object a = null;
  final a b;
  int h = -1;
  int i = -1;
  int k = 0;
  
  public h(a paramA)
  {
    b = paramA;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (k == 1)
    {
      int j = i;
      if (paramInt1 >= j)
      {
        int m = h;
        if (paramInt1 <= j + m)
        {
          h = (m + paramInt2);
          i = Math.min(paramInt1, j);
          return;
        }
      }
    }
    b();
    i = paramInt1;
    h = paramInt2;
    k = 1;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (k == 3)
    {
      int j = i;
      int m = h;
      if (paramInt1 <= j + m)
      {
        int n = paramInt1 + paramInt2;
        if ((n >= j) && (a == paramObject))
        {
          i = Math.min(paramInt1, j);
          h = (Math.max(m + j, n) - i);
          return;
        }
      }
    }
    b();
    i = paramInt1;
    h = paramInt2;
    a = paramObject;
    k = 3;
  }
  
  public void b()
  {
    int j = k;
    if (j == 0) {
      return;
    }
    if (j != 1)
    {
      if (j != 2)
      {
        if (j == 3) {
          b.a(i, h, a);
        }
      }
      else {
        b.b(i, h);
      }
    }
    else {
      b.a(i, h);
    }
    a = null;
    k = 0;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (k == 2)
    {
      int j = i;
      if ((j >= paramInt1) && (j <= paramInt1 + paramInt2))
      {
        h += paramInt2;
        i = paramInt1;
        return;
      }
    }
    b();
    i = paramInt1;
    h = paramInt2;
    k = 2;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    b();
    b.c(paramInt1, paramInt2);
  }
}
