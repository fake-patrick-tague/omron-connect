package com.google.android.datatransport;

public abstract class a<T>
{
  public a() {}
  
  public static a a(Object paramObject)
  {
    return new Attribute(null, paramObject, Priority.C);
  }
  
  public abstract Priority getGroupId();
  
  public abstract Integer getName();
  
  public abstract Object getValue();
}
