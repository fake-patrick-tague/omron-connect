package com.alivecor.ecgcore;

public enum BeatType
{
  public int code;
  
  static
  {
    BeatType localBeatType1 = new BeatType("UNKNOWN", 0, 0);
    UNKNOWN = localBeatType1;
    BeatType localBeatType2 = new BeatType("NOISE", 1, 1);
    NOISE = localBeatType2;
    BeatType localBeatType3 = new BeatType("NORMAL", 2, 2);
    NORMAL = localBeatType3;
    BeatType localBeatType4 = new BeatType("VEB", 3, 3);
    HIGH = localBeatType4;
    BeatType localBeatType5 = new BeatType("PAC", 4, 4);
    LOW = localBeatType5;
    $VALUES = new BeatType[] { localBeatType1, localBeatType2, localBeatType3, localBeatType4, localBeatType5 };
  }
  
  private BeatType(int paramInt)
  {
    code = paramInt;
  }
  
  public static BeatType fromInt(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return null;
            }
            return LOW;
          }
          return HIGH;
        }
        return NORMAL;
      }
      return NOISE;
    }
    return UNKNOWN;
  }
}
