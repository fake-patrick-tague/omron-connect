package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzds
  extends zzdt
{
  zzds(zzee paramZzee, String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(azimuth))).setUserProperty(pitch, volume, ObjectWrapper.wrap(high), low, low);
  }
}
