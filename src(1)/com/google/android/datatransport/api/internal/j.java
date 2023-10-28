package com.google.android.datatransport.api.internal;

final class j
  extends ClientInfo.a
{
  private Label a;
  private ClientInfo.ClientType n;
  
  j() {}
  
  public ClientInfo.a a(ClientInfo.ClientType paramClientType)
  {
    n = paramClientType;
    return this;
  }
  
  public ClientInfo.a a(Label paramLabel)
  {
    a = paramLabel;
    return this;
  }
  
  public ClientInfo a()
  {
    return new Handle(n, a, null);
  }
}
