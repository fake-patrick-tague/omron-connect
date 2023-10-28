package androidx.transition;

import android.view.View;

final class Property
  extends android.util.Property<View, Float>
{
  Property(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float get(View paramView)
  {
    return Float.valueOf(Item.d(paramView));
  }
  
  public void setValue(View paramView, Float paramFloat)
  {
    Item.set(paramView, paramFloat.floatValue());
  }
}
