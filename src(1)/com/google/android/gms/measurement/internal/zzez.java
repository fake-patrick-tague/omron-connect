package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

public final class zzez
{
  private final long index;
  private final String key;
  private long size;
  private boolean value;
  
  public zzez(zzfd paramZzfd, String paramString, long paramLong)
  {
    Preconditions.checkNotEmpty(paramString);
    key = paramString;
    index = paramLong;
  }
  
  public final long get()
  {
    if (!value)
    {
      value = true;
      size = next.get().getLong(key, index);
    }
    return size;
  }
  
  public final void put(long paramLong)
  {
    SharedPreferences.Editor localEditor = next.get().edit();
    localEditor.putLong(key, paramLong);
    localEditor.apply();
    size = paramLong;
  }
}
