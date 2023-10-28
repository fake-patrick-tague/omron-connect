package com.google.android.gms.internal.measurement;

public final class zzpb
  implements zzpa
{
  public static final zzia GLOBAL;
  public static final zzia LOCAL;
  
  static
  {
    zzhx localZzhx = new zzhx(zzhp.create("com.google.android.gms.measurement")).create().get();
    LOCAL = localZzhx.create("measurement.collection.enable_session_stitching_token.client.dev", false);
    GLOBAL = localZzhx.create("measurement.collection.enable_session_stitching_token.service", false);
  }
  
  public zzpb() {}
  
  public final boolean fetchData()
  {
    return ((Boolean)LOCAL.equals()).booleanValue();
  }
  
  public final boolean getOrElse()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
  
  public final boolean isStandAlone()
  {
    return true;
  }
}
