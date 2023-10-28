package com.alivecor.universal_monitor.bluetooth;

public class BluetoothDeviceProperties
{
  public int batteryLevel = -1;
  public String firmwareRevision;
  public String hardwareRevision;
  public String manufacturerName;
  public String modelNumber;
  public String serialNumber;
  public String softwareRevision;
  
  public BluetoothDeviceProperties() {}
  
  public String deviceData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (serialNumber != null)
    {
      localStringBuilder.append("SN=");
      localStringBuilder.append(serialNumber);
    }
    if (batteryLevel >= 0)
    {
      if (serialNumber != null) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append("BAT=");
      localStringBuilder.append(batteryLevel);
    }
    return localStringBuilder.toString();
  }
  
  public String recorderHardware()
  {
    if ((hardwareRevision != null) && (firmwareRevision != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("triangle hw");
      localStringBuilder.append(hardwareRevision);
      localStringBuilder.append(" fw");
      localStringBuilder.append(firmwareRevision);
      return localStringBuilder.toString();
    }
    return "";
  }
}
