package com.alivecor.mapsforge.record;

class CirShortBuffer
{
  private short[] mBuffer;
  private int mCapacity;
  private int mCount;
  private int mMask;
  
  CirShortBuffer(int paramInt)
  {
    paramInt = ceilingNextPowerOfTwo(paramInt);
    mMask = (paramInt - 1);
    mCapacity = paramInt;
    mBuffer = new short[paramInt];
    mCount = 0;
  }
  
  private static int ceilingNextPowerOfTwo(int paramInt)
  {
    return 1 << 32 - Integer.numberOfLeadingZeros(paramInt - 1);
  }
  
  short get(int paramInt)
  {
    return mBuffer[(paramInt & mMask)];
  }
  
  int getCount()
  {
    return mCount;
  }
  
  void read(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      short[] arrayOfShort = mBuffer;
      int i = mCount;
      arrayOfShort[(mMask & i)] = paramArrayOfShort[paramInt1];
      mCount = (i + 1);
      paramInt1 += 1;
    }
  }
  
  void reset()
  {
    mCount = 0;
  }
  
  void resize(int paramInt)
  {
    int j = ceilingNextPowerOfTwo(paramInt);
    paramInt = mCapacity;
    if (j != paramInt)
    {
      short[] arrayOfShort = new short[j];
      if (j > paramInt) {
        paramInt = mCount - paramInt;
      } else {
        paramInt = mCount - j;
      }
      int i = 0;
      while (paramInt < mCount)
      {
        arrayOfShort[i] = get(paramInt);
        i += 1;
        paramInt += 1;
      }
      mBuffer = null;
      mBuffer = arrayOfShort;
      mMask = (j - 1);
      mCount = i;
      mCapacity = j;
    }
  }
}
