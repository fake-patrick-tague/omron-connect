package com.google.android.gms.internal.measurement;

import android.os.BaseBundle;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbz
  extends zzce
{
  private boolean element;
  private final AtomicReference this$0 = new AtomicReference();
  
  public zzbz() {}
  
  public static final Object get(Bundle paramBundle, Class paramClass)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.get("r");
      if (paramBundle != null) {
        try
        {
          Object localObject = paramClass.cast(paramBundle);
          return localObject;
        }
        catch (ClassCastException localClassCastException)
        {
          Log.w("AM", String.format("Unexpected object type. Expected, Received: %s, %s", new Object[] { paramClass.getCanonicalName(), paramBundle.getClass().getCanonicalName() }), localClassCastException);
          throw localClassCastException;
        }
      }
    }
    return null;
  }
  
  public final String a(long paramLong)
  {
    return (String)get(get(paramLong), String.class);
  }
  
  /* Error */
  public final void append(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/google/android/gms/internal/measurement/zzbz:this$0	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 17	com/google/android/gms/internal/measurement/zzbz:this$0	Ljava/util/concurrent/atomic/AtomicReference;
    //   11: aload_1
    //   12: invokevirtual 76	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 78	com/google/android/gms/internal/measurement/zzbz:element	Z
    //   20: aload_0
    //   21: getfield 17	com/google/android/gms/internal/measurement/zzbz:this$0	Ljava/util/concurrent/atomic/AtomicReference;
    //   24: invokevirtual 81	java/lang/Object:notify	()V
    //   27: aload_2
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 17	com/google/android/gms/internal/measurement/zzbz:this$0	Ljava/util/concurrent/atomic/AtomicReference;
    //   35: invokevirtual 81	java/lang/Object:notify	()V
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload_2
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	zzbz
    //   0	45	1	paramBundle	Bundle
    //   4	38	2	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   7	20	30	java/lang/Throwable
    //   20	29	40	java/lang/Throwable
    //   31	40	40	java/lang/Throwable
    //   41	43	40	java/lang/Throwable
  }
  
  public final Bundle get(long paramLong)
  {
    localAtomicReference = this$0;
    for (;;)
    {
      try
      {
        boolean bool = element;
        if (!bool) {
          localObject = this$0;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        throw localThrowable;
      }
      try
      {
        localObject.wait(paramLong);
      }
      catch (InterruptedException localInterruptedException) {}
    }
    return null;
    localObject = (Bundle)this$0.get();
    return localObject;
  }
}
