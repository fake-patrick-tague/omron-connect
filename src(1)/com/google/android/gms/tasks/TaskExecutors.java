package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

public final class TaskExecutors
{
  public static final Executor MAIN_THREAD = new ExecutorDelivery.1();
  static final Executor executor = new Threading.2();
  
  private TaskExecutors() {}
}
