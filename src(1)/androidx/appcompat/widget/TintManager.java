package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.graphics.ColorUtils;
import v7.internal.R.attr;
import v7.internal.R.dimen;
import v7.internal.R.drawable;
import v7.internal.l;
import v7.internal.transition.util.View;

class TintManager
  implements d0.f
{
  private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = { R.drawable.header, R.drawable.c, R.drawable.b };
  private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = { R.drawable.about, R.drawable.info, R.drawable.SDK_INT, R.drawable.checkbox, R.drawable.settings, R.drawable.x, R.drawable.toolbar };
  private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = { R.drawable.white, R.drawable.black, R.drawable.heads };
  private final int[] TINT_CHECKABLE_BUTTON_LIST = { R.drawable.l, R.drawable.j, R.drawable.list, R.drawable.dialog };
  private final int[] TINT_COLOR_CONTROL_NORMAL = { R.drawable.rotate, R.drawable.icon, R.drawable.path, R.drawable.base, R.drawable.title, R.drawable.image, R.drawable.id };
  private final int[] TINT_COLOR_CONTROL_STATE_LIST = { R.drawable.op, R.drawable.a };
  
  TintManager() {}
  
  private boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private ColorStateList createBorderlessButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, 0);
  }
  
  private ColorStateList createButtonColorStateList(Context paramContext, int paramInt)
  {
    int k = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlHighlight);
    int i = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorButtonNormal);
    paramContext = ThemeUtils.DISABLED_STATE_SET;
    int[] arrayOfInt1 = ThemeUtils.PRESSED_STATE_SET;
    int j = ColorUtils.compositeColors(k, paramInt);
    int[] arrayOfInt2 = ThemeUtils.FOCUSED_STATE_SET;
    k = ColorUtils.compositeColors(k, paramInt);
    return new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, ThemeUtils.EMPTY_STATE_SET }, new int[] { i, j, k, paramInt });
  }
  
  private ColorStateList createColoredButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorAccent));
  }
  
  private ColorStateList createDefaultButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorButtonNormal));
  }
  
  private ColorStateList createSwitchThumbColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    int i = R.attr.colorSwitchThumbNormal;
    ColorStateList localColorStateList = ThemeUtils.getThemeAttrColorStateList(paramContext, i);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    else
    {
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, i);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, i);
    }
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  private LayerDrawable getDrawable(AppCompatDrawableManager paramAppCompatDrawableManager, Context paramContext, int paramInt)
  {
    paramInt = paramContext.getResources().getDimensionPixelSize(paramInt);
    Object localObject2 = paramAppCompatDrawableManager.getDrawable(paramContext, R.drawable.abc_cab_background_top_mtrl_alpha);
    Object localObject1 = paramAppCompatDrawableManager.getDrawable(paramContext, R.drawable.abc_switch_track_mtrl_alpha);
    if (((localObject2 instanceof BitmapDrawable)) && (((android.graphics.drawable.Drawable)localObject2).getIntrinsicWidth() == paramInt) && (((android.graphics.drawable.Drawable)localObject2).getIntrinsicHeight() == paramInt))
    {
      paramAppCompatDrawableManager = (BitmapDrawable)localObject2;
      paramContext = new BitmapDrawable(paramAppCompatDrawableManager.getBitmap());
    }
    else
    {
      paramContext = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
      paramAppCompatDrawableManager = new Canvas(paramContext);
      ((android.graphics.drawable.Drawable)localObject2).setBounds(0, 0, paramInt, paramInt);
      ((android.graphics.drawable.Drawable)localObject2).draw(paramAppCompatDrawableManager);
      paramAppCompatDrawableManager = new BitmapDrawable(paramContext);
      paramContext = new BitmapDrawable(paramContext);
    }
    paramContext.setTileModeX(Shader.TileMode.REPEAT);
    if (((localObject1 instanceof BitmapDrawable)) && (((android.graphics.drawable.Drawable)localObject1).getIntrinsicWidth() == paramInt) && (((android.graphics.drawable.Drawable)localObject1).getIntrinsicHeight() == paramInt))
    {
      localObject1 = (BitmapDrawable)localObject1;
    }
    else
    {
      localObject2 = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject2);
      ((android.graphics.drawable.Drawable)localObject1).setBounds(0, 0, paramInt, paramInt);
      ((android.graphics.drawable.Drawable)localObject1).draw(localCanvas);
      localObject1 = new BitmapDrawable((Bitmap)localObject2);
    }
    paramAppCompatDrawableManager = new LayerDrawable(new android.graphics.drawable.Drawable[] { paramAppCompatDrawableManager, localObject1, paramContext });
    paramAppCompatDrawableManager.setId(0, 16908288);
    paramAppCompatDrawableManager.setId(1, 16908303);
    paramAppCompatDrawableManager.setId(2, 16908301);
    return paramAppCompatDrawableManager;
  }
  
  private void setPorterDuffColorFilter(android.graphics.drawable.Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    android.graphics.drawable.Drawable localDrawable = paramDrawable;
    if (Drawable.canSafelyMutateDrawable(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = ViewCompat.setAlpha();
    }
    localDrawable.setColorFilter(ViewCompat.get(paramInt, paramDrawable));
  }
  
  public ColorStateList getTintList(Context paramContext, int paramInt)
  {
    if (paramInt == R.drawable.abc_btn_colored_material) {
      return View.a(paramContext, l.abc_spinner_mtrl_am_alpha);
    }
    if (paramInt == R.drawable.abc_edit_text_material) {
      return View.a(paramContext, l.abc_switch_track_mtrl_alpha);
    }
    if (paramInt == R.drawable.abc_switch_thumb_material) {
      return createSwitchThumbColorStateList(paramContext);
    }
    if (paramInt == R.drawable.abc_btn_default_mtrl_shape) {
      return createDefaultButtonColorStateList(paramContext);
    }
    if (paramInt == R.drawable.abc_btn_borderless_material) {
      return createBorderlessButtonColorStateList(paramContext);
    }
    if (paramInt == R.drawable.abc_btn_check_material) {
      return createColoredButtonColorStateList(paramContext);
    }
    if ((paramInt != R.drawable.abc_spinner_mtrl_am_alpha) && (paramInt != R.drawable.abc_spinner_textfield_background_material))
    {
      if (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt)) {
        return ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorControlNormal);
      }
      if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt)) {
        return View.a(paramContext, l.b);
      }
      if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, paramInt)) {
        return View.a(paramContext, l.abc_seekbar_thumb_material);
      }
      if (paramInt == R.drawable.abc_seekbar_thumb_material) {
        return View.a(paramContext, l.e);
      }
      return null;
    }
    return View.a(paramContext, l.c);
  }
  
  public PorterDuff.Mode getTintMode(int paramInt)
  {
    if (paramInt == R.drawable.abc_switch_thumb_material) {
      return PorterDuff.Mode.MULTIPLY;
    }
    return null;
  }
  
  public android.graphics.drawable.Drawable tintDrawable(AppCompatDrawableManager paramAppCompatDrawableManager, Context paramContext, int paramInt)
  {
    if (paramInt == R.drawable.abc_ratingbar_indicator_material) {
      return new LayerDrawable(new android.graphics.drawable.Drawable[] { paramAppCompatDrawableManager.getDrawable(paramContext, R.drawable.c), paramAppCompatDrawableManager.getDrawable(paramContext, R.drawable.SDK_INT) });
    }
    if (paramInt == R.drawable.abc_cab_background_top_material) {
      return getDrawable(paramAppCompatDrawableManager, paramContext, R.dimen.abc_cab_background_internal_bg);
    }
    if (paramInt == R.drawable.abc_cab_background_internal_bg) {
      return getDrawable(paramAppCompatDrawableManager, paramContext, R.dimen.abc_cab_background_top_mtrl_alpha);
    }
    if (paramInt == R.drawable.abc_seekbar_track_material) {
      return getDrawable(paramAppCompatDrawableManager, paramContext, R.dimen.abc_text_size_small_material);
    }
    return null;
  }
  
  public boolean tintDrawable(Context paramContext, int paramInt, android.graphics.drawable.Drawable paramDrawable)
  {
    if (paramInt == R.drawable.abc_ratingbar_small_material)
    {
      paramDrawable = (LayerDrawable)paramDrawable;
      localDrawable = paramDrawable.findDrawableByLayerId(16908288);
      paramInt = R.attr.colorControlNormal;
      setPorterDuffColorFilter(localDrawable, ThemeUtils.getThemeAttrColor(paramContext, paramInt), ViewCompat.setAlpha());
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, paramInt), ViewCompat.setAlpha());
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), ViewCompat.setAlpha());
      return true;
    }
    if ((paramInt != R.drawable.abc_cab_background_top_material) && (paramInt != R.drawable.abc_cab_background_internal_bg) && (paramInt != R.drawable.abc_seekbar_track_material)) {
      return false;
    }
    paramDrawable = (LayerDrawable)paramDrawable;
    setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal), ViewCompat.setAlpha());
    android.graphics.drawable.Drawable localDrawable = paramDrawable.findDrawableByLayerId(16908303);
    paramInt = R.attr.colorControlActivated;
    setPorterDuffColorFilter(localDrawable, ThemeUtils.getThemeAttrColor(paramContext, paramInt), ViewCompat.setAlpha());
    setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, paramInt), ViewCompat.setAlpha());
    return true;
  }
  
  public boolean tintDrawableUsingColorFilter(Context paramContext, int paramInt, android.graphics.drawable.Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = ViewCompat.setAlpha();
    boolean bool = arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, paramInt);
    int i = 16842801;
    if (bool) {
      paramInt = R.attr.colorControlNormal;
    }
    for (;;)
    {
      for (i = -1;; i = Math.round(40.8F))
      {
        j = 1;
        break label124;
        if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, paramInt))
        {
          paramInt = R.attr.colorControlActivated;
          break;
        }
        if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, paramInt))
        {
          localMode = PorterDuff.Mode.MULTIPLY;
          paramInt = i;
          break;
        }
        if (paramInt != R.drawable.abc_list_divider_mtrl_alpha) {
          break label103;
        }
        paramInt = 16842800;
      }
      label103:
      if (paramInt != R.drawable.progress_bar) {
        break;
      }
      paramInt = i;
    }
    i = -1;
    int j = 0;
    paramInt = 0;
    label124:
    if (j != 0)
    {
      android.graphics.drawable.Drawable localDrawable = paramDrawable;
      if (Drawable.canSafelyMutateDrawable(paramDrawable)) {
        localDrawable = paramDrawable.mutate();
      }
      localDrawable.setColorFilter(ViewCompat.get(ThemeUtils.getThemeAttrColor(paramContext, paramInt), localMode));
      if (i != -1)
      {
        localDrawable.setAlpha(i);
        return true;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
}
