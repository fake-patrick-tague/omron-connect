package com.google.android.datatransport.asm.asm;

import android.os.SystemClock;

public class x
  implements Label
{
  public x() {}
  
  public long a()
  {
    return SystemClock.elapsedRealtime();
  }
}
