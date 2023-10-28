package com.google.android.datatransport.asm;

import com.google.android.datatransport.runtime.dagger.internal.ByteVector;
import com.google.android.datatransport.runtime.dagger.internal.b;
import java.util.concurrent.Executor;

public final class q
  implements b<Executor>
{
  public q() {}
  
  public static q a()
  {
    return Handler.a();
  }
  
  public static Executor b()
  {
    return (Executor)ByteVector.get(ClassReader.createExecutor(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public Executor getItem()
  {
    return b();
  }
}
