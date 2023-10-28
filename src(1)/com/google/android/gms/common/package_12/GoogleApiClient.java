package com.google.android.gms.common.package_12;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.package_11.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zab;
import com.google.android.gms.common.package_12.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.package_12.internal.ConnectionCallbacks;
import com.google.android.gms.common.package_12.internal.LifecycleActivity;
import com.google.android.gms.common.package_12.internal.ListenerHolder;
import com.google.android.gms.common.package_12.internal.MainActivity;
import com.google.android.gms.common.package_12.internal.MediaBrowserCompat.ConnectionCallback;
import com.google.android.gms.common.package_12.internal.OnConnectionFailedListener;
import com.google.android.gms.common.package_12.internal.SignInConnectionListener;
import com.google.android.gms.common.package_12.internal.zabe;
import com.google.android.gms.common.package_12.internal.zada;
import com.google.android.gms.signin.R.id;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import v7.util.ArrayMap;

@Deprecated
@KeepForSdk
public abstract class GoogleApiClient
{
  @KeepForSdk
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  private static final Set<com.google.android.gms.common.api.GoogleApiClient> mChildren = Collections.newSetFromMap(new WeakHashMap());
  
  public GoogleApiClient() {}
  
  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    Set localSet = mChildren;
    try
    {
      String str = String.valueOf(paramString).concat("  ");
      Iterator localIterator = localSet.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        GoogleApiClient localGoogleApiClient = (GoogleApiClient)localIterator.next();
        paramPrintWriter.append(paramString).append("GoogleApiClient#").println(i);
        localGoogleApiClient.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public static Set getAllClients()
  {
    Set localSet = mChildren;
    try
    {
      return localSet;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract PendingResult clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public BaseImplementation.ApiMethodImpl enqueue(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    throw new UnsupportedOperationException();
  }
  
  public BaseImplementation.ApiMethodImpl execute(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    throw new UnsupportedOperationException();
  }
  
  public void get(zada paramZada)
  {
    throw new UnsupportedOperationException();
  }
  
  public Api.Client getClient(Api.AnyClientKey paramAnyClientKey)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract ConnectionResult getConnectionResult(Attribute paramAttribute);
  
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }
  
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean hasApi(Attribute paramAttribute)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(Attribute paramAttribute);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public void maybeSignOut()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public ListenerHolder registerListener(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public void shutdown(zada paramZada)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void stopAutoManage(FragmentActivity paramFragmentActivity);
  
  public abstract void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  @Deprecated
  @KeepForSdk
  public final class Builder
  {
    private String branch = getClass().getName();
    private LifecycleActivity id;
    private final Set<com.google.android.gms.common.api.Scope> items = new HashSet();
    private Account list;
    private int log;
    private final ArrayList<com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks> modules = new ArrayList();
    private Looper name = getMainLooper();
    private GoogleApiAvailability options = GoogleApiAvailability.getInstance();
    private final ArrayList<com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener> parameters = new ArrayList();
    private String path = getPackageName();
    private final Map<Api<?>, zab> pool = new ArrayMap();
    private final Set<com.google.android.gms.common.api.Scope> queue = new HashSet();
    private View root;
    private GoogleApiClient.OnConnectionFailedListener size;
    private com.google.android.gms.common.api.Api.AbstractClientBuilder<? extends zae, SignInOptions> stage = R.id.security;
    private final Map<Api<?>, com.google.android.gms.common.api.Api.ApiOptions> this$0 = new ArrayMap();
    private int type = -1;
    
    public Builder() {}
    
    public Builder(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this();
      Preconditions.checkNotNull(paramConnectionCallbacks, "Must provide a connected listener");
      modules.add(paramConnectionCallbacks);
      Preconditions.checkNotNull(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      parameters.add(paramOnConnectionFailedListener);
    }
    
    private final void put(Attribute paramAttribute, Api.ApiOptions paramApiOptions, Scope... paramVarArgs)
    {
      paramApiOptions = new HashSet(((Api.BaseClientBuilder)Preconditions.checkNotNull(paramAttribute.getState(), "Base client builder must not be null")).getImpliedScopes(paramApiOptions));
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramApiOptions.add(paramVarArgs[i]);
        i += 1;
      }
      pool.put(paramAttribute, new com.google.android.gms.common.internal.Attribute(paramApiOptions));
    }
    
    public Builder addApi(Attribute paramAttribute)
    {
      Preconditions.checkNotNull(paramAttribute, "Api must not be null");
      this$0.put(paramAttribute, null);
      paramAttribute = ((Api.BaseClientBuilder)Preconditions.checkNotNull(paramAttribute.getState(), "Base client builder must not be null")).getImpliedScopes(null);
      queue.addAll(paramAttribute);
      items.addAll(paramAttribute);
      return this;
    }
    
    public Builder addApi(Attribute paramAttribute, Api.ApiOptions.HasOptions paramHasOptions)
    {
      Preconditions.checkNotNull(paramAttribute, "Api must not be null");
      Preconditions.checkNotNull(paramHasOptions, "Null options are not permitted for this Api");
      this$0.put(paramAttribute, paramHasOptions);
      paramAttribute = ((Api.BaseClientBuilder)Preconditions.checkNotNull(paramAttribute.getState(), "Base client builder must not be null")).getImpliedScopes(paramHasOptions);
      queue.addAll(paramAttribute);
      items.addAll(paramAttribute);
      return this;
    }
    
    public Builder addApiIfAvailable(Attribute paramAttribute, Api.ApiOptions.HasOptions paramHasOptions, Scope... paramVarArgs)
    {
      Preconditions.checkNotNull(paramAttribute, "Api must not be null");
      Preconditions.checkNotNull(paramHasOptions, "Null options are not permitted for this Api");
      this$0.put(paramAttribute, paramHasOptions);
      put(paramAttribute, paramHasOptions, paramVarArgs);
      return this;
    }
    
    public Builder addApiIfAvailable(Attribute paramAttribute, Scope... paramVarArgs)
    {
      Preconditions.checkNotNull(paramAttribute, "Api must not be null");
      this$0.put(paramAttribute, null);
      put(paramAttribute, null, paramVarArgs);
      return this;
    }
    
    public Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      Preconditions.checkNotNull(paramConnectionCallbacks, "Listener must not be null");
      modules.add(paramConnectionCallbacks);
      return this;
    }
    
    public Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      Preconditions.checkNotNull(paramOnConnectionFailedListener, "Listener must not be null");
      parameters.add(paramOnConnectionFailedListener);
      return this;
    }
    
    public Builder addScope(Scope paramScope)
    {
      Preconditions.checkNotNull(paramScope, "Scope must not be null");
      items.add(paramScope);
      return this;
    }
    
    public GoogleApiClient build()
    {
      Preconditions.checkArgument(this$0.isEmpty() ^ true, "must call addApi() to add at least one API");
      Object localObject3 = remove();
      Map localMap = ((ClientSettings)localObject3).get();
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this$0.keySet().iterator();
      Object localObject1 = null;
      int j = 0;
      boolean bool;
      while (localIterator.hasNext())
      {
        localObject2 = (Attribute)localIterator.next();
        Object localObject4 = this$0.get(localObject2);
        if (localMap.get(localObject2) != null) {
          bool = true;
        } else {
          bool = false;
        }
        localArrayMap1.put(localObject2, Boolean.valueOf(bool));
        Object localObject5 = new MediaBrowserCompat.ConnectionCallback((Attribute)localObject2, bool);
        localArrayList.add(localObject5);
        Api.AbstractClientBuilder localAbstractClientBuilder = (Api.AbstractClientBuilder)Preconditions.checkNotNull(((Attribute)localObject2).getValue());
        localObject5 = localAbstractClientBuilder.buildClient(GoogleApiClient.this, name, (ClientSettings)localObject3, localObject4, (GoogleApiClient.ConnectionCallbacks)localObject5, (GoogleApiClient.OnConnectionFailedListener)localObject5);
        localArrayMap2.put(((Attribute)localObject2).getKey(), localObject5);
        i = j;
        if (localAbstractClientBuilder.getPriority() == 1) {
          if (localObject4 != null) {
            i = 1;
          } else {
            i = 0;
          }
        }
        j = i;
        if (((Api.Client)localObject5).providesSignIn()) {
          if (localObject1 == null)
          {
            localObject1 = localObject2;
            j = i;
          }
          else
          {
            localObject2 = ((Attribute)localObject2).get();
            localObject1 = ((Attribute)localObject1).get();
            localObject3 = new StringBuilder(String.valueOf(localObject2).length() + 21 + String.valueOf(localObject1).length());
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(" cannot be used with ");
            ((StringBuilder)localObject3).append((String)localObject1);
            throw new IllegalStateException(((StringBuilder)localObject3).toString());
          }
        }
      }
      if (localObject1 != null) {
        if (j == 0)
        {
          if (list == null) {
            bool = true;
          } else {
            bool = false;
          }
          Preconditions.checkState(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { ((Attribute)localObject1).get() });
          Preconditions.checkState(items.equals(queue), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { ((Attribute)localObject1).get() });
        }
        else
        {
          localObject1 = ((Attribute)localObject1).get();
          localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 82);
          ((StringBuilder)localObject2).append("With using ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
          throw new IllegalStateException(((StringBuilder)localObject2).toString());
        }
      }
      int i = zabe.transform(localArrayMap2.values(), true);
      Object localObject2 = new zabe(GoogleApiClient.this, new ReentrantLock(), name, (ClientSettings)localObject3, options, stage, localArrayMap1, modules, parameters, localArrayMap2, type, i, localArrayList);
      localObject1 = GoogleApiClient.split();
      try
      {
        GoogleApiClient.split().add(localObject2);
        if (type >= 0)
        {
          MainActivity.removeTab(id).get(type, (GoogleApiClient)localObject2, size);
          return localObject2;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      return localThrowable;
    }
    
    public Builder enableAutoManage(FragmentActivity paramFragmentActivity, int paramInt, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      paramFragmentActivity = new LifecycleActivity(paramFragmentActivity);
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "clientId must be non-negative");
      type = paramInt;
      size = paramOnConnectionFailedListener;
      id = paramFragmentActivity;
      return this;
    }
    
    public Builder enableAutoManage(FragmentActivity paramFragmentActivity, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      enableAutoManage(paramFragmentActivity, 0, paramOnConnectionFailedListener);
      return this;
    }
    
    public final ClientSettings remove()
    {
      SignInOptions localSignInOptions = SignInOptions.SET;
      Map localMap = this$0;
      Attribute localAttribute = R.id.label;
      if (localMap.containsKey(localAttribute)) {
        localSignInOptions = (SignInOptions)this$0.get(localAttribute);
      }
      return new ClientSettings(list, items, pool, log, root, path, branch, localSignInOptions, false);
    }
    
    public Builder setAccountName(String paramString)
    {
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = new Account(paramString, "com.google");
      }
      list = paramString;
      return this;
    }
    
    public Builder setGravityForPopups(int paramInt)
    {
      log = paramInt;
      return this;
    }
    
    public Builder setHandler(Handler paramHandler)
    {
      Preconditions.checkNotNull(paramHandler, "Handler must not be null");
      name = paramHandler.getLooper();
      return this;
    }
    
    public Builder setViewForPopups(View paramView)
    {
      Preconditions.checkNotNull(paramView, "View must not be null");
      root = paramView;
      return this;
    }
    
    public Builder useDefaultAccount()
    {
      setAccountName("<<default account>>");
      return this;
    }
  }
  
  @Deprecated
  public abstract interface ConnectionCallbacks
    extends ConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
  }
  
  @Deprecated
  public abstract interface OnConnectionFailedListener
    extends OnConnectionFailedListener
  {}
}
