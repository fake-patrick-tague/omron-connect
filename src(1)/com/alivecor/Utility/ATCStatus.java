package com.alivecor.Utility;

public enum ATCStatus
{
  public int code;
  
  static
  {
    ATCStatus localATCStatus1 = new ATCStatus("READ_SUCCESS", 0, 0);
    READ_SUCCESS = localATCStatus1;
    ATCStatus localATCStatus2 = new ATCStatus("NO_FILE", 1, 1);
    NO_FILE = localATCStatus2;
    ATCStatus localATCStatus3 = new ATCStatus("NO_ATC_SIGNATURE", 2, 2);
    NO_ATC_SIGNATURE = localATCStatus3;
    ATCStatus localATCStatus4 = new ATCStatus("MISSING_DATA", 3, 3);
    MISSING_DATA = localATCStatus4;
    ATCStatus localATCStatus5 = new ATCStatus("CORRUPT_DATA", 4, 4);
    CORRUPT_DATA = localATCStatus5;
    $VALUES = new ATCStatus[] { localATCStatus1, localATCStatus2, localATCStatus3, localATCStatus4, localATCStatus5 };
  }
  
  private ATCStatus(int paramInt)
  {
    code = paramInt;
  }
  
  public static ATCStatus fromInt(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return null;
            }
            return CORRUPT_DATA;
          }
          return MISSING_DATA;
        }
        return NO_ATC_SIGNATURE;
      }
      return NO_FILE;
    }
    return READ_SUCCESS;
  }
}
