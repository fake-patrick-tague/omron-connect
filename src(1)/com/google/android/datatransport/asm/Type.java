package com.google.android.datatransport.asm;

import com.google.android.datatransport.h.m;
import com.google.firebase.common.Paint;
import java.io.IOException;

final class Type
  implements com.google.firebase.p.d<m>
{
  static final Type c = new Type();
  private static final Paint d = Paint.valueOf("clientMetrics");
  
  private Type() {}
  
  public void a(Frame paramFrame, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.append(d, paramFrame.c());
  }
}
