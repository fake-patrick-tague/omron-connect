package com.google.android.datatransport.api.internal;

import java.util.Arrays;

final class h
  extends m
{
  private final long a;
  private final Integer b;
  private final String c;
  private final NetworkConnectionInfo d;
  private final long f;
  private final long h;
  private final byte[] r;
  
  private h(long paramLong1, Integer paramInteger, long paramLong2, byte[] paramArrayOfByte, String paramString, long paramLong3, NetworkConnectionInfo paramNetworkConnectionInfo)
  {
    h = paramLong1;
    b = paramInteger;
    f = paramLong2;
    r = paramArrayOfByte;
    c = paramString;
    a = paramLong3;
    d = paramNetworkConnectionInfo;
  }
  
  public byte[] a()
  {
    return r;
  }
  
  public long c()
  {
    return a;
  }
  
  public long d()
  {
    return f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof m))
    {
      m localM = (m)paramObject;
      if (h == localM.f())
      {
        paramObject = b;
        if ((paramObject == null ? localM.getGroupId() == null : paramObject.equals(localM.getGroupId())) && (f == localM.d()))
        {
          byte[] arrayOfByte = r;
          if ((localM instanceof h)) {
            paramObject = r;
          } else {
            paramObject = localM.a();
          }
          if (Arrays.equals(arrayOfByte, paramObject))
          {
            paramObject = c;
            if ((paramObject == null ? localM.getTitle() == null : paramObject.equals(localM.getTitle())) && (a == localM.c()))
            {
              paramObject = d;
              if (paramObject == null)
              {
                if (localM.getOrder() == null) {
                  return true;
                }
              }
              else if (paramObject.equals(localM.getOrder())) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public long f()
  {
    return h;
  }
  
  public Integer getGroupId()
  {
    return b;
  }
  
  public NetworkConnectionInfo getOrder()
  {
    return d;
  }
  
  public String getTitle()
  {
    return c;
  }
  
  public int hashCode()
  {
    long l = h;
    int m = (int)(l ^ l >>> 32);
    Object localObject = b;
    int k = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Integer)localObject).hashCode();
    }
    l = f;
    int n = (int)(l ^ l >>> 32);
    int i1 = Arrays.hashCode(r);
    localObject = c;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    l = a;
    int i2 = (int)(l >>> 32 ^ l);
    localObject = d;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return ((((((m ^ 0xF4243) * 1000003 ^ i) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ j) * 1000003 ^ i2) * 1000003 ^ k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LogEvent{eventTimeMs=");
    localStringBuilder.append(h);
    localStringBuilder.append(", eventCode=");
    localStringBuilder.append(b);
    localStringBuilder.append(", eventUptimeMs=");
    localStringBuilder.append(f);
    localStringBuilder.append(", sourceExtension=");
    localStringBuilder.append(Arrays.toString(r));
    localStringBuilder.append(", sourceExtensionJsonProto3=");
    localStringBuilder.append(c);
    localStringBuilder.append(", timezoneOffsetSeconds=");
    localStringBuilder.append(a);
    localStringBuilder.append(", networkConnectionInfo=");
    localStringBuilder.append(d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
