package com.google.android.datatransport.runtime.dagger.internal;

import g.a.a;

public final class ClassWriter<T>
  implements a<T>
{
  private static final Object a = new Object();
  private volatile Object c = a;
  private volatile a<T> index;
  
  private ClassWriter(a paramA)
  {
    index = paramA;
  }
  
  public static a a(a paramA)
  {
    ByteVector.get(paramA);
    if ((paramA instanceof ClassWriter)) {
      return paramA;
    }
    return new ClassWriter(paramA);
  }
  
  public static Object get(Object paramObject1, Object paramObject2)
  {
    int i;
    if (paramObject1 != a) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramObject1 == paramObject2) {
        return paramObject2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Scoped provider was invoked recursively returning different results: ");
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(" & ");
      localStringBuilder.append(paramObject2);
      localStringBuilder.append(". This is likely due to a circular dependency.");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    return paramObject2;
  }
  
  public Object get()
  {
    Object localObject1 = c;
    Object localObject3 = a;
    if (localObject1 == localObject3) {
      try
      {
        Object localObject2 = c;
        localObject1 = localObject2;
        if (localObject2 == localObject3)
        {
          localObject2 = index.get();
          localObject1 = localObject2;
          c = get(c, localObject2);
          index = null;
        }
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return localThrowable;
  }
}
