package com.google.android.datatransport.runtime.firebase.transport;

public final class ClassWriter
{
  private static final ClassWriter b = new e().b();
  private final long h;
  private final long index;
  
  ClassWriter(long paramLong1, long paramLong2)
  {
    index = paramLong1;
    h = paramLong2;
  }
  
  public static e a()
  {
    return new e();
  }
  
  public long f()
  {
    return h;
  }
  
  public long newUTF8()
  {
    return index;
  }
}
