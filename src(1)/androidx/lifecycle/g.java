package androidx.lifecycle;

import android.os.BaseBundle;
import android.os.Bundle;
import androidx.savedstate.ClassWriter;
import androidx.savedstate.MenuItem;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.x.d.i;

public final class g
  implements MenuItem
{
  private final kotlin.g a;
  private final ClassWriter b;
  private Bundle c;
  private boolean e;
  
  public g(ClassWriter paramClassWriter, h paramH)
  {
    b = paramClassWriter;
    a = kotlin.h.b(new Switch(paramH));
  }
  
  private final BarFormatter a()
  {
    return (BarFormatter)a.getValue();
  }
  
  public final Bundle a(String paramString)
  {
    i.e(paramString, "key");
    b();
    Bundle localBundle1 = c;
    if (localBundle1 != null) {
      localBundle1 = localBundle1.getBundle(paramString);
    } else {
      localBundle1 = null;
    }
    Bundle localBundle2 = c;
    if (localBundle2 != null) {
      localBundle2.remove(paramString);
    }
    paramString = c;
    int i = 1;
    if ((paramString == null) || (paramString.isEmpty() != true)) {
      i = 0;
    }
    if (i != 0) {
      c = null;
    }
    return localBundle1;
  }
  
  public final void b()
  {
    if (!e)
    {
      c = b.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
      e = true;
      a();
    }
  }
  
  public Bundle onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    Object localObject1 = c;
    if (localObject1 != null) {
      localBundle.putAll((Bundle)localObject1);
    }
    localObject1 = a().getFillPaint().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = ((Item)((Map.Entry)localObject2).getValue()).a().onSaveInstanceState();
      if (!i.a(localObject2, Bundle.EMPTY)) {
        localBundle.putBundle(str, (Bundle)localObject2);
      }
    }
    e = false;
    return localBundle;
  }
}
