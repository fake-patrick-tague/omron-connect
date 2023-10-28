package com.google.android.gms.internal.common;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;

public class Util
  extends Handler
{
  public Util() {}
  
  public Util(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public Util(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
  }
}
