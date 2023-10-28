package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class GmsLogger
{
  private final String className;
  private final String name;
  
  public GmsLogger(String paramString)
  {
    this(paramString, null);
  }
  
  public GmsLogger(String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramString1, "log tag cannot be null");
    boolean bool;
    if (paramString1.length() <= 23) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
    className = paramString1;
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      name = paramString2;
      return;
    }
    name = null;
  }
  
  private final String buildMessage(String paramString, Object... paramVarArgs)
  {
    paramString = String.format(paramString, paramVarArgs);
    paramVarArgs = name;
    if (paramVarArgs == null) {
      return paramString;
    }
    return paramVarArgs.concat(paramString);
  }
  
  private final String toString(String paramString)
  {
    String str = name;
    if (str == null) {
      return paramString;
    }
    return str.concat(paramString);
  }
  
  public void append(String paramString1, String paramString2)
  {
    if (canLog(2)) {
      Log.v(paramString1, toString(paramString2));
    }
  }
  
  public boolean canLog(int paramInt)
  {
    return Log.isLoggable(className, paramInt);
  }
  
  public boolean canLogPii()
  {
    return false;
  }
  
  public void checkedWtf(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void d(String paramString1, String paramString2)
  {
    if (canLog(3)) {
      Log.d(paramString1, toString(paramString2));
    }
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(3)) {
      Log.d(paramString1, toString(paramString2), paramThrowable);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    if (canLog(6)) {
      Log.e(paramString1, toString(paramString2));
    }
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(6)) {
      Log.e(paramString1, toString(paramString2), paramThrowable);
    }
  }
  
  public void efmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (canLog(6)) {
      Log.e(paramString1, buildMessage(paramString2, paramVarArgs));
    }
  }
  
  public void i(String paramString1, String paramString2)
  {
    if (canLog(4)) {
      Log.i(paramString1, toString(paramString2));
    }
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(4)) {
      Log.i(paramString1, toString(paramString2), paramThrowable);
    }
  }
  
  public void releaseImage(String paramString1, String paramString2) {}
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(2)) {
      Log.v(paramString1, toString(paramString2), paramThrowable);
    }
  }
  
  public void w(String paramString1, String paramString2)
  {
    if (canLog(5)) {
      Log.w(paramString1, toString(paramString2));
    }
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(5)) {
      Log.w(paramString1, toString(paramString2), paramThrowable);
    }
  }
  
  public void wfmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (canLog(5)) {
      Log.w(className, buildMessage(paramString2, paramVarArgs));
    }
  }
  
  public void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(7))
    {
      Log.e(paramString1, toString(paramString2), paramThrowable);
      Log.wtf(paramString1, toString(paramString2), paramThrowable);
    }
  }
}
