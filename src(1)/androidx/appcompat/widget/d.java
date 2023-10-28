package androidx.appcompat.widget;

import android.widget.AbsListView;

class d
{
  static void c(AbsListView paramAbsListView, boolean paramBoolean)
  {
    paramAbsListView.setSelectedChildViewEnabled(paramBoolean);
  }
  
  static boolean c(AbsListView paramAbsListView)
  {
    return paramAbsListView.isSelectedChildViewEnabled();
  }
}
