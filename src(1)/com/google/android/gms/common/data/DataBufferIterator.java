package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
public class DataBufferIterator<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> currentEntry;
  protected int data;
  
  public DataBufferIterator(DataBuffer paramDataBuffer)
  {
    currentEntry = ((DataBuffer)Preconditions.checkNotNull(paramDataBuffer));
    data = -1;
  }
  
  public final boolean hasNext()
  {
    return data < currentEntry.getCount() - 1;
  }
  
  public Object next()
  {
    if (hasNext())
    {
      localObject = currentEntry;
      i = data + 1;
      data = i;
      return ((DataBuffer)localObject).get(i);
    }
    int i = data;
    Object localObject = new StringBuilder(46);
    ((StringBuilder)localObject).append("Cannot advance the iterator beyond ");
    ((StringBuilder)localObject).append(i);
    throw new NoSuchElementException(((StringBuilder)localObject).toString());
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}
