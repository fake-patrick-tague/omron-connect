package com.google.android.datatransport.asm.asm;

import com.google.android.datatransport.h.a0.a;
import com.google.android.datatransport.runtime.dagger.internal.ByteVector;
import com.google.android.datatransport.runtime.dagger.internal.b;

public final class c
  implements b<a>
{
  public c() {}
  
  public static Label a()
  {
    return (Label)ByteVector.get(ClassReader.readLabel(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public static c b()
  {
    return l.a();
  }
  
  public Label createFromParcel()
  {
    return a();
  }
}
