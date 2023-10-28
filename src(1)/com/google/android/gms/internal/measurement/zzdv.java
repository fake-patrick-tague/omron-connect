package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgz;

final class zzdv
  extends zzch
{
  private final zzgz receiver;
  
  zzdv(zzgz paramZzgz)
  {
    receiver = paramZzgz;
  }
  
  public final int get()
  {
    return System.identityHashCode(receiver);
  }
  
  public final void sendHit(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    receiver.onEvent(paramString1, paramString2, paramBundle, paramLong);
  }
}
