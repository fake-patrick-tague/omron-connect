package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzjr
  implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener
{
  private volatile boolean connected;
  private volatile zzek socket;
  
  protected zzjr(zzjs paramZzjs) {}
  
  public final void close()
  {
    if ((socket != null) && ((socket.isConnected()) || (socket.isConnecting()))) {
      socket.disconnect();
    }
    socket = null;
  }
  
  public final void connect()
  {
    this$0.append();
    Context localContext = this$0.this$0.zzau();
    try
    {
      if (connected)
      {
        this$0.this$0.zzay().next().append("Connection attempt already in progress");
        return;
      }
      if ((socket != null) && ((socket.isConnecting()) || (socket.isConnected())))
      {
        this$0.this$0.zzay().next().append("Already awaiting connection attempt");
        return;
      }
      socket = new zzek(localContext, Looper.getMainLooper(), this, this);
      this$0.this$0.zzay().next().append("Connecting to remote service");
      connected = true;
      Preconditions.checkNotNull(socket);
      socket.checkAvailabilityAndConnect();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
    try
    {
      paramBundle = socket;
      Object localObject;
      socket = null;
    }
    catch (Throwable paramBundle)
    {
      try
      {
        Preconditions.checkNotNull(paramBundle);
        paramBundle = socket;
        paramBundle = paramBundle.getService();
        paramBundle = (zzee)paramBundle;
        localObject = this$0.this$0;
        localObject = ((zzfy)localObject).zzaz();
        ((zzfv)localObject).append(new zzjo(this, paramBundle));
      }
      catch (DeadObjectException paramBundle)
      {
        for (;;) {}
      }
      catch (IllegalStateException paramBundle)
      {
        for (;;) {}
      }
      paramBundle = paramBundle;
    }
    connected = false;
    return;
    throw paramBundle;
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
    zzeo localZzeo = this$0.this$0.unwrap();
    if (localZzeo != null) {
      localZzeo.hasNext().append("Service connection failed", paramConnectionResult);
    }
    try
    {
      connected = false;
      socket = null;
      this$0.this$0.zzaz().append(new zzjq(this));
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      throw paramConnectionResult;
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
    this$0.this$0.zzay().e().append("Service connection suspended");
    this$0.this$0.zzaz().append(new zzjp(this));
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a9 = a8\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
    this$0.this$0.zzay().e().append("Service disconnected");
    this$0.this$0.zzaz().append(new zzjn(this, paramComponentName));
  }
  
  public final void sendUpdate(Intent paramIntent)
  {
    this$0.append();
    Context localContext = this$0.this$0.zzau();
    ConnectionTracker localConnectionTracker = ConnectionTracker.getInstance();
    try
    {
      if (connected)
      {
        this$0.this$0.zzay().next().append("Connection attempt already in progress");
        return;
      }
      this$0.this$0.zzay().next().append("Using local app measurement service");
      connected = true;
      localConnectionTracker.bindService(localContext, paramIntent, zzjs.access$getMConnection(this$0), 129);
      return;
    }
    catch (Throwable paramIntent)
    {
      throw paramIntent;
    }
  }
}
