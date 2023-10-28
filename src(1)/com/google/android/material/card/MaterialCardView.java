package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import org.org.org.ui.ClassWriter;
import org.org.org.ui.R.string;
import org.org.org.ui.asm.GeoPoint;
import org.org.org.ui.asm.m;

public class MaterialCardView
  extends CardView
  implements Checkable, GeoPoint
{
  private static final int[] CHECKED_STATE_SET = { 16842911 };
  private static final int[] ENABLED_FOCUSED_STATE_SET = { ClassWriter.b };
  private static final int Q = R.string.right;
  private static final int[] SELECTED_STATE_SET = { 16842912 };
  private boolean l;
  private boolean mChecked;
  private boolean mDrawFullUnderlineSet;
  private a mOnCheckedChangeListener;
  private final Date val$date;
  
  private RectF getBoundsAsRectF()
  {
    new RectF();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  private void load()
  {
    if (Build.VERSION.SDK_INT <= 26) {
      return;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public ColorStateList getCardBackgroundColor()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public ColorStateList getCardForegroundColor()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  float getCardViewRadius()
  {
    return getRadius(this);
  }
  
  public Drawable getCheckedIcon()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public int getCheckedIconMargin()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public int getCheckedIconSize()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public ColorStateList getCheckedIconTint()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public int getContentPaddingBottom()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public int getContentPaddingLeft()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public int getContentPaddingRight()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public int getContentPaddingTop()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public float getProgress()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public float getRadius()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public ColorStateList getRippleColor()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public m getShapeAppearanceModel()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public int getStrokeColor()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public ColorStateList getStrokeColorStateList()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public int getStrokeWidth()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public boolean invoke()
  {
    if (val$date == null) {
      return false;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public boolean isChecked()
  {
    return mChecked;
  }
  
  public boolean n()
  {
    return l;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 3);
    if (invoke()) {
      android.view.View.mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    if (isChecked()) {
      android.view.View.mergeDrawableStates(arrayOfInt, SELECTED_STATE_SET);
    }
    if (n()) {
      android.view.View.mergeDrawableStates(arrayOfInt, ENABLED_FOCUSED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("androidx.cardview.widget.CardView");
    paramAccessibilityEvent.setChecked(isChecked());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
    paramAccessibilityNodeInfo.setCheckable(invoke());
    paramAccessibilityNodeInfo.setClickable(isClickable());
    paramAccessibilityNodeInfo.setChecked(isChecked());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    getMeasuredWidth();
    getMeasuredHeight();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (!mDrawFullUnderlineSet) {
      return;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  void setBackgroundInternal(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    ColorStateList.valueOf(paramInt);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setCardElevation(float paramFloat)
  {
    super.setCardElevation(paramFloat);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setCardForegroundColor(ColorStateList paramColorStateList)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (mChecked != paramBoolean) {
      toggle();
    }
  }
  
  public void setCheckedIcon(Drawable paramDrawable)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setCheckedIconMargin(int paramInt)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setCheckedIconMarginResource(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    getResources().getDimensionPixelSize(paramInt);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setCheckedIconResource(int paramInt)
  {
    v7.internal.transition.util.View.getDrawable(getContext(), paramInt);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setCheckedIconSize(int paramInt)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setCheckedIconSizeResource(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    getResources().getDimensionPixelSize(paramInt);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setCheckedIconTint(ColorStateList paramColorStateList)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    if (val$date == null) {
      return;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setDragged(boolean paramBoolean)
  {
    if (l != paramBoolean)
    {
      l = paramBoolean;
      refreshDrawableState();
      load();
      invalidate();
    }
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    super.setMaxCardElevation(paramFloat);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setOnCheckedChangeListener(a paramA)
  {
    mOnCheckedChangeListener = paramA;
  }
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    super.setPreventCornerOverlap(paramBoolean);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setProgress(float paramFloat)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setRadius(float paramFloat)
  {
    super.setRadius(paramFloat);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setRippleColorResource(int paramInt)
  {
    v7.internal.transition.util.View.a(getContext(), paramInt);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setShapeAppearanceModel(m paramM)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setClipToOutline(paramM.a(getBoundsAsRectF()));
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setStrokeColor(int paramInt)
  {
    ColorStateList.valueOf(paramInt);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setStrokeWidth(int paramInt)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    super.setUseCompatPadding(paramBoolean);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public void toggle()
  {
    if ((invoke()) && (isEnabled()))
    {
      mChecked ^= true;
      refreshDrawableState();
      load();
      a localA = mOnCheckedChangeListener;
      if (localA != null) {
        localA.onCheckedChanged(this, mChecked);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onCheckedChanged(MaterialCardView paramMaterialCardView, boolean paramBoolean);
  }
}
