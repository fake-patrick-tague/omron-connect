package androidx.core.widget;

import android.widget.AbsListView;
import android.widget.ListView;

class ListViewCompatDonut
{
  static void scrollListBy(ListView paramListView, int paramInt)
  {
    paramListView.scrollListBy(paramInt);
  }
  
  static boolean update(ListView paramListView, int paramInt)
  {
    return paramListView.canScrollList(paramInt);
  }
}
