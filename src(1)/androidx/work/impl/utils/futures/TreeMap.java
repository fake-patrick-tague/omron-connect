package androidx.work.impl.utils.futures;

abstract class TreeMap
{
  private TreeMap() {}
  
  abstract boolean get(AbstractFuture paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2);
  
  abstract boolean get(AbstractFuture paramAbstractFuture, Label paramLabel1, Label paramLabel2);
  
  abstract boolean get(AbstractFuture paramAbstractFuture, Object paramObject1, Object paramObject2);
  
  abstract void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2);
  
  abstract void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread);
}
