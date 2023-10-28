package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdp
  extends zzdt
{
  zzdp(zzee paramZzee, zzdv paramZzdv)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(tc))).registerOnMeasurementEventListener(blockSize);
  }
}
