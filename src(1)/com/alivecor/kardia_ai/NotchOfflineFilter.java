package com.alivecor.kardia_ai;

import com.alivecor.ecgcore.MainsFrequency;
import com.alivecor.ecgcore.SampleRate;

public class NotchOfflineFilter
  implements OfflineFilter
{
  public NotchOfflineFilter() {}
  
  public double[] filter(double[] paramArrayOfDouble, SampleRate paramSampleRate, MainsFrequency paramMainsFrequency)
  {
    return filterImpl(paramArrayOfDouble, code, code);
  }
  
  public native double[] filterImpl(double[] paramArrayOfDouble, int paramInt1, int paramInt2);
}
