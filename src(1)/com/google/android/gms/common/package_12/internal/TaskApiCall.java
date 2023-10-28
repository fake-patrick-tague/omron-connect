package com.google.android.gms.common.package_12.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class TaskApiCall<A extends com.google.android.gms.common.api.Api.AnyClient, ResultT>
{
  private final boolean derived;
  private final int milliseconds;
  private final Feature[] valueTable;
  
  public TaskApiCall()
  {
    valueTable = null;
    derived = false;
    milliseconds = 0;
  }
  
  protected TaskApiCall(Feature[] paramArrayOfFeature, boolean paramBoolean, int paramInt)
  {
    valueTable = paramArrayOfFeature;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfFeature != null)
    {
      bool1 = bool2;
      if (paramBoolean) {
        bool1 = true;
      }
    }
    derived = bool1;
    milliseconds = paramInt;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  protected abstract void doExecute(com.google.android.gms.common.package_12.Api.AnyClient paramAnyClient, TaskCompletionSource paramTaskCompletionSource)
    throws RemoteException;
  
  public final int getMilliseconds()
  {
    return milliseconds;
  }
  
  public final Feature[] getStash()
  {
    return valueTable;
  }
  
  public boolean shouldAutoResolveMissingFeatures()
  {
    return derived;
  }
  
  @KeepForSdk
  public class Builder<A extends com.google.android.gms.common.api.Api.AnyClient, ResultT>
  {
    private com.google.android.gms.common.api.internal.RemoteCall<A, TaskCompletionSource<ResultT>> androidModule;
    private Feature[] baseUrl;
    private boolean client = true;
    private int policy = 0;
    
    private Builder() {}
    
    public Builder bssid(RemoteCall paramRemoteCall)
    {
      androidModule = paramRemoteCall;
      return this;
    }
    
    public TaskApiCall build()
    {
      boolean bool;
      if (androidModule != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "execute parameter required");
      return new zacv(this, baseUrl, client, policy);
    }
    
    public Builder execute(BiConsumer paramBiConsumer)
    {
      androidModule = new zacu(paramBiConsumer);
      return this;
    }
    
    public Builder setAutoResolveMissingFeatures(boolean paramBoolean)
    {
      client = paramBoolean;
      return this;
    }
    
    public Builder setFeatures(Feature... paramVarArgs)
    {
      baseUrl = paramVarArgs;
      return this;
    }
    
    public Builder setMethodKey(int paramInt)
    {
      policy = paramInt;
      return this;
    }
  }
}
