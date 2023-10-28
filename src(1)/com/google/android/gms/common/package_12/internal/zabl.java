package com.google.android.gms.common.package_12.internal;

import android.os.Handler;

final class zabl
  implements BackgroundDetector.BackgroundStateChangeListener
{
  zabl(GoogleApiManager paramGoogleApiManager) {}
  
  public final void onBackgroundStateChanged(boolean paramBoolean)
  {
    GoogleApiManager localGoogleApiManager = criteria;
    GoogleApiManager.getInstance(localGoogleApiManager).sendMessage(GoogleApiManager.getInstance(localGoogleApiManager).obtainMessage(1, Boolean.valueOf(paramBoolean)));
  }
}
