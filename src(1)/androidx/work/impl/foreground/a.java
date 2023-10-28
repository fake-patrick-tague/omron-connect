package androidx.work.impl.foreground;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.h;
import androidx.work.impl.asm.i;
import androidx.work.impl.ui.f;
import java.util.Map;
import java.util.Set;

class a
  implements Runnable
{
  a(b paramB, WorkDatabase paramWorkDatabase, String paramString) {}
  
  public void run()
  {
    Object localObject2 = c.a().a(b);
    if ((localObject2 != null) && (((h)localObject2).b()))
    {
      Object localObject1 = a.e;
      try
      {
        a.m.put(b, localObject2);
        a.j.add(localObject2);
        localObject2 = a;
        k.a(j);
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
}
