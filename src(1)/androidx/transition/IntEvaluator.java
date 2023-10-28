package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class IntEvaluator
  implements TypeEvaluator<Rect>
{
  private Rect dstRect;
  
  IntEvaluator() {}
  
  public Rect evaluate(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    int i = left;
    i += (int)((left - i) * paramFloat);
    int j = top;
    j += (int)((top - j) * paramFloat);
    int k = right;
    k += (int)((right - k) * paramFloat);
    int m = bottom;
    m += (int)((bottom - m) * paramFloat);
    paramRect1 = dstRect;
    if (paramRect1 == null) {
      return new Rect(i, j, k, m);
    }
    paramRect1.set(i, j, k, m);
    return dstRect;
  }
}
