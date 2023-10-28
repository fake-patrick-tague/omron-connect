package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
public class Logger
{
  private final int level;
  private final GmsLogger logger;
  private final String name;
  private final String tag;
  
  public Logger(String paramString, String... paramVarArgs)
  {
    name = paramVarArgs;
    tag = paramString;
    logger = new GmsLogger(paramString);
    int i = 2;
    while ((i <= 7) && (!Log.isLoggable(tag, i))) {
      i += 1;
    }
    level = i;
  }
  
  public void error(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    Log.e(tag, format(paramString, paramVarArgs), paramThrowable);
  }
  
  public void error(String paramString, Object... paramVarArgs)
  {
    Log.e(tag, format(paramString, paramVarArgs));
  }
  
  protected String format(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length > 0) {
        str = String.format(Locale.US, paramString, paramVarArgs);
      }
    }
    return name.concat(str);
  }
  
  public String getTag()
  {
    return tag;
  }
  
  public void info(String paramString, Object... paramVarArgs)
  {
    Log.i(tag, format(paramString, paramVarArgs));
  }
  
  public boolean isLoggable(int paramInt)
  {
    return level <= paramInt;
  }
  
  public void log(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    Log.wtf(tag, format(paramString, paramVarArgs), paramThrowable);
  }
  
  public void log(String paramString, Object... paramVarArgs)
  {
    if (isLoggable(3)) {
      Log.d(tag, format(paramString, paramVarArgs));
    }
  }
  
  public void log(Throwable paramThrowable)
  {
    Log.wtf(tag, paramThrowable);
  }
  
  public void trace(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (isLoggable(2)) {
      Log.v(tag, format(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public void trace(String paramString, Object... paramVarArgs)
  {
    if (isLoggable(2)) {
      Log.v(tag, format(paramString, paramVarArgs));
    }
  }
  
  public void w(String paramString, Object... paramVarArgs)
  {
    Log.w(tag, format(paramString, paramVarArgs));
  }
}
