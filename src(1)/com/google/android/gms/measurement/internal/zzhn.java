package com.google.android.gms.measurement.internal;

import android.os.BaseBundle;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class zzhn
  implements Runnable
{
  zzhn(zzid paramZzid, Bundle paramBundle) {}
  
  public final void run()
  {
    zzid localZzid = resource;
    Object localObject1 = bundle;
    localZzid.append();
    localZzid.next();
    Preconditions.checkNotNull(localObject1);
    Object localObject2 = Preconditions.checkNotEmpty(((BaseBundle)localObject1).getString("name"));
    if (!this$0.size())
    {
      this$0.zzay().next().append("Conditional property not cleared since app measurement is disabled");
      return;
    }
    localObject2 = new zzlc((String)localObject2, 0L, null, "");
    Object localObject3 = this$0;
    try
    {
      localObject3 = ((zzfy)localObject3).get().get(((BaseBundle)localObject1).getString("app_id"), ((BaseBundle)localObject1).getString("expired_event_name"), ((Bundle)localObject1).getBundle("expired_event_params"), "", ((BaseBundle)localObject1).getLong("creation_timestamp"), true, true);
      localObject1 = new zzac(((BaseBundle)localObject1).getString("app_id"), "", (zzlc)localObject2, ((BaseBundle)localObject1).getLong("creation_timestamp"), ((BaseBundle)localObject1).getBoolean("active"), ((BaseBundle)localObject1).getString("trigger_event_name"), null, ((BaseBundle)localObject1).getLong("trigger_timeout"), null, ((BaseBundle)localObject1).getLong("time_to_live"), (zzaw)localObject3);
      this$0.getName().trim((zzac)localObject1);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
}
