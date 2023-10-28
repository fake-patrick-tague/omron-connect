package com.google.android.gms.measurement.internal;

import android.util.Log;

final class zzel
  implements Runnable
{
  zzel(zzeo paramZzeo, int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
  public final void run()
  {
    zzfd localZzfd = this$0.this$0.put();
    if (localZzfd.write())
    {
      Object localObject1 = this$0;
      if (zzeo.c((zzeo)localObject1) == 0) {
        if (this$0.append().get())
        {
          localObject1 = this$0;
          this$0.zzaw();
          zzeo.b((zzeo)localObject1, 'C');
        }
        else
        {
          localObject1 = this$0;
          this$0.zzaw();
          zzeo.b((zzeo)localObject1, 'c');
        }
      }
      localObject1 = this$0;
      if (zzeo.access$getValue((zzeo)localObject1) < 0L)
      {
        this$0.append().length();
        zzeo.onCompleted((zzeo)localObject1, 73000L);
      }
      char c1 = "01VDIWEA?".charAt(start);
      localObject1 = this$0;
      char c2 = zzeo.c((zzeo)localObject1);
      long l = zzeo.access$getValue((zzeo)localObject1);
      localObject1 = zzeo.get(true, data, activity, text, prefix);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("2");
      ((StringBuilder)localObject2).append(c1);
      ((StringBuilder)localObject2).append(c2);
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      if (((String)localObject2).length() > 1024) {
        localObject1 = data.substring(0, 1024);
      }
      localObject2 = last;
      if (localObject2 != null) {
        ((zzfb)localObject2).set((String)localObject1, 1L);
      }
    }
    else
    {
      Log.println(6, this$0.read(), "Persisted config not initialized. Not logging error/warn");
    }
  }
}
