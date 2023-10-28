package androidx.work.impl;

import androidx.work.ListenableWorker;
import androidx.work.Log;
import androidx.work.impl.asm.h;
import androidx.work.impl.utils.futures.Context;
import java.util.concurrent.Future;

class a
  implements Runnable
{
  a(i paramI, com.google.common.util.concurrent.Object paramObject, Context paramContext) {}
  
  public void run()
  {
    try
    {
      d.get();
      Log.get().append(i.a, String.format("Starting work for %s", new java.lang.Object[] { b.l.x }), new Throwable[0]);
      i localI = b;
      t = h.get();
      c.cancel(b.t);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.get(localThrowable);
    }
  }
}
