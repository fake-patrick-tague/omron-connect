package androidx.lifecycle.xy;

import androidx.lifecycle.f0.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.b;
import kotlin.x.a;
import kotlin.x.c.l;
import kotlin.x.d.i;

public final class x
{
  private final List<androidx.lifecycle.n0.f<?>> c = new ArrayList();
  
  public x() {}
  
  public final f0.b a()
  {
    Object localObject = c.toArray(new f[0]);
    Objects.requireNonNull(localObject, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    localObject = (f[])localObject;
    return new e((f[])Arrays.copyOf((Object[])localObject, localObject.length));
  }
  
  public final void a(b paramB, l paramL)
  {
    i.e(paramB, "clazz");
    i.e(paramL, "initializer");
    c.add(new f(a.a(paramB), paramL));
  }
}
