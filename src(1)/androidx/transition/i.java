package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import c.e.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;
import v7.v7.package_13.ViewCompat;

public class i
{
  static ArrayList<ViewGroup> a = new ArrayList();
  private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<Transition>>>> c;
  private static Transition d = new AutoTransition();
  
  static
  {
    c = new ThreadLocal();
  }
  
  public static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((!a.contains(paramViewGroup)) && (ViewCompat.set(paramViewGroup)))
    {
      a.add(paramViewGroup);
      Transition localTransition = paramTransition;
      if (paramTransition == null) {
        localTransition = d;
      }
      paramTransition = localTransition.set();
      clear(paramViewGroup, paramTransition);
      m.b(paramViewGroup, null);
      show(paramViewGroup, paramTransition);
    }
  }
  
  private static void clear(ViewGroup paramViewGroup, Transition paramTransition)
  {
    Object localObject = (ArrayList)remove().get(paramViewGroup);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).init(paramViewGroup);
      }
    }
    if (paramTransition != null) {
      paramTransition.draw(paramViewGroup, true);
    }
    paramViewGroup = m.a(paramViewGroup);
    if (paramViewGroup != null) {
      paramViewGroup.a();
    }
  }
  
  static ArrayMap remove()
  {
    Object localObject = (WeakReference)c.get();
    if (localObject != null)
    {
      localObject = (ArrayMap)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = new ArrayMap();
    WeakReference localWeakReference = new WeakReference(localObject);
    c.set(localWeakReference);
    return localObject;
  }
  
  private static void show(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((paramTransition != null) && (paramViewGroup != null))
    {
      paramTransition = new MainActivity.2(paramTransition, paramViewGroup);
      paramViewGroup.addOnAttachStateChangeListener(paramTransition);
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramTransition);
    }
  }
}
