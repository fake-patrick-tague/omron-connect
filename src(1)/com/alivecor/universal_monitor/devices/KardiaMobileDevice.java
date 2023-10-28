package com.alivecor.universal_monitor.devices;

import android.os.Handler;
import android.os.HandlerThread;
import com.alivecor.universal_monitor.audio.AudioBuffer;
import com.alivecor.universal_monitor.audio.AudioInput;
import com.alivecor.universal_monitor.audio.AudioInputCallback;

public class KardiaMobileDevice
  extends Device
{
  private AudioInput audioInput;
  private AudioInputCallback callback;
  private boolean capturing;
  private Handler handler;
  private HandlerThread processThread;
  
  public KardiaMobileDevice()
  {
    Object localObject = new AudioInputCallback()
    {
      public void receivedAudioSamples(AudioBuffer paramAnonymousAudioBuffer)
      {
        handler.post(new Progress(this, paramAnonymousAudioBuffer));
      }
    };
    callback = ((AudioInputCallback)localObject);
    recorderHardware = "kardia_mobile";
    capturing = false;
    localObject = new AudioInput((AudioInputCallback)localObject);
    audioInput = ((AudioInput)localObject);
    init(((AudioInput)localObject).getSampleRate());
  }
  
  private native void init(int paramInt);
  
  private native void processAudioSamples(float[] paramArrayOfFloat, int paramInt);
  
  public void startCapturing()
  {
    try
    {
      capturing = true;
      HandlerThread localHandlerThread = new HandlerThread("KardiaMobileDevice::processThread");
      processThread = localHandlerThread;
      localHandlerThread.start();
      handler = new Handler(processThread.getLooper());
      audioInput.start();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void stopCapturing()
  {
    try
    {
      if (processThread != null)
      {
        handler.removeCallbacksAndMessages(null);
        processThread.quit();
        processThread = null;
        handler = null;
      }
      audioInput.stop();
      capturing = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
