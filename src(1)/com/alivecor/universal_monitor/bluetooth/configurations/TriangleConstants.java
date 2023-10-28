package com.alivecor.universal_monitor.bluetooth.configurations;

import java.util.UUID;

public class TriangleConstants
{
  public static final UUID BATTERY_LEVEL_CHARACTERISTIC_UUID;
  public static final UUID BATTERY_SERVICE_UUID = UUID.fromString("0000180F-0000-1000-8000-00805F9B34FB");
  public static final UUID CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID = UUID.fromString("00002902-0000-1000-8000-00805F9B34FB");
  public static final UUID DEVICE_INFO_FIRMWARE_REVISION_CHARACTERISTIC_UUID;
  public static final UUID DEVICE_INFO_HARDWARE_REVISION_CHARACTERISTIC_UUID;
  public static final UUID DEVICE_INFO_MANUFACTURER_NAME_CHARACTERISTIC_UUID;
  public static final UUID DEVICE_INFO_MODEL_NUMBER_CHARACTERISTIC_UUID;
  public static final UUID DEVICE_INFO_SERIAL_NUMBER_CHARACTERISTIC_UUID;
  public static final UUID DEVICE_INFO_SERVICE_UUID;
  public static final UUID DEVICE_INFO_SOFTWARE_REVISION_CHARACTERISTIC_UUID;
  public static final UUID ECG_1LEAD_CHARACTERISTIC_UUID;
  public static final UUID ECG_1LEAD_SERVICE_UUID;
  public static final UUID ECG_6LEAD_CMD_CHARACTERISTIC_UUID;
  public static final UUID ECG_6LEAD_ECG_CHARACTERISTIC_UUID;
  public static final UUID ECG_6LEAD_SERVICE_UUID;
  public static final UUID GENERIC_ATTRIBUTE_SERVICE_UUID = UUID.fromString("00001801-0000-1000-8000-00805f9b34fb");
  public static final UUID SERVICE_CHANGED_CHARACTERISTIC_UUID = UUID.fromString("00002A05-0000-1000-8000-00805f9b34fb");
  
  static
  {
    BATTERY_LEVEL_CHARACTERISTIC_UUID = UUID.fromString("00002A19-0000-1000-8000-00805F9B34FB");
    DEVICE_INFO_SERVICE_UUID = UUID.fromString("0000180A-0000-1000-8000-00805F9B34FB");
    DEVICE_INFO_MODEL_NUMBER_CHARACTERISTIC_UUID = UUID.fromString("00002A24-0000-1000-8000-00805F9B34FB");
    DEVICE_INFO_SERIAL_NUMBER_CHARACTERISTIC_UUID = UUID.fromString("00002A25-0000-1000-8000-00805F9B34FB");
    DEVICE_INFO_FIRMWARE_REVISION_CHARACTERISTIC_UUID = UUID.fromString("00002A26-0000-1000-8000-00805F9B34FB");
    DEVICE_INFO_HARDWARE_REVISION_CHARACTERISTIC_UUID = UUID.fromString("00002A27-0000-1000-8000-00805F9B34FB");
    DEVICE_INFO_SOFTWARE_REVISION_CHARACTERISTIC_UUID = UUID.fromString("00002A28-0000-1000-8000-00805F9B34FB");
    DEVICE_INFO_MANUFACTURER_NAME_CHARACTERISTIC_UUID = UUID.fromString("00002A29-0000-1000-8000-00805F9B34FB");
    ECG_1LEAD_SERVICE_UUID = UUID.fromString("AC010001-F0A3-A691-444E-2A8AC9345D06");
    ECG_1LEAD_CHARACTERISTIC_UUID = UUID.fromString("AC010002-F0A3-A691-444E-2A8AC9345D06");
    ECG_6LEAD_SERVICE_UUID = UUID.fromString("AC060001-328C-A28F-9846-5A8AA212661B");
    ECG_6LEAD_CMD_CHARACTERISTIC_UUID = UUID.fromString("AC060002-328C-A28F-9846-5A8AA212661B");
    ECG_6LEAD_ECG_CHARACTERISTIC_UUID = UUID.fromString("AC060003-328C-A28F-9846-5A8AA212661B");
  }
  
  public TriangleConstants() {}
  
  static String characteristicName(UUID paramUUID)
  {
    if (paramUUID.equals(BATTERY_LEVEL_CHARACTERISTIC_UUID)) {
      return "battery level";
    }
    if (paramUUID.equals(DEVICE_INFO_MODEL_NUMBER_CHARACTERISTIC_UUID)) {
      return "device info - model number";
    }
    if (paramUUID.equals(DEVICE_INFO_SERIAL_NUMBER_CHARACTERISTIC_UUID)) {
      return "device info - serial number";
    }
    if (paramUUID.equals(DEVICE_INFO_FIRMWARE_REVISION_CHARACTERISTIC_UUID)) {
      return "device info - firmware revision";
    }
    if (paramUUID.equals(DEVICE_INFO_HARDWARE_REVISION_CHARACTERISTIC_UUID)) {
      return "device info - hardware revision";
    }
    if (paramUUID.equals(DEVICE_INFO_SOFTWARE_REVISION_CHARACTERISTIC_UUID)) {
      return "device info - software revision";
    }
    if (paramUUID.equals(DEVICE_INFO_MANUFACTURER_NAME_CHARACTERISTIC_UUID)) {
      return "device info - manufacturer name";
    }
    if (paramUUID.equals(ECG_1LEAD_CHARACTERISTIC_UUID)) {
      return "1-lead ecg characteristic";
    }
    if (paramUUID.equals(ECG_6LEAD_CMD_CHARACTERISTIC_UUID)) {
      return "6-lead cmd characteristic";
    }
    if (paramUUID.equals(ECG_6LEAD_ECG_CHARACTERISTIC_UUID)) {
      return "6-lead ecg characteristic";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown characteristic: ");
    localStringBuilder.append(paramUUID.toString());
    return localStringBuilder.toString();
  }
  
  static String serviceName(UUID paramUUID)
  {
    if (paramUUID.equals(BATTERY_SERVICE_UUID)) {
      return "battery service";
    }
    if (paramUUID.equals(DEVICE_INFO_SERVICE_UUID)) {
      return "device info";
    }
    if (paramUUID.equals(ECG_1LEAD_SERVICE_UUID)) {
      return "1-lead ecg service";
    }
    if (paramUUID.equals(ECG_6LEAD_SERVICE_UUID)) {
      return "6-lead ecg service";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown service: ");
    localStringBuilder.append(paramUUID.toString());
    return localStringBuilder.toString();
  }
}
