package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class Connection
  implements Object
{
  private final Continuation out;
  private final AbstractDataSource sock;
  private final Executor socket;
  
  public Connection(Executor paramExecutor, Continuation paramContinuation, AbstractDataSource paramAbstractDataSource)
  {
    socket = paramExecutor;
    out = paramContinuation;
    sock = paramAbstractDataSource;
  }
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public final void run(Task paramTask)
  {
    socket.execute(new LoggingReceiver.Slurper(this, paramTask));
  }
}
