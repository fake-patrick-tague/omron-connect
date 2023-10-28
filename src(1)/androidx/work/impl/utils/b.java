package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.room.RoomDatabase;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Item;
import androidx.work.i;
import androidx.work.impl.Label;
import androidx.work.impl.Pair;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.h;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.f;
import androidx.work.impl.l;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.l.b.a;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b
  implements Runnable
{
  private static final String a = androidx.work.Log.getInstance("EnqueueRunnable");
  private final Label b;
  private final Pair c;
  
  public b(Label paramLabel)
  {
    b = paramLabel;
    c = new Pair();
  }
  
  private static void a(h paramH)
  {
    Object localObject = b;
    String str = x;
    if ((!str.equals(ConstraintTrackingWorker.class.getName())) && ((((i)localObject).c()) || (((i)localObject).a())))
    {
      localObject = new Item();
      ((Item)localObject).a(c).a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
      x = ConstraintTrackingWorker.class.getName();
      c = ((Item)localObject).a();
    }
  }
  
  private static boolean a(Label paramLabel)
  {
    Set localSet = Label.get(paramLabel);
    boolean bool = a(paramLabel.b(), paramLabel.put(), (String[])localSet.toArray(new String[0]), paramLabel.c(), paramLabel.d());
    paramLabel.setIcon();
    return bool;
  }
  
  private static boolean a(f paramF, String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      paramF = paramF.d().iterator();
      boolean bool;
      do
      {
        bool = paramF.hasNext();
        if (!bool) {
          break;
        }
        Object localObject = paramF.next();
        localObject = (l)localObject;
        bool = paramString.isAssignableFrom(localObject.getClass());
      } while (!bool);
      return true;
      return false;
    }
    catch (ClassNotFoundException paramF) {}
    return false;
  }
  
  private static boolean a(f paramF, List paramList, String[] paramArrayOfString, String paramString, ExistingWorkPolicy paramExistingWorkPolicy)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a50 = a49\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  private static boolean write(Label paramLabel)
  {
    Object localObject = paramLabel.getValue();
    int i = 0;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      boolean bool = false;
      for (;;)
      {
        i = bool;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        Label localLabel = (Label)((Iterator)localObject).next();
        if (!localLabel.next()) {
          bool |= write(localLabel);
        } else {
          androidx.work.Log.get().add(a, String.format("Already enqueued work ids (%s).", new Object[] { TextUtils.join(", ", localLabel.get()) }), new Throwable[0]);
        }
      }
    }
    return a(paramLabel) | i;
  }
  
  public androidx.work.b a()
  {
    return c;
  }
  
  public void b()
  {
    f localF = b.b();
    androidx.work.impl.Log.a(localF.b(), localF.a(), localF.d());
  }
  
  public void run()
  {
    try
    {
      boolean bool = b.draw();
      if (!bool)
      {
        bool = write();
        if (bool)
        {
          Context.get(b.b().e(), RescheduleReceiver.class, true);
          b();
        }
        c.add(androidx.work.b.b);
        return;
      }
      throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[] { b }));
    }
    catch (Throwable localThrowable)
    {
      c.add(new l.b.a(localThrowable));
    }
  }
  
  public boolean write()
  {
    WorkDatabase localWorkDatabase = b.b().a();
    localWorkDatabase.add();
    try
    {
      boolean bool = write(b);
      localWorkDatabase.remove();
      localWorkDatabase.clear();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localWorkDatabase.clear();
      throw localThrowable;
    }
  }
}
