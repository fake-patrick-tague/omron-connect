package com.google.android.gms.common.package_12.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zabi
  implements zaca, BlockingQueue
{
  final zabe context;
  final Map<Api.AnyClientKey<?>, com.google.android.gms.common.api.Api.Client> delegate;
  final Map<Api.AnyClientKey<?>, ConnectionResult> items = new HashMap();
  private final GoogleApiAvailabilityLight key;
  private final Lock lock;
  private final zabh mHandler;
  final Map<Api<?>, Boolean> map;
  int next;
  private final Context parent;
  final ClientSettings queue;
  final zabz r;
  private final Condition ready;
  final com.google.android.gms.common.api.Api.AbstractClientBuilder<? extends zae, SignInOptions> size;
  @NotOnlyInitialized
  private volatile zabf this$0;
  private ConnectionResult uri = null;
  
  public zabi(Context paramContext, zabe paramZabe, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map paramMap1, ClientSettings paramClientSettings, Map paramMap2, com.google.android.gms.common.package_12.Api.AbstractClientBuilder paramAbstractClientBuilder, ArrayList paramArrayList, zabz paramZabz)
  {
    parent = paramContext;
    lock = paramLock;
    key = paramGoogleApiAvailabilityLight;
    delegate = paramMap1;
    queue = paramClientSettings;
    map = paramMap2;
    size = paramAbstractClientBuilder;
    context = paramZabe;
    r = paramZabz;
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((MediaBrowserCompat.ConnectionCallback)paramArrayList.get(i)).setInternalConnectionCallback(this);
      i += 1;
    }
    mHandler = new zabh(this, paramLooper);
    ready = paramLock.newCondition();
    this$0 = new zaax(this);
  }
  
  final void clear()
  {
    lock.lock();
    try
    {
      this$0 = new zaaw(this, queue, map, key, size, lock, parent);
      this$0.execute();
      ready.signalAll();
      lock.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  final void clear(ConnectionResult paramConnectionResult)
  {
    lock.lock();
    try
    {
      uri = paramConnectionResult;
      this$0 = new zaax(this);
      this$0.execute();
      ready.signalAll();
      lock.unlock();
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      lock.unlock();
      throw paramConnectionResult;
    }
  }
  
  final void clear(zabg paramZabg)
  {
    paramZabg = mHandler.obtainMessage(1, paramZabg);
    mHandler.sendMessage(paramZabg);
  }
  
  public final void connect() {}
  
  public final ConnectionResult doInBackground()
  {
    next();
    for (;;)
    {
      if (!(this$0 instanceof zaaw)) {
        break label45;
      }
      Object localObject = ready;
      try
      {
        ((Condition)localObject).await();
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
    Thread.currentThread().interrupt();
    return new ConnectionResult(15, null);
    label45:
    if ((this$0 instanceof zaaj)) {
      return ConnectionResult.RESULT_SUCCESS;
    }
    localObject = uri;
    if (localObject != null) {
      return localObject;
    }
    return new ConnectionResult(13, null);
  }
  
  public final BaseImplementation.ApiMethodImpl enqueue(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    paramApiMethodImpl.call();
    this$0.pollQueue(paramApiMethodImpl);
    return paramApiMethodImpl;
  }
  
  public final ConnectionResult execute(long paramLong, TimeUnit paramTimeUnit)
  {
    next();
    for (paramLong = paramTimeUnit.toNanos(paramLong);; paramLong = paramTimeUnit.awaitNanos(paramLong))
    {
      if ((!(this$0 instanceof zaaw)) || (paramLong <= 0L)) {}
      try
      {
        reset();
        paramTimeUnit = new ConnectionResult(14, null);
        return paramTimeUnit;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;) {}
      }
      paramTimeUnit = ready;
    }
    Thread.currentThread().interrupt();
    return new ConnectionResult(15, null);
    if ((this$0 instanceof zaaj)) {
      return ConnectionResult.RESULT_SUCCESS;
    }
    paramTimeUnit = uri;
    if (paramTimeUnit != null) {
      return paramTimeUnit;
    }
    return new ConnectionResult(13, null);
  }
  
  public final boolean isEmpty()
  {
    return this$0 instanceof zaaj;
  }
  
  public final void next()
  {
    this$0.refreshAdapter();
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    lock.lock();
    try
    {
      this$0.update(paramBundle);
      lock.unlock();
      return;
    }
    catch (Throwable paramBundle)
    {
      lock.unlock();
      throw paramBundle;
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    lock.lock();
    try
    {
      this$0.add(paramInt);
      lock.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  final void onFutureDone(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = mHandler.obtainMessage(2, paramRuntimeException);
    mHandler.sendMessage(paramRuntimeException);
  }
  
  public final ConnectionResult put(Attribute paramAttribute)
  {
    paramAttribute = paramAttribute.getKey();
    if (delegate.containsKey(paramAttribute))
    {
      if (((com.google.android.gms.common.package_12.Api.Client)delegate.get(paramAttribute)).isConnected()) {
        return ConnectionResult.RESULT_SUCCESS;
      }
      if (items.containsKey(paramAttribute)) {
        return (ConnectionResult)items.get(paramAttribute);
      }
    }
    return null;
  }
  
  public final void put(ConnectionResult paramConnectionResult, Attribute paramAttribute, boolean paramBoolean)
  {
    lock.lock();
    try
    {
      this$0.write(paramConnectionResult, paramAttribute, paramBoolean);
      lock.unlock();
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      lock.unlock();
      throw paramConnectionResult;
    }
  }
  
  public final BaseImplementation.ApiMethodImpl read(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    paramApiMethodImpl.call();
    return this$0.add(paramApiMethodImpl);
  }
  
  public final boolean remove()
  {
    return this$0 instanceof zaaw;
  }
  
  public final boolean remove(SignInConnectionListener paramSignInConnectionListener)
  {
    return false;
  }
  
  public final void reset()
  {
    if (this$0.add()) {
      items.clear();
    }
  }
  
  public final void set()
  {
    if ((this$0 instanceof zaaj)) {
      ((zaaj)this$0).enable();
    }
  }
  
  final void wakeup()
  {
    lock.lock();
    try
    {
      context.release();
      this$0 = new zaaj(this);
      this$0.execute();
      ready.signalAll();
      lock.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  public final void write(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(this$0);
    Iterator localIterator = map.keySet().iterator();
    while (localIterator.hasNext())
    {
      Attribute localAttribute = (Attribute)localIterator.next();
      paramPrintWriter.append(paramString).append(localAttribute.get()).println(":");
      ((com.google.android.gms.common.package_12.Api.Client)Preconditions.checkNotNull((com.google.android.gms.common.package_12.Api.Client)delegate.get(localAttribute.getKey()))).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
}
