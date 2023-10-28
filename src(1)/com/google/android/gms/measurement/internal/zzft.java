package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

final class zzft
  extends FutureTask
  implements Comparable
{
  final boolean data;
  private final long id;
  private final String realm;
  
  zzft(zzfv paramZzfv, Runnable paramRunnable, boolean paramBoolean, String paramString)
  {
    super(paramRunnable, null);
    Preconditions.checkNotNull(paramString);
    long l = zzfv.access$getCount().getAndIncrement();
    id = l;
    realm = paramString;
    data = paramBoolean;
    if (l == Long.MAX_VALUE) {
      this$0.zzay().iterator().append("Tasks index overflow");
    }
  }
  
  zzft(zzfv paramZzfv, Callable paramCallable, boolean paramBoolean, String paramString)
  {
    super(paramCallable);
    Preconditions.checkNotNull("Task exception on worker thread");
    long l = zzfv.access$getCount().getAndIncrement();
    id = l;
    realm = "Task exception on worker thread";
    data = paramBoolean;
    if (l == Long.MAX_VALUE) {
      this$0.zzay().iterator().append("Tasks index overflow");
    }
  }
  
  protected final void setException(Throwable paramThrowable)
  {
    event.this$0.zzay().iterator().append(realm, paramThrowable);
    if ((paramThrowable instanceof zzfr))
    {
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      if (localUncaughtExceptionHandler != null) {
        localUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), paramThrowable);
      }
    }
    super.setException(paramThrowable);
  }
}
