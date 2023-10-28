package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.measurement.drm.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzfq;
import com.google.android.gms.measurement.internal.zzgy;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zzij;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzee
{
  private static volatile zzee path;
  private volatile zzcc count;
  private int modCount;
  private final AppMeasurementSdk ms;
  private final String name;
  private boolean post;
  private final List this$0;
  private final String thread;
  protected final ExecutorService threadPool;
  protected final Clock value;
  
  protected zzee(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if ((paramString1 != null) && (put(paramString2, paramString3))) {
      name = paramString1;
    } else {
      name = "FA";
    }
    value = DefaultClock.getInstance();
    zzbx.access$getSearchResultsAdapter();
    paramString1 = new zzdi(this);
    paramString1 = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), paramString1);
    int j = 1;
    paramString1.allowCoreThreadTimeOut(true);
    threadPool = Executors.unconfigurableExecutorService(paramString1);
    ms = new AppMeasurementSdk(this);
    this$0 = new ArrayList();
    try
    {
      paramString1 = zzij.put(paramContext, "google_app_id", zzfq.build(paramContext));
      if ((paramString1 != null) && (!initializeDatabase()))
      {
        thread = null;
        post = true;
        Log.w(name, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
        return;
      }
    }
    catch (IllegalStateException paramString1)
    {
      int i;
      for (;;) {}
    }
    if (!put(paramString2, paramString3))
    {
      thread = "fa";
      if ((paramString2 != null) && (paramString3 != null))
      {
        Log.v(name, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
      }
      else
      {
        if (paramString2 == null) {
          i = 1;
        } else {
          i = 0;
        }
        if (paramString3 != null) {
          j = 0;
        }
        if ((i ^ j) != 0) {
          Log.w(name, "Specified origin or custom app id is null. Both parameters will be ignored.");
        }
      }
    }
    else
    {
      thread = paramString2;
    }
    append(new zzcx(this, paramString2, paramString3, paramContext, paramBundle));
    paramContext = (Application)paramContext.getApplicationContext();
    if (paramContext == null)
    {
      Log.w(name, "Unable to register lifecycle notifications. Application null.");
      return;
    }
    paramContext.registerActivityLifecycleCallbacks(new zzed(this));
  }
  
  private final void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, Long paramLong)
  {
    append(new zzdr(this, paramLong, paramString1, paramString2, paramBundle, paramBoolean1, paramBoolean2));
  }
  
  private final void append(zzdt paramZzdt)
  {
    threadPool.execute(paramZzdt);
  }
  
  protected static final boolean initializeDatabase()
  {
    try
    {
      Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    return false;
  }
  
  private static final boolean put(String paramString1, String paramString2)
  {
    return (paramString2 != null) && (paramString1 != null) && (!initializeDatabase());
  }
  
  private final void sendMessage(Exception paramException, boolean paramBoolean1, boolean paramBoolean2)
  {
    post |= paramBoolean1;
    if (paramBoolean1)
    {
      Log.w(name, "Data collection startup failed. No data will be collected.", paramException);
      return;
    }
    if (paramBoolean2) {
      put(5, "Error with data collection. Data lost.", paramException, null, null);
    }
    Log.w(name, "Error with data collection. Data lost.", paramException);
  }
  
  public static zzee toString(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Preconditions.checkNotNull(paramContext);
    if (path == null) {
      try
      {
        if (path == null) {
          path = new zzee(paramContext, paramString1, paramString2, paramString3, paramBundle);
        }
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
    return path;
  }
  
  public final int a(String paramString)
  {
    zzbz localZzbz = new zzbz();
    append(new zzdj(this, paramString, localZzbz));
    paramString = (Integer)zzbz.get(localZzbz.get(10000L), Integer.class);
    if (paramString == null) {
      return 25;
    }
    return paramString.intValue();
  }
  
  public final String a()
  {
    zzbz localZzbz = new zzbz();
    append(new zzdb(this, localZzbz));
    return localZzbz.a(50L);
  }
  
  public final Map a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new zzbz();
    append(new zzdf(this, paramString1, paramString2, paramBoolean, (zzbz)localObject1));
    paramString1 = ((zzbz)localObject1).get(5000L);
    if ((paramString1 != null) && (paramString1.size() != 0))
    {
      paramString2 = new HashMap(paramString1.size());
      localObject1 = paramString1.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = paramString1.get(str);
        if (((localObject2 instanceof Double)) || ((localObject2 instanceof Long)) || ((localObject2 instanceof String))) {
          paramString2.put(str, localObject2);
        }
      }
      return paramString2;
    }
    return Collections.emptyMap();
  }
  
  public final void a(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    a(paramString1, paramString2, paramBundle, true, false, Long.valueOf(paramLong));
  }
  
  public final String b()
  {
    zzbz localZzbz = new zzbz();
    append(new zzdd(this, localZzbz));
    return localZzbz.a(500L);
  }
  
  public final void b(Activity paramActivity, String paramString1, String paramString2)
  {
    append(new zzcr(this, paramActivity, paramString1, paramString2));
  }
  
  public final void b(Bundle paramBundle)
  {
    append(new zzct(this, paramBundle));
  }
  
  public final void b(zzgy paramZzgy)
  {
    paramZzgy = new zzdu(paramZzgy);
    zzcc localZzcc;
    if (count != null) {
      localZzcc = count;
    }
    try
    {
      localZzcc.setEventInterceptor(paramZzgy);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    catch (BadParcelableException localBadParcelableException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    catch (NetworkOnMainThreadException localNetworkOnMainThreadException)
    {
      for (;;) {}
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;) {}
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;) {}
    }
    Log.w(name, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
    append(new zzdo(this, paramZzgy));
  }
  
  public final void b(Boolean paramBoolean)
  {
    append(new zzcs(this, paramBoolean));
  }
  
  public final void b(String paramString)
  {
    append(new zzcz(this, paramString));
  }
  
  public final void b(String paramString1, String paramString2, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramBundle, true, true, null);
  }
  
  public final void b(boolean paramBoolean)
  {
    append(new zzdm(this, paramBoolean));
  }
  
  public final String c()
  {
    zzbz localZzbz = new zzbz();
    append(new zzde(this, localZzbz));
    return localZzbz.a(500L);
  }
  
  public final void c(Bundle paramBundle)
  {
    append(new zzcn(this, paramBundle));
  }
  
  public final void c(String paramString)
  {
    append(new zzcy(this, paramString));
  }
  
  public final void c(String paramString1, String paramString2, Bundle paramBundle)
  {
    append(new zzco(this, paramString1, paramString2, paramBundle));
  }
  
  public final void clear(zzgz paramZzgz)
  {
    Preconditions.checkNotNull(paramZzgz);
    Object localObject = this$0;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this$0.size()) {
          break label195;
        }
        if (!paramZzgz.equals(this$0.get(i)).first)) {
          break label188;
        }
        paramZzgz = (Pair)this$0.get(i);
        if (paramZzgz == null)
        {
          Log.w(name, "OnEventListener had not been registered.");
          return;
        }
        this$0.remove(paramZzgz);
        paramZzgz = (zzdv)second;
        if (count != null) {
          localObject = count;
        }
      }
      catch (Throwable paramZzgz)
      {
        throw paramZzgz;
      }
      try
      {
        ((zzcc)localObject).unregisterOnMeasurementEventListener(paramZzgz);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        continue;
      }
      catch (BadParcelableException localBadParcelableException)
      {
        continue;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        continue;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        continue;
      }
      catch (NetworkOnMainThreadException localNetworkOnMainThreadException)
      {
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        continue;
      }
      catch (SecurityException localSecurityException)
      {
        continue;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        continue;
      }
      Log.w(name, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
      append(new zzdq(this, paramZzgz));
      return;
      label188:
      i += 1;
      continue;
      label195:
      paramZzgz = null;
    }
  }
  
  public final void connectionAccepted()
  {
    append(new zzcv(this));
  }
  
  public final void connectionAccepted(String paramString)
  {
    append(new zzcq(this, paramString));
  }
  
  public final String d()
  {
    zzbz localZzbz = new zzbz();
    append(new zzda(this, localZzbz));
    return localZzbz.a(500L);
  }
  
  public final void d(String paramString, Bundle paramBundle)
  {
    a(null, paramString, paramBundle, false, true, null);
  }
  
  public final Bundle get(Bundle paramBundle, boolean paramBoolean)
  {
    zzbz localZzbz = new zzbz();
    append(new zzdh(this, paramBundle, localZzbz));
    if (paramBoolean) {
      return localZzbz.get(5000L);
    }
    return null;
  }
  
  public final AppMeasurementSdk get()
  {
    return ms;
  }
  
  public final List get(String paramString1, String paramString2)
  {
    zzbz localZzbz = new zzbz();
    append(new zzcp(this, paramString1, paramString2, localZzbz));
    paramString2 = (List)zzbz.get(localZzbz.get(5000L), List.class);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = Collections.emptyList();
    }
    return paramString1;
  }
  
  public final String getElementType()
  {
    zzbz localZzbz = new zzbz();
    append(new zzdk(this, localZzbz));
    return localZzbz.a(120000L);
  }
  
  public final Object getIdentifier(int paramInt)
  {
    zzbz localZzbz = new zzbz();
    append(new zzdl(this, localZzbz, paramInt));
    return zzbz.get(localZzbz.get(15000L), Object.class);
  }
  
  public final String getThread()
  {
    return thread;
  }
  
  public final void loadFragment(Bundle paramBundle)
  {
    append(new zzcu(this, paramBundle));
  }
  
  public final long put()
  {
    Object localObject = new zzbz();
    append(new zzdc(this, (zzbz)localObject));
    localObject = (Long)zzbz.get(((zzbz)localObject).get(500L), Long.class);
    if (localObject == null)
    {
      long l = new Random(System.nanoTime() ^ value.currentTimeMillis()).nextLong();
      int i = modCount + 1;
      modCount = i;
      return l + i;
    }
    return ((Long)localObject).longValue();
  }
  
  public final void put(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    append(new zzdg(this, false, 5, paramString, paramObject1, null, null));
  }
  
  public final void put(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    append(new zzds(this, paramString1, paramString2, paramObject, paramBoolean));
  }
  
  public final void reSeedSecure(long paramLong)
  {
    append(new zzcw(this, paramLong));
  }
  
  protected final zzcc read(Context paramContext, boolean paramBoolean)
  {
    DynamiteModule.VersionPolicy localVersionPolicy = DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION;
    try
    {
      paramContext = zzcb.asInterface(DynamiteModule.load(paramContext, localVersionPolicy, "com.google.android.gms.measurement.dynamite").instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
      return paramContext;
    }
    catch (DynamiteModule.LoadingException paramContext)
    {
      sendMessage(paramContext, true, false);
    }
    return null;
  }
  
  public final void remove(zzgz paramZzgz)
  {
    Preconditions.checkNotNull(paramZzgz);
    localList = this$0;
    int i = 0;
    try
    {
      while (i < this$0.size())
      {
        if (paramZzgz.equals(this$0.get(i)).first))
        {
          Log.w(name, "OnEventListener already registered.");
          return;
        }
        i += 1;
      }
      localZzdv = new zzdv(paramZzgz);
      this$0.add(new Pair(paramZzgz, localZzdv));
      if (count != null) {
        paramZzgz = count;
      }
    }
    catch (Throwable paramZzgz)
    {
      zzdv localZzdv;
      label125:
      throw paramZzgz;
    }
    try
    {
      paramZzgz.registerOnMeasurementEventListener(localZzdv);
      return;
    }
    catch (RemoteException paramZzgz)
    {
      break label125;
    }
    catch (BadParcelableException paramZzgz)
    {
      break label125;
    }
    catch (IllegalArgumentException paramZzgz)
    {
      break label125;
    }
    catch (IllegalStateException paramZzgz)
    {
      break label125;
    }
    catch (NetworkOnMainThreadException paramZzgz)
    {
      break label125;
    }
    catch (NullPointerException paramZzgz)
    {
      break label125;
    }
    catch (SecurityException paramZzgz)
    {
      break label125;
    }
    catch (UnsupportedOperationException paramZzgz)
    {
      break label125;
    }
    Log.w(name, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
    append(new zzdp(this, localZzdv));
  }
  
  public final void switchState(Bundle paramBundle)
  {
    append(new zzdn(this, paramBundle));
  }
}
