package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.f;
import java.lang.reflect.Method;

public class w
  extends ListPopupWindow
  implements Item
{
  private static Method b;
  private Item g;
  
  static
  {
    if (Build.VERSION.SDK_INT <= 28)
    {
      Object localObject = Boolean.TYPE;
      try
      {
        localObject = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[] { localObject });
        b = (Method)localObject;
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
      Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
      return;
    }
  }
  
  public w(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public void a(f paramF, MenuItem paramMenuItem)
  {
    Item localItem = g;
    if (localItem != null) {
      localItem.a(paramF, paramMenuItem);
    }
  }
  
  public void a(Item paramItem)
  {
    g = paramItem;
  }
  
  public void a(boolean paramBoolean)
  {
    Method localMethod;
    PopupWindow localPopupWindow;
    if (Build.VERSION.SDK_INT <= 28)
    {
      localMethod = b;
      if (localMethod != null) {
        localPopupWindow = mPopup;
      }
    }
    else
    {
      try
      {
        localMethod.invoke(localPopupWindow, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
      return;
      c0.b.addView(mPopup, paramBoolean);
      return;
    }
  }
  
  public void init(Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      c0.a.showAsDropDown(mPopup, (Transition)paramObject);
    }
  }
  
  ListViewCompat show(Context paramContext, boolean paramBoolean)
  {
    paramContext = new c0.c(paramContext, paramBoolean);
    paramContext.setHoverListener(this);
    return paramContext;
  }
  
  public void show(Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      c0.a.setWindowLayoutType(mPopup, (Transition)paramObject);
    }
  }
  
  public void toString(f paramF, MenuItem paramMenuItem)
  {
    Item localItem = g;
    if (localItem != null) {
      localItem.toString(paramF, paramMenuItem);
    }
  }
}
