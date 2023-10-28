package com.google.android.gms.internal.common;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jspecify.nullness.NullMarked;

@NullMarked
abstract class AbstractIterator
  implements Iterator
{
  private Object next;
  private int state = 2;
  
  protected AbstractIterator() {}
  
  protected abstract Object computeNext();
  
  protected final Object endOfData()
  {
    state = 3;
    return null;
  }
  
  public final boolean hasNext()
  {
    int i = state;
    if (i != 4)
    {
      int j = i - 1;
      if (i != 0)
      {
        if (j != 0)
        {
          if (j != 2)
          {
            state = 4;
            next = computeNext();
            if (state != 3)
            {
              state = 1;
              return true;
            }
          }
          else
          {
            return false;
          }
        }
        else {
          return true;
        }
      }
      else {
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
    }
    else
    {
      throw new IllegalStateException();
    }
    return false;
  }
  
  public final Object next()
  {
    if (hasNext())
    {
      state = 2;
      Object localObject = next;
      next = null;
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
