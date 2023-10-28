package com.google.android.gms.internal.fitness;

final class zzfn<E>
  extends zzfh<E>
{
  private final transient E zzts;
  private transient int zztt;
  
  zzfn(Object paramObject)
  {
    zzts = zzez.checkNotNull(paramObject);
  }
  
  zzfn(Object paramObject, int paramInt)
  {
    zzts = paramObject;
    zztt = paramInt;
  }
  
  public final boolean contains(Object paramObject)
  {
    return zzts.equals(paramObject);
  }
  
  final int get(Object[] paramArrayOfObject, int paramInt)
  {
    paramArrayOfObject[0] = zzts;
    return 1;
  }
  
  public final int hashCode()
  {
    int j = zztt;
    int i = j;
    if (j == 0)
    {
      i = zzts.hashCode();
      zztt = i;
    }
    return i;
  }
  
  public final int size()
  {
    return 1;
  }
  
  public final String toString()
  {
    String str = zzts.toString();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 2);
    localStringBuilder.append('[');
    localStringBuilder.append(str);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public final zzfm zzae()
  {
    return new zzfg(zzts);
  }
  
  final boolean zzaj()
  {
    return false;
  }
  
  final boolean zzak()
  {
    return zztt != 0;
  }
  
  final zzfc zzal()
  {
    return zzfc.addRange(zzts);
  }
}
