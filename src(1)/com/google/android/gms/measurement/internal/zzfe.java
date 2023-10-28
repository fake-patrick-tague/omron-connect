package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.BaseBundle;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzbr;

final class zzfe
  implements Runnable
{
  zzfe(zzff paramZzff, zzbr paramZzbr, ServiceConnection paramServiceConnection) {}
  
  public final void run()
  {
    Object localObject1 = mContext;
    zzfg localZzfg = log;
    String str = zzff.get((zzff)localObject1);
    Object localObject2 = mService;
    ServiceConnection localServiceConnection = mConnection;
    this$0.zzaz().append();
    Object localObject4 = new Bundle();
    ((BaseBundle)localObject4).putString("package_name", str);
    localObject1 = null;
    try
    {
      localObject2 = ((zzbr)localObject2).getSkuDetails((Bundle)localObject4);
      if (localObject2 == null)
      {
        localObject2 = this$0;
        ((zzfy)localObject2).zzay().iterator().append("Install Referrer Service returned a null response");
      }
      else
      {
        localObject1 = localObject2;
      }
    }
    catch (Exception localException)
    {
      this$0.zzay().iterator().append("Exception occurred while retrieving the Install Referrer", localException.getMessage());
    }
    this$0.zzaz().append();
    zzfy.i();
    if (localObject1 != null)
    {
      long l1 = ((BaseBundle)localObject1).getLong("install_begin_timestamp_seconds", 0L) * 1000L;
      if (l1 == 0L)
      {
        this$0.zzay().hasNext().append("Service response is missing Install Referrer install timestamp");
      }
      else
      {
        Object localObject3 = ((BaseBundle)localObject1).getString("install_referrer");
        if ((localObject3 != null) && (!((String)localObject3).isEmpty()))
        {
          this$0.zzay().next().append("InstallReferrer API result", localObject3);
          localObject3 = this$0.get().parse(Uri.parse("?".concat((String)localObject3)));
          if (localObject3 == null)
          {
            this$0.zzay().iterator().append("No campaign params defined in Install Referrer result");
          }
          else
          {
            localObject4 = ((BaseBundle)localObject3).getString("medium");
            if ((localObject4 != null) && (!"(not set)".equalsIgnoreCase((String)localObject4)) && (!"organic".equalsIgnoreCase((String)localObject4)))
            {
              long l2 = ((BaseBundle)localObject1).getLong("referrer_click_timestamp_seconds", 0L) * 1000L;
              if (l2 == 0L) {
                this$0.zzay().iterator().append("Install Referrer is missing click timestamp for ad campaign");
              } else {
                ((BaseBundle)localObject3).putLong("click_timestamp", l2);
              }
            }
            else
            {
              if (l1 == this$0.put().content.get()) {
                this$0.zzay().next().append("Logging Install Referrer campaign from module while it may have already been logged.");
              }
              if (this$0.size())
              {
                this$0.put().content.put(l1);
                this$0.zzay().next().append("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                ((BaseBundle)localObject3).putString("_cis", "referrer API v2");
                this$0.add().add("auto", "_cmp", (Bundle)localObject3, str);
              }
            }
          }
        }
        else
        {
          this$0.zzay().iterator().append("No referrer defined in Install Referrer response");
        }
      }
    }
    ConnectionTracker.getInstance().unbindService(this$0.zzau(), localServiceConnection);
  }
}
