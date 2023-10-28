package com.google.android.datatransport.api.internal;

import com.google.android.datatransport.cct.internal.j;
import com.google.firebase.common.Paint;
import java.io.IOException;

final class c
  implements com.google.firebase.p.d<j>
{
  private static final Paint b = Paint.valueOf("logRequest");
  static final c c = new c();
  
  private c() {}
  
  public void b(Item paramItem, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.append(b, paramItem.getQ());
  }
}
