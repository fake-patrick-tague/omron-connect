package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsSpinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import androidx.appcompat.app.ActionBar.b;
import v7.internal.R.attr;
import v7.internal.view.ActionBarPolicy;

public class ScrollingTabContainerView
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
  private boolean mAllowCollapse;
  private int mContentHeight;
  int mMaxTabWidth;
  private int mSelectedTabIndex;
  int mStackedTabMaxWidth;
  private g0.c mTabClickListener;
  LinearLayoutCompat mTabLayout;
  Runnable mTabSelector;
  private Spinner mTabSpinner;
  
  private Spinner createSpinner()
  {
    AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
    localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    localAppCompatSpinner.setOnItemSelectedListener(this);
    return localAppCompatSpinner;
  }
  
  private boolean isCollapsed()
  {
    Spinner localSpinner = mTabSpinner;
    return (localSpinner != null) && (localSpinner.getParent() == this);
  }
  
  private void performCollapse()
  {
    if (isCollapsed()) {
      return;
    }
    if (mTabSpinner == null) {
      mTabSpinner = createSpinner();
    }
    removeView(mTabLayout);
    addView(mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
    if (mTabSpinner.getAdapter() == null) {
      mTabSpinner.setAdapter(new g0.b(this));
    }
    Runnable localRunnable = mTabSelector;
    if (localRunnable != null)
    {
      removeCallbacks(localRunnable);
      mTabSelector = null;
    }
    mTabSpinner.setSelection(mSelectedTabIndex);
  }
  
  private boolean performExpand()
  {
    if (!isCollapsed()) {
      return false;
    }
    removeView(mTabSpinner);
    addView(mTabLayout, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(mTabSpinner.getSelectedItemPosition());
    return false;
  }
  
  public void animateToTab(int paramInt)
  {
    Object localObject = mTabLayout.getChildAt(paramInt);
    Runnable localRunnable = mTabSelector;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
    localObject = new g0.a(this, (View)localObject);
    mTabSelector = ((Runnable)localObject);
    post((Runnable)localObject);
  }
  
  g0.d createTabView(ActionBar.b paramB, boolean paramBoolean)
  {
    paramB = new g0.d(this, getContext(), paramB, paramBoolean);
    if (paramBoolean)
    {
      paramB.setBackgroundDrawable(null);
      paramB.setLayoutParams(new AbsListView.LayoutParams(-1, mContentHeight));
      return paramB;
    }
    paramB.setFocusable(true);
    if (mTabClickListener == null) {
      mTabClickListener = new g0.c(this);
    }
    paramB.setOnClickListener(mTabClickListener);
    return paramB;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Runnable localRunnable = mTabSelector;
    if (localRunnable != null) {
      post(localRunnable);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = ActionBarPolicy.get(getContext());
    setContentHeight(paramConfiguration.getTabContainerHeight());
    mStackedTabMaxWidth = paramConfiguration.getStackedTabMaxWidth();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Runnable localRunnable = mTabSelector;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
  }
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((g0.d)paramView).getItems().clear();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = 1;
    boolean bool;
    if (i == 1073741824) {
      bool = true;
    } else {
      bool = false;
    }
    setFillViewport(bool);
    int j = mTabLayout.getChildCount();
    if ((j > 1) && ((i == 1073741824) || (i == Integer.MIN_VALUE)))
    {
      if (j > 2) {
        mMaxTabWidth = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      } else {
        mMaxTabWidth = (View.MeasureSpec.getSize(paramInt1) / 2);
      }
      mMaxTabWidth = Math.min(mMaxTabWidth, mStackedTabMaxWidth);
    }
    else
    {
      mMaxTabWidth = -1;
    }
    i = View.MeasureSpec.makeMeasureSpec(mContentHeight, 1073741824);
    if ((bool) || (!mAllowCollapse)) {
      paramInt2 = 0;
    }
    if (paramInt2 != 0)
    {
      mTabLayout.measure(0, i);
      if (mTabLayout.getMeasuredWidth() > View.MeasureSpec.getSize(paramInt1)) {
        performCollapse();
      } else {
        performExpand();
      }
    }
    else
    {
      performExpand();
    }
    paramInt2 = getMeasuredWidth();
    super.onMeasure(paramInt1, i);
    paramInt1 = getMeasuredWidth();
    if ((bool) && (paramInt2 != paramInt1)) {
      setTabSelected(mSelectedTabIndex);
    }
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    mAllowCollapse = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    mContentHeight = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt)
  {
    mSelectedTabIndex = paramInt;
    int j = mTabLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = mTabLayout.getChildAt(i);
      boolean bool;
      if (i == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      ((View)localObject).setSelected(bool);
      if (bool) {
        animateToTab(paramInt);
      }
      i += 1;
    }
    Object localObject = mTabSpinner;
    if ((localObject != null) && (paramInt >= 0)) {
      ((AbsSpinner)localObject).setSelection(paramInt);
    }
  }
}
