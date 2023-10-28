package com.alivecor.universal_monitor.audio;

import android.media.AudioRecord;
import android.util.Log;

public class AudioInput
{
  private static final int AUDIO_IN_CHANNELCONFIG = 16;
  private static final int AUDIO_IN_ENCODING = 4;
  private static final String PAGE_KEY = "AudioInput";
  private AudioInputCallback callback_;
  private boolean cancel_ = false;
  private int sampleRate_ = getMaxSampleRate();
  private Thread thread_ = null;
  
  public AudioInput(AudioInputCallback paramAudioInputCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Initialized with sample rate: ");
    localStringBuilder.append(sampleRate_);
    Log.i("AudioInput", localStringBuilder.toString());
    callback_ = paramAudioInputCallback;
  }
  
  private Runnable createRecordingWorker()
  {
    return new InitiationListener.1(this);
  }
  
  private static int getBytesPerSample(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 16)
    {
      if (paramInt2 == 4) {
        return 2;
      }
      throw new AssertionError();
    }
    throw new AssertionError();
  }
  
  public static int getMaxSampleRate()
  {
    if (isAudioFormatSupported(48000, 16, 2)) {
      return 48000;
    }
    return 44100;
  }
  
  private static boolean isAudioFormatSupported(int paramInt1, int paramInt2, int paramInt3)
  {
    return AudioRecord.getMinBufferSize(paramInt1, paramInt2, paramInt3) > 0;
  }
  
  private void startWorkerThread()
  {
    cancel_ = false;
    Thread localThread = new Thread(createRecordingWorker());
    thread_ = localThread;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioInput-PcmReader");
    localStringBuilder.append(thread_.getName());
    localThread.setName(localStringBuilder.toString());
    thread_.start();
  }
  
  public int getSampleRate()
  {
    return sampleRate_;
  }
  
  public void start()
  {
    for (;;)
    {
      try
      {
        Log.d("AudioInput", "start(): called");
        Thread localThread = thread_;
        boolean bool3 = false;
        if ((localThread != null) && (localThread.isAlive()))
        {
          i = 1;
          if (localThread == null) {
            break label128;
          }
          bool1 = true;
          boolean bool2 = bool3;
          if (localThread != null)
          {
            bool2 = bool3;
            if (localThread.isAlive()) {
              bool2 = true;
            }
          }
          Log.d("AudioInput", String.format("start(): thread non-null %b isAlive %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
          if (i == 0) {
            startWorkerThread();
          }
          Log.d("AudioInput", "start(): ended");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      int i = 0;
      continue;
      label128:
      boolean bool1 = false;
    }
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 13
    //   4: ldc -39
    //   6: invokestatic 198	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield 29	com/alivecor/universal_monitor/audio/AudioInput:cancel_	Z
    //   15: aload_0
    //   16: getfield 27	com/alivecor/universal_monitor/audio/AudioInput:thread_	Ljava/lang/Thread;
    //   19: astore 5
    //   21: iconst_0
    //   22: istore 4
    //   24: aload 5
    //   26: ifnull +116 -> 142
    //   29: aload 5
    //   31: invokevirtual 202	java/lang/Thread:isAlive	()Z
    //   34: ifeq +108 -> 142
    //   37: iconst_1
    //   38: istore_1
    //   39: goto +3 -> 42
    //   42: aload 5
    //   44: ifnull +103 -> 147
    //   47: iconst_1
    //   48: istore_2
    //   49: goto +3 -> 52
    //   52: iload 4
    //   54: istore_3
    //   55: aload 5
    //   57: ifnull +16 -> 73
    //   60: iload 4
    //   62: istore_3
    //   63: aload 5
    //   65: invokevirtual 202	java/lang/Thread:isAlive	()Z
    //   68: ifeq +5 -> 73
    //   71: iconst_1
    //   72: istore_3
    //   73: ldc 13
    //   75: ldc -37
    //   77: iconst_2
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: iload_2
    //   84: invokestatic 209	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: iload_3
    //   91: invokestatic 209	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   98: invokestatic 198	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   101: pop
    //   102: iload_1
    //   103: ifeq +16 -> 119
    //   106: ldc 13
    //   108: ldc -35
    //   110: invokestatic 198	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   113: pop
    //   114: aload 5
    //   116: invokevirtual 224	java/lang/Thread:join	()V
    //   119: ldc 13
    //   121: ldc -30
    //   123: invokestatic 198	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   126: pop
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: astore 5
    //   132: aload_0
    //   133: monitorexit
    //   134: aload 5
    //   136: athrow
    //   137: astore 5
    //   139: goto -20 -> 119
    //   142: iconst_0
    //   143: istore_1
    //   144: goto -102 -> 42
    //   147: iconst_0
    //   148: istore_2
    //   149: goto -97 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	AudioInput
    //   38	106	1	i	int
    //   48	101	2	bool1	boolean
    //   54	37	3	bool2	boolean
    //   22	39	4	bool3	boolean
    //   19	96	5	localThread	Thread
    //   130	5	5	localThrowable	Throwable
    //   137	1	5	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	21	130	java/lang/Throwable
    //   29	37	130	java/lang/Throwable
    //   63	71	130	java/lang/Throwable
    //   73	102	130	java/lang/Throwable
    //   106	119	130	java/lang/Throwable
    //   119	127	130	java/lang/Throwable
    //   106	119	137	java/lang/InterruptedException
  }
}
