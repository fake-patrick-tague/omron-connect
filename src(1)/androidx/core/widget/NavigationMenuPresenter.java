package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;

public class NavigationMenuPresenter
{
  public static PorterDuff.Mode a(ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ClassReader.a(paramImageView);
    }
    if ((paramImageView instanceof PlotListener)) {
      return ((PlotListener)paramImageView).getSupportImageTintMode();
    }
    return null;
  }
  
  public static void a(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      ClassReader.a(paramImageView, paramColorStateList);
      if (i == 21)
      {
        paramColorStateList = paramImageView.getDrawable();
        if ((paramColorStateList != null) && (ClassReader.b(paramImageView) != null))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramColorStateList);
        }
      }
    }
    else if ((paramImageView instanceof PlotListener))
    {
      ((PlotListener)paramImageView).setSupportImageTintList(paramColorStateList);
    }
  }
  
  public static void a(ImageView paramImageView, PorterDuff.Mode paramMode)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      ClassReader.b(paramImageView, paramMode);
      if (i == 21)
      {
        paramMode = paramImageView.getDrawable();
        if ((paramMode != null) && (ClassReader.b(paramImageView) != null))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramMode);
        }
      }
    }
    else if ((paramImageView instanceof PlotListener))
    {
      ((PlotListener)paramImageView).setSupportImageTintMode(paramMode);
    }
  }
  
  public static ColorStateList b(ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ClassReader.b(paramImageView);
    }
    if ((paramImageView instanceof PlotListener)) {
      return ((PlotListener)paramImageView).getSupportImageTintList();
    }
    return null;
  }
}
