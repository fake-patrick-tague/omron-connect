package androidx.recyclerview.widget;

import android.view.View;

class LayoutState
{
  int mAvailable;
  int mCurrentPosition;
  int mEndLine = 0;
  boolean mInfinite;
  int mItemDirection;
  int mLayoutDirection;
  boolean mRecycle = true;
  int mStartLine = 0;
  boolean mStopInFocusable;
  
  LayoutState() {}
  
  boolean hasMore(RecyclerView.y paramY)
  {
    int i = mCurrentPosition;
    return (i >= 0) && (i < paramY.getItemCount());
  }
  
  View next(RecyclerView.u paramU)
  {
    paramU = paramU.getViewForPosition(mCurrentPosition);
    mCurrentPosition += mItemDirection;
    return paramU;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LayoutState{mAvailable=");
    localStringBuilder.append(mAvailable);
    localStringBuilder.append(", mCurrentPosition=");
    localStringBuilder.append(mCurrentPosition);
    localStringBuilder.append(", mItemDirection=");
    localStringBuilder.append(mItemDirection);
    localStringBuilder.append(", mLayoutDirection=");
    localStringBuilder.append(mLayoutDirection);
    localStringBuilder.append(", mStartLine=");
    localStringBuilder.append(mStartLine);
    localStringBuilder.append(", mEndLine=");
    localStringBuilder.append(mEndLine);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
