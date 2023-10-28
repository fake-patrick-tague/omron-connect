package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import androidx.appcompat.widget.TextUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import org.org.org.ui.R.drawable;
import org.org.org.ui.R.id;
import org.org.org.ui.R.raw;
import org.org.org.ui.h;
import v7.internal.R.attr;
import v7.v7.package_13.ActionMenuItemView;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;

public class NavigationMenuItemView
  extends ForegroundLinearLayout
  implements MenuView.ItemView
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private FrameLayout mActionArea;
  private boolean mForceShowIcon;
  private Drawable mIcon;
  private int mIconSize;
  private ColorStateList mIconTintList;
  private MenuItemImpl mItemData;
  private boolean mLogo;
  private final CheckedTextView mTextView;
  boolean s;
  private final ActionMenuItemView this$0;
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new a();
    this$0 = paramAttributeSet;
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(h.w, this, true);
    setIconSize(paramContext.getResources().getDimensionPixelSize(R.raw.s));
    paramContext = (CheckedTextView)findViewById(R.id.itemsList);
    mTextView = paramContext;
    paramContext.setDuplicateParentStateEnabled(true);
    ViewCompat.a(paramContext, paramAttributeSet);
  }
  
  private StateListDrawable createDefaultBackground()
  {
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, localTypedValue, true))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(data));
      localStateListDrawable.addState(View.EMPTY_STATE_SET, new ColorDrawable(0));
      return localStateListDrawable;
    }
    return null;
  }
  
  private void onBindViewHolder()
  {
    Object localObject;
    if (setIcon())
    {
      mTextView.setVisibility(8);
      localObject = mActionArea;
      if (localObject != null)
      {
        localObject = (LinearLayoutCompat.LayoutParams)((View)localObject).getLayoutParams();
        width = -1;
        mActionArea.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      mTextView.setVisibility(0);
      localObject = mActionArea;
      if (localObject != null)
      {
        localObject = (LinearLayoutCompat.LayoutParams)((View)localObject).getLayoutParams();
        width = -2;
        mActionArea.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (mActionArea == null) {
        mActionArea = ((FrameLayout)((ViewStub)findViewById(R.id.design_menu_item_action_area_stub)).inflate());
      }
      mActionArea.removeAllViews();
      mActionArea.addView(paramView);
    }
  }
  
  private boolean setIcon()
  {
    return (mItemData.getTitle() == null) && (mItemData.getIcon() == null) && (mItemData.getActionView() != null);
  }
  
  public MenuItemImpl getItemData()
  {
    return mItemData;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    mItemData = paramMenuItemImpl;
    if (paramMenuItemImpl.getItemId() > 0) {
      setId(paramMenuItemImpl.getItemId());
    }
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    if (getBackground() == null) {
      ViewCompat.setBackgroundDrawable(this, createDefaultBackground());
    }
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setTitle(paramMenuItemImpl.getTitle());
    setIcon(paramMenuItemImpl.getIcon());
    setActionView(paramMenuItemImpl.getActionView());
    setContentDescription(paramMenuItemImpl.getContentDescription());
    TextUtils.setText(this, paramMenuItemImpl.getTooltipText());
    onBindViewHolder();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    MenuItemImpl localMenuItemImpl = mItemData;
    if ((localMenuItemImpl != null) && (localMenuItemImpl.isCheckable()) && (mItemData.isChecked())) {
      View.mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (s != paramBoolean)
    {
      s = paramBoolean;
      this$0.a(mTextView, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    mTextView.setChecked(paramBoolean);
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    setPadding(paramInt, 0, paramInt, 0);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if (paramDrawable != null)
    {
      Object localObject = paramDrawable;
      if (mForceShowIcon)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject != null) {
          paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
        }
        paramDrawable = DrawableCompat.getDrawable(paramDrawable).mutate();
        localObject = paramDrawable;
        DrawableCompat.append(paramDrawable, mIconTintList);
      }
      i = mIconSize;
      ((Drawable)localObject).setBounds(0, 0, i, i);
      paramDrawable = (Drawable)localObject;
    }
    else if (mLogo)
    {
      if (mIcon == null)
      {
        paramDrawable = androidx.core.content.asm.Label.getDrawable(getResources(), R.drawable.mIcon, getContext().getTheme());
        mIcon = paramDrawable;
        if (paramDrawable != null)
        {
          i = mIconSize;
          paramDrawable.setBounds(0, 0, i, i);
        }
      }
      paramDrawable = mIcon;
    }
    androidx.core.widget.Label.a(mTextView, paramDrawable, null, null, null);
  }
  
  public void setIconPadding(int paramInt)
  {
    mTextView.setCompoundDrawablePadding(paramInt);
  }
  
  public void setIconSize(int paramInt)
  {
    mIconSize = paramInt;
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    mIconTintList = paramColorStateList;
    boolean bool;
    if (paramColorStateList != null) {
      bool = true;
    } else {
      bool = false;
    }
    mForceShowIcon = bool;
    paramColorStateList = mItemData;
    if (paramColorStateList != null) {
      setIcon(paramColorStateList.getIcon());
    }
  }
  
  public void setMaxLines(int paramInt)
  {
    mTextView.setMaxLines(paramInt);
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    mLogo = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    androidx.core.widget.Label.setTextAppearance(mTextView, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    mTextView.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mTextView.setText(paramCharSequence);
  }
  
  class a
    extends ActionMenuItemView
  {
    a() {}
    
    public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.a(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setCheckable(s);
    }
  }
}
