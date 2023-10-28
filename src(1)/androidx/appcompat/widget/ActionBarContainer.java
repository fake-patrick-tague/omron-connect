package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import v7.internal.R.id;
import v7.internal.R.styleable;
import v7.v7.package_13.ViewCompat;

public class ActionBarContainer
  extends FrameLayout
{
  private View mActionBarView;
  Drawable mBackground;
  private View mContextView;
  private int mHeight;
  boolean mIsSplit;
  boolean mIsStacked;
  private boolean mIsTransitioning;
  Drawable mSplitBackground;
  Drawable mStackedBackground;
  private View mTabContainer;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ViewCompat.setBackgroundDrawable(this, new CircularBorderDrawable(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar);
    mBackground = paramContext.getDrawable(R.styleable.ActionBar_background);
    mStackedBackground = paramContext.getDrawable(R.styleable.ActionBar_backgroundStacked);
    mHeight = paramContext.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
    int i = getId();
    int j = R.id.split_action_bar;
    boolean bool = true;
    if (i == j)
    {
      mIsSplit = true;
      mSplitBackground = paramContext.getDrawable(R.styleable.ActionBar_backgroundSplit);
    }
    paramContext.recycle();
    if (mIsSplit ? mSplitBackground == null : (mBackground != null) || (mStackedBackground != null)) {
      bool = false;
    }
    setWillNotDraw(bool);
  }
  
  private int getMeasuredHeightWithMargins(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    return paramView.getMeasuredHeight() + topMargin + bottomMargin;
  }
  
  private boolean isCollapsed(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = mBackground;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      mBackground.setState(getDrawableState());
    }
    localDrawable = mStackedBackground;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      mStackedBackground.setState(getDrawableState());
    }
    localDrawable = mSplitBackground;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      mSplitBackground.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return mTabContainer;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = mBackground;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = mStackedBackground;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = mSplitBackground;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    mActionBarView = findViewById(R.id.action_bar);
    mContextView = findViewById(R.id.action_context_bar);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (mIsTransitioning) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1 = mTabContainer;
    paramInt4 = 1;
    int i = 0;
    paramInt2 = 0;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    Object localObject2;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8))
    {
      int j = getMeasuredHeight();
      localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      int k = ((View)localObject1).getMeasuredHeight();
      int m = bottomMargin;
      ((View)localObject1).layout(paramInt1, j - k - m, paramInt3, j - m);
    }
    if (mIsSplit)
    {
      localObject1 = mSplitBackground;
      paramInt1 = paramInt2;
      if (localObject1 != null)
      {
        ((Drawable)localObject1).setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        paramInt1 = paramInt4;
        break label337;
      }
    }
    for (;;)
    {
      break;
      paramInt2 = i;
      if (mBackground != null)
      {
        if (mActionBarView.getVisibility() == 0)
        {
          mBackground.setBounds(mActionBarView.getLeft(), mActionBarView.getTop(), mActionBarView.getRight(), mActionBarView.getBottom());
        }
        else
        {
          localObject2 = mContextView;
          if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0)) {
            mBackground.setBounds(mContextView.getLeft(), mContextView.getTop(), mContextView.getRight(), mContextView.getBottom());
          } else {
            mBackground.setBounds(0, 0, 0, 0);
          }
        }
        paramInt2 = 1;
      }
      mIsStacked = paramBoolean;
      paramInt1 = paramInt2;
      if (paramBoolean)
      {
        localObject2 = mStackedBackground;
        paramInt1 = paramInt2;
        if (localObject2 != null)
        {
          ((Drawable)localObject2).setBounds(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom());
          paramInt1 = paramInt4;
        }
      }
    }
    label337:
    if (paramInt1 != 0) {
      invalidate();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (mActionBarView == null)
    {
      i = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE)
      {
        int j = mHeight;
        i = paramInt2;
        if (j >= 0) {
          i = View.MeasureSpec.makeMeasureSpec(Math.min(j, View.MeasureSpec.getSize(paramInt2)), Integer.MIN_VALUE);
        }
      }
    }
    super.onMeasure(paramInt1, i);
    if (mActionBarView == null) {
      return;
    }
    paramInt2 = View.MeasureSpec.getMode(i);
    View localView = mTabContainer;
    if ((localView != null) && (localView.getVisibility() != 8) && (paramInt2 != 1073741824))
    {
      if (!isCollapsed(mActionBarView)) {
        paramInt1 = getMeasuredHeightWithMargins(mActionBarView);
      } else if (!isCollapsed(mContextView)) {
        paramInt1 = getMeasuredHeightWithMargins(mContextView);
      } else {
        paramInt1 = 0;
      }
      if (paramInt2 == Integer.MIN_VALUE) {
        paramInt2 = View.MeasureSpec.getSize(i);
      } else {
        paramInt2 = Integer.MAX_VALUE;
      }
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + getMeasuredHeightWithMargins(mTabContainer), paramInt2));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = mBackground;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(mBackground);
    }
    mBackground = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      paramDrawable = mActionBarView;
      if (paramDrawable != null) {
        mBackground.setBounds(paramDrawable.getLeft(), mActionBarView.getTop(), mActionBarView.getRight(), mActionBarView.getBottom());
      }
    }
    boolean bool2 = mIsSplit;
    boolean bool1 = true;
    if (bool2 ? mSplitBackground == null : (mBackground != null) || (mStackedBackground != null)) {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    invalidate();
    if (Build.VERSION.SDK_INT >= 21) {
      a.setCallback(this);
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = mSplitBackground;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(mSplitBackground);
    }
    mSplitBackground = paramDrawable;
    boolean bool2 = false;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (mIsSplit)
      {
        paramDrawable = mSplitBackground;
        if (paramDrawable != null) {
          paramDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
      }
    }
    boolean bool1;
    if (mIsSplit)
    {
      bool1 = bool2;
      if (mSplitBackground != null) {}
    }
    else
    {
      do
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (mBackground != null) {
          break;
        }
        bool1 = bool2;
      } while (mStackedBackground == null);
    }
    setWillNotDraw(bool1);
    invalidate();
    if (Build.VERSION.SDK_INT >= 21) {
      a.setCallback(this);
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = mStackedBackground;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(mStackedBackground);
    }
    mStackedBackground = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (mIsStacked)
      {
        paramDrawable = mStackedBackground;
        if (paramDrawable != null) {
          paramDrawable.setBounds(mTabContainer.getLeft(), mTabContainer.getTop(), mTabContainer.getRight(), mTabContainer.getBottom());
        }
      }
    }
    boolean bool2 = mIsSplit;
    boolean bool1 = true;
    if (bool2 ? mSplitBackground == null : (mBackground != null) || (mStackedBackground != null)) {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    invalidate();
    if (Build.VERSION.SDK_INT >= 21) {
      a.setCallback(this);
    }
  }
  
  public void setTabContainer(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    Object localObject = mTabContainer;
    if (localObject != null) {
      removeView((View)localObject);
    }
    mTabContainer = paramScrollingTabContainerView;
    if (paramScrollingTabContainerView != null)
    {
      addView(paramScrollingTabContainerView);
      localObject = paramScrollingTabContainerView.getLayoutParams();
      width = -1;
      height = -2;
      paramScrollingTabContainerView.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    mIsTransitioning = paramBoolean;
    int i;
    if (paramBoolean) {
      i = 393216;
    } else {
      i = 262144;
    }
    setDescendantFocusability(i);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = mBackground;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
    localDrawable = mStackedBackground;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
    localDrawable = mSplitBackground;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt)
  {
    if (paramInt != 0) {
      return super.startActionModeForChild(paramView, paramCallback, paramInt);
    }
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable == mBackground) && (!mIsSplit)) || ((paramDrawable == mStackedBackground) && (mIsStacked)) || ((paramDrawable == mSplitBackground) && (mIsSplit)) || (super.verifyDrawable(paramDrawable));
  }
  
  private static class a
  {
    public static void setCallback(ActionBarContainer paramActionBarContainer)
    {
      paramActionBarContainer.invalidateOutline();
    }
  }
}
