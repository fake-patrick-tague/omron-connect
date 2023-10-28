package com.google.android.gms.internal.common;

final class Token
  extends Member
{
  static final Token next = new Token();
  
  private Token()
  {
    super("CharMatcher.none()");
  }
  
  public final boolean equals(char paramChar)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
}
