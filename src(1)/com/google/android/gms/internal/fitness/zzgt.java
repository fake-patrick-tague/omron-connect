package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class zzgt<T extends zzgv<T>>
{
  private static final zzgt zzve = new zzgt(true);
  final zzjb<T, Object> zzvb;
  private boolean zzvc;
  private boolean zzvd;
  
  private zzgt()
  {
    zzvb = zzjb.zzak(16);
  }
  
  private zzgt(zzjb paramZzjb)
  {
    zzvb = paramZzjb;
    zzar();
  }
  
  private zzgt(boolean paramBoolean)
  {
    this(zzjb.zzak(0));
    zzar();
  }
  
  private final void addContribution(Map.Entry paramEntry)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a11 = a10\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private final Object descend(zzgv paramZzgv)
  {
    paramZzgv = zzvb.get(paramZzgv);
    if ((paramZzgv instanceof zzhl))
    {
      paramZzgv = (zzhl)paramZzgv;
      return zzhl.zzce();
    }
    return paramZzgv;
  }
  
  private static Object get(Object paramObject)
  {
    if ((paramObject instanceof zziq)) {
      return ((zziq)paramObject).zzao();
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      byte[] arrayOfByte = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, arrayOfByte, 0, paramObject.length);
      return arrayOfByte;
    }
    return paramObject;
  }
  
  private static int getParameterValue(Map.Entry paramEntry)
  {
    zzgv localZzgv = (zzgv)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localZzgv.zzbm() == zzkj.zzady) && (!localZzgv.zzbn()) && (!localZzgv.zzbo()))
    {
      if ((localObject instanceof zzhl)) {
        return zzgk.get(((zzgv)paramEntry.getKey()).get(), (zzhl)localObject);
      }
      return zzgk.getValue(((zzgv)paramEntry.getKey()).get(), (zzik)localObject);
    }
    return write(localZzgv, localObject);
  }
  
  private static int getValue(zzkg paramZzkg, Object paramObject)
  {
    switch (zzgs.zzva[paramZzkg.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      if ((paramObject instanceof zzhb)) {
        return zzgk.get(((zzhb)paramObject).nextString());
      }
      return zzgk.get(((Integer)paramObject).intValue());
    case 17: 
      return zzgk.valueOf(((Long)paramObject).longValue());
    case 16: 
      return zzgk.getInt(((Integer)paramObject).intValue());
    case 15: 
      return zzgk.next(((Long)paramObject).longValue());
    case 14: 
      return zzgk.convert(((Integer)paramObject).intValue());
    case 13: 
      return zzgk.append(((Integer)paramObject).intValue());
    case 12: 
      if ((paramObject instanceof zzfx)) {
        return zzgk.get((zzfx)paramObject);
      }
      return zzgk.get((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof zzfx)) {
        return zzgk.get((zzfx)paramObject);
      }
      return zzgk.getValue((String)paramObject);
    case 10: 
      if ((paramObject instanceof zzhl)) {
        return zzgk.getX((zzhl)paramObject);
      }
      return zzgk.getRawValue((zzik)paramObject);
    case 9: 
      return zzgk.subtract((zzik)paramObject);
    case 8: 
      return zzgk.value(((Boolean)paramObject).booleanValue());
    case 7: 
      return zzgk.round(((Integer)paramObject).intValue());
    case 6: 
      return zzgk.evaluate(((Long)paramObject).longValue());
    case 5: 
      return zzgk.valueOf(((Integer)paramObject).intValue());
    case 4: 
      return zzgk.toString(((Long)paramObject).longValue());
    case 3: 
      return zzgk.get(((Long)paramObject).longValue());
    case 2: 
      return zzgk.round(((Float)paramObject).floatValue());
    }
    return zzgk.invoke(((Double)paramObject).doubleValue());
  }
  
  private static boolean isInitialized(Map.Entry paramEntry)
  {
    zzgv localZzgv = (zzgv)paramEntry.getKey();
    if (localZzgv.zzbm() == zzkj.zzady)
    {
      if (localZzgv.zzbn())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((zzik)paramEntry.next()).isInitialized());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof zzik))
      {
        if (!((zzik)paramEntry).isInitialized()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof zzhl)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  private final void setField(zzgv paramZzgv, Object paramObject)
  {
    if (paramZzgv.zzbn())
    {
      if ((paramObject instanceof List))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((List)paramObject);
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          paramObject = localArrayList.get(i);
          i += 1;
          setField(paramZzgv.zzbl(), paramObject);
        }
        paramObject = localArrayList;
      }
      else
      {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    else {
      setField(paramZzgv.zzbl(), paramObject);
    }
    if ((paramObject instanceof zzhl)) {
      zzvd = true;
    }
    zzvb.put(paramZzgv, paramObject);
  }
  
  private static void setField(zzkg paramZzkg, Object paramObject)
  {
    zzhc.checkNotNull(paramObject);
    int i = zzgs.zzuz[paramZzkg.zzdx().ordinal()];
    boolean bool2 = true;
    switch (i)
    {
    default: 
      break;
    case 9: 
    case 8: 
    case 7: 
      do
      {
        do
        {
          do
          {
            bool1 = false;
            break;
            bool1 = bool2;
            if ((paramObject instanceof zzik)) {
              break;
            }
          } while (!(paramObject instanceof zzhl));
          bool1 = bool2;
          break;
          bool1 = bool2;
          if ((paramObject instanceof Integer)) {
            break;
          }
        } while (!(paramObject instanceof zzhb));
        bool1 = bool2;
        break;
        bool1 = bool2;
        if ((paramObject instanceof zzfx)) {
          break;
        }
      } while (!(paramObject instanceof byte[]));
      bool1 = bool2;
      break;
    case 6: 
      bool1 = paramObject instanceof String;
      break;
    case 5: 
      bool1 = paramObject instanceof Boolean;
      break;
    case 4: 
      bool1 = paramObject instanceof Double;
      break;
    case 3: 
      bool1 = paramObject instanceof Float;
      break;
    case 2: 
      bool1 = paramObject instanceof Long;
      break;
    }
    boolean bool1 = paramObject instanceof Integer;
    if (bool1) {
      return;
    }
    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
  }
  
  public static int write(zzgv paramZzgv, Object paramObject)
  {
    zzkg localZzkg = paramZzgv.zzbl();
    int k = paramZzgv.get();
    if (paramZzgv.zzbn())
    {
      boolean bool = paramZzgv.zzbo();
      int j = 0;
      int i = 0;
      if (bool)
      {
        paramZzgv = ((List)paramObject).iterator();
        while (paramZzgv.hasNext()) {
          i += getValue(localZzkg, paramZzgv.next());
        }
        return zzgk.format(k) + i + zzgk.value(i);
      }
      paramZzgv = ((List)paramObject).iterator();
      i = j;
      while (paramZzgv.hasNext()) {
        i += write(localZzkg, k, paramZzgv.next());
      }
      return i;
    }
    return write(localZzkg, k, paramObject);
  }
  
  static int write(zzkg paramZzkg, int paramInt, Object paramObject)
  {
    int i = zzgk.format(paramInt);
    paramInt = i;
    if (paramZzkg == zzkg.zzade)
    {
      zzhc.writeValue((zzik)paramObject);
      paramInt = i << 1;
    }
    return paramInt + getValue(paramZzkg, paramObject);
  }
  
  static void write(zzgk paramZzgk, zzkg paramZzkg, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramZzkg == zzkg.zzade)
    {
      paramZzkg = (zzik)paramObject;
      zzhc.writeValue(paramZzkg);
      paramZzgk.writeTag(paramInt, 3);
      paramZzkg.f(paramZzgk);
      paramZzgk.writeTag(paramInt, 4);
      return;
    }
    paramZzgk.writeTag(paramInt, paramZzkg.zzdy());
    switch (zzgs.zzva[paramZzkg.ordinal()])
    {
    default: 
      return;
    case 18: 
      if ((paramObject instanceof zzhb))
      {
        paramZzgk.put(((zzhb)paramObject).nextString());
        return;
      }
      paramZzgk.put(((Integer)paramObject).intValue());
      return;
    case 17: 
      paramZzgk.getHeader(((Long)paramObject).longValue());
      return;
    case 16: 
      paramZzgk.getSession(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramZzgk.add(((Long)paramObject).longValue());
      return;
    case 14: 
      paramZzgk.write(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramZzgk.add(((Integer)paramObject).intValue());
      return;
    case 12: 
      if ((paramObject instanceof zzfx))
      {
        paramZzgk.flush((zzfx)paramObject);
        return;
      }
      paramZzkg = (byte[])paramObject;
      paramZzgk.writeTag(paramZzkg, 0, paramZzkg.length);
      return;
    case 11: 
      if ((paramObject instanceof zzfx))
      {
        paramZzgk.flush((zzfx)paramObject);
        return;
      }
      paramZzgk.write((String)paramObject);
      return;
    case 10: 
      paramZzgk.writeText((zzik)paramObject);
      return;
    case 9: 
      ((zzik)paramObject).f(paramZzgk);
      return;
    case 8: 
      paramZzgk.decode(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramZzgk.write(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramZzgk.add(((Long)paramObject).longValue());
      return;
    case 5: 
      paramZzgk.put(((Integer)paramObject).intValue());
      return;
    case 4: 
      paramZzgk.read(((Long)paramObject).longValue());
      return;
    case 3: 
      paramZzgk.read(((Long)paramObject).longValue());
      return;
    case 2: 
      paramZzgk.a(((Float)paramObject).floatValue());
      return;
    }
    paramZzgk.a(((Double)paramObject).doubleValue());
  }
  
  public static zzgt zzbj()
  {
    return zzve;
  }
  
  final Iterator descendingIterator()
  {
    if (zzvd) {
      return new zzhq(zzvb.zzde().iterator());
    }
    return zzvb.zzde().iterator();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzgt)) {
      return false;
    }
    paramObject = (zzgt)paramObject;
    return zzvb.equals(zzvb);
  }
  
  public final void getInstalledApps(zzgt paramZzgt)
  {
    int i = 0;
    while (i < zzvb.zzdc())
    {
      addContribution(zzvb.zzal(i));
      i += 1;
    }
    paramZzgt = zzvb.zzdd().iterator();
    while (paramZzgt.hasNext()) {
      addContribution((Map.Entry)paramZzgt.next());
    }
  }
  
  public final int hashCode()
  {
    return zzvb.hashCode();
  }
  
  public final boolean isImmutable()
  {
    return zzvc;
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < zzvb.zzdc())
    {
      if (!isInitialized(zzvb.zzal(i))) {
        return false;
      }
      i += 1;
    }
    Iterator localIterator = zzvb.zzdd().iterator();
    while (localIterator.hasNext()) {
      if (!isInitialized((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final Iterator iterator()
  {
    if (zzvd) {
      return new zzhq(zzvb.entrySet().iterator());
    }
    return zzvb.entrySet().iterator();
  }
  
  public final void zzar()
  {
    if (zzvc) {
      return;
    }
    zzvb.zzar();
    zzvc = true;
  }
  
  public final int zzbk()
  {
    int j = 0;
    int i = 0;
    while (j < zzvb.zzdc())
    {
      i += getParameterValue(zzvb.zzal(j));
      j += 1;
    }
    Iterator localIterator = zzvb.zzdd().iterator();
    while (localIterator.hasNext()) {
      i += getParameterValue((Map.Entry)localIterator.next());
    }
    return i;
  }
}
