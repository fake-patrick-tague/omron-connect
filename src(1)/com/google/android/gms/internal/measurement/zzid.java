package com.google.android.gms.internal.measurement;

final class zzid
  extends zzif
{
  static final zzid NEGATE = new zzid();
  
  private zzid() {}
  
  public final boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
  
  public final Object get()
  {
    throw new IllegalStateException("Optional.get() cannot be called on an absent value");
  }
  
  public final int hashCode()
  {
    return 2040732332;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public final String toString()
  {
    return "Optional.absent()";
  }
}
