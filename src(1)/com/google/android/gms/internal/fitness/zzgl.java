package com.google.android.gms.internal.fitness;

final class zzgl
  extends zzgj
{
  private int after;
  private final byte[] buffer;
  private int limit;
  private final boolean zzuo;
  private int zzup;
  private int zzuq;
  private int zzur = Integer.MAX_VALUE;
  
  private zzgl(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(null);
    buffer = paramArrayOfByte;
    limit = (paramInt2 + paramInt1);
    after = paramInt1;
    zzuq = paramInt1;
    zzuo = paramBoolean;
  }
  
  public final int deflate(int paramInt)
    throws zzhk
  {
    if (paramInt >= 0)
    {
      int j = paramInt + zzbb();
      paramInt = zzur;
      if (j <= paramInt)
      {
        zzur = j;
        int i = limit + zzup;
        limit = i;
        int k = i - zzuq;
        if (k > j)
        {
          j = k - j;
          zzup = j;
          limit = (i - j);
          return paramInt;
        }
        zzup = 0;
        return paramInt;
      }
      throw new zzhk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
    throw new zzhk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  public final int zzbb()
  {
    return after - zzuq;
  }
}
