package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.Type;
import java.util.Iterator;
import java.util.Set;

class LegacySavedStateHandleController
{
  static SavedStateHandleController b(androidx.savedstate.ClassWriter paramClassWriter, Lifecycle paramLifecycle, String paramString, Bundle paramBundle)
  {
    paramString = new SavedStateHandleController(paramString, Item.a(paramClassWriter.a(paramString), paramBundle));
    paramString.a(paramClassWriter, paramLifecycle);
    b(paramClassWriter, paramLifecycle);
    return paramString;
  }
  
  static void b(Label paramLabel, androidx.savedstate.ClassWriter paramClassWriter, Lifecycle paramLifecycle)
  {
    paramLabel = (SavedStateHandleController)paramLabel.getTag("androidx.lifecycle.savedstate.vm.tag");
    if ((paramLabel != null) && (!paramLabel.b()))
    {
      paramLabel.a(paramClassWriter, paramLifecycle);
      b(paramClassWriter, paramLifecycle);
    }
  }
  
  private static void b(final androidx.savedstate.ClassWriter paramClassWriter, Lifecycle paramLifecycle)
  {
    Lifecycle.State localState = paramLifecycle.c();
    if ((localState != Lifecycle.State.i) && (!localState.a(Lifecycle.State.g)))
    {
      paramLifecycle.a(new LayoutManager()
      {
        public void b(d paramAnonymousD, Lifecycle.Event paramAnonymousEvent)
        {
          if (paramAnonymousEvent == Lifecycle.Event.ON_START)
          {
            clear(this);
            paramClassWriter.a(LegacySavedStateHandleController.a.class);
          }
        }
      });
      return;
    }
    paramClassWriter.a(a.class);
  }
  
  static final class a
    implements Type
  {
    a() {}
    
    public void a(androidx.savedstate.Label paramLabel)
    {
      if ((paramLabel instanceof h))
      {
        ClassWriter localClassWriter = ((h)paramLabel).getViewModelStore();
        androidx.savedstate.ClassWriter localClassWriter1 = paramLabel.getSavedStateRegistry();
        Iterator localIterator = localClassWriter.get().iterator();
        while (localIterator.hasNext()) {
          LegacySavedStateHandleController.b(localClassWriter.a((String)localIterator.next()), localClassWriter1, paramLabel.getLifecycle());
        }
        if (!localClassWriter.get().isEmpty()) {
          localClassWriter1.a(a.class);
        }
      }
      else
      {
        throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
      }
    }
  }
}
