package com.alivecor.ecgcore;

public class BeatAnnotation
{
  private BeatType beatType;
  private int offset;
  
  private BeatAnnotation(int paramInt1, int paramInt2)
  {
    offset = paramInt1;
    beatType = BeatType.fromInt(paramInt2);
  }
  
  public BeatAnnotation(int paramInt, BeatType paramBeatType)
  {
    offset = paramInt;
    beatType = paramBeatType;
  }
  
  public BeatType beatType()
  {
    return beatType;
  }
  
  public int offset()
  {
    return offset;
  }
}
