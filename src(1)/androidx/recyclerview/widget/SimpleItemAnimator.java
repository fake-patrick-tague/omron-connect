package androidx.recyclerview.widget;

import android.view.View;

public abstract class SimpleItemAnimator
  extends RecyclerView.l
{
  boolean mSupportsChangeAnimations = true;
  
  public SimpleItemAnimator() {}
  
  public abstract boolean animateAdd(RecyclerView.b0 paramB0);
  
  public boolean animateAppearance(RecyclerView.b0 paramB0, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2)
  {
    if (paramC1 != null)
    {
      int i = left;
      int j = left;
      if ((i != j) || (top != top)) {
        return animateMove(paramB0, i, top, j, top);
      }
    }
    return animateAdd(paramB0);
  }
  
  public abstract boolean animateChange(RecyclerView.b0 paramB01, RecyclerView.b0 paramB02, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean animateChange(RecyclerView.b0 paramB01, RecyclerView.b0 paramB02, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2)
  {
    int k = left;
    int m = top;
    int i;
    int j;
    if (paramB02.shouldIgnore())
    {
      i = top;
      j = left;
    }
    else
    {
      j = left;
      i = top;
    }
    return animateChange(paramB01, paramB02, k, m, j, i);
  }
  
  public boolean animateDisappearance(RecyclerView.b0 paramB0, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2)
  {
    int k = left;
    int m = top;
    paramC1 = itemView;
    int i;
    if (paramC2 == null) {
      i = paramC1.getLeft();
    } else {
      i = left;
    }
    int j;
    if (paramC2 == null) {
      j = paramC1.getTop();
    } else {
      j = top;
    }
    if ((!paramB0.isRemoved()) && ((k != i) || (m != j)))
    {
      paramC1.layout(i, j, paramC1.getWidth() + i, paramC1.getHeight() + j);
      return animateMove(paramB0, k, m, i, j);
    }
    return animateRemove(paramB0);
  }
  
  public abstract boolean animateMove(RecyclerView.b0 paramB0, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean animatePersistence(RecyclerView.b0 paramB0, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2)
  {
    int i = left;
    int j = left;
    if ((i == j) && (top == top))
    {
      dispatchMoveFinished(paramB0);
      return false;
    }
    return animateMove(paramB0, i, top, j, top);
  }
  
  public abstract boolean animateRemove(RecyclerView.b0 paramB0);
  
  public boolean canReuseUpdatedViewHolder(RecyclerView.b0 paramB0)
  {
    return (!mSupportsChangeAnimations) || (paramB0.isInvalid());
  }
  
  public final void dispatchAddFinished(RecyclerView.b0 paramB0)
  {
    onAddFinished(paramB0);
    dispatchAnimationFinished(paramB0);
  }
  
  public final void dispatchAddStarting(RecyclerView.b0 paramB0)
  {
    onAddStarting(paramB0);
  }
  
  public final void dispatchChangeFinished(RecyclerView.b0 paramB0, boolean paramBoolean)
  {
    onChangeFinished(paramB0, paramBoolean);
    dispatchAnimationFinished(paramB0);
  }
  
  public final void dispatchChangeStarting(RecyclerView.b0 paramB0, boolean paramBoolean)
  {
    onChangeStarting(paramB0, paramBoolean);
  }
  
  public final void dispatchMoveFinished(RecyclerView.b0 paramB0)
  {
    onMoveFinished(paramB0);
    dispatchAnimationFinished(paramB0);
  }
  
  public final void dispatchMoveStarting(RecyclerView.b0 paramB0)
  {
    onMoveStarting(paramB0);
  }
  
  public final void dispatchRemoveFinished(RecyclerView.b0 paramB0)
  {
    onRemoveFinished(paramB0);
    dispatchAnimationFinished(paramB0);
  }
  
  public final void dispatchRemoveStarting(RecyclerView.b0 paramB0)
  {
    onRemoveStarting(paramB0);
  }
  
  public void onAddFinished(RecyclerView.b0 paramB0) {}
  
  public void onAddStarting(RecyclerView.b0 paramB0) {}
  
  public void onChangeFinished(RecyclerView.b0 paramB0, boolean paramBoolean) {}
  
  public void onChangeStarting(RecyclerView.b0 paramB0, boolean paramBoolean) {}
  
  public void onMoveFinished(RecyclerView.b0 paramB0) {}
  
  public void onMoveStarting(RecyclerView.b0 paramB0) {}
  
  public void onRemoveFinished(RecyclerView.b0 paramB0) {}
  
  public void onRemoveStarting(RecyclerView.b0 paramB0) {}
  
  public void setSupportsChangeAnimations(boolean paramBoolean)
  {
    mSupportsChangeAnimations = paramBoolean;
  }
}
