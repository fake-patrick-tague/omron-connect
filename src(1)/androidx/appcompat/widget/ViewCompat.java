package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

public final class ViewCompat
{
  private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  private static ViewCompat key;
  private AppCompatDrawableManager bitmap;
  
  public ViewCompat() {}
  
  public static PorterDuffColorFilter get(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      paramMode = AppCompatDrawableManager.getPorterDuffColorFilter(paramInt, paramMode);
      return paramMode;
    }
    catch (Throwable paramMode)
    {
      throw paramMode;
    }
  }
  
  public static ViewCompat get()
  {
    try
    {
      if (key == null) {
        set();
      }
      ViewCompat localViewCompat = key;
      return localViewCompat;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static void set()
  {
    try
    {
      if (key == null)
      {
        ViewCompat localViewCompat = new ViewCompat();
        key = localViewCompat;
        bitmap = AppCompatDrawableManager.get();
        keybitmap.get(new TintManager());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  static void tintDrawable(Drawable paramDrawable, TintInfo paramTintInfo, int[] paramArrayOfInt)
  {
    AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, paramArrayOfInt);
  }
  
  public Drawable getDrawable(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = bitmap.getDrawable(paramContext, paramInt);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  Drawable getDrawable(Context paramContext, int paramInt, boolean paramBoolean)
  {
    try
    {
      paramContext = bitmap.getDrawable(paramContext, paramInt, paramBoolean);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public void getDrawable(Context paramContext)
  {
    try
    {
      bitmap.get(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  ColorStateList getTintList(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = bitmap.get(paramContext, paramInt);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
}
