package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzgb
  extends zzka
  implements zzlm
{
  private zzgb()
  {
    super(zzgc.access$getThis$0());
  }
  
  public final zzgb add(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzam((zzgc)this$0, paramLong);
    return this;
  }
  
  public final zzgb add(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.resolve((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb addBlock()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaG((zzgc)this$0);
    return this;
  }
  
  public final zzgb addElement(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzac((zzgc)this$0, paramIterable);
    return this;
  }
  
  public final zzgb addElement(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaH((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb addMenuItem()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaQ((zzgc)this$0);
    return this;
  }
  
  public final zzgb addMenuItem(int paramInt, zzfr paramZzfr)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.add((zzgc)this$0, paramInt, (zzfs)paramZzfr.zzaE());
    return this;
  }
  
  public final zzgb append(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.put((zzgc)this$0, paramLong);
    return this;
  }
  
  public final zzgb append(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzai((zzgc)this$0, paramIterable);
    return this;
  }
  
  public final zzgb append(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzas((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb call(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    paramString = (zzgc)this$0;
    int i = zzgc.val$signal;
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final zzgb dec()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaq((zzgc)this$0);
    return this;
  }
  
  public final zzgb dec(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaK((zzgc)this$0, paramInt);
    return this;
  }
  
  public final zzgb descend()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzao((zzgc)this$0);
    return this;
  }
  
  public final zzgb descend(zzgl paramZzgl)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzah((zzgc)this$0, paramZzgl);
    return this;
  }
  
  public final zzgb descend(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.sortByValues((zzgc)this$0, paramIterable);
    return this;
  }
  
  public final zzgb descend(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaL((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb ensureInitialized()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaU((zzgc)this$0);
    return this;
  }
  
  public final zzgb get(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.put((zzgc)this$0, paramString);
    return this;
  }
  
  public final int getByName()
  {
    return ((zzgc)this$0).length();
  }
  
  public final zzgb getMedia()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaI((zzgc)this$0);
    return this;
  }
  
  public final int getQueueSize()
  {
    return ((zzgc)this$0).size();
  }
  
  public final zzfs getResource(int paramInt)
  {
    return ((zzgc)this$0).addPath(paramInt);
  }
  
  public final zzgb inc()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzat((zzgc)this$0);
    return this;
  }
  
  public final zzgb inc(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaf((zzgc)this$0, paramInt);
    return this;
  }
  
  public final zzgb indexOf(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaA((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb insert()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.inc((zzgc)this$0);
    return this;
  }
  
  public final long interpolate()
  {
    return ((zzgc)this$0).read();
  }
  
  public final zzgb linearCombination()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzad((zzgc)this$0);
    return this;
  }
  
  public final zzgb log(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzau((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb log1p()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaM((zzgc)this$0);
    return this;
  }
  
  public final zzgb multiply(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaV((zzgc)this$0, paramLong);
    return this;
  }
  
  public final zzgb put(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzae((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb remainder()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzav((zzgc)this$0);
    return this;
  }
  
  public final zzgb remove(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaB((zzgc)this$0, paramLong);
    return this;
  }
  
  public final zzgb remove(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaR((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb set(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaJ((zzgc)this$0, paramLong);
    return this;
  }
  
  public final zzgb set(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaN((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb shrink()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzab((zzgc)this$0);
    return this;
  }
  
  public final zzgb startsWith(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaz((zzgc)this$0, paramString);
    return this;
  }
  
  public final long string()
  {
    return ((zzgc)this$0).getIdentifier();
  }
  
  public final zzgb subtract(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaj((zzgc)this$0, paramInt);
    return this;
  }
  
  public final zzgb subtract(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.remove((zzgc)this$0, paramLong);
    return this;
  }
  
  public final zzgb subtract(zzfr paramZzfr)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.removeAll((zzgc)this$0, (zzfs)paramZzfr.zzaE());
    return this;
  }
  
  public final zzgb subtract(zzgk paramZzgk)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzah((zzgc)this$0, (zzgl)paramZzgk.zzaE());
    return this;
  }
  
  public final zzgb subtract(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.toFile((zzgc)this$0, paramIterable);
    return this;
  }
  
  public final zzgb subtract(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzar((zzgc)this$0, "android");
    return this;
  }
  
  public final zzgb subtract(boolean paramBoolean)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaF((zzgc)this$0, paramBoolean);
    return this;
  }
  
  public final zzgb transformBody()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaE((zzgc)this$0);
    return this;
  }
  
  public final zzgb truncate(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaS((zzgc)this$0, paramInt);
    return this;
  }
  
  public final zzgb truncate(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaP((zzgc)this$0, paramIterable);
    return this;
  }
  
  public final zzgb truncate(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzay((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb zzaa(zzgd paramZzgd)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.resolve((zzgc)this$0, (zzgf)paramZzgd.zzaE());
    return this;
  }
  
  public final zzgb zzab(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzap((zzgc)this$0, paramLong);
    return this;
  }
  
  public final zzgb zzac(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzan((zzgc)this$0, paramLong);
    return this;
  }
  
  public final zzgb zzad(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaT((zzgc)this$0, 1);
    return this;
  }
  
  public final zzgb zzae(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaD((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb zzaf(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.resolve((zzgc)this$0, paramInt);
    return this;
  }
  
  public final zzgb zzag(boolean paramBoolean)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaO((zzgc)this$0, paramBoolean);
    return this;
  }
  
  public final zzgb zzah(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaa((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgb zzai(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzal((zzgc)this$0, paramLong);
    return this;
  }
  
  public final zzgb zzaj(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzax((zzgc)this$0, paramInt);
    return this;
  }
  
  public final zzgb zzak(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzak((zzgc)this$0, paramLong);
    return this;
  }
  
  public final zzgb zzal(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaC((zzgc)this$0, 73000L);
    return this;
  }
  
  public final zzgb zzam(int paramInt, zzgl paramZzgl)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzag((zzgc)this$0, paramInt, paramZzgl);
    return this;
  }
  
  public final zzgb zzan(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgc.zzaw((zzgc)this$0, paramString);
    return this;
  }
  
  public final zzgl zzao(int paramInt)
  {
    return ((zzgc)this$0).addFile(paramInt);
  }
  
  public final String zzap()
  {
    return ((zzgc)this$0).getValue();
  }
  
  public final String zzaq()
  {
    return ((zzgc)this$0).readLine();
  }
  
  public final String zzar()
  {
    return ((zzgc)this$0).time();
  }
  
  public final List zzas()
  {
    return Collections.unmodifiableList(((zzgc)this$0).getGroups());
  }
  
  public final List zzat()
  {
    return Collections.unmodifiableList(((zzgc)this$0).getIds());
  }
}
