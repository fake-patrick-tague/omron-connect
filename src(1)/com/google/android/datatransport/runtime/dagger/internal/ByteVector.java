package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Objects;

public final class ByteVector
{
  public static void add(Object paramObject, Class paramClass)
  {
    if (paramObject != null) {
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append(paramClass.getCanonicalName());
    paramObject.append(" must be set");
    throw new IllegalStateException(paramObject.toString());
  }
  
  public static Object get(Object paramObject)
  {
    Objects.requireNonNull(paramObject);
    return paramObject;
  }
  
  public static Object get(Object paramObject, String paramString)
  {
    Objects.requireNonNull(paramObject, paramString);
    return paramObject;
  }
}
