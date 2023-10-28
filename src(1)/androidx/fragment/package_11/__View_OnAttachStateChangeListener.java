package androidx.fragment.package_11;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import v7.v7.package_13.ViewCompat;

class __View_OnAttachStateChangeListener
  implements View.OnAttachStateChangeListener
{
  __View_OnAttachStateChangeListener(Log paramLog, View paramView) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    itemView.removeOnAttachStateChangeListener(this);
    ViewCompat.requestApplyInsets(itemView);
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}
