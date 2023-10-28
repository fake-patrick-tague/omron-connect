package androidx.work.impl;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import androidx.work.Elements;
import androidx.work.ExtensionData;
import androidx.work.TextDrawer;
import androidx.work.WorkerParameters.a;
import androidx.work.impl.asm.i;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.HttpConnection;
import androidx.work.impl.utils.Item;
import androidx.work.impl.utils.a;
import androidx.work.impl.utils.c;
import androidx.work.impl.utils.h;
import androidx.work.m;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class f
  extends ExtensionData
{
  private static final String g = androidx.work.Log.getInstance("WorkManagerImpl");
  private static f h = null;
  private static f i = null;
  private static final java.lang.Object m = new java.lang.Object();
  private ClassWriter a;
  private h b;
  private androidx.work.impl.utils.asm.f c;
  private androidx.work.f d;
  private Context e;
  private WorkDatabase j;
  private List<e> l;
  private boolean p;
  private BroadcastReceiver.PendingResult r;
  
  public f(Context paramContext, androidx.work.f paramF, androidx.work.impl.utils.asm.f paramF1)
  {
    this(paramContext, paramF, paramF1, paramContext.getResources().getBoolean(TextDrawer.b));
  }
  
  public f(Context paramContext, androidx.work.f paramF, androidx.work.impl.utils.asm.f paramF1, WorkDatabase paramWorkDatabase)
  {
    java.lang.Object localObject = paramContext.getApplicationContext();
    androidx.work.Log.print(new Elements(paramF.size()));
    localObject = a((Context)localObject, paramF, paramF1);
    a(paramContext, paramF, paramF1, paramWorkDatabase, (List)localObject, new ClassWriter(paramContext, paramF, paramF1, paramWorkDatabase, (List)localObject));
  }
  
  public f(Context paramContext, androidx.work.f paramF, androidx.work.impl.utils.asm.f paramF1, boolean paramBoolean)
  {
    this(paramContext, paramF, paramF1, WorkDatabase.a(paramContext.getApplicationContext(), paramF1.a(), paramBoolean));
  }
  
  public static f a(Context paramContext)
  {
    java.lang.Object localObject = m;
    try
    {
      f localF2 = f();
      f localF1 = localF2;
      if (localF2 == null)
      {
        paramContext = paramContext.getApplicationContext();
        if ((paramContext instanceof m))
        {
          a(paramContext, ((m)paramContext).e());
          localF1 = a(paramContext);
        }
        else
        {
          throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
        }
      }
      return localF1;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext, androidx.work.f paramF)
  {
    java.lang.Object localObject = m;
    try
    {
      f localF = h;
      if ((localF != null) && (i != null)) {
        throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
      }
      if (localF == null)
      {
        paramContext = paramContext.getApplicationContext();
        if (i == null) {
          i = new f(paramContext, paramF, new androidx.work.impl.utils.asm.ClassWriter(paramF.getItem()));
        }
        h = i;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  private void a(Context paramContext, androidx.work.f paramF, androidx.work.impl.utils.asm.f paramF1, WorkDatabase paramWorkDatabase, List paramList, ClassWriter paramClassWriter)
  {
    paramContext = paramContext.getApplicationContext();
    e = paramContext;
    d = paramF;
    c = paramF1;
    j = paramWorkDatabase;
    l = paramList;
    a = paramClassWriter;
    b = new h(paramWorkDatabase);
    p = false;
    if ((Build.VERSION.SDK_INT >= 24) && (paramContext.isDeviceProtectedStorage())) {
      throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }
    c.get(new ForceStopRunnable(paramContext, this));
  }
  
  public static f f()
  {
    java.lang.Object localObject = m;
    try
    {
      f localF = h;
      if (localF != null) {
        return localF;
      }
      localF = i;
      return localF;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public androidx.work.b a(String paramString)
  {
    paramString = c.a(paramString, this);
    c.get(paramString);
    return paramString.b();
  }
  
  public androidx.work.b a(List paramList)
  {
    if (!paramList.isEmpty()) {
      return new Label(this, paramList).a();
    }
    throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
  }
  
  public androidx.work.b a(UUID paramUUID)
  {
    paramUUID = c.a(paramUUID, this);
    c.get(paramUUID);
    return paramUUID.b();
  }
  
  public WorkDatabase a()
  {
    return j;
  }
  
  public List a(Context paramContext, androidx.work.f paramF, androidx.work.impl.utils.asm.f paramF1)
  {
    return Arrays.asList(new l[] { Log.initialize(paramContext, this), new androidx.work.impl.client.cache.b(paramContext, paramF, paramF1, this) });
  }
  
  public void a(BroadcastReceiver.PendingResult paramPendingResult)
  {
    java.lang.Object localObject = m;
    try
    {
      r = paramPendingResult;
      if (p)
      {
        paramPendingResult.finish();
        r = null;
      }
      return;
    }
    catch (Throwable paramPendingResult)
    {
      throw paramPendingResult;
    }
  }
  
  public androidx.work.f b()
  {
    return d;
  }
  
  public com.google.common.util.concurrent.Object b(String paramString)
  {
    paramString = a.a(this, paramString);
    c.a().execute(paramString);
    return paramString.b();
  }
  
  public void b(String paramString, WorkerParameters.a paramA)
  {
    c.get(new Item(this, paramString, paramA));
  }
  
  public h c()
  {
    return b;
  }
  
  public void c(String paramString)
  {
    c.get(new androidx.work.impl.utils.l(this, paramString, false));
  }
  
  public void clear()
  {
    java.lang.Object localObject = m;
    try
    {
      p = true;
      BroadcastReceiver.PendingResult localPendingResult = r;
      if (localPendingResult != null)
      {
        localPendingResult.finish();
        r = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public List d()
  {
    return l;
  }
  
  public Context e()
  {
    return e;
  }
  
  public void e(String paramString)
  {
    c.get(new androidx.work.impl.utils.l(this, paramString, true));
  }
  
  public void f(String paramString)
  {
    b(paramString, null);
  }
  
  public ClassWriter get()
  {
    return a;
  }
  
  public androidx.work.impl.utils.asm.f i()
  {
    return c;
  }
  
  public void onConfigurationChanged()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      androidx.work.impl.background.systemjob.b.a(e());
    }
    a().a().c();
    Log.a(b(), a(), d());
  }
}
