package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdc
  extends zzdt
{
  zzdc(zzee paramZzee, zzbz paramZzbz)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(queue))).generateEventId(log);
  }
  
  protected final void writeResource()
  {
    log.append(null);
  }
}
