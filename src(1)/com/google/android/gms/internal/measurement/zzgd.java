package com.google.android.gms.internal.measurement;

public final class zzgd
  extends zzka
  implements zzlm
{
  private zzgd()
  {
    super(zzgf.log1p());
  }
  
  public final zzgd descend(zzft paramZzft)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgf.writeValue((zzgf)this$0, (zzfu)paramZzft.zzaE());
    return this;
  }
}
