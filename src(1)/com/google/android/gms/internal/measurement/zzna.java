package com.google.android.gms.internal.measurement;

final class zzna
  extends zzmz
{
  zzna() {}
  
  final int partialIsValidUtf8NonAscii(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    while ((paramInt2 < paramInt3) && (paramArrayOfByte[paramInt2] >= 0)) {
      paramInt2 += 1;
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= paramInt3) {
      return 0;
    }
    for (;;)
    {
      if (paramInt1 >= paramInt3) {
        return 0;
      }
      paramInt2 = paramInt1 + 1;
      int i = paramArrayOfByte[paramInt1];
      paramInt1 = paramInt2;
      if (i < 0)
      {
        if (i < -32) {
          if (paramInt2 < paramInt3) {
            if (i >= -62)
            {
              paramInt1 = paramInt2 + 1;
              if (paramArrayOfByte[paramInt2] <= -65) {
                continue;
              }
            }
          }
        }
        label171:
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return -1;
                return i;
                if (i >= -16) {
                  break label171;
                }
                if (paramInt2 >= paramInt3 - 1) {
                  return zznc.incompleteStateFor(paramArrayOfByte, paramInt2, paramInt3);
                }
                int j = paramInt2 + 1;
                paramInt1 = paramArrayOfByte[paramInt2];
                if ((paramInt1 <= -65) && ((i != -32) || (paramInt1 >= -96)) && ((i != -19) || (paramInt1 < -96)))
                {
                  paramInt1 = j + 1;
                  if (paramArrayOfByte[j] <= -65) {
                    break;
                  }
                }
              }
              if (paramInt2 >= paramInt3 - 2) {
                return zznc.incompleteStateFor(paramArrayOfByte, paramInt2, paramInt3);
              }
              paramInt1 = paramInt2 + 1;
              paramInt2 = paramArrayOfByte[paramInt2];
            } while ((paramInt2 > -65) || ((i << 28) + (paramInt2 + 112) >> 30 != 0));
            paramInt2 = paramInt1 + 1;
          } while (paramArrayOfByte[paramInt1] > -65);
          paramInt1 = paramInt2 + 1;
        } while (paramArrayOfByte[paramInt2] > -65);
      }
    }
  }
}
