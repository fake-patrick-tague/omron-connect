package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzcs
  extends zzdt
{
  zzcs(zzee paramZzee, Boolean paramBoolean)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    if (high != null)
    {
      ((zzcc)Preconditions.checkNotNull(zzee.append(low))).setMeasurementEnabled(high.booleanValue(), low);
      return;
    }
    ((zzcc)Preconditions.checkNotNull(zzee.append(low))).clearMeasurementEnabled(low);
  }
}
