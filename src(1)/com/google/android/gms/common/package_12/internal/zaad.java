package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class zaad
{
  private final Map<com.google.android.gms.common.api.internal.BasePendingResult<?>, Boolean> data = Collections.synchronizedMap(new WeakHashMap());
  private final Map<TaskCompletionSource<?>, Boolean> listeners = Collections.synchronizedMap(new WeakHashMap());
  
  public zaad() {}
  
  /* Error */
  private final void add(boolean paramBoolean, Status paramStatus)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/google/android/gms/common/package_12/internal/zaad:data	Ljava/util/Map;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: new 36	java/util/HashMap
    //   10: dup
    //   11: aload_0
    //   12: getfield 24	com/google/android/gms/common/package_12/internal/zaad:data	Ljava/util/Map;
    //   15: invokespecial 39	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   18: astore 4
    //   20: aload_3
    //   21: monitorexit
    //   22: aload_0
    //   23: getfield 26	com/google/android/gms/common/package_12/internal/zaad:listeners	Ljava/util/Map;
    //   26: astore 5
    //   28: aload 5
    //   30: monitorenter
    //   31: new 36	java/util/HashMap
    //   34: dup
    //   35: aload_0
    //   36: getfield 26	com/google/android/gms/common/package_12/internal/zaad:listeners	Ljava/util/Map;
    //   39: invokespecial 39	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   42: astore_3
    //   43: aload 5
    //   45: monitorexit
    //   46: aload 4
    //   48: invokeinterface 45 1 0
    //   53: invokeinterface 51 1 0
    //   58: astore 4
    //   60: aload 4
    //   62: invokeinterface 57 1 0
    //   67: ifeq +52 -> 119
    //   70: aload 4
    //   72: invokeinterface 61 1 0
    //   77: checkcast 63	java/util/Map$Entry
    //   80: astore 5
    //   82: iload_1
    //   83: ifne +19 -> 102
    //   86: aload 5
    //   88: invokeinterface 66 1 0
    //   93: checkcast 68	java/lang/Boolean
    //   96: invokevirtual 71	java/lang/Boolean:booleanValue	()Z
    //   99: ifeq -39 -> 60
    //   102: aload 5
    //   104: invokeinterface 74 1 0
    //   109: checkcast 76	com/google/android/gms/common/package_12/internal/BasePendingResult
    //   112: aload_2
    //   113: invokevirtual 80	com/google/android/gms/common/package_12/internal/BasePendingResult:forceFailureUnlessReady	(Lcom/google/android/gms/common/package_12/Status;)V
    //   116: goto -56 -> 60
    //   119: aload_3
    //   120: invokeinterface 45 1 0
    //   125: invokeinterface 51 1 0
    //   130: astore_3
    //   131: aload_3
    //   132: invokeinterface 57 1 0
    //   137: ifeq +59 -> 196
    //   140: aload_3
    //   141: invokeinterface 61 1 0
    //   146: checkcast 63	java/util/Map$Entry
    //   149: astore 4
    //   151: iload_1
    //   152: ifne +19 -> 171
    //   155: aload 4
    //   157: invokeinterface 66 1 0
    //   162: checkcast 68	java/lang/Boolean
    //   165: invokevirtual 71	java/lang/Boolean:booleanValue	()Z
    //   168: ifeq -37 -> 131
    //   171: aload 4
    //   173: invokeinterface 74 1 0
    //   178: checkcast 82	com/google/android/gms/tasks/TaskCompletionSource
    //   181: new 84	com/google/android/gms/common/package_12/ApiException
    //   184: dup
    //   185: aload_2
    //   186: invokespecial 86	com/google/android/gms/common/package_12/ApiException:<init>	(Lcom/google/android/gms/common/package_12/Status;)V
    //   189: invokevirtual 90	com/google/android/gms/tasks/TaskCompletionSource:trySetException	(Ljava/lang/Exception;)Z
    //   192: pop
    //   193: goto -62 -> 131
    //   196: return
    //   197: astore_2
    //   198: aload 5
    //   200: monitorexit
    //   201: aload_2
    //   202: athrow
    //   203: astore_2
    //   204: aload_3
    //   205: monitorexit
    //   206: aload_2
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	zaad
    //   0	208	1	paramBoolean	boolean
    //   0	208	2	paramStatus	Status
    //   4	201	3	localObject1	Object
    //   18	154	4	localObject2	Object
    //   26	173	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   31	46	197	java/lang/Throwable
    //   198	201	197	java/lang/Throwable
    //   7	22	203	java/lang/Throwable
    //   204	206	203	java/lang/Throwable
  }
  
  final void add(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("The connection to Google Play services was lost");
    if (paramInt == 1) {
      localStringBuilder.append(" due to service disconnection.");
    } else if (paramInt == 3) {
      localStringBuilder.append(" due to dead object exception.");
    }
    if (paramString != null)
    {
      localStringBuilder.append(" Last reason for disconnect: ");
      localStringBuilder.append(paramString);
    }
    add(true, new Status(20, localStringBuilder.toString()));
  }
  
  final void addAll(BasePendingResult paramBasePendingResult, boolean paramBoolean)
  {
    data.put(paramBasePendingResult, Boolean.valueOf(paramBoolean));
    paramBasePendingResult.addStatusListener(new zaab(this, paramBasePendingResult));
  }
  
  public final void i()
  {
    add(false, GoogleApiManager.tag);
  }
  
  final boolean set()
  {
    return (!data.isEmpty()) || (!listeners.isEmpty());
  }
  
  final void setPriority(TaskCompletionSource paramTaskCompletionSource, boolean paramBoolean)
  {
    listeners.put(paramTaskCompletionSource, Boolean.valueOf(paramBoolean));
    paramTaskCompletionSource.getTask().addOnCompleteListener(new zaac(this, paramTaskCompletionSource));
  }
}
