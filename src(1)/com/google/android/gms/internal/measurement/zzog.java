package com.google.android.gms.internal.measurement;

public final class zzog
  implements zzof
{
  public static final zzia GLOBAL;
  public static final zzia VERSION_CONTROLLED_CONFIGURATION;
  public static final zzia WORKSPACE;
  
  static
  {
    zzhx localZzhx = new zzhx(zzhp.create("com.google.android.gms.measurement")).get();
    GLOBAL = localZzhx.create("measurement.client.sessions.check_on_reset_and_enable2", true);
    WORKSPACE = localZzhx.create("measurement.client.sessions.check_on_startup", true);
    VERSION_CONTROLLED_CONFIGURATION = localZzhx.create("measurement.client.sessions.start_session_before_view_screen", true);
  }
  
  public zzog() {}
  
  public final boolean getOrElse()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
  
  public final boolean isEmpty()
  {
    return true;
  }
}
