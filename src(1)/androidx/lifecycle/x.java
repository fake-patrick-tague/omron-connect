package androidx.lifecycle;

import androidx.lifecycle.xy.a;
import androidx.lifecycle.xy.c;
import kotlin.x.d.i;

public final class x
{
  public static final a a(h paramH)
  {
    i.e(paramH, "owner");
    if ((paramH instanceof XYSeries))
    {
      paramH = ((XYSeries)paramH).getDefaultViewModelCreationExtras();
      i.d(paramH, "{\n        owner.defaultV?ModelCreationExtras\n    }");
      return paramH;
    }
    return c.d;
  }
}
