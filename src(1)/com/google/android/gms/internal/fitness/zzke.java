package com.google.android.gms.internal.fitness;

final class zzke
  extends zzjz
{
  zzke() {}
  
  private static int process(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return zzka.processBlock(paramInt1, zzjy.parse(paramArrayOfByte, paramLong), zzjy.parse(paramArrayOfByte, paramLong + 1L));
        }
        throw new AssertionError();
      }
      return zzka.processBlock(paramInt1, zzjy.parse(paramArrayOfByte, paramLong));
    }
    return zzka.zzao(paramInt1);
  }
  
  final int decode(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = paramInt1;
    long l4 = paramInt2 + l1;
    int k = paramCharSequence.length();
    if ((k <= paramInt2) && (paramArrayOfByte.length - paramInt2 >= paramInt1))
    {
      paramInt2 = 0;
      int j;
      long l2;
      for (;;)
      {
        j = 128;
        l2 = 1L;
        if (paramInt2 >= k) {
          break;
        }
        paramInt1 = paramCharSequence.charAt(paramInt2);
        if (paramInt1 >= 128) {
          break;
        }
        zzjy.get(paramArrayOfByte, l1, (byte)paramInt1);
        paramInt2 += 1;
        l1 = 1L + l1;
      }
      long l3 = l1;
      paramInt1 = paramInt2;
      if (paramInt2 == k) {
        return (int)l1;
      }
      while (paramInt1 < k)
      {
        int i = paramCharSequence.charAt(paramInt1);
        if ((i < j) && (l3 < l4))
        {
          zzjy.get(paramArrayOfByte, l3, (byte)i);
          l1 = l3 + l2;
          paramInt2 = j;
        }
        else if ((i < 2048) && (l3 <= l4 - 2L))
        {
          l1 = l3 + l2;
          zzjy.get(paramArrayOfByte, l3, (byte)(i >>> 6 | 0x3C0));
          zzjy.get(paramArrayOfByte, l1, (byte)(i & 0x3F | 0x80));
          paramInt2 = 128;
          l1 += l2;
        }
        else if (((i < 55296) || (57343 < i)) && (l3 <= l4 - 3L))
        {
          l1 = l3 + l2;
          zzjy.get(paramArrayOfByte, l3, (byte)(i >>> 12 | 0x1E0));
          l2 = l1 + l2;
          zzjy.get(paramArrayOfByte, l1, (byte)(i >>> 6 & 0x3F | 0x80));
          zzjy.get(paramArrayOfByte, l2, (byte)(i & 0x3F | 0x80));
          l1 = l2 + 1L;
          l2 = 1L;
          paramInt2 = 128;
        }
        else
        {
          if (l3 > l4 - 4L) {
            break label534;
          }
          paramInt2 = paramInt1 + 1;
          if (paramInt2 == k) {
            break label521;
          }
          char c2 = paramCharSequence.charAt(paramInt2);
          if (!Character.isSurrogatePair(i, c2)) {
            break label518;
          }
          paramInt1 = Character.toCodePoint(i, c2);
          l1 = l3 + 1L;
          zzjy.get(paramArrayOfByte, l3, (byte)(paramInt1 >>> 18 | 0xF0));
          l2 = l1 + 1L;
          j = 128;
          zzjy.get(paramArrayOfByte, l1, (byte)(paramInt1 >>> 12 & 0x3F | 0x80));
          l3 = l2 + 1L;
          zzjy.get(paramArrayOfByte, l2, (byte)(paramInt1 >>> 6 & 0x3F | 0x80));
          l2 = 1L;
          l1 = l3 + 1L;
          zzjy.get(paramArrayOfByte, l3, (byte)(paramInt1 & 0x3F | 0x80));
          paramInt1 = paramInt2;
          paramInt2 = j;
        }
        paramInt1 += 1;
        l3 = l1;
        j = paramInt2;
        continue;
        label518:
        paramInt1 = paramInt2;
        label521:
        throw new zzkb(paramInt1 - 1, k);
        label534:
        if ((55296 <= i) && (i <= 57343))
        {
          paramInt2 = paramInt1 + 1;
          if ((paramInt2 == k) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2)))) {
            throw new zzkb(paramInt1, k);
          }
        }
        paramCharSequence = new StringBuilder(46);
        paramCharSequence.append("Failed writing ");
        paramCharSequence.append(i);
        paramCharSequence.append(" at index ");
        paramCharSequence.append(l3);
        throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
      }
      return (int)l3;
    }
    char c1 = paramCharSequence.charAt(k - 1);
    paramCharSequence = new StringBuilder(37);
    paramCharSequence.append("Failed writing ");
    paramCharSequence.append(c1);
    paramCharSequence.append(" at index ");
    paramCharSequence.append(paramInt1 + paramInt2);
    throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
  }
  
  final int parse(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt2 | paramInt3 | paramArrayOfByte.length - paramInt3) >= 0)
    {
      long l2 = paramInt2;
      paramInt2 = (int)(paramInt3 - l2);
      if (paramInt2 < 16)
      {
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = 0;
        for (l1 = l2; paramInt1 < paramInt2; l1 += 1L)
        {
          if (zzjy.parse(paramArrayOfByte, l1) < 0) {
            break label74;
          }
          paramInt1 += 1;
        }
        paramInt1 = paramInt2;
      }
      label74:
      paramInt2 -= paramInt1;
      long l1 = l2 + paramInt1;
      paramInt1 = paramInt2;
      label189:
      do
      {
        long l3;
        do
        {
          for (;;)
          {
            paramInt3 = 0;
            paramInt2 = paramInt1;
            paramInt1 = paramInt3;
            for (;;)
            {
              l2 = l1;
              if (paramInt2 <= 0) {
                break;
              }
              l2 = l1 + 1L;
              paramInt1 = zzjy.parse(paramArrayOfByte, l1);
              if (paramInt1 < 0) {
                break;
              }
              paramInt2 -= 1;
              l1 = l2;
            }
            if (paramInt2 == 0) {
              return 0;
            }
            paramInt2 -= 1;
            if (paramInt1 >= -32) {
              break label189;
            }
            if (paramInt2 == 0) {
              return paramInt1;
            }
            paramInt2 -= 1;
            if (paramInt1 < -62) {
              break;
            }
            if (zzjy.parse(paramArrayOfByte, l2) > -65) {
              return -1;
            }
            l1 = l2 + 1L;
            paramInt1 = paramInt2;
          }
          return -1;
          if (paramInt1 >= -16) {
            break;
          }
          if (paramInt2 < 2) {
            return process(paramArrayOfByte, paramInt1, l2, paramInt2);
          }
          paramInt2 -= 2;
          l3 = l2 + 1L;
          paramInt3 = zzjy.parse(paramArrayOfByte, l2);
          if ((paramInt3 > -65) || ((paramInt1 == -32) && (paramInt3 < -96)) || ((paramInt1 == -19) && (paramInt3 >= -96))) {
            break label414;
          }
          l1 = l3 + 1L;
          paramInt1 = paramInt2;
        } while (zzjy.parse(paramArrayOfByte, l3) <= -65);
        return -1;
        if (paramInt2 < 3) {
          return process(paramArrayOfByte, paramInt1, l2, paramInt2);
        }
        paramInt2 -= 3;
        l1 = l2 + 1L;
        paramInt3 = zzjy.parse(paramArrayOfByte, l2);
        if ((paramInt3 > -65) || ((paramInt1 << 28) + (paramInt3 + 112) >> 30 != 0)) {
          break;
        }
        l2 = l1 + 1L;
        if (zzjy.parse(paramArrayOfByte, l1) > -65) {
          break;
        }
        l1 = l2 + 1L;
        paramInt1 = paramInt2;
      } while (zzjy.parse(paramArrayOfByte, l2) <= -65);
      return -1;
    }
    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    label414:
    return -1;
  }
}
