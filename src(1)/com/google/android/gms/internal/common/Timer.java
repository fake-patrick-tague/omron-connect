package com.google.android.gms.internal.common;

import android.os.Build.VERSION;

public final class Timer
{
  public static final int timeLimit;
  
  static
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      i = 67108864;
    } else {
      i = 0;
    }
    timeLimit = i;
  }
}
