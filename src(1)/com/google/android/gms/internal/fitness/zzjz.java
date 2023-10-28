package com.google.android.gms.internal.fitness;

abstract class zzjz
{
  zzjz() {}
  
  abstract int decode(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  abstract int parse(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  final boolean processBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return parse(0, paramArrayOfByte, paramInt1, paramInt2) == 0;
  }
}
