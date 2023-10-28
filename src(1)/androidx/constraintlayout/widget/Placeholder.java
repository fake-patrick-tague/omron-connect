package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;

public class Placeholder
  extends View
{
  private View c;
  private int d;
  private int o;
  
  public void a(ConstraintLayout paramConstraintLayout)
  {
    if (c == null) {
      return;
    }
    paramConstraintLayout = (ConstraintLayout.LayoutParams)getLayoutParams();
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)c.getLayoutParams();
    f.add(0);
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = f.iterator();
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.a;
    if (localDimensionBehaviour1 != localDimensionBehaviour2) {
      f.get(f.getValue());
    }
    if (f.size() != localDimensionBehaviour2) {
      f.append(f.length());
    }
    f.add(8);
  }
  
  public void b(ConstraintLayout paramConstraintLayout)
  {
    if ((d == -1) && (!isInEditMode())) {
      setVisibility(o);
    }
    paramConstraintLayout = paramConstraintLayout.findViewById(d);
    c = paramConstraintLayout;
    if (paramConstraintLayout != null)
    {
      getLayoutParamse = true;
      c.setVisibility(0);
      setVisibility(0);
    }
  }
  
  public View getContent()
  {
    return c;
  }
  
  public int getEmptyVisibility()
  {
    return o;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (isInEditMode())
    {
      paramCanvas.drawRGB(223, 223, 223);
      Paint localPaint = new Paint();
      localPaint.setARGB(255, 210, 210, 210);
      localPaint.setTextAlign(Paint.Align.CENTER);
      localPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      Rect localRect = new Rect();
      paramCanvas.getClipBounds(localRect);
      localPaint.setTextSize(localRect.height());
      int i = localRect.height();
      int j = localRect.width();
      localPaint.setTextAlign(Paint.Align.LEFT);
      localPaint.getTextBounds("?", 0, 1, localRect);
      paramCanvas.drawText("?", j / 2.0F - localRect.width() / 2.0F - left, i / 2.0F + localRect.height() / 2.0F - bottom, localPaint);
    }
  }
  
  public void setContentId(int paramInt)
  {
    if (d == paramInt) {
      return;
    }
    View localView = c;
    if (localView != null)
    {
      localView.setVisibility(0);
      c.getLayoutParams()).e = false;
      c = null;
    }
    d = paramInt;
    if (paramInt != -1)
    {
      localView = ((View)getParent()).findViewById(paramInt);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void setEmptyVisibility(int paramInt)
  {
    o = paramInt;
  }
}
