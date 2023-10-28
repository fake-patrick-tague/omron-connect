package com.alivecor.ecgcore;

public class ECGSignalMV
  implements ECGSignal
{
  private SampleRate sampleRate;
  private double[] samplesMV;
  
  public ECGSignalMV(double[] paramArrayOfDouble, SampleRate paramSampleRate)
  {
    samplesMV = paramArrayOfDouble;
    sampleRate = paramSampleRate;
  }
  
  private native double[] resampleSignal(double[] paramArrayOfDouble, int paramInt1, int paramInt2);
  
  public short[] getATCSamples()
  {
    throw new IllegalArgumentException("Implicit conversion from double-precision to short int not allowed in ECGSignalMV getATCSamples.");
  }
  
  public double[] getMVSamples()
  {
    return samplesMV;
  }
  
  public int length()
  {
    return samplesMV.length;
  }
  
  public ECGSignal resample(SampleRate paramSampleRate)
  {
    return new ECGSignalMV(resampleSignal(samplesMV, sampleRate.code, code), paramSampleRate);
  }
  
  public SampleRate sampleRate()
  {
    return sampleRate;
  }
}
