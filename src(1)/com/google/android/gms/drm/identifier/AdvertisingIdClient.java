package com.google.android.gms.drm.identifier;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.ads_identifier.IPlayMedia_0_8;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@KeepForSdk
public class AdvertisingIdClient
{
  BlockingServiceConnection connection;
  private final Context context;
  IPlayMedia_0_8 handler;
  IRCConnection sch;
  boolean state;
  final Object sync = new Object();
  final long uri;
  
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L, false, false);
  }
  
  public AdvertisingIdClient(Context paramContext, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramContext);
    Object localObject = paramContext;
    if (paramBoolean1)
    {
      Context localContext = paramContext.getApplicationContext();
      localObject = paramContext;
      if (localContext != null) {
        localObject = localContext;
      }
    }
    context = ((Context)localObject);
    state = false;
    uri = paramLong;
  }
  
  /* Error */
  private final Info connect(int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: ldc 64
    //   2: invokestatic 68	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 50	com/google/android/gms/drm/identifier/AdvertisingIdClient:state	Z
    //   11: ifne +87 -> 98
    //   14: aload_0
    //   15: getfield 34	com/google/android/gms/drm/identifier/AdvertisingIdClient:sync	Ljava/lang/Object;
    //   18: astore_3
    //   19: aload_3
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 70	com/google/android/gms/drm/identifier/AdvertisingIdClient:sch	Lcom/google/android/gms/drm/identifier/IRCConnection;
    //   25: astore 4
    //   27: aload 4
    //   29: ifnull +52 -> 81
    //   32: aload 4
    //   34: getfield 75	com/google/android/gms/drm/identifier/IRCConnection:isListening	Z
    //   37: ifeq +44 -> 81
    //   40: aload_3
    //   41: monitorexit
    //   42: aload_0
    //   43: iconst_0
    //   44: invokevirtual 79	com/google/android/gms/drm/identifier/AdvertisingIdClient:init	(Z)V
    //   47: aload_0
    //   48: getfield 50	com/google/android/gms/drm/identifier/AdvertisingIdClient:state	Z
    //   51: istore_2
    //   52: iload_2
    //   53: ifeq +6 -> 59
    //   56: goto +42 -> 98
    //   59: new 56	java/io/IOException
    //   62: dup
    //   63: ldc 81
    //   65: invokespecial 83	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   68: athrow
    //   69: astore_3
    //   70: new 56	java/io/IOException
    //   73: dup
    //   74: ldc 81
    //   76: aload_3
    //   77: invokespecial 86	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   80: athrow
    //   81: new 56	java/io/IOException
    //   84: dup
    //   85: ldc 88
    //   87: invokespecial 83	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   90: athrow
    //   91: astore 4
    //   93: aload_3
    //   94: monitorexit
    //   95: aload 4
    //   97: athrow
    //   98: aload_0
    //   99: getfield 90	com/google/android/gms/drm/identifier/AdvertisingIdClient:connection	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   102: invokestatic 40	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: aload_0
    //   107: getfield 92	com/google/android/gms/drm/identifier/AdvertisingIdClient:handler	Lcom/google/android/gms/internal/ads_identifier/IPlayMedia_0_8;
    //   110: invokestatic 40	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: aload_0
    //   115: getfield 92	com/google/android/gms/drm/identifier/AdvertisingIdClient:handler	Lcom/google/android/gms/internal/ads_identifier/IPlayMedia_0_8;
    //   118: astore_3
    //   119: aload_3
    //   120: invokeinterface 98 1 0
    //   125: astore_3
    //   126: aload_0
    //   127: getfield 92	com/google/android/gms/drm/identifier/AdvertisingIdClient:handler	Lcom/google/android/gms/internal/ads_identifier/IPlayMedia_0_8;
    //   130: astore 4
    //   132: new 6	com/google/android/gms/drm/identifier/AdvertisingIdClient$Info
    //   135: dup
    //   136: aload_3
    //   137: aload 4
    //   139: iconst_1
    //   140: invokeinterface 102 2 0
    //   145: invokespecial 105	com/google/android/gms/drm/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   148: astore_3
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_0
    //   152: invokespecial 107	com/google/android/gms/drm/identifier/AdvertisingIdClient:connect	()V
    //   155: aload_3
    //   156: areturn
    //   157: astore_3
    //   158: ldc 109
    //   160: ldc 111
    //   162: aload_3
    //   163: invokestatic 117	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   166: pop
    //   167: new 56	java/io/IOException
    //   170: dup
    //   171: ldc 119
    //   173: invokespecial 83	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   176: athrow
    //   177: astore_3
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_3
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	AdvertisingIdClient
    //   0	182	1	paramInt	int
    //   51	2	2	bool	boolean
    //   18	23	3	localObject1	Object
    //   69	25	3	localException	Exception
    //   118	38	3	localObject2	Object
    //   157	6	3	localRemoteException	android.os.RemoteException
    //   177	4	3	localThrowable1	Throwable
    //   25	8	4	localIRCConnection	IRCConnection
    //   91	5	4	localThrowable2	Throwable
    //   130	8	4	localIPlayMedia_0_8	IPlayMedia_0_8
    // Exception table:
    //   from	to	target	type
    //   42	47	69	java/lang/Exception
    //   21	27	91	java/lang/Throwable
    //   32	42	91	java/lang/Throwable
    //   81	91	91	java/lang/Throwable
    //   93	95	91	java/lang/Throwable
    //   119	126	157	android/os/RemoteException
    //   132	149	157	android/os/RemoteException
    //   7	21	177	java/lang/Throwable
    //   42	47	177	java/lang/Throwable
    //   47	52	177	java/lang/Throwable
    //   59	69	177	java/lang/Throwable
    //   70	81	177	java/lang/Throwable
    //   95	98	177	java/lang/Throwable
    //   98	119	177	java/lang/Throwable
    //   119	126	177	java/lang/Throwable
    //   132	149	177	java/lang/Throwable
    //   149	151	177	java/lang/Throwable
    //   158	177	177	java/lang/Throwable
    //   178	180	177	java/lang/Throwable
  }
  
  /* Error */
  private final void connect()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/google/android/gms/drm/identifier/AdvertisingIdClient:sync	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 70	com/google/android/gms/drm/identifier/AdvertisingIdClient:sch	Lcom/google/android/gms/drm/identifier/IRCConnection;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnull +22 -> 37
    //   18: aload 4
    //   20: getfield 126	com/google/android/gms/drm/identifier/IRCConnection:localAddress	Ljava/util/concurrent/CountDownLatch;
    //   23: invokevirtual 131	java/util/concurrent/CountDownLatch:countDown	()V
    //   26: aload_0
    //   27: getfield 70	com/google/android/gms/drm/identifier/AdvertisingIdClient:sch	Lcom/google/android/gms/drm/identifier/IRCConnection;
    //   30: astore 4
    //   32: aload 4
    //   34: invokevirtual 136	java/lang/Thread:join	()V
    //   37: aload_0
    //   38: getfield 52	com/google/android/gms/drm/identifier/AdvertisingIdClient:uri	J
    //   41: lstore_1
    //   42: lload_1
    //   43: lconst_0
    //   44: lcmp
    //   45: ifle +16 -> 61
    //   48: aload_0
    //   49: new 72	com/google/android/gms/drm/identifier/IRCConnection
    //   52: dup
    //   53: aload_0
    //   54: lload_1
    //   55: invokespecial 139	com/google/android/gms/drm/identifier/IRCConnection:<init>	(Lcom/google/android/gms/drm/identifier/AdvertisingIdClient;J)V
    //   58: putfield 70	com/google/android/gms/drm/identifier/AdvertisingIdClient:sch	Lcom/google/android/gms/drm/identifier/IRCConnection;
    //   61: aload_3
    //   62: monitorexit
    //   63: return
    //   64: astore 4
    //   66: aload_3
    //   67: monitorexit
    //   68: aload 4
    //   70: athrow
    //   71: astore 4
    //   73: goto -36 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	AdvertisingIdClient
    //   41	14	1	l	long
    //   4	63	3	localObject	Object
    //   11	22	4	localIRCConnection	IRCConnection
    //   64	5	4	localThrowable	Throwable
    //   71	1	4	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   7	13	64	java/lang/Throwable
    //   18	26	64	java/lang/Throwable
    //   32	37	64	java/lang/Throwable
    //   37	42	64	java/lang/Throwable
    //   48	61	64	java/lang/Throwable
    //   61	63	64	java/lang/Throwable
    //   66	68	64	java/lang/Throwable
    //   32	37	71	java/lang/InterruptedException
  }
  
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    paramContext = new AdvertisingIdClient(paramContext, -1L, true, false);
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      paramContext.init(false);
      Info localInfo = paramContext.connect(-1);
      long l2 = SystemClock.elapsedRealtime();
      paramContext.add(localInfo, true, 0.0F, l2 - l1, "", null);
      paramContext.close();
      return localInfo;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        paramContext.add(null, true, 0.0F, -1L, "", localThrowable1);
        throw localThrowable1;
      }
      catch (Throwable localThrowable2)
      {
        paramContext.close();
        throw localThrowable2;
      }
    }
  }
  
  /* Error */
  public static boolean getIsAdIdFakeForDebugLogging(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    // Byte code:
    //   0: new 2	com/google/android/gms/drm/identifier/AdvertisingIdClient
    //   3: dup
    //   4: aload_0
    //   5: ldc2_w 148
    //   8: iconst_0
    //   9: iconst_0
    //   10: invokespecial 28	com/google/android/gms/drm/identifier/AdvertisingIdClient:<init>	(Landroid/content/Context;JZZ)V
    //   13: astore_0
    //   14: aload_0
    //   15: iconst_0
    //   16: invokevirtual 79	com/google/android/gms/drm/identifier/AdvertisingIdClient:init	(Z)V
    //   19: ldc 64
    //   21: invokestatic 68	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 50	com/google/android/gms/drm/identifier/AdvertisingIdClient:state	Z
    //   30: ifne +82 -> 112
    //   33: aload_0
    //   34: getfield 34	com/google/android/gms/drm/identifier/AdvertisingIdClient:sync	Ljava/lang/Object;
    //   37: astore_2
    //   38: aload_2
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 70	com/google/android/gms/drm/identifier/AdvertisingIdClient:sch	Lcom/google/android/gms/drm/identifier/IRCConnection;
    //   44: astore_3
    //   45: aload_3
    //   46: ifnull +51 -> 97
    //   49: aload_3
    //   50: getfield 75	com/google/android/gms/drm/identifier/IRCConnection:isListening	Z
    //   53: ifeq +44 -> 97
    //   56: aload_2
    //   57: monitorexit
    //   58: aload_0
    //   59: iconst_0
    //   60: invokevirtual 79	com/google/android/gms/drm/identifier/AdvertisingIdClient:init	(Z)V
    //   63: aload_0
    //   64: getfield 50	com/google/android/gms/drm/identifier/AdvertisingIdClient:state	Z
    //   67: istore_1
    //   68: iload_1
    //   69: ifeq +6 -> 75
    //   72: goto +40 -> 112
    //   75: new 56	java/io/IOException
    //   78: dup
    //   79: ldc 81
    //   81: invokespecial 83	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   84: athrow
    //   85: astore_2
    //   86: new 56	java/io/IOException
    //   89: dup
    //   90: ldc 81
    //   92: aload_2
    //   93: invokespecial 86	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: athrow
    //   97: new 56	java/io/IOException
    //   100: dup
    //   101: ldc 88
    //   103: invokespecial 83	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   106: athrow
    //   107: astore_3
    //   108: aload_2
    //   109: monitorexit
    //   110: aload_3
    //   111: athrow
    //   112: aload_0
    //   113: getfield 90	com/google/android/gms/drm/identifier/AdvertisingIdClient:connection	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   116: invokestatic 40	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: aload_0
    //   121: getfield 92	com/google/android/gms/drm/identifier/AdvertisingIdClient:handler	Lcom/google/android/gms/internal/ads_identifier/IPlayMedia_0_8;
    //   124: invokestatic 40	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_0
    //   129: getfield 92	com/google/android/gms/drm/identifier/AdvertisingIdClient:handler	Lcom/google/android/gms/internal/ads_identifier/IPlayMedia_0_8;
    //   132: astore_2
    //   133: aload_2
    //   134: invokeinterface 172 1 0
    //   139: istore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_0
    //   143: invokespecial 107	com/google/android/gms/drm/identifier/AdvertisingIdClient:connect	()V
    //   146: aload_0
    //   147: invokevirtual 166	com/google/android/gms/drm/identifier/AdvertisingIdClient:close	()V
    //   150: iload_1
    //   151: ireturn
    //   152: astore_2
    //   153: ldc 109
    //   155: ldc 111
    //   157: aload_2
    //   158: invokestatic 117	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   161: pop
    //   162: new 56	java/io/IOException
    //   165: dup
    //   166: ldc 119
    //   168: invokespecial 83	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   171: athrow
    //   172: astore_2
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_2
    //   176: athrow
    //   177: astore_2
    //   178: aload_0
    //   179: invokevirtual 166	com/google/android/gms/drm/identifier/AdvertisingIdClient:close	()V
    //   182: aload_2
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramContext	Context
    //   67	84	1	bool	boolean
    //   37	20	2	localObject	Object
    //   85	24	2	localException	Exception
    //   132	2	2	localIPlayMedia_0_8	IPlayMedia_0_8
    //   152	6	2	localRemoteException	android.os.RemoteException
    //   172	4	2	localThrowable1	Throwable
    //   177	6	2	localThrowable2	Throwable
    //   44	6	3	localIRCConnection	IRCConnection
    //   107	4	3	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   58	63	85	java/lang/Exception
    //   40	45	107	java/lang/Throwable
    //   49	58	107	java/lang/Throwable
    //   97	107	107	java/lang/Throwable
    //   108	110	107	java/lang/Throwable
    //   133	140	152	android/os/RemoteException
    //   26	40	172	java/lang/Throwable
    //   58	63	172	java/lang/Throwable
    //   63	68	172	java/lang/Throwable
    //   75	85	172	java/lang/Throwable
    //   86	97	172	java/lang/Throwable
    //   110	112	172	java/lang/Throwable
    //   112	128	172	java/lang/Throwable
    //   133	140	172	java/lang/Throwable
    //   140	142	172	java/lang/Throwable
    //   153	172	172	java/lang/Throwable
    //   173	175	172	java/lang/Throwable
    //   14	26	177	java/lang/Throwable
    //   142	146	177	java/lang/Throwable
    //   175	177	177	java/lang/Throwable
  }
  
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean) {}
  
  final boolean add(Info paramInfo, boolean paramBoolean, float paramFloat, long paramLong, String paramString, Throwable paramThrowable)
  {
    if (Math.random() <= 0.0D)
    {
      HashMap localHashMap = new HashMap();
      paramString = "1";
      localHashMap.put("app_context", "1");
      if (paramInfo != null)
      {
        if (true != paramInfo.isLimitAdTrackingEnabled()) {
          paramString = "0";
        }
        localHashMap.put("limit_ad_tracking", paramString);
        paramInfo = paramInfo.getId();
        if (paramInfo != null) {
          localHashMap.put("ad_id_size", Integer.toString(paramInfo.length()));
        }
      }
      if (paramThrowable != null) {
        localHashMap.put("error", paramThrowable.getClass().getName());
      }
      localHashMap.put("tag", "AdvertisingIdClient");
      localHashMap.put("time_spent", Long.toString(paramLong));
      new SqlTileWriter.1(this, localHashMap).start();
      return true;
    }
    return false;
  }
  
  public final void close()
  {
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    try
    {
      if (context != null)
      {
        BlockingServiceConnection localBlockingServiceConnection = connection;
        if (localBlockingServiceConnection != null)
        {
          try
          {
            if (state) {
              ConnectionTracker.getInstance().unbindService(context, connection);
            }
          }
          catch (Throwable localThrowable1)
          {
            Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", localThrowable1);
          }
          state = false;
          handler = null;
          connection = null;
          return;
        }
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
  }
  
  protected final void finalize()
    throws Throwable
  {
    close();
    super.finalize();
  }
  
  public Info getInfo()
    throws IOException
  {
    return connect(-1);
  }
  
  /* Error */
  protected final void init(boolean paramBoolean)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    // Byte code:
    //   0: ldc 64
    //   2: invokestatic 68	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 50	com/google/android/gms/drm/identifier/AdvertisingIdClient:state	Z
    //   11: ifeq +7 -> 18
    //   14: aload_0
    //   15: invokevirtual 166	com/google/android/gms/drm/identifier/AdvertisingIdClient:close	()V
    //   18: aload_0
    //   19: getfield 48	com/google/android/gms/drm/identifier/AdvertisingIdClient:context	Landroid/content/Context;
    //   22: astore 5
    //   24: aload 5
    //   26: invokevirtual 265	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   29: ldc_w 267
    //   32: iconst_0
    //   33: invokevirtual 273	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   36: pop
    //   37: invokestatic 278	com/google/android/gms/common/GoogleApiAvailabilityLight:getInstance	()Lcom/google/android/gms/common/GoogleApiAvailabilityLight;
    //   40: aload 5
    //   42: ldc_w 279
    //   45: invokevirtual 283	com/google/android/gms/common/GoogleApiAvailabilityLight:isGooglePlayServicesAvailable	(Landroid/content/Context;I)I
    //   48: istore_2
    //   49: iload_2
    //   50: ifeq +22 -> 72
    //   53: iload_2
    //   54: iconst_2
    //   55: if_icmpne +6 -> 61
    //   58: goto +14 -> 72
    //   61: new 56	java/io/IOException
    //   64: dup
    //   65: ldc_w 285
    //   68: invokespecial 83	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   71: athrow
    //   72: new 287	com/google/android/gms/common/BlockingServiceConnection
    //   75: dup
    //   76: invokespecial 288	com/google/android/gms/common/BlockingServiceConnection:<init>	()V
    //   79: astore 4
    //   81: new 290	android/content/Intent
    //   84: dup
    //   85: ldc_w 292
    //   88: invokespecial 293	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   91: astore 6
    //   93: aload 6
    //   95: ldc_w 295
    //   98: invokevirtual 299	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   101: pop
    //   102: invokestatic 248	com/google/android/gms/common/stats/ConnectionTracker:getInstance	()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   105: aload 5
    //   107: aload 6
    //   109: aload 4
    //   111: iconst_1
    //   112: invokevirtual 303	com/google/android/gms/common/stats/ConnectionTracker:bindService	(Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   115: istore_3
    //   116: iload_3
    //   117: ifeq +74 -> 191
    //   120: aload_0
    //   121: aload 4
    //   123: putfield 90	com/google/android/gms/drm/identifier/AdvertisingIdClient:connection	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   126: getstatic 309	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   129: astore 5
    //   131: aload 4
    //   133: ldc2_w 310
    //   136: aload 5
    //   138: invokevirtual 315	com/google/android/gms/common/BlockingServiceConnection:getServiceWithTimeout	(JLjava/util/concurrent/TimeUnit;)Landroid/os/IBinder;
    //   141: invokestatic 321	com/google/android/gms/internal/ads_identifier/IPlayMedia_0_8$Stub:asInterface	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/ads_identifier/IPlayMedia_0_8;
    //   144: astore 4
    //   146: aload_0
    //   147: aload 4
    //   149: putfield 92	com/google/android/gms/drm/identifier/AdvertisingIdClient:handler	Lcom/google/android/gms/internal/ads_identifier/IPlayMedia_0_8;
    //   152: aload_0
    //   153: iconst_1
    //   154: putfield 50	com/google/android/gms/drm/identifier/AdvertisingIdClient:state	Z
    //   157: iload_1
    //   158: ifeq +7 -> 165
    //   161: aload_0
    //   162: invokespecial 107	com/google/android/gms/drm/identifier/AdvertisingIdClient:connect	()V
    //   165: aload_0
    //   166: monitorexit
    //   167: return
    //   168: astore 4
    //   170: new 56	java/io/IOException
    //   173: dup
    //   174: aload 4
    //   176: invokespecial 324	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   179: athrow
    //   180: new 56	java/io/IOException
    //   183: dup
    //   184: ldc_w 326
    //   187: invokespecial 83	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   190: athrow
    //   191: new 56	java/io/IOException
    //   194: dup
    //   195: ldc_w 328
    //   198: invokespecial 83	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   201: athrow
    //   202: astore 4
    //   204: new 56	java/io/IOException
    //   207: dup
    //   208: aload 4
    //   210: invokespecial 324	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   213: athrow
    //   214: new 145	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   217: dup
    //   218: bipush 9
    //   220: invokespecial 331	com/google/android/gms/common/GooglePlayServicesNotAvailableException:<init>	(I)V
    //   223: athrow
    //   224: astore 4
    //   226: aload_0
    //   227: monitorexit
    //   228: aload 4
    //   230: athrow
    //   231: astore 4
    //   233: goto -19 -> 214
    //   236: astore 4
    //   238: goto -58 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	AdvertisingIdClient
    //   0	241	1	paramBoolean	boolean
    //   48	8	2	i	int
    //   115	2	3	bool	boolean
    //   79	69	4	localObject1	Object
    //   168	7	4	localThrowable1	Throwable
    //   202	7	4	localThrowable2	Throwable
    //   224	5	4	localThrowable3	Throwable
    //   231	1	4	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   236	1	4	localInterruptedException	InterruptedException
    //   22	115	5	localObject2	Object
    //   91	17	6	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   131	146	168	java/lang/Throwable
    //   102	116	202	java/lang/Throwable
    //   7	18	224	java/lang/Throwable
    //   18	24	224	java/lang/Throwable
    //   24	37	224	java/lang/Throwable
    //   37	49	224	java/lang/Throwable
    //   61	72	224	java/lang/Throwable
    //   72	102	224	java/lang/Throwable
    //   120	126	224	java/lang/Throwable
    //   146	157	224	java/lang/Throwable
    //   161	165	224	java/lang/Throwable
    //   165	167	224	java/lang/Throwable
    //   170	180	224	java/lang/Throwable
    //   180	191	224	java/lang/Throwable
    //   191	202	224	java/lang/Throwable
    //   204	214	224	java/lang/Throwable
    //   214	224	224	java/lang/Throwable
    //   226	228	224	java/lang/Throwable
    //   24	37	231	android/content/pm/PackageManager$NameNotFoundException
    //   131	146	236	java/lang/InterruptedException
  }
  
  public void start()
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    init(true);
  }
  
  @KeepForSdkWithMembers
  public final class Info
  {
    private final boolean mIsValid;
    
    public Info(boolean paramBoolean)
    {
      mIsValid = paramBoolean;
    }
    
    public String getId()
    {
      return AdvertisingIdClient.this;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return mIsValid;
    }
    
    public String toString()
    {
      String str = AdvertisingIdClient.this;
      boolean bool = mIsValid;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 7);
      localStringBuilder.append("{");
      localStringBuilder.append(str);
      localStringBuilder.append("}");
      localStringBuilder.append(bool);
      return localStringBuilder.toString();
    }
  }
}
