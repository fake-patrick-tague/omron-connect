package androidx.work.impl.ui.views;

import android.content.Context;
import androidx.work.Log;
import androidx.work.impl.m.a;
import androidx.work.impl.ui.Label;
import androidx.work.impl.utils.asm.f;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public abstract class ClassWriter<T>
{
  private static final String g = Log.getInstance("ConstraintTracker");
  protected final f b;
  private final Set<a<T>> c = new LinkedHashSet();
  protected final Context context;
  private final Object d = new Object();
  T x;
  
  ClassWriter(Context paramContext, f paramF)
  {
    context = paramContext.getApplicationContext();
    b = paramF;
  }
  
  public abstract void a();
  
  public void a(Label paramLabel)
  {
    Object localObject = d;
    try
    {
      if (c.add(paramLabel))
      {
        if (c.size() == 1)
        {
          x = get();
          Log.get().append(g, String.format("%s: initial state = %s", new Object[] { getClass().getSimpleName(), x }), new Throwable[0]);
          onCreate();
        }
        paramLabel.d(x);
      }
      return;
    }
    catch (Throwable paramLabel)
    {
      throw paramLabel;
    }
  }
  
  public void add(Object paramObject)
  {
    Object localObject1 = d;
    try
    {
      Object localObject2 = x;
      if ((localObject2 != paramObject) && ((localObject2 == null) || (!localObject2.equals(paramObject))))
      {
        x = paramObject;
        paramObject = new ArrayList(c);
        b.get().execute(new XMPPService.4(this, paramObject));
        return;
      }
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public void b(Label paramLabel)
  {
    Object localObject = d;
    try
    {
      if ((c.remove(paramLabel)) && (c.isEmpty())) {
        a();
      }
      return;
    }
    catch (Throwable paramLabel)
    {
      throw paramLabel;
    }
  }
  
  public abstract Object get();
  
  public abstract void onCreate();
}
