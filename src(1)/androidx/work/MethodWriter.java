package androidx.work;

import android.os.Build.VERSION;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class MethodWriter<B extends s.a<?, ?>, W extends s>
{
  androidx.work.impl.asm.h b;
  boolean c = false;
  Class<? extends ListenableWorker> e;
  UUID g = UUID.randomUUID();
  Set<String> r = new HashSet();
  
  MethodWriter(Class paramClass)
  {
    e = paramClass;
    b = new androidx.work.impl.asm.h(g.toString(), paramClass.getName());
    a(paramClass.getName());
  }
  
  public final MethodWriter a(String paramString)
  {
    r.add(paramString);
    return c();
  }
  
  public final h a()
  {
    h localH = d();
    Object localObject = b.b;
    int i = Build.VERSION.SDK_INT;
    if (((i < 24) || (!((i)localObject).b())) && (!((i)localObject).c()) && (!((i)localObject).g()) && ((i < 23) || (!((i)localObject).f()))) {
      i = 0;
    } else {
      i = 1;
    }
    localObject = b;
    if (h) {
      if (i == 0)
      {
        if (n > 0L) {
          throw new IllegalArgumentException("Expedited jobs cannot be delayed");
        }
      }
      else {
        throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
      }
    }
    g = UUID.randomUUID();
    localObject = new androidx.work.impl.asm.h(b);
    b = ((androidx.work.impl.asm.h)localObject);
    a = g.toString();
    return localH;
  }
  
  public final MethodWriter b(Label paramLabel)
  {
    b.c = paramLabel;
    return c();
  }
  
  abstract MethodWriter c();
  
  abstract h d();
}
