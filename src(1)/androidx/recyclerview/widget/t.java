package androidx.recyclerview.widget;

import java.util.List;

public abstract class t<T, VH extends RecyclerView.b0>
  extends RecyclerView.Adapter<VH>
{
  final d<T> a;
  private final d.b<T> f;
  
  protected t(SortedList.Callback paramCallback)
  {
    Type localType = new Type(this);
    f = localType;
    paramCallback = new ClassWriter(new g(this), new RestAdapter.Builder(paramCallback).build());
    a = paramCallback;
    paramCallback.a(localType);
  }
  
  public void a(List paramList)
  {
    a.a(paramList);
  }
  
  protected Object b(int paramInt)
  {
    return a.get().get(paramInt);
  }
  
  public void b(List paramList1, List paramList2) {}
  
  public int getItemCount()
  {
    return a.get().size();
  }
}
