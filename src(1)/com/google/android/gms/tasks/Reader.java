package com.google.android.gms.tasks;

final class Reader
  implements Runnable
{
  Reader(RequestFutureTarget paramRequestFutureTarget, Task paramTask) {}
  
  public final void run()
  {
    Object localObject = RequestFutureTarget.run(error);
    try
    {
      RequestFutureTarget localRequestFutureTarget = error;
      if (RequestFutureTarget.getRequest(localRequestFutureTarget) != null) {
        RequestFutureTarget.getRequest(localRequestFutureTarget).onSuccess(task.getResult());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
