package com.google.android.datatransport.runtime.backends;

public abstract class d
{
  public d() {}
  
  public static ExtensionData b()
  {
    return new MethodWriter();
  }
  
  public abstract byte[] a();
  
  public abstract Iterable getName();
}
