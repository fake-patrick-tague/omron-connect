package com.alivecor.upgrade;

import java.io.File;
import java.io.Serializable;

public class AliveCorEcg
  implements Serializable
{
  private static final long serialVersionUID = 3L;
  private RecordingDeviceInfo deviceInfo;
  private long durationMs;
  private EcgEvaluation ecgEvaluation;
  private String enhancedAtcPath;
  private File filesDirectory;
  private String rawAtcPath;
  private long recordedAtMs;
  private RecordingConfiguration recordingConfiguration;
  private int timezoneOffset;
  private String uuid;
  
  public AliveCorEcg() {}
  
  public RecordingDeviceInfo getDeviceInfo()
  {
    return deviceInfo;
  }
  
  public long getDurationMs()
  {
    return durationMs;
  }
  
  public EcgEvaluation getEcgEvaluation()
  {
    return ecgEvaluation;
  }
  
  public String getEnhancedAtcPath()
  {
    return enhancedAtcPath;
  }
  
  public File getFilesDirectory()
  {
    return filesDirectory;
  }
  
  public String getRawAtcPath()
  {
    return rawAtcPath;
  }
  
  public long getRecordedAtMs()
  {
    return recordedAtMs;
  }
  
  public RecordingConfiguration getRecordingConfiguration()
  {
    return recordingConfiguration;
  }
  
  public int getTimezoneOffset()
  {
    return timezoneOffset;
  }
  
  public String getUuid()
  {
    return uuid;
  }
  
  public void setDeviceInfo(RecordingDeviceInfo paramRecordingDeviceInfo)
  {
    deviceInfo = paramRecordingDeviceInfo;
  }
  
  public void setDurationMs(long paramLong)
  {
    durationMs = paramLong;
  }
  
  public void setEcgEvaluation(EcgEvaluation paramEcgEvaluation)
  {
    ecgEvaluation = paramEcgEvaluation;
  }
  
  public void setEnhancedAtcPath(String paramString)
  {
    enhancedAtcPath = paramString;
  }
  
  public void setFilesDirectory(File paramFile)
  {
    filesDirectory = paramFile;
  }
  
  public void setRawAtcPath(String paramString)
  {
    rawAtcPath = paramString;
  }
  
  public void setRecordedAtMs(long paramLong)
  {
    recordedAtMs = paramLong;
  }
  
  public void setRecordingConfiguration(RecordingConfiguration paramRecordingConfiguration)
  {
    recordingConfiguration = paramRecordingConfiguration;
  }
  
  public void setTimezoneOffset(int paramInt)
  {
    timezoneOffset = paramInt;
  }
  
  public void setUuid(String paramString)
  {
    uuid = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AliveCorEcg{rawAtcPath='");
    localStringBuilder.append(rawAtcPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", enhancedAtcPath='");
    localStringBuilder.append(enhancedAtcPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", filesDirectory=");
    localStringBuilder.append(filesDirectory);
    localStringBuilder.append(", recordedAtMs=");
    localStringBuilder.append(recordedAtMs);
    localStringBuilder.append(", uuid='");
    localStringBuilder.append(uuid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", deviceInfo=");
    localStringBuilder.append(deviceInfo);
    localStringBuilder.append(", recordingConfiguration=");
    localStringBuilder.append(recordingConfiguration);
    localStringBuilder.append(", ecgEvaluation=");
    localStringBuilder.append(ecgEvaluation);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
