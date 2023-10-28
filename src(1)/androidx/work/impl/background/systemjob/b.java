package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import androidx.work.Log;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo.State;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.Attribute;
import androidx.work.impl.asm.Frame;
import androidx.work.impl.asm.h;
import androidx.work.impl.asm.i;
import androidx.work.impl.l;
import androidx.work.impl.utils.ByteVector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class b
  implements l
{
  private static final String g = Log.getInstance("SystemJobScheduler");
  private final g a;
  private final JobScheduler b;
  private final Context c;
  private final androidx.work.impl.f l;
  
  public b(Context paramContext, androidx.work.impl.f paramF)
  {
    this(paramContext, paramF, (JobScheduler)paramContext.getSystemService("jobscheduler"), new g(paramContext));
  }
  
  public b(Context paramContext, androidx.work.impl.f paramF, JobScheduler paramJobScheduler, g paramG)
  {
    c = paramContext;
    l = paramF;
    b = paramJobScheduler;
    a = paramG;
  }
  
  private static List a(Context paramContext, JobScheduler paramJobScheduler, String paramString)
  {
    paramJobScheduler = read(paramContext, paramJobScheduler);
    if (paramJobScheduler == null) {
      return null;
    }
    paramContext = new ArrayList(2);
    paramJobScheduler = paramJobScheduler.iterator();
    while (paramJobScheduler.hasNext())
    {
      JobInfo localJobInfo = (JobInfo)paramJobScheduler.next();
      if (paramString.equals(getId(localJobInfo))) {
        paramContext.add(Integer.valueOf(localJobInfo.getId()));
      }
    }
    return paramContext;
  }
  
  public static void a(Context paramContext)
  {
    JobScheduler localJobScheduler = (JobScheduler)paramContext.getSystemService("jobscheduler");
    if (localJobScheduler != null)
    {
      paramContext = read(paramContext, localJobScheduler);
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext()) {
          write(localJobScheduler, ((JobInfo)paramContext.next()).getId());
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, androidx.work.impl.f paramF)
  {
    Object localObject1 = (JobScheduler)paramContext.getSystemService("jobscheduler");
    Object localObject2 = read(paramContext, (JobScheduler)localObject1);
    paramContext = paramF.a().read().get();
    boolean bool2 = false;
    int i;
    if (localObject2 != null) {
      i = ((List)localObject2).size();
    } else {
      i = 0;
    }
    HashSet localHashSet = new HashSet(i);
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        JobInfo localJobInfo = (JobInfo)((Iterator)localObject2).next();
        String str = getId(localJobInfo);
        if (!TextUtils.isEmpty(str)) {
          localHashSet.add(str);
        } else {
          write((JobScheduler)localObject1, localJobInfo.getId());
        }
      }
    }
    localObject1 = paramContext.iterator();
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (localHashSet.contains((String)((Iterator)localObject1).next()));
    Log.get().append(g, "Reconciling jobs", new Throwable[0]);
    boolean bool1 = true;
    if (bool1)
    {
      paramF = paramF.a();
      paramF.add();
      try
      {
        localObject1 = paramF.a();
        paramContext = paramContext.iterator();
        for (;;)
        {
          bool2 = paramContext.hasNext();
          if (!bool2) {
            break;
          }
          ((i)localObject1).add((String)paramContext.next(), -1L);
        }
        paramF.remove();
        paramF.clear();
        return bool1;
      }
      catch (Throwable paramContext)
      {
        paramF.clear();
        throw paramContext;
      }
    }
    return bool1;
  }
  
  private static String getId(JobInfo paramJobInfo)
  {
    paramJobInfo = paramJobInfo.getExtras();
    if (paramJobInfo != null) {}
    try
    {
      boolean bool = paramJobInfo.containsKey("EXTRA_WORK_SPEC_ID");
      if (bool)
      {
        paramJobInfo = paramJobInfo.getString("EXTRA_WORK_SPEC_ID");
        return paramJobInfo;
      }
    }
    catch (NullPointerException paramJobInfo)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static List read(Context paramContext, JobScheduler paramJobScheduler)
  {
    try
    {
      paramJobScheduler = paramJobScheduler.getAllPendingJobs();
    }
    catch (Throwable paramJobScheduler)
    {
      Log.get().get(g, "getAllPendingJobs() is not reliable on this device.", new Throwable[] { paramJobScheduler });
      paramJobScheduler = null;
    }
    if (paramJobScheduler == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramJobScheduler.size());
    paramContext = new ComponentName(paramContext, SystemJobService.class);
    paramJobScheduler = paramJobScheduler.iterator();
    while (paramJobScheduler.hasNext())
    {
      JobInfo localJobInfo = (JobInfo)paramJobScheduler.next();
      if (paramContext.equals(localJobInfo.getService())) {
        localArrayList.add(localJobInfo);
      }
    }
    return localArrayList;
  }
  
  private static void write(JobScheduler paramJobScheduler, int paramInt)
  {
    try
    {
      paramJobScheduler.cancel(paramInt);
      return;
    }
    catch (Throwable paramJobScheduler)
    {
      Log.get().get(g, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[] { Integer.valueOf(paramInt) }), new Throwable[] { paramJobScheduler });
    }
  }
  
  public void a(h paramH, int paramInt)
  {
    Object localObject2 = a.a(paramH, paramInt);
    Object localObject3 = Log.get();
    String str = g;
    ((Log)localObject3).append(str, String.format("Scheduling work ID %s Job ID %s", new Object[] { a, Integer.valueOf(paramInt) }), new Throwable[0]);
    localObject3 = b;
    try
    {
      int i = ((JobScheduler)localObject3).schedule((JobInfo)localObject2);
      if (i == 0)
      {
        localObject2 = Log.get();
        localObject3 = a;
        localObject3 = String.format("Unable to schedule work ID %s", new Object[] { localObject3 });
        ((Log)localObject2).add(str, (String)localObject3, new Throwable[0]);
        boolean bool = h;
        if (bool)
        {
          localObject2 = y;
          localObject3 = OutOfQuotaPolicy.a;
          if (localObject2 == localObject3)
          {
            h = false;
            localObject2 = a;
            localObject2 = String.format("Scheduling a non-expedited job (work ID %s)", new Object[] { localObject2 });
            localObject3 = Log.get();
            ((Log)localObject3).append(str, (String)localObject2, new Throwable[0]);
            a(paramH, paramInt);
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Log.get().get(g, String.format("Unable to schedule %s", new Object[] { paramH }), new Throwable[] { localThrowable });
      return;
    }
    catch (IllegalStateException paramH)
    {
      Object localObject1 = read(c, b);
      if (localObject1 != null) {
        paramInt = ((List)localObject1).size();
      } else {
        paramInt = 0;
      }
      localObject1 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(l.a().a().a().size()), Integer.valueOf(l.b().a()) });
      Log.get().get(g, (String)localObject1, new Throwable[0]);
      throw new IllegalStateException((String)localObject1, paramH);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = a(c, b, paramString);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        write(b, i);
      }
      l.a().read().a(paramString);
    }
  }
  
  public void a(h... paramVarArgs)
  {
    WorkDatabase localWorkDatabase = l.a();
    ByteVector localByteVector = new ByteVector(localWorkDatabase);
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      h localH = paramVarArgs[i];
      localWorkDatabase.add();
      try
      {
        Object localObject1 = localWorkDatabase.a().a(a);
        Object localObject2;
        StringBuilder localStringBuilder;
        if (localObject1 == null)
        {
          localObject1 = Log.get();
          localObject2 = g;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Skipping scheduling ");
          localStringBuilder.append(a);
          localStringBuilder.append(" because it's no longer in the DB");
          ((Log)localObject1).add((String)localObject2, localStringBuilder.toString(), new Throwable[0]);
          localWorkDatabase.remove();
        }
        else
        {
          localObject1 = p;
          localObject2 = WorkInfo.State.a;
          if (localObject1 != localObject2)
          {
            localObject1 = Log.get();
            localObject2 = g;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Skipping scheduling ");
            localStringBuilder.append(a);
            localStringBuilder.append(" because it is no longer enqueued");
            ((Log)localObject1).add((String)localObject2, localStringBuilder.toString(), new Throwable[0]);
            localWorkDatabase.remove();
          }
          else
          {
            localObject1 = localWorkDatabase.read().get(a);
            int j;
            if (localObject1 != null) {
              j = a;
            } else {
              j = localByteVector.a(l.b().f(), l.b().e());
            }
            if (localObject1 == null)
            {
              localObject1 = new Attribute(a, j);
              l.a().read().a((Attribute)localObject1);
            }
            a(localH, j);
            int m = Build.VERSION.SDK_INT;
            if (m == 23)
            {
              localObject1 = a(c, b, a);
              if (localObject1 != null)
              {
                j = ((List)localObject1).indexOf(Integer.valueOf(j));
                if (j >= 0) {
                  ((List)localObject1).remove(j);
                }
                boolean bool = ((List)localObject1).isEmpty();
                if (!bool) {
                  j = ((Integer)((List)localObject1).get(0)).intValue();
                } else {
                  j = localByteVector.a(l.b().f(), l.b().e());
                }
                a(localH, j);
              }
            }
            localWorkDatabase.remove();
          }
        }
        localWorkDatabase.clear();
        i += 1;
      }
      catch (Throwable paramVarArgs)
      {
        localWorkDatabase.clear();
        throw paramVarArgs;
      }
    }
  }
  
  public boolean b()
  {
    return true;
  }
}
