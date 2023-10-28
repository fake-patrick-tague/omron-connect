package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzdz
  extends zzdt
{
  zzdz(zzed paramZzed, Activity paramActivity)
  {
    super(this$0, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(low.this$0))).onActivityPaused(ObjectWrapper.wrap(high), high);
  }
}
