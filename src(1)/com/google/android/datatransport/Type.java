package com.google.android.datatransport;

import java.util.Objects;

public final class Type
{
  private final String d;
  
  private Type(String paramString)
  {
    Objects.requireNonNull(paramString, "name is null");
    d = paramString;
  }
  
  public static Type valueOf(String paramString)
  {
    return new Type(paramString);
  }
  
  public String a()
  {
    return d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Type)) {
      return false;
    }
    return d.equals(d);
  }
  
  public int hashCode()
  {
    return d.hashCode() ^ 0xF4243;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Encoding{name=\"");
    localStringBuilder.append(d);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
}
