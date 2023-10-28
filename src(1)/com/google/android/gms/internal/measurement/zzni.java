package com.google.android.gms.internal.measurement;

public final class zzni
  implements zznh
{
  public static final zzia GLOBAL = new zzhx(zzhp.create("com.google.android.gms.measurement")).get().create("measurement.client.click_identifier_control.dev", false);
  
  public zzni() {}
  
  public final boolean getOrElse()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
}
