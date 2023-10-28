package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.c;

final class Job<V>
  implements Runnable
{
  final a<V> log;
  final c<? extends V> this$0;
  
  Job(AbstractFuture paramAbstractFuture, com.google.common.util.concurrent.Object paramObject)
  {
    log = paramAbstractFuture;
    this$0 = paramObject;
  }
  
  public void run()
  {
    if (log.value != this) {
      return;
    }
    Object localObject = AbstractFuture.get(this$0);
    if (AbstractFuture.this$0.get(log, this, localObject)) {
      AbstractFuture.execute(log);
    }
  }
}
