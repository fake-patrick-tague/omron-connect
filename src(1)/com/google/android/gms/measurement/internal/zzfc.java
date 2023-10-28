package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfc
{
  private final String columnKey;
  private boolean mLoaded;
  private String value;
  
  public zzfc(zzfd paramZzfd, String paramString1, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    columnKey = paramString1;
  }
  
  public final String getValue()
  {
    if (!mLoaded)
    {
      mLoaded = true;
      value = this$0.get().getString(columnKey, null);
    }
    return value;
  }
  
  public final void put(String paramString)
  {
    SharedPreferences.Editor localEditor = this$0.get().edit();
    localEditor.putString(columnKey, paramString);
    localEditor.apply();
    value = paramString;
  }
}
