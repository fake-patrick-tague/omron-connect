package com.google.android.datatransport.asm.util.util;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped.Reason;
import com.google.android.datatransport.runtime.firebase.transport.h;

public abstract interface e
{
  public abstract void add(long paramLong, LogEventDropped.Reason paramReason, String paramString);
  
  public abstract void apply();
  
  public abstract h b();
}
