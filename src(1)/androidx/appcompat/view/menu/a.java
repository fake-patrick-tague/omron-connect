package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.appcompat.widget.ListPopupWindow;
import java.util.Iterator;
import java.util.List;

class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  a(w paramW) {}
  
  public void onGlobalLayout()
  {
    if ((a.isShowing()) && (a.a.size() > 0) && (!a.a.get(0)).this$0.isModal()))
    {
      Object localObject = a.view;
      if ((localObject != null) && (((View)localObject).isShown())) {
        localObject = a.a.iterator();
      }
      while (((Iterator)localObject).hasNext())
      {
        nextthis$0.show();
        continue;
        a.dismiss();
      }
    }
  }
}
