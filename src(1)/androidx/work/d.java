package androidx.work;

import android.os.Build.VERSION;
import androidx.work.impl.asm.h;

public final class d
  extends s.a<k.a, k>
{
  public d(Class paramClass)
  {
    super(paramClass);
    b.m = OverwritingInputMerger.class.getName();
  }
  
  File b()
  {
    if ((c) && (Build.VERSION.SDK_INT >= 23) && (b.b.f())) {
      throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
    }
    return new File(this);
  }
  
  d f()
  {
    return this;
  }
}
