package com.google.android.gms.common.package_12.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Api.AbstractClientBuilder;
import com.google.android.gms.common.package_12.Api.Client;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.internal.base.Logger;
import com.google.android.gms.internal.base.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;

final class zaaa
  implements zaca
{
  private Bundle args;
  private final Api.Client b;
  private final Set<com.google.android.gms.common.api.internal.SignInConnectionListener> c = Collections.newSetFromMap(new WeakHashMap());
  private final Map<com.google.android.gms.common.api.Api.AnyClientKey<?>, com.google.android.gms.common.api.internal.zabi> context;
  private boolean f = false;
  private int i = 0;
  private final Lock lock;
  private ConnectionResult p = null;
  private final zabe q;
  private final Context r;
  private final Looper random;
  private ConnectionResult s = null;
  private final zabi state;
  private final zabi this$0;
  
  private zaaa(Context paramContext, zabe paramZabe, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map paramMap1, Map paramMap2, ClientSettings paramClientSettings, Api.AbstractClientBuilder paramAbstractClientBuilder, Api.Client paramClient, ArrayList paramArrayList1, ArrayList paramArrayList2, Map paramMap3, Map paramMap4)
  {
    r = paramContext;
    q = paramZabe;
    lock = paramLock;
    random = paramLooper;
    b = paramClient;
    this$0 = new zabi(paramContext, paramZabe, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap2, null, paramMap4, null, paramArrayList2, new MainActivity.21(this, null));
    state = new zabi(paramContext, paramZabe, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap1, paramClientSettings, paramMap3, paramAbstractClientBuilder, paramArrayList1, new TaskListFragment.7(this, null));
    paramContext = new ArrayMap();
    paramZabe = paramMap2.keySet().iterator();
    while (paramZabe.hasNext()) {
      paramContext.put((com.google.android.gms.common.package_12.Api.AnyClientKey)paramZabe.next(), this$0);
    }
    paramZabe = paramMap1.keySet().iterator();
    while (paramZabe.hasNext()) {
      paramContext.put((com.google.android.gms.common.package_12.Api.AnyClientKey)paramZabe.next(), state);
    }
    context = Collections.unmodifiableMap(paramContext);
  }
  
  private final void a(ConnectionResult paramConnectionResult)
  {
    int j = i;
    if (j != 1)
    {
      if (j != 2) {
        Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
      } else {
        q.run(paramConnectionResult);
      }
    }
    else {
      execute();
    }
    i = 0;
  }
  
  private final PendingIntent add()
  {
    if (b == null) {
      return null;
    }
    return f.a(r, System.identityHashCode(q), b.getSignInIntent(), f.c | 0x8000000);
  }
  
  public static zaaa add(Context paramContext, zabe paramZabe, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map paramMap1, ClientSettings paramClientSettings, Map paramMap2, Api.AbstractClientBuilder paramAbstractClientBuilder, ArrayList paramArrayList)
  {
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject2 = paramMap1.entrySet().iterator();
    paramMap1 = null;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (Api.Client)((Map.Entry)localObject3).getValue();
      if (true == ((Api.Client)localObject1).providesSignIn()) {
        paramMap1 = (Map)localObject1;
      }
      if (((Api.Client)localObject1).requiresSignIn()) {
        localArrayMap1.put((com.google.android.gms.common.package_12.Api.AnyClientKey)((Map.Entry)localObject3).getKey(), localObject1);
      } else {
        localArrayMap2.put((com.google.android.gms.common.package_12.Api.AnyClientKey)((Map.Entry)localObject3).getKey(), localObject1);
      }
    }
    Preconditions.checkState(localArrayMap1.isEmpty() ^ true, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
    Object localObject1 = new ArrayMap();
    localObject2 = new ArrayMap();
    Object localObject3 = paramMap2.keySet().iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Attribute)((Iterator)localObject3).next();
      com.google.android.gms.common.package_12.Api.AnyClientKey localAnyClientKey = ((Attribute)localObject4).getKey();
      if (localArrayMap1.containsKey(localAnyClientKey)) {
        ((Map)localObject1).put(localObject4, (Boolean)paramMap2.get(localObject4));
      } else if (localArrayMap2.containsKey(localAnyClientKey)) {
        ((Map)localObject2).put(localObject4, (Boolean)paramMap2.get(localObject4));
      } else {
        throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
      }
    }
    paramMap2 = new ArrayList();
    localObject3 = new ArrayList();
    int k = paramArrayList.size();
    int j = 0;
    while (j < k)
    {
      localObject4 = (MediaBrowserCompat.ConnectionCallback)paramArrayList.get(j);
      if (((Map)localObject1).containsKey(this$0))
      {
        paramMap2.add(localObject4);
      }
      else
      {
        if (!((Map)localObject2).containsKey(this$0)) {
          break label408;
        }
        ((ArrayList)localObject3).add(localObject4);
      }
      j += 1;
      continue;
      label408:
      throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
    }
    return new zaaa(paramContext, paramZabe, paramLock, paramLooper, paramGoogleApiAvailabilityLight, localArrayMap1, localArrayMap2, paramClientSettings, paramAbstractClientBuilder, paramMap1, paramMap2, (ArrayList)localObject3, (Map)localObject1, (Map)localObject2);
  }
  
  private static boolean equals(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.isSuccess());
  }
  
  private final void execute()
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((SignInConnectionListener)localIterator.next()).onComplete();
    }
    c.clear();
  }
  
  private final boolean get()
  {
    ConnectionResult localConnectionResult = p;
    return (localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4);
  }
  
  private final boolean get(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    paramApiMethodImpl = paramApiMethodImpl.getClientKey();
    paramApiMethodImpl = (zabi)context.get(paramApiMethodImpl);
    Preconditions.checkNotNull(paramApiMethodImpl, "GoogleApiClient is not configured to use the API required for this call.");
    return paramApiMethodImpl.equals(state);
  }
  
  public final void connect()
  {
    lock.lock();
    try
    {
      boolean bool = remove();
      state.reset();
      p = new ConnectionResult(4);
      if (bool) {
        new Logger(random).post(new Local.1(this));
      } else {
        execute();
      }
      lock.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  public final ConnectionResult doInBackground()
  {
    throw new UnsupportedOperationException();
  }
  
  public final BaseImplementation.ApiMethodImpl enqueue(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    if (get(paramApiMethodImpl))
    {
      if (get())
      {
        paramApiMethodImpl.setFailedResult(new Status(4, null, add()));
        return paramApiMethodImpl;
      }
      state.enqueue(paramApiMethodImpl);
      return paramApiMethodImpl;
    }
    this$0.enqueue(paramApiMethodImpl);
    return paramApiMethodImpl;
  }
  
  public final ConnectionResult execute(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean isEmpty()
  {
    lock.lock();
    try
    {
      boolean bool3 = this$0.isEmpty();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = state.isEmpty();
        if (!bool1)
        {
          bool1 = get();
          if (!bool1)
          {
            int j = i;
            bool1 = bool2;
            if (j != 1) {
              break label62;
            }
          }
        }
        bool1 = true;
      }
      label62:
      lock.unlock();
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  public final void next()
  {
    i = 2;
    f = false;
    p = null;
    s = null;
    this$0.next();
    state.next();
  }
  
  public final ConnectionResult put(Attribute paramAttribute)
  {
    if (Objects.equal(context.get(paramAttribute.getKey()), state))
    {
      if (get()) {
        return new ConnectionResult(4, add());
      }
      return state.put(paramAttribute);
    }
    return this$0.put(paramAttribute);
  }
  
  public final BaseImplementation.ApiMethodImpl read(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    if (get(paramApiMethodImpl))
    {
      if (get())
      {
        paramApiMethodImpl.setFailedResult(new Status(4, null, add()));
        return paramApiMethodImpl;
      }
      return state.read(paramApiMethodImpl);
    }
    return this$0.read(paramApiMethodImpl);
  }
  
  public final boolean remove()
  {
    lock.lock();
    try
    {
      int j = i;
      boolean bool;
      if (j == 2) {
        bool = true;
      } else {
        bool = false;
      }
      lock.unlock();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  public final boolean remove(SignInConnectionListener paramSignInConnectionListener)
  {
    lock.lock();
    try
    {
      boolean bool = remove();
      if (!bool)
      {
        bool = isEmpty();
        if (!bool) {}
      }
      else
      {
        bool = state.isEmpty();
        if (!bool)
        {
          c.add(paramSignInConnectionListener);
          int j = i;
          if (j == 0) {
            i = 1;
          }
          p = null;
          state.next();
          lock.unlock();
          return true;
        }
      }
      lock.unlock();
      return false;
    }
    catch (Throwable paramSignInConnectionListener)
    {
      lock.unlock();
      throw paramSignInConnectionListener;
    }
  }
  
  public final void reset()
  {
    p = null;
    s = null;
    i = 0;
    this$0.reset();
    state.reset();
    execute();
  }
  
  public final void set()
  {
    this$0.set();
    state.set();
  }
  
  public final void write(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    state.write(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this$0.write(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
}
