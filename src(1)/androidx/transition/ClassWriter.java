package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class ClassWriter<T>
  extends Property<T, Float>
{
  private final Property<T, PointF> b;
  private final float n;
  private final PathMeasure r;
  private final PointF w = new PointF();
  private final float[] x = new float[2];
  private float y;
  
  ClassWriter(Property paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    b = paramProperty;
    paramProperty = new PathMeasure(paramPath, false);
    r = paramProperty;
    n = paramProperty.getLength();
  }
  
  public void a(Object paramObject, Float paramFloat)
  {
    y = paramFloat.floatValue();
    r.getPosTan(n * paramFloat.floatValue(), x, null);
    paramFloat = w;
    float[] arrayOfFloat = x;
    x = arrayOfFloat[0];
    y = arrayOfFloat[1];
    b.set(paramObject, paramFloat);
  }
  
  public Float put(Object paramObject)
  {
    return Float.valueOf(y);
  }
}
