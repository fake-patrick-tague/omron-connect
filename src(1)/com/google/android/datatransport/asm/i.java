package com.google.android.datatransport.asm;

import com.google.android.datatransport.asm.util.util.m;
import java.io.Closeable;
import java.io.IOException;

abstract class i
  implements Closeable
{
  i() {}
  
  abstract a a();
  
  abstract m c();
  
  public void close()
    throws IOException
  {
    c().close();
  }
}
