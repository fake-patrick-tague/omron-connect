package androidx.work.impl.ui.menu;

import androidx.work.impl.asm.h;
import androidx.work.impl.m.a;
import androidx.work.impl.ui.views.ClassWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class d<T>
  implements a<T>
{
  private final List<String> a = new ArrayList();
  private androidx.work.impl.m.f.d<T> b;
  private Menu c;
  private T d;
  
  d(ClassWriter paramClassWriter)
  {
    b = paramClassWriter;
  }
  
  private void a(Menu paramMenu, Object paramObject)
  {
    if (!a.isEmpty())
    {
      if (paramMenu == null) {
        return;
      }
      if ((paramObject != null) && (!a(paramObject)))
      {
        paramMenu.add(a);
        return;
      }
      paramMenu.a(a);
    }
  }
  
  public void a()
  {
    if (!a.isEmpty())
    {
      a.clear();
      b.b(this);
    }
  }
  
  public void a(Menu paramMenu)
  {
    if (c != paramMenu)
    {
      c = paramMenu;
      a(paramMenu, d);
    }
  }
  
  public void a(Iterable paramIterable)
  {
    a.clear();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      h localH = (h)paramIterable.next();
      if (a(localH)) {
        a.add(a);
      }
    }
    if (a.isEmpty()) {
      b.b(this);
    } else {
      b.a(this);
    }
    a(c, d);
  }
  
  abstract boolean a(h paramH);
  
  abstract boolean a(Object paramObject);
  
  public boolean a(String paramString)
  {
    Object localObject = d;
    return (localObject != null) && (a(localObject)) && (a.contains(paramString));
  }
  
  public void d(Object paramObject)
  {
    d = paramObject;
    a(c, paramObject);
  }
}
