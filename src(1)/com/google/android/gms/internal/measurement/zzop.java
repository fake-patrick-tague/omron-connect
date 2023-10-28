package com.google.android.gms.internal.measurement;

public final class zzop
  implements zzoo
{
  public static final zzia get;
  public static final zzia groupchat;
  public static final zzia ready;
  public static final zzia write;
  
  static
  {
    zzhx localZzhx = new zzhx(zzhp.create("com.google.android.gms.measurement")).get();
    ready = localZzhx.valueOf("measurement.id.lifecycle.app_in_background_parameter", 0L);
    write = localZzhx.create("measurement.lifecycle.app_backgrounded_tracking", true);
    get = localZzhx.create("measurement.lifecycle.app_in_background_parameter", false);
    groupchat = localZzhx.valueOf("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
  }
  
  public zzop() {}
  
  public final boolean getOrElse()
  {
    return ((Boolean)get.equals()).booleanValue();
  }
}
