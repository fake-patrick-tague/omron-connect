package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.b;

public final class ByteVector
  implements b<j>
{
  private final g.a.a<Context> a;
  private final g.a.a<h> b;
  
  public ByteVector(g.a.a paramA1, g.a.a paramA2)
  {
    a = paramA1;
    b = paramA2;
  }
  
  public static a a(Context paramContext, Object paramObject)
  {
    return new a(paramContext, (h)paramObject);
  }
  
  public static ByteVector b(g.a.a paramA1, g.a.a paramA2)
  {
    return new ByteVector(paramA1, paramA2);
  }
  
  public a a()
  {
    return a((Context)a.get(), b.get());
  }
}
