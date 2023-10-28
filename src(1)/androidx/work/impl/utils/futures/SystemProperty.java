package androidx.work.impl.utils.futures;

final class SystemProperty
  extends TreeMap
{
  SystemProperty()
  {
    super(null);
  }
  
  boolean get(AbstractFuture paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
  {
    try
    {
      if (next == paramWaiter1)
      {
        next = paramWaiter2;
        return true;
      }
      return false;
    }
    catch (Throwable paramWaiter1)
    {
      throw paramWaiter1;
    }
  }
  
  boolean get(AbstractFuture paramAbstractFuture, Label paramLabel1, Label paramLabel2)
  {
    try
    {
      if (c == paramLabel1)
      {
        c = paramLabel2;
        return true;
      }
      return false;
    }
    catch (Throwable paramLabel1)
    {
      throw paramLabel1;
    }
  }
  
  boolean get(AbstractFuture paramAbstractFuture, Object paramObject1, Object paramObject2)
  {
    try
    {
      if (value == paramObject1)
      {
        value = paramObject2;
        return true;
      }
      return false;
    }
    catch (Throwable paramObject1)
    {
      throw paramObject1;
    }
  }
  
  void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
  {
    next = paramWaiter2;
  }
  
  void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread)
  {
    thread = paramThread;
  }
}
