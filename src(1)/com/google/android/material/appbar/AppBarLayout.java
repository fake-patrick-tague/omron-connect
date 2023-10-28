package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.theme.utils.Effect;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.org.org.ui.ClassWriter;
import org.org.org.ui.R.layout;
import org.org.org.ui.R.raw;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import org.org.org.ui.asm.ByteVector;
import v7.v7.package_13.MethodVisitor;
import v7.v7.package_13.NestedScrollingChild;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.asm.d;
import v7.v7.package_13.asm.o;
import v7.v7.widget.MathUtils;

public class AppBarLayout
  extends LinearLayout
  implements CoordinatorLayout.b
{
  private static final int c = R.string.c;
  private WeakReference<android.view.View> a;
  private v7.v7.package_13.f f;
  private boolean g;
  private int i;
  private ValueAnimator mAnimator;
  private int mDownPreScrollRange = -1;
  private int mDownScrollRange = -1;
  private boolean mHaveChildWithInterpolator;
  private boolean mIsOpen;
  private List<c> mListeners;
  private int mPendingAction = 0;
  private int mScrimAlpha;
  private int[] mState;
  private Drawable mStatusBarScrim;
  private int mTotalScrollRange = -1;
  private boolean p;
  private boolean s;
  
  public AppBarLayout(android.content.Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, ClassWriter.DOUBLE);
  }
  
  public AppBarLayout(android.content.Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(Effect.a(paramContext, paramAttributeSet, paramInt, k), paramAttributeSet, paramInt);
    paramContext = getContext();
    setOrientation(1);
    int j = Build.VERSION.SDK_INT;
    if (j >= 21)
    {
      Frame.setBoundsViewOutlineProvider(this);
      Frame.a(this, paramAttributeSet, paramInt, k);
    }
    paramAttributeSet = com.google.android.material.internal.Label.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SnackbarLayout, paramInt, k, new int[0]);
    ViewCompat.setBackgroundDrawable(this, paramAttributeSet.getDrawable(R.styleable.SnackbarLayout_android_maxWidth));
    if ((getBackground() instanceof ColorDrawable))
    {
      ColorDrawable localColorDrawable = (ColorDrawable)getBackground();
      org.org.org.ui.asm.f localF = new org.org.org.ui.asm.f();
      localF.setColor(ColorStateList.valueOf(localColorDrawable.getColor()));
      localF.d(paramContext);
      ViewCompat.setBackgroundDrawable(this, localF);
    }
    paramInt = R.styleable.SnackbarLayout_maxActionInlineWidth;
    if (paramAttributeSet.hasValue(paramInt)) {
      setExpanded(paramAttributeSet.getBoolean(paramInt, false), false, false);
    }
    if (j >= 21)
    {
      paramInt = R.styleable.SnackbarLayout_elevation;
      if (paramAttributeSet.hasValue(paramInt)) {
        Frame.init(this, paramAttributeSet.getDimensionPixelSize(paramInt, 0));
      }
    }
    if (j >= 26)
    {
      paramInt = R.styleable.AppBarLayout_expanded;
      if (paramAttributeSet.hasValue(paramInt)) {
        setKeyboardNavigationCluster(paramAttributeSet.getBoolean(paramInt, false));
      }
      paramInt = R.styleable.AppCompatTextView_textAllCaps;
      if (paramAttributeSet.hasValue(paramInt)) {
        setTouchscreenBlocksFocus(paramAttributeSet.getBoolean(paramInt, false));
      }
    }
    p = paramAttributeSet.getBoolean(R.styleable.SlidingMenu_selectorEnabled, false);
    i = paramAttributeSet.getResourceId(R.styleable.SlidingMenu_selectorDrawable, -1);
    setStatusBarForeground(paramAttributeSet.getDrawable(R.styleable.Switch_bpTrack));
    paramAttributeSet.recycle();
    ViewCompat.b(this, new a());
  }
  
  private android.view.View a(android.view.View paramView)
  {
    if (a == null)
    {
      int j = i;
      if (j != -1)
      {
        if (paramView != null) {
          paramView = paramView.findViewById(j);
        } else {
          paramView = null;
        }
        android.view.View localView = paramView;
        if (paramView == null)
        {
          localView = paramView;
          if ((getParent() instanceof ViewGroup)) {
            localView = ((ViewGroup)getParent()).findViewById(i);
          }
        }
        if (localView != null) {
          a = new WeakReference(localView);
        }
      }
    }
    paramView = a;
    if (paramView != null) {
      return (android.view.View)paramView.get();
    }
    return null;
  }
  
  private boolean add()
  {
    return (mStatusBarScrim != null) && (getTopInset() > 0);
  }
  
  private void close()
  {
    WeakReference localWeakReference = a;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    a = null;
  }
  
  private boolean handleMeasuredStateTooSmall()
  {
    int k = getChildCount();
    int j = 0;
    while (j < k)
    {
      if (((LayoutParams)getChildAt(j).getLayoutParams()).d()) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  private void initialize(final org.org.org.ui.asm.f paramF, boolean paramBoolean)
  {
    float f2 = getResources().getDimension(R.raw.mSelectedColor);
    float f1 = f2;
    if (paramBoolean) {
      f2 = 0.0F;
    }
    if (!paramBoolean) {
      f1 = 0.0F;
    }
    ValueAnimator localValueAnimator = mAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofFloat(new float[] { f2, f1 });
    mAnimator = localValueAnimator;
    localValueAnimator.setDuration(getResources().getInteger(R.layout.x));
    mAnimator.setInterpolator(org.org.org.ui.utils.AnimationUtils.this$0);
    mAnimator.addUpdateListener(new b(paramF));
    mAnimator.start();
  }
  
  private void invalidateScrollRanges()
  {
    mTotalScrollRange = -1;
    mDownPreScrollRange = -1;
    mDownScrollRange = -1;
  }
  
  private boolean open(boolean paramBoolean)
  {
    if (mIsOpen != paramBoolean)
    {
      mIsOpen = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }
  
  private void setExpanded()
  {
    setWillNotDraw(add() ^ true);
  }
  
  private void setExpanded(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j;
    if (paramBoolean1) {
      j = 1;
    } else {
      j = 2;
    }
    int m = 0;
    int k;
    if (paramBoolean2) {
      k = 4;
    } else {
      k = 0;
    }
    if (paramBoolean3) {
      m = 8;
    }
    mPendingAction = (j | k | m);
    requestLayout();
  }
  
  private boolean setOrientation()
  {
    if (getChildCount() > 0)
    {
      android.view.View localView = getChildAt(0);
      if ((localView.getVisibility() != 8) && (!ViewCompat.getFitsSystemWindows(localView))) {
        return true;
      }
    }
    return false;
  }
  
  protected LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams))) {
      return new LayoutParams((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  v7.v7.package_13.f a(v7.v7.package_13.f paramF)
  {
    v7.v7.package_13.f localF;
    if (ViewCompat.getFitsSystemWindows(this)) {
      localF = paramF;
    } else {
      localF = null;
    }
    if (!v7.v7.util.Context.equals(f, localF))
    {
      f = localF;
      setExpanded();
      requestLayout();
    }
    return paramF;
  }
  
  public void addListener(c paramC)
  {
    if (mListeners == null) {
      mListeners = new ArrayList();
    }
    if ((paramC != null) && (!mListeners.contains(paramC))) {
      mListeners.add(paramC);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void clear(c paramC)
  {
    List localList = mListeners;
    if ((localList != null) && (paramC != null)) {
      localList.remove(paramC);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (add())
    {
      int j = paramCanvas.save();
      paramCanvas.translate(0.0F, -mScrimAlpha);
      mStatusBarScrim.draw(paramCanvas);
      paramCanvas.restoreToCount(j);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = mStatusBarScrim;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(arrayOfInt))) {
      invalidateDrawable(localDrawable);
    }
  }
  
  protected LayoutParams generateLayoutParams()
  {
    return new LayoutParams(-1, -2);
  }
  
  public boolean get()
  {
    return p;
  }
  
  boolean get(android.view.View paramView)
  {
    android.view.View localView = a(paramView);
    if (localView != null) {
      paramView = localView;
    }
    return (paramView != null) && ((paramView.canScrollVertically(-1)) || (paramView.getScrollY() > 0));
  }
  
  boolean get(boolean paramBoolean)
  {
    if (s != paramBoolean)
    {
      s = paramBoolean;
      refreshDrawableState();
      if ((p) && ((getBackground() instanceof org.org.org.ui.asm.f))) {
        initialize((org.org.org.ui.asm.f)getBackground(), paramBoolean);
      }
      return true;
    }
    return false;
  }
  
  public CoordinatorLayout.Behavior getBehavior()
  {
    return new Behavior();
  }
  
  int getDownNestedPreScrollRange()
  {
    int j = mDownPreScrollRange;
    if (j != -1) {
      return j;
    }
    int k = getChildCount() - 1;
    for (int m = 0; k >= 0; m = j)
    {
      android.view.View localView = getChildAt(k);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i1 = localView.getMeasuredHeight();
      j = mScrollFlags;
      if ((j & 0x5) == 5)
      {
        int n = topMargin + bottomMargin;
        if ((j & 0x8) != 0) {}
        for (j = ViewCompat.getMinimumHeight(localView);; j = i1 - ViewCompat.getMinimumHeight(localView))
        {
          j = n + j;
          break label120;
          if ((j & 0x2) == 0) {
            break;
          }
        }
        j = n + i1;
        label120:
        n = j;
        if (k == 0)
        {
          n = j;
          if (ViewCompat.getFitsSystemWindows(localView)) {
            n = Math.min(j, i1 - getTopInset());
          }
        }
        j = m + n;
      }
      else
      {
        j = m;
        if (m > 0) {
          break;
        }
      }
      k -= 1;
    }
    j = Math.max(0, m);
    mDownPreScrollRange = j;
    return j;
  }
  
  int getDownNestedScrollRange()
  {
    int j = mDownScrollRange;
    if (j != -1) {
      return j;
    }
    int n = getChildCount();
    int k = 0;
    j = 0;
    int m;
    for (;;)
    {
      m = j;
      if (k >= n) {
        break;
      }
      android.view.View localView = getChildAt(k);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i2 = localView.getMeasuredHeight();
      int i3 = topMargin;
      int i4 = bottomMargin;
      int i1 = mScrollFlags;
      m = j;
      if ((i1 & 0x1) == 0) {
        break;
      }
      j += i2 + (i3 + i4);
      if ((i1 & 0x2) != 0)
      {
        m = j - ViewCompat.getMinimumHeight(localView);
        break;
      }
      k += 1;
    }
    j = Math.max(0, m);
    mDownScrollRange = j;
    return j;
  }
  
  public int getLiftOnScrollTargetViewId()
  {
    return i;
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent()
  {
    int m = getTopInset();
    int k = ViewCompat.getMinimumHeight(this);
    int j = k;
    if (k != 0) {}
    do
    {
      return j * 2 + m;
      j = getChildCount();
      if (j >= 1) {
        j = ViewCompat.getMinimumHeight(getChildAt(j - 1));
      } else {
        j = 0;
      }
    } while (j != 0);
    return getHeight() / 3;
  }
  
  int getPendingAction()
  {
    return mPendingAction;
  }
  
  public Drawable getStatusBarForeground()
  {
    return mStatusBarScrim;
  }
  
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  final int getTopInset()
  {
    v7.v7.package_13.f localF = f;
    if (localF != null) {
      return localF.getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int getTotalScrollRange()
  {
    int j = mTotalScrollRange;
    if (j != -1) {
      return j;
    }
    int n = getChildCount();
    int k = 0;
    j = 0;
    int m;
    for (;;)
    {
      m = j;
      if (k >= n) {
        break;
      }
      android.view.View localView = getChildAt(k);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i2 = localView.getMeasuredHeight();
      int i1 = mScrollFlags;
      m = j;
      if ((i1 & 0x1) == 0) {
        break;
      }
      m = j + (i2 + topMargin + bottomMargin);
      j = m;
      if (k == 0)
      {
        j = m;
        if (ViewCompat.getFitsSystemWindows(localView)) {
          j = m - getTopInset();
        }
      }
      if ((i1 & 0x2) != 0)
      {
        m = j - ViewCompat.getMinimumHeight(localView);
        break;
      }
      k += 1;
    }
    j = Math.max(0, m);
    mTotalScrollRange = j;
    return j;
  }
  
  int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }
  
  boolean hasChildWithInterpolator()
  {
    return mHaveChildWithInterpolator;
  }
  
  boolean hasScrollableChildren()
  {
    return getTotalScrollRange() != 0;
  }
  
  public LayoutParams loadFromAttributes(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ByteVector.a(this);
  }
  
  public void onAttachedToWindow(d paramD)
  {
    addListener(paramD);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (mState == null) {
      mState = new int[4];
    }
    int[] arrayOfInt1 = mState;
    int[] arrayOfInt2 = super.onCreateDrawableState(paramInt + arrayOfInt1.length);
    boolean bool = mIsOpen;
    paramInt = ClassWriter.t;
    if (!bool) {
      paramInt = -paramInt;
    }
    arrayOfInt1[0] = paramInt;
    if ((bool) && (s)) {
      paramInt = ClassWriter.N;
    } else {
      paramInt = -ClassWriter.N;
    }
    arrayOfInt1[1] = paramInt;
    paramInt = ClassWriter.F;
    if (!bool) {
      paramInt = -paramInt;
    }
    arrayOfInt1[2] = paramInt;
    if ((bool) && (s)) {
      paramInt = ClassWriter.D;
    } else {
      paramInt = -ClassWriter.D;
    }
    arrayOfInt1[3] = paramInt;
    return android.view.View.mergeDrawableStates(arrayOfInt2, arrayOfInt1);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    close();
  }
  
  public void onLayout(d paramD)
  {
    clear(paramD);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramBoolean = ViewCompat.getFitsSystemWindows(this);
    boolean bool = true;
    if ((paramBoolean) && (setOrientation()))
    {
      paramInt2 = getTopInset();
      paramInt1 = getChildCount() - 1;
      while (paramInt1 >= 0)
      {
        ViewCompat.offsetTopAndBottom(getChildAt(paramInt1), paramInt2);
        paramInt1 -= 1;
      }
    }
    invalidateScrollRanges();
    mHaveChildWithInterpolator = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (((LayoutParams)getChildAt(paramInt1).getLayoutParams()).getScrollInterpolator() != null)
      {
        mHaveChildWithInterpolator = true;
        break;
      }
      paramInt1 += 1;
    }
    Drawable localDrawable = mStatusBarScrim;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, getWidth(), getTopInset());
    }
    if (!g)
    {
      paramBoolean = bool;
      if (!p) {
        if (handleMeasuredStateTooSmall()) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
      }
      open(paramBoolean);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int k = View.MeasureSpec.getMode(paramInt2);
    if ((k != 1073741824) && (ViewCompat.getFitsSystemWindows(this)) && (setOrientation()))
    {
      int j = getMeasuredHeight();
      paramInt1 = j;
      if (k != Integer.MIN_VALUE)
      {
        if (k == 0) {
          paramInt1 = j + getTopInset();
        }
      }
      else {
        paramInt1 = MathUtils.constrain(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(paramInt2));
      }
      setMeasuredDimension(getMeasuredWidth(), paramInt1);
    }
    invalidateScrollRanges();
  }
  
  void registerListener(int paramInt)
  {
    mScrimAlpha = paramInt;
    if (!willNotDraw()) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
    Object localObject = mListeners;
    if (localObject != null)
    {
      int j = 0;
      int k = ((List)localObject).size();
      while (j < k)
      {
        localObject = (c)mListeners.get(j);
        if (localObject != null) {
          ((c)localObject).onOffsetChanged(this, paramInt);
        }
        j += 1;
      }
    }
  }
  
  void resetPendingAction()
  {
    mPendingAction = 0;
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    ByteVector.a(this, paramFloat);
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    setExpanded(paramBoolean, ViewCompat.set(this));
  }
  
  public void setExpanded(boolean paramBoolean1, boolean paramBoolean2)
  {
    setExpanded(paramBoolean1, paramBoolean2, true);
  }
  
  public void setLiftOnScroll(boolean paramBoolean)
  {
    p = paramBoolean;
  }
  
  public void setLiftOnScrollTargetViewId(int paramInt)
  {
    i = paramInt;
    close();
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 1)
    {
      super.setOrientation(paramInt);
      return;
    }
    throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
  }
  
  public void setStatusBarForeground(Drawable paramDrawable)
  {
    Drawable localDrawable2 = mStatusBarScrim;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      mStatusBarScrim = localDrawable1;
      if (localDrawable1 != null)
      {
        if (localDrawable1.isStateful()) {
          mStatusBarScrim.setState(getDrawableState());
        }
        DrawableCompat.a(mStatusBarScrim, ViewCompat.getLayoutDirection(this));
        paramDrawable = mStatusBarScrim;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        mStatusBarScrim.setCallback(this);
      }
      setExpanded();
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setStatusBarForegroundColor(int paramInt)
  {
    setStatusBarForeground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarForegroundResource(int paramInt)
  {
    setStatusBarForeground(v7.internal.transition.util.View.getDrawable(getContext(), paramInt));
  }
  
  public void setTargetElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      Frame.init(this, paramFloat);
    }
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
    Drawable localDrawable = mStatusBarScrim;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == mStatusBarScrim);
  }
  
  protected static class BaseBehavior<T extends AppBarLayout>
    extends HeaderBehavior<T>
  {
    private ValueAnimator mAnimator;
    private int mLastNestedScrollDy;
    private WeakReference<android.view.View> mLastNestedScrollingChildRef;
    private int mOffsetDelta;
    private int mOffsetToChildIndexOnLayout = -1;
    private boolean mOffsetToChildIndexOnLayoutIsMinHeight;
    private float mOffsetToChildIndexOnLayoutPerc;
    private d mOnDragCallback;
    
    public BaseBehavior() {}
    
    public BaseBehavior(android.content.Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private android.view.View a(CoordinatorLayout paramCoordinatorLayout)
    {
      int j = paramCoordinatorLayout.getChildCount();
      int i = 0;
      android.view.View localView;
      while (i < j)
      {
        localView = paramCoordinatorLayout.getChildAt(i);
        if (!(localView instanceof NestedScrollingChild))
        {
          if ((localView instanceof ListView)) {
            break label58;
          }
          if ((localView instanceof ScrollView)) {
            return localView;
          }
          i += 1;
        }
        else
        {
          return localView;
        }
      }
      return null;
      label58:
      return localView;
    }
    
    private void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
    {
      ViewCompat.a(paramCoordinatorLayout, v7.v7.package_13.asm.Label.a.a());
      ViewCompat.a(paramCoordinatorLayout, v7.v7.package_13.asm.Label.b.a());
      android.view.View localView = a(paramCoordinatorLayout);
      if (localView != null)
      {
        if (paramAppBarLayout.getTotalScrollRange() == 0) {
          return;
        }
        if (!(((CoordinatorLayout.e)localView.getLayoutParams()).getBehavior() instanceof AppBarLayout.ScrollingViewBehavior)) {
          return;
        }
        a(paramCoordinatorLayout, paramAppBarLayout, localView);
      }
    }
    
    private void a(final CoordinatorLayout paramCoordinatorLayout, final AppBarLayout paramAppBarLayout, final android.view.View paramView)
    {
      if ((getTopBottomOffsetForScrollingSibling() != -paramAppBarLayout.getTotalScrollRange()) && (paramView.canScrollVertically(1))) {
        b(paramCoordinatorLayout, paramAppBarLayout, v7.v7.package_13.asm.Label.a, false);
      }
      if (getTopBottomOffsetForScrollingSibling() != 0) {
        if (paramView.canScrollVertically(-1))
        {
          final int i = -paramAppBarLayout.getDownNestedPreScrollRange();
          if (i != 0) {
            ViewCompat.a(paramCoordinatorLayout, v7.v7.package_13.asm.Label.b, null, new b(paramCoordinatorLayout, paramAppBarLayout, paramView, i));
          }
        }
        else
        {
          b(paramCoordinatorLayout, paramAppBarLayout, v7.v7.package_13.asm.Label.b, true);
        }
      }
    }
    
    private void animateOffsetTo(final CoordinatorLayout paramCoordinatorLayout, final AppBarLayout paramAppBarLayout, int paramInt1, int paramInt2)
    {
      int i = getTopBottomOffsetForScrollingSibling();
      if (i == paramInt1)
      {
        paramCoordinatorLayout = mAnimator;
        if ((paramCoordinatorLayout != null) && (paramCoordinatorLayout.isRunning())) {
          mAnimator.cancel();
        }
      }
      else
      {
        ValueAnimator localValueAnimator = mAnimator;
        if (localValueAnimator == null)
        {
          localValueAnimator = new ValueAnimator();
          mAnimator = localValueAnimator;
          localValueAnimator.setInterpolator(org.org.org.ui.utils.AnimationUtils.DECELERATE_INTERPOLATOR);
          mAnimator.addUpdateListener(new a(paramCoordinatorLayout, paramAppBarLayout));
        }
        else
        {
          localValueAnimator.cancel();
        }
        mAnimator.setDuration(Math.min(paramInt2, 600));
        mAnimator.setIntValues(new int[] { i, paramInt1 });
        mAnimator.start();
      }
    }
    
    private void b(CoordinatorLayout paramCoordinatorLayout, final AppBarLayout paramAppBarLayout, v7.v7.package_13.asm.Label paramLabel, final boolean paramBoolean)
    {
      ViewCompat.a(paramCoordinatorLayout, paramLabel, null, new c(paramAppBarLayout, paramBoolean));
    }
    
    private void fling(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt, float paramFloat)
    {
      int i = Math.abs(getTopBottomOffsetForScrollingSibling() - paramInt);
      paramFloat = Math.abs(paramFloat);
      if (paramFloat > 0.0F) {
        i = Math.round(i / paramFloat * 1000.0F) * 3;
      } else {
        i = (int)((i / paramAppBarLayout.getHeight() + 1.0F) * 150.0F);
      }
      animateOffsetTo(paramCoordinatorLayout, paramAppBarLayout, paramInt, i);
    }
    
    private static boolean get(int paramInt1, int paramInt2)
    {
      return (paramInt1 & paramInt2) == paramInt2;
    }
    
    private static android.view.View getChildOnOffset(AppBarLayout paramAppBarLayout, int paramInt)
    {
      int i = Math.abs(paramInt);
      int j = paramAppBarLayout.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        android.view.View localView = paramAppBarLayout.getChildAt(paramInt);
        if ((i >= localView.getTop()) && (i <= localView.getBottom())) {
          return localView;
        }
        paramInt += 1;
      }
      return null;
    }
    
    private int interpolateOffset(AppBarLayout paramAppBarLayout, int paramInt)
    {
      int k = Math.abs(paramInt);
      int m = paramAppBarLayout.getChildCount();
      int j = 0;
      int i = 0;
      while (i < m)
      {
        android.view.View localView = paramAppBarLayout.getChildAt(i);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        Interpolator localInterpolator = localLayoutParams.getScrollInterpolator();
        if ((k >= localView.getTop()) && (k <= localView.getBottom()))
        {
          if (localInterpolator == null) {
            break;
          }
          m = localLayoutParams.getScrollFlags();
          i = j;
          if ((m & 0x1) != 0)
          {
            j = 0 + (localView.getHeight() + topMargin + bottomMargin);
            i = j;
            if ((m & 0x2) != 0) {
              i = j - ViewCompat.getMinimumHeight(localView);
            }
          }
          j = i;
          if (ViewCompat.getFitsSystemWindows(localView)) {
            j = i - paramAppBarLayout.getTopInset();
          }
          if (j <= 0) {
            break;
          }
          i = localView.getTop();
          float f = j;
          i = Math.round(f * localInterpolator.getInterpolation((k - i) / f));
          return Integer.signum(paramInt) * (localView.getTop() + i);
        }
        i += 1;
      }
      return paramInt;
    }
    
    private int onDrawOver(AppBarLayout paramAppBarLayout, int paramInt)
    {
      int i1 = paramAppBarLayout.getChildCount();
      int i = 0;
      while (i < i1)
      {
        Object localObject = paramAppBarLayout.getChildAt(i);
        int n = ((android.view.View)localObject).getTop();
        int j = n;
        int m = ((android.view.View)localObject).getBottom();
        int k = m;
        localObject = (AppBarLayout.LayoutParams)((android.view.View)localObject).getLayoutParams();
        if (get(((AppBarLayout.LayoutParams)localObject).getScrollFlags(), 32))
        {
          j = n - topMargin;
          k = m + bottomMargin;
        }
        m = -paramInt;
        if ((j <= m) && (k >= m)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    private void onLayoutChild(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      android.view.View localView = getChildOnOffset(paramAppBarLayout, paramInt1);
      if (localView != null)
      {
        int i = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).getScrollFlags();
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((i & 0x1) != 0)
        {
          int j = ViewCompat.getMinimumHeight(localView);
          if ((paramInt2 > 0) && ((i & 0xC) != 0))
          {
            bool1 = bool2;
            if (-paramInt1 < localView.getBottom() - j - paramAppBarLayout.getTopInset()) {}
          }
          else
          {
            do
            {
              bool1 = true;
              break;
              bool1 = bool2;
              if ((i & 0x2) == 0) {
                break;
              }
              bool1 = bool2;
            } while (-paramInt1 >= localView.getBottom() - j - paramAppBarLayout.getTopInset());
          }
        }
        if (paramAppBarLayout.get()) {
          bool1 = paramAppBarLayout.get(a(paramCoordinatorLayout));
        }
        bool1 = paramAppBarLayout.get(bool1);
        if ((paramBoolean) || ((bool1) && (onLayoutChild(paramCoordinatorLayout, paramAppBarLayout)))) {
          paramAppBarLayout.jumpDrawablesToCurrentState();
        }
      }
    }
    
    private boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
    {
      paramCoordinatorLayout = paramCoordinatorLayout.get(paramAppBarLayout);
      int j = paramCoordinatorLayout.size();
      int i = 0;
      while (i < j)
      {
        paramAppBarLayout = ((CoordinatorLayout.e)((android.view.View)paramCoordinatorLayout.get(i)).getLayoutParams()).getBehavior();
        if ((paramAppBarLayout instanceof AppBarLayout.ScrollingViewBehavior))
        {
          if (((AppBarLayout.ScrollingViewBehavior)paramAppBarLayout).getOverlayTop() == 0) {
            break;
          }
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    private boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, android.view.View paramView)
    {
      return (paramAppBarLayout.hasScrollableChildren()) && (paramCoordinatorLayout.getHeight() - paramView.getHeight() <= paramAppBarLayout.getHeight());
    }
    
    private void snapToChildIfNeeded(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
    {
      int n = getTopBottomOffsetForScrollingSibling();
      int k = onDrawOver(paramAppBarLayout, n);
      if (k >= 0)
      {
        android.view.View localView = paramAppBarLayout.getChildAt(k);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        int i1 = localLayoutParams.getScrollFlags();
        if ((i1 & 0x11) == 17)
        {
          int m = -localView.getTop();
          int i = -localView.getBottom();
          int j = i;
          if (k == paramAppBarLayout.getChildCount() - 1) {
            j = i + paramAppBarLayout.getTopInset();
          }
          if (get(i1, 2))
          {
            i = j + ViewCompat.getMinimumHeight(localView);
            k = m;
          }
          else
          {
            k = m;
            i = j;
            if (get(i1, 5))
            {
              i = ViewCompat.getMinimumHeight(localView) + j;
              if (n < i)
              {
                k = i;
                i = j;
              }
              else
              {
                k = m;
              }
            }
          }
          m = k;
          j = i;
          if (get(i1, 32))
          {
            m = k + topMargin;
            j = i - bottomMargin;
          }
          i = m;
          if (n < (j + m) / 2) {
            i = j;
          }
          fling(paramCoordinatorLayout, paramAppBarLayout, MathUtils.constrain(i, -paramAppBarLayout.getTotalScrollRange(), 0), 0.0F);
        }
      }
    }
    
    boolean canDragView(AppBarLayout paramAppBarLayout)
    {
      if (mOnDragCallback == null)
      {
        paramAppBarLayout = mLastNestedScrollingChildRef;
        if (paramAppBarLayout != null)
        {
          paramAppBarLayout = (android.view.View)paramAppBarLayout.get();
          return (paramAppBarLayout != null) && (paramAppBarLayout.isShown()) && (!paramAppBarLayout.canScrollVertically(-1));
        }
      }
      else
      {
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
      return true;
    }
    
    int getMaxDragOffset(AppBarLayout paramAppBarLayout)
    {
      return -paramAppBarLayout.getDownNestedScrollRange();
    }
    
    int getTopBottomOffsetForScrollingSibling()
    {
      return getTopAndBottomOffset() + mOffsetDelta;
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
    {
      boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramAppBarLayout, paramInt);
      int i = paramAppBarLayout.getPendingAction();
      paramInt = mOffsetToChildIndexOnLayout;
      if ((paramInt >= 0) && ((i & 0x8) == 0))
      {
        android.view.View localView = paramAppBarLayout.getChildAt(paramInt);
        i = -localView.getBottom();
        if (mOffsetToChildIndexOnLayoutIsMinHeight) {
          paramInt = ViewCompat.getMinimumHeight(localView) + paramAppBarLayout.getTopInset();
        } else {
          paramInt = Math.round(localView.getHeight() * mOffsetToChildIndexOnLayoutPerc);
        }
        setHeaderTopBottomOffset(paramCoordinatorLayout, paramAppBarLayout, i + paramInt);
      }
      else if (i != 0)
      {
        if ((i & 0x4) != 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if ((i & 0x2) != 0)
        {
          i = -paramAppBarLayout.getUpNestedPreScrollRange();
          if (paramInt != 0) {
            fling(paramCoordinatorLayout, paramAppBarLayout, i, 0.0F);
          } else {
            setHeaderTopBottomOffset(paramCoordinatorLayout, paramAppBarLayout, i);
          }
        }
        else if ((i & 0x1) != 0)
        {
          if (paramInt != 0) {
            fling(paramCoordinatorLayout, paramAppBarLayout, 0, 0.0F);
          } else {
            setHeaderTopBottomOffset(paramCoordinatorLayout, paramAppBarLayout, 0);
          }
        }
      }
      paramAppBarLayout.resetPendingAction();
      mOffsetToChildIndexOnLayout = -1;
      setTopAndBottomOffset(MathUtils.constrain(getTopAndBottomOffset(), -paramAppBarLayout.getTotalScrollRange(), 0));
      onLayoutChild(paramCoordinatorLayout, paramAppBarLayout, getTopAndBottomOffset(), 0, true);
      paramAppBarLayout.registerListener(getTopAndBottomOffset());
      a(paramCoordinatorLayout, paramAppBarLayout);
      return bool;
    }
    
    public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (getLayoutParamsheight == -2)
      {
        paramCoordinatorLayout.onMeasureChild(paramAppBarLayout, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
        return true;
      }
      return super.onMeasureChild(paramCoordinatorLayout, paramAppBarLayout, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
    {
      snapToChildIfNeeded(paramCoordinatorLayout, paramAppBarLayout);
      if (paramAppBarLayout.get()) {
        paramAppBarLayout.get(paramAppBarLayout.get(a(paramCoordinatorLayout)));
      }
    }
    
    public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, android.view.View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      if (paramInt2 != 0)
      {
        if (paramInt2 < 0)
        {
          paramInt1 = -paramAppBarLayout.getTotalScrollRange();
          paramInt3 = paramAppBarLayout.getDownNestedPreScrollRange() + paramInt1;
        }
        else
        {
          paramInt1 = -paramAppBarLayout.getUpNestedPreScrollRange();
          paramInt3 = 0;
        }
        if (paramInt1 != paramInt3) {
          paramArrayOfInt[1] = scroll(paramCoordinatorLayout, paramAppBarLayout, paramInt2, paramInt1, paramInt3);
        }
      }
      if (paramAppBarLayout.get()) {
        paramAppBarLayout.get(paramAppBarLayout.get(paramView));
      }
    }
    
    public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, android.view.View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
    {
      if (paramInt4 < 0) {
        paramArrayOfInt[1] = scroll(paramCoordinatorLayout, paramAppBarLayout, paramInt4, -paramAppBarLayout.getDownNestedScrollRange(), 0);
      }
      if (paramInt4 == 0) {
        a(paramCoordinatorLayout, paramAppBarLayout);
      }
    }
    
    public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, Parcelable paramParcelable)
    {
      if ((paramParcelable instanceof SavedState))
      {
        paramParcelable = (SavedState)paramParcelable;
        super.onRestoreInstanceState(paramCoordinatorLayout, paramAppBarLayout, paramParcelable.getSuperState());
        mOffsetToChildIndexOnLayout = d;
        mOffsetToChildIndexOnLayoutPerc = a;
        mOffsetToChildIndexOnLayoutIsMinHeight = c;
        return;
      }
      super.onRestoreInstanceState(paramCoordinatorLayout, paramAppBarLayout, paramParcelable);
      mOffsetToChildIndexOnLayout = -1;
    }
    
    public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
    {
      Object localObject = super.onSaveInstanceState(paramCoordinatorLayout, paramAppBarLayout);
      int j = getTopAndBottomOffset();
      int k = paramAppBarLayout.getChildCount();
      boolean bool = false;
      int i = 0;
      while (i < k)
      {
        paramCoordinatorLayout = paramAppBarLayout.getChildAt(i);
        int m = paramCoordinatorLayout.getBottom() + j;
        if ((paramCoordinatorLayout.getTop() + j <= 0) && (m >= 0))
        {
          localObject = new SavedState((Parcelable)localObject);
          d = i;
          if (m == ViewCompat.getMinimumHeight(paramCoordinatorLayout) + paramAppBarLayout.getTopInset()) {
            bool = true;
          }
          c = bool;
          a = (m / paramCoordinatorLayout.getHeight());
          return localObject;
        }
        i += 1;
      }
      return localObject;
    }
    
    public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, android.view.View paramView1, android.view.View paramView2, int paramInt1, int paramInt2)
    {
      boolean bool;
      if (((paramInt1 & 0x2) != 0) && ((paramAppBarLayout.get()) || (onStartNestedScroll(paramCoordinatorLayout, paramAppBarLayout, paramView1)))) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool)
      {
        paramCoordinatorLayout = mAnimator;
        if (paramCoordinatorLayout != null) {
          paramCoordinatorLayout.cancel();
        }
      }
      mLastNestedScrollingChildRef = null;
      mLastNestedScrollDy = paramInt2;
      return bool;
    }
    
    public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, android.view.View paramView, int paramInt)
    {
      if ((mLastNestedScrollDy == 0) || (paramInt == 1))
      {
        snapToChildIfNeeded(paramCoordinatorLayout, paramAppBarLayout);
        if (paramAppBarLayout.get()) {
          paramAppBarLayout.get(paramAppBarLayout.get(paramView));
        }
      }
      mLastNestedScrollingChildRef = new WeakReference(paramView);
    }
    
    int setAppBarTopBottomOffset(AppBarLayout paramAppBarLayout)
    {
      return paramAppBarLayout.getTotalScrollRange();
    }
    
    int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt1, int paramInt2, int paramInt3)
    {
      int j = getTopBottomOffsetForScrollingSibling();
      int i = 0;
      if ((paramInt2 != 0) && (j >= paramInt2) && (j <= paramInt3))
      {
        paramInt2 = MathUtils.constrain(paramInt1, paramInt2, paramInt3);
        paramInt1 = i;
        if (j != paramInt2)
        {
          if (paramAppBarLayout.hasChildWithInterpolator()) {
            paramInt1 = interpolateOffset(paramAppBarLayout, paramInt2);
          } else {
            paramInt1 = paramInt2;
          }
          boolean bool = setTopAndBottomOffset(paramInt1);
          paramInt3 = j - paramInt2;
          mOffsetDelta = (paramInt2 - paramInt1);
          if ((!bool) && (paramAppBarLayout.hasChildWithInterpolator())) {
            paramCoordinatorLayout.dispatchDependentViewsChanged(paramAppBarLayout);
          }
          paramAppBarLayout.registerListener(getTopAndBottomOffset());
          if (paramInt2 < j) {
            paramInt1 = -1;
          } else {
            paramInt1 = 1;
          }
          onLayoutChild(paramCoordinatorLayout, paramAppBarLayout, paramInt2, paramInt1, false);
          paramInt1 = paramInt3;
        }
      }
      else
      {
        mOffsetDelta = 0;
        paramInt1 = i;
      }
      a(paramCoordinatorLayout, paramAppBarLayout);
      return paramInt1;
    }
    
    protected static class SavedState
      extends AbsSavedState
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new a();
      float a;
      boolean c;
      int d;
      
      public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        super(paramClassLoader);
        d = paramParcel.readInt();
        a = paramParcel.readFloat();
        boolean bool;
        if (paramParcel.readByte() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        c = bool;
      }
      
      public SavedState(Parcelable paramParcelable)
      {
        super();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(d);
        paramParcel.writeFloat(a);
        paramParcel.writeByte((byte)c);
      }
      
      static final class a
        implements Parcelable.ClassLoaderCreator<AppBarLayout.BaseBehavior.SavedState>
      {
        a() {}
        
        public AppBarLayout.BaseBehavior.SavedState[] a(int paramInt)
        {
          return new AppBarLayout.BaseBehavior.SavedState[paramInt];
        }
        
        public AppBarLayout.BaseBehavior.SavedState readDate(Parcel paramParcel)
        {
          return new AppBarLayout.BaseBehavior.SavedState(paramParcel, null);
        }
        
        public AppBarLayout.BaseBehavior.SavedState readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
        {
          return new AppBarLayout.BaseBehavior.SavedState(paramParcel, paramClassLoader);
        }
      }
    }
    
    class a
      implements ValueAnimator.AnimatorUpdateListener
    {
      a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout) {}
      
      public void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        setHeaderTopBottomOffset(paramCoordinatorLayout, paramAppBarLayout, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      }
    }
    
    class b
      implements d
    {
      b(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, android.view.View paramView, int paramInt) {}
      
      public boolean b(android.view.View paramView, o paramO)
      {
        onNestedPreScroll(paramCoordinatorLayout, paramAppBarLayout, paramView, 0, i, new int[] { 0, 0 }, 1);
        return true;
      }
    }
    
    class c
      implements d
    {
      c(AppBarLayout paramAppBarLayout, boolean paramBoolean) {}
      
      public boolean b(android.view.View paramView, o paramO)
      {
        paramAppBarLayout.setExpanded(paramBoolean);
        return true;
      }
    }
    
    public static abstract class d<T extends AppBarLayout> {}
  }
  
  public static class Behavior
    extends AppBarLayout.BaseBehavior<AppBarLayout>
  {
    public Behavior() {}
    
    public Behavior(android.content.Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    int mScrollFlags = 1;
    Interpolator mScrollInterpolator;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(android.content.Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GridLayout);
      mScrollFlags = paramAttributeSet.getInt(R.styleable.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
      int i = R.styleable.AppBarLayout_LayoutParams_layout_scrollInterpolator;
      if (paramAttributeSet.hasValue(i)) {
        mScrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(i, 0));
      }
      paramAttributeSet.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    boolean d()
    {
      int i = mScrollFlags;
      return ((i & 0x1) == 1) && ((i & 0xA) != 0);
    }
    
    public int getScrollFlags()
    {
      return mScrollFlags;
    }
    
    public Interpolator getScrollInterpolator()
    {
      return mScrollInterpolator;
    }
  }
  
  public static class ScrollingViewBehavior
    extends HeaderScrollingViewBehavior
  {
    public ScrollingViewBehavior() {}
    
    public ScrollingViewBehavior(android.content.Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BubbleTextView);
      setOverlayTop(paramContext.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, 0));
      paramContext.recycle();
    }
    
    private static int getAppBarLayoutOffset(AppBarLayout paramAppBarLayout)
    {
      paramAppBarLayout = ((CoordinatorLayout.e)paramAppBarLayout.getLayoutParams()).getBehavior();
      if ((paramAppBarLayout instanceof AppBarLayout.BaseBehavior)) {
        return ((AppBarLayout.BaseBehavior)paramAppBarLayout).getTopBottomOffsetForScrollingSibling();
      }
      return 0;
    }
    
    private void offsetChildAsNeeded(android.view.View paramView1, android.view.View paramView2)
    {
      Object localObject = ((CoordinatorLayout.e)paramView2.getLayoutParams()).getBehavior();
      if ((localObject instanceof AppBarLayout.BaseBehavior))
      {
        localObject = (AppBarLayout.BaseBehavior)localObject;
        ViewCompat.offsetTopAndBottom(paramView1, paramView2.getBottom() - paramView1.getTop() + AppBarLayout.BaseBehavior.access$getMOffsetDelta((AppBarLayout.BaseBehavior)localObject) + getVerticalLayoutGap() - getOverlapPixelsForOffset(paramView2));
      }
    }
    
    private void onDependentViewChanged(android.view.View paramView1, android.view.View paramView2)
    {
      if ((paramView2 instanceof AppBarLayout))
      {
        paramView2 = (AppBarLayout)paramView2;
        if (paramView2.get()) {
          paramView2.get(paramView2.get(paramView1));
        }
      }
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, android.view.View paramView1, android.view.View paramView2)
    {
      if ((paramView2 instanceof AppBarLayout))
      {
        ViewCompat.a(paramCoordinatorLayout, v7.v7.package_13.asm.Label.a.a());
        ViewCompat.a(paramCoordinatorLayout, v7.v7.package_13.asm.Label.b.a());
      }
    }
    
    AppBarLayout get(List paramList)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        android.view.View localView = (android.view.View)paramList.get(i);
        if ((localView instanceof AppBarLayout)) {
          return (AppBarLayout)localView;
        }
        i += 1;
      }
      return null;
    }
    
    float getOverlapRatioForOffset(android.view.View paramView)
    {
      if ((paramView instanceof AppBarLayout))
      {
        paramView = (AppBarLayout)paramView;
        int j = paramView.getTotalScrollRange();
        int k = paramView.getDownNestedPreScrollRange();
        int i = getAppBarLayoutOffset(paramView);
        if ((k != 0) && (j + i <= k)) {
          return 0.0F;
        }
        j -= k;
        if (j != 0) {
          return i / j + 1.0F;
        }
      }
      return 0.0F;
    }
    
    int getScrollRange(android.view.View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        return ((AppBarLayout)paramView).getTotalScrollRange();
      }
      return super.getScrollRange(paramView);
    }
    
    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, android.view.View paramView1, android.view.View paramView2)
    {
      offsetChildAsNeeded(paramView1, paramView2);
      onDependentViewChanged(paramView1, paramView2);
      return false;
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, android.view.View paramView, Rect paramRect, boolean paramBoolean)
    {
      AppBarLayout localAppBarLayout = get(paramCoordinatorLayout.getDependencies(paramView));
      if (localAppBarLayout != null)
      {
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        paramView = mTempRect1;
        paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
        if (!paramView.contains(paramRect))
        {
          localAppBarLayout.setExpanded(false, paramBoolean ^ true);
          return true;
        }
      }
      return false;
    }
    
    public boolean update(CoordinatorLayout paramCoordinatorLayout, android.view.View paramView1, android.view.View paramView2)
    {
      return paramView2 instanceof AppBarLayout;
    }
  }
  
  class a
    implements MethodVisitor
  {
    a() {}
    
    public v7.v7.package_13.f a(android.view.View paramView, v7.v7.package_13.f paramF)
    {
      return a(paramF);
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(org.org.org.ui.asm.f paramF) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      paramF.add(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    }
  }
  
  public static abstract interface c<T extends AppBarLayout>
  {
    public abstract void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt);
  }
  
  public static abstract interface d
    extends AppBarLayout.c<AppBarLayout>
  {}
}
