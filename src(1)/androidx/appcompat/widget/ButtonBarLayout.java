package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import v7.internal.R.styleable;
import v7.v7.package_13.ViewCompat;

public class ButtonBarLayout
  extends LinearLayout
{
  private boolean mAllowStacking;
  private int mLastWidthSize = -1;
  private boolean mStacked;
  
  public ButtonBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int[] arrayOfInt = R.styleable.CirclePageIndicator;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    ViewCompat.obtainStyledAttributes(this, paramContext, arrayOfInt, paramAttributeSet, localTypedArray, 0, 0);
    mAllowStacking = localTypedArray.getBoolean(R.styleable.CirclePageIndicator_centered, true);
    localTypedArray.recycle();
    if (getOrientation() == 1) {
      setStacked(mAllowStacking);
    }
  }
  
  private int open(int paramInt)
  {
    int i = getChildCount();
    while (paramInt < i)
    {
      if (getChildAt(paramInt).getVisibility() == 0) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  private void setStacked(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  private boolean setStacked()
  {
    return mStacked;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    boolean bool = mAllowStacking;
    int m = 0;
    if (bool)
    {
      if ((i > mLastWidthSize) && (setStacked())) {
        setStacked(false);
      }
      mLastWidthSize = i;
    }
    int j;
    if ((!setStacked()) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      j = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
      i = 1;
    }
    else
    {
      j = paramInt1;
      i = 0;
    }
    super.onMeasure(j, paramInt2);
    int k = i;
    if (mAllowStacking)
    {
      k = i;
      if (!setStacked())
      {
        if ((getMeasuredWidthAndState() & 0xFF000000) == 16777216) {
          j = 1;
        } else {
          j = 0;
        }
        k = i;
        if (j != 0)
        {
          setStacked(true);
          k = 1;
        }
      }
    }
    if (k != 0) {
      super.onMeasure(paramInt1, paramInt2);
    }
    k = open(0);
    i = m;
    if (k >= 0)
    {
      View localView = getChildAt(k);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      j = getPaddingTop() + localView.getMeasuredHeight() + topMargin + bottomMargin + 0;
      if (setStacked())
      {
        k = open(k + 1);
        i = j;
        if (k >= 0) {
          i = j + (getChildAt(k).getPaddingTop() + (int)(getResourcesgetDisplayMetricsdensity * 16.0F));
        }
      }
      else
      {
        i = j + getPaddingBottom();
      }
    }
    if (ViewCompat.getMinimumHeight(this) != i)
    {
      setMinimumHeight(i);
      if (paramInt2 == 0) {
        super.onMeasure(paramInt1, paramInt2);
      }
    }
  }
  
  public void setAllowStacking(boolean paramBoolean)
  {
    if (mAllowStacking != paramBoolean)
    {
      mAllowStacking = paramBoolean;
      if ((!paramBoolean) && (setStacked())) {
        setStacked(false);
      }
      requestLayout();
    }
  }
}
