package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Objects;
import java.util.Set;

final class Frame
  extends SchedulerConfig.b.a
{
  private Long a;
  private Long d;
  private Set<SchedulerConfig.Flag> g;
  
  Frame() {}
  
  public SchedulerConfig.b.a a(long paramLong)
  {
    d = Long.valueOf(paramLong);
    return this;
  }
  
  public SchedulerConfig.b.a a(Set paramSet)
  {
    Objects.requireNonNull(paramSet, "Null flags");
    g = paramSet;
    return this;
  }
  
  public SchedulerConfig.b a()
  {
    Object localObject2 = d;
    Object localObject1 = "";
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(" delta");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (a == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" maxAllowedDelay");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (g == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" flags");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (((String)localObject1).isEmpty()) {
      return new Label(d.longValue(), a.longValue(), g, null);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Missing required properties:");
    ((StringBuilder)localObject2).append((String)localObject1);
    throw new IllegalStateException(((StringBuilder)localObject2).toString());
  }
  
  public SchedulerConfig.b.a b(long paramLong)
  {
    a = Long.valueOf(paramLong);
    return this;
  }
}
