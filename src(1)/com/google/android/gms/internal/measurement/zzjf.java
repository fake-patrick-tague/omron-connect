package com.google.android.gms.internal.measurement;

final class zzjf
  extends zzjh
{
  private final byte[] mByteArray;
  private int mColumnCount;
  private int mCount;
  private int mRowCount;
  
  public final int getCount(int paramInt)
    throws zzko
  {
    paramInt = mCount;
    mCount = 0;
    int i = mRowCount + mColumnCount;
    mRowCount = i;
    if (i > 0)
    {
      mColumnCount = i;
      mRowCount = (i - i);
      return paramInt;
    }
    mColumnCount = 0;
    return paramInt;
  }
}
