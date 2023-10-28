package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzda
  extends zzdt
{
  zzda(zzee paramZzee, zzbz paramZzbz)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(queue))).getGmpAppId(log);
  }
  
  protected final void writeResource()
  {
    log.append(null);
  }
}
