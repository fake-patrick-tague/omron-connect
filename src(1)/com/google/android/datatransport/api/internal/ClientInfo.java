package com.google.android.datatransport.api.internal;

public abstract class ClientInfo
{
  public ClientInfo() {}
  
  public static a a()
  {
    return new j();
  }
  
  public abstract ClientType getName();
  
  public abstract Label getOwner();
  
  public enum ClientType
  {
    private final int nps;
    
    static
    {
      ClientType localClientType1 = new ClientType("UNKNOWN", 0, 0);
      vcard = localClientType1;
      ClientType localClientType2 = new ClientType("ANDROID_FIREBASE", 1, 23);
      c = localClientType2;
      d = new ClientType[] { localClientType1, localClientType2 };
    }
    
    private ClientType(int paramInt)
    {
      nps = paramInt;
    }
  }
  
  public abstract class a
  {
    public a() {}
    
    public abstract a a(ClientInfo.ClientType paramClientType);
    
    public abstract a a(Label paramLabel);
    
    public abstract ClientInfo a();
  }
}
