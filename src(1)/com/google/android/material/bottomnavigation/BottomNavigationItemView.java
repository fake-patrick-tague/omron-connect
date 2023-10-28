package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.f;
import org.org.org.ui.R.drawable;
import org.org.org.ui.R.id;
import org.org.org.ui.R.raw;
import org.org.org.ui.Switch;
import org.org.org.ui.h;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;

public class BottomNavigationItemView
  extends FrameLayout
  implements MenuView.ItemView
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private final TextView a;
  private final TextView b;
  private final int c;
  private float d;
  private float e;
  private float f;
  private BadgeDrawable h;
  private boolean isChecked;
  private int l;
  private int list = -1;
  private ColorStateList mColor;
  private Drawable mDrawable;
  private Drawable mIcon;
  private MenuItemImpl mItemData;
  private final ViewGroup s;
  private ImageView this$0;
  
  public BottomNavigationItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = getResources();
    LayoutInflater.from(paramContext).inflate(h.d, this, true);
    setBackgroundResource(R.drawable.b);
    c = paramAttributeSet.getDimensionPixelSize(R.raw.v);
    this$0 = ((ImageView)findViewById(R.id.host));
    paramContext = (ViewGroup)findViewById(R.id.pager);
    s = paramContext;
    paramAttributeSet = (TextView)findViewById(R.id.indicator);
    a = paramAttributeSet;
    TextView localTextView = (TextView)findViewById(R.id.label);
    b = localTextView;
    paramContext.setTag(R.id.e, Integer.valueOf(paramContext.getPaddingBottom()));
    ViewCompat.get(paramAttributeSet, 2);
    ViewCompat.get(localTextView, 2);
    setFocusable(true);
    a(paramAttributeSet.getTextSize(), localTextView.getTextSize());
    paramContext = this$0;
    if (paramContext != null) {
      paramContext.addOnLayoutChangeListener(new a());
    }
  }
  
  private FrameLayout a(View paramView)
  {
    ImageView localImageView = this$0;
    if ((paramView == localImageView) && (f.c)) {
      return (FrameLayout)localImageView.getParent();
    }
    return null;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    f = (paramFloat1 - paramFloat2);
    e = (paramFloat2 * 1.0F / paramFloat1);
    d = (paramFloat1 * 1.0F / paramFloat2);
  }
  
  private static void a(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
  }
  
  private static void a(View paramView, int paramInt)
  {
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramInt);
  }
  
  private void b(View paramView)
  {
    if (!b()) {
      return;
    }
    if (paramView != null)
    {
      setClipChildren(false);
      setClipToPadding(false);
      f.b(h, paramView, a(paramView));
    }
  }
  
  private boolean b()
  {
    return h != null;
  }
  
  private void c(View paramView)
  {
    if (!b()) {
      return;
    }
    f.a(h, paramView, a(paramView));
  }
  
  private static void create(View paramView, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    topMargin = paramInt1;
    gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void f(View paramView)
  {
    if (!b()) {
      return;
    }
    if (paramView != null)
    {
      setClipChildren(true);
      setClipToPadding(true);
      f.b(h, paramView);
    }
    h = null;
  }
  
  private int getItemVisiblePosition()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    int m = localViewGroup.indexOfChild(this);
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      View localView = localViewGroup.getChildAt(i);
      k = j;
      if ((localView instanceof BottomNavigationItemView))
      {
        k = j;
        if (localView.getVisibility() == 0) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  void f()
  {
    f(this$0);
  }
  
  BadgeDrawable getBadge()
  {
    return h;
  }
  
  public MenuItemImpl getItemData()
  {
    return mItemData;
  }
  
  public int getItemPosition()
  {
    return list;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    mItemData = paramMenuItemImpl;
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.getTitle());
    setId(paramMenuItemImpl.getItemId());
    if (!android.text.TextUtils.isEmpty(paramMenuItemImpl.getContentDescription())) {
      setContentDescription(paramMenuItemImpl.getContentDescription());
    }
    CharSequence localCharSequence;
    if (!android.text.TextUtils.isEmpty(paramMenuItemImpl.getTooltipText())) {
      localCharSequence = paramMenuItemImpl.getTooltipText();
    } else {
      localCharSequence = paramMenuItemImpl.getTitle();
    }
    androidx.appcompat.widget.TextUtils.setText(this, localCharSequence);
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    MenuItemImpl localMenuItemImpl = mItemData;
    if ((localMenuItemImpl != null) && (localMenuItemImpl.isCheckable()) && (mItemData.isChecked())) {
      View.mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject = h;
    if ((localObject != null) && (((Drawable)localObject).isVisible()))
    {
      localObject = mItemData.getTitle();
      if (!android.text.TextUtils.isEmpty(mItemData.getContentDescription())) {
        localObject = mItemData.getContentDescription();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(h.get());
      paramAccessibilityNodeInfo.setContentDescription(localStringBuilder.toString());
    }
    paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setText(v7.v7.package_13.asm.ByteVector.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
    if (isSelected())
    {
      paramAccessibilityNodeInfo.setClickable(false);
      paramAccessibilityNodeInfo.setText(v7.v7.package_13.asm.Label.h);
    }
    paramAccessibilityNodeInfo.setParent(getResources().getString(Switch.w));
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  void setBadge(BadgeDrawable paramBadgeDrawable)
  {
    h = paramBadgeDrawable;
    paramBadgeDrawable = this$0;
    if (paramBadgeDrawable != null) {
      b(paramBadgeDrawable);
    }
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject = b;
    ((View)localObject).setPivotX(((View)localObject).getWidth() / 2);
    localObject = b;
    ((View)localObject).setPivotY(((TextView)localObject).getBaseline());
    localObject = a;
    ((View)localObject).setPivotX(((View)localObject).getWidth() / 2);
    localObject = a;
    ((View)localObject).setPivotY(((TextView)localObject).getBaseline());
    int i = l;
    float f1;
    if (i != -1)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            create(this$0, c, 17);
            b.setVisibility(8);
            a.setVisibility(8);
          }
        }
        else
        {
          localObject = s;
          a((View)localObject, ((Integer)((View)localObject).getTag(R.id.e)).intValue());
          if (paramBoolean)
          {
            create(this$0, (int)(c + f), 49);
            a(b, 1.0F, 1.0F, 0);
            localObject = a;
            f1 = e;
            a((View)localObject, f1, f1, 4);
          }
          else
          {
            create(this$0, c, 49);
            localObject = b;
            f1 = d;
            a((View)localObject, f1, f1, 4);
            a(a, 1.0F, 1.0F, 0);
          }
        }
      }
      else
      {
        if (paramBoolean)
        {
          create(this$0, c, 49);
          localObject = s;
          a((View)localObject, ((Integer)((View)localObject).getTag(R.id.e)).intValue());
          b.setVisibility(0);
        }
        else
        {
          create(this$0, c, 17);
          a(s, 0);
          b.setVisibility(4);
        }
        a.setVisibility(4);
      }
    }
    else if (isChecked)
    {
      if (paramBoolean)
      {
        create(this$0, c, 49);
        localObject = s;
        a((View)localObject, ((Integer)((View)localObject).getTag(R.id.e)).intValue());
        b.setVisibility(0);
      }
      else
      {
        create(this$0, c, 17);
        a(s, 0);
        b.setVisibility(4);
      }
      a.setVisibility(4);
    }
    else
    {
      localObject = s;
      a((View)localObject, ((Integer)((View)localObject).getTag(R.id.e)).intValue());
      if (paramBoolean)
      {
        create(this$0, (int)(c + f), 49);
        a(b, 1.0F, 1.0F, 0);
        localObject = a;
        f1 = e;
        a((View)localObject, f1, f1, 4);
      }
      else
      {
        create(this$0, c, 49);
        localObject = b;
        f1 = d;
        a((View)localObject, f1, f1, 4);
        a(a, 1.0F, 1.0F, 0);
      }
    }
    refreshDrawableState();
    setSelected(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    a.setEnabled(paramBoolean);
    b.setEnabled(paramBoolean);
    this$0.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      ViewCompat.a(this, v7.v7.package_13.ByteVector.a(getContext(), 1002));
      return;
    }
    ViewCompat.a(this, null);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (paramDrawable == mIcon) {
      return;
    }
    mIcon = paramDrawable;
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      }
      Drawable localDrawable = DrawableCompat.getDrawable(paramDrawable).mutate();
      paramDrawable = localDrawable;
      mDrawable = localDrawable;
      ColorStateList localColorStateList = mColor;
      localObject = paramDrawable;
      if (localColorStateList != null)
      {
        DrawableCompat.append(localDrawable, localColorStateList);
        localObject = paramDrawable;
      }
    }
    this$0.setImageDrawable((Drawable)localObject);
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this$0.getLayoutParams();
    width = paramInt;
    height = paramInt;
    this$0.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    mColor = paramColorStateList;
    if (mItemData != null)
    {
      Drawable localDrawable = mDrawable;
      if (localDrawable != null)
      {
        DrawableCompat.append(localDrawable, paramColorStateList);
        mDrawable.invalidateSelf();
      }
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 0) {
      localDrawable = null;
    } else {
      localDrawable = ContextCompat.getDrawable(getContext(), paramInt);
    }
    setItemBackground(localDrawable);
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (paramDrawable.getConstantState() != null) {
        localDrawable = paramDrawable.getConstantState().newDrawable().mutate();
      }
    }
    ViewCompat.setBackgroundDrawable(this, localDrawable);
  }
  
  public void setItemPosition(int paramInt)
  {
    list = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (l != paramInt)
    {
      l = paramInt;
      MenuItemImpl localMenuItemImpl = mItemData;
      if (localMenuItemImpl != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        setChecked(localMenuItemImpl.isChecked());
      }
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (isChecked != paramBoolean)
    {
      isChecked = paramBoolean;
      MenuItemImpl localMenuItemImpl = mItemData;
      int i;
      if (localMenuItemImpl != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        setChecked(localMenuItemImpl.isChecked());
      }
    }
  }
  
  public void setTextAppearanceActive(int paramInt)
  {
    androidx.core.widget.Label.setTextAppearance(b, paramInt);
    a(a.getTextSize(), b.getTextSize());
  }
  
  public void setTextAppearanceInactive(int paramInt)
  {
    androidx.core.widget.Label.setTextAppearance(a, paramInt);
    a(a.getTextSize(), b.getTextSize());
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      a.setTextColor(paramColorStateList);
      b.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    a.setText(paramCharSequence);
    b.setText(paramCharSequence);
    Object localObject = mItemData;
    if ((localObject == null) || (android.text.TextUtils.isEmpty(((MenuItemImpl)localObject).getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
    MenuItemImpl localMenuItemImpl = mItemData;
    localObject = paramCharSequence;
    if (localMenuItemImpl != null) {
      if (android.text.TextUtils.isEmpty(localMenuItemImpl.getTooltipText())) {
        localObject = paramCharSequence;
      } else {
        localObject = mItemData.getTooltipText();
      }
    }
    androidx.appcompat.widget.TextUtils.setText(this, (CharSequence)localObject);
  }
  
  class a
    implements View.OnLayoutChangeListener
  {
    a() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if (BottomNavigationItemView.p(BottomNavigationItemView.this).getVisibility() == 0)
      {
        paramView = BottomNavigationItemView.this;
        BottomNavigationItemView.a(paramView, BottomNavigationItemView.p(paramView));
      }
    }
  }
}
