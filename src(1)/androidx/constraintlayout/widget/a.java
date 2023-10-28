package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class a
{
  public int a = 0;
  public float d = 1.0F;
  public int e = 0;
  public float h = NaN.0F;
  public boolean i = false;
  
  public a() {}
  
  void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SearchView);
    i = true;
    int k = paramContext.getIndexCount();
    int j = 0;
    while (j < k)
    {
      int m = paramContext.getIndex(j);
      if (m == R.styleable.LONG)
      {
        d = paramContext.getFloat(m, d);
      }
      else if (m == R.styleable.d)
      {
        a = paramContext.getInt(m, a);
        a = f.a()[a];
      }
      else if (m == R.styleable.v)
      {
        e = paramContext.getInt(m, e);
      }
      else if (m == R.styleable.Theme_windowNoTitle)
      {
        h = paramContext.getFloat(m, h);
      }
      j += 1;
    }
    paramContext.recycle();
  }
  
  public void a(a paramA)
  {
    i = i;
    a = a;
    d = d;
    h = h;
    e = e;
  }
}
