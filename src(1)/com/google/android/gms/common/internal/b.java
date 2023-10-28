package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.package_12.internal.ConnectionCallbacks;
import com.google.android.gms.common.package_12.internal.OnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class b
  implements Handler.Callback
{
  private final Object a = new Object();
  private final ArrayList<com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener> b = new ArrayList();
  private final ArrayList<com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks> c = new ArrayList();
  private final Handler h;
  private final AtomicInteger i = new AtomicInteger(0);
  @VisibleForTesting
  final ArrayList<com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks> l = new ArrayList();
  private volatile boolean s = false;
  @NotOnlyInitialized
  private final Channel this$0;
  private boolean w = false;
  
  public b(Looper paramLooper, Channel paramChannel)
  {
    this$0 = paramChannel;
    h = new Logger(paramLooper, this);
  }
  
  public final void a(int paramInt)
  {
    Preconditions.checkHandlerThread(h, "onUnintentionalDisconnection must only be called on the Handler thread");
    h.removeMessages(1);
    Object localObject1 = a;
    try
    {
      w = true;
      Object localObject2 = new ArrayList(c);
      int j = i.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
        if ((!s) || (i.get() != j)) {
          break;
        }
        if (c.contains(localConnectionCallbacks)) {
          localConnectionCallbacks.onConnectionSuspended(paramInt);
        }
      }
      l.clear();
      w = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    Preconditions.checkHandlerThread(h, "onConnectionFailure must only be called on the Handler thread");
    h.removeMessages(1);
    Object localObject1 = a;
    try
    {
      Object localObject2 = new ArrayList(b);
      int j = i.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener)((Iterator)localObject2).next();
        if ((s) && (i.get() == j))
        {
          if (b.contains(localOnConnectionFailedListener)) {
            localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
          }
        }
        else {
          return;
        }
      }
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      throw paramConnectionResult;
    }
  }
  
  public final void a(com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    Object localObject = a;
    try
    {
      if (b.contains(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        StringBuilder localStringBuilder = new StringBuilder(paramOnConnectionFailedListener.length() + 67);
        localStringBuilder.append("registerConnectionFailedListener(): listener ");
        localStringBuilder.append(paramOnConnectionFailedListener);
        localStringBuilder.append(" is already registered");
        Log.w("GmsClientEvents", localStringBuilder.toString());
      }
      else
      {
        b.add(paramOnConnectionFailedListener);
      }
      return;
    }
    catch (Throwable paramOnConnectionFailedListener)
    {
      throw paramOnConnectionFailedListener;
    }
  }
  
  public final void add(com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    Object localObject = a;
    try
    {
      if (!c.remove(paramConnectionCallbacks))
      {
        paramConnectionCallbacks = String.valueOf(paramConnectionCallbacks);
        StringBuilder localStringBuilder = new StringBuilder(paramConnectionCallbacks.length() + 52);
        localStringBuilder.append("unregisterConnectionCallbacks(): listener ");
        localStringBuilder.append(paramConnectionCallbacks);
        localStringBuilder.append(" not found");
        Log.w("GmsClientEvents", localStringBuilder.toString());
      }
      else if (w)
      {
        l.add(paramConnectionCallbacks);
      }
      return;
    }
    catch (Throwable paramConnectionCallbacks)
    {
      throw paramConnectionCallbacks;
    }
  }
  
  public final void close(com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    Object localObject = a;
    try
    {
      if (c.contains(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        StringBuilder localStringBuilder = new StringBuilder(str.length() + 62);
        localStringBuilder.append("registerConnectionCallbacks(): listener ");
        localStringBuilder.append(str);
        localStringBuilder.append(" is already registered");
        Log.w("GmsClientEvents", localStringBuilder.toString());
      }
      else
      {
        c.add(paramConnectionCallbacks);
      }
      if (this$0.isConnected())
      {
        localObject = h;
        ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1, paramConnectionCallbacks));
        return;
      }
    }
    catch (Throwable paramConnectionCallbacks)
    {
      throw paramConnectionCallbacks;
    }
  }
  
  public final void close(com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    Object localObject = a;
    try
    {
      if (!b.remove(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        StringBuilder localStringBuilder = new StringBuilder(paramOnConnectionFailedListener.length() + 57);
        localStringBuilder.append("unregisterConnectionFailedListener(): listener ");
        localStringBuilder.append(paramOnConnectionFailedListener);
        localStringBuilder.append(" not found");
        Log.w("GmsClientEvents", localStringBuilder.toString());
      }
      return;
    }
    catch (Throwable paramOnConnectionFailedListener)
    {
      throw paramOnConnectionFailedListener;
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    int j = what;
    if (j == 1)
    {
      com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks)obj;
      paramMessage = a;
      try
      {
        if ((s) && (this$0.isConnected()) && (c.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(null);
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    paramMessage = new StringBuilder(45);
    paramMessage.append("Don't know how to handle message: ");
    paramMessage.append(j);
    Exception localException = new Exception();
    Log.wtf("GmsClientEvents", paramMessage.toString(), localException);
    return false;
  }
  
  public final void onCreate()
  {
    s = true;
  }
  
  public final void run(Bundle paramBundle)
  {
    Preconditions.checkHandlerThread(h, "onConnectionSuccess must only be called on the Handler thread");
    Object localObject1 = a;
    try
    {
      Preconditions.checkState(w ^ true);
      h.removeMessages(1);
      w = true;
      Preconditions.checkState(l.isEmpty());
      Object localObject2 = new ArrayList(c);
      int j = i.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
        if ((!s) || (!this$0.isConnected()) || (i.get() != j)) {
          break;
        }
        if (!l.contains(localConnectionCallbacks)) {
          localConnectionCallbacks.onConnected(paramBundle);
        }
      }
      l.clear();
      w = false;
      return;
    }
    catch (Throwable paramBundle)
    {
      throw paramBundle;
    }
  }
  
  public final void write()
  {
    s = false;
    i.incrementAndGet();
  }
  
  public final boolean write(com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    Object localObject = a;
    try
    {
      boolean bool = c.contains(paramConnectionCallbacks);
      return bool;
    }
    catch (Throwable paramConnectionCallbacks)
    {
      throw paramConnectionCallbacks;
    }
  }
  
  public final boolean write(com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    Object localObject = a;
    try
    {
      boolean bool = b.contains(paramOnConnectionFailedListener);
      return bool;
    }
    catch (Throwable paramOnConnectionFailedListener)
    {
      throw paramOnConnectionFailedListener;
    }
  }
}
