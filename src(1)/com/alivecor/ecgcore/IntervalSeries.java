package com.alivecor.ecgcore;

public class IntervalSeries
{
  private long nativeHandle = 0L;
  
  public IntervalSeries()
  {
    initEmpty();
  }
  
  public IntervalSeries(Interval[] paramArrayOfInterval)
  {
    int[] arrayOfInt1 = new int[paramArrayOfInterval.length];
    int[] arrayOfInt2 = new int[paramArrayOfInterval.length];
    int i = 0;
    while (i < paramArrayOfInterval.length)
    {
      arrayOfInt1[i] = paramArrayOfInterval[i].start();
      arrayOfInt2[i] = paramArrayOfInterval[i].length();
      i += 1;
    }
    init(arrayOfInt1, arrayOfInt2);
  }
  
  private native void addIntervalToSeries(int paramInt1, int paramInt2);
  
  private native void dispose();
  
  private native void init(int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private native void initEmpty();
  
  public void addInterval(int paramInt1, int paramInt2)
  {
    addIntervalToSeries(paramInt1, paramInt2);
  }
  
  public void addInterval(Interval paramInterval)
  {
    addInterval(paramInterval.start(), paramInterval.length());
  }
  
  protected void finalize()
  {
    dispose();
  }
  
  public native Interval[] intervals();
  
  public native int length();
}
