package com.google.android.datatransport.asm.util.util;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.b;
import g.a.a;

public final class ByteVector
  implements b<String>
{
  private final a<Context> b;
  
  public ByteVector(a paramA)
  {
    b = paramA;
  }
  
  public static ByteVector a(a paramA)
  {
    return new ByteVector(paramA);
  }
  
  public static String a(Context paramContext)
  {
    return (String)com.google.android.datatransport.runtime.dagger.internal.ByteVector.get(g.a(paramContext), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public String b()
  {
    return a((Context)b.get());
  }
}
