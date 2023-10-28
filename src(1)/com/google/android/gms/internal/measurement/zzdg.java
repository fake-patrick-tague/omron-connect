package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzdg
  extends zzdt
{
  zzdg(zzee paramZzee, boolean paramBoolean, int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    super(paramZzee, false);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(ask))).logHealthData(5, high, ObjectWrapper.wrap(low), ObjectWrapper.wrap(null), ObjectWrapper.wrap(null));
  }
}
