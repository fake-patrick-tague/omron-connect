package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import androidx.recyclerview.widget.ClassReader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.u;
import androidx.recyclerview.widget.RecyclerView.y;
import androidx.viewpager2.adapter.Fragment;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import v7.v7.package_13.asm.Label;
import v7.v7.package_13.asm.o;
import v7.widget.R.styleable;

public final class ViewPager2
  extends ViewGroup
{
  static boolean right;
  private boolean A = true;
  h a;
  private d b;
  private f c;
  private LinearLayoutManager d;
  boolean i = false;
  private f j = new f(3);
  private i l;
  private final Rect left = new Rect();
  private Parcelable m;
  private RecyclerView.i mObserver = new a();
  private int mOffscreenPageLimit = -1;
  private boolean mPaused = false;
  RecyclerView mRecyclerView;
  private final Rect mTmpRect = new Rect();
  private int n = -1;
  private RecyclerView.l o = null;
  private ClassReader r;
  e this$0;
  int x;
  
  public ViewPager2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  private void add()
  {
    if (n == -1) {
      return;
    }
    RecyclerView.Adapter localAdapter = getAdapter();
    if (localAdapter == null) {
      return;
    }
    Parcelable localParcelable = m;
    if (localParcelable != null)
    {
      if ((localAdapter instanceof Fragment)) {
        ((Fragment)localAdapter).a(localParcelable);
      }
      m = null;
    }
    int k = Math.max(0, Math.min(n, localAdapter.getItemCount() - 1));
    x = k;
    n = -1;
    mRecyclerView.scrollToPosition(k);
    this$0.updateMax();
  }
  
  private RecyclerView.p getStep()
  {
    return new d();
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    int[] arrayOfInt = R.styleable.PullToRefresh;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    if (Build.VERSION.SDK_INT >= 29) {
      saveAttributeDataForStyleable(paramContext, arrayOfInt, paramAttributeSet, localTypedArray, 0, 0);
    }
    try
    {
      setOrientation(localTypedArray.getInt(R.styleable.FlowLayout_LayoutParams_android_layout_gravity, 0));
      localTypedArray.recycle();
      return;
    }
    catch (Throwable paramContext)
    {
      localTypedArray.recycle();
      throw paramContext;
    }
  }
  
  private void setAdapterInternal(RecyclerView.Adapter paramAdapter)
  {
    if (paramAdapter != null) {
      paramAdapter.registerAdapterDataObserver(mObserver);
    }
  }
  
  private void unregisterAdapterDataObserver(RecyclerView.Adapter paramAdapter)
  {
    if (paramAdapter != null) {
      paramAdapter.unregisterAdapterDataObserver(mObserver);
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = getAdapter();
    if (localObject == null)
    {
      if (n != -1) {
        n = Math.max(paramInt, 0);
      }
    }
    else
    {
      if (((RecyclerView.Adapter)localObject).getItemCount() <= 0) {
        return;
      }
      int k = Math.min(Math.max(paramInt, 0), ((RecyclerView.Adapter)localObject).getItemCount() - 1);
      if ((k == x) && (a.k())) {
        return;
      }
      paramInt = x;
      if ((k == paramInt) && (paramBoolean)) {
        return;
      }
      double d1 = paramInt;
      x = k;
      this$0.visitEnum();
      if (!a.k()) {
        d1 = a.b();
      }
      a.a(k, paramBoolean);
      if (!paramBoolean)
      {
        mRecyclerView.scrollToPosition(k);
        return;
      }
      double d2 = k;
      if (Math.abs(d2 - d1) > 3.0D)
      {
        localObject = mRecyclerView;
        if (d2 > d1) {
          paramInt = k - 3;
        } else {
          paramInt = k + 3;
        }
        ((RecyclerView)localObject).scrollToPosition(paramInt);
        localObject = mRecyclerView;
        ((View)localObject).post(new n(k, (RecyclerView)localObject));
        return;
      }
      mRecyclerView.smoothScrollToPosition(k);
    }
  }
  
  public void a(i paramI)
  {
    j.b(paramI);
  }
  
  boolean a()
  {
    return d.getLayoutDirection() == 1;
  }
  
  public void add(int paramInt, boolean paramBoolean)
  {
    if (!d())
    {
      a(paramInt, paramBoolean);
      return;
    }
    throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
  }
  
  void b()
  {
    Object localObject = r;
    if (localObject != null)
    {
      localObject = ((ClassReader)localObject).b(d);
      if (localObject == null) {
        return;
      }
      int k = d.getPosition((View)localObject);
      if ((k != x) && (getScrollState() == 0)) {
        c.a(k);
      }
      i = false;
      return;
    }
    throw new IllegalStateException("Design assumption violated.");
  }
  
  public void b(i paramI)
  {
    j.a(paramI);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return mRecyclerView.canScrollHorizontally(paramInt);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return mRecyclerView.canScrollVertically(paramInt);
  }
  
  public boolean d()
  {
    return b.b();
  }
  
  protected void dispatchRestoreInstanceState(SparseArray paramSparseArray)
  {
    Parcelable localParcelable = (Parcelable)paramSparseArray.get(getId());
    if ((localParcelable instanceof SavedState))
    {
      int k = value;
      paramSparseArray.put(mRecyclerView.getId(), paramSparseArray.get(k));
      paramSparseArray.remove(k);
    }
    super.dispatchRestoreInstanceState(paramSparseArray);
    add();
  }
  
  public boolean get()
  {
    return A;
  }
  
  public CharSequence getAccessibilityClassName()
  {
    if (this$0.isStaticHeader()) {
      return this$0.getName();
    }
    return super.getAccessibilityClassName();
  }
  
  public RecyclerView.Adapter getAdapter()
  {
    return mRecyclerView.getAdapter();
  }
  
  public int getCurrentItem()
  {
    return x;
  }
  
  public int getItemDecorationCount()
  {
    return mRecyclerView.getItemDecorationCount();
  }
  
  public int getOffscreenPageLimit()
  {
    return mOffscreenPageLimit;
  }
  
  public int getOrientation()
  {
    return d.getOrientation();
  }
  
  int getPageSize()
  {
    RecyclerView localRecyclerView = mRecyclerView;
    int k;
    int i1;
    if (getOrientation() == 0)
    {
      k = localRecyclerView.getWidth() - localRecyclerView.getPaddingLeft();
      i1 = localRecyclerView.getPaddingRight();
    }
    else
    {
      k = localRecyclerView.getHeight() - localRecyclerView.getPaddingTop();
      i1 = localRecyclerView.getPaddingBottom();
    }
    return k - i1;
  }
  
  public int getScrollState()
  {
    return a.h();
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    this$0.filter(paramAccessibilityNodeInfo);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = mRecyclerView.getMeasuredWidth();
    int i1 = mRecyclerView.getMeasuredHeight();
    mTmpRect.left = getPaddingLeft();
    mTmpRect.right = (paramInt3 - paramInt1 - getPaddingRight());
    mTmpRect.top = getPaddingTop();
    mTmpRect.bottom = (paramInt4 - paramInt2 - getPaddingBottom());
    Gravity.apply(8388659, k, i1, mTmpRect, left);
    RecyclerView localRecyclerView = mRecyclerView;
    Rect localRect = left;
    localRecyclerView.layout(left, top, right, bottom);
    if (i) {
      b();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChild(mRecyclerView, paramInt1, paramInt2);
    int i4 = mRecyclerView.getMeasuredWidth();
    int i1 = mRecyclerView.getMeasuredHeight();
    int k = mRecyclerView.getMeasuredState();
    int i5 = getPaddingLeft();
    int i6 = getPaddingRight();
    int i2 = getPaddingTop();
    int i3 = getPaddingBottom();
    i4 = Math.max(i4 + (i5 + i6), getSuggestedMinimumWidth());
    i1 = Math.max(i1 + (i2 + i3), getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(i4, paramInt1, k), View.resolveSizeAndState(i1, paramInt2, k << 16));
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
    n = position;
    m = adapterState;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    value = mRecyclerView.getId();
    int i1 = n;
    int k = i1;
    if (i1 == -1) {
      k = x;
    }
    position = k;
    Object localObject = m;
    if (localObject != null)
    {
      adapterState = ((Parcelable)localObject);
      return localSavedState;
    }
    localObject = mRecyclerView.getAdapter();
    if ((localObject instanceof Fragment)) {
      adapterState = ((Fragment)localObject).saveState();
    }
    return localSavedState;
  }
  
  public void onViewAdded(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(ViewPager2.class.getSimpleName());
    paramView.append(" does not support direct child views");
    throw new IllegalStateException(paramView.toString());
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (this$0.get(paramInt, paramBundle)) {
      return this$0.a(paramInt, paramBundle);
    }
    return super.performAccessibilityAction(paramInt, paramBundle);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    RecyclerView.Adapter localAdapter = mRecyclerView.getAdapter();
    this$0.setAdapterInternal(localAdapter);
    unregisterAdapterDataObserver(localAdapter);
    mRecyclerView.setAdapter(paramAdapter);
    x = 0;
    add();
    this$0.setAdapter(paramAdapter);
    setAdapterInternal(paramAdapter);
  }
  
  public void setCurrentItem(int paramInt)
  {
    add(paramInt, true);
  }
  
  public void setIcon()
  {
    if (l.a() == null) {
      return;
    }
    double d1 = a.b();
    int k = (int)d1;
    float f = (float)(d1 - k);
    int i1 = Math.round(getPageSize() * f);
    l.a(k, f, i1);
  }
  
  public void setLayoutDirection(int paramInt)
  {
    super.setLayoutDirection(paramInt);
    this$0.showValueOnSummary();
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    if ((paramInt < 1) && (paramInt != -1)) {
      throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }
    mOffscreenPageLimit = paramInt;
    mRecyclerView.requestLayout();
  }
  
  public void setOrientation(int paramInt)
  {
    d.setOrientation(paramInt);
    this$0.pack();
  }
  
  public void setPageTransformer(k paramK)
  {
    if (paramK != null)
    {
      if (!mPaused)
      {
        o = mRecyclerView.getItemAnimator();
        mPaused = true;
      }
      mRecyclerView.setItemAnimator(null);
    }
    else if (mPaused)
    {
      mRecyclerView.setItemAnimator(o);
      o = null;
      mPaused = false;
    }
    if (paramK == l.a()) {
      return;
    }
    l.e(paramK);
    setIcon();
  }
  
  public void setUserInputEnabled(boolean paramBoolean)
  {
    A = paramBoolean;
    this$0.b();
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    Parcelable adapterState;
    int position;
    int value;
    
    SavedState(Parcel paramParcel)
    {
      super();
      readFromParcel(paramParcel, null);
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      readFromParcel(paramParcel, paramClassLoader);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    private void readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      value = paramParcel.readInt();
      position = paramParcel.readInt();
      adapterState = paramParcel.readParcelable(paramClassLoader);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(value);
      paramParcel.writeInt(position);
      paramParcel.writeParcelable(adapterState, paramInt);
    }
    
    static final class a
      implements Parcelable.ClassLoaderCreator<ViewPager2.SavedState>
    {
      a() {}
      
      public ViewPager2.SavedState[] a(int paramInt)
      {
        return new ViewPager2.SavedState[paramInt];
      }
      
      public ViewPager2.SavedState getInstance(Parcel paramParcel)
      {
        return getInstance(paramParcel, null);
      }
      
      public ViewPager2.SavedState getInstance(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        if (Build.VERSION.SDK_INT >= 24) {
          return new ViewPager2.SavedState(paramParcel, paramClassLoader);
        }
        return new ViewPager2.SavedState(paramParcel);
      }
    }
  }
  
  class a
    extends ViewPager2.g
  {
    a()
    {
      super();
    }
    
    public void onChanged()
    {
      ViewPager2 localViewPager2 = ViewPager2.this;
      i = true;
      a.e();
    }
  }
  
  class b
    extends ViewPager2.i
  {
    b() {}
    
    public void a(int paramInt)
    {
      ViewPager2 localViewPager2 = ViewPager2.this;
      if (x != paramInt)
      {
        x = paramInt;
        this$0.visitEnum();
      }
    }
    
    public void b(int paramInt)
    {
      if (paramInt == 0) {
        b();
      }
    }
  }
  
  class c
    extends ViewPager2.i
  {
    c() {}
    
    public void a(int paramInt)
    {
      clearFocus();
      if (hasFocus()) {
        mRecyclerView.requestFocus(2);
      }
    }
  }
  
  class d
    implements RecyclerView.p
  {
    d() {}
    
    public void bindView(View paramView)
    {
      paramView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((width == -1) && (height == -1)) {
        return;
      }
      throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
    }
    
    public void onChildViewDetachedFromWindow(View paramView) {}
  }
  
  private abstract class e
  {
    private e() {}
    
    void a(f paramF, RecyclerView paramRecyclerView) {}
    
    boolean a(int paramInt)
    {
      return false;
    }
    
    boolean a(int paramInt, Bundle paramBundle)
    {
      throw new IllegalStateException("Not implemented.");
    }
    
    void accept(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
    
    void b() {}
    
    boolean b(int paramInt)
    {
      throw new IllegalStateException("Not implemented.");
    }
    
    void filter(AccessibilityNodeInfo paramAccessibilityNodeInfo) {}
    
    boolean get(int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    String getName()
    {
      throw new IllegalStateException("Not implemented.");
    }
    
    boolean isShowing()
    {
      return false;
    }
    
    boolean isStaticHeader()
    {
      return false;
    }
    
    void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {}
    
    void pack() {}
    
    void setAdapter(RecyclerView.Adapter paramAdapter) {}
    
    void setAdapterInternal(RecyclerView.Adapter paramAdapter) {}
    
    void showValueOnSummary() {}
    
    CharSequence startActionMode()
    {
      throw new IllegalStateException("Not implemented.");
    }
    
    void updateMax() {}
    
    void visitEnum() {}
  }
  
  class f
    extends ViewPager2.e
  {
    f()
    {
      super(null);
    }
    
    public boolean a(int paramInt)
    {
      return ((paramInt == 8192) || (paramInt == 4096)) && (!get());
    }
    
    public void accept(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if (!get())
      {
        paramAccessibilityNodeInfoCompat.setText(Label.b);
        paramAccessibilityNodeInfoCompat.setText(Label.a);
        paramAccessibilityNodeInfoCompat.setScrollable(false);
      }
    }
    
    public boolean b(int paramInt)
    {
      if (a(paramInt)) {
        return false;
      }
      throw new IllegalStateException();
    }
    
    public boolean isShowing()
    {
      return true;
    }
    
    public CharSequence startActionMode()
    {
      if (isShowing()) {
        return "androidx.viewpager.widget.ViewPager";
      }
      throw new IllegalStateException();
    }
  }
  
  private static abstract class g
    extends RecyclerView.i
  {
    private g() {}
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      onChanged();
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      onChanged();
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      onChanged();
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      onChanged();
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      onChanged();
    }
  }
  
  private class h
    extends LinearLayoutManager
  {
    h(Context paramContext)
    {
      super();
    }
    
    public boolean a(RecyclerView.u paramU, RecyclerView.y paramY, int paramInt, Bundle paramBundle)
    {
      if (this$0.a(paramInt)) {
        return this$0.b(paramInt);
      }
      return super.a(paramU, paramY, paramInt, paramBundle);
    }
    
    public void onInitializeAccessibilityNodeInfo(RecyclerView.u paramU, RecyclerView.y paramY, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramU, paramY, paramAccessibilityNodeInfoCompat);
      this$0.accept(paramAccessibilityNodeInfoCompat);
    }
    
    protected void onLayoutChildren(RecyclerView.y paramY, int[] paramArrayOfInt)
    {
      int i = getOffscreenPageLimit();
      if (i == -1)
      {
        super.onLayoutChildren(paramY, paramArrayOfInt);
        return;
      }
      i = getPageSize() * i;
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = i;
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
    {
      return false;
    }
  }
  
  public static abstract class i
  {
    public i() {}
    
    public void a(int paramInt) {}
    
    public void a(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void b(int paramInt) {}
  }
  
  class j
    extends ViewPager2.e
  {
    private final v7.v7.package_13.asm.d b = new b();
    private final v7.v7.package_13.asm.d l = new a();
    private RecyclerView.i mObserver;
    
    j()
    {
      super(null);
    }
    
    private void add(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      int i;
      int j;
      if (getAdapter() != null)
      {
        if (getOrientation() == 1)
        {
          i = getAdapter().getItemCount();
          j = 0;
        }
        else
        {
          j = getAdapter().getItemCount();
          i = 0;
        }
      }
      else
      {
        i = 0;
        j = 0;
      }
      AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfo).setParent(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i, j, false, 0));
    }
    
    private void get(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      RecyclerView.Adapter localAdapter = getAdapter();
      if (localAdapter == null) {
        return;
      }
      int i = localAdapter.getItemCount();
      if (i != 0)
      {
        if (!get()) {
          return;
        }
        if (x > 0) {
          paramAccessibilityNodeInfo.addAction(8192);
        }
        if (x < i - 1) {
          paramAccessibilityNodeInfo.addAction(4096);
        }
        paramAccessibilityNodeInfo.setScrollable(true);
      }
    }
    
    public void a(f paramF, RecyclerView paramRecyclerView)
    {
      ViewCompat.get(paramRecyclerView, 2);
      mObserver = new c();
      if (ViewCompat.getImportantForAccessibility(ViewPager2.this) == 0) {
        ViewCompat.get(ViewPager2.this, 1);
      }
    }
    
    public boolean a(int paramInt, Bundle paramBundle)
    {
      if (get(paramInt, paramBundle))
      {
        if (paramInt == 8192) {
          paramInt = getCurrentItem() - 1;
        } else {
          paramInt = getCurrentItem() + 1;
        }
        c(paramInt);
        return true;
      }
      throw new IllegalStateException();
    }
    
    void add()
    {
      ViewPager2 localViewPager2 = ViewPager2.this;
      int j = 16908360;
      ViewCompat.a(localViewPager2, 16908360);
      ViewCompat.a(localViewPager2, 16908361);
      ViewCompat.a(localViewPager2, 16908358);
      ViewCompat.a(localViewPager2, 16908359);
      if (getAdapter() == null) {
        return;
      }
      int k = getAdapter().getItemCount();
      if (k == 0) {
        return;
      }
      if (!get()) {
        return;
      }
      if (getOrientation() == 0)
      {
        boolean bool = a();
        int i;
        if (bool) {
          i = 16908360;
        } else {
          i = 16908361;
        }
        if (bool) {
          j = 16908361;
        }
        if (x < k - 1) {
          ViewCompat.a(localViewPager2, new Label(i, null), null, l);
        }
        if (x > 0) {
          ViewCompat.a(localViewPager2, new Label(j, null), null, b);
        }
      }
      else
      {
        if (x < k - 1) {
          ViewCompat.a(localViewPager2, new Label(16908359, null), null, l);
        }
        if (x > 0) {
          ViewCompat.a(localViewPager2, new Label(16908358, null), null, b);
        }
      }
    }
    
    public void b()
    {
      add();
      if (Build.VERSION.SDK_INT < 21) {
        sendAccessibilityEvent(2048);
      }
    }
    
    void c(int paramInt)
    {
      if (get()) {
        a(paramInt, true);
      }
    }
    
    public void filter(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      add(paramAccessibilityNodeInfo);
      if (Build.VERSION.SDK_INT >= 16) {
        get(paramAccessibilityNodeInfo);
      }
    }
    
    public boolean get(int paramInt, Bundle paramBundle)
    {
      return (paramInt == 8192) || (paramInt == 4096);
    }
    
    public String getName()
    {
      if (isStaticHeader()) {
        return "androidx.viewpager.widget.ViewPager";
      }
      throw new IllegalStateException();
    }
    
    public boolean isStaticHeader()
    {
      return true;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      paramAccessibilityEvent.setSource(ViewPager2.this);
      paramAccessibilityEvent.setClassName(getName());
    }
    
    public void pack()
    {
      add();
    }
    
    public void setAdapter(RecyclerView.Adapter paramAdapter)
    {
      add();
      if (paramAdapter != null) {
        paramAdapter.registerAdapterDataObserver(mObserver);
      }
    }
    
    public void setAdapterInternal(RecyclerView.Adapter paramAdapter)
    {
      if (paramAdapter != null) {
        paramAdapter.unregisterAdapterDataObserver(mObserver);
      }
    }
    
    public void showValueOnSummary()
    {
      add();
    }
    
    public void updateMax()
    {
      add();
    }
    
    public void visitEnum()
    {
      add();
    }
    
    class a
      implements v7.v7.package_13.asm.d
    {
      a() {}
      
      public boolean b(View paramView, o paramO)
      {
        paramView = (ViewPager2)paramView;
        c(paramView.getCurrentItem() + 1);
        return true;
      }
    }
    
    class b
      implements v7.v7.package_13.asm.d
    {
      b() {}
      
      public boolean b(View paramView, o paramO)
      {
        paramView = (ViewPager2)paramView;
        c(paramView.getCurrentItem() - 1);
        return true;
      }
    }
    
    class c
      extends ViewPager2.g
    {
      c()
      {
        super();
      }
      
      public void onChanged()
      {
        add();
      }
    }
  }
  
  public static abstract interface k
  {
    public abstract void a(View paramView, float paramFloat);
  }
  
  private class l
    extends ClassReader
  {
    l() {}
    
    public View b(RecyclerView.o paramO)
    {
      if (d()) {
        return null;
      }
      return super.b(paramO);
    }
  }
  
  private class m
    extends RecyclerView
  {
    m(Context paramContext)
    {
      super();
    }
    
    public CharSequence getAccessibilityClassName()
    {
      if (this$0.isShowing()) {
        return this$0.startActionMode();
      }
      return super.getAccessibilityClassName();
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setFromIndex(x);
      paramAccessibilityEvent.setToIndex(x);
      this$0.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      return (get()) && (super.onInterceptTouchEvent(paramMotionEvent));
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      return (get()) && (super.onTouchEvent(paramMotionEvent));
    }
  }
  
  private static class n
    implements Runnable
  {
    private final int mDirection;
    private final RecyclerView mRecyclerView;
    
    n(int paramInt, RecyclerView paramRecyclerView)
    {
      mDirection = paramInt;
      mRecyclerView = paramRecyclerView;
    }
    
    public void run()
    {
      mRecyclerView.smoothScrollToPosition(mDirection);
    }
  }
}
