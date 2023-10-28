package com.google.android.gms.internal.fitness;

public final class zzfj
{
  static Object[] add(Object[] paramArrayOfObject, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      checkElementNotNull(paramArrayOfObject[i], i);
      i += 1;
    }
    return paramArrayOfObject;
  }
  
  static Object checkElementNotNull(Object paramObject, int paramInt)
  {
    if (paramObject != null) {
      return paramObject;
    }
    paramObject = new StringBuilder(20);
    paramObject.append("at index ");
    paramObject.append(paramInt);
    throw new NullPointerException(paramObject.toString());
  }
}
