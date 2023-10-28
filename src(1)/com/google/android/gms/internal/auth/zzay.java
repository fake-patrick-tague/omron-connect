package com.google.android.gms.internal.auth;

public enum zzay
{
  private final String zzek;
  
  private zzay(String paramString)
  {
    zzek = paramString;
  }
  
  public static final zzay byName(String paramString)
  {
    zzay[] arrayOfZzay = values();
    int j = arrayOfZzay.length;
    Object localObject = null;
    int i = 0;
    while (i < j)
    {
      zzay localZzay = arrayOfZzay[i];
      if (zzek.equals(paramString)) {
        localObject = localZzay;
      }
      i += 1;
    }
    return localObject;
  }
  
  public static boolean isDescendantOf(zzay paramZzay)
  {
    return (zzcr.equals(paramZzay)) || (zzda.equals(paramZzay)) || (zzdd.equals(paramZzay)) || (zzde.equals(paramZzay)) || (zzcv.equals(paramZzay)) || (zzdg.equals(paramZzay)) || (zzck.equals(paramZzay)) || (zzdl.equals(paramZzay)) || (zzdm.equals(paramZzay)) || (zzdn.equals(paramZzay)) || (zzdo.equals(paramZzay)) || (zzdp.equals(paramZzay)) || (zzdq.equals(paramZzay)) || (zzds.equals(paramZzay)) || (zzdk.equals(paramZzay)) || (zzdr.equals(paramZzay));
  }
}
