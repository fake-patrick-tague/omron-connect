package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.StrictMode;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import v7.util.ArrayMap;

public final class zzib
  implements zzhj
{
  private static final Map nodes = new ArrayMap();
  private final SharedPreferences data;
  private final SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;
  
  static zzib init(Context paramContext, String paramString, Runnable paramRunnable)
  {
    if (!zzha.hasExternalCacheDir()) {
      try
      {
        paramContext = (zzib)nodes.get(null);
        if (paramContext != null) {
          return paramContext;
        }
        paramContext = StrictMode.allowThreadDiskReads();
        try
        {
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
        catch (Throwable paramString)
        {
          StrictMode.setThreadPolicy(paramContext);
          throw paramString;
        }
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
  }
  
  static void init()
  {
    try
    {
      Object localObject = nodes;
      Iterator localIterator = ((Map)localObject).values().iterator();
      if (!localIterator.hasNext())
      {
        ((Map)localObject).clear();
        return;
      }
      localObject = nextdata;
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Object get(String paramString)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
}
