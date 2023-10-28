package androidx.core.content.asm;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

final class l
{
  static final float[] c;
  static final float[][] color;
  static final float[][] i = { { 0.401288F, 0.650173F, -0.051461F }, { -0.250268F, 1.204414F, 0.045854F }, { -0.002079F, 0.048952F, 0.953127F } };
  static final float[][] k = { { 1.8620678F, -1.0112547F, 0.14918678F }, { 0.38752654F, 0.62144744F, -0.00897398F }, { -0.0158415F, -0.03412294F, 1.0499644F } };
  
  static
  {
    c = new float[] { 95.047F, 100.0F, 108.883F };
    float[] arrayOfFloat1 = { 0.2126F, 0.7152F, 0.0722F };
    float[] arrayOfFloat2 = { 0.01932141F, 0.11916382F, 0.9503448F };
    color = new float[][] { { 0.41233894F, 0.35762063F, 0.18051042F }, arrayOfFloat1, arrayOfFloat2 };
  }
  
  static float a(float paramFloat)
  {
    paramFloat /= 100.0F;
    if (paramFloat <= 0.008856452F) {
      return paramFloat * 903.2963F;
    }
    return (float)Math.cbrt(paramFloat) * 116.0F - 16.0F;
  }
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + (paramFloat2 - paramFloat1) * paramFloat3;
  }
  
  static float a(int paramInt)
  {
    return a(setAlpha(paramInt));
  }
  
  static int draw(float paramFloat)
  {
    if (paramFloat < 1.0F) {
      return -16777216;
    }
    if (paramFloat > 99.0F) {
      return -1;
    }
    float f3 = (paramFloat + 16.0F) / 116.0F;
    int j;
    if (paramFloat > 8.0F) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      paramFloat = f3 * f3 * f3;
    } else {
      paramFloat /= 903.2963F;
    }
    float f1 = f3 * f3 * f3;
    if (f1 > 0.008856452F) {
      j = 1;
    } else {
      j = 0;
    }
    float f2;
    if (j != 0) {
      f2 = f1;
    } else {
      f2 = (f3 * 116.0F - 16.0F) / 903.2963F;
    }
    if (j == 0) {
      f1 = (f3 * 116.0F - 16.0F) / 903.2963F;
    }
    float[] arrayOfFloat = c;
    return ColorUtils.XYZToColor(f2 * arrayOfFloat[0], paramFloat * arrayOfFloat[1], f1 * arrayOfFloat[2]);
  }
  
  static float[] draw(int paramInt)
  {
    float f1 = evaluate(Color.red(paramInt));
    float f2 = evaluate(Color.green(paramInt));
    float f3 = evaluate(Color.blue(paramInt));
    float[][] arrayOfFloat = color;
    return new float[] { arrayOfFloat[0][0] * f1 + arrayOfFloat[0][1] * f2 + arrayOfFloat[0][2] * f3, arrayOfFloat[1][0] * f1 + arrayOfFloat[1][1] * f2 + arrayOfFloat[1][2] * f3, f1 * arrayOfFloat[2][0] + f2 * arrayOfFloat[2][1] + f3 * arrayOfFloat[2][2] };
  }
  
  static float evaluate(float paramFloat)
  {
    if (paramFloat > 8.0F) {}
    for (paramFloat = (float)Math.pow((paramFloat + 16.0D) / 116.0D, 3.0D);; paramFloat /= 903.2963F) {
      return paramFloat * 100.0F;
    }
  }
  
  static float evaluate(int paramInt)
  {
    float f = paramInt / 255.0F;
    if (f <= 0.04045F) {}
    for (f /= 12.92F;; f = (float)Math.pow((f + 0.055F) / 1.055F, 2.4000000953674316D)) {
      return f * 100.0F;
    }
  }
  
  static float setAlpha(int paramInt)
  {
    float f1 = evaluate(Color.red(paramInt));
    float f2 = evaluate(Color.green(paramInt));
    float f3 = evaluate(Color.blue(paramInt));
    float[][] arrayOfFloat = color;
    return f1 * arrayOfFloat[1][0] + f2 * arrayOfFloat[1][1] + f3 * arrayOfFloat[1][2];
  }
}
