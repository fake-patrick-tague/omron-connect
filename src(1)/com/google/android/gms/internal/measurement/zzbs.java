package com.google.android.gms.internal.measurement;

import android.os.Build.VERSION;

public final class zzbs
{
  public static final int id;
  
  static
  {
    int i;
    if (Build.VERSION.SDK_INT >= 31) {
      i = 33554432;
    } else {
      i = 0;
    }
    id = i;
  }
}
