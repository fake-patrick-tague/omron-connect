package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import v7.util.ArrayMap;

public final class zzhe
  implements zzhj
{
  public static final String[] header = { "key", "value" };
  private static final Map sections = new ArrayMap();
  private final ContentObserver TAG;
  private final ContentResolver adapter;
  private volatile Map data;
  private final List items;
  private final Object size;
  private final Runnable timestamp;
  private final Uri url;
  
  private zzhe(ContentResolver paramContentResolver, Uri paramUri, Runnable paramRunnable)
  {
    zzhd localZzhd = new zzhd(this, null);
    TAG = localZzhd;
    size = new Object();
    items = new ArrayList();
    Objects.requireNonNull(paramContentResolver);
    Objects.requireNonNull(paramUri);
    adapter = paramContentResolver;
    url = paramUri;
    timestamp = paramRunnable;
    paramContentResolver.registerContentObserver(paramUri, false, localZzhd);
  }
  
  /* Error */
  public static zzhe get(ContentResolver paramContentResolver, Uri paramUri, Runnable paramRunnable)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 32	com/google/android/gms/internal/measurement/zzhe:sections	Ljava/util/Map;
    //   6: astore 5
    //   8: aload 5
    //   10: aload_1
    //   11: invokeinterface 85 2 0
    //   16: checkcast 2	com/google/android/gms/internal/measurement/zzhe
    //   19: astore 4
    //   21: aload 4
    //   23: astore_3
    //   24: aload 4
    //   26: ifnonnull +24 -> 50
    //   29: new 2	com/google/android/gms/internal/measurement/zzhe
    //   32: dup
    //   33: aload_0
    //   34: aload_1
    //   35: aload_2
    //   36: invokespecial 87	com/google/android/gms/internal/measurement/zzhe:<init>	(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/Runnable;)V
    //   39: astore_3
    //   40: aload 5
    //   42: aload_1
    //   43: aload_3
    //   44: invokeinterface 91 3 0
    //   49: pop
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_3
    //   54: areturn
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    //   61: astore_0
    //   62: aload 4
    //   64: astore_3
    //   65: goto -15 -> 50
    //   68: astore_0
    //   69: goto -19 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramContentResolver	ContentResolver
    //   0	72	1	paramUri	Uri
    //   0	72	2	paramRunnable	Runnable
    //   23	42	3	localZzhe1	zzhe
    //   19	44	4	localZzhe2	zzhe
    //   6	35	5	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   3	21	55	java/lang/Throwable
    //   29	40	55	java/lang/Throwable
    //   40	50	55	java/lang/Throwable
    //   50	53	55	java/lang/Throwable
    //   56	59	55	java/lang/Throwable
    //   29	40	61	java/lang/SecurityException
    //   40	50	68	java/lang/SecurityException
  }
  
  static void onDestroy()
  {
    try
    {
      Iterator localIterator = sections.values().iterator();
      while (localIterator.hasNext())
      {
        zzhe localZzhe = (zzhe)localIterator.next();
        adapter.unregisterContentObserver(TAG);
      }
      sections.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Map parse()
  {
    Object localObject3 = data;
    Object localObject1 = localObject3;
    Object localObject4;
    if (localObject3 == null) {
      localObject4 = size;
    }
    for (;;)
    {
      try
      {
        localObject3 = data;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject3 = StrictMode.allowThreadDiskReads();
        }
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        throw localThrowable2;
      }
      try
      {
        try
        {
          localObject1 = zzhh.size(new zzhc(this));
          localObject1 = (Map)localObject1;
          StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)localObject3);
        }
        catch (Throwable localThrowable1) {}
      }
      catch (SecurityException localSecurityException) {}catch (SQLiteException localSQLiteException) {}catch (IllegalStateException localIllegalStateException) {}
    }
    Log.e("ConfigurationContentLdr", "PhenotypeFlag unable to load ContentProvider, using default values");
    StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)localObject3);
    localObject2 = null;
    data = localObject2;
    break label89;
    StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)localObject3);
    throw localObject2;
    label89:
    if (localThrowable2 != null) {
      return localThrowable2;
    }
    return Collections.emptyMap();
  }
  
  /* Error */
  public final void save()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/google/android/gms/internal/measurement/zzhe:size	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 140	com/google/android/gms/internal/measurement/zzhe:data	Ljava/util/Map;
    //   12: aload_0
    //   13: getfield 69	com/google/android/gms/internal/measurement/zzhe:timestamp	Ljava/lang/Runnable;
    //   16: invokeinterface 181 1 0
    //   21: aload_1
    //   22: monitorexit
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 57	com/google/android/gms/internal/measurement/zzhe:items	Ljava/util/List;
    //   29: invokeinterface 184 1 0
    //   34: astore_1
    //   35: aload_1
    //   36: invokeinterface 108 1 0
    //   41: ifeq +20 -> 61
    //   44: aload_1
    //   45: invokeinterface 112 1 0
    //   50: checkcast 186	com/google/android/gms/internal/measurement/zzhf
    //   53: invokeinterface 189 1 0
    //   58: goto -23 -> 35
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    //   69: astore_2
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	zzhe
    //   4	41	1	localObject	Object
    //   64	7	1	localThrowable1	Throwable
    //   69	4	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   25	35	64	java/lang/Throwable
    //   35	58	64	java/lang/Throwable
    //   61	63	64	java/lang/Throwable
    //   65	67	64	java/lang/Throwable
    //   7	23	69	java/lang/Throwable
    //   70	72	69	java/lang/Throwable
  }
}
