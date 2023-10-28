package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import v7.v7.package_13.ViewCompat;

public class ChangeBounds
  extends Transition
{
  private static final Property<k, PointF> B;
  private static final Property<Drawable, PointF> P;
  private static final Property<View, PointF> S = new f(PointF.class, "topLeft");
  private static final Property<View, PointF> U = new g(PointF.class, "position");
  private static IntEvaluator V = new IntEvaluator();
  private static final String[] W = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  private static final Property<View, PointF> X;
  private static final Property<k, PointF> s;
  private int[] a = new int[2];
  private boolean b = false;
  private boolean f = false;
  
  static
  {
    P = new b(PointF.class, "boundsOrigin");
    s = new c(PointF.class, "topLeft");
    B = new d(PointF.class, "bottomRight");
    X = new e(PointF.class, "bottomRight");
  }
  
  public ChangeBounds() {}
  
  private void a(Label paramLabel)
  {
    View localView = a;
    if ((ViewCompat.set(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      m.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      m.put("android:changeBounds:parent", a.getParent());
      if (f)
      {
        a.getLocationInWindow(a);
        m.put("android:changeBounds:windowX", Integer.valueOf(a[0]));
        m.put("android:changeBounds:windowY", Integer.valueOf(a[1]));
      }
      if (b) {
        m.put("android:changeBounds:clip", ViewCompat.obtain(localView));
      }
    }
  }
  
  private boolean c(View paramView1, View paramView2)
  {
    if (f)
    {
      Label localLabel = a(paramView1, true);
      if (localLabel == null) {
        if (paramView1 == paramView2) {
          return true;
        }
      }
      while (paramView2 != a) {
        return false;
      }
    }
    return true;
  }
  
  public Animator a(final ViewGroup paramViewGroup, final Label paramLabel1, Label paramLabel2)
  {
    if ((paramLabel1 != null) && (paramLabel2 != null))
    {
      Object localObject2 = m;
      Object localObject1 = m;
      localObject2 = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
      Object localObject3 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
      if ((localObject2 != null) && (localObject3 != null))
      {
        localObject1 = a;
        int k;
        final int m;
        int j;
        int i;
        if (c((View)localObject2, (View)localObject3))
        {
          paramViewGroup = (Rect)m.get("android:changeBounds:bounds");
          localObject2 = (Rect)m.get("android:changeBounds:bounds");
          k = left;
          m = left;
          int n = top;
          final int i1 = top;
          int i2 = right;
          final int i3 = right;
          int i4 = bottom;
          final int i5 = bottom;
          int i6 = i2 - k;
          int i7 = i4 - n;
          int i8 = i3 - m;
          int i9 = i5 - i1;
          localObject3 = (Rect)m.get("android:changeBounds:clip");
          localObject2 = (Rect)m.get("android:changeBounds:clip");
          if (((i6 != 0) && (i7 != 0)) || ((i8 != 0) && (i9 != 0)))
          {
            if ((k == m) && (n == i1)) {
              j = 0;
            } else {
              j = 1;
            }
            if (i2 == i3)
            {
              i = j;
              if (i4 == i5) {}
            }
            else
            {
              i = j + 1;
            }
          }
          else
          {
            i = 0;
          }
          if ((localObject3 == null) || (((Rect)localObject3).equals(localObject2)))
          {
            j = i;
            if (localObject3 == null)
            {
              j = i;
              if (localObject2 == null) {}
            }
          }
          else
          {
            j = i + 1;
          }
          if (j > 0)
          {
            if (!b)
            {
              Item.set((View)localObject1, k, n, i2, i4);
              if (j == 2)
              {
                if ((i6 == i8) && (i7 == i9))
                {
                  paramViewGroup = getTarget().getMarkPath(k, n, m, i1);
                  paramViewGroup = SignatureReader.a(localObject1, U, paramViewGroup);
                }
                else
                {
                  paramLabel1 = new k((View)localObject1);
                  paramViewGroup = getTarget().getMarkPath(k, n, m, i1);
                  paramLabel2 = SignatureReader.a(paramLabel1, s, paramViewGroup);
                  paramViewGroup = getTarget().getMarkPath(i2, i4, i3, i5);
                  localObject2 = SignatureReader.a(paramLabel1, B, paramViewGroup);
                  paramViewGroup = new AnimatorSet();
                  paramViewGroup.playTogether(new Animator[] { paramLabel2, localObject2 });
                  paramViewGroup.addListener(new h(paramLabel1));
                }
              }
              else if ((k == m) && (n == i1))
              {
                paramViewGroup = getTarget().getMarkPath(i2, i4, i3, i5);
                paramViewGroup = SignatureReader.a(localObject1, X, paramViewGroup);
              }
              else
              {
                paramViewGroup = getTarget().getMarkPath(k, n, m, i1);
                paramViewGroup = SignatureReader.a(localObject1, S, paramViewGroup);
              }
            }
            else
            {
              Item.set((View)localObject1, k, n, Math.max(i6, i8) + k, Math.max(i7, i9) + n);
              if ((k == m) && (n == i1))
              {
                paramViewGroup = null;
              }
              else
              {
                paramViewGroup = getTarget().getMarkPath(k, n, m, i1);
                paramViewGroup = SignatureReader.a(localObject1, U, paramViewGroup);
              }
              paramLabel1 = (Label)localObject3;
              if (localObject3 == null) {
                paramLabel1 = new Rect(0, 0, i6, i7);
              }
              if (localObject2 == null) {
                paramLabel2 = new Rect(0, 0, i8, i9);
              } else {
                paramLabel2 = (Label)localObject2;
              }
              if (!paramLabel1.equals(paramLabel2))
              {
                ViewCompat.setElevation((View)localObject1, paramLabel1);
                paramLabel1 = ObjectAnimator.ofObject(localObject1, "clipBounds", V, new Object[] { paramLabel1, paramLabel2 });
                paramLabel1.addListener(new i((View)localObject1, (Rect)localObject2, m, i1, i3, i5));
              }
              else
              {
                paramLabel1 = null;
              }
              paramViewGroup = l.a(paramViewGroup, paramLabel1);
            }
            if (!(((View)localObject1).getParent() instanceof ViewGroup)) {
              return paramViewGroup;
            }
            paramLabel1 = (ViewGroup)((View)localObject1).getParent();
            XYPlot.a(paramLabel1, true);
            next(new j(paramLabel1));
            return paramViewGroup;
          }
        }
        else
        {
          i = ((Integer)m.get("android:changeBounds:windowX")).intValue();
          j = ((Integer)m.get("android:changeBounds:windowY")).intValue();
          k = ((Integer)m.get("android:changeBounds:windowX")).intValue();
          m = ((Integer)m.get("android:changeBounds:windowY")).intValue();
          if ((i != k) || (j != m)) {
            break label949;
          }
        }
        return null;
        label949:
        paramViewGroup.getLocationInWindow(a);
        paramLabel1 = Bitmap.createBitmap(((View)localObject1).getWidth(), ((View)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        ((View)localObject1).draw(new Canvas(paramLabel1));
        paramLabel1 = new BitmapDrawable(paramLabel1);
        final float f1 = Item.d((View)localObject1);
        Item.set((View)localObject1, 0.0F);
        Item.a(paramViewGroup).a(paramLabel1);
        paramLabel2 = getTarget();
        localObject2 = a;
        paramLabel2 = paramLabel2.getMarkPath(i - localObject2[0], j - localObject2[1], k - localObject2[0], m - localObject2[1]);
        paramLabel2 = ObjectAnimator.ofPropertyValuesHolder(paramLabel1, new PropertyValuesHolder[] { y.ofFloat(P, paramLabel2) });
        paramLabel2.addListener(new a(paramViewGroup, paramLabel1, (View)localObject1, f1));
        return paramLabel2;
      }
    }
    return null;
    return paramViewGroup;
  }
  
  public void draw(Label paramLabel)
  {
    a(paramLabel);
  }
  
  public String[] valueOf()
  {
    return W;
  }
  
  public void write(Label paramLabel)
  {
    a(paramLabel);
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a(ViewGroup paramViewGroup, BitmapDrawable paramBitmapDrawable, View paramView, float paramFloat) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      Item.a(paramViewGroup).b(paramLabel1);
      Item.set(c, f1);
    }
  }
  
  static final class b
    extends Property<Drawable, PointF>
  {
    private Rect mRect = new Rect();
    
    b(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public PointF draw(Drawable paramDrawable)
    {
      paramDrawable.copyBounds(mRect);
      paramDrawable = mRect;
      return new PointF(left, top);
    }
    
    public void draw(Drawable paramDrawable, PointF paramPointF)
    {
      paramDrawable.copyBounds(mRect);
      mRect.offsetTo(Math.round(x), Math.round(y));
      paramDrawable.setBounds(mRect);
    }
  }
  
  static final class c
    extends Property<ChangeBounds.k, PointF>
  {
    c(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public void a(ChangeBounds.k paramK, PointF paramPointF)
    {
      paramK.b(paramPointF);
    }
    
    public PointF getPrevious(ChangeBounds.k paramK)
    {
      return null;
    }
  }
  
  static final class d
    extends Property<ChangeBounds.k, PointF>
  {
    d(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public void drawBitmap(ChangeBounds.k paramK, PointF paramPointF)
    {
      paramK.a(paramPointF);
    }
    
    public PointF getPrevious(ChangeBounds.k paramK)
    {
      return null;
    }
  }
  
  static final class e
    extends Property<View, PointF>
  {
    e(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public void a(View paramView, PointF paramPointF)
    {
      Item.set(paramView, paramView.getLeft(), paramView.getTop(), Math.round(x), Math.round(y));
    }
    
    public PointF getPrevious(View paramView)
    {
      return null;
    }
  }
  
  static final class f
    extends Property<View, PointF>
  {
    f(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public void a(View paramView, PointF paramPointF)
    {
      Item.set(paramView, Math.round(x), Math.round(y), paramView.getRight(), paramView.getBottom());
    }
    
    public PointF getPrevious(View paramView)
    {
      return null;
    }
  }
  
  static final class g
    extends Property<View, PointF>
  {
    g(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public void a(View paramView, PointF paramPointF)
    {
      int i = Math.round(x);
      int j = Math.round(y);
      Item.set(paramView, i, j, paramView.getWidth() + i, paramView.getHeight() + j);
    }
    
    public PointF getPrevious(View paramView)
    {
      return null;
    }
  }
  
  class h
    extends AnimatorListenerAdapter
  {
    private ChangeBounds.k mViewBounds;
    
    h(ChangeBounds.k paramK)
    {
      mViewBounds = paramK;
    }
  }
  
  class i
    extends AnimatorListenerAdapter
  {
    private boolean mCancelled;
    
    i(View paramView, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      mCancelled = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!mCancelled)
      {
        ViewCompat.setElevation(val$dummyView, this$2);
        Item.set(val$dummyView, m, i1, i3, i5);
      }
    }
  }
  
  class j
    extends ActionMenuItemView
  {
    boolean d = false;
    
    j(ViewGroup paramViewGroup) {}
    
    public void b(Transition paramTransition)
    {
      XYPlot.a(paramLabel1, true);
    }
    
    public void c(Transition paramTransition)
    {
      if (!d) {
        XYPlot.a(paramLabel1, false);
      }
      paramTransition.recycle(this);
    }
    
    public void d(Transition paramTransition)
    {
      XYPlot.a(paramLabel1, false);
      d = true;
    }
    
    public void e(Transition paramTransition)
    {
      XYPlot.a(paramLabel1, false);
    }
  }
  
  private static class k
  {
    private int h;
    private View i;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    
    k(View paramView)
    {
      i = paramView;
    }
    
    private void b()
    {
      Item.set(i, x, w, h, y);
      u = 0;
      v = 0;
    }
    
    void a(PointF paramPointF)
    {
      h = Math.round(x);
      y = Math.round(y);
      int j = v + 1;
      v = j;
      if (u == j) {
        b();
      }
    }
    
    void b(PointF paramPointF)
    {
      x = Math.round(x);
      w = Math.round(y);
      int j = u + 1;
      u = j;
      if (j == v) {
        b();
      }
    }
  }
}
