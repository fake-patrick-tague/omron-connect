package com.google.android.gms.common.internal;

import java.util.ArrayList;

public abstract class Connection
{
  private boolean first;
  private Object next;
  
  public Connection(BaseGmsClient paramBaseGmsClient, Object paramObject)
  {
    next = paramObject;
    first = false;
  }
  
  public final void cancel()
  {
    remove();
    ArrayList localArrayList = BaseGmsClient.access$getMTasks(key);
    try
    {
      BaseGmsClient.access$getMTasks(key).remove(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  /* Error */
  public final void clear()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/google/android/gms/common/internal/Connection:next	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield 21	com/google/android/gms/common/internal/Connection:first	Z
    //   11: ifeq +46 -> 57
    //   14: aload_0
    //   15: invokevirtual 46	java/lang/Object:toString	()Ljava/lang/String;
    //   18: astore_2
    //   19: new 48	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   26: astore_3
    //   27: aload_3
    //   28: ldc 51
    //   30: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_3
    //   35: aload_2
    //   36: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: ldc 57
    //   43: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 59
    //   49: aload_3
    //   50: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 66	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   56: pop
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: ifnull +14 -> 74
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 70	com/google/android/gms/common/internal/Connection:onCreate	(Ljava/lang/Object;)V
    //   68: goto +6 -> 74
    //   71: astore_1
    //   72: aload_1
    //   73: athrow
    //   74: aload_0
    //   75: monitorenter
    //   76: aload_0
    //   77: iconst_1
    //   78: putfield 21	com/google/android/gms/common/internal/Connection:first	Z
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_0
    //   84: invokevirtual 72	com/google/android/gms/common/internal/Connection:cancel	()V
    //   87: return
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	Connection
    //   6	59	1	localObject	Object
    //   71	2	1	localRuntimeException	RuntimeException
    //   88	4	1	localThrowable1	Throwable
    //   93	4	1	localThrowable2	Throwable
    //   18	18	2	str	String
    //   26	24	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   63	68	71	java/lang/RuntimeException
    //   76	83	88	java/lang/Throwable
    //   89	91	88	java/lang/Throwable
    //   2	57	93	java/lang/Throwable
    //   57	59	93	java/lang/Throwable
    //   94	96	93	java/lang/Throwable
  }
  
  protected abstract void log();
  
  protected abstract void onCreate(Object paramObject);
  
  public final void remove()
  {
    try
    {
      next = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
