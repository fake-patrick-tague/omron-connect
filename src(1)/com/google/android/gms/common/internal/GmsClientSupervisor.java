package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;

@KeepForSdk
public abstract class GmsClientSupervisor
{
  private static DecoderThread INSTANCE;
  private static int ServerError;
  @VisibleForTesting
  static HandlerThread mHandlerThread;
  private static final Object sync = new Object();
  private static boolean terminal;
  
  public GmsClientSupervisor() {}
  
  public static int getDefaultBindFlags()
  {
    return ServerError;
  }
  
  public static GmsClientSupervisor getInstance(Context paramContext)
  {
    Object localObject = sync;
    try
    {
      if (INSTANCE == null)
      {
        Context localContext = paramContext.getApplicationContext();
        if (terminal) {
          paramContext = getOrStartHandlerThread().getLooper();
        } else {
          paramContext = paramContext.getMainLooper();
        }
        INSTANCE = new DecoderThread(localContext, paramContext);
      }
      return INSTANCE;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static HandlerThread getOrStartHandlerThread()
  {
    Object localObject = sync;
    try
    {
      HandlerThread localHandlerThread = mHandlerThread;
      if (localHandlerThread != null) {
        return localHandlerThread;
      }
      localHandlerThread = new HandlerThread("GoogleApiHandler", 9);
      mHandlerThread = localHandlerThread;
      localHandlerThread.start();
      localHandlerThread = mHandlerThread;
      return localHandlerThread;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static void setUseHandlerThreadForCallbacks()
  {
    Object localObject = sync;
    try
    {
      DecoderThread localDecoderThread = INSTANCE;
      if ((localDecoderThread != null) && (!terminal)) {
        localDecoderThread.start(getOrStartHandlerThread().getLooper());
      }
      terminal = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void append(String paramString1, String paramString2, int paramInt, ServiceConnection paramServiceConnection, String paramString3, boolean paramBoolean)
  {
    start(new Node(paramString1, paramString2, paramInt, paramBoolean), paramServiceConnection, paramString3);
  }
  
  public boolean bindService(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return start(new Node(paramComponentName, getDefaultBindFlags()), paramServiceConnection, paramString, null);
  }
  
  public boolean bindService(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    return start(new Node(paramString1, getDefaultBindFlags(), false), paramServiceConnection, paramString2, null);
  }
  
  protected abstract void start(Node paramNode, ServiceConnection paramServiceConnection, String paramString);
  
  protected abstract boolean start(Node paramNode, ServiceConnection paramServiceConnection, String paramString, Executor paramExecutor);
  
  public void unbindService(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    start(new Node(paramComponentName, getDefaultBindFlags()), paramServiceConnection, paramString);
  }
  
  public void unbindService(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    start(new Node(paramString1, getDefaultBindFlags(), false), paramServiceConnection, paramString2);
  }
}
