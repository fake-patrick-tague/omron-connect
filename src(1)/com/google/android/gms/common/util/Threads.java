package com.google.android.gms.common.util;

import android.os.Looper;

public final class Threads
{
  public static boolean isOnMainThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
}
