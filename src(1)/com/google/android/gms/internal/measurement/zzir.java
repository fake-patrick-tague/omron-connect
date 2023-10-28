package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

final class zzir
{
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzmo paramZzmo, zziq paramZziq)
    throws zzko
  {
    if (paramInt1 >>> 3 != 0)
    {
      int i = paramInt1 & 0x7;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 5)
              {
                paramZzmo.add(paramInt1, Integer.valueOf(readInt(paramArrayOfByte, paramInt2)));
                return paramInt2 + 4;
              }
              throw zzko.getStep();
            }
            int k = paramInt1 & 0xFFFFFFF8 | 0x4;
            zzmo localZzmo = zzmo.a();
            i = 0;
            int j;
            for (;;)
            {
              j = paramInt2;
              if (paramInt2 >= paramInt3) {
                break;
              }
              j = a(paramArrayOfByte, paramInt2, paramZziq);
              i = a;
              if (i == k) {
                break;
              }
              paramInt2 = a(i, paramArrayOfByte, j, paramInt3, localZzmo, paramZziq);
            }
            if ((j <= paramInt3) && (i == k))
            {
              paramZzmo.add(paramInt1, localZzmo);
              return j;
            }
            throw zzko.getSort();
          }
          paramInt2 = a(paramArrayOfByte, paramInt2, paramZziq);
          paramInt3 = a;
          if (paramInt3 >= 0)
          {
            if (paramInt3 <= paramArrayOfByte.length - paramInt2)
            {
              if (paramInt3 == 0) {
                paramZzmo.add(paramInt1, zzjd.a);
              } else {
                paramZzmo.add(paramInt1, zzjd.a(paramArrayOfByte, paramInt2, paramInt3));
              }
              return paramInt2 + paramInt3;
            }
            throw zzko.visitParameterAnnotation();
          }
          throw zzko.g();
        }
        paramZzmo.add(paramInt1, Long.valueOf(readLong(paramArrayOfByte, paramInt2)));
        return paramInt2 + 8;
      }
      paramInt2 = read(paramArrayOfByte, paramInt2, paramZziq);
      paramZzmo.add(paramInt1, Long.valueOf(d));
      return paramInt2;
    }
    throw zzko.getStep();
  }
  
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, zziq paramZziq)
  {
    int i = paramInt1 & 0x7F;
    paramInt1 = paramInt2 + 1;
    paramInt2 = paramArrayOfByte[paramInt2];
    if (paramInt2 >= 0)
    {
      a = (i | paramInt2 << 7);
      return paramInt1;
    }
    i |= (paramInt2 & 0x7F) << 7;
    paramInt2 = paramInt1 + 1;
    paramInt1 = paramArrayOfByte[paramInt1];
    if (paramInt1 >= 0)
    {
      a = (i | paramInt1 << 14);
      return paramInt2;
    }
    paramInt1 = i | (paramInt1 & 0x7F) << 14;
    int j = paramInt2 + 1;
    paramInt2 = paramArrayOfByte[paramInt2];
    if (paramInt2 >= 0)
    {
      a = (paramInt1 | paramInt2 << 21);
      return j;
    }
    i = paramInt1 | (paramInt2 & 0x7F) << 21;
    paramInt1 = j + 1;
    j = paramArrayOfByte[j];
    if (j >= 0)
    {
      a = (i | j << 28);
      return paramInt1;
    }
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      if (paramArrayOfByte[paramInt1] >= 0) {
        break;
      }
      paramInt1 = paramInt2;
    }
    a = (i | (j & 0x7F) << 28);
    return paramInt2;
  }
  
  static int a(zzlw paramZzlw, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzkl paramZzkl, zziq paramZziq)
    throws IOException
  {
    paramInt2 = a(paramZzlw, paramArrayOfByte, paramInt2, paramInt3, paramZziq);
    paramZzkl.add(c);
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramZziq);
      if (paramInt1 != a) {
        return paramInt2;
      }
      paramInt2 = a(paramZzlw, paramArrayOfByte, i, paramInt3, paramZziq);
      paramZzkl.add(c);
    }
    return paramInt2;
  }
  
  static int a(zzlw paramZzlw, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, zziq paramZziq)
    throws IOException
  {
    paramZzlw = (zzlo)paramZzlw;
    Object localObject = paramZzlw.c();
    paramInt1 = paramZzlw.a(localObject, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramZziq);
    paramZzlw.add(localObject);
    c = localObject;
    return paramInt1;
  }
  
  static int a(zzlw paramZzlw, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zziq paramZziq)
    throws IOException
  {
    int j = paramInt1 + 1;
    int k = paramArrayOfByte[paramInt1];
    paramInt1 = j;
    int i = k;
    if (k < 0)
    {
      paramInt1 = a(k, paramArrayOfByte, j, paramZziq);
      i = a;
    }
    if ((i >= 0) && (i <= paramInt2 - paramInt1))
    {
      Object localObject = paramZzlw.c();
      paramInt2 = i + paramInt1;
      paramZzlw.b(localObject, paramArrayOfByte, paramInt1, paramInt2, paramZziq);
      paramZzlw.add(localObject);
      c = localObject;
      return paramInt2;
    }
    throw zzko.visitParameterAnnotation();
  }
  
  static int a(byte[] paramArrayOfByte, int paramInt, zziq paramZziq)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    if (paramInt >= 0)
    {
      a = paramInt;
      return i;
    }
    return a(paramInt, paramArrayOfByte, i, paramZziq);
  }
  
  static int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzkl paramZzkl, zziq paramZziq)
  {
    paramZzkl = (zzkf)paramZzkl;
    paramInt2 = a(paramArrayOfByte, paramInt2, paramZziq);
    paramZzkl.write(a);
    while (paramInt2 < paramInt3)
    {
      int i = a(paramArrayOfByte, paramInt2, paramZziq);
      if (paramInt1 != a) {
        return paramInt2;
      }
      paramInt2 = a(paramArrayOfByte, i, paramZziq);
      paramZzkl.write(a);
    }
    return paramInt2;
  }
  
  static int b(byte[] paramArrayOfByte, int paramInt, zziq paramZziq)
    throws zzko
  {
    paramInt = a(paramArrayOfByte, paramInt, paramZziq);
    int i = a;
    if (i >= 0)
    {
      if (i <= paramArrayOfByte.length - paramInt)
      {
        if (i == 0)
        {
          c = zzjd.a;
          return paramInt;
        }
        c = zzjd.a(paramArrayOfByte, paramInt, i);
        return paramInt + i;
      }
      throw zzko.visitParameterAnnotation();
    }
    throw zzko.g();
  }
  
  static int b(byte[] paramArrayOfByte, int paramInt, zzkl paramZzkl, zziq paramZziq)
    throws IOException
  {
    paramZzkl = (zzkf)paramZzkl;
    int i = a(paramArrayOfByte, paramInt, paramZziq);
    paramInt = i;
    i = a + i;
    while (paramInt < i)
    {
      paramInt = a(paramArrayOfByte, paramInt, paramZziq);
      paramZzkl.write(a);
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzko.visitParameterAnnotation();
  }
  
  static int c(byte[] paramArrayOfByte, int paramInt, zziq paramZziq)
    throws zzko
  {
    paramInt = a(paramArrayOfByte, paramInt, paramZziq);
    int i = a;
    if (i >= 0)
    {
      if (i == 0)
      {
        c = "";
        return paramInt;
      }
      c = zznc.a(paramArrayOfByte, paramInt, i);
      return paramInt + i;
    }
    throw zzko.g();
  }
  
  static int d(byte[] paramArrayOfByte, int paramInt, zziq paramZziq)
    throws zzko
  {
    paramInt = a(paramArrayOfByte, paramInt, paramZziq);
    int i = a;
    if (i >= 0)
    {
      if (i == 0)
      {
        c = "";
        return paramInt;
      }
      c = new String(paramArrayOfByte, paramInt, i, zzkm.a);
      return paramInt + i;
    }
    throw zzko.g();
  }
  
  static int read(byte[] paramArrayOfByte, int paramInt, zziq paramZziq)
  {
    int i = paramInt + 1;
    long l = paramArrayOfByte[paramInt];
    if (l >= 0L)
    {
      d = l;
      return i;
    }
    paramInt = i + 1;
    int j = paramArrayOfByte[i];
    l = l & 0x7F | (j & 0x7F) << 7;
    i = 7;
    while (j < 0)
    {
      j = paramArrayOfByte[paramInt];
      i += 7;
      l |= (j & 0x7F) << i;
      paramInt += 1;
    }
    d = l;
    return paramInt;
  }
  
  static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  static long readLong(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[paramInt];
    long l2 = paramArrayOfByte[(paramInt + 1)];
    long l3 = paramArrayOfByte[(paramInt + 2)];
    long l4 = paramArrayOfByte[(paramInt + 3)];
    long l5 = paramArrayOfByte[(paramInt + 4)];
    long l6 = paramArrayOfByte[(paramInt + 5)];
    long l7 = paramArrayOfByte[(paramInt + 6)];
    return (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
}
