package com.google.android.gms.internal.measurement;

final class zzbd
  implements zzbf
{
  private final String cursor;
  private final Headers this$0;
  
  public zzbd(Headers paramHeaders, String paramString)
  {
    this$0 = paramHeaders;
    cursor = paramString;
  }
  
  public final Headers get(zzap paramZzap)
  {
    Headers localHeaders = this$0.get();
    localHeaders.put(cursor, paramZzap);
    return localHeaders;
  }
}
