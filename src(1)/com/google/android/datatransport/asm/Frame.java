package com.google.android.datatransport.asm;

import com.google.android.datatransport.runtime.firebase.transport.h;
import com.google.firebase.encoders.proto.Attribute;
import com.google.firebase.encoders.proto.f;

public abstract class Frame
{
  private static final Attribute a = Attribute.a().a(RFC4519Style.c).a();
  
  private Frame() {}
  
  public static byte[] a(Object paramObject)
  {
    return a.read(paramObject);
  }
  
  public abstract h c();
}
