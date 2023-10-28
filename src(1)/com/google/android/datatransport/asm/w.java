package com.google.android.datatransport.asm;

import com.google.android.datatransport.runtime.firebase.transport.b;
import com.google.firebase.common.BitmapCache;
import com.google.firebase.common.Paint;
import com.google.firebase.encoders.proto.a;
import java.io.IOException;

final class w
  implements com.google.firebase.p.d<b>
{
  static final w a = new w();
  private static final Paint b = Paint.get("storageMetrics").get(a.i().setValue(1).getValue()).getInstance();
  
  private w() {}
  
  public void a(b paramB, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.append(b, paramB.a());
  }
}
