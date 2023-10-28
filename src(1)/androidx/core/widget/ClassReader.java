package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

class ClassReader
{
  static PorterDuff.Mode a(ImageView paramImageView)
  {
    return paramImageView.getImageTintMode();
  }
  
  static void a(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    paramImageView.setImageTintList(paramColorStateList);
  }
  
  static ColorStateList b(ImageView paramImageView)
  {
    return paramImageView.getImageTintList();
  }
  
  static void b(ImageView paramImageView, PorterDuff.Mode paramMode)
  {
    paramImageView.setImageTintMode(paramMode);
  }
}
