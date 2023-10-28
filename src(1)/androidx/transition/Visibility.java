package androidx.transition;

import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public abstract class Visibility
  extends Transition
{
  private static final String[] CANCELED = { "android:visibility:visibility", "android:visibility:parent" };
  private int c = 3;
  
  public Visibility() {}
  
  private c a(Label paramLabel1, Label paramLabel2)
  {
    c localC = new c();
    c = false;
    l = false;
    if ((paramLabel1 != null) && (m.containsKey("android:visibility:visibility")))
    {
      b = ((Integer)m.get("android:visibility:visibility")).intValue();
      a = ((ViewGroup)m.get("android:visibility:parent"));
    }
    else
    {
      b = -1;
      a = null;
    }
    if ((paramLabel2 != null) && (m.containsKey("android:visibility:visibility")))
    {
      i = ((Integer)m.get("android:visibility:visibility")).intValue();
      g = ((ViewGroup)m.get("android:visibility:parent"));
    }
    else
    {
      i = -1;
      g = null;
    }
    if ((paramLabel1 != null) && (paramLabel2 != null))
    {
      int i = b;
      int j = i;
      if ((i == j) && (a == g)) {
        return localC;
      }
      if (i != j)
      {
        if (i == 0)
        {
          l = false;
          c = true;
          return localC;
        }
        if (j == 0)
        {
          l = true;
          c = true;
          return localC;
        }
      }
      else
      {
        if (g == null)
        {
          l = false;
          c = true;
          return localC;
        }
        if (a == null)
        {
          l = true;
          c = true;
          return localC;
        }
      }
    }
    else
    {
      if ((paramLabel1 == null) && (i == 0))
      {
        l = true;
        c = true;
        return localC;
      }
      if ((paramLabel2 == null) && (b == 0))
      {
        l = false;
        c = true;
      }
    }
    return localC;
  }
  
  private void a(Label paramLabel)
  {
    int i = a.getVisibility();
    m.put("android:visibility:visibility", Integer.valueOf(i));
    m.put("android:visibility:parent", a.getParent());
    int[] arrayOfInt = new int[2];
    a.getLocationOnScreen(arrayOfInt);
    m.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  public abstract android.animation.Animator a(ViewGroup paramViewGroup, View paramView, Label paramLabel1, Label paramLabel2);
  
  public android.animation.Animator a(final ViewGroup paramViewGroup, Label paramLabel1, int paramInt1, Label paramLabel2, int paramInt2)
  {
    if ((c & 0x2) != 2) {
      return null;
    }
    if (paramLabel1 == null) {
      return null;
    }
    final View localView1 = a;
    Object localObject2;
    if (paramLabel2 != null) {
      localObject2 = a;
    } else {
      localObject2 = null;
    }
    int i = R.id.b;
    Object localObject1 = (View)localView1.getTag(i);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = null;
      paramInt1 = 1;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    else
    {
      if ((localObject2 != null) && (((View)localObject2).getParent() != null))
      {
        if ((paramInt2 == 4) || (localView1 == localObject2))
        {
          localObject1 = localObject2;
          paramInt1 = 0;
          localObject2 = null;
          break label145;
        }
      }
      else if (localObject2 != null)
      {
        localObject1 = null;
        paramInt1 = 0;
        break label145;
      }
      localObject2 = null;
      localObject1 = null;
      paramInt1 = 1;
      label145:
      localObject3 = localObject2;
      if (paramInt1 != 0) {
        if (localView1.getParent() != null)
        {
          localObject3 = localObject2;
          if ((localView1.getParent() instanceof View))
          {
            View localView2 = (View)localView1.getParent();
            if (!aequalsac)
            {
              localObject3 = l.draw(paramViewGroup, localView1, localView2);
            }
            else
            {
              paramInt1 = localView2.getId();
              localObject3 = localObject2;
              if (localView2.getParent() == null)
              {
                localObject3 = localObject2;
                if (paramInt1 != -1)
                {
                  localObject3 = localObject2;
                  if (paramViewGroup.findViewById(paramInt1) != null)
                  {
                    localObject3 = localObject2;
                    if (!w) {}
                  }
                }
              }
            }
          }
        }
        else
        {
          paramInt1 = 0;
          localObject2 = localView1;
          break label291;
        }
      }
      paramInt1 = 0;
      localObject2 = localObject3;
    }
    label291:
    if (localObject2 != null)
    {
      if (paramInt1 == 0)
      {
        localObject1 = (int[])m.get("android:visibility:screenLocation");
        paramInt2 = localObject1[0];
        int j = localObject1[1];
        localObject1 = new int[2];
        paramViewGroup.getLocationOnScreen((int[])localObject1);
        ((View)localObject2).offsetLeftAndRight(paramInt2 - localObject1[0] - ((View)localObject2).getLeft());
        ((View)localObject2).offsetTopAndBottom(j - localObject1[1] - ((View)localObject2).getTop());
        XYPlot.a(paramViewGroup).b((View)localObject2);
      }
      paramLabel1 = a(paramViewGroup, (View)localObject2, paramLabel1, paramLabel2);
      if (paramInt1 == 0)
      {
        if (paramLabel1 == null)
        {
          XYPlot.a(paramViewGroup).c((View)localObject2);
          return paramLabel1;
        }
        localView1.setTag(i, localObject2);
        next(new a(paramViewGroup, (View)localObject2, localView1));
        return paramLabel1;
      }
    }
    else
    {
      if (localObject1 != null)
      {
        paramInt1 = ((View)localObject1).getVisibility();
        Item.set((View)localObject1, 0);
        paramViewGroup = a(paramViewGroup, (View)localObject1, paramLabel1, paramLabel2);
        if (paramViewGroup != null)
        {
          paramLabel1 = new b((View)localObject1, paramInt2, true);
          paramViewGroup.addListener(paramLabel1);
          Animator.cancel(paramViewGroup, paramLabel1);
          next(paramLabel1);
          return paramViewGroup;
        }
        Item.set((View)localObject1, paramInt1);
        return paramViewGroup;
      }
      return null;
    }
    return paramLabel1;
  }
  
  public android.animation.Animator a(ViewGroup paramViewGroup, Label paramLabel1, Label paramLabel2)
  {
    c localC = a(paramLabel1, paramLabel2);
    if ((c) && ((a != null) || (g != null)))
    {
      if (l) {
        return b(paramViewGroup, paramLabel1, b, paramLabel2, i);
      }
      return a(paramViewGroup, paramLabel1, b, paramLabel2, i);
    }
    return null;
  }
  
  public void add(int paramInt)
  {
    if ((paramInt & 0xFFFFFFFC) == 0)
    {
      c = paramInt;
      return;
    }
    throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
  }
  
  public boolean add(Label paramLabel1, Label paramLabel2)
  {
    if ((paramLabel1 == null) && (paramLabel2 == null)) {
      return false;
    }
    if ((paramLabel1 != null) && (paramLabel2 != null) && (m.containsKey("android:visibility:visibility") != m.containsKey("android:visibility:visibility"))) {
      return false;
    }
    paramLabel1 = a(paramLabel1, paramLabel2);
    return (c) && ((b == 0) || (i == 0));
  }
  
  public abstract android.animation.Animator b(ViewGroup paramViewGroup, View paramView, Label paramLabel1, Label paramLabel2);
  
  public android.animation.Animator b(ViewGroup paramViewGroup, Label paramLabel1, int paramInt1, Label paramLabel2, int paramInt2)
  {
    if ((c & 0x1) == 1)
    {
      if (paramLabel2 == null) {
        return null;
      }
      if (paramLabel1 == null)
      {
        View localView = (View)a.getParent();
        if (aaequalsc) {
          return null;
        }
      }
      return b(paramViewGroup, a, paramLabel1, paramLabel2);
    }
    return null;
  }
  
  public void draw(Label paramLabel)
  {
    a(paramLabel);
  }
  
  public String[] valueOf()
  {
    return CANCELED;
  }
  
  public void write(Label paramLabel)
  {
    a(paramLabel);
  }
  
  class a
    extends ActionMenuItemView
  {
    a(ViewGroup paramViewGroup, View paramView1, View paramView2) {}
    
    public void b(Transition paramTransition)
    {
      if (a.getParent() == null)
      {
        XYPlot.a(paramViewGroup).b(a);
        return;
      }
      cancel();
    }
    
    public void c(Transition paramTransition)
    {
      localView1.setTag(R.id.b, null);
      XYPlot.a(paramViewGroup).c(a);
      paramTransition.recycle(this);
    }
    
    public void e(Transition paramTransition)
    {
      XYPlot.a(paramViewGroup).c(a);
    }
  }
  
  private static class b
    extends AnimatorListenerAdapter
    implements Transition.f, Identity
  {
    private final ViewGroup a;
    private boolean d;
    boolean mIsVisible = false;
    private final int mPosition;
    private final View mView;
    private final boolean o;
    
    b(View paramView, int paramInt, boolean paramBoolean)
    {
      mView = paramView;
      mPosition = paramInt;
      a = ((ViewGroup)paramView.getParent());
      o = paramBoolean;
      d(true);
    }
    
    private void d(boolean paramBoolean)
    {
      if ((o) && (d != paramBoolean))
      {
        ViewGroup localViewGroup = a;
        if (localViewGroup != null)
        {
          d = paramBoolean;
          XYPlot.a(localViewGroup, paramBoolean);
        }
      }
    }
    
    private void setText()
    {
      if (!mIsVisible)
      {
        Item.set(mView, mPosition);
        ViewGroup localViewGroup = a;
        if (localViewGroup != null) {
          localViewGroup.invalidate();
        }
      }
      d(false);
    }
    
    public void b(Transition paramTransition)
    {
      d(true);
    }
    
    public void c(Transition paramTransition)
    {
      setText();
      paramTransition.recycle(this);
    }
    
    public void d(Transition paramTransition) {}
    
    public void e(Transition paramTransition)
    {
      d(false);
    }
    
    public void onAnimationCancel(android.animation.Animator paramAnimator)
    {
      mIsVisible = true;
    }
    
    public void onAnimationEnd(android.animation.Animator paramAnimator)
    {
      setText();
    }
    
    public void onAnimationPause(android.animation.Animator paramAnimator)
    {
      if (!mIsVisible) {
        Item.set(mView, mPosition);
      }
    }
    
    public void onAnimationRepeat(android.animation.Animator paramAnimator) {}
    
    public void onAnimationResume(android.animation.Animator paramAnimator)
    {
      if (!mIsVisible) {
        Item.set(mView, 0);
      }
    }
    
    public void onAnimationStart(android.animation.Animator paramAnimator) {}
    
    public void onPreDraw(Transition paramTransition) {}
  }
  
  private static class c
  {
    ViewGroup a;
    int b;
    boolean c;
    ViewGroup g;
    int i;
    boolean l;
    
    c() {}
  }
}
