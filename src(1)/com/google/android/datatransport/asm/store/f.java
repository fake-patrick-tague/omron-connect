package com.google.android.datatransport.asm.store;

import android.os.Build.VERSION;
import android.util.Log;

public final class f
{
  private static String a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return b("TRuntime.", paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TRuntime.");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject)
  {
    paramString1 = a(paramString1);
    if (Log.isLoggable(paramString1, 5)) {
      Log.w(paramString1, String.format(paramString2, new Object[] { paramObject }));
    }
  }
  
  public static void add(String paramString1, String paramString2, Object paramObject)
  {
    paramString1 = a(paramString1);
    if (Log.isLoggable(paramString1, 4)) {
      Log.i(paramString1, String.format(paramString2, new Object[] { paramObject }));
    }
  }
  
  private static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    paramString1 = paramString2;
    if (paramString2.length() > 23) {
      paramString1 = paramString2.substring(0, 23);
    }
    return paramString1;
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject)
  {
    paramString1 = a(paramString1);
    if (Log.isLoggable(paramString1, 3)) {
      Log.d(paramString1, String.format(paramString2, new Object[] { paramObject }));
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    paramString1 = a(paramString1);
    if (Log.isLoggable(paramString1, 3)) {
      Log.d(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    paramString1 = a(paramString1);
    if (Log.isLoggable(paramString1, 6)) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
}
