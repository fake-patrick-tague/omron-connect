package com.alivecor.universal_monitor;

public enum RecordingStatus
{
  public int code;
  
  static
  {
    RecordingStatus localRecordingStatus1 = new RecordingStatus("OK", 0, 0);
    ALPHABETICAL = localRecordingStatus1;
    RecordingStatus localRecordingStatus2 = new RecordingStatus("MAX_DURATION", 1, 1);
    MAX_DURATION = localRecordingStatus2;
    RecordingStatus localRecordingStatus3 = new RecordingStatus("LEADS_OFF", 2, 2);
    LEADS_OFF = localRecordingStatus3;
    RecordingStatus localRecordingStatus4 = new RecordingStatus("MAINS_NOISE", 3, 3);
    MAINS_NOISE = localRecordingStatus4;
    RecordingStatus localRecordingStatus5 = new RecordingStatus("WRITE_ERROR", 4, 4);
    WRITE_ERROR = localRecordingStatus5;
    RecordingStatus localRecordingStatus6 = new RecordingStatus("INTERNAL_ERROR", 5, 5);
    INTERNAL_ERROR = localRecordingStatus6;
    $VALUES = new RecordingStatus[] { localRecordingStatus1, localRecordingStatus2, localRecordingStatus3, localRecordingStatus4, localRecordingStatus5, localRecordingStatus6 };
  }
  
  private RecordingStatus(int paramInt)
  {
    code = paramInt;
  }
  
  public static RecordingStatus fromInt(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return null;
              }
              return INTERNAL_ERROR;
            }
            return WRITE_ERROR;
          }
          return MAINS_NOISE;
        }
        return LEADS_OFF;
      }
      return MAX_DURATION;
    }
    return ALPHABETICAL;
  }
}
