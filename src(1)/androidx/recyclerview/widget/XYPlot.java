package androidx.recyclerview.widget;

class XYPlot
  extends RecyclerView.s
{
  boolean r = false;
  
  XYPlot(b paramB) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      r = true;
    }
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    super.b(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (r))
    {
      r = false;
      c.a();
    }
  }
}
