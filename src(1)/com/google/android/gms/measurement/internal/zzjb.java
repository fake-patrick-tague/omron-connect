package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzjb
  implements Runnable
{
  zzjb(zzjs paramZzjs, Item paramItem, Bundle paramBundle) {}
  
  public final void run()
  {
    Object localObject = this$0;
    zzee localZzee = zzjs.getInstance((zzjs)localObject);
    if (localZzee == null)
    {
      this$0.zzay().iterator().append("Failed to send default event parameters to service");
      return;
    }
    localObject = mAlbum;
    try
    {
      Preconditions.checkNotNull(localObject);
      localObject = mTrack;
      Item localItem = mAlbum;
      localZzee.add((Bundle)localObject, localItem);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this$0.this$0.zzay().iterator().append("Failed to send default event parameters to service", localRemoteException);
    }
  }
}
