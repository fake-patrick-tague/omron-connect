package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseIntArray;

public class Plot
{
  private static SparseIntArray a;
  public float c = 0.0F;
  public boolean d = false;
  public float e = 0.0F;
  public float g = 0.0F;
  public float h = NaN.0F;
  public float i = 1.0F;
  public float j = 0.0F;
  public float k = 0.0F;
  public float m = NaN.0F;
  public float n = 0.0F;
  public boolean p = false;
  public float r = 0.0F;
  public float s = 1.0F;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    a = localSparseIntArray;
    localSparseIntArray.append(R.styleable.NONE, 1);
    a.append(R.styleable.ROW, 2);
    a.append(R.styleable.TOP, 3);
    a.append(R.styleable.BottomSheet_bs_numColumns, 4);
    a.append(R.styleable.BottomSheet_bs_titleTextAppearance, 5);
    a.append(R.styleable.SDK_INT, 6);
    a.append(R.styleable.SeekBarPreference_maxValue, 7);
    a.append(R.styleable.BottomSheet_bs_listStyle, 8);
    a.append(R.styleable.nnf_button_cancel, 9);
    a.append(R.styleable.g, 10);
    a.append(R.styleable.CalendarView_weekDayTextAppearance, 11);
  }
  
  public Plot() {}
  
  void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DatePickerDialog);
    d = true;
    int i2 = paramContext.getIndexCount();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramContext.getIndex(i1);
      switch (a.get(i3))
      {
      default: 
        break;
      case 11: 
        if (Build.VERSION.SDK_INT >= 21)
        {
          p = true;
          c = paramContext.getDimension(i3, c);
        }
        break;
      case 10: 
        if (Build.VERSION.SDK_INT >= 21) {
          k = paramContext.getDimension(i3, k);
        }
        break;
      case 9: 
        j = paramContext.getDimension(i3, j);
        break;
      case 8: 
        n = paramContext.getDimension(i3, n);
        break;
      case 7: 
        m = paramContext.getDimension(i3, m);
        break;
      case 6: 
        h = paramContext.getDimension(i3, h);
        break;
      case 5: 
        i = paramContext.getFloat(i3, i);
        break;
      case 4: 
        s = paramContext.getFloat(i3, s);
        break;
      case 3: 
        e = paramContext.getFloat(i3, e);
        break;
      case 2: 
        g = paramContext.getFloat(i3, g);
        break;
      case 1: 
        r = paramContext.getFloat(i3, r);
      }
      i1 += 1;
    }
    paramContext.recycle();
  }
  
  public void a(Plot paramPlot)
  {
    d = d;
    r = r;
    g = g;
    e = e;
    s = s;
    i = i;
    h = h;
    m = m;
    n = n;
    j = j;
    k = k;
    p = p;
    c = c;
  }
}
