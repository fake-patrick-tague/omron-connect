package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzhp
  implements Runnable
{
  zzhp(zzid paramZzid, AtomicReference paramAtomicReference) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/google/android/gms/measurement/internal/zzhp:this$0	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 16	com/google/android/gms/measurement/internal/zzhp:this$0	Ljava/util/concurrent/atomic/AtomicReference;
    //   11: aload_0
    //   12: getfield 14	com/google/android/gms/measurement/internal/zzhp:val$mPath	Lcom/google/android/gms/measurement/internal/zzid;
    //   15: getfield 28	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   18: invokevirtual 34	com/google/android/gms/measurement/internal/zzfy:append	()Lcom/google/android/gms/measurement/internal/zzag;
    //   21: aload_0
    //   22: getfield 14	com/google/android/gms/measurement/internal/zzhp:val$mPath	Lcom/google/android/gms/measurement/internal/zzid;
    //   25: getfield 28	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   28: invokevirtual 38	com/google/android/gms/measurement/internal/zzfy:getInstance	()Lcom/google/android/gms/measurement/internal/zzef;
    //   31: invokevirtual 44	com/google/android/gms/measurement/internal/zzef:read	()Ljava/lang/String;
    //   34: getstatic 50	com/google/android/gms/measurement/internal/zzeb:album	Lcom/google/android/gms/measurement/internal/zzea;
    //   37: invokevirtual 56	com/google/android/gms/measurement/internal/zzag:get	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzea;)Z
    //   40: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   43: invokevirtual 68	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   46: aload_0
    //   47: getfield 16	com/google/android/gms/measurement/internal/zzhp:this$0	Ljava/util/concurrent/atomic/AtomicReference;
    //   50: invokevirtual 71	java/lang/Object:notify	()V
    //   53: aload_1
    //   54: monitorexit
    //   55: return
    //   56: astore_2
    //   57: aload_0
    //   58: getfield 16	com/google/android/gms/measurement/internal/zzhp:this$0	Ljava/util/concurrent/atomic/AtomicReference;
    //   61: invokevirtual 71	java/lang/Object:notify	()V
    //   64: aload_2
    //   65: athrow
    //   66: astore_2
    //   67: aload_1
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	zzhp
    //   4	64	1	localAtomicReference	AtomicReference
    //   56	9	2	localThrowable1	Throwable
    //   66	4	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	46	56	java/lang/Throwable
    //   46	55	66	java/lang/Throwable
    //   57	66	66	java/lang/Throwable
    //   67	69	66	java/lang/Throwable
  }
}
