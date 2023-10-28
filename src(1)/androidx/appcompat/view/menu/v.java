package androidx.appcompat.view.menu;

import android.widget.PopupWindow.OnDismissListener;

class v
  implements PopupWindow.OnDismissListener
{
  v(Label paramLabel) {}
  
  public void onDismiss()
  {
    a.onCloseMenu();
  }
}
