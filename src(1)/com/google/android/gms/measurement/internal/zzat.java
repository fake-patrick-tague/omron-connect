package com.google.android.gms.measurement.internal;

import android.os.BaseBundle;
import java.util.Iterator;
import java.util.Set;

final class zzat
  implements Iterator
{
  final Iterator iter;
  
  zzat(zzau paramZzau)
  {
    iter = zzau.getConfiguration(paramZzau).keySet().iterator();
  }
  
  public final String getValue()
  {
    return (String)iter.next();
  }
  
  public final boolean hasNext()
  {
    return iter.hasNext();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Remove not supported");
  }
}
