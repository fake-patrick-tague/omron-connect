package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public abstract class zzaw
{
  final List this$0 = new ArrayList();
  
  protected zzaw() {}
  
  final zzap add(String paramString)
  {
    if (this$0.contains(ByteVector.get(paramString))) {
      throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(paramString)));
    }
    throw new IllegalArgumentException("Command not supported");
  }
  
  public abstract zzap add(String paramString, Headers paramHeaders, List paramList);
}
