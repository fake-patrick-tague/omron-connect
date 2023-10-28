package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Layout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.theme.utils.Effect;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import org.org.org.ui.asm.ByteVector;
import org.org.org.ui.asm.GeoPoint;
import org.org.org.ui.asm.Item;
import org.org.org.ui.asm.f;
import org.org.org.ui.asm.m;

public class MaterialButton
  extends AppCompatButton
  implements Checkable, GeoPoint
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int N = R.string.N;
  private static final int[] PRESSED_STATE_SET = { 16842911 };
  private Drawable a;
  private int c;
  private b connectThread;
  private int f;
  private int g;
  private PorterDuff.Mode j;
  private ColorStateList l;
  private final AppCompatEditText mBackgroundTintHelper;
  private boolean mBroadcasting;
  private boolean mChecked;
  private final LinkedHashSet<a> mItems = new LinkedHashSet();
  private int u;
  private int v;
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, org.org.org.ui.ClassWriter.INT);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(Effect.a(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    boolean bool = false;
    mChecked = false;
    mBroadcasting = false;
    Context localContext = getContext();
    paramContext = com.google.android.material.internal.Label.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.DragSortListView, paramInt, i, new int[0]);
    g = paramContext.getDimensionPixelSize(R.styleable.DragSortListView_collapsed_height, 0);
    j = com.google.android.material.internal.ViewCompat.parseTintMode(paramContext.getInt(R.styleable.DragSortListView_track_drag_sort, -1), PorterDuff.Mode.SRC_IN);
    l = org.org.org.ui.menu.ClassWriter.getString(getContext(), paramContext, R.styleable.MaterialRippleLayout_mrl_rippleAlpha);
    a = org.org.org.ui.menu.ClassWriter.getDrawable(getContext(), paramContext, R.styleable.MaterialRippleLayout_mrl_rippleDelayClick);
    f = paramContext.getInteger(R.styleable.MaterialRippleLayout_mrl_rippleFadeDuration, 1);
    c = paramContext.getDimensionPixelSize(R.styleable.MaterialRippleLayout_mrl_rippleBackground, 0);
    paramAttributeSet = new AppCompatEditText(this, m.a(localContext, paramAttributeSet, paramInt, i).a());
    mBackgroundTintHelper = paramAttributeSet;
    paramAttributeSet.init(paramContext);
    paramContext.recycle();
    setCompoundDrawablePadding(g);
    if (a != null) {
      bool = true;
    }
    a(bool);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (a != null)
    {
      if (getLayout() == null) {
        return;
      }
      int i;
      if ((!b()) && (!c()))
      {
        if (a())
        {
          u = 0;
          if (f == 16)
          {
            v = 0;
            a(false);
            return;
          }
          i = c;
          paramInt1 = i;
          if (i == 0) {
            paramInt1 = a.getIntrinsicHeight();
          }
          paramInt1 = (paramInt2 - getTextHeight() - getPaddingTop() - paramInt1 - g - getPaddingBottom()) / 2;
          if (v != paramInt1)
          {
            v = paramInt1;
            a(false);
          }
        }
      }
      else
      {
        v = 0;
        paramInt2 = f;
        boolean bool1 = true;
        if ((paramInt2 != 1) && (paramInt2 != 3))
        {
          i = c;
          paramInt2 = i;
          if (i == 0) {
            paramInt2 = a.getIntrinsicWidth();
          }
          paramInt2 = (paramInt1 - getTextWidth() - v7.v7.package_13.ViewCompat.format(this) - paramInt2 - g - v7.v7.package_13.ViewCompat.add(this)) / 2;
          boolean bool2 = isLayoutRtl();
          if (f != 4) {
            bool1 = false;
          }
          paramInt1 = paramInt2;
          if (bool2 != bool1) {
            paramInt1 = -paramInt2;
          }
          if (u != paramInt1)
          {
            u = paramInt1;
            a(false);
          }
        }
        else
        {
          u = 0;
          a(false);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = a;
    int i;
    if (localObject1 != null)
    {
      localObject1 = DrawableCompat.getDrawable((Drawable)localObject1).mutate();
      a = ((Drawable)localObject1);
      DrawableCompat.append((Drawable)localObject1, l);
      localObject1 = j;
      if (localObject1 != null) {
        DrawableCompat.setTintMode(a, (PorterDuff.Mode)localObject1);
      }
      i = c;
      if (i == 0) {
        i = a.getIntrinsicWidth();
      }
      k = c;
      if (k == 0) {
        k = a.getIntrinsicHeight();
      }
      localObject1 = a;
      int m = u;
      int n = v;
      ((Drawable)localObject1).setBounds(m, n, i + m, k + n);
    }
    if (paramBoolean)
    {
      visitMaxs();
      return;
    }
    Object localObject3 = androidx.core.widget.Label.b(this);
    int k = 0;
    localObject1 = localObject3[0];
    Object localObject2 = localObject3[1];
    localObject3 = localObject3[2];
    if (((!b()) || (localObject1 == a)) && ((!c()) || (localObject3 == a)))
    {
      i = k;
      if (a())
      {
        i = k;
        if (localObject2 == a) {}
      }
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      visitMaxs();
    }
  }
  
  private boolean a()
  {
    int i = f;
    return (i == 16) || (i == 32);
  }
  
  private boolean b()
  {
    int i = f;
    if (i != 1) {
      return i == 2;
    }
    return true;
  }
  
  private boolean c()
  {
    int i = f;
    return (i == 3) || (i == 4);
  }
  
  private boolean g()
  {
    AppCompatEditText localAppCompatEditText = mBackgroundTintHelper;
    return (localAppCompatEditText != null) && (!localAppCompatEditText.b());
  }
  
  private String getA11yClassName()
  {
    Object localObject;
    if (f()) {
      localObject = CompoundButton.class;
    } else {
      localObject = Button.class;
    }
    return ((Class)localObject).getName();
  }
  
  private int getTextHeight()
  {
    TextPaint localTextPaint = getPaint();
    Object localObject2 = getText().toString();
    Object localObject1 = localObject2;
    if (getTransformationMethod() != null) {
      localObject1 = getTransformationMethod().getTransformation((CharSequence)localObject2, this).toString();
    }
    localObject2 = new Rect();
    localTextPaint.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
    return Math.min(((Rect)localObject2).height(), getLayout().getHeight());
  }
  
  private int getTextWidth()
  {
    TextPaint localTextPaint = getPaint();
    String str2 = getText().toString();
    String str1 = str2;
    if (getTransformationMethod() != null) {
      str1 = getTransformationMethod().getTransformation(str2, this).toString();
    }
    return Math.min((int)localTextPaint.measureText(str1), getLayout().getEllipsizedWidth());
  }
  
  private boolean isLayoutRtl()
  {
    return v7.v7.package_13.ViewCompat.getLayoutDirection(this) == 1;
  }
  
  private void visitMaxs()
  {
    if (b())
    {
      androidx.core.widget.Label.a(this, a, null, null, null);
      return;
    }
    if (c())
    {
      androidx.core.widget.Label.a(this, null, null, a, null);
      return;
    }
    if (a()) {
      androidx.core.widget.Label.a(this, null, a, null, null);
    }
  }
  
  public boolean f()
  {
    AppCompatEditText localAppCompatEditText = mBackgroundTintHelper;
    return (localAppCompatEditText != null) && (localAppCompatEditText.next());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return getSupportBackgroundTintMode();
  }
  
  public int getCornerRadius()
  {
    if (g()) {
      return mBackgroundTintHelper.getMarginBottom();
    }
    return 0;
  }
  
  public Drawable getIcon()
  {
    return a;
  }
  
  public int getIconGravity()
  {
    return f;
  }
  
  public int getIconPadding()
  {
    return g;
  }
  
  public int getIconSize()
  {
    return c;
  }
  
  public ColorStateList getIconTint()
  {
    return l;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return j;
  }
  
  public int getInsetBottom()
  {
    return mBackgroundTintHelper._2();
  }
  
  public int getInsetTop()
  {
    return mBackgroundTintHelper.getPaddingLeft();
  }
  
  public ColorStateList getRippleColor()
  {
    if (g()) {
      return mBackgroundTintHelper.f();
    }
    return null;
  }
  
  public m getShapeAppearanceModel()
  {
    if (g()) {
      return mBackgroundTintHelper.t();
    }
    throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
  }
  
  public ColorStateList getStrokeColor()
  {
    if (g()) {
      return mBackgroundTintHelper.setSupportBackgroundTintMode();
    }
    return null;
  }
  
  public int getStrokeWidth()
  {
    if (g()) {
      return mBackgroundTintHelper.applySupportBackgroundTint();
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (g()) {
      return mBackgroundTintHelper.getSupportBackgroundTintList();
    }
    return super.getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (g()) {
      return mBackgroundTintHelper.getSupportBackgroundTintMode();
    }
    return super.getSupportBackgroundTintMode();
  }
  
  public boolean isChecked()
  {
    return mChecked;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (g()) {
      ByteVector.a(this, mBackgroundTintHelper.inflate());
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (f()) {
      android.view.View.mergeDrawableStates(arrayOfInt, PRESSED_STATE_SET);
    }
    if (isChecked()) {
      android.view.View.mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(getA11yClassName());
    paramAccessibilityEvent.setChecked(isChecked());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(getA11yClassName());
    paramAccessibilityNodeInfo.setCheckable(f());
    paramAccessibilityNodeInfo.setChecked(isChecked());
    paramAccessibilityNodeInfo.setClickable(isClickable());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Build.VERSION.SDK_INT == 21)
    {
      AppCompatEditText localAppCompatEditText = mBackgroundTintHelper;
      if (localAppCompatEditText != null) {
        localAppCompatEditText.b(paramInt4 - paramInt2, paramInt3 - paramInt1);
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setChecked(checked);
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    checked = mChecked;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    a(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public boolean performClick()
  {
    toggle();
    return super.performClick();
  }
  
  public void remove(a paramA)
  {
    mItems.remove(paramA);
  }
  
  public void removeChildren(a paramA)
  {
    mItems.add(paramA);
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (g())
    {
      mBackgroundTintHelper.setBackgroundDrawable(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (g())
    {
      if (paramDrawable != getBackground())
      {
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        mBackgroundTintHelper.setSupportBackgroundTintList();
        super.setBackgroundDrawable(paramDrawable);
        return;
      }
      getBackground().setState(paramDrawable.getState());
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = v7.internal.transition.util.View.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setBackgroundDrawable(localDrawable);
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setSupportBackgroundTintMode(paramMode);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if (g()) {
      mBackgroundTintHelper.setSupportBackgroundTintMode(paramBoolean);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if ((f()) && (isEnabled()) && (mChecked != paramBoolean))
    {
      mChecked = paramBoolean;
      refreshDrawableState();
      if (mBroadcasting) {
        return;
      }
      mBroadcasting = true;
      Iterator localIterator = mItems.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).b(this, mChecked);
      }
      mBroadcasting = false;
    }
  }
  
  public void setCornerRadius(int paramInt)
  {
    if (g()) {
      mBackgroundTintHelper.b(paramInt);
    }
  }
  
  public void setCornerRadiusResource(int paramInt)
  {
    if (g()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    if (g()) {
      mBackgroundTintHelper.inflate().add(paramFloat);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (a != paramDrawable)
    {
      a = paramDrawable;
      a(true);
      a(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    if (f != paramInt)
    {
      f = paramInt;
      a(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public void setIconPadding(int paramInt)
  {
    if (g != paramInt)
    {
      g = paramInt;
      setCompoundDrawablePadding(paramInt);
    }
  }
  
  public void setIconResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = v7.internal.transition.util.View.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setIcon(localDrawable);
  }
  
  public void setIconSize(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (c != paramInt)
      {
        c = paramInt;
        a(true);
      }
    }
    else {
      throw new IllegalArgumentException("iconSize cannot be less than 0");
    }
  }
  
  public void setIconTint(ColorStateList paramColorStateList)
  {
    if (l != paramColorStateList)
    {
      l = paramColorStateList;
      a(false);
    }
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (j != paramMode)
    {
      j = paramMode;
      a(false);
    }
  }
  
  public void setIconTintResource(int paramInt)
  {
    setIconTint(v7.internal.transition.util.View.a(getContext(), paramInt));
  }
  
  public void setInsetBottom(int paramInt)
  {
    mBackgroundTintHelper.setTextAppearance(paramInt);
  }
  
  public void setInsetTop(int paramInt)
  {
    mBackgroundTintHelper.setSupportBackgroundTintMode(paramInt);
  }
  
  void setInternalBackground(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  void setOnPressedChangeListenerInternal(b paramB)
  {
    connectThread = paramB;
  }
  
  public void setPressed(boolean paramBoolean)
  {
    b localB = connectThread;
    if (localB != null) {
      localB.cancel(this, paramBoolean);
    }
    super.setPressed(paramBoolean);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (g()) {
      mBackgroundTintHelper.init(paramColorStateList);
    }
  }
  
  public void setRippleColorResource(int paramInt)
  {
    if (g()) {
      setRippleColor(v7.internal.transition.util.View.a(getContext(), paramInt));
    }
  }
  
  public void setShapeAppearanceModel(m paramM)
  {
    if (g())
    {
      mBackgroundTintHelper.initialize(paramM);
      return;
    }
    throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
  }
  
  void setShouldDrawSurfaceColorStroke(boolean paramBoolean)
  {
    if (g()) {
      mBackgroundTintHelper.setSupportBackgroundTintList(paramBoolean);
    }
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    if (g()) {
      mBackgroundTintHelper.setSupportBackgroundTintMode(paramColorStateList);
    }
  }
  
  public void setStrokeColorResource(int paramInt)
  {
    if (g()) {
      setStrokeColor(v7.internal.transition.util.View.a(getContext(), paramInt));
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    if (g()) {
      mBackgroundTintHelper.setSupportBackgroundTintList(paramInt);
    }
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    if (g()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (g())
    {
      mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
      return;
    }
    super.setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (g())
    {
      mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
      return;
    }
    super.setSupportBackgroundTintMode(paramMode);
  }
  
  public void toggle()
  {
    setChecked(mChecked ^ true);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    boolean checked;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader == null) {
        SavedState.class.getClassLoader();
      }
      readFromParcel(paramParcel);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    private void readFromParcel(Parcel paramParcel)
    {
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      checked = bool;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    static final class a
      implements Parcelable.ClassLoaderCreator<MaterialButton.SavedState>
    {
      a() {}
      
      public MaterialButton.SavedState[] a(int paramInt)
      {
        return new MaterialButton.SavedState[paramInt];
      }
      
      public MaterialButton.SavedState readDate(Parcel paramParcel)
      {
        return new MaterialButton.SavedState(paramParcel, null);
      }
      
      public MaterialButton.SavedState readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new MaterialButton.SavedState(paramParcel, paramClassLoader);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(MaterialButton paramMaterialButton, boolean paramBoolean);
  }
  
  static abstract interface b
  {
    public abstract void cancel(MaterialButton paramMaterialButton, boolean paramBoolean);
  }
}
