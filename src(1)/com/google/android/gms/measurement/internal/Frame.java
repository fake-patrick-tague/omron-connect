package com.google.android.gms.measurement.internal;

import android.os.BaseBundle;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import v7.util.ArrayMap;

public final class Frame
  extends RealmObject
{
  private final Map c = new ArrayMap();
  private long h;
  private final Map m = new ArrayMap();
  
  public Frame(zzfy paramZzfy)
  {
    super(paramZzfy);
  }
  
  private final void a(long paramLong)
  {
    Iterator localIterator = c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      c.put(str, Long.valueOf(paramLong));
    }
    if (!c.isEmpty()) {
      h = paramLong;
    }
  }
  
  private final void copy(long paramLong, zzik paramZzik)
  {
    if (paramZzik == null)
    {
      this$0.zzay().next().append("Not logging ad exposure. No active activity");
      return;
    }
    if (paramLong < 1000L)
    {
      this$0.zzay().next().append("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("_xt", paramLong);
    zzlh.add(paramZzik, localBundle, true);
    this$0.add().put("am", "_xa", localBundle);
  }
  
  private final void set(String paramString, long paramLong, zzik paramZzik)
  {
    if (paramZzik == null)
    {
      this$0.zzay().next().append("Not logging ad unit exposure. No active activity");
      return;
    }
    if (paramLong < 1000L)
    {
      this$0.zzay().next().append("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_ai", paramString);
    localBundle.putLong("_xt", paramLong);
    zzlh.add(paramZzik, localBundle, true);
    this$0.add().put("am", "_xu", localBundle);
  }
  
  public final void b(String paramString, long paramLong)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      this$0.zzaz().append(new PluginManager.1(this, paramString, paramLong));
      return;
    }
    this$0.zzay().iterator().append("Ad unit id must be a non-empty string");
  }
  
  public final void c(String paramString, long paramLong)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      this$0.zzaz().append(new b(this, paramString, paramLong));
      return;
    }
    this$0.zzay().iterator().append("Ad unit id must be a non-empty string");
  }
  
  public final void execute(long paramLong)
  {
    zzik localZzik = this$0.d().get(false);
    Iterator localIterator = c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      set(str, paramLong - ((Long)c.get(str)).longValue(), localZzik);
    }
    if (!c.isEmpty()) {
      copy(paramLong - h, localZzik);
    }
    a(paramLong);
  }
}
