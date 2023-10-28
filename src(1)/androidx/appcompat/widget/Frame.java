package androidx.appcompat.widget;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Frame
{
  private static Method a;
  private static Method b;
  private static boolean c;
  private static Method d;
  
  static
  {
    Object localObject1 = Integer.TYPE;
    Object localObject2 = Boolean.TYPE;
    Class localClass = Float.TYPE;
    try
    {
      localObject2 = AbsListView.class.getDeclaredMethod("positionSelector", new Class[] { localObject1, View.class, localObject2, localClass, localClass });
      a = (Method)localObject2;
      ((Method)localObject2).setAccessible(true);
      localObject2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", new Class[] { localObject1 });
      b = (Method)localObject2;
      ((Method)localObject2).setAccessible(true);
      localObject1 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", new Class[] { localObject1 });
      d = (Method)localObject1;
      ((Method)localObject1).setAccessible(true);
      c = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
  }
  
  static void a(ListViewCompat paramListViewCompat, int paramInt, View paramView)
  {
    Method localMethod = a;
    Boolean localBoolean = Boolean.FALSE;
    try
    {
      localMethod.invoke(paramListViewCompat, new Object[] { Integer.valueOf(paramInt), paramView, localBoolean, Integer.valueOf(-1), Integer.valueOf(-1) });
      paramView = b;
      paramView.invoke(paramListViewCompat, new Object[] { Integer.valueOf(paramInt) });
      paramView = d;
      paramView.invoke(paramListViewCompat, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (InvocationTargetException paramListViewCompat)
    {
      paramListViewCompat.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramListViewCompat)
    {
      paramListViewCompat.printStackTrace();
    }
  }
  
  static boolean c()
  {
    return c;
  }
}
