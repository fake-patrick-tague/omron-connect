package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Objects;

final class zzji
  extends zzjl
{
  private final byte[] data;
  private final int type;
  private int value;
  
  zzji(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(null);
    Objects.requireNonNull(paramArrayOfByte, "buffer");
    paramInt1 = paramArrayOfByte.length;
    if ((paramInt1 - paramInt2 | paramInt2) >= 0)
    {
      data = paramArrayOfByte;
      value = 0;
      type = paramInt2;
      return;
    }
    throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2) }));
  }
  
  public final void add(byte paramByte)
    throws IOException
  {
    byte[] arrayOfByte = data;
    int i = value;
    value = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public final void add(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = data;
    int j = value;
    int i = j + 1;
    value = i;
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    j = i + 1;
    value = j;
    arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
    i = j + 1;
    value = i;
    arrayOfByte[j] = ((byte)(paramInt >> 16 & 0xFF));
    value = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 24 & 0xFF));
  }
  
  public final void add(int paramInt1, int paramInt2)
    throws IOException
  {
    toString(paramInt1 << 3 | paramInt2);
  }
  
  public final void add(int paramInt, long paramLong)
    throws IOException
  {
    toString(paramInt << 3 | 0x1);
    toString(paramLong);
  }
  
  public final void add(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte = data;
    paramInt1 = value;
    try
    {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, paramInt1, paramInt2);
      value += paramInt2;
      return;
    }
    catch (IndexOutOfBoundsException paramArrayOfByte)
    {
      throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(value), Integer.valueOf(type), Integer.valueOf(paramInt2) }), paramArrayOfByte);
    }
  }
  
  public final void append(int paramInt1, int paramInt2)
    throws IOException
  {
    toString(paramInt1 << 3 | 0x5);
    add(paramInt2);
  }
  
  public final void append(int paramInt, String paramString)
    throws IOException
  {
    toString(paramInt << 3 | 0x2);
    toString(paramString);
  }
  
  public final void append(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    add(paramArrayOfByte, 0, paramInt2);
  }
  
  public final void get(int paramInt, long paramLong)
    throws IOException
  {
    toString(paramInt << 3);
    read(paramLong);
  }
  
  public final int getColor()
  {
    return type - value;
  }
  
  public final void put(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      toString(paramInt);
      return;
    }
    read(paramInt);
  }
  
  public final void read(long paramLong)
    throws IOException
  {
    long l = paramLong;
    byte[] arrayOfByte;
    int i;
    if (zzjl.version())
    {
      l = paramLong;
      if (type - value >= 10) {
        for (;;)
        {
          if ((paramLong & 0xFFFFFFFFFFFFFF80) == 0L)
          {
            arrayOfByte = data;
            i = value;
            value = (i + 1);
            zzmx.add(arrayOfByte, i, (byte)(int)paramLong);
            return;
          }
          arrayOfByte = data;
          i = value;
          value = (i + 1);
          zzmx.add(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
          paramLong >>>= 7;
        }
      }
    }
    for (;;)
    {
      if ((l & 0xFFFFFFFFFFFFFF80) == 0L)
      {
        arrayOfByte = data;
        i = value;
        value = (i + 1);
        arrayOfByte[i] = ((byte)(int)l);
        return;
      }
      arrayOfByte = data;
      i = value;
      value = (i + 1);
      arrayOfByte[i] = ((byte)((int)l & 0x7F | 0x80));
      l >>>= 7;
    }
  }
  
  public final void remove(int paramInt1, int paramInt2)
    throws IOException
  {
    toString(paramInt1 << 3);
    toString(paramInt2);
  }
  
  public final void remove(int paramInt, zzjd paramZzjd)
    throws IOException
  {
    toString(paramInt << 3 | 0x2);
    toString(paramZzjd.size());
    paramZzjd.remainder(this);
  }
  
  public final void set(int paramInt1, int paramInt2)
    throws IOException
  {
    toString(paramInt1 << 3);
    put(paramInt2);
  }
  
  public final void toString(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        arrayOfByte = data;
        i = value;
        value = (i + 1);
        arrayOfByte[i] = ((byte)paramInt);
        return;
      }
      byte[] arrayOfByte = data;
      int i = value;
      value = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt & 0x7F | 0x80));
      paramInt >>>= 7;
    }
  }
  
  public final void toString(long paramLong)
    throws IOException
  {
    byte[] arrayOfByte = data;
    int j = value;
    int i = j + 1;
    value = i;
    arrayOfByte[j] = ((byte)((int)paramLong & 0xFF));
    j = i + 1;
    value = j;
    arrayOfByte[i] = ((byte)((int)(paramLong >> 8) & 0xFF));
    i = j + 1;
    value = i;
    arrayOfByte[j] = ((byte)((int)(paramLong >> 16) & 0xFF));
    j = i + 1;
    value = j;
    arrayOfByte[i] = ((byte)((int)(paramLong >> 24) & 0xFF));
    i = j + 1;
    value = i;
    arrayOfByte[j] = ((byte)((int)(paramLong >> 32) & 0xFF));
    j = i + 1;
    value = j;
    arrayOfByte[i] = ((byte)((int)(paramLong >> 40) & 0xFF));
    i = j + 1;
    value = i;
    arrayOfByte[j] = ((byte)((int)(paramLong >> 48) & 0xFF));
    value = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 56) & 0xFF));
  }
  
  public final void toString(String paramString)
    throws IOException
  {
    int i = value;
    try
    {
      int j = paramString.length();
      int k = zzjl.append(j * 3);
      j = zzjl.append(paramString.length());
      if (j == k)
      {
        k = i + j;
        value = k;
        arrayOfByte = data;
        int m = type;
        k = zznc.decode(paramString, arrayOfByte, k, m - k);
        value = i;
        toString(k - i - j);
        value = k;
        return;
      }
      toString(zznc.decode(paramString));
      byte[] arrayOfByte = data;
      j = value;
      k = type;
      j = zznc.decode(paramString, arrayOfByte, j, k - j);
      value = j;
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new zzjj(paramString);
    }
    catch (zznb localZznb)
    {
      value = i;
      warn(paramString, localZznb);
    }
  }
  
  public final void write(int paramInt, boolean paramBoolean)
    throws IOException
  {
    toString(paramInt << 3);
    add((byte)paramBoolean);
  }
}
