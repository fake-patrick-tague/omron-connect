package com.alivecor.universal_monitor;

import android.os.Handler;
import android.os.Looper;
import com.alivecor.universal_monitor.devices.Device;

public class ECGMonitor
{
  private ECGMonitorCallback callback;
  private Device device;
  private Handler mainHandler;
  private long nativeHandle = 0L;
  
  public ECGMonitor(Device paramDevice, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, boolean paramBoolean, Filter paramFilter, int paramInt2, int paramInt3, ECGMonitorCallback paramECGMonitorCallback)
  {
    device = paramDevice;
    mainHandler = new Handler(Looper.getMainLooper());
    callback = mainThreadCallback(paramECGMonitorCallback);
    init(paramDevice, paramString1, paramString2, paramString3, paramString4, paramDevice.recorderHardware(), paramDevice.deviceData(), paramInt1, paramBoolean, filter, paramInt2, paramInt3, callback);
  }
  
  private native void disposeImpl(long paramLong);
  
  private native void init(Device paramDevice, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, ECGMonitorCallback paramECGMonitorCallback);
  
  private ECGMonitorCallback mainThreadCallback(final ECGMonitorCallback paramECGMonitorCallback)
  {
    new ECGMonitorCallback()
    {
      public void monitorBeatDetected(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        mainHandler.post(new b(paramECGMonitorCallback, paramAnonymousInt1, paramAnonymousInt2));
      }
      
      public void monitorLeadsStateUpdated(LeadState paramAnonymousLeadState1, LeadState paramAnonymousLeadState2)
      {
        mainHandler.post(new NumberPicker.PressedStateHelper(paramECGMonitorCallback, paramAnonymousLeadState1, paramAnonymousLeadState2));
      }
      
      public void monitorMainsNoiseStarted()
      {
        mainHandler.post(new MainActivity.5(paramECGMonitorCallback));
      }
      
      public void monitorMainsNoiseStopped()
      {
        mainHandler.post(new LatinIME.2(paramECGMonitorCallback));
      }
      
      public void monitorNoiseLevelUpdated(int paramAnonymousInt)
      {
        mainHandler.post(new StreamPumper(paramECGMonitorCallback, paramAnonymousInt));
      }
      
      public void monitorPreviewSamples(LeadValues paramAnonymousLeadValues)
      {
        mainHandler.post(new FileBrowser.11(paramECGMonitorCallback, paramAnonymousLeadValues));
      }
      
      public void monitorRecordingComplete(RecordingStatus paramAnonymousRecordingStatus, boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        mainHandler.post(new a(paramECGMonitorCallback, paramAnonymousRecordingStatus, paramAnonymousBoolean, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3));
      }
      
      public void monitorRecordingFailed(RecordingStatus paramAnonymousRecordingStatus, String paramAnonymousString)
      {
        mainHandler.post(new Item(paramECGMonitorCallback, paramAnonymousRecordingStatus, paramAnonymousString));
      }
      
      public void monitorRecordingProgress(int paramAnonymousInt)
      {
        mainHandler.post(new GifDrawable.3(paramECGMonitorCallback, paramAnonymousInt));
      }
      
      public void monitorRecordingResumed()
      {
        mainHandler.post(new InitiationListener.1(paramECGMonitorCallback));
      }
      
      public void monitorRecordingStarted()
      {
        mainHandler.post(new GeckoLayerClient.1(paramECGMonitorCallback));
      }
      
      public void monitorRecordingStopped()
      {
        mainHandler.post(new TaskListFragment.7(paramECGMonitorCallback));
      }
      
      public void monitorSignalStrengthUpdated(int paramAnonymousInt)
      {
        mainHandler.post(new Slider(paramECGMonitorCallback, paramAnonymousInt));
      }
      
      public void monitorStartPreview()
      {
        mainHandler.post(new TestActivity.1(paramECGMonitorCallback));
      }
      
      public void monitorStopPreview()
      {
        mainHandler.post(new FileBrowser.10(paramECGMonitorCallback));
      }
    };
  }
  
  public void dispose()
  {
    mainHandler.removeCallbacksAndMessages(null);
    disposeImpl(nativeHandle);
    nativeHandle = 0L;
  }
  
  public native void invertRecording();
  
  public native void setDeviceData(String paramString);
  
  public native void setRecorderHardware(String paramString);
  
  public void start()
  {
    device.startCapturing();
  }
  
  public void stop()
  {
    device.stopCapturing();
  }
}
