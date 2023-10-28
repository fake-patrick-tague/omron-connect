package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;

class SwipeRefreshLayout
  implements RecyclerView.j
{
  SwipeRefreshLayout(ItemTouchHelper paramItemTouchHelper) {}
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    ItemTouchHelper localItemTouchHelper = this$0;
    View localView = mOverdrawChild;
    if (localView == null) {
      return paramInt2;
    }
    int j = mOverdrawChildPosition;
    int i = j;
    if (j == -1)
    {
      j = mRecyclerView.indexOfChild(localView);
      i = j;
      this$0.mOverdrawChildPosition = j;
    }
    if (paramInt2 == paramInt1 - 1) {
      return i;
    }
    if (paramInt2 < i) {
      return paramInt2;
    }
    return paramInt2 + 1;
  }
}
