package com.google.android.gms.common.package_12.internal;

import android.content.Context;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Api.BaseClientBuilder;
import com.google.android.gms.common.package_12.Api.Client;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.signin.Connection;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zaaw
  implements zabf
{
  private boolean c;
  private Connection connection;
  private final Context context;
  private final ClientSettings data;
  private boolean empty;
  private boolean group;
  private final Map<Api<?>, Boolean> hash;
  private IAccountAccessor host;
  private boolean id;
  private int index;
  private final Lock lock;
  private boolean port;
  private int previous;
  private final ArrayList<Future<?>> queue = new ArrayList();
  private final Bundle result = new Bundle();
  private final Set<com.google.android.gms.common.api.Api.AnyClientKey> set = new HashSet();
  private final zabi this$0;
  private int type = 0;
  private final GoogleApiAvailabilityLight updater;
  private final com.google.android.gms.common.api.Api.AbstractClientBuilder<? extends zae, SignInOptions> url;
  private ConnectionResult value;
  
  public zaaw(zabi paramZabi, ClientSettings paramClientSettings, Map paramMap, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, com.google.android.gms.common.package_12.Api.AbstractClientBuilder paramAbstractClientBuilder, Lock paramLock, Context paramContext)
  {
    this$0 = paramZabi;
    data = paramClientSettings;
    hash = paramMap;
    updater = paramGoogleApiAvailabilityLight;
    url = paramAbstractClientBuilder;
    lock = paramLock;
    context = paramContext;
  }
  
  private final void add(ConnectionResult paramConnectionResult)
  {
    purge();
    load(paramConnectionResult.hasResolution() ^ true);
    this$0.clear(paramConnectionResult);
    this$0.r.run(paramConnectionResult);
  }
  
  private final void clear()
  {
    id = false;
    this$0.context.tag = Collections.emptySet();
    Iterator localIterator = set.iterator();
    while (localIterator.hasNext())
    {
      com.google.android.gms.common.package_12.Api.AnyClientKey localAnyClientKey = (com.google.android.gms.common.package_12.Api.AnyClientKey)localIterator.next();
      if (!this$0.items.containsKey(localAnyClientKey)) {
        this$0.items.put(localAnyClientKey, new ConnectionResult(17, null));
      }
    }
  }
  
  private final boolean f(ConnectionResult paramConnectionResult)
  {
    return (c) && (!paramConnectionResult.hasResolution());
  }
  
  private final boolean get()
  {
    int i = index - 1;
    index = i;
    if (i > 0) {
      return false;
    }
    if (i < 0)
    {
      Log.w("GACConnecting", this$0.context.getString());
      Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      add(new ConnectionResult(8, null));
      return false;
    }
    ConnectionResult localConnectionResult = value;
    if (localConnectionResult != null)
    {
      this$0.next = previous;
      add(localConnectionResult);
      return false;
    }
    return true;
  }
  
  private static final String getTypeString(int paramInt)
  {
    if (paramInt != 0) {
      return "STEP_GETTING_REMOTE_SERVICE";
    }
    return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
  }
  
  private final void load(boolean paramBoolean)
  {
    Object localObject = connection;
    if (localObject != null)
    {
      if ((((Api.Client)localObject).isConnected()) && (paramBoolean)) {
        ((Connection)localObject).add();
      }
      ((Api.Client)localObject).disconnect();
      localObject = (ClientSettings)Preconditions.checkNotNull(data);
      host = null;
    }
  }
  
  private final void purge()
  {
    ArrayList localArrayList = queue;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((Future)localArrayList.get(i)).cancel(true);
      i += 1;
    }
    queue.clear();
  }
  
  private final boolean read(int paramInt)
  {
    if (type != paramInt)
    {
      Log.w("GACConnecting", this$0.context.getString());
      Log.w("GACConnecting", "Unexpected callback in ".concat(toString()));
      int i = index;
      StringBuilder localStringBuilder = new StringBuilder(33);
      localStringBuilder.append("mRemainingConnections=");
      localStringBuilder.append(i);
      Log.w("GACConnecting", localStringBuilder.toString());
      Object localObject = getTypeString(type);
      String str = getTypeString(paramInt);
      localStringBuilder = new StringBuilder(((String)localObject).length() + 70 + str.length());
      localStringBuilder.append("GoogleApiClient connecting is in step ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" but received callback for step ");
      localStringBuilder.append(str);
      localObject = new Exception();
      Log.e("GACConnecting", localStringBuilder.toString(), (Throwable)localObject);
      add(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  private final void run()
  {
    this$0.wakeup();
    zabj.getExecutor().execute(new zaak(this));
    Object localObject = connection;
    if (localObject != null)
    {
      if (port) {
        ((Connection)localObject).add((IAccountAccessor)Preconditions.checkNotNull(host), group);
      }
      load(false);
    }
    localObject = this$0.items.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.google.android.gms.common.package_12.Api.AnyClientKey localAnyClientKey = (com.google.android.gms.common.package_12.Api.AnyClientKey)((Iterator)localObject).next();
      ((Api.Client)Preconditions.checkNotNull((Api.Client)this$0.delegate.get(localAnyClientKey))).disconnect();
    }
    if (result.isEmpty()) {
      localObject = null;
    } else {
      localObject = result;
    }
    this$0.r.run((Bundle)localObject);
  }
  
  private final void update(ConnectionResult paramConnectionResult, Attribute paramAttribute, boolean paramBoolean)
  {
    int i = paramAttribute.getState().getPriority();
    if (((!paramBoolean) || (paramConnectionResult.hasResolution()) || (updater.getErrorResolutionIntent(paramConnectionResult.getErrorCode()) != null)) && ((value == null) || (i < previous)))
    {
      value = paramConnectionResult;
      previous = i;
    }
    this$0.items.put(paramAttribute.getKey(), paramConnectionResult);
  }
  
  private final void write()
  {
    if (index != 0) {
      return;
    }
    if ((!id) || (empty))
    {
      ArrayList localArrayList = new ArrayList();
      type = 1;
      index = this$0.delegate.size();
      Iterator localIterator = this$0.delegate.keySet().iterator();
      while (localIterator.hasNext())
      {
        com.google.android.gms.common.package_12.Api.AnyClientKey localAnyClientKey = (com.google.android.gms.common.package_12.Api.AnyClientKey)localIterator.next();
        if (this$0.items.containsKey(localAnyClientKey))
        {
          if (get()) {
            run();
          }
        }
        else {
          localArrayList.add((Api.Client)this$0.delegate.get(localAnyClientKey));
        }
      }
      if (!localArrayList.isEmpty()) {
        queue.add(zabj.getExecutor().submit(new zaap(this, localArrayList)));
      }
    }
  }
  
  public final BaseImplementation.ApiMethodImpl add(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final void add(int paramInt)
  {
    add(new ConnectionResult(8, null));
  }
  
  public final boolean add()
  {
    purge();
    load(true);
    this$0.clear(null);
    return true;
  }
  
  public final void execute()
  {
    this$0.items.clear();
    id = false;
    value = null;
    type = 0;
    c = true;
    empty = false;
    port = false;
    HashMap localHashMap = new HashMap();
    Object localObject1 = hash.keySet().iterator();
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Attribute)((Iterator)localObject1).next();
      localObject3 = (Api.Client)Preconditions.checkNotNull((Api.Client)this$0.delegate.get(((Attribute)localObject2).getKey()));
      int j;
      if (((Attribute)localObject2).getState().getPriority() == 1) {
        j = 1;
      } else {
        j = 0;
      }
      i |= j;
      boolean bool = ((Boolean)hash.get(localObject2)).booleanValue();
      if (((Api.Client)localObject3).requiresSignIn())
      {
        id = true;
        if (bool) {
          set.add(((Attribute)localObject2).getKey());
        } else {
          c = false;
        }
      }
      localHashMap.put(localObject3, new zaal(this, (Attribute)localObject2, bool));
    }
    if (i != 0) {
      id = false;
    }
    if (id)
    {
      Preconditions.checkNotNull(data);
      Preconditions.checkNotNull(url);
      data.set(Integer.valueOf(System.identityHashCode(this$0.context)));
      localObject1 = new zaat(this, null);
      localObject2 = url;
      localObject3 = context;
      Looper localLooper = this$0.context.getLooper();
      ClientSettings localClientSettings = data;
      connection = ((Connection)((com.google.android.gms.common.package_12.Api.AbstractClientBuilder)localObject2).buildClient((Context)localObject3, localLooper, localClientSettings, localClientSettings.entrySet(), (GoogleApiClient.ConnectionCallbacks)localObject1, (GoogleApiClient.OnConnectionFailedListener)localObject1));
    }
    index = this$0.delegate.size();
    queue.add(zabj.getExecutor().submit(new zaao(this, localHashMap)));
  }
  
  public final BaseImplementation.ApiMethodImpl pollQueue(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    this$0.context.queue.add(paramApiMethodImpl);
    return paramApiMethodImpl;
  }
  
  public final void refreshAdapter() {}
  
  public final void update(Bundle paramBundle)
  {
    if (!read(1)) {
      return;
    }
    if (paramBundle != null) {
      result.putAll(paramBundle);
    }
    if (get()) {
      run();
    }
  }
  
  public final void write(ConnectionResult paramConnectionResult, Attribute paramAttribute, boolean paramBoolean)
  {
    if (!read(1)) {
      return;
    }
    update(paramConnectionResult, paramAttribute, paramBoolean);
    if (get()) {
      run();
    }
  }
}
