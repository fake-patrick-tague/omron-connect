package androidx.savedstate;

import android.os.BaseBundle;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.d;
import c.b.a.b.b;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.x.d.i;
import v7.support.v7.asm.f;

public final class ClassWriter
{
  private static final Quaternion K = new Quaternion(null);
  private Bundle a;
  private final b<String, c.c> c = new f();
  private boolean e;
  private boolean f;
  private Recreator.b i;
  private boolean s = true;
  
  public ClassWriter() {}
  
  private static final void b(ClassWriter paramClassWriter, d paramD, Lifecycle.Event paramEvent)
  {
    i.e(paramClassWriter, "this$0");
    i.e(paramD, "<anonymous parameter 0>");
    i.e(paramEvent, "event");
    if (paramEvent == Lifecycle.Event.ON_START)
    {
      s = true;
      return;
    }
    if (paramEvent == Lifecycle.Event.ON_STOP) {
      s = false;
    }
  }
  
  public final Bundle a(String paramString)
  {
    i.e(paramString, "key");
    Bundle localBundle1;
    if (f)
    {
      localBundle1 = a;
      if (localBundle1 != null)
      {
        if (localBundle1 != null) {
          localBundle1 = localBundle1.getBundle(paramString);
        } else {
          localBundle1 = null;
        }
        Bundle localBundle2 = a;
        if (localBundle2 != null) {
          localBundle2.remove(paramString);
        }
        paramString = a;
        int k = 0;
        int j = k;
        if (paramString != null)
        {
          j = k;
          if (!paramString.isEmpty()) {
            j = 1;
          }
        }
        if (j == 0)
        {
          a = null;
          return localBundle1;
        }
      }
      else
      {
        return null;
      }
    }
    else
    {
      throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }
    return localBundle1;
  }
  
  public final void a(Bundle paramBundle)
  {
    if (e)
    {
      if ((f ^ true))
      {
        if (paramBundle != null) {
          paramBundle = paramBundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        } else {
          paramBundle = null;
        }
        a = paramBundle;
        f = true;
        return;
      }
      throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
    }
    throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
  }
  
  public final void a(Lifecycle paramLifecycle)
  {
    i.e(paramLifecycle, "lifecycle");
    if ((e ^ true))
    {
      paramLifecycle.a(new a(this));
      e = true;
      return;
    }
    throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
  }
  
  public final void a(Class paramClass)
  {
    i.e(paramClass, "clazz");
    if (s)
    {
      Object localObject2 = i;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Recreator.b(this);
      }
      i = ((Recreator.b)localObject1);
      try
      {
        paramClass.getDeclaredConstructor(new Class[0]);
        localObject1 = i;
        if (localObject1 == null) {
          return;
        }
        paramClass = paramClass.getName();
        i.d(paramClass, "clazz.name");
        ((Recreator.b)localObject1).a(paramClass);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Class ");
        ((StringBuilder)localObject2).append(paramClass.getSimpleName());
        ((StringBuilder)localObject2).append(" must have default constructor in order to be automatically recreated");
        throw new IllegalArgumentException(((StringBuilder)localObject2).toString(), localNoSuchMethodException);
      }
    }
    else
    {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }
  }
  
  public final void a(String paramString, MenuItem paramMenuItem)
  {
    i.e(paramString, "key");
    i.e(paramMenuItem, "provider");
    int j;
    if ((MenuItem)c.b(paramString, paramMenuItem) == null) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      return;
    }
    throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
  }
  
  public final MenuItem b(String paramString)
  {
    i.e(paramString, "key");
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      i.d(localObject, "components");
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (MenuItem)((Map.Entry)localObject).getValue();
      if (i.a(str, paramString)) {
        return localObject;
      }
    }
    return null;
  }
  
  public final void b(Bundle paramBundle)
  {
    i.e(paramBundle, "outBundle");
    Bundle localBundle = new Bundle();
    Object localObject = a;
    if (localObject != null) {
      localBundle.putAll((Bundle)localObject);
    }
    localObject = c.a();
    i.d(localObject, "this.components.iteratorWithAdditions()");
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localBundle.putBundle((String)localEntry.getKey(), ((MenuItem)localEntry.getValue()).onSaveInstanceState());
    }
    if (!localBundle.isEmpty()) {
      paramBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", localBundle);
    }
  }
}
