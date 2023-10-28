package com.google.android.gms.internal.measurement;

public final class zzph
  implements zzpg
{
  public static final zzia GLOBAL = new zzhx(zzhp.create("com.google.android.gms.measurement")).get().create("measurement.integration.disable_firebase_instance_id", false);
  
  public zzph() {}
  
  public final boolean canZoomIn()
  {
    return true;
  }
  
  public final boolean getOrElse()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
}
