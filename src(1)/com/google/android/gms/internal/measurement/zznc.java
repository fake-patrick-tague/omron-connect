package com.google.android.gms.internal.measurement;

final class zznc
{
  private static final zzmz o = new zzna();
  
  static
  {
    if ((zzmx.getValue()) && (zzmx.i())) {
      int i = zzip.type;
    }
  }
  
  static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzko
  {
    int i = paramArrayOfByte.length;
    if ((paramInt1 | paramInt2 | i - paramInt1 - paramInt2) >= 0)
    {
      int m = paramInt1 + paramInt2;
      char[] arrayOfChar = new char[paramInt2];
      i = 0;
      int j = paramInt1;
      byte b;
      for (;;)
      {
        paramInt2 = j;
        paramInt1 = i;
        if (j >= m) {
          break;
        }
        b = paramArrayOfByte[j];
        if (!zzmy.isPrimitive(b))
        {
          paramInt2 = j;
          paramInt1 = i;
          break;
        }
        j += 1;
        arrayOfChar[i] = ((char)b);
        i += 1;
      }
      while (paramInt2 < m)
      {
        j = paramInt2 + 1;
        b = paramArrayOfByte[paramInt2];
        if (zzmy.isPrimitive(b))
        {
          i = paramInt1 + 1;
          arrayOfChar[paramInt1] = ((char)b);
          for (;;)
          {
            int k = i;
            paramInt2 = j;
            paramInt1 = k;
            if (j >= m) {
              break;
            }
            b = paramArrayOfByte[j];
            if (!zzmy.isPrimitive(b))
            {
              paramInt2 = j;
              paramInt1 = k;
              break;
            }
            j += 1;
            i += 1;
            arrayOfChar[k] = ((char)b);
          }
        }
        if (b < -32)
        {
          if (j < m)
          {
            zzmy.append(b, paramArrayOfByte[j], arrayOfChar, paramInt1);
            paramInt2 = j + 1;
            paramInt1 += 1;
          }
          else
          {
            throw zzko.write();
          }
        }
        else if (b < -16)
        {
          if (j < m - 1)
          {
            paramInt2 = j + 1;
            zzmy.a(b, paramArrayOfByte[j], paramArrayOfByte[paramInt2], arrayOfChar, paramInt1);
            paramInt2 += 1;
            paramInt1 += 1;
          }
          else
          {
            throw zzko.write();
          }
        }
        else if (j < m - 2)
        {
          i = j + 1;
          paramInt2 = i + 1;
          zzmy.encode(b, paramArrayOfByte[j], paramArrayOfByte[i], paramArrayOfByte[paramInt2], arrayOfChar, paramInt1);
          paramInt1 += 2;
          paramInt2 += 1;
        }
        else
        {
          throw zzko.write();
        }
      }
      return new String(arrayOfChar, 0, paramInt1);
    }
    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  static boolean b(byte[] paramArrayOfByte)
  {
    return o.b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  static boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return o.b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static int decode(CharSequence paramCharSequence)
  {
    int n = paramCharSequence.length();
    int m = 0;
    int j = 0;
    while ((j < n) && (paramCharSequence.charAt(j) < '?')) {
      j += 1;
    }
    int i = n;
    for (;;)
    {
      k = i;
      if (j >= n) {
        break label208;
      }
      k = paramCharSequence.charAt(j);
      if (k >= 2048) {
        break;
      }
      i += (127 - k >>> 31);
      j += 1;
    }
    int i2 = paramCharSequence.length();
    int k = m;
    while (j < i2)
    {
      int i3 = paramCharSequence.charAt(j);
      if (i3 < 2048)
      {
        k += (127 - i3 >>> 31);
        m = j;
      }
      else
      {
        int i1 = k + 2;
        k = i1;
        m = j;
        if (i3 >= 55296)
        {
          k = i1;
          m = j;
          if (i3 <= 57343) {
            if (Character.codePointAt(paramCharSequence, j) >= 65536)
            {
              m = j + 1;
              k = i1;
            }
            else
            {
              throw new zznb(j, i2);
            }
          }
        }
      }
      j = m + 1;
    }
    k = i + k;
    label208:
    if (k >= n) {
      return k;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(k + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  static int decode(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int m = paramInt2 + paramInt1;
    paramInt2 = 0;
    int n;
    while (paramInt2 < k)
    {
      j = paramInt2 + paramInt1;
      if (j >= m) {
        break;
      }
      n = paramCharSequence.charAt(paramInt2);
      if (n >= 128) {
        break;
      }
      paramArrayOfByte[j] = ((byte)n);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    int j = paramInt1 + paramInt2;
    paramInt1 = paramInt2;
    while (paramInt1 < k)
    {
      int i = paramCharSequence.charAt(paramInt1);
      if ((i < 128) && (j < m))
      {
        paramInt2 = j + 1;
        paramArrayOfByte[j] = ((byte)i);
      }
      for (;;)
      {
        break;
        if ((i < 2048) && (j <= m - 2))
        {
          n = j + 1;
          paramArrayOfByte[j] = ((byte)(i >>> 6 | 0x3C0));
          paramInt2 = n + 1;
          paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
        }
        else if (((i < 55296) || (i > 57343)) && (j <= m - 3))
        {
          paramInt2 = j + 1;
          paramArrayOfByte[j] = ((byte)(i >>> 12 | 0x1E0));
          j = paramInt2 + 1;
          paramArrayOfByte[paramInt2] = ((byte)(i >>> 6 & 0x3F | 0x80));
          paramInt2 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          if (j > m - 4) {
            break label433;
          }
          paramInt2 = paramInt1 + 1;
          if (paramInt2 == paramCharSequence.length()) {
            break label420;
          }
          char c = paramCharSequence.charAt(paramInt2);
          if (!Character.isSurrogatePair(i, c)) {
            break label418;
          }
          paramInt1 = Character.toCodePoint(i, c);
          n = j + 1;
          paramArrayOfByte[j] = ((byte)(paramInt1 >>> 18 | 0xF0));
          j = n + 1;
          paramArrayOfByte[n] = ((byte)(paramInt1 >>> 12 & 0x3F | 0x80));
          n = j + 1;
          paramArrayOfByte[j] = ((byte)(paramInt1 >>> 6 & 0x3F | 0x80));
          j = n + 1;
          paramArrayOfByte[n] = ((byte)(paramInt1 & 0x3F | 0x80));
          paramInt1 = paramInt2;
          paramInt2 = j;
        }
      }
      paramInt1 += 1;
      j = paramInt2;
      continue;
      label418:
      paramInt1 = paramInt2;
      label420:
      throw new zznb(paramInt1 - 1, k);
      label433:
      if ((i >= 55296) && (i <= 57343))
      {
        paramInt2 = paramInt1 + 1;
        if ((paramInt2 == paramCharSequence.length()) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2)))) {
          throw new zznb(paramInt1, k);
        }
      }
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("Failed writing ");
      paramCharSequence.append(i);
      paramCharSequence.append(" at index ");
      paramCharSequence.append(j);
      throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
    }
    return j;
  }
}
