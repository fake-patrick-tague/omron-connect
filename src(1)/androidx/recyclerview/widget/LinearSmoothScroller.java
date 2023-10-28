package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class LinearSmoothScroller
  extends RecyclerView.x
{
  private boolean active = false;
  protected final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
  protected int mInterimTargetDx = 0;
  protected int mInterimTargetDy = 0;
  protected final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
  protected PointF mTargetVector;
  private float speed;
  private final DisplayMetrics volume;
  
  public LinearSmoothScroller(Context paramContext)
  {
    volume = paramContext.getResources().getDisplayMetrics();
  }
  
  private int clampApplyScroll(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 - paramInt2;
    if (paramInt1 * paramInt2 <= 0) {
      return 0;
    }
    return paramInt2;
  }
  
  private float onStop()
  {
    if (!active)
    {
      speed = calculateSpeedPerPixel(volume);
      active = true;
    }
    return speed;
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 != -1)
    {
      if (paramInt5 != 0)
      {
        if (paramInt5 == 1) {
          return paramInt4 - paramInt2;
        }
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
      }
      paramInt1 = paramInt3 - paramInt1;
      if (paramInt1 > 0) {
        return paramInt1;
      }
      paramInt1 = paramInt4 - paramInt2;
      if (paramInt1 < 0) {
        return paramInt1;
      }
      return 0;
    }
    return paramInt3 - paramInt1;
  }
  
  public int calculateDxToMakeVisible(View paramView, int paramInt)
  {
    RecyclerView.o localO = getLayoutManager();
    if ((localO != null) && (localO.canScrollHorizontally()))
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return calculateDtToFit(localO.getDecoratedLeft(paramView) - leftMargin, localO.getDecoratedRight(paramView) + rightMargin, localO.getPaddingLeft(), localO.getWidth() - localO.getPaddingRight(), paramInt);
    }
    return 0;
  }
  
  public int calculateDyToMakeVisible(View paramView, int paramInt)
  {
    RecyclerView.o localO = getLayoutManager();
    if ((localO != null) && (localO.canScrollVertically()))
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return calculateDtToFit(localO.getDecoratedTop(paramView) - topMargin, localO.getDecoratedBottom(paramView) + bottomMargin, localO.getPaddingTop(), localO.getHeight() - localO.getPaddingBottom(), paramInt);
    }
    return 0;
  }
  
  protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / densityDpi;
  }
  
  protected int calculateTimeForDeceleration(int paramInt)
  {
    return (int)Math.ceil(calculateTimeForScrolling(paramInt) / 0.3356D);
  }
  
  protected int calculateTimeForScrolling(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * onStop());
  }
  
  protected int getHorizontalSnapPreference()
  {
    PointF localPointF = mTargetVector;
    if (localPointF != null)
    {
      float f = x;
      if (f != 0.0F)
      {
        if (f > 0.0F) {
          return 1;
        }
        return -1;
      }
    }
    return 0;
  }
  
  protected int getVerticalSnapPreference()
  {
    PointF localPointF = mTargetVector;
    if (localPointF != null)
    {
      float f = y;
      if (f != 0.0F)
      {
        if (f > 0.0F) {
          return 1;
        }
        return -1;
      }
    }
    return 0;
  }
  
  protected void onSeekTargetStep(int paramInt1, int paramInt2, RecyclerView.y paramY, RecyclerView.x.a paramA)
  {
    if (getChildCount() == 0)
    {
      e();
      return;
    }
    mInterimTargetDx = clampApplyScroll(mInterimTargetDx, paramInt1);
    paramInt1 = clampApplyScroll(mInterimTargetDy, paramInt2);
    mInterimTargetDy = paramInt1;
    if ((mInterimTargetDx == 0) && (paramInt1 == 0)) {
      updateActionForInterimTarget(paramA);
    }
  }
  
  protected void onStart() {}
  
  protected void onTargetFound(View paramView, RecyclerView.y paramY, RecyclerView.x.a paramA)
  {
    int i = calculateDxToMakeVisible(paramView, getHorizontalSnapPreference());
    int j = calculateDyToMakeVisible(paramView, getVerticalSnapPreference());
    int k = calculateTimeForDeceleration((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      paramA.update(-i, -j, k, mDecelerateInterpolator);
    }
  }
  
  protected void updateActionForInterimTarget()
  {
    mInterimTargetDy = 0;
    mInterimTargetDx = 0;
    mTargetVector = null;
  }
  
  protected void updateActionForInterimTarget(RecyclerView.x.a paramA)
  {
    PointF localPointF = a(intValue());
    if ((localPointF != null) && ((x != 0.0F) || (y != 0.0F)))
    {
      normalize(localPointF);
      mTargetVector = localPointF;
      mInterimTargetDx = ((int)(x * 10000.0F));
      mInterimTargetDy = ((int)(y * 10000.0F));
      int i = calculateTimeForScrolling(10000);
      paramA.update((int)(mInterimTargetDx * 1.2F), (int)(mInterimTargetDy * 1.2F), (int)(i * 1.2F), mLinearInterpolator);
      return;
    }
    paramA.jumpTo(intValue());
    e();
  }
}
