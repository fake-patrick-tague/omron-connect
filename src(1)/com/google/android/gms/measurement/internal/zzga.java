package com.google.android.gms.measurement.internal;

final class zzga
  implements Runnable
{
  zzga(zzgq paramZzgq, zzac paramZzac, Item paramItem) {}
  
  public final void run()
  {
    zzgq.getInstance(this$0).write();
    if (responseHandler.context.get() == null)
    {
      zzgq.getInstance(this$0).put(responseHandler, request);
      return;
    }
    zzgq.getInstance(this$0).execute(responseHandler, request);
  }
}
