package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.Log;
import androidx.work.impl.asm.h;
import androidx.work.impl.l;

public class g
  implements l
{
  private static final String g = Log.getInstance("SystemAlarmScheduler");
  private final Context j;
  
  public g(Context paramContext)
  {
    j = paramContext.getApplicationContext();
  }
  
  private void a(h paramH)
  {
    Log.get().append(g, String.format("Scheduling work with workSpecId %s", new Object[] { a }), new Throwable[0]);
    paramH = b.a(j, a);
    j.startService(paramH);
  }
  
  public void a(String paramString)
  {
    paramString = b.set(j, paramString);
    j.startService(paramString);
  }
  
  public void a(h... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      a(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public boolean b()
  {
    return true;
  }
}
