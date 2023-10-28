package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.package_12.CommonStatusCodes;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface>
{
  @KeepForSdk
  public static final int CONNECT_STATE_CONNECTED = 4;
  @KeepForSdk
  public static final int CONNECT_STATE_DISCONNECTED = 1;
  @KeepForSdk
  public static final int CONNECT_STATE_DISCONNECTING = 5;
  @KeepForSdk
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  @KeepForSdk
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = { "service_esmobile", "service_googleme" };
  @KeepForSdk
  public static final String KEY_PENDING_INTENT = "pendingIntent";
  private static final Feature[] mDescriptionId = new Feature[0];
  private Main activity;
  private volatile MediaDescriptionCompat added = null;
  private final BaseConnectionCallbacks applicationContext;
  private ConnectionResult categoryId = null;
  @VisibleForTesting
  ParsableByteArray data;
  private final String defaultValue;
  @VisibleForTesting
  protected ConnectionProgressReportCallbacks destination;
  private final int dirs;
  private final GoogleApiAvailabilityLight label;
  private int mCallbacksMessenger;
  private final Context mContext;
  private final Looper mDbAdapter;
  final Handler mHandler;
  private IInterface mListener;
  private long mNow;
  private long mRootId;
  private int mState = 1;
  private final ArrayList mTasks = new ArrayList();
  private final Object mView = new Object();
  private IGmsServiceBroker mainActivity;
  private int namespaces;
  private final Object next = new Object();
  private volatile String replyText;
  private long state;
  @VisibleForTesting
  protected AtomicInteger this$0 = new AtomicInteger(0);
  private volatile String thread = null;
  private final GmsClientSupervisor title;
  private final BaseOnConnectionFailedListener updater;
  private boolean value = false;
  
  protected BaseGmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    mContext = paramContext;
    Preconditions.checkNotNull(paramHandler, "Handler must not be null");
    mHandler = paramHandler;
    mDbAdapter = paramHandler.getLooper();
    Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null");
    title = paramGmsClientSupervisor;
    Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null");
    label = paramGoogleApiAvailabilityLight;
    dirs = paramInt;
    applicationContext = paramBaseConnectionCallbacks;
    updater = paramBaseOnConnectionFailedListener;
    defaultValue = null;
  }
  
  protected BaseGmsClient(Context paramContext, Looper paramLooper, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString)
  {
    this(paramContext, paramLooper, localGmsClientSupervisor, localGoogleApiAvailabilityLight, paramInt, paramBaseConnectionCallbacks, paramBaseOnConnectionFailedListener, paramString);
  }
  
  protected BaseGmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    mContext = paramContext;
    Preconditions.checkNotNull(paramLooper, "Looper must not be null");
    mDbAdapter = paramLooper;
    Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null");
    title = paramGmsClientSupervisor;
    Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null");
    label = paramGoogleApiAvailabilityLight;
    mHandler = new SlidingDrawer.SlidingHandler(this, paramLooper);
    dirs = paramInt;
    applicationContext = paramBaseConnectionCallbacks;
    updater = paramBaseOnConnectionFailedListener;
    defaultValue = paramString;
  }
  
  private final void execute(int paramInt, IInterface paramIInterface)
  {
    boolean bool = false;
    int i;
    if (paramInt != 4) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if (paramIInterface == null) {
      j = 0;
    } else {
      j = 1;
    }
    if (i == j) {
      bool = true;
    }
    Preconditions.checkArgument(bool);
    Object localObject1 = next;
    try
    {
      mState = paramInt;
      mListener = paramIInterface;
      Object localObject3;
      Object localObject2;
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 3))
        {
          if (paramInt == 4)
          {
            Preconditions.checkNotNull(paramIInterface);
            onConnectedLocked(paramIInterface);
          }
        }
        else
        {
          paramIInterface = activity;
          if (paramIInterface != null)
          {
            localObject3 = data;
            if (localObject3 != null)
            {
              localObject2 = ((ParsableByteArray)localObject3).getPosition();
              localObject3 = ((ParsableByteArray)localObject3).limit();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("Calling connect() while still connected, missing disconnect() for ");
              ((StringBuilder)localObject4).append((String)localObject2);
              ((StringBuilder)localObject4).append(" on ");
              ((StringBuilder)localObject4).append((String)localObject3);
              Log.e("GmsClient", ((StringBuilder)localObject4).toString());
              localObject2 = title;
              localObject3 = data.getPosition();
              Preconditions.checkNotNull(localObject3);
              ((GmsClientSupervisor)localObject2).append((String)localObject3, data.limit(), data.readInt(), paramIInterface, getDefault(), data.capacity());
              this$0.incrementAndGet();
            }
          }
          localObject2 = new Main(this, this$0.get());
          activity = ((Main)localObject2);
          if ((mState == 3) && (getLocalStartServiceAction() != null)) {
            paramIInterface = new ParsableByteArray(getContext().getPackageName(), getLocalStartServiceAction(), true, GmsClientSupervisor.getDefaultBindFlags(), false);
          } else {
            paramIInterface = new ParsableByteArray(getStartServicePackage(), getStartServiceAction(), false, GmsClientSupervisor.getDefaultBindFlags(), getUseDynamicLookup());
          }
          data = paramIInterface;
          if ((paramIInterface.capacity()) && (getMinApkVersion() < 17895000)) {
            throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(data.getPosition())));
          }
          paramIInterface = title;
          localObject3 = data.getPosition();
          Preconditions.checkNotNull(localObject3);
          Object localObject4 = data.limit();
          paramInt = data.readInt();
          String str = getDefault();
          bool = data.capacity();
          Executor localExecutor = getBindServiceExecutor();
          if (!paramIInterface.start(new Node((String)localObject3, (String)localObject4, paramInt, bool), (ServiceConnection)localObject2, str, localExecutor))
          {
            paramIInterface = data.getPosition();
            localObject2 = data.limit();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("unable to connect to service: ");
            ((StringBuilder)localObject3).append(paramIInterface);
            ((StringBuilder)localObject3).append(" on ");
            ((StringBuilder)localObject3).append((String)localObject2);
            Log.w("GmsClient", ((StringBuilder)localObject3).toString());
            sendMessage(16, null, this$0.get());
          }
        }
      }
      else
      {
        paramIInterface = activity;
        if (paramIInterface != null)
        {
          localObject2 = title;
          localObject3 = data.getPosition();
          Preconditions.checkNotNull(localObject3);
          ((GmsClientSupervisor)localObject2).append((String)localObject3, data.limit(), data.readInt(), paramIInterface, getDefault(), data.capacity());
          activity = null;
        }
      }
      return;
    }
    catch (Throwable paramIInterface)
    {
      throw paramIInterface;
    }
  }
  
  public void checkAvailabilityAndConnect()
  {
    int i = label.isGooglePlayServicesAvailable(mContext, getMinApkVersion());
    if (i != 0)
    {
      execute(1, null);
      triggerNotAvailable(new LegacyClientCallbackAdapter(), i, null);
      return;
    }
    connect(new LegacyClientCallbackAdapter());
  }
  
  protected final void checkConnected()
  {
    if (isConnected()) {
      return;
    }
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  public void connect(ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
    destination = paramConnectionProgressReportCallbacks;
    execute(2, null);
  }
  
  protected abstract IInterface createServiceInterface(IBinder paramIBinder);
  
  /* Error */
  public void disconnect()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 133	com/google/android/gms/common/internal/BaseGmsClient:this$0	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: invokevirtual 338	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   7: pop
    //   8: aload_0
    //   9: getfield 118	com/google/android/gms/common/internal/BaseGmsClient:mTasks	Ljava/util/ArrayList;
    //   12: astore_3
    //   13: aload_3
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 118	com/google/android/gms/common/internal/BaseGmsClient:mTasks	Ljava/util/ArrayList;
    //   19: invokevirtual 441	java/util/ArrayList:size	()I
    //   22: istore_2
    //   23: iconst_0
    //   24: istore_1
    //   25: iload_1
    //   26: iload_2
    //   27: if_icmpge +24 -> 51
    //   30: aload_0
    //   31: getfield 118	com/google/android/gms/common/internal/BaseGmsClient:mTasks	Ljava/util/ArrayList;
    //   34: iload_1
    //   35: invokevirtual 444	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   38: checkcast 446	com/google/android/gms/common/internal/Connection
    //   41: invokevirtual 449	com/google/android/gms/common/internal/Connection:remove	()V
    //   44: iload_1
    //   45: iconst_1
    //   46: iadd
    //   47: istore_1
    //   48: goto -23 -> 25
    //   51: aload_0
    //   52: getfield 118	com/google/android/gms/common/internal/BaseGmsClient:mTasks	Ljava/util/ArrayList;
    //   55: invokevirtual 452	java/util/ArrayList:clear	()V
    //   58: aload_3
    //   59: monitorexit
    //   60: aload_0
    //   61: getfield 113	com/google/android/gms/common/internal/BaseGmsClient:mView	Ljava/lang/Object;
    //   64: astore_3
    //   65: aload_3
    //   66: monitorenter
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 210	com/google/android/gms/common/internal/BaseGmsClient:mainActivity	Lcom/google/android/gms/common/internal/IGmsServiceBroker;
    //   72: aload_3
    //   73: monitorexit
    //   74: aload_0
    //   75: iconst_1
    //   76: aconst_null
    //   77: invokespecial 216	com/google/android/gms/common/internal/BaseGmsClient:execute	(ILandroid/os/IInterface;)V
    //   80: return
    //   81: astore 4
    //   83: aload_3
    //   84: monitorexit
    //   85: aload 4
    //   87: athrow
    //   88: astore 4
    //   90: aload_3
    //   91: monitorexit
    //   92: aload 4
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	BaseGmsClient
    //   24	24	1	i	int
    //   22	6	2	j	int
    //   12	79	3	localObject	Object
    //   81	5	4	localThrowable1	Throwable
    //   88	5	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   67	74	81	java/lang/Throwable
    //   83	85	81	java/lang/Throwable
    //   15	23	88	java/lang/Throwable
    //   30	44	88	java/lang/Throwable
    //   51	60	88	java/lang/Throwable
    //   90	92	88	java/lang/Throwable
  }
  
  public void disconnect(String paramString)
  {
    thread = paramString;
    disconnect();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramArrayOfString = next;
    try
    {
      int i = mState;
      paramFileDescriptor = mListener;
      paramArrayOfString = mView;
      try
      {
        Object localObject = mainActivity;
        paramPrintWriter.append(paramString).append("mConnectState=");
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5) {
                  paramPrintWriter.print("UNKNOWN");
                } else {
                  paramPrintWriter.print("DISCONNECTING");
                }
              }
              else {
                paramPrintWriter.print("CONNECTED");
              }
            }
            else {
              paramPrintWriter.print("LOCAL_CONNECTING");
            }
          }
          else {
            paramPrintWriter.print("REMOTE_CONNECTING");
          }
        }
        else {
          paramPrintWriter.print("DISCONNECTED");
        }
        paramPrintWriter.append(" mService=");
        if (paramFileDescriptor == null) {
          paramPrintWriter.append("null");
        } else {
          paramPrintWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(paramFileDescriptor.asBinder())));
        }
        paramPrintWriter.append(" mServiceBroker=");
        if (localObject == null) {
          paramPrintWriter.println("null");
        } else {
          paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((IInterface)localObject).asBinder())));
        }
        paramFileDescriptor = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        long l;
        StringBuilder localStringBuilder;
        if (mNow > 0L)
        {
          paramArrayOfString = paramPrintWriter.append(paramString).append("lastConnectedTime=");
          l = mNow;
          localObject = paramFileDescriptor.format(new Date(l));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(l);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject);
          paramArrayOfString.println(localStringBuilder.toString());
        }
        if (mRootId > 0L)
        {
          paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          i = mCallbacksMessenger;
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3) {
                paramPrintWriter.append(String.valueOf(i));
              } else {
                paramPrintWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
              }
            }
            else {
              paramPrintWriter.append("CAUSE_NETWORK_LOST");
            }
          }
          else {
            paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
          }
          paramArrayOfString = paramPrintWriter.append(" lastSuspendedTime=");
          l = mRootId;
          localObject = paramFileDescriptor.format(new Date(l));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(l);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject);
          paramArrayOfString.println(localStringBuilder.toString());
        }
        if (state > 0L)
        {
          paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(namespaces));
          paramString = paramPrintWriter.append(" lastFailedTime=");
          l = state;
          paramFileDescriptor = paramFileDescriptor.format(new Date(l));
          paramPrintWriter = new StringBuilder();
          paramPrintWriter.append(l);
          paramPrintWriter.append(" ");
          paramPrintWriter.append(paramFileDescriptor);
          paramString.println(paramPrintWriter.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  protected boolean enableLocalFallback()
  {
    return false;
  }
  
  public Account getAccount()
  {
    return null;
  }
  
  public Feature[] getApiFeatures()
  {
    return mDescriptionId;
  }
  
  public final Feature[] getAvailableFeatures()
  {
    MediaDescriptionCompat localMediaDescriptionCompat = added;
    if (localMediaDescriptionCompat == null) {
      return null;
    }
    return mMediaUri;
  }
  
  protected Executor getBindServiceExecutor()
  {
    return null;
  }
  
  public Bundle getConnectionHint()
  {
    return null;
  }
  
  public final Context getContext()
  {
    return mContext;
  }
  
  protected final String getDefault()
  {
    String str2 = defaultValue;
    String str1 = str2;
    if (str2 == null) {
      str1 = mContext.getClass().getName();
    }
    return str1;
  }
  
  public String getEndpointPackageName()
  {
    if (isConnected())
    {
      ParsableByteArray localParsableByteArray = data;
      if (localParsableByteArray != null) {
        return localParsableByteArray.limit();
      }
    }
    throw new RuntimeException("Failed to connect when checking package");
  }
  
  public int getGCoreServiceId()
  {
    return dirs;
  }
  
  protected Bundle getGetServiceRequestExtraArgs()
  {
    return new Bundle();
  }
  
  public String getLastDisconnectMessage()
  {
    return thread;
  }
  
  protected String getLocalStartServiceAction()
  {
    return null;
  }
  
  public final Looper getLooper()
  {
    return mDbAdapter;
  }
  
  public int getMinApkVersion()
  {
    return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }
  
  public void getRemoteService(IAccountAccessor paramIAccountAccessor, Set paramSet)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a14 = a13\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  protected Set getScopes()
  {
    return Collections.emptySet();
  }
  
  public final IInterface getService()
    throws DeadObjectException
  {
    Object localObject = next;
    try
    {
      if (mState != 5)
      {
        checkConnected();
        IInterface localIInterface = mListener;
        Preconditions.checkNotNull(localIInterface, "Client is connected but service is null");
        return localIInterface;
      }
      throw new DeadObjectException();
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public IBinder getServiceBrokerBinder()
  {
    Object localObject1 = mView;
    try
    {
      Object localObject2 = mainActivity;
      if (localObject2 == null) {
        return null;
      }
      localObject2 = ((IInterface)localObject2).asBinder();
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  protected abstract String getServiceDescriptor();
  
  public Intent getSignInIntent()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  protected abstract String getStartServiceAction();
  
  protected String getStartServicePackage()
  {
    return "com.google.android.gms";
  }
  
  public ConnectionTelemetryConfiguration getTelemetryConfiguration()
  {
    MediaDescriptionCompat localMediaDescriptionCompat = added;
    if (localMediaDescriptionCompat == null) {
      return null;
    }
    return added;
  }
  
  protected boolean getUseDynamicLookup()
  {
    return getMinApkVersion() >= 211700000;
  }
  
  public boolean hasConnectionInfo()
  {
    return added != null;
  }
  
  public boolean isConnected()
  {
    Object localObject = next;
    for (;;)
    {
      try
      {
        if (mState == 4)
        {
          bool = true;
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    Object localObject = next;
    for (;;)
    {
      try
      {
        int i = mState;
        boolean bool2 = true;
        bool1 = bool2;
        if (i != 2)
        {
          if (i != 3) {
            break label46;
          }
          bool1 = bool2;
        }
        return bool1;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      label46:
      boolean bool1 = false;
    }
  }
  
  protected void onConnectedLocked(IInterface paramIInterface)
  {
    mNow = System.currentTimeMillis();
  }
  
  protected void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    namespaces = paramConnectionResult.getErrorCode();
    state = System.currentTimeMillis();
  }
  
  protected void onConnectionSuspended(int paramInt)
  {
    mCallbacksMessenger = paramInt;
    mRootId = System.currentTimeMillis();
  }
  
  protected void onPostInitHandler(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    Handler localHandler = mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(1, paramInt2, -1, new State(this, paramInt1, paramIBinder, paramBundle)));
  }
  
  public void onUserSignOut(SignOutCallbacks paramSignOutCallbacks)
  {
    paramSignOutCallbacks.onSignOutComplete();
  }
  
  public boolean providesSignIn()
  {
    return false;
  }
  
  public boolean requiresAccount()
  {
    return false;
  }
  
  public boolean requiresGooglePlayServices()
  {
    return true;
  }
  
  public boolean requiresSignIn()
  {
    return false;
  }
  
  protected final void sendMessage(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    paramBundle = mHandler;
    paramBundle.sendMessage(paramBundle.obtainMessage(7, paramInt2, -1, new AbstractHttpConnection.ConnectionIdleTask(this, paramInt1, null)));
  }
  
  public void setAttributionTag(String paramString)
  {
    replyText = paramString;
  }
  
  public void triggerConnectionSuspended(int paramInt)
  {
    Handler localHandler = mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(6, this$0.get(), paramInt));
  }
  
  protected void triggerNotAvailable(ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks, int paramInt, PendingIntent paramPendingIntent)
  {
    Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
    destination = paramConnectionProgressReportCallbacks;
    paramConnectionProgressReportCallbacks = mHandler;
    paramConnectionProgressReportCallbacks.sendMessage(paramConnectionProgressReportCallbacks.obtainMessage(3, this$0.get(), paramInt, paramPendingIntent));
  }
  
  public boolean usesClientTelemetry()
  {
    return false;
  }
  
  @KeepForSdk
  public static abstract interface BaseConnectionCallbacks
  {
    @KeepForSdk
    public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
    @KeepForSdk
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    public abstract void onConnected(Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  @KeepForSdk
  public static abstract interface BaseOnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
  
  @KeepForSdk
  public static abstract interface ConnectionProgressReportCallbacks
  {
    public abstract void onReportServiceBinding(ConnectionResult paramConnectionResult);
  }
  
  protected class LegacyClientCallbackAdapter
    implements BaseGmsClient.ConnectionProgressReportCallbacks
  {
    public LegacyClientCallbackAdapter() {}
    
    public final void onReportServiceBinding(ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess())
      {
        paramConnectionResult = BaseGmsClient.this;
        paramConnectionResult.getRemoteService(null, paramConnectionResult.getScopes());
        return;
      }
      if (BaseGmsClient.access$getUpdater(BaseGmsClient.this) != null) {
        BaseGmsClient.access$getUpdater(BaseGmsClient.this).onConnectionFailed(paramConnectionResult);
      }
    }
  }
  
  @KeepForSdk
  public static abstract interface SignOutCallbacks
  {
    public abstract void onSignOutComplete();
  }
}
