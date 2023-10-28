package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final class zzep
{
  public final Bundle data;
  public final String filename;
  public final String length;
  public final long pos;
  
  public zzep(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    length = paramString1;
    filename = paramString2;
    data = paramBundle;
    pos = paramLong;
  }
  
  public static zzep newInstance(zzaw paramZzaw)
  {
    return new zzep(type, name, this$0.get(), size);
  }
  
  public final zzaw parse()
  {
    return new zzaw(length, new zzau(new Bundle(data)), filename, pos);
  }
  
  public final String toString()
  {
    String str1 = filename;
    String str2 = length;
    String str3 = data.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("origin=");
    localStringBuilder.append(str1);
    localStringBuilder.append(",name=");
    localStringBuilder.append(str2);
    localStringBuilder.append(",params=");
    localStringBuilder.append(str3);
    return localStringBuilder.toString();
  }
}
