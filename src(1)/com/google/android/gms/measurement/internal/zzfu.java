package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

final class zzfu
  extends Thread
{
  private boolean done = false;
  private final Object lock;
  private final BlockingQueue queue;
  
  public zzfu(zzfv paramZzfv, String paramString, BlockingQueue paramBlockingQueue)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramBlockingQueue);
    lock = new Object();
    queue = paramBlockingQueue;
    setName(paramString);
  }
  
  private final void calculate(InterruptedException paramInterruptedException)
  {
    this$0.this$0.zzay().hasNext().append(String.valueOf(getName()).concat(" was interrupted"), paramInterruptedException);
  }
  
  private final void done()
  {
    Object localObject = zzfv.access$getLock(this$0);
    try
    {
      if (!done)
      {
        zzfv.access$getMIsAvailable(this$0).release();
        zzfv.access$getLock(this$0).notifyAll();
        zzfv localZzfv = this$0;
        if (this == zzfv.access$getExecutor(localZzfv)) {
          zzfv.getSongs(localZzfv, null);
        } else if (this == zzfv.access$getUpdater(localZzfv)) {
          zzfv.access$400(localZzfv, null);
        } else {
          this$0.zzay().iterator().append("Current scheduler thread is neither worker nor network");
        }
        done = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: ifne +33 -> 36
    //   6: aload_0
    //   7: getfield 16	com/google/android/gms/measurement/internal/zzfu:this$0	Lcom/google/android/gms/measurement/internal/zzfv;
    //   10: astore 4
    //   12: aload 4
    //   14: invokestatic 92	com/google/android/gms/measurement/internal/zzfv:access$getMIsAvailable	(Lcom/google/android/gms/measurement/internal/zzfv;)Ljava/util/concurrent/Semaphore;
    //   17: invokevirtual 127	java/util/concurrent/Semaphore:acquire	()V
    //   20: iconst_1
    //   21: istore_1
    //   22: goto -20 -> 2
    //   25: astore 4
    //   27: aload_0
    //   28: aload 4
    //   30: invokespecial 129	com/google/android/gms/measurement/internal/zzfu:calculate	(Ljava/lang/InterruptedException;)V
    //   33: goto -31 -> 2
    //   36: invokestatic 135	android/os/Process:myTid	()I
    //   39: invokestatic 139	android/os/Process:getThreadPriority	(I)I
    //   42: istore_2
    //   43: aload_0
    //   44: getfield 34	com/google/android/gms/measurement/internal/zzfu:queue	Ljava/util/concurrent/BlockingQueue;
    //   47: invokeinterface 145 1 0
    //   52: checkcast 147	com/google/android/gms/measurement/internal/zzft
    //   55: astore 4
    //   57: aload 4
    //   59: ifnull +34 -> 93
    //   62: aload 4
    //   64: getfield 150	com/google/android/gms/measurement/internal/zzft:data	Z
    //   67: istore_3
    //   68: iconst_1
    //   69: iload_3
    //   70: if_icmpeq +9 -> 79
    //   73: bipush 10
    //   75: istore_1
    //   76: goto +5 -> 81
    //   79: iload_2
    //   80: istore_1
    //   81: iload_1
    //   82: invokestatic 154	android/os/Process:setThreadPriority	(I)V
    //   85: aload 4
    //   87: invokevirtual 158	java/util/concurrent/FutureTask:run	()V
    //   90: goto -47 -> 43
    //   93: aload_0
    //   94: getfield 32	com/google/android/gms/measurement/internal/zzfu:lock	Ljava/lang/Object;
    //   97: astore 4
    //   99: aload 4
    //   101: monitorenter
    //   102: aload_0
    //   103: getfield 34	com/google/android/gms/measurement/internal/zzfu:queue	Ljava/util/concurrent/BlockingQueue;
    //   106: invokeinterface 161 1 0
    //   111: ifnonnull +36 -> 147
    //   114: aload_0
    //   115: getfield 16	com/google/android/gms/measurement/internal/zzfu:this$0	Lcom/google/android/gms/measurement/internal/zzfv;
    //   118: invokestatic 165	com/google/android/gms/measurement/internal/zzfv:isImportant	(Lcom/google/android/gms/measurement/internal/zzfv;)Z
    //   121: pop
    //   122: aload_0
    //   123: getfield 32	com/google/android/gms/measurement/internal/zzfu:lock	Ljava/lang/Object;
    //   126: astore 5
    //   128: aload 5
    //   130: ldc2_w 166
    //   133: invokevirtual 171	java/lang/Object:wait	(J)V
    //   136: goto +11 -> 147
    //   139: astore 5
    //   141: aload_0
    //   142: aload 5
    //   144: invokespecial 129	com/google/android/gms/measurement/internal/zzfu:calculate	(Ljava/lang/InterruptedException;)V
    //   147: aload 4
    //   149: monitorexit
    //   150: aload_0
    //   151: getfield 16	com/google/android/gms/measurement/internal/zzfu:this$0	Lcom/google/android/gms/measurement/internal/zzfv;
    //   154: invokestatic 88	com/google/android/gms/measurement/internal/zzfv:access$getLock	(Lcom/google/android/gms/measurement/internal/zzfv;)Ljava/lang/Object;
    //   157: astore 4
    //   159: aload 4
    //   161: monitorenter
    //   162: aload_0
    //   163: getfield 34	com/google/android/gms/measurement/internal/zzfu:queue	Ljava/util/concurrent/BlockingQueue;
    //   166: invokeinterface 161 1 0
    //   171: ifnonnull +15 -> 186
    //   174: aload_0
    //   175: invokespecial 173	com/google/android/gms/measurement/internal/zzfu:done	()V
    //   178: aload 4
    //   180: monitorexit
    //   181: aload_0
    //   182: invokespecial 173	com/google/android/gms/measurement/internal/zzfu:done	()V
    //   185: return
    //   186: aload 4
    //   188: monitorexit
    //   189: goto -146 -> 43
    //   192: astore 5
    //   194: aload 4
    //   196: monitorexit
    //   197: aload 5
    //   199: athrow
    //   200: astore 5
    //   202: aload 4
    //   204: monitorexit
    //   205: aload 5
    //   207: athrow
    //   208: astore 4
    //   210: aload_0
    //   211: invokespecial 173	com/google/android/gms/measurement/internal/zzfu:done	()V
    //   214: aload 4
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	zzfu
    //   1	81	1	i	int
    //   42	38	2	j	int
    //   67	4	3	bool	boolean
    //   10	3	4	localZzfv	zzfv
    //   25	4	4	localInterruptedException1	InterruptedException
    //   55	148	4	localObject1	Object
    //   208	7	4	localThrowable1	Throwable
    //   126	3	5	localObject2	Object
    //   139	4	5	localInterruptedException2	InterruptedException
    //   192	6	5	localThrowable2	Throwable
    //   200	6	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   12	20	25	java/lang/InterruptedException
    //   128	136	139	java/lang/InterruptedException
    //   162	181	192	java/lang/Throwable
    //   186	189	192	java/lang/Throwable
    //   194	197	192	java/lang/Throwable
    //   102	122	200	java/lang/Throwable
    //   128	136	200	java/lang/Throwable
    //   141	147	200	java/lang/Throwable
    //   147	150	200	java/lang/Throwable
    //   202	205	200	java/lang/Throwable
    //   36	43	208	java/lang/Throwable
    //   43	57	208	java/lang/Throwable
    //   62	68	208	java/lang/Throwable
    //   81	90	208	java/lang/Throwable
    //   93	102	208	java/lang/Throwable
    //   150	162	208	java/lang/Throwable
    //   197	200	208	java/lang/Throwable
    //   205	208	208	java/lang/Throwable
  }
  
  public final void stop()
  {
    Object localObject = lock;
    try
    {
      lock.notifyAll();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
