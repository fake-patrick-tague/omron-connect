package androidx.work.impl.utils.asm;

import androidx.work.impl.utils.HttpConnection;
import java.util.concurrent.Executor;

public abstract interface f
{
  public abstract HttpConnection a();
  
  public abstract Executor get();
  
  public abstract void get(Runnable paramRunnable);
}
