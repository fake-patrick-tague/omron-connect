package com.google.android.gms.internal.measurement;

public final class zzgi
  extends zzka
  implements zzlm
{
  private zzgi()
  {
    super(zzgj.getSecond());
  }
  
  public final zzgi descend(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgj.subtract((zzgj)this$0, paramIterable);
    return this;
  }
  
  public final zzgi position(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgj.fetchItems((zzgj)this$0, paramInt);
    return this;
  }
}
