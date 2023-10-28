package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;

public class Logger
  extends Handler
{
  public Logger() {}
  
  public Logger(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public Logger(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
  }
}
