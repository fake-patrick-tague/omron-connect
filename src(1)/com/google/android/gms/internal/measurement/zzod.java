package com.google.android.gms.internal.measurement;

public final class zzod
  implements zzoc
{
  public static final zzia GLOBAL = new zzhx(zzhp.create("com.google.android.gms.measurement")).create().get().create("measurement.audience.dynamic_filters.oob_fix", true);
  
  public zzod() {}
  
  public final boolean getOrElse()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
  
  public final boolean isManaged()
  {
    return true;
  }
}
