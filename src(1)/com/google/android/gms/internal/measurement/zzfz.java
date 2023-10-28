package com.google.android.gms.internal.measurement;

public final class zzfz
  extends zzka
  implements zzlm
{
  private zzfz()
  {
    super(zzga.getApplication());
  }
  
  public final zzgc getResource(int paramInt)
  {
    return ((zzga)this$0).getResource(0);
  }
  
  public final zzfz subtract(zzgb paramZzgb)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzga.initContext((zzga)this$0, (zzgc)paramZzgb.zzaE());
    return this;
  }
}
