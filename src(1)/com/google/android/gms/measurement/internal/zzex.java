package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

public final class zzex
{
  private final boolean active;
  private boolean completed;
  private final String name;
  private boolean result;
  
  public zzex(zzfd paramZzfd, String paramString, boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString);
    name = paramString;
    active = paramBoolean;
  }
  
  public final boolean get()
  {
    if (!completed)
    {
      completed = true;
      result = list.get().getBoolean(name, active);
    }
    return result;
  }
  
  public final void put(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = list.get().edit();
    localEditor.putBoolean(name, paramBoolean);
    localEditor.apply();
    result = paramBoolean;
  }
}
