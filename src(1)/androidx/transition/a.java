package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class a
{
  private static Method d;
  private static Field o;
  private static boolean r;
  private static boolean s;
  
  a() {}
  
  private void a()
  {
    if (!r)
    {
      Object localObject = Integer.TYPE;
      try
      {
        localObject = View.class.getDeclaredMethod("setFrame", new Class[] { localObject, localObject, localObject, localObject });
        d = (Method)localObject;
        ((Method)localObject).setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", localNoSuchMethodException);
      }
      r = true;
    }
  }
  
  public float a(View paramView)
  {
    Float localFloat = (Float)paramView.getTag(R.id.t);
    if (localFloat != null) {
      return paramView.getAlpha() / localFloat.floatValue();
    }
    return paramView.getAlpha();
  }
  
  public void a(View paramView, float paramFloat)
  {
    Float localFloat = (Float)paramView.getTag(R.id.t);
    if (localFloat != null)
    {
      paramView.setAlpha(localFloat.floatValue() * paramFloat);
      return;
    }
    paramView.setAlpha(paramFloat);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (!s) {}
    try
    {
      localField = View.class.getDeclaredField("mViewFlags");
      o = localField;
      localField.setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          int i = localField.getInt(paramView);
          Field localField = o;
          localField.setInt(paramView, paramInt | i & 0xFFFFFFF3);
          return;
        }
        catch (IllegalAccessException paramView) {}
        localNoSuchFieldException = localNoSuchFieldException;
      }
    }
    Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
    s = true;
    localField = o;
    if (localField != null) {}
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    Method localMethod = d;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramView, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      catch (IllegalAccessException paramView) {}
    }
  }
  
  public void a(View paramView, Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      a((View)localObject, paramMatrix);
      paramMatrix.preTranslate(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
    }
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity()) {
      paramMatrix.preConcat(paramView);
    }
  }
  
  public void b(View paramView)
  {
    if (paramView.getVisibility() == 0) {
      paramView.setTag(R.id.t, null);
    }
  }
  
  public void draw(View paramView, Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      draw((View)localObject, paramMatrix);
      paramMatrix.postTranslate(((View)localObject).getScrollX(), ((View)localObject).getScrollY());
    }
    paramMatrix.postTranslate(-paramView.getLeft(), -paramView.getTop());
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity())
    {
      localObject = new Matrix();
      if (paramView.invert((Matrix)localObject)) {
        paramMatrix.postConcat((Matrix)localObject);
      }
    }
  }
  
  public void set(View paramView)
  {
    int i = R.id.t;
    if (paramView.getTag(i) == null) {
      paramView.setTag(i, Float.valueOf(paramView.getAlpha()));
    }
  }
}
