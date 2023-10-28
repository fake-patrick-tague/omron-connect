package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdj
  extends zzdt
{
  zzdj(zzee paramZzee, String paramString, zzbz paramZzbz)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(set))).getMaxUserProperties(queue, log);
  }
  
  protected final void writeResource()
  {
    log.append(null);
  }
}
