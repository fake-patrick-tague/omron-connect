package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

public final class zzmo
{
  private static final zzmo d = new zzmo(0, new int[0], new Object[0], false);
  private boolean added;
  private int[] buffer;
  private Object[] data;
  private int size;
  private int value = -1;
  
  private zzmo()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private zzmo(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    size = paramInt;
    buffer = paramArrayOfInt;
    data = paramArrayOfObject;
    added = paramBoolean;
  }
  
  static zzmo a()
  {
    return new zzmo(0, new int[8], new Object[8], true);
  }
  
  static zzmo add(zzmo paramZzmo1, zzmo paramZzmo2)
  {
    int i = size + size;
    int[] arrayOfInt = Arrays.copyOf(buffer, i);
    System.arraycopy(buffer, 0, arrayOfInt, size, size);
    Object[] arrayOfObject = Arrays.copyOf(data, i);
    System.arraycopy(data, 0, arrayOfObject, size, size);
    return new zzmo(i, arrayOfInt, arrayOfObject, true);
  }
  
  public static zzmo e()
  {
    return d;
  }
  
  public final void add()
  {
    added = false;
  }
  
  final void add(int paramInt, Object paramObject)
  {
    if (added)
    {
      int j = size;
      int[] arrayOfInt = buffer;
      if (j == arrayOfInt.length)
      {
        if (j < 4) {
          i = 8;
        } else {
          i = j >> 1;
        }
        i = j + i;
        buffer = Arrays.copyOf(arrayOfInt, i);
        data = Arrays.copyOf(data, i);
      }
      arrayOfInt = buffer;
      int i = size;
      arrayOfInt[i] = paramInt;
      data[i] = paramObject;
      size = (i + 1);
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof zzmo)) {
      return false;
    }
    paramObject = (zzmo)paramObject;
    int j = size;
    if (j == size)
    {
      Object localObject = buffer;
      int[] arrayOfInt = buffer;
      int i = 0;
      while (i < j)
      {
        if (localObject[i] != arrayOfInt[i]) {
          return false;
        }
        i += 1;
      }
      localObject = data;
      paramObject = data;
      j = size;
      i = 0;
      while (i < j)
      {
        if (!localObject[i].equals(paramObject[i])) {
          break label124;
        }
        i += 1;
      }
      return true;
    }
    label124:
    return false;
  }
  
  public final int hashCode()
  {
    int n = size;
    Object localObject = buffer;
    int m = 0;
    int k = 17;
    int j = 0;
    int i = 17;
    while (j < n)
    {
      i = i * 31 + localObject[j];
      j += 1;
    }
    localObject = data;
    int i1 = size;
    j = m;
    while (j < i1)
    {
      k = k * 31 + localObject[j].hashCode();
      j += 1;
    }
    return ((n + 527) * 31 + i) * 31 + k;
  }
  
  public final int next()
  {
    int i = value;
    if (i == -1)
    {
      int j = 0;
      for (int k = 0; j < size; k = i)
      {
        int m = buffer[j];
        i = m >>> 3;
        m &= 0x7;
        if (m != 0)
        {
          if (m != 1)
          {
            if (m != 2)
            {
              if (m != 3)
              {
                if (m == 5)
                {
                  ((Integer)data[j]).intValue();
                  i = zzjl.append(i << 3) + 4;
                  break label233;
                }
                throw new IllegalStateException(zzko.getEWAHIterator());
              }
              i = zzjl.getValue(i);
              i += i;
              m = ((zzmo)data[j]).next();
            }
            else
            {
              zzjd localZzjd = (zzjd)data[j];
              i = zzjl.append(i << 3);
              m = localZzjd.size();
              i = k + (i + (zzjl.append(m) + m));
              break label237;
            }
          }
          else
          {
            ((Long)data[j]).longValue();
            i = zzjl.append(i << 3) + 8;
            break label233;
          }
        }
        else
        {
          long l = ((Long)data[j]).longValue();
          i = zzjl.append(i << 3);
          m = zzjl.get(l);
        }
        i += m;
        label233:
        i = k + i;
        label237:
        j += 1;
      }
      value = k;
      return k;
    }
    return i;
  }
  
  public final int read()
  {
    int i = value;
    if (i == -1)
    {
      i = 0;
      int j = 0;
      while (i < size)
      {
        int k = buffer[i];
        zzjd localZzjd = (zzjd)data[i];
        int m = zzjl.append(8);
        int n = localZzjd.size();
        j += m + m + (zzjl.append(16) + zzjl.append(k >>> 3)) + (zzjl.append(24) + (zzjl.append(n) + n));
        i += 1;
      }
      value = j;
      return j;
    }
    return i;
  }
  
  public final void read(zznf paramZznf)
    throws IOException
  {
    if (size != 0)
    {
      int i = 0;
      while (i < size)
      {
        int k = buffer[i];
        Object localObject = data[i];
        int j = k >>> 3;
        k &= 0x7;
        if (k != 0)
        {
          if (k != 1)
          {
            if (k != 2)
            {
              if (k != 3)
              {
                if (k == 5) {
                  paramZznf.put(j, ((Integer)localObject).intValue());
                } else {
                  throw new RuntimeException(zzko.getEWAHIterator());
                }
              }
              else
              {
                paramZznf.getInfo(j);
                ((zzmo)localObject).read(paramZznf);
                paramZznf.recurse(j);
              }
            }
            else {
              paramZznf.put(j, (zzjd)localObject);
            }
          }
          else {
            paramZznf.put(j, ((Long)localObject).longValue());
          }
        }
        else {
          paramZznf.get(j, ((Long)localObject).longValue());
        }
        i += 1;
      }
    }
  }
  
  final void write(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < size)
    {
      zzln.add(paramStringBuilder, paramInt, String.valueOf(buffer[i] >>> 3), data[i]);
      i += 1;
    }
  }
}
