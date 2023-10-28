package androidx.core.widget;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

public final class View
{
  public static void scrollListBy(ListView paramListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      ListViewCompatDonut.scrollListBy(paramListView, paramInt);
      return;
    }
    int i = paramListView.getFirstVisiblePosition();
    if (i == -1) {
      return;
    }
    android.view.View localView = paramListView.getChildAt(0);
    if (localView == null) {
      return;
    }
    paramListView.setSelectionFromTop(i, localView.getTop() - paramInt);
  }
  
  public static boolean update(ListView paramListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ListViewCompatDonut.update(paramListView, paramInt);
    }
    int j = paramListView.getChildCount();
    if (j == 0) {
      return false;
    }
    int i = paramListView.getFirstVisiblePosition();
    if (paramInt > 0)
    {
      paramInt = paramListView.getChildAt(j - 1).getBottom();
      if ((i + j < paramListView.getCount()) || (paramInt > paramListView.getHeight() - paramListView.getListPaddingBottom())) {
        return true;
      }
    }
    else
    {
      paramInt = paramListView.getChildAt(0).getTop();
      if ((i > 0) || (paramInt < paramListView.getListPaddingTop())) {
        return true;
      }
    }
    return false;
  }
}
