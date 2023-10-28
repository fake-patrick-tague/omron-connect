package com.alivecor.asm;

import android.content.Context;
import com.alivecor.mapsforge.core.asm.b;
import com.alivecor.neuralsuite.NeuralSuite;
import java.io.File;

class a
  implements f
{
  private static final String i = "x";
  private static final String t = "inversion.tensorflow";
  private Context c;
  private final String f = "inversion.tensorflow";
  
  public a(Context paramContext)
  {
    c = paramContext.getApplicationContext();
  }
  
  public Type a(double[] paramArrayOfDouble)
  {
    int k = paramArrayOfDouble.length;
    float[] arrayOfFloat = new float[k];
    int j = 0;
    while (j < k)
    {
      arrayOfFloat[j] = ((float)paramArrayOfDouble[j]);
      j += 1;
    }
    return new Type(NeuralSuite.checkInverted(arrayOfFloat, b.a(c, f).getAbsolutePath()));
  }
}
