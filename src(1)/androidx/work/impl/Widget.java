package androidx.work.impl;

import com.google.common.util.concurrent.c;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class Widget
  implements Runnable
{
  private String b;
  private Object c;
  private c<Boolean> d;
  
  Widget(Object paramObject, String paramString, com.google.common.util.concurrent.Object paramObject1)
  {
    c = paramObject;
    b = paramString;
    d = paramObject1;
  }
  
  public void run()
  {
    java.lang.Object localObject = d;
    try
    {
      localObject = ((Future)localObject).get();
      localObject = (Boolean)localObject;
      bool = ((Boolean)localObject).booleanValue();
    }
    catch (InterruptedException localInterruptedException)
    {
      boolean bool;
      for (;;) {}
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;) {}
    }
    bool = true;
    c.a(b, bool);
  }
}
