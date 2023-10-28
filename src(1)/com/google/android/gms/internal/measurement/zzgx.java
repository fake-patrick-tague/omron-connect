package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgx
  extends zzke
  implements zzlm
{
  private static final zzgx webView;
  private zzkl cache = zzke.zzbD();
  private String certainty = "";
  private int generator;
  private boolean originId;
  private int pass;
  private String size = "";
  private double totalSize;
  
  static
  {
    zzgx localZzgx = new zzgx();
    webView = localZzgx;
    zzke.zzbJ(zzgx.class, localZzgx);
  }
  
  private zzgx() {}
  
  protected final Object Decode(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramInt -= 1;
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return null;
            }
            return webView;
          }
          return new zzgt(null);
        }
        return new zzgx();
      }
      paramObject1 = zzgv.FAR;
      return zzke.zzbI(webView, "\001\006\000\001\001\006\006\000\001\000\001?\000\002\033\003?\001\004?\002\005?\003\006?\004", new Object[] { "zze", "zzf", paramObject1, "zzg", zzgx.class, "zzh", "zzi", "zzj", "zzk" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean call()
  {
    return (generator & 0x8) != 0;
  }
  
  public final List get()
  {
    return cache;
  }
  
  public final String getCertainty()
  {
    return certainty;
  }
  
  public final String getFileSize()
  {
    return size;
  }
  
  public final boolean getOriginId()
  {
    return originId;
  }
  
  public final double getSize()
  {
    return totalSize;
  }
  
  public final boolean next()
  {
    return (generator & 0x10) != 0;
  }
  
  public final int testConnection()
  {
    int i = zzgw.testConnection(pass);
    if (i == 0) {
      return 1;
    }
    return i;
  }
  
  public final boolean writeValue()
  {
    return (generator & 0x4) != 0;
  }
}
