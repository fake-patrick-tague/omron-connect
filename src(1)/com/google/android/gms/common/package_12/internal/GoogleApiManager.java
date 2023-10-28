package com.google.android.gms.common.package_12.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.MultiMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.package_12.Api.Client;
import com.google.android.gms.common.package_12.GoogleApi;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.internal.base.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import v7.util.TLongArrayList;

@KeepForSdk
@ShowFirstParty
public class GoogleApiManager
  implements Handler.Callback
{
  private static final Object $assertionsDisabled = new Object();
  private static final Status CONFLICT;
  private static GoogleApiManager length;
  public static final Status tag = new Status(4, "Sign-out occurred while this API call was in progress.");
  private final AtomicInteger clients = new AtomicInteger(0);
  private zaae connection = null;
  private final Context context;
  private long d = 5000L;
  private long data = 10000L;
  private long duration = 120000L;
  @NotOnlyInitialized
  private final Handler handler;
  private TelemetryLoggingClient httpClient;
  private boolean id = false;
  private final Set<com.google.android.gms.common.api.internal.ApiKey<?>> ids = new TLongArrayList();
  private volatile boolean mSuccess = true;
  private final MultiMap map;
  private final AtomicInteger nextId = new AtomicInteger(1);
  private final Set<com.google.android.gms.common.api.internal.ApiKey<?>> path = new TLongArrayList();
  private TelemetryData state;
  private final Map<com.google.android.gms.common.api.internal.ApiKey<?>, com.google.android.gms.common.api.internal.zabq<?>> this$0 = new ConcurrentHashMap(5, 0.75F, 1);
  private final GoogleApiAvailability type;
  
  static
  {
    CONFLICT = new Status(4, "The user must be signed in to make this API call.");
  }
  
  private GoogleApiManager(Context paramContext, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability)
  {
    context = paramContext;
    paramLooper = new Logger(paramLooper, this);
    handler = paramLooper;
    type = paramGoogleApiAvailability;
    map = new MultiMap(paramGoogleApiAvailability);
    if (DeviceProperties.isAuto(paramContext)) {
      mSuccess = false;
    }
    paramLooper.sendMessage(paramLooper.obtainMessage(6));
  }
  
  private final zabq execute(GoogleApi paramGoogleApi)
  {
    ApiKey localApiKey = paramGoogleApi.getApiKey();
    zabq localZabq2 = (zabq)this$0.get(localApiKey);
    zabq localZabq1 = localZabq2;
    if (localZabq2 == null)
    {
      localZabq1 = new zabq(this, paramGoogleApi);
      this$0.put(localApiKey, localZabq1);
    }
    if (localZabq1.isCancelled()) {
      ids.add(localApiKey);
    }
    localZabq1.parse();
    return localZabq1;
  }
  
  private final void execute(TaskCompletionSource paramTaskCompletionSource, int paramInt, GoogleApi paramGoogleApi)
  {
    if (paramInt != 0)
    {
      paramGoogleApi = zacd.e(this, paramInt, paramGoogleApi.getApiKey());
      if (paramGoogleApi != null)
      {
        paramTaskCompletionSource = paramTaskCompletionSource.getTask();
        Handler localHandler = handler;
        localHandler.getClass();
        paramTaskCompletionSource.addOnCompleteListener(new zabk(localHandler), paramGoogleApi);
      }
    }
  }
  
  private static Status get(ApiKey paramApiKey, ConnectionResult paramConnectionResult)
  {
    paramApiKey = paramApiKey.get();
    String str = String.valueOf(paramConnectionResult);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramApiKey).length() + 63 + str.length());
    localStringBuilder.append("API: ");
    localStringBuilder.append(paramApiKey);
    localStringBuilder.append(" is not available on this device. Connection failed with: ");
    localStringBuilder.append(str);
    return new Status(paramConnectionResult, localStringBuilder.toString());
  }
  
  public static GoogleApiManager get()
  {
    Object localObject = $assertionsDisabled;
    try
    {
      Preconditions.checkNotNull(length, "Must guarantee manager is non-null before using getInstance");
      GoogleApiManager localGoogleApiManager = length;
      return localGoogleApiManager;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private final TelemetryLoggingClient getHttpClient()
  {
    if (httpClient == null) {
      httpClient = TelemetryLogging.getClient(context);
    }
    return httpClient;
  }
  
  private final void handle()
  {
    TelemetryData localTelemetryData = state;
    if (localTelemetryData != null)
    {
      if ((localTelemetryData.getType() > 0) || (next())) {
        getHttpClient().getLocation(localTelemetryData);
      }
      state = null;
    }
  }
  
  public static GoogleApiManager open(Context paramContext)
  {
    Object localObject = $assertionsDisabled;
    try
    {
      if (length == null)
      {
        Looper localLooper = GmsClientSupervisor.getOrStartHandlerThread().getLooper();
        length = new GoogleApiManager(paramContext.getApplicationContext(), localLooper, GoogleApiAvailability.getInstance());
      }
      paramContext = length;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static void reportSignOut()
  {
    Object localObject1 = $assertionsDisabled;
    try
    {
      Object localObject2 = length;
      if (localObject2 != null)
      {
        clients.incrementAndGet();
        localObject2 = handler;
        ((Handler)localObject2).sendMessageAtFrontOfQueue(((Handler)localObject2).obtainMessage(10));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  final boolean add(ConnectionResult paramConnectionResult, int paramInt)
  {
    return type.add(context, paramConnectionResult, paramInt);
  }
  
  public final Task call(GoogleApi paramGoogleApi, RegisterListenerMethod paramRegisterListenerMethod, UnregisterListenerMethod paramUnregisterListenerMethod, Runnable paramRunnable)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    execute(localTaskCompletionSource, paramRegisterListenerMethod.getCommand(), paramGoogleApi);
    paramRegisterListenerMethod = new TObjectFloatHashMap(new zaci(paramRegisterListenerMethod, paramUnregisterListenerMethod, paramRunnable), localTaskCompletionSource);
    paramUnregisterListenerMethod = handler;
    paramUnregisterListenerMethod.sendMessage(paramUnregisterListenerMethod.obtainMessage(8, new zach(paramRegisterListenerMethod, clients.get(), paramGoogleApi)));
    return localTaskCompletionSource.getTask();
  }
  
  public final Task call(Iterable paramIterable)
  {
    paramIterable = new Metadata(paramIterable);
    Handler localHandler = handler;
    localHandler.sendMessage(localHandler.obtainMessage(2, paramIterable));
    return paramIterable.getTask();
  }
  
  public final Task clear(GoogleApi paramGoogleApi, ListenerHolder.ListenerKey paramListenerKey, int paramInt)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    execute(localTaskCompletionSource, paramInt, paramGoogleApi);
    paramListenerKey = new TObjectShortCustomHashMap(paramListenerKey, localTaskCompletionSource);
    Handler localHandler = handler;
    localHandler.sendMessage(localHandler.obtainMessage(13, new zach(paramListenerKey, clients.get(), paramGoogleApi)));
    return localTaskCompletionSource.getTask();
  }
  
  public final void close()
  {
    Handler localHandler = handler;
    localHandler.sendMessage(localHandler.obtainMessage(3));
  }
  
  public final void close(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!add(paramConnectionResult, paramInt))
    {
      Handler localHandler = handler;
      localHandler.sendMessage(localHandler.obtainMessage(5, paramInt, 0, paramConnectionResult));
    }
  }
  
  public final void close(GoogleApi paramGoogleApi)
  {
    Handler localHandler = handler;
    localHandler.sendMessage(localHandler.obtainMessage(7, paramGoogleApi));
  }
  
  public final void disconnect(GoogleApi paramGoogleApi, int paramInt, BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    paramApiMethodImpl = new SynchronizedHashtable4(paramInt, paramApiMethodImpl);
    Handler localHandler = handler;
    localHandler.sendMessage(localHandler.obtainMessage(4, new zach(paramApiMethodImpl, clients.get(), paramGoogleApi)));
  }
  
  public final void disconnect(GoogleApi paramGoogleApi, int paramInt, TaskApiCall paramTaskApiCall, TaskCompletionSource paramTaskCompletionSource, StatusExceptionMapper paramStatusExceptionMapper)
  {
    execute(paramTaskCompletionSource, paramTaskApiCall.getMilliseconds(), paramGoogleApi);
    paramTaskApiCall = new CollectionUtils.MultiValueMapAdapter(paramInt, paramTaskApiCall, paramTaskCompletionSource, paramStatusExceptionMapper);
    paramTaskCompletionSource = handler;
    paramTaskCompletionSource.sendMessage(paramTaskCompletionSource.obtainMessage(4, new zach(paramTaskApiCall, clients.get(), paramGoogleApi)));
  }
  
  final zabq get(ApiKey paramApiKey)
  {
    return (zabq)this$0.get(paramApiKey);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    int i = what;
    long l = 300000L;
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    switch (i)
    {
    default: 
      paramMessage = new StringBuilder(31);
      paramMessage.append("Unknown message id: ");
      paramMessage.append(i);
      Log.w("GoogleApiManager", paramMessage.toString());
      return false;
    case 19: 
      id = false;
      return true;
    case 18: 
      paramMessage = (zace)obj;
      if (state == 0L)
      {
        paramMessage = new TelemetryData(lock, Arrays.asList(new MethodInvocation[] { this$0 }));
        getHttpClient().getLocation(paramMessage);
        return true;
      }
      localObject1 = state;
      if (localObject1 != null)
      {
        localObject2 = ((TelemetryData)localObject1).getPositions();
        if ((((TelemetryData)localObject1).getType() == lock) && ((localObject2 == null) || (((List)localObject2).size() < shutdownWhenStartupFinishes)))
        {
          state.startTransition(this$0);
        }
        else
        {
          handler.removeMessages(17);
          handle();
        }
      }
      if (state == null)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(this$0);
        state = new TelemetryData(lock, (List)localObject1);
        localObject1 = handler;
        ((Handler)localObject1).sendMessageDelayed(((Handler)localObject1).obtainMessage(17), state);
        return true;
      }
      break;
    case 17: 
      handle();
      return true;
    case 16: 
      paramMessage = (zabs)obj;
      if (this$0.containsKey(zabs.getCacheKey(paramMessage)))
      {
        zabq.execute((zabq)this$0.get(zabs.getCacheKey(paramMessage)), paramMessage);
        return true;
      }
      break;
    case 15: 
      paramMessage = (zabs)obj;
      if (this$0.containsKey(zabs.getCacheKey(paramMessage)))
      {
        zabq.open((zabq)this$0.get(zabs.getCacheKey(paramMessage)), paramMessage);
        return true;
      }
      break;
    case 14: 
      paramMessage = (zaaf)obj;
      localObject1 = paramMessage.getResourcePath();
      if (!this$0.containsKey(localObject1))
      {
        paramMessage.create().setResult(Boolean.FALSE);
        return true;
      }
      boolean bool = zabq.renderBitmap((zabq)this$0.get(localObject1), false);
      paramMessage.create().setResult(Boolean.valueOf(bool));
      return true;
    case 12: 
      if (this$0.containsKey(obj))
      {
        ((zabq)this$0.get(obj)).isSyncing();
        return true;
      }
      break;
    case 11: 
      if (this$0.containsKey(obj))
      {
        ((zabq)this$0.get(obj)).read();
        return true;
      }
      break;
    case 10: 
      paramMessage = ids.iterator();
      while (paramMessage.hasNext())
      {
        localObject1 = (ApiKey)paramMessage.next();
        localObject1 = (zabq)this$0.remove(localObject1);
        if (localObject1 != null) {
          ((zabq)localObject1).close();
        }
      }
      ids.clear();
      return true;
    case 9: 
      if (this$0.containsKey(obj))
      {
        ((zabq)this$0.get(obj)).checkVersion();
        return true;
      }
      break;
    case 7: 
      execute((GoogleApi)obj);
      return true;
    case 6: 
      if ((context.getApplicationContext() instanceof Application))
      {
        BackgroundDetector.initialize((Application)context.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zabl(this));
        if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true))
        {
          data = 300000L;
          return true;
        }
      }
      break;
    case 5: 
      i = arg1;
      localObject2 = (ConnectionResult)obj;
      localObject3 = this$0.values().iterator();
      do
      {
        paramMessage = (Message)localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        paramMessage = (zabq)((Iterator)localObject3).next();
      } while (paramMessage.getInt() != i);
      if (paramMessage != null)
      {
        if (((ConnectionResult)localObject2).getErrorCode() == 13)
        {
          localObject1 = type.getErrorString(((ConnectionResult)localObject2).getErrorCode());
          localObject2 = ((ConnectionResult)localObject2).getErrorMessage();
          localObject3 = new StringBuilder(String.valueOf(localObject1).length() + 69 + String.valueOf(localObject2).length());
          ((StringBuilder)localObject3).append("Error resolution was canceled by the user, original error message: ");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(": ");
          ((StringBuilder)localObject3).append((String)localObject2);
          zabq.addDelta(paramMessage, new Status(17, ((StringBuilder)localObject3).toString()));
          return true;
        }
        zabq.addDelta(paramMessage, get(zabq.getPath(paramMessage), (ConnectionResult)localObject2));
        return true;
      }
      paramMessage = new StringBuilder(76);
      paramMessage.append("Could not find API instance ");
      paramMessage.append(i);
      paramMessage.append(" while trying to fail enqueued calls.");
      localObject1 = new Exception();
      Log.wtf("GoogleApiManager", paramMessage.toString(), (Throwable)localObject1);
      return true;
    case 4: 
    case 8: 
    case 13: 
      localObject2 = (zach)obj;
      localObject1 = (zabq)this$0.get(state.getApiKey());
      paramMessage = (Message)localObject1;
      if (localObject1 == null) {
        paramMessage = execute(state);
      }
      if ((paramMessage.isCancelled()) && (clients.get() != lock))
      {
        this$0.put(tag);
        paramMessage.close();
        return true;
      }
      paramMessage.next(this$0);
      return true;
    case 3: 
      paramMessage = this$0.values().iterator();
    case 2: 
    case 1: 
      while (paramMessage.hasNext())
      {
        localObject1 = (zabq)paramMessage.next();
        ((zabq)localObject1).remove();
        ((zabq)localObject1).parse();
        continue;
        paramMessage = (Metadata)obj;
        localObject1 = paramMessage.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ApiKey)((Iterator)localObject1).next();
          localObject3 = (zabq)this$0.get(localObject2);
          if (localObject3 == null)
          {
            paramMessage.parse((ApiKey)localObject2, new ConnectionResult(13), null);
            return true;
          }
          if (((zabq)localObject3).stateChanged())
          {
            paramMessage.parse((ApiKey)localObject2, ConnectionResult.RESULT_SUCCESS, ((zabq)localObject3).getContext().getEndpointPackageName());
          }
          else
          {
            ConnectionResult localConnectionResult = ((zabq)localObject3).getValue();
            if (localConnectionResult != null)
            {
              paramMessage.parse((ApiKey)localObject2, localConnectionResult, null);
            }
            else
            {
              ((zabq)localObject3).write(paramMessage);
              ((zabq)localObject3).parse();
              continue;
              if (true == ((Boolean)obj).booleanValue()) {
                l = 10000L;
              }
              data = l;
              handler.removeMessages(12);
              paramMessage = this$0.keySet().iterator();
              while (paramMessage.hasNext())
              {
                localObject1 = (ApiKey)paramMessage.next();
                localObject2 = handler;
                ((Handler)localObject2).sendMessageDelayed(((Handler)localObject2).obtainMessage(12, localObject1), data);
              }
            }
          }
        }
      }
    }
    return true;
  }
  
  final boolean next()
  {
    if (id) {
      return false;
    }
    RootTelemetryConfiguration localRootTelemetryConfiguration = RootTelemetryConfigManager.getInstance().getConfig();
    if ((localRootTelemetryConfiguration != null) && (!localRootTelemetryConfiguration.getMethodInvocationTelemetryEnabled())) {
      return false;
    }
    int i = map.add(context, 203400000);
    return (i == -1) || (i == 0);
  }
  
  final void release(zaae paramZaae)
  {
    Object localObject = $assertionsDisabled;
    try
    {
      if (connection == paramZaae)
      {
        connection = null;
        path.clear();
      }
      return;
    }
    catch (Throwable paramZaae)
    {
      throw paramZaae;
    }
  }
  
  public final int sendRequest()
  {
    return nextId.getAndIncrement();
  }
  
  final void showToast(MethodInvocation paramMethodInvocation, int paramInt1, long paramLong, int paramInt2)
  {
    Handler localHandler = handler;
    localHandler.sendMessage(localHandler.obtainMessage(18, new zace(paramMethodInvocation, paramInt1, paramLong, paramInt2)));
  }
  
  public final void start(zaae paramZaae)
  {
    Object localObject = $assertionsDisabled;
    try
    {
      if (connection != paramZaae)
      {
        connection = paramZaae;
        path.clear();
      }
      path.addAll(paramZaae.getAdded());
      return;
    }
    catch (Throwable paramZaae)
    {
      throw paramZaae;
    }
  }
  
  public final Task update(GoogleApi paramGoogleApi)
  {
    paramGoogleApi = new zaaf(paramGoogleApi.getApiKey());
    Handler localHandler = handler;
    localHandler.sendMessage(localHandler.obtainMessage(14, paramGoogleApi));
    return paramGoogleApi.create().getTask();
  }
}
