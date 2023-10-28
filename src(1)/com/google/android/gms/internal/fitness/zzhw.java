package com.google.android.gms.internal.fitness;

import java.util.Collections;
import java.util.List;

final class zzhw
  extends zzhu
{
  private static final Class<?> zzzn = Collections.unmodifiableList(Collections.emptyList()).getClass();
  
  private zzhw()
  {
    super(null);
  }
  
  private static List get(Object paramObject, long paramLong)
  {
    return (List)zzjy.getName(paramObject, paramLong);
  }
  
  final void setObjectClass(Object paramObject, long paramLong)
  {
    Object localObject = (List)zzjy.getName(paramObject, paramLong);
    if ((localObject instanceof zzhr))
    {
      localObject = ((zzhr)localObject).zzci();
    }
    else
    {
      if (zzzn.isAssignableFrom(localObject.getClass())) {
        return;
      }
      if (((localObject instanceof zzit)) && ((localObject instanceof zzhh)))
      {
        paramObject = (zzhh)localObject;
        if (!paramObject.zzaq()) {
          return;
        }
        paramObject.zzar();
        return;
      }
      localObject = Collections.unmodifiableList((List)localObject);
    }
    zzjy.append(paramObject, paramLong, localObject);
  }
  
  final void showImage(Object paramObject1, Object paramObject2, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a10 = a9\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
}
