package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

public abstract class OrientationHelper
{
  final Rect mHeight = new Rect();
  private int mLastTotalSpace = Integer.MIN_VALUE;
  protected final RecyclerView.o mLayoutManager;
  
  private OrientationHelper(RecyclerView.o paramO)
  {
    mLayoutManager = paramO;
  }
  
  public static OrientationHelper createOrientationHelper(RecyclerView.o paramO, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return valueOf(paramO);
      }
      throw new IllegalArgumentException("invalid orientation");
    }
    return read(paramO);
  }
  
  public static OrientationHelper read(RecyclerView.o paramO)
  {
    return new OrientationHelper.1(paramO);
  }
  
  public static OrientationHelper valueOf(RecyclerView.o paramO)
  {
    return new OrientationHelper.2(paramO);
  }
  
  public abstract int getDecoratedEnd(View paramView);
  
  public abstract int getDecoratedMeasurement(View paramView);
  
  public abstract int getDecoratedMeasurementInOther(View paramView);
  
  public abstract int getDecoratedStart(View paramView);
  
  public abstract int getEnd();
  
  public abstract int getEnd(View paramView);
  
  public abstract int getEndAfterPadding();
  
  public abstract int getEndPadding();
  
  public abstract int getMode();
  
  public abstract int getModeInOther();
  
  public abstract int getStartAfterPadding();
  
  public abstract int getTotalSpace();
  
  public abstract int getTotalSpace(View paramView);
  
  public int getTotalSpaceChange()
  {
    if (Integer.MIN_VALUE == mLastTotalSpace) {
      return 0;
    }
    return getTotalSpace() - mLastTotalSpace;
  }
  
  public abstract void offsetChildren(int paramInt);
  
  public void onLayoutComplete()
  {
    mLastTotalSpace = getTotalSpace();
  }
}
