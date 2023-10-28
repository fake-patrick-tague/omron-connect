package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdo
  extends zzdt
{
  zzdo(zzee paramZzee, zzdu paramZzdu)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(tc))).setEventInterceptor(blockSize);
  }
}
