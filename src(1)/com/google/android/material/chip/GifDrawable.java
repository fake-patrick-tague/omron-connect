package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.DrawableWrapper;
import com.google.android.material.internal.Label;
import com.google.android.material.internal.ViewCompat;
import com.google.android.material.internal.d;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.org.org.ui.R.styleable;
import org.org.org.ui.asm.f;
import org.org.org.ui.compound.Log;
import org.org.org.ui.menu.h;
import org.org.org.ui.progress.DrawInterface;
import org.org.org.ui.utils.Attribute;
import v7.internal.transition.util.View;
import v7.v7.text.BidiFormatter;

public class GifDrawable
  extends f
  implements DrawableWrapper, Drawable.Callback, com.google.android.material.internal.m
{
  private static final ShapeDrawable IMPL = new ShapeDrawable(new OvalShape());
  private static final int[] LAYOUT_ATTRS = { 16842910 };
  private final d a;
  private int[] array;
  private Drawable b;
  private float bottom;
  private final Context c;
  private int color;
  private ColorStateList context;
  private Attribute cookieComment;
  private int count;
  private ColorStateList current;
  private float data;
  private boolean dir;
  private float dy;
  private boolean f;
  private ColorStateList flags;
  private float g;
  private float h;
  private float height;
  private boolean i;
  private boolean isRecycled;
  private ColorStateList k;
  private boolean key;
  private CharSequence left;
  private CharSequence loopCount;
  private int mAlpha = 255;
  private ColorFilter mColorFilter;
  private ColorStateList mColors;
  private Drawable mDrawable;
  private Drawable mIcon;
  private ColorStateList mId;
  private TextUtils.TruncateAt mPaint;
  private float mPosition;
  private boolean mScale;
  private int mSize;
  private float mState;
  private ColorStateList mTint;
  private PorterDuffColorFilter mTintFilter;
  private PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;
  private boolean mVisible;
  private final PointF n = new PointF();
  private ColorStateList name;
  private float next;
  private final Path o = new Path();
  private int offset;
  private final Paint p = new Paint(1);
  private final Paint paint;
  private Attribute q;
  private final Paint.FontMetrics r = new Paint.FontMetrics();
  private float right;
  private int s;
  private boolean start;
  private float state;
  private WeakReference<a.a> target = new WeakReference(null);
  private int text;
  private Drawable this$0;
  private float top;
  private int u;
  private int v;
  private ColorStateList w;
  private boolean width;
  private final RectF x = new RectF();
  private float y = -1.0F;
  
  private GifDrawable(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    d(paramContext);
    c = paramContext;
    paramAttributeSet = new d(this);
    a = paramAttributeSet;
    left = "";
    getTitledensity = getResourcesgetDisplayMetricsdensity;
    paint = null;
    paramContext = LAYOUT_ATTRS;
    setState(paramContext);
    reset(paramContext);
    f = true;
    if (Log.$assertionsDisabled) {
      IMPL.setTint(-1);
    }
  }
  
  public static GifDrawable a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = new GifDrawable(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramContext.run(paramAttributeSet, paramInt1, paramInt2);
    return paramContext;
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    p.setColor(u);
    p.setStyle(Paint.Style.FILL);
    x.set(paramRect);
    if (!width)
    {
      paramCanvas.drawRoundRect(x, getHeight(), getHeight(), p);
      return;
    }
    a(new RectF(paramRect), o);
    super.a(paramCanvas, p, o, add());
  }
  
  private void append(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private static boolean b(h paramH)
  {
    if (paramH != null)
    {
      paramH = u;
      if ((paramH != null) && (paramH.isStateful())) {
        return true;
      }
    }
    return false;
  }
  
  private void doDraw(Canvas paramCanvas, Rect paramRect)
  {
    if (!width)
    {
      p.setColor(text);
      p.setStyle(Paint.Style.FILL);
      x.set(paramRect);
      paramCanvas.drawRoundRect(x, getHeight(), getHeight(), p);
    }
  }
  
  private ColorFilter draw()
  {
    ColorFilter localColorFilter = mColorFilter;
    if (localColorFilter != null) {
      return localColorFilter;
    }
    return mTintFilter;
  }
  
  private void draw(Canvas paramCanvas, Rect paramRect)
  {
    Paint localPaint = paint;
    if (localPaint != null)
    {
      localPaint.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
      paramCanvas.drawRect(paramRect, paint);
      if ((isRecycled()) || (update()))
      {
        draw(paramRect, x);
        paramCanvas.drawRect(x, paint);
      }
      if (left != null) {
        paramCanvas.drawLine(left, paramRect.exactCenterY(), right, paramRect.exactCenterY(), paint);
      }
      if (reset())
      {
        zoom(paramRect, x);
        paramCanvas.drawRect(x, paint);
      }
      paint.setColor(ColorUtils.setAlphaComponent(-65536, 127));
      move(paramRect, x);
      paramCanvas.drawRect(x, paint);
      paint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
      setBounds(paramRect, x);
      paramCanvas.drawRect(x, paint);
    }
  }
  
  private void draw(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if ((isRecycled()) || (update()))
    {
      float f2 = height + data;
      float f1 = execute();
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        f2 = left + f2;
        left = f2;
        right = (f2 + f1);
      }
      else
      {
        f2 = right - f2;
        right = f2;
        left = (f2 - f1);
      }
      f1 = onDraw();
      f2 = paramRect.exactCenterY() - f1 / 2.0F;
      top = f2;
      bottom = (f2 + f1);
    }
  }
  
  private void drawBackground(Canvas paramCanvas, Rect paramRect)
  {
    if ((g > 0.0F) && (!width))
    {
      p.setColor(s);
      p.setStyle(Paint.Style.STROKE);
      if (!width) {
        p.setColorFilter(draw());
      }
      RectF localRectF = x;
      float f1 = left;
      float f2 = g;
      localRectF.set(f1 + f2 / 2.0F, top + f2 / 2.0F, right - f2 / 2.0F, bottom - f2 / 2.0F);
      f1 = y - g / 2.0F;
      paramCanvas.drawRoundRect(x, f1, f1, p);
    }
  }
  
  private void drawShadow(Canvas paramCanvas, Rect paramRect)
  {
    if (isRecycled())
    {
      draw(paramRect, x);
      paramRect = x;
      float f1 = left;
      float f2 = top;
      paramCanvas.translate(f1, f2);
      b.setBounds(0, 0, (int)x.width(), (int)x.height());
      b.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private float drawText()
  {
    a.getTitle().getFontMetrics(r);
    Paint.FontMetrics localFontMetrics = r;
    return (descent + ascent) / 2.0F;
  }
  
  private boolean equals()
  {
    return (mVisible) && (this$0 != null) && (dir);
  }
  
  private float execute()
  {
    Drawable localDrawable;
    if (start) {
      localDrawable = this$0;
    } else {
      localDrawable = b;
    }
    float f2 = h;
    float f1 = f2;
    if (f2 <= 0.0F)
    {
      f1 = f2;
      if (localDrawable != null) {
        f1 = localDrawable.getIntrinsicWidth();
      }
    }
    return f1;
  }
  
  private void inflate(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (left != null)
    {
      float f1 = height + recycle() + mState;
      float f2 = top + getSize() + bottom;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        left = (left + f1);
        right = (right - f2);
      }
      else
      {
        left = (left + f2);
        right = (right - f1);
      }
      top = top;
      bottom = bottom;
    }
  }
  
  private boolean isRecycled()
  {
    return (isRecycled) && (b != null);
  }
  
  private void move(Rect paramRect, RectF paramRectF)
  {
    paramRectF.set(paramRect);
    if (reset())
    {
      float f1 = top + state + right + mPosition + bottom;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        right = (right - f1);
        return;
      }
      left = (left + f1);
    }
  }
  
  private float onDraw()
  {
    Drawable localDrawable;
    if (start) {
      localDrawable = this$0;
    } else {
      localDrawable = b;
    }
    float f2 = h;
    float f1 = f2;
    if (f2 <= 0.0F)
    {
      f1 = f2;
      if (localDrawable != null)
      {
        f2 = (float)Math.ceil(ViewCompat.dpToPx(c, 24));
        f1 = f2;
        if (localDrawable.getIntrinsicHeight() <= f2) {
          f1 = localDrawable.getIntrinsicHeight();
        }
      }
    }
    return f1;
  }
  
  private void onDraw(Canvas paramCanvas, Rect paramRect)
  {
    if (left != null)
    {
      Object localObject = draw(paramRect, n);
      inflate(paramRect, x);
      if (a.a() != null)
      {
        a.getTitle().drawableState = getState();
        a.a(c);
      }
      a.getTitle().setTextAlign((Paint.Align)localObject);
      int j = Math.round(a.a(a().toString()));
      int i1 = Math.round(x.width());
      int m = 0;
      if (j > i1) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        m = paramCanvas.save();
        paramCanvas.clipRect(x);
      }
      localObject = left;
      paramRect = (Rect)localObject;
      if (j != 0)
      {
        paramRect = (Rect)localObject;
        if (mPaint != null) {
          paramRect = TextUtils.ellipsize((CharSequence)localObject, a.getTitle(), x.width(), mPaint);
        }
      }
      i1 = paramRect.length();
      localObject = n;
      paramCanvas.drawText(paramRect, 0, i1, x, y, a.getTitle());
      if (j != 0) {
        paramCanvas.restoreToCount(m);
      }
    }
  }
  
  private void onFrameReady(ColorStateList paramColorStateList)
  {
    if (current != paramColorStateList)
    {
      current = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  private void paint(Canvas paramCanvas, Rect paramRect)
  {
    if (!width)
    {
      p.setColor(color);
      p.setStyle(Paint.Style.FILL);
      p.setColorFilter(draw());
      x.set(paramRect);
      paramCanvas.drawRoundRect(x, getHeight(), getHeight(), p);
    }
  }
  
  private void render(Canvas paramCanvas, Rect paramRect)
  {
    if (reset())
    {
      zoom(paramRect, x);
      paramRect = x;
      float f1 = left;
      float f2 = top;
      paramCanvas.translate(f1, f2);
      mDrawable.setBounds(0, 0, (int)x.width(), (int)x.height());
      if (Log.$assertionsDisabled)
      {
        mIcon.setBounds(mDrawable.getBounds());
        mIcon.jumpToCurrentState();
        mIcon.draw(paramCanvas);
      }
      else
      {
        mDrawable.draw(paramCanvas);
      }
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private boolean reset()
  {
    return (mScale) && (mDrawable != null);
  }
  
  private boolean reset(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool1 = super.onStateChange(paramArrayOfInt1);
    Object localObject = current;
    if (localObject != null) {
      j = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, text);
    } else {
      j = 0;
    }
    int m = d(j);
    int j = text;
    boolean bool3 = true;
    if (j != m)
    {
      text = m;
      bool1 = true;
    }
    localObject = name;
    if (localObject != null) {
      j = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, color);
    } else {
      j = 0;
    }
    j = d(j);
    if (color != j)
    {
      color = j;
      bool1 = true;
    }
    int i1 = org.org.org.ui.keys.ClassWriter.get(m, j);
    if (count != i1) {
      j = 1;
    } else {
      j = 0;
    }
    if (getIntent() == null) {
      m = 1;
    } else {
      m = 0;
    }
    if ((j | m) != 0)
    {
      count = i1;
      setColor(ColorStateList.valueOf(i1));
      bool1 = true;
    }
    localObject = context;
    if (localObject != null) {
      j = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, s);
    } else {
      j = 0;
    }
    if (s != j)
    {
      s = j;
      bool1 = true;
    }
    if ((w != null) && (Log.isEnabled(paramArrayOfInt1))) {
      j = w.getColorForState(paramArrayOfInt1, u);
    } else {
      j = 0;
    }
    boolean bool2 = bool1;
    if (u != j)
    {
      u = j;
      bool2 = bool1;
      if (key) {
        bool2 = true;
      }
    }
    if ((a.a() != null) && (a.a().u != null)) {
      j = a.a().u.getColorForState(paramArrayOfInt1, v);
    } else {
      j = 0;
    }
    bool1 = bool2;
    if (v != j)
    {
      v = j;
      bool1 = true;
    }
    if ((start(getState(), 16842912)) && (dir)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if ((start != bool2) && (this$0 != null))
    {
      float f1 = recycle();
      start = bool2;
      if (f1 != recycle())
      {
        bool1 = true;
        j = 1;
      }
      else
      {
        j = 0;
        bool1 = true;
      }
    }
    else
    {
      j = 0;
    }
    localObject = mTint;
    if (localObject != null) {
      m = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, offset);
    } else {
      m = 0;
    }
    if (offset != m)
    {
      offset = m;
      mTintFilter = org.org.org.ui.general.GifDrawable.updateTintFilter(this, mTint, mTintMode);
      bool2 = bool3;
    }
    else
    {
      bool2 = bool1;
    }
    bool1 = bool2;
    if (stop(b)) {
      bool1 = bool2 | b.setState(paramArrayOfInt1);
    }
    bool2 = bool1;
    if (stop(this$0)) {
      bool2 = bool1 | this$0.setState(paramArrayOfInt1);
    }
    bool1 = bool2;
    if (stop(mDrawable))
    {
      localObject = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
      System.arraycopy(paramArrayOfInt1, 0, localObject, 0, paramArrayOfInt1.length);
      System.arraycopy(paramArrayOfInt2, 0, localObject, paramArrayOfInt1.length, paramArrayOfInt2.length);
      bool1 = bool2 | mDrawable.setState((int[])localObject);
    }
    bool2 = bool1;
    if (Log.$assertionsDisabled)
    {
      bool2 = bool1;
      if (stop(mIcon)) {
        bool2 = bool1 | mIcon.setState(paramArrayOfInt2);
      }
    }
    if (bool2) {
      invalidateSelf();
    }
    if (j != 0) {
      append();
    }
    return bool2;
  }
  
  private void run(AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    TypedArray localTypedArray = Label.obtainStyledAttributes(c, paramAttributeSet, R.styleable.a, paramInt1, paramInt2, new int[0]);
    width = localTypedArray.hasValue(R.styleable.second);
    onFrameReady(org.org.org.ui.menu.ClassWriter.getString(c, localTypedArray, R.styleable.l2));
    start(org.org.org.ui.menu.ClassWriter.getString(c, localTypedArray, R.styleable.ArcProgress_arc_bottom_text));
    set(localTypedArray.getDimension(R.styleable.CircleProgress_circle_text_size, 0.0F));
    paramInt1 = R.styleable.TitlePageIndicator_topPadding;
    if (localTypedArray.hasValue(paramInt1)) {
      setVisible(localTypedArray.getDimension(paramInt1, 0.0F));
    }
    setVisible(org.org.org.ui.menu.ClassWriter.getString(c, localTypedArray, R.styleable.TextView_maxLines));
    onCreate(localTypedArray.getDimension(R.styleable.LinePageIndicator_gapWidth, 0.0F));
    stop(org.org.org.ui.menu.ClassWriter.getString(c, localTypedArray, R.styleable.AnySoftKeyboardTheme_hintTextColor));
    draw(localTypedArray.getText(R.styleable.BottomSheet_bs_titleTextAppearance));
    h localH = org.org.org.ui.menu.ClassWriter.a(c, localTypedArray, R.styleable.left);
    a = localTypedArray.getDimension(R.styleable.I, a);
    reset(localH);
    paramInt1 = localTypedArray.getInt(R.styleable.CENTER, 0);
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3) {
          draw(TextUtils.TruncateAt.END);
        }
      }
      else {
        draw(TextUtils.TruncateAt.MIDDLE);
      }
    }
    else {
      draw(TextUtils.TruncateAt.START);
    }
    recycle(localTypedArray.getBoolean(R.styleable.START, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null)) {
      recycle(localTypedArray.getBoolean(R.styleable.LIGHT, false));
    }
    draw(org.org.org.ui.menu.ClassWriter.getDrawable(c, localTypedArray, R.styleable.ImageView_src));
    paramInt1 = R.styleable.TextAppearance_textAllCaps;
    if (localTypedArray.hasValue(paramInt1)) {
      reset(org.org.org.ui.menu.ClassWriter.getString(c, localTypedArray, paramInt1));
    }
    transform(localTypedArray.getDimension(R.styleable.LinePageIndicator_lineWidth, -1.0F));
    draw(localTypedArray.getBoolean(R.styleable.SherlockTheme_abDivider, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null)) {
      draw(localTypedArray.getBoolean(R.styleable.header, false));
    }
    reset(org.org.org.ui.menu.ClassWriter.getDrawable(c, localTypedArray, R.styleable.k));
    startAnimation(org.org.org.ui.menu.ClassWriter.getString(c, localTypedArray, R.styleable.TextView_scrollHorizontally));
    reset(localTypedArray.getDimension(R.styleable.FloatingActionMenu_menu_shadowXOffset, 0.0F));
    reset(localTypedArray.getBoolean(R.styleable.SlidingDrawer_animateOnClick, false));
    setVisible(localTypedArray.getBoolean(R.styleable.CalendarView_weekDayTextAppearance, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null)) {
      setVisible(localTypedArray.getBoolean(R.styleable.StickyListHeadersListView_android_clipToPadding, false));
    }
    startAnimation(org.org.org.ui.menu.ClassWriter.getDrawable(c, localTypedArray, R.styleable.RecipientEditTextView_chipDelete));
    paramInt1 = R.styleable.AppCompatTheme_windowFixedHeightMajor;
    if (localTypedArray.hasValue(paramInt1)) {
      draw(org.org.org.ui.menu.ClassWriter.getString(c, localTypedArray, paramInt1));
    }
    put(Attribute.a(c, localTypedArray, R.styleable.i));
    add(Attribute.a(c, localTypedArray, R.styleable.w));
    create(localTypedArray.getDimension(R.styleable.TextView_cursorVisible, 0.0F));
    start(localTypedArray.getDimension(R.styleable.AnySoftKeyboardTheme_hintTextSize, 0.0F));
    recycle(localTypedArray.getDimension(R.styleable.AnySoftKeyboardTheme_suggestionStripHeight, 0.0F));
    close(localTypedArray.getDimension(R.styleable.AnySoftKeyboardTheme_hintOverflowLabel, 0.0F));
    setCornerRadius(localTypedArray.getDimension(R.styleable.SherlockTheme_abItemPadding, 0.0F));
    startAnimation(localTypedArray.getDimension(R.styleable.SherlockTheme_abIcon, 0.0F));
    stop(localTypedArray.getDimension(R.styleable.FloatingActionMenu_menu_shadowRadius, 0.0F));
    draw(localTypedArray.getDimension(R.styleable.TitlePageIndicator_titlePadding, 0.0F));
    put(localTypedArray.getDimensionPixelSize(R.styleable.TitlePageIndicator_clipPadding, Integer.MAX_VALUE));
    localTypedArray.recycle();
  }
  
  private void setBounds(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (reset())
    {
      float f1 = top + state + right + mPosition + bottom;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        float f2 = right;
        right = f2;
        left = (f2 - f1);
      }
      else
      {
        int j = left;
        left = j;
        right = (j + f1);
      }
      top = top;
      bottom = bottom;
    }
  }
  
  private void shutdown()
  {
    ColorStateList localColorStateList;
    if (key) {
      localColorStateList = Log.getColor(k);
    } else {
      localColorStateList = null;
    }
    w = localColorStateList;
  }
  
  private void start()
  {
    mIcon = new RippleDrawable(Log.getColor(i()), mDrawable, IMPL);
  }
  
  private static boolean start(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return false;
    }
    int m = paramArrayOfInt.length;
    int j = 0;
    while (j < m)
    {
      if (paramArrayOfInt[j] == paramInt) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  private static boolean stop(Drawable paramDrawable)
  {
    return (paramDrawable != null) && (paramDrawable.isStateful());
  }
  
  private void transform(Canvas paramCanvas, Rect paramRect)
  {
    if (update())
    {
      draw(paramRect, x);
      paramRect = x;
      float f1 = left;
      float f2 = top;
      paramCanvas.translate(f1, f2);
      this$0.setBounds(0, 0, (int)x.width(), (int)x.height());
      this$0.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void update(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setCallback(this);
    DrawableCompat.a(paramDrawable, DrawableCompat.getLayoutDirection(this));
    paramDrawable.setLevel(getLevel());
    paramDrawable.setVisible(isVisible(), false);
    if (paramDrawable == mDrawable)
    {
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(array());
      }
      DrawableCompat.append(paramDrawable, mId);
      return;
    }
    if (paramDrawable.isStateful()) {
      paramDrawable.setState(getState());
    }
    Drawable localDrawable = b;
    if ((paramDrawable == localDrawable) && (i)) {
      DrawableCompat.append(localDrawable, flags);
    }
  }
  
  private boolean update()
  {
    return (mVisible) && (this$0 != null) && (start);
  }
  
  private static boolean update(ColorStateList paramColorStateList)
  {
    return (paramColorStateList != null) && (paramColorStateList.isStateful());
  }
  
  private void zoom(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (reset())
    {
      float f1 = top + state;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        f1 = right - f1;
        right = f1;
        left = (f1 - right);
      }
      else
      {
        f1 = left + f1;
        left = f1;
        right = (f1 + right);
      }
      float f2 = paramRect.exactCenterY();
      f1 = right;
      f2 -= f1 / 2.0F;
      top = f2;
      bottom = (f2 + f1);
    }
  }
  
  public CharSequence a()
  {
    return left;
  }
  
  public void add(Attribute paramAttribute)
  {
    q = paramAttribute;
  }
  
  protected void append()
  {
    Element localElement = (Element)target.get();
    if (localElement != null) {
      localElement.a();
    }
  }
  
  public int[] array()
  {
    return array;
  }
  
  public void build(int paramInt)
  {
    reset(c.getResources().getDimension(paramInt));
  }
  
  public void close(float paramFloat)
  {
    if (mState != paramFloat)
    {
      mState = paramFloat;
      invalidateSelf();
      append();
    }
  }
  
  public void collapse(int paramInt)
  {
    set(c.getResources().getDimension(paramInt));
  }
  
  public void create(float paramFloat)
  {
    if (height != paramFloat)
    {
      height = paramFloat;
      invalidateSelf();
      append();
    }
  }
  
  public void create(int paramInt)
  {
    onCreate(c.getResources().getDimension(paramInt));
  }
  
  public h d()
  {
    return a.a();
  }
  
  public void decode(int paramInt)
  {
    recycle(c.getResources().getDimension(paramInt));
  }
  
  Paint.Align draw(Rect paramRect, PointF paramPointF)
  {
    paramPointF.set(0.0F, 0.0F);
    Paint.Align localAlign = Paint.Align.LEFT;
    if (left != null)
    {
      float f1 = height + recycle() + mState;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        x = (left + f1);
        localAlign = Paint.Align.LEFT;
      }
      else
      {
        x = (right - f1);
        localAlign = Paint.Align.RIGHT;
      }
      y = (paramRect.centerY() - drawText());
    }
    return localAlign;
  }
  
  public void draw(float paramFloat)
  {
    if (top != paramFloat)
    {
      top = paramFloat;
      invalidateSelf();
      append();
    }
  }
  
  public void draw(int paramInt)
  {
    draw(c.getResources().getDimension(paramInt));
  }
  
  public void draw(ColorStateList paramColorStateList)
  {
    if (mColors != paramColorStateList)
    {
      mColors = paramColorStateList;
      if (equals()) {
        DrawableCompat.append(this$0, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if (!localRect.isEmpty())
    {
      if (getAlpha() == 0) {
        return;
      }
      int j = 0;
      int m = mAlpha;
      if (m < 255) {
        j = DrawInterface.draw(paramCanvas, left, top, right, bottom, m);
      }
      doDraw(paramCanvas, localRect);
      paint(paramCanvas, localRect);
      if (width) {
        super.draw(paramCanvas);
      }
      drawBackground(paramCanvas, localRect);
      a(paramCanvas, localRect);
      drawShadow(paramCanvas, localRect);
      transform(paramCanvas, localRect);
      if (f) {
        onDraw(paramCanvas, localRect);
      }
      render(paramCanvas, localRect);
      draw(paramCanvas, localRect);
      if (mAlpha < 255) {
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  public void draw(RectF paramRectF)
  {
    setBounds(getBounds(), paramRectF);
  }
  
  public void draw(Drawable paramDrawable)
  {
    Drawable localDrawable = next();
    if (localDrawable != paramDrawable)
    {
      float f1 = recycle();
      if (paramDrawable != null) {
        paramDrawable = DrawableCompat.getDrawable(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      }
      b = paramDrawable;
      float f2 = recycle();
      append(localDrawable);
      if (isRecycled()) {
        update(b);
      }
      invalidateSelf();
      if (f1 != f2) {
        append();
      }
    }
  }
  
  public void draw(TextUtils.TruncateAt paramTruncateAt)
  {
    mPaint = paramTruncateAt;
  }
  
  public void draw(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (!TextUtils.equals(left, (CharSequence)localObject))
    {
      left = ((CharSequence)localObject);
      a.a(true);
      invalidateSelf();
      append();
    }
  }
  
  public void draw(boolean paramBoolean)
  {
    if (mScale != paramBoolean)
    {
      boolean bool = reset();
      mScale = paramBoolean;
      paramBoolean = reset();
      int j;
      if (bool != paramBoolean) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        if (paramBoolean) {
          update(mDrawable);
        } else {
          append(mDrawable);
        }
        invalidateSelf();
        append();
      }
    }
  }
  
  public void encode(int paramInt)
  {
    start(c.getResources().getDimension(paramInt));
  }
  
  public void f(int paramInt)
  {
    reset(c.getResources().getBoolean(paramInt));
  }
  
  public Drawable get()
  {
    Drawable localDrawable = mDrawable;
    if (localDrawable != null) {
      return DrawableCompat.unwrap(localDrawable);
    }
    return null;
  }
  
  public int getAlpha()
  {
    return mAlpha;
  }
  
  public ColorFilter getColorFilter()
  {
    return mColorFilter;
  }
  
  public Attribute getComment()
  {
    return cookieComment;
  }
  
  public float getCornerRadius()
  {
    return dy;
  }
  
  public float getCurrentPosition()
  {
    return state;
  }
  
  public float getData()
  {
    return data;
  }
  
  public boolean getDirectory()
  {
    return dir;
  }
  
  public ColorStateList getError()
  {
    return context;
  }
  
  public float getHeight()
  {
    if (width) {
      return close();
    }
    return y;
  }
  
  public int getIntrinsicHeight()
  {
    return (int)dy;
  }
  
  public int getIntrinsicWidth()
  {
    return Math.min(Math.round(height + recycle() + mState + a.a(a().toString()) + bottom + getSize() + top), mSize);
  }
  
  public ColorStateList getItemId()
  {
    return mId;
  }
  
  public CharSequence getLoopCount()
  {
    return loopCount;
  }
  
  public float getMaxX()
  {
    return right;
  }
  
  public float getMaxY()
  {
    return bottom;
  }
  
  public ColorStateList getNodeName()
  {
    return name;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void getOutline(Outline paramOutline)
  {
    if (width)
    {
      super.getOutline(paramOutline);
      return;
    }
    Rect localRect = getBounds();
    if (!localRect.isEmpty()) {
      paramOutline.setRoundRect(localRect, y);
    } else {
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), y);
    }
    paramOutline.setAlpha(getAlpha() / 255.0F);
  }
  
  public float getPaddingBottom()
  {
    return h;
  }
  
  public TextUtils.TruncateAt getPaint()
  {
    return mPaint;
  }
  
  public ColorStateList getPixel()
  {
    return mColors;
  }
  
  public float getPixels()
  {
    return height;
  }
  
  float getSize()
  {
    if (reset()) {
      return mPosition + right + state;
    }
    return 0.0F;
  }
  
  public void getSize(int paramInt)
  {
    reset(View.a(c, paramInt));
  }
  
  boolean getValue()
  {
    return f;
  }
  
  public ColorStateList i()
  {
    return k;
  }
  
  public void init(int paramInt)
  {
    setCornerRadius(c.getResources().getDimension(paramInt));
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
  }
  
  public boolean isAnimated()
  {
    return mScale;
  }
  
  public float isRunning()
  {
    return mState;
  }
  
  public boolean isStateful()
  {
    return (update(current)) || (update(name)) || (update(context)) || ((key) && (update(w))) || (b(a.a())) || (equals()) || (stop(b)) || (stop(this$0)) || (update(mTint));
  }
  
  public Drawable next()
  {
    Drawable localDrawable = b;
    if (localDrawable != null) {
      return DrawableCompat.unwrap(localDrawable);
    }
    return null;
  }
  
  public float nextFloat()
  {
    return next;
  }
  
  public void onCreate(float paramFloat)
  {
    if (g != paramFloat)
    {
      g = paramFloat;
      p.setStrokeWidth(paramFloat);
      if (width) {
        super.b(paramFloat);
      }
      invalidateSelf();
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (isRecycled()) {
      bool1 = bool2 | DrawableCompat.a(b, paramInt);
    }
    bool2 = bool1;
    if (update()) {
      bool2 = bool1 | DrawableCompat.a(this$0, paramInt);
    }
    bool1 = bool2;
    if (reset()) {
      bool1 = bool2 | DrawableCompat.a(mDrawable, paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    boolean bool2 = super.onLevelChange(paramInt);
    boolean bool1 = bool2;
    if (isRecycled()) {
      bool1 = bool2 | b.setLevel(paramInt);
    }
    bool2 = bool1;
    if (update()) {
      bool2 = bool1 | this$0.setLevel(paramInt);
    }
    bool1 = bool2;
    if (reset()) {
      bool1 = bool2 | mDrawable.setLevel(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public void onPageSelected(int paramInt)
  {
    setVisible(c.getResources().getDimension(paramInt));
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    if (width) {
      super.onStateChange(paramArrayOfInt);
    }
    return reset(paramArrayOfInt, array());
  }
  
  public void parse(int paramInt)
  {
    create(c.getResources().getDimension(paramInt));
  }
  
  public void pause(int paramInt)
  {
    stop(View.a(c, paramInt));
  }
  
  public void put(int paramInt)
  {
    mSize = paramInt;
  }
  
  public void put(Attribute paramAttribute)
  {
    cookieComment = paramAttribute;
  }
  
  float recycle()
  {
    if ((!isRecycled()) && (!update())) {
      return 0.0F;
    }
    return data + execute() + next;
  }
  
  public void recycle(float paramFloat)
  {
    if (next != paramFloat)
    {
      float f1 = recycle();
      next = paramFloat;
      paramFloat = recycle();
      invalidateSelf();
      if (f1 != paramFloat) {
        append();
      }
    }
  }
  
  public void recycle(int paramInt)
  {
    reset(new h(c, paramInt));
  }
  
  public void recycle(boolean paramBoolean)
  {
    if (isRecycled != paramBoolean)
    {
      boolean bool = isRecycled();
      isRecycled = paramBoolean;
      paramBoolean = isRecycled();
      int j;
      if (bool != paramBoolean) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        if (paramBoolean) {
          update(b);
        } else {
          append(b);
        }
        invalidateSelf();
        append();
      }
    }
  }
  
  public Attribute remove()
  {
    return q;
  }
  
  public void reset(float paramFloat)
  {
    if (right != paramFloat)
    {
      right = paramFloat;
      invalidateSelf();
      if (reset()) {
        append();
      }
    }
  }
  
  public void reset(int paramInt)
  {
    startAnimation(View.a(c, paramInt));
  }
  
  public void reset(ColorStateList paramColorStateList)
  {
    i = true;
    if (flags != paramColorStateList)
    {
      flags = paramColorStateList;
      if (isRecycled()) {
        DrawableCompat.append(b, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void reset(Drawable paramDrawable)
  {
    Drawable localDrawable = get();
    if (localDrawable != paramDrawable)
    {
      float f1 = getSize();
      if (paramDrawable != null) {
        paramDrawable = DrawableCompat.getDrawable(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      }
      mDrawable = paramDrawable;
      if (Log.$assertionsDisabled) {
        start();
      }
      float f2 = getSize();
      append(localDrawable);
      if (reset()) {
        update(mDrawable);
      }
      invalidateSelf();
      if (f1 != f2) {
        append();
      }
    }
  }
  
  public void reset(h paramH)
  {
    a.a(paramH, c);
  }
  
  public void reset(boolean paramBoolean)
  {
    if (dir != paramBoolean)
    {
      dir = paramBoolean;
      float f1 = recycle();
      if ((!paramBoolean) && (start)) {
        start = false;
      }
      float f2 = recycle();
      invalidateSelf();
      if (f1 != f2) {
        append();
      }
    }
  }
  
  public boolean reset(int[] paramArrayOfInt)
  {
    if (!Arrays.equals(array, paramArrayOfInt))
    {
      array = paramArrayOfInt;
      if (reset()) {
        return reset(getState(), paramArrayOfInt);
      }
    }
    return false;
  }
  
  public void resolve(int paramInt)
  {
    reset(View.getDrawable(c, paramInt));
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public void seekTo(int paramInt)
  {
    start(View.a(c, paramInt));
  }
  
  public void set(float paramFloat)
  {
    if (dy != paramFloat)
    {
      dy = paramFloat;
      invalidateSelf();
      append();
    }
  }
  
  public float setAlpha()
  {
    return g;
  }
  
  public void setAlpha(int paramInt)
  {
    if (mAlpha != paramInt)
    {
      mAlpha = paramInt;
      invalidateSelf();
    }
  }
  
  public Drawable setColorFilter()
  {
    return this$0;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (mColorFilter != paramColorFilter)
    {
      mColorFilter = paramColorFilter;
      invalidateSelf();
    }
  }
  
  public void setCornerRadius(float paramFloat)
  {
    if (bottom != paramFloat)
    {
      bottom = paramFloat;
      invalidateSelf();
      append();
    }
  }
  
  public void setCornerRadius(int paramInt)
  {
    startAnimation(c.getResources().getDimension(paramInt));
  }
  
  public float setDither()
  {
    return mPosition;
  }
  
  public ColorStateList setLoopCount()
  {
    return flags;
  }
  
  public void setLoopCount(int paramInt)
  {
    draw(View.a(c, paramInt));
  }
  
  public void setSpeed(int paramInt)
  {
    put(Attribute.a(c, paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    if (mTint != paramColorStateList)
    {
      mTint = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (mTintMode != paramMode)
    {
      mTintMode = paramMode;
      mTintFilter = org.org.org.ui.general.GifDrawable.updateTintFilter(this, mTint, paramMode);
      invalidateSelf();
    }
  }
  
  public boolean setValue()
  {
    return key;
  }
  
  public void setVisible()
  {
    append();
    invalidateSelf();
  }
  
  public void setVisible(float paramFloat)
  {
    if (y != paramFloat)
    {
      y = paramFloat;
      setShapeAppearanceModel(c().a(paramFloat));
    }
  }
  
  public void setVisible(int paramInt)
  {
    setVisible(View.a(c, paramInt));
  }
  
  public void setVisible(ColorStateList paramColorStateList)
  {
    if (context != paramColorStateList)
    {
      context = paramColorStateList;
      if (width) {
        a(paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (mVisible != paramBoolean)
    {
      boolean bool = update();
      mVisible = paramBoolean;
      paramBoolean = update();
      int j;
      if (bool != paramBoolean) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        if (paramBoolean) {
          update(this$0);
        } else {
          append(this$0);
        }
        invalidateSelf();
        append();
      }
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (isRecycled()) {
      bool1 = bool2 | b.setVisible(paramBoolean1, paramBoolean2);
    }
    bool2 = bool1;
    if (update()) {
      bool2 = bool1 | this$0.setVisible(paramBoolean1, paramBoolean2);
    }
    bool1 = bool2;
    if (reset()) {
      bool1 = bool2 | mDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  void shutdown(boolean paramBoolean)
  {
    f = paramBoolean;
  }
  
  public void start(float paramFloat)
  {
    if (data != paramFloat)
    {
      float f1 = recycle();
      data = paramFloat;
      paramFloat = recycle();
      invalidateSelf();
      if (f1 != paramFloat) {
        append();
      }
    }
  }
  
  public void start(int paramInt)
  {
    setVisible(c.getResources().getBoolean(paramInt));
  }
  
  public void start(ColorStateList paramColorStateList)
  {
    if (name != paramColorStateList)
    {
      name = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void start(Element paramElement)
  {
    target = new WeakReference(paramElement);
  }
  
  public void start(CharSequence paramCharSequence)
  {
    if (loopCount != paramCharSequence)
    {
      loopCount = BidiFormatter.getInstance().unicodeWrap(paramCharSequence);
      invalidateSelf();
    }
  }
  
  public void start(boolean paramBoolean)
  {
    if (key != paramBoolean)
    {
      key = paramBoolean;
      shutdown();
      onStateChange(getState());
    }
  }
  
  public void startAnimation(float paramFloat)
  {
    if (mPosition != paramFloat)
    {
      mPosition = paramFloat;
      invalidateSelf();
      if (reset()) {
        append();
      }
    }
  }
  
  public void startAnimation(int paramInt)
  {
    startAnimation(View.getDrawable(c, paramInt));
  }
  
  public void startAnimation(ColorStateList paramColorStateList)
  {
    if (mId != paramColorStateList)
    {
      mId = paramColorStateList;
      if (reset()) {
        DrawableCompat.append(mDrawable, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void startAnimation(Drawable paramDrawable)
  {
    if (this$0 != paramDrawable)
    {
      float f1 = recycle();
      this$0 = paramDrawable;
      float f2 = recycle();
      append(this$0);
      update(this$0);
      invalidateSelf();
      if (f1 != f2) {
        append();
      }
    }
  }
  
  public void stop(float paramFloat)
  {
    if (state != paramFloat)
    {
      state = paramFloat;
      invalidateSelf();
      if (reset()) {
        append();
      }
    }
  }
  
  public void stop(int paramInt)
  {
    recycle(c.getResources().getBoolean(paramInt));
  }
  
  public void stop(ColorStateList paramColorStateList)
  {
    if (k != paramColorStateList)
    {
      k = paramColorStateList;
      shutdown();
      onStateChange(getState());
    }
  }
  
  public boolean stop()
  {
    return stop(mDrawable);
  }
  
  public void toString(int paramInt)
  {
    transform(c.getResources().getDimension(paramInt));
  }
  
  public float transform()
  {
    return top;
  }
  
  public void transform(float paramFloat)
  {
    if (h != paramFloat)
    {
      float f1 = recycle();
      h = paramFloat;
      paramFloat = recycle();
      invalidateSelf();
      if (f1 != paramFloat) {
        append();
      }
    }
  }
  
  public void transform(int paramInt)
  {
    draw(View.getDrawable(c, paramInt));
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
  }
  
  public void update(int paramInt)
  {
    stop(c.getResources().getDimension(paramInt));
  }
  
  public void validate(int paramInt)
  {
    close(c.getResources().getDimension(paramInt));
  }
  
  public void write(int paramInt)
  {
    add(Attribute.a(c, paramInt));
  }
}
