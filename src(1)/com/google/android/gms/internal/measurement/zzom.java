package com.google.android.gms.internal.measurement;

public final class zzom
  implements zzol
{
  public static final zzia CASE_INSENSITIVE;
  public static final zzia GLOBAL;
  public static final zzia LOCAL;
  public static final zzia TRANSACTION;
  
  static
  {
    zzhx localZzhx = new zzhx(zzhp.create("com.google.android.gms.measurement")).get();
    TRANSACTION = localZzhx.create("measurement.sdk.collection.enable_extend_user_property_size", true);
    LOCAL = localZzhx.create("measurement.sdk.collection.last_deep_link_referrer2", true);
    GLOBAL = localZzhx.create("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
    CASE_INSENSITIVE = localZzhx.valueOf("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
  }
  
  public zzom() {}
  
  public final boolean getOrElse()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
}
