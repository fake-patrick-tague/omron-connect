package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
public abstract class Buffer
{
  protected Buffer() {}
  
  public static Buffer read(char paramChar)
  {
    return new Source(paramChar);
  }
  
  public abstract boolean equals(char paramChar);
}
