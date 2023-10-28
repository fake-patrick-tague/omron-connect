package androidx.work.impl.utils.futures;

public final class Context<V>
  extends a<V>
{
  private Context() {}
  
  public static Context getInstance()
  {
    return new Context();
  }
  
  public boolean cancel(com.google.common.util.concurrent.Object paramObject)
  {
    return super.cancel(paramObject);
  }
  
  public boolean get(Object paramObject)
  {
    return super.get(paramObject);
  }
  
  public boolean get(Throwable paramThrowable)
  {
    return super.get(paramThrowable);
  }
}
