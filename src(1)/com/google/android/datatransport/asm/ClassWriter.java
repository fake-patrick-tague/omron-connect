package com.google.android.datatransport.asm;

import com.google.firebase.common.BitmapCache;
import com.google.firebase.common.Paint;
import com.google.firebase.encoders.proto.a;
import java.io.IOException;

final class ClassWriter
  implements com.google.firebase.p.d<com.google.android.datatransport.runtime.firebase.transport.d>
{
  static final ClassWriter a = new ClassWriter();
  private static final Paint b = Paint.get("currentCacheSizeBytes").get(a.i().setValue(1).getValue()).getInstance();
  private static final Paint p = Paint.get("maxCacheSizeBytes").get(a.i().setValue(2).getValue()).getInstance();
  
  private ClassWriter() {}
  
  public void b(com.google.android.datatransport.runtime.firebase.transport.ClassWriter paramClassWriter, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.a(b, paramClassWriter.newUTF8());
    paramD.a(p, paramClassWriter.f());
  }
}
