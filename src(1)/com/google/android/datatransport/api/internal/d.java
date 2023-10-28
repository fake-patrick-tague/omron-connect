package com.google.android.datatransport.api.internal;

import com.google.android.datatransport.cct.internal.k;
import java.util.List;

final class d
  extends e
{
  private Long a;
  private Integer b;
  private String c;
  private Long d;
  private List<k> f;
  private QosTier i;
  private ClientInfo z;
  
  d() {}
  
  public e a(long paramLong)
  {
    d = Long.valueOf(paramLong);
    return this;
  }
  
  public e a(ClientInfo paramClientInfo)
  {
    z = paramClientInfo;
    return this;
  }
  
  public e a(QosTier paramQosTier)
  {
    i = paramQosTier;
    return this;
  }
  
  e a(Integer paramInteger)
  {
    b = paramInteger;
    return this;
  }
  
  public e a(List paramList)
  {
    f = paramList;
    return this;
  }
  
  public p a()
  {
    Object localObject2 = d;
    Object localObject1 = "";
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(" requestTimeMs");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (a == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" requestUptimeMs");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if (((String)localObject2).isEmpty()) {
      return new b(d.longValue(), a.longValue(), z, b, c, f, i, null);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Missing required properties:");
    ((StringBuilder)localObject1).append((String)localObject2);
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
  }
  
  public e b(long paramLong)
  {
    a = Long.valueOf(paramLong);
    return this;
  }
  
  e b(String paramString)
  {
    c = paramString;
    return this;
  }
}
