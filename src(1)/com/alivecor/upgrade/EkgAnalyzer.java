package com.alivecor.upgrade;

import com.alivecor.asm.ClassifierData.b;
import com.alivecor.asm.Item;
import com.alivecor.asm.Label;
import com.alivecor.asm.c;
import com.alivecor.ecgcore.ECGSignal;
import com.alivecor.ecgcore.ECGSignalMV;
import com.alivecor.mapsforge.core.model.MainsFilterFrequency;

public class EkgAnalyzer
{
  private final c classifyRunner;
  private final InternalRecordApiUtil util = InternalRecordApiUtil._();
  
  EkgAnalyzer(c paramC)
  {
    classifyRunner = paramC;
  }
  
  public Result classifySamples(double[] paramArrayOfDouble, int paramInt1, int paramInt2, SampleRate paramSampleRate)
  {
    Object localObject = MainsFilterFrequency.fromFrequency(paramInt2);
    paramArrayOfDouble = new ECGSignalMV(paramArrayOfDouble, util.internalSampleRate(paramSampleRate)).resample(com.alivecor.ecgcore.SampleRate.RATE_300_HZ);
    paramArrayOfDouble = classifyRunner.a(paramArrayOfDouble.getMVSamples(), paramInt1, paramArrayOfDouble.sampleRate(), (MainsFilterFrequency)localObject);
    paramSampleRate = util.externalDetermination(((ClassifierData.b)b.newUTF8()).getDetermination());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b.b());
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(b.a());
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(b.c());
    return new Result(paramSampleRate, ((StringBuilder)localObject).toString(), c, d);
  }
  
  public class Result
  {
    public final String errorMsg;
    public final String kardiaAiVersion;
    public final int pos;
    
    public Result(String paramString1, int paramInt, String paramString2)
    {
      kardiaAiVersion = paramString1;
      pos = paramInt;
      errorMsg = paramString2;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Result{determination=");
      localStringBuilder.append(EkgAnalyzer.this);
      localStringBuilder.append(", kardiaAiVersion='");
      localStringBuilder.append(kardiaAiVersion);
      localStringBuilder.append('\'');
      localStringBuilder.append(", hr=");
      localStringBuilder.append(pos);
      localStringBuilder.append(", errorMsg='");
      localStringBuilder.append(errorMsg);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
