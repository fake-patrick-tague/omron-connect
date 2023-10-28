package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatCheckBox;
import c.j.a.a;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.theme.utils.Effect;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import org.org.org.ui.Switch;
import org.org.org.ui.asm.GeoPoint;
import org.org.org.ui.asm.f;
import org.org.org.ui.asm.m;
import org.org.org.ui.menu.d;
import org.org.org.ui.menu.h;
import org.org.org.ui.utils.Attribute;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.view.asm.i;

public class Chip
  extends AppCompatCheckBox
  implements Element, GeoPoint
{
  private static final int[] CHECKED_STATE_SET = { 16842913 };
  private static final int[] SELECTED_STATE_SET = { 16842911 };
  private static final int a = R.string.left;
  private static final Rect o = new Rect();
  private int B;
  private final c b;
  private final RectF bBox = new RectF();
  private View.OnClickListener clickListener;
  private int coord;
  private final d e = new a();
  private boolean h;
  private boolean i;
  private boolean k;
  private InsetDrawable left;
  private final Rect mAnchor = new Rect();
  private RippleDrawable mBackground;
  private boolean mChecked;
  private CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
  private boolean s;
  private GifDrawable wrapped;
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, org.org.org.ui.ClassWriter.r);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(Effect.a(paramContext, paramAttributeSet, paramInt, j), paramAttributeSet, paramInt);
    paramContext = getContext();
    init(paramAttributeSet);
    GifDrawable localGifDrawable = GifDrawable.a(paramContext, paramAttributeSet, paramInt, j);
    init(paramContext, paramAttributeSet, paramInt);
    setChipDrawable(localGifDrawable);
    localGifDrawable.add(v7.v7.package_13.ViewCompat.getElevation(this));
    paramAttributeSet = com.google.android.material.internal.Label.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.a, paramInt, j, new int[0]);
    if (Build.VERSION.SDK_INT < 23) {
      setTextColor(org.org.org.ui.menu.ClassWriter.getString(paramContext, paramAttributeSet, R.styleable.width));
    }
    boolean bool = paramAttributeSet.hasValue(R.styleable.second);
    paramAttributeSet.recycle();
    b = new c(this);
    onCreate();
    if (!bool) {
      setOutlineProvider();
    }
    setChecked(mChecked);
    setText(localGifDrawable.a());
    setEllipsize(localGifDrawable.getPaint());
    initialize();
    if (!wrapped.getValue())
    {
      setLines(1);
      setHorizontallyScrolling(true);
    }
    setGravity(8388627);
    draw();
    if (d()) {
      setMinHeight(B);
    }
    coord = v7.v7.package_13.ViewCompat.getLayoutDirection(this);
  }
  
  private void build(GifDrawable paramGifDrawable)
  {
    if (paramGifDrawable != null) {
      paramGifDrawable.start(null);
    }
  }
  
  private void clear()
  {
    if (org.org.org.ui.compound.Log.$assertionsDisabled)
    {
      init();
      return;
    }
    wrapped.start(true);
    v7.v7.package_13.ViewCompat.setBackgroundDrawable(this, getBackgroundDrawable());
    draw();
    execute();
  }
  
  private void draw()
  {
    if (!TextUtils.isEmpty(getText()))
    {
      Object localObject = wrapped;
      if (localObject == null) {
        return;
      }
      int n = (int)(((GifDrawable)localObject).transform() + wrapped.getMaxY() + wrapped.getSize());
      int i1 = (int)(wrapped.getPixels() + wrapped.isRunning() + wrapped.recycle());
      int m = n;
      int j = i1;
      if (left != null)
      {
        localObject = new Rect();
        left.getPadding((Rect)localObject);
        j = i1 + left;
        m = n + right;
      }
      v7.v7.package_13.ViewCompat.get(this, j, getPaddingTop(), m, getPaddingBottom());
    }
  }
  
  private void execute()
  {
    if ((getBackgroundDrawable() == left) && (wrapped.getCallback() == null)) {
      wrapped.setCallback(left);
    }
  }
  
  private RectF getCloseIconTouchBounds()
  {
    bBox.setEmpty();
    if ((isEmpty()) && (clickListener != null)) {
      wrapped.draw(bBox);
    }
    return bBox;
  }
  
  private Rect getCloseIconTouchBoundsInt()
  {
    RectF localRectF = getCloseIconTouchBounds();
    mAnchor.set((int)left, (int)top, (int)right, (int)bottom);
    return mAnchor;
  }
  
  private h getTextAppearance()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.d();
    }
    return null;
  }
  
  private void init()
  {
    mBackground = new RippleDrawable(org.org.org.ui.compound.Log.getColor(wrapped.i()), getBackgroundDrawable(), null);
    wrapped.start(false);
    v7.v7.package_13.ViewCompat.setBackgroundDrawable(this, mBackground);
    draw();
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = com.google.android.material.internal.Label.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.a, paramInt, a, new int[0]);
    k = paramContext.getBoolean(R.styleable.FloatingActionButton_fab_progress_indeterminate, false);
    float f = (float)Math.ceil(com.google.android.material.internal.ViewCompat.dpToPx(getContext(), 48));
    B = ((int)Math.ceil(paramContext.getDimension(R.styleable.FloatingActionMenu_menu_shadowYOffset, f)));
    paramContext.recycle();
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
      android.util.Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
    }
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null)
    {
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null)
      {
        if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null)
        {
          if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null)
          {
            if ((paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true)) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1))
            {
              if (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                android.util.Log.w("Chip", "Chip text must be vertically center and start aligned");
              }
            }
            else {
              throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
          }
          else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
          }
        }
        else {
          throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
      }
      else {
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      }
    }
    else {
      throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }
  }
  
  private void initialize()
  {
    TextPaint localTextPaint = getPaint();
    Object localObject = wrapped;
    if (localObject != null) {
      drawableState = ((Drawable)localObject).getState();
    }
    localObject = getTextAppearance();
    if (localObject != null) {
      ((h)localObject).a(getContext(), localTextPaint, e);
    }
  }
  
  private boolean isEmpty()
  {
    GifDrawable localGifDrawable = wrapped;
    return (localGifDrawable != null) && (localGifDrawable.get() != null);
  }
  
  private void onCreate()
  {
    if ((isEmpty()) && (setBounds()) && (clickListener != null))
    {
      v7.v7.package_13.ViewCompat.a(this, b);
      return;
    }
    v7.v7.package_13.ViewCompat.a(this, null);
  }
  
  private void restoreState(GifDrawable paramGifDrawable)
  {
    paramGifDrawable.start(this);
  }
  
  private void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    left = new InsetDrawable(wrapped, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void setCloseIconHovered(boolean paramBoolean)
  {
    if (s != paramBoolean)
    {
      s = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconPressed(boolean paramBoolean)
  {
    if (i != paramBoolean)
    {
      i = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setOutlineProvider()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new b());
    }
  }
  
  private void shrink()
  {
    if (left != null)
    {
      left = null;
      setMinWidth(0);
      setMinHeight((int)getChipMinHeight());
      clear();
    }
  }
  
  private boolean update(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 10) {
      try
      {
        paramMotionEvent = a.class.getDeclaredField("p");
        paramMotionEvent.setAccessible(true);
        c localC = b;
        paramMotionEvent = paramMotionEvent.get(localC);
        paramMotionEvent = (Integer)paramMotionEvent;
        int j = paramMotionEvent.intValue();
        if (j != Integer.MIN_VALUE)
        {
          paramMotionEvent = Integer.TYPE;
          paramMotionEvent = a.class.getDeclaredMethod("V", new Class[] { paramMotionEvent });
          paramMotionEvent.setAccessible(true);
          localC = b;
          paramMotionEvent.invoke(localC, new Object[] { Integer.valueOf(Integer.MIN_VALUE) });
          return true;
        }
      }
      catch (NoSuchFieldException paramMotionEvent)
      {
        android.util.Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
        return false;
      }
      catch (InvocationTargetException paramMotionEvent)
      {
        android.util.Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
        return false;
      }
      catch (IllegalAccessException paramMotionEvent)
      {
        android.util.Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
        return false;
      }
      catch (NoSuchMethodException paramMotionEvent)
      {
        android.util.Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
      }
    }
    return false;
  }
  
  private int[] update()
  {
    boolean bool = isEnabled();
    int n = 0;
    if (bool) {
      m = 1;
    } else {
      m = 0;
    }
    int j = m;
    if (h) {
      j = m + 1;
    }
    int m = j;
    if (s) {
      m = j + 1;
    }
    j = m;
    if (i) {
      j = m + 1;
    }
    m = j;
    if (isChecked()) {
      m = j + 1;
    }
    int[] arrayOfInt = new int[m];
    m = n;
    if (isEnabled())
    {
      arrayOfInt[0] = 16842910;
      m = 1;
    }
    j = m;
    if (h)
    {
      arrayOfInt[m] = 16842908;
      j = m + 1;
    }
    m = j;
    if (s)
    {
      arrayOfInt[j] = 16843623;
      m = j + 1;
    }
    j = m;
    if (i)
    {
      arrayOfInt[m] = 16842919;
      j = m + 1;
    }
    if (isChecked()) {
      arrayOfInt[j] = 16842913;
    }
    return arrayOfInt;
  }
  
  public void a()
  {
    a(B);
    requestLayout();
    if (Build.VERSION.SDK_INT >= 21) {
      invalidateOutline();
    }
  }
  
  public boolean a(int paramInt)
  {
    B = paramInt;
    boolean bool = d();
    int m = 0;
    if (!bool)
    {
      if (left != null)
      {
        shrink();
        return false;
      }
      clear();
      return false;
    }
    int n = Math.max(0, paramInt - wrapped.getIntrinsicHeight());
    int j = Math.max(0, paramInt - wrapped.getIntrinsicWidth());
    if ((j <= 0) && (n <= 0))
    {
      if (left != null)
      {
        shrink();
        return false;
      }
      clear();
      return false;
    }
    if (j > 0) {
      j /= 2;
    } else {
      j = 0;
    }
    if (n > 0) {
      m = n / 2;
    }
    if (left != null)
    {
      Rect localRect = new Rect();
      left.getPadding(localRect);
      if ((top == m) && (bottom == m) && (left == j) && (right == j))
      {
        clear();
        return true;
      }
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (getMinHeight() != paramInt) {
        setMinHeight(paramInt);
      }
      if (getMinWidth() != paramInt) {
        setMinWidth(paramInt);
      }
    }
    else
    {
      setMinHeight(paramInt);
      setMinWidth(paramInt);
    }
    setBounds(j, m, j, m);
    clear();
    return true;
  }
  
  public boolean b()
  {
    boolean bool = false;
    playSoundEffect(0);
    View.OnClickListener localOnClickListener = clickListener;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(this);
      bool = true;
    }
    b.a(1, 1);
    return bool;
  }
  
  public boolean d()
  {
    return k;
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    return (update(paramMotionEvent)) || (b.a(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((b.a(paramKeyEvent)) && (b.i() != Integer.MIN_VALUE)) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    GifDrawable localGifDrawable = wrapped;
    boolean bool;
    if ((localGifDrawable != null) && (localGifDrawable.stop())) {
      bool = wrapped.reset(update());
    } else {
      bool = false;
    }
    if (bool) {
      invalidate();
    }
  }
  
  public boolean equals()
  {
    GifDrawable localGifDrawable = wrapped;
    return (localGifDrawable != null) && (localGifDrawable.getDirectory());
  }
  
  public Drawable getBackgroundDrawable()
  {
    InsetDrawable localInsetDrawable = left;
    if (localInsetDrawable == null) {
      return wrapped;
    }
    return localInsetDrawable;
  }
  
  public Drawable getCheckedIcon()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.setColorFilter();
    }
    return null;
  }
  
  public ColorStateList getCheckedIconTint()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getPixel();
    }
    return null;
  }
  
  public ColorStateList getChipBackgroundColor()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getNodeName();
    }
    return null;
  }
  
  public float getChipCornerRadius()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return Math.max(0.0F, localGifDrawable.getHeight());
    }
    return 0.0F;
  }
  
  public Drawable getChipDrawable()
  {
    return wrapped;
  }
  
  public float getChipEndPadding()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.transform();
    }
    return 0.0F;
  }
  
  public Drawable getChipIcon()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.next();
    }
    return null;
  }
  
  public float getChipIconSize()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getPaddingBottom();
    }
    return 0.0F;
  }
  
  public ColorStateList getChipIconTint()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.setLoopCount();
    }
    return null;
  }
  
  public float getChipMinHeight()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getCornerRadius();
    }
    return 0.0F;
  }
  
  public float getChipStartPadding()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getPixels();
    }
    return 0.0F;
  }
  
  public ColorStateList getChipStrokeColor()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getError();
    }
    return null;
  }
  
  public float getChipStrokeWidth()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.setAlpha();
    }
    return 0.0F;
  }
  
  public CharSequence getChipText()
  {
    return getText();
  }
  
  public Drawable getCloseIcon()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.get();
    }
    return null;
  }
  
  public CharSequence getCloseIconContentDescription()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getLoopCount();
    }
    return null;
  }
  
  public float getCloseIconEndPadding()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getCurrentPosition();
    }
    return 0.0F;
  }
  
  public float getCloseIconSize()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getMaxX();
    }
    return 0.0F;
  }
  
  public float getCloseIconStartPadding()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.setDither();
    }
    return 0.0F;
  }
  
  public ColorStateList getCloseIconTint()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getItemId();
    }
    return null;
  }
  
  public TextUtils.TruncateAt getEllipsize()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getPaint();
    }
    return null;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    if ((b.i() != 1) && (b.h() != 1))
    {
      super.getFocusedRect(paramRect);
      return;
    }
    paramRect.set(getCloseIconTouchBoundsInt());
  }
  
  public Attribute getHideMotionSpec()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.remove();
    }
    return null;
  }
  
  public float getIconEndPadding()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.nextFloat();
    }
    return 0.0F;
  }
  
  public float getIconStartPadding()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getData();
    }
    return 0.0F;
  }
  
  public ColorStateList getRippleColor()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.i();
    }
    return null;
  }
  
  public m getShapeAppearanceModel()
  {
    return wrapped.c();
  }
  
  public Attribute getShowMotionSpec()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getComment();
    }
    return null;
  }
  
  public float getTextEndPadding()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.getMaxY();
    }
    return 0.0F;
  }
  
  public float getTextStartPadding()
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      return localGifDrawable.isRunning();
    }
    return 0.0F;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    org.org.org.ui.asm.ByteVector.a(this, wrapped);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (isChecked()) {
      View.mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    if (equals()) {
      View.mergeDrawableStates(arrayOfInt, SELECTED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    b.clear(paramBoolean, paramInt, paramRect);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getActionMasked();
    if (j != 7)
    {
      if (j == 10) {
        setCloseIconHovered(false);
      }
    }
    else {
      setCloseIconHovered(getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY()));
    }
    return super.onHoverEvent(paramMotionEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject;
    if ((!equals()) && (!isClickable()))
    {
      paramAccessibilityNodeInfo.setClassName("android.view.View");
    }
    else
    {
      if (equals()) {
        localObject = "android.widget.CompoundButton";
      } else {
        localObject = "android.widget.Button";
      }
      paramAccessibilityNodeInfo.setClassName((CharSequence)localObject);
    }
    paramAccessibilityNodeInfo.setCheckable(equals());
    paramAccessibilityNodeInfo.setClickable(isClickable());
    if ((getParent() instanceof ChipGroup))
    {
      localObject = (ChipGroup)getParent();
      paramAccessibilityNodeInfo = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfo);
      int j;
      if (((ChipGroup)localObject).isDebugDraw()) {
        j = ((ChipGroup)localObject).a(this);
      } else {
        j = -1;
      }
      paramAccessibilityNodeInfo.setText(v7.v7.package_13.asm.ByteVector.a(((FlowLayout)localObject).b(this), 1, j, 1, false, isChecked()));
    }
  }
  
  public PointerIcon onResolvePointerIcon(MotionEvent paramMotionEvent, int paramInt)
  {
    if ((getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (isEnabled())) {
      return PointerIcon.getSystemIcon(getContext(), 1002);
    }
    return null;
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    if (coord != paramInt)
    {
      coord = paramInt;
      draw();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getActionMasked();
    boolean bool = getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            break label103;
          }
        }
        else
        {
          if (!i) {
            break label103;
          }
          if (bool) {
            break label98;
          }
          setCloseIconPressed(false);
          break label98;
        }
      }
      else if (i)
      {
        b();
        j = 1;
        break label81;
      }
      j = 0;
      label81:
      setCloseIconPressed(false);
      break label105;
    }
    else
    {
      if (!bool) {
        break label103;
      }
      setCloseIconPressed(true);
    }
    label98:
    j = 1;
    break label105;
    label103:
    j = 0;
    label105:
    return (j != 0) || (super.onTouchEvent(paramMotionEvent));
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    if ((paramDrawable != getBackgroundDrawable()) && (paramDrawable != mBackground))
    {
      android.util.Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
      return;
    }
    super.setBackground(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    android.util.Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable != getBackgroundDrawable()) && (paramDrawable != mBackground))
    {
      android.util.Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    android.util.Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    android.util.Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    android.util.Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
  }
  
  public boolean setBounds()
  {
    GifDrawable localGifDrawable = wrapped;
    return (localGifDrawable != null) && (localGifDrawable.isAnimated());
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.reset(paramBoolean);
    }
  }
  
  public void setCheckableResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.f(paramInt);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject = wrapped;
    if (localObject == null)
    {
      mChecked = paramBoolean;
      return;
    }
    if (((GifDrawable)localObject).getDirectory())
    {
      boolean bool = isChecked();
      super.setChecked(paramBoolean);
      if (bool != paramBoolean)
      {
        localObject = mCheckedChangeListener;
        if (localObject != null) {
          ((CompoundButton.OnCheckedChangeListener)localObject).onCheckedChanged(this, paramBoolean);
        }
      }
    }
  }
  
  public void setCheckedIcon(Drawable paramDrawable)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.startAnimation(paramDrawable);
    }
  }
  
  public void setCheckedIconEnabled(boolean paramBoolean)
  {
    setCheckedIconVisible(paramBoolean);
  }
  
  public void setCheckedIconEnabledResource(int paramInt)
  {
    setCheckedIconVisible(paramInt);
  }
  
  public void setCheckedIconResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.startAnimation(paramInt);
    }
  }
  
  public void setCheckedIconTint(ColorStateList paramColorStateList)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.draw(paramColorStateList);
    }
  }
  
  public void setCheckedIconTintResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.setLoopCount(paramInt);
    }
  }
  
  public void setCheckedIconVisible(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.start(paramInt);
    }
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.setVisible(paramBoolean);
    }
  }
  
  public void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.start(paramColorStateList);
    }
  }
  
  public void setChipBackgroundColorResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.seekTo(paramInt);
    }
  }
  
  public void setChipCornerRadius(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.setVisible(paramFloat);
    }
  }
  
  public void setChipCornerRadiusResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.onPageSelected(paramInt);
    }
  }
  
  public void setChipDrawable(GifDrawable paramGifDrawable)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != paramGifDrawable)
    {
      build(localGifDrawable);
      wrapped = paramGifDrawable;
      paramGifDrawable.shutdown(false);
      restoreState(wrapped);
      a(B);
    }
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.draw(paramFloat);
    }
  }
  
  public void setChipEndPaddingResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.draw(paramInt);
    }
  }
  
  public void setChipIcon(Drawable paramDrawable)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.draw(paramDrawable);
    }
  }
  
  public void setChipIconEnabled(boolean paramBoolean)
  {
    setChipIconVisible(paramBoolean);
  }
  
  public void setChipIconEnabledResource(int paramInt)
  {
    setChipIconVisible(paramInt);
  }
  
  public void setChipIconResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.transform(paramInt);
    }
  }
  
  public void setChipIconSize(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.transform(paramFloat);
    }
  }
  
  public void setChipIconSizeResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.toString(paramInt);
    }
  }
  
  public void setChipIconTint(ColorStateList paramColorStateList)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.reset(paramColorStateList);
    }
  }
  
  public void setChipIconTintResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.getSize(paramInt);
    }
  }
  
  public void setChipIconVisible(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.stop(paramInt);
    }
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.recycle(paramBoolean);
    }
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.set(paramFloat);
    }
  }
  
  public void setChipMinHeightResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.collapse(paramInt);
    }
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.create(paramFloat);
    }
  }
  
  public void setChipStartPaddingResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.parse(paramInt);
    }
  }
  
  public void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.setVisible(paramColorStateList);
    }
  }
  
  public void setChipStrokeColorResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.setVisible(paramInt);
    }
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.onCreate(paramFloat);
    }
  }
  
  public void setChipStrokeWidthResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.create(paramInt);
    }
  }
  
  public void setChipText(CharSequence paramCharSequence)
  {
    setText(paramCharSequence);
  }
  
  public void setChipTextResource(int paramInt)
  {
    setText(getResources().getString(paramInt));
  }
  
  public void setCloseIcon(Drawable paramDrawable)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.reset(paramDrawable);
    }
    onCreate();
  }
  
  public void setCloseIconContentDescription(CharSequence paramCharSequence)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.start(paramCharSequence);
    }
  }
  
  public void setCloseIconEnabled(boolean paramBoolean)
  {
    setCloseIconVisible(paramBoolean);
  }
  
  public void setCloseIconEnabledResource(int paramInt)
  {
    setCloseIconVisible(paramInt);
  }
  
  public void setCloseIconEndPadding(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.stop(paramFloat);
    }
  }
  
  public void setCloseIconEndPaddingResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.update(paramInt);
    }
  }
  
  public void setCloseIconResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.resolve(paramInt);
    }
    onCreate();
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.reset(paramFloat);
    }
  }
  
  public void setCloseIconSizeResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.build(paramInt);
    }
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.startAnimation(paramFloat);
    }
  }
  
  public void setCloseIconStartPaddingResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.setCornerRadius(paramInt);
    }
  }
  
  public void setCloseIconTint(ColorStateList paramColorStateList)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.startAnimation(paramColorStateList);
    }
  }
  
  public void setCloseIconTintResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.reset(paramInt);
    }
  }
  
  public void setCloseIconVisible(int paramInt)
  {
    setCloseIconVisible(getResources().getBoolean(paramInt));
  }
  
  public void setCloseIconVisible(boolean paramBoolean)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.draw(paramBoolean);
    }
    onCreate();
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelative(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 0)
    {
      if (paramInt3 == 0)
      {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 0)
    {
      if (paramInt3 == 0)
      {
        super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.add(paramFloat);
    }
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (wrapped == null) {
      return;
    }
    if (paramTruncateAt != TextUtils.TruncateAt.MARQUEE)
    {
      super.setEllipsize(paramTruncateAt);
      GifDrawable localGifDrawable = wrapped;
      if (localGifDrawable != null) {
        localGifDrawable.draw(paramTruncateAt);
      }
    }
    else
    {
      throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean)
  {
    k = paramBoolean;
    a(B);
  }
  
  public void setGravity(int paramInt)
  {
    if (paramInt != 8388627)
    {
      android.util.Log.w("Chip", "Chip text must be vertically center and start aligned");
      return;
    }
    super.setGravity(paramInt);
  }
  
  public void setHideMotionSpec(Attribute paramAttribute)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.add(paramAttribute);
    }
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.write(paramInt);
    }
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.recycle(paramFloat);
    }
  }
  
  public void setIconEndPaddingResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.decode(paramInt);
    }
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.start(paramFloat);
    }
  }
  
  public void setIconStartPaddingResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.encode(paramInt);
    }
  }
  
  public void setLayoutDirection(int paramInt)
  {
    if (wrapped == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 17) {
      super.setLayoutDirection(paramInt);
    }
  }
  
  public void setLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setMaxLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxWidth(int paramInt)
  {
    super.setMaxWidth(paramInt);
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.put(paramInt);
    }
  }
  
  public void setMinLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setMinLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    mCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    clickListener = paramOnClickListener;
    onCreate();
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.stop(paramColorStateList);
    }
    if (!wrapped.setValue()) {
      init();
    }
  }
  
  public void setRippleColorResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null)
    {
      localGifDrawable.pause(paramInt);
      if (!wrapped.setValue()) {
        init();
      }
    }
  }
  
  public void setShapeAppearanceModel(m paramM)
  {
    wrapped.setShapeAppearanceModel(paramM);
  }
  
  public void setShowMotionSpec(Attribute paramAttribute)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.put(paramAttribute);
    }
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.setSpeed(paramInt);
    }
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setSingleLine(paramBoolean);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable == null) {
      return;
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (localGifDrawable.getValue()) {
      paramCharSequence = null;
    } else {
      paramCharSequence = (CharSequence)localObject;
    }
    super.setText((CharSequence)paramCharSequence, paramBufferType);
    paramCharSequence = wrapped;
    if (paramCharSequence != null) {
      paramCharSequence.draw((CharSequence)localObject);
    }
  }
  
  public void setTextAppearance(int paramInt)
  {
    super.setTextAppearance(paramInt);
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.recycle(paramInt);
    }
    initialize();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    paramContext = wrapped;
    if (paramContext != null) {
      paramContext.recycle(paramInt);
    }
    initialize();
  }
  
  public void setTextAppearance(h paramH)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.reset(paramH);
    }
    initialize();
  }
  
  public void setTextAppearanceResource(int paramInt)
  {
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.setCornerRadius(paramFloat);
    }
  }
  
  public void setTextEndPaddingResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.init(paramInt);
    }
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.close(paramFloat);
    }
  }
  
  public void setTextStartPaddingResource(int paramInt)
  {
    GifDrawable localGifDrawable = wrapped;
    if (localGifDrawable != null) {
      localGifDrawable.validate(paramInt);
    }
  }
  
  class a
    extends d
  {
    a() {}
    
    public void a(int paramInt) {}
    
    public void a(Typeface paramTypeface, boolean paramBoolean)
    {
      Chip localChip = Chip.this;
      if (Chip.valueOf(localChip).getValue()) {
        paramTypeface = Chip.valueOf(Chip.this).a();
      } else {
        paramTypeface = getText();
      }
      localChip.setText(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  class b
    extends ViewOutlineProvider
  {
    b() {}
    
    public void getOutline(View paramView, Outline paramOutline)
    {
      if (Chip.valueOf(Chip.this) != null)
      {
        Chip.valueOf(Chip.this).getOutline(paramOutline);
        return;
      }
      paramOutline.setAlpha(0.0F);
    }
  }
  
  private class c
    extends i
  {
    c(Chip paramChip)
    {
      super();
    }
    
    protected int a(float paramFloat1, float paramFloat2)
    {
      if ((Chip.isEmpty(Chip.this)) && (Chip.c(Chip.this).contains(paramFloat1, paramFloat2))) {
        return 1;
      }
      return 0;
    }
    
    protected void a(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      Object localObject = "";
      if (paramInt == 1)
      {
        CharSequence localCharSequence = getCloseIconContentDescription();
        if (localCharSequence != null)
        {
          paramAccessibilityNodeInfoCompat.setContentDescription(localCharSequence);
        }
        else
        {
          localCharSequence = getText();
          Context localContext = getContext();
          paramInt = Switch.d;
          if (!TextUtils.isEmpty(localCharSequence)) {
            localObject = localCharSequence;
          }
          paramAccessibilityNodeInfoCompat.setContentDescription(localContext.getString(paramInt, new Object[] { localObject }).trim());
        }
        paramAccessibilityNodeInfoCompat.setText(Chip.drawText(Chip.this));
        paramAccessibilityNodeInfoCompat.b(v7.v7.package_13.asm.Label.h);
        paramAccessibilityNodeInfoCompat.setEnabled(isEnabled());
        return;
      }
      paramAccessibilityNodeInfoCompat.setContentDescription("");
      paramAccessibilityNodeInfoCompat.setText(Chip.c());
    }
    
    protected void a(List paramList)
    {
      paramList.add(Integer.valueOf(0));
      if ((Chip.isEmpty(Chip.this)) && (setBounds()) && (Chip.access$getClickListener(Chip.this) != null)) {
        paramList.add(Integer.valueOf(1));
      }
    }
    
    protected void a(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      paramAccessibilityNodeInfoCompat.setCheckable(equals());
      paramAccessibilityNodeInfoCompat.setClickable(isClickable());
      if ((!equals()) && (!isClickable()))
      {
        paramAccessibilityNodeInfoCompat.getText("android.view.View");
      }
      else
      {
        if (equals()) {
          localObject = "android.widget.CompoundButton";
        } else {
          localObject = "android.widget.Button";
        }
        paramAccessibilityNodeInfoCompat.getText((CharSequence)localObject);
      }
      Object localObject = getText();
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramAccessibilityNodeInfoCompat.setError((CharSequence)localObject);
        return;
      }
      paramAccessibilityNodeInfoCompat.setContentDescription((CharSequence)localObject);
    }
    
    protected void b(int paramInt, boolean paramBoolean)
    {
      if (paramInt == 1)
      {
        Chip.f(Chip.this, paramBoolean);
        refreshDrawableState();
      }
    }
    
    protected boolean b(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (paramInt2 == 16)
      {
        if (paramInt1 == 0) {
          return performClick();
        }
        if (paramInt1 == 1) {
          return b();
        }
      }
      return false;
    }
  }
}
