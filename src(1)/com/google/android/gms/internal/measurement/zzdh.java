package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdh
  extends zzdt
{
  zzdh(zzee paramZzee, Bundle paramBundle, zzbz paramZzbz)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(ask))).performAction(high, low, low);
  }
  
  protected final void writeResource()
  {
    low.append(null);
  }
}
