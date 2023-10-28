package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
public final class Workout
  extends Object
{
  public static boolean equals(java.lang.Object paramObject1, java.lang.Object paramObject2)
  {
    if (paramObject1 != paramObject2)
    {
      if (paramObject1 == null) {
        break label24;
      }
      if (!paramObject1.equals(paramObject2)) {
        return false;
      }
    }
    return true;
    label24:
    return false;
  }
}
