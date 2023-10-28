package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class d
{
  private final List<h.d> a;
  private final boolean b;
  private final int c;
  private final int d;
  private final int[] e;
  private final int[] f;
  private final ClassVisitor i;
  
  d(ClassVisitor paramClassVisitor, List paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    a = paramList;
    f = paramArrayOfInt1;
    e = paramArrayOfInt2;
    Arrays.fill(paramArrayOfInt1, 0);
    Arrays.fill(paramArrayOfInt2, 0);
    i = paramClassVisitor;
    d = paramClassVisitor.getOldListSize();
    c = paramClassVisitor.getNewListSize();
    b = paramBoolean;
    d();
    a();
  }
  
  private static c a(Collection paramCollection, int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      paramCollection = (c)localIterator.next();
      if ((c == paramInt) && (f == paramBoolean))
      {
        localIterator.remove();
        break label53;
      }
    }
    paramCollection = null;
    label53:
    while (localIterator.hasNext())
    {
      c localC = (c)localIterator.next();
      if (paramBoolean) {
        d -= 1;
      } else {
        d += 1;
      }
    }
    return paramCollection;
  }
  
  private void a()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      x localX = (x)localIterator.next();
      int j = 0;
      while (j < a)
      {
        int m = d + j;
        int n = c + j;
        int k;
        if (i.areContentsTheSame(m, n)) {
          k = 1;
        } else {
          k = 2;
        }
        f[m] = (n << 4 | k);
        e[n] = (m << 4 | k);
        j += 1;
      }
    }
    if (b) {
      c();
    }
  }
  
  private void a(int paramInt)
  {
    int m = a.size();
    int k = 0;
    int j = 0;
    while (k < m)
    {
      x localX = (x)a.get(k);
      while (j < c)
      {
        if ((e[j] == 0) && (i.areItemsTheSame(paramInt, j)))
        {
          if (i.areContentsTheSame(paramInt, j)) {
            k = 8;
          } else {
            k = 4;
          }
          f[paramInt] = (j << 4 | k);
          e[j] = (paramInt << 4 | k);
          return;
        }
        j += 1;
      }
      j = localX.get();
      k += 1;
    }
  }
  
  private void c()
  {
    Iterator localIterator = a.iterator();
    x localX;
    for (int j = 0; localIterator.hasNext(); j = localX.a())
    {
      localX = (x)localIterator.next();
      while (j < d)
      {
        if (f[j] == 0) {
          a(j);
        }
        j += 1;
      }
    }
  }
  
  private void d()
  {
    x localX;
    if (a.isEmpty()) {
      localX = null;
    } else {
      localX = (x)a.get(0);
    }
    if ((localX == null) || (d != 0) || (c != 0)) {
      a.add(0, new x(0, 0, 0));
    }
    a.add(new x(d, c, 0));
  }
  
  public void a(a paramA)
  {
    if ((paramA instanceof h)) {
      paramA = (h)paramA;
    } else {
      paramA = new h(paramA);
    }
    int j = d;
    ArrayDeque localArrayDeque = new ArrayDeque();
    int m = d;
    int k = c;
    int n = a.size() - 1;
    while (n >= 0)
    {
      x localX = (x)a.get(n);
      int i5 = localX.a();
      int i4 = localX.get();
      int i1 = m;
      m = j;
      int i3;
      int i2;
      c localC;
      for (;;)
      {
        i3 = 0;
        j = m;
        i2 = k;
        if (i1 <= i5) {
          break;
        }
        j = i1 - 1;
        i2 = f[j];
        if ((i2 & 0xC) != 0)
        {
          i3 = i2 >> 4;
          localC = a(localArrayDeque, i3, false);
          if (localC != null)
          {
            int i6 = m - d - 1;
            paramA.c(j, i6);
            i1 = j;
            if ((i2 & 0x4) != 0)
            {
              paramA.a(i6, 1, i.getChangePayload(j, i3));
              i1 = j;
            }
          }
          else
          {
            localArrayDeque.add(new c(j, m - j - 1, true));
            i1 = j;
          }
        }
        else
        {
          paramA.b(j, 1);
          m -= 1;
          i1 = j;
        }
      }
      while (i2 > i4)
      {
        k = i2 - 1;
        m = e[k];
        if ((m & 0xC) != 0)
        {
          i5 = m >> 4;
          localC = a(localArrayDeque, i5, true);
          if (localC == null)
          {
            localArrayDeque.add(new c(k, j - i1, false));
            i2 = k;
          }
          else
          {
            paramA.c(j - d - 1, i1);
            i2 = k;
            if ((m & 0x4) != 0)
            {
              paramA.a(i1, 1, i.getChangePayload(i5, k));
              i2 = k;
            }
          }
        }
        else
        {
          paramA.a(i1, 1);
          j += 1;
          i2 = k;
        }
      }
      i1 = d;
      m = c;
      k = i3;
      while (k < a)
      {
        if ((f[i1] & 0xF) == 2) {
          paramA.a(i1, 1, i.getChangePayload(i1, m));
        }
        i1 += 1;
        m += 1;
        k += 1;
      }
      m = d;
      k = c;
      n -= 1;
    }
    paramA.b();
  }
  
  public void b(RecyclerView.Adapter paramAdapter)
  {
    a(new g(paramAdapter));
  }
}
