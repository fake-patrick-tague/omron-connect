package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.braze.ui.R.styleable;
import kotlin.x.d.i;

public class InAppMessageBoundedLayout
  extends RelativeLayout
{
  private int maxDefinedHeightPixels;
  private int maxDefinedWidthPixels;
  private int minDefinedHeightPixels;
  private int minDefinedWidthPixels;
  
  public InAppMessageBoundedLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.InAppMessageBoundedLayout);
    i.d(paramContext, "context.obtainStyledAttr?nAppMessageBoundedLayout)");
    maxDefinedWidthPixels = paramContext.getDimensionPixelSize(R.styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMaxWidth, 0);
    minDefinedWidthPixels = paramContext.getDimensionPixelSize(R.styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMinWidth, 0);
    maxDefinedHeightPixels = paramContext.getDimensionPixelSize(R.styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMaxHeight, 0);
    minDefinedHeightPixels = paramContext.getDimensionPixelSize(R.styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMinHeight, 0);
    paramContext.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = minDefinedWidthPixels;
    int k;
    if ((i > 0) && (j < i))
    {
      paramInt1 = View.MeasureSpec.getMode(paramInt1);
      i = View.MeasureSpec.makeMeasureSpec(minDefinedWidthPixels, paramInt1);
    }
    else
    {
      k = maxDefinedWidthPixels;
      i = paramInt1;
      if (k > 0)
      {
        i = paramInt1;
        if (j > k)
        {
          paramInt1 = View.MeasureSpec.getMode(paramInt1);
          i = View.MeasureSpec.makeMeasureSpec(maxDefinedWidthPixels, paramInt1);
        }
      }
    }
    j = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = minDefinedHeightPixels;
    if ((paramInt1 > 0) && (j < paramInt1))
    {
      paramInt1 = View.MeasureSpec.getMode(paramInt2);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(minDefinedHeightPixels, paramInt1);
    }
    else
    {
      k = maxDefinedHeightPixels;
      paramInt1 = paramInt2;
      if (k > 0)
      {
        paramInt1 = paramInt2;
        if (j > k)
        {
          paramInt1 = View.MeasureSpec.getMode(paramInt2);
          paramInt1 = View.MeasureSpec.makeMeasureSpec(maxDefinedHeightPixels, paramInt1);
        }
      }
    }
    super.onMeasure(i, paramInt1);
  }
}
