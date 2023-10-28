package com.alivecor.mapsforge.core.asm;

public class ByteVector
{
  private byte[] a;
  private int b;
  private int v;
  
  private ByteVector(int paramInt)
  {
    if (paramInt != v)
    {
      if (a != null) {
        a = null;
      }
      a = new byte[paramInt];
      v = paramInt;
    }
  }
  
  public static ByteVector get(int paramInt)
  {
    ByteVector localByteVector = new ByteVector(paramInt);
    if (localByteVector.get() != paramInt) {
      return null;
    }
    return localByteVector;
  }
  
  public static long getInt(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      return 0L;
    }
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    return (paramArrayOfByte[3] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public int a()
  {
    return b;
  }
  
  public void a(int paramInt)
  {
    int i = b;
    if (i + 2 > v) {
      return;
    }
    byte[] arrayOfByte = a;
    int j = i + 1;
    b = j;
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    b = (j + 1);
    arrayOfByte[j] = ((byte)(paramInt >> 8 & 0xFF));
  }
  
  public void add()
  {
    b = 0;
  }
  
  public void add(int paramInt)
  {
    int i = b;
    if (i + 2 > v) {
      return;
    }
    byte[] arrayOfByte = a;
    int j = i + 1;
    b = j;
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    b = (j + 1);
    arrayOfByte[j] = ((byte)(paramInt >> 8 & 0xFF));
  }
  
  public void add(long paramLong)
  {
    int j = b;
    if (j + 4 > v) {
      return;
    }
    byte[] arrayOfByte = a;
    int i = j + 1;
    b = i;
    arrayOfByte[j] = ((byte)(int)(paramLong & 0xFF));
    j = i + 1;
    b = j;
    arrayOfByte[i] = ((byte)(int)(paramLong >> 8 & 0xFF));
    i = j + 1;
    b = i;
    arrayOfByte[j] = ((byte)(int)(paramLong >> 16 & 0xFF));
    b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 24 & 0xFF));
  }
  
  public void add(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = b;
    if (j + i > v) {
      return;
    }
    System.arraycopy(paramArrayOfByte, 0, a, j, i);
    b += i;
  }
  
  public boolean b()
  {
    return b < v;
  }
  
  public int d()
  {
    byte[] arrayOfByte = a;
    int i = b;
    b = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int get()
  {
    return v;
  }
  
  public byte[] getValue()
  {
    return a;
  }
  
  public void putInt(int paramInt)
  {
    int i = b;
    int j = i + 1;
    if (j > v) {
      return;
    }
    byte[] arrayOfByte = a;
    b = j;
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
  
  public long read()
  {
    byte[] arrayOfByte = a;
    int i = b;
    int j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    long l = (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
    b = (i + 4);
    return l;
  }
  
  public long read(int paramInt)
  {
    byte[] arrayOfByte = a;
    int i = arrayOfByte[paramInt];
    int j = arrayOfByte[(paramInt + 1)];
    int k = arrayOfByte[(paramInt + 2)];
    return (arrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public int write()
  {
    byte[] arrayOfByte = a;
    int i = b;
    int j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    b = (i + 2);
    return (k & 0xFF) << 8 | j & 0xFF;
  }
  
  public String write(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    int i = b;
    int j;
    for (;;)
    {
      j = b + paramInt;
      if (i >= j) {
        break;
      }
      byte[] arrayOfByte = a;
      if (arrayOfByte[i] == 0) {
        break;
      }
      localStringBuilder.append((char)arrayOfByte[i]);
      i += 1;
    }
    b = j;
    return localStringBuilder.toString();
  }
  
  public void write(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (b + paramString.length() > v) {
        return;
      }
      int j = paramString.length();
      int i = 0;
      while (i < paramInt)
      {
        byte[] arrayOfByte = a;
        int k = b;
        b = (k + 1);
        if (i < j) {
          arrayOfByte[k] = ((byte)paramString.charAt(i));
        } else {
          arrayOfByte[k] = 0;
        }
        i += 1;
      }
    }
  }
}
