package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public abstract interface PlotListener
{
  public abstract ColorStateList getSupportImageTintList();
  
  public abstract PorterDuff.Mode getSupportImageTintMode();
  
  public abstract void setSupportImageTintList(ColorStateList paramColorStateList);
  
  public abstract void setSupportImageTintMode(PorterDuff.Mode paramMode);
}
