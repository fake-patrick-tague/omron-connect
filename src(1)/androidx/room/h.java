package androidx.room;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class h
{
  final int[] a;
  final d b;
  private final String[] c;
  private final Set<String> s;
  
  h(d paramD, int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    b = paramD;
    a = paramArrayOfInt;
    c = paramArrayOfString;
    if (paramArrayOfInt.length == 1)
    {
      paramD = new HashSet();
      paramD.add(paramArrayOfString[0]);
      s = Collections.unmodifiableSet(paramD);
      return;
    }
    s = null;
  }
  
  void a(Set paramSet)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a14 = a13\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  void a(String[] paramArrayOfString)
  {
    Object localObject1 = c;
    h localH = this;
    int i = localObject1.length;
    Object localObject3 = null;
    int j;
    if (i == 1)
    {
      j = paramArrayOfString.length;
      i = 0;
      for (;;)
      {
        localObject1 = localObject3;
        localObject2 = localH;
        if (i >= j) {
          break;
        }
        localObject1 = paramArrayOfString[i];
        localObject2 = c;
        if (((String)localObject1).equalsIgnoreCase(localObject2[0]))
        {
          localObject1 = s;
          localObject2 = localH;
          break;
        }
        i += 1;
      }
    }
    HashSet localHashSet = new HashSet();
    int k = paramArrayOfString.length;
    i = 0;
    while (i < k)
    {
      localObject1 = paramArrayOfString[i];
      localObject2 = c;
      int m = localObject2.length;
      j = 0;
      while (j < m)
      {
        Object localObject4 = localObject2[j];
        if (localObject4.equalsIgnoreCase((String)localObject1))
        {
          localHashSet.add(localObject4);
          break;
        }
        j += 1;
      }
      i += 1;
    }
    localObject1 = localObject3;
    Object localObject2 = localH;
    if (localHashSet.size() > 0)
    {
      localObject1 = localHashSet;
      localObject2 = localH;
    }
    if (localObject1 != null) {
      b.a((Set)localObject1);
    }
  }
}
