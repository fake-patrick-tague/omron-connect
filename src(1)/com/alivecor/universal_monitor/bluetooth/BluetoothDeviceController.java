package com.alivecor.universal_monitor.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.alivecor.universal_monitor.bluetooth.configurations.BleUtil;
import com.alivecor.universal_monitor.bluetooth.configurations.EcgBleManager;
import com.alivecor.universal_monitor.bluetooth.configurations.EcgBleManagerCallback;
import com.alivecor.universal_monitor.bluetooth.configurations.TriangleMode;
import com.alivecor.universal_monitor.devices.TriangleDevice;
import java.util.HashMap;

public class BluetoothDeviceController
{
  private static final String PAGE_KEY = "BluetoothDeviceController";
  private BluetoothDeviceControllerCallback callback;
  private TriangleDevice connectedTriangleDevice;
  private Context context;
  private HashMap<String, TriangleDevice> discoveredDevices;
  private EcgBleManager ecgBleManager;
  private final Handler mainHandler;
  
  public BluetoothDeviceController(BluetoothDeviceControllerCallback paramBluetoothDeviceControllerCallback, Context paramContext)
  {
    callback = paramBluetoothDeviceControllerCallback;
    ecgBleManager = new EcgBleManager(paramContext, wrapCallback(this, paramBluetoothDeviceControllerCallback));
    connectedTriangleDevice = null;
    context = paramContext;
    discoveredDevices = new HashMap();
    mainHandler = new Handler(Looper.getMainLooper());
  }
  
  private EcgBleManagerCallback wrapCallback(final BluetoothDeviceController paramBluetoothDeviceController, final BluetoothDeviceControllerCallback paramBluetoothDeviceControllerCallback)
  {
    new EcgBleManagerCallback()
    {
      public void onBatteryLevelReceived(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt)
      {
        paramAnonymousBluetoothDevice = paramBluetoothDeviceController.getTriangleDevice(paramAnonymousBluetoothDevice.getAddress());
        if (paramAnonymousBluetoothDevice != null) {
          paramAnonymousBluetoothDevice.bluetoothBatteryLevelUpdated(paramAnonymousInt);
        }
      }
      
      public void onDeviceConnected(BluetoothDevice paramAnonymousBluetoothDevice)
      {
        Log.v("BluetoothDeviceController", "onDeviceConnected");
      }
      
      public void onDeviceConnecting(BluetoothDevice paramAnonymousBluetoothDevice)
      {
        Log.v("BluetoothDeviceController", "onDeviceConnecting");
      }
      
      public void onDeviceDisconnected(BluetoothDevice paramAnonymousBluetoothDevice)
      {
        paramAnonymousBluetoothDevice = paramBluetoothDeviceController.getTriangleDevice(paramAnonymousBluetoothDevice.getAddress());
        if (paramAnonymousBluetoothDevice != null)
        {
          BluetoothDeviceController.access$202(paramBluetoothDeviceController, null);
          mainHandler.post(new FileBrowser.11(paramBluetoothDeviceControllerCallback, paramAnonymousBluetoothDevice));
          return;
        }
        Log.e("BluetoothDeviceController", "onDeviceDisconnected called with device not discovered in last scan.");
      }
      
      public void onDeviceDiscovered(BluetoothDevice paramAnonymousBluetoothDevice)
      {
        Log.v("BluetoothDeviceController", "onDeviceDiscovered");
        TriangleDevice localTriangleDevice = new TriangleDevice(paramAnonymousBluetoothDevice, paramBluetoothDeviceController);
        paramBluetoothDeviceControllerdiscoveredDevices.put(paramAnonymousBluetoothDevice.getAddress(), localTriangleDevice);
        mainHandler.post(new InitiationListener.1(paramBluetoothDeviceControllerCallback, localTriangleDevice));
      }
      
      public void onDeviceProperties(BluetoothDevice paramAnonymousBluetoothDevice, BluetoothDeviceProperties paramAnonymousBluetoothDeviceProperties)
      {
        paramAnonymousBluetoothDevice = paramBluetoothDeviceController.getTriangleDevice(paramAnonymousBluetoothDevice.getAddress());
        if (paramAnonymousBluetoothDevice != null) {
          paramAnonymousBluetoothDevice.bluetoothDevicePropertiesUpdated(paramAnonymousBluetoothDeviceProperties);
        }
      }
      
      public void onDeviceReadyToStream(BluetoothDevice paramAnonymousBluetoothDevice)
      {
        paramAnonymousBluetoothDevice = paramBluetoothDeviceController.getTriangleDevice(paramAnonymousBluetoothDevice.getAddress());
        if (paramAnonymousBluetoothDevice != null)
        {
          BluetoothDeviceController.access$202(paramBluetoothDeviceController, paramAnonymousBluetoothDevice);
          mainHandler.post(new b(paramBluetoothDeviceControllerCallback, paramAnonymousBluetoothDevice));
          return;
        }
        Log.e("BluetoothDeviceController", "onDeviceReadyToStream called with device not discovered in last scan.");
      }
      
      public void onDeviceScanning()
      {
        Log.v("BluetoothDeviceController", "onDeviceScanning");
      }
      
      public void onDeviceScanningStopped()
      {
        Log.v("BluetoothDeviceController", "onDeviceScanningStopped");
        paramBluetoothDeviceControllerCallback.didStopScanning();
      }
      
      public void onDeviceStreaming(BluetoothDevice paramAnonymousBluetoothDevice)
      {
        Log.v("BluetoothDeviceController", "onDeviceStreaming");
      }
      
      public void onEcgPacketReceived(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        paramAnonymousBluetoothDevice = paramBluetoothDeviceController.getTriangleDevice(paramAnonymousBluetoothDevice.getAddress());
        if (paramAnonymousBluetoothDevice != null) {
          paramAnonymousBluetoothDevice.bluetoothECGDataReceived(paramAnonymousArrayOfByte);
        }
      }
      
      public void onError(BluetoothDevice paramAnonymousBluetoothDevice, String paramAnonymousString, int paramAnonymousInt)
      {
        Log.d("BluetoothDeviceController", String.format("Bluetooth error: %d/%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString }));
        paramAnonymousBluetoothDevice = BluetoothDeviceConnectionError.fromGattError(paramAnonymousInt);
        mainHandler.post(new StreamingDrmSessionManager.2(paramBluetoothDeviceControllerCallback, paramAnonymousBluetoothDevice, paramAnonymousString));
      }
    };
  }
  
  public void connectTriangleDevice(TriangleDevice paramTriangleDevice)
  {
    ecgBleManager.connectDevice(paramTriangleDevice.bluetoothDevice());
  }
  
  public void disconnectTriangleDevice(TriangleDevice paramTriangleDevice)
  {
    ecgBleManager.stop();
  }
  
  public void enableCapture(BluetoothECGMode paramBluetoothECGMode)
  {
    if (connectedTriangleDevice == null)
    {
      Log.e("BluetoothDeviceController", "enableCapture called with no currently connected device.");
      return;
    }
    int i = 2.$SwitchMap$com$alivecor$universal_monitor$bluetooth$BluetoothECGMode[paramBluetoothECGMode.ordinal()];
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4) {
          paramBluetoothECGMode = TriangleMode.SINGLE_LEAD_300HZ;
        } else {
          paramBluetoothECGMode = TriangleMode.DUAL_LEAD_600HZ;
        }
      }
      else {
        paramBluetoothECGMode = TriangleMode.SINGLE_LEAD_600HZ;
      }
    }
    else {
      paramBluetoothECGMode = TriangleMode.DUAL_LEAD_300HZ;
    }
    ecgBleManager.enableCapture(paramBluetoothECGMode);
    connectedTriangleDevice.bluetoothControllerCaptureEnabled();
  }
  
  public TriangleDevice getTriangleDevice(String paramString)
  {
    return (TriangleDevice)discoveredDevices.get(paramString);
  }
  
  public void startCapture()
  {
    if (connectedTriangleDevice == null)
    {
      Log.e("BluetoothDeviceController", "enableCapture called with no currently connected device.");
      return;
    }
    ecgBleManager.startCapture();
  }
  
  public void startScanning()
  {
    discoveredDevices.clear();
    if (!BleUtil.isBleSupported(context))
    {
      callback.bluetoothConnectionError(BluetoothDeviceConnectionError.UNSUPPORTED, "Bluetooth is not supported on this device");
      return;
    }
    if (!BleUtil.isBluetoothEnabled(context))
    {
      callback.bluetoothConnectionError(BluetoothDeviceConnectionError.BLUETOOTH_OFF, "Bluetooth is turned off");
      return;
    }
    ecgBleManager.start();
  }
  
  public void stopScanning()
  {
    ecgBleManager.stop();
    TriangleDevice localTriangleDevice = connectedTriangleDevice;
    if (localTriangleDevice == null)
    {
      disconnectTriangleDevice(localTriangleDevice);
      connectedTriangleDevice = null;
    }
  }
}
