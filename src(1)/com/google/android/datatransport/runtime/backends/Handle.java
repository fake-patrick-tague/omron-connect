package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.h.j;
import java.util.Arrays;

final class Handle
  extends d
{
  private final Iterable<j> c;
  private final byte[] d;
  
  private Handle(Iterable paramIterable, byte[] paramArrayOfByte)
  {
    c = paramIterable;
    d = paramArrayOfByte;
  }
  
  public byte[] a()
  {
    return d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      if (c.equals(paramObject.getName()))
      {
        byte[] arrayOfByte = d;
        if ((paramObject instanceof Handle)) {
          paramObject = d;
        } else {
          paramObject = paramObject.a();
        }
        if (Arrays.equals(arrayOfByte, paramObject)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Iterable getName()
  {
    return c;
  }
  
  public int hashCode()
  {
    return (c.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(d);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BackendRequest{events=");
    localStringBuilder.append(c);
    localStringBuilder.append(", extras=");
    localStringBuilder.append(Arrays.toString(d));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
