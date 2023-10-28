package com.google.android.datatransport.api.internal;

final class MethodWriter
  extends NetworkConnectionInfo.a
{
  private NetworkConnectionInfo.NetworkType J;
  private NetworkConnectionInfo.MobileSubtype q;
  
  MethodWriter() {}
  
  public NetworkConnectionInfo.a a(NetworkConnectionInfo.MobileSubtype paramMobileSubtype)
  {
    q = paramMobileSubtype;
    return this;
  }
  
  public NetworkConnectionInfo.a a(NetworkConnectionInfo.NetworkType paramNetworkType)
  {
    J = paramNetworkType;
    return this;
  }
  
  public NetworkConnectionInfo a()
  {
    return new Type(J, q, null);
  }
}
