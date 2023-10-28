package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import androidx.work.Log;
import androidx.work.impl.ClassWriter;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.h;
import androidx.work.impl.asm.i;
import androidx.work.impl.ui.a;
import androidx.work.impl.utils.Collection;
import androidx.work.impl.utils.OkHttpClient;
import androidx.work.impl.utils.Settings;
import java.util.Collections;
import java.util.List;

public class Label
  implements a, androidx.work.impl.Object, OkHttpClient
{
  private static final String c = Log.getInstance("DelayMetCommandHandler");
  private PowerManager.WakeLock a;
  private final f b;
  private final androidx.work.impl.ui.f d;
  private boolean f;
  private final Object g;
  private int h;
  private final String i;
  private final Context j;
  private final int k;
  
  Label(Context paramContext, int paramInt, String paramString, f paramF)
  {
    j = paramContext;
    k = paramInt;
    b = paramF;
    i = paramString;
    d = new androidx.work.impl.ui.f(paramContext, paramF.i(), this);
    f = false;
    h = 0;
    g = new Object();
  }
  
  private void a()
  {
    Object localObject1 = g;
    try
    {
      if (h < 2)
      {
        h = 2;
        Object localObject3 = Log.get();
        Object localObject2 = c;
        ((Log)localObject3).append((String)localObject2, String.format("Stopping work for WorkSpec %s", new Object[] { i }), new Throwable[0]);
        localObject3 = b.set(j, i);
        f localF = b;
        localF.a(new Widget(localF, (Intent)localObject3, k));
        if (b.j().get(i))
        {
          Log.get().append((String)localObject2, String.format("WorkSpec %s needs to be rescheduled", new Object[] { i }), new Throwable[0]);
          localObject2 = b.a(j, i);
          localObject3 = b;
          ((f)localObject3).a(new Widget((f)localObject3, (Intent)localObject2, k));
        }
        else
        {
          Log.get().append((String)localObject2, String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[] { i }), new Throwable[0]);
        }
      }
      else
      {
        Log.get().append(c, String.format("Already stopped work for %s", new Object[] { i }), new Throwable[0]);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void draw()
  {
    Object localObject = g;
    try
    {
      d.a();
      b.d().get(i);
      PowerManager.WakeLock localWakeLock = a;
      if ((localWakeLock != null) && (localWakeLock.isHeld()))
      {
        Log.get().append(c, String.format("Releasing wakelock %s for WorkSpec %s", new Object[] { a, i }), new Throwable[0]);
        a.release();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Log.get().append(c, String.format("onExecuted %s, %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }), new Throwable[0]);
    draw();
    f localF;
    if (paramBoolean)
    {
      paramString = b.a(j, i);
      localF = b;
      localF.a(new Widget(localF, paramString, k));
    }
    if (f)
    {
      paramString = b.a(j);
      localF = b;
      localF.a(new Widget(localF, paramString, k));
    }
  }
  
  public void a(List paramList)
  {
    if (!paramList.contains(i)) {
      return;
    }
    paramList = g;
    try
    {
      if (h == 0)
      {
        h = 1;
        Log.get().append(c, String.format("onAllConstraintsMet for %s", new Object[] { i }), new Throwable[0]);
        if (b.j().c(i)) {
          b.d().get(i, 600000L, this);
        } else {
          draw();
        }
      }
      else
      {
        Log.get().append(c, String.format("Already started work for %s", new Object[] { i }), new Throwable[0]);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  void b()
  {
    a = Collection.add(j, String.format("%s (%s)", new Object[] { i, Integer.valueOf(k) }));
    Object localObject = Log.get();
    String str = c;
    ((Log)localObject).append(str, String.format("Acquiring wakelock %s for WorkSpec %s", new Object[] { a, i }), new Throwable[0]);
    a.acquire();
    localObject = b.b().a().a().a(i);
    if (localObject == null)
    {
      a();
      return;
    }
    boolean bool = ((h)localObject).b();
    f = bool;
    if (!bool)
    {
      Log.get().append(str, String.format("No constraints for %s", new Object[] { i }), new Throwable[0]);
      a(Collections.singletonList(i));
      return;
    }
    d.a(Collections.singletonList(localObject));
  }
  
  public void b(String paramString)
  {
    Log.get().append(c, String.format("Exceeded time limits on execution for %s", new Object[] { paramString }), new Throwable[0]);
    a();
  }
  
  public void b(List paramList)
  {
    a();
  }
}
