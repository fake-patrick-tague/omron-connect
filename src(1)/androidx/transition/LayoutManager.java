package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class LayoutManager
{
  private static Method d;
  private static boolean e;
  private static LayoutTransition h;
  private static boolean i;
  private static Field j;
  
  private static void init(LayoutTransition paramLayoutTransition)
  {
    if (!e) {}
    try
    {
      localMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
      d = localMethod;
      localMethod.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      for (;;) {}
    }
    Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
    e = true;
    localMethod = d;
    if (localMethod != null)
    {
      try
      {
        localMethod.invoke(paramLayoutTransition, new Object[0]);
        return;
      }
      catch (IllegalAccessException paramLayoutTransition)
      {
        for (;;) {}
      }
      catch (InvocationTargetException paramLayoutTransition)
      {
        for (;;) {}
      }
      Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
      return;
      Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
      return;
    }
  }
  
  static void init(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Object localObject = h;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject == null)
    {
      localObject = new SparseIntArray();
      h = (LayoutTransition)localObject;
      ((LayoutTransition)localObject).setAnimator(2, null);
      h.setAnimator(0, null);
      h.setAnimator(1, null);
      h.setAnimator(3, null);
      h.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if (localObject != null)
      {
        if (((LayoutTransition)localObject).isRunning()) {
          init((LayoutTransition)localObject);
        }
        if (localObject != h) {
          paramViewGroup.setTag(R.id.g, localObject);
        }
      }
      paramViewGroup.setLayoutTransition(h);
      return;
    }
    paramViewGroup.setLayoutTransition(null);
    if (!i) {}
    try
    {
      localObject = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
      j = (Field)localObject;
      ((Field)localObject).setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
    i = true;
    localObject = j;
    paramBoolean = bool2;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        paramBoolean = ((Field)localObject).getBoolean(paramViewGroup);
        if (paramBoolean) {
          localObject = j;
        }
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        int k;
        paramBoolean = bool1;
        continue;
      }
      try
      {
        ((Field)localObject).setBoolean(paramViewGroup, false);
      }
      catch (IllegalAccessException localIllegalAccessException2) {}
    }
    break label212;
    break label220;
    label212:
    Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
    label220:
    if (paramBoolean) {
      paramViewGroup.requestLayout();
    }
    k = R.id.g;
    localObject = (LayoutTransition)paramViewGroup.getTag(k);
    if (localObject != null)
    {
      paramViewGroup.setTag(k, null);
      paramViewGroup.setLayoutTransition((LayoutTransition)localObject);
      return;
    }
  }
}
