package com.google.android.gms.internal.measurement;

final class zzix
  extends zzja
{
  private final int pointer;
  
  zzix(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    zzjd.add(0, paramInt2, paramArrayOfByte.length);
    pointer = paramInt2;
  }
  
  final byte get(int paramInt)
  {
    return data[paramInt];
  }
  
  protected final int getCharIndex()
  {
    return 0;
  }
  
  public final byte next(int paramInt)
  {
    int i = pointer;
    if ((i - (paramInt + 1) | paramInt) < 0)
    {
      if (paramInt < 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Index < 0: ");
        localStringBuilder.append(paramInt);
        throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Index > length: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(i);
      throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
    }
    return data[paramInt];
  }
  
  public final int size()
  {
    return pointer;
  }
}
