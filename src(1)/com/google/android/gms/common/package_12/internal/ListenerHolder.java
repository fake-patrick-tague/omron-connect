package com.google.android.gms.common.package_12.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

@KeepForSdk
public final class ListenerHolder<L>
{
  private final Executor callbackExecutor;
  private volatile L delegate;
  private volatile com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey<L> fileName;
  
  ListenerHolder(Looper paramLooper, Object paramObject, String paramString)
  {
    callbackExecutor = new HandlerExecutor(paramLooper);
    delegate = Preconditions.checkNotNull(paramObject, "Listener must not be null");
    fileName = new ListenerKey(paramObject, Preconditions.checkNotEmpty(paramString));
  }
  
  ListenerHolder(Executor paramExecutor, Object paramObject, String paramString)
  {
    callbackExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor, "Executor must not be null"));
    delegate = Preconditions.checkNotNull(paramObject, "Listener must not be null");
    fileName = new ListenerKey(paramObject, Preconditions.checkNotEmpty(paramString));
  }
  
  public void clear()
  {
    delegate = null;
    fileName = null;
  }
  
  public ListenerKey getListenerKey()
  {
    return fileName;
  }
  
  public boolean hasListener()
  {
    return delegate != null;
  }
  
  final void hideKeyboard(Notifier paramNotifier)
  {
    Object localObject = delegate;
    if (localObject == null)
    {
      paramNotifier.onNotifyListenerFailed();
      return;
    }
    try
    {
      paramNotifier.notifyListener(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramNotifier.onNotifyListenerFailed();
      throw localRuntimeException;
    }
  }
  
  public void notifyListener(Notifier paramNotifier)
  {
    Preconditions.checkNotNull(paramNotifier, "Notifier must not be null");
    callbackExecutor.execute(new zacb(this, paramNotifier));
  }
  
  @KeepForSdk
  public final class ListenerKey<L>
  {
    private final String methodName;
    
    ListenerKey(String paramString)
    {
      methodName = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof ListenerKey)) {
        return false;
      }
      paramObject = (ListenerKey)paramObject;
      return (ListenerHolder.this == target) && (methodName.equals(methodName));
    }
    
    public int hashCode()
    {
      return System.identityHashCode(ListenerHolder.this) * 31 + methodName.hashCode();
    }
    
    public String toIdString()
    {
      String str = methodName;
      int i = System.identityHashCode(ListenerHolder.this);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 12);
      localStringBuilder.append(str);
      localStringBuilder.append("@");
      localStringBuilder.append(i);
      return localStringBuilder.toString();
    }
  }
  
  @KeepForSdk
  public abstract interface Notifier<L>
  {
    public abstract void notifyListener(Object paramObject);
    
    public abstract void onNotifyListenerFailed();
  }
}
