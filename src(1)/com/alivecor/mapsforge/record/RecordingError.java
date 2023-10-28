package com.alivecor.mapsforge.record;

public enum RecordingError
{
  static
  {
    RecordingError localRecordingError1 = new RecordingError("NFC_ON", 0);
    NFC_ON = localRecordingError1;
    RecordingError localRecordingError2 = new RecordingError("BLUETOOTH_OFF", 1);
    BLUETOOTH_OFF = localRecordingError2;
    RecordingError localRecordingError3 = new RecordingError("MIC_PERMISSION_EKG", 2);
    MIC_PERMISSION_EKG = localRecordingError3;
    RecordingError localRecordingError4 = new RecordingError("MIC_PERMISSION_VOICE", 3);
    MIC_PERMISSION_VOICE = localRecordingError4;
    RecordingError localRecordingError5 = new RecordingError("LOCATION_PERMISSION", 4);
    LOCATION_PERMISSION = localRecordingError5;
    RecordingError localRecordingError6 = new RecordingError("NEARBY_DEVICES_PERMISSION", 5);
    NEARBY_DEVICES_PERMISSION = localRecordingError6;
    RecordingError localRecordingError7 = new RecordingError("LOCATION_OFF", 6);
    LOCATION_OFF = localRecordingError7;
    RecordingError localRecordingError8 = new RecordingError("TRIANGLE_BATTERY", 7);
    TRIANGLE_BATTERY = localRecordingError8;
    RecordingError localRecordingError9 = new RecordingError("TRIANGLE_CONNECTION", 8);
    TRIANGLE_CONNECTION = localRecordingError9;
    RecordingError localRecordingError10 = new RecordingError("MAINS_NOISE_EARLY", 9);
    MAINS_NOISE_EARLY = localRecordingError10;
    RecordingError localRecordingError11 = new RecordingError("UNKNOWN", 10);
    UNKNOWN = localRecordingError11;
    $VALUES = new RecordingError[] { localRecordingError1, localRecordingError2, localRecordingError3, localRecordingError4, localRecordingError5, localRecordingError6, localRecordingError7, localRecordingError8, localRecordingError9, localRecordingError10, localRecordingError11 };
  }
  
  public static RecordingError fromValue(String paramString)
  {
    RecordingError[] arrayOfRecordingError = values();
    int j = arrayOfRecordingError.length;
    int i = 0;
    while (i < j)
    {
      RecordingError localRecordingError = arrayOfRecordingError[i];
      if (localRecordingError.name().equals(paramString)) {
        return localRecordingError;
      }
      i += 1;
    }
    return null;
  }
}
