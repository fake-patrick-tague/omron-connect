package com.google.android.gms.common.package_12;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.util.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.Builder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.internal.ApiExceptionMapper;
import com.google.android.gms.common.package_12.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.package_12.internal.BasePendingResult;
import com.google.android.gms.common.package_12.internal.GoogleApiManager;
import com.google.android.gms.common.package_12.internal.ListenerHolder;
import com.google.android.gms.common.package_12.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.package_12.internal.ListenerHolders;
import com.google.android.gms.common.package_12.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.package_12.internal.RegisterListenerMethod;
import com.google.android.gms.common.package_12.internal.RegistrationMethods;
import com.google.android.gms.common.package_12.internal.StatusExceptionMapper;
import com.google.android.gms.common.package_12.internal.TaskApiCall;
import com.google.android.gms.common.package_12.internal.UnregisterListenerMethod;
import com.google.android.gms.common.package_12.internal.zaae;
import com.google.android.gms.common.package_12.internal.zabq;
import com.google.android.gms.common.package_12.internal.zabv;
import com.google.android.gms.common.package_12.internal.zact;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

@KeepForSdk
public abstract class GoogleApi<O extends com.google.android.gms.common.api.Api.ApiOptions>
  implements HasApiKey<O>
{
  @NotOnlyInitialized
  private final GoogleApiClient appView;
  private final String authCookie;
  private final com.google.android.gms.common.api.internal.ApiKey<O> mApiKey;
  private final Looper mLooper;
  private final StatusExceptionMapper source;
  protected final GoogleApiManager this$0;
  private final int type;
  private final Api<O> val$clazz;
  private final Context val$context;
  private final O val$field;
  
  public GoogleApi(Activity paramActivity, Attribute paramAttribute, Api.ApiOptions paramApiOptions, Settings paramSettings)
  {
    this(paramActivity, paramActivity, paramAttribute, paramApiOptions, paramSettings);
  }
  
  public GoogleApi(Activity paramActivity, Attribute paramAttribute, Api.ApiOptions paramApiOptions, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramActivity, paramAttribute, paramApiOptions, localBuilder.build());
  }
  
  private GoogleApi(Context paramContext, Activity paramActivity, Attribute paramAttribute, Api.ApiOptions paramApiOptions, Settings paramSettings)
  {
    Preconditions.checkNotNull(paramContext, "Null context is not permitted.");
    Preconditions.checkNotNull(paramAttribute, "Api must not be null.");
    Preconditions.checkNotNull(paramSettings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    val$context = paramContext.getApplicationContext();
    boolean bool = PlatformVersion.isAtLeastR();
    localObject2 = null;
    localObject1 = localObject2;
    if (bool) {}
    try
    {
      localObject1 = Context.class.getMethod("getAttributionTag", new Class[0]);
      paramContext = ((Method)localObject1).invoke(paramContext, new Object[0]);
      localObject1 = (String)paramContext;
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
    authCookie = ((String)localObject1);
    val$clazz = paramAttribute;
    val$field = paramApiOptions;
    mLooper = inputStream;
    paramContext = com.google.android.gms.common.package_12.internal.ApiKey.addAttribute(paramAttribute, paramApiOptions, (String)localObject1);
    mApiKey = paramContext;
    appView = new zabv(this);
    paramAttribute = GoogleApiManager.open(val$context);
    this$0 = paramAttribute;
    type = paramAttribute.sendRequest();
    source = source;
    if ((paramActivity != null) && (!(paramActivity instanceof GoogleApiActivity)) && (Looper.myLooper() == Looper.getMainLooper())) {
      zaae.toString(paramActivity, paramAttribute, paramContext);
    }
    paramAttribute.close(this);
  }
  
  public GoogleApi(Context paramContext, Attribute paramAttribute, Api.ApiOptions paramApiOptions, Looper paramLooper, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramContext, paramAttribute, paramApiOptions, localBuilder.build());
  }
  
  public GoogleApi(Context paramContext, Attribute paramAttribute, Api.ApiOptions paramApiOptions, Settings paramSettings)
  {
    this(paramContext, null, paramAttribute, paramApiOptions, paramSettings);
  }
  
  public GoogleApi(Context paramContext, Attribute paramAttribute, Api.ApiOptions paramApiOptions, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramContext, paramAttribute, paramApiOptions, localBuilder.build());
  }
  
  private final Task call(int paramInt, TaskApiCall paramTaskApiCall)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this$0.disconnect(this, paramInt, paramTaskApiCall, localTaskCompletionSource, source);
    return localTaskCompletionSource.getTask();
  }
  
  private final BaseImplementation.ApiMethodImpl get(int paramInt, BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    paramApiMethodImpl.call();
    this$0.disconnect(this, paramInt, paramApiMethodImpl);
    return paramApiMethodImpl;
  }
  
  public final Api.Client appendTo(Looper paramLooper, zabq paramZabq)
  {
    ClientSettings localClientSettings = createClientSettingsBuilder().build();
    paramLooper = ((Api.AbstractClientBuilder)Preconditions.checkNotNull(val$clazz.getValue())).buildClient(val$context, paramLooper, localClientSettings, val$field, paramZabq, paramZabq);
    paramZabq = getContextAttributionTag();
    if ((paramZabq != null) && ((paramLooper instanceof BaseGmsClient))) {
      ((BaseGmsClient)paramLooper).setAttributionTag(paramZabq);
    }
    if ((paramZabq != null) && ((paramLooper instanceof NonGmsServiceBrokerClient))) {
      ((NonGmsServiceBrokerClient)paramLooper).setTo(paramZabq);
    }
    return paramLooper;
  }
  
  public GoogleApiClient asGoogleApiClient()
  {
    return appView;
  }
  
  protected ClientSettings.Builder createClientSettingsBuilder()
  {
    ClientSettings.Builder localBuilder = new ClientSettings.Builder();
    Object localObject = val$field;
    if ((localObject instanceof Api.ApiOptions.HasGoogleSignInAccountOptions))
    {
      localObject = ((Api.ApiOptions.HasGoogleSignInAccountOptions)localObject).getGoogleSignInAccount();
      if (localObject != null)
      {
        localObject = ((GoogleSignInAccount)localObject).getAccount();
        break label69;
      }
    }
    localObject = val$field;
    if ((localObject instanceof Api.ApiOptions.HasAccountOptions)) {
      localObject = ((Api.ApiOptions.HasAccountOptions)localObject).getAccount();
    } else {
      localObject = null;
    }
    label69:
    localBuilder.setAccount((Account)localObject);
    localObject = val$field;
    if ((localObject instanceof Api.ApiOptions.HasGoogleSignInAccountOptions))
    {
      localObject = ((Api.ApiOptions.HasGoogleSignInAccountOptions)localObject).getGoogleSignInAccount();
      if (localObject == null) {
        localObject = Collections.emptySet();
      } else {
        localObject = ((GoogleSignInAccount)localObject).getRequestedScopes();
      }
    }
    else
    {
      localObject = Collections.emptySet();
    }
    localBuilder.addAll((Collection)localObject);
    localBuilder.addModules(val$context.getClass().getName());
    localBuilder.setRealClientPackageName(val$context.getPackageName());
    return localBuilder;
  }
  
  protected Task disconnectService()
  {
    return this$0.update(this);
  }
  
  public BaseImplementation.ApiMethodImpl doBestEffortWrite(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    get(2, paramApiMethodImpl);
    return paramApiMethodImpl;
  }
  
  public Task doBestEffortWrite(TaskApiCall paramTaskApiCall)
  {
    return call(2, paramTaskApiCall);
  }
  
  public BaseImplementation.ApiMethodImpl doRead(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    get(0, paramApiMethodImpl);
    return paramApiMethodImpl;
  }
  
  public Task doRead(TaskApiCall paramTaskApiCall)
  {
    return call(0, paramTaskApiCall);
  }
  
  public Task doRegisterEventListener(RegisterListenerMethod paramRegisterListenerMethod, UnregisterListenerMethod paramUnregisterListenerMethod)
  {
    Preconditions.checkNotNull(paramRegisterListenerMethod);
    Preconditions.checkNotNull(paramUnregisterListenerMethod);
    Preconditions.checkNotNull(paramRegisterListenerMethod.getListenerKey(), "Listener has already been released.");
    Preconditions.checkNotNull(paramUnregisterListenerMethod.getListenerKey(), "Listener has already been released.");
    Preconditions.checkArgument(Objects.equal(paramRegisterListenerMethod.getListenerKey(), paramUnregisterListenerMethod.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
    return this$0.call(this, paramRegisterListenerMethod, paramUnregisterListenerMethod, UpdateService.4.NIL);
  }
  
  public Task doRegisterEventListener(RegistrationMethods paramRegistrationMethods)
  {
    Preconditions.checkNotNull(paramRegistrationMethods);
    Preconditions.checkNotNull(register.getListenerKey(), "Listener has already been released.");
    Preconditions.checkNotNull(operation.getListenerKey(), "Listener has already been released.");
    return this$0.call(this, register, operation, value);
  }
  
  public Task doUnregisterEventListener(ListenerHolder.ListenerKey paramListenerKey)
  {
    return doUnregisterEventListener(paramListenerKey, 0);
  }
  
  public Task doUnregisterEventListener(ListenerHolder.ListenerKey paramListenerKey, int paramInt)
  {
    Preconditions.checkNotNull(paramListenerKey, "Listener key cannot be null.");
    return this$0.clear(this, paramListenerKey, paramInt);
  }
  
  public BaseImplementation.ApiMethodImpl doWrite(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    get(1, paramApiMethodImpl);
    return paramApiMethodImpl;
  }
  
  public Task doWrite(TaskApiCall paramTaskApiCall)
  {
    return call(1, paramTaskApiCall);
  }
  
  public final zact get(Context paramContext, Handler paramHandler)
  {
    return new zact(paramContext, paramHandler, createClientSettingsBuilder().build());
  }
  
  public final com.google.android.gms.common.package_12.internal.ApiKey getApiKey()
  {
    return mApiKey;
  }
  
  public Api.ApiOptions getApiOptions()
  {
    return val$field;
  }
  
  public Context getApplicationContext()
  {
    return val$context;
  }
  
  protected String getContextAttributionTag()
  {
    return authCookie;
  }
  
  protected String getContextFeatureId()
  {
    return authCookie;
  }
  
  public final int getElementType()
  {
    return type;
  }
  
  public Looper getLooper()
  {
    return mLooper;
  }
  
  public ListenerHolder registerListener(Object paramObject, String paramString)
  {
    return ListenerHolders.createListenerHolder(paramObject, mLooper, paramString);
  }
  
  @KeepForSdk
  public class Settings
  {
    @KeepForSdk
    public static final Settings DEFAULT_SETTINGS = new Builder().build();
    public final Looper inputStream;
    
    private Settings(Account paramAccount, Looper paramLooper)
    {
      inputStream = paramLooper;
    }
    
    @KeepForSdk
    public class Builder
    {
      private Looper backlogSize;
      private StatusExceptionMapper rcvBufSize;
      
      public Builder() {}
      
      public GoogleApi.Settings build()
      {
        if (rcvBufSize == null) {
          rcvBufSize = new ApiExceptionMapper();
        }
        if (backlogSize == null) {
          backlogSize = Looper.getMainLooper();
        }
        return new GoogleApi.Settings(rcvBufSize, null, backlogSize, null);
      }
      
      public Builder setLooper(Looper paramLooper)
      {
        Preconditions.checkNotNull(paramLooper, "Looper must not be null.");
        backlogSize = paramLooper;
        return this;
      }
      
      public Builder setMapper(StatusExceptionMapper paramStatusExceptionMapper)
      {
        Preconditions.checkNotNull(paramStatusExceptionMapper, "StatusExceptionMapper must not be null.");
        rcvBufSize = paramStatusExceptionMapper;
        return this;
      }
    }
  }
}
