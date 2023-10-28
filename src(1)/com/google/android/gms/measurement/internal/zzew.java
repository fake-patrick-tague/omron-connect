package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

final class zzew
  extends BroadcastReceiver
{
  @VisibleForTesting
  static final String NULL_ARG = zzew.class.getName();
  private boolean id;
  private final zzkz mContext;
  private boolean started;
  
  zzew(zzkz paramZzkz)
  {
    Preconditions.checkNotNull(paramZzkz);
    mContext = paramZzkz;
  }
  
  public final void onCreate()
  {
    mContext.add();
    mContext.zzaz().append();
    if (started) {
      return;
    }
    mContext.zzau().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    id = mContext.getApplication().send();
    mContext.zzay().next().append("Registering connectivity change receiver. Network connected", Boolean.valueOf(id));
    started = true;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    mContext.add();
    paramContext = paramIntent.getAction();
    mContext.zzay().next().append("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      boolean bool = mContext.getApplication().send();
      if (id != bool)
      {
        id = bool;
        mContext.zzaz().append(new zzev(this, bool));
      }
    }
    else
    {
      mContext.zzay().hasNext().append("NetworkBroadcastReceiver received unknown action", paramContext);
    }
  }
  
  public final void startup()
  {
    mContext.add();
    mContext.zzaz().append();
    mContext.zzaz().append();
    if (started)
    {
      mContext.zzay().next().append("Unregistering connectivity change receiver");
      started = false;
      id = false;
      Context localContext = mContext.zzau();
      try
      {
        localContext.unregisterReceiver(this);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        mContext.zzay().iterator().append("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
      }
    }
  }
}
