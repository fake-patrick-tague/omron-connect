package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.o;
import java.util.Locale;

final class i
  extends ViewPager2.i
{
  private ViewPager2.k b;
  private final LinearLayoutManager d;
  
  i(LinearLayoutManager paramLinearLayoutManager)
  {
    d = paramLinearLayoutManager;
  }
  
  ViewPager2.k a()
  {
    return b;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (b == null) {
      return;
    }
    paramFloat = -paramFloat;
    paramInt2 = 0;
    while (paramInt2 < d.getChildCount())
    {
      View localView = d.getChildAt(paramInt2);
      if (localView != null)
      {
        float f = d.getPosition(localView) - paramInt1;
        b.a(localView, f + paramFloat);
        paramInt2 += 1;
      }
      else
      {
        throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(d.getChildCount()) }));
      }
    }
  }
  
  public void b(int paramInt) {}
  
  void e(ViewPager2.k paramK)
  {
    b = paramK;
  }
}
