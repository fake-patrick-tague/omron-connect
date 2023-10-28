package com.google.android.datatransport.api.internal;

import com.google.android.datatransport.cct.internal.k;
import java.util.List;

final class b
  extends p
{
  private final long a;
  private final Integer b;
  private final ClientInfo c;
  private final long d;
  private final List<k> f;
  private final String g;
  private final QosTier h;
  
  private b(long paramLong1, long paramLong2, ClientInfo paramClientInfo, Integer paramInteger, String paramString, List paramList, QosTier paramQosTier)
  {
    d = paramLong1;
    a = paramLong2;
    c = paramClientInfo;
    b = paramInteger;
    g = paramString;
    f = paramList;
    h = paramQosTier;
  }
  
  public long b()
  {
    return d;
  }
  
  public ClientInfo c()
  {
    return c;
  }
  
  public List d()
  {
    return f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof p))
    {
      paramObject = (p)paramObject;
      if ((d == paramObject.b()) && (a == paramObject.getItem()))
      {
        Object localObject = c;
        if (localObject == null ? paramObject.c() == null : localObject.equals(paramObject.c()))
        {
          localObject = b;
          if (localObject == null ? paramObject.getValue() == null : ((Integer)localObject).equals(paramObject.getValue()))
          {
            localObject = g;
            if (localObject == null ? paramObject.getId() == null : ((String)localObject).equals(paramObject.getId()))
            {
              localObject = f;
              if (localObject == null ? paramObject.d() == null : ((List)localObject).equals(paramObject.d()))
              {
                localObject = h;
                if (localObject == null)
                {
                  if (paramObject.getTitle() == null) {
                    return true;
                  }
                }
                else if (((Enum)localObject).equals(paramObject.getTitle())) {
                  return true;
                }
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public String getId()
  {
    return g;
  }
  
  public long getItem()
  {
    return a;
  }
  
  public QosTier getTitle()
  {
    return h;
  }
  
  public Integer getValue()
  {
    return b;
  }
  
  public int hashCode()
  {
    long l = d;
    int i1 = (int)(l ^ l >>> 32);
    l = a;
    int i2 = (int)(l >>> 32 ^ l);
    Object localObject = c;
    int n = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = b;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((Integer)localObject).hashCode();
    }
    localObject = g;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((String)localObject).hashCode();
    }
    localObject = f;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((List)localObject).hashCode();
    }
    localObject = h;
    if (localObject != null) {
      n = ((Enum)localObject).hashCode();
    }
    return ((((((i1 ^ 0xF4243) * 1000003 ^ i2) * 1000003 ^ i) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LogRequest{requestTimeMs=");
    localStringBuilder.append(d);
    localStringBuilder.append(", requestUptimeMs=");
    localStringBuilder.append(a);
    localStringBuilder.append(", clientInfo=");
    localStringBuilder.append(c);
    localStringBuilder.append(", logSource=");
    localStringBuilder.append(b);
    localStringBuilder.append(", logSourceName=");
    localStringBuilder.append(g);
    localStringBuilder.append(", logEvents=");
    localStringBuilder.append(f);
    localStringBuilder.append(", qosTier=");
    localStringBuilder.append(h);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
