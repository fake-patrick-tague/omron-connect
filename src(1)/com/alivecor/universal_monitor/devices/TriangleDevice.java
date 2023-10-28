package com.alivecor.universal_monitor.devices;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alivecor.universal_monitor.audio.AudioBuffer;
import com.alivecor.universal_monitor.audio.AudioInput;
import com.alivecor.universal_monitor.audio.AudioInputCallback;
import com.alivecor.universal_monitor.bluetooth.BluetoothDeviceController;
import com.alivecor.universal_monitor.bluetooth.BluetoothDeviceProperties;
import com.alivecor.universal_monitor.bluetooth.BluetoothECGMode;

public class TriangleDevice
  extends Device
{
  private static final int DEFAULT_AUDIO_SAMPLERATE_HZ = 44100;
  public static final String PAGE_KEY = "TriangleDevice";
  private AudioInputCallback audioCallback = new AudioInputCallback()
  {
    public void receivedAudioSamples(AudioBuffer paramAnonymousAudioBuffer)
    {
      processCallbackHandler.post(new FileBrowser.10(this, paramAnonymousAudioBuffer));
    }
  };
  private AudioInput audioInput;
  private BluetoothDeviceController bluetoothController;
  private BluetoothDevice bluetoothDevice;
  private TriangleDeviceCallback callback;
  private boolean capturing;
  private final Handler mainHandler;
  private final Handler processCallbackHandler;
  private final HandlerThread processThread;
  private boolean recordAudio;
  
  public TriangleDevice(BluetoothDevice paramBluetoothDevice, BluetoothDeviceController paramBluetoothDeviceController)
  {
    recorderHardware = "triangle";
    capturing = false;
    audioInput = null;
    recordAudio = false;
    bluetoothController = paramBluetoothDeviceController;
    bluetoothDevice = paramBluetoothDevice;
    callback = null;
    paramBluetoothDevice = new StringBuilder();
    paramBluetoothDevice.append(toString());
    paramBluetoothDevice.append("::processThread");
    paramBluetoothDevice = new HandlerThread(paramBluetoothDevice.toString());
    processThread = paramBluetoothDevice;
    paramBluetoothDevice.start();
    processCallbackHandler = new Handler(paramBluetoothDevice.getLooper());
    mainHandler = new Handler(Looper.getMainLooper());
    init();
  }
  
  private native void configureDevice(int paramInt1, int paramInt2);
  
  private native void deviceDisconnected();
  
  private native void init();
  
  private native void processAudioSamples(float[] paramArrayOfFloat, int paramInt);
  
  private native void receiveData(byte[] paramArrayOfByte);
  
  private native void updateRSSI(float paramFloat);
  
  public void bluetoothBatteryLevelUpdated(int paramInt)
  {
    mainHandler.post(new FileBrowser.11(this, paramInt));
  }
  
  public void bluetoothControllerCaptureEnabled()
  {
    mainHandler.post(new InitiationListener.1(this));
  }
  
  public BluetoothDevice bluetoothDevice()
  {
    return bluetoothDevice;
  }
  
  public void bluetoothDevicePropertiesUpdated(BluetoothDeviceProperties paramBluetoothDeviceProperties)
  {
    recorderHardware = paramBluetoothDeviceProperties.recorderHardware();
    deviceData = paramBluetoothDeviceProperties.deviceData();
    mainHandler.post(new Slider(this, paramBluetoothDeviceProperties));
  }
  
  public void bluetoothECGDataReceived(byte[] paramArrayOfByte)
  {
    processCallbackHandler.post(new Action(this, paramArrayOfByte));
  }
  
  public void dispose()
  {
    stopCapturing();
    processCallbackHandler.removeCallbacksAndMessages(null);
    processThread.quit();
    super.dispose();
  }
  
  public void enableCapture(BluetoothECGMode paramBluetoothECGMode, boolean paramBoolean, TriangleDeviceCallback paramTriangleDeviceCallback)
  {
    callback = paramTriangleDeviceCallback;
    recordAudio = paramBoolean;
    bluetoothController.enableCapture(paramBluetoothECGMode);
    int i;
    int j;
    if (paramBoolean)
    {
      paramTriangleDeviceCallback = new AudioInput(audioCallback);
      audioInput = paramTriangleDeviceCallback;
      i = mode;
      j = paramTriangleDeviceCallback.getSampleRate();
    }
    else
    {
      i = mode;
      j = 44100;
    }
    configureDevice(i, j);
  }
  
  public void startCapturing()
  {
    if (recordAudio) {
      audioInput.start();
    }
    bluetoothController.startCapture();
    capturing = true;
  }
  
  public void stopCapturing()
  {
    if (recordAudio) {
      audioInput.stop();
    }
    bluetoothController.disconnectTriangleDevice(this);
    capturing = false;
  }
}
