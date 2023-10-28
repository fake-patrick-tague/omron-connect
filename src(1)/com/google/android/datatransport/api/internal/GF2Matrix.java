package com.google.android.datatransport.api.internal;

final class GF2Matrix
  extends Matrix
{
  private final long length;
  
  GF2Matrix(long paramLong)
  {
    length = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Matrix))
    {
      paramObject = (Matrix)paramObject;
      if (length == paramObject.length()) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = length;
    return (int)(l ^ l >>> 32) ^ 0xF4243;
  }
  
  public long length()
  {
    return length;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LogResponse{nextRequestWaitMillis=");
    localStringBuilder.append(length);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
