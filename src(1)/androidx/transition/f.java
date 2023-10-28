package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import v7.v7.package_13.ViewCompat;

class f
  extends ViewGroup
{
  static Method sComputeFitSystemWindowsMethod;
  View a;
  ArrayList<Drawable> b = null;
  ViewGroup d;
  e k;
  private boolean w;
  
  static
  {
    Object localObject = Integer.TYPE;
    try
    {
      localObject = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { localObject, localObject, Rect.class });
      sComputeFitSystemWindowsMethod = (Method)localObject;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  f(Context paramContext, ViewGroup paramViewGroup, View paramView, e paramE)
  {
    super(paramContext);
    d = paramViewGroup;
    a = paramView;
    setRight(paramViewGroup.getWidth());
    setBottom(paramViewGroup.getHeight());
    paramViewGroup.addView(this);
    k = paramE;
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    d.getLocationOnScreen(arrayOfInt1);
    a.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] -= arrayOfInt1[0];
    arrayOfInt2[1] -= arrayOfInt1[1];
  }
  
  private void b()
  {
    if (getChildCount() == 0)
    {
      ArrayList localArrayList = b;
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        w = true;
        d.removeView(this);
      }
    }
  }
  
  private void close()
  {
    if (!w) {
      return;
    }
    throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
  }
  
  public void a(Drawable paramDrawable)
  {
    close();
    if (b == null) {
      b = new ArrayList();
    }
    if (!b.contains(paramDrawable))
    {
      b.add(paramDrawable);
      invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(this);
    }
  }
  
  public void a(View paramView)
  {
    close();
    if ((paramView.getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if ((localViewGroup != d) && (localViewGroup.getParent() != null) && (ViewCompat.d(localViewGroup)))
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        localViewGroup.getLocationOnScreen(arrayOfInt1);
        d.getLocationOnScreen(arrayOfInt2);
        ViewCompat.offsetLeftAndRight(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
        ViewCompat.offsetTopAndBottom(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
      }
      localViewGroup.removeView(paramView);
      if (paramView.getParent() != null) {
        localViewGroup.removeView(paramView);
      }
    }
    super.addView(paramView);
  }
  
  public void b(Drawable paramDrawable)
  {
    ArrayList localArrayList = b;
    if (localArrayList != null)
    {
      localArrayList.remove(paramDrawable);
      invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(null);
      b();
    }
  }
  
  public void b(View paramView)
  {
    super.removeView(paramView);
    b();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = new int[2];
    int[] arrayOfInt = new int[2];
    d.getLocationOnScreen((int[])localObject);
    a.getLocationOnScreen(arrayOfInt);
    int j = 0;
    paramCanvas.translate(arrayOfInt[0] - localObject[0], arrayOfInt[1] - localObject[1]);
    paramCanvas.clipRect(new Rect(0, 0, a.getWidth(), a.getHeight()));
    super.dispatchDraw(paramCanvas);
    localObject = b;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((ArrayList)localObject).size();
    }
    while (j < i)
    {
      ((Drawable)b.get(j)).draw(paramCanvas);
      j += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    if (d != null)
    {
      paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
      if ((d instanceof ViewGroup))
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = 0;
        int[] arrayOfInt = new int[2];
        a(arrayOfInt);
        paramRect.offset(arrayOfInt[0], arrayOfInt[1]);
        return super.invalidateChildInParent(paramArrayOfInt, paramRect);
      }
      invalidate(paramRect);
    }
    return null;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate(paramDrawable.getBounds());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if (!super.verifyDrawable(paramDrawable))
    {
      ArrayList localArrayList = b;
      if ((localArrayList == null) || (!localArrayList.contains(paramDrawable))) {
        return false;
      }
    }
    return true;
  }
}
