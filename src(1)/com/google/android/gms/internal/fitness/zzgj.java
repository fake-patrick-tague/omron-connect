package com.google.android.gms.internal.fitness;

public abstract class zzgj
{
  private int zzuj = 100;
  private int zzuk = Integer.MAX_VALUE;
  private boolean zzul = false;
  
  private zzgj() {}
  
  static zzgj write(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new zzgl(paramArrayOfByte, 0, paramInt2, false, null);
    try
    {
      paramArrayOfByte.deflate(paramInt2);
      return paramArrayOfByte;
    }
    catch (zzhk paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public abstract int deflate(int paramInt)
    throws zzhk;
  
  public abstract int zzbb();
}
