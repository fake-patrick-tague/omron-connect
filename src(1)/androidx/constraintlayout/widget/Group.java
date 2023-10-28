package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class Group
  extends ConstraintHelper
{
  public Group(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void applyStyle(AttributeSet paramAttributeSet)
  {
    super.applyStyle(paramAttributeSet);
    d = false;
  }
  
  public void f(ConstraintLayout paramConstraintLayout)
  {
    paramConstraintLayout = (ConstraintLayout.LayoutParams)getLayoutParams();
    f.get(0);
    f.append(0);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    animateOpen();
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    animateOpen();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    animateOpen();
  }
}
