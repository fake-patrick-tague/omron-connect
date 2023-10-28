package com.google.android.datatransport.api.internal;

final class Handle
  extends ClientInfo
{
  private final Label b;
  private final ClientInfo.ClientType c;
  
  private Handle(ClientInfo.ClientType paramClientType, Label paramLabel)
  {
    c = paramClientType;
    b = paramLabel;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ClientInfo))
    {
      paramObject = (ClientInfo)paramObject;
      Object localObject = c;
      if (localObject == null ? paramObject.getName() == null : ((Enum)localObject).equals(paramObject.getName()))
      {
        localObject = b;
        if (localObject == null)
        {
          if (paramObject.getOwner() == null) {
            return true;
          }
        }
        else if (localObject.equals(paramObject.getOwner())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public ClientInfo.ClientType getName()
  {
    return c;
  }
  
  public Label getOwner()
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
      j = localObject.hashCode();
    }
    return (i ^ 0xF4243) * 1000003 ^ j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClientInfo{clientType=");
    localStringBuilder.append(c);
    localStringBuilder.append(", androidClientInfo=");
    localStringBuilder.append(b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
