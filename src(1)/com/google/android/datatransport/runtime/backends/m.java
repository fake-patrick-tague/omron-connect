package com.google.android.datatransport.runtime.backends;

import java.util.Objects;

final class m
  extends BackendResponse
{
  private final long h;
  private final BackendResponse.Status q;
  
  m(BackendResponse.Status paramStatus, long paramLong)
  {
    Objects.requireNonNull(paramStatus, "Null status");
    q = paramStatus;
    h = paramLong;
  }
  
  public BackendResponse.Status c()
  {
    return q;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof BackendResponse))
    {
      paramObject = (BackendResponse)paramObject;
      if ((q.equals(paramObject.c())) && (h == paramObject.f())) {
        return true;
      }
    }
    return false;
  }
  
  public long f()
  {
    return h;
  }
  
  public int hashCode()
  {
    int i = q.hashCode();
    long l = h;
    return (i ^ 0xF4243) * 1000003 ^ (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BackendResponse{status=");
    localStringBuilder.append(q);
    localStringBuilder.append(", nextRequestWaitMillis=");
    localStringBuilder.append(h);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
