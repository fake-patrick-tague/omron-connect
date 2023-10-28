package com.google.android.datatransport.api.internal;

import com.google.android.datatransport.cct.internal.k;
import com.google.firebase.common.Paint;
import java.io.IOException;

final class g
  implements com.google.firebase.p.d<k>
{
  static final g a = new g();
  private static final Paint b = Paint.valueOf("timezoneOffsetSeconds");
  private static final Paint c;
  private static final Paint d;
  private static final Paint e = Paint.valueOf("eventTimeMs");
  private static final Paint f;
  private static final Paint g = Paint.valueOf("networkConnectionInfo");
  private static final Paint h;
  
  static
  {
    c = Paint.valueOf("eventCode");
    d = Paint.valueOf("eventUptimeMs");
    f = Paint.valueOf("sourceExtension");
    h = Paint.valueOf("sourceExtensionJsonProto3");
  }
  
  private g() {}
  
  public void a(m paramM, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.a(e, paramM.f());
    paramD.append(c, paramM.getGroupId());
    paramD.a(d, paramM.d());
    paramD.append(f, paramM.a());
    paramD.append(h, paramM.getTitle());
    paramD.a(b, paramM.c());
    paramD.append(g, paramM.getOrder());
  }
}
