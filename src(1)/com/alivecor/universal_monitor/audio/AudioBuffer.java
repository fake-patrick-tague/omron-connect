package com.alivecor.universal_monitor.audio;

import c.h.p.g;
import v7.v7.util.Pools.SynchronizedPool;

public class AudioBuffer
{
  private static final String PAGE_KEY = "AudioBuffer";
  private static final g<AudioBuffer> pool_ = new Pools.SynchronizedPool(128);
  public int length;
  public float[] samples = new float['?'];
  
  public AudioBuffer() {}
  
  public static AudioBuffer obtain()
  {
    AudioBuffer localAudioBuffer = (AudioBuffer)pool_.acquire();
    if (localAudioBuffer != null) {
      return localAudioBuffer;
    }
    return new AudioBuffer();
  }
  
  public void recycle()
  {
    pool_.release(this);
  }
}
