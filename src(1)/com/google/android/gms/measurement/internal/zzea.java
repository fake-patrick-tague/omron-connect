package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzea
{
  private static final Object next = new Object();
  private volatile Object columnKey;
  private final Object current;
  private final zzdx length;
  private final String position;
  private final Object this$0;
  private final Object v;
  private volatile Object value;
  
  /* Error */
  public final Object get(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/google/android/gms/measurement/internal/zzea:this$0	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_3
    //   8: monitorexit
    //   9: aload_1
    //   10: ifnull +5 -> 15
    //   13: aload_1
    //   14: areturn
    //   15: getstatic 52	com/google/android/gms/measurement/internal/zzdy:this$0	Lcom/google/android/gms/measurement/internal/zzab;
    //   18: ifnonnull +8 -> 26
    //   21: aload_0
    //   22: getfield 35	com/google/android/gms/measurement/internal/zzea:current	Ljava/lang/Object;
    //   25: areturn
    //   26: getstatic 23	com/google/android/gms/measurement/internal/zzea:next	Ljava/lang/Object;
    //   29: astore_3
    //   30: aload_3
    //   31: monitorenter
    //   32: invokestatic 58	com/google/android/gms/measurement/internal/zzab:remove	()Z
    //   35: ifeq +27 -> 62
    //   38: aload_0
    //   39: getfield 31	com/google/android/gms/measurement/internal/zzea:value	Ljava/lang/Object;
    //   42: ifnonnull +11 -> 53
    //   45: aload_0
    //   46: getfield 35	com/google/android/gms/measurement/internal/zzea:current	Ljava/lang/Object;
    //   49: astore_1
    //   50: goto +8 -> 58
    //   53: aload_0
    //   54: getfield 31	com/google/android/gms/measurement/internal/zzea:value	Ljava/lang/Object;
    //   57: astore_1
    //   58: aload_3
    //   59: monitorexit
    //   60: aload_1
    //   61: areturn
    //   62: aload_3
    //   63: monitorexit
    //   64: invokestatic 64	com/google/android/gms/measurement/internal/zzeb:getTransportProtocols	()Ljava/util/List;
    //   67: invokeinterface 70 1 0
    //   72: astore 4
    //   74: aload 4
    //   76: invokeinterface 75 1 0
    //   81: istore_2
    //   82: iload_2
    //   83: ifeq +83 -> 166
    //   86: aload 4
    //   88: invokeinterface 78 1 0
    //   93: astore_1
    //   94: aload_1
    //   95: checkcast 2	com/google/android/gms/measurement/internal/zzea
    //   98: astore 5
    //   100: invokestatic 58	com/google/android/gms/measurement/internal/zzab:remove	()Z
    //   103: istore_2
    //   104: iload_2
    //   105: ifne +49 -> 154
    //   108: aconst_null
    //   109: astore_3
    //   110: aload 5
    //   112: getfield 39	com/google/android/gms/measurement/internal/zzea:length	Lcom/google/android/gms/measurement/internal/zzdx;
    //   115: astore 6
    //   117: aload_3
    //   118: astore_1
    //   119: aload 6
    //   121: ifnull +11 -> 132
    //   124: aload 6
    //   126: invokeinterface 83 1 0
    //   131: astore_1
    //   132: getstatic 23	com/google/android/gms/measurement/internal/zzea:next	Ljava/lang/Object;
    //   135: astore_3
    //   136: aload_3
    //   137: monitorenter
    //   138: aload 5
    //   140: aload_1
    //   141: putfield 31	com/google/android/gms/measurement/internal/zzea:value	Ljava/lang/Object;
    //   144: aload_3
    //   145: monitorexit
    //   146: goto -72 -> 74
    //   149: astore_1
    //   150: aload_3
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    //   154: new 47	java/lang/IllegalStateException
    //   157: dup
    //   158: ldc 85
    //   160: invokespecial 88	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   163: astore_1
    //   164: aload_1
    //   165: athrow
    //   166: aload_0
    //   167: getfield 39	com/google/android/gms/measurement/internal/zzea:length	Lcom/google/android/gms/measurement/internal/zzdx;
    //   170: astore_1
    //   171: aload_1
    //   172: ifnonnull +8 -> 180
    //   175: aload_0
    //   176: getfield 35	com/google/android/gms/measurement/internal/zzea:current	Ljava/lang/Object;
    //   179: areturn
    //   180: aload_1
    //   181: invokeinterface 83 1 0
    //   186: astore_1
    //   187: aload_1
    //   188: areturn
    //   189: aload_0
    //   190: getfield 35	com/google/android/gms/measurement/internal/zzea:current	Ljava/lang/Object;
    //   193: areturn
    //   194: aload_0
    //   195: getfield 35	com/google/android/gms/measurement/internal/zzea:current	Ljava/lang/Object;
    //   198: areturn
    //   199: astore_1
    //   200: aload_3
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    //   204: astore_1
    //   205: aload_3
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    //   209: astore_1
    //   210: goto -44 -> 166
    //   213: astore_1
    //   214: aload_3
    //   215: astore_1
    //   216: goto -84 -> 132
    //   219: astore_1
    //   220: goto -54 -> 166
    //   223: astore_1
    //   224: goto -58 -> 166
    //   227: astore_1
    //   228: goto -34 -> 194
    //   231: astore_1
    //   232: goto -43 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	zzea
    //   0	235	1	paramObject	Object
    //   81	24	2	bool	boolean
    //   4	211	3	localObject	Object
    //   72	15	4	localIterator	java.util.Iterator
    //   98	41	5	localZzea	zzea
    //   115	10	6	localZzdx	zzdx
    // Exception table:
    //   from	to	target	type
    //   138	146	149	java/lang/Throwable
    //   150	152	149	java/lang/Throwable
    //   32	50	199	java/lang/Throwable
    //   53	58	199	java/lang/Throwable
    //   58	60	199	java/lang/Throwable
    //   62	64	199	java/lang/Throwable
    //   200	202	199	java/lang/Throwable
    //   7	9	204	java/lang/Throwable
    //   205	207	204	java/lang/Throwable
    //   64	74	209	java/lang/SecurityException
    //   74	82	209	java/lang/SecurityException
    //   86	94	209	java/lang/SecurityException
    //   100	104	209	java/lang/SecurityException
    //   124	132	213	java/lang/IllegalStateException
    //   124	132	219	java/lang/SecurityException
    //   152	154	223	java/lang/SecurityException
    //   154	164	223	java/lang/SecurityException
    //   180	187	227	java/lang/SecurityException
    //   180	187	231	java/lang/IllegalStateException
  }
  
  public final String position()
  {
    return position;
  }
}
