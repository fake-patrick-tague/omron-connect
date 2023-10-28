package com.alivecor.mapsforge.record;

import com.alivecor.mapsforge.core.model.Direction;
import com.alivecor.mapsforge.core.model.Frame;
import java.io.Serializable;

public class RecordResult
  implements Serializable
{
  float averageHeartRate;
  long dateTimeUtcMillis;
  String deviceBluetoothAddress;
  String enhancedPath;
  boolean inverted;
  Direction leadsConfig;
  String localRecordingID;
  String originalPath;
  Frame recordingDeviceData;
  int timezoneOffset;
  boolean voiceEnabled;
  
  public RecordResult(String paramString)
  {
    localRecordingID = paramString;
  }
  
  public float getAverageHeartRate()
  {
    return averageHeartRate;
  }
  
  public long getDateTimeUtcMillis()
  {
    return dateTimeUtcMillis;
  }
  
  public String getDeviceBluetoothAddress()
  {
    return deviceBluetoothAddress;
  }
  
  public String getEnhancedPath()
  {
    return enhancedPath;
  }
  
  public Direction getLeadsConfig()
  {
    return leadsConfig;
  }
  
  public String getLocalRecordingID()
  {
    return localRecordingID;
  }
  
  public String getOriginalPath()
  {
    return originalPath;
  }
  
  public Frame getRecordingDeviceData()
  {
    return recordingDeviceData;
  }
  
  public int getTimezoneOffset()
  {
    return timezoneOffset;
  }
  
  public boolean isInverted()
  {
    return inverted;
  }
  
  boolean isVoiceEnabled()
  {
    return voiceEnabled;
  }
  
  public void setAverageHeartRate(float paramFloat)
  {
    averageHeartRate = paramFloat;
  }
  
  public void setDateTimeUtcMillis(long paramLong)
  {
    dateTimeUtcMillis = paramLong;
  }
  
  public void setDeviceBluetoothAddress(String paramString)
  {
    deviceBluetoothAddress = paramString;
  }
  
  public void setEnhancedPath(String paramString)
  {
    enhancedPath = paramString;
  }
  
  public void setInverted(boolean paramBoolean)
  {
    inverted = paramBoolean;
  }
  
  public void setLeadsConfig(Direction paramDirection)
  {
    leadsConfig = paramDirection;
  }
  
  public void setOriginalPath(String paramString)
  {
    originalPath = paramString;
  }
  
  public void setRecordingDeviceData(Frame paramFrame)
  {
    recordingDeviceData = paramFrame;
  }
  
  public void setTimezoneOffset(int paramInt)
  {
    timezoneOffset = paramInt;
  }
  
  void setVoiceEnabled(boolean paramBoolean)
  {
    voiceEnabled = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordResult{recordingDeviceData=");
    localStringBuilder.append(recordingDeviceData);
    localStringBuilder.append(", deviceBluetoothAddress='");
    localStringBuilder.append(deviceBluetoothAddress);
    localStringBuilder.append('\'');
    localStringBuilder.append(", originalPath='");
    localStringBuilder.append(originalPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", enhancedPath='");
    localStringBuilder.append(enhancedPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", localRecordingID='");
    localStringBuilder.append(localRecordingID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", inverted=");
    localStringBuilder.append(inverted);
    localStringBuilder.append(", dateTimeUtcMillis=");
    localStringBuilder.append(dateTimeUtcMillis);
    localStringBuilder.append(", leadsConfig=");
    localStringBuilder.append(leadsConfig);
    localStringBuilder.append(", voiceEnabled=");
    localStringBuilder.append(voiceEnabled);
    localStringBuilder.append(", timezoneOffset=");
    localStringBuilder.append(timezoneOffset);
    localStringBuilder.append(", averageHeartRate=");
    localStringBuilder.append(averageHeartRate);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
