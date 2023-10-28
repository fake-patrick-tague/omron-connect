package androidx.fragment.package_11;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.Plot;
import androidx.lifecycle.XYSeries;
import androidx.lifecycle.f0.a;
import androidx.lifecycle.f0.b;
import androidx.lifecycle.h;
import androidx.lifecycle.xy.PositionMetric;
import androidx.lifecycle.xy.a;
import androidx.savedstate.Label;

class MethodWriter
  implements XYSeries, Label, h
{
  private androidx.lifecycle.f b = null;
  private androidx.savedstate.f c = null;
  private f0.b j;
  private final Fragment o;
  private final androidx.lifecycle.ClassWriter r;
  
  MethodWriter(Fragment paramFragment, androidx.lifecycle.ClassWriter paramClassWriter)
  {
    o = paramFragment;
    r = paramClassWriter;
  }
  
  void a()
  {
    if (b == null)
    {
      b = new androidx.lifecycle.f(this);
      androidx.savedstate.f localF = androidx.savedstate.f.a(this);
      c = localF;
      localF.a();
      androidx.lifecycle.MethodWriter.b(this);
    }
  }
  
  void a(Bundle paramBundle)
  {
    c.b(paramBundle);
  }
  
  void f(Bundle paramBundle)
  {
    c.a(paramBundle);
  }
  
  void f(Lifecycle.State paramState)
  {
    b.c(paramState);
  }
  
  boolean f()
  {
    return b != null;
  }
  
  public a getDefaultViewModelCreationExtras()
  {
    for (Object localObject = o.requireContext().getApplicationContext(); (localObject instanceof ContextWrapper); localObject = ((ContextWrapper)localObject).getBaseContext()) {
      if ((localObject instanceof Application))
      {
        localObject = (Application)localObject;
        break label46;
      }
    }
    localObject = null;
    label46:
    PositionMetric localPositionMetric = new PositionMetric();
    if (localObject != null) {
      localPositionMetric.a(f0.a.c, localObject);
    }
    localPositionMetric.a(androidx.lifecycle.MethodWriter.l, this);
    localPositionMetric.a(androidx.lifecycle.MethodWriter.o, this);
    if (o.getArguments() != null) {
      localPositionMetric.a(androidx.lifecycle.MethodWriter.d, o.getArguments());
    }
    return localPositionMetric;
  }
  
  public f0.b getDefaultViewModelProviderFactory()
  {
    Object localObject1 = o.getDefaultViewModelProviderFactory();
    if (!localObject1.equals(o.mDefaultFactory))
    {
      j = ((f0.b)localObject1);
      return localObject1;
    }
    if (j == null)
    {
      Object localObject3 = null;
      Object localObject2;
      for (localObject1 = o.requireContext().getApplicationContext();; localObject1 = ((ContextWrapper)localObject1).getBaseContext())
      {
        localObject2 = localObject3;
        if (!(localObject1 instanceof ContextWrapper)) {
          break;
        }
        if ((localObject1 instanceof Application))
        {
          localObject2 = (Application)localObject1;
          break;
        }
      }
      j = new Plot((Application)localObject2, this, o.getArguments());
    }
    return j;
  }
  
  public Lifecycle getLifecycle()
  {
    a();
    return b;
  }
  
  public androidx.savedstate.ClassWriter getSavedStateRegistry()
  {
    a();
    return c.n();
  }
  
  public androidx.lifecycle.ClassWriter getViewModelStore()
  {
    a();
    return r;
  }
  
  void toString(Lifecycle.Event paramEvent)
  {
    b.append(paramEvent);
  }
}
