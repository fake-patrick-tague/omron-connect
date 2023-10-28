package com.alivecor.ecgcore;

public abstract interface ECGSignal
{
  public abstract short[] getATCSamples();
  
  public abstract double[] getMVSamples();
  
  public abstract int length();
  
  public abstract ECGSignal resample(SampleRate paramSampleRate);
  
  public abstract SampleRate sampleRate();
}
