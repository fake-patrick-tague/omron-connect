package com.google.android.gms.internal.base;

import com.google.android.gms.common.Feature;

public final class Menu
{
  public static final Feature FIRST;
  public static final Feature[] LAST;
  
  static
  {
    Feature localFeature = new Feature("CLIENT_TELEMETRY", 1L);
    FIRST = localFeature;
    LAST = new Feature[] { localFeature };
  }
}
