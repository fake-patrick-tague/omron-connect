package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import android.widget.LinearLayout.LayoutParams;
import v7.internal.R.styleable;
import v7.v7.package_13.GravityCompat;
import v7.v7.package_13.ViewCompat;

public class LinearLayoutCompat
  extends ViewGroup
{
  private boolean mBaselineAligned = true;
  private int mBaselineAlignedChildIndex = -1;
  private int mBaselineChildTop = 0;
  private Drawable mDivider;
  private int mDividerHeight;
  private int mDividerPadding;
  private int mDividerWidth;
  private int mGravity = 8388659;
  private int[] mMaxAscent;
  private int[] mMaxDescent;
  private int mOrientation;
  private int mShowDividers;
  private int mTotalLength;
  private boolean mUseLargestChild;
  private float mWeightSum;
  
  public LinearLayoutCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int[] arrayOfInt = R.styleable.SherlockActionMenuItemView;
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, arrayOfInt, paramInt, 0);
    ViewCompat.obtainStyledAttributes(this, paramContext, arrayOfInt, paramAttributeSet, localTintTypedArray.getResourceId(), paramInt, 0);
    paramInt = localTintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0) {
      setOrientation(paramInt);
    }
    paramInt = localTintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    boolean bool = localTintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    mWeightSum = localTintTypedArray.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
    mBaselineAlignedChildIndex = localTintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    mUseLargestChild = localTintTypedArray.getBoolean(R.styleable.SlidingMenu_touchModeBehind, false);
    setDividerDrawable(localTintTypedArray.getDrawable(R.styleable.SlidingMenu_behindOffset));
    mShowDividers = localTintTypedArray.getInt(R.styleable.FormEditText_maxNumber, 0);
    mDividerPadding = localTintTypedArray.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsTabPaddingLeftRight, 0);
    localTintTypedArray.recycle();
  }
  
  private void forceUniformHeight(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getVirtualChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (height == -1)
        {
          int k = width;
          width = localView.getMeasuredWidth();
          measureChildWithMargins(localView, paramInt2, 0, j, 0);
          width = k;
        }
      }
      i += 1;
    }
  }
  
  private void forceUniformWidth(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getVirtualChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (width == -1)
        {
          int k = height;
          height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, j, 0, paramInt2, 0);
          height = k;
        }
      }
      i += 1;
    }
  }
  
  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  void drawDividersHorizontal(Canvas paramCanvas)
  {
    int k = getVirtualChildCount();
    boolean bool = ViewUtils.isLayoutRtl(this);
    int i = 0;
    View localView;
    LayoutParams localLayoutParams;
    int j;
    while (i < k)
    {
      localView = getVirtualChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasDividerBeforeChildAt(i)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (bool) {
          j = localView.getRight() + rightMargin;
        } else {
          j = localView.getLeft() - leftMargin - mDividerWidth;
        }
        drawVerticalDivider(paramCanvas, j);
      }
      i += 1;
    }
    if (hasDividerBeforeChildAt(k))
    {
      localView = getVirtualChildAt(k - 1);
      if (localView == null)
      {
        if (bool)
        {
          i = getPaddingLeft();
          break label216;
        }
        i = getWidth() - getPaddingRight();
        j = mDividerWidth;
      }
      else
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!bool) {
          break label204;
        }
        i = localView.getLeft() - leftMargin;
        j = mDividerWidth;
      }
      i -= j;
      break label216;
      label204:
      i = localView.getRight() + rightMargin;
      label216:
      drawVerticalDivider(paramCanvas, i);
    }
  }
  
  void drawDividersVertical(Canvas paramCanvas)
  {
    int j = getVirtualChildCount();
    int i = 0;
    View localView;
    LayoutParams localLayoutParams;
    while (i < j)
    {
      localView = getVirtualChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasDividerBeforeChildAt(i)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        drawHorizontalDivider(paramCanvas, localView.getTop() - topMargin - mDividerHeight);
      }
      i += 1;
    }
    if (hasDividerBeforeChildAt(j))
    {
      localView = getVirtualChildAt(j - 1);
      if (localView == null)
      {
        i = getHeight() - getPaddingBottom() - mDividerHeight;
      }
      else
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = localView.getBottom() + bottomMargin;
      }
      drawHorizontalDivider(paramCanvas, i);
    }
  }
  
  void drawHorizontalDivider(Canvas paramCanvas, int paramInt)
  {
    mDivider.setBounds(getPaddingLeft() + mDividerPadding, paramInt, getWidth() - getPaddingRight() - mDividerPadding, mDividerHeight + paramInt);
    mDivider.draw(paramCanvas);
  }
  
  void drawVerticalDivider(Canvas paramCanvas, int paramInt)
  {
    mDivider.setBounds(paramInt, getPaddingTop() + mDividerPadding, mDividerWidth + paramInt, getHeight() - getPaddingBottom() - mDividerPadding);
    mDivider.draw(paramCanvas);
  }
  
  protected LayoutParams generateDefaultLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getBaseline()
  {
    if (mBaselineAlignedChildIndex < 0) {
      return super.getBaseline();
    }
    int i = getChildCount();
    int j = mBaselineAlignedChildIndex;
    if (i > j)
    {
      View localView = getChildAt(j);
      int k = localView.getBaseline();
      if (k == -1)
      {
        if (mBaselineAlignedChildIndex == 0) {
          return -1;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      }
      j = mBaselineChildTop;
      i = j;
      if (mOrientation == 1)
      {
        int m = mGravity & 0x70;
        i = j;
        if (m != 48) {
          if (m != 16)
          {
            if (m != 80) {
              i = j;
            } else {
              i = getBottom() - getTop() - getPaddingBottom() - mTotalLength;
            }
          }
          else {
            i = j + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - mTotalLength) / 2;
          }
        }
      }
      return i + getLayoutParamstopMargin + k;
    }
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return mBaselineAlignedChildIndex;
  }
  
  int getChildrenSkipCount(View paramView, int paramInt)
  {
    return 0;
  }
  
  public Drawable getDividerDrawable()
  {
    return mDivider;
  }
  
  public int getDividerPadding()
  {
    return mDividerPadding;
  }
  
  public int getDividerWidth()
  {
    return mDividerWidth;
  }
  
  public int getGravity()
  {
    return mGravity;
  }
  
  int getLocationOffset(View paramView)
  {
    return 0;
  }
  
  int getNextLocationOffset(View paramView)
  {
    return 0;
  }
  
  public int getOrientation()
  {
    return mOrientation;
  }
  
  public int getShowDividers()
  {
    return mShowDividers;
  }
  
  View getVirtualChildAt(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  int getVirtualChildCount()
  {
    return getChildCount();
  }
  
  public float getWeightSum()
  {
    return mWeightSum;
  }
  
  protected boolean hasDividerBeforeChildAt(int paramInt)
  {
    if (paramInt == 0)
    {
      if ((mShowDividers & 0x1) != 0) {
        return true;
      }
    }
    else if (paramInt == getChildCount())
    {
      if ((mShowDividers & 0x4) != 0) {
        return true;
      }
    }
    else if ((mShowDividers & 0x2) != 0)
    {
      paramInt -= 1;
      while (paramInt >= 0)
      {
        if (getChildAt(paramInt).getVisibility() != 8) {
          return true;
        }
        paramInt -= 1;
      }
    }
    return false;
  }
  
  void layoutHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = ViewUtils.isLayoutRtl(this);
    int k = getPaddingTop();
    int n = paramInt4 - paramInt2;
    int i1 = getPaddingBottom();
    int i2 = getPaddingBottom();
    int i3 = getVirtualChildCount();
    int i4 = mGravity;
    boolean bool2 = mBaselineAligned;
    int[] arrayOfInt1 = mMaxAscent;
    int[] arrayOfInt2 = mMaxDescent;
    paramInt2 = GravityCompat.getAbsoluteGravity(0x800007 & i4, ViewCompat.getLayoutDirection(this));
    if (paramInt2 != 1)
    {
      if (paramInt2 != 5) {
        paramInt1 = getPaddingLeft();
      } else {
        paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - mTotalLength;
      }
    }
    else {
      paramInt1 = getPaddingLeft() + (paramInt3 - paramInt1 - mTotalLength) / 2;
    }
    int i;
    if (bool1)
    {
      i = i3 - 1;
      paramInt4 = -1;
    }
    else
    {
      i = 0;
      paramInt4 = 1;
    }
    paramInt2 = 0;
    for (paramInt3 = paramInt1; paramInt2 < i3; paramInt3 = paramInt1)
    {
      int i5 = i + paramInt4 * paramInt2;
      View localView = getVirtualChildAt(i5);
      int j;
      if (localView == null)
      {
        paramInt1 = paramInt3 + measureNullChild(i5);
        j = paramInt2;
      }
      else
      {
        j = paramInt2;
        paramInt1 = paramInt3;
        if (localView.getVisibility() != 8)
        {
          int i6 = localView.getMeasuredWidth();
          int i7 = localView.getMeasuredHeight();
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if ((bool2) && (height != -1)) {
            j = localView.getBaseline();
          } else {
            j = -1;
          }
          int m = gravity;
          paramInt1 = m;
          if (m < 0) {
            paramInt1 = i4 & 0x70;
          }
          paramInt1 &= 0x70;
          if (paramInt1 != 16)
          {
            if (paramInt1 != 48)
            {
              if (paramInt1 != 80)
              {
                paramInt1 = k;
              }
              else
              {
                m = n - i1 - i7 - bottomMargin;
                paramInt1 = m;
                if (j != -1)
                {
                  paramInt1 = localView.getMeasuredHeight();
                  paramInt1 = m - (arrayOfInt2[2] - (paramInt1 - j));
                }
              }
            }
            else
            {
              m = topMargin + k;
              paramInt1 = m;
              if (j != -1)
              {
                paramInt1 = m + (arrayOfInt1[1] - j);
                break label423;
              }
            }
          }
          else {
            paramInt1 = (n - k - i2 - i7) / 2 + k + topMargin - bottomMargin;
          }
          label423:
          j = paramInt3;
          if (hasDividerBeforeChildAt(i5)) {
            j = paramInt3 + mDividerWidth;
          }
          paramInt3 = leftMargin + j;
          setChildFrame(localView, paramInt3 + getLocationOffset(localView), paramInt1, i6, i7);
          paramInt1 = rightMargin;
          m = getNextLocationOffset(localView);
          j = paramInt2 + getChildrenSkipCount(localView, i5);
          paramInt1 = paramInt3 + (i6 + paramInt1 + m);
        }
      }
      paramInt2 = j + 1;
    }
  }
  
  void layoutVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = getPaddingRight();
    int m = getPaddingRight();
    int n = getVirtualChildCount();
    int i1 = mGravity;
    paramInt1 = i1 & 0x70;
    if (paramInt1 != 16)
    {
      if (paramInt1 != 80) {
        paramInt1 = getPaddingTop();
      } else {
        paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - mTotalLength;
      }
    }
    else {
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - mTotalLength) / 2;
    }
    paramInt2 = 0;
    while (paramInt2 < n)
    {
      View localView = getVirtualChildAt(paramInt2);
      if (localView == null)
      {
        paramInt3 = paramInt1 + measureNullChild(paramInt2);
        paramInt4 = paramInt2;
      }
      else
      {
        paramInt3 = paramInt1;
        paramInt4 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          int i3 = localView.getMeasuredWidth();
          int i2 = localView.getMeasuredHeight();
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          paramInt4 = gravity;
          paramInt3 = paramInt4;
          if (paramInt4 < 0) {
            paramInt3 = i1 & 0x800007;
          }
          paramInt3 = GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection(this)) & 0x7;
          if (paramInt3 != 1)
          {
            if (paramInt3 != 5)
            {
              paramInt3 = leftMargin + i;
              break label279;
            }
            paramInt3 = j - k - i3;
            paramInt4 = rightMargin;
          }
          else
          {
            paramInt3 = (j - i - m - i3) / 2 + i + leftMargin;
            paramInt4 = rightMargin;
          }
          paramInt3 -= paramInt4;
          label279:
          paramInt4 = paramInt1;
          if (hasDividerBeforeChildAt(paramInt2)) {
            paramInt4 = paramInt1 + mDividerHeight;
          }
          paramInt1 = paramInt4 + topMargin;
          setChildFrame(localView, paramInt3, paramInt1 + getLocationOffset(localView), i3, i2);
          paramInt3 = bottomMargin;
          i3 = getNextLocationOffset(localView);
          paramInt4 = paramInt2 + getChildrenSkipCount(localView, paramInt2);
          paramInt3 = paramInt1 + (i2 + paramInt3 + i3);
        }
      }
      paramInt2 = paramInt4 + 1;
      paramInt1 = paramInt3;
    }
  }
  
  void measureChildBeforeLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  void measureHorizontal(int paramInt1, int paramInt2)
  {
    mTotalLength = 0;
    int i12 = getVirtualChildCount();
    int i14 = View.MeasureSpec.getMode(paramInt1);
    int i13 = View.MeasureSpec.getMode(paramInt2);
    if ((mMaxAscent == null) || (mMaxDescent == null))
    {
      mMaxAscent = new int[4];
      mMaxDescent = new int[4];
    }
    int[] arrayOfInt1 = mMaxAscent;
    int[] arrayOfInt2 = mMaxDescent;
    arrayOfInt1[3] = -1;
    arrayOfInt1[2] = -1;
    arrayOfInt1[1] = -1;
    arrayOfInt1[0] = -1;
    arrayOfInt2[3] = -1;
    arrayOfInt2[2] = -1;
    arrayOfInt2[1] = -1;
    arrayOfInt2[0] = -1;
    boolean bool1 = mBaselineAligned;
    boolean bool2 = mUseLargestChild;
    int i5 = 1073741824;
    int i6;
    if (i14 == 1073741824) {
      i6 = 1;
    } else {
      i6 = 0;
    }
    int m = 0;
    int k = 0;
    int i3 = 0;
    int j = 0;
    int i1 = 0;
    int i4 = 0;
    int i2 = 0;
    int n = 0;
    int i = 1;
    float f1 = 0.0F;
    View localView;
    int i7;
    LayoutParams localLayoutParams;
    float f2;
    while (m < i12)
    {
      localView = getVirtualChildAt(m);
      if (localView == null) {
        mTotalLength += measureNullChild(m);
      }
      for (;;)
      {
        i7 = m;
        m = i5;
        break label844;
        if (localView.getVisibility() != 8) {
          break;
        }
        m += getChildrenSkipCount(localView, m);
      }
      if (hasDividerBeforeChildAt(m)) {
        mTotalLength += mDividerWidth;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      f2 = weight;
      f1 += f2;
      if ((i14 == i5) && (width == 0) && (f2 > 0.0F))
      {
        if (i6 != 0)
        {
          mTotalLength += leftMargin + rightMargin;
        }
        else
        {
          i5 = mTotalLength;
          mTotalLength = Math.max(i5, leftMargin + i5 + rightMargin);
        }
        if (bool1)
        {
          i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
          localView.measure(i5, i5);
          i5 = k;
        }
        else
        {
          i4 = 1;
          break label578;
        }
      }
      else
      {
        if ((width == 0) && (f2 > 0.0F))
        {
          width = -2;
          i5 = 0;
        }
        else
        {
          i5 = Integer.MIN_VALUE;
        }
        if (f1 == 0.0F) {
          i7 = mTotalLength;
        } else {
          i7 = 0;
        }
        measureChildBeforeLayout(localView, m, paramInt1, i7, paramInt2, 0);
        if (i5 != Integer.MIN_VALUE) {
          width = i5;
        }
        i7 = localView.getMeasuredWidth();
        if (i6 != 0)
        {
          mTotalLength += leftMargin + i7 + rightMargin + getNextLocationOffset(localView);
        }
        else
        {
          i5 = mTotalLength;
          mTotalLength = Math.max(i5, i5 + i7 + leftMargin + rightMargin + getNextLocationOffset(localView));
        }
        i5 = k;
        if (bool2) {
          i5 = Math.max(i7, k);
        }
      }
      k = i5;
      label578:
      i8 = 1073741824;
      int i9 = m;
      if ((i13 != 1073741824) && (height == -1))
      {
        m = 1;
        n = 1;
      }
      else
      {
        m = 0;
      }
      i5 = topMargin + bottomMargin;
      i7 = localView.getMeasuredHeight() + i5;
      int i10 = View.combineMeasuredStates(i2, localView.getMeasuredState());
      if (bool1)
      {
        int i15 = localView.getBaseline();
        if (i15 != -1)
        {
          int i11 = gravity;
          i2 = i11;
          if (i11 < 0) {
            i2 = mGravity;
          }
          i2 = ((i2 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
          arrayOfInt1[i2] = Math.max(arrayOfInt1[i2], i15);
          arrayOfInt2[i2] = Math.max(arrayOfInt2[i2], i7 - i15);
        }
      }
      i3 = Math.max(i3, i7);
      if ((i != 0) && (height == -1)) {
        i = 1;
      } else {
        i = 0;
      }
      if (weight > 0.0F)
      {
        if (m == 0) {
          i5 = i7;
        }
        i1 = Math.max(i1, i5);
      }
      else
      {
        if (m == 0) {
          i5 = i7;
        }
        j = Math.max(j, i5);
      }
      i7 = getChildrenSkipCount(localView, i9) + i9;
      i2 = i10;
      m = i8;
      label844:
      i7 += 1;
      i5 = m;
      m = i7;
    }
    if ((mTotalLength > 0) && (hasDividerBeforeChildAt(i12))) {
      mTotalLength += mDividerWidth;
    }
    if ((arrayOfInt1[1] == -1) && (arrayOfInt1[0] == -1) && (arrayOfInt1[2] == -1) && (arrayOfInt1[3] == -1)) {
      break label986;
    }
    i3 = Math.max(i3, Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2]))) + Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2]))));
    label986:
    if ((bool2) && ((i14 == Integer.MIN_VALUE) || (i14 == 0)))
    {
      mTotalLength = 0;
      m = 0;
      while (m < i12)
      {
        localView = getVirtualChildAt(m);
        if (localView == null)
        {
          mTotalLength += measureNullChild(m);
        }
        else
        {
          if (localView.getVisibility() != 8) {
            break label1076;
          }
          m += getChildrenSkipCount(localView, m);
        }
        for (;;)
        {
          break;
          label1076:
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (i6 != 0)
          {
            mTotalLength += leftMargin + k + rightMargin + getNextLocationOffset(localView);
          }
          else
          {
            i5 = mTotalLength;
            mTotalLength = Math.max(i5, i5 + k + leftMargin + rightMargin + getNextLocationOffset(localView));
          }
        }
        m += 1;
      }
    }
    m = mTotalLength + (getPaddingLeft() + getPaddingRight());
    mTotalLength = m;
    int i8 = View.resolveSizeAndState(Math.max(m, getSuggestedMinimumWidth()), paramInt1, 0);
    i5 = (0xFFFFFF & i8) - mTotalLength;
    if ((i4 == 0) && ((i5 == 0) || (f1 <= 0.0F)))
    {
      m = Math.max(j, i1);
      if ((bool2) && (i14 != 1073741824))
      {
        j = 0;
        while (j < i12)
        {
          localView = getVirtualChildAt(j);
          if ((localView != null) && (localView.getVisibility() != 8) && (getLayoutParamsweight > 0.0F)) {
            localView.measure(View.MeasureSpec.makeMeasureSpec(k, 1073741824), View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824));
          }
          j += 1;
        }
      }
      k = i3;
      j = m;
    }
    else
    {
      f2 = mWeightSum;
      if (f2 > 0.0F) {
        f1 = f2;
      }
      arrayOfInt1[3] = -1;
      arrayOfInt1[2] = -1;
      arrayOfInt1[1] = -1;
      arrayOfInt1[0] = -1;
      arrayOfInt2[3] = -1;
      arrayOfInt2[2] = -1;
      arrayOfInt2[1] = -1;
      arrayOfInt2[0] = -1;
      mTotalLength = 0;
      i1 = -1;
      i3 = i2;
      i2 = 0;
      k = i;
      m = j;
      j = i5;
      i = i3;
      while (i2 < i12)
      {
        localView = getVirtualChildAt(i2);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          f2 = weight;
          if (f2 > 0.0F)
          {
            i4 = (int)(j * f2 / f1);
            f1 -= f2;
            i3 = j - i4;
            i5 = ViewGroup.getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + topMargin + bottomMargin, height);
            if ((width == 0) && (i14 == 1073741824))
            {
              if (i4 > 0) {
                j = i4;
              } else {
                j = 0;
              }
              localView.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), i5);
            }
            else
            {
              i4 = localView.getMeasuredWidth() + i4;
              j = i4;
              if (i4 < 0) {
                j = 0;
              }
              localView.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), i5);
            }
            i = View.combineMeasuredStates(i, localView.getMeasuredState() & 0xFF000000);
            j = i3;
          }
          if (i6 != 0)
          {
            mTotalLength += localView.getMeasuredWidth() + leftMargin + rightMargin + getNextLocationOffset(localView);
          }
          else
          {
            i3 = mTotalLength;
            mTotalLength = Math.max(i3, localView.getMeasuredWidth() + i3 + leftMargin + rightMargin + getNextLocationOffset(localView));
          }
          if ((i13 != 1073741824) && (height == -1)) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          i7 = topMargin + bottomMargin;
          i4 = localView.getMeasuredHeight() + i7;
          i5 = Math.max(i1, i4);
          if (i3 != 0) {
            i1 = i7;
          } else {
            i1 = i4;
          }
          i3 = Math.max(m, i1);
          if ((k != 0) && (height == -1)) {
            k = 1;
          } else {
            k = 0;
          }
          if (bool1)
          {
            i7 = localView.getBaseline();
            if (i7 != -1)
            {
              i1 = gravity;
              m = i1;
              if (i1 < 0) {
                m = mGravity;
              }
              m = ((m & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              arrayOfInt1[m] = Math.max(arrayOfInt1[m], i7);
              arrayOfInt2[m] = Math.max(arrayOfInt2[m], i4 - i7);
            }
          }
          i1 = i5;
          m = i3;
        }
        i2 += 1;
      }
      mTotalLength += getPaddingLeft() + getPaddingRight();
      if ((arrayOfInt1[1] == -1) && (arrayOfInt1[0] == -1) && (arrayOfInt1[2] == -1) && (arrayOfInt1[3] == -1)) {
        j = i1;
      } else {
        j = Math.max(i1, Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2]))) + Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2]))));
      }
      i2 = i;
      i = k;
      k = j;
      j = m;
    }
    if ((i != 0) || (i13 == 1073741824)) {
      j = k;
    }
    setMeasuredDimension(i8 | i2 & 0xFF000000, View.resolveSizeAndState(Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), paramInt2, i2 << 16));
    if (n != 0) {
      forceUniformHeight(i12, paramInt1);
    }
  }
  
  int measureNullChild(int paramInt)
  {
    return 0;
  }
  
  void measureVertical(int paramInt1, int paramInt2)
  {
    mTotalLength = 0;
    int i3 = getVirtualChildCount();
    int i10 = View.MeasureSpec.getMode(paramInt1);
    int i11 = View.MeasureSpec.getMode(paramInt2);
    int i12 = mBaselineAlignedChildIndex;
    boolean bool = mUseLargestChild;
    int k = 0;
    int i = 0;
    int n = 0;
    int i4 = 0;
    int m = 0;
    int i1 = 0;
    int i5 = 0;
    int i2 = 0;
    float f1 = 0.0F;
    int j = 1;
    View localView;
    LayoutParams localLayoutParams;
    float f2;
    int i9;
    int i8;
    while (i1 < i3)
    {
      localView = getVirtualChildAt(i1);
      if (localView == null)
      {
        mTotalLength += measureNullChild(i1);
      }
      else if (localView.getVisibility() == 8)
      {
        i1 += getChildrenSkipCount(localView, i1);
      }
      else
      {
        if (hasDividerBeforeChildAt(i1)) {
          mTotalLength += mDividerHeight;
        }
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        f2 = weight;
        f1 += f2;
        if ((i11 == 1073741824) && (height == 0) && (f2 > 0.0F))
        {
          i5 = mTotalLength;
          mTotalLength = Math.max(i5, topMargin + i5 + bottomMargin);
          i5 = n;
          n = 1;
          i6 = i;
          i = i5;
        }
        else
        {
          if ((height == 0) && (f2 > 0.0F))
          {
            height = -2;
            i6 = 0;
          }
          else
          {
            i6 = Integer.MIN_VALUE;
          }
          if (f1 == 0.0F) {
            i9 = mTotalLength;
          } else {
            i9 = 0;
          }
          i7 = i;
          i8 = n;
          measureChildBeforeLayout(localView, i1, paramInt1, 0, paramInt2, i9);
          if (i6 != Integer.MIN_VALUE) {
            height = i6;
          }
          i9 = localView.getMeasuredHeight();
          i = mTotalLength;
          mTotalLength = Math.max(i, i + i9 + topMargin + bottomMargin + getNextLocationOffset(localView));
          i6 = i7;
          n = i5;
          i = i8;
          if (bool)
          {
            i = Math.max(i9, i8);
            i6 = i7;
            n = i5;
          }
        }
        i9 = i1;
        if ((i12 >= 0) && (i12 == i9 + 1)) {
          mBaselineChildTop = mTotalLength;
        }
        if ((i9 < i12) && (weight > 0.0F)) {
          throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
        }
        if ((i10 != 1073741824) && (width == -1))
        {
          i1 = 1;
          i2 = 1;
        }
        else
        {
          i1 = 0;
        }
        i5 = leftMargin + rightMargin;
        i7 = localView.getMeasuredWidth() + i5;
        i8 = Math.max(i6, i7);
        i6 = View.combineMeasuredStates(k, localView.getMeasuredState());
        if ((j != 0) && (width == -1)) {
          j = 1;
        } else {
          j = 0;
        }
        if (weight > 0.0F)
        {
          if (i1 == 0) {
            i5 = i7;
          }
          k = Math.max(i4, i5);
        }
        else
        {
          if (i1 == 0) {
            i5 = i7;
          }
          m = Math.max(m, i5);
          k = i4;
        }
        i1 = getChildrenSkipCount(localView, i9);
        i1 += i9;
        i5 = n;
        i4 = k;
        n = i;
        i = i8;
        k = i6;
      }
      i1 += 1;
    }
    if ((mTotalLength > 0) && (hasDividerBeforeChildAt(i3))) {
      mTotalLength += mDividerHeight;
    }
    int i6 = i3;
    if ((bool) && ((i11 == Integer.MIN_VALUE) || (i11 == 0)))
    {
      mTotalLength = 0;
      i1 = 0;
      while (i1 < i6)
      {
        localView = getVirtualChildAt(i1);
        if (localView == null)
        {
          mTotalLength += measureNullChild(i1);
        }
        else if (localView.getVisibility() == 8)
        {
          i1 += getChildrenSkipCount(localView, i1);
        }
        else
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          i3 = mTotalLength;
          mTotalLength = Math.max(i3, i3 + n + topMargin + bottomMargin + getNextLocationOffset(localView));
        }
        i1 += 1;
      }
    }
    i1 = mTotalLength + (getPaddingTop() + getPaddingBottom());
    mTotalLength = i1;
    int i7 = View.resolveSizeAndState(Math.max(i1, getSuggestedMinimumHeight()), paramInt2, 0);
    i3 = (0xFFFFFF & i7) - mTotalLength;
    if ((i5 == 0) && ((i3 == 0) || (f1 <= 0.0F)))
    {
      i1 = Math.max(m, i4);
      if ((bool) && (i11 != 1073741824))
      {
        m = 0;
        while (m < i6)
        {
          localView = getVirtualChildAt(m);
          if ((localView != null) && (localView.getVisibility() != 8) && (getLayoutParamsweight > 0.0F)) {
            localView.measure(View.MeasureSpec.makeMeasureSpec(localView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(n, 1073741824));
          }
          m += 1;
        }
      }
      m = i1;
    }
    else
    {
      f2 = mWeightSum;
      if (f2 > 0.0F) {
        f1 = f2;
      }
      mTotalLength = 0;
      i4 = 0;
      while (i4 < i6)
      {
        localView = getVirtualChildAt(i4);
        if (localView.getVisibility() == 8)
        {
          i1 = i3;
          i5 = i;
        }
        else
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          float f3 = weight;
          n = k;
          i1 = i3;
          f2 = f1;
          if (f3 > 0.0F)
          {
            n = (int)(i3 * f3 / f1);
            f2 = f1 - f3;
            i5 = getPaddingLeft();
            i8 = getPaddingRight();
            i9 = leftMargin;
            i12 = rightMargin;
            int i13 = width;
            i1 = i3 - n;
            i5 = ViewGroup.getChildMeasureSpec(paramInt1, i5 + i8 + i9 + i12, i13);
            if ((height == 0) && (i11 == 1073741824))
            {
              if (n <= 0) {
                n = 0;
              }
              localView.measure(i5, View.MeasureSpec.makeMeasureSpec(n, 1073741824));
            }
            else
            {
              i3 = localView.getMeasuredHeight() + n;
              n = i3;
              if (i3 < 0) {
                n = 0;
              }
              localView.measure(i5, View.MeasureSpec.makeMeasureSpec(n, 1073741824));
            }
            n = View.combineMeasuredStates(k, localView.getMeasuredState() & 0xFF00);
          }
          k = leftMargin + rightMargin;
          i3 = localView.getMeasuredWidth() + k;
          i5 = Math.max(i, i3);
          if ((i10 != 1073741824) && (width == -1)) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            i = k;
          } else {
            i = i3;
          }
          m = Math.max(m, i);
          if ((j != 0) && (width == -1)) {
            i = 1;
          } else {
            i = 0;
          }
          j = mTotalLength;
          mTotalLength = Math.max(j, localView.getMeasuredHeight() + j + topMargin + bottomMargin + getNextLocationOffset(localView));
          j = i;
          f1 = f2;
          k = n;
        }
        i4 += 1;
        i3 = i1;
        i = i5;
      }
      mTotalLength += getPaddingTop() + getPaddingBottom();
    }
    if ((j == 0) && (i10 != 1073741824)) {
      i = m;
    }
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), paramInt1, k), i7);
    if (i2 != 0) {
      forceUniformWidth(i6, paramInt2);
    }
  }
  
  protected LayoutParams onConfigurationChanged()
  {
    int i = mOrientation;
    if (i == 0) {
      return new LayoutParams(-2, -2);
    }
    if (i == 1) {
      return new LayoutParams(-1, -2);
    }
    return null;
  }
  
  public LayoutParams onCreateView(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (mDivider == null) {
      return;
    }
    if (mOrientation == 1)
    {
      drawDividersVertical(paramCanvas);
      return;
    }
    drawDividersHorizontal(paramCanvas);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (mOrientation == 1)
    {
      layoutVertical(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layoutHorizontal(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (mOrientation == 1)
    {
      measureVertical(paramInt1, paramInt2);
      return;
    }
    measureHorizontal(paramInt1, paramInt2);
  }
  
  public void setBaselineAligned(boolean paramBoolean)
  {
    mBaselineAligned = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount()))
    {
      mBaselineAlignedChildIndex = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("base aligned child index out of range (0, ");
    localStringBuilder.append(getChildCount());
    localStringBuilder.append(")");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == mDivider) {
      return;
    }
    mDivider = paramDrawable;
    boolean bool = false;
    if (paramDrawable != null)
    {
      mDividerWidth = paramDrawable.getIntrinsicWidth();
      mDividerHeight = paramDrawable.getIntrinsicHeight();
    }
    else
    {
      mDividerWidth = 0;
      mDividerHeight = 0;
    }
    if (paramDrawable == null) {
      bool = true;
    }
    setWillNotDraw(bool);
    requestLayout();
  }
  
  public void setDividerPadding(int paramInt)
  {
    mDividerPadding = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (mGravity != paramInt)
    {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i = paramInt | 0x800003;
      }
      paramInt = i;
      if ((i & 0x70) == 0) {
        paramInt = i | 0x30;
      }
      mGravity = paramInt;
      requestLayout();
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    paramInt &= 0x800007;
    int i = mGravity;
    if ((0x800007 & i) != paramInt)
    {
      mGravity = (paramInt | 0xFF7FFFF8 & i);
      requestLayout();
    }
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    mUseLargestChild = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (mOrientation != paramInt)
    {
      mOrientation = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividers(int paramInt)
  {
    if (paramInt != mShowDividers) {
      requestLayout();
    }
    mShowDividers = paramInt;
  }
  
  public void setVerticalGravity(int paramInt)
  {
    paramInt &= 0x70;
    int i = mGravity;
    if ((i & 0x70) != paramInt)
    {
      mGravity = (paramInt | i & 0xFFFFFF8F);
      requestLayout();
    }
  }
  
  public void setWeightSum(float paramFloat)
  {
    mWeightSum = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
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
  }
}
