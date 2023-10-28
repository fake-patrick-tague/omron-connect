package com.alivecor.Utility;

import com.alivecor.ecgcore.BeatSeries;
import com.alivecor.ecgcore.ECGLead;
import com.alivecor.ecgcore.ECGSignal;
import com.alivecor.ecgcore.MainsFrequency;
import com.alivecor.ecgcore.SampleRate;

public class ATCWriter
{
  private long nativeHandle;
  
  public ATCWriter(String paramString)
  {
    init(paramString);
  }
  
  private native void dispose();
  
  private native void init(String paramString);
  
  private native int nativeWriteAverageBeat(short[] paramArrayOfShort, int paramInt);
  
  private native int nativeWriteHeader(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, char paramChar, int paramInt1, int paramInt2);
  
  private native int nativeWriteSamples(short[] paramArrayOfShort, int paramInt);
  
  public native void close();
  
  protected void finalize()
  {
    dispose();
  }
  
  public native boolean isOpen();
  
  public native int writeAnnotations(BeatSeries paramBeatSeries);
  
  public int writeAverageBeat(ECGSignal paramECGSignal, ECGLead paramECGLead)
  {
    return nativeWriteAverageBeat(paramECGSignal.getATCSamples(), code);
  }
  
  public int writeHeader(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, char paramChar, SampleRate paramSampleRate, MainsFrequency paramMainsFrequency)
  {
    return nativeWriteHeader(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramChar, code, code);
  }
  
  public int writeSamples(ECGSignal paramECGSignal, ECGLead paramECGLead)
  {
    return nativeWriteSamples(paramECGSignal.getATCSamples(), code);
  }
}
