package com.google.android.gms.internal.measurement;

public final class zzeg
  extends zzka
  implements zzlm
{
  private zzeg()
  {
    super(zzeh.getView());
  }
  
  public final zzeg add(int paramInt, zzer paramZzer)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzeh.addAttribute((zzeh)this$0, paramInt, (zzes)paramZzer.zzaE());
    return this;
  }
  
  public final int download()
  {
    return ((zzeh)this$0).download();
  }
  
  public final int execute()
  {
    return ((zzeh)this$0).get();
  }
  
  public final zzej openConnection(int paramInt)
  {
    return ((zzeh)this$0).openConnection(paramInt);
  }
  
  public final zzes post(int paramInt)
  {
    return ((zzeh)this$0).makeRequest(paramInt);
  }
  
  public final zzeg remainder(int paramInt, zzei paramZzei)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzeh.add((zzeh)this$0, paramInt, (zzej)paramZzei.zzaE());
    return this;
  }
}
