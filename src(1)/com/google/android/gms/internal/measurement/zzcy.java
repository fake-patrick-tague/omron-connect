package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzcy
  extends zzdt
{
  zzcy(zzee paramZzee, String paramString)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(low))).beginAdUnitExposure(high, high);
  }
}
