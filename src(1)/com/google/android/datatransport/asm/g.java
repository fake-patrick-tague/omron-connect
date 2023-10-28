package com.google.android.datatransport.asm;

import com.google.android.datatransport.runtime.firebase.transport.Marker;
import com.google.android.datatransport.runtime.firebase.transport.e;
import com.google.firebase.common.BitmapCache;
import com.google.firebase.common.Paint;
import com.google.firebase.encoders.proto.a;
import java.io.IOException;

final class g
  implements com.google.firebase.p.d<e>
{
  private static final Paint b = Paint.get("endMs").get(a.i().setValue(2).getValue()).getInstance();
  private static final Paint c;
  static final g d = new g();
  
  static
  {
    c = Paint.get("startMs").get(a.i().setValue(1).getValue()).getInstance();
  }
  
  private g() {}
  
  public void b(Marker paramMarker, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.a(c, paramMarker.getValue());
    paramD.a(b, paramMarker.getPosition());
  }
}
