package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.util.Property;

class y
{
  static PropertyValuesHolder ofFloat(Property paramProperty, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return PropertyValuesHolder.ofObject(paramProperty, null, paramPath);
    }
    return PropertyValuesHolder.ofFloat(new ClassWriter(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
  }
}
