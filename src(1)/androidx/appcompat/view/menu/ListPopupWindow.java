package androidx.appcompat.view.menu;

import android.widget.ListView;

public abstract interface ListPopupWindow
{
  public abstract void dismiss();
  
  public abstract ListView getListView();
  
  public abstract boolean isShowing();
  
  public abstract void show();
}
