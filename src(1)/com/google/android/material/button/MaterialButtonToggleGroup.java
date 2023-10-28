package com.google.android.material.button;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.material.theme.utils.Effect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.org.org.ui.ClassWriter;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import org.org.org.ui.asm.Item;
import org.org.org.ui.asm.m;
import v7.v7.package_13.ActionMenuItemView;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import v7.v7.package_13.asm.ByteVector;

public class MaterialButtonToggleGroup
  extends LinearLayout
{
  private static final int ROW = R.string.condition_clouds_scattered;
  private static final String TAG = MaterialButtonToggleGroup.class.getSimpleName();
  private final List<d> a = new ArrayList();
  private final Comparator<MaterialButton> c = new a();
  private boolean g;
  private int i;
  private Integer[] id;
  private final f j = new f(null);
  private final LinkedHashSet<e> k = new LinkedHashSet();
  private boolean l;
  private final c o = new c(null);
  private boolean p = false;
  
  public MaterialButtonToggleGroup(android.content.Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, ClassWriter.key);
  }
  
  public MaterialButtonToggleGroup(android.content.Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(Effect.a(paramContext, paramAttributeSet, paramInt, m), paramAttributeSet, paramInt);
    paramContext = com.google.android.material.internal.Label.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.SeekBarPreference, paramInt, m, new int[0]);
    setSingleSelection(paramContext.getBoolean(R.styleable.ImageView_adjustViewBounds, false));
    i = paramContext.getResourceId(R.styleable.Preference_android_icon, -1);
    g = paramContext.getBoolean(R.styleable.Preference_key, false);
    setChildrenDrawingOrderEnabled(true);
    paramContext.recycle();
    v7.v7.package_13.ViewCompat.get(this, 1);
  }
  
  private int a(View paramView)
  {
    if (!(paramView instanceof MaterialButton)) {
      return -1;
    }
    int m = 0;
    int i1;
    for (int n = 0; m < getChildCount(); n = i1)
    {
      if (getChildAt(m) == paramView) {
        return n;
      }
      i1 = n;
      if ((getChildAt(m) instanceof MaterialButton))
      {
        i1 = n;
        if (p(m)) {
          i1 = n + 1;
        }
      }
      m += 1;
    }
    return -1;
  }
  
  private d a(int paramInt1, int paramInt2, int paramInt3)
  {
    d localD = (d)a.get(paramInt1);
    if (paramInt2 == paramInt3) {
      return localD;
    }
    int m;
    if (getOrientation() == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (paramInt1 == paramInt2)
    {
      if (m != 0) {
        return d.a(localD, this);
      }
      return d.p(localD);
    }
    if (paramInt1 == paramInt3)
    {
      if (m != 0) {
        return d.b(localD, this);
      }
      return d.b(localD);
    }
    return null;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = k.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).b(this, paramInt, paramBoolean);
    }
  }
  
  private boolean add(int paramInt, boolean paramBoolean)
  {
    Object localObject = getCheckedButtonIds();
    if ((g) && (((List)localObject).isEmpty()))
    {
      set(paramInt, true);
      i = paramInt;
      return false;
    }
    if ((paramBoolean) && (l))
    {
      ((List)localObject).remove(Integer.valueOf(paramInt));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramInt = ((Integer)((Iterator)localObject).next()).intValue();
        set(paramInt, false);
        a(paramInt, false);
      }
    }
    return true;
  }
  
  private static void b(Item paramItem, d paramD)
  {
    if (paramD == null)
    {
      paramItem.c(0.0F);
      return;
    }
    paramItem.get(i).b(j).a(e).c(a);
  }
  
  private void create()
  {
    TreeMap localTreeMap = new TreeMap(c);
    int n = getChildCount();
    int m = 0;
    while (m < n)
    {
      localTreeMap.put(next(m), Integer.valueOf(m));
      m += 1;
    }
    id = ((Integer[])localTreeMap.values().toArray(new Integer[0]));
  }
  
  private LinearLayout.LayoutParams get(View paramView)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof LinearLayout.LayoutParams)) {
      return (LinearLayout.LayoutParams)paramView;
    }
    return new LinearLayout.LayoutParams(width, height);
  }
  
  private int getFirstVisibleChildIndex()
  {
    int n = getChildCount();
    int m = 0;
    while (m < n)
    {
      if (p(m)) {
        return m;
      }
      m += 1;
    }
    return -1;
  }
  
  private int getLastVisibleChildIndex()
  {
    int m = getChildCount() - 1;
    while (m >= 0)
    {
      if (p(m)) {
        return m;
      }
      m -= 1;
    }
    return -1;
  }
  
  private int getVisibleButtonCount()
  {
    int m = 0;
    int i1;
    for (int n = 0; m < getChildCount(); n = i1)
    {
      i1 = n;
      if ((getChildAt(m) instanceof MaterialButton))
      {
        i1 = n;
        if (p(m)) {
          i1 = n + 1;
        }
      }
      m += 1;
    }
    return n;
  }
  
  private MaterialButton next(int paramInt)
  {
    return (MaterialButton)getChildAt(paramInt);
  }
  
  private boolean p(int paramInt)
  {
    return getChildAt(paramInt).getVisibility() != 8;
  }
  
  private void set(int paramInt, boolean paramBoolean)
  {
    View localView = findViewById(paramInt);
    if ((localView instanceof MaterialButton))
    {
      p = true;
      ((MaterialButton)localView).setChecked(paramBoolean);
      p = false;
    }
  }
  
  private void setCheckedId(int paramInt)
  {
    i = paramInt;
    a(paramInt, true);
  }
  
  private void setGeneratedIdIfNeeded(MaterialButton paramMaterialButton)
  {
    if (paramMaterialButton.getId() == -1) {
      paramMaterialButton.setId(v7.v7.package_13.ViewCompat.generateViewId());
    }
  }
  
  private void setupButtonChild(MaterialButton paramMaterialButton)
  {
    paramMaterialButton.setMaxLines(1);
    paramMaterialButton.setEllipsize(TextUtils.TruncateAt.END);
    paramMaterialButton.setCheckable(true);
    paramMaterialButton.removeChildren(o);
    paramMaterialButton.setOnPressedChangeListenerInternal(j);
    paramMaterialButton.setShouldDrawSurfaceColorStroke(true);
  }
  
  private void show()
  {
    int n = getFirstVisibleChildIndex();
    if (n == -1) {
      return;
    }
    int m = n + 1;
    while (m < getChildCount())
    {
      MaterialButton localMaterialButton = next(m);
      Object localObject = next(m - 1);
      int i1 = Math.min(localMaterialButton.getStrokeWidth(), ((MaterialButton)localObject).getStrokeWidth());
      localObject = get(localMaterialButton);
      if (getOrientation() == 0)
      {
        v7.v7.package_13.Log.init((ViewGroup.MarginLayoutParams)localObject, 0);
        v7.v7.package_13.Log.show((ViewGroup.MarginLayoutParams)localObject, -i1);
        topMargin = 0;
      }
      else
      {
        bottomMargin = 0;
        topMargin = (-i1);
        v7.v7.package_13.Log.show((ViewGroup.MarginLayoutParams)localObject, 0);
      }
      localMaterialButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      m += 1;
    }
    show(n);
  }
  
  private void show(int paramInt)
  {
    if (getChildCount() != 0)
    {
      if (paramInt == -1) {
        return;
      }
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)next(paramInt).getLayoutParams();
      if (getOrientation() == 1)
      {
        topMargin = 0;
        bottomMargin = 0;
        return;
      }
      v7.v7.package_13.Log.init(localLayoutParams, 0);
      v7.v7.package_13.Log.show(localLayoutParams, 0);
      leftMargin = 0;
      rightMargin = 0;
    }
  }
  
  private void updateDate(int paramInt)
  {
    set(paramInt, true);
    add(paramInt, true);
    setCheckedId(paramInt);
  }
  
  public void a()
  {
    p = true;
    int m = 0;
    while (m < getChildCount())
    {
      MaterialButton localMaterialButton = next(m);
      localMaterialButton.setChecked(false);
      a(localMaterialButton.getId(), false);
      m += 1;
    }
    p = false;
    setCheckedId(-1);
  }
  
  public void addValue(e paramE)
  {
    k.add(paramE);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!(paramView instanceof MaterialButton))
    {
      android.util.Log.e(TAG, "Child views must be of type MaterialButton.");
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    paramView = (MaterialButton)paramView;
    setGeneratedIdIfNeeded(paramView);
    setupButtonChild(paramView);
    if (paramView.isChecked())
    {
      add(paramView.getId(), true);
      setCheckedId(paramView.getId());
    }
    paramLayoutParams = paramView.getShapeAppearanceModel();
    a.add(new d(paramLayoutParams.c(), paramLayoutParams.f(), paramLayoutParams.e(), paramLayoutParams.k()));
    v7.v7.package_13.ViewCompat.a(paramView, new b());
  }
  
  void d()
  {
    int n = getChildCount();
    int i1 = getFirstVisibleChildIndex();
    int i2 = getLastVisibleChildIndex();
    int m = 0;
    while (m < n)
    {
      MaterialButton localMaterialButton = next(m);
      if (localMaterialButton.getVisibility() != 8)
      {
        Item localItem = localMaterialButton.getShapeAppearanceModel().get();
        b(localItem, a(m, i1, i2));
        localMaterialButton.setShapeAppearanceModel(localItem.a());
      }
      m += 1;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    create();
    super.dispatchDraw(paramCanvas);
  }
  
  public CharSequence getAccessibilityClassName()
  {
    return MaterialButtonToggleGroup.class.getName();
  }
  
  public int getCheckedButtonId()
  {
    if (l) {
      return i;
    }
    return -1;
  }
  
  public List getCheckedButtonIds()
  {
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    while (m < getChildCount())
    {
      MaterialButton localMaterialButton = next(m);
      if (localMaterialButton.isChecked()) {
        localArrayList.add(Integer.valueOf(localMaterialButton.getId()));
      }
      m += 1;
    }
    return localArrayList;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    Integer[] arrayOfInteger = id;
    if ((arrayOfInteger != null) && (paramInt2 < arrayOfInteger.length)) {
      return arrayOfInteger[paramInt2].intValue();
    }
    android.util.Log.w(TAG, "Child order wasn't updated");
    return paramInt2;
  }
  
  public boolean n()
  {
    return l;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int m = i;
    if (m != -1) {
      updateDate(m);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfo);
    int n = getVisibleButtonCount();
    int m;
    if (n()) {
      m = 1;
    } else {
      m = 2;
    }
    paramAccessibilityNodeInfo.setParent(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, n, false, m));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    d();
    show();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    if ((paramView instanceof MaterialButton))
    {
      MaterialButton localMaterialButton = (MaterialButton)paramView;
      localMaterialButton.remove(o);
      localMaterialButton.setOnPressedChangeListenerInternal(null);
    }
    int m = indexOfChild(paramView);
    if (m >= 0) {
      a.remove(m);
    }
    d();
    show();
  }
  
  public void setSelectionRequired(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public void setSingleSelection(int paramInt)
  {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    if (l != paramBoolean)
    {
      l = paramBoolean;
      a();
    }
  }
  
  class a
    implements Comparator<MaterialButton>
  {
    a() {}
    
    public int compare(MaterialButton paramMaterialButton1, MaterialButton paramMaterialButton2)
    {
      int i = Boolean.valueOf(paramMaterialButton1.isChecked()).compareTo(Boolean.valueOf(paramMaterialButton2.isChecked()));
      if (i != 0) {
        return i;
      }
      i = Boolean.valueOf(paramMaterialButton1.isPressed()).compareTo(Boolean.valueOf(paramMaterialButton2.isPressed()));
      if (i != 0) {
        return i;
      }
      return Integer.valueOf(indexOfChild(paramMaterialButton1)).compareTo(Integer.valueOf(indexOfChild(paramMaterialButton2)));
    }
  }
  
  class b
    extends ActionMenuItemView
  {
    b() {}
    
    public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.a(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setText(ByteVector.a(0, 1, MaterialButtonToggleGroup.a(MaterialButtonToggleGroup.this, paramView), 1, false, ((MaterialButton)paramView).isChecked()));
    }
  }
  
  private class c
    implements MaterialButton.a
  {
    private c() {}
    
    public void b(MaterialButton paramMaterialButton, boolean paramBoolean)
    {
      if (MaterialButtonToggleGroup.b(MaterialButtonToggleGroup.this)) {
        return;
      }
      if (MaterialButtonToggleGroup.c(MaterialButtonToggleGroup.this))
      {
        MaterialButtonToggleGroup localMaterialButtonToggleGroup = MaterialButtonToggleGroup.this;
        int i;
        if (paramBoolean) {
          i = paramMaterialButton.getId();
        } else {
          i = -1;
        }
        MaterialButtonToggleGroup.a(localMaterialButtonToggleGroup, i);
      }
      if (MaterialButtonToggleGroup.putString(MaterialButtonToggleGroup.this, paramMaterialButton.getId(), paramBoolean)) {
        MaterialButtonToggleGroup.b(MaterialButtonToggleGroup.this, paramMaterialButton.getId(), paramMaterialButton.isChecked());
      }
      invalidate();
    }
  }
  
  private static class d
  {
    private static final org.org.org.ui.asm.Context c = new org.org.org.ui.asm.Label(0.0F);
    org.org.org.ui.asm.Context a;
    org.org.org.ui.asm.Context e;
    org.org.org.ui.asm.Context i;
    org.org.org.ui.asm.Context j;
    
    d(org.org.org.ui.asm.Context paramContext1, org.org.org.ui.asm.Context paramContext2, org.org.org.ui.asm.Context paramContext3, org.org.org.ui.asm.Context paramContext4)
    {
      i = paramContext1;
      e = paramContext3;
      a = paramContext4;
      j = paramContext2;
    }
    
    public static d a(d paramD)
    {
      org.org.org.ui.asm.Context localContext1 = i;
      paramD = j;
      org.org.org.ui.asm.Context localContext2 = c;
      return new d(localContext1, paramD, localContext2, localContext2);
    }
    
    public static d a(d paramD, View paramView)
    {
      if (com.google.android.material.internal.ViewCompat.a(paramView)) {
        return c(paramD);
      }
      return a(paramD);
    }
    
    public static d b(d paramD)
    {
      org.org.org.ui.asm.Context localContext = c;
      return new d(localContext, j, localContext, a);
    }
    
    public static d b(d paramD, View paramView)
    {
      if (com.google.android.material.internal.ViewCompat.a(paramView)) {
        return a(paramD);
      }
      return c(paramD);
    }
    
    public static d c(d paramD)
    {
      org.org.org.ui.asm.Context localContext = c;
      return new d(localContext, localContext, e, a);
    }
    
    public static d p(d paramD)
    {
      org.org.org.ui.asm.Context localContext1 = i;
      org.org.org.ui.asm.Context localContext2 = c;
      return new d(localContext1, localContext2, e, localContext2);
    }
  }
  
  public static abstract interface e
  {
    public abstract void b(MaterialButtonToggleGroup paramMaterialButtonToggleGroup, int paramInt, boolean paramBoolean);
  }
  
  private class f
    implements MaterialButton.b
  {
    private f() {}
    
    public void cancel(MaterialButton paramMaterialButton, boolean paramBoolean)
    {
      invalidate();
    }
  }
}
