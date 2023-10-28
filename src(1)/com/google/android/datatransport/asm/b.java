package com.google.android.datatransport.asm;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.firebase.common.BitmapCache;
import com.google.firebase.common.Paint;
import com.google.firebase.encoders.proto.a;
import java.io.IOException;

final class b
  implements com.google.firebase.p.d<LogEventDropped>
{
  private static final Paint b = Paint.get("eventsDroppedCount").get(a.i().setValue(1).getValue()).getInstance();
  static final b c = new b();
  private static final Paint g = Paint.get("reason").get(a.i().setValue(3).getValue()).getInstance();
  
  private b() {}
  
  public void c(LogEventDropped paramLogEventDropped, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.a(b, paramLogEventDropped.b());
    paramD.append(g, paramLogEventDropped.a());
  }
}
