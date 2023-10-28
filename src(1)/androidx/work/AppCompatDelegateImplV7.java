package androidx.work;

import android.os.Build.VERSION;
import androidx.work.impl.asm.h;
import java.util.concurrent.TimeUnit;

public final class AppCompatDelegateImplV7
  extends s.a<m.a, m>
{
  public AppCompatDelegateImplV7(Class paramClass, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramClass);
    b.a(paramTimeUnit.toMillis(paramLong));
  }
  
  e.a b()
  {
    if ((c) && (Build.VERSION.SDK_INT >= 23) && (b.b.f())) {
      throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
    }
    if (!b.h) {
      return new e.a(this);
    }
    throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
  }
  
  AppCompatDelegateImplV7 f()
  {
    return this;
  }
}
