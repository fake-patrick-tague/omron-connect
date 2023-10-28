package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

public class Marker
{
  public static boolean evaluate()
  {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
  }
}
