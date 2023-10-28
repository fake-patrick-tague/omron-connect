package com.google.android.gms.common.package_12.internal;

import java.lang.ref.WeakReference;

final class zabd
  extends zabw
{
  private final WeakReference<com.google.android.gms.common.api.internal.zabe> viewReference;
  
  zabd(zabe paramZabe)
  {
    viewReference = new WeakReference(paramZabe);
  }
  
  public final void run()
  {
    zabe localZabe = (zabe)viewReference.get();
    if (localZabe == null) {
      return;
    }
    zabe.onError(localZabe);
  }
}
