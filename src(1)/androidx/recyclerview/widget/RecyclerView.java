package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import v7.cardview.R.dimen;
import v7.cardview.R.styleable;
import v7.cardview.SingularValueDecomposition;
import v7.v7.menu.TraceCompat;
import v7.v7.package_13.ActionMenuItemView;
import v7.v7.package_13.Frame;
import v7.v7.package_13.NestedScrollingChild;
import v7.v7.package_13.NestedScrollingChildHelper;
import v7.v7.package_13.RecyclerView.LayoutManager;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.asm.AccessibilityEventCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat.CollectionInfoCompat;

public class RecyclerView
  extends ViewGroup
  implements NestedScrollingChild
{
  private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
  private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
  static final boolean M;
  private static final int[] NESTED_SCROLLING_ATTRS = { 16843830 };
  static final boolean c;
  static final boolean itemView;
  static final Interpolator mInterpolator = new c();
  private static final boolean mPostUpdatesOnAnimation;
  static final boolean y;
  private q DEBUG;
  final RectF a = new RectF();
  private final Rect bottom = new Rect();
  Item h;
  v i;
  m mAccessibilityDelegate;
  private final AccessibilityManager mAccessibilityManager;
  private r mActiveOnItemTouchListener;
  Adapter mAdapter;
  AdapterHelper mAdapterHelper;
  boolean mAdapterUpdateDuringMeasure;
  final List<b0> mAttachedScrap;
  private EdgeEffect mBottomGlow;
  private j mChildDrawingOrderCallback;
  ChildHelper mChildHelper;
  boolean mClipToPadding;
  boolean mDataSetHasChangedAfterLayout = false;
  private int mEatRequestLayout = 0;
  private int mEatenAccessibilityChangeFlags;
  boolean mFirstLayoutComplete;
  boolean mHasFixedSize;
  private boolean mHasStableIds;
  private int mHeight;
  private boolean mIgnoreMotionEventTillDown;
  private int mInitialTouchX;
  private int mInitialTouchY;
  boolean mIsAttached;
  private boolean mIsMeasuring;
  l mItemAnimator = new DefaultItemAnimator();
  private RecyclerView.l.b mItemAnimatorListener;
  private Runnable mItemAnimatorRunner;
  final ArrayList<n> mItemDecorations = new ArrayList();
  boolean mItemsAddedOrRemoved;
  boolean mItemsChanged;
  private int mLastTouchX;
  private int mLastTouchY;
  o mLayout;
  boolean mLayoutFrozen;
  private int mLayoutOrScrollCounter = 0;
  boolean mLayoutRequestEaten;
  private EdgeEffect mLeftGlow;
  private final int mMaxFlingVelocity;
  private final int mMinFlingVelocity;
  private final int[] mMinMaxLayoutPositions;
  private final int[] mNestedOffsets;
  private final w mObserver = new w();
  private List<p> mOnChildAttachStateListeners;
  private final ArrayList<r> mOnItemTouchListeners = new ArrayList();
  SavedState mPendingSavedState;
  boolean mPostedAnimatorRunner;
  final u mRecycler = new u();
  private EdgeEffect mRightGlow;
  boolean mRunningLayoutOrScroll = false;
  private float mScreenDensity = Float.MIN_VALUE;
  private float mScrollFactor = Float.MIN_VALUE;
  private s mScrollListener;
  private List<s> mScrollListeners;
  private final int[] mScrollOffset;
  private int mScrollPointerId = -1;
  private int mScrollState = 0;
  private NestedScrollingChildHelper mScrollingChildHelper;
  boolean mShowDefault;
  final y mState;
  final Rect mTempRect = new Rect();
  private EdgeEffect mTopGlow;
  private int mTouchSlop;
  final Runnable mUpdateChildViewsRunnable = new a();
  private VelocityTracker mVelocityTracker;
  Slider mView;
  final a0 mViewFlinger;
  private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
  final ViewInfoStore mViewInfoStore = new ViewInfoStore();
  private int mWidth;
  private k n = new k();
  private int s = 0;
  final int[] this$0;
  final List<v> x = new ArrayList();
  
  static
  {
    int j = Build.VERSION.SDK_INT;
    boolean bool;
    if ((j != 18) && (j != 19) && (j != 20)) {
      bool = false;
    } else {
      bool = true;
    }
    y = bool;
    if (j >= 23) {
      bool = true;
    } else {
      bool = false;
    }
    M = bool;
    if (j >= 16) {
      bool = true;
    } else {
      bool = false;
    }
    c = bool;
    if (j >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    itemView = bool;
    if (j <= 15) {
      bool = true;
    } else {
      bool = false;
    }
    mPostUpdatesOnAnimation = bool;
    if (j <= 15) {
      bool = true;
    } else {
      bool = false;
    }
    FORCE_INVALIDATE_DISPLAY_LIST = bool;
    Class localClass = Integer.TYPE;
    LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class, AttributeSet.class, localClass, localClass };
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, SingularValueDecomposition.n);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool2 = true;
    mHasStableIds = true;
    mViewFlinger = new a0();
    if (itemView) {
      localObject1 = new Item();
    } else {
      localObject1 = null;
    }
    h = ((Item)localObject1);
    mState = new y();
    mItemsAddedOrRemoved = false;
    mItemsChanged = false;
    mItemAnimatorListener = new m();
    mPostedAnimatorRunner = false;
    mMinMaxLayoutPositions = new int[2];
    mScrollOffset = new int[2];
    mNestedOffsets = new int[2];
    this$0 = new int[2];
    mAttachedScrap = new ArrayList();
    mItemAnimatorRunner = new b();
    mWidth = 0;
    mHeight = 0;
    mViewInfoProcessCallback = new d();
    setScrollContainer(true);
    setFocusableInTouchMode(true);
    Object localObject1 = ViewConfiguration.get(paramContext);
    mTouchSlop = ((ViewConfiguration)localObject1).getScaledTouchSlop();
    mScrollFactor = Frame.a((ViewConfiguration)localObject1, paramContext);
    mScreenDensity = Frame.d((ViewConfiguration)localObject1, paramContext);
    mMinFlingVelocity = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
    mMaxFlingVelocity = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
    if (getOverScrollMode() == 2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    mItemAnimator.setListener(mItemAnimatorListener);
    initAdapterManager();
    initChildrenHelper();
    smoothScrollBy();
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.get(this, 1);
    }
    mAccessibilityManager = ((AccessibilityManager)getContext().getSystemService("accessibility"));
    setAccessibilityDelegateCompat(new m(this));
    Object localObject2 = R.styleable.RecyclerView;
    localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject2, paramInt, 0);
    ViewCompat.obtainStyledAttributes(this, paramContext, (int[])localObject2, paramAttributeSet, (TypedArray)localObject1, paramInt, 0);
    localObject2 = ((TypedArray)localObject1).getString(R.styleable.RecyclerView_layoutManager);
    if (((TypedArray)localObject1).getInt(R.styleable.CameraBridgeViewBase_camera_id, -1) == -1) {
      setDescendantFocusability(262144);
    }
    mClipToPadding = ((TypedArray)localObject1).getBoolean(R.styleable.CirclePageIndicator_centered, true);
    boolean bool1 = ((TypedArray)localObject1).getBoolean(R.styleable.FlowLayout_debugDraw, false);
    mShowDefault = bool1;
    if (bool1) {
      init((StateListDrawable)((TypedArray)localObject1).getDrawable(R.styleable.PullToRefresh_ptrDrawable), ((TypedArray)localObject1).getDrawable(R.styleable.FloatingActionButton_android_background), (StateListDrawable)((TypedArray)localObject1).getDrawable(R.styleable.l), ((TypedArray)localObject1).getDrawable(R.styleable.c));
    }
    ((TypedArray)localObject1).recycle();
    createLayoutManager(paramContext, (String)localObject2, paramAttributeSet, paramInt, 0);
    bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = NESTED_SCROLLING_ATTRS;
      localObject2 = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject1, paramInt, 0);
      ViewCompat.obtainStyledAttributes(this, paramContext, (int[])localObject1, paramAttributeSet, (TypedArray)localObject2, paramInt, 0);
      bool1 = ((TypedArray)localObject2).getBoolean(0, true);
      ((TypedArray)localObject2).recycle();
    }
    setNestedScrollingEnabled(bool1);
  }
  
  static RecyclerView a(View paramView)
  {
    if (!(paramView instanceof ViewGroup)) {
      return null;
    }
    if ((paramView instanceof RecyclerView)) {
      return (RecyclerView)paramView;
    }
    paramView = (ViewGroup)paramView;
    int k = paramView.getChildCount();
    int j = 0;
    while (j < k)
    {
      RecyclerView localRecyclerView = a(paramView.getChildAt(j));
      if (localRecyclerView != null) {
        return localRecyclerView;
      }
      j += 1;
    }
    return null;
  }
  
  private void a()
  {
    if ((mHasStableIds) && (mAdapter != null) && (hasFocus()) && (getDescendantFocusability() != 393216))
    {
      if ((getDescendantFocusability() == 131072) && (isFocused())) {
        return;
      }
      Object localObject1;
      if (!isFocused())
      {
        localObject1 = getFocusedChild();
        if ((FORCE_INVALIDATE_DISPLAY_LIST) && ((((View)localObject1).getParent() == null) || (!((View)localObject1).hasFocus())))
        {
          if (mChildHelper.getChildCount() == 0) {
            requestFocus();
          }
        }
        else if (!mChildHelper.isHidden((View)localObject1)) {
          return;
        }
      }
      long l = mState.mState;
      Object localObject2 = null;
      if ((l != -1L) && (mAdapter.hasStableIds())) {
        localObject1 = findViewHolderForItemId(mState.mState);
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (!mChildHelper.isHidden(itemView)) && (itemView.hasFocusable()))
      {
        localObject1 = itemView;
      }
      else
      {
        localObject1 = localObject2;
        if (mChildHelper.getChildCount() > 0) {
          localObject1 = draw();
        }
      }
      if (localObject1 != null)
      {
        int j = mState.left;
        localObject2 = localObject1;
        if (j != -1L)
        {
          View localView = ((View)localObject1).findViewById(j);
          localObject2 = localObject1;
          if (localView != null)
          {
            localObject2 = localObject1;
            if (localView.isFocusable()) {
              localObject2 = localView;
            }
          }
        }
        localObject2.requestFocus();
      }
    }
  }
  
  private void addAnimatingView(b0 paramB0)
  {
    View localView = itemView;
    int j;
    if (localView.getParent() == this) {
      j = 1;
    } else {
      j = 0;
    }
    mRecycler.unscrapView(getChildViewHolder(localView));
    if (paramB0.isTmpDetached())
    {
      mChildHelper.attachViewToParent(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (j == 0)
    {
      mChildHelper.addView(localView, true);
      return;
    }
    mChildHelper.hide(localView);
  }
  
  private void animateChange(b0 paramB01, b0 paramB02, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramB01.setIsRecyclable(false);
    if (paramBoolean1) {
      addAnimatingView(paramB01);
    }
    if (paramB01 != paramB02)
    {
      if (paramBoolean2) {
        addAnimatingView(paramB02);
      }
      mShadowedHolder = paramB02;
      addAnimatingView(paramB01);
      mRecycler.unscrapView(paramB01);
      paramB02.setIsRecyclable(false);
      mShadowingHolder = paramB01;
    }
    if (mItemAnimator.animateChange(paramB01, paramB02, paramC1, paramC2)) {
      postAnimationRunner();
    }
  }
  
  private boolean arrowScroll(View paramView1, View paramView2, int paramInt)
  {
    if ((paramView2 != null) && (paramView2 != this))
    {
      if (paramView2 == paramView1) {
        return false;
      }
      if (findContainingItemView(paramView2) == null) {
        return false;
      }
      if (paramView1 == null) {
        return true;
      }
      if (findContainingItemView(paramView1) == null) {
        return true;
      }
      mTempRect.set(0, 0, paramView1.getWidth(), paramView1.getHeight());
      bottom.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
      offsetDescendantRectToMyCoords(paramView1, mTempRect);
      offsetDescendantRectToMyCoords(paramView2, bottom);
      int j = mLayout.getLayoutDirection();
      int k = -1;
      int m;
      if (j == 1) {
        m = -1;
      } else {
        m = 1;
      }
      paramView1 = mTempRect;
      j = left;
      paramView2 = bottom;
      int i1 = left;
      int i3;
      if (((j < i1) || (right <= i1)) && (right < right))
      {
        j = 1;
      }
      else
      {
        i2 = right;
        i3 = right;
        if (((i2 > i3) || (j >= i3)) && (j > i1)) {
          j = -1;
        } else {
          j = 0;
        }
      }
      i1 = top;
      int i2 = top;
      if (((i1 < i2) || (bottom <= i2)) && (bottom < bottom))
      {
        k = 1;
      }
      else
      {
        i3 = bottom;
        int i4 = bottom;
        if (((i3 <= i4) && (i1 < i4)) || (i1 <= i2)) {
          k = 0;
        }
      }
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
                if (paramInt == 130)
                {
                  if (k > 0) {
                    return true;
                  }
                }
                else
                {
                  paramView1 = new StringBuilder();
                  paramView1.append("Invalid direction: ");
                  paramView1.append(paramInt);
                  paramView1.append(append());
                  throw new IllegalArgumentException(paramView1.toString());
                }
              }
              else if (j > 0) {
                return true;
              }
            }
            else if (k < 0) {
              return true;
            }
          }
          else if (j < 0) {
            return true;
          }
        }
        else if ((k > 0) || ((k == 0) && (j * m > 0))) {
          return true;
        }
      }
      else if ((k < 0) || ((k == 0) && (j * m < 0))) {
        return true;
      }
    }
    return false;
  }
  
  private void cancelTouch()
  {
    resetTouch();
    setScrollState(0);
  }
  
  private void createLayoutManager(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (!paramString.isEmpty())
      {
        String str = getFullClassName(paramContext, paramString);
        try
        {
          boolean bool = isInEditMode();
          if (bool) {
            paramString = getClass().getClassLoader();
          } else {
            paramString = paramContext.getClassLoader();
          }
          Class localClass = Class.forName(str, false, paramString).asSubclass(o.class);
          Object localObject = null;
          paramString = LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
          try
          {
            paramString = localClass.getConstructor(paramString);
            paramContext = new Object[] { paramContext, paramAttributeSet, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) };
          }
          catch (NoSuchMethodException paramContext) {}
          try
          {
            paramString = localClass.getConstructor(new Class[0]);
            paramContext = localObject;
            paramString.setAccessible(true);
            paramContext = paramString.newInstance(paramContext);
            paramContext = (o)paramContext;
            setLayoutManager(paramContext);
            return;
          }
          catch (NoSuchMethodException paramString)
          {
            paramString.initCause(paramContext);
            paramContext = new StringBuilder();
            paramContext.append(paramAttributeSet.getPositionDescription());
            paramContext.append(": Error creating LayoutManager ");
            paramContext.append(str);
            paramContext = new IllegalStateException(paramContext.toString(), paramString);
            throw paramContext;
          }
          return;
        }
        catch (ClassCastException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Class is not a LayoutManager ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (IllegalAccessException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Cannot access non-public constructor ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (InstantiationException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Could not instantiate the LayoutManager: ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (InvocationTargetException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Could not instantiate the LayoutManager: ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (ClassNotFoundException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Unable to find LayoutManager ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
      }
    }
  }
  
  private boolean didChildRangeChange(int paramInt1, int paramInt2)
  {
    findMinMaxChildLayoutPositions(mMinMaxLayoutPositions);
    int[] arrayOfInt = mMinMaxLayoutPositions;
    return (arrayOfInt[0] != paramInt1) || (arrayOfInt[1] != paramInt2);
  }
  
  private void dispatchContentChangedIfNecessary()
  {
    int j = mEatenAccessibilityChangeFlags;
    mEatenAccessibilityChangeFlags = 0;
    if ((j != 0) && (isAccessibilityEnabled()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      AccessibilityEventCompat.setContentChangeTypes(localAccessibilityEvent, j);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private void dispatchLayoutStep1()
  {
    Object localObject = mState;
    boolean bool = true;
    ((y)localObject).assertLayoutStep(1);
    onInterceptTouchEvent(mState);
    mState.mIsMeasuring = false;
    eatRequestLayout();
    mViewInfoStore.clear();
    onEnterLayoutOrScroll();
    processAdapterUpdatesAndSetAnimationFlags();
    getViewForPosition();
    localObject = mState;
    if ((!mRunSimpleAnimations) || (!mItemsChanged)) {
      bool = false;
    }
    mTrackOldChangeHolders = bool;
    mItemsChanged = false;
    mItemsAddedOrRemoved = false;
    mInPreLayout = mRunPredictiveAnimations;
    mItemCount = mAdapter.getItemCount();
    findMinMaxChildLayoutPositions(mMinMaxLayoutPositions);
    int k;
    int j;
    RecyclerView.l.c localC;
    if (mState.mRunSimpleAnimations)
    {
      k = mChildHelper.getChildCount();
      j = 0;
      while (j < k)
      {
        localObject = getChildViewHolderInt(mChildHelper.getChildAt(j));
        if ((!((b0)localObject).shouldIgnore()) && ((!((b0)localObject).isInvalid()) || (mAdapter.hasStableIds())))
        {
          localC = mItemAnimator.recordPreLayoutInformation(mState, (b0)localObject, l.buildAdapterChangeFlagsForAnimations((b0)localObject), ((b0)localObject).getUnmodifiedPayloads());
          mViewInfoStore.addToPreLayout((b0)localObject, localC);
          if ((mState.mTrackOldChangeHolders) && (((b0)localObject).isUpdated()) && (!((b0)localObject).isRemoved()) && (!((b0)localObject).shouldIgnore()) && (!((b0)localObject).isInvalid()))
          {
            long l = getChangedHolderKey((b0)localObject);
            mViewInfoStore.addToOldChangeHolders(l, (b0)localObject);
          }
        }
        j += 1;
      }
    }
    if (mState.mRunPredictiveAnimations)
    {
      saveOldPositions();
      localObject = mState;
      bool = mStructureChanged;
      mStructureChanged = false;
      mLayout.onLayoutChildren(mRecycler, (y)localObject);
      mState.mStructureChanged = bool;
      j = 0;
      while (j < mChildHelper.getChildCount())
      {
        localObject = getChildViewHolderInt(mChildHelper.getChildAt(j));
        if ((!((b0)localObject).shouldIgnore()) && (!mViewInfoStore.isInPreLayout((b0)localObject)))
        {
          int m = l.buildAdapterChangeFlagsForAnimations((b0)localObject);
          k = m;
          bool = ((b0)localObject).hasAnyOfTheFlags(8192);
          if (!bool) {
            k = m | 0x1000;
          }
          localC = mItemAnimator.recordPreLayoutInformation(mState, (b0)localObject, k, ((b0)localObject).getUnmodifiedPayloads());
          if (bool) {
            recordAnimationInfoIfBouncedHiddenView((b0)localObject, localC);
          } else {
            mViewInfoStore.addToAppearedInPreLayoutHolders((b0)localObject, localC);
          }
        }
        j += 1;
      }
      clearOldPositions();
    }
    else
    {
      clearOldPositions();
    }
    resumeRequestLayout();
    resumeRequestLayout(false);
    mState.mLayoutStep = 2;
  }
  
  private void dispatchLayoutStep2()
  {
    eatRequestLayout();
    onEnterLayoutOrScroll();
    mState.assertLayoutStep(6);
    mAdapterHelper.consumeUpdatesInOnePass();
    mState.mItemCount = mAdapter.getItemCount();
    mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
    if ((mPendingSavedState != null) && (mAdapter.canRestoreState()))
    {
      localObject = mPendingSavedState.mLayoutState;
      if (localObject != null) {
        mLayout.onRestoreInstanceState((Parcelable)localObject);
      }
      mPendingSavedState = null;
    }
    Object localObject = mState;
    mInPreLayout = false;
    mLayout.onLayoutChildren(mRecycler, (y)localObject);
    localObject = mState;
    mStructureChanged = false;
    boolean bool;
    if ((mRunSimpleAnimations) && (mItemAnimator != null)) {
      bool = true;
    } else {
      bool = false;
    }
    mRunSimpleAnimations = bool;
    mLayoutStep = 4;
    resumeRequestLayout();
    resumeRequestLayout(false);
  }
  
  private void dispatchLayoutStep3()
  {
    mState.assertLayoutStep(4);
    eatRequestLayout();
    onEnterLayoutOrScroll();
    Object localObject = mState;
    mLayoutStep = 1;
    if (mRunSimpleAnimations)
    {
      int j = mChildHelper.getChildCount() - 1;
      while (j >= 0)
      {
        localObject = getChildViewHolderInt(mChildHelper.getChildAt(j));
        if (!((b0)localObject).shouldIgnore())
        {
          long l = getChangedHolderKey((b0)localObject);
          RecyclerView.l.c localC2 = mItemAnimator.recordPostLayoutInformation(mState, (b0)localObject);
          b0 localB0 = mViewInfoStore.getFromOldChangeHolders(l);
          if ((localB0 != null) && (!localB0.shouldIgnore()))
          {
            boolean bool1 = mViewInfoStore.isDisappearing(localB0);
            boolean bool2 = mViewInfoStore.isDisappearing((b0)localObject);
            if ((bool1) && (localB0 == localObject))
            {
              mViewInfoStore.addToPostLayout((b0)localObject, localC2);
            }
            else
            {
              RecyclerView.l.c localC1 = mViewInfoStore.popFromPreLayout(localB0);
              mViewInfoStore.addToPostLayout((b0)localObject, localC2);
              localC2 = mViewInfoStore.popFromPostLayout((b0)localObject);
              if (localC1 == null) {
                handleMissingPreInfoForChangeError(l, (b0)localObject, localB0);
              } else {
                animateChange(localB0, (b0)localObject, localC1, localC2, bool1, bool2);
              }
            }
          }
          else
          {
            mViewInfoStore.addToPostLayout((b0)localObject, localC2);
          }
        }
        j -= 1;
      }
      mViewInfoStore.process(mViewInfoProcessCallback);
    }
    mLayout.removeAndRecycleScrapInt(mRecycler);
    localObject = mState;
    mPreviousLayoutItemCount = mItemCount;
    mDataSetHasChangedAfterLayout = false;
    mRunningLayoutOrScroll = false;
    mRunSimpleAnimations = false;
    mRunPredictiveAnimations = false;
    mLayout.mDataSetHasChangedAfterLayout = false;
    localObject = mRecycler.mChangedScrap;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = mLayout;
    if (mState)
    {
      b = 0;
      mState = false;
      mRecycler.next();
    }
    mLayout.onLayoutChildren(mState);
    resumeRequestLayout();
    resumeRequestLayout(false);
    mViewInfoStore.clear();
    localObject = mMinMaxLayoutPositions;
    if (didChildRangeChange(localObject[0], localObject[1])) {
      dispatchOnScrolled(0, 0);
    }
    a();
    onDraw();
  }
  
  private boolean dispatchOnItemTouch(MotionEvent paramMotionEvent)
  {
    r localR = mActiveOnItemTouchListener;
    if (localR == null)
    {
      if (paramMotionEvent.getAction() == 0) {
        return false;
      }
      return dispatchOnItemTouchIntercept(paramMotionEvent);
    }
    localR.onTouchEvent(this, paramMotionEvent);
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 1)) {
      mActiveOnItemTouchListener = null;
    }
    return true;
  }
  
  private boolean dispatchOnItemTouchIntercept(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    int m = mOnItemTouchListeners.size();
    int j = 0;
    while (j < m)
    {
      r localR = (r)mOnItemTouchListeners.get(j);
      if ((localR.onInterceptTouchEvent(this, paramMotionEvent)) && (k != 3))
      {
        mActiveOnItemTouchListener = localR;
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  private View draw()
  {
    Object localObject = mState;
    int j = mPosition;
    if (j == -1) {
      j = 0;
    }
    int m = ((y)localObject).getItemCount();
    int k = j;
    while (k < m)
    {
      localObject = findViewHolderForAdapterPosition(k);
      if (localObject == null) {
        break;
      }
      if (itemView.hasFocusable()) {
        return itemView;
      }
      k += 1;
    }
    j = Math.min(m, j) - 1;
    while (j >= 0)
    {
      localObject = findViewHolderForAdapterPosition(j);
      if (localObject == null) {
        return null;
      }
      if (itemView.hasFocusable()) {
        return itemView;
      }
      j -= 1;
    }
    return null;
  }
  
  private void draw(View paramView1, View paramView2)
  {
    if (paramView2 != null) {
      localObject = paramView2;
    } else {
      localObject = paramView1;
    }
    mTempRect.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
    Object localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof LayoutParams))
    {
      localObject = (LayoutParams)localObject;
      if (!mInsetsDirty)
      {
        localObject = mDecorInsets;
        localRect = mTempRect;
        left -= left;
        right += right;
        top -= top;
        bottom += bottom;
      }
    }
    if (paramView2 != null)
    {
      offsetDescendantRectToMyCoords(paramView2, mTempRect);
      offsetRectIntoDescendantCoords(paramView1, mTempRect);
    }
    localObject = mLayout;
    Rect localRect = mTempRect;
    boolean bool2 = mFirstLayoutComplete;
    boolean bool1;
    if (paramView2 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((o)localObject).requestChildRectangleOnScreen(this, paramView1, localRect, bool2 ^ true, bool1);
  }
  
  private void findMinMaxChildLayoutPositions(int[] paramArrayOfInt)
  {
    int i4 = mChildHelper.getChildCount();
    if (i4 == 0)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    int k = Integer.MAX_VALUE;
    int i1 = Integer.MIN_VALUE;
    int m = 0;
    while (m < i4)
    {
      b0 localB0 = getChildViewHolderInt(mChildHelper.getChildAt(m));
      int i3;
      if (localB0.shouldIgnore())
      {
        i3 = i1;
      }
      else
      {
        int i2 = localB0.getLayoutPosition();
        int j = k;
        if (i2 < k) {
          j = i2;
        }
        k = j;
        i3 = i1;
        if (i2 > i1)
        {
          i3 = i2;
          k = j;
        }
      }
      m += 1;
      i1 = i3;
    }
    paramArrayOfInt[0] = k;
    paramArrayOfInt[1] = i1;
  }
  
  static b0 getChildViewHolderInt(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return getLayoutParamsmViewHolder;
  }
  
  private String getFullClassName(Context paramContext, String paramString)
  {
    if (paramString.charAt(0) == '.')
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    if (paramString.contains(".")) {
      return paramString;
    }
    paramContext = new StringBuilder();
    paramContext.append(RecyclerView.class.getPackage().getName());
    paramContext.append('.');
    paramContext.append(paramString);
    return paramContext.toString();
  }
  
  private NestedScrollingChildHelper getScrollingChildHelper()
  {
    if (mScrollingChildHelper == null) {
      mScrollingChildHelper = new NestedScrollingChildHelper(this);
    }
    return mScrollingChildHelper;
  }
  
  private void getViewForPosition()
  {
    boolean bool = mHasStableIds;
    y localY = null;
    Object localObject;
    if ((bool) && (hasFocus()) && (mAdapter != null)) {
      localObject = getFocusedChild();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      localObject = localY;
    } else {
      localObject = findContainingViewHolder((View)localObject);
    }
    if (localObject == null)
    {
      onDraw();
      return;
    }
    localY = mState;
    long l;
    if (mAdapter.hasStableIds()) {
      l = ((b0)localObject).getItemId();
    } else {
      l = -1L;
    }
    mState = l;
    localY = mState;
    int j;
    if (mDataSetHasChangedAfterLayout) {
      j = -1;
    } else if (((b0)localObject).isRemoved()) {
      j = mOldPosition;
    } else {
      j = ((b0)localObject).getAbsoluteAdapterPosition();
    }
    mPosition = j;
    mState.left = remove(itemView);
  }
  
  private void handleMissingPreInfoForChangeError(long paramLong, b0 paramB01, b0 paramB02)
  {
    int k = mChildHelper.getChildCount();
    int j = 0;
    while (j < k)
    {
      localObject = getChildViewHolderInt(mChildHelper.getChildAt(j));
      if ((localObject != paramB01) && (getChangedHolderKey((b0)localObject) == paramLong))
      {
        paramB02 = mAdapter;
        if ((paramB02 != null) && (paramB02.hasStableIds()))
        {
          paramB02 = new StringBuilder();
          paramB02.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
          paramB02.append(localObject);
          paramB02.append(" \n View Holder 2:");
          paramB02.append(paramB01);
          paramB02.append(append());
          throw new IllegalStateException(paramB02.toString());
        }
        paramB02 = new StringBuilder();
        paramB02.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        paramB02.append(localObject);
        paramB02.append(" \n View Holder 2:");
        paramB02.append(paramB01);
        paramB02.append(append());
        throw new IllegalStateException(paramB02.toString());
      }
      j += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
    ((StringBuilder)localObject).append(paramB02);
    ((StringBuilder)localObject).append(" cannot be found but it is necessary for ");
    ((StringBuilder)localObject).append(paramB01);
    ((StringBuilder)localObject).append(append());
    android.util.Log.e("RecyclerView", ((StringBuilder)localObject).toString());
  }
  
  private boolean hasUpdatedView()
  {
    int k = mChildHelper.getChildCount();
    int j = 0;
    while (j < k)
    {
      b0 localB0 = getChildViewHolderInt(mChildHelper.getChildAt(j));
      if ((localB0 != null) && (!localB0.shouldIgnore()) && (localB0.isUpdated())) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  private void initChildrenHelper()
  {
    mChildHelper = new ChildHelper(new e());
  }
  
  static void next(b0 paramB0)
  {
    Object localObject = mNestedRecyclerView;
    if (localObject != null)
    {
      localObject = (View)((WeakReference)localObject).get();
      while (localObject != null)
      {
        if (localObject == itemView) {
          return;
        }
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof View)) {
          localObject = (View)localObject;
        } else {
          localObject = null;
        }
      }
      mNestedRecyclerView = null;
    }
  }
  
  private void onDraw()
  {
    y localY = mState;
    mState = -1L;
    mPosition = -1;
    left = -1;
  }
  
  static void onDraw(View paramView, Rect paramRect)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = mDecorInsets;
    paramRect.set(paramView.getLeft() - left - leftMargin, paramView.getTop() - top - topMargin, paramView.getRight() + right + rightMargin, paramView.getBottom() + bottom + bottomMargin);
  }
  
  private void onPointerUp(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(j) == mScrollPointerId)
    {
      if (j == 0) {
        j = 1;
      } else {
        j = 0;
      }
      mScrollPointerId = paramMotionEvent.getPointerId(j);
      int k = (int)(paramMotionEvent.getX(j) + 0.5F);
      mLastTouchY = k;
      mInitialTouchY = k;
      j = (int)(paramMotionEvent.getY(j) + 0.5F);
      mLastTouchX = j;
      mInitialTouchX = j;
    }
  }
  
  private void onTouchEvent(int paramInt1, int paramInt2, MotionEvent paramMotionEvent, int paramInt3)
  {
    Object localObject = mLayout;
    if (localObject == null)
    {
      android.util.Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (mLayoutFrozen) {
      return;
    }
    int[] arrayOfInt = this$0;
    int i2 = 0;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    boolean bool1 = ((o)localObject).canScrollHorizontally();
    boolean bool2 = mLayout.canScrollVertically();
    if (bool1) {
      j = 1;
    } else {
      j = 0;
    }
    int k = j;
    if (bool2) {
      k = j | 0x2;
    }
    startNestedScroll(k, paramInt3);
    int m;
    if (bool1) {
      m = paramInt1;
    } else {
      m = 0;
    }
    int i1;
    if (bool2) {
      i1 = paramInt2;
    } else {
      i1 = 0;
    }
    k = paramInt1;
    int j = paramInt2;
    if (dispatchNestedPreScroll(m, i1, this$0, mScrollOffset, paramInt3))
    {
      localObject = this$0;
      k = paramInt1 - localObject[0];
      j = paramInt2 - localObject[1];
    }
    if (bool1) {
      paramInt1 = k;
    } else {
      paramInt1 = 0;
    }
    paramInt2 = i2;
    if (bool2) {
      paramInt2 = j;
    }
    scrollByInternal(paramInt1, paramInt2, paramMotionEvent, paramInt3);
    paramMotionEvent = mView;
    if ((paramMotionEvent != null) && ((k != 0) || (j != 0))) {
      paramMotionEvent.start(this, k, j);
    }
    setNestedScrollingEnabled(paramInt3);
  }
  
  private boolean predictiveItemAnimationsEnabled()
  {
    return (mItemAnimator != null) && (mLayout.supportsPredictiveItemAnimations());
  }
  
  private void processAdapterUpdatesAndSetAnimationFlags()
  {
    if (mDataSetHasChangedAfterLayout)
    {
      mAdapterHelper.reset();
      if (mRunningLayoutOrScroll) {
        mLayout.onItemsChanged(this);
      }
    }
    if (predictiveItemAnimationsEnabled()) {
      mAdapterHelper.preProcess();
    } else {
      mAdapterHelper.consumeUpdatesInOnePass();
    }
    boolean bool1 = mItemsAddedOrRemoved;
    boolean bool2 = false;
    int j;
    if ((!bool1) && (!mItemsChanged)) {
      j = 0;
    } else {
      j = 1;
    }
    y localY = mState;
    if ((mFirstLayoutComplete) && (mItemAnimator != null))
    {
      bool1 = mDataSetHasChangedAfterLayout;
      if (((bool1) || (j != 0) || (mLayout.mDataSetHasChangedAfterLayout)) && ((!bool1) || (mAdapter.hasStableIds())))
      {
        bool1 = true;
        break label145;
      }
    }
    bool1 = false;
    label145:
    mRunSimpleAnimations = bool1;
    localY = mState;
    bool1 = bool2;
    if (mRunSimpleAnimations)
    {
      bool1 = bool2;
      if (j != 0)
      {
        bool1 = bool2;
        if (!mDataSetHasChangedAfterLayout)
        {
          bool1 = bool2;
          if (predictiveItemAnimationsEnabled()) {
            bool1 = true;
          }
        }
      }
    }
    mRunPredictiveAnimations = bool1;
  }
  
  private void pullGlows(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int k = 1;
    if (paramFloat2 < 0.0F)
    {
      ensureBottomGlow();
      EdgeEffectCompat.draw(mBottomGlow, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
    }
    for (;;)
    {
      j = 1;
      break label80;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      ensureLeftGlow();
      EdgeEffectCompat.draw(mLeftGlow, paramFloat2 / getWidth(), paramFloat3 / getHeight());
    }
    int j = 0;
    label80:
    if (paramFloat4 < 0.0F)
    {
      ensureRightGlow();
      EdgeEffectCompat.draw(mRightGlow, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      j = k;
    }
    else if (paramFloat4 > 0.0F)
    {
      ensureTopGlow();
      EdgeEffectCompat.draw(mTopGlow, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
      j = k;
    }
    if ((j != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void releaseGlows()
  {
    EdgeEffect localEdgeEffect = mBottomGlow;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool2 = mBottomGlow.isFinished();
    }
    else
    {
      bool2 = false;
    }
    localEdgeEffect = mRightGlow;
    boolean bool1 = bool2;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool1 = bool2 | mRightGlow.isFinished();
    }
    localEdgeEffect = mLeftGlow;
    boolean bool2 = bool1;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool2 = bool1 | mLeftGlow.isFinished();
    }
    localEdgeEffect = mTopGlow;
    bool1 = bool2;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      bool1 = bool2 | mTopGlow.isFinished();
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private int remove(View paramView)
  {
    int j = paramView.getId();
    while ((!paramView.isFocused()) && ((paramView instanceof ViewGroup)) && (paramView.hasFocus()))
    {
      View localView2 = ((ViewGroup)paramView).getFocusedChild();
      View localView1 = localView2;
      paramView = localView1;
      if (localView2.getId() != -1)
      {
        j = localView2.getId();
        paramView = localView1;
      }
    }
    return j;
  }
  
  private void resetTouch()
  {
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    setNestedScrollingEnabled(0);
    releaseGlows();
  }
  
  private void setAdapterInternal(Adapter paramAdapter, boolean paramBoolean1, boolean paramBoolean2)
  {
    Adapter localAdapter = mAdapter;
    if (localAdapter != null)
    {
      localAdapter.unregisterAdapterDataObserver(mObserver);
      mAdapter.onDetachedFromRecyclerView(this);
    }
    if ((!paramBoolean1) || (paramBoolean2)) {
      setAdapterInternal();
    }
    mAdapterHelper.reset();
    localAdapter = mAdapter;
    mAdapter = paramAdapter;
    if (paramAdapter != null)
    {
      paramAdapter.registerAdapterDataObserver(mObserver);
      paramAdapter.onAttachedToRecyclerView(this);
    }
    paramAdapter = mLayout;
    if (paramAdapter != null) {
      paramAdapter.onLayoutChildren(localAdapter, mAdapter);
    }
    mRecycler.onAdapterChanged(localAdapter, mAdapter, paramBoolean1);
    mState.mStructureChanged = true;
  }
  
  private void smoothScrollBy()
  {
    if (ViewCompat.finish(this) == 0) {
      ViewCompat.create(this, 8);
    }
  }
  
  private void stopScrollersInternal()
  {
    mViewFlinger.stop();
    o localO = mLayout;
    if (localO != null) {
      localO.onLayoutChildren();
    }
  }
  
  public void a(s paramS)
  {
    List localList = mScrollListeners;
    if (localList != null) {
      localList.remove(paramS);
    }
  }
  
  void a(String paramString)
  {
    if (isComputingLayout())
    {
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramString.append(append());
        throw new IllegalStateException(paramString.toString());
      }
      throw new IllegalStateException(paramString);
    }
    if (s > 0)
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(append());
      android.util.Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(paramString.toString()));
    }
  }
  
  void absorbGlows(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      ensureBottomGlow();
      if (mBottomGlow.isFinished()) {
        mBottomGlow.onAbsorb(-paramInt1);
      }
    }
    else if (paramInt1 > 0)
    {
      ensureLeftGlow();
      if (mLeftGlow.isFinished()) {
        mLeftGlow.onAbsorb(paramInt1);
      }
    }
    if (paramInt2 < 0)
    {
      ensureRightGlow();
      if (mRightGlow.isFinished()) {
        mRightGlow.onAbsorb(-paramInt2);
      }
    }
    else if (paramInt2 > 0)
    {
      ensureTopGlow();
      if (mTopGlow.isFinished()) {
        mTopGlow.onAbsorb(paramInt2);
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void addFocusables(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    o localO = mLayout;
    if ((localO == null) || (!localO.onAddFocusables(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public void addItemDecoration(n paramN)
  {
    addItemDecoration(paramN, -1);
  }
  
  public void addItemDecoration(n paramN, int paramInt)
  {
    o localO = mLayout;
    if (localO != null) {
      localO.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    }
    if (mItemDecorations.isEmpty()) {
      setWillNotDraw(false);
    }
    if (paramInt < 0) {
      mItemDecorations.add(paramN);
    } else {
      mItemDecorations.add(paramInt, paramN);
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void addOnChildAttachStateChangeListener(p paramP)
  {
    if (mOnChildAttachStateListeners == null) {
      mOnChildAttachStateListeners = new ArrayList();
    }
    mOnChildAttachStateListeners.add(paramP);
  }
  
  public void addOnItemTouchListener(r paramR)
  {
    mOnItemTouchListeners.add(paramR);
  }
  
  void animateAppearance(b0 paramB0, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2)
  {
    paramB0.setIsRecyclable(false);
    if (mItemAnimator.animateAppearance(paramB0, paramC1, paramC2)) {
      postAnimationRunner();
    }
  }
  
  void animateDisappearance(b0 paramB0, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2)
  {
    addAnimatingView(paramB0);
    paramB0.setIsRecyclable(false);
    if (mItemAnimator.animateDisappearance(paramB0, paramC1, paramC2)) {
      postAnimationRunner();
    }
  }
  
  String append()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", adapter:");
    localStringBuilder.append(mAdapter);
    localStringBuilder.append(", layout:");
    localStringBuilder.append(mLayout);
    localStringBuilder.append(", context:");
    localStringBuilder.append(getContext());
    return localStringBuilder.toString();
  }
  
  boolean canReuseUpdatedViewHolder(b0 paramB0)
  {
    l localL = mItemAnimator;
    return (localL == null) || (localL.canReuseUpdatedViewHolder(paramB0, paramB0.getUnmodifiedPayloads()));
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (mLayout.checkLayoutParams((LayoutParams)paramLayoutParams));
  }
  
  void clearOldPositions()
  {
    int k = mChildHelper.getUnfilteredChildCount();
    int j = 0;
    while (j < k)
    {
      b0 localB0 = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
      if (!localB0.shouldIgnore()) {
        localB0.clearOldPosition();
      }
      j += 1;
    }
    mRecycler.clearOldPositions();
  }
  
  public int computeHorizontalScrollExtent()
  {
    o localO = mLayout;
    if (localO == null) {
      return 0;
    }
    if (localO.canScrollHorizontally()) {
      return mLayout.computeHorizontalScrollExtent(mState);
    }
    return 0;
  }
  
  public int computeHorizontalScrollOffset()
  {
    o localO = mLayout;
    if (localO == null) {
      return 0;
    }
    if (localO.canScrollHorizontally()) {
      return mLayout.computeHorizontalScrollOffset(mState);
    }
    return 0;
  }
  
  public int computeHorizontalScrollRange()
  {
    o localO = mLayout;
    if (localO == null) {
      return 0;
    }
    if (localO.canScrollHorizontally()) {
      return mLayout.computeHorizontalScrollRange(mState);
    }
    return 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    o localO = mLayout;
    if (localO == null) {
      return 0;
    }
    if (localO.canScrollVertically()) {
      return mLayout.computeVerticalScrollExtent(mState);
    }
    return 0;
  }
  
  public int computeVerticalScrollOffset()
  {
    o localO = mLayout;
    if (localO == null) {
      return 0;
    }
    if (localO.canScrollVertically()) {
      return mLayout.computeVerticalScrollOffset(mState);
    }
    return 0;
  }
  
  public int computeVerticalScrollRange()
  {
    o localO = mLayout;
    if (localO == null) {
      return 0;
    }
    if (localO.canScrollVertically()) {
      return mLayout.computeVerticalScrollRange(mState);
    }
    return 0;
  }
  
  void considerReleasingGlowsOnScroll(int paramInt1, int paramInt2)
  {
    EdgeEffect localEdgeEffect = mBottomGlow;
    if ((localEdgeEffect != null) && (!localEdgeEffect.isFinished()) && (paramInt1 > 0))
    {
      mBottomGlow.onRelease();
      bool2 = mBottomGlow.isFinished();
    }
    else
    {
      bool2 = false;
    }
    localEdgeEffect = mLeftGlow;
    boolean bool1 = bool2;
    if (localEdgeEffect != null)
    {
      bool1 = bool2;
      if (!localEdgeEffect.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 < 0)
        {
          mLeftGlow.onRelease();
          bool1 = bool2 | mLeftGlow.isFinished();
        }
      }
    }
    localEdgeEffect = mRightGlow;
    boolean bool2 = bool1;
    if (localEdgeEffect != null)
    {
      bool2 = bool1;
      if (!localEdgeEffect.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 > 0)
        {
          mRightGlow.onRelease();
          bool2 = bool1 | mRightGlow.isFinished();
        }
      }
    }
    localEdgeEffect = mTopGlow;
    bool1 = bool2;
    if (localEdgeEffect != null)
    {
      bool1 = bool2;
      if (!localEdgeEffect.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 < 0)
        {
          mTopGlow.onRelease();
          bool1 = bool2 | mTopGlow.isFinished();
        }
      }
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void consumePendingUpdateOperations()
  {
    if ((mFirstLayoutComplete) && (!mDataSetHasChangedAfterLayout))
    {
      if (!mAdapterHelper.hasPendingUpdates()) {
        return;
      }
      if ((mAdapterHelper.hasAnyUpdateTypes(4)) && (!mAdapterHelper.hasAnyUpdateTypes(11)))
      {
        TraceCompat.beginSection("RV PartialInvalidate");
        eatRequestLayout();
        onEnterLayoutOrScroll();
        mAdapterHelper.preProcess();
        if (!mLayoutRequestEaten) {
          if (hasUpdatedView()) {
            dispatchLayout();
          } else {
            mAdapterHelper.consumePostponedUpdates();
          }
        }
        resumeRequestLayout(true);
        resumeRequestLayout();
        TraceCompat.beginSection();
        return;
      }
      if (mAdapterHelper.hasPendingUpdates())
      {
        TraceCompat.beginSection("RV FullInvalidate");
        dispatchLayout();
        TraceCompat.beginSection();
      }
    }
    else
    {
      TraceCompat.beginSection("RV FullInvalidate");
      dispatchLayout();
      TraceCompat.beginSection();
    }
  }
  
  void defaultOnMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(o.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), o.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
  }
  
  void dispatchChildAttached(View paramView)
  {
    Object localObject = getChildViewHolderInt(paramView);
    onChildAttachedToWindow(paramView);
    Adapter localAdapter = mAdapter;
    if ((localAdapter != null) && (localObject != null)) {
      localAdapter.onViewAttachedToWindow((b0)localObject);
    }
    localObject = mOnChildAttachStateListeners;
    if (localObject != null)
    {
      int j = ((List)localObject).size() - 1;
      while (j >= 0)
      {
        ((p)mOnChildAttachStateListeners.get(j)).bindView(paramView);
        j -= 1;
      }
    }
  }
  
  void dispatchChildDetached(View paramView)
  {
    Object localObject = getChildViewHolderInt(paramView);
    onChildDetachedFromWindow(paramView);
    Adapter localAdapter = mAdapter;
    if ((localAdapter != null) && (localObject != null)) {
      localAdapter.onViewDetachedFromWindow((b0)localObject);
    }
    localObject = mOnChildAttachStateListeners;
    if (localObject != null)
    {
      int j = ((List)localObject).size() - 1;
      while (j >= 0)
      {
        ((p)mOnChildAttachStateListeners.get(j)).onChildViewDetachedFromWindow(paramView);
        j -= 1;
      }
    }
  }
  
  void dispatchLayout()
  {
    if (mAdapter == null)
    {
      android.util.Log.w("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    if (mLayout == null)
    {
      android.util.Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    }
    mState.mIsMeasuring = false;
    int j;
    if ((mIsMeasuring) && ((mWidth != getWidth()) || (mHeight != getHeight()))) {
      j = 1;
    } else {
      j = 0;
    }
    mWidth = 0;
    mHeight = 0;
    mIsMeasuring = false;
    if (mState.mLayoutStep == 1)
    {
      dispatchLayoutStep1();
      mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    }
    else if ((!mAdapterHelper.hasUpdates()) && (j == 0) && (mLayout.getWidth() == getWidth()) && (mLayout.getHeight() == getHeight()))
    {
      mLayout.setExactMeasureSpecsFrom(this);
    }
    else
    {
      mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    }
    dispatchLayoutStep3();
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  void dispatchOnScrollStateChanged(int paramInt)
  {
    Object localObject = mLayout;
    if (localObject != null) {
      ((o)localObject).onScrollStateChanged(paramInt);
    }
    onScrollStateChanged(paramInt);
    localObject = mScrollListener;
    if (localObject != null) {
      ((s)localObject).b(this, paramInt);
    }
    localObject = mScrollListeners;
    if (localObject != null)
    {
      int j = ((List)localObject).size() - 1;
      while (j >= 0)
      {
        ((s)mScrollListeners.get(j)).b(this, paramInt);
        j -= 1;
      }
    }
  }
  
  void dispatchOnScrolled(int paramInt1, int paramInt2)
  {
    s += 1;
    int j = getScrollX();
    int k = getScrollY();
    onScrollChanged(j, k, j - paramInt1, k - paramInt2);
    onScrolled(paramInt1, paramInt2);
    Object localObject = mScrollListener;
    if (localObject != null) {
      ((s)localObject).a(this, paramInt1, paramInt2);
    }
    localObject = mScrollListeners;
    if (localObject != null)
    {
      j = ((List)localObject).size() - 1;
      while (j >= 0)
      {
        ((s)mScrollListeners.get(j)).a(this, paramInt1, paramInt2);
        j -= 1;
      }
    }
    s -= 1;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    onPopulateAccessibilityEvent(paramAccessibilityEvent);
    return true;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = mItemDecorations.size();
    int m = 0;
    int j = 0;
    while (j < k)
    {
      ((n)mItemDecorations.get(j)).onDrawOver(paramCanvas, this, mState);
      j += 1;
    }
    EdgeEffect localEdgeEffect = mBottomGlow;
    int i1 = 1;
    int i2;
    if ((localEdgeEffect != null) && (!localEdgeEffect.isFinished()))
    {
      i2 = paramCanvas.save();
      if (mClipToPadding) {
        j = getPaddingBottom();
      } else {
        j = 0;
      }
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-getHeight() + j, 0.0F);
      localEdgeEffect = mBottomGlow;
      if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
        k = 1;
      } else {
        k = 0;
      }
      paramCanvas.restoreToCount(i2);
    }
    else
    {
      k = 0;
    }
    localEdgeEffect = mRightGlow;
    j = k;
    if (localEdgeEffect != null)
    {
      j = k;
      if (!localEdgeEffect.isFinished())
      {
        i2 = paramCanvas.save();
        if (mClipToPadding) {
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        }
        localEdgeEffect = mRightGlow;
        if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
          j = 1;
        } else {
          j = 0;
        }
        j = k | j;
        paramCanvas.restoreToCount(i2);
      }
    }
    localEdgeEffect = mLeftGlow;
    k = j;
    if (localEdgeEffect != null)
    {
      k = j;
      if (!localEdgeEffect.isFinished())
      {
        i2 = paramCanvas.save();
        int i3 = getWidth();
        if (mClipToPadding) {
          k = getPaddingTop();
        } else {
          k = 0;
        }
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(k, -i3);
        localEdgeEffect = mLeftGlow;
        if ((localEdgeEffect != null) && (localEdgeEffect.draw(paramCanvas))) {
          k = 1;
        } else {
          k = 0;
        }
        k = j | k;
        paramCanvas.restoreToCount(i2);
      }
    }
    localEdgeEffect = mTopGlow;
    j = k;
    if (localEdgeEffect != null)
    {
      j = k;
      if (!localEdgeEffect.isFinished())
      {
        i2 = paramCanvas.save();
        paramCanvas.rotate(180.0F);
        if (mClipToPadding) {
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
        } else {
          paramCanvas.translate(-getWidth(), -getHeight());
        }
        localEdgeEffect = mTopGlow;
        j = m;
        if (localEdgeEffect != null)
        {
          j = m;
          if (localEdgeEffect.draw(paramCanvas)) {
            j = 1;
          }
        }
        j = k | j;
        paramCanvas.restoreToCount(i2);
      }
    }
    if ((j == 0) && (mItemAnimator != null) && (mItemDecorations.size() > 0) && (mItemAnimator.isRunning())) {
      j = i1;
    }
    if (j != 0) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  void eatRequestLayout()
  {
    int j = mEatRequestLayout + 1;
    mEatRequestLayout = j;
    if ((j == 1) && (!mLayoutFrozen)) {
      mLayoutRequestEaten = false;
    }
  }
  
  void ensureBottomGlow()
  {
    if (mBottomGlow != null) {
      return;
    }
    EdgeEffect localEdgeEffect = n.a(this, 0);
    mBottomGlow = localEdgeEffect;
    if (mClipToPadding)
    {
      localEdgeEffect.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    localEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  void ensureLeftGlow()
  {
    if (mLeftGlow != null) {
      return;
    }
    EdgeEffect localEdgeEffect = n.a(this, 2);
    mLeftGlow = localEdgeEffect;
    if (mClipToPadding)
    {
      localEdgeEffect.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    localEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  void ensureRightGlow()
  {
    if (mRightGlow != null) {
      return;
    }
    EdgeEffect localEdgeEffect = n.a(this, 1);
    mRightGlow = localEdgeEffect;
    if (mClipToPadding)
    {
      localEdgeEffect.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    localEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  void ensureTopGlow()
  {
    if (mTopGlow != null) {
      return;
    }
    EdgeEffect localEdgeEffect = n.a(this, 3);
    mTopGlow = localEdgeEffect;
    if (mClipToPadding)
    {
      localEdgeEffect.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    localEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public View findChildViewUnder(float paramFloat1, float paramFloat2)
  {
    int j = mChildHelper.getChildCount() - 1;
    while (j >= 0)
    {
      View localView = mChildHelper.getChildAt(j);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= localView.getRight() + f1) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      j -= 1;
    }
    return null;
  }
  
  public View findContainingItemView(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != null) && (paramView != this) && ((paramView instanceof View)); paramView = localView.getParent()) {
      localView = (View)paramView;
    }
    if (paramView == this) {
      return localView;
    }
    return null;
  }
  
  public b0 findContainingViewHolder(View paramView)
  {
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      return null;
    }
    return getChildViewHolder(paramView);
  }
  
  public b0 findViewHolderForAdapterPosition(int paramInt)
  {
    boolean bool = mDataSetHasChangedAfterLayout;
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    int k = mChildHelper.getUnfilteredChildCount();
    int j = 0;
    while (j < k)
    {
      b0 localB0 = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
      Object localObject2 = localObject1;
      if (localB0 != null)
      {
        localObject2 = localObject1;
        if (!localB0.isRemoved())
        {
          localObject2 = localObject1;
          if (getAdapterPositionFor(localB0) == paramInt) {
            if (mChildHelper.isHidden(itemView)) {
              localObject2 = localB0;
            } else {
              return localB0;
            }
          }
        }
      }
      j += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public b0 findViewHolderForItemId(long paramLong)
  {
    Object localObject2 = mAdapter;
    Object localObject1 = null;
    if (localObject2 != null)
    {
      if (!((Adapter)localObject2).hasStableIds()) {
        return null;
      }
      int k = mChildHelper.getUnfilteredChildCount();
      int j = 0;
      while (j < k)
      {
        b0 localB0 = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
        localObject2 = localObject1;
        if (localB0 != null)
        {
          localObject2 = localObject1;
          if (!localB0.isRemoved())
          {
            localObject2 = localObject1;
            if (localB0.getItemId() == paramLong) {
              if (mChildHelper.isHidden(itemView)) {
                localObject2 = localB0;
              } else {
                return localB0;
              }
            }
          }
        }
        j += 1;
        localObject1 = localObject2;
      }
    }
    return null;
    return localObject1;
  }
  
  b0 findViewHolderForPosition(int paramInt, boolean paramBoolean)
  {
    int k = mChildHelper.getUnfilteredChildCount();
    Object localObject1 = null;
    int j = 0;
    while (j < k)
    {
      b0 localB0 = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
      Object localObject2 = localObject1;
      if (localB0 != null)
      {
        localObject2 = localObject1;
        if (!localB0.isRemoved())
        {
          if (paramBoolean)
          {
            if (mPosition != paramInt)
            {
              localObject2 = localObject1;
              break label115;
            }
          }
          else if (localB0.getLayoutPosition() != paramInt)
          {
            localObject2 = localObject1;
            break label115;
          }
          if (mChildHelper.isHidden(itemView)) {
            localObject2 = localB0;
          } else {
            return localB0;
          }
        }
      }
      label115:
      j += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    Object localObject = mLayout;
    int m = 0;
    if (localObject == null)
    {
      android.util.Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return false;
    }
    if (mLayoutFrozen) {
      return false;
    }
    boolean bool2 = ((o)localObject).canScrollHorizontally();
    boolean bool3 = mLayout.canScrollVertically();
    int j;
    if (bool2)
    {
      j = paramInt1;
      if (Math.abs(paramInt1) >= mMinFlingVelocity) {}
    }
    else
    {
      j = 0;
    }
    int k;
    if (bool3)
    {
      k = paramInt2;
      if (Math.abs(paramInt2) >= mMinFlingVelocity) {}
    }
    else
    {
      k = 0;
    }
    if ((j == 0) && (k == 0)) {
      return false;
    }
    float f1 = j;
    float f2 = k;
    if (!dispatchNestedPreFling(f1, f2))
    {
      boolean bool1;
      if ((!bool2) && (!bool3)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      dispatchNestedFling(f1, f2, bool1);
      localObject = DEBUG;
      if ((localObject != null) && (((q)localObject).a(j, k))) {
        return true;
      }
      if (bool1)
      {
        paramInt1 = m;
        if (bool2) {
          paramInt1 = 1;
        }
        paramInt2 = paramInt1;
        if (bool3) {
          paramInt2 = paramInt1 | 0x2;
        }
        startNestedScroll(paramInt2, 1);
        paramInt1 = mMaxFlingVelocity;
        paramInt1 = Math.max(-paramInt1, Math.min(j, paramInt1));
        paramInt2 = mMaxFlingVelocity;
        paramInt2 = Math.max(-paramInt2, Math.min(k, paramInt2));
        mViewFlinger.fling(paramInt1, paramInt2);
        return true;
      }
    }
    return false;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    Object localObject = mLayout.onFocusSearchFailed(paramView, paramInt);
    if (localObject != null) {
      return localObject;
    }
    localObject = mAdapter;
    int i1 = 1;
    int j;
    if ((localObject != null) && (mLayout != null) && (!isComputingLayout()) && (!mLayoutFrozen)) {
      j = 1;
    } else {
      j = 0;
    }
    localObject = FocusFinder.getInstance();
    int k;
    if ((j != 0) && ((paramInt == 2) || (paramInt == 1)))
    {
      if (mLayout.canScrollVertically())
      {
        if (paramInt == 2) {
          k = 130;
        } else {
          k = 33;
        }
        if (((FocusFinder)localObject).findNextFocus(this, paramView, k) == null) {
          m = 1;
        } else {
          m = 0;
        }
        j = m;
        if (mPostUpdatesOnAnimation)
        {
          paramInt = k;
          j = m;
        }
      }
      else
      {
        j = 0;
      }
      int m = j;
      k = paramInt;
      if (j == 0)
      {
        m = j;
        k = paramInt;
        if (mLayout.canScrollHorizontally())
        {
          if (mLayout.getLayoutDirection() == 1) {
            j = 1;
          } else {
            j = 0;
          }
          if (paramInt == 2) {
            k = 1;
          } else {
            k = 0;
          }
          if ((j ^ k) != 0) {
            j = 66;
          } else {
            j = 17;
          }
          if (((FocusFinder)localObject).findNextFocus(this, paramView, j) == null) {
            k = i1;
          } else {
            k = 0;
          }
          if (mPostUpdatesOnAnimation) {
            paramInt = j;
          }
          m = k;
          k = paramInt;
        }
      }
      if (m != 0)
      {
        consumePendingUpdateOperations();
        if (findContainingItemView(paramView) == null) {
          return null;
        }
        eatRequestLayout();
        mLayout.onFocusSearchFailed(paramView, k, mRecycler, mState);
        resumeRequestLayout(false);
      }
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, k);
    }
    else
    {
      View localView = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
      localObject = localView;
      k = paramInt;
      if (localView == null)
      {
        localObject = localView;
        k = paramInt;
        if (j != 0)
        {
          consumePendingUpdateOperations();
          if (findContainingItemView(paramView) == null) {
            return null;
          }
          eatRequestLayout();
          localObject = mLayout.onFocusSearchFailed(paramView, paramInt, mRecycler, mState);
          resumeRequestLayout(false);
          k = paramInt;
        }
      }
    }
    if ((localObject != null) && (!((View)localObject).hasFocusable()))
    {
      if (getFocusedChild() == null) {
        return super.focusSearch(paramView, k);
      }
      draw((View)localObject, null);
      return paramView;
    }
    if (arrowScroll(paramView, (View)localObject, k)) {
      return localObject;
    }
    return super.focusSearch(paramView, k);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    Object localObject = mLayout;
    if (localObject != null) {
      return ((o)localObject).generateDefaultLayoutParams();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RecyclerView has no LayoutManager");
    ((StringBuilder)localObject).append(append());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    o localO = mLayout;
    if (localO != null) {
      return localO.generateLayoutParams(getContext(), paramAttributeSet);
    }
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("RecyclerView has no LayoutManager");
    paramAttributeSet.append(append());
    throw new IllegalStateException(paramAttributeSet.toString());
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    o localO = mLayout;
    if (localO != null) {
      return localO.generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("RecyclerView has no LayoutManager");
    paramLayoutParams.append(append());
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  public CharSequence getAccessibilityClassName()
  {
    return "androidx.recyclerview.widget.RecyclerView";
  }
  
  public Adapter getAdapter()
  {
    return mAdapter;
  }
  
  int getAdapterPositionFor(b0 paramB0)
  {
    if ((!paramB0.hasAnyOfTheFlags(524)) && (paramB0.isBound())) {
      return mAdapterHelper.applyPendingUpdatesToPosition(mPosition);
    }
    return -1;
  }
  
  public int getBaseline()
  {
    o localO = mLayout;
    if (localO != null) {
      return localO.getBaseline();
    }
    return super.getBaseline();
  }
  
  long getChangedHolderKey(b0 paramB0)
  {
    if (mAdapter.hasStableIds()) {
      return paramB0.getItemId();
    }
    return mPosition;
  }
  
  public int getChildAdapterPosition(View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getAbsoluteAdapterPosition();
    }
    return -1;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    j localJ = mChildDrawingOrderCallback;
    if (localJ == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return localJ.getChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public int getChildLayoutPosition(View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getLayoutPosition();
    }
    return -1;
  }
  
  public b0 getChildViewHolder(View paramView)
  {
    Object localObject = paramView.getParent();
    if ((localObject != null) && (localObject != this))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("View ");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(" is not a direct child of ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return getChildViewHolderInt(paramView);
  }
  
  public boolean getClipToPadding()
  {
    return mClipToPadding;
  }
  
  public m getCompatAccessibilityDelegate()
  {
    return mAccessibilityDelegate;
  }
  
  public k getEdgeEffectFactory()
  {
    return n;
  }
  
  public l getItemAnimator()
  {
    return mItemAnimator;
  }
  
  Rect getItemDecorInsetsForChild(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!mInsetsDirty) {
      return mDecorInsets;
    }
    if ((mState.isPreLayout()) && ((localLayoutParams.isItemChanged()) || (localLayoutParams.isViewInvalid()))) {
      return mDecorInsets;
    }
    Rect localRect1 = mDecorInsets;
    localRect1.set(0, 0, 0, 0);
    int k = mItemDecorations.size();
    int j = 0;
    while (j < k)
    {
      mTempRect.set(0, 0, 0, 0);
      ((n)mItemDecorations.get(j)).getItemOffsets(mTempRect, paramView, this, mState);
      int m = left;
      Rect localRect2 = mTempRect;
      left = (m + left);
      top += top;
      right += right;
      bottom += bottom;
      j += 1;
    }
    mInsetsDirty = false;
    return localRect1;
  }
  
  public int getItemDecorationCount()
  {
    return mItemDecorations.size();
  }
  
  public o getLayoutManager()
  {
    return mLayout;
  }
  
  public int getMaxFlingVelocity()
  {
    return mMaxFlingVelocity;
  }
  
  public int getMinFlingVelocity()
  {
    return mMinFlingVelocity;
  }
  
  long getNanoTime()
  {
    if (itemView) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  public q getOnFlingListener()
  {
    return DEBUG;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return mHasStableIds;
  }
  
  public t getRecycledViewPool()
  {
    return mRecycler.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return mScrollState;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().hasNestedScrollingParent();
  }
  
  public boolean hasPendingAdapterUpdates()
  {
    return (!mFirstLayoutComplete) || (mDataSetHasChangedAfterLayout) || (mAdapterHelper.hasPendingUpdates());
  }
  
  void init(StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2)
  {
    if ((paramStateListDrawable1 != null) && (paramDrawable1 != null) && (paramStateListDrawable2 != null) && (paramDrawable2 != null))
    {
      Resources localResources = getContext().getResources();
      new f(this, paramStateListDrawable1, paramDrawable1, paramStateListDrawable2, paramDrawable2, localResources.getDimensionPixelSize(R.dimen.sb__min_width), localResources.getDimensionPixelSize(R.dimen.sb__max_width), localResources.getDimensionPixelOffset(R.dimen.fab_scroll_threshold));
      return;
    }
    paramStateListDrawable1 = new StringBuilder();
    paramStateListDrawable1.append("Trying to set fast scroller without both required drawables.");
    paramStateListDrawable1.append(append());
    throw new IllegalArgumentException(paramStateListDrawable1.toString());
  }
  
  void initAdapterManager()
  {
    mAdapterHelper = new AdapterHelper(new f());
  }
  
  void invalidateGlows()
  {
    mTopGlow = null;
    mRightGlow = null;
    mLeftGlow = null;
    mBottomGlow = null;
  }
  
  boolean isAccessibilityEnabled()
  {
    AccessibilityManager localAccessibilityManager = mAccessibilityManager;
    return (localAccessibilityManager != null) && (localAccessibilityManager.isEnabled());
  }
  
  public boolean isAttachedToWindow()
  {
    return mIsAttached;
  }
  
  public boolean isComputingLayout()
  {
    return mLayoutOrScrollCounter > 0;
  }
  
  public final boolean isLayoutSuppressed()
  {
    return mLayoutFrozen;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().isNestedScrollingEnabled();
  }
  
  void markItemDecorInsetsDirty()
  {
    int k = mChildHelper.getUnfilteredChildCount();
    int j = 0;
    while (j < k)
    {
      mChildHelper.getUnfilteredChildAt(j).getLayoutParams()).mInsetsDirty = true;
      j += 1;
    }
    mRecycler.markItemDecorInsetsDirty();
  }
  
  void markKnownViewsInvalid()
  {
    int k = mChildHelper.getUnfilteredChildCount();
    int j = 0;
    while (j < k)
    {
      b0 localB0 = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
      if ((localB0 != null) && (!localB0.shouldIgnore())) {
        localB0.addFlags(6);
      }
      j += 1;
    }
    markItemDecorInsetsDirty();
    mRecycler.markKnownViewsInvalid();
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    int k = mChildHelper.getChildCount();
    int j = 0;
    while (j < k)
    {
      mChildHelper.getChildAt(j).offsetLeftAndRight(paramInt);
      j += 1;
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    int k = mChildHelper.getChildCount();
    int j = 0;
    while (j < k)
    {
      mChildHelper.getChildAt(j).offsetTopAndBottom(paramInt);
      j += 1;
    }
  }
  
  void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
  {
    int k = mChildHelper.getUnfilteredChildCount();
    int j = 0;
    while (j < k)
    {
      b0 localB0 = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
      if ((localB0 != null) && (!localB0.shouldIgnore()) && (mPosition >= paramInt1))
      {
        localB0.offsetPosition(paramInt2, false);
        mState.mStructureChanged = true;
      }
      j += 1;
    }
    mRecycler.offsetPositionRecordsForInsert(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
  {
    int i2 = mChildHelper.getUnfilteredChildCount();
    int j;
    int k;
    int m;
    if (paramInt1 < paramInt2)
    {
      j = -1;
      k = paramInt1;
      m = paramInt2;
    }
    else
    {
      m = paramInt1;
      k = paramInt2;
      j = 1;
    }
    int i1 = 0;
    while (i1 < i2)
    {
      b0 localB0 = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i1));
      if (localB0 != null)
      {
        int i3 = mPosition;
        if ((i3 >= k) && (i3 <= m))
        {
          if (i3 == paramInt1) {
            localB0.offsetPosition(paramInt2 - paramInt1, false);
          } else {
            localB0.offsetPosition(j, false);
          }
          mState.mStructureChanged = true;
        }
      }
      i1 += 1;
    }
    mRecycler.offsetPositionRecordsForMove(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = mChildHelper.getUnfilteredChildCount();
    int j = 0;
    while (j < k)
    {
      b0 localB0 = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
      if ((localB0 != null) && (!localB0.shouldIgnore()))
      {
        int m = mPosition;
        if (m >= paramInt1 + paramInt2)
        {
          localB0.offsetPosition(-paramInt2, paramBoolean);
          mState.mStructureChanged = true;
        }
        else if (m >= paramInt1)
        {
          localB0.flagRemovedAndOffsetPosition(paramInt1 - 1, -paramInt2, paramBoolean);
          mState.mStructureChanged = true;
        }
      }
      j += 1;
    }
    mRecycler.offsetPositionRecordsForRemove(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    mLayoutOrScrollCounter = 0;
    boolean bool = true;
    mIsAttached = true;
    if ((!mFirstLayoutComplete) || (isLayoutRequested())) {
      bool = false;
    }
    mFirstLayoutComplete = bool;
    Object localObject1 = mLayout;
    if (localObject1 != null) {
      ((o)localObject1).dispatchAttachedToWindow(this);
    }
    mPostedAnimatorRunner = false;
    if (itemView)
    {
      localObject1 = Slider.id;
      Object localObject2 = (Slider)((ThreadLocal)localObject1).get();
      mView = ((Slider)localObject2);
      if (localObject2 == null)
      {
        mView = new Slider();
        localObject2 = ViewCompat.getInstance(this);
        float f2 = 60.0F;
        float f1 = f2;
        if (!isInEditMode())
        {
          f1 = f2;
          if (localObject2 != null)
          {
            float f3 = ((Display)localObject2).getRefreshRate();
            f1 = f2;
            if (f3 >= 30.0F) {
              f1 = f3;
            }
          }
        }
        localObject2 = mView;
        value = ((1.0E9F / f1));
        ((ThreadLocal)localObject1).set(localObject2);
      }
      mView.start(this);
    }
  }
  
  public void onChildAttachedToWindow(View paramView) {}
  
  public void onChildDetachedFromWindow(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = mItemAnimator;
    if (localObject != null) {
      ((l)localObject).endAnimations();
    }
    stopScroll();
    mIsAttached = false;
    localObject = mLayout;
    if (localObject != null) {
      ((o)localObject).onDetachedFromWindow(this, mRecycler);
    }
    mAttachedScrap.clear();
    removeCallbacks(mItemAnimatorRunner);
    mViewInfoStore.onDetach();
    if (itemView)
    {
      localObject = mView;
      if (localObject != null)
      {
        ((Slider)localObject).draw(this);
        mView = null;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k = mItemDecorations.size();
    int j = 0;
    while (j < k)
    {
      ((n)mItemDecorations.get(j)).onDraw(paramCanvas, this, mState);
      j += 1;
    }
  }
  
  void onEnterLayoutOrScroll()
  {
    mLayoutOrScrollCounter += 1;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (mLayout == null) {
      return false;
    }
    if (mLayoutFrozen) {
      return false;
    }
    if (paramMotionEvent.getAction() == 8)
    {
      float f1;
      float f2;
      if ((paramMotionEvent.getSource() & 0x2) != 0)
      {
        if (mLayout.canScrollVertically()) {
          f1 = -paramMotionEvent.getAxisValue(9);
        } else {
          f1 = 0.0F;
        }
        f2 = f1;
        if (mLayout.canScrollHorizontally())
        {
          f2 = paramMotionEvent.getAxisValue(10);
          break label145;
        }
      }
      for (;;)
      {
        float f3 = 0.0F;
        f1 = f2;
        f2 = f3;
        break label145;
        if ((paramMotionEvent.getSource() & 0x400000) == 0) {
          break label141;
        }
        f2 = paramMotionEvent.getAxisValue(26);
        if (!mLayout.canScrollVertically()) {
          break;
        }
        f2 = -f2;
      }
      if (mLayout.canScrollHorizontally())
      {
        f1 = 0.0F;
      }
      else
      {
        label141:
        f1 = 0.0F;
        f2 = 0.0F;
      }
      label145:
      if ((f1 != 0.0F) || (f2 != 0.0F)) {
        onTouchEvent((int)(f2 * mScrollFactor), (int)(f1 * mScreenDensity), paramMotionEvent, 1);
      }
    }
    return false;
  }
  
  final void onInterceptTouchEvent(y paramY)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = mViewFlinger.mScroller;
      mCoordOffset = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      mDragPoint = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    mCoordOffset = 0;
    mDragPoint = 0;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceCompat.beginSection("RV OnLayout");
    dispatchLayout();
    TraceCompat.beginSection();
    mFirstLayoutComplete = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = mLayout;
    if (localObject == null)
    {
      defaultOnMeasure(paramInt1, paramInt2);
      return;
    }
    boolean bool1 = ((o)localObject).setOrientation();
    boolean bool2 = false;
    if (bool1)
    {
      int j = View.MeasureSpec.getMode(paramInt1);
      int k = View.MeasureSpec.getMode(paramInt2);
      mLayout.onMeasure(mRecycler, mState, paramInt1, paramInt2);
      bool1 = bool2;
      if (j == 1073741824)
      {
        bool1 = bool2;
        if (k == 1073741824) {
          bool1 = true;
        }
      }
      mIsMeasuring = bool1;
      if (!bool1)
      {
        if (mAdapter == null) {
          return;
        }
        if (mState.mLayoutStep == 1) {
          dispatchLayoutStep1();
        }
        mLayout.setMeasureSpecs(paramInt1, paramInt2);
        mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        mLayout.draw(paramInt1, paramInt2);
        if (mLayout.shouldMeasureTwice())
        {
          mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
          mState.mIsMeasuring = true;
          dispatchLayoutStep2();
          mLayout.draw(paramInt1, paramInt2);
        }
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
      }
      return;
    }
    if (mHasFixedSize)
    {
      mLayout.onMeasure(mRecycler, mState, paramInt1, paramInt2);
      return;
    }
    if (mAdapterUpdateDuringMeasure)
    {
      eatRequestLayout();
      onEnterLayoutOrScroll();
      processAdapterUpdatesAndSetAnimationFlags();
      resumeRequestLayout();
      localObject = mState;
      if (mRunPredictiveAnimations)
      {
        mInPreLayout = true;
      }
      else
      {
        mAdapterHelper.consumeUpdatesInOnePass();
        mState.mInPreLayout = false;
      }
      mAdapterUpdateDuringMeasure = false;
      resumeRequestLayout(false);
    }
    else if (mState.mRunPredictiveAnimations)
    {
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
    localObject = mAdapter;
    if (localObject != null) {
      mState.mItemCount = ((Adapter)localObject).getItemCount();
    } else {
      mState.mItemCount = 0;
    }
    eatRequestLayout();
    mLayout.onMeasure(mRecycler, mState, paramInt1, paramInt2);
    resumeRequestLayout(false);
    mState.mInPreLayout = false;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (isComputingLayout()) {
      return false;
    }
    return super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    mPendingSavedState = paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Object localObject = mPendingSavedState;
    if (localObject != null)
    {
      localSavedState.copyFrom((SavedState)localObject);
      return localSavedState;
    }
    localObject = mLayout;
    if (localObject != null)
    {
      mLayoutState = ((o)localObject).onSaveInstanceState();
      return localSavedState;
    }
    mLayoutState = null;
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  public void onScrolled(int paramInt1, int paramInt2) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      invalidateGlows();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  void postAnimationRunner()
  {
    if ((!mPostedAnimatorRunner) && (mIsAttached))
    {
      ViewCompat.postOnAnimation(this, mItemAnimatorRunner);
      mPostedAnimatorRunner = true;
    }
  }
  
  void recordAnimationInfoIfBouncedHiddenView(b0 paramB0, RecyclerView.l.c paramC)
  {
    paramB0.setFlags(0, 8192);
    if ((mState.mTrackOldChangeHolders) && (paramB0.isUpdated()) && (!paramB0.isRemoved()) && (!paramB0.shouldIgnore()))
    {
      long l = getChangedHolderKey(paramB0);
      mViewInfoStore.addToOldChangeHolders(l, paramB0);
    }
    mViewInfoStore.addToPreLayout(paramB0, paramC);
  }
  
  void removeAndRecycleScrapInt()
  {
    int j = mAttachedScrap.size() - 1;
    while (j >= 0)
    {
      b0 localB0 = (b0)mAttachedScrap.get(j);
      if ((itemView.getParent() == this) && (!localB0.shouldIgnore()))
      {
        int k = mPendingAccessibilityState;
        if (k != -1)
        {
          ViewCompat.get(itemView, k);
          mPendingAccessibilityState = -1;
        }
      }
      j -= 1;
    }
    mAttachedScrap.clear();
  }
  
  boolean removeAnimatingView(View paramView)
  {
    eatRequestLayout();
    boolean bool = mChildHelper.removeViewIfHidden(paramView);
    if (bool)
    {
      paramView = getChildViewHolderInt(paramView);
      mRecycler.unscrapView(paramView);
      mRecycler.recycleViewHolderInternal(paramView);
    }
    resumeRequestLayout(bool ^ true);
    return bool;
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    b0 localB0 = getChildViewHolderInt(paramView);
    if (localB0 != null) {
      if (localB0.isTmpDetached())
      {
        localB0.clearTmpDetachFlag();
      }
      else if (!localB0.shouldIgnore())
      {
        paramView = new StringBuilder();
        paramView.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
        paramView.append(localB0);
        paramView.append(append());
        throw new IllegalArgumentException(paramView.toString());
      }
    }
    paramView.clearAnimation();
    dispatchChildDetached(paramView);
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void removeItemDecoration(n paramN)
  {
    o localO = mLayout;
    if (localO != null) {
      localO.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    }
    mItemDecorations.remove(paramN);
    if (mItemDecorations.isEmpty())
    {
      boolean bool;
      if (getOverScrollMode() == 2) {
        bool = true;
      } else {
        bool = false;
      }
      setWillNotDraw(bool);
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void removeOnChildAttachStateChangeListener(p paramP)
  {
    List localList = mOnChildAttachStateListeners;
    if (localList == null) {
      return;
    }
    localList.remove(paramP);
  }
  
  public void removeOnItemTouchListener(r paramR)
  {
    mOnItemTouchListeners.remove(paramR);
    if (mActiveOnItemTouchListener == paramR) {
      mActiveOnItemTouchListener = null;
    }
  }
  
  void repositionShadowingViews()
  {
    int k = mChildHelper.getChildCount();
    int j = 0;
    while (j < k)
    {
      View localView = mChildHelper.getChildAt(j);
      Object localObject = getChildViewHolder(localView);
      if (localObject != null)
      {
        localObject = mShadowingHolder;
        if (localObject != null)
        {
          localObject = itemView;
          int m = localView.getLeft();
          int i1 = localView.getTop();
          if ((m != ((View)localObject).getLeft()) || (i1 != ((View)localObject).getTop())) {
            ((View)localObject).layout(m, i1, ((View)localObject).getWidth() + m, ((View)localObject).getHeight() + i1);
          }
        }
      }
      j += 1;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((!mLayout.onRequestChildFocus(this, mState, paramView1, paramView2)) && (paramView2 != null)) {
      draw(paramView1, paramView2);
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return mLayout.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int k = mOnItemTouchListeners.size();
    int j = 0;
    while (j < k)
    {
      ((r)mOnItemTouchListeners.get(j)).onRequestDisallowInterceptTouchEvent(paramBoolean);
      j += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((mEatRequestLayout == 0) && (!mLayoutFrozen))
    {
      super.requestLayout();
      return;
    }
    mLayoutRequestEaten = true;
  }
  
  void resumeRequestLayout()
  {
    scrollByInternal(true);
  }
  
  void resumeRequestLayout(boolean paramBoolean)
  {
    if (mEatRequestLayout < 1) {
      mEatRequestLayout = 1;
    }
    if ((!paramBoolean) && (!mLayoutFrozen)) {
      mLayoutRequestEaten = false;
    }
    if (mEatRequestLayout == 1)
    {
      if ((paramBoolean) && (mLayoutRequestEaten) && (!mLayoutFrozen) && (mLayout != null) && (mAdapter != null)) {
        dispatchLayout();
      }
      if (!mLayoutFrozen) {
        mLayoutRequestEaten = false;
      }
    }
    mEatRequestLayout -= 1;
  }
  
  void saveOldPositions()
  {
    int k = mChildHelper.getUnfilteredChildCount();
    int j = 0;
    while (j < k)
    {
      b0 localB0 = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
      if (!localB0.shouldIgnore()) {
        localB0.saveOldPosition();
      }
      j += 1;
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    o localO = mLayout;
    if (localO == null)
    {
      android.util.Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (mLayoutFrozen) {
      return;
    }
    boolean bool1 = localO.canScrollHorizontally();
    boolean bool2 = mLayout.canScrollVertically();
    if ((bool1) || (bool2))
    {
      if (!bool1) {
        paramInt1 = 0;
      }
      if (!bool2) {
        paramInt2 = 0;
      }
      scrollByInternal(paramInt1, paramInt2, null, 0);
    }
  }
  
  void scrollByInternal(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    eatRequestLayout();
    onEnterLayoutOrScroll();
    TraceCompat.beginSection("RV Scroll");
    onInterceptTouchEvent(mState);
    if (paramInt1 != 0) {
      paramInt1 = mLayout.scrollHorizontallyBy(paramInt1, mRecycler, mState);
    } else {
      paramInt1 = 0;
    }
    if (paramInt2 != 0) {
      paramInt2 = mLayout.scrollVerticallyBy(paramInt2, mRecycler, mState);
    } else {
      paramInt2 = 0;
    }
    TraceCompat.beginSection();
    repositionShadowingViews();
    resumeRequestLayout();
    resumeRequestLayout(false);
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = paramInt1;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  void scrollByInternal(boolean paramBoolean)
  {
    int j = mLayoutOrScrollCounter - 1;
    mLayoutOrScrollCounter = j;
    if (j < 1)
    {
      mLayoutOrScrollCounter = 0;
      if (paramBoolean)
      {
        dispatchContentChangedIfNecessary();
        removeAndRecycleScrapInt();
      }
    }
  }
  
  boolean scrollByInternal(int paramInt1, int paramInt2, MotionEvent paramMotionEvent, int paramInt3)
  {
    consumePendingUpdateOperations();
    int j;
    int k;
    int m;
    int i1;
    if (mAdapter != null)
    {
      arrayOfInt1 = this$0;
      arrayOfInt1[0] = 0;
      arrayOfInt1[1] = 0;
      scrollByInternal(paramInt1, paramInt2, arrayOfInt1);
      arrayOfInt1 = this$0;
      j = arrayOfInt1[0];
      k = arrayOfInt1[1];
      m = paramInt1 - j;
      i1 = paramInt2 - k;
    }
    else
    {
      k = 0;
      j = 0;
      m = 0;
      i1 = 0;
    }
    if (!mItemDecorations.isEmpty()) {
      invalidate();
    }
    int[] arrayOfInt1 = this$0;
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    setNestedScrollingEnabled(j, k, m, i1, mScrollOffset, paramInt3, arrayOfInt1);
    arrayOfInt1 = this$0;
    int i2 = arrayOfInt1[0];
    int i3 = arrayOfInt1[1];
    if ((arrayOfInt1[0] == 0) && (arrayOfInt1[1] == 0)) {
      paramInt3 = 0;
    } else {
      paramInt3 = 1;
    }
    int i4 = mLastTouchY;
    arrayOfInt1 = mScrollOffset;
    mLastTouchY = (i4 - arrayOfInt1[0]);
    mLastTouchX -= arrayOfInt1[1];
    int[] arrayOfInt2 = mNestedOffsets;
    arrayOfInt2[0] += arrayOfInt1[0];
    arrayOfInt2[1] += arrayOfInt1[1];
    if (getOverScrollMode() != 2)
    {
      if ((paramMotionEvent != null) && (!RecyclerView.LayoutManager.process(paramMotionEvent, 8194))) {
        pullGlows(paramMotionEvent.getX(), m - i2, paramMotionEvent.getY(), i1 - i3);
      }
      considerReleasingGlowsOnScroll(paramInt1, paramInt2);
    }
    if ((j != 0) || (k != 0)) {
      dispatchOnScrolled(j, k);
    }
    if (!awakenScrollBars()) {
      invalidate();
    }
    if ((paramInt3 == 0) && (j == 0)) {
      return k != 0;
    }
    return true;
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    android.util.Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void scrollToPosition(int paramInt)
  {
    if (mLayoutFrozen) {
      return;
    }
    stopScroll();
    o localO = mLayout;
    if (localO == null)
    {
      android.util.Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    localO.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    if (shouldDeferAccessibilityEvent(paramAccessibilityEvent)) {
      return;
    }
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegateCompat(m paramM)
  {
    mAccessibilityDelegate = paramM;
    ViewCompat.a(this, paramM);
  }
  
  public void setAdapter(Adapter paramAdapter)
  {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, false, true);
    setAdapterInternal(false);
    requestLayout();
  }
  
  public void setAdapter(s paramS)
  {
    if (mScrollListeners == null) {
      mScrollListeners = new ArrayList();
    }
    mScrollListeners.add(paramS);
  }
  
  void setAdapterInternal()
  {
    Object localObject = mItemAnimator;
    if (localObject != null) {
      ((l)localObject).endAnimations();
    }
    localObject = mLayout;
    if (localObject != null)
    {
      ((o)localObject).removeAndRecycleAllViews(mRecycler);
      mLayout.removeAndRecycleScrapInt(mRecycler);
    }
    mRecycler.clear();
  }
  
  void setAdapterInternal(boolean paramBoolean)
  {
    mRunningLayoutOrScroll = (paramBoolean | mRunningLayoutOrScroll);
    mDataSetHasChangedAfterLayout = true;
    markKnownViewsInvalid();
  }
  
  public void setChildDrawingOrderCallback(j paramJ)
  {
    if (paramJ == mChildDrawingOrderCallback) {
      return;
    }
    mChildDrawingOrderCallback = paramJ;
    boolean bool;
    if (paramJ != null) {
      bool = true;
    } else {
      bool = false;
    }
    setChildrenDrawingOrderEnabled(bool);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != mClipToPadding) {
      invalidateGlows();
    }
    mClipToPadding = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (mFirstLayoutComplete) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(k paramK)
  {
    v7.v7.util.Log.valueOf(paramK);
    n = paramK;
    invalidateGlows();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    mHasFixedSize = paramBoolean;
  }
  
  public void setItemAnimator(l paramL)
  {
    l localL = mItemAnimator;
    if (localL != null)
    {
      localL.endAnimations();
      mItemAnimator.setListener(null);
    }
    mItemAnimator = paramL;
    if (paramL != null) {
      paramL.setListener(mItemAnimatorListener);
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    mRecycler.setViewCacheSize(paramInt);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    suppressLayout(paramBoolean);
  }
  
  public void setLayoutManager(o paramO)
  {
    if (paramO == mLayout) {
      return;
    }
    stopScroll();
    Object localObject;
    if (mLayout != null)
    {
      localObject = mItemAnimator;
      if (localObject != null) {
        ((l)localObject).endAnimations();
      }
      mLayout.removeAndRecycleAllViews(mRecycler);
      mLayout.removeAndRecycleScrapInt(mRecycler);
      mRecycler.clear();
      if (mIsAttached) {
        mLayout.onDetachedFromWindow(this, mRecycler);
      }
      mLayout.setRecyclerView(null);
      mLayout = null;
    }
    else
    {
      mRecycler.clear();
    }
    mChildHelper.removeAllViewsUnfiltered();
    mLayout = paramO;
    if (paramO != null) {
      if (mRecyclerView == null)
      {
        paramO.setRecyclerView(this);
        if (mIsAttached) {
          mLayout.dispatchAttachedToWindow(this);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LayoutManager ");
        ((StringBuilder)localObject).append(paramO);
        ((StringBuilder)localObject).append(" is already attached to a RecyclerView:");
        ((StringBuilder)localObject).append(mRecyclerView.append());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    mRecycler.next();
    requestLayout();
  }
  
  public void setLayoutTransition(LayoutTransition paramLayoutTransition)
  {
    if (Build.VERSION.SDK_INT < 18)
    {
      if (paramLayoutTransition == null)
      {
        suppressLayout(false);
        return;
      }
      if ((paramLayoutTransition.getAnimator(0) == null) && (paramLayoutTransition.getAnimator(1) == null) && (paramLayoutTransition.getAnimator(2) == null) && (paramLayoutTransition.getAnimator(3) == null) && (paramLayoutTransition.getAnimator(4) == null))
      {
        suppressLayout(true);
        return;
      }
    }
    if (paramLayoutTransition == null)
    {
      super.setLayoutTransition(null);
      return;
    }
    throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
  }
  
  public void setNestedScrollingEnabled(int paramInt)
  {
    getScrollingChildHelper().stopNestedScroll(paramInt);
  }
  
  public final void setNestedScrollingEnabled(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, int[] paramArrayOfInt2)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(q paramQ)
  {
    DEBUG = paramQ;
  }
  
  public void setOnScrollListener(s paramS)
  {
    mScrollListener = paramS;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    mHasStableIds = paramBoolean;
  }
  
  public void setRecycledViewPool(t paramT)
  {
    mRecycler.setRecycledViewPool(paramT);
  }
  
  public void setRecyclerListener(v paramV)
  {
    i = paramV;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == mScrollState) {
      return;
    }
    mScrollState = paramInt;
    if (paramInt != 2) {
      stopScrollersInternal();
    }
    dispatchOnScrollStateChanged(paramInt);
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("; using default value");
        android.util.Log.w("RecyclerView", localStringBuilder.toString());
      }
      else
      {
        mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
        return;
      }
    }
    mTouchSlop = localViewConfiguration.getScaledTouchSlop();
  }
  
  public void setViewCacheExtension(z paramZ)
  {
    mRecycler.setViewCacheExtension(paramZ);
  }
  
  boolean shouldDeferAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool = isComputingLayout();
    int k = 0;
    if (bool)
    {
      int j;
      if (paramAccessibilityEvent != null) {
        j = AccessibilityEventCompat.getContentChangeTypes(paramAccessibilityEvent);
      } else {
        j = 0;
      }
      if (j == 0) {
        j = k;
      }
      mEatenAccessibilityChangeFlags |= j;
      return true;
    }
    return false;
  }
  
  void smoothScrollBy(int paramInt)
  {
    if (mLayout == null) {
      return;
    }
    setScrollState(2);
    mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, null);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInterpolator, Integer.MIN_VALUE);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, Interpolator paramInterpolator, int paramInt3)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInterpolator, paramInt3, false);
  }
  
  void smoothScrollBy(int paramInt1, int paramInt2, Interpolator paramInterpolator, int paramInt3, boolean paramBoolean)
  {
    o localO = mLayout;
    if (localO == null)
    {
      android.util.Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (mLayoutFrozen) {
      return;
    }
    boolean bool = localO.canScrollHorizontally();
    int k = 0;
    int j = paramInt1;
    if (!bool) {
      j = 0;
    }
    if (!mLayout.canScrollVertically()) {
      paramInt2 = 0;
    }
    if ((j != 0) || (paramInt2 != 0))
    {
      if ((paramInt3 != Integer.MIN_VALUE) && (paramInt3 <= 0)) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        if (paramBoolean)
        {
          paramInt1 = k;
          if (j != 0) {
            paramInt1 = 1;
          }
          k = paramInt1;
          if (paramInt2 != 0) {
            k = paramInt1 | 0x2;
          }
          startNestedScroll(k, 1);
        }
        mViewFlinger.smoothScrollBy(j, paramInt2, paramInt3, paramInterpolator);
        return;
      }
      scrollBy(j, paramInt2);
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (mLayoutFrozen) {
      return;
    }
    o localO = mLayout;
    if (localO == null)
    {
      android.util.Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    localO.smoothScrollToPosition(this, mState, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt1, paramInt2);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().stopNestedScroll();
  }
  
  public void stopScroll()
  {
    setScrollState(0);
    stopScrollersInternal();
  }
  
  public final void suppressLayout(boolean paramBoolean)
  {
    if (paramBoolean != mLayoutFrozen)
    {
      a("Do not suppressLayout in layout or scroll");
      if (!paramBoolean)
      {
        mLayoutFrozen = false;
        if ((mLayoutRequestEaten) && (mLayout != null) && (mAdapter != null)) {
          requestLayout();
        }
        mLayoutRequestEaten = false;
        return;
      }
      long l = SystemClock.uptimeMillis();
      onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
      mLayoutFrozen = true;
      mIgnoreMotionEventTillDown = true;
      stopScroll();
    }
  }
  
  boolean update(b0 paramB0, int paramInt)
  {
    if (isComputingLayout())
    {
      mPendingAccessibilityState = paramInt;
      mAttachedScrap.add(paramB0);
      return false;
    }
    ViewCompat.get(itemView, paramInt);
    return true;
  }
  
  void viewRangeUpdate(int paramInt1, int paramInt2, Object paramObject)
  {
    int k = mChildHelper.getUnfilteredChildCount();
    int j = 0;
    while (j < k)
    {
      View localView = mChildHelper.getUnfilteredChildAt(j);
      b0 localB0 = getChildViewHolderInt(localView);
      if ((localB0 != null) && (!localB0.shouldIgnore()))
      {
        int m = mPosition;
        if ((m >= paramInt1) && (m < paramInt1 + paramInt2))
        {
          localB0.addFlags(2);
          localB0.addChangePayload(paramObject);
          getLayoutParamsmInsetsDirty = true;
        }
      }
      j += 1;
    }
    mRecycler.viewRangeUpdate(paramInt1, paramInt2);
  }
  
  public static abstract class Adapter<VH extends RecyclerView.b0>
  {
    private boolean mHasStableIds = false;
    private final RecyclerView.h mObservable = new RecyclerView.h();
    private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.vcard;
    
    public Adapter() {}
    
    public final void bindViewHolder(RecyclerView.b0 paramB0, int paramInt)
    {
      int i;
      if (mBindingAdapter == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        mPosition = paramInt;
        if (hasStableIds()) {
          mItemId = getItemId(paramInt);
        }
        paramB0.setFlags(1, 519);
        TraceCompat.beginSection("RV OnBindView");
      }
      mBindingAdapter = this;
      onBindViewHolder(paramB0, paramInt, paramB0.getUnmodifiedPayloads());
      if (i != 0)
      {
        paramB0.clearPayload();
        paramB0 = itemView.getLayoutParams();
        if ((paramB0 instanceof RecyclerView.LayoutParams)) {
          mInsetsDirty = true;
        }
        TraceCompat.beginSection();
      }
    }
    
    boolean canRestoreState()
    {
      int i = RecyclerView.g.times[mStateRestorationPolicy.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        if (getItemCount() > 0) {
          return true;
        }
      }
      return false;
    }
    
    public final RecyclerView.b0 createViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      try
      {
        TraceCompat.beginSection("RV CreateView");
        paramViewGroup = onCreateViewHolder(paramViewGroup, paramInt);
        ViewParent localViewParent = itemView.getParent();
        if (localViewParent == null)
        {
          mItemViewType = paramInt;
          TraceCompat.beginSection();
          return paramViewGroup;
        }
        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
      }
      catch (Throwable paramViewGroup)
      {
        TraceCompat.beginSection();
        throw paramViewGroup;
      }
    }
    
    public int findRelativeAdapterPositionIn(Adapter paramAdapter, RecyclerView.b0 paramB0, int paramInt)
    {
      if (paramAdapter == this) {
        return paramInt;
      }
      return -1;
    }
    
    public abstract int getItemCount();
    
    public long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public final boolean hasObservers()
    {
      return mObservable.hasObservers();
    }
    
    public final boolean hasStableIds()
    {
      return mHasStableIds;
    }
    
    public final void notifyDataSetChanged()
    {
      mObservable.notifyChanged();
    }
    
    public final void notifyItemChanged(int paramInt)
    {
      mObservable.notifyItemRangeChanged(paramInt, 1);
    }
    
    public final void notifyItemMoved(int paramInt1, int paramInt2)
    {
      mObservable.notifyItemMoved(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      mObservable.notifyItemRangeChanged(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      mObservable.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
    }
    
    public final void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      mObservable.notifyItemRangeInserted(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      mObservable.notifyItemRangeRemoved(paramInt1, paramInt2);
    }
    
    public final void notifyItemRemoved(int paramInt)
    {
      mObservable.notifyItemRangeRemoved(paramInt, 1);
    }
    
    public void onAttachedToRecyclerView(RecyclerView paramRecyclerView) {}
    
    public abstract void onBindViewHolder(RecyclerView.b0 paramB0, int paramInt);
    
    public void onBindViewHolder(RecyclerView.b0 paramB0, int paramInt, List paramList)
    {
      onBindViewHolder(paramB0, paramInt);
    }
    
    public abstract RecyclerView.b0 onCreateViewHolder(ViewGroup paramViewGroup, int paramInt);
    
    public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView) {}
    
    public boolean onFailedToRecycleView(RecyclerView.b0 paramB0)
    {
      return false;
    }
    
    public void onViewAttachedToWindow(RecyclerView.b0 paramB0) {}
    
    public void onViewDetachedFromWindow(RecyclerView.b0 paramB0) {}
    
    public void onViewRecycled(RecyclerView.b0 paramB0) {}
    
    public void registerAdapterDataObserver(RecyclerView.i paramI)
    {
      mObservable.registerObserver(paramI);
    }
    
    public void setHasStableIds(boolean paramBoolean)
    {
      if (!hasObservers())
      {
        mHasStableIds = paramBoolean;
        return;
      }
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    
    public void unregisterAdapterDataObserver(RecyclerView.i paramI)
    {
      mObservable.unregisterObserver(paramI);
    }
    
    public static enum StateRestorationPolicy
    {
      static
      {
        StateRestorationPolicy localStateRestorationPolicy1 = new StateRestorationPolicy("ALLOW", 0);
        vcard = localStateRestorationPolicy1;
        StateRestorationPolicy localStateRestorationPolicy2 = new StateRestorationPolicy("PREVENT_WHEN_EMPTY", 1);
        c = localStateRestorationPolicy2;
        StateRestorationPolicy localStateRestorationPolicy3 = new StateRestorationPolicy("PREVENT", 2);
        d = localStateRestorationPolicy3;
        a = new StateRestorationPolicy[] { localStateRestorationPolicy1, localStateRestorationPolicy2, localStateRestorationPolicy3 };
      }
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    final Rect mDecorInsets = new Rect();
    boolean mInsetsDirty = true;
    boolean mPendingInvalidate = false;
    RecyclerView.b0 mViewHolder;
    
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
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public int getViewLayoutPosition()
    {
      return mViewHolder.getLayoutPosition();
    }
    
    public boolean isItemChanged()
    {
      return mViewHolder.isUpdated();
    }
    
    public boolean isItemRemoved()
    {
      return mViewHolder.isRemoved();
    }
    
    public boolean isViewInvalid()
    {
      return mViewHolder.isInvalid();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    Parcelable mLayoutState;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader == null) {
        paramClassLoader = RecyclerView.o.class.getClassLoader();
      }
      mLayoutState = paramParcel.readParcelable(paramClassLoader);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    void copyFrom(SavedState paramSavedState)
    {
      mLayoutState = mLayoutState;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(mLayoutState, 0);
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<RecyclerView.SavedState>
    {
      a() {}
      
      public RecyclerView.SavedState[] a(int paramInt)
      {
        return new RecyclerView.SavedState[paramInt];
      }
      
      public RecyclerView.SavedState getInstance(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new RecyclerView.SavedState(paramParcel, paramClassLoader);
      }
      
      public RecyclerView.SavedState readDate(Parcel paramParcel)
      {
        return new RecyclerView.SavedState(paramParcel, null);
      }
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      RecyclerView localRecyclerView = RecyclerView.this;
      if (mFirstLayoutComplete)
      {
        if (localRecyclerView.isLayoutRequested()) {
          return;
        }
        localRecyclerView = RecyclerView.this;
        if (!mIsAttached)
        {
          localRecyclerView.requestLayout();
          return;
        }
        if (mLayoutFrozen)
        {
          mLayoutRequestEaten = true;
          return;
        }
        localRecyclerView.consumePendingUpdateOperations();
      }
    }
  }
  
  class a0
    implements Runnable
  {
    private boolean h;
    private boolean i;
    Interpolator mInterpolator;
    private int mLastFlingX;
    private int mLastFlingY;
    OverScroller mScroller;
    
    a0()
    {
      Interpolator localInterpolator = RecyclerView.mInterpolator;
      mInterpolator = localInterpolator;
      h = false;
      i = false;
      mScroller = new OverScroller(getContext(), localInterpolator);
    }
    
    private int computeScrollDuration(int paramInt1, int paramInt2)
    {
      int j = Math.abs(paramInt1);
      paramInt1 = j;
      int k = Math.abs(paramInt2);
      if (j > k) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      RecyclerView localRecyclerView = RecyclerView.this;
      if (paramInt2 != 0) {
        j = localRecyclerView.getWidth();
      } else {
        j = localRecyclerView.getHeight();
      }
      if (paramInt2 == 0) {
        paramInt1 = k;
      }
      return Math.min((int)((paramInt1 / j + 1.0F) * 300.0F), 2000);
    }
    
    private void postOnAnimation()
    {
      removeCallbacks(this);
      ViewCompat.postOnAnimation(RecyclerView.this, this);
    }
    
    void d()
    {
      if (h)
      {
        i = true;
        return;
      }
      postOnAnimation();
    }
    
    public void fling(int paramInt1, int paramInt2)
    {
      setScrollState(2);
      mLastFlingY = 0;
      mLastFlingX = 0;
      Interpolator localInterpolator1 = mInterpolator;
      Interpolator localInterpolator2 = RecyclerView.mInterpolator;
      if (localInterpolator1 != localInterpolator2)
      {
        mInterpolator = localInterpolator2;
        mScroller = new OverScroller(getContext(), localInterpolator2);
      }
      mScroller.fling(0, 0, paramInt1, paramInt2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
      d();
    }
    
    public void run()
    {
      Object localObject1 = RecyclerView.this;
      if (mLayout == null)
      {
        stop();
        return;
      }
      i = false;
      h = true;
      ((RecyclerView)localObject1).consumePendingUpdateOperations();
      localObject1 = mScroller;
      if (((OverScroller)localObject1).computeScrollOffset())
      {
        int j = ((OverScroller)localObject1).getCurrX();
        int k = ((OverScroller)localObject1).getCurrY();
        int n = j - mLastFlingX;
        int m = k - mLastFlingY;
        mLastFlingX = j;
        mLastFlingY = k;
        Object localObject2 = RecyclerView.this;
        int[] arrayOfInt = this$0;
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        j = m;
        k = n;
        if (((RecyclerView)localObject2).dispatchNestedPreScroll(n, m, arrayOfInt, null, 1))
        {
          localObject2 = this$0;
          k = n - localObject2[0];
          j = m - localObject2[1];
        }
        if (getOverScrollMode() != 2) {
          considerReleasingGlowsOnScroll(k, j);
        }
        localObject2 = RecyclerView.this;
        if (mAdapter != null)
        {
          arrayOfInt = this$0;
          arrayOfInt[0] = 0;
          arrayOfInt[1] = 0;
          ((RecyclerView)localObject2).scrollByInternal(k, j, arrayOfInt);
          localObject2 = RecyclerView.this;
          arrayOfInt = this$0;
          i1 = arrayOfInt[0];
          i2 = arrayOfInt[1];
          int i3 = k - i1;
          int i4 = j - i2;
          localObject2 = mLayout.a;
          k = i1;
          j = i2;
          m = i4;
          n = i3;
          if (localObject2 != null)
          {
            k = i1;
            j = i2;
            m = i4;
            n = i3;
            if (!((RecyclerView.x)localObject2).d())
            {
              k = i1;
              j = i2;
              m = i4;
              n = i3;
              if (((RecyclerView.x)localObject2).s())
              {
                j = mState.getItemCount();
                if (j == 0)
                {
                  ((RecyclerView.x)localObject2).e();
                  k = i1;
                  j = i2;
                  m = i4;
                  n = i3;
                }
                else if (((RecyclerView.x)localObject2).intValue() >= j)
                {
                  ((RecyclerView.x)localObject2).d(j - 1);
                  ((RecyclerView.x)localObject2).a(i1, i2);
                  k = i1;
                  j = i2;
                  m = i4;
                  n = i3;
                }
                else
                {
                  ((RecyclerView.x)localObject2).a(i1, i2);
                  k = i1;
                  j = i2;
                  m = i4;
                  n = i3;
                }
              }
            }
          }
        }
        else
        {
          i2 = 0;
          i1 = 0;
          n = k;
          m = j;
          j = i2;
          k = i1;
        }
        if (!mItemDecorations.isEmpty()) {
          invalidate();
        }
        localObject2 = RecyclerView.this;
        arrayOfInt = this$0;
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        ((RecyclerView)localObject2).setNestedScrollingEnabled(k, j, n, m, null, 1, arrayOfInt);
        localObject2 = RecyclerView.this;
        arrayOfInt = this$0;
        int i2 = n - arrayOfInt[0];
        int i1 = m - arrayOfInt[1];
        if ((k != 0) || (j != 0)) {
          ((RecyclerView)localObject2).dispatchOnScrolled(k, j);
        }
        if (!RecyclerView.access$getAwakenScrollBars(RecyclerView.this)) {
          invalidate();
        }
        if (((OverScroller)localObject1).getCurrX() == ((OverScroller)localObject1).getFinalX()) {
          m = 1;
        } else {
          m = 0;
        }
        if (((OverScroller)localObject1).getCurrY() == ((OverScroller)localObject1).getFinalY()) {
          n = 1;
        } else {
          n = 0;
        }
        if ((!((OverScroller)localObject1).isFinished()) && (((m == 0) && (i2 == 0)) || ((n == 0) && (i1 == 0)))) {
          m = 0;
        } else {
          m = 1;
        }
        localObject2 = mLayout.a;
        if ((localObject2 != null) && (((RecyclerView.x)localObject2).d())) {
          n = 1;
        } else {
          n = 0;
        }
        if ((n == 0) && (m != 0))
        {
          if (getOverScrollMode() != 2)
          {
            k = (int)((OverScroller)localObject1).getCurrVelocity();
            if (i2 < 0) {
              j = -k;
            } else if (i2 > 0) {
              j = k;
            } else {
              j = 0;
            }
            if (i1 < 0) {
              k = -k;
            } else if (i1 <= 0) {
              k = 0;
            }
            absorbGlows(j, k);
          }
          if (RecyclerView.itemView) {
            h.set();
          }
        }
        else
        {
          d();
          localObject1 = RecyclerView.this;
          localObject2 = mView;
          if (localObject2 != null) {
            ((Slider)localObject2).start((RecyclerView)localObject1, k, j);
          }
        }
      }
      localObject1 = mLayout.a;
      if ((localObject1 != null) && (((RecyclerView.x)localObject1).d())) {
        ((RecyclerView.x)localObject1).a(0, 0);
      }
      h = false;
      if (i)
      {
        postOnAnimation();
        return;
      }
      setScrollState(0);
      setNestedScrollingEnabled(1);
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      int j = paramInt3;
      if (paramInt3 == Integer.MIN_VALUE) {
        j = computeScrollDuration(paramInt1, paramInt2);
      }
      Interpolator localInterpolator = paramInterpolator;
      if (paramInterpolator == null) {
        localInterpolator = RecyclerView.mInterpolator;
      }
      if (mInterpolator != localInterpolator)
      {
        mInterpolator = localInterpolator;
        mScroller = new OverScroller(getContext(), localInterpolator);
      }
      mLastFlingY = 0;
      mLastFlingX = 0;
      setScrollState(2);
      mScroller.startScroll(0, 0, paramInt1, paramInt2, j);
      if (Build.VERSION.SDK_INT < 23) {
        mScroller.computeScrollOffset();
      }
      d();
    }
    
    public void stop()
    {
      removeCallbacks(this);
      mScroller.abortAnimation();
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      RecyclerView.l localL = mItemAnimator;
      if (localL != null) {
        localL.runPendingAnimations();
      }
      mPostedAnimatorRunner = false;
    }
  }
  
  public static abstract class b0
  {
    private static final List<Object> FULLUPDATE_PAYLOADS = ;
    public final View itemView;
    RecyclerView.Adapter<? extends b0> mBindingAdapter;
    int mFlags;
    boolean mInChangeScrap = false;
    private int mIsRecyclableCount = 0;
    long mItemId = -1L;
    int mItemViewType = -1;
    WeakReference<RecyclerView> mNestedRecyclerView;
    int mOldPosition = -1;
    RecyclerView mOwnerRecyclerView;
    List<Object> mPayloads = null;
    int mPendingAccessibilityState = -1;
    int mPosition = -1;
    int mPreLayoutPosition = -1;
    RecyclerView.u mScrapContainer = null;
    b0 mShadowedHolder = null;
    b0 mShadowingHolder = null;
    List<Object> mUnmodifiedPayloads = null;
    private int mWasImportantForAccessibilityBeforeHidden = 0;
    
    public b0(View paramView)
    {
      if (paramView != null)
      {
        itemView = paramView;
        return;
      }
      throw new IllegalArgumentException("itemView may not be null");
    }
    
    private void createPayloadsIfNeeded()
    {
      if (mPayloads == null)
      {
        ArrayList localArrayList = new ArrayList();
        mPayloads = localArrayList;
        mUnmodifiedPayloads = Collections.unmodifiableList(localArrayList);
      }
    }
    
    void addChangePayload(Object paramObject)
    {
      if (paramObject == null)
      {
        addFlags(1024);
        return;
      }
      if ((0x400 & mFlags) == 0)
      {
        createPayloadsIfNeeded();
        mPayloads.add(paramObject);
      }
    }
    
    void addFlags(int paramInt)
    {
      mFlags = (paramInt | mFlags);
    }
    
    void clearOldPosition()
    {
      mOldPosition = -1;
      mPreLayoutPosition = -1;
    }
    
    void clearPayload()
    {
      List localList = mPayloads;
      if (localList != null) {
        localList.clear();
      }
      mFlags &= 0xFBFF;
    }
    
    void clearReturnedFromScrapFlag()
    {
      mFlags &= 0xFFFFFFDF;
    }
    
    void clearTmpDetachFlag()
    {
      mFlags &= 0xFEFF;
    }
    
    boolean doesTransientStatePreventRecycling()
    {
      return ((mFlags & 0x10) == 0) && (ViewCompat.hasTransientState(itemView));
    }
    
    void flagRemovedAndOffsetPosition(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      addFlags(8);
      offsetPosition(paramInt2, paramBoolean);
      mPosition = paramInt1;
    }
    
    public final int getAbsoluteAdapterPosition()
    {
      RecyclerView localRecyclerView = mOwnerRecyclerView;
      if (localRecyclerView == null) {
        return -1;
      }
      return localRecyclerView.getAdapterPositionFor(this);
    }
    
    public final int getBindingAdapterPosition()
    {
      if (mBindingAdapter == null) {
        return -1;
      }
      Object localObject = mOwnerRecyclerView;
      if (localObject == null) {
        return -1;
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null) {
        return -1;
      }
      int i = mOwnerRecyclerView.getAdapterPositionFor(this);
      if (i == -1) {
        return -1;
      }
      return ((RecyclerView.Adapter)localObject).findRelativeAdapterPositionIn(mBindingAdapter, this, i);
    }
    
    public final long getItemId()
    {
      return mItemId;
    }
    
    public final int getItemViewType()
    {
      return mItemViewType;
    }
    
    public final int getLayoutPosition()
    {
      int j = mPreLayoutPosition;
      int i = j;
      if (j == -1) {
        i = mPosition;
      }
      return i;
    }
    
    public final int getOldPosition()
    {
      return mOldPosition;
    }
    
    List getUnmodifiedPayloads()
    {
      if ((mFlags & 0x400) == 0)
      {
        List localList = mPayloads;
        if ((localList != null) && (localList.size() != 0)) {
          return mUnmodifiedPayloads;
        }
        return FULLUPDATE_PAYLOADS;
      }
      return FULLUPDATE_PAYLOADS;
    }
    
    boolean hasAnyOfTheFlags(int paramInt)
    {
      return (paramInt & mFlags) != 0;
    }
    
    boolean isAdapterPositionUnknown()
    {
      return ((mFlags & 0x200) != 0) || (isInvalid());
    }
    
    boolean isAttachedToTransitionOverlay()
    {
      return (itemView.getParent() != null) && (itemView.getParent() != mOwnerRecyclerView);
    }
    
    boolean isBound()
    {
      return (mFlags & 0x1) != 0;
    }
    
    boolean isInvalid()
    {
      return (mFlags & 0x4) != 0;
    }
    
    public final boolean isRecyclable()
    {
      return ((mFlags & 0x10) == 0) && (!ViewCompat.hasTransientState(itemView));
    }
    
    boolean isRemoved()
    {
      return (mFlags & 0x8) != 0;
    }
    
    boolean isScrap()
    {
      return mScrapContainer != null;
    }
    
    boolean isTmpDetached()
    {
      return (mFlags & 0x100) != 0;
    }
    
    boolean isUpdated()
    {
      return (mFlags & 0x2) != 0;
    }
    
    boolean needsUpdate()
    {
      return (mFlags & 0x2) != 0;
    }
    
    void offsetPosition(int paramInt, boolean paramBoolean)
    {
      if (mOldPosition == -1) {
        mOldPosition = mPosition;
      }
      if (mPreLayoutPosition == -1) {
        mPreLayoutPosition = mPosition;
      }
      if (paramBoolean) {
        mPreLayoutPosition += paramInt;
      }
      mPosition += paramInt;
      if (itemView.getLayoutParams() != null) {
        itemView.getLayoutParams()).mInsetsDirty = true;
      }
    }
    
    void onEnteredHiddenState(RecyclerView paramRecyclerView)
    {
      int i = mPendingAccessibilityState;
      if (i != -1) {
        mWasImportantForAccessibilityBeforeHidden = i;
      } else {
        mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(itemView);
      }
      paramRecyclerView.update(this, 4);
    }
    
    void onLeftHiddenState(RecyclerView paramRecyclerView)
    {
      paramRecyclerView.update(this, mWasImportantForAccessibilityBeforeHidden);
      mWasImportantForAccessibilityBeforeHidden = 0;
    }
    
    void resetInternal()
    {
      mFlags = 0;
      mPosition = -1;
      mOldPosition = -1;
      mItemId = -1L;
      mPreLayoutPosition = -1;
      mIsRecyclableCount = 0;
      mShadowedHolder = null;
      mShadowingHolder = null;
      clearPayload();
      mWasImportantForAccessibilityBeforeHidden = 0;
      mPendingAccessibilityState = -1;
      RecyclerView.next(this);
    }
    
    void saveOldPosition()
    {
      if (mOldPosition == -1) {
        mOldPosition = mPosition;
      }
    }
    
    void setFlags(int paramInt1, int paramInt2)
    {
      mFlags = (paramInt1 & paramInt2 | mFlags & paramInt2);
    }
    
    public final void setIsRecyclable(boolean paramBoolean)
    {
      int i = mIsRecyclableCount;
      if (paramBoolean) {
        i -= 1;
      } else {
        i += 1;
      }
      mIsRecyclableCount = i;
      if (i < 0)
      {
        mIsRecyclableCount = 0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
        localStringBuilder.append(this);
        android.util.Log.e("View", localStringBuilder.toString());
        return;
      }
      if ((!paramBoolean) && (i == 1))
      {
        mFlags |= 0x10;
        return;
      }
      if ((paramBoolean) && (i == 0)) {
        mFlags &= 0xFFFFFFEF;
      }
    }
    
    void setScrapContainer(RecyclerView.u paramU, boolean paramBoolean)
    {
      mScrapContainer = paramU;
      mInChangeScrap = paramBoolean;
    }
    
    boolean shouldBeKeptAsChild()
    {
      return (mFlags & 0x10) != 0;
    }
    
    boolean shouldIgnore()
    {
      return (mFlags & 0x80) != 0;
    }
    
    public String toString()
    {
      Object localObject;
      if (getClass().isAnonymousClass()) {
        localObject = "ViewHolder";
      } else {
        localObject = getClass().getSimpleName();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("{");
      localStringBuilder.append(Integer.toHexString(hashCode()));
      localStringBuilder.append(" position=");
      localStringBuilder.append(mPosition);
      localStringBuilder.append(" id=");
      localStringBuilder.append(mItemId);
      localStringBuilder.append(", oldPos=");
      localStringBuilder.append(mOldPosition);
      localStringBuilder.append(", pLpos:");
      localStringBuilder.append(mPreLayoutPosition);
      localStringBuilder = new StringBuilder(localStringBuilder.toString());
      if (isScrap())
      {
        localStringBuilder.append(" scrap ");
        if (mInChangeScrap) {
          localObject = "[changeScrap]";
        } else {
          localObject = "[attachedScrap]";
        }
        localStringBuilder.append((String)localObject);
      }
      if (isInvalid()) {
        localStringBuilder.append(" invalid");
      }
      if (!isBound()) {
        localStringBuilder.append(" unbound");
      }
      if (needsUpdate()) {
        localStringBuilder.append(" update");
      }
      if (isRemoved()) {
        localStringBuilder.append(" removed");
      }
      if (shouldIgnore()) {
        localStringBuilder.append(" ignored");
      }
      if (isTmpDetached()) {
        localStringBuilder.append(" tmpDetached");
      }
      if (!isRecyclable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" not recyclable(");
        ((StringBuilder)localObject).append(mIsRecyclableCount);
        ((StringBuilder)localObject).append(")");
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      if (isAdapterPositionUnknown()) {
        localStringBuilder.append(" undefined adapter position");
      }
      if (itemView.getParent() == null) {
        localStringBuilder.append(" no parent");
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    void unScrap()
    {
      mScrapContainer.unscrapView(this);
    }
    
    boolean wasReturnedFromScrap()
    {
      return (mFlags & 0x20) != 0;
    }
  }
  
  class c
    implements Interpolator
  {
    c() {}
    
    public float getInterpolation(float paramFloat)
    {
      paramFloat -= 1.0F;
      return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
    }
  }
  
  class d
    implements ViewInfoStore.ProcessCallback
  {
    d() {}
    
    public void processAppeared(RecyclerView.b0 paramB0, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2)
    {
      animateAppearance(paramB0, paramC1, paramC2);
    }
    
    public void processDisappeared(RecyclerView.b0 paramB0, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2)
    {
      mRecycler.unscrapView(paramB0);
      animateDisappearance(paramB0, paramC1, paramC2);
    }
    
    public void processPersistent(RecyclerView.b0 paramB0, RecyclerView.l.c paramC1, RecyclerView.l.c paramC2)
    {
      paramB0.setIsRecyclable(false);
      RecyclerView localRecyclerView = RecyclerView.this;
      if (mDataSetHasChangedAfterLayout)
      {
        if (mItemAnimator.animateChange(paramB0, paramB0, paramC1, paramC2)) {
          postAnimationRunner();
        }
      }
      else if (mItemAnimator.animatePersistence(paramB0, paramC1, paramC2)) {
        postAnimationRunner();
      }
    }
    
    public void unused(RecyclerView.b0 paramB0)
    {
      RecyclerView localRecyclerView = RecyclerView.this;
      mLayout.removeAndRecycleView(itemView, mRecycler);
    }
  }
  
  class e
    implements ChildHelper.Callback
  {
    e() {}
    
    public void addView(View paramView, int paramInt)
    {
      RecyclerView.this.addView(paramView, paramInt);
      dispatchChildAttached(paramView);
    }
    
    public void attachViewToParent(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      if (paramView != null) {
        paramView.onEnteredHiddenState(RecyclerView.this);
      }
    }
    
    public void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
    {
      RecyclerView.b0 localB0 = RecyclerView.getChildViewHolderInt(paramView);
      if (localB0 != null)
      {
        if ((!localB0.isTmpDetached()) && (!localB0.shouldIgnore()))
        {
          paramView = new StringBuilder();
          paramView.append("Called attach on a child which is not detached: ");
          paramView.append(localB0);
          paramView.append(append());
          throw new IllegalArgumentException(paramView.toString());
        }
        localB0.clearTmpDetachFlag();
      }
      RecyclerView.access$getAttachViewToParent(RecyclerView.this, paramView, paramInt, paramLayoutParams);
    }
    
    public void detachViewFromParent(int paramInt)
    {
      Object localObject = getChildAt(paramInt);
      if (localObject != null)
      {
        localObject = RecyclerView.getChildViewHolderInt((View)localObject);
        if (localObject != null)
        {
          if ((((RecyclerView.b0)localObject).isTmpDetached()) && (!((RecyclerView.b0)localObject).shouldIgnore()))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("called detach on an already detached child ");
            localStringBuilder.append(localObject);
            localStringBuilder.append(append());
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          ((RecyclerView.b0)localObject).addFlags(256);
        }
      }
      RecyclerView.access$getDetachViewFromParent(RecyclerView.this, paramInt);
    }
    
    public View getChildAt(int paramInt)
    {
      return RecyclerView.this.getChildAt(paramInt);
    }
    
    public int getChildCount()
    {
      return RecyclerView.this.getChildCount();
    }
    
    public RecyclerView.b0 getChildViewHolder(View paramView)
    {
      return RecyclerView.getChildViewHolderInt(paramView);
    }
    
    public int indexOfChild(View paramView)
    {
      return RecyclerView.this.indexOfChild(paramView);
    }
    
    public void onLeftHiddenState(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      if (paramView != null) {
        paramView.onLeftHiddenState(RecyclerView.this);
      }
    }
    
    public void removeAllViews()
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        dispatchChildDetached(localView);
        localView.clearAnimation();
        i += 1;
      }
      RecyclerView.this.removeAllViews();
    }
    
    public void removeViewAt(int paramInt)
    {
      View localView = RecyclerView.this.getChildAt(paramInt);
      if (localView != null)
      {
        dispatchChildDetached(localView);
        localView.clearAnimation();
      }
      RecyclerView.this.removeViewAt(paramInt);
    }
  }
  
  class f
    implements AdapterHelper.Callback
  {
    f() {}
    
    void dispatchUpdate(AdapterHelper.UpdateOp paramUpdateOp)
    {
      int i = cmd;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 4)
          {
            if (i != 8) {
              return;
            }
            localRecyclerView = RecyclerView.this;
            mLayout.onItemsMoved(localRecyclerView, positionStart, itemCount, 1);
            return;
          }
          localRecyclerView = RecyclerView.this;
          mLayout.onItemsUpdated(localRecyclerView, positionStart, itemCount, payload);
          return;
        }
        localRecyclerView = RecyclerView.this;
        mLayout.onItemsUpdated(localRecyclerView, positionStart, itemCount);
        return;
      }
      RecyclerView localRecyclerView = RecyclerView.this;
      mLayout.onItemsAdded(localRecyclerView, positionStart, itemCount);
    }
    
    public RecyclerView.b0 findViewHolder(int paramInt)
    {
      RecyclerView.b0 localB0 = findViewHolderForPosition(paramInt, true);
      if (localB0 == null) {
        return null;
      }
      if (mChildHelper.isHidden(itemView)) {
        return null;
      }
      return localB0;
    }
    
    public void markViewHoldersUpdated(int paramInt1, int paramInt2, Object paramObject)
    {
      viewRangeUpdate(paramInt1, paramInt2, paramObject);
      mItemsChanged = true;
    }
    
    public void offsetPositionsForAdd(int paramInt1, int paramInt2)
    {
      offsetPositionRecordsForInsert(paramInt1, paramInt2);
      mItemsAddedOrRemoved = true;
    }
    
    public void offsetPositionsForMove(int paramInt1, int paramInt2)
    {
      offsetPositionRecordsForMove(paramInt1, paramInt2);
      mItemsAddedOrRemoved = true;
    }
    
    public void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2)
    {
      offsetPositionRecordsForRemove(paramInt1, paramInt2, true);
      Object localObject = RecyclerView.this;
      mItemsAddedOrRemoved = true;
      localObject = mState;
      mDeletedInvisibleItemCountSincePreviousLayout += paramInt2;
    }
    
    public void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2)
    {
      offsetPositionRecordsForRemove(paramInt1, paramInt2, false);
      mItemsAddedOrRemoved = true;
    }
    
    public void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp)
    {
      dispatchUpdate(paramUpdateOp);
    }
    
    public void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp)
    {
      dispatchUpdate(paramUpdateOp);
    }
  }
  
  static class h
    extends Observable<RecyclerView.i>
  {
    h() {}
    
    public boolean hasObservers()
    {
      return mObservers.isEmpty() ^ true;
    }
    
    public void notifyChanged()
    {
      int i = mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.i)mObservers.get(i)).onChanged();
        i -= 1;
      }
    }
    
    public void notifyItemMoved(int paramInt1, int paramInt2)
    {
      int i = mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.i)mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
        i -= 1;
      }
    }
    
    public void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      notifyItemRangeChanged(paramInt1, paramInt2, null);
    }
    
    public void notifyItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.i)mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2, paramObject);
        i -= 1;
      }
    }
    
    public void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      int i = mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.i)mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      int i = mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.i)mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
        i -= 1;
      }
    }
  }
  
  public static abstract class i
  {
    public i() {}
    
    public void onChanged() {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2) {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      onItemRangeChanged(paramInt1, paramInt2);
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2) {}
    
    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2) {}
  }
  
  public static abstract interface j
  {
    public abstract int getChildDrawingOrder(int paramInt1, int paramInt2);
  }
  
  public static class k
  {
    public k() {}
    
    protected EdgeEffect a(RecyclerView paramRecyclerView, int paramInt)
    {
      return new EdgeEffect(paramRecyclerView.getContext());
    }
  }
  
  public static abstract class l
  {
    private long animationDuration = 120L;
    private ArrayList<a> j = new ArrayList();
    private long mChangeDuration = 250L;
    private b mListener = null;
    private long mMoveDuration = 250L;
    private long mRemoveDuration = 120L;
    
    public l() {}
    
    static int buildAdapterChangeFlagsForAnimations(RecyclerView.b0 paramB0)
    {
      int k = mFlags & 0xE;
      if (paramB0.isInvalid()) {
        return 4;
      }
      int i = k;
      if ((k & 0x4) == 0)
      {
        int m = paramB0.getOldPosition();
        int n = paramB0.getAbsoluteAdapterPosition();
        i = k;
        if (m != -1)
        {
          i = k;
          if (n != -1)
          {
            i = k;
            if (m != n) {
              i = k | 0x800;
            }
          }
        }
      }
      return i;
    }
    
    public abstract boolean animateAppearance(RecyclerView.b0 paramB0, c paramC1, c paramC2);
    
    public abstract boolean animateChange(RecyclerView.b0 paramB01, RecyclerView.b0 paramB02, c paramC1, c paramC2);
    
    public abstract boolean animateDisappearance(RecyclerView.b0 paramB0, c paramC1, c paramC2);
    
    public abstract boolean animatePersistence(RecyclerView.b0 paramB0, c paramC1, c paramC2);
    
    public final void b()
    {
      int k = j.size();
      int i = 0;
      while (i < k)
      {
        ((a)j.get(i)).visitAttribute();
        i += 1;
      }
      j.clear();
    }
    
    public final boolean b(a paramA)
    {
      boolean bool = isRunning();
      if (paramA != null)
      {
        if (!bool)
        {
          paramA.visitAttribute();
          return bool;
        }
        j.add(paramA);
      }
      return bool;
    }
    
    public abstract boolean canReuseUpdatedViewHolder(RecyclerView.b0 paramB0);
    
    public boolean canReuseUpdatedViewHolder(RecyclerView.b0 paramB0, List paramList)
    {
      return canReuseUpdatedViewHolder(paramB0);
    }
    
    public final void dispatchAnimationFinished(RecyclerView.b0 paramB0)
    {
      onAnimationFinished(paramB0);
      b localB = mListener;
      if (localB != null) {
        localB.onAnimationFinished(paramB0);
      }
    }
    
    public abstract void endAnimation(RecyclerView.b0 paramB0);
    
    public abstract void endAnimations();
    
    public long getAnimationDuration()
    {
      return animationDuration;
    }
    
    public long getChangeDuration()
    {
      return mChangeDuration;
    }
    
    public long getMoveDuration()
    {
      return mMoveDuration;
    }
    
    public long getRemoveDuration()
    {
      return mRemoveDuration;
    }
    
    public abstract boolean isRunning();
    
    public c obtainHolderInfo()
    {
      return new c();
    }
    
    public void onAnimationFinished(RecyclerView.b0 paramB0) {}
    
    public c recordPostLayoutInformation(RecyclerView.y paramY, RecyclerView.b0 paramB0)
    {
      return obtainHolderInfo().setFrom(paramB0);
    }
    
    public c recordPreLayoutInformation(RecyclerView.y paramY, RecyclerView.b0 paramB0, int paramInt, List paramList)
    {
      return obtainHolderInfo().setFrom(paramB0);
    }
    
    public abstract void runPendingAnimations();
    
    void setListener(b paramB)
    {
      mListener = paramB;
    }
    
    public static abstract interface a
    {
      public abstract void visitAttribute();
    }
    
    static abstract interface b
    {
      public abstract void onAnimationFinished(RecyclerView.b0 paramB0);
    }
    
    public static class c
    {
      public int bottom;
      public int left;
      public int right;
      public int top;
      
      public c() {}
      
      public c setFrom(RecyclerView.b0 paramB0)
      {
        return setFrom(paramB0, 0);
      }
      
      public c setFrom(RecyclerView.b0 paramB0, int paramInt)
      {
        paramB0 = itemView;
        left = paramB0.getLeft();
        top = paramB0.getTop();
        right = paramB0.getRight();
        bottom = paramB0.getBottom();
        return this;
      }
    }
  }
  
  private class m
    implements RecyclerView.l.b
  {
    m() {}
    
    public void onAnimationFinished(RecyclerView.b0 paramB0)
    {
      paramB0.setIsRecyclable(true);
      if ((mShadowedHolder != null) && (mShadowingHolder == null)) {
        mShadowedHolder = null;
      }
      mShadowingHolder = null;
      if ((!paramB0.shouldBeKeptAsChild()) && (!removeAnimatingView(itemView)) && (paramB0.isTmpDetached())) {
        removeDetachedView(itemView, false);
      }
    }
  }
  
  public static abstract class n
  {
    public n() {}
    
    public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      paramRect.set(0, 0, 0, 0);
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.y paramY)
    {
      getItemOffsets(paramRect, ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition(), paramRecyclerView);
    }
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.y paramY)
    {
      onDraw(paramCanvas, paramRecyclerView);
    }
    
    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
    
    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.y paramY)
    {
      onDrawOver(paramCanvas, paramRecyclerView);
    }
  }
  
  public static abstract class o
  {
    RecyclerView.x a;
    int b;
    i c;
    i d;
    private boolean i;
    private final ByteVector l;
    boolean mAutoMeasure;
    ChildHelper mChildHelper;
    boolean mDataSetHasChangedAfterLayout;
    private int mHeight;
    private int mHeightMode;
    boolean mIsAttachedToWindow;
    private boolean mMeasurementCacheEnabled;
    RecyclerView mRecyclerView;
    boolean mState;
    private int mWidth;
    private int mWidthMode;
    private final ByteVector stackMap;
    
    public o()
    {
      a localA = new a();
      stackMap = localA;
      b localB = new b();
      l = localB;
      c = new i(localA);
      d = new i(localB);
      mDataSetHasChangedAfterLayout = false;
      mIsAttachedToWindow = false;
      mAutoMeasure = false;
      mMeasurementCacheEnabled = true;
      i = true;
    }
    
    private void addViewInt(View paramView, int paramInt, boolean paramBoolean)
    {
      Object localObject = RecyclerView.getChildViewHolderInt(paramView);
      if ((!paramBoolean) && (!((RecyclerView.b0)localObject).isRemoved())) {
        mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout((RecyclerView.b0)localObject);
      } else {
        mRecyclerView.mViewInfoStore.addToDisappearedInLayout((RecyclerView.b0)localObject);
      }
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((!((RecyclerView.b0)localObject).wasReturnedFromScrap()) && (!((RecyclerView.b0)localObject).isScrap()))
      {
        if (paramView.getParent() == mRecyclerView)
        {
          int k = mChildHelper.indexOfChild(paramView);
          int j = paramInt;
          if (paramInt == -1) {
            j = mChildHelper.getChildCount();
          }
          if (k != -1)
          {
            if (k != j) {
              mRecyclerView.mLayout.moveView(k, j);
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
            ((StringBuilder)localObject).append(mRecyclerView.indexOfChild(paramView));
            ((StringBuilder)localObject).append(mRecyclerView.append());
            throw new IllegalStateException(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          mChildHelper.addView(paramView, paramInt, false);
          mInsetsDirty = true;
          RecyclerView.x localX = a;
          if ((localX != null) && (localX.s())) {
            a.b(paramView);
          }
        }
      }
      else
      {
        if (((RecyclerView.b0)localObject).isScrap()) {
          ((RecyclerView.b0)localObject).unScrap();
        } else {
          ((RecyclerView.b0)localObject).clearReturnedFromScrapFlag();
        }
        mChildHelper.attachViewToParent(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      if (mPendingInvalidate)
      {
        itemView.invalidate();
        mPendingInvalidate = false;
      }
    }
    
    public static int chooseSize(int paramInt1, int paramInt2, int paramInt3)
    {
      int j = View.MeasureSpec.getMode(paramInt1);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      if (j != Integer.MIN_VALUE)
      {
        if (j != 1073741824) {
          return Math.max(paramInt2, paramInt3);
        }
      }
      else {
        paramInt1 = Math.min(paramInt1, Math.max(paramInt2, paramInt3));
      }
      return paramInt1;
    }
    
    private void detachViewInternal(int paramInt, View paramView)
    {
      mChildHelper.detachViewFromParent(paramInt);
    }
    
    private boolean draw(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      paramRecyclerView = paramRecyclerView.getFocusedChild();
      if (paramRecyclerView == null) {
        return false;
      }
      int j = getPaddingLeft();
      int k = getPaddingTop();
      int m = getWidth();
      int n = getPaddingRight();
      int i1 = getHeight();
      int i2 = getPaddingBottom();
      Rect localRect = mRecyclerView.mTempRect;
      draw(paramRecyclerView, localRect);
      if ((left - paramInt1 < m - n) && (right - paramInt1 > j) && (top - paramInt2 < i1 - i2)) {
        return bottom - paramInt2 > k;
      }
      return false;
    }
    
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      paramInt1 = Math.max(0, paramInt1 - paramInt3);
      if (paramBoolean)
      {
        if (paramInt4 < 0)
        {
          if (paramInt4 != -1) {
            break label100;
          }
          if (paramInt2 == Integer.MIN_VALUE) {
            break label59;
          }
          if (paramInt2 == 0) {
            break label100;
          }
          if (paramInt2 == 1073741824) {
            break label59;
          }
          break label100;
        }
      }
      else {
        if (paramInt4 < 0) {
          break label54;
        }
      }
      paramInt2 = 1073741824;
      break label104;
      label54:
      if (paramInt4 == -1)
      {
        label59:
        paramInt4 = paramInt1;
      }
      else if (paramInt4 == -2)
      {
        if ((paramInt2 != Integer.MIN_VALUE) && (paramInt2 != 1073741824))
        {
          paramInt2 = 0;
          paramInt4 = paramInt1;
        }
        else
        {
          paramInt2 = Integer.MIN_VALUE;
          paramInt4 = paramInt1;
        }
      }
      else
      {
        label100:
        paramInt2 = 0;
        paramInt4 = 0;
      }
      label104:
      return View.MeasureSpec.makeMeasureSpec(paramInt4, paramInt2);
    }
    
    public static d getProperties(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      d localD = new d();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt1, paramInt2);
      orientation = paramContext.getInt(R.styleable.RecyclerView_android_orientation, 1);
      spanCount = paramContext.getInt(R.styleable.RecyclerView_spanCount, 1);
      reverseLayout = paramContext.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
      stackFromEnd = paramContext.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
      paramContext.recycle();
      return localD;
    }
    
    private static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
    {
      int j = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {
        return false;
      }
      if (j != Integer.MIN_VALUE)
      {
        if (j != 0)
        {
          if (j != 1073741824) {
            return false;
          }
          if (paramInt2 != paramInt1) {}
        }
        else
        {
          return true;
        }
      }
      else if (paramInt2 >= paramInt1) {
        return true;
      }
      return false;
    }
    
    private int[] requestChildRectangleOnScreen(View paramView, Rect paramRect)
    {
      int j = getPaddingLeft();
      int k = getPaddingTop();
      int m = getWidth();
      int i2 = getPaddingRight();
      int i4 = getHeight();
      int i5 = getPaddingBottom();
      int i9 = paramView.getLeft() + left - paramView.getScrollX();
      int i6 = paramView.getTop() + top - paramView.getScrollY();
      int i10 = paramRect.width();
      int i7 = paramRect.height();
      int i8 = i9 - j;
      int i1 = Math.min(0, i8);
      j = i1;
      int i3 = i6 - k;
      int n = Math.min(0, i3);
      k = n;
      i9 = i10 + i9 - (m - i2);
      i2 = Math.max(0, i9);
      m = i2;
      i4 = Math.max(0, i7 + i6 - (i4 - i5));
      if (getLayoutDirection() == 1)
      {
        if (i2 != 0) {
          j = m;
        } else {
          j = Math.max(i1, i9);
        }
      }
      else if (i1 == 0) {
        j = Math.min(i8, i2);
      }
      if (n == 0) {
        k = Math.min(i3, i4);
      }
      return new int[] { j, k };
    }
    
    private void scrapOrRecycleView(RecyclerView.u paramU, int paramInt, View paramView)
    {
      RecyclerView.b0 localB0 = RecyclerView.getChildViewHolderInt(paramView);
      if (localB0.shouldIgnore()) {
        return;
      }
      if ((localB0.isInvalid()) && (!localB0.isRemoved()) && (!mRecyclerView.mAdapter.hasStableIds()))
      {
        removeViewAt(paramInt);
        paramU.recycleViewHolderInternal(localB0);
        return;
      }
      detachViewAt(paramInt);
      paramU.scrapView(paramView);
      mRecyclerView.mViewInfoStore.onViewDetached(localB0);
    }
    
    public int a()
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView != null) {
        return ViewCompat.format(localRecyclerView);
      }
      return 0;
    }
    
    public int a(View paramView)
    {
      return getLayoutParamsmDecorInsets.bottom;
    }
    
    public void a(RecyclerView.x paramX)
    {
      RecyclerView.x localX = a;
      if ((localX != null) && (paramX != localX) && (localX.s())) {
        a.e();
      }
      a = paramX;
      paramX.start(mRecyclerView, this);
    }
    
    public boolean a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((c.a(paramView, 24579)) && (d.a(paramView, 24579))) {
        paramBoolean2 = true;
      } else {
        paramBoolean2 = false;
      }
      if (paramBoolean1) {
        return paramBoolean2;
      }
      return paramBoolean2 ^ true;
    }
    
    public boolean a(RecyclerView.u paramU, RecyclerView.y paramY, int paramInt, Bundle paramBundle)
    {
      paramU = mRecyclerView;
      if (paramU == null) {
        return false;
      }
      if (paramInt != 4096)
      {
        if (paramInt != 8192)
        {
          j = 0;
          paramInt = 0;
        }
        else
        {
          if (paramU.canScrollVertically(-1)) {
            paramInt = -(getHeight() - getPaddingTop() - getPaddingBottom());
          } else {
            paramInt = 0;
          }
          j = paramInt;
          if (mRecyclerView.canScrollHorizontally(-1)) {
            j = -(getWidth() - getPaddingLeft() - getPaddingRight());
          }
        }
      }
      else
      {
        if (paramU.canScrollVertically(1)) {
          paramInt = getHeight() - getPaddingTop() - getPaddingBottom();
        } else {
          paramInt = 0;
        }
        j = paramInt;
        if (!mRecyclerView.canScrollHorizontally(1)) {
          break label157;
        }
        j = getWidth() - getPaddingLeft() - getPaddingRight();
      }
      break label167;
      label157:
      int k = 0;
      paramInt = j;
      int j = k;
      label167:
      if ((paramInt == 0) && (j == 0)) {
        return false;
      }
      mRecyclerView.smoothScrollBy(j, paramInt, null, Integer.MIN_VALUE, true);
      return true;
    }
    
    public int add()
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView != null) {
        return ViewCompat.add(localRecyclerView);
      }
      return 0;
    }
    
    public void addDisappearingView(View paramView)
    {
      addDisappearingView(paramView, -1);
    }
    
    public void addDisappearingView(View paramView, int paramInt)
    {
      addViewInt(paramView, paramInt, true);
    }
    
    public void addView(View paramView)
    {
      addView(paramView, -1);
    }
    
    public void addView(View paramView, int paramInt)
    {
      addViewInt(paramView, paramInt, false);
    }
    
    public void assertNotInLayoutOrScroll(String paramString)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView != null) {
        localRecyclerView.a(paramString);
      }
    }
    
    public void attachToRecyclerView(RecyclerView paramRecyclerView) {}
    
    public void attachView(View paramView, int paramInt)
    {
      attachView(paramView, paramInt, (RecyclerView.LayoutParams)paramView.getLayoutParams());
    }
    
    public void attachView(View paramView, int paramInt, RecyclerView.LayoutParams paramLayoutParams)
    {
      RecyclerView.b0 localB0 = RecyclerView.getChildViewHolderInt(paramView);
      if (localB0.isRemoved()) {
        mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localB0);
      } else {
        mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localB0);
      }
      mChildHelper.attachViewToParent(paramView, paramInt, paramLayoutParams, localB0.isRemoved());
    }
    
    public void b(RecyclerView paramRecyclerView) {}
    
    public final void b(boolean paramBoolean)
    {
      if (paramBoolean != i)
      {
        i = paramBoolean;
        b = 0;
        RecyclerView localRecyclerView = mRecyclerView;
        if (localRecyclerView != null) {
          mRecycler.next();
        }
      }
    }
    
    boolean b(int paramInt, Bundle paramBundle)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      return a(mRecycler, mState, paramInt, paramBundle);
    }
    
    public boolean b(RecyclerView.u paramU, RecyclerView.y paramY)
    {
      return false;
    }
    
    public int c(View paramView)
    {
      return getLayoutParamsmDecorInsets.left;
    }
    
    public void calculateItemDecorationsForChild(View paramView, Rect paramRect)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(localRecyclerView.getItemDecorInsetsForChild(paramView));
    }
    
    public boolean canScrollHorizontally()
    {
      return false;
    }
    
    public boolean canScrollVertically()
    {
      return false;
    }
    
    public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      return paramLayoutParams != null;
    }
    
    public int computeHorizontalScrollExtent(RecyclerView.y paramY)
    {
      return 0;
    }
    
    public int computeHorizontalScrollOffset(RecyclerView.y paramY)
    {
      return 0;
    }
    
    public int computeHorizontalScrollRange(RecyclerView.y paramY)
    {
      return 0;
    }
    
    public int computeVerticalScrollExtent(RecyclerView.y paramY)
    {
      return 0;
    }
    
    public int computeVerticalScrollOffset(RecyclerView.y paramY)
    {
      return 0;
    }
    
    public int computeVerticalScrollRange(RecyclerView.y paramY)
    {
      return 0;
    }
    
    public void detachAndScrapAttachedViews(RecyclerView.u paramU)
    {
      int j = getChildCount() - 1;
      while (j >= 0)
      {
        scrapOrRecycleView(paramU, j, getChildAt(j));
        j -= 1;
      }
    }
    
    public void detachViewAt(int paramInt)
    {
      detachViewInternal(paramInt, getChildAt(paramInt));
    }
    
    void dispatchAttachedToWindow(RecyclerView paramRecyclerView)
    {
      mIsAttachedToWindow = true;
      b(paramRecyclerView);
    }
    
    void draw(int paramInt1, int paramInt2)
    {
      int i5 = getChildCount();
      if (i5 == 0)
      {
        mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
        return;
      }
      int k = 0;
      int i2 = Integer.MIN_VALUE;
      int i1 = Integer.MAX_VALUE;
      int m = Integer.MAX_VALUE;
      int i4;
      for (int j = Integer.MIN_VALUE; k < i5; j = i4)
      {
        View localView = getChildAt(k);
        Rect localRect = mRecyclerView.mTempRect;
        draw(localView, localRect);
        int i3 = left;
        int n = i1;
        if (i3 < i1) {
          n = i3;
        }
        i3 = right;
        i1 = i2;
        if (i3 > i2) {
          i1 = i3;
        }
        i2 = top;
        i3 = m;
        if (i2 < m) {
          i3 = i2;
        }
        m = bottom;
        i4 = j;
        if (m > j) {
          i4 = m;
        }
        k += 1;
        i2 = i1;
        i1 = n;
        m = i3;
      }
      mRecyclerView.mTempRect.set(i1, m, i2, j);
      setMeasuredDimension(mRecyclerView.mTempRect, paramInt1, paramInt2);
    }
    
    public void draw(View paramView, Rect paramRect)
    {
      RecyclerView.onDraw(paramView, paramRect);
    }
    
    public void draw(View paramView, boolean paramBoolean, Rect paramRect)
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = getLayoutParamsmDecorInsets;
        paramRect.set(-left, -top, paramView.getWidth() + right, paramView.getHeight() + bottom);
      }
      else
      {
        paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
      }
      if (mRecyclerView != null)
      {
        localObject = paramView.getMatrix();
        if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
        {
          RectF localRectF = mRecyclerView.a;
          localRectF.set(paramRect);
          ((Matrix)localObject).mapRect(localRectF);
          paramRect.set((int)Math.floor(left), (int)Math.floor(top), (int)Math.ceil(right), (int)Math.ceil(bottom));
        }
      }
      paramRect.offset(paramView.getLeft(), paramView.getTop());
    }
    
    public int f(View paramView)
    {
      return getLayoutParamsmDecorInsets.top;
    }
    
    public void fill(int paramInt1, int paramInt2, RecyclerView.y paramY, c paramC) {}
    
    public View findContainingItemView(View paramView)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView == null) {
        return null;
      }
      paramView = localRecyclerView.findContainingItemView(paramView);
      if (paramView == null) {
        return null;
      }
      if (mChildHelper.isHidden(paramView)) {
        return null;
      }
      return paramView;
    }
    
    public boolean findValidDrawClaim()
    {
      return mMeasurementCacheEnabled;
    }
    
    public View findViewByPosition(int paramInt)
    {
      int k = getChildCount();
      int j = 0;
      View localView;
      while (j < k)
      {
        localView = getChildAt(j);
        RecyclerView.b0 localB0 = RecyclerView.getChildViewHolderInt(localView);
        if ((localB0 != null) && (localB0.getLayoutPosition() == paramInt) && (!localB0.shouldIgnore()))
        {
          if (mRecyclerView.mState.isPreLayout()) {
            break label84;
          }
          if (!localB0.isRemoved()) {
            return localView;
          }
        }
        j += 1;
      }
      return null;
      label84:
      return localView;
    }
    
    public final boolean g()
    {
      return i;
    }
    
    public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();
    
    public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
    }
    
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
        return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new RecyclerView.LayoutParams(paramLayoutParams);
    }
    
    public int getBaseline()
    {
      return -1;
    }
    
    public View getChildAt(int paramInt)
    {
      ChildHelper localChildHelper = mChildHelper;
      if (localChildHelper != null) {
        return localChildHelper.getChildAt(paramInt);
      }
      return null;
    }
    
    public int getChildCount()
    {
      ChildHelper localChildHelper = mChildHelper;
      if (localChildHelper != null) {
        return localChildHelper.getChildCount();
      }
      return 0;
    }
    
    public int getColumnCountForAccessibility(RecyclerView.u paramU, RecyclerView.y paramY)
    {
      return -1;
    }
    
    public int getDecoratedBottom(View paramView)
    {
      return paramView.getBottom() + a(paramView);
    }
    
    public int getDecoratedLeft(View paramView)
    {
      return paramView.getLeft() - c(paramView);
    }
    
    public int getDecoratedMeasuredHeight(View paramView)
    {
      Rect localRect = getLayoutParamsmDecorInsets;
      return paramView.getMeasuredHeight() + top + bottom;
    }
    
    public int getDecoratedMeasuredWidth(View paramView)
    {
      Rect localRect = getLayoutParamsmDecorInsets;
      return paramView.getMeasuredWidth() + left + right;
    }
    
    public int getDecoratedRight(View paramView)
    {
      return paramView.getRight() + next(paramView);
    }
    
    public int getDecoratedTop(View paramView)
    {
      return paramView.getTop() - f(paramView);
    }
    
    public View getFocusedChild()
    {
      Object localObject = mRecyclerView;
      if (localObject == null) {
        return null;
      }
      localObject = ((ViewGroup)localObject).getFocusedChild();
      if (localObject != null)
      {
        if (mChildHelper.isHidden((View)localObject)) {
          return null;
        }
        return localObject;
      }
      return null;
    }
    
    public int getHeight()
    {
      return mHeight;
    }
    
    public int getHeightMode()
    {
      return mHeightMode;
    }
    
    public int getItemCount()
    {
      Object localObject = mRecyclerView;
      if (localObject != null) {
        localObject = ((RecyclerView)localObject).getAdapter();
      } else {
        localObject = null;
      }
      if (localObject != null) {
        return ((RecyclerView.Adapter)localObject).getItemCount();
      }
      return 0;
    }
    
    public int getLayoutDirection()
    {
      return ViewCompat.getLayoutDirection(mRecyclerView);
    }
    
    public int getMinimumHeight()
    {
      return ViewCompat.getMinimumHeight(mRecyclerView);
    }
    
    public int getMinimumWidth()
    {
      return ViewCompat.getMinimumWidth(mRecyclerView);
    }
    
    public int getPaddingBottom()
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView != null) {
        return localRecyclerView.getPaddingBottom();
      }
      return 0;
    }
    
    public int getPaddingLeft()
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView != null) {
        return localRecyclerView.getPaddingLeft();
      }
      return 0;
    }
    
    public int getPaddingRight()
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView != null) {
        return localRecyclerView.getPaddingRight();
      }
      return 0;
    }
    
    public int getPaddingTop()
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView != null) {
        return localRecyclerView.getPaddingTop();
      }
      return 0;
    }
    
    public int getPosition(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    }
    
    public int getRowCountForAccessibility(RecyclerView.u paramU, RecyclerView.y paramY)
    {
      return -1;
    }
    
    public int getWidth()
    {
      return mWidth;
    }
    
    public int getWidthMode()
    {
      return mWidthMode;
    }
    
    boolean hasFlexibleChildInBothOrientations()
    {
      int k = getChildCount();
      int j = 0;
      while (j < k)
      {
        ViewGroup.LayoutParams localLayoutParams = getChildAt(j).getLayoutParams();
        if ((width < 0) && (height < 0)) {
          return true;
        }
        j += 1;
      }
      return false;
    }
    
    public boolean isAttachedToWindow()
    {
      return mIsAttachedToWindow;
    }
    
    public void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = mDecorInsets;
      paramView.layout(paramInt1 + left + leftMargin, paramInt2 + top + topMargin, paramInt3 - right - rightMargin, paramInt4 - bottom - bottomMargin);
    }
    
    public void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = mRecyclerView.getItemDecorInsetsForChild(paramView);
      int m = left;
      int n = right;
      int j = top;
      int k = bottom;
      paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin + (paramInt1 + (m + n)), width, canScrollHorizontally());
      paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + topMargin + bottomMargin + (paramInt2 + (j + k)), height, canScrollVertically());
      if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
        paramView.measure(paramInt1, paramInt2);
      }
    }
    
    public void moveView(int paramInt1, int paramInt2)
    {
      Object localObject = getChildAt(paramInt1);
      if (localObject != null)
      {
        detachViewAt(paramInt1);
        attachView((View)localObject, paramInt2);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot move a child from non-existing index:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(mRecyclerView.toString());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public int next(View paramView)
    {
      return getLayoutParamsmDecorInsets.right;
    }
    
    public void offsetChildrenHorizontal(int paramInt)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView != null) {
        localRecyclerView.offsetChildrenHorizontal(paramInt);
      }
    }
    
    public void offsetChildrenVertical(int paramInt)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView != null) {
        localRecyclerView.offsetChildrenVertical(paramInt);
      }
    }
    
    public boolean onAddFocusables(RecyclerView paramRecyclerView, ArrayList paramArrayList, int paramInt1, int paramInt2)
    {
      return false;
    }
    
    void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.u paramU)
    {
      mIsAttachedToWindow = false;
      onLayoutChildren(paramRecyclerView, paramU);
    }
    
    public View onFocusSearchFailed(View paramView, int paramInt)
    {
      return null;
    }
    
    public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
    {
      return null;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      onInitializeAccessibilityEvent(mRecycler, mState, paramAccessibilityEvent);
    }
    
    public void onInitializeAccessibilityEvent(RecyclerView.u paramU, RecyclerView.y paramY, AccessibilityEvent paramAccessibilityEvent)
    {
      paramU = mRecyclerView;
      if (paramU != null)
      {
        if (paramAccessibilityEvent == null) {
          return;
        }
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (!paramU.canScrollVertically(1))
        {
          bool1 = bool2;
          if (!mRecyclerView.canScrollVertically(-1))
          {
            bool1 = bool2;
            if (!mRecyclerView.canScrollHorizontally(-1)) {
              if (mRecyclerView.canScrollHorizontally(1)) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
          }
        }
        paramAccessibilityEvent.setScrollable(bool1);
        paramU = mRecyclerView.mAdapter;
        if (paramU != null) {
          paramAccessibilityEvent.setItemCount(paramU.getItemCount());
        }
      }
    }
    
    public void onInitializeAccessibilityNodeInfo(RecyclerView.u paramU, RecyclerView.y paramY, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if ((mRecyclerView.canScrollVertically(-1)) || (mRecyclerView.canScrollHorizontally(-1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(8192);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      if ((mRecyclerView.canScrollVertically(1)) || (mRecyclerView.canScrollHorizontally(1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(4096);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      paramAccessibilityNodeInfoCompat.setParent(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getColumnCountForAccessibility(paramU, paramY), getRowCountForAccessibility(paramU, paramY), b(paramU, paramY), toInteger(paramU, paramY)));
    }
    
    void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      onInitializeAccessibilityNodeInfo(mRecycler, mState, paramAccessibilityNodeInfoCompat);
    }
    
    void onInitializeAccessibilityNodeInfoForItem(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      Object localObject = RecyclerView.getChildViewHolderInt(paramView);
      if ((localObject != null) && (!((RecyclerView.b0)localObject).isRemoved()) && (!mChildHelper.isHidden(itemView)))
      {
        localObject = mRecyclerView;
        onInitializeAccessibilityNodeInfoForItem(mRecycler, mState, paramView, paramAccessibilityNodeInfoCompat);
      }
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.u paramU, RecyclerView.y paramY, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
    
    public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsChanged(RecyclerView paramRecyclerView) {}
    
    public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
    {
      xor(paramRecyclerView, paramInt1, paramInt2);
    }
    
    void onLayoutChildren()
    {
      RecyclerView.x localX = a;
      if (localX != null) {
        localX.e();
      }
    }
    
    public void onLayoutChildren(int paramInt, c paramC) {}
    
    public void onLayoutChildren(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2) {}
    
    public void onLayoutChildren(RecyclerView.u paramU, RecyclerView.y paramY)
    {
      android.util.Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }
    
    public void onLayoutChildren(RecyclerView.y paramY) {}
    
    public void onLayoutChildren(RecyclerView paramRecyclerView, RecyclerView.u paramU)
    {
      attachToRecyclerView(paramRecyclerView);
    }
    
    public void onMeasure(RecyclerView.u paramU, RecyclerView.y paramY, int paramInt1, int paramInt2)
    {
      mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
    }
    
    public boolean onRequestChildFocus(RecyclerView paramRecyclerView, View paramView1, View paramView2)
    {
      return (require()) || (paramRecyclerView.isComputingLayout());
    }
    
    public boolean onRequestChildFocus(RecyclerView paramRecyclerView, RecyclerView.y paramY, View paramView1, View paramView2)
    {
      return onRequestChildFocus(paramRecyclerView, paramView1, paramView2);
    }
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public void onScrollStateChanged(int paramInt) {}
    
    boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      return performAccessibilityActionForItem(mRecycler, mState, paramView, paramInt, paramBundle);
    }
    
    public boolean performAccessibilityActionForItem(RecyclerView.u paramU, RecyclerView.y paramY, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void removeAllViews()
    {
      int j = getChildCount() - 1;
      while (j >= 0)
      {
        mChildHelper.removeViewAt(j);
        j -= 1;
      }
    }
    
    public void removeAndRecycleAllViews(RecyclerView.u paramU)
    {
      int j = getChildCount() - 1;
      while (j >= 0)
      {
        if (!RecyclerView.getChildViewHolderInt(getChildAt(j)).shouldIgnore()) {
          removeAndRecycleViewAt(j, paramU);
        }
        j -= 1;
      }
    }
    
    void removeAndRecycleScrapInt(RecyclerView.u paramU)
    {
      int k = paramU.getScrapCount();
      int j = k - 1;
      while (j >= 0)
      {
        View localView = paramU.getScrapViewAt(j);
        RecyclerView.b0 localB0 = RecyclerView.getChildViewHolderInt(localView);
        if (!localB0.shouldIgnore())
        {
          localB0.setIsRecyclable(false);
          if (localB0.isTmpDetached()) {
            mRecyclerView.removeDetachedView(localView, false);
          }
          RecyclerView.l localL = mRecyclerView.mItemAnimator;
          if (localL != null) {
            localL.endAnimation(localB0);
          }
          localB0.setIsRecyclable(true);
          paramU.quickRecycleScrapView(localView);
        }
        j -= 1;
      }
      paramU.clearScrap();
      if (k > 0) {
        mRecyclerView.invalidate();
      }
    }
    
    public void removeAndRecycleView(View paramView, RecyclerView.u paramU)
    {
      removeView(paramView);
      paramU.recycleView(paramView);
    }
    
    public void removeAndRecycleViewAt(int paramInt, RecyclerView.u paramU)
    {
      View localView = getChildAt(paramInt);
      removeViewAt(paramInt);
      paramU.recycleView(localView);
    }
    
    public boolean removeCallbacks(Runnable paramRunnable)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView != null) {
        return localRecyclerView.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public void removeView(View paramView)
    {
      mChildHelper.removeView(paramView);
    }
    
    public void removeViewAt(int paramInt)
    {
      if (getChildAt(paramInt) != null) {
        mChildHelper.removeViewAt(paramInt);
      }
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
    {
      return requestChildRectangleOnScreen(paramRecyclerView, paramView, paramRect, paramBoolean, false);
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
    {
      paramView = requestChildRectangleOnScreen(paramView, paramRect);
      int j = paramView[0];
      int k = paramView[1];
      if ((!paramBoolean2) || (draw(paramRecyclerView, j, k)))
      {
        if (j == 0) {
          if (k == 0) {
            break label74;
          }
        }
      }
      else {
        return false;
      }
      if (paramBoolean1)
      {
        paramRecyclerView.scrollBy(j, k);
        return true;
      }
      paramRecyclerView.smoothScrollBy(j, k);
      return true;
      label74:
      return false;
    }
    
    public void requestLayout()
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if (localRecyclerView != null) {
        localRecyclerView.requestLayout();
      }
    }
    
    public void requestSimpleAnimationsInNextLayout()
    {
      mDataSetHasChangedAfterLayout = true;
    }
    
    public boolean require()
    {
      RecyclerView.x localX = a;
      return (localX != null) && (localX.s());
    }
    
    public int scrollHorizontallyBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
    {
      return 0;
    }
    
    public void scrollToPosition(int paramInt) {}
    
    public int scrollVerticallyBy(int paramInt, RecyclerView.u paramU, RecyclerView.y paramY)
    {
      return 0;
    }
    
    public void setAutoMeasureEnabled(boolean paramBoolean)
    {
      mAutoMeasure = paramBoolean;
    }
    
    void setExactMeasureSpecsFrom(RecyclerView paramRecyclerView)
    {
      setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }
    
    void setMeasureSpecs(int paramInt1, int paramInt2)
    {
      mWidth = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = View.MeasureSpec.getMode(paramInt1);
      mWidthMode = paramInt1;
      if ((paramInt1 == 0) && (!RecyclerView.M)) {
        mWidth = 0;
      }
      mHeight = View.MeasureSpec.getSize(paramInt2);
      paramInt1 = View.MeasureSpec.getMode(paramInt2);
      mHeightMode = paramInt1;
      if ((paramInt1 == 0) && (!RecyclerView.M)) {
        mHeight = 0;
      }
    }
    
    public void setMeasuredDimension(int paramInt1, int paramInt2)
    {
      RecyclerView.access$getSetMeasuredDimension(mRecyclerView, paramInt1, paramInt2);
    }
    
    public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
    {
      int j = paramRect.width();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      int n = paramRect.height();
      int i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      setMeasuredDimension(chooseSize(paramInt1, j + k + m, getMinimumWidth()), chooseSize(paramInt2, n + i1 + i2, getMinimumHeight()));
    }
    
    public boolean setOrientation()
    {
      return mAutoMeasure;
    }
    
    void setRecyclerView(RecyclerView paramRecyclerView)
    {
      if (paramRecyclerView == null)
      {
        mRecyclerView = null;
        mChildHelper = null;
        mWidth = 0;
        mHeight = 0;
      }
      else
      {
        mRecyclerView = paramRecyclerView;
        mChildHelper = mChildHelper;
        mWidth = paramRecyclerView.getWidth();
        mHeight = paramRecyclerView.getHeight();
      }
      mWidthMode = 1073741824;
      mHeightMode = 1073741824;
    }
    
    public boolean shouldIgnore()
    {
      RecyclerView localRecyclerView = mRecyclerView;
      return (localRecyclerView != null) && (mClipToPadding);
    }
    
    boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (paramView.isLayoutRequested()) || (!mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, height));
    }
    
    boolean shouldMeasureTwice()
    {
      return false;
    }
    
    boolean shouldReMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (!mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getMeasuredWidth(), paramInt1, width)) || (!isMeasurementUpToDate(paramView.getMeasuredHeight(), paramInt2, height));
    }
    
    public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.y paramY, int paramInt)
    {
      android.util.Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }
    
    public boolean supportsPredictiveItemAnimations()
    {
      return false;
    }
    
    public int toInteger(RecyclerView.u paramU, RecyclerView.y paramY)
    {
      return 0;
    }
    
    void write(RecyclerView.x paramX)
    {
      if (a == paramX) {
        a = null;
      }
    }
    
    public void xor(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    class a
      implements ByteVector
    {
      a() {}
      
      public int a()
      {
        return getWidth() - getPaddingRight();
      }
      
      public int b()
      {
        return getPaddingLeft();
      }
      
      public View getChildAt(int paramInt)
      {
        return RecyclerView.o.this.getChildAt(paramInt);
      }
      
      public int getDecoratedEnd(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return getDecoratedRight(paramView) + rightMargin;
      }
      
      public int getDecoratedStart(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return getDecoratedLeft(paramView) - leftMargin;
      }
    }
    
    class b
      implements ByteVector
    {
      b() {}
      
      public int a()
      {
        return getHeight() - getPaddingBottom();
      }
      
      public int b()
      {
        return getPaddingTop();
      }
      
      public View getChildAt(int paramInt)
      {
        return RecyclerView.o.this.getChildAt(paramInt);
      }
      
      public int getDecoratedEnd(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return getDecoratedBottom(paramView) + bottomMargin;
      }
      
      public int getDecoratedStart(View paramView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        return getDecoratedTop(paramView) - topMargin;
      }
    }
    
    public static abstract interface c
    {
      public abstract void set(int paramInt1, int paramInt2);
    }
    
    public static class d
    {
      public int orientation;
      public boolean reverseLayout;
      public int spanCount;
      public boolean stackFromEnd;
      
      public d() {}
    }
  }
  
  public static abstract interface p
  {
    public abstract void bindView(View paramView);
    
    public abstract void onChildViewDetachedFromWindow(View paramView);
  }
  
  public static abstract class q
  {
    public q() {}
    
    public abstract boolean a(int paramInt1, int paramInt2);
  }
  
  public static abstract interface r
  {
    public abstract boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
    
    public abstract void onRequestDisallowInterceptTouchEvent(boolean paramBoolean);
    
    public abstract void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
  }
  
  public static abstract class s
  {
    public s() {}
    
    public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void b(RecyclerView paramRecyclerView, int paramInt) {}
  }
  
  public static class t
  {
    SparseArray<a> a = new SparseArray();
    private int mAttachCount = 0;
    
    public t() {}
    
    private a get(int paramInt)
    {
      a localA2 = (a)a.get(paramInt);
      a localA1 = localA2;
      if (localA2 == null)
      {
        localA1 = new a();
        a.put(paramInt, localA1);
      }
      return localA1;
    }
    
    public void a()
    {
      int i = 0;
      while (i < a.size())
      {
        a.valueAt(i)).c.clear();
        i += 1;
      }
    }
    
    public void a(RecyclerView.b0 paramB0)
    {
      int i = paramB0.getItemViewType();
      ArrayList localArrayList = getc;
      if (a.get(i)).type <= localArrayList.size()) {
        return;
      }
      paramB0.resetInternal();
      localArrayList.add(paramB0);
    }
    
    long add(long paramLong1, long paramLong2)
    {
      if (paramLong1 == 0L) {
        return paramLong2;
      }
      return paramLong1 / 4L * 3L + paramLong2 / 4L;
    }
    
    void append(int paramInt, long paramLong)
    {
      a localA = get(paramInt);
      next = add(next, paramLong);
    }
    
    void attach()
    {
      mAttachCount += 1;
    }
    
    void detach()
    {
      mAttachCount -= 1;
    }
    
    boolean get(int paramInt, long paramLong1, long paramLong2)
    {
      long l = getnext;
      return (l == 0L) || (paramLong1 + l < paramLong2);
    }
    
    void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
    {
      if (paramAdapter1 != null) {
        detach();
      }
      if ((!paramBoolean) && (mAttachCount == 0)) {
        a();
      }
      if (paramAdapter2 != null) {
        attach();
      }
    }
    
    public RecyclerView.b0 onCreateViewHolder(int paramInt)
    {
      Object localObject = (a)a.get(paramInt);
      if ((localObject != null) && (!c.isEmpty()))
      {
        localObject = c;
        paramInt = ((ArrayList)localObject).size() - 1;
        while (paramInt >= 0)
        {
          if (!((RecyclerView.b0)((ArrayList)localObject).get(paramInt)).isAttachedToTransitionOverlay()) {
            return (RecyclerView.b0)((ArrayList)localObject).remove(paramInt);
          }
          paramInt -= 1;
        }
      }
      return null;
    }
    
    void put(int paramInt, long paramLong)
    {
      a localA = get(paramInt);
      value = add(value, paramLong);
    }
    
    boolean put(int paramInt, long paramLong1, long paramLong2)
    {
      long l = getvalue;
      return (l == 0L) || (paramLong1 + l < paramLong2);
    }
    
    static class a
    {
      final ArrayList<RecyclerView.b0> c = new ArrayList();
      long next = 0L;
      int type = 5;
      long value = 0L;
      
      a() {}
    }
  }
  
  public final class u
  {
    int itemView;
    final ArrayList<RecyclerView.b0> mAttachedScrap;
    final ArrayList<RecyclerView.b0> mCachedViews;
    ArrayList<RecyclerView.b0> mChangedScrap;
    private RecyclerView.z mListView;
    RecyclerView.t mRecyclerPool;
    private final List<RecyclerView.b0> mUnmodifiableAttachedScrap;
    private int mViewCacheMax;
    
    public u()
    {
      this$1 = new ArrayList();
      mAttachedScrap = RecyclerView.this;
      mChangedScrap = null;
      mCachedViews = new ArrayList();
      mUnmodifiableAttachedScrap = Collections.unmodifiableList(RecyclerView.this);
      mViewCacheMax = 2;
      itemView = 2;
    }
    
    private void a(RecyclerView.b0 paramB0)
    {
      if (isAccessibilityEnabled())
      {
        paramB0 = itemView;
        if (ViewCompat.getImportantForAccessibility(paramB0) == 0) {
          ViewCompat.get(paramB0, 1);
        }
        Object localObject = mAccessibilityDelegate;
        if (localObject == null) {
          return;
        }
        localObject = ((m)localObject).a();
        if ((localObject instanceof e)) {
          ((e)localObject).onSaveInstanceState(paramB0);
        }
        ViewCompat.a(paramB0, (ActionMenuItemView)localObject);
      }
    }
    
    private void b(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      int i = paramViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          b((ViewGroup)localView, true);
        }
        i -= 1;
      }
      if (!paramBoolean) {
        return;
      }
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
        return;
      }
      i = paramViewGroup.getVisibility();
      paramViewGroup.setVisibility(4);
      paramViewGroup.setVisibility(i);
    }
    
    private void setFrom(RecyclerView.b0 paramB0)
    {
      paramB0 = itemView;
      if ((paramB0 instanceof ViewGroup)) {
        b((ViewGroup)paramB0, false);
      }
    }
    
    private boolean updateContent(RecyclerView.b0 paramB0, int paramInt1, int paramInt2, long paramLong)
    {
      mBindingAdapter = null;
      mOwnerRecyclerView = RecyclerView.this;
      int i = paramB0.getItemViewType();
      long l = getNanoTime();
      if ((paramLong != Long.MAX_VALUE) && (!mRecyclerPool.put(i, l, paramLong))) {
        return false;
      }
      mAdapter.bindViewHolder(paramB0, paramInt1);
      paramLong = getNanoTime();
      mRecyclerPool.put(paramB0.getItemViewType(), paramLong - l);
      a(paramB0);
      if (mState.isPreLayout()) {
        mPreLayoutPosition = paramInt2;
      }
      return true;
    }
    
    void a(RecyclerView.b0 paramB0, boolean paramBoolean)
    {
      RecyclerView.next(paramB0);
      View localView = itemView;
      Object localObject = mAccessibilityDelegate;
      if (localObject != null)
      {
        localObject = ((m)localObject).a();
        if ((localObject instanceof e)) {
          localObject = ((e)localObject).b(localView);
        } else {
          localObject = null;
        }
        ViewCompat.a(localView, (ActionMenuItemView)localObject);
      }
      if (paramBoolean) {
        draw(paramB0);
      }
      mBindingAdapter = null;
      mOwnerRecyclerView = null;
      getRecycledViewPool().a(paramB0);
    }
    
    public void clear()
    {
      mAttachedScrap.clear();
      update();
    }
    
    void clearOldPositions()
    {
      int k = mCachedViews.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        ((RecyclerView.b0)mCachedViews.get(i)).clearOldPosition();
        i += 1;
      }
      k = mAttachedScrap.size();
      i = 0;
      while (i < k)
      {
        ((RecyclerView.b0)mAttachedScrap.get(i)).clearOldPosition();
        i += 1;
      }
      ArrayList localArrayList = mChangedScrap;
      if (localArrayList != null)
      {
        k = localArrayList.size();
        i = j;
        while (i < k)
        {
          ((RecyclerView.b0)mChangedScrap.get(i)).clearOldPosition();
          i += 1;
        }
      }
    }
    
    void clearScrap()
    {
      mAttachedScrap.clear();
      ArrayList localArrayList = mChangedScrap;
      if (localArrayList != null) {
        localArrayList.clear();
      }
    }
    
    public int convertPreLayoutPositionToPostLayout(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < mState.getItemCount()))
      {
        if (!mState.isPreLayout()) {
          return paramInt;
        }
        return mAdapterHelper.findPositionOffset(paramInt);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid position ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(". State item count is ");
      localStringBuilder.append(mState.getItemCount());
      localStringBuilder.append(append());
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    void draw(RecyclerView.b0 paramB0)
    {
      Object localObject = RecyclerView.this.i;
      if (localObject != null) {
        ((RecyclerView.v)localObject).trim(paramB0);
      }
      int j = x.size();
      int i = 0;
      while (i < j)
      {
        ((RecyclerView.v)x.get(i)).trim(paramB0);
        i += 1;
      }
      localObject = mAdapter;
      if (localObject != null) {
        ((RecyclerView.Adapter)localObject).onViewRecycled(paramB0);
      }
      localObject = RecyclerView.this;
      if (mState != null) {
        mViewInfoStore.removeViewHolder(paramB0);
      }
    }
    
    void get(int paramInt)
    {
      a((RecyclerView.b0)mCachedViews.get(paramInt), true);
      mCachedViews.remove(paramInt);
    }
    
    RecyclerView.b0 getChangedScrapViewForPosition(int paramInt)
    {
      Object localObject = mChangedScrap;
      u localU = this;
      if (localObject != null)
      {
        int k = ((ArrayList)localObject).size();
        if (k == 0) {
          return null;
        }
        int j = 0;
        int i = 0;
        while (i < k)
        {
          localObject = mChangedScrap;
          localObject = (RecyclerView.b0)((ArrayList)localObject).get(i);
          if ((!((RecyclerView.b0)localObject).wasReturnedFromScrap()) && (((RecyclerView.b0)localObject).getLayoutPosition() == paramInt))
          {
            ((RecyclerView.b0)localObject).addFlags(32);
            return localObject;
          }
          i += 1;
        }
        if (this$0.mAdapter.hasStableIds())
        {
          paramInt = this$0.mAdapterHelper.findPositionOffset(paramInt);
          if ((paramInt > 0) && (paramInt < this$0.mAdapter.getItemCount()))
          {
            long l = this$0.mAdapter.getItemId(paramInt);
            paramInt = j;
            while (paramInt < k)
            {
              localObject = mChangedScrap;
              localObject = (RecyclerView.b0)((ArrayList)localObject).get(paramInt);
              if ((!((RecyclerView.b0)localObject).wasReturnedFromScrap()) && (((RecyclerView.b0)localObject).getItemId() == l))
              {
                ((RecyclerView.b0)localObject).addFlags(32);
                return localObject;
              }
              paramInt += 1;
            }
          }
        }
      }
      return null;
    }
    
    RecyclerView.t getRecycledViewPool()
    {
      if (mRecyclerPool == null) {
        mRecyclerPool = new RecyclerView.t();
      }
      return mRecyclerPool;
    }
    
    int getScrapCount()
    {
      return mAttachedScrap.size();
    }
    
    public List getScrapList()
    {
      return mUnmodifiableAttachedScrap;
    }
    
    View getScrapViewAt(int paramInt)
    {
      return mAttachedScrap.get(paramInt)).itemView;
    }
    
    RecyclerView.b0 getScrapViewForId(long paramLong, int paramInt, boolean paramBoolean)
    {
      Object localObject2 = mAttachedScrap;
      Object localObject1 = this;
      int i = ((ArrayList)localObject2).size() - 1;
      Object localObject3;
      while (i >= 0)
      {
        localObject3 = mAttachedScrap;
        localObject2 = localObject1;
        localObject3 = (RecyclerView.b0)((ArrayList)localObject3).get(i);
        if ((((RecyclerView.b0)localObject3).getItemId() == paramLong) && (!((RecyclerView.b0)localObject3).wasReturnedFromScrap()))
        {
          if (paramInt == ((RecyclerView.b0)localObject3).getItemViewType())
          {
            ((RecyclerView.b0)localObject3).addFlags(32);
            localObject1 = localObject3;
            if (!((RecyclerView.b0)localObject3).isRemoved()) {
              break label297;
            }
            localObject1 = localObject3;
            if (this$0.mState.isPreLayout()) {
              break label297;
            }
            ((RecyclerView.b0)localObject3).setFlags(2, 14);
            return localObject3;
          }
          if (!paramBoolean)
          {
            ArrayList localArrayList = mAttachedScrap;
            localArrayList.remove(i);
            this$0.removeDetachedView(itemView, false);
            ((u)localObject2).quickRecycleScrapView(itemView);
          }
        }
        i -= 1;
      }
      localObject2 = mCachedViews;
      i = ((ArrayList)localObject2).size() - 1;
      while (i >= 0)
      {
        localObject3 = mCachedViews;
        localObject2 = localObject1;
        localObject3 = (RecyclerView.b0)((ArrayList)localObject3).get(i);
        if ((((RecyclerView.b0)localObject3).getItemId() == paramLong) && (!((RecyclerView.b0)localObject3).isAttachedToTransitionOverlay()))
        {
          if (paramInt == ((RecyclerView.b0)localObject3).getItemViewType())
          {
            localObject1 = localObject3;
            if (paramBoolean) {
              break label297;
            }
            mCachedViews.remove(i);
            return localObject3;
          }
          if (!paramBoolean)
          {
            ((u)localObject2).get(i);
            return null;
          }
        }
        i -= 1;
        localObject1 = localObject2;
      }
      return null;
      label297:
      return localObject1;
    }
    
    RecyclerView.b0 getScrapViewForPosition(int paramInt, boolean paramBoolean)
    {
      int k = mAttachedScrap.size();
      int j = 0;
      int i = 0;
      RecyclerView.b0 localB0;
      while (i < k)
      {
        localB0 = (RecyclerView.b0)mAttachedScrap.get(i);
        if ((!localB0.wasReturnedFromScrap()) && (localB0.getLayoutPosition() == paramInt) && (!localB0.isInvalid()) && ((mState.mInPreLayout) || (!localB0.isRemoved())))
        {
          localB0.addFlags(32);
          return localB0;
        }
        i += 1;
      }
      if (!paramBoolean)
      {
        Object localObject = mChildHelper.findHiddenNonRemovedView(paramInt);
        if (localObject != null)
        {
          localB0 = RecyclerView.getChildViewHolderInt((View)localObject);
          mChildHelper.unhide((View)localObject);
          paramInt = mChildHelper.indexOfChild((View)localObject);
          if (paramInt != -1)
          {
            mChildHelper.detachViewFromParent(paramInt);
            scrapView((View)localObject);
            localB0.addFlags(8224);
            return localB0;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("layout index should not be -1 after unhiding a view:");
          ((StringBuilder)localObject).append(localB0);
          ((StringBuilder)localObject).append(append());
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
      k = mCachedViews.size();
      i = j;
      while (i < k)
      {
        localB0 = (RecyclerView.b0)mCachedViews.get(i);
        if ((!localB0.isInvalid()) && (localB0.getLayoutPosition() == paramInt) && (!localB0.isAttachedToTransitionOverlay()))
        {
          if (paramBoolean) {
            break label316;
          }
          mCachedViews.remove(i);
          return localB0;
        }
        i += 1;
      }
      return null;
      label316:
      return localB0;
    }
    
    public View getViewForPosition(int paramInt)
    {
      return getViewForPosition(paramInt, false);
    }
    
    View getViewForPosition(int paramInt, boolean paramBoolean)
    {
      return getViewForPositionMAX_VALUEitemView;
    }
    
    RecyclerView.b0 getViewForPosition(int paramInt, boolean paramBoolean, long paramLong)
    {
      if ((paramInt >= 0) && (paramInt < mState.getItemCount()))
      {
        boolean bool2 = mState.isPreLayout();
        boolean bool1 = true;
        Object localObject3;
        if (bool2)
        {
          localObject3 = getChangedScrapViewForPosition(paramInt);
          localObject1 = localObject3;
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            j = 1;
            localObject2 = localObject1;
            break label74;
          }
        }
        else
        {
          localObject2 = null;
        }
        int j = 0;
        label74:
        int i = j;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject3 = getScrapViewForPosition(paramInt, paramBoolean);
          localObject2 = localObject3;
          i = j;
          localObject1 = localObject2;
          if (localObject3 != null) {
            if (!validateViewHolderForOffsetPosition((RecyclerView.b0)localObject3))
            {
              if (!paramBoolean)
              {
                ((RecyclerView.b0)localObject3).addFlags(4);
                if (((RecyclerView.b0)localObject3).isScrap())
                {
                  removeDetachedView(itemView, false);
                  ((RecyclerView.b0)localObject3).unScrap();
                }
                else if (((RecyclerView.b0)localObject3).wasReturnedFromScrap())
                {
                  ((RecyclerView.b0)localObject3).clearReturnedFromScrapFlag();
                }
                recycleViewHolderInternal((RecyclerView.b0)localObject3);
              }
              localObject1 = null;
              i = j;
            }
            else
            {
              i = 1;
              localObject1 = localObject2;
            }
          }
        }
        int k = i;
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          k = mAdapterHelper.findPositionOffset(paramInt);
          if ((k >= 0) && (k < mAdapter.getItemCount()))
          {
            int m = mAdapter.getItemViewType(k);
            j = i;
            if (mAdapter.hasStableIds())
            {
              localObject3 = getScrapViewForId(mAdapter.getItemId(k), m, paramBoolean);
              localObject2 = localObject3;
              j = i;
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                mPosition = k;
                j = 1;
                localObject1 = localObject2;
              }
            }
            if ((localObject1 == null) && (mListView != null)) {
              throw new NullPointerException("Null throw statement replaced by Soot");
            }
            localObject3 = localObject1;
            if (localObject1 == null)
            {
              localObject1 = getRecycledViewPool().onCreateViewHolder(m);
              localObject3 = localObject1;
              if (localObject1 != null)
              {
                ((RecyclerView.b0)localObject1).resetInternal();
                localObject3 = localObject1;
                if (RecyclerView.y)
                {
                  setFrom((RecyclerView.b0)localObject1);
                  localObject3 = localObject1;
                }
              }
            }
            k = j;
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              long l1 = getNanoTime();
              if ((paramLong != Long.MAX_VALUE) && (!mRecyclerPool.get(m, l1, paramLong))) {
                return null;
              }
              localObject1 = RecyclerView.this;
              localObject2 = mAdapter.createViewHolder((ViewGroup)localObject1, m);
              if (RecyclerView.itemView)
              {
                localObject1 = RecyclerView.a(itemView);
                if (localObject1 != null) {
                  mNestedRecyclerView = new WeakReference(localObject1);
                }
              }
              long l2 = getNanoTime();
              mRecyclerPool.append(m, l2 - l1);
              k = j;
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Inconsistency detected. Invalid item position ");
            ((StringBuilder)localObject1).append(paramInt);
            ((StringBuilder)localObject1).append("(offset:");
            ((StringBuilder)localObject1).append(k);
            ((StringBuilder)localObject1).append(").state:");
            ((StringBuilder)localObject1).append(mState.getItemCount());
            ((StringBuilder)localObject1).append(append());
            throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
          }
        }
        if ((k != 0) && (!mState.isPreLayout()) && (((RecyclerView.b0)localObject2).hasAnyOfTheFlags(8192)))
        {
          ((RecyclerView.b0)localObject2).setFlags(0, 8192);
          if (mState.mRunSimpleAnimations)
          {
            i = RecyclerView.l.buildAdapterChangeFlagsForAnimations((RecyclerView.b0)localObject2);
            localObject1 = RecyclerView.this;
            localObject1 = mItemAnimator.recordPreLayoutInformation(mState, (RecyclerView.b0)localObject2, i | 0x1000, ((RecyclerView.b0)localObject2).getUnmodifiedPayloads());
            recordAnimationInfoIfBouncedHiddenView((RecyclerView.b0)localObject2, (RecyclerView.l.c)localObject1);
          }
        }
        if ((mState.isPreLayout()) && (((RecyclerView.b0)localObject2).isBound())) {
          mPreLayoutPosition = paramInt;
        } else {
          if ((!((RecyclerView.b0)localObject2).isBound()) || (((RecyclerView.b0)localObject2).needsUpdate()) || (((RecyclerView.b0)localObject2).isInvalid())) {
            break label795;
          }
        }
        paramBoolean = false;
        break label815;
        label795:
        paramBoolean = updateContent((RecyclerView.b0)localObject2, mAdapterHelper.findPositionOffset(paramInt), paramInt, paramLong);
        label815:
        localObject1 = itemView.getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = (RecyclerView.LayoutParams)generateDefaultLayoutParams();
          itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        else if (!checkLayoutParams((ViewGroup.LayoutParams)localObject1))
        {
          localObject1 = (RecyclerView.LayoutParams)generateLayoutParams((ViewGroup.LayoutParams)localObject1);
          itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        else
        {
          localObject1 = (RecyclerView.LayoutParams)localObject1;
        }
        mViewHolder = ((RecyclerView.b0)localObject2);
        if ((k != 0) && (paramBoolean)) {
          paramBoolean = bool1;
        } else {
          paramBoolean = false;
        }
        mPendingInvalidate = paramBoolean;
        return localObject2;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Invalid item position ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("). Item count:");
      ((StringBuilder)localObject1).append(mState.getItemCount());
      ((StringBuilder)localObject1).append(append());
      throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
    }
    
    void markItemDecorInsetsDirty()
    {
      int j = mCachedViews.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)mCachedViews.get(i)).itemView.getLayoutParams();
        if (localLayoutParams != null) {
          mInsetsDirty = true;
        }
        i += 1;
      }
    }
    
    void markKnownViewsInvalid()
    {
      int j = mCachedViews.size();
      int i = 0;
      while (i < j)
      {
        localObject = (RecyclerView.b0)mCachedViews.get(i);
        if (localObject != null)
        {
          ((RecyclerView.b0)localObject).addFlags(6);
          ((RecyclerView.b0)localObject).addChangePayload(null);
        }
        i += 1;
      }
      Object localObject = mAdapter;
      if ((localObject == null) || (!((RecyclerView.Adapter)localObject).hasStableIds())) {
        update();
      }
    }
    
    void next()
    {
      RecyclerView.o localO = mLayout;
      if (localO != null) {
        i = b;
      } else {
        i = 0;
      }
      itemView = (mViewCacheMax + i);
      int i = mCachedViews.size() - 1;
      while ((i >= 0) && (mCachedViews.size() > itemView))
      {
        get(i);
        i -= 1;
      }
    }
    
    void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
    {
      int j = mCachedViews.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.b0 localB0 = (RecyclerView.b0)mCachedViews.get(i);
        if ((localB0 != null) && (mPosition >= paramInt1)) {
          localB0.offsetPosition(paramInt2, false);
        }
        i += 1;
      }
    }
    
    void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
    {
      int i;
      int j;
      int k;
      if (paramInt1 < paramInt2)
      {
        i = -1;
        j = paramInt1;
        k = paramInt2;
      }
      else
      {
        i = 1;
        k = paramInt1;
        j = paramInt2;
      }
      int n = mCachedViews.size();
      int m = 0;
      while (m < n)
      {
        RecyclerView.b0 localB0 = (RecyclerView.b0)mCachedViews.get(m);
        if (localB0 != null)
        {
          int i1 = mPosition;
          if ((i1 >= j) && (i1 <= k)) {
            if (i1 == paramInt1) {
              localB0.offsetPosition(paramInt2 - paramInt1, false);
            } else {
              localB0.offsetPosition(i, false);
            }
          }
        }
        m += 1;
      }
    }
    
    void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int i = mCachedViews.size() - 1;
      while (i >= 0)
      {
        RecyclerView.b0 localB0 = (RecyclerView.b0)mCachedViews.get(i);
        if (localB0 != null)
        {
          int j = mPosition;
          if (j >= paramInt1 + paramInt2)
          {
            localB0.offsetPosition(-paramInt2, paramBoolean);
          }
          else if (j >= paramInt1)
          {
            localB0.addFlags(8);
            get(i);
          }
        }
        i -= 1;
      }
    }
    
    void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
    {
      clear();
      getRecycledViewPool().onAdapterChanged(paramAdapter1, paramAdapter2, paramBoolean);
    }
    
    void quickRecycleScrapView(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      mScrapContainer = null;
      mInChangeScrap = false;
      paramView.clearReturnedFromScrapFlag();
      recycleViewHolderInternal(paramView);
    }
    
    public void recycleView(View paramView)
    {
      RecyclerView.b0 localB0 = RecyclerView.getChildViewHolderInt(paramView);
      if (localB0.isTmpDetached()) {
        removeDetachedView(paramView, false);
      }
      if (localB0.isScrap()) {
        localB0.unScrap();
      } else if (localB0.wasReturnedFromScrap()) {
        localB0.clearReturnedFromScrapFlag();
      }
      recycleViewHolderInternal(localB0);
      if ((mItemAnimator != null) && (!localB0.isRecyclable())) {
        mItemAnimator.endAnimation(localB0);
      }
    }
    
    void recycleViewHolderInternal(RecyclerView.b0 paramB0)
    {
      boolean bool2 = paramB0.isScrap();
      boolean bool1 = false;
      int j = 0;
      int k = 1;
      Object localObject;
      if ((!bool2) && (itemView.getParent() == null))
      {
        if (!paramB0.isTmpDetached())
        {
          if (!paramB0.shouldIgnore())
          {
            bool1 = paramB0.doesTransientStatePreventRecycling();
            localObject = mAdapter;
            int i;
            if ((localObject != null) && (bool1) && (((RecyclerView.Adapter)localObject).onFailedToRecycleView(paramB0))) {
              i = 1;
            } else {
              i = 0;
            }
            if ((i == 0) && (!paramB0.isRecyclable()))
            {
              k = 0;
              i = j;
              j = k;
            }
            else
            {
              if ((itemView > 0) && (!paramB0.hasAnyOfTheFlags(526)))
              {
                int m = mCachedViews.size();
                j = m;
                i = j;
                if (m >= itemView)
                {
                  i = j;
                  if (m > 0)
                  {
                    get(0);
                    i = m - 1;
                  }
                }
                j = i;
                if (RecyclerView.itemView)
                {
                  j = i;
                  if (i > 0)
                  {
                    j = i;
                    if (!h.a(mPosition))
                    {
                      i -= 1;
                      while (i >= 0)
                      {
                        j = mCachedViews.get(i)).mPosition;
                        if (!h.a(j)) {
                          break;
                        }
                        i -= 1;
                      }
                      j = i + 1;
                    }
                  }
                }
                mCachedViews.add(j, paramB0);
                i = 1;
              }
              else
              {
                i = 0;
              }
              if (i == 0)
              {
                a(paramB0, true);
                j = k;
              }
              else
              {
                j = 0;
              }
            }
            mViewInfoStore.removeViewHolder(paramB0);
            if ((i == 0) && (j == 0) && (bool1))
            {
              mBindingAdapter = null;
              mOwnerRecyclerView = null;
            }
          }
          else
          {
            paramB0 = new StringBuilder();
            paramB0.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            paramB0.append(append());
            throw new IllegalArgumentException(paramB0.toString());
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
          ((StringBuilder)localObject).append(paramB0);
          ((StringBuilder)localObject).append(append());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Scrapped or attached views may not be recycled. isScrap:");
        ((StringBuilder)localObject).append(paramB0.isScrap());
        ((StringBuilder)localObject).append(" isAttached:");
        if (itemView.getParent() != null) {
          bool1 = true;
        }
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(append());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    
    void scrapView(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      if ((!paramView.hasAnyOfTheFlags(12)) && (paramView.isUpdated()) && (!canReuseUpdatedViewHolder(paramView)))
      {
        if (mChangedScrap == null) {
          mChangedScrap = new ArrayList();
        }
        paramView.setScrapContainer(this, true);
        mChangedScrap.add(paramView);
        return;
      }
      if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!mAdapter.hasStableIds()))
      {
        paramView = new StringBuilder();
        paramView.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        paramView.append(append());
        throw new IllegalArgumentException(paramView.toString());
      }
      paramView.setScrapContainer(this, false);
      mAttachedScrap.add(paramView);
    }
    
    void setRecycledViewPool(RecyclerView.t paramT)
    {
      RecyclerView.t localT = mRecyclerPool;
      if (localT != null) {
        localT.detach();
      }
      mRecyclerPool = paramT;
      if ((paramT != null) && (getAdapter() != null)) {
        mRecyclerPool.attach();
      }
    }
    
    void setViewCacheExtension(RecyclerView.z paramZ) {}
    
    public void setViewCacheSize(int paramInt)
    {
      mViewCacheMax = paramInt;
      next();
    }
    
    void unscrapView(RecyclerView.b0 paramB0)
    {
      if (mInChangeScrap) {
        mChangedScrap.remove(paramB0);
      } else {
        mAttachedScrap.remove(paramB0);
      }
      mScrapContainer = null;
      mInChangeScrap = false;
      paramB0.clearReturnedFromScrapFlag();
    }
    
    void update()
    {
      int i = mCachedViews.size() - 1;
      while (i >= 0)
      {
        get(i);
        i -= 1;
      }
      mCachedViews.clear();
      if (RecyclerView.itemView) {
        h.set();
      }
    }
    
    boolean validateViewHolderForOffsetPosition(RecyclerView.b0 paramB0)
    {
      if (paramB0.isRemoved()) {
        return mState.isPreLayout();
      }
      int i = mPosition;
      if ((i >= 0) && (i < mAdapter.getItemCount()))
      {
        if ((!mState.isPreLayout()) && (mAdapter.getItemViewType(mPosition) != paramB0.getItemViewType())) {
          return false;
        }
        if ((!mAdapter.hasStableIds()) || (paramB0.getItemId() == mAdapter.getItemId(mPosition))) {
          return true;
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
        localStringBuilder.append(paramB0);
        localStringBuilder.append(append());
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      return false;
    }
    
    void viewRangeUpdate(int paramInt1, int paramInt2)
    {
      int i = mCachedViews.size() - 1;
      while (i >= 0)
      {
        RecyclerView.b0 localB0 = (RecyclerView.b0)mCachedViews.get(i);
        if (localB0 != null)
        {
          int j = mPosition;
          if ((j >= paramInt1) && (j < paramInt2 + paramInt1))
          {
            localB0.addFlags(2);
            get(i);
          }
        }
        i -= 1;
      }
    }
  }
  
  public static abstract interface v
  {
    public abstract void trim(RecyclerView.b0 paramB0);
  }
  
  private class w
    extends RecyclerView.i
  {
    w() {}
    
    public void onChanged()
    {
      a(null);
      RecyclerView localRecyclerView = RecyclerView.this;
      mState.mStructureChanged = true;
      localRecyclerView.setAdapterInternal(true);
      if (!mAdapterHelper.hasPendingUpdates()) {
        requestLayout();
      }
    }
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      a(null);
      if (mAdapterHelper.onItemRangeChanged(paramInt1, paramInt2, paramObject)) {
        triggerUpdateProcessor();
      }
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      a(null);
      if (mAdapterHelper.onItemRangeInserted(paramInt1, paramInt2)) {
        triggerUpdateProcessor();
      }
    }
    
    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      a(null);
      if (mAdapterHelper.onItemRangeMoved(paramInt1, paramInt2, paramInt3)) {
        triggerUpdateProcessor();
      }
    }
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      a(null);
      if (mAdapterHelper.onItemRangeRemoved(paramInt1, paramInt2)) {
        triggerUpdateProcessor();
      }
    }
    
    void triggerUpdateProcessor()
    {
      if (RecyclerView.c)
      {
        localRecyclerView = RecyclerView.this;
        if ((mHasFixedSize) && (mIsAttached))
        {
          ViewCompat.postOnAnimation(localRecyclerView, mUpdateChildViewsRunnable);
          return;
        }
      }
      RecyclerView localRecyclerView = RecyclerView.this;
      mAdapterUpdateDuringMeasure = true;
      localRecyclerView.requestLayout();
    }
  }
  
  public static abstract class x
  {
    private boolean d;
    private RecyclerView.o f;
    private View g;
    private boolean h;
    private int i = -1;
    private RecyclerView mRecyclerView;
    private final a o = new a(0, 0);
    private boolean t;
    
    public x() {}
    
    public int a(View paramView)
    {
      return mRecyclerView.getChildLayoutPosition(paramView);
    }
    
    public PointF a(int paramInt)
    {
      Object localObject = getLayoutManager();
      if ((localObject instanceof b)) {
        return ((b)localObject).onSaveInstanceState(paramInt);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
      ((StringBuilder)localObject).append(b.class.getCanonicalName());
      android.util.Log.w("RecyclerView", ((StringBuilder)localObject).toString());
      return null;
    }
    
    void a(int paramInt1, int paramInt2)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      if ((i == -1) || (localRecyclerView == null)) {
        e();
      }
      if ((h) && (g == null) && (f != null))
      {
        localObject = a(i);
        if (localObject != null)
        {
          float f1 = x;
          if ((f1 != 0.0F) || (y != 0.0F)) {
            localRecyclerView.scrollByInternal((int)Math.signum(f1), (int)Math.signum(y), null);
          }
        }
      }
      h = false;
      Object localObject = g;
      if (localObject != null) {
        if (a((View)localObject) == i)
        {
          onTargetFound(g, mState, o);
          o.runIfNecessary(localRecyclerView);
          e();
        }
        else
        {
          android.util.Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
          g = null;
        }
      }
      if (d)
      {
        onSeekTargetStep(paramInt1, paramInt2, mState, o);
        boolean bool = o.b();
        o.runIfNecessary(localRecyclerView);
        if ((bool) && (d))
        {
          h = true;
          mViewFlinger.d();
        }
      }
    }
    
    protected void b(View paramView)
    {
      if (a(paramView) == intValue()) {
        g = paramView;
      }
    }
    
    public void d(int paramInt)
    {
      i = paramInt;
    }
    
    public boolean d()
    {
      return h;
    }
    
    protected final void e()
    {
      if (!d) {
        return;
      }
      d = false;
      updateActionForInterimTarget();
      mRecyclerView.mState.h = -1;
      g = null;
      i = -1;
      h = false;
      f.write(this);
      f = null;
      mRecyclerView = null;
    }
    
    public View findViewByPosition(int paramInt)
    {
      return mRecyclerView.mLayout.findViewByPosition(paramInt);
    }
    
    public int getChildCount()
    {
      return mRecyclerView.mLayout.getChildCount();
    }
    
    public RecyclerView.o getLayoutManager()
    {
      return f;
    }
    
    public int intValue()
    {
      return i;
    }
    
    protected void normalize(PointF paramPointF)
    {
      float f1 = x;
      float f2 = y;
      f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      x /= f1;
      y /= f1;
    }
    
    protected abstract void onSeekTargetStep(int paramInt1, int paramInt2, RecyclerView.y paramY, a paramA);
    
    protected abstract void onStart();
    
    protected abstract void onTargetFound(View paramView, RecyclerView.y paramY, a paramA);
    
    public boolean s()
    {
      return d;
    }
    
    void start(RecyclerView paramRecyclerView, RecyclerView.o paramO)
    {
      mViewFlinger.stop();
      if (t)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("An instance of ");
        localStringBuilder.append(getClass().getSimpleName());
        localStringBuilder.append(" was started more than once. Each instance of");
        localStringBuilder.append(getClass().getSimpleName());
        localStringBuilder.append(" is intended to only be used once. You should create a new instance for each use.");
        android.util.Log.w("RecyclerView", localStringBuilder.toString());
      }
      mRecyclerView = paramRecyclerView;
      f = paramO;
      int j = i;
      if (j != -1)
      {
        mState.h = j;
        d = true;
        h = true;
        g = findViewByPosition(intValue());
        onStart();
        mRecyclerView.mViewFlinger.d();
        t = true;
        return;
      }
      throw new IllegalArgumentException("Invalid target position");
    }
    
    protected abstract void updateActionForInterimTarget();
    
    public static class a
    {
      private boolean changed = false;
      private int consecutiveUpdates = 0;
      private int mDuration;
      private int mDx;
      private int mDy;
      private Interpolator mInterpolator;
      private int mJumpToPosition = -1;
      
      public a(int paramInt1, int paramInt2)
      {
        this(paramInt1, paramInt2, Integer.MIN_VALUE, null);
      }
      
      public a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        mDx = paramInt1;
        mDy = paramInt2;
        mDuration = paramInt3;
        mInterpolator = paramInterpolator;
      }
      
      private void validate()
      {
        if ((mInterpolator != null) && (mDuration < 1)) {
          throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (mDuration >= 1) {
          return;
        }
        throw new IllegalStateException("Scroll duration must be a positive number");
      }
      
      boolean b()
      {
        return mJumpToPosition >= 0;
      }
      
      public void jumpTo(int paramInt)
      {
        mJumpToPosition = paramInt;
      }
      
      void runIfNecessary(RecyclerView paramRecyclerView)
      {
        int i = mJumpToPosition;
        if (i >= 0)
        {
          mJumpToPosition = -1;
          paramRecyclerView.smoothScrollBy(i);
          changed = false;
          return;
        }
        if (changed)
        {
          validate();
          mViewFlinger.smoothScrollBy(mDx, mDy, mDuration, mInterpolator);
          i = consecutiveUpdates + 1;
          consecutiveUpdates = i;
          if (i > 10) {
            android.util.Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
          }
          changed = false;
          return;
        }
        consecutiveUpdates = 0;
      }
      
      public void update(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        mDx = paramInt1;
        mDy = paramInt2;
        mDuration = paramInt3;
        mInterpolator = paramInterpolator;
        changed = true;
      }
    }
    
    public static abstract interface b
    {
      public abstract PointF onSaveInstanceState(int paramInt);
    }
  }
  
  public static class y
  {
    int h = -1;
    int left;
    int mCoordOffset;
    private SparseArray<Object> mData;
    int mDeletedInvisibleItemCountSincePreviousLayout = 0;
    int mDragPoint;
    boolean mInPreLayout = false;
    boolean mIsMeasuring = false;
    int mItemCount = 0;
    int mLayoutStep = 1;
    int mPosition;
    int mPreviousLayoutItemCount = 0;
    boolean mRunPredictiveAnimations = false;
    boolean mRunSimpleAnimations = false;
    long mState;
    boolean mStructureChanged = false;
    boolean mTrackOldChangeHolders = false;
    
    public y() {}
    
    void assertLayoutStep(int paramInt)
    {
      if ((mLayoutStep & paramInt) != 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Layout state should be one of ");
      localStringBuilder.append(Integer.toBinaryString(paramInt));
      localStringBuilder.append(" but it is ");
      localStringBuilder.append(Integer.toBinaryString(mLayoutStep));
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    public boolean b()
    {
      return h != -1;
    }
    
    public int c()
    {
      return h;
    }
    
    void dispatchLayoutStep1(RecyclerView.Adapter paramAdapter)
    {
      mLayoutStep = 1;
      mItemCount = paramAdapter.getItemCount();
      mInPreLayout = false;
      mTrackOldChangeHolders = false;
      mIsMeasuring = false;
    }
    
    public int getItemCount()
    {
      if (mInPreLayout) {
        return mPreviousLayoutItemCount - mDeletedInvisibleItemCountSincePreviousLayout;
      }
      return mItemCount;
    }
    
    public boolean isPreLayout()
    {
      return mInPreLayout;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("State{mTargetPosition=");
      localStringBuilder.append(h);
      localStringBuilder.append(", mData=");
      localStringBuilder.append(mData);
      localStringBuilder.append(", mItemCount=");
      localStringBuilder.append(mItemCount);
      localStringBuilder.append(", mIsMeasuring=");
      localStringBuilder.append(mIsMeasuring);
      localStringBuilder.append(", mPreviousLayoutItemCount=");
      localStringBuilder.append(mPreviousLayoutItemCount);
      localStringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
      localStringBuilder.append(mDeletedInvisibleItemCountSincePreviousLayout);
      localStringBuilder.append(", mStructureChanged=");
      localStringBuilder.append(mStructureChanged);
      localStringBuilder.append(", mInPreLayout=");
      localStringBuilder.append(mInPreLayout);
      localStringBuilder.append(", mRunSimpleAnimations=");
      localStringBuilder.append(mRunSimpleAnimations);
      localStringBuilder.append(", mRunPredictiveAnimations=");
      localStringBuilder.append(mRunPredictiveAnimations);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public boolean willRunPredictiveAnimations()
    {
      return mRunPredictiveAnimations;
    }
  }
  
  public static abstract class z {}
}
