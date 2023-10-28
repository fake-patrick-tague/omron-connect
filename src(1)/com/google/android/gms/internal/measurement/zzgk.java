package com.google.android.gms.internal.measurement;

public final class zzgk
  extends zzka
  implements zzlm
{
  private zzgk()
  {
    super(zzgl.getH());
  }
  
  public final zzgk descend()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgl.d((zzgl)this$0);
    return this;
  }
  
  public final zzgk descend(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgl.b((zzgl)this$0, paramString);
    return this;
  }
  
  public final zzgk f(double paramDouble)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgl.a((zzgl)this$0, paramDouble);
    return this;
  }
  
  public final zzgk inc()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgl.c((zzgl)this$0);
    return this;
  }
  
  public final zzgk inc(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgl.b((zzgl)this$0, paramLong);
    return this;
  }
  
  public final zzgk insert(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgl.d((zzgl)this$0, paramLong);
    return this;
  }
  
  public final zzgk insert(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgl.d((zzgl)this$0, paramString);
    return this;
  }
  
  public final zzgk putShort()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzgl.a((zzgl)this$0);
    return this;
  }
}
