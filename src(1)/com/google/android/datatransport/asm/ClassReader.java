package com.google.android.datatransport.asm;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

abstract class ClassReader
{
  static Executor createExecutor()
  {
    return new MoreExecutors.2(Executors.newSingleThreadExecutor());
  }
}
