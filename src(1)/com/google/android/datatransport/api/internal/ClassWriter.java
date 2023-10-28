package com.google.android.datatransport.api.internal;

import com.google.firebase.common.Paint;
import java.io.IOException;

final class ClassWriter
  implements com.google.firebase.p.d<com.google.android.datatransport.cct.internal.ClientInfo>
{
  static final ClassWriter b = new ClassWriter();
  private static final Paint c = Paint.valueOf("clientType");
  private static final Paint d = Paint.valueOf("androidClientInfo");
  
  private ClassWriter() {}
  
  public void a(ClientInfo paramClientInfo, com.google.firebase.common.d paramD)
    throws IOException
  {
    paramD.append(c, paramClientInfo.getName());
    paramD.append(d, paramClientInfo.getOwner());
  }
}
