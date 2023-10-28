package com.alivecor.universal_monitor.bluetooth;

public enum BluetoothDeviceConnectionError
{
  public int code;
  
  static
  {
    BluetoothDeviceConnectionError localBluetoothDeviceConnectionError1 = new BluetoothDeviceConnectionError("UNEXPECTED", 0, -1);
    UNEXPECTED = localBluetoothDeviceConnectionError1;
    BluetoothDeviceConnectionError localBluetoothDeviceConnectionError2 = new BluetoothDeviceConnectionError("NO_ERROR", 1, 0);
    NO_ERROR = localBluetoothDeviceConnectionError2;
    BluetoothDeviceConnectionError localBluetoothDeviceConnectionError3 = new BluetoothDeviceConnectionError("UNSUPPORTED", 2, 1);
    UNSUPPORTED = localBluetoothDeviceConnectionError3;
    BluetoothDeviceConnectionError localBluetoothDeviceConnectionError4 = new BluetoothDeviceConnectionError("BLUETOOTH_OFF", 3, 2);
    BLUETOOTH_OFF = localBluetoothDeviceConnectionError4;
    BluetoothDeviceConnectionError localBluetoothDeviceConnectionError5 = new BluetoothDeviceConnectionError("PAIRING_REQUEST_DENIED", 4, 3);
    PAIRING_REQUEST_DENIED = localBluetoothDeviceConnectionError5;
    BluetoothDeviceConnectionError localBluetoothDeviceConnectionError6 = new BluetoothDeviceConnectionError("DISCONNECTED", 5, 4);
    DISCONNECTED = localBluetoothDeviceConnectionError6;
    $VALUES = new BluetoothDeviceConnectionError[] { localBluetoothDeviceConnectionError1, localBluetoothDeviceConnectionError2, localBluetoothDeviceConnectionError3, localBluetoothDeviceConnectionError4, localBluetoothDeviceConnectionError5, localBluetoothDeviceConnectionError6 };
  }
  
  private BluetoothDeviceConnectionError(int paramInt)
  {
    code = paramInt;
  }
  
  static BluetoothDeviceConnectionError fromGattError(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 5)
      {
        if ((paramInt != 8) && (paramInt != 19) && (paramInt != 22) && (paramInt != 256)) {
          return UNEXPECTED;
        }
        return DISCONNECTED;
      }
      return PAIRING_REQUEST_DENIED;
    }
    return NO_ERROR;
  }
}
