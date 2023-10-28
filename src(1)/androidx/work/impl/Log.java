package androidx.work.impl;

import android.os.Build.VERSION;
import androidx.room.RoomDatabase;
import androidx.work.impl.asm.h;
import androidx.work.impl.asm.i;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemalarm.g;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.background.systemjob.b;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

public class Log
{
  private static final String id = androidx.work.Log.getInstance("Schedulers");
  
  public static void a(androidx.work.f paramF, WorkDatabase paramWorkDatabase, List paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject1 = paramWorkDatabase.a();
      paramWorkDatabase.add();
      try
      {
        Object localObject2 = ((i)localObject1).run(paramF.a());
        paramF = ((i)localObject1).a(200);
        if (localObject2 != null)
        {
          int i = ((List)localObject2).size();
          if (i > 0)
          {
            long l = System.currentTimeMillis();
            Iterator localIterator = ((List)localObject2).iterator();
            for (;;)
            {
              boolean bool = localIterator.hasNext();
              if (!bool) {
                break;
              }
              ((i)localObject1).add(nexta, l);
            }
          }
        }
        paramWorkDatabase.remove();
        paramWorkDatabase.clear();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          paramWorkDatabase = (h[])((List)localObject2).toArray(new h[((List)localObject2).size()]);
          localObject1 = paramList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (l)((Iterator)localObject1).next();
            if (((l)localObject2).b()) {
              ((l)localObject2).a(paramWorkDatabase);
            }
          }
        }
        if (paramF != null)
        {
          if (paramF.size() > 0)
          {
            paramF = (h[])paramF.toArray(new h[paramF.size()]);
            paramWorkDatabase = paramList.iterator();
            while (paramWorkDatabase.hasNext())
            {
              paramList = (l)paramWorkDatabase.next();
              if (!paramList.b()) {
                paramList.a(paramF);
              }
            }
          }
        }
        else {}
      }
      catch (Throwable paramF)
      {
        paramWorkDatabase.clear();
        throw paramF;
      }
    }
  }
  
  private static l get(android.content.Context paramContext)
  {
    try
    {
      paramContext = (l)Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(new Class[] { android.content.Context.class }).newInstance(new Object[] { paramContext });
      androidx.work.Log.get().append(id, String.format("Created %s", new Object[] { "androidx.work.impl.background.gcm.GcmScheduler" }), new Throwable[0]);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      androidx.work.Log.get().append(id, "Unable to create GCM Scheduler", new Throwable[] { paramContext });
    }
    return null;
  }
  
  static l initialize(android.content.Context paramContext, f paramF)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramF = new b(paramContext, paramF);
      androidx.work.impl.utils.Context.get(paramContext, SystemJobService.class, true);
      androidx.work.Log.get().append(id, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
      return paramF;
    }
    paramF = get(paramContext);
    if (paramF == null)
    {
      paramF = new g(paramContext);
      androidx.work.impl.utils.Context.get(paramContext, SystemAlarmService.class, true);
      androidx.work.Log.get().append(id, "Created SystemAlarmScheduler", new Throwable[0]);
      return paramF;
    }
    return paramF;
  }
}
