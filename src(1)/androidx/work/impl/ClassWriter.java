package androidx.work.impl;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import androidx.core.content.ContextCompat;
import androidx.work.Handle;
import androidx.work.Log;
import androidx.work.WorkerParameters.a;
import androidx.work.impl.foreground.Item;
import androidx.work.impl.utils.Collection;
import androidx.work.impl.utils.HttpConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClassWriter
  implements Object, Item
{
  private static final String p = Log.getInstance("Processor");
  private PowerManager.WakeLock a;
  private androidx.work.impl.utils.asm.f b;
  private Map<String, k> c;
  private List<e> e;
  private Set<String> f;
  private WorkDatabase i;
  private final java.lang.Object k;
  private Context l;
  private Map<String, k> m;
  private final List<b> n;
  private androidx.work.f o;
  
  public ClassWriter(Context paramContext, androidx.work.f paramF, androidx.work.impl.utils.asm.f paramF1, WorkDatabase paramWorkDatabase, List paramList)
  {
    l = paramContext;
    o = paramF;
    b = paramF1;
    i = paramWorkDatabase;
    m = new HashMap();
    c = new HashMap();
    e = paramList;
    f = new HashSet();
    n = new ArrayList();
    a = null;
    k = new java.lang.Object();
  }
  
  private void a()
  {
    java.lang.Object localObject = k;
    try
    {
      if (!(c.isEmpty() ^ true))
      {
        Intent localIntent = androidx.work.impl.foreground.b.a(l);
        try
        {
          l.startService(localIntent);
        }
        catch (Throwable localThrowable1)
        {
          Log.get().get(p, "Unable to stop foreground service", new Throwable[] { localThrowable1 });
        }
        PowerManager.WakeLock localWakeLock = a;
        if (localWakeLock != null)
        {
          localWakeLock.release();
          a = null;
        }
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
  }
  
  private static boolean a(String paramString, i paramI)
  {
    if (paramI != null)
    {
      paramI.e();
      Log.get().append(p, String.format("WorkerWrapper interrupted for %s", new java.lang.Object[] { paramString }), new Throwable[0]);
      return true;
    }
    Log.get().append(p, String.format("WorkerWrapper could not be found for %s", new java.lang.Object[] { paramString }), new Throwable[0]);
    return false;
  }
  
  public void a(Object paramObject)
  {
    java.lang.Object localObject = k;
    try
    {
      n.add(paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public void a(String paramString, Handle paramHandle)
  {
    java.lang.Object localObject = k;
    try
    {
      Log.get().a(p, String.format("Moving WorkSpec (%s) to the foreground", new java.lang.Object[] { paramString }), new Throwable[0]);
      i localI = (i)m.remove(paramString);
      if (localI != null)
      {
        if (a == null)
        {
          PowerManager.WakeLock localWakeLock = Collection.add(l, "ProcessorForegroundLck");
          a = localWakeLock;
          localWakeLock.acquire();
        }
        c.put(paramString, localI);
        paramString = androidx.work.impl.foreground.b.a(l, paramString, paramHandle);
        ContextCompat.init(l, paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    java.lang.Object localObject = k;
    try
    {
      m.remove(paramString);
      Log.get().append(p, String.format("%s %s executed; reschedule = %s", new java.lang.Object[] { getClass().getSimpleName(), paramString, Boolean.valueOf(paramBoolean) }), new Throwable[0]);
      Iterator localIterator = n.iterator();
      while (localIterator.hasNext()) {
        ((Object)localIterator.next()).a(paramString, paramBoolean);
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public boolean a(String paramString)
  {
    java.lang.Object localObject = k;
    try
    {
      Log.get().append(p, String.format("Processor stopping background work %s", new java.lang.Object[] { paramString }), new Throwable[0]);
      boolean bool = a(paramString, (i)m.remove(paramString));
      return bool;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public boolean a(String paramString, WorkerParameters.a paramA)
  {
    java.lang.Object localObject = k;
    try
    {
      if (get(paramString))
      {
        Log.get().append(p, String.format("Work %s is already enqueued for processing", new java.lang.Object[] { paramString }), new Throwable[0]);
        return false;
      }
      paramA = new e(l, o, b, this, i, paramString).a(e).a(paramA).a();
      com.google.common.util.concurrent.Object localObject1 = paramA.f();
      localObject1.addListener(new Widget(this, paramString, localObject1), b.get());
      m.put(paramString, paramA);
      b.a().execute(paramA);
      Log.get().append(p, String.format("%s: processing %s", new java.lang.Object[] { d.class.getSimpleName(), paramString }), new Throwable[0]);
      return true;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public boolean accept(String paramString)
  {
    java.lang.Object localObject = k;
    try
    {
      boolean bool = c.containsKey(paramString);
      return bool;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public boolean add(String paramString)
  {
    java.lang.Object localObject3 = k;
    for (;;)
    {
      try
      {
        java.lang.Object localObject1 = Log.get();
        java.lang.Object localObject2 = p;
        j = 1;
        ((Log)localObject1).append((String)localObject2, String.format("Processor cancelling %s", new java.lang.Object[] { paramString }), new Throwable[0]);
        f.add(paramString);
        localObject2 = (i)c.remove(paramString);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = (i)m.remove(paramString);
          }
          boolean bool = a(paramString, (i)localObject1);
          if (j != 0) {
            a();
          }
          return bool;
        }
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      int j = 0;
    }
  }
  
  public boolean b(String paramString)
  {
    java.lang.Object localObject = k;
    try
    {
      Log.get().append(p, String.format("Processor stopping foreground work %s", new java.lang.Object[] { paramString }), new Throwable[0]);
      boolean bool = a(paramString, (i)c.remove(paramString));
      return bool;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public boolean c(String paramString)
  {
    return a(paramString, null);
  }
  
  public void clear(String paramString)
  {
    java.lang.Object localObject = k;
    try
    {
      c.remove(paramString);
      a();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public boolean execute(String paramString)
  {
    java.lang.Object localObject = k;
    try
    {
      boolean bool = f.contains(paramString);
      return bool;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void get(Object paramObject)
  {
    java.lang.Object localObject = k;
    try
    {
      n.remove(paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public boolean get(String paramString)
  {
    java.lang.Object localObject = k;
    for (;;)
    {
      try
      {
        if (m.containsKey(paramString)) {
          break label50;
        }
        if (!c.containsKey(paramString)) {
          break label45;
        }
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      return bool;
      label45:
      boolean bool = false;
      continue;
      label50:
      bool = true;
    }
  }
}
