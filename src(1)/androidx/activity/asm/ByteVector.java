package androidx.activity.asm;

import android.content.Context;
import androidx.activity.n.b;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ByteVector
{
  private volatile Context a;
  private final Set<b> n = new CopyOnWriteArraySet();
  
  public ByteVector() {}
  
  public void a()
  {
    a = null;
  }
  
  public void a(Context paramContext)
  {
    a = paramContext;
    Iterator localIterator = n.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(paramContext);
    }
  }
  
  public void a(c paramC)
  {
    if (a != null) {
      paramC.a(a);
    }
    n.add(paramC);
  }
  
  public Context b()
  {
    return a;
  }
  
  public void trimToSize(c paramC)
  {
    n.remove(paramC);
  }
}
