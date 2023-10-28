package androidx.work.impl.utils.asm;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.HttpConnection;
import java.util.concurrent.Executor;

public class ClassWriter
  implements f
{
  private final Handler a = new Handler(Looper.getMainLooper());
  private final Executor c = new ExecutorDelivery.1(this);
  private final HttpConnection g;
  
  public ClassWriter(Executor paramExecutor)
  {
    g = new HttpConnection(paramExecutor);
  }
  
  public HttpConnection a()
  {
    return g;
  }
  
  public void a(Runnable paramRunnable)
  {
    a.post(paramRunnable);
  }
  
  public Executor get()
  {
    return c;
  }
  
  public void get(Runnable paramRunnable)
  {
    g.execute(paramRunnable);
  }
}
