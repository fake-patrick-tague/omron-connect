package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import androidx.core.content.asm.d;
import java.lang.ref.WeakReference;

class Plot
  extends d
{
  Plot(TimePicker paramTimePicker, int paramInt1, int paramInt2, WeakReference paramWeakReference) {}
  
  public void b(int paramInt) {}
  
  public void b(Typeface paramTypeface)
  {
    Typeface localTypeface = paramTypeface;
    if (Build.VERSION.SDK_INT >= 28)
    {
      int i = c;
      localTypeface = paramTypeface;
      if (i != -1)
      {
        boolean bool;
        if ((d & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        localTypeface = Paint.get(paramTypeface, i, bool);
      }
    }
    e.update(a, localTypeface);
  }
}
