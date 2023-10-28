package com.google.android.gms.internal.measurement;

final class zzbg
  implements zzbf
{
  private final String hash;
  private final Headers this$0;
  
  public zzbg(Headers paramHeaders, String paramString)
  {
    this$0 = paramHeaders;
    hash = paramString;
  }
  
  public final Headers get(zzap paramZzap)
  {
    this$0.add(hash, paramZzap);
    return this$0;
  }
}
