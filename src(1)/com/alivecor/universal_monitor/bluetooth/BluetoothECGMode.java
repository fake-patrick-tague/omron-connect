package com.alivecor.universal_monitor.bluetooth;

public enum BluetoothECGMode
{
  public int mode;
  
  static
  {
    BluetoothECGMode localBluetoothECGMode1 = new BluetoothECGMode("UNKNOWN", 0, 0);
    UNKNOWN = localBluetoothECGMode1;
    BluetoothECGMode localBluetoothECGMode2 = new BluetoothECGMode("SINGLE_LEAD_300HZ", 1, 1);
    SINGLE_LEAD_300HZ = localBluetoothECGMode2;
    BluetoothECGMode localBluetoothECGMode3 = new BluetoothECGMode("DUAL_LEAD_300HZ", 2, 2);
    DUAL_LEAD_300HZ = localBluetoothECGMode3;
    BluetoothECGMode localBluetoothECGMode4 = new BluetoothECGMode("SINGLE_LEAD_600HZ", 3, 3);
    SINGLE_LEAD_600HZ = localBluetoothECGMode4;
    BluetoothECGMode localBluetoothECGMode5 = new BluetoothECGMode("DUAL_LEAD_600HZ", 4, 4);
    DUAL_LEAD_600HZ = localBluetoothECGMode5;
    $VALUES = new BluetoothECGMode[] { localBluetoothECGMode1, localBluetoothECGMode2, localBluetoothECGMode3, localBluetoothECGMode4, localBluetoothECGMode5 };
  }
  
  private BluetoothECGMode(int paramInt)
  {
    mode = paramInt;
  }
  
  public static BluetoothECGMode fromInt(int paramInt)
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
            return DUAL_LEAD_600HZ;
          }
          return SINGLE_LEAD_600HZ;
        }
        return DUAL_LEAD_300HZ;
      }
      return SINGLE_LEAD_300HZ;
    }
    return UNKNOWN;
  }
}
