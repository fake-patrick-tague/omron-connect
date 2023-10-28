package com.google.android.gms.internal.measurement;

public final class zznl
  implements zznk
{
  public static final zzia GLOBAL = new zzhx(zzhp.create("com.google.android.gms.measurement")).get().create("measurement.service.click_identifier_control", false);
  
  public zznl() {}
  
  public final boolean getOrElse()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
}
