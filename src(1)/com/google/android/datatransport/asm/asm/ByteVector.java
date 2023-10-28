package com.google.android.datatransport.asm.asm;

import com.google.android.datatransport.h.a0.a;
import com.google.android.datatransport.runtime.dagger.internal.b;

public final class ByteVector
  implements b<a>
{
  public ByteVector() {}
  
  public static ByteVector a()
  {
    return Frame.b();
  }
  
  public static Label toByteArray()
  {
    return (Label)com.google.android.datatransport.runtime.dagger.internal.ByteVector.get(ClassReader.a(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public Label read()
  {
    return toByteArray();
  }
}
