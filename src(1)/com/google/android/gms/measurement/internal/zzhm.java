package com.google.android.gms.measurement.internal;

import android.os.BaseBundle;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class zzhm
  implements Runnable
{
  zzhm(zzid paramZzid, Bundle paramBundle) {}
  
  public final void run()
  {
    zzid localZzid = target;
    Object localObject1 = arguments;
    localZzid.append();
    localZzid.next();
    Preconditions.checkNotNull(localObject1);
    Object localObject2 = ((BaseBundle)localObject1).getString("name");
    String str = ((BaseBundle)localObject1).getString("origin");
    Preconditions.checkNotEmpty((String)localObject2);
    Preconditions.checkNotEmpty(str);
    Preconditions.checkNotNull(((BaseBundle)localObject1).get("value"));
    if (!this$0.size())
    {
      this$0.zzay().next().append("Conditional property not set since app measurement is disabled");
      return;
    }
    localObject2 = new zzlc((String)localObject2, ((BaseBundle)localObject1).getLong("triggered_timestamp"), ((BaseBundle)localObject1).get("value"), str);
    Object localObject3 = this$0;
    try
    {
      localObject3 = ((zzfy)localObject3).get().get(((BaseBundle)localObject1).getString("app_id"), ((BaseBundle)localObject1).getString("triggered_event_name"), ((Bundle)localObject1).getBundle("triggered_event_params"), str, 0L, true, true);
      Object localObject4 = this$0;
      localObject4 = ((zzfy)localObject4).get().get(((BaseBundle)localObject1).getString("app_id"), ((BaseBundle)localObject1).getString("timed_out_event_name"), ((Bundle)localObject1).getBundle("timed_out_event_params"), str, 0L, true, true);
      Object localObject5 = this$0;
      localObject5 = ((zzfy)localObject5).get().get(((BaseBundle)localObject1).getString("app_id"), ((BaseBundle)localObject1).getString("expired_event_name"), ((Bundle)localObject1).getBundle("expired_event_params"), str, 0L, true, true);
      localObject1 = new zzac(((BaseBundle)localObject1).getString("app_id"), str, (zzlc)localObject2, ((BaseBundle)localObject1).getLong("creation_timestamp"), false, ((BaseBundle)localObject1).getString("trigger_event_name"), (zzaw)localObject4, ((BaseBundle)localObject1).getLong("trigger_timeout"), (zzaw)localObject3, ((BaseBundle)localObject1).getLong("time_to_live"), (zzaw)localObject5);
      this$0.getName().trim((zzac)localObject1);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
}
