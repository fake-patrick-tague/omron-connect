package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzcp
  extends zzdt
{
  zzcp(zzee paramZzee, String paramString1, String paramString2, zzbz paramZzbz)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(old))).getConditionalUserProperties(current, queue, log);
  }
  
  protected final void writeResource()
  {
    log.append(null);
  }
}
