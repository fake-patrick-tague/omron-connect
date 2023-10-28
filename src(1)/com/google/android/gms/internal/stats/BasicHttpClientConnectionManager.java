package com.google.android.gms.internal.stats;

import java.io.Closeable;

class BasicHttpClientConnectionManager
  implements Closeable
{
  public void close()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void finalize() {}
}
