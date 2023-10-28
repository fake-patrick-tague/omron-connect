package androidx.work.impl.utils.futures;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

final class ClassWriter
  extends TreeMap
{
  final AtomicReferenceFieldUpdater<a, Object> factory;
  final AtomicReferenceFieldUpdater<a, a.i> pool;
  final AtomicReferenceFieldUpdater<a, a.e> table;
  final AtomicReferenceFieldUpdater<a.i, a.i> waiterNextUpdater;
  final AtomicReferenceFieldUpdater<a.i, Thread> waiterThreadUpdater;
  
  ClassWriter(AtomicReferenceFieldUpdater paramAtomicReferenceFieldUpdater1, AtomicReferenceFieldUpdater paramAtomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater paramAtomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater paramAtomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater paramAtomicReferenceFieldUpdater5)
  {
    super(null);
    waiterThreadUpdater = paramAtomicReferenceFieldUpdater1;
    waiterNextUpdater = paramAtomicReferenceFieldUpdater2;
    pool = paramAtomicReferenceFieldUpdater3;
    table = paramAtomicReferenceFieldUpdater4;
    factory = paramAtomicReferenceFieldUpdater5;
  }
  
  boolean get(AbstractFuture paramAbstractFuture, AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
  {
    return pool.compareAndSet(paramAbstractFuture, paramWaiter1, paramWaiter2);
  }
  
  boolean get(AbstractFuture paramAbstractFuture, Label paramLabel1, Label paramLabel2)
  {
    return table.compareAndSet(paramAbstractFuture, paramLabel1, paramLabel2);
  }
  
  boolean get(AbstractFuture paramAbstractFuture, Object paramObject1, Object paramObject2)
  {
    return factory.compareAndSet(paramAbstractFuture, paramObject1, paramObject2);
  }
  
  void putNext(AbstractFuture.Waiter paramWaiter1, AbstractFuture.Waiter paramWaiter2)
  {
    waiterNextUpdater.lazySet(paramWaiter1, paramWaiter2);
  }
  
  void putThread(AbstractFuture.Waiter paramWaiter, Thread paramThread)
  {
    waiterThreadUpdater.lazySet(paramWaiter, paramThread);
  }
}
