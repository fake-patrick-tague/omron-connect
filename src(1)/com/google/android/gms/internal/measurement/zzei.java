package com.google.android.gms.internal.measurement;

public final class zzei
  extends zzka
  implements zzlm
{
  private zzei()
  {
    super(zzej.getApplication());
  }
  
  public final zzei append(int paramInt, zzel paramZzel)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzej.createCopy((zzej)this$0, paramInt, paramZzel);
    return this;
  }
  
  public final int clientCount()
  {
    return ((zzej)this$0).size();
  }
  
  public final zzei descend(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzej.apply((zzej)this$0, paramString);
    return this;
  }
  
  public final zzel getContent(int paramInt)
  {
    return ((zzej)this$0).getInputStream(paramInt);
  }
  
  public final String getFile()
  {
    return ((zzej)this$0).getEntry();
  }
}
