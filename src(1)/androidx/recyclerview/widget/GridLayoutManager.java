package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.package_13.asm.ByteVector;

public class GridLayoutManager
  extends LinearLayoutManager
{
  int[] mCachedBorders;
  final Rect mOrientation = new Rect();
  boolean mPendingSpanCountChange = false;
  final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
  final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
  View[] mSet;
  int mSpanCount = -1;
  b mSpanSizeLookup = new a();
  private boolean mState;
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt2, paramBoolean);
    setSpanCount(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setSpanCount(getPropertiesspanCount);
  }
  
  private void assignSpans(RecyclerView.u paramU, RecyclerView.y paramY, int paramInt, boolean paramBoolean)
  {
    int k = 0;
    int i = -1;
    int j;
    int m;
    if (paramBoolean)
    {
      j = 1;
      m = 0;
      i = paramInt;
      paramInt = m;
    }
    else
    {
      paramInt -= 1;
      j = -1;
    }
    while (paramInt != i)
    {
      View localView = mSet[paramInt];
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      m = getSpanSize(paramU, paramY, getPosition(localView));
      mOrientation = m;
      mSpanCount = k;
      k += m;
      paramInt += j;
    }
  }
  
  private void cachePreLayoutSpanMapping()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
      int k = localLayoutParams.getViewLayoutPosition();
      mPreLayoutSpanSizeCache.put(k, localLayoutParams.getSpanSize());
      mPreLayoutSpanIndexCache.put(k, localLayoutParams.getSpanIndex());
      i += 1;
    }
  }
  
  private void calculateItemBorders(int paramInt)
  {
    mCachedBorders = calculateItemBorders(mCachedBorders, mSpanCount, paramInt);
  }
  
  static int[] calculateItemBorders(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = 1;
    int[] arrayOfInt;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length == paramInt1 + 1))
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt[(paramArrayOfInt.length - 1)] == paramInt2) {}
    }
    else
    {
      arrayOfInt = new int[paramInt1 + 1];
    }
    int k = 0;
    arrayOfInt[0] = 0;
    int m = paramInt2 / paramInt1;
    int n = paramInt2 % paramInt1;
    int i = 0;
    paramInt2 = k;
    while (j <= paramInt1)
    {
      paramInt2 += n;
      if ((paramInt2 > 0) && (paramInt1 - paramInt2 < n))
      {
        k = m + 1;
        paramInt2 -= paramInt1;
      }
      else
      {
        k = m;
      }
      i += k;
      arrayOfInt[j] = i;
      j += 1;
    }
    return arrayOfInt;
  }
  
  private void clearPreLayoutSpanMappingCache()
  {
    mPreLayoutSpanSizeCache.clear();
    mPreLayoutSpanIndexCache.clear();
  }
  
  private int computeScrollOffset(RecyclerView.y paramY)
  {
    if (getChildCount() != 0)
    {
      if (paramY.getItemCount() == 0) {
        return 0;
      }
      ensureLayoutState();
      boolean bool = computeScrollOffset();
      View localView1 = findFirstVisibleChildClosestToEnd(bool ^ true, true);
      View localView2 = findFirstVisibleChildClosestToStart(bool ^ true, true);
      if (localView1 != null)
      {
        if (localView2 == null) {
          return 0;
        }
        int j = mSpanSizeLookup.getCachedSpanIndex(getPosition(localView1), mSpanCount);
        int k = mSpanSizeLookup.getCachedSpanIndex(getPosition(localView2), mSpanCount);
        int i = Math.min(j, k);
        j = Math.max(j, k);
        k = mSpanSizeLookup.getCachedSpanIndex(paramY.getItemCount() - 1, mSpanCount);
        if (mShouldReverseLayout) {
          i = Math.max(0, k + 1 - j - 1);
        } else {
          i = Math.max(0, i);
        }
        if (!bool) {
          return i;
        }
        j = Math.abs(mOrientationHelper.getDecoratedEnd(localView2) - mOrientationHelper.getDecoratedStart(localView1));
        k = mSpanSizeLookup.getCachedSpanIndex(getPosition(localView1), mSpanCount);
        int m = mSpanSizeLookup.getCachedSpanIndex(getPosition(localView2), mSpanCount);
        float f = j / (m - k + 1);
        return Math.round(i * f + (mOrientationHelper.getStartAfterPadding() - mOrientationHelper.getDecoratedStart(localView1)));
      }
    }
    return 0;
  }
  
  private int computeScrollRange(RecyclerView.y paramY)
  {
    if (getChildCount() != 0)
    {
      if (paramY.getItemCount() == 0) {
        return 0;
      }
      ensureLayoutState();
      View localView1 = findFirstVisibleChildClosestToEnd(computeScrollOffset() ^ true, true);
      View localView2 = findFirstVisibleChildClosestToStart(computeScrollOffset() ^ true, true);
      if (localView1 != null)
      {
        if (localView2 == null) {
          return 0;
        }
        if (!computeScrollOffset()) {
          return mSpanSizeLookup.getCachedSpanIndex(paramY.getItemCount() - 1, mSpanCount) + 1;
        }
        int i = mOrientationHelper.getDecoratedEnd(localView2);
        int j = mOrientationHelper.getDecoratedStart(localView1);
        int k = mSpanSizeLookup.getCachedSpanIndex(getPosition(localView1), mSpanCount);
        int m = mSpanSizeLookup.getCachedSpanIndex(getPosition(localView2), mSpanCount);
        int n = mSpanSizeLookup.getCachedSpanIndex(paramY.getItemCount() - 1, mSpanCount);
        return (int)((i - j) / (m - k + 1) * (n + 1));
      }
    }
    return 0;
  }
  
  private void ensureAnchorIsInCorrectSpan(RecyclerView.u paramU, RecyclerView.y paramY, LinearLayoutManager.a paramA, int paramInt)
  {
    if (paramInt == 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i = getSpanIndex(paramU, paramY, mPosition);
    if (paramInt != 0) {
      while (i > 0)
      {
        paramInt = mPosition;
        if (paramInt <= 0) {
          break;
        }
        paramInt -= 1;
        mPosition = paramInt;
        i = getSpanIndex(paramU, paramY, paramInt);
      }
    }
    int m = paramY.getItemCount();
    paramInt = mPosition;
    while (paramInt < m - 1)
    {
      int k = paramInt + 1;
      int j = getSpanIndex(paramU, paramY, k);
      if (j <= i) {
        break;
      }
      paramInt = k;
      i = j;
    }
    mPosition = paramInt;
  }
  
  private void ensureViewSet()
  {
    View[] arrayOfView = mSet;
    if ((arrayOfView == null) || (arrayOfView.length != mSpanCount)) {
      mSet = new View[mSpanCount];
    }
  }
  
  private int getSpanGroupIndex(RecyclerView.u paramU, RecyclerView.y paramY, int paramInt)
  {
    if (!paramY.isPreLayout()) {
      return mSpanSizeLookup.getCachedSpanIndex(paramInt, mSpanCount);
    }
    int i = paramU.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramU = new StringBuilder();
      paramU.append("Cannot find span size for pre layout position. ");
      paramU.append(paramInt);
      Log.w("GridLayoutManager", paramU.toString());
      return 0;
    }
    return mSpanSizeLookup.getCachedSpanIndex(i, mSpanCount);
  }
  
  private int getSpanIndex(RecyclerView.u paramU, RecyclerView.y paramY, int paramInt)
  {
    if (!paramY.isPreLayout()) {
      return mSpanSizeLookup.get(paramInt, mSpanCount);
    }
    int i = mPreLayoutSpanIndexCache.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramU.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramU = new StringBuilder();
      paramU.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      paramU.append(paramInt);
      Log.w("GridLayoutManager", paramU.toString());
      return 0;
    }
    return mSpanSizeLookup.get(i, mSpanCount);
  }
  
  private int getSpanSize(RecyclerView.u paramU, RecyclerView.y paramY, int paramInt)
  {
    if (!paramY.isPreLayout()) {
      return mSpanSizeLookup.getSpanSize(paramInt);
    }
    int i = mPreLayoutSpanSizeCache.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramU.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramU = new StringBuilder();
      paramU.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      paramU.append(paramInt);
      Log.w("GridLayoutManager", paramU.toString());
      return 1;
    }
    return mSpanSizeLookup.getSpanSize(i);
  }
  
  private void guessMeasurement(float paramFloat, int paramInt)
  {
    calculateItemBorders(Math.max(Math.round(paramFloat * mSpanCount), paramInt));
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {
      paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    } else {
      paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    }
    if (paramBoolean) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt, boolean paramBoolean)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = mDecorInsets;
    int j = top + bottom + topMargin + bottomMargin;
    int i = left + right + leftMargin + rightMargin;
    int k = assignSpans(mSpanCount, mOrientation);
    if (mOrientation == 1)
    {
      i = RecyclerView.o.getChildMeasureSpec(k, paramInt, i, width, false);
      paramInt = RecyclerView.o.getChildMeasureSpec(mOrientationHelper.getTotalSpace(), getHeightMode(), j, height, true);
    }
    else
    {
      paramInt = RecyclerView.o.getChildMeasureSpec(k, paramInt, j, height, false);
      i = RecyclerView.o.getChildMeasureSpec(mOrientationHelper.getTotalSpace(), getWidthMode(), i, width, true);
    }
    measureChildWithDecorationsAndMargin(paramView, i, paramInt, paramBoolean);
  }
  
  private void updateMeasurements()
  {
    int i;
    int j;
    if (getOrientation() == 1)
    {
      i = getWidth() - getPaddingRight();
      j = getPaddingLeft();
    }
    else
    {
      i = getHeight() - getPaddingBottom();
      j = getPaddingTop();
    }
    calculateItemBorders(i - j);
  }
  
  int assignSpans(int paramInt1, int paramInt2)
  {
    if ((mOrientation == 1) && (isLayoutRTL()))
    {
      arrayOfInt = mCachedBorders;
      int i = mSpanCount;
      return arrayOfInt[(i - paramInt1)] - arrayOfInt[(i - paramInt1 - paramInt2)];
    }
    int[] arrayOfInt = mCachedBorders;
    return arrayOfInt[(paramInt2 + paramInt1)] - arrayOfInt[paramInt1];
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.y paramY)
  {
    if (mState) {
      return computeScrollOffset(paramY);
    }
    return super.computeHorizontalScrollOffset(paramY);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.y paramY)
  {
    if (mState) {
      return computeScrollRange(paramY);
    }
    return super.computeHorizontalScrollRange(paramY);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.y paramY)
  {
    if (mState) {
      return computeScrollOffset(paramY);
    }
    return super.computeVerticalScrollOffset(paramY);
  }
  
  public int computeVerticalScrollRange(RecyclerView.y paramY)
  {
    if (mState) {
      return computeScrollRange(paramY);
    }
    return super.computeVerticalScrollRange(paramY);
  }
  
  void fill(RecyclerView.y paramY, LinearLayoutManager.c paramC, RecyclerView.o.c paramC1)
  {
    int j = mSpanCount;
    int i = 0;
    while ((i < mSpanCount) && (paramC.hasMore(paramY)) && (j > 0))
    {
      int k = mCurrentPosition;
      paramC1.set(k, Math.max(0, mScrollingOffset));
      j -= mSpanSizeLookup.getSpanSize(k);
      mCurrentPosition += mItemDirection;
      i += 1;
    }
  }
  
  View findReferenceChild(RecyclerView.u paramU, RecyclerView.y paramY, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = -1;
    int k = 1;
    int i;
    if (paramBoolean2)
    {
      i = getChildCount() - 1;
      k = -1;
    }
    else
    {
      j = getChildCount();
      i = 0;
    }
    int m = paramY.getItemCount();
    ensureLayoutState();
    int n = mOrientationHelper.getStartAfterPadding();
    int i1 = mOrientationHelper.getEndAfterPadding();
    Object localObject2 = null;
    Object localObject4;
    for (Object localObject1 = null; i != j; localObject1 = localObject4)
    {
      View localView = getChildAt(i);
      int i2 = getPosition(localView);
      Object localObject3 = localObject2;
      localObject4 = localObject1;
      if (i2 >= 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (i2 < m) {
          if (getSpanIndex(paramU, paramY, i2) != 0)
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
          }
          else if (((RecyclerView.LayoutParams)localView.getLayoutParams()).isItemRemoved())
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject1 == null)
            {
              localObject4 = localView;
              localObject3 = localObject2;
            }
          }
          else
          {
            if ((mOrientationHelper.getDecoratedStart(localView) < i1) && (mOrientationHelper.getDecoratedEnd(localView) >= n)) {
              return localView;
            }
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject2 == null)
            {
              localObject3 = localView;
              localObject4 = localObject1;
            }
          }
        }
      }
      i += k;
      localObject2 = localObject3;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    return localObject1;
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
  
  public int getColumnCountForAccessibility(RecyclerView.u paramU, RecyclerView.y paramY)
  {
    if (mOrientation == 0) {
      return mSpanCount;
    }
    if (paramY.getItemCount() < 1) {
      return 0;
    }
    return getSpanGroupIndex(paramU, paramY, paramY.getItemCount() - 1) + 1;
  }
  
  public int getRowCountForAccessibility(RecyclerView.u paramU, RecyclerView.y paramY)
  {
    if (mOrientation == 1) {
      return mSpanCount;
    }
    if (paramY.getItemCount() < 1) {
      return 0;
    }
    return getSpanGroupIndex(paramU, paramY, paramY.getItemCount() - 1) + 1;
  }
  
  public int getTag()
  {
    return mSpanCount;
  }
  
  void layoutChunk(RecyclerView.u paramU, RecyclerView.y paramY, LinearLayoutManager.c paramC, LinearLayoutManager.b paramB)
  {
    int i3 = mOrientationHelper.getModeInOther();
    int k;
    if (i3 != 1073741824) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (getChildCount() > 0) {
      m = mCachedBorders[mSpanCount];
    } else {
      m = 0;
    }
    if (k != 0) {
      updateMeasurements();
    }
    boolean bool;
    if (mItemDirection == 1) {
      bool = true;
    } else {
      bool = false;
    }
    int i = mSpanCount;
    if (!bool) {
      i = getSpanIndex(paramU, paramY, mCurrentPosition) + getSpanSize(paramU, paramY, mCurrentPosition);
    }
    int n = 0;
    Object localObject;
    while ((n < mSpanCount) && (paramC.hasMore(paramY)) && (i > 0))
    {
      j = mCurrentPosition;
      i1 = getSpanSize(paramU, paramY, j);
      if (i1 <= mSpanCount)
      {
        i -= i1;
        if (i >= 0)
        {
          localObject = paramC.next(paramU);
          if (localObject != null)
          {
            mSet[n] = localObject;
            n += 1;
          }
        }
      }
      else
      {
        paramU = new StringBuilder();
        paramU.append("Item at position ");
        paramU.append(j);
        paramU.append(" requires ");
        paramU.append(i1);
        paramU.append(" spans but GridLayoutManager has only ");
        paramU.append(mSpanCount);
        paramU.append(" spans.");
        throw new IllegalArgumentException(paramU.toString());
      }
    }
    if (n == 0)
    {
      mFinished = true;
      return;
    }
    float f1 = 0.0F;
    assignSpans(paramU, paramY, n, bool);
    int j = 0;
    i = 0;
    int i2;
    while (j < n)
    {
      paramU = mSet[j];
      if (mScrapList == null)
      {
        if (bool) {
          addView(paramU);
        } else {
          addView(paramU, 0);
        }
      }
      else if (bool) {
        addDisappearingView(paramU);
      } else {
        addDisappearingView(paramU, 0);
      }
      calculateItemDecorationsForChild(paramU, mOrientation);
      measureChildWithDecorationsAndMargin(paramU, i3, false);
      i2 = mOrientationHelper.getDecoratedMeasurement(paramU);
      i1 = i;
      if (i2 > i) {
        i1 = i2;
      }
      paramY = (LayoutParams)paramU.getLayoutParams();
      float f3 = mOrientationHelper.getDecoratedMeasurementInOther(paramU) * 1.0F / mOrientation;
      float f2 = f1;
      if (f3 > f1) {
        f2 = f3;
      }
      j += 1;
      i = i1;
      f1 = f2;
    }
    j = i;
    if (k != 0)
    {
      guessMeasurement(f1, m);
      k = 0;
      for (i = 0;; i = j)
      {
        j = i;
        if (k >= n) {
          break;
        }
        paramU = mSet[k];
        measureChildWithDecorationsAndMargin(paramU, 1073741824, true);
        m = mOrientationHelper.getDecoratedMeasurement(paramU);
        j = i;
        if (m > i) {
          j = m;
        }
        k += 1;
      }
    }
    i = 0;
    while (i < n)
    {
      paramU = mSet[i];
      if (mOrientationHelper.getDecoratedMeasurement(paramU) != j)
      {
        paramY = (LayoutParams)paramU.getLayoutParams();
        localObject = mDecorInsets;
        k = top + bottom + topMargin + bottomMargin;
        m = left + right + leftMargin + rightMargin;
        i1 = assignSpans(mSpanCount, mOrientation);
        if (mOrientation == 1)
        {
          m = RecyclerView.o.getChildMeasureSpec(i1, 1073741824, m, width, false);
          k = View.MeasureSpec.makeMeasureSpec(j - k, 1073741824);
        }
        else
        {
          m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);
          k = RecyclerView.o.getChildMeasureSpec(i1, 1073741824, k, height, false);
        }
        measureChildWithDecorationsAndMargin(paramU, m, k, true);
      }
      i += 1;
    }
    int i1 = 0;
    mConsumed = j;
    if (mOrientation == 1)
    {
      if (mLayoutDirection == -1)
      {
        i = mOffset;
        j = i - j;
      }
      else
      {
        k = mOffset;
        i = k;
        k = j + k;
        j = i;
        i = k;
      }
      k = 0;
      m = 0;
    }
    else if (mLayoutDirection == -1)
    {
      k = mOffset;
      m = k - j;
      j = 0;
      i = 0;
    }
    else
    {
      m = mOffset;
      k = j + m;
      i = 0;
      j = 0;
    }
    while (i1 < n)
    {
      paramU = mSet[i1];
      paramY = (LayoutParams)paramU.getLayoutParams();
      if (mOrientation == 1)
      {
        if (isLayoutRTL())
        {
          m = getPaddingLeft() + mCachedBorders[(mSpanCount - mSpanCount)];
          k = m - mOrientationHelper.getDecoratedMeasurementInOther(paramU);
        }
        else
        {
          m = getPaddingLeft() + mCachedBorders[mSpanCount];
          i2 = mOrientationHelper.getDecoratedMeasurementInOther(paramU);
          k = m;
          m = i2 + m;
        }
        i2 = k;
      }
      else
      {
        j = getPaddingTop() + mCachedBorders[mSpanCount];
        i = mOrientationHelper.getDecoratedMeasurementInOther(paramU) + j;
        i2 = m;
        m = k;
      }
      measureChildWithDecorationsAndMargin(paramU, i2, j, m, i);
      if ((paramY.isItemRemoved()) || (paramY.isItemChanged())) {
        mIgnoreConsumed = true;
      }
      mFocusable |= paramU.hasFocusable();
      i1 += 1;
      k = m;
      m = i2;
    }
    Arrays.fill(mSet, null);
  }
  
  void onAnchorReady(RecyclerView.u paramU, RecyclerView.y paramY, LinearLayoutManager.a paramA, int paramInt)
  {
    super.onAnchorReady(paramU, paramY, paramA, paramInt);
    updateMeasurements();
    if ((paramY.getItemCount() > 0) && (!paramY.isPreLayout())) {
      ensureAnchorIsInCorrectSpan(paramU, paramY, paramA, paramInt);
    }
    ensureViewSet();
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    View localView = findContainingItemView(paramView);
    Object localObject1 = null;
    if (localView == null) {
      return null;
    }
    Object localObject2 = (LayoutParams)localView.getLayoutParams();
    int i5 = mSpanCount;
    int i6 = mOrientation + i5;
    if (super.onFocusSearchFailed(paramView, paramInt, paramU, paramY) == null) {
      return null;
    }
    int i11;
    if (fill(paramInt) == 1) {
      i11 = 1;
    } else {
      i11 = 0;
    }
    if (i11 != mShouldReverseLayout) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int j;
    int k;
    int m;
    if (paramInt != 0)
    {
      j = getChildCount() - 1;
      k = -1;
      m = -1;
    }
    else
    {
      k = getChildCount();
      m = 1;
      j = 0;
    }
    int n;
    if ((mOrientation == 1) && (isLayoutRTL())) {
      n = 1;
    } else {
      n = 0;
    }
    int i7 = getSpanGroupIndex(paramU, paramY, j);
    int i3 = -1;
    int i = -1;
    int i2 = 0;
    paramInt = 0;
    localObject2 = null;
    int i1 = j;
    paramView = localObject1;
    localObject1 = localObject2;
    while (i1 != k)
    {
      j = getSpanGroupIndex(paramU, paramY, i1);
      localObject2 = getChildAt(i1);
      if (localObject2 == localView) {
        break;
      }
      if ((((View)localObject2).hasFocusable()) && (j != i7))
      {
        if (paramView != null) {
          break;
        }
      }
      else
      {
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
        int i8 = mSpanCount;
        int i9 = mOrientation + i8;
        if ((((View)localObject2).hasFocusable()) && (i8 == i5) && (i9 == i6)) {
          return localObject2;
        }
        if (((((View)localObject2).hasFocusable()) && (paramView == null)) || ((!((View)localObject2).hasFocusable()) && (localObject1 == null))) {}
        for (;;)
        {
          j = 1;
          break label470;
          j = Math.max(i8, i5);
          int i10 = Math.min(i9, i6) - j;
          if (((View)localObject2).hasFocusable())
          {
            if (i10 <= i2)
            {
              if (i10 != i2) {
                break;
              }
              if (i8 > i3) {
                j = 1;
              } else {
                j = 0;
              }
              if (n != j) {
                break;
              }
            }
          }
          else
          {
            if (paramView != null) {
              break;
            }
            int i4 = 1;
            j = 1;
            if (!a((View)localObject2, false, true)) {
              break;
            }
            if (i10 > paramInt)
            {
              j = i4;
              break label470;
            }
            if (i10 != paramInt) {
              break;
            }
            if (i8 <= i) {
              j = 0;
            }
            if (n != j) {
              break;
            }
          }
        }
        j = 0;
        label470:
        if (j != 0) {
          if (((View)localObject2).hasFocusable())
          {
            i3 = mSpanCount;
            j = Math.min(i9, i6);
            i2 = Math.max(i8, i5);
            i2 = j - i2;
            paramView = (View)localObject2;
          }
          else
          {
            i = mSpanCount;
            paramInt = Math.min(i9, i6) - Math.max(i8, i5);
            localObject1 = localObject2;
          }
        }
      }
      i1 += m;
    }
    if (paramView != null) {
      return paramView;
    }
    return localObject1;
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.u paramU, RecyclerView.y paramY, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = getSpanGroupIndex(paramU, paramY, paramView.getViewLayoutPosition());
    if (mOrientation == 0)
    {
      paramAccessibilityNodeInfoCompat.setText(ByteVector.a(paramView.getSpanIndex(), paramView.getSpanSize(), i, 1, false, false));
      return;
    }
    paramAccessibilityNodeInfoCompat.setText(ByteVector.a(i, 1, paramView.getSpanIndex(), paramView.getSpanSize(), false, false));
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    mSpanSizeLookup.invalidateSpanIndexCache();
    mSpanSizeLookup.handleUpdate();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    mSpanSizeLookup.invalidateSpanIndexCache();
    mSpanSizeLookup.handleUpdate();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    mSpanSizeLookup.invalidateSpanIndexCache();
    mSpanSizeLookup.handleUpdate();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    mSpanSizeLookup.invalidateSpanIndexCache();
    mSpanSizeLookup.handleUpdate();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    mSpanSizeLookup.invalidateSpanIndexCache();
    mSpanSizeLookup.handleUpdate();
  }
  
  public void onLayoutChildren(RecyclerView.u paramU, RecyclerView.y paramY)
  {
    if (paramY.isPreLayout()) {
      cachePreLayoutSpanMapping();
    }
    super.onLayoutChildren(paramU, paramY);
    clearPreLayoutSpanMappingCache();
  }
  
  public void onLayoutChildren(RecyclerView.y paramY)
  {
    super.onLayoutChildren(paramY);
    mPendingSpanCountChange = false;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollHorizontallyBy(paramInt, paramU, paramY);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollVerticallyBy(paramInt, paramU, paramY);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (mCachedBorders == null) {
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (mOrientation == 1)
    {
      paramInt2 = RecyclerView.o.chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      paramRect = mCachedBorders;
      paramInt1 = RecyclerView.o.chooseSize(paramInt1, paramRect[(paramRect.length - 1)] + i, getMinimumWidth());
    }
    else
    {
      paramInt1 = RecyclerView.o.chooseSize(paramInt1, paramRect.width() + i, getMinimumWidth());
      paramRect = mCachedBorders;
      paramInt2 = RecyclerView.o.chooseSize(paramInt2, paramRect[(paramRect.length - 1)] + j, getMinimumHeight());
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setSpanCount(int paramInt)
  {
    if (paramInt == mSpanCount) {
      return;
    }
    mPendingSpanCountChange = true;
    if (paramInt >= 1)
    {
      mSpanCount = paramInt;
      mSpanSizeLookup.invalidateSpanIndexCache();
      requestLayout();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Span count should be at least 1. Provided ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      super.setStackFromEnd(false);
      return;
    }
    throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (mPendingSavedState == null) && (!mPendingSpanCountChange);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    int mOrientation = 0;
    int mSpanCount = -1;
    
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
    
    public int getSpanIndex()
    {
      return mSpanCount;
    }
    
    public int getSpanSize()
    {
      return mOrientation;
    }
  }
  
  public static final class a
    extends GridLayoutManager.b
  {
    public a() {}
    
    public int getSpanSize(int paramInt)
    {
      return 1;
    }
    
    public int getStash(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
  }
  
  public static abstract class b
  {
    private boolean mCacheSpanIndices = false;
    final SparseIntArray mSpanIndexCache = new SparseIntArray();
    final SparseIntArray mapping = new SparseIntArray();
    private boolean permanent = false;
    
    public b() {}
    
    static int findReferenceIndexFromCache(SparseIntArray paramSparseIntArray, int paramInt)
    {
      int j = paramSparseIntArray.size() - 1;
      int i = 0;
      while (i <= j)
      {
        int k = i + j >>> 1;
        if (paramSparseIntArray.keyAt(k) < paramInt) {
          i = k + 1;
        } else {
          j = k - 1;
        }
      }
      paramInt = i - 1;
      if ((paramInt >= 0) && (paramInt < paramSparseIntArray.size())) {
        return paramSparseIntArray.keyAt(paramInt);
      }
      return -1;
    }
    
    int get(int paramInt1, int paramInt2)
    {
      if (!permanent) {
        return getStash(paramInt1, paramInt2);
      }
      int i = mapping.get(paramInt1, -1);
      if (i != -1) {
        return i;
      }
      paramInt2 = getStash(paramInt1, paramInt2);
      mapping.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    int getCachedSpanIndex(int paramInt1, int paramInt2)
    {
      if (!mCacheSpanIndices) {
        return getSpanIndex(paramInt1, paramInt2);
      }
      int i = mSpanIndexCache.get(paramInt1, -1);
      if (i != -1) {
        return i;
      }
      paramInt2 = getSpanIndex(paramInt1, paramInt2);
      mSpanIndexCache.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      int n;
      int i1;
      if (mCacheSpanIndices)
      {
        j = findReferenceIndexFromCache(mSpanIndexCache, paramInt1);
        if (j != -1)
        {
          n = mSpanIndexCache.get(j);
          i = n;
          m = j + 1;
          i1 = get(j, paramInt2) + getSpanSize(j);
          k = m;
          j = i1;
          if (i1 != paramInt2) {
            break label96;
          }
          i = n + 1;
          j = 0;
          k = m;
          break label96;
        }
      }
      int i = 0;
      int k = 0;
      int j = 0;
      label96:
      int i2 = getSpanSize(paramInt1);
      int m = i;
      while (k < paramInt1)
      {
        n = getSpanSize(k);
        i1 = j + n;
        if (i1 == paramInt2)
        {
          j = m + 1;
          i = 0;
        }
        else
        {
          j = m;
          i = i1;
          if (i1 > paramInt2)
          {
            j = m + 1;
            i = n;
          }
        }
        k += 1;
        m = j;
        j = i;
      }
      if (j + i2 > paramInt2) {
        return m + 1;
      }
      return m;
    }
    
    public abstract int getSpanSize(int paramInt);
    
    public abstract int getStash(int paramInt1, int paramInt2);
    
    public void handleUpdate()
    {
      mSpanIndexCache.clear();
    }
    
    public void invalidateSpanIndexCache()
    {
      mapping.clear();
    }
  }
}
