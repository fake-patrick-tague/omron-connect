package com.android.volley;

public abstract class AsyncCache
{
  public AsyncCache() {}
  
  public abstract void clear(OnWriteCompleteCallback paramOnWriteCompleteCallback);
  
  public abstract void initialize(OnWriteCompleteCallback paramOnWriteCompleteCallback);
  
  public abstract void invalidate(String paramString, boolean paramBoolean, OnWriteCompleteCallback paramOnWriteCompleteCallback);
  
  public abstract void loop(String paramString, OnGetCompleteCallback paramOnGetCompleteCallback);
  
  public abstract void put(String paramString, Cache.Entry paramEntry, OnWriteCompleteCallback paramOnWriteCompleteCallback);
  
  public abstract void remove(String paramString, OnWriteCompleteCallback paramOnWriteCompleteCallback);
  
  public static abstract interface OnGetCompleteCallback
  {
    public abstract void onGetComplete(Cache.Entry paramEntry);
  }
  
  public static abstract interface OnWriteCompleteCallback
  {
    public abstract void onWriteComplete();
  }
}
