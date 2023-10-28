package androidx.browser.browseractions;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import v7.rss.R.string;

public class BrowserActionsFallbackMenuView
  extends LinearLayout
{
  private final int mItemPadding = getResources().getDimensionPixelOffset(R.string.username);
  private final int mProgressBarPadding = getResources().getDimensionPixelOffset(R.string.security);
  
  public BrowserActionsFallbackMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResourcesgetDisplayMetricswidthPixels - mProgressBarPadding * 2, mItemPadding), 1073741824), paramInt2);
  }
}
