package com.google.android.datatransport.api.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.d;
import com.google.android.datatransport.cct.internal.f;
import com.google.android.datatransport.cct.internal.i;
import com.google.android.datatransport.cct.internal.j;
import com.google.android.datatransport.cct.internal.k;
import com.google.firebase.common.reflect.Label;

public final class Frame
  implements Label
{
  public static final Label i = new Frame();
  
  private Frame() {}
  
  public void a(com.google.firebase.common.reflect.e paramE)
  {
    Object localObject = c.c;
    paramE.a(j.class, (com.google.firebase.common.Object)localObject);
    paramE.a(d.class, (com.google.firebase.common.Object)localObject);
    localObject = l.i;
    paramE.a(com.google.android.datatransport.cct.internal.l.class, (com.google.firebase.common.Object)localObject);
    paramE.a(com.google.android.datatransport.cct.internal.g.class, (com.google.firebase.common.Object)localObject);
    localObject = ClassWriter.b;
    paramE.a(ClientInfo.class, (com.google.firebase.common.Object)localObject);
    paramE.a(com.google.android.datatransport.cct.internal.e.class, (com.google.firebase.common.Object)localObject);
    localObject = a.g;
    paramE.a(com.google.android.datatransport.cct.internal.a.class, (com.google.firebase.common.Object)localObject);
    paramE.a(com.google.android.datatransport.cct.internal.c.class, (com.google.firebase.common.Object)localObject);
    localObject = g.a;
    paramE.a(k.class, (com.google.firebase.common.Object)localObject);
    paramE.a(f.class, (com.google.firebase.common.Object)localObject);
    localObject = Plot.a;
    paramE.a(NetworkConnectionInfo.class, (com.google.firebase.common.Object)localObject);
    paramE.a(i.class, (com.google.firebase.common.Object)localObject);
  }
}
