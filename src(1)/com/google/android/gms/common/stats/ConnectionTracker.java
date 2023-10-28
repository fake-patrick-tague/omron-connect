package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

@KeepForSdk
public class ConnectionTracker
{
  private static volatile ConnectionTracker mInstance;
  private static final Object mLock = new Object();
  @VisibleForTesting
  public ConcurrentHashMap this$0 = new ConcurrentHashMap();
  
  private ConnectionTracker() {}
  
  private static final boolean bindService(Context paramContext, Intent paramIntent, android.content.ServiceConnection paramServiceConnection, int paramInt, Executor paramExecutor)
  {
    if ((PlatformVersion.isAtLeastQ()) && (paramExecutor != null)) {
      return paramContext.bindService(paramIntent, paramInt, paramExecutor, paramServiceConnection);
    }
    return paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public static ConnectionTracker getInstance()
  {
    if (mInstance == null)
    {
      localObject = mLock;
      try
      {
        if (mInstance == null) {
          mInstance = new ConnectionTracker();
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    Object localObject = mInstance;
    Preconditions.checkNotNull(localObject);
    return localObject;
  }
  
  private static boolean i(android.content.ServiceConnection paramServiceConnection)
  {
    return !(paramServiceConnection instanceof com.google.android.gms.common.internal.ServiceConnection);
  }
  
  private final boolean init(Context paramContext, String paramString, Intent paramIntent, android.content.ServiceConnection paramServiceConnection, int paramInt, boolean paramBoolean, Executor paramExecutor)
  {
    Object localObject = paramIntent.getComponent();
    if (localObject != null)
    {
      localObject = ((ComponentName)localObject).getPackageName();
      "com.google.android.gms".equals(localObject);
    }
    try
    {
      localObject = Wrappers.packageManager(paramContext).getApplicationInfo((String)localObject, 0);
      if ((flags & 0x200000) != 0)
      {
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    if (i(paramServiceConnection))
    {
      localObject = (android.content.ServiceConnection)this$0.putIfAbsent(paramServiceConnection, paramServiceConnection);
      if ((localObject != null) && (paramServiceConnection != localObject)) {
        Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", new Object[] { paramServiceConnection, paramString, paramIntent.getAction() }));
      }
      try
      {
        paramBoolean = bindService(paramContext, paramIntent, paramServiceConnection, paramInt, paramExecutor);
        if (paramBoolean) {
          return paramBoolean;
        }
        this$0.remove(paramServiceConnection, paramServiceConnection);
        return false;
      }
      catch (Throwable paramContext)
      {
        this$0.remove(paramServiceConnection, paramServiceConnection);
        throw paramContext;
      }
    }
    return bindService(paramContext, paramIntent, paramServiceConnection, paramInt, paramExecutor);
  }
  
  private static void unbind(Context paramContext, android.content.ServiceConnection paramServiceConnection)
  {
    try
    {
      paramContext.unbindService(paramServiceConnection);
      return;
    }
    catch (IllegalArgumentException paramContext) {}catch (IllegalStateException paramContext) {}catch (NoSuchElementException paramContext) {}
  }
  
  public boolean bindService(Context paramContext, Intent paramIntent, android.content.ServiceConnection paramServiceConnection, int paramInt)
  {
    return init(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt, true, null);
  }
  
  public final boolean get(Context paramContext, String paramString, Intent paramIntent, android.content.ServiceConnection paramServiceConnection, int paramInt, Executor paramExecutor)
  {
    return init(paramContext, paramString, paramIntent, paramServiceConnection, paramInt, true, paramExecutor);
  }
  
  public void unbindService(Context paramContext, android.content.ServiceConnection paramServiceConnection)
  {
    if ((i(paramServiceConnection)) && (this$0.containsKey(paramServiceConnection))) {
      try
      {
        unbind(paramContext, (android.content.ServiceConnection)this$0.get(paramServiceConnection));
        this$0.remove(paramServiceConnection);
        return;
      }
      catch (Throwable paramContext)
      {
        this$0.remove(paramServiceConnection);
        throw paramContext;
      }
    }
    unbind(paramContext, paramServiceConnection);
  }
  
  public void unbindServiceSafe(Context paramContext, android.content.ServiceConnection paramServiceConnection)
  {
    try
    {
      unbindService(paramContext, paramServiceConnection);
      return;
    }
    catch (IllegalArgumentException paramContext) {}
  }
}
