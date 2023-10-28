package androidx.transition;

import android.animation.LayoutTransition;

final class SparseIntArray
  extends LayoutTransition
{
  SparseIntArray() {}
  
  public boolean isChangingLayout()
  {
    return true;
  }
}
