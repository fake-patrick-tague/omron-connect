package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class SharedPreferencesUtils
{
  private SharedPreferencesUtils() {}
  
  public static void publishWorldReadableSharedPreferences(Context paramContext, SharedPreferences.Editor paramEditor, String paramString)
  {
    throw new IllegalStateException("world-readable shared preferences should only be used by apk");
  }
}
