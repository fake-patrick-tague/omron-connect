package com.google.android.datatransport.asm;

import com.google.android.datatransport.Type;
import com.google.android.datatransport.asm.util.Menu;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Plot;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.f;
import java.util.Collections;
import java.util.Set;

public class a
  implements LayoutManager
{
  private static volatile i b;
  private final com.google.android.datatransport.asm.asm.Label a;
  private final com.google.android.datatransport.asm.asm.Label c;
  private final Menu e;
  private final f f;
  
  a(com.google.android.datatransport.asm.asm.Label paramLabel1, com.google.android.datatransport.asm.asm.Label paramLabel2, Menu paramMenu, f paramF, Plot paramPlot)
  {
    c = paramLabel1;
    a = paramLabel2;
    e = paramMenu;
    f = paramF;
    paramPlot.addListener();
  }
  
  private Item a(m paramM)
  {
    return Item.get().add(c.a()).get(a.a()).get(paramM.d()).add(new Edge(paramM.getGroupId(), paramM.a())).add(paramM.get().getName()).add();
  }
  
  public static a a()
  {
    i localI = b;
    if (localI != null) {
      return localI.a();
    }
    throw new IllegalStateException("Not initialized!");
  }
  
  public static void a(android.content.Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = MethodWriter.b().a(paramContext).a();
        }
        return;
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
  }
  
  private static Set read(Object paramObject)
  {
    if ((paramObject instanceof Label)) {
      return Collections.unmodifiableSet(((Label)paramObject).d());
    }
    return Collections.singleton(Type.valueOf("proto"));
  }
  
  public com.google.android.datatransport.Label a(Object paramObject)
  {
    return new l(read(paramObject), Context.getInstance().get(paramObject.getName()).get(paramObject.getExtras()).get(), this);
  }
  
  public void a(m paramM, com.google.android.datatransport.Item paramItem)
  {
    e.add(paramM.f().get(paramM.get().getGroupId()), a(paramM), paramItem);
  }
  
  public f getValue()
  {
    return f;
  }
}
