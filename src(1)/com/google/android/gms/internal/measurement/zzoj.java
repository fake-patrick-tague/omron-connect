package com.google.android.gms.internal.measurement;

public final class zzoj
  implements zzoi
{
  public static final zzia GLOBAL;
  public static final zzia LOCAL;
  public static final zzia TRANSACTION;
  public static final zzia VERSION_CONTROLLED_CONFIGURATION;
  public static final zzia WORKSPACE;
  
  static
  {
    zzhx localZzhx = new zzhx(zzhp.create("com.google.android.gms.measurement")).create().get();
    TRANSACTION = localZzhx.create("measurement.client.global_params", true);
    LOCAL = localZzhx.create("measurement.service.global_params_in_payload", true);
    GLOBAL = localZzhx.create("measurement.service.clear_global_params_on_uninstall", true);
    WORKSPACE = localZzhx.create("measurement.service.global_params", true);
    VERSION_CONTROLLED_CONFIGURATION = localZzhx.valueOf("measurement.id.service.global_params", 0L);
  }
  
  public zzoj() {}
  
  public final boolean getOrElse()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
  
  public final boolean play_next()
  {
    return true;
  }
}
