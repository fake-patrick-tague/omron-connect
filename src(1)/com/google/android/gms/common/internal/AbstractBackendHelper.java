package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class AbstractBackendHelper
  implements android.content.ServiceConnection, ServiceConnection
{
  private IBinder binder;
  private boolean bound;
  private final Map context;
  private ComponentName service;
  private int state;
  private final Node token;
  
  public AbstractBackendHelper(DecoderThread paramDecoderThread, Node paramNode)
  {
    token = paramNode;
    context = new HashMap();
    state = 2;
  }
  
  public final void bind(android.content.ServiceConnection paramServiceConnection1, android.content.ServiceConnection paramServiceConnection2, String paramString)
  {
    context.put(paramServiceConnection1, paramServiceConnection2);
  }
  
  public final void bind(android.content.ServiceConnection paramServiceConnection, String paramString)
  {
    context.remove(paramServiceConnection);
  }
  
  public final boolean bind()
  {
    return bound;
  }
  
  public final boolean bind(android.content.ServiceConnection paramServiceConnection)
  {
    return context.containsKey(paramServiceConnection);
  }
  
  public final boolean close()
  {
    return context.isEmpty();
  }
  
  public final int get()
  {
    return state;
  }
  
  public final ComponentName getService()
  {
    return service;
  }
  
  public final IBinder onServiceConnected()
  {
    return binder;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HashMap localHashMap = DecoderThread.access$getRunning(this$0);
    try
    {
      DecoderThread.access$getHandler(this$0).removeMessages(1, token);
      binder = paramIBinder;
      service = paramComponentName;
      Iterator localIterator = context.values().iterator();
      while (localIterator.hasNext()) {
        ((android.content.ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
      state = 1;
      return;
    }
    catch (Throwable paramComponentName)
    {
      throw paramComponentName;
    }
  }
  
  public final void onServiceConnected(String paramString)
  {
    DecoderThread.access$getHandler(this$0).removeMessages(1, token);
    paramString = this$0;
    DecoderThread.access$getMContext(paramString).unbindService(DecoderThread.access$getLOCK(paramString), this);
    bound = false;
    state = 2;
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    HashMap localHashMap = DecoderThread.access$getRunning(this$0);
    try
    {
      DecoderThread.access$getHandler(this$0).removeMessages(1, token);
      binder = null;
      service = paramComponentName;
      Iterator localIterator = context.values().iterator();
      while (localIterator.hasNext()) {
        ((android.content.ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
      state = 2;
      return;
    }
    catch (Throwable paramComponentName)
    {
      throw paramComponentName;
    }
  }
  
  /* Error */
  public final void start(String paramString, java.util.concurrent.Executor paramExecutor)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_3
    //   2: putfield 38	com/google/android/gms/common/internal/AbstractBackendHelper:state	I
    //   5: invokestatic 143	android/os/StrictMode:getVmPolicy	()Landroid/os/StrictMode$VmPolicy;
    //   8: astore 4
    //   10: invokestatic 148	com/google/android/gms/common/util/PlatformVersion:isAtLeastS	()Z
    //   13: ifeq +21 -> 34
    //   16: new 150	android/os/StrictMode$VmPolicy$Builder
    //   19: dup
    //   20: aload 4
    //   22: invokespecial 153	android/os/StrictMode$VmPolicy$Builder:<init>	(Landroid/os/StrictMode$VmPolicy;)V
    //   25: invokevirtual 157	android/os/StrictMode$VmPolicy$Builder:permitUnsafeIntentLaunch	()Landroid/os/StrictMode$VmPolicy$Builder;
    //   28: invokevirtual 160	android/os/StrictMode$VmPolicy$Builder:build	()Landroid/os/StrictMode$VmPolicy;
    //   31: invokestatic 163	android/os/StrictMode:setVmPolicy	(Landroid/os/StrictMode$VmPolicy;)V
    //   34: aload_0
    //   35: getfield 26	com/google/android/gms/common/internal/AbstractBackendHelper:this$0	Lcom/google/android/gms/common/internal/DecoderThread;
    //   38: astore 5
    //   40: aload 5
    //   42: invokestatic 119	com/google/android/gms/common/internal/DecoderThread:access$getMContext	(Lcom/google/android/gms/common/internal/DecoderThread;)Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   45: aload 5
    //   47: invokestatic 123	com/google/android/gms/common/internal/DecoderThread:access$getLOCK	(Lcom/google/android/gms/common/internal/DecoderThread;)Landroid/content/Context;
    //   50: aload_1
    //   51: aload_0
    //   52: getfield 31	com/google/android/gms/common/internal/AbstractBackendHelper:token	Lcom/google/android/gms/common/internal/Node;
    //   55: aload 5
    //   57: invokestatic 123	com/google/android/gms/common/internal/DecoderThread:access$getLOCK	(Lcom/google/android/gms/common/internal/DecoderThread;)Landroid/content/Context;
    //   60: invokevirtual 169	com/google/android/gms/common/internal/Node:execute	(Landroid/content/Context;)Landroid/content/Intent;
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 31	com/google/android/gms/common/internal/AbstractBackendHelper:token	Lcom/google/android/gms/common/internal/Node;
    //   68: invokevirtual 172	com/google/android/gms/common/internal/Node:getType	()I
    //   71: aload_2
    //   72: invokevirtual 175	com/google/android/gms/common/stats/ConnectionTracker:get	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/content/ServiceConnection;ILjava/util/concurrent/Executor;)Z
    //   75: istore_3
    //   76: aload_0
    //   77: iload_3
    //   78: putfield 55	com/google/android/gms/common/internal/AbstractBackendHelper:bound	Z
    //   81: iload_3
    //   82: ifeq +41 -> 123
    //   85: aload_0
    //   86: getfield 26	com/google/android/gms/common/internal/AbstractBackendHelper:this$0	Lcom/google/android/gms/common/internal/DecoderThread;
    //   89: invokestatic 87	com/google/android/gms/common/internal/DecoderThread:access$getHandler	(Lcom/google/android/gms/common/internal/DecoderThread;)Landroid/os/Handler;
    //   92: iconst_1
    //   93: aload_0
    //   94: getfield 31	com/google/android/gms/common/internal/AbstractBackendHelper:token	Lcom/google/android/gms/common/internal/Node;
    //   97: invokevirtual 179	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   100: astore_1
    //   101: aload_0
    //   102: getfield 26	com/google/android/gms/common/internal/AbstractBackendHelper:this$0	Lcom/google/android/gms/common/internal/DecoderThread;
    //   105: invokestatic 87	com/google/android/gms/common/internal/DecoderThread:access$getHandler	(Lcom/google/android/gms/common/internal/DecoderThread;)Landroid/os/Handler;
    //   108: aload_1
    //   109: aload_0
    //   110: getfield 26	com/google/android/gms/common/internal/AbstractBackendHelper:this$0	Lcom/google/android/gms/common/internal/DecoderThread;
    //   113: invokestatic 183	com/google/android/gms/common/internal/DecoderThread:decode	(Lcom/google/android/gms/common/internal/DecoderThread;)J
    //   116: invokevirtual 187	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   119: pop
    //   120: goto +25 -> 145
    //   123: aload_0
    //   124: iconst_2
    //   125: putfield 38	com/google/android/gms/common/internal/AbstractBackendHelper:state	I
    //   128: aload_0
    //   129: getfield 26	com/google/android/gms/common/internal/AbstractBackendHelper:this$0	Lcom/google/android/gms/common/internal/DecoderThread;
    //   132: astore_1
    //   133: aload_1
    //   134: invokestatic 119	com/google/android/gms/common/internal/DecoderThread:access$getMContext	(Lcom/google/android/gms/common/internal/DecoderThread;)Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   137: aload_1
    //   138: invokestatic 123	com/google/android/gms/common/internal/DecoderThread:access$getLOCK	(Lcom/google/android/gms/common/internal/DecoderThread;)Landroid/content/Context;
    //   141: aload_0
    //   142: invokevirtual 129	com/google/android/gms/common/stats/ConnectionTracker:unbindService	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   145: aload 4
    //   147: invokestatic 163	android/os/StrictMode:setVmPolicy	(Landroid/os/StrictMode$VmPolicy;)V
    //   150: return
    //   151: astore_1
    //   152: aload 4
    //   154: invokestatic 163	android/os/StrictMode:setVmPolicy	(Landroid/os/StrictMode$VmPolicy;)V
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: goto -15 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	AbstractBackendHelper
    //   0	163	1	paramString	String
    //   0	163	2	paramExecutor	java.util.concurrent.Executor
    //   75	7	3	bool	boolean
    //   8	145	4	localVmPolicy	android.os.StrictMode.VmPolicy
    //   38	18	5	localDecoderThread	DecoderThread
    // Exception table:
    //   from	to	target	type
    //   34	81	151	java/lang/Throwable
    //   85	120	151	java/lang/Throwable
    //   123	128	151	java/lang/Throwable
    //   133	145	151	java/lang/Throwable
    //   133	145	159	java/lang/IllegalArgumentException
  }
}
