package com.google.android.datatransport.asm;

import com.google.android.datatransport.runtime.firebase.transport.Label;
import com.google.android.datatransport.runtime.firebase.transport.c;
import com.google.firebase.common.BitmapCache;
import com.google.firebase.common.Paint;
import com.google.firebase.encoders.proto.a;
import java.io.IOException;

final class AnnotationWriter
  implements com.google.firebase.p.d<c>
{
  private static final Paint b = Paint.get("logEventDropped").get(a.i().setValue(2).getValue()).getInstance();
  private static final Paint c;
  static final AnnotationWriter g = new AnnotationWriter();
  
  static
  {
    c = Paint.get("logSource").get(a.i().setValue(1).getValue()).getInstance();
  }
  
  private AnnotationWriter() {}
  
  public void a(Label paramLabel, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.append(c, paramLabel.b());
    paramD.append(b, paramLabel.a());
  }
}
