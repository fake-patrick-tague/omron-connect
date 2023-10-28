package androidx.work.impl.utils;

import androidx.work.impl.f;
import androidx.work.impl.utils.futures.Context;
import androidx.work.impl.utils.futures.b;

public abstract class a<T>
  implements Runnable
{
  private final b<T> j = Context.getInstance();
  
  public a() {}
  
  public static a a(f paramF, String paramString)
  {
    return new d(paramF, paramString);
  }
  
  public com.google.common.util.concurrent.Object b()
  {
    return j;
  }
  
  abstract Object c();
  
  public void run()
  {
    try
    {
      Object localObject = c();
      j.get(localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      j.get(localThrowable);
    }
  }
}
