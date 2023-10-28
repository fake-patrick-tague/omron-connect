package androidx.appcompat.view.menu;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

class MenuPopupHelper
  implements View.OnAttachStateChangeListener
{
  MenuPopupHelper(k paramK) {}
  
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
      mTreeObserver.removeGlobalOnLayoutListener(W);
    }
    paramView.removeOnAttachStateChangeListener(this);
  }
}
