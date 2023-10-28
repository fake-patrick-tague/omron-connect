package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Log;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.h;
import androidx.work.impl.asm.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Frame
{
  private static final String g = Log.getInstance("ConstraintsCmdHandler");
  private final Context a;
  private final f b;
  private final int c;
  private final androidx.work.impl.ui.f d;
  
  Frame(Context paramContext, int paramInt, f paramF)
  {
    a = paramContext;
    c = paramInt;
    b = paramF;
    d = new androidx.work.impl.ui.f(paramContext, paramF.i(), null);
  }
  
  void a()
  {
    Object localObject2 = b.b().a().a().a();
    ConstraintProxy.a(a, (List)localObject2);
    d.a((Iterable)localObject2);
    Object localObject1 = new ArrayList(((List)localObject2).size());
    long l = System.currentTimeMillis();
    localObject2 = ((List)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (h)((Iterator)localObject2).next();
      String str = a;
      if ((l >= ((h)localObject3).a()) && ((!((h)localObject3).b()) || (d.a(str)))) {
        ((List)localObject1).add(localObject3);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = nexta;
      localObject2 = b.e(a, (String)localObject3);
      Log.get().append(g, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[] { localObject3 }), new Throwable[0]);
      localObject3 = b;
      ((f)localObject3).a(new Widget((f)localObject3, (Intent)localObject2, c));
    }
    d.a();
  }
}
