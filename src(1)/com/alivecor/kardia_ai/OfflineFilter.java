package com.alivecor.kardia_ai;

import com.alivecor.ecgcore.MainsFrequency;
import com.alivecor.ecgcore.SampleRate;

public abstract interface OfflineFilter
{
  public abstract double[] filter(double[] paramArrayOfDouble, SampleRate paramSampleRate, MainsFrequency paramMainsFrequency);
}
