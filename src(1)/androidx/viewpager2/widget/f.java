package androidx.viewpager2.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

final class f
  extends ViewPager2.i
{
  private final List<ViewPager2.i> q;
  
  f(int paramInt)
  {
    q = new ArrayList(paramInt);
  }
  
  private void close(ConcurrentModificationException paramConcurrentModificationException)
  {
    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", paramConcurrentModificationException);
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = q;
    try
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject1).hasNext();
        if (!bool) {
          break;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        localObject2 = (ViewPager2.i)localObject2;
        ((ViewPager2.i)localObject2).a(paramInt);
      }
      return;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      close(localConcurrentModificationException);
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject1 = q;
    try
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject1).hasNext();
        if (!bool) {
          break;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        localObject2 = (ViewPager2.i)localObject2;
        ((ViewPager2.i)localObject2).a(paramInt1, paramFloat, paramInt2);
      }
      return;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      close(localConcurrentModificationException);
    }
  }
  
  void a(ViewPager2.i paramI)
  {
    q.add(paramI);
  }
  
  public void b(int paramInt)
  {
    Object localObject1 = q;
    try
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject1).hasNext();
        if (!bool) {
          break;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        localObject2 = (ViewPager2.i)localObject2;
        ((ViewPager2.i)localObject2).b(paramInt);
      }
      return;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      close(localConcurrentModificationException);
    }
  }
  
  void b(ViewPager2.i paramI)
  {
    q.remove(paramI);
  }
}
