package com.google.android.datatransport.api.internal;

final class Type
  extends NetworkConnectionInfo
{
  private final NetworkConnectionInfo.MobileSubtype b;
  private final NetworkConnectionInfo.NetworkType c;
  
  private Type(NetworkConnectionInfo.NetworkType paramNetworkType, NetworkConnectionInfo.MobileSubtype paramMobileSubtype)
  {
    c = paramNetworkType;
    b = paramMobileSubtype;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof NetworkConnectionInfo))
    {
      paramObject = (NetworkConnectionInfo)paramObject;
      Object localObject = c;
      if (localObject == null ? paramObject.get() == null : ((Enum)localObject).equals(paramObject.get()))
      {
        localObject = b;
        if (localObject == null)
        {
          if (paramObject.getValue() == null) {
            return true;
          }
        }
        else if (((Enum)localObject).equals(paramObject.getValue())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public NetworkConnectionInfo.NetworkType get()
  {
    return c;
  }
  
  public NetworkConnectionInfo.MobileSubtype getValue()
  {
    return b;
  }
  
  public int hashCode()
  {
    Object localObject = c;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Enum)localObject).hashCode();
    }
    localObject = b;
    if (localObject != null) {
      j = ((Enum)localObject).hashCode();
    }
    return (i ^ 0xF4243) * 1000003 ^ j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetworkConnectionInfo{networkType=");
    localStringBuilder.append(c);
    localStringBuilder.append(", mobileSubtype=");
    localStringBuilder.append(b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
