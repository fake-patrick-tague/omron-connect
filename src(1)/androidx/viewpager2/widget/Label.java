package androidx.viewpager2.widget;

import I;
import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.o;
import java.lang.reflect.Array;
import java.util.Arrays;

final class Label
{
  private static final ViewGroup.MarginLayoutParams mDividerHeight;
  private LinearLayoutManager d;
  
  static
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
    mDividerHeight = localMarginLayoutParams;
    localMarginLayoutParams.setMargins(0, 0, 0, 0);
  }
  
  Label(LinearLayoutManager paramLinearLayoutManager)
  {
    d = paramLinearLayoutManager;
  }
  
  private static boolean a(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      LayoutTransition localLayoutTransition = paramView.getLayoutTransition();
      if ((localLayoutTransition != null) && (localLayoutTransition.isChangingLayout())) {
        return true;
      }
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        if (a(paramView.getChildAt(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private boolean b()
  {
    int j = d.getChildCount();
    int i = 0;
    while (i < j)
    {
      if (a(d.getChildAt(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean onDrawOver()
  {
    int n = d.getChildCount();
    if (n == 0) {
      return true;
    }
    if (d.getOrientation() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(I.class, new int[] { n, 2 });
    int j = 0;
    while (j < n)
    {
      View localView = d.getChildAt(j);
      if (localView != null)
      {
        Object localObject = localView.getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
        } else {
          localObject = mDividerHeight;
        }
        int[] arrayOfInt1 = arrayOfInt[j];
        int k;
        int m;
        if (i != 0)
        {
          k = localView.getLeft();
          m = leftMargin;
        }
        else
        {
          k = localView.getTop();
          m = topMargin;
        }
        arrayOfInt1[0] = (k - m);
        arrayOfInt1 = arrayOfInt[j];
        if (i != 0)
        {
          k = localView.getRight();
          m = rightMargin;
        }
        else
        {
          k = localView.getBottom();
          m = bottomMargin;
        }
        arrayOfInt1[1] = (k + m);
        j += 1;
      }
      else
      {
        throw new IllegalStateException("null view contained in the view hierarchy");
      }
    }
    Arrays.sort(arrayOfInt, new DetailArret.1(this));
    int i = 1;
    while (i < n)
    {
      if (arrayOfInt[(i - 1)][1] != arrayOfInt[i][0]) {
        return false;
      }
      i += 1;
    }
    i = arrayOfInt[0][1];
    j = arrayOfInt[0][0];
    if (arrayOfInt[0][0] <= 0) {
      return arrayOfInt[(n - 1)][1] >= i - j;
    }
    return false;
  }
  
  boolean a()
  {
    return ((!onDrawOver()) || (d.getChildCount() <= 1)) && (b());
  }
}
