package com.google.android.gms.measurement.internal;

public enum zzah
{
  public static final zzah[] text;
  public final String key;
  
  static
  {
    zzah localZzah1 = new zzah("AD_STORAGE", 0, "ad_storage");
    count = localZzah1;
    zzah localZzah2 = new zzah("ANALYTICS_STORAGE", 1, "analytics_storage");
    name = localZzah2;
    values = new zzah[] { localZzah1, localZzah2 };
    text = new zzah[] { localZzah1, localZzah2 };
  }
  
  private zzah(String paramString)
  {
    key = paramString;
  }
}
