package com.alivecor.mapsforge.record;

import java.io.Serializable;

public class RecordingHelpUrls
  implements Serializable
{
  public final String bluetoothOff;
  public final String locationPermission;
  public final String mainsNoise;
  public final String micPermission;
  public final String nfcOn;
  public final String recordingHudHelp1L;
  public final String recordingHudHelp6L;
  private RecordingResultHelpUrls recordingResultHelpLinks;
  public final String shortRecording;
  public final String triangleBattery;
  public final String triangleConnection;
  public final String unreadableRecording;
  
  public RecordingHelpUrls(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    locationPermission = paramString1;
    mainsNoise = paramString2;
    micPermission = paramString3;
    nfcOn = paramString4;
    triangleBattery = paramString5;
    triangleConnection = paramString6;
    bluetoothOff = paramString7;
    shortRecording = paramString8;
    unreadableRecording = paramString9;
    recordingHudHelp1L = paramString10;
    recordingHudHelp6L = paramString11;
    recordingResultHelpLinks = new RecordingResultHelpUrls();
  }
  
  public RecordingHelpUrls(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, RecordingResultHelpUrls paramRecordingResultHelpUrls)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11);
    recordingResultHelpLinks = paramRecordingResultHelpUrls;
  }
  
  public RecordingResultHelpUrls getRecordingResultHelpLinks()
  {
    return recordingResultHelpLinks;
  }
  
  public void setRecordingResultHelpLinks(RecordingResultHelpUrls paramRecordingResultHelpUrls)
  {
    recordingResultHelpLinks = paramRecordingResultHelpUrls;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordingHelpUrls{locationPermission='");
    localStringBuilder.append(locationPermission);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mainsNoise='");
    localStringBuilder.append(mainsNoise);
    localStringBuilder.append('\'');
    localStringBuilder.append(", micPermission='");
    localStringBuilder.append(micPermission);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nfcOn='");
    localStringBuilder.append(nfcOn);
    localStringBuilder.append('\'');
    localStringBuilder.append(", triangleBattery='");
    localStringBuilder.append(triangleBattery);
    localStringBuilder.append('\'');
    localStringBuilder.append(", triangleConnection='");
    localStringBuilder.append(triangleConnection);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bluetoothOff='");
    localStringBuilder.append(bluetoothOff);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shortRecording='");
    localStringBuilder.append(shortRecording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", unreadableRecording='");
    localStringBuilder.append(unreadableRecording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recordingHudHelp1L='");
    localStringBuilder.append(recordingHudHelp1L);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recordingHudHelp6L='");
    localStringBuilder.append(recordingHudHelp6L);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recordingResultHelpLinks=");
    localStringBuilder.append(recordingResultHelpLinks);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
