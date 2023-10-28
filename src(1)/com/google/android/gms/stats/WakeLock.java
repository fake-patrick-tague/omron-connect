package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.stats.FinalizableReferenceQueue;
import com.google.android.gms.internal.stats.RewriteCardinalityException;
import com.google.android.gms.internal.stats.SimpleWeather;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
@ShowFirstParty
public class WakeLock
{
  private static final long MAX_BACKOFF_MS = TimeUnit.DAYS.toMillis(366L);
  private static volatile Button filter = new Transport();
  private static final Object lock;
  private static volatile ScheduledExecutorService scheduledExecutor = null;
  private boolean $assertionsDisabled = true;
  private Future<?> a;
  private int b;
  private final String connection;
  private final Context context;
  private long e;
  private final ScheduledExecutorService executor;
  private int f = 0;
  private WorkSource factory;
  private AtomicInteger id = new AtomicInteger(0);
  private Clock log = DefaultClock.getInstance();
  private final PowerManager.WakeLock mWakeLock;
  FinalizableReferenceQueue queue;
  private final Map<String, zzc> this$0 = new HashMap();
  private final String user;
  private final Set<zze> v = new HashSet();
  private final Object wakeLock = new Object();
  
  static
  {
    lock = new Object();
  }
  
  public WakeLock(Context paramContext, int paramInt, String paramString)
  {
    Preconditions.checkNotNull(paramContext, "WakeLock: context must not be null");
    Preconditions.checkNotEmpty(paramString, "WakeLock: wakeLockName must not be empty");
    context = paramContext.getApplicationContext();
    user = paramString;
    queue = null;
    if (!"com.google.android.gms".equals(paramContext.getPackageName()))
    {
      localObject2 = String.valueOf(paramString);
      if (((String)localObject2).length() != 0) {
        localObject2 = "*gcore*:".concat((String)localObject2);
      } else {
        localObject2 = new String("*gcore*:");
      }
      connection = ((String)localObject2);
    }
    else
    {
      connection = paramString;
    }
    Object localObject2 = (PowerManager)paramContext.getSystemService("power");
    if (localObject2 == null)
    {
      paramContext = new StringBuilder(29);
      paramContext.append("expected a non-null reference", 0, 29);
      throw new RewriteCardinalityException(paramContext.toString());
    }
    paramString = ((PowerManager)localObject2).newWakeLock(paramInt, paramString);
    mWakeLock = paramString;
    if (WorkSourceUtil.hasWorkSourcePermission(paramContext))
    {
      if (Strings.isEmptyOrWhitespace(str)) {
        localObject1 = paramContext.getPackageName();
      }
      paramContext = WorkSourceUtil.fromPackage(paramContext, (String)localObject1);
      factory = paramContext;
      if (paramContext != null) {
        release(paramString, paramContext);
      }
    }
    paramString = scheduledExecutor;
    paramContext = paramString;
    if (paramString == null)
    {
      localObject1 = lock;
      try
      {
        paramString = scheduledExecutor;
        paramContext = paramString;
        if (paramString == null)
        {
          SimpleWeather.getForecastURL();
          paramString = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
          paramContext = paramString;
          scheduledExecutor = paramString;
        }
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
    executor = paramContext;
  }
  
  private final String get(String paramString)
  {
    if (($assertionsDisabled) && (!TextUtils.isEmpty(null))) {}
    return null;
  }
  
  private final void release(int paramInt)
  {
    Object localObject1 = wakeLock;
    try
    {
      if (!isHeld()) {
        return;
      }
      if ($assertionsDisabled)
      {
        paramInt = f - 1;
        f = paramInt;
        if (paramInt <= 0) {}
      }
      else
      {
        f = 0;
      }
      reset();
      Object localObject2 = this$0.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        nexta = 0;
      }
      this$0.clear();
      localObject2 = a;
      if (localObject2 != null)
      {
        ((Future)localObject2).cancel(false);
        a = null;
        e = 0L;
      }
      b = 0;
      boolean bool = mWakeLock.isHeld();
      if (bool)
      {
        try
        {
          mWakeLock.release();
          if (queue == null) {
            break label271;
          }
          queue = null;
        }
        catch (Throwable localThrowable1) {}catch (RuntimeException localRuntimeException)
        {
          if (localRuntimeException.getClass().equals(RuntimeException.class))
          {
            Log.e("WakeLock", String.valueOf(connection).concat(" failed to release!"), localRuntimeException);
            if (queue == null) {
              break label271;
            }
            queue = null;
            break label271;
          }
          throw localRuntimeException;
        }
        if (queue != null) {
          queue = null;
        }
        throw localRuntimeException;
      }
      else
      {
        Log.e("WakeLock", String.valueOf(connection).concat(" should be held!"));
      }
      label271:
      return;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
  }
  
  private static void release(PowerManager.WakeLock paramWakeLock, WorkSource paramWorkSource)
  {
    try
    {
      paramWakeLock.setWorkSource(paramWorkSource);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramWakeLock) {}catch (IllegalArgumentException paramWakeLock) {}
    Log.wtf("WakeLock", ((RuntimeException)paramWakeLock).toString());
  }
  
  private final void reset()
  {
    if (v.isEmpty()) {
      return;
    }
    Object localObject = new ArrayList(v);
    v.clear();
    if (((List)localObject).size() <= 0) {
      return;
    }
    localObject = (Lock)((List)localObject).get(0);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void acquire(long paramLong)
  {
    id.incrementAndGet();
    long l1 = MAX_BACKOFF_MS;
    long l2 = Long.MAX_VALUE;
    long l3 = Math.max(Math.min(Long.MAX_VALUE, l1), 1L);
    l1 = l3;
    if (paramLong > 0L) {
      l1 = Math.min(paramLong, l3);
    }
    Object localObject2 = wakeLock;
    try
    {
      if (!isHeld())
      {
        queue = FinalizableReferenceQueue.toString(false, null);
        mWakeLock.acquire();
        log.elapsedRealtime();
      }
      f += 1;
      b += 1;
      get(null);
      DiskCacheWriteLocker.WriteLock localWriteLock = (DiskCacheWriteLocker.WriteLock)this$0.get(null);
      Object localObject1 = localWriteLock;
      if (localWriteLock == null)
      {
        localObject1 = new DiskCacheWriteLocker.WriteLock(null);
        this$0.put(null, localObject1);
      }
      a += 1;
      l3 = log.elapsedRealtime();
      paramLong = l2;
      if (Long.MAX_VALUE - l3 > l1) {
        paramLong = l3 + l1;
      }
      if (paramLong > e)
      {
        e = paramLong;
        localObject1 = a;
        if (localObject1 != null) {
          ((Future)localObject1).cancel(false);
        }
        a = executor.schedule(new MonthByWeekFragment.2(this), l1, TimeUnit.MILLISECONDS);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean isHeld()
  {
    Object localObject = wakeLock;
    for (;;)
    {
      try
      {
        if (f > 0)
        {
          bool = true;
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  public void release()
  {
    if (id.decrementAndGet() < 0) {
      Log.e("WakeLock", String.valueOf(connection).concat(" release without a matched acquire!"));
    }
    Object localObject = wakeLock;
    try
    {
      get(null);
      if (this$0.containsKey(null))
      {
        DiskCacheWriteLocker.WriteLock localWriteLock = (DiskCacheWriteLocker.WriteLock)this$0.get(null);
        if (localWriteLock != null)
        {
          int i = a - 1;
          a = i;
          if (i == 0) {
            this$0.remove(null);
          }
        }
      }
      else
      {
        Log.w("WakeLock", String.valueOf(connection).concat(" counter does not exist"));
      }
      release(0);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void setReferenceCounted(boolean paramBoolean)
  {
    Object localObject = wakeLock;
    try
    {
      $assertionsDisabled = paramBoolean;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
