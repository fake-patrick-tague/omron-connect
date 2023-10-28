package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

@KeepForSdk
public class SingleRefDataBufferIterator<T>
  extends DataBufferIterator<T>
{
  private T data;
  
  public SingleRefDataBufferIterator(DataBuffer paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public final Object next()
  {
    if (hasNext())
    {
      i = data + 1;
      data = i;
      if (i == 0)
      {
        localObject = Preconditions.checkNotNull(currentEntry.get(0));
        data = localObject;
        if (!(localObject instanceof DataBufferRef))
        {
          localObject = String.valueOf(localObject.getClass());
          StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 44);
          localStringBuilder.append("DataBuffer reference of type ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" is not movable");
          throw new IllegalStateException(localStringBuilder.toString());
        }
      }
      else
      {
        ((DataBufferRef)Preconditions.checkNotNull(data)).setData(data);
      }
      return data;
    }
    int i = data;
    Object localObject = new StringBuilder(46);
    ((StringBuilder)localObject).append("Cannot advance the iterator beyond ");
    ((StringBuilder)localObject).append(i);
    throw new NoSuchElementException(((StringBuilder)localObject).toString());
  }
}
