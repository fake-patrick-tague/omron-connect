package com.google.android.datatransport.api.internal;

import com.google.firebase.common.Paint;
import java.io.IOException;

final class l
  implements com.google.firebase.p.d<com.google.android.datatransport.cct.internal.l>
{
  private static final Paint a;
  private static final Paint b = Paint.valueOf("qosTier");
  private static final Paint c;
  private static final Paint d;
  private static final Paint e;
  private static final Paint g;
  private static final Paint h;
  static final l i = new l();
  
  static
  {
    e = Paint.valueOf("requestTimeMs");
    a = Paint.valueOf("requestUptimeMs");
    c = Paint.valueOf("clientInfo");
    d = Paint.valueOf("logSource");
    g = Paint.valueOf("logSourceName");
    h = Paint.valueOf("logEvent");
  }
  
  private l() {}
  
  public void a(p paramP, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.a(e, paramP.b());
    paramD.a(a, paramP.getItem());
    paramD.append(c, paramP.c());
    paramD.append(d, paramP.getValue());
    paramD.append(g, paramP.getId());
    paramD.append(h, paramP.d());
    paramD.append(b, paramP.getTitle());
  }
}
