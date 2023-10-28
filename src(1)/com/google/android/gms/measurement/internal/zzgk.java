package com.google.android.gms.measurement.internal;

final class zzgk
  implements Runnable
{
  zzgk(zzgq paramZzgq, zzaw paramZzaw, String paramString) {}
  
  public final void run()
  {
    zzgq.getInstance(this$0).write();
    zzgq.getInstance(this$0).read(bluetoothDevice, deviceName);
  }
}
