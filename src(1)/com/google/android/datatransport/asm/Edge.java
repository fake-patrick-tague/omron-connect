package com.google.android.datatransport.asm;

import com.google.android.datatransport.Type;
import java.util.Arrays;
import java.util.Objects;

public final class Edge
{
  private final Type b;
  private final byte[] c;
  
  public Edge(Type paramType, byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramType, "encoding is null");
    Objects.requireNonNull(paramArrayOfByte, "bytes is null");
    b = paramType;
    c = paramArrayOfByte;
  }
  
  public Type a()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Edge)) {
      return false;
    }
    paramObject = (Edge)paramObject;
    if (!b.equals(b)) {
      return false;
    }
    return Arrays.equals(c, c);
  }
  
  public byte[] get()
  {
    return c;
  }
  
  public int hashCode()
  {
    return (b.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(c);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EncodedPayload{encoding=");
    localStringBuilder.append(b);
    localStringBuilder.append(", bytes=[...]}");
    return localStringBuilder.toString();
  }
}
