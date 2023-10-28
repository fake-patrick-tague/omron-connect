package com.google.android.datatransport.runtime.firebase.transport;

import java.util.List;

public final class Label
{
  private static final Label i = new HttpMediaType().build();
  private final String b;
  private final List<LogEventDropped> f;
  
  Label(String paramString, List paramList)
  {
    b = paramString;
    f = paramList;
  }
  
  public static HttpMediaType getType()
  {
    return new HttpMediaType();
  }
  
  public List a()
  {
    return f;
  }
  
  public String b()
  {
    return b;
  }
}
