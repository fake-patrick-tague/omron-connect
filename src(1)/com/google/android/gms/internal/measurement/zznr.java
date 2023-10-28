package com.google.android.gms.internal.measurement;

public final class zznr
  implements zznq
{
  public static final zzia VERSION_CONTROLLED_CONFIGURATION;
  public static final zzia VERSION_HISTORY;
  public static final zzia VERSION_NAME;
  public static final zzia table;
  
  static
  {
    zzhx localZzhx = new zzhx(zzhp.create("com.google.android.gms.measurement")).get();
    VERSION_CONTROLLED_CONFIGURATION = localZzhx.create("measurement.client.consent_state_v1", true);
    VERSION_NAME = localZzhx.create("measurement.client.3p_consent_state_v1", true);
    VERSION_HISTORY = localZzhx.create("measurement.service.consent_state_v1_W36", true);
    table = localZzhx.valueOf("measurement.service.storage_consent_support_version", 203600L);
  }
  
  public zznr() {}
  
  public final long parseAndAdd()
  {
    return ((Long)table.equals()).longValue();
  }
}
