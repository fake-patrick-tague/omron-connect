package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.util.Clock;

abstract class zzdt
  implements Runnable
{
  final long high;
  final long low;
  final boolean val$exception;
  
  zzdt(zzee paramZzee, boolean paramBoolean)
  {
    low = value.currentTimeMillis();
    high = value.elapsedRealtime();
    val$exception = paramBoolean;
  }
  
  abstract void receiveLoop()
    throws RemoteException;
  
  public final void run()
  {
    if (zzee.isImportant(e))
    {
      writeResource();
      return;
    }
    try
    {
      receiveLoop();
      return;
    }
    catch (Exception localException)
    {
      zzee.onError(e, localException, false, val$exception);
      writeResource();
    }
  }
  
  protected void writeResource() {}
}
