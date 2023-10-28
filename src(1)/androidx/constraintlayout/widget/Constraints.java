package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class Constraints
  extends ViewGroup
{
  f o;
  
  public LayoutParams applyFont(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ConstraintLayout.LayoutParams(paramLayoutParams);
  }
  
  public f getConstraintSet()
  {
    if (o == null) {
      o = new f();
    }
    o.a(this);
    return o;
  }
  
  protected LayoutParams isValid()
  {
    return new LayoutParams(-2, -2);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public static class LayoutParams
    extends ConstraintLayout.LayoutParams
  {
    public float a;
    public boolean c;
    public float d = 1.0F;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float n;
    public float r;
    public float s;
    public float w;
    public float x;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      c = false;
      a = 0.0F;
      r = 0.0F;
      n = 0.0F;
      x = 0.0F;
      w = 1.0F;
      l = 1.0F;
      s = 0.0F;
      i = 0.0F;
      h = 0.0F;
      j = 0.0F;
      k = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      int m = 0;
      c = false;
      a = 0.0F;
      r = 0.0F;
      n = 0.0F;
      x = 0.0F;
      w = 1.0F;
      l = 1.0F;
      s = 0.0F;
      i = 0.0F;
      h = 0.0F;
      j = 0.0F;
      k = 0.0F;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
      int i1 = paramContext.getIndexCount();
      while (m < i1)
      {
        int i2 = paramContext.getIndex(m);
        if (i2 == R.styleable.set) {
          d = paramContext.getFloat(i2, d);
        } else if (i2 == R.styleable.settings)
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            a = paramContext.getFloat(i2, a);
            c = true;
          }
        }
        else if (i2 == R.styleable.f5) {
          n = paramContext.getFloat(i2, n);
        } else if (i2 == R.styleable.pos) {
          x = paramContext.getFloat(i2, x);
        } else if (i2 == R.styleable.t) {
          r = paramContext.getFloat(i2, r);
        } else if (i2 == R.styleable.z) {
          w = paramContext.getFloat(i2, w);
        } else if (i2 == R.styleable.size) {
          l = paramContext.getFloat(i2, l);
        } else if (i2 == R.styleable.x) {
          s = paramContext.getFloat(i2, s);
        } else if (i2 == R.styleable.b) {
          i = paramContext.getFloat(i2, i);
        } else if (i2 == R.styleable.flags) {
          h = paramContext.getFloat(i2, h);
        } else if (i2 == R.styleable.board) {
          j = paramContext.getFloat(i2, j);
        } else if ((i2 == R.styleable.list) && (Build.VERSION.SDK_INT >= 21)) {
          k = paramContext.getFloat(i2, k);
        }
        m += 1;
      }
      paramContext.recycle();
    }
  }
}
