package com.google.android.gms.internal.measurement;

public final class zznu
  implements zznt
{
  public static final zzia GLOBAL;
  public static final zzia LOCAL;
  public static final zzia TRANSACTION;
  
  static
  {
    zzhx localZzhx = new zzhx(zzhp.create("com.google.android.gms.measurement")).create().get();
    TRANSACTION = localZzhx.create("measurement.collection.event_safelist", true);
    LOCAL = localZzhx.create("measurement.service.store_null_safelist", true);
    GLOBAL = localZzhx.create("measurement.service.store_safelist", true);
  }
  
  public zznu() {}
  
  public final boolean booleanValue()
  {
    return ((Boolean)LOCAL.equals()).booleanValue();
  }
  
  public final boolean getOrElse()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
  
  public final boolean isEmpty()
  {
    return true;
  }
}
