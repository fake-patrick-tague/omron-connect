package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;

final class Label
{
  static final Label i = new Label(null, null);
  Label c;
  final Executor executor;
  final Runnable runnable;
  
  Label(Runnable paramRunnable, Executor paramExecutor)
  {
    runnable = paramRunnable;
    executor = paramExecutor;
  }
}
