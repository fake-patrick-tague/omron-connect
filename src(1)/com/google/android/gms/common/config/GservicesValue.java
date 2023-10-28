package com.google.android.gms.common.config;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class GservicesValue<T>
{
  private static final Object data = new Object();
  private Object attributes = null;
  protected final Object subscriber;
  protected final String value;
  
  protected GservicesValue(String paramString, Object paramObject)
  {
    value = paramString;
    subscriber = paramObject;
  }
  
  public static boolean isInitialized()
  {
    Object localObject = data;
    try
    {
      return false;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static GservicesValue value(String paramString, Float paramFloat)
  {
    return new PdfContentStreamProcessor.ModifyCurrentTransformationMatrix(paramString, paramFloat);
  }
  
  public static GservicesValue value(String paramString, Integer paramInteger)
  {
    return new PdfContentStreamProcessor.Do(paramString, paramInteger);
  }
  
  public static GservicesValue value(String paramString, Long paramLong)
  {
    return new NonLinearConjugateGradientOptimizer(paramString, paramLong);
  }
  
  public static GservicesValue value(String paramString1, String paramString2)
  {
    return new PdfContentStreamProcessor.SetTextHorizontalScaling(paramString1, paramString2);
  }
  
  public static GservicesValue value(String paramString, boolean paramBoolean)
  {
    return new PdfContentStreamProcessor.PopGraphicsState(paramString, Boolean.valueOf(paramBoolean));
  }
  
  /* Error */
  public final Object get()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/google/android/gms/common/config/GservicesValue:attributes	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +5 -> 11
    //   9: aload_3
    //   10: areturn
    //   11: invokestatic 77	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   14: astore_3
    //   15: getstatic 19	com/google/android/gms/common/config/GservicesValue:data	Ljava/lang/Object;
    //   18: astore 4
    //   20: aload 4
    //   22: monitorenter
    //   23: aload 4
    //   25: monitorexit
    //   26: aload 4
    //   28: monitorenter
    //   29: aload 4
    //   31: monitorexit
    //   32: aload_0
    //   33: getfield 25	com/google/android/gms/common/config/GservicesValue:value	Ljava/lang/String;
    //   36: astore 4
    //   38: aload_0
    //   39: aload 4
    //   41: invokevirtual 81	com/google/android/gms/common/config/GservicesValue:invoke	(Ljava/lang/String;)Ljava/lang/Object;
    //   44: astore 4
    //   46: aload_3
    //   47: invokestatic 85	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   50: aload 4
    //   52: areturn
    //   53: astore 4
    //   55: goto +37 -> 92
    //   58: invokestatic 91	android/os/Binder:clearCallingIdentity	()J
    //   61: lstore_1
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 25	com/google/android/gms/common/config/GservicesValue:value	Ljava/lang/String;
    //   67: invokevirtual 81	com/google/android/gms/common/config/GservicesValue:invoke	(Ljava/lang/String;)Ljava/lang/Object;
    //   70: astore 4
    //   72: lload_1
    //   73: invokestatic 95	android/os/Binder:restoreCallingIdentity	(J)V
    //   76: aload_3
    //   77: invokestatic 85	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   80: aload 4
    //   82: areturn
    //   83: astore 4
    //   85: lload_1
    //   86: invokestatic 95	android/os/Binder:restoreCallingIdentity	(J)V
    //   89: aload 4
    //   91: athrow
    //   92: aload_3
    //   93: invokestatic 85	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   96: aload 4
    //   98: athrow
    //   99: astore_3
    //   100: aload 4
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    //   105: astore_3
    //   106: aload 4
    //   108: monitorexit
    //   109: aload_3
    //   110: athrow
    //   111: astore 4
    //   113: goto -55 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	GservicesValue
    //   61	25	1	l	long
    //   4	89	3	localObject1	Object
    //   99	5	3	localThrowable1	Throwable
    //   105	5	3	localThrowable2	Throwable
    //   18	33	4	localObject2	Object
    //   53	1	4	localThrowable3	Throwable
    //   70	11	4	localObject3	Object
    //   83	24	4	localThrowable4	Throwable
    //   111	1	4	localSecurityException	SecurityException
    // Exception table:
    //   from	to	target	type
    //   38	46	53	java/lang/Throwable
    //   58	62	53	java/lang/Throwable
    //   72	76	53	java/lang/Throwable
    //   85	92	53	java/lang/Throwable
    //   62	72	83	java/lang/Throwable
    //   29	32	99	java/lang/Throwable
    //   100	103	99	java/lang/Throwable
    //   23	26	105	java/lang/Throwable
    //   106	109	105	java/lang/Throwable
    //   38	46	111	java/lang/SecurityException
  }
  
  public final Object getBinderSafe()
  {
    return get();
  }
  
  protected abstract Object invoke(String paramString);
  
  /* Error */
  public void override(Object paramObject)
  {
    // Byte code:
    //   0: ldc 102
    //   2: ldc 104
    //   4: invokestatic 110	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: aload_0
    //   9: aload_1
    //   10: putfield 23	com/google/android/gms/common/config/GservicesValue:attributes	Ljava/lang/Object;
    //   13: getstatic 19	com/google/android/gms/common/config/GservicesValue:data	Ljava/lang/Object;
    //   16: astore_1
    //   17: aload_1
    //   18: monitorenter
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_1
    //   22: monitorexit
    //   23: aload_1
    //   24: monitorexit
    //   25: return
    //   26: astore_2
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    //   31: astore_2
    //   32: aload_1
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	GservicesValue
    //   0	36	1	paramObject	Object
    //   26	4	2	localThrowable1	Throwable
    //   31	4	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   21	23	26	java/lang/Throwable
    //   27	29	26	java/lang/Throwable
    //   19	21	31	java/lang/Throwable
    //   23	25	31	java/lang/Throwable
    //   29	31	31	java/lang/Throwable
    //   32	34	31	java/lang/Throwable
  }
  
  public void resetOverride()
  {
    attributes = null;
  }
}
