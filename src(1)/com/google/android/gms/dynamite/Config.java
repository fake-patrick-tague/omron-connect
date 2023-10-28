package com.google.android.gms.dynamite;

import android.util.Log;

public final class Config
{
  private static volatile ClassLoader data;
  private static volatile Thread value;
  
  private static ClassLoader get()
  {
    try
    {
      Object localObject2 = value;
      Object localObject1 = null;
      if (localObject2 == null)
      {
        value = init();
        localObject2 = value;
        if (localObject2 == null) {
          return null;
        }
      }
      localThread = value;
      localObject2 = value;
      try
      {
        localObject2 = ((Thread)localObject2).getContextClassLoader();
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable1)
      {
        break label103;
      }
      catch (SecurityException localSecurityException)
      {
        String str = localSecurityException.getMessage();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to get thread context classloader ");
        localStringBuilder.append(str);
        Log.w("DynamiteLoaderV2CL", localStringBuilder.toString());
      }
      return localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      Thread localThread;
      label103:
      throw localThrowable2;
    }
    throw localThrowable1;
  }
  
  private static Thread init()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a10 = a9\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static ClassLoader load()
  {
    try
    {
      if (data == null) {
        data = get();
      }
      ClassLoader localClassLoader = data;
      return localClassLoader;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
