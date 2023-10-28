package androidx.work.impl.ui;

import android.content.Context;
import androidx.work.Log;
import androidx.work.impl.ui.menu.Menu;
import androidx.work.impl.ui.menu.d;
import androidx.work.impl.ui.menu.e.a;
import androidx.work.impl.ui.menu.i;
import androidx.work.impl.ui.menu.o;
import androidx.work.impl.ui.menu.p;
import androidx.work.impl.ui.menu.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
  implements Menu
{
  private static final String p = Log.getInstance("WorkConstraintsTracker");
  private final androidx.work.impl.m.e.c<?>[] a;
  private final a b;
  private final Object d;
  
  public f(Context paramContext, androidx.work.impl.utils.asm.f paramF, a paramA)
  {
    paramContext = paramContext.getApplicationContext();
    b = paramA;
    a = new d[] { new x(paramContext, paramF), new e.a(paramContext, paramF), new androidx.work.impl.ui.menu.c(paramContext, paramF), new p(paramContext, paramF), new o(paramContext, paramF), new androidx.work.impl.ui.menu.f(paramContext, paramF), new i(paramContext, paramF) };
    d = new Object();
  }
  
  public void a()
  {
    Object localObject = d;
    try
    {
      d[] arrayOfD = a;
      int j = arrayOfD.length;
      int i = 0;
      while (i < j)
      {
        arrayOfD[i].a();
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void a(Iterable paramIterable)
  {
    Object localObject = d;
    try
    {
      d[] arrayOfD = a;
      int k = arrayOfD.length;
      int j = 0;
      int i = 0;
      while (i < k)
      {
        arrayOfD[i].a(null);
        i += 1;
      }
      arrayOfD = a;
      k = arrayOfD.length;
      i = 0;
      while (i < k)
      {
        arrayOfD[i].a(paramIterable);
        i += 1;
      }
      paramIterable = a;
      k = paramIterable.length;
      i = j;
      while (i < k)
      {
        paramIterable[i].a(this);
        i += 1;
      }
      return;
    }
    catch (Throwable paramIterable)
    {
      throw paramIterable;
    }
  }
  
  public void a(List paramList)
  {
    Object localObject = d;
    try
    {
      a localA = b;
      if (localA != null) {
        localA.b(paramList);
      }
      return;
    }
    catch (Throwable paramList)
    {
      throw paramList;
    }
  }
  
  public boolean a(String paramString)
  {
    Object localObject = d;
    try
    {
      d[] arrayOfD = a;
      int j = arrayOfD.length;
      int i = 0;
      while (i < j)
      {
        d localD = arrayOfD[i];
        if (localD.a(paramString))
        {
          Log.get().append(p, String.format("Work %s constrained by %s", new Object[] { paramString, localD.getClass().getSimpleName() }), new Throwable[0]);
          return false;
        }
        i += 1;
      }
      return true;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void add(List paramList)
  {
    Object localObject = d;
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (a(str))
        {
          Log.get().append(p, String.format("Constraints met for %s", new Object[] { str }), new Throwable[0]);
          localArrayList.add(str);
        }
      }
      paramList = b;
      if (paramList != null) {
        paramList.a(localArrayList);
      }
      return;
    }
    catch (Throwable paramList)
    {
      throw paramList;
    }
  }
}
