package com.google.android.gms.common.package_12.internal;

import java.util.concurrent.locks.Lock;

abstract class zaav
  implements Runnable
{
  protected abstract void parse();
  
  public final void run()
  {
    zaaw.access$getLock(this$0).lock();
    for (;;)
    {
      try
      {
        boolean bool = Thread.interrupted();
        if (!bool) {
          continue;
        }
        localLock1 = zaaw.access$getLock(this$0);
      }
      catch (Throwable localThrowable) {}catch (RuntimeException localRuntimeException)
      {
        Lock localLock1;
        zaaw.append(this$0).onFutureDone(localRuntimeException);
        localLock2 = zaaw.access$getLock(this$0);
        continue;
      }
      localLock1.unlock();
      return;
      parse();
      localLock1 = zaaw.access$getLock(this$0);
    }
    Lock localLock2;
    zaaw.access$getLock(this$0).unlock();
    throw localLock2;
  }
}
