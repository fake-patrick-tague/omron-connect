package com.google.android.gms.internal.base;

public final class Target
{
  private static final Optional port;
  private static volatile Optional priority;
  
  static
  {
    AbbreviatedObjectId localAbbreviatedObjectId = new AbbreviatedObjectId(null);
    port = localAbbreviatedObjectId;
    priority = localAbbreviatedObjectId;
  }
  
  public static Optional getPriority()
  {
    return priority;
  }
}
