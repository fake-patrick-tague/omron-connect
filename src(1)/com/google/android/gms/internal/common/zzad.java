package com.google.android.gms.internal.common;

import java.util.Iterator;

public final class zzad
  extends zzaa
{
  public zzad()
  {
    super(4);
  }
  
  zzad(int paramInt)
  {
    super(4);
  }
  
  public final zzad append(Object paramObject)
  {
    super.get(paramObject);
    return this;
  }
  
  public final zzad transform(Iterator paramIterator)
  {
    while (paramIterator.hasNext()) {
      super.get(paramIterator.next());
    }
    return this;
  }
}
