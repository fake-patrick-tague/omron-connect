package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzcr
  extends zzdt
{
  zzcr(zzee paramZzee, Activity paramActivity, String paramString1, String paramString2)
  {
    super(paramZzee, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(bid))).setCurrentScreen(ObjectWrapper.wrap(ask), high, low, low);
  }
}
