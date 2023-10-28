package androidx.recyclerview.widget;

public abstract class ClassVisitor
{
  public ClassVisitor() {}
  
  public abstract boolean areContentsTheSame(int paramInt1, int paramInt2);
  
  public abstract boolean areItemsTheSame(int paramInt1, int paramInt2);
  
  public Object getChangePayload(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public abstract int getNewListSize();
  
  public abstract int getOldListSize();
}
