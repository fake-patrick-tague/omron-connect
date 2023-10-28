package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.o
  implements ItemTouchHelper.ViewDropHandler, RecyclerView.x.b
{
  final a mAnchorInfo = new a();
  private int mGapStrategy = 2;
  private boolean mLastStackFromEnd;
  private c mLayoutState;
  private final b mLazySpanLookup = new b();
  private int[] mOffset = new int[2];
  int mOrientation = 1;
  OrientationHelper mOrientationHelper;
  SavedState mPendingSavedState = null;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  private boolean mRecycleChildrenOnDetach;
  private boolean mReverseLayout = false;
  boolean mShouldReverseLayout = false;
  private boolean mSmoothScrollbarEnabled = true;
  private boolean mStackFromEnd = false;
  
  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = RecyclerView.o.getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(orientation);
    setReverseLayout(reverseLayout);
    setStackFromEnd(stackFromEnd);
  }
  
  private int computeScrollExtent(RecyclerView.y paramY)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollExtent(paramY, mOrientationHelper, findFirstVisibleChildClosestToEnd(mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToStart(mSmoothScrollbarEnabled ^ true, true), this, mSmoothScrollbarEnabled);
  }
  
  private int computeScrollOffset(RecyclerView.y paramY)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollOffset(paramY, mOrientationHelper, findFirstVisibleChildClosestToEnd(mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToStart(mSmoothScrollbarEnabled ^ true, true), this, mSmoothScrollbarEnabled, mShouldReverseLayout);
  }
  
  private int computeScrollRange(RecyclerView.y paramY)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollRange(paramY, mOrientationHelper, findFirstVisibleChildClosestToEnd(mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToStart(mSmoothScrollbarEnabled ^ true, true), this, mSmoothScrollbarEnabled);
  }
  
  private View findFirstReferenceChild()
  {
    return findReferenceChild(0, getChildCount());
  }
  
  private View findLastReferenceChild()
  {
    return findReferenceChild(getChildCount() - 1, -1);
  }
  
  private View findReferenceChildClosestToEnd()
  {
    if (mShouldReverseLayout) {
      return findLastReferenceChild();
    }
    return findFirstReferenceChild();
  }
  
  private View findReferenceChildClosestToStart()
  {
    if (mShouldReverseLayout) {
      return findFirstReferenceChild();
    }
    return findLastReferenceChild();
  }
  
  private int fixLayoutEndGap(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY, boolean paramBoolean)
  {
    int i = mOrientationHelper.getEndAfterPadding() - paramInt;
    if (i > 0)
    {
      i = -scrollBy(-i, paramU, paramY);
      if (paramBoolean)
      {
        paramInt = mOrientationHelper.getEndAfterPadding() - (paramInt + i);
        if (paramInt > 0)
        {
          mOrientationHelper.offsetChildren(paramInt);
          return paramInt + i;
        }
      }
      else
      {
        return i;
      }
    }
    else
    {
      return 0;
    }
    return i;
  }
  
  private int fixLayoutStartGap(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY, boolean paramBoolean)
  {
    int i = paramInt - mOrientationHelper.getStartAfterPadding();
    if (i > 0)
    {
      i = -scrollBy(i, paramU, paramY);
      if (paramBoolean)
      {
        paramInt = paramInt + i - mOrientationHelper.getStartAfterPadding();
        if (paramInt > 0)
        {
          mOrientationHelper.offsetChildren(-paramInt);
          return i - paramInt;
        }
      }
    }
    else
    {
      return 0;
    }
    return i;
  }
  
  private View getChildClosestToEnd()
  {
    int i;
    if (mShouldReverseLayout) {
      i = 0;
    } else {
      i = getChildCount() - 1;
    }
    return getChildAt(i);
  }
  
  private View getChildClosestToStart()
  {
    int i;
    if (mShouldReverseLayout) {
      i = getChildCount() - 1;
    } else {
      i = 0;
    }
    return getChildAt(i);
  }
  
  private void layoutForPredictiveAnimations(RecyclerView.u paramU, RecyclerView.y paramY, int paramInt1, int paramInt2)
  {
    if ((paramY.willRunPredictiveAnimations()) && (getChildCount() != 0) && (!paramY.isPreLayout()))
    {
      if (!supportsPredictiveItemAnimations()) {
        return;
      }
      Object localObject = paramU.getScrapList();
      int n = ((List)localObject).size();
      int i1 = getPosition(getChildAt(0));
      int i = 0;
      int j = 0;
      int k = 0;
      while (i < n)
      {
        RecyclerView.b0 localB0 = (RecyclerView.b0)((List)localObject).get(i);
        if (!localB0.isRemoved())
        {
          int i2 = localB0.getLayoutPosition();
          int m = 1;
          int i3;
          if (i2 < i1) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          if (i3 != mShouldReverseLayout) {
            m = -1;
          }
          if (m == -1) {
            j += mOrientationHelper.getDecoratedMeasurement(itemView);
          } else {
            k += mOrientationHelper.getDecoratedMeasurement(itemView);
          }
        }
        i += 1;
      }
      mLayoutState.mScrapList = ((List)localObject);
      if (j > 0)
      {
        updateLayoutStateToFillEnd(getPosition(getChildClosestToStart()), paramInt1);
        localObject = mLayoutState;
        mExtra = j;
        mAvailable = 0;
        ((c)localObject).assignPositionFromScrapList();
        fill(paramU, mLayoutState, paramY, false);
      }
      if (k > 0)
      {
        updateLayoutStateToFillStart(getPosition(getChildClosestToEnd()), paramInt2);
        localObject = mLayoutState;
        mExtra = k;
        mAvailable = 0;
        ((c)localObject).assignPositionFromScrapList();
        fill(paramU, mLayoutState, paramY, false);
      }
      mLayoutState.mScrapList = null;
    }
  }
  
  private void onLayoutChildren(RecyclerView.u paramU, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return;
    }
    int i = paramInt1 - paramInt2;
    paramInt2 = getChildCount();
    View localView;
    if (mShouldReverseLayout)
    {
      paramInt2 -= 1;
      paramInt1 = paramInt2;
      for (;;)
      {
        if (paramInt1 < 0) {
          return;
        }
        localView = getChildAt(paramInt1);
        if ((mOrientationHelper.getDecoratedEnd(localView) > i) || (mOrientationHelper.getTotalSpace(localView) > i)) {
          break;
        }
        paramInt1 -= 1;
      }
      recycleChildren(paramU, paramInt2, paramInt1);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localView = getChildAt(paramInt1);
      if ((mOrientationHelper.getDecoratedEnd(localView) <= i) && (mOrientationHelper.getTotalSpace(localView) <= i)) {
        paramInt1 += 1;
      } else {
        recycleChildren(paramU, 0, paramInt1);
      }
    }
  }
  
  private void recycleByLayoutState(RecyclerView.u paramU, c paramC)
  {
    if (mRecycle)
    {
      if (mInfinite) {
        return;
      }
      int i = mScrollingOffset;
      int j = mShouldReverseLayout;
      if (mLayoutDirection == -1)
      {
        recycleViewsFromEnd(paramU, i, j);
        return;
      }
      onLayoutChildren(paramU, i, j);
    }
  }
  
  private void recycleChildren(RecyclerView.u paramU, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int i = paramInt1;
    if (paramInt2 > paramInt1)
    {
      paramInt2 -= 1;
      while (paramInt2 >= paramInt1)
      {
        removeAndRecycleViewAt(paramInt2, paramU);
        paramInt2 -= 1;
      }
    }
    while (i > paramInt2)
    {
      removeAndRecycleViewAt(i, paramU);
      i -= 1;
    }
  }
  
  private void recycleViewsFromEnd(RecyclerView.u paramU, int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    if (paramInt1 < 0) {
      return;
    }
    int i = mOrientationHelper.getEnd() - paramInt1 + paramInt2;
    View localView;
    if (mShouldReverseLayout)
    {
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= j) {
          return;
        }
        localView = getChildAt(paramInt1);
        if ((mOrientationHelper.getDecoratedStart(localView) < i) || (mOrientationHelper.getEnd(localView) < i)) {
          break;
        }
        paramInt1 += 1;
      }
      recycleChildren(paramU, 0, paramInt1);
      return;
    }
    paramInt2 = j - 1;
    paramInt1 = paramInt2;
    while (paramInt1 >= 0)
    {
      localView = getChildAt(paramInt1);
      if ((mOrientationHelper.getDecoratedStart(localView) >= i) && (mOrientationHelper.getEnd(localView) >= i)) {
        paramInt1 -= 1;
      } else {
        recycleChildren(paramU, paramInt2, paramInt1);
      }
    }
  }
  
  private void resolveShouldLayoutReverse()
  {
    if ((mOrientation != 1) && (isLayoutRTL()))
    {
      mShouldReverseLayout = (mReverseLayout ^ true);
      return;
    }
    mShouldReverseLayout = mReverseLayout;
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.u paramU, RecyclerView.y paramY, a paramA)
  {
    int i = getChildCount();
    int n = 0;
    if (i == 0) {
      return false;
    }
    View localView = getFocusedChild();
    if ((localView != null) && (paramA.assignFromViewIfValid(localView, paramY)))
    {
      paramA.assignFromViewAndKeepVisibleRect(localView, getPosition(localView));
      return true;
    }
    boolean bool1 = mLastStackFromEnd;
    boolean bool2 = mStackFromEnd;
    if (bool1 != bool2) {
      return false;
    }
    paramU = findReferenceChild(paramU, paramY, mLayoutFromEnd, bool2);
    if (paramU != null)
    {
      paramA.assignFromView(paramU, getPosition(paramU));
      if ((!paramY.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        int i1 = mOrientationHelper.getDecoratedStart(paramU);
        int i2 = mOrientationHelper.getDecoratedEnd(paramU);
        int j = mOrientationHelper.getStartAfterPadding();
        i = j;
        int m = mOrientationHelper.getEndAfterPadding();
        if ((i2 <= j) && (i1 < j)) {
          j = 1;
        } else {
          j = 0;
        }
        int k = n;
        if (i1 >= m)
        {
          k = n;
          if (i2 > m) {
            k = 1;
          }
        }
        if ((j != 0) || (k != 0))
        {
          if (mLayoutFromEnd) {
            i = m;
          }
          mCoordinate = i;
          return true;
        }
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  private boolean updateAnchorFromPendingData(RecyclerView.y paramY, a paramA)
  {
    boolean bool1 = paramY.isPreLayout();
    boolean bool2 = false;
    if (!bool1)
    {
      int i = mPendingScrollPosition;
      if (i == -1) {
        return false;
      }
      if ((i >= 0) && (i < paramY.getItemCount()))
      {
        mPosition = mPendingScrollPosition;
        paramY = mPendingSavedState;
        if ((paramY != null) && (paramY.hasValidAnchor()))
        {
          bool1 = mPendingSavedState.mAnchorLayoutFromEnd;
          mLayoutFromEnd = bool1;
          if (bool1)
          {
            mCoordinate = (mOrientationHelper.getEndAfterPadding() - mPendingSavedState.mAnchorOffset);
            return true;
          }
          mCoordinate = (mOrientationHelper.getStartAfterPadding() + mPendingSavedState.mAnchorOffset);
          return true;
        }
        if (mPendingScrollPositionOffset == Integer.MIN_VALUE)
        {
          paramY = findViewByPosition(mPendingScrollPosition);
          if (paramY != null)
          {
            if (mOrientationHelper.getDecoratedMeasurement(paramY) > mOrientationHelper.getTotalSpace())
            {
              paramA.assignCoordinateFromPadding();
              return true;
            }
            if (mOrientationHelper.getDecoratedStart(paramY) - mOrientationHelper.getStartAfterPadding() < 0)
            {
              mCoordinate = mOrientationHelper.getStartAfterPadding();
              mLayoutFromEnd = false;
              return true;
            }
            if (mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd(paramY) < 0)
            {
              mCoordinate = mOrientationHelper.getEndAfterPadding();
              mLayoutFromEnd = true;
              return true;
            }
            if (mLayoutFromEnd) {
              i = mOrientationHelper.getDecoratedEnd(paramY) + mOrientationHelper.getTotalSpaceChange();
            } else {
              i = mOrientationHelper.getDecoratedStart(paramY);
            }
            mCoordinate = i;
            return true;
          }
          if (getChildCount() > 0)
          {
            i = getPosition(getChildAt(0));
            if (mPendingScrollPosition < i) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (bool1 == mShouldReverseLayout) {
              bool2 = true;
            }
            mLayoutFromEnd = bool2;
          }
          paramA.assignCoordinateFromPadding();
          return true;
        }
        bool1 = mShouldReverseLayout;
        mLayoutFromEnd = bool1;
        if (bool1)
        {
          mCoordinate = (mOrientationHelper.getEndAfterPadding() - mPendingScrollPositionOffset);
          return true;
        }
        mCoordinate = (mOrientationHelper.getStartAfterPadding() + mPendingScrollPositionOffset);
        return true;
      }
      mPendingScrollPosition = -1;
      mPendingScrollPositionOffset = Integer.MIN_VALUE;
    }
    return false;
  }
  
  private void updateAnchorInfoForLayout(RecyclerView.u paramU, RecyclerView.y paramY, a paramA)
  {
    if (updateAnchorFromPendingData(paramY, paramA)) {
      return;
    }
    if (updateAnchorFromChildren(paramU, paramY, paramA)) {
      return;
    }
    paramA.assignCoordinateFromPadding();
    int i;
    if (mStackFromEnd) {
      i = paramY.getItemCount() - 1;
    } else {
      i = 0;
    }
    mPosition = i;
  }
  
  private void updateLayoutState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.y paramY)
  {
    mLayoutState.mInfinite = resolveIsInfinite();
    mLayoutState.mLayoutDirection = paramInt1;
    Object localObject = mOffset;
    int k = 0;
    localObject[0] = 0;
    int i1 = 1;
    int n = 1;
    localObject[1] = 0;
    onLayoutChildren(paramY, (int[])localObject);
    int m = Math.max(0, mOffset[0]);
    int i = m;
    int j = Math.max(0, mOffset[1]);
    if (paramInt1 == 1) {
      k = 1;
    }
    paramY = mLayoutState;
    if (k != 0) {
      paramInt1 = j;
    } else {
      paramInt1 = m;
    }
    mExtra = paramInt1;
    if (k == 0) {
      i = j;
    }
    mShouldReverseLayout = i;
    c localC;
    if (k != 0)
    {
      mExtra = (paramInt1 + mOrientationHelper.getEndPadding());
      paramY = getChildClosestToEnd();
      localObject = mLayoutState;
      paramInt1 = n;
      if (mShouldReverseLayout) {
        paramInt1 = -1;
      }
      mItemDirection = paramInt1;
      paramInt1 = getPosition(paramY);
      localC = mLayoutState;
      mCurrentPosition = (paramInt1 + mItemDirection);
      mOffset = mOrientationHelper.getDecoratedEnd(paramY);
      paramInt1 = mOrientationHelper.getDecoratedEnd(paramY) - mOrientationHelper.getEndAfterPadding();
    }
    else
    {
      paramY = getChildClosestToStart();
      localObject = mLayoutState;
      mExtra += mOrientationHelper.getStartAfterPadding();
      localObject = mLayoutState;
      if (mShouldReverseLayout) {
        paramInt1 = i1;
      } else {
        paramInt1 = -1;
      }
      mItemDirection = paramInt1;
      paramInt1 = getPosition(paramY);
      localC = mLayoutState;
      mCurrentPosition = (paramInt1 + mItemDirection);
      mOffset = mOrientationHelper.getDecoratedStart(paramY);
      paramInt1 = -mOrientationHelper.getDecoratedStart(paramY) + mOrientationHelper.getStartAfterPadding();
    }
    paramY = mLayoutState;
    mAvailable = paramInt2;
    if (paramBoolean) {
      mAvailable = (paramInt2 - paramInt1);
    }
    mScrollingOffset = paramInt1;
  }
  
  private void updateLayoutStateToFillEnd(int paramInt1, int paramInt2)
  {
    mLayoutState.mAvailable = (paramInt2 - mOrientationHelper.getStartAfterPadding());
    c localC = mLayoutState;
    mCurrentPosition = paramInt1;
    if (mShouldReverseLayout) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    }
    mItemDirection = paramInt1;
    mLayoutDirection = -1;
    mOffset = paramInt2;
    mScrollingOffset = Integer.MIN_VALUE;
  }
  
  private void updateLayoutStateToFillEnd(a paramA)
  {
    updateLayoutStateToFillEnd(mPosition, mCoordinate);
  }
  
  private void updateLayoutStateToFillStart(int paramInt1, int paramInt2)
  {
    mLayoutState.mAvailable = (mOrientationHelper.getEndAfterPadding() - paramInt2);
    c localC = mLayoutState;
    int i;
    if (mShouldReverseLayout) {
      i = -1;
    } else {
      i = 1;
    }
    mItemDirection = i;
    mCurrentPosition = paramInt1;
    mLayoutDirection = 1;
    mOffset = paramInt2;
    mScrollingOffset = Integer.MIN_VALUE;
  }
  
  private void updateLayoutStateToFillStart(a paramA)
  {
    updateLayoutStateToFillStart(mPosition, mCoordinate);
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (mPendingSavedState == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  public boolean canScrollHorizontally()
  {
    return mOrientation == 0;
  }
  
  public boolean canScrollVertically()
  {
    return mOrientation == 1;
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.y paramY)
  {
    return computeScrollExtent(paramY);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.y paramY)
  {
    return computeScrollOffset(paramY);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.y paramY)
  {
    return computeScrollRange(paramY);
  }
  
  public boolean computeScrollOffset()
  {
    return mSmoothScrollbarEnabled;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.y paramY)
  {
    return computeScrollExtent(paramY);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.y paramY)
  {
    return computeScrollOffset(paramY);
  }
  
  public int computeVerticalScrollRange(RecyclerView.y paramY)
  {
    return computeScrollRange(paramY);
  }
  
  c createLayoutState()
  {
    return new c();
  }
  
  void ensureLayoutState()
  {
    if (mLayoutState == null) {
      mLayoutState = createLayoutState();
    }
  }
  
  int fill(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 17)
        {
          if (paramInt != 33)
          {
            if (paramInt != 66)
            {
              if (paramInt != 130) {
                return Integer.MIN_VALUE;
              }
              if (mOrientation == 1) {
                return 1;
              }
              return Integer.MIN_VALUE;
            }
            if (mOrientation == 0) {
              return 1;
            }
            return Integer.MIN_VALUE;
          }
          if (mOrientation == 1) {
            return -1;
          }
          return Integer.MIN_VALUE;
        }
        if (mOrientation == 0) {
          return -1;
        }
        return Integer.MIN_VALUE;
      }
      if (mOrientation == 1) {
        return 1;
      }
      if (isLayoutRTL()) {
        return -1;
      }
      return 1;
    }
    if (mOrientation == 1) {
      return -1;
    }
    if (isLayoutRTL()) {
      return 1;
    }
    return -1;
  }
  
  int fill(RecyclerView.u paramU, c paramC, RecyclerView.y paramY, boolean paramBoolean)
  {
    int k = mAvailable;
    int i = mScrollingOffset;
    if (i != Integer.MIN_VALUE)
    {
      if (k < 0) {
        mScrollingOffset = (i + k);
      }
      recycleByLayoutState(paramU, paramC);
    }
    int j = mAvailable + mExtra;
    b localB = mLazySpanLookup;
    do
    {
      do
      {
        if (((!mInfinite) && (j <= 0)) || (!paramC.hasMore(paramY))) {
          break;
        }
        localB.resetInternal();
        layoutChunk(paramU, paramY, paramC, localB);
        if (mFinished) {
          break;
        }
        mOffset += mConsumed * mLayoutDirection;
        int m;
        if ((mIgnoreConsumed) && (mScrapList == null))
        {
          i = j;
          if (paramY.isPreLayout()) {}
        }
        else
        {
          i = mAvailable;
          m = mConsumed;
          mAvailable = (i - m);
          i = j - m;
        }
        j = mScrollingOffset;
        if (j != Integer.MIN_VALUE)
        {
          j += mConsumed;
          mScrollingOffset = j;
          m = mAvailable;
          if (m < 0) {
            mScrollingOffset = (j + m);
          }
          recycleByLayoutState(paramU, paramC);
        }
        j = i;
      } while (!paramBoolean);
      j = i;
    } while (!mFocusable);
    return k - mAvailable;
  }
  
  public void fill(int paramInt1, int paramInt2, RecyclerView.y paramY, RecyclerView.o.c paramC)
  {
    if (mOrientation != 0) {
      paramInt1 = paramInt2;
    }
    if (getChildCount() != 0)
    {
      if (paramInt1 == 0) {
        return;
      }
      ensureLayoutState();
      if (paramInt1 > 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = -1;
      }
      updateLayoutState(paramInt2, Math.abs(paramInt1), true, paramY);
      fill(paramY, mLayoutState, paramC);
    }
  }
  
  void fill(RecyclerView.y paramY, c paramC, RecyclerView.o.c paramC1)
  {
    int i = mCurrentPosition;
    if ((i >= 0) && (i < paramY.getItemCount())) {
      paramC1.set(i, Math.max(0, mScrollingOffset));
    }
  }
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  View findFirstVisibleChildClosestToEnd(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mShouldReverseLayout) {
      return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
  }
  
  View findFirstVisibleChildClosestToStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mShouldReverseLayout) {
      return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  public int findFirstVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureLayoutState();
    int j = 320;
    int i;
    if (paramBoolean1) {
      i = 24579;
    } else {
      i = 320;
    }
    if (!paramBoolean2) {
      j = 0;
    }
    if (mOrientation == 0) {
      return c.a(paramInt1, paramInt2, i, j);
    }
    return d.a(paramInt1, paramInt2, i, j);
  }
  
  View findReferenceChild(int paramInt1, int paramInt2)
  {
    ensureLayoutState();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else if (paramInt2 < paramInt1) {
      i = -1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return getChildAt(paramInt1);
    }
    int j;
    if (mOrientationHelper.getDecoratedStart(getChildAt(paramInt1)) < mOrientationHelper.getStartAfterPadding())
    {
      i = 16644;
      j = 16388;
    }
    else
    {
      i = 4161;
      j = 4097;
    }
    if (mOrientation == 0) {
      return c.a(paramInt1, paramInt2, i, j);
    }
    return d.a(paramInt1, paramInt2, i, j);
  }
  
  View findReferenceChild(RecyclerView.u paramU, RecyclerView.y paramY, boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureLayoutState();
    int j = -1;
    int i;
    int k;
    if (paramBoolean2)
    {
      i = getChildCount() - 1;
      k = -1;
    }
    else
    {
      j = getChildCount();
      i = 0;
      k = 1;
    }
    int i1 = paramY.getItemCount();
    int i2 = mOrientationHelper.getStartAfterPadding();
    int i3 = mOrientationHelper.getEndAfterPadding();
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject5;
    for (paramY = null; i != j; paramY = (RecyclerView.y)localObject5)
    {
      paramU = getChildAt(i);
      int m = getPosition(paramU);
      int n = mOrientationHelper.getDecoratedStart(paramU);
      int i4 = mOrientationHelper.getDecoratedEnd(paramU);
      Object localObject3 = localObject2;
      Object localObject4 = localObject1;
      localObject5 = paramY;
      if (m >= 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        localObject5 = paramY;
        if (m < i1) {
          if (((RecyclerView.LayoutParams)paramU.getLayoutParams()).isItemRemoved())
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            localObject5 = paramY;
            if (paramY == null)
            {
              localObject3 = localObject2;
              localObject4 = localObject1;
              localObject5 = paramU;
            }
          }
          else
          {
            if ((i4 <= i2) && (n < i2)) {
              m = 1;
            } else {
              m = 0;
            }
            if ((n >= i3) && (i4 > i3)) {
              n = 1;
            } else {
              n = 0;
            }
            if ((m == 0) && (n == 0)) {
              return paramU;
            }
            if (paramBoolean1)
            {
              if (n == 0)
              {
                localObject3 = localObject2;
                localObject4 = localObject1;
                localObject5 = paramY;
                if (localObject2 != null) {
                  break label323;
                }
                break label313;
              }
            }
            else {
              if (m == 0) {
                break label297;
              }
            }
            localObject3 = localObject2;
            localObject4 = paramU;
            localObject5 = paramY;
            break label323;
            label297:
            localObject3 = localObject2;
            localObject4 = localObject1;
            localObject5 = paramY;
            if (localObject2 == null)
            {
              label313:
              localObject5 = paramY;
              localObject4 = localObject1;
              localObject3 = paramU;
            }
          }
        }
      }
      label323:
      i += k;
      localObject2 = localObject3;
      localObject1 = localObject4;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return paramY;
  }
  
  public View findViewByPosition(int paramInt)
  {
    int i = getChildCount();
    if (i == 0) {
      return null;
    }
    int j = paramInt - getPosition(getChildAt(0));
    if ((j >= 0) && (j < i))
    {
      View localView = getChildAt(j);
      if (getPosition(localView) == paramInt) {
        return localView;
      }
    }
    return super.findViewByPosition(paramInt);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  protected int getExtraLayoutSpace(RecyclerView.y paramY)
  {
    if (paramY.b()) {
      return mOrientationHelper.getTotalSpace();
    }
    return 0;
  }
  
  public int getOrientation()
  {
    return mOrientation;
  }
  
  public int getPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int getValue()
  {
    View localView = findOneVisibleChild(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  protected boolean isLayoutRTL()
  {
    return getLayoutDirection() == 1;
  }
  
  void layoutChunk(RecyclerView.u paramU, RecyclerView.y paramY, c paramC, b paramB)
  {
    paramU = paramC.next(paramU);
    if (paramU == null)
    {
      mFinished = true;
      return;
    }
    paramY = (RecyclerView.LayoutParams)paramU.getLayoutParams();
    boolean bool2;
    boolean bool1;
    if (mScrapList == null)
    {
      bool2 = mShouldReverseLayout;
      if (mLayoutDirection == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool2 == bool1) {
        addView(paramU);
      } else {
        addView(paramU, 0);
      }
    }
    else
    {
      bool2 = mShouldReverseLayout;
      if (mLayoutDirection == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool2 == bool1) {
        addDisappearingView(paramU);
      } else {
        addDisappearingView(paramU, 0);
      }
    }
    measureChildWithMargins(paramU, 0, 0);
    mConsumed = mOrientationHelper.getDecoratedMeasurement(paramU);
    int i;
    int m;
    int k;
    int j;
    if (mOrientation == 1)
    {
      if (isLayoutRTL())
      {
        i = getWidth() - getPaddingRight();
        m = i - mOrientationHelper.getDecoratedMeasurementInOther(paramU);
      }
      else
      {
        i = getPaddingLeft();
        m = i;
        i = mOrientationHelper.getDecoratedMeasurementInOther(paramU) + i;
      }
      if (mLayoutDirection == -1)
      {
        k = mOffset;
        j = k - mConsumed;
      }
      else
      {
        j = mOffset;
        k = mConsumed + j;
      }
    }
    else
    {
      j = getPaddingTop();
      i = mOrientationHelper.getDecoratedMeasurementInOther(paramU) + j;
      int n;
      if (mLayoutDirection == -1)
      {
        n = mOffset;
        m = mConsumed;
        k = i;
        m = n - m;
        i = n;
      }
      else
      {
        m = mOffset;
        k = mConsumed;
        n = k + m;
        k = i;
        i = n;
      }
    }
    measureChildWithDecorationsAndMargin(paramU, m, j, i, k);
    if ((paramY.isItemRemoved()) || (paramY.isItemChanged())) {
      mIgnoreConsumed = true;
    }
    mFocusable = paramU.hasFocusable();
  }
  
  void onAnchorReady(RecyclerView.u paramU, RecyclerView.y paramY, a paramA, int paramInt) {}
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    resolveShouldLayoutReverse();
    if (getChildCount() == 0) {
      return null;
    }
    paramInt = fill(paramInt);
    if (paramInt == Integer.MIN_VALUE) {
      return null;
    }
    ensureLayoutState();
    updateLayoutState(paramInt, (int)(mOrientationHelper.getTotalSpace() * 0.33333334F), false, paramY);
    paramView = mLayoutState;
    mScrollingOffset = Integer.MIN_VALUE;
    mRecycle = false;
    fill(paramU, paramView, paramY, true);
    if (paramInt == -1) {
      paramView = findReferenceChildClosestToEnd();
    } else {
      paramView = findReferenceChildClosestToStart();
    }
    if (paramInt == -1) {
      paramU = getChildClosestToStart();
    } else {
      paramU = getChildClosestToEnd();
    }
    if (paramU.hasFocusable())
    {
      if (paramView == null) {
        return null;
      }
      return paramU;
    }
    return paramView;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(getValue());
      paramAccessibilityEvent.setToIndex(getPosition());
    }
  }
  
  public void onLayoutChildren(int paramInt, RecyclerView.o.c paramC)
  {
    SavedState localSavedState = mPendingSavedState;
    int j = -1;
    boolean bool1;
    int i;
    if ((localSavedState != null) && (localSavedState.hasValidAnchor()))
    {
      localSavedState = mPendingSavedState;
      bool1 = mAnchorLayoutFromEnd;
      i = mAnchorPosition;
    }
    else
    {
      resolveShouldLayoutReverse();
      boolean bool2 = mShouldReverseLayout;
      k = mPendingScrollPosition;
      bool1 = bool2;
      i = k;
      if (k == -1) {
        if (bool2)
        {
          i = paramInt - 1;
          bool1 = bool2;
        }
        else
        {
          i = 0;
          bool1 = bool2;
        }
      }
    }
    if (!bool1) {
      j = 1;
    }
    int k = 0;
    while ((k < mGapStrategy) && (i >= 0) && (i < paramInt))
    {
      paramC.set(i, 0);
      i += j;
      k += 1;
    }
  }
  
  public void onLayoutChildren(RecyclerView.u paramU, RecyclerView.y paramY)
  {
    Object localObject = mPendingSavedState;
    int k = -1;
    if (((localObject != null) || (mPendingScrollPosition != -1)) && (paramY.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramU);
      return;
    }
    localObject = mPendingSavedState;
    if ((localObject != null) && (((SavedState)localObject).hasValidAnchor())) {
      mPendingScrollPosition = mPendingSavedState.mAnchorPosition;
    }
    ensureLayoutState();
    mLayoutState.mRecycle = false;
    resolveShouldLayoutReverse();
    localObject = getFocusedChild();
    a localA = mAnchorInfo;
    if ((mInPreLayout) && (mPendingScrollPosition == -1) && (mPendingSavedState == null))
    {
      if ((localObject != null) && ((mOrientationHelper.getDecoratedStart((View)localObject) >= mOrientationHelper.getEndAfterPadding()) || (mOrientationHelper.getDecoratedEnd((View)localObject) <= mOrientationHelper.getStartAfterPadding()))) {
        mAnchorInfo.assignFromViewAndKeepVisibleRect((View)localObject, getPosition((View)localObject));
      }
    }
    else
    {
      localA.reset();
      localObject = mAnchorInfo;
      mLayoutFromEnd = (mShouldReverseLayout ^ mStackFromEnd);
      updateAnchorInfoForLayout(paramU, paramY, (a)localObject);
      mAnchorInfo.mInPreLayout = true;
    }
    localObject = mLayoutState;
    if (mLastScrollDelta >= 0) {
      i = 1;
    } else {
      i = -1;
    }
    mLayoutDirection = i;
    localObject = mOffset;
    localObject[0] = 0;
    localObject[1] = 0;
    onLayoutChildren(paramY, (int[])localObject);
    int m = Math.max(0, mOffset[0]) + mOrientationHelper.getStartAfterPadding();
    int n = Math.max(0, mOffset[1]) + mOrientationHelper.getEndPadding();
    int i = m;
    int j = n;
    int i1;
    if (paramY.isPreLayout())
    {
      i1 = mPendingScrollPosition;
      i = m;
      j = n;
      if (i1 != -1)
      {
        i = m;
        j = n;
        if (mPendingScrollPositionOffset != Integer.MIN_VALUE)
        {
          localObject = findViewByPosition(i1);
          i = m;
          j = n;
          if (localObject != null)
          {
            if (mShouldReverseLayout)
            {
              i = mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd((View)localObject);
              j = mPendingScrollPositionOffset;
            }
            else
            {
              j = mOrientationHelper.getDecoratedStart((View)localObject) - mOrientationHelper.getStartAfterPadding();
              i = mPendingScrollPositionOffset;
            }
            i -= j;
            if (i > 0)
            {
              i = m + i;
              j = n;
            }
            else
            {
              j = n - i;
              i = m;
            }
          }
        }
      }
    }
    localObject = mAnchorInfo;
    if (mLayoutFromEnd)
    {
      if (!mShouldReverseLayout) {}
    }
    else {
      while (!mShouldReverseLayout)
      {
        k = 1;
        break;
      }
    }
    onAnchorReady(paramU, paramY, (a)localObject, k);
    detachAndScrapAttachedViews(paramU);
    mLayoutState.mInfinite = resolveIsInfinite();
    mLayoutState.mIsPreLayout = paramY.isPreLayout();
    mLayoutState.mShouldReverseLayout = 0;
    localObject = mAnchorInfo;
    if (mLayoutFromEnd)
    {
      updateLayoutStateToFillEnd((a)localObject);
      localObject = mLayoutState;
      mExtra = i;
      fill(paramU, (c)localObject, paramY, false);
      localObject = mLayoutState;
      k = mOffset;
      n = mCurrentPosition;
      m = mAvailable;
      i = j;
      if (m > 0) {
        i = j + m;
      }
      updateLayoutStateToFillStart(mAnchorInfo);
      localObject = mLayoutState;
      mExtra = i;
      mCurrentPosition += mItemDirection;
      fill(paramU, (c)localObject, paramY, false);
      localObject = mLayoutState;
      m = mOffset;
      i1 = mAvailable;
      j = k;
      i = m;
      if (i1 > 0)
      {
        updateLayoutStateToFillEnd(n, k);
        localObject = mLayoutState;
        mExtra = i1;
        fill(paramU, (c)localObject, paramY, false);
        j = mLayoutState.mOffset;
        i = m;
      }
    }
    else
    {
      updateLayoutStateToFillStart((a)localObject);
      localObject = mLayoutState;
      mExtra = j;
      fill(paramU, (c)localObject, paramY, false);
      localObject = mLayoutState;
      k = mOffset;
      n = mCurrentPosition;
      m = mAvailable;
      j = i;
      if (m > 0) {
        j = i + m;
      }
      updateLayoutStateToFillEnd(mAnchorInfo);
      localObject = mLayoutState;
      mExtra = j;
      mCurrentPosition += mItemDirection;
      fill(paramU, (c)localObject, paramY, false);
      localObject = mLayoutState;
      m = mOffset;
      i1 = mAvailable;
      j = m;
      i = k;
      if (i1 > 0)
      {
        updateLayoutStateToFillStart(n, k);
        localObject = mLayoutState;
        mExtra = i1;
        fill(paramU, (c)localObject, paramY, false);
        i = mLayoutState.mOffset;
        j = m;
      }
    }
    m = j;
    k = i;
    if (getChildCount() > 0)
    {
      if ((mShouldReverseLayout ^ mStackFromEnd))
      {
        m = fixLayoutEndGap(i, paramU, paramY, true);
        k = j + m;
        i += m;
        j = fixLayoutStartGap(k, paramU, paramY, false);
      }
      else
      {
        m = fixLayoutStartGap(j, paramU, paramY, true);
        k = j + m;
        i += m;
        j = fixLayoutEndGap(i, paramU, paramY, false);
      }
      m = k + j;
      k = i + j;
    }
    layoutForPredictiveAnimations(paramU, paramY, m, k);
    if (!paramY.isPreLayout()) {
      mOrientationHelper.onLayoutComplete();
    } else {
      mAnchorInfo.reset();
    }
    mLastStackFromEnd = mStackFromEnd;
  }
  
  public void onLayoutChildren(RecyclerView.y paramY)
  {
    super.onLayoutChildren(paramY);
    mPendingSavedState = null;
    mPendingScrollPosition = -1;
    mPendingScrollPositionOffset = Integer.MIN_VALUE;
    mAnchorInfo.reset();
  }
  
  protected void onLayoutChildren(RecyclerView.y paramY, int[] paramArrayOfInt)
  {
    int i = getExtraLayoutSpace(paramY);
    int j = i;
    if (mLayoutState.mLayoutDirection == -1) {
      i = 0;
    } else {
      j = 0;
    }
    paramArrayOfInt[0] = j;
    paramArrayOfInt[1] = i;
  }
  
  public void onLayoutChildren(RecyclerView paramRecyclerView, RecyclerView.u paramU)
  {
    super.onLayoutChildren(paramRecyclerView, paramU);
    if (mRecycleChildrenOnDetach)
    {
      removeAndRecycleAllViews(paramU);
      paramU.clear();
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      paramParcelable = (SavedState)paramParcelable;
      mPendingSavedState = paramParcelable;
      if (mPendingScrollPosition != -1) {
        paramParcelable.invalidateAnchor();
      }
      requestLayout();
    }
  }
  
  public PointF onSaveInstanceState(int paramInt)
  {
    if (getChildCount() == 0) {
      return null;
    }
    int k = 0;
    int j = getPosition(getChildAt(0));
    int i = 1;
    if (paramInt < j) {
      k = 1;
    }
    paramInt = i;
    if (k != mShouldReverseLayout) {
      paramInt = -1;
    }
    if (mOrientation == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (mPendingSavedState != null) {
      return new SavedState(mPendingSavedState);
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      ensureLayoutState();
      boolean bool = mLastStackFromEnd ^ mShouldReverseLayout;
      mAnchorLayoutFromEnd = bool;
      if (bool)
      {
        localView = getChildClosestToEnd();
        mAnchorOffset = (mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd(localView));
        mAnchorPosition = getPosition(localView);
        return localSavedState;
      }
      View localView = getChildClosestToStart();
      mAnchorPosition = getPosition(localView);
      mAnchorOffset = (mOrientationHelper.getDecoratedStart(localView) - mOrientationHelper.getStartAfterPadding());
      return localSavedState;
    }
    localSavedState.invalidateAnchor();
    return localSavedState;
  }
  
  public void prepareForDrop(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    ensureLayoutState();
    resolveShouldLayoutReverse();
    paramInt1 = getPosition(paramView1);
    paramInt2 = getPosition(paramView2);
    if (paramInt1 < paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    }
    if (mShouldReverseLayout)
    {
      if (paramInt1 == 1)
      {
        scrollToPositionWithOffset(paramInt2, mOrientationHelper.getEndAfterPadding() - (mOrientationHelper.getDecoratedStart(paramView2) + mOrientationHelper.getDecoratedMeasurement(paramView1)));
        return;
      }
      scrollToPositionWithOffset(paramInt2, mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd(paramView2));
      return;
    }
    if (paramInt1 == -1)
    {
      scrollToPositionWithOffset(paramInt2, mOrientationHelper.getDecoratedStart(paramView2));
      return;
    }
    scrollToPositionWithOffset(paramInt2, mOrientationHelper.getDecoratedEnd(paramView2) - mOrientationHelper.getDecoratedMeasurement(paramView1));
  }
  
  boolean resolveIsInfinite()
  {
    return (mOrientationHelper.getMode() == 0) && (mOrientationHelper.getEnd() == 0);
  }
  
  int scrollBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    if (getChildCount() != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      ensureLayoutState();
      mLayoutState.mRecycle = true;
      int i;
      if (paramInt > 0) {
        i = 1;
      } else {
        i = -1;
      }
      int j = Math.abs(paramInt);
      updateLayoutState(i, j, true, paramY);
      c localC = mLayoutState;
      int k = mScrollingOffset + fill(paramU, localC, paramY, false);
      if (k < 0) {
        return 0;
      }
      if (j > k) {
        paramInt = i * k;
      }
      mOrientationHelper.offsetChildren(-paramInt);
      mLayoutState.mLastScrollDelta = paramInt;
      return paramInt;
    }
    return 0;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    if (mOrientation == 1) {
      return 0;
    }
    return scrollBy(paramInt, paramU, paramY);
  }
  
  public void scrollToPosition(int paramInt)
  {
    mPendingScrollPosition = paramInt;
    mPendingScrollPositionOffset = Integer.MIN_VALUE;
    SavedState localSavedState = mPendingSavedState;
    if (localSavedState != null) {
      localSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    mPendingScrollPosition = paramInt1;
    mPendingScrollPositionOffset = paramInt2;
    SavedState localSavedState = mPendingSavedState;
    if (localSavedState != null) {
      localSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    if (mOrientation == 0) {
      return 0;
    }
    return scrollBy(paramInt, paramU, paramY);
  }
  
  public void setOrientation(int paramInt)
  {
    Object localObject;
    if ((paramInt != 0) && (paramInt != 1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid orientation:");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    assertNotInLayoutOrScroll(null);
    if ((paramInt != mOrientation) || (mOrientationHelper == null))
    {
      localObject = OrientationHelper.createOrientationHelper(this, paramInt);
      mOrientationHelper = ((OrientationHelper)localObject);
      mAnchorInfo.mOrientationHelper = ((OrientationHelper)localObject);
      mOrientation = paramInt;
      requestLayout();
    }
  }
  
  public boolean setOrientation()
  {
    return true;
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == mReverseLayout) {
      return;
    }
    mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (mStackFromEnd == paramBoolean) {
      return;
    }
    mStackFromEnd = paramBoolean;
    requestLayout();
  }
  
  boolean shouldMeasureTwice()
  {
    return (getHeightMode() != 1073741824) && (getWidthMode() != 1073741824) && (hasFlexibleChildInBothOrientations());
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.y paramY, int paramInt)
  {
    paramRecyclerView = new LinearSmoothScroller(paramRecyclerView.getContext());
    paramRecyclerView.d(paramInt);
    a(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (mPendingSavedState == null) && (mLastStackFromEnd == mStackFromEnd);
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    boolean mAnchorLayoutFromEnd;
    int mAnchorOffset;
    int mAnchorPosition;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      mAnchorPosition = paramParcel.readInt();
      mAnchorOffset = paramParcel.readInt();
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      mAnchorLayoutFromEnd = bool;
    }
    
    public SavedState(SavedState paramSavedState)
    {
      mAnchorPosition = mAnchorPosition;
      mAnchorOffset = mAnchorOffset;
      mAnchorLayoutFromEnd = mAnchorLayoutFromEnd;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    boolean hasValidAnchor()
    {
      return mAnchorPosition >= 0;
    }
    
    void invalidateAnchor()
    {
      mAnchorPosition = -1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    class a
      implements Parcelable.Creator<LinearLayoutManager.SavedState>
    {
      a() {}
      
      public LinearLayoutManager.SavedState[] a(int paramInt)
      {
        return new LinearLayoutManager.SavedState[paramInt];
      }
      
      public LinearLayoutManager.SavedState readDate(Parcel paramParcel)
      {
        return new LinearLayoutManager.SavedState(paramParcel);
      }
    }
  }
  
  static class a
  {
    int mCoordinate;
    boolean mInPreLayout;
    boolean mLayoutFromEnd;
    OrientationHelper mOrientationHelper;
    int mPosition;
    
    a()
    {
      reset();
    }
    
    void assignCoordinateFromPadding()
    {
      int i;
      if (mLayoutFromEnd) {
        i = mOrientationHelper.getEndAfterPadding();
      } else {
        i = mOrientationHelper.getStartAfterPadding();
      }
      mCoordinate = i;
    }
    
    public void assignFromView(View paramView, int paramInt)
    {
      if (mLayoutFromEnd) {
        mCoordinate = (mOrientationHelper.getDecoratedEnd(paramView) + mOrientationHelper.getTotalSpaceChange());
      } else {
        mCoordinate = mOrientationHelper.getDecoratedStart(paramView);
      }
      mPosition = paramInt;
    }
    
    public void assignFromViewAndKeepVisibleRect(View paramView, int paramInt)
    {
      int i = mOrientationHelper.getTotalSpaceChange();
      if (i >= 0)
      {
        assignFromView(paramView, paramInt);
        return;
      }
      mPosition = paramInt;
      int j;
      int k;
      if (mLayoutFromEnd)
      {
        paramInt = mOrientationHelper.getEndAfterPadding() - i - mOrientationHelper.getDecoratedEnd(paramView);
        mCoordinate = (mOrientationHelper.getEndAfterPadding() - paramInt);
        if (paramInt > 0)
        {
          i = mOrientationHelper.getDecoratedMeasurement(paramView);
          j = mCoordinate;
          k = mOrientationHelper.getStartAfterPadding();
          i = j - i - (k + Math.min(mOrientationHelper.getDecoratedStart(paramView) - k, 0));
          if (i < 0) {
            mCoordinate += Math.min(paramInt, -i);
          }
        }
      }
      else
      {
        j = mOrientationHelper.getDecoratedStart(paramView);
        paramInt = j - mOrientationHelper.getStartAfterPadding();
        mCoordinate = j;
        if (paramInt > 0)
        {
          k = mOrientationHelper.getDecoratedMeasurement(paramView);
          int m = mOrientationHelper.getEndAfterPadding();
          int n = mOrientationHelper.getDecoratedEnd(paramView);
          i = mOrientationHelper.getEndAfterPadding() - Math.min(0, m - i - n) - (j + k);
          if (i < 0) {
            mCoordinate -= Math.min(paramInt, -i);
          }
        }
      }
    }
    
    boolean assignFromViewIfValid(View paramView, RecyclerView.y paramY)
    {
      paramView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return (!paramView.isItemRemoved()) && (paramView.getViewLayoutPosition() >= 0) && (paramView.getViewLayoutPosition() < paramY.getItemCount());
    }
    
    void reset()
    {
      mPosition = -1;
      mCoordinate = Integer.MIN_VALUE;
      mLayoutFromEnd = false;
      mInPreLayout = false;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AnchorInfo{mPosition=");
      localStringBuilder.append(mPosition);
      localStringBuilder.append(", mCoordinate=");
      localStringBuilder.append(mCoordinate);
      localStringBuilder.append(", mLayoutFromEnd=");
      localStringBuilder.append(mLayoutFromEnd);
      localStringBuilder.append(", mValid=");
      localStringBuilder.append(mInPreLayout);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  protected static class b
  {
    public int mConsumed;
    public boolean mFinished;
    public boolean mFocusable;
    public boolean mIgnoreConsumed;
    
    protected b() {}
    
    void resetInternal()
    {
      mConsumed = 0;
      mFinished = false;
      mIgnoreConsumed = false;
      mFocusable = false;
    }
  }
  
  static class c
  {
    int mAvailable;
    int mCurrentPosition;
    int mExtra = 0;
    boolean mInfinite;
    boolean mIsPreLayout = false;
    int mItemDirection;
    int mLastScrollDelta;
    int mLayoutDirection;
    int mOffset;
    boolean mRecycle = true;
    List<RecyclerView.b0> mScrapList = null;
    int mScrollingOffset;
    int mShouldReverseLayout = 0;
    
    c() {}
    
    private View nextViewFromScrapList()
    {
      int j = mScrapList.size();
      int i = 0;
      while (i < j)
      {
        View localView = mScrapList.get(i)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((!localLayoutParams.isItemRemoved()) && (mCurrentPosition == localLayoutParams.getViewLayoutPosition()))
        {
          assignPositionFromScrapList(localView);
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    public void assignPositionFromScrapList()
    {
      assignPositionFromScrapList(null);
    }
    
    public void assignPositionFromScrapList(View paramView)
    {
      paramView = nextViewInLimitedList(paramView);
      if (paramView == null)
      {
        mCurrentPosition = -1;
        return;
      }
      mCurrentPosition = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    }
    
    boolean hasMore(RecyclerView.y paramY)
    {
      int i = mCurrentPosition;
      return (i >= 0) && (i < paramY.getItemCount());
    }
    
    View next(RecyclerView.u paramU)
    {
      if (mScrapList != null) {
        return nextViewFromScrapList();
      }
      paramU = paramU.getViewForPosition(mCurrentPosition);
      mCurrentPosition += mItemDirection;
      return paramU;
    }
    
    public View nextViewInLimitedList(View paramView)
    {
      Object localObject1 = mScrapList;
      Object localObject2 = this;
      int n = ((List)localObject1).size();
      localObject1 = null;
      int j = Integer.MAX_VALUE;
      int i = 0;
      while (i < n)
      {
        Object localObject4 = mScrapList;
        Object localObject3 = localObject2;
        localObject4 = getitemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject4).getLayoutParams();
        localObject2 = localObject1;
        int k = j;
        if (localObject4 != paramView) {
          if (localLayoutParams.isItemRemoved())
          {
            localObject2 = localObject1;
            k = j;
          }
          else
          {
            int m = (localLayoutParams.getViewLayoutPosition() - mCurrentPosition) * mItemDirection;
            if (m < 0)
            {
              localObject2 = localObject1;
              k = j;
            }
            else
            {
              localObject2 = localObject1;
              k = j;
              if (m < j)
              {
                localObject2 = localObject4;
                if (m == 0) {
                  return localObject4;
                }
                k = m;
              }
            }
          }
        }
        i += 1;
        localObject1 = localObject2;
        j = k;
        localObject2 = localObject3;
      }
      return localObject1;
    }
  }
}
