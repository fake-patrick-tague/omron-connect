package com.google.android.gms.internal.measurement;

public final class zzfn
  extends zzka
  implements zzlm
{
  private zzfn()
  {
    super(zzfo.access$getTitle());
  }
  
  public final zzfn descend(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfo.init((zzfo)this$0, paramInt);
    return this;
  }
  
  public final zzfn descend(zzgg paramZzgg)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfo.restart((zzfo)this$0, (zzgh)paramZzgg.zzaE());
    return this;
  }
  
  public final zzfn descend(zzgh paramZzgh)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfo.parseFeed((zzfo)this$0, paramZzgh);
    return this;
  }
  
  public final zzfn descend(boolean paramBoolean)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfo.restart((zzfo)this$0, paramBoolean);
    return this;
  }
}
