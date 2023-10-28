package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Set;

final class Label
  extends SchedulerConfig.b
{
  private final long a;
  private final Set<SchedulerConfig.Flag> c;
  private final long d;
  
  private Label(long paramLong1, long paramLong2, Set paramSet)
  {
    d = paramLong1;
    a = paramLong2;
    c = paramSet;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof SchedulerConfig.b))
    {
      paramObject = (SchedulerConfig.b)paramObject;
      if ((d == paramObject.getStart()) && (a == paramObject.getFirst()) && (c.equals(paramObject.getName()))) {
        return true;
      }
    }
    return false;
  }
  
  long getFirst()
  {
    return a;
  }
  
  Set getName()
  {
    return c;
  }
  
  long getStart()
  {
    return d;
  }
  
  public int hashCode()
  {
    long l = d;
    int i = (int)(l ^ l >>> 32);
    l = a;
    return ((i ^ 0xF4243) * 1000003 ^ (int)(l >>> 32 ^ l)) * 1000003 ^ c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConfigValue{delta=");
    localStringBuilder.append(d);
    localStringBuilder.append(", maxAllowedDelay=");
    localStringBuilder.append(a);
    localStringBuilder.append(", flags=");
    localStringBuilder.append(c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
