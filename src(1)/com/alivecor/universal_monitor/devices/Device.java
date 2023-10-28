package com.alivecor.universal_monitor.devices;

public class Device
{
  protected String deviceData = "";
  private long nativeHandle = 0L;
  protected String recorderHardware = "";
  
  public Device() {}
  
  private native void disposeImpl(long paramLong);
  
  public String deviceData()
  {
    return deviceData;
  }
  
  public void dispose()
  {
    disposeImpl(nativeHandle);
    nativeHandle = 0L;
  }
  
  public String recorderHardware()
  {
    return recorderHardware;
  }
  
  public void startCapturing() {}
  
  public void stopCapturing() {}
}
