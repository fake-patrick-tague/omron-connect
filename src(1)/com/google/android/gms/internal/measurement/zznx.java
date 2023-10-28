package com.google.android.gms.internal.measurement;

public final class zznx
  implements zznw
{
  public static final zzia GLOBAL = new zzhx(zzhp.create("com.google.android.gms.measurement")).get().create("measurement.client.firebase_feature_rollout.v1.enable", true);
  
  public zznx() {}
  
  public final boolean getOrElse()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
  
  public final boolean play_next()
  {
    return true;
  }
}
