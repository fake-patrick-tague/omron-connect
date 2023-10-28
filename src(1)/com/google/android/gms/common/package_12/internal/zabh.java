package com.google.android.gms.common.package_12.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.Logger;

final class zabh
  extends Logger
{
  zabh(zabi paramZabi, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = what;
    if (i != 1)
    {
      if (i != 2)
      {
        paramMessage = new StringBuilder(31);
        paramMessage.append("Unknown message id: ");
        paramMessage.append(i);
        Log.w("GACStateManager", paramMessage.toString());
        return;
      }
      throw ((RuntimeException)obj);
    }
    ((zabg)obj).complete(id);
  }
}
