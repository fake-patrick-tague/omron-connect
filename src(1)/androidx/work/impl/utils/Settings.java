package androidx.work.impl.utils;

import androidx.work.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Settings
{
  private static final String id = Log.getInstance("WorkTimer");
  private final ScheduledExecutorService executor;
  private final ThreadFactory group;
  final Map<String, o.b> item_map;
  final Map<String, o.c> items;
  final Object lock;
  
  public Settings()
  {
    FifoPriorityThreadPoolExecutor.DefaultThreadFactory localDefaultThreadFactory = new FifoPriorityThreadPoolExecutor.DefaultThreadFactory(this);
    group = localDefaultThreadFactory;
    items = new HashMap();
    item_map = new HashMap();
    lock = new Object();
    executor = Executors.newSingleThreadScheduledExecutor(localDefaultThreadFactory);
  }
  
  public void get(String paramString)
  {
    Object localObject = lock;
    try
    {
      if ((MonthByWeekFragment.2)items.remove(paramString) != null)
      {
        Log.get().append(id, String.format("Stopping timer for %s", new Object[] { paramString }), new Throwable[0]);
        item_map.remove(paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void get(String paramString, long paramLong, OkHttpClient paramOkHttpClient)
  {
    Object localObject = lock;
    try
    {
      Log.get().append(id, String.format("Starting timer for %s", new Object[] { paramString }), new Throwable[0]);
      get(paramString);
      MonthByWeekFragment.2 local2 = new MonthByWeekFragment.2(this, paramString);
      items.put(paramString, local2);
      item_map.put(paramString, paramOkHttpClient);
      executor.schedule(local2, paramLong, TimeUnit.MILLISECONDS);
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void onDestroy()
  {
    if (!executor.isShutdown()) {
      executor.shutdownNow();
    }
  }
}
