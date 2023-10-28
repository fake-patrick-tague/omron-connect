package androidx.emoji2.text;

import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;
import v7.v7.util.Log;

public abstract class x
  extends ReplacementSpan
{
  private float a = 1.0F;
  private final i b;
  private final Paint.FontMetricsInt data = new Paint.FontMetricsInt();
  private short n = -1;
  private short x = -1;
  
  x(i paramI)
  {
    Log.get(paramI, "metadata cannot be null");
    b = paramI;
  }
  
  public final i a()
  {
    return b;
  }
  
  final int getCount()
  {
    return n;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramPaint.getFontMetricsInt(data);
    paramPaint = data;
    a = (Math.abs(descent - ascent) * 1.0F / b.close());
    x = ((short)(int)(b.close() * a));
    short s = (short)(int)(b.i() * a);
    n = s;
    if (paramFontMetricsInt != null)
    {
      paramPaint = data;
      ascent = ascent;
      descent = descent;
      top = top;
      bottom = bottom;
    }
    return s;
  }
}
