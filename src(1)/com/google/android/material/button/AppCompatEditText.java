package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import org.org.org.ui.R.styleable;
import org.org.org.ui.asm.GeoPoint;
import org.org.org.ui.asm.f;
import org.org.org.ui.asm.m;
import org.org.org.ui.compound.DrawableWrapperDonut;
import org.org.org.ui.compound.Log;

class AppCompatEditText
{
  private static final boolean $assertionsDisabled;
  private int N;
  private final MaterialButton a;
  private int b;
  private Drawable c;
  private int d;
  private int e;
  private boolean f = false;
  private boolean g;
  private int h;
  private boolean i = false;
  private ColorStateList l;
  private ColorStateList m;
  private ColorStateList mBackgroundTint;
  private PorterDuff.Mode mTintMode;
  private int n;
  private boolean p = false;
  private int s;
  private LayerDrawable type;
  private m x;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    $assertionsDisabled = bool;
  }
  
  AppCompatEditText(MaterialButton paramMaterialButton, m paramM)
  {
    a = paramMaterialButton;
    x = paramM;
  }
  
  private InsetDrawable a(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, s, e, n, b);
  }
  
  private void a()
  {
    f localF1 = inflate();
    f localF2 = setBackgroundDrawable();
    if (localF1 != null)
    {
      localF1.a(h, l);
      if (localF2 != null)
      {
        float f1 = h;
        int j;
        if (f) {
          j = org.org.org.ui.keys.ClassWriter.a(a, org.org.org.ui.ClassWriter.a);
        } else {
          j = 0;
        }
        localF2.a(f1, j);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int j = v7.v7.package_13.ViewCompat.add(a);
    int k = a.getPaddingTop();
    int i1 = v7.v7.package_13.ViewCompat.format(a);
    int i2 = a.getPaddingBottom();
    int i3 = e;
    int i4 = b;
    b = paramInt2;
    e = paramInt1;
    if (!p) {
      init();
    }
    v7.v7.package_13.ViewCompat.get(a, j, k + paramInt1 - i3, i1, i2 + paramInt2 - i4);
  }
  
  private f getDrawable(boolean paramBoolean)
  {
    LayerDrawable localLayerDrawable = type;
    if ((localLayerDrawable != null) && (localLayerDrawable.getNumberOfLayers() > 0))
    {
      if ($assertionsDisabled) {
        return (f)((LayerDrawable)((InsetDrawable)type.getDrawable(0)).getDrawable()).getDrawable(paramBoolean ^ true);
      }
      return (f)type.getDrawable(paramBoolean ^ true);
    }
    return null;
  }
  
  private void init()
  {
    a.setInternalBackground(onCreateView());
    f localF = inflate();
    if (localF != null) {
      localF.add(N);
    }
  }
  
  private void init(m paramM)
  {
    if (inflate() != null) {
      inflate().setShapeAppearanceModel(paramM);
    }
    if (setBackgroundDrawable() != null) {
      setBackgroundDrawable().setShapeAppearanceModel(paramM);
    }
    if (start() != null) {
      start().setShapeAppearanceModel(paramM);
    }
  }
  
  private Drawable onCreateView()
  {
    Object localObject1 = new f(x);
    ((f)localObject1).d(a.getContext());
    DrawableCompat.append((Drawable)localObject1, mBackgroundTint);
    Object localObject2 = mTintMode;
    if (localObject2 != null) {
      DrawableCompat.setTintMode((Drawable)localObject1, (PorterDuff.Mode)localObject2);
    }
    ((f)localObject1).a(h, l);
    localObject2 = new f(x);
    ((f)localObject2).setTint(0);
    float f1 = h;
    int j;
    if (f) {
      j = org.org.org.ui.keys.ClassWriter.a(a, org.org.org.ui.ClassWriter.a);
    } else {
      j = 0;
    }
    ((f)localObject2).a(f1, j);
    if ($assertionsDisabled)
    {
      localObject3 = new f(x);
      c = ((Drawable)localObject3);
      DrawableCompat.setTint((Drawable)localObject3, -1);
      localObject1 = new RippleDrawable(Log.getColor(m), a(new LayerDrawable(new Drawable[] { localObject2, localObject1 })), c);
      type = ((LayerDrawable)localObject1);
      return localObject1;
    }
    Object localObject3 = new DrawableWrapperDonut(x);
    c = ((Drawable)localObject3);
    DrawableCompat.append((Drawable)localObject3, Log.getColor(m));
    localObject1 = new LayerDrawable(new Drawable[] { localObject2, localObject1, c });
    type = ((LayerDrawable)localObject1);
    return a((Drawable)localObject1);
  }
  
  private f setBackgroundDrawable()
  {
    return getDrawable(true);
  }
  
  public int _2()
  {
    return b;
  }
  
  int applySupportBackgroundTint()
  {
    return h;
  }
  
  void b(int paramInt)
  {
    if ((!i) || (d != paramInt))
    {
      d = paramInt;
      i = true;
      initialize(x.a(paramInt));
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = c;
    if (localDrawable != null) {
      localDrawable.setBounds(s, e, paramInt2 - n, paramInt1 - b);
    }
  }
  
  boolean b()
  {
    return p;
  }
  
  ColorStateList f()
  {
    return m;
  }
  
  int getMarginBottom()
  {
    return d;
  }
  
  public int getPaddingLeft()
  {
    return e;
  }
  
  ColorStateList getSupportBackgroundTintList()
  {
    return mBackgroundTint;
  }
  
  PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return mTintMode;
  }
  
  f inflate()
  {
    return getDrawable(false);
  }
  
  void init(ColorStateList paramColorStateList)
  {
    if (m != paramColorStateList)
    {
      m = paramColorStateList;
      boolean bool = $assertionsDisabled;
      if ((bool) && ((a.getBackground() instanceof RippleDrawable)))
      {
        ((RippleDrawable)a.getBackground()).setColor(Log.getColor(paramColorStateList));
        return;
      }
      if ((!bool) && ((a.getBackground() instanceof DrawableWrapperDonut))) {
        ((DrawableWrapperDonut)a.getBackground()).setTintList(Log.getColor(paramColorStateList));
      }
    }
  }
  
  void init(TypedArray paramTypedArray)
  {
    s = paramTypedArray.getDimensionPixelOffset(R.styleable.ColorPickerView_alphaChannelText, 0);
    n = paramTypedArray.getDimensionPixelOffset(R.styleable.ColorPickerView_colorPickerSliderColor, 0);
    e = paramTypedArray.getDimensionPixelOffset(R.styleable.ColorPickerView_colorPickerBorderColor, 0);
    b = paramTypedArray.getDimensionPixelOffset(R.styleable.FloatingActionButton_fab_elevationCompat, 0);
    int j = R.styleable.FloatingActionButton_fab_shadowYOffset;
    if (paramTypedArray.hasValue(j))
    {
      j = paramTypedArray.getDimensionPixelSize(j, -1);
      d = j;
      initialize(x.a(j));
      i = true;
    }
    h = paramTypedArray.getDimensionPixelSize(R.styleable.t, 0);
    mTintMode = com.google.android.material.internal.ViewCompat.parseTintMode(paramTypedArray.getInt(R.styleable.key, -1), PorterDuff.Mode.SRC_IN);
    mBackgroundTint = org.org.org.ui.menu.ClassWriter.getString(a.getContext(), paramTypedArray, R.styleable.END);
    l = org.org.org.ui.menu.ClassWriter.getString(a.getContext(), paramTypedArray, R.styleable.FloatingActionMenu_menu_animationDelayPerItem);
    m = org.org.org.ui.menu.ClassWriter.getString(a.getContext(), paramTypedArray, R.styleable.PercentLayout_Layout_layout_marginStartPercent);
    g = paramTypedArray.getBoolean(R.styleable.PercentLayout_Layout_layout_marginEndPercent, false);
    N = paramTypedArray.getDimensionPixelSize(R.styleable.PercentLayout_Layout_layout_aspectRatio, 0);
    j = v7.v7.package_13.ViewCompat.add(a);
    int k = a.getPaddingTop();
    int i1 = v7.v7.package_13.ViewCompat.format(a);
    int i2 = a.getPaddingBottom();
    if (paramTypedArray.hasValue(R.styleable.MaterialProgressBar_android_tint)) {
      setSupportBackgroundTintList();
    } else {
      init();
    }
    v7.v7.package_13.ViewCompat.get(a, j + s, k + e, i1 + n, i2 + b);
  }
  
  void initialize(m paramM)
  {
    x = paramM;
    init(paramM);
  }
  
  boolean next()
  {
    return g;
  }
  
  void setBackgroundDrawable(int paramInt)
  {
    if (inflate() != null) {
      inflate().setTint(paramInt);
    }
  }
  
  void setSupportBackgroundTintList()
  {
    p = true;
    a.setSupportBackgroundTintList(mBackgroundTint);
    a.setSupportBackgroundTintMode(mTintMode);
  }
  
  void setSupportBackgroundTintList(int paramInt)
  {
    if (h != paramInt)
    {
      h = paramInt;
      a();
    }
  }
  
  void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (mBackgroundTint != paramColorStateList)
    {
      mBackgroundTint = paramColorStateList;
      if (inflate() != null) {
        DrawableCompat.append(inflate(), mBackgroundTint);
      }
    }
  }
  
  void setSupportBackgroundTintList(boolean paramBoolean)
  {
    f = paramBoolean;
    a();
  }
  
  ColorStateList setSupportBackgroundTintMode()
  {
    return l;
  }
  
  public void setSupportBackgroundTintMode(int paramInt)
  {
    a(paramInt, b);
  }
  
  void setSupportBackgroundTintMode(ColorStateList paramColorStateList)
  {
    if (l != paramColorStateList)
    {
      l = paramColorStateList;
      a();
    }
  }
  
  void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (mTintMode != paramMode)
    {
      mTintMode = paramMode;
      if ((inflate() != null) && (mTintMode != null)) {
        DrawableCompat.setTintMode(inflate(), mTintMode);
      }
    }
  }
  
  void setSupportBackgroundTintMode(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    a(e, paramInt);
  }
  
  public GeoPoint start()
  {
    LayerDrawable localLayerDrawable = type;
    if ((localLayerDrawable != null) && (localLayerDrawable.getNumberOfLayers() > 1))
    {
      if (type.getNumberOfLayers() > 2) {
        return (GeoPoint)type.getDrawable(2);
      }
      return (GeoPoint)type.getDrawable(1);
    }
    return null;
  }
  
  m t()
  {
    return x;
  }
}
