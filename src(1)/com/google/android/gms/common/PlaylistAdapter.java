package com.google.android.gms.common;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.Logger;

final class PlaylistAdapter
  extends Logger
{
  private final Context mContext;
  
  public PlaylistAdapter(GoogleApiAvailability paramGoogleApiAvailability, Context paramContext)
  {
    super(paramGoogleApiAvailability);
    mContext = paramContext.getApplicationContext();
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = what;
    if (i != 1)
    {
      paramMessage = new StringBuilder(50);
      paramMessage.append("Don't know how to handle this message: ");
      paramMessage.append(i);
      Log.w("GoogleApiAvailability", paramMessage.toString());
      return;
    }
    i = mAudioPlayer.isGooglePlayServicesAvailable(mContext);
    if (mAudioPlayer.isUserResolvableError(i)) {
      mAudioPlayer.showErrorNotification(mContext, i);
    }
  }
}
