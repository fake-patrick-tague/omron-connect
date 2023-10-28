package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class Mp4Extractor
  extends zzab
{
  private final int contentView;
  private BaseGmsClient storage;
  
  public Mp4Extractor(BaseGmsClient paramBaseGmsClient, int paramInt)
  {
    storage = paramBaseGmsClient;
    contentView = paramInt;
  }
  
  public final void init(int paramInt, Bundle paramBundle)
  {
    Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
  }
  
  public final void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    Preconditions.checkNotNull(storage, "onPostInitComplete can be called only once per call to getRemoteService");
    storage.onPostInitHandler(paramInt, paramIBinder, paramBundle, contentView);
    storage = null;
  }
  
  public final void read(int paramInt, IBinder paramIBinder, MediaDescriptionCompat paramMediaDescriptionCompat)
  {
    BaseGmsClient localBaseGmsClient = storage;
    Preconditions.checkNotNull(localBaseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
    Preconditions.checkNotNull(paramMediaDescriptionCompat);
    BaseGmsClient.changePath(localBaseGmsClient, paramMediaDescriptionCompat);
    onPostInitComplete(paramInt, paramIBinder, mExtras);
  }
}
