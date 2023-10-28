package com.google.android.datatransport.runtime.dagger.internal;

public final class Type<T>
  implements b<T>
{
  private static final c<java.lang.Object> GRIDSET = new Type(null);
  private final T a;
  
  private Type(java.lang.Object paramObject)
  {
    a = paramObject;
  }
  
  public static Object a(java.lang.Object paramObject)
  {
    return new Type(ByteVector.get(paramObject, "instance cannot be null"));
  }
  
  public java.lang.Object get()
  {
    return a;
  }
}
