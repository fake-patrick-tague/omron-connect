package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgy;

final class zzdu
  extends zzch
{
  private final zzgy object;
  
  zzdu(zzgy paramZzgy)
  {
    object = paramZzgy;
  }
  
  public final int get()
  {
    return System.identityHashCode(object);
  }
  
  public final void sendHit(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    object.interceptEvent(paramString1, paramString2, paramBundle, paramLong);
  }
}
