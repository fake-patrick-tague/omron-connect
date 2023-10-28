package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.c;
import com.google.android.material.internal.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.org.org.ui.R.raw;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import org.org.org.ui.Switch;
import org.org.org.ui.asm.m;
import v7.v7.package_13.asm.Label;
import v7.v7.package_13.asm.d;
import v7.v7.package_13.asm.o;
import v7.v7.widget.MathUtils;
import v7.view.asm.ViewDragHelper;
import v7.view.asm.ViewDragHelper.Callback;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private static final int i = R.string.from;
  float a = -1.0F;
  private BottomSheetBehavior<V>.g b = null;
  int bottom;
  private Map<View, Integer> c;
  private int data = 0;
  private int entry;
  private boolean g;
  int height;
  private int index;
  WeakReference<V> left;
  private int m = -1;
  int mActivePointerId;
  private ValueAnimator mAnimator;
  private final ViewDragHelper.Callback mDragCallback = new d();
  private boolean mHideable = true;
  private boolean mIgnoreEvents;
  private int mInitialY;
  private int mLastNestedScrollDy;
  private float mMaximumVelocity;
  private boolean mNestedScrolled;
  WeakReference<View> mNestedScrollingChildRef;
  int mPadding;
  int mState = 4;
  boolean mTouchingScrollingChild;
  private VelocityTracker mVelocityTracker;
  ViewDragHelper mViewDragHelper;
  private boolean min;
  float n = 0.5F;
  boolean r;
  private int right;
  private boolean s = true;
  private int size;
  private final ArrayList<f> stack = new ArrayList();
  private boolean state;
  int this$0;
  int top;
  private int v;
  private boolean value;
  private boolean w;
  int width;
  private m x;
  private org.org.org.ui.asm.f y;
  private boolean z = false;
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    v = paramContext.getResources().getDimensionPixelSize(R.raw.abs__config_allowActionMenuItemTextWithIcon);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockActionMenuItemView);
    w = localTypedArray.hasValue(R.styleable.Preference_android_dependency);
    int j = R.styleable.Preference_defaultValue;
    boolean bool = localTypedArray.hasValue(j);
    if (bool) {
      b(paramContext, paramAttributeSet, bool, org.org.org.ui.menu.ClassWriter.getString(paramContext, localTypedArray, j));
    } else {
      a(paramContext, paramAttributeSet, bool);
    }
    init();
    if (Build.VERSION.SDK_INT >= 21) {
      a = localTypedArray.getDimension(R.styleable.TitlePageIndicator_android_textSize, -1.0F);
    }
    j = R.styleable.StickyListHeadersListView_android_fadingEdgeLength;
    paramAttributeSet = localTypedArray.peekValue(j);
    if (paramAttributeSet != null)
    {
      int k = data;
      if (k == -1)
      {
        setPeekHeight(k);
        break label228;
      }
    }
    setPeekHeight(localTypedArray.getDimensionPixelSize(j, -1));
    label228:
    set(localTypedArray.getBoolean(R.styleable.ImageView_baselineAlignBottom, false));
    put(localTypedArray.getBoolean(R.styleable.SlidingMenu_fadeEnabled, false));
    setState(localTypedArray.getBoolean(R.styleable.GraphViewXML_seriesColor, true));
    reset(localTypedArray.getBoolean(R.styleable.CameraBridgeViewBase_show_fps, false));
    setHideable(localTypedArray.getBoolean(R.styleable.SlidingDrawer_allowSingleTap, true));
    reset(localTypedArray.getInt(R.styleable.FormEditText_maxNumber, 0));
    reset(localTypedArray.getFloat(R.styleable.DragSortListView_slide_shuffle_speed, 0.5F));
    j = R.styleable.Toolbar_titleMarginBottom;
    paramAttributeSet = localTypedArray.peekValue(j);
    if ((paramAttributeSet != null) && (type == 16)) {
      setPadding(data);
    } else {
      setPadding(localTypedArray.getDimensionPixelOffset(j, 0));
    }
    localTypedArray.recycle();
    mMaximumVelocity = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  private int a(View paramView, int paramInt1, int paramInt2)
  {
    return v7.v7.package_13.ViewCompat.b(paramView, paramView.getResources().getString(paramInt1), a(paramInt2));
  }
  
  private d a(final int paramInt)
  {
    return new e(paramInt);
  }
  
  private void a()
  {
    Object localObject = left;
    if (localObject == null) {
      return;
    }
    localObject = (View)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    v7.v7.package_13.ViewCompat.a((View)localObject, 524288);
    v7.v7.package_13.ViewCompat.a((View)localObject, 262144);
    v7.v7.package_13.ViewCompat.a((View)localObject, 1048576);
    int j = m;
    if (j != -1) {
      v7.v7.package_13.ViewCompat.a((View)localObject, j);
    }
    int k = mState;
    j = 6;
    if (k != 6) {
      m = a((View)localObject, Switch.left, 6);
    }
    if ((r) && (mState != 5)) {
      a((View)localObject, Label.C, 5);
    }
    k = mState;
    if (k != 3)
    {
      if (k != 4)
      {
        if (k != 6) {
          return;
        }
        a((View)localObject, Label.B, 4);
        a((View)localObject, Label.s, 3);
        return;
      }
      if (s) {
        j = 3;
      }
      a((View)localObject, Label.s, j);
      return;
    }
    if (s) {
      j = 4;
    }
    a((View)localObject, Label.B, j);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    b(paramContext, paramAttributeSet, paramBoolean, null);
  }
  
  private void a(View paramView, Label paramLabel, int paramInt)
  {
    v7.v7.package_13.ViewCompat.a(paramView, paramLabel, null, a(paramInt));
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = left;
    if (localObject == null) {
      return;
    }
    localObject = ((View)((WeakReference)localObject).get()).getParent();
    if (!(localObject instanceof CoordinatorLayout)) {
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int k = ((ViewGroup)localObject).getChildCount();
    if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean)) {
      if (c == null) {
        c = new HashMap(k);
      } else {
        return;
      }
    }
    int j = 0;
    while (j < k)
    {
      View localView = ((ViewGroup)localObject).getChildAt(j);
      if (localView != left.get()) {
        if (paramBoolean)
        {
          if (Build.VERSION.SDK_INT >= 16) {
            c.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          if (z) {
            v7.v7.package_13.ViewCompat.get(localView, 4);
          }
        }
        else if (z)
        {
          Map localMap = c;
          if ((localMap != null) && (localMap.containsKey(localView))) {
            v7.v7.package_13.ViewCompat.get(localView, ((Integer)c.get(localView)).intValue());
          }
        }
      }
      j += 1;
    }
    if (!paramBoolean)
    {
      c = null;
      return;
    }
    if (z) {
      ((View)left.get()).sendAccessibilityEvent(8);
    }
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean, ColorStateList paramColorStateList)
  {
    if (w)
    {
      x = m.a(paramContext, paramAttributeSet, org.org.org.ui.ClassWriter.f, i).a();
      paramAttributeSet = new org.org.org.ui.asm.f(x);
      y = paramAttributeSet;
      paramAttributeSet.d(paramContext);
      if ((paramBoolean) && (paramColorStateList != null))
      {
        y.setColor(paramColorStateList);
        return;
      }
      paramAttributeSet = new TypedValue();
      paramContext.getTheme().resolveAttribute(16842801, paramAttributeSet, true);
      y.setTint(data);
    }
  }
  
  private float getYVelocity()
  {
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker == null) {
      return 0.0F;
    }
    localVelocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
    return mVelocityTracker.getYVelocity(mActivePointerId);
  }
  
  private void init()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    mAnimator = localValueAnimator;
    localValueAnimator.setDuration(500L);
    mAnimator.addUpdateListener(new b());
  }
  
  private void init(final int paramInt)
  {
    final View localView = (View)left.get();
    if (localView == null) {
      return;
    }
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (v7.v7.package_13.ViewCompat.d(localView)))
    {
      localView.post(new a(localView, paramInt));
      return;
    }
    reset(localView, paramInt);
  }
  
  private void onLayoutChild()
  {
    int j = size();
    if (s)
    {
      this$0 = Math.max(height - j, top);
      return;
    }
    this$0 = (height - j);
  }
  
  private void onLayoutChild(boolean paramBoolean)
  {
    if (left != null)
    {
      onLayoutChild();
      if (mState == 4)
      {
        View localView = (View)left.get();
        if (localView != null)
        {
          if (paramBoolean)
          {
            init(mState);
            return;
          }
          localView.requestLayout();
        }
      }
    }
  }
  
  private void onSaveInstanceState(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 29) && (!getValue()) && (!state)) {
      com.google.android.material.internal.ViewCompat.a(paramView, new c());
    }
  }
  
  private void onTouchEvent()
  {
    bottom = ((int)(height * (1.0F - n)));
  }
  
  private void reset()
  {
    mActivePointerId = -1;
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      mVelocityTracker = null;
    }
  }
  
  private void reset(SavedState paramSavedState)
  {
    int j = data;
    if (j == 0) {
      return;
    }
    if ((j == -1) || ((j & 0x1) == 1)) {
      index = id;
    }
    if ((j == -1) || ((j & 0x2) == 2)) {
      s = c;
    }
    if ((j == -1) || ((j & 0x4) == 4)) {
      r = e;
    }
    if ((j == -1) || ((j & 0x8) == 8)) {
      g = b;
    }
  }
  
  private int size()
  {
    if (state) {
      return Math.min(Math.max(right, height - width * 9 / 16), size);
    }
    if (!value)
    {
      int j = entry;
      if (j > 0) {
        return Math.max(index, j + v);
      }
    }
    return index;
  }
  
  private void start(int paramInt)
  {
    if (paramInt == 2) {
      return;
    }
    boolean bool;
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    }
    if (min != bool)
    {
      min = bool;
      if (y != null)
      {
        ValueAnimator localValueAnimator = mAnimator;
        if (localValueAnimator != null)
        {
          if (localValueAnimator.isRunning())
          {
            mAnimator.reverse();
            return;
          }
          float f;
          if (bool) {
            f = 0.0F;
          } else {
            f = 1.0F;
          }
          mAnimator.setFloatValues(new float[] { 1.0F - f, f });
          mAnimator.start();
        }
      }
    }
  }
  
  void add(int paramInt)
  {
    View localView = (View)left.get();
    if ((localView != null) && (!stack.isEmpty()))
    {
      int j = this$0;
      float f1;
      float f2;
      if ((paramInt <= j) && (j != get()))
      {
        j = this$0;
        f1 = j - paramInt;
        f2 = j - get();
      }
      else
      {
        j = this$0;
        f1 = j - paramInt;
        f2 = height - j;
      }
      f1 /= f2;
      paramInt = 0;
      while (paramInt < stack.size())
      {
        ((f)stack.get(paramInt)).nativeSetFloat(localView, f1);
        paramInt += 1;
      }
    }
  }
  
  View findScrollingChild(View paramView)
  {
    if (v7.v7.package_13.ViewCompat.isNestedScrollingEnabled(paramView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = 0;
      int k = paramView.getChildCount();
      while (j < k)
      {
        View localView = findScrollingChild(paramView.getChildAt(j));
        if (localView != null) {
          return localView;
        }
        j += 1;
      }
    }
    return null;
  }
  
  public int get()
  {
    if (s) {
      return top;
    }
    return mPadding;
  }
  
  public boolean getValue()
  {
    return value;
  }
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.isShown()) && (mHideable))
    {
      int j = paramMotionEvent.getActionMasked();
      if (j == 0) {
        reset();
      }
      if (mVelocityTracker == null) {
        mVelocityTracker = VelocityTracker.obtain();
      }
      mVelocityTracker.addMovement(paramMotionEvent);
      Object localObject2 = null;
      if (j != 0)
      {
        if ((j == 1) || (j == 3))
        {
          mTouchingScrollingChild = false;
          mActivePointerId = -1;
          if (mIgnoreEvents)
          {
            mIgnoreEvents = false;
            return false;
          }
        }
      }
      else
      {
        int k = (int)paramMotionEvent.getX();
        mInitialY = ((int)paramMotionEvent.getY());
        if (mState != 2)
        {
          localObject1 = mNestedScrollingChildRef;
          if (localObject1 != null) {
            localObject1 = (View)((WeakReference)localObject1).get();
          } else {
            localObject1 = null;
          }
          if ((localObject1 != null) && (paramCoordinatorLayout.isPointInChildBounds((View)localObject1, k, mInitialY)))
          {
            mActivePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            mTouchingScrollingChild = true;
          }
        }
        boolean bool;
        if ((mActivePointerId == -1) && (!paramCoordinatorLayout.isPointInChildBounds(paramView, k, mInitialY))) {
          bool = true;
        } else {
          bool = false;
        }
        mIgnoreEvents = bool;
      }
      if (!mIgnoreEvents)
      {
        paramView = mViewDragHelper;
        if ((paramView != null) && (paramView.shouldInterceptTouchEvent(paramMotionEvent))) {
          return true;
        }
      }
      Object localObject1 = mNestedScrollingChildRef;
      paramView = localObject2;
      if (localObject1 != null) {
        paramView = (View)((WeakReference)localObject1).get();
      }
      if ((j == 2) && (paramView != null) && (!mIgnoreEvents) && (mState != 1) && (!paramCoordinatorLayout.isPointInChildBounds(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (mViewDragHelper != null) && (Math.abs(mInitialY - paramMotionEvent.getY()) > mViewDragHelper.getTouchSlop())) {
        return true;
      }
    }
    else
    {
      mIgnoreEvents = true;
    }
    return false;
  }
  
  public void onLayoutChild(CoordinatorLayout.e paramE)
  {
    super.onLayoutChild(paramE);
    left = null;
    mViewDragHelper = null;
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    if ((v7.v7.package_13.ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!v7.v7.package_13.ViewCompat.getFitsSystemWindows(paramView))) {
      paramView.setFitsSystemWindows(true);
    }
    if (left == null)
    {
      right = paramCoordinatorLayout.getResources().getDimensionPixelSize(R.raw.left);
      onSaveInstanceState(paramView);
      left = new WeakReference(paramView);
      if (w)
      {
        localF = y;
        if (localF != null) {
          v7.v7.package_13.ViewCompat.setBackgroundDrawable(paramView, localF);
        }
      }
      org.org.org.ui.asm.f localF = y;
      if (localF != null)
      {
        float f2 = a;
        float f1 = f2;
        if (f2 == -1.0F) {
          f1 = v7.v7.package_13.ViewCompat.getElevation(paramView);
        }
        localF.add(f1);
        boolean bool;
        if (mState == 3) {
          bool = true;
        } else {
          bool = false;
        }
        min = bool;
        localF = y;
        if (bool) {
          f1 = 0.0F;
        } else {
          f1 = 1.0F;
        }
        localF.a(f1);
      }
      a();
      if (v7.v7.package_13.ViewCompat.getImportantForAccessibility(paramView) == 0) {
        v7.v7.package_13.ViewCompat.get(paramView, 1);
      }
    }
    if (mViewDragHelper == null) {
      mViewDragHelper = ViewDragHelper.create(paramCoordinatorLayout, mDragCallback);
    }
    int j = paramView.getTop();
    paramCoordinatorLayout.onLayoutChild(paramView, paramInt);
    width = paramCoordinatorLayout.getWidth();
    height = paramCoordinatorLayout.getHeight();
    paramInt = paramView.getHeight();
    size = paramInt;
    top = Math.max(0, height - paramInt);
    onTouchEvent();
    onLayoutChild();
    paramInt = mState;
    if (paramInt == 3) {
      v7.v7.package_13.ViewCompat.offsetTopAndBottom(paramView, get());
    } else if (paramInt == 6) {
      v7.v7.package_13.ViewCompat.offsetTopAndBottom(paramView, bottom);
    } else if ((r) && (paramInt == 5)) {
      v7.v7.package_13.ViewCompat.offsetTopAndBottom(paramView, height);
    } else if (paramInt == 4) {
      v7.v7.package_13.ViewCompat.offsetTopAndBottom(paramView, this$0);
    } else if ((paramInt == 1) || (paramInt == 2)) {
      v7.v7.package_13.ViewCompat.offsetTopAndBottom(paramView, j - paramView.getTop());
    }
    mNestedScrollingChildRef = new WeakReference(findScrollingChild(paramView));
    return true;
  }
  
  public boolean onNestedPreFling(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, float paramFloat1, float paramFloat2)
  {
    WeakReference localWeakReference = mNestedScrollingChildRef;
    return (localWeakReference != null) && (paramView2 == localWeakReference.get()) && ((mState != 3) || (super.onNestedPreFling(paramCoordinatorLayout, paramView1, paramView2, paramFloat1, paramFloat2)));
  }
  
  public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1) {
      return;
    }
    paramCoordinatorLayout = mNestedScrollingChildRef;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout = (View)paramCoordinatorLayout.get();
    } else {
      paramCoordinatorLayout = null;
    }
    if (paramView2 != paramCoordinatorLayout) {
      return;
    }
    paramInt1 = paramView1.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0)
    {
      if (paramInt3 < get())
      {
        paramArrayOfInt[1] = (paramInt1 - get());
        v7.v7.package_13.ViewCompat.offsetTopAndBottom(paramView1, -paramArrayOfInt[1]);
        setState(3);
      }
      else
      {
        if (!mHideable) {
          return;
        }
        paramArrayOfInt[1] = paramInt2;
        v7.v7.package_13.ViewCompat.offsetTopAndBottom(paramView1, -paramInt2);
        setState(1);
      }
    }
    else if ((paramInt2 < 0) && (!paramView2.canScrollVertically(-1)))
    {
      int j = this$0;
      if ((paramInt3 > j) && (!r))
      {
        paramArrayOfInt[1] = (paramInt1 - j);
        v7.v7.package_13.ViewCompat.offsetTopAndBottom(paramView1, -paramArrayOfInt[1]);
        setState(4);
      }
      else
      {
        if (!mHideable) {
          return;
        }
        paramArrayOfInt[1] = paramInt2;
        v7.v7.package_13.ViewCompat.offsetTopAndBottom(paramView1, -paramInt2);
        setState(1);
      }
    }
    add(paramView1.getTop());
    mLastNestedScrollDy = paramInt2;
    mNestedScrolled = true;
  }
  
  public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt) {}
  
  public void onRestoreInstanceState()
  {
    super.onRestoreInstanceState();
    left = null;
    mViewDragHelper = null;
  }
  
  public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, View paramView, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramCoordinatorLayout, paramView, paramParcelable.getSuperState());
    reset(paramParcelable);
    int j = state;
    if ((j != 1) && (j != 2))
    {
      mState = j;
      return;
    }
    mState = 4;
  }
  
  public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    return new SavedState(super.onSaveInstanceState(paramCoordinatorLayout, paramView), this);
  }
  
  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
  {
    mLastNestedScrollDy = 0;
    mNestedScrolled = false;
    return (paramInt1 & 0x2) != 0;
  }
  
  public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt)
  {
    paramInt = paramView1.getTop();
    int k = get();
    int j = 3;
    if (paramInt == k)
    {
      setState(3);
      return;
    }
    paramCoordinatorLayout = mNestedScrollingChildRef;
    if ((paramCoordinatorLayout != null) && (paramView2 == paramCoordinatorLayout.get()))
    {
      if (!mNestedScrolled) {
        return;
      }
      if (mLastNestedScrollDy > 0)
      {
        if (s)
        {
          paramInt = top;
          break label354;
        }
        k = paramView1.getTop();
        paramInt = bottom;
        if (k <= paramInt)
        {
          paramInt = mPadding;
          break label354;
        }
      }
      else
      {
        if ((r) && (shouldHide(paramView1, getYVelocity())))
        {
          paramInt = height;
          j = 5;
          break label354;
        }
        if (mLastNestedScrollDy == 0)
        {
          paramInt = paramView1.getTop();
          if (s)
          {
            if (Math.abs(paramInt - top) < Math.abs(paramInt - this$0))
            {
              paramInt = top;
              break label354;
            }
            paramInt = this$0;
          }
          else
          {
            k = bottom;
            if (paramInt < k)
            {
              if (paramInt < Math.abs(paramInt - this$0))
              {
                paramInt = mPadding;
                break label354;
              }
              paramInt = bottom;
              break label338;
            }
            if (Math.abs(paramInt - k) < Math.abs(paramInt - this$0))
            {
              paramInt = bottom;
              break label338;
            }
            paramInt = this$0;
          }
        }
        else
        {
          if (!s) {
            break label303;
          }
        }
      }
      for (paramInt = this$0;; paramInt = this$0)
      {
        j = 4;
        break;
        label303:
        paramInt = paramView1.getTop();
        if (Math.abs(paramInt - bottom) < Math.abs(paramInt - this$0))
        {
          paramInt = bottom;
          label338:
          j = 6;
          break;
        }
      }
      label354:
      setState(paramView1, j, paramInt, false);
      mNestedScrolled = false;
    }
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    if (!paramView.isShown()) {
      return false;
    }
    int j = paramMotionEvent.getActionMasked();
    if ((mState == 1) && (j == 0)) {
      return true;
    }
    paramCoordinatorLayout = mViewDragHelper;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.processTouchEvent(paramMotionEvent);
    }
    if (j == 0) {
      reset();
    }
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
    mVelocityTracker.addMovement(paramMotionEvent);
    if ((mViewDragHelper != null) && (j == 2) && (!mIgnoreEvents) && (Math.abs(mInitialY - paramMotionEvent.getY()) > mViewDragHelper.getTouchSlop())) {
      mViewDragHelper.captureChildView(paramView, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
    }
    return mIgnoreEvents ^ true;
  }
  
  public void put(boolean paramBoolean)
  {
    value = paramBoolean;
  }
  
  public void reset(float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F))
    {
      n = paramFloat;
      if (left != null) {
        onTouchEvent();
      }
    }
    else
    {
      throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
  }
  
  public void reset(int paramInt)
  {
    data = paramInt;
  }
  
  void reset(View paramView, int paramInt)
  {
    int j;
    if (paramInt == 4)
    {
      j = this$0;
    }
    else if (paramInt == 6)
    {
      int k = bottom;
      if (s)
      {
        j = top;
        if (k <= j)
        {
          paramInt = 3;
          break label84;
        }
      }
      j = k;
    }
    else if (paramInt == 3)
    {
      j = get();
    }
    else
    {
      if ((!r) || (paramInt != 5)) {
        break label93;
      }
      j = height;
    }
    label84:
    setState(paramView, paramInt, j, false);
    return;
    label93:
    paramView = new StringBuilder();
    paramView.append("Illegal state argument: ");
    paramView.append(paramInt);
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public void reset(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public void set(boolean paramBoolean)
  {
    if (r != paramBoolean)
    {
      r = paramBoolean;
      if ((!paramBoolean) && (mState == 5)) {
        write(4);
      }
      a();
    }
  }
  
  public void setHideable(boolean paramBoolean)
  {
    mHideable = paramBoolean;
  }
  
  public void setPadding(int paramInt)
  {
    if (paramInt >= 0)
    {
      mPadding = paramInt;
      return;
    }
    throw new IllegalArgumentException("offset must be greater than or equal to 0");
  }
  
  public void setPeekHeight(int paramInt)
  {
    setState(paramInt, false);
  }
  
  void setState(int paramInt)
  {
    if (mState == paramInt) {
      return;
    }
    mState = paramInt;
    Object localObject = left;
    if (localObject == null) {
      return;
    }
    localObject = (View)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    int j = 0;
    if (paramInt == 3) {
      a(true);
    } else if ((paramInt == 6) || (paramInt == 5) || (paramInt == 4)) {
      a(false);
    }
    start(paramInt);
    while (j < stack.size())
    {
      ((f)stack.get(j)).setColor((View)localObject, paramInt);
      j += 1;
    }
    a();
  }
  
  public final void setState(int paramInt, boolean paramBoolean)
  {
    int j = 1;
    if (paramInt == -1)
    {
      if (!state)
      {
        state = true;
        paramInt = j;
        break label63;
      }
    }
    else {
      if ((state) || (index != paramInt)) {
        break label47;
      }
    }
    paramInt = 0;
    break label63;
    label47:
    state = false;
    index = Math.max(0, paramInt);
    paramInt = j;
    label63:
    if (paramInt != 0) {
      onLayoutChild(paramBoolean);
    }
  }
  
  void setState(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = mViewDragHelper;
    if ((localObject != null) && (paramBoolean ? ((ViewDragHelper)localObject).settleCapturedViewAt(paramView.getLeft(), paramInt2) : ((ViewDragHelper)localObject).smoothSlideViewTo(paramView, paramView.getLeft(), paramInt2))) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 != 0)
    {
      setState(2);
      start(paramInt1);
      if (b == null) {
        b = new g(paramView, paramInt1);
      }
      if (!g.b(b))
      {
        localObject = b;
        state = paramInt1;
        v7.v7.package_13.ViewCompat.postOnAnimation(paramView, (Runnable)localObject);
        g.b(b, true);
        return;
      }
      b.state = paramInt1;
      return;
    }
    setState(paramInt1);
  }
  
  public void setState(boolean paramBoolean)
  {
    if (s == paramBoolean) {
      return;
    }
    s = paramBoolean;
    if (left != null) {
      onLayoutChild();
    }
    int j;
    if ((s) && (mState == 6)) {
      j = 3;
    } else {
      j = mState;
    }
    setState(j);
    a();
  }
  
  boolean shouldHide(View paramView, float paramFloat)
  {
    if (g) {
      return true;
    }
    if (paramView.getTop() < this$0) {
      return false;
    }
    int j = size();
    return Math.abs(paramView.getTop() + paramFloat * 0.1F - this$0) / j > 0.5F;
  }
  
  public void write(int paramInt)
  {
    if (paramInt == mState) {
      return;
    }
    if (left == null)
    {
      if ((paramInt == 4) || (paramInt == 3) || (paramInt == 6) || ((r) && (paramInt == 5))) {
        mState = paramInt;
      }
    }
    else {
      init(paramInt);
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    boolean b;
    boolean c;
    boolean e;
    int id;
    final int state;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      state = paramParcel.readInt();
      id = paramParcel.readInt();
      int i = paramParcel.readInt();
      boolean bool2 = false;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      c = bool1;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      e = bool1;
      boolean bool1 = bool2;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      }
      b = bool1;
    }
    
    public SavedState(Parcelable paramParcelable, BottomSheetBehavior paramBottomSheetBehavior)
    {
      super();
      state = mState;
      id = BottomSheetBehavior.access$getMState(paramBottomSheetBehavior);
      c = BottomSheetBehavior.access$getShouldHide(paramBottomSheetBehavior);
      e = r;
      b = BottomSheetBehavior.next(paramBottomSheetBehavior);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    static final class a
      implements Parcelable.ClassLoaderCreator<BottomSheetBehavior.SavedState>
    {
      a() {}
      
      public BottomSheetBehavior.SavedState[] a(int paramInt)
      {
        return new BottomSheetBehavior.SavedState[paramInt];
      }
      
      public BottomSheetBehavior.SavedState getInstance(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new BottomSheetBehavior.SavedState(paramParcel, paramClassLoader);
      }
      
      public BottomSheetBehavior.SavedState readDate(Parcel paramParcel)
      {
        return new BottomSheetBehavior.SavedState(paramParcel, null);
      }
    }
  }
  
  class a
    implements Runnable
  {
    a(View paramView, int paramInt) {}
    
    public void run()
    {
      reset(localView, paramInt);
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      if (BottomSheetBehavior.a(BottomSheetBehavior.this) != null) {
        BottomSheetBehavior.a(BottomSheetBehavior.this).a(f);
      }
    }
  }
  
  class c
    implements c
  {
    c() {}
    
    public v7.v7.package_13.f a(View paramView, v7.v7.package_13.f paramF, i paramI)
    {
      BottomSheetBehavior.set(BottomSheetBehavior.this, dright);
      BottomSheetBehavior.access$getSetStateInternal(BottomSheetBehavior.this, false);
      return paramF;
    }
  }
  
  class d
    extends ViewDragHelper.Callback
  {
    d() {}
    
    private boolean onTouchEvent(View paramView)
    {
      int i = paramView.getTop();
      paramView = BottomSheetBehavior.this;
      return i > (height + paramView.get()) / 2;
    }
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getLeft();
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      int i = get();
      paramView = BottomSheetBehavior.this;
      if (r) {
        paramInt2 = height;
      } else {
        paramInt2 = this$0;
      }
      return MathUtils.constrain(paramInt1, i, paramInt2);
    }
    
    public int getViewVerticalDragRange(View paramView)
    {
      paramView = BottomSheetBehavior.this;
      if (r) {
        return height;
      }
      return this$0;
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      if ((paramInt == 1) && (BottomSheetBehavior.access$getMHideable(BottomSheetBehavior.this))) {
        setState(1);
      }
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      add(paramInt2);
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      int j = 4;
      if (paramFloat2 < 0.0F) {
        if (BottomSheetBehavior.access$getShouldHide(BottomSheetBehavior.this)) {
          i = top;
        }
      }
      BottomSheetBehavior localBottomSheetBehavior;
      for (;;)
      {
        j = 3;
        break label498;
        j = paramView.getTop();
        localBottomSheetBehavior = BottomSheetBehavior.this;
        i = bottom;
        if (j > i) {
          break label305;
        }
        i = mPadding;
        continue;
        localBottomSheetBehavior = BottomSheetBehavior.this;
        if ((!r) || (!localBottomSheetBehavior.shouldHide(paramView, paramFloat2))) {
          break label218;
        }
        if (((Math.abs(paramFloat1) < Math.abs(paramFloat2)) && (paramFloat2 > 500.0F)) || (onTouchEvent(paramView)))
        {
          i = height;
          j = 5;
          break label498;
        }
        if (BottomSheetBehavior.access$getShouldHide(BottomSheetBehavior.this))
        {
          i = top;
        }
        else
        {
          if (Math.abs(paramView.getTop() - mPadding) >= Math.abs(paramView.getTop() - bottom)) {
            break;
          }
          i = mPadding;
        }
      }
      int i = bottom;
      break label305;
      label218:
      if ((paramFloat2 != 0.0F) && (Math.abs(paramFloat1) <= Math.abs(paramFloat2)))
      {
        if (BottomSheetBehavior.access$getShouldHide(BottomSheetBehavior.this))
        {
          i = this$0;
          break label498;
        }
        i = paramView.getTop();
        if (Math.abs(i - bottom) < Math.abs(i - this$0)) {
          i = bottom;
        }
      }
      for (;;)
      {
        label305:
        j = 6;
        break label498;
        i = this$0;
        break label498;
        i = paramView.getTop();
        if (BottomSheetBehavior.access$getShouldHide(BottomSheetBehavior.this))
        {
          if (Math.abs(i - top) < Math.abs(i - this$0))
          {
            i = top;
            break;
          }
          i = this$0;
          break label498;
        }
        localBottomSheetBehavior = BottomSheetBehavior.this;
        int k = bottom;
        if (i < k)
        {
          if (i < Math.abs(i - this$0))
          {
            i = mPadding;
            break;
          }
          i = bottom;
          continue;
        }
        if (Math.abs(i - k) >= Math.abs(i - this$0)) {
          break label489;
        }
        i = bottom;
      }
      label489:
      i = this$0;
      label498:
      setState(paramView, j, i, true);
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      Object localObject = BottomSheetBehavior.this;
      int i = mState;
      if (i == 1) {
        return false;
      }
      if (mTouchingScrollingChild) {
        return false;
      }
      if ((i == 3) && (mActivePointerId == paramInt))
      {
        localObject = mNestedScrollingChildRef;
        if (localObject != null) {
          localObject = (View)((WeakReference)localObject).get();
        } else {
          localObject = null;
        }
        if ((localObject != null) && (((View)localObject).canScrollVertically(-1))) {
          return false;
        }
      }
      localObject = left;
      return (localObject != null) && (((WeakReference)localObject).get() == paramView);
    }
  }
  
  class e
    implements d
  {
    e(int paramInt) {}
    
    public boolean b(View paramView, o paramO)
    {
      write(paramInt);
      return true;
    }
  }
  
  public static abstract class f
  {
    public f() {}
    
    public abstract void nativeSetFloat(View paramView, float paramFloat);
    
    public abstract void setColor(View paramView, int paramInt);
  }
  
  private class g
    implements Runnable
  {
    private boolean b;
    private final View mLayout;
    int state;
    
    g(View paramView, int paramInt)
    {
      mLayout = paramView;
      state = paramInt;
    }
    
    public void run()
    {
      ViewDragHelper localViewDragHelper = mViewDragHelper;
      if ((localViewDragHelper != null) && (localViewDragHelper.continueSettling(true))) {
        v7.v7.package_13.ViewCompat.postOnAnimation(mLayout, this);
      } else {
        setState(state);
      }
      b = false;
    }
  }
}
