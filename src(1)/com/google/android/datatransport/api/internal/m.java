package com.google.android.datatransport.api.internal;

public abstract class m
{
  public m() {}
  
  private static DfsRefDatabase.RefCache remove()
  {
    return new CustomConcurrentHashMap.Impl.Segment();
  }
  
  public static DfsRefDatabase.RefCache remove(String paramString)
  {
    return remove().remove(paramString);
  }
  
  public static DfsRefDatabase.RefCache remove(byte[] paramArrayOfByte)
  {
    return remove().remove(paramArrayOfByte);
  }
  
  public abstract byte[] a();
  
  public abstract long c();
  
  public abstract long d();
  
  public abstract long f();
  
  public abstract Integer getGroupId();
  
  public abstract NetworkConnectionInfo getOrder();
  
  public abstract String getTitle();
}
