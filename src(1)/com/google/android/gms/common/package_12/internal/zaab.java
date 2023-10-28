package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.package_12.PendingResult.StatusListener;
import com.google.android.gms.common.package_12.Status;
import java.util.Map;

final class zaab
  implements PendingResult.StatusListener
{
  zaab(zaad paramZaad, BasePendingResult paramBasePendingResult) {}
  
  public final void onComplete(Status paramStatus)
  {
    zaad.access$getData(this$0).remove(val$position);
  }
}
