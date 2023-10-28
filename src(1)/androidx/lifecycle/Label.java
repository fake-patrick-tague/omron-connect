package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class Label
{
  private final Map<String, Object> mBagOfTags = new HashMap();
  private volatile boolean mCleared;
  private final Set<Closeable> mCloseables;
  
  public Label()
  {
    mCloseables = new LinkedHashSet();
    mCleared = false;
  }
  
  public Label(Closeable... paramVarArgs)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    mCloseables = localLinkedHashSet;
    mCleared = false;
    localLinkedHashSet.addAll(Arrays.asList(paramVarArgs));
  }
  
  private static void closeWithRuntimeException(Object paramObject)
  {
    if ((paramObject instanceof Closeable))
    {
      paramObject = (Closeable)paramObject;
      try
      {
        paramObject.close();
        return;
      }
      catch (IOException paramObject)
      {
        throw new RuntimeException(paramObject);
      }
    }
  }
  
  public void addCloseable(Closeable paramCloseable)
  {
    Set localSet = mCloseables;
    if (localSet != null) {
      try
      {
        mCloseables.add(paramCloseable);
        return;
      }
      catch (Throwable paramCloseable)
      {
        throw paramCloseable;
      }
    }
  }
  
  final void clear()
  {
    mCleared = true;
    Object localObject = mBagOfTags;
    if (localObject != null) {
      try
      {
        Iterator localIterator1 = mBagOfTags.values().iterator();
        while (localIterator1.hasNext()) {
          closeWithRuntimeException(localIterator1.next());
        }
      }
      catch (Throwable localThrowable1)
      {
        throw localThrowable1;
      }
    }
    localObject = mCloseables;
    if (localObject != null) {
      try
      {
        Iterator localIterator2 = mCloseables.iterator();
        while (localIterator2.hasNext()) {
          closeWithRuntimeException((Closeable)localIterator2.next());
        }
      }
      catch (Throwable localThrowable2)
      {
        throw localThrowable2;
      }
    }
    onCleared();
  }
  
  Object getTag(String paramString)
  {
    Map localMap = mBagOfTags;
    if (localMap == null) {
      return null;
    }
    try
    {
      paramString = mBagOfTags.get(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  protected void onCleared() {}
  
  Object setTagIfAbsent(String paramString, Object paramObject)
  {
    Map localMap = mBagOfTags;
    try
    {
      Object localObject = mBagOfTags.get(paramString);
      if (localObject == null) {
        mBagOfTags.put(paramString, paramObject);
      }
      if (localObject == null) {
        paramString = paramObject;
      } else {
        paramString = localObject;
      }
      if (mCleared)
      {
        closeWithRuntimeException(paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
    return paramString;
  }
}
