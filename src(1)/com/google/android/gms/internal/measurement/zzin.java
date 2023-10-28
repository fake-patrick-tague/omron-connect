package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class zzin<MessageType extends zzin<MessageType, BuilderType>, BuilderType extends zzim<MessageType, BuilderType>>
  implements zzll
{
  protected int hashcode = 0;
  
  public zzin() {}
  
  protected static void zzbt(Iterable paramIterable, List paramList)
  {
    zzkm.get(paramIterable);
    Object localObject;
    int j;
    int i;
    if ((paramIterable instanceof zzkt))
    {
      localObject = ((zzkt)paramIterable).getFileList();
      paramIterable = (zzkt)paramList;
      j = paramList.size();
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = paramList.next();
        if (localObject == null)
        {
          i = paramIterable.size();
          paramList = new StringBuilder();
          paramList.append("Element at index ");
          paramList.append(i - j);
          paramList.append(" is null.");
          paramList = paramList.toString();
          i = paramIterable.size();
          for (;;)
          {
            i -= 1;
            if (i < j) {
              break;
            }
            paramIterable.remove(i);
          }
          throw new NullPointerException(paramList);
        }
        if ((localObject instanceof zzjd)) {
          paramIterable.removeAt((zzjd)localObject);
        } else {
          paramIterable.add((String)localObject);
        }
      }
    }
    if (!(paramIterable instanceof zzls))
    {
      if (((paramList instanceof ArrayList)) && ((paramIterable instanceof Collection))) {
        ((ArrayList)paramList).ensureCapacity(paramList.size() + ((Collection)paramIterable).size());
      }
      j = paramList.size();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (localObject == null)
        {
          i = paramList.size();
          paramIterable = new StringBuilder();
          paramIterable.append("Element at index ");
          paramIterable.append(i - j);
          paramIterable.append(" is null.");
          paramIterable = paramIterable.toString();
          i = paramList.size();
          for (;;)
          {
            i -= 1;
            if (i < j) {
              break;
            }
            paramList.remove(i);
          }
          throw new NullPointerException(paramIterable);
        }
        paramList.add(localObject);
      }
      return;
    }
    paramList.addAll((Collection)paramIterable);
  }
  
  int zzbr()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final zzjd zzbs()
  {
    try
    {
      int i = zzbw();
      Object localObject1 = zzjd.a;
      localObject1 = new byte[i];
      localObject2 = zzjl.shrink((byte[])localObject1);
      zzbK((zzjl)localObject2);
      ((zzjl)localObject2).startDragging();
      localObject1 = new zzja((byte[])localObject1);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      Object localObject2 = getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Serializing ");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" to a ByteString threw an IOException (should never happen).");
      throw new RuntimeException(localStringBuilder.toString(), localIOException);
    }
  }
  
  void zzbu(int paramInt)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final byte[] zzbv()
  {
    try
    {
      int i = zzbw();
      byte[] arrayOfByte = new byte[i];
      localObject = zzjl.shrink(arrayOfByte);
      zzbK((zzjl)localObject);
      ((zzjl)localObject).startDragging();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      Object localObject = getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Serializing ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" to a byte array threw an IOException (should never happen).");
      throw new RuntimeException(localStringBuilder.toString(), localIOException);
    }
  }
}
