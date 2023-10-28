package androidx.work.impl.utils;

import androidx.room.RoomDatabase;
import androidx.work.Log;
import androidx.work.WorkInfo.State;
import androidx.work.impl.ClassWriter;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.i;
import androidx.work.impl.f;

public class l
  implements Runnable
{
  private static final String b = Log.getInstance("StopWorkRunnable");
  private final String a;
  private final boolean c;
  private final f d;
  
  public l(f paramF, String paramString, boolean paramBoolean)
  {
    d = paramF;
    a = paramString;
    c = paramBoolean;
  }
  
  public void run()
  {
    WorkDatabase localWorkDatabase = d.a();
    Object localObject = d.get();
    i localI = localWorkDatabase.a();
    localWorkDatabase.add();
    try
    {
      boolean bool1 = ((ClassWriter)localObject).accept(a);
      boolean bool2 = c;
      if (bool2)
      {
        bool1 = d.get().b(a);
      }
      else
      {
        if (!bool1)
        {
          localObject = localI.get(a);
          WorkInfo.State localState = WorkInfo.State.b;
          if (localObject == localState) {
            localI.a(WorkInfo.State.a, new String[] { a });
          }
        }
        bool1 = d.get().a(a);
      }
      Log.get().append(b, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", new Object[] { a, Boolean.valueOf(bool1) }), new Throwable[0]);
      localWorkDatabase.remove();
      localWorkDatabase.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      localWorkDatabase.clear();
      throw localThrowable;
    }
  }
}
