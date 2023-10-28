package com.alivecor.ecgcore;

public class ECGSignalATC
  implements ECGSignal
{
  private SampleRate sampleRate;
  private short[] samplesATC;
  
  public ECGSignalATC(short[] paramArrayOfShort, SampleRate paramSampleRate)
  {
    samplesATC = paramArrayOfShort;
    sampleRate = paramSampleRate;
  }
  
  private native double[] convertSamplesToMV(short[] paramArrayOfShort);
  
  public short[] getATCSamples()
  {
    return samplesATC;
  }
  
  public double[] getMVSamples()
  {
    return convertSamplesToMV(samplesATC);
  }
  
  public int length()
  {
    return samplesATC.length;
  }
  
  public ECGSignal resample(SampleRate paramSampleRate)
  {
    return new ECGSignalMV(getMVSamples(), sampleRate).resample(paramSampleRate);
  }
  
  public SampleRate sampleRate()
  {
    return sampleRate;
  }
}
