package com.google.android.gms.internal.measurement;

public final class zzgg
  extends zzka
  implements zzlm
{
  private zzgg()
  {
    super(zzgh.access$getTAG());
  }
  
  public final zzgg append(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgh.rewrite((zzgh)this$0, paramInt);
    return this;
  }
  
  public final zzgg append(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgh.createCopy((zzgh)this$0, paramIterable);
    return this;
  }
  
  public final zzgg clear()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgh.items((zzgh)this$0);
    return this;
  }
  
  public final zzgg descend()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgh.parseData((zzgh)this$0);
    return this;
  }
  
  public final zzgg get(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgh.getFiles((zzgh)this$0, paramInt);
    return this;
  }
  
  public final zzgg linearCombination()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgh.setBuffer((zzgh)this$0);
    return this;
  }
  
  public final zzgg put(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgh.trim((zzgh)this$0, paramIterable);
    return this;
  }
  
  public final zzgg replace(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgh.rewrite((zzgh)this$0, paramIterable);
    return this;
  }
  
  public final zzgg subtract()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgh.setEntry((zzgh)this$0);
    return this;
  }
  
  public final zzgg toString(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgh.normalize((zzgh)this$0, paramIterable);
    return this;
  }
}
