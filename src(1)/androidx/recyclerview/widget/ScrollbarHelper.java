package androidx.recyclerview.widget;

import android.view.View;

class ScrollbarHelper
{
  static int computeScrollExtent(RecyclerView.y paramY, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.o paramO, boolean paramBoolean)
  {
    if ((paramO.getChildCount() != 0) && (paramY.getItemCount() != 0) && (paramView1 != null) && (paramView2 != null))
    {
      if (!paramBoolean) {
        return Math.abs(paramO.getPosition(paramView1) - paramO.getPosition(paramView2)) + 1;
      }
      int i = paramOrientationHelper.getDecoratedEnd(paramView2);
      int j = paramOrientationHelper.getDecoratedStart(paramView1);
      return Math.min(paramOrientationHelper.getTotalSpace(), i - j);
    }
    return 0;
  }
  
  static int computeScrollOffset(RecyclerView.y paramY, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.o paramO, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramO.getChildCount() != 0) && (paramY.getItemCount() != 0) && (paramView1 != null))
    {
      if (paramView2 == null) {
        return 0;
      }
      int i = Math.min(paramO.getPosition(paramView1), paramO.getPosition(paramView2));
      int j = Math.max(paramO.getPosition(paramView1), paramO.getPosition(paramView2));
      if (paramBoolean2) {
        i = Math.max(0, paramY.getItemCount() - j - 1);
      } else {
        i = Math.max(0, i);
      }
      if (!paramBoolean1) {
        return i;
      }
      j = Math.abs(paramOrientationHelper.getDecoratedEnd(paramView2) - paramOrientationHelper.getDecoratedStart(paramView1));
      int k = Math.abs(paramO.getPosition(paramView1) - paramO.getPosition(paramView2));
      float f = j / (k + 1);
      return Math.round(i * f + (paramOrientationHelper.getStartAfterPadding() - paramOrientationHelper.getDecoratedStart(paramView1)));
    }
    return 0;
  }
  
  static int computeScrollRange(RecyclerView.y paramY, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.o paramO, boolean paramBoolean)
  {
    if ((paramO.getChildCount() != 0) && (paramY.getItemCount() != 0) && (paramView1 != null) && (paramView2 != null))
    {
      if (!paramBoolean) {
        return paramY.getItemCount();
      }
      int i = paramOrientationHelper.getDecoratedEnd(paramView2);
      int j = paramOrientationHelper.getDecoratedStart(paramView1);
      int k = Math.abs(paramO.getPosition(paramView1) - paramO.getPosition(paramView2));
      return (int)((i - j) / (k + 1) * paramY.getItemCount());
    }
    return 0;
  }
}
