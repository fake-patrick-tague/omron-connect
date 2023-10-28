package androidx.work.impl.client.cache;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.work.Log;
import androidx.work.WorkInfo.State;
import androidx.work.i;
import androidx.work.impl.asm.h;
import androidx.work.impl.l;
import androidx.work.impl.n.p;
import androidx.work.impl.ui.a;
import androidx.work.impl.utils.Frame;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b
  implements l, a, androidx.work.impl.Object
{
  private static final String a = Log.getInstance("GreedyScheduler");
  private final androidx.work.impl.f b;
  private final Set<p> c = new HashSet();
  Boolean d;
  private final Object e;
  private boolean f;
  private ClassWriter i;
  private final androidx.work.impl.ui.f j;
  private final Context l;
  
  public b(Context paramContext, androidx.work.f paramF, androidx.work.impl.utils.asm.f paramF1, androidx.work.impl.f paramF2)
  {
    l = paramContext;
    b = paramF2;
    j = new androidx.work.impl.ui.f(paramContext, paramF1, this);
    i = new ClassWriter(this, paramF.l());
    e = new Object();
  }
  
  private void a()
  {
    androidx.work.f localF = b.b();
    d = Boolean.valueOf(Frame.a(l, localF));
  }
  
  private void b(String paramString)
  {
    Object localObject = e;
    try
    {
      Iterator localIterator = c.iterator();
      while (localIterator.hasNext())
      {
        h localH = (h)localIterator.next();
        if (a.equals(paramString))
        {
          Log.get().append(a, String.format("Stopping tracking for %s", new Object[] { paramString }), new Throwable[0]);
          c.remove(localH);
          j.a(c);
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  private void c()
  {
    if (!f)
    {
      b.get().a(this);
      f = true;
    }
  }
  
  public void a(String paramString)
  {
    if (d == null) {
      a();
    }
    if (!d.booleanValue())
    {
      Log.get().a(a, "Ignoring schedule request in non-main process", new Throwable[0]);
      return;
    }
    c();
    Log.get().append(a, String.format("Cancelling work ID %s", new Object[] { paramString }), new Throwable[0]);
    ClassWriter localClassWriter = i;
    if (localClassWriter != null) {
      localClassWriter.a(paramString);
    }
    b.c(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    b(paramString);
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Log.get().append(a, String.format("Constraints met: Scheduling work ID %s", new Object[] { str }), new Throwable[0]);
      b.f(str);
    }
  }
  
  public void a(h... paramVarArgs)
  {
    if (d == null) {
      a();
    }
    if (!d.booleanValue())
    {
      Log.get().a(a, "Ignoring schedule request in a secondary process", new Throwable[0]);
      return;
    }
    c();
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    int m = paramVarArgs.length;
    int k = 0;
    while (k < m)
    {
      h localH = paramVarArgs[k];
      long l1 = localH.a();
      long l2 = System.currentTimeMillis();
      if (p == WorkInfo.State.a) {
        if (l2 < l1)
        {
          ClassWriter localClassWriter = i;
          if (localClassWriter != null) {
            localClassWriter.a(localH);
          }
        }
        else if (localH.b())
        {
          int n = Build.VERSION.SDK_INT;
          if ((n >= 23) && (b.f()))
          {
            Log.get().append(a, String.format("Ignoring WorkSpec %s, Requires device idle.", new Object[] { localH }), new Throwable[0]);
          }
          else if ((n >= 24) && (b.b()))
          {
            Log.get().append(a, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", new Object[] { localH }), new Throwable[0]);
          }
          else
          {
            localHashSet1.add(localH);
            localHashSet2.add(a);
          }
        }
        else
        {
          Log.get().append(a, String.format("Starting work for %s", new Object[] { a }), new Throwable[0]);
          b.f(a);
        }
      }
      k += 1;
    }
    paramVarArgs = e;
    try
    {
      if (!localHashSet1.isEmpty())
      {
        Log.get().append(a, String.format("Starting tracking for [%s]", new Object[] { TextUtils.join(",", localHashSet2) }), new Throwable[0]);
        c.addAll(localHashSet1);
        j.a(c);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void b(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Log.get().append(a, String.format("Constraints not met: Cancelling work ID %s", new Object[] { str }), new Throwable[0]);
      b.c(str);
    }
  }
  
  public boolean b()
  {
    return false;
  }
}
