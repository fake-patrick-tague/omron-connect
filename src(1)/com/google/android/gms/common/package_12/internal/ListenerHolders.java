package com.google.android.gms.common.package_12.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

@KeepForSdk
public class ListenerHolders
{
  private final Set<com.google.android.gms.common.api.internal.ListenerHolder<?>> requests = Collections.newSetFromMap(new WeakHashMap());
  
  public ListenerHolders() {}
  
  public static ListenerHolder createListenerHolder(Object paramObject, Looper paramLooper, String paramString)
  {
    Preconditions.checkNotNull(paramObject, "Listener must not be null");
    Preconditions.checkNotNull(paramLooper, "Looper must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    return new ListenerHolder(paramLooper, paramObject, paramString);
  }
  
  public static ListenerHolder createListenerHolder(Object paramObject, Executor paramExecutor, String paramString)
  {
    Preconditions.checkNotNull(paramObject, "Listener must not be null");
    Preconditions.checkNotNull(paramExecutor, "Executor must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    return new ListenerHolder(paramExecutor, paramObject, paramString);
  }
  
  public static ListenerHolder.ListenerKey createListenerKey(Object paramObject, String paramString)
  {
    Preconditions.checkNotNull(paramObject, "Listener must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    Preconditions.checkNotEmpty(paramString, "Listener type must not be empty");
    return new ListenerHolder.ListenerKey(paramObject, paramString);
  }
  
  public final ListenerHolder add(Object paramObject, Looper paramLooper, String paramString)
  {
    paramObject = createListenerHolder(paramObject, paramLooper, "NO_TYPE");
    requests.add(paramObject);
    return paramObject;
  }
  
  public final void clear()
  {
    Iterator localIterator = requests.iterator();
    while (localIterator.hasNext()) {
      ((ListenerHolder)localIterator.next()).clear();
    }
    requests.clear();
  }
}
