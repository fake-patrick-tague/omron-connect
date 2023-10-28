package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.asm.asm.Label;
import java.util.Map;
import java.util.Objects;

final class Handle
  extends SchedulerConfig
{
  private final Label b;
  private final Map<Priority, SchedulerConfig.b> c;
  
  Handle(Label paramLabel, Map paramMap)
  {
    Objects.requireNonNull(paramLabel, "Null clock");
    b = paramLabel;
    Objects.requireNonNull(paramMap, "Null values");
    c = paramMap;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof SchedulerConfig))
    {
      paramObject = (SchedulerConfig)paramObject;
      if ((b.equals(paramObject.getOwner())) && (c.equals(paramObject.getName()))) {
        return true;
      }
    }
    return false;
  }
  
  Map getName()
  {
    return c;
  }
  
  Label getOwner()
  {
    return b;
  }
  
  public int hashCode()
  {
    return (b.hashCode() ^ 0xF4243) * 1000003 ^ c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SchedulerConfig{clock=");
    localStringBuilder.append(b);
    localStringBuilder.append(", values=");
    localStringBuilder.append(c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
