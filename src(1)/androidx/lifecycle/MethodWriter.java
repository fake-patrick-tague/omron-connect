package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.n0.a.b;
import androidx.lifecycle.xy.a;
import androidx.lifecycle.xy.x;
import androidx.savedstate.ClassWriter;
import androidx.savedstate.Label;
import androidx.savedstate.MenuItem;
import androidx.savedstate.e;
import java.util.Map;
import kotlin.x.d.i;
import kotlin.x.d.t;

public final class MethodWriter
{
  public static final a.b<Bundle> d = new Observable();
  public static final a.b<e> l = new LombokConfiguration.1();
  public static final a.b<j0> o = new LombokConfiguration.2();
  
  public static final BarFormatter a(h paramH)
  {
    i.e(paramH, "<this>");
    x localX = new x();
    b localB = b.c;
    localX.a(t.a(a0.class), localB);
    return (BarFormatter)new ClassReader(paramH, localX.a()).a("androidx.lifecycle.internal.SavedStateHandlesVM", a0.class);
  }
  
  public static final Item a(a paramA)
  {
    i.e(paramA, "<this>");
    Label localLabel = (Label)paramA.a(l);
    if (localLabel != null)
    {
      h localH = (h)paramA.a(o);
      if (localH != null)
      {
        Bundle localBundle = (Bundle)paramA.a(d);
        paramA = (String)paramA.a(f0.c.d);
        if (paramA != null) {
          return a(localLabel, localH, paramA, localBundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
      }
      throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
    }
    throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
  }
  
  private static final Item a(Label paramLabel, h paramH, String paramString, Bundle paramBundle)
  {
    g localG = a(paramLabel);
    BarFormatter localBarFormatter = a(paramH);
    paramH = (Item)localBarFormatter.getFillPaint().get(paramString);
    paramLabel = paramH;
    if (paramH == null)
    {
      paramLabel = Item.h.a(localG.a(paramString), paramBundle);
      localBarFormatter.getFillPaint().put(paramString, paramLabel);
    }
    return paramLabel;
  }
  
  public static final g a(Label paramLabel)
  {
    i.e(paramLabel, "<this>");
    paramLabel = paramLabel.getSavedStateRegistry().b("androidx.lifecycle.internal.SavedStateHandlesProvider");
    if ((paramLabel instanceof g)) {
      paramLabel = (g)paramLabel;
    } else {
      paramLabel = null;
    }
    if (paramLabel != null) {
      return paramLabel;
    }
    throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
  }
  
  public static final void b(Label paramLabel)
  {
    i.e(paramLabel, "<this>");
    Object localObject = paramLabel.getLifecycle().c();
    i.d(localObject, "lifecycle.currentState");
    int i;
    if ((localObject != Lifecycle.State.i) && (localObject != Lifecycle.State.d)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      if (paramLabel.getSavedStateRegistry().b("androidx.lifecycle.internal.SavedStateHandlesProvider") == null)
      {
        localObject = new g(paramLabel.getSavedStateRegistry(), (h)paramLabel);
        paramLabel.getSavedStateRegistry().a("androidx.lifecycle.internal.SavedStateHandlesProvider", (MenuItem)localObject);
        paramLabel.getLifecycle().a(new SavedStateHandleAttacher((g)localObject));
      }
    }
    else {
      throw new IllegalArgumentException("Failed requirement.".toString());
    }
  }
}
