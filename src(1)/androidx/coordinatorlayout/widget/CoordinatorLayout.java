package androidx.coordinatorlayout.widget;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import c.h.p.e;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import v7.appcompat.R.styleable;
import v7.appcompat.StandardShowcaseDrawer;
import v7.appcompat.TextDrawer;
import v7.v7.package_13.CoordinatorLayout.LayoutParams;
import v7.v7.package_13.GravityCompat;
import v7.v7.package_13.MethodVisitor;
import v7.v7.package_13.NestedScrollingParentHelper;
import v7.v7.package_13.ViewCompat;
import v7.v7.util.Pools.Pool;
import v7.v7.util.Pools.SynchronizedPool;

public class CoordinatorLayout
  extends ViewGroup
  implements CoordinatorLayout.LayoutParams, v7.v7.package_13.Object
{
  static final Class<?>[] CONSTRUCTOR_PARAMS;
  static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
  static final String WIDGET_PACKAGE_NAME;
  private static final e<Rect> lock = new Pools.SynchronizedPool(12);
  static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
  private MethodVisitor a;
  private final a<View> c = new f();
  private final List<View> data = new ArrayList();
  private final int[] h = new int[2];
  private View mBehaviorTouchView;
  private boolean mDisallowInterceptReset;
  private boolean mDrawStatusBarBackground;
  private boolean mIsAttachedToWindow;
  private int[] mKeylines;
  private v7.v7.package_13.f mLastInsets;
  private boolean mNeedsPreDrawListener;
  private final NestedScrollingParentHelper mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
  private View mNestedScrollingTarget;
  ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
  private f mOnPreDrawListener;
  private Paint mScrimPaint;
  private Drawable mStatusBarBackground;
  private final List<View> mTempList1 = new ArrayList();
  private final List<View> x = new ArrayList();
  private final int[] y = new int[2];
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null) {
      localObject = ((Package)localObject).getName();
    } else {
      localObject = null;
    }
    WIDGET_PACKAGE_NAME = (String)localObject;
    if (Build.VERSION.SDK_INT >= 21) {
      TOP_SORTED_CHILDREN_COMPARATOR = new g();
    } else {
      TOP_SORTED_CHILDREN_COMPARATOR = null;
    }
    CONSTRUCTOR_PARAMS = new Class[] { android.content.Context.class, AttributeSet.class };
    sConstructors = new ThreadLocal();
  }
  
  public CoordinatorLayout(android.content.Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, StandardShowcaseDrawer.a);
  }
  
  public CoordinatorLayout(android.content.Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int i = 0;
    TypedArray localTypedArray;
    if (paramInt == 0) {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.c, 0, TextDrawer.a);
    } else {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.c, paramInt, 0);
    }
    if (Build.VERSION.SDK_INT >= 29) {
      if (paramInt == 0) {
        saveAttributeDataForStyleable(paramContext, R.styleable.c, paramAttributeSet, localTypedArray, 0, TextDrawer.a);
      } else {
        saveAttributeDataForStyleable(paramContext, R.styleable.c, paramAttributeSet, localTypedArray, paramInt, 0);
      }
    }
    paramInt = localTypedArray.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getResources();
      mKeylines = paramContext.getIntArray(paramInt);
      float f = getDisplayMetricsdensity;
      int j = mKeylines.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = mKeylines;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
        paramInt += 1;
      }
    }
    mStatusBarBackground = localTypedArray.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
    localTypedArray.recycle();
    b();
    super.setOnHierarchyChangeListener(new d());
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.get(this, 1);
    }
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (ViewCompat.getFitsSystemWindows(this))
    {
      if (a == null) {
        a = new a();
      }
      ViewCompat.b(this, a);
      setSystemUiVisibility(1280);
      return;
    }
    ViewCompat.b(this, null);
  }
  
  private static int constrain(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  private static void decode(Rect paramRect)
  {
    paramRect.setEmpty();
    lock.release(paramRect);
  }
  
  private v7.v7.package_13.f dispatchApplyWindowInsetsToBehaviors(v7.v7.package_13.f paramF)
  {
    if (paramF.isConsumed()) {
      return paramF;
    }
    int i = 0;
    int j = getChildCount();
    for (v7.v7.package_13.f localF = paramF; i < j; localF = paramF)
    {
      View localView = getChildAt(i);
      paramF = localF;
      if (ViewCompat.getFitsSystemWindows(localView))
      {
        Behavior localBehavior = ((e)localView.getLayoutParams()).getBehavior();
        paramF = localF;
        if (localBehavior != null)
        {
          localF = localBehavior.onApplyWindowInsets(this, localView, localF);
          paramF = localF;
          if (localF.isConsumed()) {
            return localF;
          }
        }
      }
      i += 1;
    }
    return localF;
  }
  
  private static Rect get()
  {
    Rect localRect2 = (Rect)lock.acquire();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    return localRect1;
  }
  
  private void getDesiredAnchoredChildRect(View paramView, int paramInt1, Rect paramRect1, Rect paramRect2, e paramE, int paramInt2, int paramInt3)
  {
    int i = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(gravity), paramInt1);
    paramInt1 = GravityCompat.getAbsoluteGravity(resolveGravity(anchorGravity), paramInt1);
    int m = i & 0x7;
    int k = i & 0x70;
    int j = paramInt1 & 0x7;
    i = paramInt1 & 0x70;
    if (j != 1)
    {
      if (j != 5) {
        paramInt1 = left;
      } else {
        paramInt1 = right;
      }
    }
    else {
      paramInt1 = left + paramRect1.width() / 2;
    }
    if (i != 16)
    {
      if (i != 80) {
        i = top;
      } else {
        i = bottom;
      }
    }
    else {
      i = top + paramRect1.height() / 2;
    }
    if (m != 1)
    {
      j = paramInt1;
      if (m != 5) {
        j = paramInt1 - paramInt2;
      }
    }
    else
    {
      j = paramInt1 - paramInt2 / 2;
    }
    if (k != 16)
    {
      paramInt1 = i;
      if (k != 80) {
        paramInt1 = i - paramInt3;
      }
    }
    else
    {
      paramInt1 = i - paramInt3 / 2;
    }
    paramRect2.set(j, paramInt1, paramInt2 + j, paramInt3 + paramInt1);
  }
  
  private void getDesiredAnchoredChildRect(e paramE, Rect paramRect, int paramInt1, int paramInt2)
  {
    int j = getWidth();
    int i = getHeight();
    j = Math.max(getPaddingLeft() + leftMargin, Math.min(left, j - getPaddingRight() - paramInt1 - rightMargin));
    i = Math.max(getPaddingTop() + topMargin, Math.min(top, i - getPaddingBottom() - paramInt2 - bottomMargin));
    paramRect.set(j, i, paramInt1 + j, paramInt2 + i);
  }
  
  private int getKeyline(int paramInt)
  {
    Object localObject = mKeylines;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No keylines defined for ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" - attempted index lookup ");
      ((StringBuilder)localObject).append(paramInt);
      Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString());
      return 0;
    }
    if ((paramInt >= 0) && (paramInt < localObject.length)) {
      return localObject[paramInt];
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Keyline index ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" out of range for ");
    ((StringBuilder)localObject).append(this);
    Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString());
    return 0;
  }
  
  private void getTopSortedChildren(List paramList)
  {
    paramList.clear();
    boolean bool = isChildrenDrawingOrderEnabled();
    int k = getChildCount();
    int i = k - 1;
    while (i >= 0)
    {
      int j;
      if (bool) {
        j = getChildDrawingOrder(k, i);
      } else {
        j = i;
      }
      paramList.add(getChildAt(j));
      i -= 1;
    }
    Comparator localComparator = TOP_SORTED_CHILDREN_COMPARATOR;
    if (localComparator != null) {
      Collections.sort(paramList, localComparator);
    }
  }
  
  private boolean hasDependencies(View paramView)
  {
    return c.a(paramView);
  }
  
  private void layout(View paramView, int paramInt)
  {
    e localE = (e)paramView.getLayoutParams();
    int i = height;
    if (i != paramInt)
    {
      ViewCompat.offsetLeftAndRight(paramView, paramInt - i);
      height = paramInt;
    }
  }
  
  private void layoutChild(View paramView, int paramInt)
  {
    e localE = (e)paramView.getLayoutParams();
    Rect localRect1 = get();
    localRect1.set(getPaddingLeft() + leftMargin, getPaddingTop() + topMargin, getWidth() - getPaddingRight() - rightMargin, getHeight() - getPaddingBottom() - bottomMargin);
    if ((mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this)) && (!ViewCompat.getFitsSystemWindows(paramView)))
    {
      left += mLastInsets.getHeight();
      top += mLastInsets.getSystemWindowInsetTop();
      right -= mLastInsets.getWidth();
      bottom -= mLastInsets.size();
    }
    Rect localRect2 = get();
    GravityCompat.apply(resolveGravity(gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(left, top, right, bottom);
    decode(localRect1);
    decode(localRect2);
  }
  
  private void layoutChildWithAnchor(View paramView1, View paramView2, int paramInt)
  {
    Rect localRect1 = get();
    Rect localRect2 = get();
    try
    {
      getDescendantRect(paramView2, localRect1);
      getDesiredAnchoredChildRect(paramView1, paramInt, localRect1, localRect2);
      paramView1.layout(left, top, right, bottom);
      decode(localRect1);
      decode(localRect2);
      return;
    }
    catch (Throwable paramView1)
    {
      decode(localRect1);
      decode(localRect2);
      throw paramView1;
    }
  }
  
  private void layoutChildWithKeyline(View paramView, int paramInt1, int paramInt2)
  {
    e localE = (e)paramView.getLayoutParams();
    int i = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(gravity), paramInt2);
    int i2 = i & 0x7;
    int i1 = i & 0x70;
    int n = getWidth();
    int m = getHeight();
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    i = paramInt1;
    if (paramInt2 == 1) {
      i = n - paramInt1;
    }
    paramInt1 = getKeyline(i) - j;
    paramInt2 = 0;
    if (i2 != 1)
    {
      if (i2 == 5) {
        paramInt1 += j;
      }
    }
    else {
      paramInt1 += j / 2;
    }
    if (i1 != 16)
    {
      if (i1 == 80) {
        paramInt2 = k + 0;
      }
    }
    else {
      paramInt2 = 0 + k / 2;
    }
    paramInt1 = Math.max(getPaddingLeft() + leftMargin, Math.min(paramInt1, n - getPaddingRight() - j - rightMargin));
    paramInt2 = Math.max(getPaddingTop() + topMargin, Math.min(paramInt2, m - getPaddingBottom() - k - bottomMargin));
    paramView.layout(paramInt1, paramInt2, j + paramInt1, k + paramInt2);
  }
  
  private void onMeasureChild(View paramView, int paramInt)
  {
    e localE = (e)paramView.getLayoutParams();
    int i = width;
    if (i != paramInt)
    {
      ViewCompat.offsetTopAndBottom(paramView, paramInt - i);
      width = paramInt;
    }
  }
  
  static Behavior parseBehavior(android.content.Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a13 = a12\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  private void performIntercept(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      Behavior localBehavior = ((e)localView.getLayoutParams()).getBehavior();
      if (localBehavior != null)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        if (paramBoolean) {
          localBehavior.onInterceptTouchEvent(this, localView, localMotionEvent);
        } else {
          localBehavior.onTouchEvent(this, localView, localMotionEvent);
        }
        localMotionEvent.recycle();
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      ((e)getChildAt(i).getLayoutParams()).isBlockingInteractionBelow();
      i += 1;
    }
    mBehaviorTouchView = null;
    mDisallowInterceptReset = false;
  }
  
  private boolean performIntercept(MotionEvent paramMotionEvent, int paramInt)
  {
    int m = paramMotionEvent.getActionMasked();
    List localList = mTempList1;
    getTopSortedChildren(localList);
    int n = localList.size();
    Object localObject1 = null;
    int j = 0;
    boolean bool1 = false;
    boolean bool2;
    int k;
    for (int i = 0;; i = k)
    {
      bool2 = bool1;
      if (j >= n) {
        break;
      }
      View localView = (View)localList.get(j);
      Object localObject2 = (e)localView.getLayoutParams();
      Behavior localBehavior = ((e)localObject2).getBehavior();
      boolean bool3;
      if (((bool1) || (i != 0)) && (m != 0))
      {
        localObject2 = localObject1;
        bool3 = bool1;
        k = i;
        if (localBehavior != null)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            long l = SystemClock.uptimeMillis();
            localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          }
          if (paramInt != 0)
          {
            if (paramInt != 1)
            {
              bool3 = bool1;
              k = i;
            }
            else
            {
              localBehavior.onTouchEvent(this, localView, (MotionEvent)localObject2);
              bool3 = bool1;
              k = i;
            }
          }
          else
          {
            localBehavior.onInterceptTouchEvent(this, localView, (MotionEvent)localObject2);
            bool3 = bool1;
            k = i;
          }
        }
      }
      else
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (localBehavior != null)
          {
            if (paramInt != 0)
            {
              if (paramInt == 1) {
                bool1 = localBehavior.onTouchEvent(this, localView, paramMotionEvent);
              }
            }
            else {
              bool1 = localBehavior.onInterceptTouchEvent(this, localView, paramMotionEvent);
            }
            bool2 = bool1;
            if (bool1)
            {
              mBehaviorTouchView = localView;
              bool2 = bool1;
            }
          }
        }
        bool3 = ((e)localObject2).didBlockInteraction();
        bool1 = ((e)localObject2).isBlockingInteractionBelow(this, localView);
        if ((bool1) && (!bool3)) {
          i = 1;
        } else {
          i = 0;
        }
        localObject2 = localObject1;
        bool3 = bool2;
        k = i;
        if (bool1)
        {
          localObject2 = localObject1;
          bool3 = bool2;
          k = i;
          if (i == 0) {
            break;
          }
        }
      }
      j += 1;
      localObject1 = localObject2;
      bool1 = bool3;
    }
    localList.clear();
    return bool2;
  }
  
  private void prepareChildren()
  {
    x.clear();
    c.clear();
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      View localView1 = getChildAt(i);
      e localE = getResolvedLayoutParams(localView1);
      localE.findAnchorView(this, localView1);
      c.put(localView1);
      int j = 0;
      while (j < k)
      {
        if (j != i)
        {
          View localView2 = getChildAt(j);
          if (localE.isDirty(this, localView1, localView2))
          {
            if (!c.add(localView2)) {
              c.put(localView2);
            }
            c.add(localView2, localView1);
          }
        }
        j += 1;
      }
      i += 1;
    }
    x.addAll(c.a());
    Collections.reverse(x);
  }
  
  private static int resolveAnchoredChildGravity(int paramInt)
  {
    if (paramInt == 0) {
      return 17;
    }
    return paramInt;
  }
  
  private static int resolveGravity(int paramInt)
  {
    int i = paramInt;
    if ((paramInt & 0x7) == 0) {
      i = paramInt | 0x800003;
    }
    paramInt = i;
    if ((i & 0x70) == 0) {
      paramInt = i | 0x30;
    }
    return paramInt;
  }
  
  private static int resolveKeylineGravity(int paramInt)
  {
    if (paramInt == 0) {
      return 8388661;
    }
    return paramInt;
  }
  
  private void show(View paramView, Rect paramRect, int paramInt)
  {
    if (!ViewCompat.set(paramView)) {
      return;
    }
    if (paramView.getWidth() > 0)
    {
      if (paramView.getHeight() <= 0) {
        return;
      }
      e localE = (e)paramView.getLayoutParams();
      Behavior localBehavior = localE.getBehavior();
      Rect localRect1 = get();
      Rect localRect2 = get();
      localRect2.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      if ((localBehavior != null) && (localBehavior.layoutDependsOn(this, paramView, localRect1)))
      {
        if (!localRect2.contains(localRect1))
        {
          paramView = new StringBuilder();
          paramView.append("Rect should be within the child's bounds. Rect:");
          paramView.append(localRect1.toShortString());
          paramView.append(" | Bounds:");
          paramView.append(localRect2.toShortString());
          throw new IllegalArgumentException(paramView.toString());
        }
      }
      else {
        localRect1.set(localRect2);
      }
      decode(localRect2);
      if (localRect1.isEmpty())
      {
        decode(localRect1);
        return;
      }
      int k = GravityCompat.getAbsoluteGravity(left, paramInt);
      int j = 1;
      if ((k & 0x30) == 48)
      {
        paramInt = top - topMargin - width;
        i = top;
        if (paramInt < i)
        {
          onMeasureChild(paramView, i - paramInt);
          paramInt = 1;
          break label252;
        }
      }
      paramInt = 0;
      label252:
      int i = paramInt;
      if ((k & 0x50) == 80)
      {
        int m = getHeight() - bottom - bottomMargin + width;
        int n = bottom;
        i = paramInt;
        if (m < n)
        {
          onMeasureChild(paramView, m - n);
          i = 1;
        }
      }
      if (i == 0) {
        onMeasureChild(paramView, 0);
      }
      if ((k & 0x3) == 3)
      {
        paramInt = left - leftMargin - height;
        i = left;
        if (paramInt < i)
        {
          layout(paramView, i - paramInt);
          paramInt = 1;
          break label383;
        }
      }
      paramInt = 0;
      label383:
      if ((k & 0x5) == 5)
      {
        i = getWidth() - right - rightMargin + height;
        k = right;
        if (i < k)
        {
          layout(paramView, i - k);
          paramInt = j;
        }
      }
      if (paramInt == 0) {
        layout(paramView, 0);
      }
      decode(localRect1);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    int i2 = getChildCount();
    int i1 = 0;
    int k = 0;
    int i = 0;
    int m;
    for (int j = 0; k < i2; j = m)
    {
      Object localObject1 = getChildAt(k);
      int n;
      if (((View)localObject1).getVisibility() == 8)
      {
        n = i;
        m = j;
      }
      else
      {
        Object localObject2 = (e)((View)localObject1).getLayoutParams();
        if (!((e)localObject2).get(paramInt5))
        {
          n = i;
          m = j;
        }
        else
        {
          localObject2 = ((e)localObject2).getBehavior();
          n = i;
          m = j;
          if (localObject2 != null)
          {
            int[] arrayOfInt = h;
            arrayOfInt[0] = 0;
            arrayOfInt[1] = 0;
            ((Behavior)localObject2).onNestedScroll(this, (View)localObject1, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, arrayOfInt);
            localObject1 = h;
            if (paramInt3 > 0) {
              i = Math.max(i, localObject1[0]);
            } else {
              i = Math.min(i, localObject1[0]);
            }
            if (paramInt4 > 0) {
              j = Math.max(j, h[1]);
            } else {
              j = Math.min(j, h[1]);
            }
            i1 = 1;
            m = j;
            n = i;
          }
        }
      }
      k += 1;
      i = n;
    }
    paramArrayOfInt[0] += i;
    paramArrayOfInt[1] += j;
    if (i1 != 0) {
      onDraw(1);
    }
  }
  
  public boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool1 = false;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        e localE = (e)localView.getLayoutParams();
        Behavior localBehavior = localE.getBehavior();
        if (localBehavior != null)
        {
          boolean bool2 = localBehavior.onStartNestedScroll(this, localView, paramView1, paramView2, paramInt1, paramInt2);
          bool1 |= bool2;
          localE.a(paramInt2, bool2);
        }
        else
        {
          localE.a(paramInt2, false);
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  void addPreDrawListener()
  {
    if (mIsAttachedToWindow)
    {
      if (mOnPreDrawListener == null) {
        mOnPreDrawListener = new f();
      }
      getViewTreeObserver().addOnPreDrawListener(mOnPreDrawListener);
    }
    mNeedsPreDrawListener = true;
  }
  
  public e applyFont(AttributeSet paramAttributeSet)
  {
    return new e(getContext(), paramAttributeSet);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof e)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void dispatchDependentViewsChanged(View paramView)
  {
    List localList = c.removeAll(paramView);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        View localView = (View)localList.get(i);
        Behavior localBehavior = ((e)localView.getLayoutParams()).getBehavior();
        if (localBehavior != null) {
          localBehavior.onDependentViewChanged(this, localView, paramView);
        }
        i += 1;
      }
    }
  }
  
  void draw(View paramView, Rect paramRect)
  {
    ((e)paramView.getLayoutParams()).setRect(paramRect);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    e localE = (e)paramView.getLayoutParams();
    Behavior localBehavior = mBehavior;
    if (localBehavior != null)
    {
      float f = localBehavior.getScrimOpacity(this, paramView);
      if (f > 0.0F)
      {
        if (mScrimPaint == null) {
          mScrimPaint = new Paint();
        }
        mScrimPaint.setColor(mBehavior.getScrimColor(this, paramView));
        mScrimPaint.setAlpha(constrain(Math.round(f * 255.0F), 0, 255));
        int i = paramCanvas.save();
        if (paramView.isOpaque()) {
          paramCanvas.clipRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom(), Region.Op.DIFFERENCE);
        }
        paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), mScrimPaint);
        paramCanvas.restoreToCount(i);
      }
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = mStatusBarBackground;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = false | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool1) {
      invalidate();
    }
  }
  
  void ensurePreDrawListener()
  {
    int j = getChildCount();
    int m = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = m;
      if (i >= j) {
        break;
      }
      if (hasDependencies(getChildAt(i)))
      {
        k = 1;
        break;
      }
      i += 1;
    }
    if (k != mNeedsPreDrawListener)
    {
      if (k != 0)
      {
        addPreDrawListener();
        return;
      }
      removePreDrawListener();
    }
  }
  
  public List get(View paramView)
  {
    paramView = c.removeAll(paramView);
    data.clear();
    if (paramView != null) {
      data.addAll(paramView);
    }
    return data;
  }
  
  void getChildRect(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((!paramView.isLayoutRequested()) && (paramView.getVisibility() != 8))
    {
      if (paramBoolean)
      {
        getDescendantRect(paramView, paramRect);
        return;
      }
      paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      return;
    }
    paramRect.setEmpty();
  }
  
  public List getDependencies(View paramView)
  {
    paramView = c.get(paramView);
    data.clear();
    if (paramView != null) {
      data.addAll(paramView);
    }
    return data;
  }
  
  final List getDependencySortedChildren()
  {
    prepareChildren();
    return Collections.unmodifiableList(x);
  }
  
  void getDescendantRect(View paramView, Rect paramRect)
  {
    ViewGroupUtilsHoneycomb.getDescendantRect(this, paramView, paramRect);
  }
  
  void getDesiredAnchoredChildRect(View paramView, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    e localE = (e)paramView.getLayoutParams();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    getDesiredAnchoredChildRect(paramView, paramInt, paramRect1, paramRect2, localE, i, j);
    getDesiredAnchoredChildRect(localE, paramRect2, i, j);
  }
  
  public final v7.v7.package_13.f getLastWindowInsets()
  {
    return mLastInsets;
  }
  
  public int getNestedScrollAxes()
  {
    return mNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  e getResolvedLayoutParams(View paramView)
  {
    e localE = (e)paramView.getLayoutParams();
    if (!mBehaviorResolved)
    {
      if ((paramView instanceof b))
      {
        paramView = ((b)paramView).getBehavior();
        if (paramView == null) {
          Log.e("CoordinatorLayout", "Attached behavior class is null");
        }
        localE.setBehavior(paramView);
        mBehaviorResolved = true;
        return localE;
      }
      Object localObject1 = paramView.getClass();
      Object localObject2;
      for (paramView = null; localObject1 != null; paramView = (View)localObject2)
      {
        localObject2 = (c)((Class)localObject1).getAnnotation(c.class);
        paramView = (View)localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = ((Class)localObject1).getSuperclass();
      }
      if (paramView != null) {
        try
        {
          localObject1 = paramView.value();
          localObject1 = ((Class)localObject1).getDeclaredConstructor(new Class[0]);
          localObject1 = ((Constructor)localObject1).newInstance(new Object[0]);
          localObject1 = (Behavior)localObject1;
          localE.setBehavior((Behavior)localObject1);
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Default behavior class ");
          ((StringBuilder)localObject2).append(paramView.value().getName());
          ((StringBuilder)localObject2).append(" could not be instantiated. Did you forget a default constructor?");
          Log.e("CoordinatorLayout", ((StringBuilder)localObject2).toString(), localException);
        }
      }
      mBehaviorResolved = true;
    }
    return localE;
  }
  
  public Drawable getStatusBarBackground()
  {
    return mStatusBarBackground;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public boolean isPointInChildBounds(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = get();
    getDescendantRect(paramView, localRect);
    try
    {
      boolean bool = localRect.contains(paramInt1, paramInt2);
      decode(localRect);
      return bool;
    }
    catch (Throwable paramView)
    {
      decode(localRect);
      throw paramView;
    }
  }
  
  void offsetChildToAnchor(View paramView, int paramInt)
  {
    e localE = (e)paramView.getLayoutParams();
    if (mAnchorView != null)
    {
      Rect localRect1 = get();
      Rect localRect2 = get();
      Rect localRect3 = get();
      getDescendantRect(mAnchorView, localRect1);
      int i = 0;
      getChildRect(paramView, false, localRect2);
      int j = paramView.getMeasuredWidth();
      int k = paramView.getMeasuredHeight();
      getDesiredAnchoredChildRect(paramView, paramInt, localRect1, localRect3, localE, j, k);
      if (left == left)
      {
        paramInt = i;
        if (top == top) {}
      }
      else
      {
        paramInt = 1;
      }
      getDesiredAnchoredChildRect(localE, localRect3, j, k);
      i = left - left;
      j = top - top;
      if (i != 0) {
        ViewCompat.offsetLeftAndRight(paramView, i);
      }
      if (j != 0) {
        ViewCompat.offsetTopAndBottom(paramView, j);
      }
      if (paramInt != 0)
      {
        Behavior localBehavior = localE.getBehavior();
        if (localBehavior != null) {
          localBehavior.onDependentViewChanged(this, paramView, mAnchorView);
        }
      }
      decode(localRect1);
      decode(localRect2);
      decode(localRect3);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    performIntercept(false);
    if (mNeedsPreDrawListener)
    {
      if (mOnPreDrawListener == null) {
        mOnPreDrawListener = new f();
      }
      getViewTreeObserver().addOnPreDrawListener(mOnPreDrawListener);
    }
    if ((mLastInsets == null) && (ViewCompat.getFitsSystemWindows(this))) {
      ViewCompat.requestApplyInsets(this);
    }
    mIsAttachedToWindow = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    performIntercept(false);
    if ((mNeedsPreDrawListener) && (mOnPreDrawListener != null)) {
      getViewTreeObserver().removeOnPreDrawListener(mOnPreDrawListener);
    }
    View localView = mNestedScrollingTarget;
    if (localView != null) {
      onStopNestedScroll(localView);
    }
    mIsAttachedToWindow = false;
  }
  
  final void onDraw(int paramInt)
  {
    int k = ViewCompat.getLayoutDirection(this);
    int m = x.size();
    Rect localRect1 = get();
    Rect localRect2 = get();
    Rect localRect3 = get();
    int i = 0;
    while (i < m)
    {
      View localView = (View)x.get(i);
      Object localObject1 = (e)localView.getLayoutParams();
      if ((paramInt != 0) || (localView.getVisibility() != 8))
      {
        int j = 0;
        Object localObject2;
        while (j < i)
        {
          localObject2 = (View)x.get(j);
          if (mAnchorDirectChild == localObject2) {
            offsetChildToAnchor(localView, k);
          }
          j += 1;
        }
        getChildRect(localView, true, localRect2);
        if ((top != 0) && (!localRect2.isEmpty()))
        {
          j = GravityCompat.getAbsoluteGravity(top, k);
          int n = j & 0x70;
          if (n != 48)
          {
            if (n == 80) {
              bottom = Math.max(bottom, getHeight() - top);
            }
          }
          else {
            top = Math.max(top, bottom);
          }
          j &= 0x7;
          if (j != 3)
          {
            if (j == 5) {
              right = Math.max(right, getWidth() - left);
            }
          }
          else {
            left = Math.max(left, right);
          }
        }
        if ((left != 0) && (localView.getVisibility() == 0)) {
          show(localView, localRect1, k);
        }
        if (paramInt != 2)
        {
          onDraw(localView, localRect3);
          if (!localRect3.equals(localRect2)) {
            draw(localView, localRect2);
          }
        }
        else
        {
          j = i + 1;
          while (j < m)
          {
            localObject1 = (View)x.get(j);
            localObject2 = (e)((View)localObject1).getLayoutParams();
            Behavior localBehavior = ((e)localObject2).getBehavior();
            if ((localBehavior != null) && (localBehavior.update(this, (View)localObject1, localView))) {
              if ((paramInt == 0) && (((e)localObject2).isPlayed()))
              {
                ((e)localObject2).get();
              }
              else
              {
                boolean bool;
                if (paramInt != 2)
                {
                  bool = localBehavior.onDependentViewChanged(this, (View)localObject1, localView);
                }
                else
                {
                  localBehavior.a(this, (View)localObject1, localView);
                  bool = true;
                }
                if (paramInt == 1) {
                  ((e)localObject2).get(bool);
                }
              }
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    decode(localRect1);
    decode(localRect2);
    decode(localRect3);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((mDrawStatusBarBackground) && (mStatusBarBackground != null))
    {
      v7.v7.package_13.f localF = mLastInsets;
      int i;
      if (localF != null) {
        i = localF.getSystemWindowInsetTop();
      } else {
        i = 0;
      }
      if (i > 0)
      {
        mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        mStatusBarBackground.draw(paramCanvas);
      }
    }
  }
  
  public void onDraw(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i2 = getChildCount();
    int i1 = 0;
    int k = 0;
    int i = 0;
    int m;
    for (int j = 0; k < i2; j = m)
    {
      Object localObject1 = getChildAt(k);
      int n;
      if (((View)localObject1).getVisibility() == 8)
      {
        n = i;
        m = j;
      }
      else
      {
        Object localObject2 = (e)((View)localObject1).getLayoutParams();
        if (!((e)localObject2).get(paramInt3))
        {
          n = i;
          m = j;
        }
        else
        {
          localObject2 = ((e)localObject2).getBehavior();
          n = i;
          m = j;
          if (localObject2 != null)
          {
            int[] arrayOfInt = h;
            arrayOfInt[0] = 0;
            arrayOfInt[1] = 0;
            ((Behavior)localObject2).onNestedPreScroll(this, (View)localObject1, paramView, paramInt1, paramInt2, arrayOfInt, paramInt3);
            localObject1 = h;
            if (paramInt1 > 0) {
              i = Math.max(i, localObject1[0]);
            } else {
              i = Math.min(i, localObject1[0]);
            }
            localObject1 = h;
            if (paramInt2 > 0) {
              j = Math.max(j, localObject1[1]);
            } else {
              j = Math.min(j, localObject1[1]);
            }
            i1 = 1;
            m = j;
            n = i;
          }
        }
      }
      k += 1;
      i = n;
    }
    paramArrayOfInt[0] = i;
    paramArrayOfInt[1] = j;
    if (i1 != 0) {
      onDraw(1);
    }
  }
  
  void onDraw(View paramView, Rect paramRect)
  {
    paramRect.set(((e)paramView.getLayoutParams()).getRect());
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      performIntercept(true);
    }
    boolean bool = performIntercept(paramMotionEvent, 0);
    if ((i == 1) || (i == 3)) {
      performIntercept(true);
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = ViewCompat.getLayoutDirection(this);
    paramInt3 = x.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)x.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        Behavior localBehavior = ((e)localView.getLayoutParams()).getBehavior();
        if ((localBehavior == null) || (!localBehavior.onLayoutChild(this, localView, paramInt2))) {
          onLayoutChild(localView, paramInt2);
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void onLayoutChild(View paramView, int paramInt)
  {
    e localE = (e)paramView.getLayoutParams();
    if (!localE.checkAnchorChanged())
    {
      View localView = mAnchorView;
      if (localView != null)
      {
        layoutChildWithAnchor(paramView, localView, paramInt);
        return;
      }
      int i = keyline;
      if (i >= 0)
      {
        layoutChildWithKeyline(paramView, i, paramInt);
        return;
      }
      layoutChild(paramView, paramInt);
      return;
    }
    throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    prepareChildren();
    ensurePreDrawListener();
    int i5 = getPaddingLeft();
    int i6 = getPaddingTop();
    int i7 = getPaddingRight();
    int i8 = getPaddingBottom();
    int i9 = ViewCompat.getLayoutDirection(this);
    int j;
    if (i9 == 1) {
      j = 1;
    } else {
      j = 0;
    }
    int i10 = View.MeasureSpec.getMode(paramInt1);
    int i11 = View.MeasureSpec.getSize(paramInt1);
    int i12 = View.MeasureSpec.getMode(paramInt2);
    int i13 = View.MeasureSpec.getSize(paramInt2);
    int i2 = getSuggestedMinimumWidth();
    int i1 = getSuggestedMinimumHeight();
    int k;
    if ((mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this))) {
      k = 1;
    } else {
      k = 0;
    }
    int i14 = x.size();
    int n = 0;
    int m = 0;
    while (m < i14)
    {
      View localView = (View)x.get(m);
      if (localView.getVisibility() != 8)
      {
        e localE = (e)localView.getLayoutParams();
        int i = keyline;
        int i3;
        if ((i >= 0) && (i10 != 0))
        {
          i = getKeyline(i);
          i3 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(gravity), i9) & 0x7;
          if (((i3 == 3) && (j == 0)) || ((i3 == 5) && (j != 0)))
          {
            i = Math.max(0, i11 - i7 - i);
            break label287;
          }
          if (((i3 == 5) && (j == 0)) || ((i3 == 3) && (j != 0)))
          {
            i = Math.max(0, i - i5);
            break label287;
          }
        }
        i = 0;
        label287:
        int i4;
        if ((k != 0) && (!ViewCompat.getFitsSystemWindows(localView)))
        {
          i3 = mLastInsets.getHeight();
          int i16 = mLastInsets.getWidth();
          i4 = mLastInsets.getSystemWindowInsetTop();
          int i15 = mLastInsets.size();
          i3 = View.MeasureSpec.makeMeasureSpec(i11 - (i3 + i16), i10);
          i4 = View.MeasureSpec.makeMeasureSpec(i13 - (i4 + i15), i12);
        }
        else
        {
          i3 = paramInt1;
          i4 = paramInt2;
        }
        Behavior localBehavior = localE.getBehavior();
        if (localBehavior != null) {
          if (localBehavior.onMeasureChild(this, localView, i3, i, i4, 0)) {
            break label419;
          }
        }
        onMeasureChild(localView, i3, i, i4, 0);
        label419:
        i2 = Math.max(i2, i5 + i7 + localView.getMeasuredWidth() + leftMargin + rightMargin);
        i1 = Math.max(i1, i6 + i8 + localView.getMeasuredHeight() + topMargin + bottomMargin);
        n = View.combineMeasuredStates(n, localView.getMeasuredState());
      }
      m += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(i2, paramInt1, 0xFF000000 & n), View.resolveSizeAndState(i1, paramInt2, n << 16));
  }
  
  public void onMeasureChild(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 8)
      {
        bool2 = bool1;
      }
      else
      {
        Object localObject = (e)localView.getLayoutParams();
        if (!((e)localObject).get(0))
        {
          bool2 = bool1;
        }
        else
        {
          localObject = ((e)localObject).getBehavior();
          bool2 = bool1;
          if (localObject != null) {
            bool2 = bool1 | ((Behavior)localObject).onNestedFling(this, localView, paramView, paramFloat1, paramFloat2, paramBoolean);
          }
        }
      }
      i += 1;
    }
    if (bool1) {
      onDraw(1);
    }
    return bool1;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 8)
      {
        bool2 = bool1;
      }
      else
      {
        Object localObject = (e)localView.getLayoutParams();
        if (!((e)localObject).get(0))
        {
          bool2 = bool1;
        }
        else
        {
          localObject = ((e)localObject).getBehavior();
          bool2 = bool1;
          if (localObject != null) {
            bool2 = bool1 | ((Behavior)localObject).onNestedPreFling(this, localView, paramView, paramFloat1, paramFloat2);
          }
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    onDraw(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0, y);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    performIntercept(paramView1, paramView2, paramInt, 0);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    paramParcelable = behaviorStates;
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      int k = localView.getId();
      Behavior localBehavior = getResolvedLayoutParams(localView).getBehavior();
      if ((k != -1) && (localBehavior != null))
      {
        Parcelable localParcelable = (Parcelable)paramParcelable.get(k);
        if (localParcelable != null) {
          localBehavior.onRestoreInstanceState(this, localView, localParcelable);
        }
      }
      i += 1;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      int k = ((View)localObject).getId();
      Behavior localBehavior = ((e)((View)localObject).getLayoutParams()).getBehavior();
      if ((k != -1) && (localBehavior != null))
      {
        localObject = localBehavior.onSaveInstanceState(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    behaviorStates = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return a(paramView1, paramView2, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    performIntercept(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool3;
    boolean bool1;
    if (mBehaviorTouchView == null)
    {
      bool3 = performIntercept(paramMotionEvent, 1);
      bool1 = bool3;
      bool2 = bool1;
      if (!bool3) {
        break label75;
      }
    }
    else
    {
      bool1 = false;
    }
    Object localObject = ((e)mBehaviorTouchView.getLayoutParams()).getBehavior();
    boolean bool2 = bool1;
    if (localObject != null)
    {
      bool2 = ((Behavior)localObject).onTouchEvent(this, mBehaviorTouchView, paramMotionEvent);
    }
    else
    {
      label75:
      bool3 = false;
      bool1 = bool2;
      bool2 = bool3;
    }
    View localView = mBehaviorTouchView;
    localObject = null;
    if (localView == null)
    {
      bool3 = bool2 | super.onTouchEvent(paramMotionEvent);
      paramMotionEvent = (MotionEvent)localObject;
    }
    else
    {
      bool3 = bool2;
      paramMotionEvent = (MotionEvent)localObject;
      if (bool1)
      {
        long l = SystemClock.uptimeMillis();
        localObject = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        paramMotionEvent = (MotionEvent)localObject;
        super.onTouchEvent((MotionEvent)localObject);
        bool3 = bool2;
      }
    }
    if (paramMotionEvent != null) {
      paramMotionEvent.recycle();
    }
    if ((i == 1) || (i == 3)) {
      performIntercept(false);
    }
    return bool3;
  }
  
  public void performIntercept(View paramView, int paramInt)
  {
    mNestedScrollingParentHelper.onStopNestedScroll(paramView, paramInt);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      e localE = (e)localView.getLayoutParams();
      if (localE.get(paramInt))
      {
        Behavior localBehavior = localE.getBehavior();
        if (localBehavior != null) {
          localBehavior.onStopNestedScroll(this, localView, paramView, paramInt);
        }
        localE.add(paramInt);
        localE.get();
      }
      i += 1;
    }
    mNestedScrollingTarget = null;
  }
  
  public void performIntercept(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    mNestedScrollingParentHelper.onStopNestedScroll(paramView1, paramView2, paramInt1, paramInt2);
    mNestedScrollingTarget = paramView2;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      Object localObject = (e)localView.getLayoutParams();
      if (((e)localObject).get(paramInt2))
      {
        localObject = ((e)localObject).getBehavior();
        if (localObject != null) {
          ((Behavior)localObject).onNestedPreScroll(this, localView, paramView1, paramView2, paramInt1, paramInt2);
        }
      }
      i += 1;
    }
  }
  
  void removePreDrawListener()
  {
    if ((mIsAttachedToWindow) && (mOnPreDrawListener != null)) {
      getViewTreeObserver().removeOnPreDrawListener(mOnPreDrawListener);
    }
    mNeedsPreDrawListener = false;
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    Behavior localBehavior = ((e)paramView.getLayoutParams()).getBehavior();
    if ((localBehavior != null) && (localBehavior.onLayoutChild(this, paramView, paramRect, paramBoolean))) {
      return true;
    }
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!mDisallowInterceptReset))
    {
      performIntercept(false);
      mDisallowInterceptReset = true;
    }
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    b();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    mOnHierarchyChangeListener = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable2 = mStatusBarBackground;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      mStatusBarBackground = localDrawable1;
      if (localDrawable1 != null)
      {
        if (localDrawable1.isStateful()) {
          mStatusBarBackground.setState(getDrawableState());
        }
        DrawableCompat.a(mStatusBarBackground, ViewCompat.getLayoutDirection(this));
        paramDrawable = mStatusBarBackground;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        mStatusBarBackground.setCallback(this);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    setStatusBarBackground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarBackgroundResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = ContextCompat.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setStatusBarBackground(localDrawable);
  }
  
  protected e setTopMargin(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof e)) {
      return new e((e)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new e((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new e(paramLayoutParams);
  }
  
  protected e setVisibility()
  {
    return new e(-2, -2);
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
    Drawable localDrawable = mStatusBarBackground;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      mStatusBarBackground.setVisible(bool, false);
    }
  }
  
  final v7.v7.package_13.f setWindowInsets(v7.v7.package_13.f paramF)
  {
    v7.v7.package_13.f localF = paramF;
    if (!v7.v7.util.Context.equals(mLastInsets, paramF))
    {
      mLastInsets = paramF;
      boolean bool2 = true;
      boolean bool1;
      if ((paramF != null) && (paramF.getSystemWindowInsetTop() > 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      mDrawStatusBarBackground = bool1;
      if ((!bool1) && (getBackground() == null)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      setWillNotDraw(bool1);
      localF = dispatchApplyWindowInsetsToBehaviors(paramF);
      requestLayout();
    }
    return localF;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == mStatusBarBackground);
  }
  
  public static abstract class Behavior<V extends View>
  {
    public Behavior() {}
    
    public Behavior(android.content.Context paramContext, AttributeSet paramAttributeSet) {}
    
    public void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2) {}
    
    public boolean blocksInteractionBelow(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      return getScrimOpacity(paramCoordinatorLayout, paramView) > 0.0F;
    }
    
    public int getScrimColor(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      return -16777216;
    }
    
    public float getScrimOpacity(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      return 0.0F;
    }
    
    public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect)
    {
      return false;
    }
    
    public v7.v7.package_13.f onApplyWindowInsets(CoordinatorLayout paramCoordinatorLayout, View paramView, v7.v7.package_13.f paramF)
    {
      return paramF;
    }
    
    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return false;
    }
    
    public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public void onLayoutChild(CoordinatorLayout.e paramE) {}
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
    {
      return false;
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
    {
      return false;
    }
    
    public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return false;
    }
    
    public boolean onNestedFling(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      return false;
    }
    
    public boolean onNestedPreFling(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
    
    public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      if (paramInt3 == 0) {
        onNestedPreScroll(paramCoordinatorLayout, paramView1, paramView2, paramInt1, paramInt2, paramArrayOfInt);
      }
    }
    
    public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0) {
        onNestedScrollAccepted(paramCoordinatorLayout, paramView1, paramView2, paramView3, paramInt1);
      }
    }
    
    public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      if (paramInt5 == 0) {
        onNestedScroll(paramCoordinatorLayout, paramView1, paramView2, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
    {
      paramArrayOfInt[0] += paramInt3;
      paramArrayOfInt[1] += paramInt4;
      onNestedScroll(paramCoordinatorLayout, paramView1, paramView2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public void onNestedScrollAccepted(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt) {}
    
    public void onRestoreInstanceState() {}
    
    public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, View paramView, Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      return android.view.AbsSavedState.EMPTY_STATE;
    }
    
    public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt)
    {
      return false;
    }
    
    public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0) {
        return onStartNestedScroll(paramCoordinatorLayout, paramView1, paramView2, paramView3, paramInt1);
      }
      return false;
    }
    
    public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2) {}
    
    public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt)
    {
      if (paramInt == 0) {
        onStopNestedScroll(paramCoordinatorLayout, paramView1, paramView2);
      }
    }
    
    public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean update(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return false;
    }
  }
  
  protected static class SavedState
    extends androidx.customview.view.AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    SparseArray<Parcelable> behaviorStates;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      int j = paramParcel.readInt();
      int[] arrayOfInt = new int[j];
      paramParcel.readIntArray(arrayOfInt);
      paramParcel = paramParcel.readParcelableArray(paramClassLoader);
      behaviorStates = new SparseArray(j);
      int i = 0;
      while (i < j)
      {
        behaviorStates.append(arrayOfInt[i], paramParcel[i]);
        i += 1;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      Object localObject = behaviorStates;
      int j = 0;
      int i;
      if (localObject != null) {
        i = ((SparseArray)localObject).size();
      } else {
        i = 0;
      }
      paramParcel.writeInt(i);
      localObject = new int[i];
      Parcelable[] arrayOfParcelable = new Parcelable[i];
      while (j < i)
      {
        localObject[j] = behaviorStates.keyAt(j);
        arrayOfParcelable[j] = ((Parcelable)behaviorStates.valueAt(j));
        j += 1;
      }
      paramParcel.writeIntArray((int[])localObject);
      paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
    }
    
    static final class a
      implements Parcelable.ClassLoaderCreator<CoordinatorLayout.SavedState>
    {
      a() {}
      
      public CoordinatorLayout.SavedState[] a(int paramInt)
      {
        return new CoordinatorLayout.SavedState[paramInt];
      }
      
      public CoordinatorLayout.SavedState getInstance(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new CoordinatorLayout.SavedState(paramParcel, paramClassLoader);
      }
      
      public CoordinatorLayout.SavedState readDate(Parcel paramParcel)
      {
        return new CoordinatorLayout.SavedState(paramParcel, null);
      }
    }
  }
  
  class a
    implements MethodVisitor
  {
    a() {}
    
    public v7.v7.package_13.f a(View paramView, v7.v7.package_13.f paramF)
    {
      return setWindowInsets(paramF);
    }
  }
  
  public static abstract interface b
  {
    public abstract CoordinatorLayout.Behavior getBehavior();
  }
  
  @Deprecated
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface c
  {
    Class value();
  }
  
  private class d
    implements ViewGroup.OnHierarchyChangeListener
  {
    d() {}
    
    public void onChildViewAdded(View paramView1, View paramView2)
    {
      ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = mOnHierarchyChangeListener;
      if (localOnHierarchyChangeListener != null) {
        localOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public void onChildViewRemoved(View paramView1, View paramView2)
    {
      onDraw(2);
      ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = mOnHierarchyChangeListener;
      if (localOnHierarchyChangeListener != null) {
        localOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
  
  public static class e
    extends ViewGroup.MarginLayoutParams
  {
    private boolean a;
    public int anchorGravity = 0;
    private boolean c;
    public int gravity = 0;
    int height;
    public int keyline = -1;
    public int left = 0;
    View mAnchorDirectChild;
    int mAnchorId = -1;
    View mAnchorView;
    CoordinatorLayout.Behavior mBehavior;
    boolean mBehaviorResolved = false;
    Object mBehaviorTag;
    private boolean mDidBlockInteraction;
    final Rect mRect = new Rect();
    private boolean multiline;
    public int top = 0;
    int width;
    
    public e(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    e(android.content.Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.a);
      gravity = localTypedArray.getInteger(R.styleable.SlidingMenu_mode, 0);
      mAnchorId = localTypedArray.getResourceId(R.styleable.SlidingMenu_viewAbove, -1);
      anchorGravity = localTypedArray.getInteger(R.styleable.SlidingMenu_viewBehind, 0);
      keyline = localTypedArray.getInteger(R.styleable.SlidingMenu_touchModeAbove, -1);
      top = localTypedArray.getInt(R.styleable.SlidingMenu_touchModeBehind, 0);
      left = localTypedArray.getInt(R.styleable.Preference_android_dependency, 0);
      int i = R.styleable.Preference_defaultValue;
      boolean bool = localTypedArray.hasValue(i);
      mBehaviorResolved = bool;
      if (bool) {
        mBehavior = CoordinatorLayout.parseBehavior(paramContext, paramAttributeSet, localTypedArray.getString(i));
      }
      localTypedArray.recycle();
      paramContext = mBehavior;
      if (paramContext != null) {
        paramContext.onLayoutChild(this);
      }
    }
    
    public e(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public e(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public e(e paramE)
    {
      super();
    }
    
    private boolean onLayoutChild(View paramView, int paramInt)
    {
      int i = GravityCompat.getAbsoluteGravity(getLayoutParamstop, paramInt);
      return (i != 0) && ((GravityCompat.getAbsoluteGravity(left, paramInt) & i) == i);
    }
    
    private void resolveAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
    {
      Object localObject1 = paramCoordinatorLayout.findViewById(mAnchorId);
      Object localObject2 = localObject1;
      mAnchorView = ((View)localObject1);
      if (localObject1 != null)
      {
        if (localObject1 == paramCoordinatorLayout)
        {
          if (paramCoordinatorLayout.isInEditMode())
          {
            mAnchorDirectChild = null;
            mAnchorView = null;
            return;
          }
          throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        }
        for (localObject1 = ((View)localObject1).getParent(); (localObject1 != paramCoordinatorLayout) && (localObject1 != null); localObject1 = ((ViewParent)localObject1).getParent())
        {
          if (localObject1 == paramView)
          {
            if (paramCoordinatorLayout.isInEditMode())
            {
              mAnchorDirectChild = null;
              mAnchorView = null;
              return;
            }
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
          }
          if ((localObject1 instanceof View)) {
            localObject2 = (View)localObject1;
          }
        }
        mAnchorDirectChild = ((View)localObject2);
        return;
      }
      if (paramCoordinatorLayout.isInEditMode())
      {
        mAnchorDirectChild = null;
        mAnchorView = null;
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Could not find CoordinatorLayout descendant view with id ");
      ((StringBuilder)localObject1).append(paramCoordinatorLayout.getResources().getResourceName(mAnchorId));
      ((StringBuilder)localObject1).append(" to anchor view ");
      ((StringBuilder)localObject1).append(paramView);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    private boolean verifyAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
    {
      if (mAnchorView.getId() != mAnchorId) {
        return false;
      }
      View localView = mAnchorView;
      ViewParent localViewParent = localView.getParent();
      while (localViewParent != paramCoordinatorLayout) {
        if ((localViewParent != null) && (localViewParent != paramView))
        {
          if ((localViewParent instanceof View)) {
            localView = (View)localViewParent;
          }
          localViewParent = localViewParent.getParent();
        }
        else
        {
          mAnchorDirectChild = null;
          mAnchorView = null;
          return false;
        }
      }
      mAnchorDirectChild = localView;
      return true;
    }
    
    void a(int paramInt, boolean paramBoolean)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        a = paramBoolean;
        return;
      }
      c = paramBoolean;
    }
    
    void add(int paramInt)
    {
      a(paramInt, false);
    }
    
    boolean checkAnchorChanged()
    {
      return (mAnchorView == null) && (mAnchorId != -1);
    }
    
    boolean didBlockInteraction()
    {
      if (mBehavior == null) {
        mDidBlockInteraction = false;
      }
      return mDidBlockInteraction;
    }
    
    View findAnchorView(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      if (mAnchorId == -1)
      {
        mAnchorDirectChild = null;
        mAnchorView = null;
        return null;
      }
      if ((mAnchorView == null) || (!verifyAnchorView(paramView, paramCoordinatorLayout))) {
        resolveAnchorView(paramView, paramCoordinatorLayout);
      }
      return mAnchorView;
    }
    
    void get()
    {
      multiline = false;
    }
    
    void get(boolean paramBoolean)
    {
      multiline = paramBoolean;
    }
    
    boolean get(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return false;
        }
        return a;
      }
      return c;
    }
    
    public int getAnchorId()
    {
      return mAnchorId;
    }
    
    public CoordinatorLayout.Behavior getBehavior()
    {
      return mBehavior;
    }
    
    Rect getRect()
    {
      return mRect;
    }
    
    void isBlockingInteractionBelow()
    {
      mDidBlockInteraction = false;
    }
    
    boolean isBlockingInteractionBelow(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      boolean bool2 = mDidBlockInteraction;
      if (bool2) {
        return true;
      }
      CoordinatorLayout.Behavior localBehavior = mBehavior;
      boolean bool1;
      if (localBehavior != null) {
        bool1 = localBehavior.blocksInteractionBelow(paramCoordinatorLayout, paramView);
      } else {
        bool1 = false;
      }
      bool1 |= bool2;
      mDidBlockInteraction = bool1;
      return bool1;
    }
    
    boolean isDirty(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      if ((paramView2 != mAnchorDirectChild) && (!onLayoutChild(paramView2, ViewCompat.getLayoutDirection(paramCoordinatorLayout))))
      {
        CoordinatorLayout.Behavior localBehavior = mBehavior;
        if ((localBehavior == null) || (!localBehavior.update(paramCoordinatorLayout, paramView1, paramView2))) {
          return false;
        }
      }
      return true;
    }
    
    boolean isPlayed()
    {
      return multiline;
    }
    
    public void setBehavior(CoordinatorLayout.Behavior paramBehavior)
    {
      CoordinatorLayout.Behavior localBehavior = mBehavior;
      if (localBehavior != paramBehavior)
      {
        if (localBehavior != null) {
          localBehavior.onRestoreInstanceState();
        }
        mBehavior = paramBehavior;
        mBehaviorTag = null;
        mBehaviorResolved = true;
        if (paramBehavior != null) {
          paramBehavior.onLayoutChild(this);
        }
      }
    }
    
    void setRect(Rect paramRect)
    {
      mRect.set(paramRect);
    }
  }
  
  class f
    implements ViewTreeObserver.OnPreDrawListener
  {
    f() {}
    
    public boolean onPreDraw()
    {
      onDraw(0);
      return true;
    }
  }
  
  static class g
    implements Comparator<View>
  {
    g() {}
    
    public int compare(View paramView1, View paramView2)
    {
      float f1 = ViewCompat.init(paramView1);
      float f2 = ViewCompat.init(paramView2);
      if (f1 > f2) {
        return -1;
      }
      if (f1 < f2) {
        return 1;
      }
      return 0;
    }
  }
}
