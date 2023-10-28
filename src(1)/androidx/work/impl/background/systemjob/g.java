package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobInfo.TriggerContentUri;
import android.content.ComponentName;
import android.net.NetworkRequest.Builder;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.Log;
import androidx.work.NetworkType;
import androidx.work.Segment;
import androidx.work.Type;
import androidx.work.i;
import androidx.work.impl.asm.h;
import java.util.Iterator;
import java.util.Set;

class g
{
  private static final String b = Log.getInstance("SystemJobInfoConverter");
  private final ComponentName a;
  
  g(android.content.Context paramContext)
  {
    a = new ComponentName(paramContext.getApplicationContext(), SystemJobService.class);
  }
  
  static int a(NetworkType paramNetworkType)
  {
    int i = Type.c[paramNetworkType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if ((i == 5) && (Build.VERSION.SDK_INT >= 26)) {
              return 4;
            }
          }
          else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
          }
          Log.get().append(b, String.format("API version too low. Cannot convert network type value %s", new Object[] { paramNetworkType }), new Throwable[0]);
          return 1;
        }
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private static JobInfo.TriggerContentUri a(Segment paramSegment)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  static void c(JobInfo.Builder paramBuilder, NetworkType paramNetworkType)
  {
    if ((Build.VERSION.SDK_INT >= 30) && (paramNetworkType == NetworkType.b))
    {
      paramBuilder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
      return;
    }
    paramBuilder.setRequiredNetworkType(a(paramNetworkType));
  }
  
  JobInfo a(h paramH, int paramInt)
  {
    i localI = b;
    Object localObject = new PersistableBundle();
    ((BaseBundle)localObject).putString("EXTRA_WORK_SPEC_ID", a);
    ((BaseBundle)localObject).putBoolean("EXTRA_IS_PERIODIC", paramH.j());
    localObject = new JobInfo.Builder(paramInt, a).setRequiresCharging(localI.g()).setRequiresDeviceIdle(localI.f()).setExtras((PersistableBundle)localObject);
    c((JobInfo.Builder)localObject, localI.p());
    boolean bool = localI.f();
    int i = 0;
    if (!bool)
    {
      if (d == BackoffPolicy.b) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      ((JobInfo.Builder)localObject).setBackoffCriteria(f, paramInt);
    }
    long l = Math.max(paramH.a() - System.currentTimeMillis(), 0L);
    paramInt = Build.VERSION.SDK_INT;
    if (paramInt <= 28) {
      ((JobInfo.Builder)localObject).setMinimumLatency(l);
    } else if (l > 0L) {
      ((JobInfo.Builder)localObject).setMinimumLatency(l);
    } else if (!h) {
      ((JobInfo.Builder)localObject).setImportantWhileForeground(true);
    }
    if ((paramInt >= 24) && (localI.b()))
    {
      Iterator localIterator = localI.add().getValue().iterator();
      while (localIterator.hasNext()) {
        ((JobInfo.Builder)localObject).addTriggerContentUri(a((Segment)localIterator.next()));
      }
      ((JobInfo.Builder)localObject).setTriggerContentUpdateDelay(localI.size());
      ((JobInfo.Builder)localObject).setTriggerContentMaxDelay(localI.e());
    }
    ((JobInfo.Builder)localObject).setPersisted(false);
    if (Build.VERSION.SDK_INT >= 26)
    {
      ((JobInfo.Builder)localObject).setRequiresBatteryNotLow(localI.c());
      ((JobInfo.Builder)localObject).setRequiresStorageNotLow(localI.a());
    }
    if (e > 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (l > 0L) {
      i = 1;
    }
    if ((v7.v7.menu.Context.getType()) && (h) && (paramInt == 0) && (i == 0)) {
      ((JobInfo.Builder)localObject).setExpedited(true);
    }
    return ((JobInfo.Builder)localObject).build();
  }
}
