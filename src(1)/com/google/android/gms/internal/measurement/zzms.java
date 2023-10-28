package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzms
  extends AbstractList
  implements RandomAccess, zzkt
{
  private final zzkt data;
  
  public zzms(zzkt paramZzkt)
  {
    data = paramZzkt;
  }
  
  public final zzkt a()
  {
    return this;
  }
  
  public final List getFileList()
  {
    return data.getFileList();
  }
  
  public final Object getKey(int paramInt)
  {
    return data.getKey(paramInt);
  }
  
  public final Iterator iterator()
  {
    return new zzmr(this);
  }
  
  public final ListIterator listIterator(int paramInt)
  {
    return new zzmq(this, paramInt);
  }
  
  public final void removeAt(zzjd paramZzjd)
  {
    throw new UnsupportedOperationException();
  }
  
  public final int size()
  {
    return data.size();
  }
}
