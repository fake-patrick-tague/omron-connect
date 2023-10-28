package com.alivecor.mapsforge.record;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.StatusPreference;
import androidx.lifecycle.s;
import com.alivecor.universal_monitor.bluetooth.BluetoothDeviceController;
import com.alivecor.universal_monitor.bluetooth.BluetoothDeviceControllerCallback;
import com.alivecor.universal_monitor.bluetooth.BluetoothDeviceProperties;
import com.alivecor.universal_monitor.bluetooth.BluetoothECGMode;
import com.alivecor.universal_monitor.devices.TriangleDevice;
import com.alivecor.universal_monitor.devices.TriangleDeviceCallback;
import io.reactivex.c0.b;
import io.reactivex.c0.c;
import io.reactivex.n;
import io.reactivex.q;
import io.reactivex.r;
import v7.v7.menu.RewriteCardinalityException;

public class TriangleBluetoothWrapperClass
{
  public static final int BATTERY_LEVEL_UNKNOWN = -1;
  private static TriangleBluetoothWrapperClass triangleBluetoothWrapperClass;
  Context applicationContext;
  private BluetoothDeviceController bluetoothDeviceController;
  private c<TriangleDevice> connectSubject;
  private TriangleDevice connectedTriangleDevice;
  private final s<com.alivecor.ecg.record.TriangleBluetoothWrapperClass.BLEConnectionState> connectionStateLiveData;
  private final q controlScheduler = io.reactivex.u.b.a.a();
  private s<BluetoothDeviceProperties> devicePropertiesLiveData = new StatusPreference();
  private c<TriangleDevice> enableCaptureSubject;
  private b<TriangleDevice> scanSubject;
  private s<Integer> triangleBatteryLiveData = new StatusPreference();
  
  public TriangleBluetoothWrapperClass()
  {
    StatusPreference localStatusPreference = new StatusPreference();
    connectionStateLiveData = localStatusPreference;
    RecordEkgConfig.getDB().getRecordDependencyComponent().inject(this);
    bluetoothDeviceController = createBluetoothDeviceController();
    triangleBatteryLiveData.setValue(Integer.valueOf(-1));
    localStatusPreference.setValue(BLEConnectionState.DISCONNECTED);
  }
  
  private BluetoothDeviceController createBluetoothDeviceController()
  {
    return new BluetoothDeviceController(createBluetoothDeviceControllerCallback(), applicationContext);
  }
  
  private BluetoothDeviceControllerCallback createBluetoothDeviceControllerCallback()
  {
    return new TriangleBluetoothWrapperClass.2(this);
  }
  
  private TriangleDeviceCallback createTriangleCallback()
  {
    return new TriangleBluetoothWrapperClass.1(this);
  }
  
  private void disposeTriangleDevice()
  {
    TriangleDevice localTriangleDevice = connectedTriangleDevice;
    if (localTriangleDevice != null)
    {
      localTriangleDevice.dispose();
      connectedTriangleDevice = null;
    }
  }
  
  public static TriangleBluetoothWrapperClass getInstance()
  {
    if (triangleBluetoothWrapperClass == null) {
      triangleBluetoothWrapperClass = new TriangleBluetoothWrapperClass();
    }
    return triangleBluetoothWrapperClass;
  }
  
  public r connectToDevice(TriangleDevice paramTriangleDevice)
  {
    return r.f(new StreamClientImpl.4(this, paramTriangleDevice)).v(controlScheduler).g(new InitiationListener.1(this)).v(controlScheduler);
  }
  
  public LiveData connectionState()
  {
    return connectionStateLiveData;
  }
  
  public LiveData deviceProperties()
  {
    return devicePropertiesLiveData;
  }
  
  public void disconnect()
  {
    if (connectionStateLiveData.getValue() == BLEConnectionState.DISCONNECTED) {
      l.a.a.d("disconnect(): Called while already disconnected.  Not changing state, but trying to clean up anyway", new Object[0]);
    } else {
      connectionStateLiveData.setValue(BLEConnectionState.DISCONNECTING);
    }
    bluetoothDeviceController.stopScanning();
    Object localObject = scanSubject;
    if (localObject != null)
    {
      ((b)localObject).a(new RewriteCardinalityException());
      scanSubject = null;
    }
    localObject = connectSubject;
    if (localObject != null)
    {
      ((c)localObject).a(new RewriteCardinalityException());
      connectSubject = null;
    }
    localObject = enableCaptureSubject;
    if (localObject != null)
    {
      ((c)localObject).a(new RewriteCardinalityException());
      enableCaptureSubject = null;
    }
  }
  
  public void dispose()
  {
    disconnect();
    disposeTriangleDevice();
  }
  
  public r enableCapture(TriangleDevice paramTriangleDevice, boolean paramBoolean, BluetoothECGMode paramBluetoothECGMode)
  {
    return r.f(new DatabaseHelper.1(this, paramTriangleDevice, paramBluetoothECGMode, paramBoolean)).v(controlScheduler).g(new Transaction(this)).v(controlScheduler);
  }
  
  public n scanForDevices()
  {
    return n.g(new MultiplexingDiscovery.1(this)).u(controlScheduler).i(new MethodVisitor(this)).u(controlScheduler);
  }
  
  public LiveData triangleBattery()
  {
    return triangleBatteryLiveData;
  }
  
  public enum BLEConnectionState
  {
    static
    {
      BLEConnectionState localBLEConnectionState1 = new BLEConnectionState("SCANNING", 0);
      SCANNING = localBLEConnectionState1;
      BLEConnectionState localBLEConnectionState2 = new BLEConnectionState("CONNECTING", 1);
      CONNECTING = localBLEConnectionState2;
      BLEConnectionState localBLEConnectionState3 = new BLEConnectionState("CONNECTED", 2);
      CONNECTED = localBLEConnectionState3;
      BLEConnectionState localBLEConnectionState4 = new BLEConnectionState("CAPTURE_ENABLED", 3);
      CAPTURE_ENABLED = localBLEConnectionState4;
      BLEConnectionState localBLEConnectionState5 = new BLEConnectionState("DISCONNECTING", 4);
      DISCONNECTING = localBLEConnectionState5;
      BLEConnectionState localBLEConnectionState6 = new BLEConnectionState("DISCONNECTED", 5);
      DISCONNECTED = localBLEConnectionState6;
      BLEConnectionState localBLEConnectionState7 = new BLEConnectionState("ERROR", 6);
      ERROR = localBLEConnectionState7;
      $VALUES = new BLEConnectionState[] { localBLEConnectionState1, localBLEConnectionState2, localBLEConnectionState3, localBLEConnectionState4, localBLEConnectionState5, localBLEConnectionState6, localBLEConnectionState7 };
    }
  }
}
