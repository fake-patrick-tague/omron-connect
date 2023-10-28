package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

class FlurryAdSize
  extends b
{
  FlurryAdSize() {}
  
  public float a(View paramView)
  {
    return paramView.getTransitionAlpha();
  }
  
  public void a(View paramView, float paramFloat)
  {
    paramView.setTransitionAlpha(paramFloat);
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView.setTransitionVisibility(paramInt);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setLeftTopRightBottom(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(View paramView, Matrix paramMatrix)
  {
    paramView.transformMatrixToGlobal(paramMatrix);
  }
  
  public void draw(View paramView, Matrix paramMatrix)
  {
    paramView.transformMatrixToLocal(paramMatrix);
  }
}
