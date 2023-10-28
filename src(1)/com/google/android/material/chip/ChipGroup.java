package com.google.android.material.chip;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.Label;
import com.google.android.material.theme.utils.Effect;
import java.util.ArrayList;
import java.util.List;
import org.org.org.ui.ClassWriter;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat.CollectionInfoCompat;

public class ChipGroup
  extends FlowLayout
{
  private static final int d = R.string.d;
  private int Text;
  private c a;
  private boolean contentResolver;
  private int curIndex;
  private boolean j;
  private boolean k = false;
  private int l = -1;
  private final b mGridView = new b(null);
  private d o = new d(null);
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, ClassWriter.y);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(Effect.a(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = Label.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.AlertDialog, paramInt, i, new int[0]);
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    setChipSpacingHorizontal(paramContext.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, paramInt));
    setChipSpacingVertical(paramContext.getDimensionPixelOffset(R.styleable.FloatingActionButton_pressedTranslationZ, paramInt));
    setSingleLine(paramContext.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false));
    setSingleSelection(paramContext.getBoolean(R.styleable.StickyListHeadersListView_android_scrollingCache, false));
    setSelectionRequired(paramContext.getBoolean(R.styleable.R, false));
    paramInt = paramContext.getResourceId(R.styleable.C, -1);
    if (paramInt != -1) {
      l = paramInt;
    }
    paramContext.recycle();
    super.setOnHierarchyChangeListener(o);
    ViewCompat.get(this, 1);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    View localView = findViewById(paramInt);
    if ((localView instanceof Chip))
    {
      k = true;
      ((Chip)localView).setChecked(paramBoolean);
      k = false;
    }
  }
  
  private int getChipCount()
  {
    int i = 0;
    int n;
    for (int m = 0; i < getChildCount(); m = n)
    {
      n = m;
      if ((getChildAt(i) instanceof Chip)) {
        n = m + 1;
      }
      i += 1;
    }
    return m;
  }
  
  private void setCheckedId(int paramInt)
  {
    setValueInternal(paramInt, true);
  }
  
  private void setValueInternal(int paramInt, boolean paramBoolean)
  {
    l = paramInt;
    c localC = a;
    if ((localC != null) && (j) && (paramBoolean)) {
      localC.onValueChange(this, paramInt);
    }
  }
  
  public void SetValue()
  {
    k = true;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof Chip)) {
        ((Chip)localView).setChecked(false);
      }
      i += 1;
    }
    k = false;
    setCheckedId(-1);
  }
  
  int a(View paramView)
  {
    if (!(paramView instanceof Chip)) {
      return -1;
    }
    int i = 0;
    int n;
    for (int m = 0; i < getChildCount(); m = n)
    {
      n = m;
      if ((getChildAt(i) instanceof Chip))
      {
        if ((Chip)getChildAt(i) == paramView) {
          return m;
        }
        n = m + 1;
      }
      i += 1;
    }
    return -1;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof Chip))
    {
      Chip localChip = (Chip)paramView;
      if (localChip.isChecked())
      {
        int i = l;
        if ((i != -1) && (j)) {
          a(i, false);
        }
        setCheckedId(localChip.getId());
      }
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public boolean b()
  {
    return j;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public void e(int paramInt)
  {
    int i = l;
    if (paramInt == i) {
      return;
    }
    if ((i != -1) && (j)) {
      a(i, false);
    }
    if (paramInt != -1) {
      a(paramInt, true);
    }
    setCheckedId(paramInt);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getCheckedChipId()
  {
    if (j) {
      return l;
    }
    return -1;
  }
  
  public List getCheckedChipIds()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (((localView instanceof Chip)) && (((Chip)localView).isChecked()))
      {
        localArrayList.add(Integer.valueOf(localView.getId()));
        if (j) {
          return localArrayList;
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int getChipSpacingHorizontal()
  {
    return curIndex;
  }
  
  public int getChipSpacingVertical()
  {
    return Text;
  }
  
  public boolean isDebugDraw()
  {
    return super.isDebugDraw();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i = l;
    if (i != -1)
    {
      a(i, true);
      setCheckedId(l);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfo);
    int i;
    if (isDebugDraw()) {
      i = getChipCount();
    } else {
      i = -1;
    }
    int n = getRowCount();
    int m;
    if (b()) {
      m = 1;
    } else {
      m = 2;
    }
    paramAccessibilityNodeInfo.setParent(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(n, i, false, m));
  }
  
  public void setChipSpacing(int paramInt)
  {
    setChipSpacingHorizontal(paramInt);
    setChipSpacingVertical(paramInt);
  }
  
  public void setChipSpacingHorizontal(int paramInt)
  {
    if (curIndex != paramInt)
    {
      curIndex = paramInt;
      setItemSpacing(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingHorizontalResource(int paramInt)
  {
    setChipSpacingHorizontal(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingResource(int paramInt)
  {
    setChipSpacing(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingVertical(int paramInt)
  {
    if (Text != paramInt)
    {
      Text = paramInt;
      setLineSpacing(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingVerticalResource(int paramInt)
  {
    setChipSpacingVertical(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setFlexWrap(int paramInt)
  {
    throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
  }
  
  public void setOnCheckedChangeListener(c paramC)
  {
    a = paramC;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    d.getColor(o, paramOnHierarchyChangeListener);
  }
  
  public void setSelectionRequired(boolean paramBoolean)
  {
    contentResolver = paramBoolean;
  }
  
  public void setShowDividerHorizontal(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setShowDividerVertical(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setSingleLine(int paramInt)
  {
    setSingleLine(getResources().getBoolean(paramInt));
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    super.setSingleLine(paramBoolean);
  }
  
  public void setSingleSelection(int paramInt)
  {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    if (j != paramBoolean)
    {
      j = paramBoolean;
      SetValue();
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
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
  
  private class b
    implements CompoundButton.OnCheckedChangeListener
  {
    private b() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (ChipGroup.d(ChipGroup.this)) {
        return;
      }
      if ((getCheckedChipIds().isEmpty()) && (ChipGroup.access$getContentResolver(ChipGroup.this)))
      {
        ChipGroup.set(ChipGroup.this, paramCompoundButton.getId(), true);
        ChipGroup.setValue(ChipGroup.this, paramCompoundButton.getId(), false);
        return;
      }
      int i = paramCompoundButton.getId();
      if (paramBoolean)
      {
        if ((ChipGroup.access$getL(ChipGroup.this) != -1) && (ChipGroup.access$getL(ChipGroup.this) != i) && (ChipGroup.a(ChipGroup.this)))
        {
          paramCompoundButton = ChipGroup.this;
          ChipGroup.set(paramCompoundButton, ChipGroup.access$getL(paramCompoundButton), false);
        }
        ChipGroup.removeBookmark(ChipGroup.this, i);
        return;
      }
      if (ChipGroup.access$getL(ChipGroup.this) == i) {
        ChipGroup.removeBookmark(ChipGroup.this, -1);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void onValueChange(ChipGroup paramChipGroup, int paramInt);
  }
  
  private class d
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    
    private d() {}
    
    public void onChildViewAdded(View paramView1, View paramView2)
    {
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip)))
      {
        if (paramView2.getId() == -1) {
          paramView2.setId(ViewCompat.generateViewId());
        }
        localObject = (Chip)paramView2;
        if (((CompoundButton)localObject).isChecked()) {
          ((ChipGroup)paramView1).e(((View)localObject).getId());
        }
        ((Chip)localObject).setOnCheckedChangeListenerInternal(ChipGroup.access$getMGridView(ChipGroup.this));
      }
      Object localObject = mOnHierarchyChangeListener;
      if (localObject != null) {
        ((ViewGroup.OnHierarchyChangeListener)localObject).onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public void onChildViewRemoved(View paramView1, View paramView2)
    {
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip))) {
        ((Chip)paramView2).setOnCheckedChangeListenerInternal(null);
      }
      ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = mOnHierarchyChangeListener;
      if (localOnHierarchyChangeListener != null) {
        localOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
}
