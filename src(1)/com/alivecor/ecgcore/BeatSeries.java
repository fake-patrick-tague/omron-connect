package com.alivecor.ecgcore;

public class BeatSeries
{
  private long nativeHandle = 0L;
  
  public BeatSeries()
  {
    initEmpty();
  }
  
  public BeatSeries(BeatAnnotation[] paramArrayOfBeatAnnotation)
  {
    int[] arrayOfInt1 = new int[paramArrayOfBeatAnnotation.length];
    int[] arrayOfInt2 = new int[paramArrayOfBeatAnnotation.length];
    int i = 0;
    while (i < paramArrayOfBeatAnnotation.length)
    {
      arrayOfInt1[i] = paramArrayOfBeatAnnotation[i].offset();
      arrayOfInt2[i] = beatTypecode;
      i += 1;
    }
    init(arrayOfInt1, arrayOfInt2);
  }
  
  private native int countBeatsWithType(int paramInt);
  
  private native void dispose();
  
  private native BeatAnnotation[] getBeatsOfType(int paramInt);
  
  private native void init(int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private native void initEmpty();
  
  private native boolean insertBeatAtOffset(int paramInt1, int paramInt2);
  
  public native BeatAnnotation[] beatAnnotations();
  
  public BeatSeries beatsOfType(BeatType paramBeatType)
  {
    return new BeatSeries(getBeatsOfType(code));
  }
  
  public native void clear();
  
  public int countOfType(BeatType paramBeatType)
  {
    return countBeatsWithType(code);
  }
  
  protected void finalize()
  {
    dispose();
  }
  
  public boolean insert(int paramInt, BeatType paramBeatType)
  {
    return insertBeatAtOffset(paramInt, code);
  }
  
  public boolean insert(BeatAnnotation paramBeatAnnotation)
  {
    return insert(paramBeatAnnotation.offset(), paramBeatAnnotation.beatType());
  }
  
  public native int length();
}
