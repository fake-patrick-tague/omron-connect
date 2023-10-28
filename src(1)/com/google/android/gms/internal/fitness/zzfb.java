package com.google.android.gms.internal.fitness;

import java.util.NoSuchElementException;

abstract class zzfb<E>
  extends zzfp<E>
{
  private int position;
  private final int size;
  
  protected zzfb(int paramInt1, int paramInt2)
  {
    zzez.checkPositionIndex(paramInt2, paramInt1);
    size = paramInt1;
    position = paramInt2;
  }
  
  protected abstract Object get(int paramInt);
  
  public final boolean hasNext()
  {
    return position < size;
  }
  
  public final boolean hasPrevious()
  {
    return position > 0;
  }
  
  public final Object next()
  {
    if (hasNext())
    {
      int i = position;
      position = (i + 1);
      return get(i);
    }
    throw new NoSuchElementException();
  }
  
  public final int nextIndex()
  {
    return position;
  }
  
  public final Object previous()
  {
    if (hasPrevious())
    {
      int i = position - 1;
      position = i;
      return get(i);
    }
    throw new NoSuchElementException();
  }
  
  public final int previousIndex()
  {
    return position - 1;
  }
}
