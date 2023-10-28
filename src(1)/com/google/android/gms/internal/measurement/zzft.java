package com.google.android.gms.internal.measurement;

public final class zzft
  extends zzka
  implements zzlm
{
  private zzft()
  {
    super(zzfu.getSocket());
  }
  
  public final zzft put(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfu.offer((zzfu)this$0, paramLong);
    return this;
  }
  
  public final zzft put(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfu.addElement((zzfu)this$0, paramString);
    return this;
  }
}
