package com.google.android.gms.common.package_12.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.api.internal.zal;
import com.google.android.gms.common.api.internal.zau;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.MultiMap;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.IQ;
import com.google.android.gms.common.package_12.Api.Client;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApi;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.UnsupportedApiCallException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import v7.util.ArrayMap;

public final class zabq<O extends Api.ApiOptions>
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zau
{
  private final Queue<zai> buffer = new LinkedList();
  private int data = 0;
  private boolean handler;
  private final zaad index;
  private ConnectionResult key = null;
  private final ApiKey<O> path;
  private final List<com.google.android.gms.common.api.internal.zabs> query = new ArrayList();
  private final int status;
  private final Map<com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey<?>, com.google.android.gms.common.api.internal.zaci> table = new HashMap();
  @NotOnlyInitialized
  private final Api.Client this$0;
  private final zact type;
  private final Set<zal> values = new HashSet();
  
  public zabq(GoogleApiManager paramGoogleApiManager, GoogleApi paramGoogleApi)
  {
    Api.Client localClient = paramGoogleApi.appendTo(GoogleApiManager.getInstance(paramGoogleApiManager).getLooper(), this);
    this$0 = localClient;
    path = paramGoogleApi.getApiKey();
    index = new zaad();
    status = paramGoogleApi.getElementType();
    if (localClient.requiresSignIn())
    {
      type = paramGoogleApi.get(GoogleApiManager.resolve(paramGoogleApiManager), GoogleApiManager.getInstance(paramGoogleApiManager));
      return;
    }
    type = null;
  }
  
  private final void add()
  {
    ArrayList localArrayList = new ArrayList(buffer);
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Resource localResource = (Resource)localArrayList.get(i);
      if (!this$0.isConnected()) {
        return;
      }
      if (start(localResource)) {
        buffer.remove(localResource);
      }
      i += 1;
    }
  }
  
  private final void add(Status paramStatus)
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    add(paramStatus, null, false);
  }
  
  private final void add(Status paramStatus, Exception paramException, boolean paramBoolean)
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    int j = 0;
    int i;
    if (paramStatus != null) {
      i = 0;
    } else {
      i = 1;
    }
    if (paramException == null) {
      j = 1;
    }
    if (i != j)
    {
      Iterator localIterator = buffer.iterator();
      while (localIterator.hasNext())
      {
        Resource localResource = (Resource)localIterator.next();
        if ((!paramBoolean) || (size == 2))
        {
          if (paramStatus != null) {
            localResource.put(paramStatus);
          } else {
            localResource.get(paramException);
          }
          localIterator.remove();
        }
      }
      return;
    }
    throw new IllegalArgumentException("Status XOR exception should be null");
  }
  
  private final boolean close(ConnectionResult paramConnectionResult)
  {
    Object localObject = GoogleApiManager.pop();
    try
    {
      GoogleApiManager localGoogleApiManager = name;
      if ((GoogleApiManager.access$getConnection(localGoogleApiManager) != null) && (GoogleApiManager.getPath(localGoogleApiManager).contains(path)))
      {
        GoogleApiManager.access$getConnection(name).onError(paramConnectionResult, status);
        return true;
      }
      return false;
    }
    catch (Throwable paramConnectionResult)
    {
      throw paramConnectionResult;
    }
  }
  
  private final void execute(int paramInt)
  {
    remove();
    handler = true;
    index.add(paramInt, this$0.getLastDisconnectMessage());
    Object localObject = name;
    GoogleApiManager.getInstance((GoogleApiManager)localObject).sendMessageDelayed(Message.obtain(GoogleApiManager.getInstance((GoogleApiManager)localObject), 9, path), GoogleApiManager.e(name));
    localObject = name;
    GoogleApiManager.getInstance((GoogleApiManager)localObject).sendMessageDelayed(Message.obtain(GoogleApiManager.getInstance((GoogleApiManager)localObject), 11, path), GoogleApiManager.getDuration(name));
    GoogleApiManager.valueOf(name).add();
    localObject = table.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      nextkey.run();
    }
  }
  
  private final boolean get(boolean paramBoolean)
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    if ((this$0.isConnected()) && (table.size() == 0)) {
      if (index.set())
      {
        if (paramBoolean)
        {
          next();
          return false;
        }
      }
      else
      {
        this$0.disconnect("Timing out service connection.");
        return true;
      }
    }
    return false;
  }
  
  private final void next()
  {
    GoogleApiManager.getInstance(name).removeMessages(12, path);
    GoogleApiManager localGoogleApiManager = name;
    GoogleApiManager.getInstance(localGoogleApiManager).sendMessageDelayed(GoogleApiManager.getInstance(localGoogleApiManager).obtainMessage(12, path), GoogleApiManager.getBytes(name));
  }
  
  private final void open()
  {
    if (handler)
    {
      GoogleApiManager.getInstance(name).removeMessages(11, path);
      GoogleApiManager.getInstance(name).removeMessages(9, path);
      handler = false;
    }
  }
  
  private final Feature parse(Feature[] paramArrayOfFeature)
  {
    if (paramArrayOfFeature != null)
    {
      if (paramArrayOfFeature.length == 0) {
        return null;
      }
      Object localObject2 = this$0.getAvailableFeatures();
      Object localObject1 = localObject2;
      int j = 0;
      if (localObject2 == null) {
        localObject1 = new Feature[0];
      }
      int k = localObject1.length;
      localObject2 = new ArrayMap(k);
      int i = 0;
      Long localLong;
      while (i < k)
      {
        localLong = localObject1[i];
        ((Map)localObject2).put(localLong.getName(), Long.valueOf(localLong.getVersion()));
        i += 1;
      }
      k = paramArrayOfFeature.length;
      i = j;
      while (i < k)
      {
        localObject1 = paramArrayOfFeature[i];
        localLong = (Long)((Map)localObject2).get(((Feature)localObject1).getName());
        if (localLong != null)
        {
          if (localLong.longValue() < ((Feature)localObject1).getVersion()) {
            return localObject1;
          }
          i += 1;
        }
        else
        {
          return localObject1;
        }
      }
    }
    return null;
  }
  
  private final void process(Resource paramResource)
  {
    paramResource.get(index, isCancelled());
    try
    {
      paramResource.put(this);
      return;
    }
    catch (DeadObjectException paramResource)
    {
      for (;;) {}
    }
    onConnectionSuspended(1);
    this$0.disconnect("DeadObjectException thrown while running ApiCallRunner.");
  }
  
  private final void remove(ConnectionResult paramConnectionResult)
  {
    Iterator localIterator = values.iterator();
    while (localIterator.hasNext())
    {
      Metadata localMetadata = (Metadata)localIterator.next();
      String str;
      if (Objects.equal(paramConnectionResult, ConnectionResult.RESULT_SUCCESS)) {
        str = this$0.getEndpointPackageName();
      } else {
        str = null;
      }
      localMetadata.parse(path, paramConnectionResult, str);
    }
    values.clear();
  }
  
  private final boolean start(Resource paramResource)
  {
    if (!(paramResource instanceof Loader))
    {
      process(paramResource);
      return true;
    }
    Object localObject = (Loader)paramResource;
    Feature localFeature = parse(((Loader)localObject).get(this));
    if (localFeature == null)
    {
      process(paramResource);
      return true;
    }
    paramResource = this$0.getClass().getName();
    String str = localFeature.getName();
    long l = localFeature.getVersion();
    StringBuilder localStringBuilder = new StringBuilder(paramResource.length() + 77 + String.valueOf(str).length());
    localStringBuilder.append(paramResource);
    localStringBuilder.append(" could not execute call because it requires feature (");
    localStringBuilder.append(str);
    localStringBuilder.append(", ");
    localStringBuilder.append(l);
    localStringBuilder.append(").");
    Log.w("GoogleApiManager", localStringBuilder.toString());
    if ((GoogleApiManager.isSuccess(name)) && (((Loader)localObject).putAll(this)))
    {
      paramResource = new zabs(path, localFeature, null);
      int i = query.indexOf(paramResource);
      if (i >= 0)
      {
        paramResource = (zabs)query.get(i);
        GoogleApiManager.getInstance(name).removeMessages(15, paramResource);
        localObject = name;
        GoogleApiManager.getInstance((GoogleApiManager)localObject).sendMessageDelayed(Message.obtain(GoogleApiManager.getInstance((GoogleApiManager)localObject), 15, paramResource), GoogleApiManager.e(name));
      }
      else
      {
        query.add(paramResource);
        localObject = name;
        GoogleApiManager.getInstance((GoogleApiManager)localObject).sendMessageDelayed(Message.obtain(GoogleApiManager.getInstance((GoogleApiManager)localObject), 15, paramResource), GoogleApiManager.e(name));
        localObject = name;
        GoogleApiManager.getInstance((GoogleApiManager)localObject).sendMessageDelayed(Message.obtain(GoogleApiManager.getInstance((GoogleApiManager)localObject), 16, paramResource), GoogleApiManager.getDuration(name));
        paramResource = new ConnectionResult(2, null);
        if (!close(paramResource)) {
          name.add(paramResource, status);
        }
      }
      return false;
    }
    ((Resource)localObject).get(new UnsupportedApiCallException(localFeature));
    return true;
  }
  
  private final void update()
  {
    remove();
    remove(ConnectionResult.RESULT_SUCCESS);
    open();
    Iterator localIterator = table.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (zaci)localIterator.next();
      Api.Client localClient;
      if (parse(this$0.getRequiredFeatures()) != null)
      {
        localIterator.remove();
      }
      else
      {
        localObject = this$0;
        localClient = this$0;
      }
      try
      {
        ((RegisterListenerMethod)localObject).registerListener(localClient, new TaskCompletionSource());
      }
      catch (DeadObjectException localDeadObjectException)
      {
        for (;;) {}
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      localIterator.remove();
      continue;
      onConnectionSuspended(3);
      this$0.disconnect("DeadObjectException thrown while calling register listener method.");
    }
    add();
    next();
  }
  
  public final void checkVersion()
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    if (handler) {
      parse();
    }
  }
  
  final void clear()
  {
    data += 1;
  }
  
  public final void close()
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    add(GoogleApiManager.tag);
    index.i();
    Object localObject = table.keySet();
    int i = 0;
    localObject = (ListenerHolder.ListenerKey[])((Set)localObject).toArray(new ListenerHolder.ListenerKey[0]);
    int j = localObject.length;
    while (i < j)
    {
      next(new TObjectShortCustomHashMap(localObject[i], new TaskCompletionSource()));
      i += 1;
    }
    remove(new ConnectionResult(4));
    if (this$0.isConnected()) {
      this$0.onUserSignOut(new zabp(this));
    }
  }
  
  public final Map get()
  {
    return table;
  }
  
  public final Api.Client getContext()
  {
    return this$0;
  }
  
  public final int getInt()
  {
    return status;
  }
  
  public final ConnectionResult getValue()
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    return key;
  }
  
  public final boolean isCancelled()
  {
    return this$0.requiresSignIn();
  }
  
  public final boolean isSyncing()
  {
    return get(true);
  }
  
  public final void next(ConnectionResult paramConnectionResult, Exception paramException)
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    Object localObject = type;
    if (localObject != null) {
      ((zact)localObject).onStringAvailable();
    }
    remove();
    GoogleApiManager.valueOf(name).add();
    remove(paramConnectionResult);
    if (((this$0 instanceof IQ)) && (paramConnectionResult.getErrorCode() != 24))
    {
      GoogleApiManager.parseEntry(name, true);
      localObject = name;
      GoogleApiManager.getInstance((GoogleApiManager)localObject).sendMessageDelayed(GoogleApiManager.getInstance((GoogleApiManager)localObject).obtainMessage(19), 300000L);
    }
    if (paramConnectionResult.getErrorCode() == 4)
    {
      add(GoogleApiManager.call());
      return;
    }
    if (buffer.isEmpty())
    {
      key = paramConnectionResult;
      return;
    }
    if (paramException != null)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
      add(null, paramException, false);
      return;
    }
    if (GoogleApiManager.isSuccess(name))
    {
      add(GoogleApiManager.parse(path, paramConnectionResult), null, true);
      if (buffer.isEmpty()) {
        return;
      }
      if (close(paramConnectionResult)) {
        return;
      }
      if (!name.add(paramConnectionResult, status))
      {
        if (paramConnectionResult.getErrorCode() == 18) {
          handler = true;
        }
        if (handler)
        {
          paramConnectionResult = name;
          GoogleApiManager.getInstance(paramConnectionResult).sendMessageDelayed(Message.obtain(GoogleApiManager.getInstance(paramConnectionResult), 9, path), GoogleApiManager.e(name));
          return;
        }
        add(GoogleApiManager.parse(path, paramConnectionResult));
      }
    }
    else
    {
      add(GoogleApiManager.parse(path, paramConnectionResult));
    }
  }
  
  public final void next(Resource paramResource)
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    if (this$0.isConnected())
    {
      if (start(paramResource))
      {
        next();
        return;
      }
      buffer.add(paramResource);
      return;
    }
    buffer.add(paramResource);
    paramResource = key;
    if ((paramResource != null) && (paramResource.hasResolution()))
    {
      next(key, null);
      return;
    }
    parse();
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    if (Looper.myLooper() == GoogleApiManager.getInstance(name).getLooper())
    {
      update();
      return;
    }
    GoogleApiManager.getInstance(name).post(new zabm(this));
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    next(paramConnectionResult, null);
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    if (Looper.myLooper() == GoogleApiManager.getInstance(name).getLooper())
    {
      execute(paramInt);
      return;
    }
    GoogleApiManager.getInstance(name).post(new zabn(this, paramInt));
  }
  
  public final void parse()
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    if (!this$0.isConnected())
    {
      if (this$0.isConnecting()) {
        return;
      }
      Object localObject2 = name;
      try
      {
        Object localObject1 = GoogleApiManager.valueOf((GoogleApiManager)localObject2);
        localObject2 = GoogleApiManager.resolve((GoogleApiManager)localObject2);
        Object localObject3 = this$0;
        int i = ((MultiMap)localObject1).add((Context)localObject2, (Api.Client)localObject3);
        if (i != 0)
        {
          localObject1 = new ConnectionResult(i, null);
          localObject2 = this$0;
          localObject2 = localObject2.getClass().getName();
          localObject3 = localObject1.toString();
          i = ((String)localObject2).length();
          int j = ((String)localObject3).length();
          StringBuilder localStringBuilder = new StringBuilder(i + 35 + j);
          localStringBuilder.append("The service for ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(" is not available: ");
          localStringBuilder.append((String)localObject3);
          Log.w("GoogleApiManager", localStringBuilder.toString());
          next((ConnectionResult)localObject1, null);
          return;
        }
        localObject1 = name;
        localObject2 = this$0;
        localObject1 = new zabu((GoogleApiManager)localObject1, (Api.Client)localObject2, path);
        if (((Api.Client)localObject2).requiresSignIn()) {
          ((zact)Preconditions.checkNotNull(type)).init((zacs)localObject1);
        }
        localObject2 = this$0;
        try
        {
          ((Api.Client)localObject2).connect((BaseGmsClient.ConnectionProgressReportCallbacks)localObject1);
          return;
        }
        catch (SecurityException localSecurityException)
        {
          next(new ConnectionResult(10), localSecurityException);
          return;
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        next(new ConnectionResult(10), localIllegalStateException);
      }
    }
  }
  
  public final void put(ConnectionResult paramConnectionResult)
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    Api.Client localClient = this$0;
    String str1 = localClient.getClass().getName();
    String str2 = String.valueOf(paramConnectionResult);
    StringBuilder localStringBuilder = new StringBuilder(str1.length() + 25 + str2.length());
    localStringBuilder.append("onSignInFailed for ");
    localStringBuilder.append(str1);
    localStringBuilder.append(" with ");
    localStringBuilder.append(str2);
    localClient.disconnect(localStringBuilder.toString());
    next(paramConnectionResult, null);
  }
  
  public final void put(ConnectionResult paramConnectionResult, Attribute paramAttribute, boolean paramBoolean)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void read()
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    if (handler)
    {
      open();
      Object localObject = name;
      if (GoogleApiManager.getNext((GoogleApiManager)localObject).isGooglePlayServicesAvailable(GoogleApiManager.resolve((GoogleApiManager)localObject)) == 18) {
        localObject = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
      } else {
        localObject = new Status(22, "API failed to connect while resuming due to an unknown error.");
      }
      add((Status)localObject);
      this$0.disconnect("Timing out connection while resuming.");
    }
  }
  
  final int recv()
  {
    return data;
  }
  
  public final void remove()
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    key = null;
  }
  
  final boolean stateChanged()
  {
    return this$0.isConnected();
  }
  
  public final void write(Metadata paramMetadata)
  {
    Preconditions.checkHandlerThread(GoogleApiManager.getInstance(name));
    values.add(paramMetadata);
  }
}
