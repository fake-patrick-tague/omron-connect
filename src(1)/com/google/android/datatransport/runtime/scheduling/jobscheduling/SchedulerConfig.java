package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo.Builder;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.asm.asm.Label;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public abstract class SchedulerConfig
{
  public SchedulerConfig() {}
  
  static SchedulerConfig a(Label paramLabel, Map paramMap)
  {
    return new Handle(paramLabel, paramMap);
  }
  
  public static SchedulerConfig b(Label paramLabel)
  {
    return p().a(Priority.C, b.a().a(30000L).b(86400000L).a()).a(Priority.G, b.a().a(1000L).b(86400000L).a()).a(Priority.F, b.a().a(86400000L).b(86400000L).a(get(new Flag[] { Flag.h })).a()).a(paramLabel).a();
  }
  
  private long get(int paramInt, long paramLong)
  {
    paramInt -= 1;
    long l;
    if (paramLong > 1L) {
      l = paramLong;
    } else {
      l = 2L;
    }
    double d = Math.max(1.0D, Math.log(10000.0D) / Math.log(l * paramInt));
    return (Math.pow(3.0D, paramInt) * paramLong * d);
  }
  
  private static Set get(Object... paramVarArgs)
  {
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(paramVarArgs)));
  }
  
  public static a p()
  {
    return new a();
  }
  
  private void visitMethodInsn(JobInfo.Builder paramBuilder, Set paramSet)
  {
    if (paramSet.contains(Flag.P)) {
      paramBuilder.setRequiredNetworkType(2);
    } else {
      paramBuilder.setRequiredNetworkType(1);
    }
    if (paramSet.contains(Flag.b)) {
      paramBuilder.setRequiresCharging(true);
    }
    if (paramSet.contains(Flag.h)) {
      paramBuilder.setRequiresDeviceIdle(true);
    }
  }
  
  public JobInfo.Builder a(JobInfo.Builder paramBuilder, Priority paramPriority, long paramLong, int paramInt)
  {
    paramBuilder.setMinimumLatency(get(paramPriority, paramLong, paramInt));
    visitMethodInsn(paramBuilder, ((b)getName().get(paramPriority)).getName());
    return paramBuilder;
  }
  
  public long get(Priority paramPriority, long paramLong, int paramInt)
  {
    long l = getOwner().a();
    paramPriority = (b)getName().get(paramPriority);
    return Math.min(Math.max(get(paramInt, paramPriority.getStart()), paramLong - l), paramPriority.getFirst());
  }
  
  abstract Map getName();
  
  abstract Label getOwner();
  
  public static enum Flag
  {
    static
    {
      Flag localFlag1 = new Flag("NETWORK_UNMETERED", 0);
      P = localFlag1;
      Flag localFlag2 = new Flag("DEVICE_IDLE", 1);
      h = localFlag2;
      Flag localFlag3 = new Flag("DEVICE_CHARGING", 2);
      b = localFlag3;
      d = new Flag[] { localFlag1, localFlag2, localFlag3 };
    }
  }
  
  public static class a
  {
    private Label k;
    private Map<Priority, SchedulerConfig.b> m = new HashMap();
    
    public a() {}
    
    public a a(Priority paramPriority, SchedulerConfig.b paramB)
    {
      m.put(paramPriority, paramB);
      return this;
    }
    
    public a a(Label paramLabel)
    {
      k = paramLabel;
      return this;
    }
    
    public SchedulerConfig a()
    {
      Objects.requireNonNull(k, "missing required property: clock");
      if (m.keySet().size() >= Priority.values().length)
      {
        Map localMap = m;
        m = new HashMap();
        return SchedulerConfig.a(k, localMap);
      }
      throw new IllegalStateException("Not all priorities have been configured");
    }
  }
  
  public static abstract class b
  {
    public b() {}
    
    public static a a()
    {
      return new Frame().a(Collections.emptySet());
    }
    
    abstract long getFirst();
    
    abstract Set getName();
    
    abstract long getStart();
    
    public static abstract class a
    {
      public a() {}
      
      public abstract a a(long paramLong);
      
      public abstract a a(Set paramSet);
      
      public abstract SchedulerConfig.b a();
      
      public abstract a b(long paramLong);
    }
  }
}
