package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzat
  implements Iterable, zzap
{
  private final String name;
  
  public zzat(String paramString)
  {
    if (paramString != null)
    {
      name = paramString;
      return;
    }
    throw new IllegalArgumentException("StringValue cannot be null.");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzat)) {
      return false;
    }
    paramObject = (zzat)paramObject;
    return name.equals(name);
  }
  
  public final Double get()
  {
    if (name.isEmpty()) {
      return Double.valueOf(0.0D);
    }
    Object localObject = name;
    try
    {
      localObject = Double.valueOf((String)localObject);
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    return Double.valueOf(NaN.0D);
  }
  
  public final String getValue()
  {
    return name;
  }
  
  public final int hashCode()
  {
    return name.hashCode();
  }
  
  public final Iterator iterator()
  {
    return new zzas(this);
  }
  
  public final zzap multiply()
  {
    return new zzat(name);
  }
  
  public final String toString()
  {
    String str = name;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\"");
    localStringBuilder.append(str);
    localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }
  
  public final Iterator toXml()
  {
    return new zzar(this);
  }
  
  public final Boolean value()
  {
    return Boolean.valueOf(name.isEmpty() ^ true);
  }
  
  public final zzap zzbN(String paramString, Headers paramHeaders, List paramList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
}
