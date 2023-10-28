package com.google.android.gms.measurement.internal;

import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzaa
  extends zzkn
{
  private Long id;
  private Set keys;
  private Long pageSize;
  private String size;
  private Map values;
  
  zzaa(zzkz paramZzkz)
  {
    super(paramZzkz);
  }
  
  private final boolean add(int paramInt1, int paramInt2)
  {
    Range localRange = (Range)values.get(Integer.valueOf(paramInt1));
    if (localRange == null) {
      return false;
    }
    return Range.toString(localRange).get(paramInt2);
  }
  
  private final Range get(Integer paramInteger)
  {
    if (values.containsKey(paramInteger)) {
      return (Range)values.get(paramInteger);
    }
    Range localRange = new Range(this, size, null);
    values.put(paramInteger, localRange);
    return localRange;
  }
  
  final List load(String paramString, List paramList1, List paramList2, Long paramLong1, Long paramLong2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a342 = a341\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  protected final boolean registerAlarm()
  {
    return false;
  }
}
