package com.google.android.datatransport.asm.util.util;

import com.google.android.datatransport.h.y.j.k0;
import com.google.android.datatransport.runtime.dagger.internal.ByteVector;
import com.google.android.datatransport.runtime.dagger.internal.b;

public final class c
  implements b<k0>
{
  public c() {}
  
  public static f a()
  {
    return (f)ByteVector.get(g.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public static c valueOf()
  {
    return p0.a.valueOf();
  }
  
  public f getItem()
  {
    return a();
  }
}
