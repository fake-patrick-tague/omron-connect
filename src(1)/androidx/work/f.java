package androidx.work;

import android.os.Build.VERSION;
import androidx.work.impl.x;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class f
{
  final Executor a;
  final Pair c;
  final ByteVector d;
  private final boolean e;
  final Executor f;
  final String g;
  final int h;
  final int j;
  final int k;
  final Logger l;
  final p m;
  final int n;
  
  f(ClassWriter paramClassWriter)
  {
    Object localObject = e;
    if (localObject == null) {
      f = start(false);
    } else {
      f = ((Executor)localObject);
    }
    localObject = a;
    if (localObject == null)
    {
      e = true;
      a = start(true);
    }
    else
    {
      e = false;
      a = ((Executor)localObject);
    }
    localObject = c;
    if (localObject == null) {
      c = Pair.create();
    } else {
      c = ((Pair)localObject);
    }
    localObject = d;
    if (localObject == null) {
      d = ByteVector.putByte();
    } else {
      d = ((ByteVector)localObject);
    }
    localObject = m;
    if (localObject == null) {
      m = new x();
    } else {
      m = ((p)localObject);
    }
    n = n;
    h = h;
    j = j;
    k = k;
    l = l;
    g = g;
  }
  
  private ThreadFactory build(boolean paramBoolean)
  {
    return new ThreadFactoryBuilder.1(this, paramBoolean);
  }
  
  private Executor start(boolean paramBoolean)
  {
    return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), build(paramBoolean));
  }
  
  public int a()
  {
    if (Build.VERSION.SDK_INT == 23) {
      return k / 2;
    }
    return k;
  }
  
  public ByteVector b()
  {
    return d;
  }
  
  public String c()
  {
    return g;
  }
  
  public Executor d()
  {
    return f;
  }
  
  public int e()
  {
    return j;
  }
  
  public int f()
  {
    return h;
  }
  
  public Executor getItem()
  {
    return a;
  }
  
  public Logger i()
  {
    return l;
  }
  
  public p l()
  {
    return m;
  }
  
  public Pair p()
  {
    return c;
  }
  
  public int size()
  {
    return n;
  }
}
