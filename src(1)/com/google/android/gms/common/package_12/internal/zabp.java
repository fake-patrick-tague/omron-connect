package com.google.android.gms.common.package_12.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;

final class zabp
  implements BaseGmsClient.SignOutCallbacks
{
  zabp(zabq paramZabq) {}
  
  public final void onSignOutComplete()
  {
    GoogleApiManager.getInstance(size.name).post(new zabo(this));
  }
}
