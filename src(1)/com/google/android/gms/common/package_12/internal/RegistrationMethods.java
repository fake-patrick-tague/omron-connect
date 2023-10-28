package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class RegistrationMethods<A extends Api.AnyClient, L>
{
  public final UnregisterListenerMethod<A, L> operation;
  @KeepForSdk
  public final RegisterListenerMethod<A, L> register;
  public final Runnable value;
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  @KeepForSdk
  public class Builder<A extends Api.AnyClient, L>
  {
    private Feature[] connectionFactory;
    private com.google.android.gms.common.api.internal.RemoteCall<A, TaskCompletionSource<Boolean>> errors;
    private Runnable hostnameVerifier = zacj.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    private com.google.android.gms.common.api.internal.ListenerHolder<L> initializer;
    private int policy;
    private boolean sslSocketFactory = true;
    private com.google.android.gms.common.api.internal.RemoteCall<A, TaskCompletionSource<Void>> state;
    
    private Builder() {}
    
    public RegistrationMethods build()
    {
      Object localObject = state;
      boolean bool2 = true;
      boolean bool1;
      if (localObject != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must set register function");
      if (errors != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must set unregister function");
      if (initializer != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must set holder");
      localObject = (ListenerHolder.ListenerKey)Preconditions.checkNotNull(initializer.getListenerKey(), "Key must not be null");
      return new RegistrationMethods(new zack(this, initializer, connectionFactory, sslSocketFactory, policy), new zacl(this, (ListenerHolder.ListenerKey)localObject), hostnameVerifier, null);
    }
    
    public Builder onConnectionSuspended(Runnable paramRunnable)
    {
      hostnameVerifier = paramRunnable;
      return this;
    }
    
    public Builder register(RemoteCall paramRemoteCall)
    {
      state = paramRemoteCall;
      return this;
    }
    
    public Builder setAutoResolveMissingFeatures(boolean paramBoolean)
    {
      sslSocketFactory = paramBoolean;
      return this;
    }
    
    public Builder setFeatures(Feature... paramVarArgs)
    {
      connectionFactory = paramVarArgs;
      return this;
    }
    
    public Builder setMethodKey(int paramInt)
    {
      policy = paramInt;
      return this;
    }
    
    public Builder unregister(RemoteCall paramRemoteCall)
    {
      errors = paramRemoteCall;
      return this;
    }
    
    public Builder withHolder(ListenerHolder paramListenerHolder)
    {
      initializer = paramListenerHolder;
      return this;
    }
  }
}
