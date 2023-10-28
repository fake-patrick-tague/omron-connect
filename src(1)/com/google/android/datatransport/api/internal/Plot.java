package com.google.android.datatransport.api.internal;

import com.google.firebase.common.Paint;
import java.io.IOException;

final class Plot
  implements com.google.firebase.p.d<com.google.android.datatransport.cct.internal.NetworkConnectionInfo>
{
  static final Plot a = new Plot();
  private static final Paint b = Paint.valueOf("networkType");
  private static final Paint d = Paint.valueOf("mobileSubtype");
  
  private Plot() {}
  
  public void b(NetworkConnectionInfo paramNetworkConnectionInfo, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.append(b, paramNetworkConnectionInfo.get());
    paramD.append(d, paramNetworkConnectionInfo.getValue());
  }
}
