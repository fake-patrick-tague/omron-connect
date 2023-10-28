package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgo
  extends zzke
  implements zzlm
{
  private static final zzgo webView;
  private zzkl elements = zzke.zzbD();
  
  static
  {
    zzgo localZzgo = new zzgo();
    webView = localZzgo;
    zzke.zzbJ(zzgo.class, localZzgo);
  }
  
  private zzgo() {}
  
  public static zzgo access$getWebView()
  {
    return webView;
  }
  
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
          return new zzgn(null);
        }
        return new zzgo();
      }
      return zzke.zzbI(webView, "\001\001\000\000\001\001\001\000\001\000\001\033", new Object[] { "zze", zzgq.class });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final List getElements()
  {
    return elements;
  }
  
  public final int getSize()
  {
    return elements.size();
  }
}
