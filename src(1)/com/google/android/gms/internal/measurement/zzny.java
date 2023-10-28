package com.google.android.gms.internal.measurement;

public final class zzny
  implements zzih
{
  private static final zzny TAG = new zzny();
  private final zzih to;
  
  public zzny()
  {
    to = zzil.toLowerCase(localZzih);
  }
  
  public static boolean d()
  {
    return TAG.hasNext().a();
  }
  
  public static boolean download()
  {
    TAG.hasNext().cancelPotentialDownload();
    return true;
  }
  
  public static boolean fetchData()
  {
    return TAG.hasNext().fetchData();
  }
  
  public static boolean initDbTable()
  {
    return TAG.hasNext().getOrElse();
  }
  
  public final zznz hasNext()
  {
    return (zznz)to.dotProduct();
  }
}
