package com.google.android.gms.internal.measurement;

final class zzig
  extends zzif
{
  private final Object text;
  
  zzig(Object paramObject)
  {
    text = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof zzig))
    {
      paramObject = (zzig)paramObject;
      return text.equals(text);
    }
    return false;
  }
  
  public final Object get()
  {
    return text;
  }
  
  public final int hashCode()
  {
    return text.hashCode() + 1502476572;
  }
  
  public final boolean isEmpty()
  {
    return true;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Optional.of(");
    localStringBuilder.append(text);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}
