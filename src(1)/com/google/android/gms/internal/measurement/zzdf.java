package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdf
  extends zzdt
{
  zzdf(zzee paramZzee, String paramString1, String paramString2, boolean paramBoolean, zzbz paramZzbz)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(low))).getUserProperties(range, current, queue, log);
  }
  
  protected final void writeResource()
  {
    log.append(null);
  }
}
