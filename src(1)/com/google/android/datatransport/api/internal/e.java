package com.google.android.datatransport.api.internal;

import java.util.List;

public abstract class e
{
  public e() {}
  
  public e a(int paramInt)
  {
    return a(Integer.valueOf(paramInt));
  }
  
  public abstract e a(long paramLong);
  
  public abstract e a(ClientInfo paramClientInfo);
  
  public abstract e a(QosTier paramQosTier);
  
  abstract e a(Integer paramInteger);
  
  public e a(String paramString)
  {
    return b(paramString);
  }
  
  public abstract e a(List paramList);
  
  public abstract p a();
  
  public abstract e b(long paramLong);
  
  abstract e b(String paramString);
}
