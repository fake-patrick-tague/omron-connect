package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdr
  extends zzdt
{
  zzdr(zzee paramZzee, Long paramLong, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    Long localLong = dbid;
    long l;
    if (localLong == null) {
      l = low;
    } else {
      l = localLong.longValue();
    }
    ((zzcc)Preconditions.checkNotNull(zzee.append(low))).logEvent(remoteId, updated, feed_id, content, isSet, l);
  }
}
