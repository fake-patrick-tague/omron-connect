package androidx.appcompat.widget;

import android.widget.AbsListView;
import java.lang.reflect.Field;

class l
{
  private static final Field f;
  
  static
  {
    Object localObject = null;
    try
    {
      Field localField2 = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      Field localField1 = localField2;
      localObject = localField1;
      localField2.setAccessible(true);
      localObject = localField1;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
    f = localObject;
  }
  
  static void a(AbsListView paramAbsListView, boolean paramBoolean)
  {
    Field localField = f;
    if (localField != null) {
      try
      {
        localField.set(paramAbsListView, Boolean.valueOf(paramBoolean));
        return;
      }
      catch (IllegalAccessException paramAbsListView)
      {
        paramAbsListView.printStackTrace();
      }
    }
  }
  
  static boolean a(AbsListView paramAbsListView)
  {
    Field localField = f;
    if (localField != null) {
      try
      {
        boolean bool = localField.getBoolean(paramAbsListView);
        return bool;
      }
      catch (IllegalAccessException paramAbsListView)
      {
        paramAbsListView.printStackTrace();
      }
    }
    return false;
  }
}
