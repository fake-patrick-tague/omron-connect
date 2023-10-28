package com.alivecor.mapsforge.record;

class CirIntBuffer
{
  private int[] mBuffer;
  private int mCapacity;
  private int mCount;
  private int mMask;
  
  CirIntBuffer(int paramInt)
  {
    paramInt = ceilingNextPowerOfTwo(paramInt);
    mMask = (paramInt - 1);
    mCapacity = paramInt;
    mBuffer = new int[paramInt];
    mCount = 0;
  }
  
  private static int ceilingNextPowerOfTwo(int paramInt)
  {
    return 1 << 32 - Integer.numberOfLeadingZeros(paramInt - 1);
  }
  
  void add(int paramInt)
  {
    int[] arrayOfInt = mBuffer;
    int i = mCount;
    arrayOfInt[(mMask & i)] = paramInt;
    mCount = (i + 1);
  }
  
  int get(int paramInt)
  {
    return mBuffer[(paramInt & mMask)];
  }
  
  int getCount()
  {
    return mCount;
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
      int[] arrayOfInt = new int[j];
      if (j > paramInt) {
        paramInt = mCount - paramInt;
      } else {
        paramInt = mCount - j;
      }
      int i = 0;
      while (paramInt < mCount)
      {
        arrayOfInt[i] = get(paramInt);
        i += 1;
        paramInt += 1;
      }
      mBuffer = null;
      mBuffer = arrayOfInt;
      mMask = (j - 1);
      mCount = i;
    }
  }
}
