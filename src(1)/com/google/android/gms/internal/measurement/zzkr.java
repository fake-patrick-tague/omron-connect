package com.google.android.gms.internal.measurement;

public class zzkr
{
  private static final zzjq magenta = zzjq.o;
  private volatile zzjd a;
  protected volatile zzll type;
  
  public zzkr() {}
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzkr)) {
      return false;
    }
    paramObject = (zzkr)paramObject;
    zzll localZzll1 = type;
    zzll localZzll2 = type;
    if ((localZzll1 == null) && (localZzll2 == null)) {
      return getTitle().equals(paramObject.getTitle());
    }
    if ((localZzll1 != null) && (localZzll2 != null)) {
      return localZzll1.equals(localZzll2);
    }
    if (localZzll1 != null)
    {
      paramObject.reinit(localZzll1.zzbO());
      return localZzll1.equals(type);
    }
    reinit(localZzll2.zzbO());
    return type.equals(localZzll2);
  }
  
  public final zzjd getTitle()
  {
    if (a != null) {
      return a;
    }
    try
    {
      if (a != null)
      {
        localZzjd = a;
        return localZzjd;
      }
      if (type == null) {
        a = zzjd.a;
      } else {
        a = type.zzbs();
      }
      zzjd localZzjd = a;
      return localZzjd;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final int length()
  {
    if (a != null) {
      return a).data.length;
    }
    if (type != null) {
      return type.zzbw();
    }
    return 0;
  }
  
  protected final void reinit(zzll paramZzll)
  {
    if (type != null) {
      return;
    }
    try
    {
      zzll localZzll = type;
      if (localZzll == null)
      {
        type = paramZzll;
        a = zzjd.a;
        return;
      }
      return;
    }
    catch (Throwable paramZzll)
    {
      throw paramZzll;
    }
  }
}
