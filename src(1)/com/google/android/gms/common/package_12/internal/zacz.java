package com.google.android.gms.common.package_12.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.internal.base.Logger;

final class zacz
  extends Logger
{
  public zacz(zada paramZada, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = what;
    if (i != 0)
    {
      if (i != 1)
      {
        paramMessage = new StringBuilder(70);
        paramMessage.append("TransformationResultHandler received unknown message type: ");
        paramMessage.append(i);
        Log.e("TransformedResultImpl", paramMessage.toString());
        return;
      }
      localObject = (RuntimeException)obj;
      paramMessage = String.valueOf(((Exception)localObject).getMessage());
      if (paramMessage.length() != 0) {
        paramMessage = "Runtime exception on the transformation worker thread: ".concat(paramMessage);
      } else {
        paramMessage = new String("Runtime exception on the transformation worker thread: ");
      }
      Log.e("TransformedResultImpl", paramMessage);
      throw ((Throwable)localObject);
    }
    Object localObject = (PendingResult)obj;
    paramMessage = zada.get(view);
    try
    {
      zada localZada = (zada)Preconditions.checkNotNull(zada.loadData(view));
      if (localObject == null) {
        zada.status(localZada, new Status(13, "Transform returned null"));
      } else if ((localObject instanceof zacp)) {
        zada.status(localZada, ((zacp)localObject).read());
      } else {
        localZada.sendUpdate((PendingResult)localObject);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
