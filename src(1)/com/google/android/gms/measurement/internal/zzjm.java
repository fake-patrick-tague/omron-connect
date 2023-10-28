package com.google.android.gms.measurement.internal;

final class zzjm
  implements Runnable
{
  zzjm(zzjr paramZzjr, zzee paramZzee) {}
  
  public final void run()
  {
    zzjr localZzjr = bitmap;
    try
    {
      zzjr.display(bitmap, false);
      if (!bitmap.this$0.add())
      {
        bitmap.this$0.this$0.zzay().next().append("Connected to service");
        bitmap.this$0.clear(path);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
