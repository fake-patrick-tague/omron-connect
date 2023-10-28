package com.google.android.gms.internal.measurement;

public final class zzfp
  extends zzka
  implements zzlm
{
  private zzfp()
  {
    super(zzfq.getSecond());
  }
  
  public final zzfp position(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfq.setPosition((zzfq)this$0, paramInt);
    return this;
  }
  
  public final zzfp remainder(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfq.multiply((zzfq)this$0, paramLong);
    return this;
  }
}
