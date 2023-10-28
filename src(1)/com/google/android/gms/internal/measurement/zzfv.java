package com.google.android.gms.internal.measurement;

public final class zzfv
  extends zzka
  implements zzlm
{
  private zzfv()
  {
    super(zzfw.getCondition());
  }
  
  public final zzfv add(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfw.increment((zzfw)this$0, paramLong);
    return this;
  }
  
  public final zzfv descend()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfw.clear((zzfw)this$0);
    return this;
  }
  
  public final zzfv descend(zzfv paramZzfv)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfw.write((zzfw)this$0, (zzfw)paramZzfv.zzaE());
    return this;
  }
  
  public final zzfv descend(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfw.writeDefaultNamespace((zzfw)this$0, paramIterable);
    return this;
  }
  
  public final zzfv get(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfw.getInstance((zzfw)this$0, paramString);
    return this;
  }
  
  public final zzfv getLabel(double paramDouble)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfw.apply((zzfw)this$0, paramDouble);
    return this;
  }
  
  public final int getNumberOfColumns()
  {
    return ((zzfw)this$0).size();
  }
  
  public final zzfv inc()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfw.deleteDocument((zzfw)this$0);
    return this;
  }
  
  public final zzfv linearCombination()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfw.multiply((zzfw)this$0);
    return this;
  }
  
  public final zzfv parseHeader()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfw.readHeader((zzfw)this$0);
    return this;
  }
  
  public final zzfv setValue(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfw.assign((zzfw)this$0, paramString);
    return this;
  }
}
