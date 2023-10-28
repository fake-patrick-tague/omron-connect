package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.xy.a;
import androidx.savedstate.ClassWriter;
import java.lang.reflect.Constructor;

public final class Plot
  extends f0.d
  implements f0.b
{
  private ClassWriter a;
  private Application b;
  private Lifecycle i;
  private final f0.b l;
  private Bundle s;
  
  public Plot(Application paramApplication, androidx.savedstate.Label paramLabel, Bundle paramBundle)
  {
    a = paramLabel.getSavedStateRegistry();
    i = paramLabel.getLifecycle();
    s = paramBundle;
    b = paramApplication;
    if (paramApplication != null) {
      paramApplication = f0.a.l.e(paramApplication);
    } else {
      paramApplication = new f0.a();
    }
    l = paramApplication;
  }
  
  public Label a(Class paramClass)
  {
    kotlin.x.d.i.e(paramClass, "modelClass");
    String str = paramClass.getCanonicalName();
    if (str != null) {
      return a(str, paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  public Label a(Class paramClass, a paramA)
  {
    kotlin.x.d.i.e(paramClass, "modelClass");
    kotlin.x.d.i.e(paramA, "extras");
    Object localObject = (String)paramA.a(f0.c.d);
    if (localObject != null)
    {
      if ((paramA.a(MethodWriter.l) != null) && (paramA.a(MethodWriter.o) != null))
      {
        Application localApplication = (Application)paramA.a(f0.a.c);
        boolean bool = b.class.isAssignableFrom(paramClass);
        if ((bool) && (localApplication != null)) {
          localObject = i.a(paramClass, i.a());
        } else {
          localObject = i.a(paramClass, i.b());
        }
        if (localObject == null) {
          return l.a(paramClass, paramA);
        }
        if ((bool) && (localApplication != null)) {
          return i.invoke(paramClass, (Constructor)localObject, new Object[] { localApplication, MethodWriter.a(paramA) });
        }
        return i.invoke(paramClass, (Constructor)localObject, new Object[] { MethodWriter.a(paramA) });
      }
      if (i != null) {
        return a((String)localObject, paramClass);
      }
      throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
    }
    throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
  }
  
  public final Label a(String paramString, Class paramClass)
  {
    kotlin.x.d.i.e(paramString, "key");
    kotlin.x.d.i.e(paramClass, "modelClass");
    if (i != null)
    {
      boolean bool = b.class.isAssignableFrom(paramClass);
      Constructor localConstructor;
      if ((bool) && (b != null)) {
        localConstructor = i.a(paramClass, i.a());
      } else {
        localConstructor = i.a(paramClass, i.b());
      }
      if (localConstructor == null)
      {
        if (b != null) {
          return l.a(paramClass);
        }
        return f0.c.o.b().a(paramClass);
      }
      SavedStateHandleController localSavedStateHandleController = LegacySavedStateHandleController.b(a, i, paramString, s);
      if (bool)
      {
        paramString = b;
        if (paramString != null)
        {
          kotlin.x.d.i.b(paramString);
          Item localItem = localSavedStateHandleController.a();
          kotlin.x.d.i.d(localItem, "controller.handle");
          paramString = i.invoke(paramClass, localConstructor, new Object[] { paramString, localItem });
          break label191;
        }
      }
      paramString = localSavedStateHandleController.a();
      kotlin.x.d.i.d(paramString, "controller.handle");
      paramString = i.invoke(paramClass, localConstructor, new Object[] { paramString });
      label191:
      paramString.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", localSavedStateHandleController);
      return paramString;
    }
    throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
  }
  
  public void b(Label paramLabel)
  {
    kotlin.x.d.i.e(paramLabel, "viewModel");
    Lifecycle localLifecycle = i;
    if (localLifecycle != null) {
      LegacySavedStateHandleController.b(paramLabel, a, localLifecycle);
    }
  }
}
