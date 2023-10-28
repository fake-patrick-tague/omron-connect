package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.material.internal.Label;
import com.google.android.material.internal.d;
import com.google.android.material.internal.m;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import org.org.org.ui.DisplayDimensions;
import org.org.org.ui.R.id;
import org.org.org.ui.R.raw;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import org.org.org.ui.Switch;
import org.org.org.ui.menu.h;
import v7.v7.package_13.ViewCompat;

public class BadgeDrawable
  extends Drawable
  implements m
{
  private static final int o = R.string.info;
  private static final int p = org.org.org.ui.ClassWriter.u;
  private final d a;
  private final Rect b;
  private int c;
  private final float d;
  private final org.org.org.ui.asm.f f;
  private float g;
  private WeakReference<View> l;
  private WeakReference<FrameLayout> m;
  private final float n;
  private float r;
  private final WeakReference<Context> s;
  private float t;
  private final SavedState this$0;
  private float u;
  private final float v;
  private float x;
  
  private BadgeDrawable(Context paramContext)
  {
    s = new WeakReference(paramContext);
    Label.b(paramContext);
    Object localObject = paramContext.getResources();
    b = new Rect();
    f = new org.org.org.ui.asm.f();
    v = ((Resources)localObject).getDimensionPixelSize(R.raw.widthDimensionResId);
    d = ((Resources)localObject).getDimensionPixelSize(R.raw.gravity);
    n = ((Resources)localObject).getDimensionPixelSize(R.raw.width);
    localObject = new d(this);
    a = ((d)localObject);
    ((d)localObject).getTitle().setTextAlign(Paint.Align.CENTER);
    this$0 = new SavedState(paramContext);
    f(R.string.db);
  }
  
  public static BadgeDrawable a(Context paramContext)
  {
    return a(paramContext, null, p, o);
  }
  
  private static BadgeDrawable a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    BadgeDrawable localBadgeDrawable = new BadgeDrawable(paramContext);
    localBadgeDrawable.init(paramContext, paramAttributeSet, paramInt1, paramInt2);
    return localBadgeDrawable;
  }
  
  private void a()
  {
    Context localContext = (Context)s.get();
    Object localObject1 = l;
    FrameLayout localFrameLayout = null;
    if (localObject1 != null) {
      localObject1 = (View)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if (localContext != null)
    {
      if (localObject1 == null) {
        return;
      }
      Rect localRect1 = new Rect();
      localRect1.set(b);
      Rect localRect2 = new Rect();
      ((View)localObject1).getDrawingRect(localRect2);
      Object localObject2 = m;
      if (localObject2 != null) {
        localFrameLayout = (FrameLayout)((WeakReference)localObject2).get();
      }
      if ((localFrameLayout != null) || (f.c))
      {
        localObject2 = localFrameLayout;
        if (localFrameLayout == null) {
          localObject2 = (ViewGroup)((View)localObject1).getParent();
        }
        ((ViewGroup)localObject2).offsetDescendantRectToMyCoords((View)localObject1, localRect2);
      }
      a(localContext, localRect2, (View)localObject1);
      f.add(b, x, t, r, u);
      f.c(g);
      if (!localRect1.equals(b)) {
        f.setBounds(b);
      }
    }
  }
  
  private void a(Context paramContext, Rect paramRect, View paramView)
  {
    int i = SavedState.toString(this$0);
    if ((i != 8388691) && (i != 8388693)) {
      t = (top + SavedState.access$getDate(this$0));
    } else {
      t = (bottom - SavedState.access$getDate(this$0));
    }
    float f1;
    if (d() <= 9)
    {
      if (!hasNext()) {
        f1 = v;
      } else {
        f1 = n;
      }
      g = f1;
      u = f1;
      r = f1;
    }
    else
    {
      f1 = n;
      g = f1;
      u = f1;
      String str = getName();
      r = (a.a(str) / 2.0F + d);
    }
    paramContext = paramContext.getResources();
    if (hasNext()) {
      i = R.raw.d;
    } else {
      i = R.raw.header;
    }
    i = paramContext.getDimensionPixelSize(i);
    int j = SavedState.toString(this$0);
    if ((j != 8388659) && (j != 8388691))
    {
      if (ViewCompat.getLayoutDirection(paramView) == 0) {
        f1 = right + r - i - SavedState.access$getPath(this$0);
      } else {
        f1 = left - r + i + SavedState.access$getPath(this$0);
      }
      x = f1;
      return;
    }
    if (ViewCompat.getLayoutDirection(paramView) == 0) {
      f1 = left - r + i + SavedState.access$getPath(this$0);
    } else {
      f1 = right + r - i - SavedState.access$getPath(this$0);
    }
    x = f1;
  }
  
  private void a(Canvas paramCanvas)
  {
    Rect localRect = new Rect();
    String str = getName();
    a.getTitle().getTextBounds(str, 0, str.length(), localRect);
    paramCanvas.drawText(str, x, t + localRect.height() / 2, a.getTitle());
  }
  
  private void b()
  {
    c = ((int)Math.pow(10.0D, f() - 1.0D) - 1);
  }
  
  private void b(SavedState paramSavedState)
  {
    a(SavedState.f(paramSavedState));
    if (SavedState.b(paramSavedState) != -1) {
      b(SavedState.b(paramSavedState));
    }
    update(SavedState.getItemId(paramSavedState));
    setColor(SavedState.c(paramSavedState));
    c(SavedState.toString(paramSavedState));
    append(SavedState.access$getPath(paramSavedState));
    putShort(SavedState.access$getDate(paramSavedState));
    b(SavedState.a(paramSavedState));
  }
  
  private void b(h paramH)
  {
    if (a.a() == paramH) {
      return;
    }
    Context localContext = (Context)s.get();
    if (localContext == null) {
      return;
    }
    a.a(paramH, localContext);
    a();
  }
  
  static BadgeDrawable f(Context paramContext, SavedState paramSavedState)
  {
    paramContext = new BadgeDrawable(paramContext);
    paramContext.b(paramSavedState);
    return paramContext;
  }
  
  private void f(int paramInt)
  {
    Context localContext = (Context)s.get();
    if (localContext == null) {
      return;
    }
    b(new h(localContext, paramInt));
  }
  
  private String getName()
  {
    if (d() <= c) {
      return NumberFormat.getInstance().format(d());
    }
    Context localContext = (Context)s.get();
    if (localContext == null) {
      return "";
    }
    return localContext.getString(Switch.c, new Object[] { Integer.valueOf(c), "+" });
  }
  
  private static int init(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    return org.org.org.ui.menu.ClassWriter.getString(paramContext, paramTypedArray, paramInt).getDefaultColor();
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramAttributeSet = Label.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SVGImageView, paramInt1, paramInt2, new int[0]);
    a(paramAttributeSet.getInt(R.styleable.CircleProgress_circle_max, 4));
    paramInt1 = R.styleable.MaterialProgressBar_mpb_tintMode;
    if (paramAttributeSet.hasValue(paramInt1)) {
      b(paramAttributeSet.getInt(paramInt1, 0));
    }
    update(init(paramContext, paramAttributeSet, R.styleable.ProgressBar_android_maxWidth));
    paramInt1 = R.styleable.ViewBackgroundHelper_android_background;
    if (paramAttributeSet.hasValue(paramInt1)) {
      setColor(init(paramContext, paramAttributeSet, paramInt1));
    }
    c(paramAttributeSet.getInt(R.styleable.ViewBackgroundHelper_backgroundTint, 8388661));
    append(paramAttributeSet.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, 0));
    putShort(paramAttributeSet.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, 0));
    paramAttributeSet.recycle();
  }
  
  private void init(final View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if ((localViewGroup == null) || (localViewGroup.getId() != R.id.key))
    {
      Object localObject = m;
      if ((localObject != null) && (((WeakReference)localObject).get() == localViewGroup)) {
        return;
      }
      show(paramView);
      localObject = new FrameLayout(paramView.getContext());
      ((View)localObject).setId(R.id.key);
      ((ViewGroup)localObject).setClipChildren(false);
      ((ViewGroup)localObject).setClipToPadding(false);
      ((View)localObject).setLayoutParams(paramView.getLayoutParams());
      ((View)localObject).setMinimumWidth(paramView.getWidth());
      ((View)localObject).setMinimumHeight(paramView.getHeight());
      int i = localViewGroup.indexOfChild(paramView);
      localViewGroup.removeViewAt(i);
      paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      ((ViewGroup)localObject).addView(paramView);
      localViewGroup.addView((View)localObject, i);
      m = new WeakReference(localObject);
      ((View)localObject).post(new a(paramView, (FrameLayout)localObject));
    }
  }
  
  private static void show(View paramView)
  {
    paramView = (ViewGroup)paramView.getParent();
    paramView.setClipChildren(false);
    paramView.setClipToPadding(false);
  }
  
  public void a(int paramInt)
  {
    if (SavedState.f(this$0) != paramInt)
    {
      SavedState.access$setId(this$0, paramInt);
      b();
      a.a(true);
      a();
      invalidateSelf();
    }
  }
  
  public void append(int paramInt)
  {
    SavedState.getPath(this$0, paramInt);
    a();
  }
  
  public void b(int paramInt)
  {
    paramInt = Math.max(0, paramInt);
    if (SavedState.b(this$0) != paramInt)
    {
      SavedState.a(this$0, paramInt);
      a.a(true);
      a();
      invalidateSelf();
    }
  }
  
  public void b(View paramView, FrameLayout paramFrameLayout)
  {
    l = new WeakReference(paramView);
    boolean bool = f.c;
    if ((bool) && (paramFrameLayout == null)) {
      init(paramView);
    } else {
      m = new WeakReference(paramFrameLayout);
    }
    if (!bool) {
      show(paramView);
    }
    a();
    invalidateSelf();
  }
  
  public void b(boolean paramBoolean)
  {
    setVisible(paramBoolean, false);
    SavedState.f(this$0, paramBoolean);
    if ((f.c) && (c() != null) && (!paramBoolean)) {
      ((ViewGroup)c().getParent()).invalidate();
    }
  }
  
  public FrameLayout c()
  {
    WeakReference localWeakReference = m;
    if (localWeakReference != null) {
      return (FrameLayout)localWeakReference.get();
    }
    return null;
  }
  
  public void c(int paramInt)
  {
    if (SavedState.toString(this$0) != paramInt)
    {
      SavedState.access$setValue(this$0, paramInt);
      Object localObject = l;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        View localView = (View)l.get();
        localObject = m;
        if (localObject != null) {
          localObject = (FrameLayout)((WeakReference)localObject).get();
        } else {
          localObject = null;
        }
        b(localView, (FrameLayout)localObject);
      }
    }
  }
  
  public int d()
  {
    if (!hasNext()) {
      return 0;
    }
    return SavedState.b(this$0);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((!getBounds().isEmpty()) && (getAlpha() != 0))
    {
      if (!isVisible()) {
        return;
      }
      f.draw(paramCanvas);
      if (hasNext()) {
        a(paramCanvas);
      }
    }
  }
  
  public int f()
  {
    return SavedState.f(this$0);
  }
  
  public CharSequence get()
  {
    if (!isVisible()) {
      return null;
    }
    if (hasNext())
    {
      if (SavedState.getTime(this$0) > 0)
      {
        Context localContext = (Context)s.get();
        if (localContext == null) {
          return null;
        }
        if (d() <= c) {
          return localContext.getResources().getQuantityString(SavedState.getTime(this$0), d(), new Object[] { Integer.valueOf(d()) });
        }
        return localContext.getString(SavedState.access$getI(this$0), new Object[] { Integer.valueOf(c) });
      }
      return null;
    }
    return SavedState.getEntry(this$0);
  }
  
  public int getAlpha()
  {
    return SavedState.access$getD(this$0);
  }
  
  public int getIntrinsicHeight()
  {
    return b.height();
  }
  
  public int getIntrinsicWidth()
  {
    return b.width();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean hasNext()
  {
    return SavedState.b(this$0) != -1;
  }
  
  public boolean isStateful()
  {
    return false;
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    return super.onStateChange(paramArrayOfInt);
  }
  
  public SavedState p()
  {
    return this$0;
  }
  
  public void putShort(int paramInt)
  {
    SavedState.access$setDate(this$0, paramInt);
    a();
  }
  
  public void setAlpha(int paramInt)
  {
    SavedState.b(this$0, paramInt);
    a.getTitle().setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColor(int paramInt)
  {
    SavedState.getColor(this$0, paramInt);
    if (a.getTitle().getColor() != paramInt)
    {
      a.getTitle().setColor(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setVisible()
  {
    invalidateSelf();
  }
  
  public void update(int paramInt)
  {
    SavedState.processBlock(this$0, paramInt);
    ColorStateList localColorStateList = ColorStateList.valueOf(paramInt);
    if (f.getIntent() != localColorStateList)
    {
      f.setColor(localColorStateList);
      invalidateSelf();
    }
  }
  
  public static final class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    private int a;
    private int b = -1;
    private int c;
    private int d = 255;
    private int date;
    private boolean f;
    private int i;
    private int id;
    private int path;
    private int time;
    private CharSequence type;
    private int value;
    
    public SavedState(Context paramContext)
    {
      c = hdbu.getDefaultColor();
      type = paramContext.getString(Switch.x);
      time = DisplayDimensions.a;
      i = Switch.i;
      f = true;
    }
    
    protected SavedState(Parcel paramParcel)
    {
      a = paramParcel.readInt();
      c = paramParcel.readInt();
      d = paramParcel.readInt();
      b = paramParcel.readInt();
      id = paramParcel.readInt();
      type = paramParcel.readString();
      time = paramParcel.readInt();
      value = paramParcel.readInt();
      path = paramParcel.readInt();
      date = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      f = bool;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    static final class a
      implements Parcelable.Creator<BadgeDrawable.SavedState>
    {
      a() {}
      
      public BadgeDrawable.SavedState[] a(int paramInt)
      {
        return new BadgeDrawable.SavedState[paramInt];
      }
      
      public BadgeDrawable.SavedState readDate(Parcel paramParcel)
      {
        return new BadgeDrawable.SavedState(paramParcel);
      }
    }
  }
  
  class a
    implements Runnable
  {
    a(View paramView, FrameLayout paramFrameLayout) {}
    
    public void run()
    {
      b(paramView, a);
    }
  }
}
