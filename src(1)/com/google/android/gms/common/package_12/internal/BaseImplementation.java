package com.google.android.gms.common.package_12.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.Status;

@KeepForSdk
public class BaseImplementation
{
  public BaseImplementation() {}
  
  @KeepForSdk
  public abstract class ApiMethodImpl<R extends com.google.android.gms.common.api.Result, A extends com.google.android.gms.common.api.Api.AnyClient>
    extends com.google.android.gms.common.api.internal.BasePendingResult<R>
    implements com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder<R>
  {
    @KeepForSdk
    private final Api<?> mApi;
    @KeepForSdk
    private final com.google.android.gms.common.api.Api.AnyClientKey<A> mClientKey;
    
    protected ApiMethodImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
      mClientKey = ((com.google.android.gms.common.package_12.Api.AnyClientKey)Preconditions.checkNotNull(this$1));
      mApi = null;
    }
    
    protected ApiMethodImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
      Preconditions.checkNotNull(this$1, "Api must not be null");
      mClientKey = this$1.getKey();
      mApi = this$1;
    }
    
    protected ApiMethodImpl()
    {
      super();
      mClientKey = new com.google.android.gms.common.package_12.Api.AnyClientKey();
      mApi = null;
    }
    
    private void setFailedResult(RemoteException paramRemoteException)
    {
      setFailedResult(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    protected abstract void doExecute(com.google.android.gms.common.package_12.Api.AnyClient paramAnyClient)
      throws RemoteException;
    
    public final Attribute getApi()
    {
      return mApi;
    }
    
    public final com.google.android.gms.common.package_12.Api.AnyClientKey getClientKey()
    {
      return mClientKey;
    }
    
    protected void onSetFailedResult(com.google.android.gms.common.package_12.Result paramResult) {}
    
    public final void setData(com.google.android.gms.common.package_12.Api.AnyClient paramAnyClient)
      throws DeadObjectException
    {
      try
      {
        doExecute(paramAnyClient);
        return;
      }
      catch (RemoteException paramAnyClient)
      {
        setFailedResult(paramAnyClient);
        return;
      }
      catch (DeadObjectException paramAnyClient)
      {
        setFailedResult(paramAnyClient);
        throw paramAnyClient;
      }
    }
    
    public final void setFailedResult(Status paramStatus)
    {
      Preconditions.checkArgument(paramStatus.isSuccess() ^ true, "Failed result must not be success");
      paramStatus = createFailedResult(paramStatus);
      setResult(paramStatus);
      onSetFailedResult(paramStatus);
    }
  }
  
  @KeepForSdk
  public abstract interface ResultHolder<R>
  {
    public abstract void setFailedResult(Status paramStatus);
    
    public abstract void setResult(Object paramObject);
  }
}
