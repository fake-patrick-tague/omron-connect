package com.google.android.gms.internal.measurement;

final class zzbe
  implements zzbf
{
  private final String key;
  private final Headers this$0;
  
  public zzbe(Headers paramHeaders, String paramString)
  {
    this$0 = paramHeaders;
    key = paramString;
  }
  
  public final Headers get(zzap paramZzap)
  {
    Headers localHeaders = this$0.get();
    localHeaders.add(key, paramZzap);
    return localHeaders;
  }
}
