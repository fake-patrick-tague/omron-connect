package com.google.android.gms.internal.measurement;

public final class zzfb
  extends zzka
  implements zzlm
{
  private zzfb()
  {
    super(zzfc.getView());
  }
  
  public final String getType()
  {
    return ((zzfc)this$0).getStringValue();
  }
  
  public final boolean is3D()
  {
    return ((zzfc)this$0).is3D();
  }
  
  public final boolean isEmpty()
  {
    return ((zzfc)this$0).isEmpty();
  }
  
  public final int iterator()
  {
    return ((zzfc)this$0).empty();
  }
  
  public final boolean last()
  {
    return ((zzfc)this$0).next();
  }
  
  public final boolean newSession()
  {
    return ((zzfc)this$0).newSession();
  }
  
  public final boolean next()
  {
    return ((zzfc)this$0).get();
  }
  
  public final zzfb remove(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfc.replace((zzfc)this$0, paramString);
    return this;
  }
}
