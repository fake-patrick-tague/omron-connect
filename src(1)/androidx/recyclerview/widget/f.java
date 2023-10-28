package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import v7.v7.package_13.ViewCompat;

class f
  extends RecyclerView.n
  implements RecyclerView.r
{
  private static final int[] d = new int[0];
  private static final int[] o = { 16842919 };
  private RecyclerView a;
  private int b = 0;
  private final int[] c = new int[2];
  private boolean e = false;
  int f;
  int g;
  final Drawable h;
  final StateListDrawable i;
  private final Drawable icon;
  int k;
  int l;
  private final int[] m = new int[2];
  final ValueAnimator mAnimator;
  private final Runnable mCallback;
  private final RecyclerView.s mContext;
  int mode;
  private int n = 0;
  private int p = 0;
  private final StateListDrawable paint;
  private final int q;
  private final int r;
  private boolean s = false;
  private final int t;
  private final int u;
  private final int v;
  float w;
  private int x = 0;
  float y;
  private final int z;
  
  f(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    mAnimator = localValueAnimator;
    mode = 0;
    mCallback = new MonthByWeekFragment.2(this);
    mContext = new ae(this);
    i = paramStateListDrawable1;
    h = paramDrawable1;
    paint = paramStateListDrawable2;
    icon = paramDrawable2;
    v = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    u = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    t = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    r = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    q = paramInt2;
    z = paramInt3;
    paramStateListDrawable1.setAlpha(255);
    paramDrawable1.setAlpha(255);
    localValueAnimator.addListener(new ScrollingTabContainerView.VisibilityAnimListener(this));
    localValueAnimator.addUpdateListener(new ViewPropertyAnimatorPreHC.AnimatorEventListener(this));
    a(paramRecyclerView);
  }
  
  private void a(float paramFloat)
  {
    int[] arrayOfInt = d();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(f - paramFloat) < 2.0F) {
      return;
    }
    int j = add(w, paramFloat, arrayOfInt, a.computeVerticalScrollRange(), a.computeVerticalScrollOffset(), n);
    if (j != 0) {
      a.scrollBy(0, j);
    }
    w = paramFloat;
  }
  
  private void a(Canvas paramCanvas)
  {
    int i1 = x;
    int j = v;
    i1 -= j;
    int i3 = f;
    int i2 = k;
    i3 -= i2 / 2;
    i.setBounds(0, 0, j, i2);
    h.setBounds(0, 0, u, n);
    if (a())
    {
      h.draw(paramCanvas);
      paramCanvas.translate(v, i3);
      paramCanvas.scale(-1.0F, 1.0F);
      i.draw(paramCanvas);
      paramCanvas.scale(-1.0F, 1.0F);
      paramCanvas.translate(-v, -i3);
      return;
    }
    paramCanvas.translate(i1, 0.0F);
    h.draw(paramCanvas);
    paramCanvas.translate(0.0F, i3);
    i.draw(paramCanvas);
    paramCanvas.translate(-i1, -i3);
  }
  
  private boolean a()
  {
    return ViewCompat.getLayoutDirection(a) == 1;
  }
  
  private int add(float paramFloat1, float paramFloat2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramArrayOfInt[1] - paramArrayOfInt[0];
    if (j == 0) {
      return 0;
    }
    paramFloat1 = (paramFloat2 - paramFloat1) / j;
    paramInt1 -= paramInt3;
    paramInt3 = (int)(paramFloat1 * paramInt1);
    paramInt2 += paramInt3;
    if ((paramInt2 < paramInt1) && (paramInt2 >= 0)) {
      return paramInt3;
    }
    return 0;
  }
  
  private void add(float paramFloat)
  {
    int[] arrayOfInt = add();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(g - paramFloat) < 2.0F) {
      return;
    }
    int j = add(y, paramFloat, arrayOfInt, a.computeHorizontalScrollRange(), a.computeHorizontalScrollOffset(), x);
    if (j != 0) {
      a.scrollBy(j, 0);
    }
    y = paramFloat;
  }
  
  private void add(int paramInt)
  {
    clear();
    a.postDelayed(mCallback, paramInt);
  }
  
  private int[] add()
  {
    int[] arrayOfInt = c;
    int j = z;
    arrayOfInt[0] = j;
    arrayOfInt[1] = (x - j);
    return arrayOfInt;
  }
  
  private void clear()
  {
    a.removeCallbacks(mCallback);
  }
  
  private int[] d()
  {
    int[] arrayOfInt = m;
    int j = z;
    arrayOfInt[0] = j;
    arrayOfInt[1] = (n - j);
    return arrayOfInt;
  }
  
  private void onConfigurationChanged()
  {
    a.removeItemDecoration(this);
    a.removeOnItemTouchListener(this);
    a.a(mContext);
    clear();
  }
  
  private void onCreate()
  {
    a.addItemDecoration(this);
    a.addOnItemTouchListener(this);
    a.setAdapter(mContext);
  }
  
  private void onDraw(Canvas paramCanvas)
  {
    int i1 = n;
    int j = t;
    i1 -= j;
    int i3 = g;
    int i2 = l;
    i3 -= i2 / 2;
    paint.setBounds(0, 0, i2, j);
    icon.setBounds(0, 0, x, r);
    paramCanvas.translate(0.0F, i1);
    icon.draw(paramCanvas);
    paramCanvas.translate(i3, 0.0F);
    paint.draw(paramCanvas);
    paramCanvas.translate(-i3, -i1);
  }
  
  void a(int paramInt)
  {
    if ((paramInt == 2) && (b != 2))
    {
      i.setState(o);
      clear();
    }
    if (paramInt == 0) {
      close();
    } else {
      animate();
    }
    if ((b == 2) && (paramInt != 2))
    {
      i.setState(d);
      add(1200);
    }
    else if (paramInt == 1)
    {
      add(1500);
    }
    b = paramInt;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    int j = a.computeVerticalScrollRange();
    int i1 = n;
    boolean bool1;
    if ((j - i1 > 0) && (i1 >= q)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    s = bool1;
    int i2 = a.computeHorizontalScrollRange();
    int i3 = x;
    if ((i2 - i3 > 0) && (i3 >= q)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    e = bool1;
    boolean bool2 = s;
    if ((!bool2) && (!bool1))
    {
      if (b != 0) {
        a(0);
      }
    }
    else
    {
      float f1;
      float f2;
      if (bool2)
      {
        f1 = paramInt2;
        f2 = i1;
        f = ((int)(f2 * (f1 + f2 / 2.0F) / j));
        k = Math.min(i1, i1 * i1 / j);
      }
      if (e)
      {
        f1 = paramInt1;
        f2 = i3;
        g = ((int)(f2 * (f1 + f2 / 2.0F) / i2));
        l = Math.min(i3, i3 * i3 / i2);
      }
      paramInt1 = b;
      if ((paramInt1 == 0) || (paramInt1 == 1)) {
        a(1);
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    RecyclerView localRecyclerView = a;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      onConfigurationChanged();
    }
    a = paramRecyclerView;
    if (paramRecyclerView != null) {
      onCreate();
    }
  }
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    if (a() ? paramFloat1 <= v : paramFloat1 >= x - v)
    {
      int j = f;
      int i1 = k;
      if ((paramFloat2 >= j - i1 / 2) && (paramFloat2 <= j + i1 / 2)) {
        return true;
      }
    }
    return false;
  }
  
  boolean add(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 >= n - t)
    {
      int j = g;
      int i1 = l;
      if ((paramFloat1 >= j - i1 / 2) && (paramFloat1 <= j + i1 / 2)) {
        return true;
      }
    }
    return false;
  }
  
  public void animate()
  {
    int j = mode;
    if (j != 0)
    {
      if (j != 3) {
        return;
      }
      mAnimator.cancel();
    }
    mode = 1;
    ValueAnimator localValueAnimator = mAnimator;
    localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 1.0F });
    mAnimator.setDuration(500L);
    mAnimator.setStartDelay(0L);
    mAnimator.start();
  }
  
  void animate(int paramInt)
  {
    int j = mode;
    if (j != 1)
    {
      if (j == 2) {}
    }
    else {
      mAnimator.cancel();
    }
    mode = 3;
    ValueAnimator localValueAnimator = mAnimator;
    localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 0.0F });
    mAnimator.setDuration(paramInt);
    mAnimator.start();
  }
  
  void close()
  {
    a.invalidate();
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.y paramY)
  {
    if ((x == a.getWidth()) && (n == a.getHeight()))
    {
      if (mode != 0)
      {
        if (s) {
          a(paramCanvas);
        }
        if (e) {
          onDraw(paramCanvas);
        }
      }
    }
    else
    {
      x = a.getWidth();
      n = a.getHeight();
      a(0);
    }
  }
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int j = b;
    if (j == 1)
    {
      boolean bool1 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool2 = add(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((paramMotionEvent.getAction() != 0) || ((!bool1) && (!bool2))) {
        break label113;
      }
      if (bool2)
      {
        p = 1;
        y = ((int)paramMotionEvent.getX());
      }
      else if (bool1)
      {
        p = 2;
        w = ((int)paramMotionEvent.getY());
      }
      a(2);
    }
    else
    {
      if (j != 2) {
        break label113;
      }
    }
    return true;
    label113:
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (b == 0) {
      return;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      boolean bool1 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool2 = add(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((bool1) || (bool2))
      {
        if (bool2)
        {
          p = 1;
          y = ((int)paramMotionEvent.getX());
        }
        else if (bool1)
        {
          p = 2;
          w = ((int)paramMotionEvent.getY());
        }
        a(2);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 1) && (b == 2))
      {
        w = 0.0F;
        y = 0.0F;
        a(1);
        p = 0;
        return;
      }
      if ((paramMotionEvent.getAction() == 2) && (b == 2))
      {
        animate();
        if (p == 1) {
          add(paramMotionEvent.getX());
        }
        if (p == 2) {
          a(paramMotionEvent.getY());
        }
      }
    }
  }
}
