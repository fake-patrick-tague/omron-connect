package androidx.appcompat.view.menu;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

class PopupMenuHelper
  implements View.OnAttachStateChangeListener
{
  PopupMenuHelper(w paramW) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    Object localObject = mPopup.mTreeObserver;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        mPopup.mTreeObserver = paramView.getViewTreeObserver();
      }
      localObject = mPopup;
      mTreeObserver.removeGlobalOnLayoutListener(this$0);
    }
    paramView.removeOnAttachStateChangeListener(this);
  }
}
