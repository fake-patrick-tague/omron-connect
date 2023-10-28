package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.d;
import kotlin.x.d.i;

public final class f
{
  public static final Item i = new Item(null);
  private final ClassWriter b;
  private final Label c;
  private boolean e;
  
  private f(Label paramLabel)
  {
    c = paramLabel;
    b = new ClassWriter();
  }
  
  public static final f a(Label paramLabel)
  {
    return i.a(paramLabel);
  }
  
  public final void a()
  {
    Lifecycle localLifecycle = c.getLifecycle();
    i.d(localLifecycle, "owner.lifecycle");
    int j;
    if (localLifecycle.c() == Lifecycle.State.i) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      localLifecycle.a(new Recreator(c));
      b.a(localLifecycle);
      e = true;
      return;
    }
    throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
  }
  
  public final void a(Bundle paramBundle)
  {
    if (!e) {
      a();
    }
    Lifecycle localLifecycle = c.getLifecycle();
    i.d(localLifecycle, "owner.lifecycle");
    if ((localLifecycle.c().a(Lifecycle.State.g) ^ true))
    {
      b.a(paramBundle);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("performRestore cannot be called when owner is ");
    paramBundle.append(localLifecycle.c());
    throw new IllegalStateException(paramBundle.toString().toString());
  }
  
  public final void b(Bundle paramBundle)
  {
    i.e(paramBundle, "outBundle");
    b.b(paramBundle);
  }
  
  public final ClassWriter n()
  {
    return b;
  }
}
