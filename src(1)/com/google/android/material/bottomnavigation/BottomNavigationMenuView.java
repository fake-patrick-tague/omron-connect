package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.f;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionSet;
import androidx.transition.i;
import c.h.p.e;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.LayoutManager;
import java.util.ArrayList;
import java.util.HashSet;
import org.org.org.ui.R.raw;
import v7.internal.R.attr;
import v7.text.view.menu.FastOutLinearInInterpolator;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import v7.v7.util.Pools.Pool;
import v7.v7.util.Pools.SynchronizedPool;

public class BottomNavigationMenuView
  extends ViewGroup
  implements MenuView
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int[] SELECTED_STATE_SET = { -16842910 };
  private ColorStateList B;
  private int Q;
  private BottomNavigationItemView[] a;
  private f b;
  private final ColorStateList c;
  private int d;
  private final e<BottomNavigationItemView> e = new Pools.SynchronizedPool(5);
  private boolean f;
  private final int h;
  private final TransitionSet i;
  private final int j;
  private int k = 0;
  private ColorStateList l;
  private Drawable m;
  private final int mHeight;
  private final int mMaxHeight;
  private final int mMinHeight;
  private BottomNavigationPresenter n;
  private int o;
  private final View.OnClickListener q;
  private int r;
  private int s;
  private SparseArray<BadgeDrawable> selectedItems = new SparseArray(5);
  private final SparseArray<View.OnTouchListener> w = new SparseArray(5);
  private int x = 0;
  private int[] y;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    mHeight = paramContext.getDimensionPixelSize(R.raw.u);
    mMinHeight = paramContext.getDimensionPixelSize(R.raw.b);
    mMaxHeight = paramContext.getDimensionPixelSize(R.raw.f);
    h = paramContext.getDimensionPixelSize(R.raw.c);
    j = paramContext.getDimensionPixelSize(R.raw.e);
    c = createDefaultColorStateList(16842808);
    paramContext = new AutoTransition();
    i = paramContext;
    paramContext.close(0);
    paramContext.add(115L);
    paramContext.initialize(new FastOutLinearInInterpolator());
    paramContext.init(new LayoutManager());
    q = new a();
    y = new int[5];
    ViewCompat.get(this, 1);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      if (paramInt2 > 3) {
        return true;
      }
    }
    else if (paramInt1 == 0) {
      return true;
    }
    return false;
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)e.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  private void getSelectedItems()
  {
    HashSet localHashSet = new HashSet();
    int i3 = 0;
    int i2 = 0;
    int i1;
    for (;;)
    {
      i1 = i3;
      if (i2 >= b.size()) {
        break;
      }
      localHashSet.add(Integer.valueOf(b.getItem(i2).getItemId()));
      i2 += 1;
    }
    while (i1 < selectedItems.size())
    {
      i2 = selectedItems.keyAt(i1);
      if (!localHashSet.contains(Integer.valueOf(i2))) {
        selectedItems.delete(i2);
      }
      i1 += 1;
    }
  }
  
  private boolean isStarred(int paramInt)
  {
    return paramInt != -1;
  }
  
  private void setBadgeIfNeeded(BottomNavigationItemView paramBottomNavigationItemView)
  {
    int i1 = paramBottomNavigationItemView.getId();
    if (!isStarred(i1)) {
      return;
    }
    BadgeDrawable localBadgeDrawable = (BadgeDrawable)selectedItems.get(i1);
    if (localBadgeDrawable != null) {
      paramBottomNavigationItemView.setBadge(localBadgeDrawable);
    }
  }
  
  public void a()
  {
    removeAllViews();
    Object localObject1 = a;
    BottomNavigationMenuView localBottomNavigationMenuView = this;
    int i2;
    Object localObject2;
    if (localObject1 != null)
    {
      i2 = localObject1.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject2 = localObject1[i1];
        if (localObject2 != null)
        {
          e.release(localObject2);
          ((BottomNavigationItemView)localObject2).f();
        }
        i1 += 1;
      }
    }
    if (b.size() == 0)
    {
      k = 0;
      x = 0;
      a = null;
      return;
    }
    localBottomNavigationMenuView.getSelectedItems();
    a = new BottomNavigationItemView[b.size()];
    boolean bool = localBottomNavigationMenuView.a(d, b.getVisibleItems().size());
    int i1 = 0;
    while (i1 < b.size())
    {
      n.a(true);
      b.getItem(i1).setCheckable(true);
      n.a(false);
      localObject1 = localBottomNavigationMenuView.getNewItem();
      localObject2 = a;
      localObject2[i1] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(l);
      ((BottomNavigationItemView)localObject1).setIconSize(s);
      ((BottomNavigationItemView)localObject1).setTextColor(c);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(r);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(o);
      ((BottomNavigationItemView)localObject1).setTextColor(B);
      localObject2 = m;
      if (localObject2 != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground((Drawable)localObject2);
      } else {
        ((BottomNavigationItemView)localObject1).setItemBackground(Q);
      }
      ((BottomNavigationItemView)localObject1).setShifting(bool);
      ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(d);
      localObject2 = (MenuItemImpl)b.getItem(i1);
      ((BottomNavigationItemView)localObject1).initialize((MenuItemImpl)localObject2, 0);
      ((BottomNavigationItemView)localObject1).setItemPosition(i1);
      i2 = ((MenuItemImpl)localObject2).getItemId();
      ((android.view.View)localObject1).setOnTouchListener((View.OnTouchListener)w.get(i2));
      ((android.view.View)localObject1).setOnClickListener(q);
      int i3 = k;
      if ((i3 != 0) && (i2 == i3)) {
        x = i1;
      }
      localBottomNavigationMenuView.setBadgeIfNeeded((BottomNavigationItemView)localObject1);
      localBottomNavigationMenuView.addView((android.view.View)localObject1);
      i1 += 1;
    }
    i1 = Math.min(b.size() - 1, x);
    x = i1;
    b.getItem(i1).setChecked(true);
  }
  
  void b(int paramInt)
  {
    int i2 = b.size();
    int i1 = 0;
    while (i1 < i2)
    {
      MenuItem localMenuItem = b.getItem(i1);
      if (paramInt == localMenuItem.getItemId())
      {
        k = paramInt;
        x = i1;
        localMenuItem.setChecked(true);
        return;
      }
      i1 += 1;
    }
  }
  
  public void c()
  {
    Object localObject = b;
    if (localObject != null)
    {
      if (a == null) {
        return;
      }
      int i2 = ((f)localObject).size();
      if (i2 != a.length)
      {
        a();
        return;
      }
      int i3 = k;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = b.getItem(i1);
        if (((MenuItem)localObject).isChecked())
        {
          k = ((MenuItem)localObject).getItemId();
          x = i1;
        }
        i1 += 1;
      }
      if (i3 != k) {
        i.a(this, i);
      }
      boolean bool = a(d, b.getVisibleItems().size());
      i1 = 0;
      while (i1 < i2)
      {
        n.a(true);
        a[i1].setLabelVisibilityMode(d);
        a[i1].setShifting(bool);
        a[i1].initialize((MenuItemImpl)b.getItem(i1), 0);
        n.a(false);
        i1 += 1;
      }
    }
  }
  
  public ColorStateList createDefaultColorStateList(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {
      return null;
    }
    ColorStateList localColorStateList = v7.internal.transition.util.View.a(getContext(), resourceId);
    if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, (TypedValue)localObject, true)) {
      return null;
    }
    paramInt = data;
    int i1 = localColorStateList.getDefaultColor();
    localObject = SELECTED_STATE_SET;
    int[] arrayOfInt1 = CHECKED_STATE_SET;
    int[] arrayOfInt2 = android.view.View.EMPTY_STATE_SET;
    int i2 = localColorStateList.getColorForState((int[])localObject, i1);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { i2, paramInt, i1 });
  }
  
  public boolean f()
  {
    return f;
  }
  
  SparseArray getBadgeDrawables()
  {
    return selectedItems;
  }
  
  public ColorStateList getIconTintList()
  {
    return l;
  }
  
  public Drawable getItemBackground()
  {
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = a;
    if ((arrayOfBottomNavigationItemView != null) && (arrayOfBottomNavigationItemView.length > 0)) {
      return arrayOfBottomNavigationItemView[0].getBackground();
    }
    return m;
  }
  
  public int getItemBackgroundRes()
  {
    return Q;
  }
  
  public int getItemIconSize()
  {
    return s;
  }
  
  public int getItemTextAppearanceActive()
  {
    return o;
  }
  
  public int getItemTextAppearanceInactive()
  {
    return r;
  }
  
  public ColorStateList getItemTextColor()
  {
    return B;
  }
  
  public int getLabelVisibilityMode()
  {
    return d;
  }
  
  public int getSelectedItemId()
  {
    return k;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void initialize(f paramF)
  {
    b = paramF;
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfo).setParent(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, b.getVisibleItems().size(), false, 1));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i2 = paramInt4 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt2 < i1)
    {
      android.view.View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        if (ViewCompat.getLayoutDirection(this) == 1)
        {
          int i3 = paramInt3 - paramInt1 - paramInt4;
          localView.layout(i3 - localView.getMeasuredWidth(), 0, i3, i2);
        }
        else
        {
          localView.layout(paramInt4, 0, localView.getMeasuredWidth() + paramInt4, i2);
        }
        paramInt4 += localView.getMeasuredWidth();
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i1 = b.getVisibleItems().size();
    int i4 = getChildCount();
    int i5 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
    Object localObject;
    int i2;
    if ((a(d, i1)) && (f))
    {
      localObject = getChildAt(x);
      paramInt2 = h;
      paramInt1 = paramInt2;
      if (((android.view.View)localObject).getVisibility() != 8)
      {
        ((android.view.View)localObject).measure(View.MeasureSpec.makeMeasureSpec(mMaxHeight, Integer.MIN_VALUE), i5);
        paramInt1 = Math.max(paramInt2, ((android.view.View)localObject).getMeasuredWidth());
      }
      if (((android.view.View)localObject).getVisibility() != 8) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramInt2 = i1 - paramInt2;
      i2 = Math.min(i3 - mMinHeight * paramInt2, Math.min(paramInt1, mMaxHeight));
      i1 = i3 - i2;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = paramInt2;
      }
      i3 = Math.min(i1 / paramInt1, mHeight);
      paramInt2 = i1 - paramInt2 * i3;
      paramInt1 = 0;
    }
    while (paramInt1 < i4)
    {
      if (getChildAt(paramInt1).getVisibility() != 8)
      {
        localObject = y;
        if (paramInt1 == x) {
          i1 = i2;
        } else {
          i1 = i3;
        }
        localObject[paramInt1] = i1;
        i1 = paramInt2;
        if (paramInt2 > 0)
        {
          localObject[paramInt1] += 1;
          i1 = paramInt2 - 1;
        }
      }
      else
      {
        y[paramInt1] = 0;
        i1 = paramInt2;
      }
      paramInt1 += 1;
      paramInt2 = i1;
      continue;
      if (i1 == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = i1;
      }
      i2 = Math.min(i3 / paramInt1, mMaxHeight);
      paramInt2 = i3 - i1 * i2;
      paramInt1 = 0;
      while (paramInt1 < i4)
      {
        if (getChildAt(paramInt1).getVisibility() != 8)
        {
          localObject = y;
          localObject[paramInt1] = i2;
          i1 = paramInt2;
          if (paramInt2 > 0)
          {
            localObject[paramInt1] += 1;
            i1 = paramInt2 - 1;
          }
        }
        else
        {
          y[paramInt1] = 0;
          i1 = paramInt2;
        }
        paramInt1 += 1;
        paramInt2 = i1;
      }
    }
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < i4)
    {
      localObject = getChildAt(paramInt1);
      if (((android.view.View)localObject).getVisibility() != 8)
      {
        ((android.view.View)localObject).measure(View.MeasureSpec.makeMeasureSpec(y[paramInt1], 1073741824), i5);
        getLayoutParamswidth = ((android.view.View)localObject).getMeasuredWidth();
        paramInt2 += ((android.view.View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(android.view.View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), android.view.View.resolveSizeAndState(j, i5, 0));
  }
  
  void setBadgeDrawables(SparseArray paramSparseArray)
  {
    selectedItems = paramSparseArray;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = a;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i1];
        localBottomNavigationItemView.setBadge((BadgeDrawable)paramSparseArray.get(localBottomNavigationItemView.getId()));
        i1 += 1;
      }
    }
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    l = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = a;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfBottomNavigationItemView[i1].setIconTintList(paramColorStateList);
        i1 += 1;
      }
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    m = paramDrawable;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = a;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfBottomNavigationItemView[i1].setItemBackground(paramDrawable);
        i1 += 1;
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    Q = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = a;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfBottomNavigationItemView[i1].setItemBackground(paramInt);
        i1 += 1;
      }
    }
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    f = paramBoolean;
  }
  
  public void setItemIconSize(int paramInt)
  {
    s = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = a;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfBottomNavigationItemView[i1].setIconSize(paramInt);
        i1 += 1;
      }
    }
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    o = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = a;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i1];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        ColorStateList localColorStateList = B;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
        i1 += 1;
      }
    }
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    r = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = a;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i1];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        ColorStateList localColorStateList = B;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
        i1 += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    B = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = a;
    if (arrayOfBottomNavigationItemView != null)
    {
      int i2 = arrayOfBottomNavigationItemView.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfBottomNavigationItemView[i1].setTextColor(paramColorStateList);
        i1 += 1;
      }
    }
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    d = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    n = paramBottomNavigationPresenter;
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(android.view.View paramView)
    {
      paramView = ((BottomNavigationItemView)paramView).getItemData();
      if (!BottomNavigationMenuView.b(BottomNavigationMenuView.this).a(paramView, BottomNavigationMenuView.a(BottomNavigationMenuView.this), 0)) {
        paramView.setChecked(true);
      }
    }
  }
}
