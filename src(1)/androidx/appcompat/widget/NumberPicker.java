package androidx.appcompat.widget;

import android.view.View;

class NumberPicker
  implements Runnable
{
  NumberPicker(ListViewCompat paramListViewCompat) {}
  
  public void onTouchEvent()
  {
    ListViewCompat localListViewCompat = a;
    a = null;
    localListViewCompat.removeCallbacks(this);
  }
  
  public void postChangeCurrentByOneFromLongPress()
  {
    a.post(this);
  }
  
  public void run()
  {
    ListViewCompat localListViewCompat = a;
    a = null;
    localListViewCompat.drawableStateChanged();
  }
}
