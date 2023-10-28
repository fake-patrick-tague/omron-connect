package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.package_12.Attribute;
import java.lang.ref.WeakReference;

final class zaal
  implements BaseGmsClient.ConnectionProgressReportCallbacks
{
  private final WeakReference<com.google.android.gms.common.api.internal.zaaw> context;
  private final boolean darkTheme;
  private final Api<?> pm;
  
  public zaal(zaaw paramZaaw, Attribute paramAttribute, boolean paramBoolean)
  {
    context = new WeakReference(paramZaaw);
    pm = paramAttribute;
    darkTheme = paramBoolean;
  }
  
  /* Error */
  public final void onReportServiceBinding(com.google.android.gms.common.ConnectionResult paramConnectionResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/google/android/gms/common/package_12/internal/zaal:context	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 41	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 43	com/google/android/gms/common/package_12/internal/zaaw
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: invokestatic 49	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   19: aload_3
    //   20: invokestatic 53	com/google/android/gms/common/package_12/internal/zaaw:append	(Lcom/google/android/gms/common/package_12/internal/zaaw;)Lcom/google/android/gms/common/package_12/internal/zabi;
    //   23: getfield 58	com/google/android/gms/common/package_12/internal/zabi:context	Lcom/google/android/gms/common/package_12/internal/zabe;
    //   26: invokevirtual 63	com/google/android/gms/common/package_12/GoogleApiClient:getLooper	()Landroid/os/Looper;
    //   29: if_acmpne +8 -> 37
    //   32: iconst_1
    //   33: istore_2
    //   34: goto +5 -> 39
    //   37: iconst_0
    //   38: istore_2
    //   39: iload_2
    //   40: ldc 65
    //   42: invokestatic 71	com/google/android/gms/common/internal/Preconditions:checkState	(ZLjava/lang/Object;)V
    //   45: aload_3
    //   46: invokestatic 75	com/google/android/gms/common/package_12/internal/zaaw:access$getLock	(Lcom/google/android/gms/common/package_12/internal/zaaw;)Ljava/util/concurrent/locks/Lock;
    //   49: invokeinterface 80 1 0
    //   54: aload_3
    //   55: iconst_0
    //   56: invokestatic 84	com/google/android/gms/common/package_12/internal/zaaw:a	(Lcom/google/android/gms/common/package_12/internal/zaaw;I)Z
    //   59: istore_2
    //   60: iload_2
    //   61: ifne +15 -> 76
    //   64: aload_3
    //   65: invokestatic 75	com/google/android/gms/common/package_12/internal/zaaw:access$getLock	(Lcom/google/android/gms/common/package_12/internal/zaaw;)Ljava/util/concurrent/locks/Lock;
    //   68: astore_1
    //   69: aload_1
    //   70: invokeinterface 87 1 0
    //   75: return
    //   76: aload_1
    //   77: invokevirtual 93	com/google/android/gms/common/ConnectionResult:isSuccess	()Z
    //   80: istore_2
    //   81: iload_2
    //   82: ifne +16 -> 98
    //   85: aload_3
    //   86: aload_1
    //   87: aload_0
    //   88: getfield 28	com/google/android/gms/common/package_12/internal/zaal:pm	Lcom/google/android/gms/common/package_12/Attribute;
    //   91: aload_0
    //   92: getfield 30	com/google/android/gms/common/package_12/internal/zaal:darkTheme	Z
    //   95: invokestatic 97	com/google/android/gms/common/package_12/internal/zaaw:setColor	(Lcom/google/android/gms/common/package_12/internal/zaaw;Lcom/google/android/gms/common/ConnectionResult;Lcom/google/android/gms/common/package_12/Attribute;Z)V
    //   98: aload_3
    //   99: invokestatic 101	com/google/android/gms/common/package_12/internal/zaaw:renderBitmap	(Lcom/google/android/gms/common/package_12/internal/zaaw;)Z
    //   102: istore_2
    //   103: iload_2
    //   104: ifeq +7 -> 111
    //   107: aload_3
    //   108: invokestatic 105	com/google/android/gms/common/package_12/internal/zaaw:access$getLog	(Lcom/google/android/gms/common/package_12/internal/zaaw;)V
    //   111: aload_3
    //   112: invokestatic 75	com/google/android/gms/common/package_12/internal/zaaw:access$getLock	(Lcom/google/android/gms/common/package_12/internal/zaaw;)Ljava/util/concurrent/locks/Lock;
    //   115: astore_1
    //   116: goto -47 -> 69
    //   119: astore_1
    //   120: aload_3
    //   121: invokestatic 75	com/google/android/gms/common/package_12/internal/zaaw:access$getLock	(Lcom/google/android/gms/common/package_12/internal/zaaw;)Ljava/util/concurrent/locks/Lock;
    //   124: invokeinterface 87 1 0
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	zaal
    //   0	131	1	paramConnectionResult	com.google.android.gms.common.ConnectionResult
    //   33	71	2	bool	boolean
    //   10	111	3	localZaaw	zaaw
    // Exception table:
    //   from	to	target	type
    //   54	60	119	java/lang/Throwable
    //   76	81	119	java/lang/Throwable
    //   85	98	119	java/lang/Throwable
    //   98	103	119	java/lang/Throwable
    //   107	111	119	java/lang/Throwable
  }
}
