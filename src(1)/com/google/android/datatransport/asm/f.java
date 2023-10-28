package com.google.android.datatransport.asm;

import com.google.android.datatransport.runtime.firebase.transport.h;
import com.google.firebase.common.BitmapCache;
import com.google.firebase.common.Paint;
import java.io.IOException;

final class f
  implements com.google.firebase.p.d<com.google.android.datatransport.runtime.firebase.transport.a>
{
  private static final Paint a = Paint.get("window").get(com.google.firebase.encoders.proto.a.i().setValue(1).getValue()).getInstance();
  private static final Paint b = Paint.get("logSourceMetrics").get(com.google.firebase.encoders.proto.a.i().setValue(2).getValue()).getInstance();
  static final f d = new f();
  private static final Paint p = Paint.get("globalMetrics").get(com.google.firebase.encoders.proto.a.i().setValue(3).getValue()).getInstance();
  private static final Paint q = Paint.get("appNamespace").get(com.google.firebase.encoders.proto.a.i().setValue(4).getValue()).getInstance();
  
  private f() {}
  
  public void b(h paramH, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.append(a, paramH.c());
    paramD.append(b, paramH.f());
    paramD.append(p, paramH.a());
    paramD.append(q, paramH.b());
  }
}
