package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
public final class Preconditions
{
  public static int add(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 >= 0) && (paramInt1 < paramInt2)) {
      return paramInt1;
    }
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0)
      {
        paramString = new StringBuilder();
        paramString.append("negative size: ");
        paramString.append(paramInt2);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = Integer.format("%s (%s) must be less than size (%s)", new Object[] { "index", java.lang.Integer.valueOf(paramInt1), java.lang.Integer.valueOf(paramInt2) });
    }
    else
    {
      paramString = Integer.format("%s (%s) must not be negative", new Object[] { "index", java.lang.Integer.valueOf(paramInt1) });
    }
    throw new IndexOutOfBoundsException(paramString);
  }
  
  private static String badPositionIndex(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 < 0) {
      return Integer.format("%s (%s) must not be negative", new Object[] { paramString, java.lang.Integer.valueOf(paramInt1) });
    }
    if (paramInt2 >= 0) {
      return Integer.format("%s (%s) must not be greater than size (%s)", new Object[] { paramString, java.lang.Integer.valueOf(paramInt1), java.lang.Integer.valueOf(paramInt2) });
    }
    paramString = new StringBuilder();
    paramString.append("negative size: ");
    paramString.append(paramInt2);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public static int checkPositionIndex(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2)) {
      return paramInt1;
    }
    throw new IndexOutOfBoundsException(badPositionIndex(paramInt1, paramInt2, "index"));
  }
  
  public static void checkPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 <= paramInt3)) {
      return;
    }
    String str;
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt3))
    {
      if ((paramInt2 >= 0) && (paramInt2 <= paramInt3)) {
        str = Integer.format("end index (%s) must not be less than start index (%s)", new Object[] { java.lang.Integer.valueOf(paramInt2), java.lang.Integer.valueOf(paramInt1) });
      } else {
        str = badPositionIndex(paramInt2, paramInt3, "end index");
      }
    }
    else {
      str = badPositionIndex(paramInt1, paramInt3, "start index");
    }
    throw new IndexOutOfBoundsException(str);
  }
}
