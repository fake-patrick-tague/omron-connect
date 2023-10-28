package com.alivecor.kardia_ai;

import com.alivecor.ecgcore.ECGSignal;
import com.alivecor.ecgcore.MainsFrequency;
import com.alivecor.ecgcore.SampleRate;

public class Classifier
{
  private long nativeHandle = 0L;
  
  public Classifier()
  {
    init();
  }
  
  public Classifier(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      initWithAlgSuite(paramBoolean2);
      return;
    }
    init();
  }
  
  private native void dispose();
  
  private native void init();
  
  private native void initWithAlgSuite(boolean paramBoolean);
  
  private native ClassifierResult nativeDeterminationFromSamples(double[] paramArrayOfDouble, int paramInt1, int paramInt2);
  
  public native ClassifierResult determinationFromFile(String paramString);
  
  public ClassifierResult determinationFromSamples(double[] paramArrayOfDouble, SampleRate paramSampleRate, MainsFrequency paramMainsFrequency)
  {
    return nativeDeterminationFromSamples(paramArrayOfDouble, code, code);
  }
  
  public ClassifierResult determinationFromSignal(ECGSignal paramECGSignal, MainsFrequency paramMainsFrequency)
  {
    return determinationFromSamples(paramECGSignal.getMVSamples(), paramECGSignal.sampleRate(), paramMainsFrequency);
  }
}
