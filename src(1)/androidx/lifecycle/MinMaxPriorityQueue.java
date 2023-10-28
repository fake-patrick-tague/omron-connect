package androidx.lifecycle;

import android.os.Handler;

public class MinMaxPriorityQueue
{
  private final Handler maximumSize;
  private final f queue;
  private d0.a size;
  
  public MinMaxPriorityQueue(d paramD)
  {
    queue = new f(paramD);
    maximumSize = new Handler();
  }
  
  private void offer(Lifecycle.Event paramEvent)
  {
    d0.a localA = size;
    if (localA != null) {
      localA.run();
    }
    paramEvent = new d0.a(queue, paramEvent);
    size = paramEvent;
    maximumSize.postAtFrontOfQueue(paramEvent);
  }
  
  public void add()
  {
    offer(Lifecycle.Event.ON_CREATE);
  }
  
  public void create()
  {
    offer(Lifecycle.Event.ON_START);
  }
  
  public Lifecycle elementData()
  {
    return queue;
  }
  
  public void offer()
  {
    offer(Lifecycle.Event.ON_START);
  }
  
  public void setResult()
  {
    offer(Lifecycle.Event.ON_STOP);
    offer(Lifecycle.Event.ON_DESTROY);
  }
}
