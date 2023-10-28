package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdq
  extends zzdt
{
  zzdq(zzee paramZzee, zzdv paramZzdv)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(tc))).unregisterOnMeasurementEventListener(blockSize);
  }
}
