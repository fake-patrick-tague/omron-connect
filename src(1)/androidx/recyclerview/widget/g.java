package androidx.recyclerview.widget;

public final class g
  implements a
{
  private final RecyclerView.Adapter a;
  
  public g(RecyclerView.Adapter paramAdapter)
  {
    a = paramAdapter;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a.notifyItemMoved(paramInt1, paramInt2);
  }
}
