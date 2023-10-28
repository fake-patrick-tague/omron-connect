package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.d;

public abstract class VirtualLayout
  extends ConstraintHelper
{
  private boolean mDetached;
  private boolean mFragmentManager;
  
  protected void applyStyle(AttributeSet paramAttributeSet)
  {
    super.applyStyle(paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.Spinner_android_gravity) {
          mDetached = true;
        } else if (k == R.styleable.Spinner_android_prompt) {
          mFragmentManager = true;
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
  }
  
  public void g(d paramD, int paramInt1, int paramInt2) {}
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((mDetached) || (mFragmentManager))
    {
      Object localObject = getParent();
      if ((localObject != null) && ((localObject instanceof ConstraintLayout)))
      {
        localObject = (ConstraintLayout)localObject;
        int j = getVisibility();
        float f;
        if (Build.VERSION.SDK_INT >= 21) {
          f = getElevation();
        } else {
          f = 0.0F;
        }
        int i = 0;
        while (i < k)
        {
          View localView = ((ConstraintLayout)localObject).b(b[i]);
          if (localView != null)
          {
            if (mDetached) {
              localView.setVisibility(j);
            }
            if ((mFragmentManager) && (f > 0.0F) && (Build.VERSION.SDK_INT >= 21)) {
              localView.setTranslationZ(localView.getTranslationZ() + f);
            }
          }
          i += 1;
        }
      }
    }
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
