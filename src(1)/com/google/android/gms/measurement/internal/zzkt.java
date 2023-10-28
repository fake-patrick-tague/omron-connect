package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

final class zzkt
  implements Runnable
{
  zzkt(zzku paramZzku, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public final void run()
  {
    zzaw localZzaw = this$0.labels.get().get(value, description, iconUrl, "auto", this$0.labels.zzav().currentTimeMillis(), false, true);
    this$0.labels.read((zzaw)Preconditions.checkNotNull(localZzaw), value);
  }
}
