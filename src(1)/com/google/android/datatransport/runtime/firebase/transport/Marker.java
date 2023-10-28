package com.google.android.datatransport.runtime.firebase.transport;

public final class Marker
{
  private static final Marker mDefaultInfoWindow = new f().getItem();
  private final long a;
  private final long mPosition;
  
  Marker(long paramLong1, long paramLong2)
  {
    a = paramLong1;
    mPosition = paramLong2;
  }
  
  public static f a()
  {
    return new f();
  }
  
  public long getPosition()
  {
    return mPosition;
  }
  
  public long getValue()
  {
    return a;
  }
}
