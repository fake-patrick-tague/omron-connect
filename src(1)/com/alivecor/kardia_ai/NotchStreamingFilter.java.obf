package com.alivecor.kardia_ai;

import com.alivecor.ecgcore.MainsFrequency;
import com.alivecor.ecgcore.SampleRate;

public class NotchStreamingFilter
{
  private long nativeHandle = 0L;
  
  public NotchStreamingFilter(SampleRate paramSampleRate, MainsFrequency paramMainsFrequency)
  {
    init(code, code);
  }
  
  private native void dispose();
  
  private native void init(int paramInt1, int paramInt2);
  
  public native int delay();
  
  public native double filterSample(double paramDouble, HeartRateUpdate paramHeartRateUpdate);
  
  protected void finalize()
  {
    dispose();
  }
  
  public native void reset();
}
