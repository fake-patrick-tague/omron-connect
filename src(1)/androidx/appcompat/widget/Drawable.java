package androidx.appcompat.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import androidx.core.graphics.drawable.Integer;

public class Drawable
{
  private static final int[] STATE_FOCUSED = { 16842912 };
  private static final int[] STATE_INACTIVE = new int[0];
  public static final Rect sOldBounds = new Rect();
  
  static void a(android.graphics.drawable.Drawable paramDrawable)
  {
    String str = paramDrawable.getClass().getName();
    int i = Build.VERSION.SDK_INT;
    if ((i == 21) && ("android.graphics.drawable.VectorDrawable".equals(str)))
    {
      setDrawable(paramDrawable);
      return;
    }
    if ((i >= 29) && (i < 31) && ("android.graphics.drawable.ColorStateListDrawable".equals(str))) {
      setDrawable(paramDrawable);
    }
  }
  
  public static boolean canSafelyMutateDrawable(android.graphics.drawable.Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17) {
      return true;
    }
    if ((i < 15) && ((paramDrawable instanceof InsetDrawable))) {
      return false;
    }
    if ((i < 15) && ((paramDrawable instanceof GradientDrawable))) {
      return false;
    }
    if ((i < 17) && ((paramDrawable instanceof LayerDrawable))) {
      return false;
    }
    if ((paramDrawable instanceof DrawableContainer))
    {
      paramDrawable = paramDrawable.getConstantState();
      if ((paramDrawable instanceof DrawableContainer.DrawableContainerState))
      {
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        i = 0;
        while (i < j)
        {
          if (!canSafelyMutateDrawable(paramDrawable[i])) {
            return false;
          }
          i += 1;
        }
      }
    }
    else
    {
      if ((paramDrawable instanceof Integer)) {
        return canSafelyMutateDrawable(((Integer)paramDrawable).getWrappedDrawable());
      }
      if ((paramDrawable instanceof v7.internal.text.drawable.DrawableWrapper)) {
        return canSafelyMutateDrawable(((v7.internal.text.drawable.DrawableWrapper)paramDrawable).getWrappedDrawable());
      }
      if ((paramDrawable instanceof ScaleDrawable)) {
        return canSafelyMutateDrawable(((ScaleDrawable)paramDrawable).getDrawable());
      }
    }
    return true;
  }
  
  public static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  private static void setDrawable(android.graphics.drawable.Drawable paramDrawable)
  {
    int[] arrayOfInt = paramDrawable.getState();
    if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
      paramDrawable.setState(STATE_INACTIVE);
    } else {
      paramDrawable.setState(STATE_FOCUSED);
    }
    paramDrawable.setState(arrayOfInt);
  }
}
