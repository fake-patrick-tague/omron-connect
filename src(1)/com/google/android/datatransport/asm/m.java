package com.google.android.datatransport.asm;

import com.google.android.datatransport.Type;
import com.google.android.datatransport.a;
import com.google.android.datatransport.g;

abstract class m
{
  m() {}
  
  public static ByteVector b()
  {
    return new XYPlot();
  }
  
  public byte[] a()
  {
    return (byte[])getTitle().apply(get().getValue());
  }
  
  public abstract String d();
  
  public abstract Context f();
  
  abstract a get();
  
  public abstract Type getGroupId();
  
  abstract g getTitle();
}
