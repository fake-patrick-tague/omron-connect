package com.google.android.gms.internal.measurement;

public final class zznp
  implements zzih
{
  private static final zznp y = new zznp();
  private final zzih value;
  
  public zznp()
  {
    value = zzil.toLowerCase(localZzih);
  }
  
  public static long crossProduct()
  {
    return y.linearCombination().parseAndAdd();
  }
  
  public final zznq linearCombination()
  {
    return (zznq)value.dotProduct();
  }
}
