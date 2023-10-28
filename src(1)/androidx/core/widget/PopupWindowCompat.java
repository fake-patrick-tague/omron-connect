package androidx.core.widget;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import v7.v7.package_13.GravityCompat;
import v7.v7.package_13.ViewCompat;

public final class PopupWindowCompat
{
  private static boolean b;
  private static Method sSetWindowLayoutTypeMethod;
  private static boolean sSetWindowLayoutTypeMethodAttempted;
  private static Field w;
  
  public static void init(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      PopupWindowImpl.setOverlapAnchor(paramPopupWindow, paramBoolean);
      return;
    }
    if (i >= 21)
    {
      if (!b)
      {
        try
        {
          Field localField1 = PopupWindow.class.getDeclaredField("mOverlapAnchor");
          w = localField1;
          localField1.setAccessible(true);
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", localNoSuchFieldException);
        }
        b = true;
      }
      Field localField2 = w;
      if (localField2 != null) {
        try
        {
          localField2.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
          return;
        }
        catch (IllegalAccessException paramPopupWindow)
        {
          Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", paramPopupWindow);
        }
      }
    }
  }
  
  public static void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      PopupWindowImpl.setWindowLayoutType(paramPopupWindow, paramInt);
      return;
    }
    if (!sSetWindowLayoutTypeMethodAttempted) {
      localObject = Integer.TYPE;
    }
    try
    {
      localObject = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { localObject });
      sSetWindowLayoutTypeMethod = (Method)localObject;
      ((Method)localObject).setAccessible(true);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          ((Method)localObject).invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow) {}
        localException = localException;
      }
    }
    sSetWindowLayoutTypeMethodAttempted = true;
    Object localObject = sSetWindowLayoutTypeMethod;
    if (localObject != null) {}
  }
  
  public static void update(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      ApplicationContext.showAsDropDown(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
      return;
    }
    int i = paramInt1;
    if ((GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection(paramView)) & 0x7) == 5) {
      i = paramInt1 - (paramPopupWindow.getWidth() - paramView.getWidth());
    }
    paramPopupWindow.showAsDropDown(paramView, i, paramInt2);
  }
  
  class PopupWindowImpl
  {
    static boolean getOverlapAnchor(PopupWindow paramPopupWindow)
    {
      return paramPopupWindow.getOverlapAnchor();
    }
    
    static int getWindowLayoutType(PopupWindow paramPopupWindow)
    {
      return paramPopupWindow.getWindowLayoutType();
    }
    
    static void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
    }
    
    static void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
    {
      paramPopupWindow.setWindowLayoutType(paramInt);
    }
  }
}
