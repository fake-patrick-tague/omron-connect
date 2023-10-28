package com.google.android.datatransport.runtime.firebase.transport;

public final class f
{
  private long b = 0L;
  private long l = 0L;
  
  f() {}
  
  public f a(long paramLong)
  {
    b = paramLong;
    return this;
  }
  
  public f b(long paramLong)
  {
    l = paramLong;
    return this;
  }
  
  public Marker getItem()
  {
    return new Marker(b, l);
  }
}
