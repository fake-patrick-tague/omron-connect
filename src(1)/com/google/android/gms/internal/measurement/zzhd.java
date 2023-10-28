package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzhd
  extends ContentObserver
{
  zzhd(zzhe paramZzhe, Handler paramHandler)
  {
    super(null);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    mReader.save();
  }
}
