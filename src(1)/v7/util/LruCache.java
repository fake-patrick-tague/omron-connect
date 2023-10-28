package v7.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class LruCache<K, V>
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  private final LinkedHashMap<K, V> map;
  private int maxSize;
  private int missCount;
  private int putCount;
  private int size;
  
  public LruCache(int paramInt)
  {
    if (paramInt > 0)
    {
      maxSize = paramInt;
      map = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private int safeSizeOf(Object paramObject1, Object paramObject2)
  {
    int i = sizeOf(paramObject1, paramObject2);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Negative size: ");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append("=");
    localStringBuilder.append(paramObject2);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  protected Object create(Object paramObject)
  {
    return null;
  }
  
  public final int createCount()
  {
    try
    {
      int i = createCount;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  protected void entryRemoved(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final int evictionCount()
  {
    try
    {
      int i = evictionCount;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  /* Error */
  public final Object get(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 83
    //   3: invokestatic 89	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 31	v7/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   13: aload_1
    //   14: invokevirtual 91	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +17 -> 36
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 93	v7/util/LruCache:hitCount	I
    //   27: iconst_1
    //   28: iadd
    //   29: putfield 93	v7/util/LruCache:hitCount	I
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 95	v7/util/LruCache:missCount	I
    //   41: iconst_1
    //   42: iadd
    //   43: putfield 95	v7/util/LruCache:missCount	I
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 97	v7/util/LruCache:create	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: astore_2
    //   54: aload_2
    //   55: ifnonnull +5 -> 60
    //   58: aconst_null
    //   59: areturn
    //   60: aload_0
    //   61: monitorenter
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 72	v7/util/LruCache:createCount	I
    //   67: iconst_1
    //   68: iadd
    //   69: putfield 72	v7/util/LruCache:createCount	I
    //   72: aload_0
    //   73: getfield 31	v7/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   76: aload_1
    //   77: aload_2
    //   78: invokevirtual 101	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull +16 -> 99
    //   86: aload_0
    //   87: getfield 31	v7/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   90: aload_1
    //   91: aload_3
    //   92: invokevirtual 101	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: goto +18 -> 114
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 103	v7/util/LruCache:size	I
    //   104: aload_0
    //   105: aload_1
    //   106: aload_2
    //   107: invokespecial 105	v7/util/LruCache:safeSizeOf	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   110: iadd
    //   111: putfield 103	v7/util/LruCache:size	I
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_3
    //   117: ifnull +13 -> 130
    //   120: aload_0
    //   121: iconst_0
    //   122: aload_1
    //   123: aload_2
    //   124: aload_3
    //   125: invokevirtual 107	v7/util/LruCache:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   128: aload_3
    //   129: areturn
    //   130: aload_0
    //   131: aload_0
    //   132: getfield 23	v7/util/LruCache:maxSize	I
    //   135: invokevirtual 78	v7/util/LruCache:trimToSize	(I)V
    //   138: aload_2
    //   139: areturn
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	LruCache
    //   0	150	1	paramObject	Object
    //   17	122	2	localObject1	Object
    //   81	48	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   62	82	140	java/lang/Throwable
    //   86	96	140	java/lang/Throwable
    //   99	114	140	java/lang/Throwable
    //   114	116	140	java/lang/Throwable
    //   141	143	140	java/lang/Throwable
    //   9	18	145	java/lang/Throwable
    //   22	34	145	java/lang/Throwable
    //   36	48	145	java/lang/Throwable
    //   146	148	145	java/lang/Throwable
  }
  
  public final int hitCount()
  {
    try
    {
      int i = hitCount;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final int maxSize()
  {
    try
    {
      int i = maxSize;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final int missCount()
  {
    try
    {
      int i = missCount;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Object put(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null)) {
      try
      {
        putCount += 1;
        size += safeSizeOf(paramObject1, paramObject2);
        Object localObject = map.put(paramObject1, paramObject2);
        if (localObject != null) {
          size -= safeSizeOf(paramObject1, localObject);
        }
        if (localObject != null) {
          entryRemoved(false, paramObject1, localObject, paramObject2);
        }
        trimToSize(maxSize);
        return localObject;
      }
      catch (Throwable paramObject1)
      {
        throw paramObject1;
      }
    }
    throw new NullPointerException("key == null || value == null");
  }
  
  public final int putCount()
  {
    try
    {
      int i = putCount;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Object remove(Object paramObject)
  {
    Objects.requireNonNull(paramObject, "key == null");
    Object localObject;
    try
    {
      localObject = map.remove(paramObject);
      if (localObject != null) {
        size -= safeSizeOf(paramObject, localObject);
      }
      if (localObject != null)
      {
        entryRemoved(false, paramObject, localObject, null);
        return localObject;
      }
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
    return localObject;
  }
  
  public void resize(int paramInt)
  {
    if (paramInt > 0) {
      try
      {
        maxSize = paramInt;
        trimToSize(paramInt);
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  public final int size()
  {
    try
    {
      int i = size;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  protected int sizeOf(Object paramObject1, Object paramObject2)
  {
    return 1;
  }
  
  public final Map snapshot()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(map);
      return localLinkedHashMap;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final String toString()
  {
    for (;;)
    {
      try
      {
        i = hitCount;
        int j = missCount + i;
        if (j != 0)
        {
          i = i * 100 / j;
          String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(maxSize), Integer.valueOf(hitCount), Integer.valueOf(missCount), Integer.valueOf(i) });
          return str;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      int i = 0;
    }
  }
  
  public void trimToSize(int paramInt)
  {
    Object localObject2 = this;
    for (;;)
    {
      Object localObject1 = localObject2;
      try
      {
        int i = size;
        Object localObject3 = localObject2;
        if (i >= 0)
        {
          localObject1 = localObject3;
          if (map.isEmpty())
          {
            localObject1 = localObject3;
            if (size != 0) {}
          }
          else
          {
            localObject1 = localObject2;
            i = size;
            if (i > paramInt)
            {
              localObject1 = localObject2;
              if (!map.isEmpty())
              {
                localObject1 = localObject2;
                localObject3 = (Map.Entry)map.entrySet().iterator().next();
                localObject1 = localObject2;
                Object localObject4 = ((Map.Entry)localObject3).getKey();
                localObject1 = localObject2;
                Object localObject5 = ((Map.Entry)localObject3).getValue();
                localObject1 = localObject2;
                map.remove(localObject4);
                localObject1 = localObject2;
                i = size;
                localObject3 = localObject2;
                localObject1 = localObject3;
                size = (i - ((LruCache)localObject2).safeSizeOf(localObject4, localObject5));
                localObject1 = localObject3;
                i = evictionCount;
                localObject2 = localObject3;
                localObject1 = localObject2;
                evictionCount = (i + 1);
                localObject1 = localObject2;
                ((LruCache)localObject2).entryRemoved(true, localObject4, localObject5, null);
                continue;
              }
            }
            localObject1 = localObject2;
            return;
          }
        }
        localObject1 = localObject2;
        localObject3 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(localObject2.getClass().getName());
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(".sizeOf() is reporting inconsistent results!");
        localObject1 = localObject2;
        throw new IllegalStateException(((StringBuilder)localObject3).toString());
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
}
