package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Plot
{
  private static final Comparator<h.d> a = new w();
  
  public static d a(ClassVisitor paramClassVisitor)
  {
    return a(paramClassVisitor, true);
  }
  
  public static d a(ClassVisitor paramClassVisitor, boolean paramBoolean)
  {
    int i = paramClassVisitor.getOldListSize();
    int j = paramClassVisitor.getNewListSize();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new NavigationMenuPresenter(0, i, 0, j));
    i = (i + j + 1) / 2 * 2 + 1;
    Label localLabel1 = new Label(i);
    Label localLabel2 = new Label(i);
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      NavigationMenuPresenter localNavigationMenuPresenter2 = (NavigationMenuPresenter)localArrayList2.remove(localArrayList2.size() - 1);
      e.a localA = a(localNavigationMenuPresenter2, paramClassVisitor, localLabel1, localLabel2);
      if (localA != null)
      {
        if (localA.getCount() > 0) {
          localArrayList1.add(localA.getItem());
        }
        NavigationMenuPresenter localNavigationMenuPresenter1;
        if (localArrayList3.isEmpty()) {
          localNavigationMenuPresenter1 = new NavigationMenuPresenter();
        } else {
          localNavigationMenuPresenter1 = (NavigationMenuPresenter)localArrayList3.remove(localArrayList3.size() - 1);
        }
        c = c;
        j = j;
        i = a;
        b = c;
        localArrayList2.add(localNavigationMenuPresenter1);
        i = i;
        b = b;
        c = b;
        j = d;
        localArrayList2.add(localNavigationMenuPresenter2);
      }
      else
      {
        localArrayList3.add(localNavigationMenuPresenter2);
      }
    }
    Collections.sort(localArrayList1, a);
    return new d(paramClassVisitor, localArrayList1, localLabel1.a(), localLabel2.a(), paramBoolean);
  }
  
  private static e.a a(NavigationMenuPresenter paramNavigationMenuPresenter, ClassVisitor paramClassVisitor, Label paramLabel1, Label paramLabel2)
  {
    if (paramNavigationMenuPresenter.b() >= 1)
    {
      if (paramNavigationMenuPresenter.e() < 1) {
        return null;
      }
      int j = (paramNavigationMenuPresenter.b() + paramNavigationMenuPresenter.e() + 1) / 2;
      paramLabel1.a(1, c);
      paramLabel2.a(1, paramNavigationMenuPresenter.i);
      int i = 0;
      while (i < j)
      {
        e.a localA = b(paramNavigationMenuPresenter, paramClassVisitor, paramLabel1, paramLabel2, i);
        if (localA != null) {
          return localA;
        }
        localA = a(paramNavigationMenuPresenter, paramClassVisitor, paramLabel1, paramLabel2, i);
        if (localA != null) {
          return localA;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private static e.a a(NavigationMenuPresenter paramNavigationMenuPresenter, ClassVisitor paramClassVisitor, Label paramLabel1, Label paramLabel2, int paramInt)
  {
    int j;
    if ((paramNavigationMenuPresenter.b() - paramNavigationMenuPresenter.e()) % 2 == 0) {
      j = 1;
    } else {
      j = 0;
    }
    int i3 = paramNavigationMenuPresenter.b();
    int i4 = paramNavigationMenuPresenter.e();
    int i2 = -paramInt;
    int k = i2;
    while (k <= paramInt)
    {
      int i;
      int m;
      if ((k != i2) && ((k == paramInt) || (paramLabel2.a(k + 1) >= paramLabel2.a(k - 1))))
      {
        i = paramLabel2.a(k - 1);
        m = i;
        i -= 1;
      }
      else
      {
        i = paramLabel2.a(k + 1);
        m = i;
      }
      int i1 = b - (paramNavigationMenuPresenter.i - i - k);
      int n;
      if ((paramInt != 0) && (i == m)) {
        n = i1 + 1;
      } else {
        n = i1;
      }
      while ((i > c) && (i1 > paramNavigationMenuPresenter.j) && (paramClassVisitor.areItemsTheSame(i - 1, i1 - 1)))
      {
        i -= 1;
        i1 -= 1;
      }
      paramLabel2.a(k, i);
      if (j != 0)
      {
        int i5 = i3 - i4 - k;
        if ((i5 >= i2) && (i5 <= paramInt) && (paramLabel1.a(i5) >= i))
        {
          paramNavigationMenuPresenter = new e.a();
          a = i;
          c = i1;
          b = m;
          d = n;
          e = true;
          return paramNavigationMenuPresenter;
        }
      }
      k += 2;
    }
    return null;
  }
  
  private static e.a b(NavigationMenuPresenter paramNavigationMenuPresenter, ClassVisitor paramClassVisitor, Label paramLabel1, Label paramLabel2, int paramInt)
  {
    int i = Math.abs(paramNavigationMenuPresenter.b() - paramNavigationMenuPresenter.e());
    int j = 1;
    if (i % 2 != 1) {
      j = 0;
    }
    int i3 = paramNavigationMenuPresenter.b();
    int i4 = paramNavigationMenuPresenter.e();
    int i2 = -paramInt;
    int k = i2;
    while (k <= paramInt)
    {
      int m;
      if ((k != i2) && ((k == paramInt) || (paramLabel1.a(k + 1) <= paramLabel1.a(k - 1))))
      {
        i = paramLabel1.a(k - 1);
        m = i;
        i += 1;
      }
      else
      {
        i = paramLabel1.a(k + 1);
        m = i;
      }
      int i1 = paramNavigationMenuPresenter.j + (i - c) - k;
      int n;
      if ((paramInt != 0) && (i == m)) {
        n = i1 - 1;
      } else {
        n = i1;
      }
      while ((i < paramNavigationMenuPresenter.i) && (i1 < b) && (paramClassVisitor.areItemsTheSame(i, i1)))
      {
        i += 1;
        i1 += 1;
      }
      paramLabel1.a(k, i);
      if (j != 0)
      {
        int i5 = i3 - i4 - k;
        if ((i5 >= i2 + 1) && (i5 <= paramInt - 1) && (paramLabel2.a(i5) <= i))
        {
          paramNavigationMenuPresenter = new e.a();
          a = m;
          c = n;
          b = i;
          d = i1;
          e = false;
          return paramNavigationMenuPresenter;
        }
      }
      k += 2;
    }
    return null;
  }
}
