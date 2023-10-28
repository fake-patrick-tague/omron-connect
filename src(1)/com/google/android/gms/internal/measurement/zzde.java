package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzde
  extends zzdt
{
  zzde(zzee paramZzee, zzbz paramZzbz)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(queue))).getCurrentScreenClass(log);
  }
  
  protected final void writeResource()
  {
    log.append(null);
  }
}
