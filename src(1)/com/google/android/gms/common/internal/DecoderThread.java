package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.Util;
import java.util.HashMap;
import java.util.concurrent.Executor;

final class DecoderThread
  extends GmsClientSupervisor
{
  private final Context LOCK;
  private final SnackbarManager.1 TAG;
  private volatile Handler handler;
  private final long length;
  private final ConnectionTracker mContext;
  private final HashMap this$0 = new HashMap();
  private final long thread;
  
  DecoderThread(Context paramContext, Looper paramLooper)
  {
    SnackbarManager.1 local1 = new SnackbarManager.1(this, null);
    TAG = local1;
    LOCK = paramContext.getApplicationContext();
    handler = new Util(paramLooper, local1);
    mContext = ConnectionTracker.getInstance();
    thread = 5000L;
    length = 300000L;
  }
  
  final void start(Looper paramLooper)
  {
    HashMap localHashMap = this$0;
    try
    {
      handler = new Util(paramLooper, TAG);
      return;
    }
    catch (Throwable paramLooper)
    {
      throw paramLooper;
    }
  }
  
  protected final void start(Node paramNode, ServiceConnection paramServiceConnection, String paramString)
  {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    HashMap localHashMap = this$0;
    try
    {
      AbstractBackendHelper localAbstractBackendHelper = (AbstractBackendHelper)this$0.get(paramNode);
      if (localAbstractBackendHelper != null)
      {
        if (localAbstractBackendHelper.bind(paramServiceConnection))
        {
          localAbstractBackendHelper.bind(paramServiceConnection, paramString);
          if (localAbstractBackendHelper.close())
          {
            paramNode = handler.obtainMessage(0, paramNode);
            handler.sendMessageDelayed(paramNode, thread);
          }
          return;
        }
        paramNode = paramNode.toString();
        paramServiceConnection = new StringBuilder();
        paramServiceConnection.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
        paramServiceConnection.append(paramNode);
        throw new IllegalStateException(paramServiceConnection.toString());
      }
      paramNode = paramNode.toString();
      paramServiceConnection = new StringBuilder();
      paramServiceConnection.append("Nonexistent connection status for service config: ");
      paramServiceConnection.append(paramNode);
      throw new IllegalStateException(paramServiceConnection.toString());
    }
    catch (Throwable paramNode)
    {
      throw paramNode;
    }
  }
  
  protected final boolean start(Node paramNode, ServiceConnection paramServiceConnection, String paramString, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    HashMap localHashMap = this$0;
    try
    {
      AbstractBackendHelper localAbstractBackendHelper = (AbstractBackendHelper)this$0.get(paramNode);
      if (localAbstractBackendHelper == null)
      {
        localAbstractBackendHelper = new AbstractBackendHelper(this, paramNode);
        localAbstractBackendHelper.bind(paramServiceConnection, paramServiceConnection, paramString);
        localAbstractBackendHelper.start(paramString, paramExecutor);
        this$0.put(paramNode, localAbstractBackendHelper);
        paramNode = localAbstractBackendHelper;
      }
      else
      {
        handler.removeMessages(0, paramNode);
        if (localAbstractBackendHelper.bind(paramServiceConnection)) {
          break label174;
        }
        localAbstractBackendHelper.bind(paramServiceConnection, paramServiceConnection, paramString);
        int i = localAbstractBackendHelper.get();
        if (i != 1)
        {
          if (i != 2)
          {
            paramNode = localAbstractBackendHelper;
          }
          else
          {
            localAbstractBackendHelper.start(paramString, paramExecutor);
            paramNode = localAbstractBackendHelper;
          }
        }
        else
        {
          paramServiceConnection.onServiceConnected(localAbstractBackendHelper.getService(), localAbstractBackendHelper.onServiceConnected());
          paramNode = localAbstractBackendHelper;
        }
      }
      boolean bool = paramNode.bind();
      return bool;
      label174:
      paramNode = paramNode.toString();
      paramServiceConnection = new StringBuilder();
      paramServiceConnection.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
      paramServiceConnection.append(paramNode);
      throw new IllegalStateException(paramServiceConnection.toString());
    }
    catch (Throwable paramNode)
    {
      throw paramNode;
    }
  }
}
