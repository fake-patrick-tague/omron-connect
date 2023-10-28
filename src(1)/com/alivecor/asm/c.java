package com.alivecor.asm;

import com.alivecor.ecgcore.SampleRate;
import com.alivecor.mapsforge.core.model.MainsFilterFrequency;
import java.io.File;

public abstract interface c
{
  public abstract Item a(File paramFile);
  
  public abstract Item a(double[] paramArrayOfDouble, int paramInt, SampleRate paramSampleRate, MainsFilterFrequency paramMainsFilterFrequency);
}
