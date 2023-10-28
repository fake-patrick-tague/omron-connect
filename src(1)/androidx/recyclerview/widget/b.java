package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class b
  extends RecyclerView.q
{
  private Scroller b;
  RecyclerView c;
  private final RecyclerView.s h = new XYPlot(this);
  
  public b() {}
  
  private boolean b(RecyclerView.o paramO, int paramInt1, int paramInt2)
  {
    if (!(paramO instanceof RecyclerView.x.b)) {
      return false;
    }
    RecyclerView.x localX = close(paramO);
    if (localX == null) {
      return false;
    }
    paramInt1 = a(paramO, paramInt1, paramInt2);
    if (paramInt1 == -1) {
      return false;
    }
    localX.d(paramInt1);
    paramO.a(localX);
    return true;
  }
  
  private void e()
  {
    c.a(h);
    c.setOnFlingListener(null);
  }
  
  private void onCreateView()
    throws IllegalStateException
  {
    if (c.getOnFlingListener() == null)
    {
      c.setAdapter(h);
      c.setOnFlingListener(this);
      return;
    }
    throw new IllegalStateException("An instance of OnFlingListener already set.");
  }
  
  public abstract int a(RecyclerView.o paramO, int paramInt1, int paramInt2);
  
  void a()
  {
    Object localObject = c;
    if (localObject == null) {
      return;
    }
    localObject = ((RecyclerView)localObject).getLayoutManager();
    if (localObject == null) {
      return;
    }
    View localView = b((RecyclerView.o)localObject);
    if (localView == null) {
      return;
    }
    localObject = a((RecyclerView.o)localObject, localView);
    if ((localObject[0] != 0) || (localObject[1] != 0)) {
      c.smoothScrollBy(localObject[0], localObject[1]);
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
    throws IllegalStateException
  {
    RecyclerView localRecyclerView = c;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      e();
    }
    c = paramRecyclerView;
    if (paramRecyclerView != null)
    {
      onCreateView();
      b = new Scroller(c.getContext(), new DecelerateInterpolator());
      a();
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    RecyclerView.o localO = c.getLayoutManager();
    if (localO == null) {
      return false;
    }
    if (c.getAdapter() == null) {
      return false;
    }
    int i = c.getMinFlingVelocity();
    return ((Math.abs(paramInt2) > i) || (Math.abs(paramInt1) > i)) && (b(localO, paramInt1, paramInt2));
  }
  
  public abstract int[] a(RecyclerView.o paramO, View paramView);
  
  public abstract View b(RecyclerView.o paramO);
  
  protected abstract RecyclerView.x close(RecyclerView.o paramO);
}
