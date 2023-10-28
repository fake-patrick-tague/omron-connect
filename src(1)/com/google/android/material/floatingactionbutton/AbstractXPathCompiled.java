package com.google.android.material.floatingactionbutton;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

class AbstractXPathCompiled
  implements TypeEvaluator<Float>
{
  FloatEvaluator xfilter = new FloatEvaluator();
  
  AbstractXPathCompiled(FloatingActionButtonImpl paramFloatingActionButtonImpl) {}
  
  public Float evaluate(float paramFloat, Float paramFloat1, Float paramFloat2)
  {
    float f = xfilter.evaluate(paramFloat, paramFloat1, paramFloat2).floatValue();
    paramFloat = f;
    if (f < 0.1F) {
      paramFloat = 0.0F;
    }
    return Float.valueOf(paramFloat);
  }
}
