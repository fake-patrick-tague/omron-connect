package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzdx
  extends zzdt
{
  zzdx(zzed paramZzed, Activity paramActivity)
  {
    super(this$0, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(low.this$0))).onActivityStarted(ObjectWrapper.wrap(high), high);
  }
}
