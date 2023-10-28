package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzby;

public final class zzki
  extends Log
{
  private Handler a;
  protected final zzke handler = new zzke(this);
  protected final zzkh id = new zzkh(this);
  protected final zzkg this$0 = new zzkg(this);
  
  zzki(zzfy paramZzfy)
  {
    super(paramZzfy);
  }
  
  private final void acquire()
  {
    append();
    if (a == null) {
      a = new zzby(Looper.getMainLooper());
    }
  }
  
  protected final boolean isMapped()
  {
    return false;
  }
}
