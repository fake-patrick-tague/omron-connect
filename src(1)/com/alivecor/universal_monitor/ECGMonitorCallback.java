package com.alivecor.universal_monitor;

public abstract class ECGMonitorCallback
{
  public ECGMonitorCallback() {}
  
  public void monitorBeatDetected(int paramInt1, int paramInt2) {}
  
  public void monitorLeadsStateUpdated(LeadState paramLeadState1, LeadState paramLeadState2) {}
  
  public void monitorMainsNoiseStarted() {}
  
  public void monitorMainsNoiseStopped() {}
  
  public void monitorNoiseLevelUpdated(int paramInt) {}
  
  public void monitorPreviewSamples(LeadValues paramLeadValues) {}
  
  public void monitorRecordingComplete(RecordingStatus paramRecordingStatus, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void monitorRecordingFailed(RecordingStatus paramRecordingStatus, String paramString) {}
  
  public void monitorRecordingProgress(int paramInt) {}
  
  public void monitorRecordingResumed() {}
  
  public void monitorRecordingStarted() {}
  
  public void monitorRecordingStopped() {}
  
  public void monitorSignalStrengthUpdated(int paramInt) {}
  
  public void monitorStartPreview() {}
  
  public void monitorStopPreview() {}
}
