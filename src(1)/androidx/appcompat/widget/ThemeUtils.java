package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import v7.internal.R.styleable;

public class ThemeUtils
{
  static final int[] ACTIVATED_STATE_SET;
  static final int[] CHECKED_STATE_SET;
  static final int[] DISABLED_STATE_SET;
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] FOCUSED_STATE_SET;
  static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET;
  static final int[] PRESSED_STATE_SET;
  static final int[] SELECTED_STATE_SET;
  private static final int[] TEMP_ARRAY = new int[1];
  private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal();
  
  static
  {
    DISABLED_STATE_SET = new int[] { -16842910 };
    FOCUSED_STATE_SET = new int[] { 16842908 };
    ACTIVATED_STATE_SET = new int[] { 16843518 };
    PRESSED_STATE_SET = new int[] { 16842919 };
    CHECKED_STATE_SET = new int[] { 16842912 };
    SELECTED_STATE_SET = new int[] { 16842913 };
    NOT_PRESSED_OR_FOCUSED_STATE_SET = new int[] { -16842919, -16842908 };
  }
  
  public static void a(View paramView, Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(R.styleable.Theme);
    try
    {
      boolean bool = paramContext.hasValue(R.styleable.Theme_windowActionBar);
      if (!bool)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("View ");
        localStringBuilder.append(paramView.getClass());
        localStringBuilder.append(" is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
        Log.e("ThemeUtils", localStringBuilder.toString());
      }
      paramContext.recycle();
      return;
    }
    catch (Throwable paramView)
    {
      paramContext.recycle();
      throw paramView;
    }
  }
  
  public static int getDisabledThemeAttrColor(Context paramContext, int paramInt)
  {
    Object localObject = getThemeAttrColorStateList(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(DISABLED_STATE_SET, ((ColorStateList)localObject).getDefaultColor());
    }
    localObject = getTypedValue();
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    return getThemeAttrColor(paramContext, paramInt, ((TypedValue)localObject).getFloat());
  }
  
  public static int getThemeAttrColor(Context paramContext, int paramInt)
  {
    int[] arrayOfInt = TEMP_ARRAY;
    arrayOfInt[0] = paramInt;
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, null, arrayOfInt);
    try
    {
      paramInt = paramContext.getColor(0, 0);
      paramContext.recycle();
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      paramContext.recycle();
      throw localThrowable;
    }
  }
  
  static int getThemeAttrColor(Context paramContext, int paramInt, float paramFloat)
  {
    paramInt = getThemeAttrColor(paramContext, paramInt);
    return ColorUtils.setAlphaComponent(paramInt, Math.round(Color.alpha(paramInt) * paramFloat));
  }
  
  public static ColorStateList getThemeAttrColorStateList(Context paramContext, int paramInt)
  {
    Object localObject = TEMP_ARRAY;
    localObject[0] = paramInt;
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, null, (int[])localObject);
    try
    {
      localObject = paramContext.getColor(0);
      paramContext.recycle();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      paramContext.recycle();
      throw localThrowable;
    }
  }
  
  private static TypedValue getTypedValue()
  {
    ThreadLocal localThreadLocal = TL_TYPED_VALUE;
    TypedValue localTypedValue2 = (TypedValue)localThreadLocal.get();
    TypedValue localTypedValue1 = localTypedValue2;
    if (localTypedValue2 == null)
    {
      localTypedValue1 = new TypedValue();
      localThreadLocal.set(localTypedValue1);
    }
    return localTypedValue1;
  }
}
