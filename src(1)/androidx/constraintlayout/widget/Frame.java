package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;

public class Frame
{
  private static SparseIntArray this$0;
  public String d = null;
  public int e = -1;
  public int h = -1;
  public boolean i = false;
  public float w = NaN.0F;
  public int x = 0;
  public float y = NaN.0F;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    this$0 = localSparseIntArray;
    localSparseIntArray.append(R.styleable.DIRECTORY, 1);
    this$0.append(R.styleable.WHITELIST, 2);
    this$0.append(R.styleable.mFilter, 3);
    this$0.append(R.styleable.STEP_1, 4);
    this$0.append(R.styleable.mMode, 5);
    this$0.append(R.styleable.STEP_2, 6);
  }
  
  public Frame() {}
  
  public void a(Frame paramFrame)
  {
    i = i;
    h = h;
    d = d;
    e = e;
    x = x;
    y = y;
    w = w;
  }
  
  void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PullToRefresh);
    i = true;
    int k = paramContext.getIndexCount();
    int j = 0;
    while (j < k)
    {
      int m = paramContext.getIndex(j);
      switch (this$0.get(m))
      {
      default: 
        break;
      case 6: 
        w = paramContext.getFloat(m, w);
        break;
      case 5: 
        h = f.min(paramContext, m, h);
        break;
      case 4: 
        x = paramContext.getInt(m, 0);
        break;
      case 3: 
        if (peekValuetype == 3) {
          d = paramContext.getString(m);
        } else {
          d = v7.sufficientlysecure.transition.util.Configuration.w[paramContext.getInteger(m, 0)];
        }
        break;
      case 2: 
        e = paramContext.getInt(m, e);
        break;
      case 1: 
        y = paramContext.getFloat(m, y);
      }
      j += 1;
    }
    paramContext.recycle();
  }
}
