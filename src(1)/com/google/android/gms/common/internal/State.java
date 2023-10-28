package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class State
  extends Application
{
  public final IBinder token;
  
  public State(BaseGmsClient paramBaseGmsClient, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paramBaseGmsClient, paramInt, paramBundle);
    token = paramIBinder;
  }
  
  protected final boolean execute()
  {
    Object localObject1 = token;
    try
    {
      Preconditions.checkNotNull(localObject1);
      localObject1 = ((IBinder)localObject1).getInterfaceDescriptor();
      Object localObject2;
      if (!this$0.getServiceDescriptor().equals(localObject1))
      {
        localObject2 = this$0.getServiceDescriptor();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("service descriptor mismatch: ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" vs. ");
        localStringBuilder.append((String)localObject1);
        Log.w("GmsClient", localStringBuilder.toString());
        return false;
      }
      localObject1 = this$0.createServiceInterface(token);
      if (localObject1 != null)
      {
        if ((!BaseGmsClient.close(this$0, 2, 4, (IInterface)localObject1)) && (!BaseGmsClient.close(this$0, 3, 4, (IInterface)localObject1))) {
          break label183;
        }
        BaseGmsClient.set(this$0, null);
        localObject1 = this$0.getConnectionHint();
        localObject2 = this$0;
        if (BaseGmsClient.getInstance((BaseGmsClient)localObject2) != null) {
          BaseGmsClient.getInstance((BaseGmsClient)localObject2).onConnected((Bundle)localObject1);
        }
        return true;
      }
      return false;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    Log.w("GmsClient", "service probably died");
    return false;
    label183:
    return false;
  }
  
  protected final void expired(ConnectionResult paramConnectionResult)
  {
    if (BaseGmsClient.access$getUpdater(this$0) != null) {
      BaseGmsClient.access$getUpdater(this$0).onConnectionFailed(paramConnectionResult);
    }
    this$0.onConnectionFailed(paramConnectionResult);
  }
}
