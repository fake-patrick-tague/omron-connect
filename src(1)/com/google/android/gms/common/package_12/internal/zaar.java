package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.signin.internal.NavigationMenuPresenter;
import com.google.android.gms.signin.internal.TransportInformation;
import java.lang.ref.WeakReference;

final class zaar
  extends NavigationMenuPresenter
{
  private final WeakReference<com.google.android.gms.common.api.internal.zaaw> l;
  
  zaar(zaaw paramZaaw)
  {
    l = new WeakReference(paramZaaw);
  }
  
  public final void e(TransportInformation paramTransportInformation)
  {
    zaaw localZaaw = (zaaw)l.get();
    if (localZaaw == null) {
      return;
    }
    zaaw.append(localZaaw).clear(new zaaq(this, localZaaw, localZaaw, paramTransportInformation));
  }
}
