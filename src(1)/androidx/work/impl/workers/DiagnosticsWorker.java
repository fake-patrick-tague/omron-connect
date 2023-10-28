package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.ListenableWorker.a;
import androidx.work.Log;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.Attribute;
import androidx.work.impl.asm.Frame;
import androidx.work.impl.asm.h;
import androidx.work.impl.asm.i;
import androidx.work.impl.asm.l;
import androidx.work.impl.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker
  extends Worker
{
  private static final String b = Log.getInstance("DiagnosticsWrkr");
  
  public DiagnosticsWorker(Context paramContext, WorkerParameters paramWorkerParameters)
  {
    super(paramContext, paramWorkerParameters);
  }
  
  private static String a(h paramH, String paramString1, Integer paramInteger, String paramString2)
  {
    return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", new Object[] { a, x, paramInteger, p.name(), paramString1, paramString2 });
  }
  
  private static String a(l paramL, androidx.work.impl.asm.Object paramObject, Frame paramFrame, List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = "Job Id";
    } else {
      localObject1 = "Alarm Id";
    }
    localStringBuilder.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", new Object[] { localObject1 }));
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      h localH = (h)((Iterator)localObject1).next();
      paramList = null;
      Object localObject2 = paramFrame.get(a);
      if (localObject2 != null) {
        paramList = Integer.valueOf(a);
      }
      localObject2 = paramL.write(a);
      List localList = paramObject.get(a);
      localStringBuilder.append(a(localH, TextUtils.join(",", (Iterable)localObject2), paramList, TextUtils.join(",", localList)));
    }
    return localStringBuilder.toString();
  }
  
  public ListenableWorker.a run()
  {
    Object localObject1 = f.a(b()).a();
    Object localObject2 = ((WorkDatabase)localObject1).a();
    l localL = ((WorkDatabase)localObject1).d();
    androidx.work.impl.asm.Object localObject = ((WorkDatabase)localObject1).getValue();
    localObject1 = ((WorkDatabase)localObject1).read();
    Object localObject4 = ((i)localObject2).a(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
    Object localObject3 = ((i)localObject2).run();
    localObject2 = ((i)localObject2).a(200);
    Object localObject5;
    if ((localObject4 != null) && (!((List)localObject4).isEmpty()))
    {
      localObject5 = Log.get();
      String str = b;
      ((Log)localObject5).a(str, "Recently completed work:\n\n", new Throwable[0]);
      Log.get().a(str, a(localL, localObject, (Frame)localObject1, (List)localObject4), new Throwable[0]);
    }
    if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
    {
      localObject4 = Log.get();
      localObject5 = b;
      ((Log)localObject4).a((String)localObject5, "Running work:\n\n", new Throwable[0]);
      Log.get().a((String)localObject5, a(localL, localObject, (Frame)localObject1, (List)localObject3), new Throwable[0]);
    }
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject3 = Log.get();
      localObject4 = b;
      ((Log)localObject3).a((String)localObject4, "Enqueued work:\n\n", new Throwable[0]);
      Log.get().a((String)localObject4, a(localL, localObject, (Frame)localObject1, (List)localObject2), new Throwable[0]);
    }
    return ListenableWorker.a.createFactory();
  }
}
