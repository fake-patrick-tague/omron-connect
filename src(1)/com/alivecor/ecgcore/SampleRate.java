package com.alivecor.ecgcore;

public enum SampleRate
{
  public int code;
  
  static
  {
    SampleRate localSampleRate1 = new SampleRate("RATE_125_HZ", 0, 0);
    RATE_125_HZ = localSampleRate1;
    SampleRate localSampleRate2 = new SampleRate("RATE_250_HZ", 1, 1);
    RATE_250_HZ = localSampleRate2;
    SampleRate localSampleRate3 = new SampleRate("RATE_300_HZ", 2, 2);
    RATE_300_HZ = localSampleRate3;
    SampleRate localSampleRate4 = new SampleRate("RATE_500_HZ", 3, 3);
    RATE_500_HZ = localSampleRate4;
    SampleRate localSampleRate5 = new SampleRate("RATE_600_HZ", 4, 4);
    RATE_600_HZ = localSampleRate5;
    $VALUES = new SampleRate[] { localSampleRate1, localSampleRate2, localSampleRate3, localSampleRate4, localSampleRate5 };
  }
  
  private SampleRate(int paramInt)
  {
    code = paramInt;
  }
  
  public static SampleRate fromInt(int paramInt)
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
            return RATE_600_HZ;
          }
          return RATE_500_HZ;
        }
        return RATE_300_HZ;
      }
      return RATE_250_HZ;
    }
    return RATE_125_HZ;
  }
}
