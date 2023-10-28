package com.google.android.datatransport.asm.util.util;

import com.google.android.datatransport.runtime.dagger.internal.ByteVector;
import com.google.android.datatransport.runtime.dagger.internal.b;

public final class h
  implements b<String>
{
  public h() {}
  
  public static String a()
  {
    return (String)ByteVector.get(g.getId(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public static h c()
  {
    return m0.a.c();
  }
  
  public String getItem()
  {
    return a();
  }
}
