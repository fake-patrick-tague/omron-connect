package com.google.android.gms.common.package_12.internal;

abstract class zabg
{
  private final zabf _connection;
  
  protected zabg(zabf paramZabf)
  {
    _connection = paramZabf;
  }
  
  /* Error */
  public final void complete(zabi paramZabi)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 24	com/google/android/gms/common/package_12/internal/zabi:access$getLock	(Lcom/google/android/gms/common/package_12/internal/zabi;)Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 29 1 0
    //   9: aload_1
    //   10: invokestatic 33	com/google/android/gms/common/package_12/internal/zabi:access$getThis$0	(Lcom/google/android/gms/common/package_12/internal/zabi;)Lcom/google/android/gms/common/package_12/internal/zabf;
    //   13: astore_2
    //   14: aload_0
    //   15: getfield 13	com/google/android/gms/common/package_12/internal/zabg:_connection	Lcom/google/android/gms/common/package_12/internal/zabf;
    //   18: astore_3
    //   19: aload_2
    //   20: aload_3
    //   21: if_acmpeq +15 -> 36
    //   24: aload_1
    //   25: invokestatic 24	com/google/android/gms/common/package_12/internal/zabi:access$getLock	(Lcom/google/android/gms/common/package_12/internal/zabi;)Ljava/util/concurrent/locks/Lock;
    //   28: astore_1
    //   29: aload_1
    //   30: invokeinterface 36 1 0
    //   35: return
    //   36: aload_0
    //   37: invokevirtual 39	com/google/android/gms/common/package_12/internal/zabg:drain	()V
    //   40: aload_1
    //   41: invokestatic 24	com/google/android/gms/common/package_12/internal/zabi:access$getLock	(Lcom/google/android/gms/common/package_12/internal/zabi;)Ljava/util/concurrent/locks/Lock;
    //   44: astore_1
    //   45: goto -16 -> 29
    //   48: astore_2
    //   49: aload_1
    //   50: invokestatic 24	com/google/android/gms/common/package_12/internal/zabi:access$getLock	(Lcom/google/android/gms/common/package_12/internal/zabi;)Ljava/util/concurrent/locks/Lock;
    //   53: invokeinterface 36 1 0
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	zabg
    //   0	60	1	paramZabi	zabi
    //   13	7	2	localZabf1	zabf
    //   48	11	2	localThrowable	Throwable
    //   18	3	3	localZabf2	zabf
    // Exception table:
    //   from	to	target	type
    //   9	19	48	java/lang/Throwable
    //   36	40	48	java/lang/Throwable
  }
  
  protected abstract void drain();
}
