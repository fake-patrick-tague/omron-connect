package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
  extends RecyclerView.o
  implements RecyclerView.x.b
{
  private final b mAnchorInfo = new b();
  private final Runnable mCheckForGapsRunnable = new a();
  private int[] mCurrentPosition;
  private int mFullSizeSpec;
  private int mGapStrategy = 2;
  private boolean mLaidOutInvalidFullSpan = false;
  private boolean mLastLayoutFromEnd;
  private boolean mLastLayoutRTL;
  private final LayoutState mLayoutState;
  LazySpanLookup mLazySpanLookup = new LazySpanLookup();
  private int mOrientation;
  private SavedState mPendingSavedState;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  OrientationHelper mPrimaryOrientation;
  private BitSet mRemainingSpans;
  boolean mReverseLayout = false;
  OrientationHelper mSecondaryOrientation;
  boolean mShouldReverseLayout = false;
  private int mSizePerSpan;
  private boolean mSmoothScrollbarEnabled = true;
  private int mSpanCount = -1;
  c[] mSpans;
  private final Rect mTmpRect = new Rect();
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = RecyclerView.o.getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(orientation);
    setSpanCount(spanCount);
    setReverseLayout(reverseLayout);
    mLayoutState = new LayoutState();
    createOrientationHelpers();
  }
  
  private void appendViewToAllSpans(View paramView)
  {
    int i = mSpanCount - 1;
    while (i >= 0)
    {
      mSpans[i].appendToSpan(paramView);
      i -= 1;
    }
  }
  
  private void applyPendingSavedState(b paramB)
  {
    SavedState localSavedState = mPendingSavedState;
    int i = mSpanOffsetsSize;
    if (i > 0)
    {
      if (i == mSpanCount)
      {
        i = 0;
        while (i < mSpanCount)
        {
          mSpans[i].clear();
          localSavedState = mPendingSavedState;
          int k = mSpanOffsets[i];
          int j = k;
          if (k != Integer.MIN_VALUE)
          {
            if (mAnchorLayoutFromEnd) {
              j = mPrimaryOrientation.getEndAfterPadding();
            } else {
              j = mPrimaryOrientation.getStartAfterPadding();
            }
            j = k + j;
          }
          mSpans[i].setLine(j);
          i += 1;
        }
      }
      localSavedState.invalidateSpanInfo();
      localSavedState = mPendingSavedState;
      mAnchorPosition = mVisibleAnchorPosition;
    }
    localSavedState = mPendingSavedState;
    mLastLayoutRTL = mLastLayoutRTL;
    setReverseLayout(mReverseLayout);
    resolveShouldLayoutReverse();
    localSavedState = mPendingSavedState;
    i = mAnchorPosition;
    if (i != -1)
    {
      mPendingScrollPosition = i;
      mLayoutFromEnd = mAnchorLayoutFromEnd;
    }
    else
    {
      mLayoutFromEnd = mShouldReverseLayout;
    }
    if (mSpanLookupSize > 1)
    {
      paramB = mLazySpanLookup;
      mData = mSpanLookup;
      mFullSpanItems = mFullSpanItems;
    }
  }
  
  private void attachViewToSpans(View paramView, LayoutParams paramLayoutParams, LayoutState paramLayoutState)
  {
    if (mLayoutDirection == 1)
    {
      if (mFullSpan)
      {
        prependViewToAllSpans(paramView);
        return;
      }
      mSpan.prependToSpan(paramView);
      return;
    }
    if (mFullSpan)
    {
      appendViewToAllSpans(paramView);
      return;
    }
    mSpan.appendToSpan(paramView);
  }
  
  private int calculateScrollDirectionForPosition(int paramInt)
  {
    if (getChildCount() == 0)
    {
      if (mShouldReverseLayout) {
        return 1;
      }
    }
    else
    {
      int i;
      if (paramInt < getFirstChildPosition()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != mShouldReverseLayout) {
        return -1;
      }
      return 1;
    }
    return -1;
  }
  
  private boolean checkSpanForGap(c paramC)
  {
    if (mShouldReverseLayout)
    {
      if (paramC.getEndLine() < mPrimaryOrientation.getEndAfterPadding())
      {
        ArrayList localArrayList = mViews;
        return getLayoutParamsgetsize1mFullSpan ^ true;
      }
    }
    else if (paramC.getStartLine() > mPrimaryOrientation.getStartAfterPadding()) {
      return getLayoutParamsmViews.get(0)).mFullSpan ^ true;
    }
    return false;
  }
  
  private int computeScrollExtent(RecyclerView.y paramY)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return ScrollbarHelper.computeScrollExtent(paramY, mPrimaryOrientation, findFirstVisibleItemClosestToStart(mSmoothScrollbarEnabled ^ true), findFirstVisibleItemClosestToEnd(mSmoothScrollbarEnabled ^ true), this, mSmoothScrollbarEnabled);
  }
  
  private int computeScrollOffset(RecyclerView.y paramY)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return ScrollbarHelper.computeScrollOffset(paramY, mPrimaryOrientation, findFirstVisibleItemClosestToStart(mSmoothScrollbarEnabled ^ true), findFirstVisibleItemClosestToEnd(mSmoothScrollbarEnabled ^ true), this, mSmoothScrollbarEnabled, mShouldReverseLayout);
  }
  
  private int computeScrollRange(RecyclerView.y paramY)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return ScrollbarHelper.computeScrollRange(paramY, mPrimaryOrientation, findFirstVisibleItemClosestToStart(mSmoothScrollbarEnabled ^ true), findFirstVisibleItemClosestToEnd(mSmoothScrollbarEnabled ^ true), this, mSmoothScrollbarEnabled);
  }
  
  private int convertFocusDirectionToLayoutDirection(int paramInt)
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
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    mGapPerSpan = new int[mSpanCount];
    int i = 0;
    while (i < mSpanCount)
    {
      mGapPerSpan[i] = (paramInt - mSpans[i].getEndLine(paramInt));
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    mGapPerSpan = new int[mSpanCount];
    int i = 0;
    while (i < mSpanCount)
    {
      mGapPerSpan[i] = (mSpans[i].getStartLine(paramInt) - paramInt);
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private void createOrientationHelpers()
  {
    mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, mOrientation);
    mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - mOrientation);
  }
  
  private int fill(RecyclerView.u paramU, LayoutState paramLayoutState, RecyclerView.y paramY)
  {
    mRemainingSpans.set(0, mSpanCount, true);
    int i;
    if (mLayoutState.mInfinite)
    {
      if (mLayoutDirection == 1) {
        i = Integer.MAX_VALUE;
      } else {
        i = Integer.MIN_VALUE;
      }
    }
    else if (mLayoutDirection == 1) {
      i = mEndLine + mAvailable;
    } else {
      i = mStartLine - mAvailable;
    }
    updateAllRemainingSpans(mLayoutDirection, i);
    int k;
    if (mShouldReverseLayout) {
      k = mPrimaryOrientation.getEndAfterPadding();
    } else {
      k = mPrimaryOrientation.getStartAfterPadding();
    }
    for (int j = 0; (paramLayoutState.hasMore(paramY)) && ((mLayoutState.mInfinite) || (!mRemainingSpans.isEmpty())); j = 1)
    {
      View localView = paramLayoutState.next(paramU);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i3 = localLayoutParams.getViewLayoutPosition();
      j = mLazySpanLookup.getSpan(i3);
      int i1;
      if (j == -1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      c localC;
      if (i1 != 0)
      {
        if (mFullSpan) {
          localC = mSpans[0];
        } else {
          localC = getNextSpan(paramLayoutState);
        }
        mLazySpanLookup.setSpan(i3, localC);
      }
      else
      {
        localC = mSpans[j];
      }
      mSpan = localC;
      if (mLayoutDirection == 1) {
        addView(localView);
      } else {
        addView(localView, 0);
      }
      measureChildWithDecorationsAndMargin(localView, localLayoutParams, false);
      int m;
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
      int n;
      int i2;
      if (mLayoutDirection == 1)
      {
        if (mFullSpan) {
          j = getMaxEnd(k);
        } else {
          j = localC.getEndLine(k);
        }
        m = mPrimaryOrientation.getDecoratedMeasurement(localView) + j;
        if ((i1 != 0) && (mFullSpan))
        {
          localFullSpanItem = createFullSpanItemFromEnd(j);
          mGapDir = -1;
          mPosition = i3;
          mLazySpanLookup.addFullSpanItem(localFullSpanItem);
        }
        n = j;
      }
      else
      {
        if (mFullSpan) {
          j = getMinStart(k);
        } else {
          j = localC.getStartLine(k);
        }
        i2 = j - mPrimaryOrientation.getDecoratedMeasurement(localView);
        m = j;
        n = i2;
        if (i1 != 0)
        {
          m = j;
          n = i2;
          if (mFullSpan)
          {
            localFullSpanItem = createFullSpanItemFromStart(j);
            mGapDir = 1;
            mPosition = i3;
            mLazySpanLookup.addFullSpanItem(localFullSpanItem);
            n = i2;
            m = j;
          }
        }
      }
      if ((mFullSpan) && (mItemDirection == -1)) {
        if (i1 != 0)
        {
          mLaidOutInvalidFullSpan = true;
        }
        else
        {
          boolean bool;
          if (mLayoutDirection == 1) {
            bool = areAllEndsEqual();
          } else {
            bool = areAllStartsEqual();
          }
          if ((bool ^ true))
          {
            localFullSpanItem = mLazySpanLookup.getFullSpanItem(i3);
            if (localFullSpanItem != null) {
              mHasUnwantedGapAfter = true;
            }
            mLaidOutInvalidFullSpan = true;
          }
        }
      }
      attachViewToSpans(localView, localLayoutParams, paramLayoutState);
      if ((isLayoutRTL()) && (mOrientation == 1))
      {
        if (mFullSpan) {
          j = mSecondaryOrientation.getEndAfterPadding();
        } else {
          j = mSecondaryOrientation.getEndAfterPadding() - (mSpanCount - 1 - mIndex) * mSizePerSpan;
        }
        i1 = j - mSecondaryOrientation.getDecoratedMeasurement(localView);
      }
      else
      {
        if (mFullSpan) {
          j = mSecondaryOrientation.getStartAfterPadding();
        } else {
          j = mIndex * mSizePerSpan + mSecondaryOrientation.getStartAfterPadding();
        }
        i2 = mSecondaryOrientation.getDecoratedMeasurement(localView);
        i1 = j;
        j = i2 + j;
      }
      if (mOrientation == 1) {
        measureChildWithDecorationsAndMargin(localView, i1, n, j, m);
      } else {
        measureChildWithDecorationsAndMargin(localView, n, i1, m, j);
      }
      if (mFullSpan) {
        updateAllRemainingSpans(mLayoutState.mLayoutDirection, i);
      } else {
        updateRemainingSpans(localC, mLayoutState.mLayoutDirection, i);
      }
      recycle(paramU, mLayoutState);
      if ((mLayoutState.mStopInFocusable) && (localView.hasFocusable())) {
        if (mFullSpan) {
          mRemainingSpans.clear();
        } else {
          mRemainingSpans.set(mIndex, false);
        }
      }
    }
    if (j == 0) {
      recycle(paramU, mLayoutState);
    }
    if (mLayoutState.mLayoutDirection == -1)
    {
      i = getMinStart(mPrimaryOrientation.getStartAfterPadding());
      i = mPrimaryOrientation.getStartAfterPadding() - i;
    }
    else
    {
      i = getMaxEnd(mPrimaryOrientation.getEndAfterPadding()) - mPrimaryOrientation.getEndAfterPadding();
    }
    if (i > 0) {
      return Math.min(mAvailable, i);
    }
    return 0;
  }
  
  private int findFirstReferenceChildPosition(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      int k = getPosition(getChildAt(i));
      if ((k >= 0) && (k < paramInt)) {
        return k;
      }
      i += 1;
    }
    return 0;
  }
  
  private int findLastReferenceChildPosition(int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      int j = getPosition(getChildAt(i));
      if ((j >= 0) && (j < paramInt)) {
        return j;
      }
      i -= 1;
    }
    return 0;
  }
  
  private void fixEndGap(RecyclerView.u paramU, RecyclerView.y paramY, boolean paramBoolean)
  {
    int i = getMaxEnd(Integer.MIN_VALUE);
    if (i == Integer.MIN_VALUE) {
      return;
    }
    i = mPrimaryOrientation.getEndAfterPadding() - i;
    if (i > 0)
    {
      i -= -scrollBy(-i, paramU, paramY);
      if ((paramBoolean) && (i > 0)) {
        mPrimaryOrientation.offsetChildren(i);
      }
    }
  }
  
  private void fixStartGap(RecyclerView.u paramU, RecyclerView.y paramY, boolean paramBoolean)
  {
    int i = getMinStart(Integer.MAX_VALUE);
    if (i == Integer.MAX_VALUE) {
      return;
    }
    i -= mPrimaryOrientation.getStartAfterPadding();
    if (i > 0)
    {
      i -= scrollBy(i, paramU, paramY);
      if ((paramBoolean) && (i > 0)) {
        mPrimaryOrientation.offsetChildren(-i);
      }
    }
  }
  
  private int getMaxEnd(int paramInt)
  {
    int j = mSpans[0].getEndLine(paramInt);
    int i = 1;
    while (i < mSpanCount)
    {
      int m = mSpans[i].getEndLine(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int getMaxStart(int paramInt)
  {
    int j = mSpans[0].getStartLine(paramInt);
    int i = 1;
    while (i < mSpanCount)
    {
      int m = mSpans[i].getStartLine(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int getMinEnd(int paramInt)
  {
    int j = mSpans[0].getEndLine(paramInt);
    int i = 1;
    while (i < mSpanCount)
    {
      int m = mSpans[i].getEndLine(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int getMinStart(int paramInt)
  {
    int j = mSpans[0].getStartLine(paramInt);
    int i = 1;
    while (i < mSpanCount)
    {
      int m = mSpans[i].getStartLine(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private c getNextSpan(LayoutState paramLayoutState)
  {
    boolean bool = preferLastSpan(mLayoutDirection);
    int j = -1;
    int i;
    int k;
    if (bool)
    {
      i = mSpanCount - 1;
      k = -1;
    }
    else
    {
      i = 0;
      j = mSpanCount;
      k = 1;
    }
    int m = mLayoutDirection;
    c localC = null;
    paramLayoutState = null;
    int i1;
    int n;
    if (m == 1)
    {
      m = Integer.MAX_VALUE;
      i2 = mPrimaryOrientation.getStartAfterPadding();
      while (i != j)
      {
        localC = mSpans[i];
        i1 = localC.getEndLine(i2);
        n = m;
        if (i1 < m)
        {
          paramLayoutState = localC;
          n = i1;
        }
        i += k;
        m = n;
      }
      return paramLayoutState;
    }
    m = Integer.MIN_VALUE;
    int i2 = mPrimaryOrientation.getEndAfterPadding();
    paramLayoutState = localC;
    while (i != j)
    {
      localC = mSpans[i];
      i1 = localC.getStartLine(i2);
      n = m;
      if (i1 > m)
      {
        paramLayoutState = localC;
        n = i1;
      }
      i += k;
      m = n;
    }
    return paramLayoutState;
  }
  
  private void handleUpdate(int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    if (mShouldReverseLayout) {
      j = getLastChildPosition();
    } else {
      j = getFirstChildPosition();
    }
    int i;
    if (paramInt3 == 8)
    {
      if (paramInt1 < paramInt2)
      {
        i = paramInt2 + 1;
      }
      else
      {
        i = paramInt1 + 1;
        k = paramInt2;
        break label60;
      }
    }
    else {
      i = paramInt1 + paramInt2;
    }
    int k = paramInt1;
    label60:
    mLazySpanLookup.invalidateAfter(k);
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2)
      {
        if (paramInt3 == 8)
        {
          mLazySpanLookup.offsetForRemoval(paramInt1, 1);
          mLazySpanLookup.offsetForAddition(paramInt2, 1);
        }
      }
      else {
        mLazySpanLookup.offsetForRemoval(paramInt1, paramInt2);
      }
    }
    else {
      mLazySpanLookup.offsetForAddition(paramInt1, paramInt2);
    }
    if (i <= j) {
      return;
    }
    if (mShouldReverseLayout) {
      paramInt1 = getFirstChildPosition();
    } else {
      paramInt1 = getLastChildPosition();
    }
    if (k <= paramInt1) {
      requestLayout();
    }
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    calculateItemDecorationsForChild(paramView, mTmpRect);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = leftMargin;
    Rect localRect = mTmpRect;
    paramInt1 = updateSpecWithExtra(paramInt1, i + left, rightMargin + right);
    i = topMargin;
    localRect = mTmpRect;
    paramInt2 = updateSpecWithExtra(paramInt2, i + top, bottomMargin + bottom);
    if (paramBoolean) {
      paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    } else {
      paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    }
    if (paramBoolean) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (mFullSpan)
    {
      if (mOrientation == 1)
      {
        measureChildWithDecorationsAndMargin(paramView, mFullSizeSpec, RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), height, true), paramBoolean);
        return;
      }
      measureChildWithDecorationsAndMargin(paramView, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), width, true), mFullSizeSpec, paramBoolean);
      return;
    }
    if (mOrientation == 1)
    {
      measureChildWithDecorationsAndMargin(paramView, RecyclerView.o.getChildMeasureSpec(mSizePerSpan, getWidthMode(), 0, width, false), RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), height, true), paramBoolean);
      return;
    }
    measureChildWithDecorationsAndMargin(paramView, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), width, true), RecyclerView.o.getChildMeasureSpec(mSizePerSpan, getHeightMode(), 0, height, false), paramBoolean);
  }
  
  private void onLayoutChildren(RecyclerView.u paramU, RecyclerView.y paramY, boolean paramBoolean)
  {
    b localB = mAnchorInfo;
    if (((mPendingSavedState != null) || (mPendingScrollPosition != -1)) && (paramY.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramU);
      localB.reset();
      return;
    }
    boolean bool = mLaidOutInvalidFullSpan;
    int j = 1;
    if ((bool) && (mPendingScrollPosition == -1) && (mPendingSavedState == null)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localB.reset();
      if (mPendingSavedState != null)
      {
        applyPendingSavedState(localB);
      }
      else
      {
        resolveShouldLayoutReverse();
        mLayoutFromEnd = mShouldReverseLayout;
      }
      updateAnchorInfoForLayout(paramY, localB);
      mLaidOutInvalidFullSpan = true;
    }
    if ((mPendingSavedState == null) && (mPendingScrollPosition == -1) && ((mLayoutFromEnd != mLastLayoutFromEnd) || (isLayoutRTL() != mLastLayoutRTL)))
    {
      mLazySpanLookup.clear();
      mInvalidateOffsets = true;
    }
    Object localObject;
    if (getChildCount() > 0)
    {
      localObject = mPendingSavedState;
      if ((localObject == null) || (mSpanOffsetsSize < 1))
      {
        if (mInvalidateOffsets)
        {
          i = 0;
          while (i < mSpanCount)
          {
            mSpans[i].clear();
            int k = mOffset;
            if (k != Integer.MIN_VALUE) {
              mSpans[i].setLine(k);
            }
            i += 1;
          }
        }
        if ((i == 0) && (mAnchorInfo.mShouldReverseLayout != null)) {
          i = 0;
        }
        while (i < mSpanCount)
        {
          localObject = mSpans[i];
          ((c)localObject).clear();
          ((c)localObject).setLine(mAnchorInfo.mShouldReverseLayout[i]);
          i += 1;
          continue;
          i = 0;
          while (i < mSpanCount)
          {
            mSpans[i].cacheReferenceLineAndClear(mShouldReverseLayout, mOffset);
            i += 1;
          }
          mAnchorInfo.onLayoutChildren(mSpans);
        }
      }
    }
    detachAndScrapAttachedViews(paramU);
    mLayoutState.mRecycle = false;
    mLaidOutInvalidFullSpan = false;
    updateMeasureSpecs(mSecondaryOrientation.getTotalSpace());
    updateLayoutState(mPosition, paramY);
    if (mLayoutFromEnd)
    {
      updateLayoutState(-1);
      fill(paramU, mLayoutState, paramY);
      updateLayoutState(1);
      localObject = mLayoutState;
      mCurrentPosition = (mPosition + mItemDirection);
      fill(paramU, (LayoutState)localObject, paramY);
    }
    else
    {
      updateLayoutState(1);
      fill(paramU, mLayoutState, paramY);
      updateLayoutState(-1);
      localObject = mLayoutState;
      mCurrentPosition = (mPosition + mItemDirection);
      fill(paramU, (LayoutState)localObject, paramY);
    }
    repositionToWrapContentIfNecessary();
    if (getChildCount() > 0) {
      if (mShouldReverseLayout)
      {
        fixEndGap(paramU, paramY, true);
        fixStartGap(paramU, paramY, false);
      }
      else
      {
        fixStartGap(paramU, paramY, true);
        fixEndGap(paramU, paramY, false);
      }
    }
    if ((paramBoolean) && (!paramY.isPreLayout()))
    {
      if ((mGapStrategy != 0) && (getChildCount() > 0) && ((mLaidOutInvalidFullSpan) || (hasGapsToFix() != null))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        removeCallbacks(mCheckForGapsRunnable);
        if (checkForGaps())
        {
          i = j;
          break label677;
        }
      }
    }
    int i = 0;
    label677:
    if (paramY.isPreLayout()) {
      mAnchorInfo.reset();
    }
    mLastLayoutFromEnd = mLayoutFromEnd;
    mLastLayoutRTL = isLayoutRTL();
    if (i != 0)
    {
      mAnchorInfo.reset();
      onLayoutChildren(paramU, paramY, false);
    }
  }
  
  private boolean preferLastSpan(int paramInt)
  {
    int i;
    if (mOrientation == 0)
    {
      if (paramInt == -1) {
        i = 1;
      } else {
        i = 0;
      }
      return i != mShouldReverseLayout;
    }
    if (paramInt == -1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == mShouldReverseLayout) {
      i = 1;
    } else {
      i = 0;
    }
    return i == isLayoutRTL();
  }
  
  private void prependViewToAllSpans(View paramView)
  {
    int i = mSpanCount - 1;
    while (i >= 0)
    {
      mSpans[i].prependToSpan(paramView);
      i -= 1;
    }
  }
  
  private void recycle(RecyclerView.u paramU, LayoutState paramLayoutState)
  {
    if (mRecycle)
    {
      if (mInfinite) {
        return;
      }
      if (mAvailable == 0)
      {
        if (mLayoutDirection == -1)
        {
          recycleFromEnd(paramU, mEndLine);
          return;
        }
        recycleFromStart(paramU, mStartLine);
        return;
      }
      if (mLayoutDirection == -1)
      {
        i = mStartLine;
        i -= getMaxStart(i);
        if (i < 0) {
          i = mEndLine;
        } else {
          i = mEndLine - Math.min(i, mAvailable);
        }
        recycleFromEnd(paramU, i);
        return;
      }
      int i = getMinEnd(mEndLine) - mEndLine;
      if (i < 0)
      {
        i = mStartLine;
      }
      else
      {
        int j = mStartLine;
        i = Math.min(i, mAvailable) + j;
      }
      recycleFromStart(paramU, i);
    }
  }
  
  private void recycleFromEnd(RecyclerView.u paramU, int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      if ((mPrimaryOrientation.getDecoratedStart(localView) < paramInt) || (mPrimaryOrientation.getEnd(localView) < paramInt)) {
        break;
      }
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (mFullSpan)
      {
        int m = 0;
        int j = 0;
        int k;
        for (;;)
        {
          k = m;
          if (j >= mSpanCount) {
            break;
          }
          if (mSpans[j].mViews.size() == 1) {
            return;
          }
          j += 1;
        }
        while (k < mSpanCount)
        {
          mSpans[k].popEnd();
          k += 1;
        }
      }
      if (mSpan.mViews.size() == 1) {
        return;
      }
      mSpan.popEnd();
      removeAndRecycleView(localView, paramU);
      i -= 1;
    }
  }
  
  private void recycleFromStart(RecyclerView.u paramU, int paramInt)
  {
    while (getChildCount() > 0)
    {
      int k = 0;
      View localView = getChildAt(0);
      if ((mPrimaryOrientation.getDecoratedEnd(localView) > paramInt) || (mPrimaryOrientation.getTotalSpace(localView) > paramInt)) {
        break;
      }
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (mFullSpan)
      {
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= mSpanCount) {
            break;
          }
          if (mSpans[i].mViews.size() == 1) {
            return;
          }
          i += 1;
        }
        while (j < mSpanCount)
        {
          mSpans[j].popStart();
          j += 1;
        }
      }
      if (mSpan.mViews.size() == 1) {
        return;
      }
      mSpan.popStart();
      removeAndRecycleView(localView, paramU);
    }
  }
  
  private void repositionToWrapContentIfNecessary()
  {
    if (mSecondaryOrientation.getMode() == 1073741824) {
      return;
    }
    float f1 = 0.0F;
    int m = getChildCount();
    int j = 0;
    int i = 0;
    View localView;
    while (i < m)
    {
      localView = getChildAt(i);
      float f3 = mSecondaryOrientation.getDecoratedMeasurement(localView);
      if (f3 >= f1)
      {
        float f2 = f3;
        if (((LayoutParams)localView.getLayoutParams()).isFullSpan()) {
          f2 = f3 * 1.0F / mSpanCount;
        }
        f1 = Math.max(f1, f2);
      }
      i += 1;
    }
    int n = mSizePerSpan;
    int k = Math.round(f1 * mSpanCount);
    i = k;
    if (mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
      i = Math.min(k, mSecondaryOrientation.getTotalSpace());
    }
    updateMeasureSpecs(i);
    i = j;
    if (mSizePerSpan == n) {
      return;
    }
    while (i < m)
    {
      localView = getChildAt(i);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!mFullSpan) {
        if ((isLayoutRTL()) && (mOrientation == 1))
        {
          j = mSpanCount;
          k = mSpan.mIndex;
          localView.offsetLeftAndRight(-(j - 1 - k) * mSizePerSpan - -(j - 1 - k) * n);
        }
        else
        {
          k = mSpan.mIndex;
          j = mSizePerSpan * k;
          k *= n;
          if (mOrientation == 1) {
            localView.offsetLeftAndRight(j - k);
          } else {
            localView.offsetTopAndBottom(j - k);
          }
        }
      }
      i += 1;
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
  
  private void updateAllRemainingSpans(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < mSpanCount)
    {
      if (!mSpans[i].mViews.isEmpty()) {
        updateRemainingSpans(mSpans[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.y paramY, b paramB)
  {
    int i;
    if (mLastLayoutFromEnd) {
      i = findLastReferenceChildPosition(paramY.getItemCount());
    } else {
      i = findFirstReferenceChildPosition(paramY.getItemCount());
    }
    mPosition = i;
    mOffset = Integer.MIN_VALUE;
    return true;
  }
  
  private void updateLayoutState(int paramInt)
  {
    LayoutState localLayoutState = mLayoutState;
    mLayoutDirection = paramInt;
    boolean bool2 = mShouldReverseLayout;
    int i = 1;
    boolean bool1;
    if (paramInt == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool2 == bool1) {
      paramInt = i;
    } else {
      paramInt = -1;
    }
    mItemDirection = paramInt;
  }
  
  private void updateLayoutState(int paramInt, RecyclerView.y paramY)
  {
    LayoutState localLayoutState = mLayoutState;
    boolean bool2 = false;
    mAvailable = 0;
    mCurrentPosition = paramInt;
    if (require())
    {
      i = paramY.c();
      if (i != -1)
      {
        boolean bool3 = mShouldReverseLayout;
        if (i < paramInt) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (bool3 == bool1)
        {
          i = mPrimaryOrientation.getTotalSpace();
          paramInt = 0;
          break label95;
        }
        paramInt = mPrimaryOrientation.getTotalSpace();
        i = 0;
        break label95;
      }
    }
    int i = 0;
    paramInt = 0;
    label95:
    if (shouldIgnore())
    {
      mLayoutState.mStartLine = (mPrimaryOrientation.getStartAfterPadding() - paramInt);
      mLayoutState.mEndLine = (mPrimaryOrientation.getEndAfterPadding() + i);
    }
    else
    {
      mLayoutState.mEndLine = (mPrimaryOrientation.getEnd() + i);
      mLayoutState.mStartLine = (-paramInt);
    }
    paramY = mLayoutState;
    mStopInFocusable = false;
    mRecycle = true;
    boolean bool1 = bool2;
    if (mPrimaryOrientation.getMode() == 0)
    {
      bool1 = bool2;
      if (mPrimaryOrientation.getEnd() == 0) {
        bool1 = true;
      }
    }
    mInfinite = bool1;
  }
  
  private void updateRemainingSpans(c paramC, int paramInt1, int paramInt2)
  {
    int i = paramC.getDeletedSize();
    if (paramInt1 == -1)
    {
      if (paramC.getStartLine() + i <= paramInt2) {
        mRemainingSpans.set(mIndex, false);
      }
    }
    else if (paramC.getEndLine() - i >= paramInt2) {
      mRemainingSpans.set(mIndex, false);
    }
  }
  
  private int updateSpecWithExtra(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      return paramInt1;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    if ((i != Integer.MIN_VALUE) && (i != 1073741824)) {
      return paramInt1;
    }
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
  }
  
  boolean areAllEndsEqual()
  {
    int j = mSpans[0].getEndLine(Integer.MIN_VALUE);
    int i = 1;
    while (i < mSpanCount)
    {
      if (mSpans[i].getEndLine(Integer.MIN_VALUE) != j) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  boolean areAllStartsEqual()
  {
    int j = mSpans[0].getStartLine(Integer.MIN_VALUE);
    int i = 1;
    while (i < mSpanCount)
    {
      if (mSpans[i].getStartLine(Integer.MIN_VALUE) != j) {
        return false;
      }
      i += 1;
    }
    return true;
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
  
  boolean checkForGaps()
  {
    if ((getChildCount() != 0) && (mGapStrategy != 0))
    {
      if (!isAttachedToWindow()) {
        return false;
      }
      int i;
      int j;
      if (mShouldReverseLayout)
      {
        i = getLastChildPosition();
        j = getFirstChildPosition();
      }
      else
      {
        i = getFirstChildPosition();
        j = getLastChildPosition();
      }
      if ((i == 0) && (hasGapsToFix() != null))
      {
        mLazySpanLookup.clear();
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
      }
      if (!mLaidOutInvalidFullSpan) {
        return false;
      }
      int k;
      if (mShouldReverseLayout) {
        k = -1;
      } else {
        k = 1;
      }
      Object localObject = mLazySpanLookup;
      j += 1;
      localObject = ((LazySpanLookup)localObject).getFirstFullSpanItemInRange(i, j, k, true);
      if (localObject == null)
      {
        mLaidOutInvalidFullSpan = false;
        mLazySpanLookup.forceInvalidateAfter(j);
        return false;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = mLazySpanLookup.getFirstFullSpanItemInRange(i, mPosition, k * -1, true);
      if (localFullSpanItem == null) {
        mLazySpanLookup.forceInvalidateAfter(mPosition);
      } else {
        mLazySpanLookup.forceInvalidateAfter(mPosition + 1);
      }
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      return true;
    }
    return false;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
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
      scrollBy(paramInt1, paramY);
      Object localObject = mCurrentPosition;
      if ((localObject == null) || (localObject.length < mSpanCount)) {
        mCurrentPosition = new int[mSpanCount];
      }
      int k = 0;
      paramInt2 = 0;
      int i;
      for (paramInt1 = 0; paramInt2 < mSpanCount; paramInt1 = i)
      {
        localObject = mLayoutState;
        if (mItemDirection == -1)
        {
          i = mStartLine;
          j = mSpans[paramInt2].getStartLine(i);
        }
        else
        {
          i = mSpans[paramInt2].getEndLine(mEndLine);
          j = mLayoutState.mEndLine;
        }
        int j = i - j;
        i = paramInt1;
        if (j >= 0)
        {
          mCurrentPosition[paramInt1] = j;
          i = paramInt1 + 1;
        }
        paramInt2 += 1;
      }
      Arrays.sort(mCurrentPosition, 0, paramInt1);
      paramInt2 = k;
      while ((paramInt2 < paramInt1) && (mLayoutState.hasMore(paramY)))
      {
        paramC.set(mLayoutState.mCurrentPosition, mCurrentPosition[paramInt2]);
        localObject = mLayoutState;
        mCurrentPosition += mItemDirection;
        paramInt2 += 1;
      }
    }
  }
  
  View findFirstVisibleItemClosestToEnd(boolean paramBoolean)
  {
    int j = mPrimaryOrientation.getStartAfterPadding();
    int k = mPrimaryOrientation.getEndAfterPadding();
    int i = getChildCount() - 1;
    Object localObject2;
    for (Object localObject1 = null; i >= 0; localObject1 = localObject2)
    {
      View localView = getChildAt(i);
      int m = mPrimaryOrientation.getDecoratedStart(localView);
      int n = mPrimaryOrientation.getDecoratedEnd(localView);
      localObject2 = localObject1;
      if (n > j) {
        if (m >= k)
        {
          localObject2 = localObject1;
        }
        else if (n > k)
        {
          if (!paramBoolean) {
            return localView;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      i -= 1;
    }
    return localObject1;
  }
  
  View findFirstVisibleItemClosestToStart(boolean paramBoolean)
  {
    int j = mPrimaryOrientation.getStartAfterPadding();
    int k = mPrimaryOrientation.getEndAfterPadding();
    int m = getChildCount();
    Object localObject1 = null;
    int i = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      int n = mPrimaryOrientation.getDecoratedStart(localView);
      Object localObject2 = localObject1;
      if (mPrimaryOrientation.getDecoratedEnd(localView) > j) {
        if (n >= k)
        {
          localObject2 = localObject1;
        }
        else if (n < j)
        {
          if (!paramBoolean) {
            return localView;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  int findFirstVisibleItemPositionInt()
  {
    View localView;
    if (mShouldReverseLayout) {
      localView = findFirstVisibleItemClosestToEnd(true);
    } else {
      localView = findFirstVisibleItemClosestToStart(true);
    }
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  int getFirstChildPosition()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return getPosition(getChildAt(0));
  }
  
  int getLastChildPosition()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return getPosition(getChildAt(i - 1));
  }
  
  View hasGapsToFix()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(mSpanCount);
    localBitSet.set(0, mSpanCount, true);
    int j = mOrientation;
    int n = -1;
    if ((j == 1) && (isLayoutRTL())) {
      j = 1;
    } else {
      j = -1;
    }
    int k;
    if (mShouldReverseLayout)
    {
      k = -1;
    }
    else
    {
      k = i + 1;
      i = 0;
    }
    int m = i;
    if (i < k)
    {
      n = 1;
      m = i;
    }
    while (m != k)
    {
      View localView = getChildAt(m);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localBitSet.get(mSpan.mIndex))
      {
        if (checkSpanForGap(mSpan)) {
          return localView;
        }
        localBitSet.clear(mSpan.mIndex);
      }
      if (!mFullSpan)
      {
        i = m + n;
        if (i != k)
        {
          Object localObject = getChildAt(i);
          int i1;
          if (mShouldReverseLayout)
          {
            i = mPrimaryOrientation.getDecoratedEnd(localView);
            i1 = mPrimaryOrientation.getDecoratedEnd((View)localObject);
            if (i < i1) {
              return localView;
            }
            if (i != i1) {
              break label274;
            }
          }
          else
          {
            i = mPrimaryOrientation.getDecoratedStart(localView);
            i1 = mPrimaryOrientation.getDecoratedStart((View)localObject);
            if (i > i1) {
              return localView;
            }
            if (i != i1) {
              break label274;
            }
          }
          i = 1;
          break label276;
          label274:
          i = 0;
          label276:
          if (i != 0)
          {
            localObject = (LayoutParams)((View)localObject).getLayoutParams();
            if (mSpan.mIndex - mSpan.mIndex < 0) {
              i = 1;
            } else {
              i = 0;
            }
            if (j < 0) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (i != i1) {
              return localView;
            }
          }
        }
      }
      m += n;
    }
    return null;
  }
  
  public void invalidateSpanAssignments()
  {
    mLazySpanLookup.clear();
    requestLayout();
  }
  
  boolean isLayoutRTL()
  {
    return getLayoutDirection() == 1;
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    super.offsetChildrenHorizontal(paramInt);
    int i = 0;
    while (i < mSpanCount)
    {
      mSpans[i].onOffset(paramInt);
      i += 1;
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    super.offsetChildrenVertical(paramInt);
    int i = 0;
    while (i < mSpanCount)
    {
      mSpans[i].onOffset(paramInt);
      i += 1;
    }
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    if (getChildCount() == 0) {
      return null;
    }
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      return null;
    }
    resolveShouldLayoutReverse();
    int k = convertFocusDirectionToLayoutDirection(paramInt);
    if (k == Integer.MIN_VALUE) {
      return null;
    }
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    boolean bool1 = mFullSpan;
    localObject = mSpan;
    if (k == 1) {
      paramInt = getLastChildPosition();
    } else {
      paramInt = getFirstChildPosition();
    }
    updateLayoutState(paramInt, paramY);
    updateLayoutState(k);
    LayoutState localLayoutState = mLayoutState;
    mCurrentPosition = (mItemDirection + paramInt);
    mAvailable = ((int)(mPrimaryOrientation.getTotalSpace() * 0.33333334F));
    localLayoutState = mLayoutState;
    mStopInFocusable = true;
    int j = 0;
    mRecycle = false;
    fill(paramU, localLayoutState, paramY);
    mLastLayoutFromEnd = mShouldReverseLayout;
    if (!bool1)
    {
      paramU = ((c)localObject).getFocusableViewAfter(paramInt, k);
      if ((paramU != null) && (paramU != paramView)) {
        return paramU;
      }
    }
    if (preferLastSpan(k))
    {
      i = mSpanCount - 1;
      while (i >= 0)
      {
        paramU = mSpans[i].getFocusableViewAfter(paramInt, k);
        if ((paramU != null) && (paramU != paramView)) {
          return paramU;
        }
        i -= 1;
      }
    }
    int i = 0;
    while (i < mSpanCount)
    {
      paramU = mSpans[i].getFocusableViewAfter(paramInt, k);
      if ((paramU != null) && (paramU != paramView)) {
        return paramU;
      }
      i += 1;
    }
    boolean bool2 = mReverseLayout;
    if (k == -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((bool2 ^ true) == paramInt) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (!bool1)
    {
      if (paramInt != 0) {
        i = ((c)localObject).findFirstVisibleItemPosition();
      } else {
        i = ((c)localObject).findLastVisibleItemPosition();
      }
      paramU = findViewByPosition(i);
      if ((paramU != null) && (paramU != paramView)) {
        return paramU;
      }
    }
    i = j;
    if (preferLastSpan(k))
    {
      i = mSpanCount - 1;
      while (i >= 0)
      {
        if (i != mIndex)
        {
          if (paramInt != 0) {
            j = mSpans[i].findFirstVisibleItemPosition();
          } else {
            j = mSpans[i].findLastVisibleItemPosition();
          }
          paramU = findViewByPosition(j);
          if ((paramU != null) && (paramU != paramView)) {
            return paramU;
          }
        }
        i -= 1;
      }
    }
    while (i < mSpanCount)
    {
      if (paramInt != 0) {
        j = mSpans[i].findFirstVisibleItemPosition();
      } else {
        j = mSpans[i].findLastVisibleItemPosition();
      }
      paramU = findViewByPosition(j);
      if ((paramU != null) && (paramU != paramView)) {
        return paramU;
      }
      i += 1;
    }
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      View localView1 = findFirstVisibleItemClosestToStart(false);
      View localView2 = findFirstVisibleItemClosestToEnd(false);
      if (localView1 != null)
      {
        if (localView2 == null) {
          return;
        }
        int i = getPosition(localView1);
        int j = getPosition(localView2);
        if (i < j)
        {
          paramAccessibilityEvent.setFromIndex(i);
          paramAccessibilityEvent.setToIndex(j);
          return;
        }
        paramAccessibilityEvent.setFromIndex(j);
        paramAccessibilityEvent.setToIndex(i);
      }
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 1);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    mLazySpanLookup.clear();
    requestLayout();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    handleUpdate(paramInt1, paramInt2, 8);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 2);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    handleUpdate(paramInt1, paramInt2, 4);
  }
  
  public void onLayoutChildren(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2)
  {
    mLazySpanLookup.clear();
    int i = 0;
    while (i < mSpanCount)
    {
      mSpans[i].clear();
      i += 1;
    }
  }
  
  public void onLayoutChildren(RecyclerView.u paramU, RecyclerView.y paramY)
  {
    onLayoutChildren(paramU, paramY, true);
  }
  
  public void onLayoutChildren(RecyclerView.y paramY)
  {
    super.onLayoutChildren(paramY);
    mPendingScrollPosition = -1;
    mPendingScrollPositionOffset = Integer.MIN_VALUE;
    mPendingSavedState = null;
    mAnchorInfo.reset();
  }
  
  public void onLayoutChildren(RecyclerView paramRecyclerView, RecyclerView.u paramU)
  {
    super.onLayoutChildren(paramRecyclerView, paramU);
    removeCallbacks(mCheckForGapsRunnable);
    int i = 0;
    while (i < mSpanCount)
    {
      mSpans[i].clear();
      i += 1;
    }
    paramRecyclerView.requestLayout();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      paramParcelable = (SavedState)paramParcelable;
      mPendingSavedState = paramParcelable;
      if (mPendingScrollPosition != -1)
      {
        paramParcelable.invalidateAnchorPositionInfo();
        mPendingSavedState.invalidateSpanInfo();
      }
      requestLayout();
    }
  }
  
  public PointF onSaveInstanceState(int paramInt)
  {
    paramInt = calculateScrollDirectionForPosition(paramInt);
    PointF localPointF = new PointF();
    if (paramInt == 0) {
      return null;
    }
    if (mOrientation == 0)
    {
      x = paramInt;
      y = 0.0F;
      return localPointF;
    }
    x = 0.0F;
    y = paramInt;
    return localPointF;
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (mPendingSavedState != null) {
      return new SavedState(mPendingSavedState);
    }
    SavedState localSavedState = new SavedState();
    mReverseLayout = mReverseLayout;
    mAnchorLayoutFromEnd = mLastLayoutFromEnd;
    mLastLayoutRTL = mLastLayoutRTL;
    LazySpanLookup localLazySpanLookup = mLazySpanLookup;
    int k = 0;
    if (localLazySpanLookup != null)
    {
      int[] arrayOfInt = mData;
      if (arrayOfInt != null)
      {
        mSpanLookup = arrayOfInt;
        mSpanLookupSize = arrayOfInt.length;
        mFullSpanItems = mFullSpanItems;
        break label114;
      }
    }
    mSpanLookupSize = 0;
    label114:
    if (getChildCount() > 0)
    {
      if (mLastLayoutFromEnd) {
        i = getLastChildPosition();
      } else {
        i = getFirstChildPosition();
      }
      mAnchorPosition = i;
      mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
      int i = mSpanCount;
      mSpanOffsetsSize = i;
      mSpanOffsets = new int[i];
      while (k < mSpanCount)
      {
        int m;
        if (mLastLayoutFromEnd)
        {
          m = mSpans[k].getEndLine(Integer.MIN_VALUE);
          i = m;
          j = i;
          if (m == Integer.MIN_VALUE) {
            break label263;
          }
          j = mPrimaryOrientation.getEndAfterPadding();
        }
        else
        {
          m = mSpans[k].getStartLine(Integer.MIN_VALUE);
          i = m;
          j = i;
          if (m == Integer.MIN_VALUE) {
            break label263;
          }
          j = mPrimaryOrientation.getStartAfterPadding();
        }
        int j = i - j;
        label263:
        mSpanOffsets[k] = j;
        k += 1;
      }
    }
    mAnchorPosition = -1;
    mVisibleAnchorPosition = -1;
    mSpanOffsetsSize = 0;
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      checkForGaps();
    }
  }
  
  int scrollBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    if (getChildCount() != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      scrollBy(paramInt, paramY);
      int i = fill(paramU, mLayoutState, paramY);
      if (mLayoutState.mAvailable >= i) {
        if (paramInt < 0) {
          paramInt = -i;
        } else {
          paramInt = i;
        }
      }
      mPrimaryOrientation.offsetChildren(-paramInt);
      mLastLayoutFromEnd = mShouldReverseLayout;
      paramY = mLayoutState;
      mAvailable = 0;
      recycle(paramU, paramY);
      return paramInt;
    }
    return 0;
  }
  
  void scrollBy(int paramInt, RecyclerView.y paramY)
  {
    int i;
    int j;
    if (paramInt > 0)
    {
      i = getLastChildPosition();
      j = 1;
    }
    else
    {
      j = -1;
      i = getFirstChildPosition();
    }
    mLayoutState.mRecycle = true;
    updateLayoutState(i, paramY);
    updateLayoutState(j);
    paramY = mLayoutState;
    mCurrentPosition = (i + mItemDirection);
    mAvailable = Math.abs(paramInt);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    return scrollBy(paramInt, paramU, paramY);
  }
  
  public void scrollToPosition(int paramInt)
  {
    SavedState localSavedState = mPendingSavedState;
    if ((localSavedState != null) && (mAnchorPosition != paramInt)) {
      localSavedState.invalidateAnchorPositionInfo();
    }
    mPendingScrollPosition = paramInt;
    mPendingScrollPositionOffset = Integer.MIN_VALUE;
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    return scrollBy(paramInt, paramU, paramY);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (mOrientation == 1)
    {
      paramInt2 = RecyclerView.o.chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      paramInt1 = RecyclerView.o.chooseSize(paramInt1, mSizePerSpan * mSpanCount + i, getMinimumWidth());
    }
    else
    {
      paramInt1 = RecyclerView.o.chooseSize(paramInt1, paramRect.width() + i, getMinimumWidth());
      paramInt2 = RecyclerView.o.chooseSize(paramInt2, mSizePerSpan * mSpanCount + j, getMinimumHeight());
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == mOrientation) {
      return;
    }
    mOrientation = paramInt;
    OrientationHelper localOrientationHelper = mPrimaryOrientation;
    mPrimaryOrientation = mSecondaryOrientation;
    mSecondaryOrientation = localOrientationHelper;
    requestLayout();
  }
  
  public boolean setOrientation()
  {
    return mGapStrategy != 0;
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    SavedState localSavedState = mPendingSavedState;
    if ((localSavedState != null) && (mReverseLayout != paramBoolean)) {
      mReverseLayout = paramBoolean;
    }
    mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setSpanCount(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt != mSpanCount)
    {
      invalidateSpanAssignments();
      mSpanCount = paramInt;
      mRemainingSpans = new BitSet(mSpanCount);
      mSpans = new c[mSpanCount];
      paramInt = 0;
      while (paramInt < mSpanCount)
      {
        mSpans[paramInt] = new c(paramInt);
        paramInt += 1;
      }
      requestLayout();
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.y paramY, int paramInt)
  {
    paramRecyclerView = new LinearSmoothScroller(paramRecyclerView.getContext());
    paramRecyclerView.d(paramInt);
    a(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return mPendingSavedState == null;
  }
  
  boolean updateAnchorFromPendingData(RecyclerView.y paramY, b paramB)
  {
    boolean bool2 = paramY.isPreLayout();
    boolean bool1 = false;
    if (!bool2)
    {
      int i = mPendingScrollPosition;
      if (i == -1) {
        return false;
      }
      if ((i >= 0) && (i < paramY.getItemCount()))
      {
        paramY = mPendingSavedState;
        if ((paramY != null) && (mAnchorPosition != -1) && (mSpanOffsetsSize >= 1))
        {
          mOffset = Integer.MIN_VALUE;
          mPosition = mPendingScrollPosition;
          return true;
        }
        paramY = findViewByPosition(mPendingScrollPosition);
        if (paramY != null)
        {
          if (mShouldReverseLayout) {
            i = getLastChildPosition();
          } else {
            i = getFirstChildPosition();
          }
          mPosition = i;
          if (mPendingScrollPositionOffset != Integer.MIN_VALUE)
          {
            if (mLayoutFromEnd)
            {
              mOffset = (mPrimaryOrientation.getEndAfterPadding() - mPendingScrollPositionOffset - mPrimaryOrientation.getDecoratedEnd(paramY));
              return true;
            }
            mOffset = (mPrimaryOrientation.getStartAfterPadding() + mPendingScrollPositionOffset - mPrimaryOrientation.getDecoratedStart(paramY));
            return true;
          }
          if (mPrimaryOrientation.getDecoratedMeasurement(paramY) > mPrimaryOrientation.getTotalSpace())
          {
            if (mLayoutFromEnd) {
              i = mPrimaryOrientation.getEndAfterPadding();
            } else {
              i = mPrimaryOrientation.getStartAfterPadding();
            }
            mOffset = i;
            return true;
          }
          i = mPrimaryOrientation.getDecoratedStart(paramY) - mPrimaryOrientation.getStartAfterPadding();
          if (i < 0)
          {
            mOffset = (-i);
            return true;
          }
          i = mPrimaryOrientation.getEndAfterPadding() - mPrimaryOrientation.getDecoratedEnd(paramY);
          if (i < 0)
          {
            mOffset = i;
            return true;
          }
          mOffset = Integer.MIN_VALUE;
          return true;
        }
        i = mPendingScrollPosition;
        mPosition = i;
        int j = mPendingScrollPositionOffset;
        if (j == Integer.MIN_VALUE)
        {
          if (calculateScrollDirectionForPosition(i) == 1) {
            bool1 = true;
          }
          mLayoutFromEnd = bool1;
          paramB.assignCoordinateFromPadding();
        }
        else
        {
          paramB.assignCoordinateFromPadding(j);
        }
        mInvalidateOffsets = true;
        return true;
      }
      mPendingScrollPosition = -1;
      mPendingScrollPositionOffset = Integer.MIN_VALUE;
    }
    return false;
  }
  
  void updateAnchorInfoForLayout(RecyclerView.y paramY, b paramB)
  {
    if (updateAnchorFromPendingData(paramY, paramB)) {
      return;
    }
    if (updateAnchorFromChildren(paramY, paramB)) {
      return;
    }
    paramB.assignCoordinateFromPadding();
    mPosition = 0;
  }
  
  void updateMeasureSpecs(int paramInt)
  {
    mSizePerSpan = (paramInt / mSpanCount);
    mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(paramInt, mSecondaryOrientation.getMode());
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    boolean mFullSpan;
    StaggeredGridLayoutManager.c mSpan;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public boolean isFullSpan()
    {
      return mFullSpan;
    }
  }
  
  static class LazySpanLookup
  {
    int[] mData;
    List<FullSpanItem> mFullSpanItems;
    
    LazySpanLookup() {}
    
    private int invalidateFullSpansAfter(int paramInt)
    {
      if (mFullSpanItems == null) {
        return -1;
      }
      FullSpanItem localFullSpanItem = getFullSpanItem(paramInt);
      if (localFullSpanItem != null) {
        mFullSpanItems.remove(localFullSpanItem);
      }
      int j = mFullSpanItems.size();
      int i = 0;
      while (i < j)
      {
        if (mFullSpanItems.get(i)).mPosition >= paramInt) {
          break label82;
        }
        i += 1;
      }
      i = -1;
      label82:
      if (i != -1)
      {
        localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
        mFullSpanItems.remove(i);
        return mPosition;
      }
      return -1;
    }
    
    private void offsetFullSpansForAddition(int paramInt1, int paramInt2)
    {
      Object localObject = mFullSpanItems;
      if (localObject == null) {
        return;
      }
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (FullSpanItem)mFullSpanItems.get(i);
        int j = mPosition;
        if (j >= paramInt1) {
          mPosition = (j + paramInt2);
        }
        i -= 1;
      }
    }
    
    private void offsetFullSpansForRemoval(int paramInt1, int paramInt2)
    {
      Object localObject = mFullSpanItems;
      if (localObject == null) {
        return;
      }
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (FullSpanItem)mFullSpanItems.get(i);
        int j = mPosition;
        if (j >= paramInt1) {
          if (j < paramInt1 + paramInt2) {
            mFullSpanItems.remove(i);
          } else {
            mPosition = (j - paramInt2);
          }
        }
        i -= 1;
      }
    }
    
    public void addFullSpanItem(FullSpanItem paramFullSpanItem)
    {
      if (mFullSpanItems == null) {
        mFullSpanItems = new ArrayList();
      }
      int j = mFullSpanItems.size();
      int i = 0;
      while (i < j)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
        if (mPosition == mPosition) {
          mFullSpanItems.remove(i);
        }
        if (mPosition >= mPosition)
        {
          mFullSpanItems.add(i, paramFullSpanItem);
          return;
        }
        i += 1;
      }
      mFullSpanItems.add(paramFullSpanItem);
    }
    
    void clear()
    {
      int[] arrayOfInt = mData;
      if (arrayOfInt != null) {
        Arrays.fill(arrayOfInt, -1);
      }
      mFullSpanItems = null;
    }
    
    void ensureSize(int paramInt)
    {
      int[] arrayOfInt1 = mData;
      if (arrayOfInt1 == null)
      {
        arrayOfInt1 = new int[Math.max(paramInt, 10) + 1];
        mData = arrayOfInt1;
        Arrays.fill(arrayOfInt1, -1);
        return;
      }
      if (paramInt >= arrayOfInt1.length)
      {
        int[] arrayOfInt2 = new int[sizeForPosition(paramInt)];
        mData = arrayOfInt2;
        System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
        arrayOfInt2 = mData;
        Arrays.fill(arrayOfInt2, arrayOfInt1.length, arrayOfInt2.length, -1);
      }
    }
    
    int forceInvalidateAfter(int paramInt)
    {
      List localList = mFullSpanItems;
      if (localList != null)
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          if (mFullSpanItems.get(i)).mPosition >= paramInt) {
            mFullSpanItems.remove(i);
          }
          i -= 1;
        }
      }
      return invalidateAfter(paramInt);
    }
    
    public FullSpanItem getFirstFullSpanItemInRange(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      Object localObject = mFullSpanItems;
      if (localObject == null) {
        return null;
      }
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        localObject = (FullSpanItem)mFullSpanItems.get(i);
        int k = mPosition;
        if (k >= paramInt2) {
          return null;
        }
        if (k >= paramInt1)
        {
          if ((paramInt3 == 0) || (mGapDir == paramInt3)) {
            break label109;
          }
          if ((paramBoolean) && (mHasUnwantedGapAfter)) {
            return localObject;
          }
        }
        i += 1;
      }
      return null;
      label109:
      return localObject;
    }
    
    public FullSpanItem getFullSpanItem(int paramInt)
    {
      Object localObject = mFullSpanItems;
      if (localObject == null) {
        return null;
      }
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (FullSpanItem)mFullSpanItems.get(i);
        if (mPosition == paramInt) {
          return localObject;
        }
        i -= 1;
      }
      return null;
    }
    
    int getSpan(int paramInt)
    {
      int[] arrayOfInt = mData;
      if ((arrayOfInt != null) && (paramInt < arrayOfInt.length)) {
        return arrayOfInt[paramInt];
      }
      return -1;
    }
    
    int invalidateAfter(int paramInt)
    {
      int[] arrayOfInt = mData;
      if (arrayOfInt == null) {
        return -1;
      }
      if (paramInt >= arrayOfInt.length) {
        return -1;
      }
      int i = invalidateFullSpansAfter(paramInt);
      if (i == -1)
      {
        arrayOfInt = mData;
        Arrays.fill(arrayOfInt, paramInt, arrayOfInt.length, -1);
        return mData.length;
      }
      i = Math.min(i + 1, mData.length);
      Arrays.fill(mData, paramInt, i, -1);
      return i;
    }
    
    void offsetForAddition(int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = mData;
      if (arrayOfInt != null)
      {
        if (paramInt1 >= arrayOfInt.length) {
          return;
        }
        int i = paramInt1 + paramInt2;
        ensureSize(i);
        arrayOfInt = mData;
        System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, i, arrayOfInt.length - paramInt1 - paramInt2);
        Arrays.fill(mData, paramInt1, i, -1);
        offsetFullSpansForAddition(paramInt1, paramInt2);
      }
    }
    
    void offsetForRemoval(int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = mData;
      if (arrayOfInt != null)
      {
        if (paramInt1 >= arrayOfInt.length) {
          return;
        }
        int i = paramInt1 + paramInt2;
        ensureSize(i);
        arrayOfInt = mData;
        System.arraycopy(arrayOfInt, i, arrayOfInt, paramInt1, arrayOfInt.length - paramInt1 - paramInt2);
        arrayOfInt = mData;
        Arrays.fill(arrayOfInt, arrayOfInt.length - paramInt2, arrayOfInt.length, -1);
        offsetFullSpansForRemoval(paramInt1, paramInt2);
      }
    }
    
    void setSpan(int paramInt, StaggeredGridLayoutManager.c paramC)
    {
      ensureSize(paramInt);
      mData[paramInt] = mIndex;
    }
    
    int sizeForPosition(int paramInt)
    {
      int i = mData.length;
      while (i <= paramInt) {
        i *= 2;
      }
      return i;
    }
    
    static class FullSpanItem
      implements Parcelable
    {
      public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();
      int mGapDir;
      int[] mGapPerSpan;
      boolean mHasUnwantedGapAfter;
      int mPosition;
      
      FullSpanItem() {}
      
      FullSpanItem(Parcel paramParcel)
      {
        mPosition = paramParcel.readInt();
        mGapDir = paramParcel.readInt();
        int i = paramParcel.readInt();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        mHasUnwantedGapAfter = bool;
        i = paramParcel.readInt();
        if (i > 0)
        {
          int[] arrayOfInt = new int[i];
          mGapPerSpan = arrayOfInt;
          paramParcel.readIntArray(arrayOfInt);
        }
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      int getGapForSpan(int paramInt)
      {
        int[] arrayOfInt = mGapPerSpan;
        if (arrayOfInt == null) {
          return 0;
        }
        return arrayOfInt[paramInt];
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FullSpanItem{mPosition=");
        localStringBuilder.append(mPosition);
        localStringBuilder.append(", mGapDir=");
        localStringBuilder.append(mGapDir);
        localStringBuilder.append(", mHasUnwantedGapAfter=");
        localStringBuilder.append(mHasUnwantedGapAfter);
        localStringBuilder.append(", mGapPerSpan=");
        localStringBuilder.append(Arrays.toString(mGapPerSpan));
        localStringBuilder.append('}');
        return localStringBuilder.toString();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
      }
      
      class a
        implements Parcelable.Creator<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem>
      {
        a() {}
        
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] a(int paramInt)
        {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[paramInt];
        }
        
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem readDate(Parcel paramParcel)
        {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(paramParcel);
        }
      }
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    boolean mAnchorLayoutFromEnd;
    int mAnchorPosition;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> mFullSpanItems;
    boolean mLastLayoutRTL;
    boolean mReverseLayout;
    int[] mSpanLookup;
    int mSpanLookupSize;
    int[] mSpanOffsets;
    int mSpanOffsetsSize;
    int mVisibleAnchorPosition;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      mAnchorPosition = paramParcel.readInt();
      mVisibleAnchorPosition = paramParcel.readInt();
      int i = paramParcel.readInt();
      mSpanOffsetsSize = i;
      int[] arrayOfInt;
      if (i > 0)
      {
        arrayOfInt = new int[i];
        mSpanOffsets = arrayOfInt;
        paramParcel.readIntArray(arrayOfInt);
      }
      i = paramParcel.readInt();
      mSpanLookupSize = i;
      if (i > 0)
      {
        arrayOfInt = new int[i];
        mSpanLookup = arrayOfInt;
        paramParcel.readIntArray(arrayOfInt);
      }
      i = paramParcel.readInt();
      boolean bool2 = false;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      mReverseLayout = bool1;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      mAnchorLayoutFromEnd = bool1;
      boolean bool1 = bool2;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      }
      mLastLayoutRTL = bool1;
      mFullSpanItems = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
    }
    
    public SavedState(SavedState paramSavedState)
    {
      mSpanOffsetsSize = mSpanOffsetsSize;
      mAnchorPosition = mAnchorPosition;
      mVisibleAnchorPosition = mVisibleAnchorPosition;
      mSpanOffsets = mSpanOffsets;
      mSpanLookupSize = mSpanLookupSize;
      mSpanLookup = mSpanLookup;
      mReverseLayout = mReverseLayout;
      mAnchorLayoutFromEnd = mAnchorLayoutFromEnd;
      mLastLayoutRTL = mLastLayoutRTL;
      mFullSpanItems = mFullSpanItems;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    void invalidateAnchorPositionInfo()
    {
      mSpanOffsets = null;
      mSpanOffsetsSize = 0;
      mAnchorPosition = -1;
      mVisibleAnchorPosition = -1;
    }
    
    void invalidateSpanInfo()
    {
      mSpanOffsets = null;
      mSpanOffsetsSize = 0;
      mSpanLookupSize = 0;
      mSpanLookup = null;
      mFullSpanItems = null;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    class a
      implements Parcelable.Creator<StaggeredGridLayoutManager.SavedState>
    {
      a() {}
      
      public StaggeredGridLayoutManager.SavedState[] a(int paramInt)
      {
        return new StaggeredGridLayoutManager.SavedState[paramInt];
      }
      
      public StaggeredGridLayoutManager.SavedState readDate(Parcel paramParcel)
      {
        return new StaggeredGridLayoutManager.SavedState(paramParcel);
      }
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      checkForGaps();
    }
  }
  
  class b
  {
    boolean mInvalidateOffsets;
    boolean mLaidOutInvalidFullSpan;
    boolean mLayoutFromEnd;
    int mOffset;
    int mPosition;
    int[] mShouldReverseLayout;
    
    b()
    {
      reset();
    }
    
    void assignCoordinateFromPadding()
    {
      int i;
      if (mLayoutFromEnd) {
        i = mPrimaryOrientation.getEndAfterPadding();
      } else {
        i = mPrimaryOrientation.getStartAfterPadding();
      }
      mOffset = i;
    }
    
    void assignCoordinateFromPadding(int paramInt)
    {
      if (mLayoutFromEnd)
      {
        mOffset = (mPrimaryOrientation.getEndAfterPadding() - paramInt);
        return;
      }
      mOffset = (mPrimaryOrientation.getStartAfterPadding() + paramInt);
    }
    
    void onLayoutChildren(StaggeredGridLayoutManager.c[] paramArrayOfC)
    {
      int j = paramArrayOfC.length;
      int[] arrayOfInt = mShouldReverseLayout;
      if ((arrayOfInt == null) || (arrayOfInt.length < j)) {
        mShouldReverseLayout = new int[mSpans.length];
      }
      int i = 0;
      while (i < j)
      {
        mShouldReverseLayout[i] = paramArrayOfC[i].getStartLine(Integer.MIN_VALUE);
        i += 1;
      }
    }
    
    void reset()
    {
      mPosition = -1;
      mOffset = Integer.MIN_VALUE;
      mLayoutFromEnd = false;
      mInvalidateOffsets = false;
      mLaidOutInvalidFullSpan = false;
      int[] arrayOfInt = mShouldReverseLayout;
      if (arrayOfInt != null) {
        Arrays.fill(arrayOfInt, -1);
      }
    }
  }
  
  class c
  {
    int mCachedEnd = Integer.MIN_VALUE;
    int mCachedStart = Integer.MIN_VALUE;
    int mDeletedSize = 0;
    final int mIndex;
    ArrayList<View> mViews = new ArrayList();
    
    c(int paramInt)
    {
      mIndex = paramInt;
    }
    
    void appendToSpan(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(paramView);
      mSpan = this;
      mViews.add(0, paramView);
      mCachedStart = Integer.MIN_VALUE;
      if (mViews.size() == 1) {
        mCachedEnd = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        mDeletedSize += mPrimaryOrientation.getDecoratedMeasurement(paramView);
      }
    }
    
    void cacheReferenceLineAndClear(boolean paramBoolean, int paramInt)
    {
      int i;
      if (paramBoolean) {
        i = getEndLine(Integer.MIN_VALUE);
      } else {
        i = getStartLine(Integer.MIN_VALUE);
      }
      clear();
      if (i == Integer.MIN_VALUE) {
        return;
      }
      if ((!paramBoolean) || (i >= mPrimaryOrientation.getEndAfterPadding()))
      {
        if ((!paramBoolean) && (i > mPrimaryOrientation.getStartAfterPadding())) {
          return;
        }
        int j = i;
        if (paramInt != Integer.MIN_VALUE) {
          j = i + paramInt;
        }
        mCachedEnd = j;
        mCachedStart = j;
      }
    }
    
    void calculateCachedEnd()
    {
      Object localObject = mViews;
      localObject = (View)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams((View)localObject);
      mCachedEnd = mPrimaryOrientation.getDecoratedEnd((View)localObject);
      if (mFullSpan)
      {
        localObject = mLazySpanLookup.getFullSpanItem(localLayoutParams.getViewLayoutPosition());
        if ((localObject != null) && (mGapDir == 1)) {
          mCachedEnd += ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(mIndex);
        }
      }
    }
    
    void calculateCachedStart()
    {
      Object localObject = (View)mViews.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams((View)localObject);
      mCachedStart = mPrimaryOrientation.getDecoratedStart((View)localObject);
      if (mFullSpan)
      {
        localObject = mLazySpanLookup.getFullSpanItem(localLayoutParams.getViewLayoutPosition());
        if ((localObject != null) && (mGapDir == -1)) {
          mCachedStart -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(mIndex);
        }
      }
    }
    
    void clear()
    {
      mViews.clear();
      invalidateCache();
      mDeletedSize = 0;
    }
    
    public int findFirstVisibleItemPosition()
    {
      if (mReverseLayout) {
        return findOneVisibleChild(mViews.size() - 1, -1, true);
      }
      return findOneVisibleChild(0, mViews.size(), true);
    }
    
    public int findLastVisibleItemPosition()
    {
      if (mReverseLayout) {
        return findOneVisibleChild(0, mViews.size(), true);
      }
      return findOneVisibleChild(mViews.size() - 1, -1, true);
    }
    
    int findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return findOneVisibleChild(paramInt1, paramInt2, false, false, paramBoolean);
    }
    
    int findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      int m = mPrimaryOrientation.getStartAfterPadding();
      int n = mPrimaryOrientation.getEndAfterPadding();
      int i;
      if (paramInt2 > paramInt1) {
        i = 1;
      } else {
        i = -1;
      }
      while (paramInt1 != paramInt2)
      {
        View localView = (View)mViews.get(paramInt1);
        int i1 = mPrimaryOrientation.getDecoratedStart(localView);
        int i2 = mPrimaryOrientation.getDecoratedEnd(localView);
        int k = 0;
        int j;
        if (paramBoolean3 ? i1 <= n : i1 < n) {
          j = 1;
        } else {
          j = 0;
        }
        if (paramBoolean3 ? i2 >= m : i2 > m) {
          k = 1;
        }
        if ((j != 0) && (k != 0)) {
          if ((paramBoolean1) && (paramBoolean2))
          {
            if ((i1 >= m) && (i2 <= n)) {
              return getPosition(localView);
            }
          }
          else
          {
            if (paramBoolean2) {
              return getPosition(localView);
            }
            if ((i1 < m) || (i2 > n)) {
              return getPosition(localView);
            }
          }
        }
        paramInt1 += i;
      }
      return -1;
    }
    
    public int getDeletedSize()
    {
      return mDeletedSize;
    }
    
    int getEndLine()
    {
      int i = mCachedEnd;
      if (i != Integer.MIN_VALUE) {
        return i;
      }
      calculateCachedEnd();
      return mCachedEnd;
    }
    
    int getEndLine(int paramInt)
    {
      int i = mCachedEnd;
      if (i != Integer.MIN_VALUE) {
        return i;
      }
      if (mViews.size() == 0) {
        return paramInt;
      }
      calculateCachedEnd();
      return mCachedEnd;
    }
    
    public View getFocusableViewAfter(int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      View localView;
      StaggeredGridLayoutManager localStaggeredGridLayoutManager;
      if (paramInt2 == -1)
      {
        int i = mViews.size();
        paramInt2 = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (paramInt2 >= i) {
            break;
          }
          localView = (View)mViews.get(paramInt2);
          localStaggeredGridLayoutManager = StaggeredGridLayoutManager.this;
          if (mReverseLayout)
          {
            localObject2 = localObject1;
            if (localStaggeredGridLayoutManager.getPosition(localView) <= paramInt1) {
              break;
            }
          }
          localObject2 = StaggeredGridLayoutManager.this;
          if ((!mReverseLayout) && (((RecyclerView.o)localObject2).getPosition(localView) >= paramInt1)) {
            return localObject1;
          }
          localObject2 = localObject1;
          if (!localView.hasFocusable()) {
            break;
          }
          paramInt2 += 1;
          localObject1 = localView;
        }
      }
      paramInt2 = mViews.size() - 1;
      for (localObject1 = localObject2;; localObject1 = localView)
      {
        localObject2 = localObject1;
        if (paramInt2 < 0) {
          break;
        }
        localView = (View)mViews.get(paramInt2);
        localStaggeredGridLayoutManager = StaggeredGridLayoutManager.this;
        if (mReverseLayout)
        {
          localObject2 = localObject1;
          if (localStaggeredGridLayoutManager.getPosition(localView) >= paramInt1) {
            break;
          }
        }
        localObject2 = StaggeredGridLayoutManager.this;
        if ((!mReverseLayout) && (((RecyclerView.o)localObject2).getPosition(localView) <= paramInt1)) {
          return localObject1;
        }
        localObject2 = localObject1;
        if (!localView.hasFocusable()) {
          break;
        }
        paramInt2 -= 1;
      }
      return localObject2;
    }
    
    StaggeredGridLayoutManager.LayoutParams getLayoutParams(View paramView)
    {
      return (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    }
    
    int getStartLine()
    {
      int i = mCachedStart;
      if (i != Integer.MIN_VALUE) {
        return i;
      }
      calculateCachedStart();
      return mCachedStart;
    }
    
    int getStartLine(int paramInt)
    {
      int i = mCachedStart;
      if (i != Integer.MIN_VALUE) {
        return i;
      }
      if (mViews.size() == 0) {
        return paramInt;
      }
      calculateCachedStart();
      return mCachedStart;
    }
    
    void invalidateCache()
    {
      mCachedStart = Integer.MIN_VALUE;
      mCachedEnd = Integer.MIN_VALUE;
    }
    
    void onOffset(int paramInt)
    {
      int i = mCachedStart;
      if (i != Integer.MIN_VALUE) {
        mCachedStart = (i + paramInt);
      }
      i = mCachedEnd;
      if (i != Integer.MIN_VALUE) {
        mCachedEnd = (i + paramInt);
      }
    }
    
    void popEnd()
    {
      int i = mViews.size();
      View localView = (View)mViews.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
      mSpan = null;
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        mDeletedSize -= mPrimaryOrientation.getDecoratedMeasurement(localView);
      }
      if (i == 1) {
        mCachedStart = Integer.MIN_VALUE;
      }
      mCachedEnd = Integer.MIN_VALUE;
    }
    
    void popStart()
    {
      View localView = (View)mViews.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
      mSpan = null;
      if (mViews.size() == 0) {
        mCachedEnd = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        mDeletedSize -= mPrimaryOrientation.getDecoratedMeasurement(localView);
      }
      mCachedStart = Integer.MIN_VALUE;
    }
    
    void prependToSpan(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(paramView);
      mSpan = this;
      mViews.add(paramView);
      mCachedEnd = Integer.MIN_VALUE;
      if (mViews.size() == 1) {
        mCachedStart = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        mDeletedSize += mPrimaryOrientation.getDecoratedMeasurement(paramView);
      }
    }
    
    void setLine(int paramInt)
    {
      mCachedStart = paramInt;
      mCachedEnd = paramInt;
    }
  }
}
