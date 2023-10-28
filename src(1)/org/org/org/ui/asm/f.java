package org.org.org.ui.asm;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.DrawableWrapper;
import d.c.a.a.x.g;
import java.util.BitSet;
import org.org.org.ui.adapters.a;

public class f
  extends Drawable
  implements DrawableWrapper, GeoPoint
{
  private static final Paint p = new Paint(1);
  private static final String t = g.class.getSimpleName();
  private final RectF B = new RectF();
  private final org.org.org.ui.widget.ClassWriter a;
  private d b;
  private final Path c = new Path();
  private final k d;
  private PorterDuffColorFilter e;
  private final Paint f;
  private final Paint g;
  private boolean h;
  private final c[] j = new c[4];
  private final BitSet k = new BitSet(8);
  private final Matrix m = new Matrix();
  private final c[] n = new c[4];
  private final l o;
  private m q;
  private final RectF r;
  private boolean s;
  private final Region u = new Region();
  private final RectF v = new RectF();
  private final Region w = new Region();
  private PorterDuffColorFilter x;
  private final Path y = new Path();
  
  public f()
  {
    this(new m());
  }
  
  public f(android.content.Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(m.a(paramContext, paramAttributeSet, paramInt1, paramInt2).a());
  }
  
  private f(d paramD)
  {
    Paint localPaint1 = new Paint(1);
    g = localPaint1;
    Paint localPaint2 = new Paint(1);
    f = localPaint2;
    a = new org.org.org.ui.widget.ClassWriter();
    l localL;
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      localL = l.access$getDecoder();
    } else {
      localL = new l();
    }
    o = localL;
    r = new RectF();
    s = true;
    b = paramD;
    localPaint2.setStyle(Paint.Style.STROKE);
    localPaint1.setStyle(Paint.Style.FILL);
    paramD = p;
    paramD.setColor(-1);
    paramD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    b();
    a(getState());
    d = new e(this);
  }
  
  public f(m paramM)
  {
    this(new d(paramM, null));
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 * (paramInt2 + (paramInt2 >>> 7)) >>> 8;
  }
  
  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, Paint paramPaint, boolean paramBoolean)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return updateTintFilter(paramColorStateList, paramMode, paramBoolean);
    }
    return a(paramPaint, paramBoolean);
  }
  
  private PorterDuffColorFilter a(Paint paramPaint, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = paramPaint.getColor();
      int i1 = d(i);
      if (i1 != i) {
        return new PorterDuffColorFilter(i1, PorterDuff.Mode.SRC_IN);
      }
    }
    return null;
  }
  
  public static f a(android.content.Context paramContext, float paramFloat)
  {
    int i = org.org.org.ui.keys.ClassWriter.b(paramContext, org.org.org.ui.ClassWriter.a, g.class.getSimpleName());
    f localF = new f();
    localF.d(paramContext);
    localF.setColor(ColorStateList.valueOf(i));
    localF.add(paramFloat);
    return localF;
  }
  
  private void a()
  {
    float f1 = e();
    b.z = ((int)Math.ceil(0.75F * f1));
    b.v = ((int)Math.ceil(f1 * 0.25F));
    b();
    setColor();
  }
  
  private void a(Canvas paramCanvas)
  {
    if (k.cardinality() > 0) {
      Log.w(t, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
    }
    if (b.v != 0) {
      paramCanvas.drawPath(c, a.newUTF8());
    }
    int i = 0;
    while (i < 4)
    {
      j[i].a(a, b.z, paramCanvas);
      n[i].a(a, b.z, paramCanvas);
      i += 1;
    }
    if (s)
    {
      i = size();
      int i1 = clear();
      paramCanvas.translate(-i, -i1);
      paramCanvas.drawPath(c, p);
      paramCanvas.translate(i, i1);
    }
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, Path paramPath, m paramM, RectF paramRectF)
  {
    if (paramM.a(paramRectF))
    {
      float f1 = paramM.e().a(paramRectF) * b.y;
      paramCanvas.drawRoundRect(paramRectF, f1, f1, paramPaint);
      return;
    }
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private boolean a(int[] paramArrayOfInt)
  {
    int i;
    int i1;
    if (b.g != null)
    {
      i = g.getColor();
      i1 = b.g.getColorForState(paramArrayOfInt, i);
      if (i != i1)
      {
        g.setColor(i1);
        bool = true;
        break label53;
      }
    }
    boolean bool = false;
    label53:
    if (b.f != null)
    {
      i = f.getColor();
      i1 = b.f.getColorForState(paramArrayOfInt, i);
      if (i != i1)
      {
        f.setColor(i1);
        return true;
      }
    }
    return bool;
  }
  
  private void add(Canvas paramCanvas)
  {
    a(paramCanvas, g, c, b.a, add());
  }
  
  private void add(RectF paramRectF, Path paramPath)
  {
    a(paramRectF, paramPath);
    if (b.l != 1.0F)
    {
      m.reset();
      Matrix localMatrix = m;
      float f1 = b.l;
      localMatrix.setScale(f1, f1, paramRectF.width() / 2.0F, paramRectF.height() / 2.0F);
      paramPath.transform(m);
    }
    paramPath.computeBounds(r, true);
  }
  
  private void b(Canvas paramCanvas)
  {
    int i = size();
    int i1 = clear();
    if ((Build.VERSION.SDK_INT < 21) && (s))
    {
      Rect localRect = paramCanvas.getClipBounds();
      int i2 = b.z;
      localRect.inset(-i2, -i2);
      localRect.offset(i, i1);
      paramCanvas.clipRect(localRect, Region.Op.REPLACE);
    }
    paramCanvas.translate(i, i1);
  }
  
  private boolean b()
  {
    PorterDuffColorFilter localPorterDuffColorFilter1 = e;
    PorterDuffColorFilter localPorterDuffColorFilter2 = x;
    d localD = b;
    e = a(s, c, g, true);
    localD = b;
    x = a(m, c, f, false);
    localD = b;
    if (h) {
      a.a(s.getColorForState(getState(), 0));
    }
    if (v7.v7.util.Context.equals(localPorterDuffColorFilter1, e)) {
      return !v7.v7.util.Context.equals(localPorterDuffColorFilter2, x);
    }
    return true;
  }
  
  private void d()
  {
    float f1 = -getValue();
    m localM = c().a(new Attribute(this, f1));
    q = localM;
    o.a(localM, b.y, inflate(), y);
  }
  
  private void d(Canvas paramCanvas)
  {
    a(paramCanvas, f, y, q, inflate());
  }
  
  private boolean draw()
  {
    Paint.Style localStyle = b.k;
    return ((localStyle == Paint.Style.FILL_AND_STROKE) || (localStyle == Paint.Style.STROKE)) && (f.getStrokeWidth() > 0.0F);
  }
  
  private void drawBackground(Canvas paramCanvas)
  {
    if (!m()) {
      return;
    }
    paramCanvas.save();
    b(paramCanvas);
    if (!s)
    {
      a(paramCanvas);
      paramCanvas.restore();
      return;
    }
    int i = (int)(r.width() - getBounds().width());
    int i1 = (int)(r.height() - getBounds().height());
    if ((i >= 0) && (i1 >= 0))
    {
      Bitmap localBitmap = Bitmap.createBitmap((int)r.width() + b.z * 2 + i, (int)r.height() + b.z * 2 + i1, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      float f1 = getBoundsleft - b.z - i;
      float f2 = getBoundstop - b.z - i1;
      localCanvas.translate(-f1, -f2);
      a(localCanvas);
      paramCanvas.drawBitmap(localBitmap, f1, f2, null);
      localBitmap.recycle();
      paramCanvas.restore();
      return;
    }
    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
  }
  
  private float getValue()
  {
    if (draw()) {
      return f.getStrokeWidth() / 2.0F;
    }
    return 0.0F;
  }
  
  private RectF inflate()
  {
    B.set(add());
    float f1 = getValue();
    B.inset(f1, f1);
    return B;
  }
  
  private boolean isEnabled()
  {
    Paint.Style localStyle = b.k;
    return (localStyle == Paint.Style.FILL_AND_STROKE) || (localStyle == Paint.Style.FILL);
  }
  
  private boolean m()
  {
    d localD = b;
    int i = q;
    if ((i != 1) && (z > 0))
    {
      if (i == 2) {
        break label38;
      }
      if (l()) {
        return true;
      }
    }
    return false;
    label38:
    return true;
  }
  
  private void setColor()
  {
    super.invalidateSelf();
  }
  
  private PorterDuffColorFilter updateTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, boolean paramBoolean)
  {
    int i1 = paramColorStateList.getColorForState(getState(), 0);
    int i = i1;
    if (paramBoolean) {
      i = d(i1);
    }
    return new PorterDuffColorFilter(i, paramMode);
  }
  
  public void a(float paramFloat)
  {
    d localD = b;
    if (y != paramFloat)
    {
      y = paramFloat;
      h = true;
      invalidateSelf();
    }
  }
  
  public void a(float paramFloat, int paramInt)
  {
    b(paramFloat);
    a(ColorStateList.valueOf(paramInt));
  }
  
  public void a(float paramFloat, ColorStateList paramColorStateList)
  {
    b(paramFloat);
    a(paramColorStateList);
  }
  
  public void a(int paramInt)
  {
    d localD = b;
    if (w != paramInt)
    {
      w = paramInt;
      setColor();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    d localD = b;
    if (p == null) {
      p = new Rect();
    }
    b.p.set(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidateSelf();
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    d localD = b;
    if (f != paramColorStateList)
    {
      f = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  protected void a(Canvas paramCanvas, Paint paramPaint, Path paramPath, RectF paramRectF)
  {
    a(paramCanvas, paramPaint, paramPath, b.a, paramRectF);
  }
  
  protected final void a(RectF paramRectF, Path paramPath)
  {
    l localL = o;
    d localD = b;
    localL.a(a, y, paramRectF, d, paramPath);
  }
  
  protected RectF add()
  {
    v.set(getBounds());
    return v;
  }
  
  public void add(float paramFloat)
  {
    d localD = b;
    if (value != paramFloat)
    {
      value = paramFloat;
      a();
    }
  }
  
  public float addSubMenu()
  {
    return b.a.f().a(add());
  }
  
  public void b(float paramFloat)
  {
    b.i = paramFloat;
    invalidateSelf();
  }
  
  public void b(int paramInt)
  {
    a.a(paramInt);
    b.h = false;
    setColor();
  }
  
  public m c()
  {
    return b.a;
  }
  
  public void c(float paramFloat)
  {
    setShapeAppearanceModel(b.a.a(paramFloat));
  }
  
  public int clear()
  {
    d localD = b;
    return (int)(v * Math.cos(Math.toRadians(w)));
  }
  
  public float close()
  {
    return b.a.c().a(add());
  }
  
  protected int d(int paramInt)
  {
    float f1 = e();
    float f2 = g();
    a localA = b.j;
    int i = paramInt;
    if (localA != null) {
      i = localA.b(paramInt, f1 + f2);
    }
    return i;
  }
  
  public void d(float paramFloat)
  {
    d localD = b;
    if (n != paramFloat)
    {
      n = paramFloat;
      a();
    }
  }
  
  public void d(android.content.Context paramContext)
  {
    b.j = new a(paramContext);
    a();
  }
  
  public void draw(Canvas paramCanvas)
  {
    g.setColorFilter(e);
    int i = g.getAlpha();
    g.setAlpha(a(i, b.b));
    f.setColorFilter(x);
    f.setStrokeWidth(b.i);
    int i1 = f.getAlpha();
    f.setAlpha(a(i1, b.b));
    if (h)
    {
      d();
      add(add(), c);
      h = false;
    }
    drawBackground(paramCanvas);
    if (isEnabled()) {
      add(paramCanvas);
    }
    if (draw()) {
      d(paramCanvas);
    }
    g.setAlpha(i);
    f.setAlpha(i1);
  }
  
  public float e()
  {
    return put() + h();
  }
  
  public void e(Context paramContext)
  {
    setShapeAppearanceModel(b.a.a(paramContext));
  }
  
  public int f()
  {
    return b.z;
  }
  
  public float findItem()
  {
    return b.a.k().a(add());
  }
  
  public float g()
  {
    return b.n;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return b;
  }
  
  public ColorStateList getIntent()
  {
    return b.g;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void getOutline(Outline paramOutline)
  {
    if (b.q == 2) {
      return;
    }
    if (k())
    {
      float f1 = close();
      float f2 = b.y;
      paramOutline.setRoundRect(getBounds(), f1 * f2);
      return;
    }
    add(add(), c);
    if ((c.isConvex()) || (Build.VERSION.SDK_INT >= 29))
    {
      Path localPath = c;
      try
      {
        paramOutline.setConvexPath(localPath);
        return;
      }
      catch (IllegalArgumentException paramOutline) {}
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Rect localRect = b.p;
    if (localRect != null)
    {
      paramRect.set(localRect);
      return true;
    }
    return super.getPadding(paramRect);
  }
  
  public Region getTransparentRegion()
  {
    Rect localRect = getBounds();
    w.set(localRect);
    add(add(), c);
    u.setPath(c, w);
    w.op(u, Region.Op.DIFFERENCE);
    return w;
  }
  
  public float h()
  {
    return b.x;
  }
  
  public void invalidateSelf()
  {
    h = true;
    super.invalidateSelf();
  }
  
  public boolean isStateful()
  {
    if (!super.isStateful())
    {
      ColorStateList localColorStateList = b.s;
      if ((localColorStateList == null) || (!localColorStateList.isStateful()))
      {
        localColorStateList = b.m;
        if ((localColorStateList == null) || (!localColorStateList.isStateful()))
        {
          localColorStateList = b.f;
          if ((localColorStateList == null) || (!localColorStateList.isStateful()))
          {
            localColorStateList = b.g;
            if ((localColorStateList == null) || (!localColorStateList.isStateful())) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
  
  public boolean k()
  {
    return b.a.a(add());
  }
  
  public boolean l()
  {
    int i = Build.VERSION.SDK_INT;
    return (i < 21) || ((!k()) && (!c.isConvex()) && (i < 29));
  }
  
  public Drawable mutate()
  {
    b = new d(b);
    return this;
  }
  
  public boolean o()
  {
    a localA = b.j;
    return (localA != null) && (localA.a());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    h = true;
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = a(paramArrayOfInt);
    boolean bool2 = b();
    if ((!bool1) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public ColorStateList performShortcut()
  {
    return b.s;
  }
  
  public float put()
  {
    return b.value;
  }
  
  public float removeItem()
  {
    return b.a.e().a(add());
  }
  
  public void setAlpha(int paramInt)
  {
    d localD = b;
    if (b != paramInt)
    {
      b = paramInt;
      setColor();
    }
  }
  
  public void setColor(ColorStateList paramColorStateList)
  {
    d localD = b;
    if (g != paramColorStateList)
    {
      g = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    b.e = paramColorFilter;
    setColor();
  }
  
  public void setShapeAppearanceModel(m paramM)
  {
    b.a = paramM;
    invalidateSelf();
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    b.s = paramColorStateList;
    b();
    setColor();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    d localD = b;
    if (c != paramMode)
    {
      c = paramMode;
      b();
      setColor();
    }
  }
  
  public int size()
  {
    d localD = b;
    return (int)(v * Math.sin(Math.toRadians(w)));
  }
}
