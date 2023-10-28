package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzah
{
  static Object[] add(Object[] paramArrayOfObject, int paramInt)
  {
    int i = 0;
    while (i < paramInt) {
      if (paramArrayOfObject[i] != null)
      {
        i += 1;
      }
      else
      {
        paramArrayOfObject = new StringBuilder();
        paramArrayOfObject.append("at index ");
        paramArrayOfObject.append(i);
        throw new NullPointerException(paramArrayOfObject.toString());
      }
    }
    return paramArrayOfObject;
  }
}
