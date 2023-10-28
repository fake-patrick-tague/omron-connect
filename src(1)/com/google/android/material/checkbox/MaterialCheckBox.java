package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.internal.Label;
import com.google.android.material.theme.utils.Effect;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;

public class MaterialCheckBox
  extends AppCompatCheckBox
{
  private static final int o = R.string.condition_clouds_clear;
  private static final int[][] s;
  private boolean isPaddingMiddle;
  private ColorStateList m;
  
  static
  {
    int[] arrayOfInt = { -16842910, -16842912 };
    s = new int[][] { { 16842910, 16842912 }, { 16842910, -16842912 }, { -16842910, 16842912 }, arrayOfInt };
  }
  
  public MaterialCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, org.org.org.ui.ClassWriter.c);
  }
  
  public MaterialCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(Effect.a(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = Label.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SwitchPreference, paramInt, i, new int[0]);
    paramInt = R.styleable.SwitchPreference_summaryOn;
    if (paramAttributeSet.hasValue(paramInt)) {
      CompoundButtonCompat.b(this, org.org.org.ui.menu.ClassWriter.getString(paramContext, paramAttributeSet, paramInt));
    }
    isPaddingMiddle = paramAttributeSet.getBoolean(R.styleable.LinePageIndicator_centered, false);
    paramAttributeSet.recycle();
  }
  
  private ColorStateList getMaterialThemeColorsTintList()
  {
    if (m == null)
    {
      int[][] arrayOfInt = s;
      int[] arrayOfInt1 = new int[arrayOfInt.length];
      int i = org.org.org.ui.keys.ClassWriter.a(this, org.org.org.ui.ClassWriter.B);
      int j = org.org.org.ui.keys.ClassWriter.a(this, org.org.org.ui.ClassWriter.a);
      int k = org.org.org.ui.keys.ClassWriter.a(this, org.org.org.ui.ClassWriter.e);
      arrayOfInt1[0] = org.org.org.ui.keys.ClassWriter.a(j, i, 1.0F);
      arrayOfInt1[1] = org.org.org.ui.keys.ClassWriter.a(j, k, 0.54F);
      arrayOfInt1[2] = org.org.org.ui.keys.ClassWriter.a(j, k, 0.38F);
      arrayOfInt1[3] = org.org.org.ui.keys.ClassWriter.a(j, k, 0.38F);
      m = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return m;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((isPaddingMiddle) && (CompoundButtonCompat.getButtonTintList(this) == null)) {
      setUseMaterialThemeColors(true);
    }
  }
  
  public void setUseMaterialThemeColors(boolean paramBoolean)
  {
    isPaddingMiddle = paramBoolean;
    if (paramBoolean)
    {
      CompoundButtonCompat.b(this, getMaterialThemeColorsTintList());
      return;
    }
    CompoundButtonCompat.b(this, null);
  }
}
