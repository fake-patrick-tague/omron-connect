package androidx.recyclerview.widget;

import java.util.concurrent.Executor;

public final class Trip<T>
{
  private final Executor colorArray;
  private final Executor constructor;
  private final h.f<T> mCallback;
  
  Trip(Executor paramExecutor1, Executor paramExecutor2, SortedList.Callback paramCallback)
  {
    constructor = paramExecutor1;
    colorArray = paramExecutor2;
    mCallback = paramCallback;
  }
  
  public SortedList.Callback equals()
  {
    return mCallback;
  }
  
  public Executor getColorArray()
  {
    return colorArray;
  }
  
  public Executor getConstructor()
  {
    return constructor;
  }
}
