package com.google.android.material.circularreveal;

import android.os.Build.VERSION;

public class Color
{
  public static final int index = 0;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      index = 2;
      return;
    }
    if (i >= 18)
    {
      index = 1;
      return;
    }
  }
}
