package com.google.android.gms.internal.common;

final class Source
  extends UriProperty
{
  private final char value;
  
  Source(char paramChar)
  {
    value = paramChar;
  }
  
  public final boolean equals(char paramChar)
  {
    return paramChar == value;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CharMatcher.is('");
    int j = value;
    char[] arrayOfChar = new char[6];
    char[] tmp28_26 = arrayOfChar;
    tmp28_26[0] = 92;
    char[] tmp33_28 = tmp28_26;
    tmp33_28[1] = 117;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[2] = 0;
    char[] tmp43_38 = tmp38_33;
    tmp43_38[3] = 0;
    char[] tmp48_43 = tmp43_38;
    tmp48_43[4] = 0;
    char[] tmp53_48 = tmp48_43;
    tmp53_48[5] = 0;
    tmp53_48;
    int i = 0;
    while (i < 4)
    {
      arrayOfChar[(5 - i)] = "0123456789ABCDEF".charAt(j & 0xF);
      j >>= 4;
      i += 1;
    }
    localStringBuilder.append(String.copyValueOf(arrayOfChar));
    localStringBuilder.append("')");
    return localStringBuilder.toString();
  }
}
