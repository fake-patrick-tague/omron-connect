package com.google.android.gms.common.package_12.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.Logger;

final class zabc
  extends Logger
{
  zabc(zabe paramZabe, Looper paramLooper)
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
        Log.w("GoogleApiClientImpl", paramMessage.toString());
        return;
      }
      zabe.onError(mCursor);
      return;
    }
    zabe.removeFile(mCursor);
  }
}
