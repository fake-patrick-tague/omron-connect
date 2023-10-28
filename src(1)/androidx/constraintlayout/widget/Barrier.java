package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.m;

public class Barrier
  extends ConstraintHelper
{
  private int c;
  private int d;
  private m j;
  
  public Barrier(Context paramContext)
  {
    super(paramContext);
    super.setVisibility(8);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setVisibility(8);
  }
  
  private void a(ConstraintWidget paramConstraintWidget, int paramInt, boolean paramBoolean)
  {
    d = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      paramInt = c;
      if (paramInt == 5) {
        d = 0;
      } else if (paramInt == 6) {
        d = 1;
      }
    }
    else if (paramBoolean)
    {
      paramInt = c;
      if (paramInt == 5) {
        d = 1;
      } else if (paramInt == 6) {
        d = 0;
      }
    }
    else
    {
      paramInt = c;
      if (paramInt == 5) {
        d = 0;
      } else if (paramInt == 6) {
        d = 1;
      }
    }
    if ((paramConstraintWidget instanceof m)) {
      ((m)paramConstraintWidget).setTitle(d);
    }
  }
  
  protected void applyStyle(AttributeSet paramAttributeSet)
  {
    super.applyStyle(paramAttributeSet);
    j = new m();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView);
      int k = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < k)
      {
        int m = paramAttributeSet.getIndex(i);
        if (m == R.styleable.TextAppearance_android_textSize)
        {
          setType(paramAttributeSet.getInt(m, 0));
        }
        else if (m == R.styleable.TextAppearance_android_textColor)
        {
          j.setEnabled(paramAttributeSet.getBoolean(m, true));
        }
        else if (m == R.styleable.START)
        {
          m = paramAttributeSet.getDimensionPixelSize(m, 0);
          j.b(m);
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
    l = j;
    f();
  }
  
  public void b(ConstraintWidget paramConstraintWidget, boolean paramBoolean)
  {
    a(paramConstraintWidget, c, paramBoolean);
  }
  
  public boolean b()
  {
    return j.b();
  }
  
  public int getMargin()
  {
    return j.g();
  }
  
  public int getType()
  {
    return c;
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean)
  {
    j.setEnabled(paramBoolean);
  }
  
  public void setDpMargin(int paramInt)
  {
    float f = getResourcesgetDisplayMetricsdensity;
    paramInt = (int)(paramInt * f + 0.5F);
    j.b(paramInt);
  }
  
  public void setMargin(int paramInt)
  {
    j.b(paramInt);
  }
  
  public void setType(int paramInt)
  {
    c = paramInt;
  }
}
