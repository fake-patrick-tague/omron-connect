package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzea
  extends zzdt
{
  zzea(zzed paramZzed, Activity paramActivity)
  {
    super(this$0, true);
  }
  
  final void receiveLoop()
    throws RemoteException
  {
    ((zzcc)Preconditions.checkNotNull(zzee.append(low.this$0))).onActivityStopped(ObjectWrapper.wrap(high), high);
  }
}
