package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextPaint;

public final class BubbleTextView
  extends x
{
  private static Paint mBackground;
  
  public BubbleTextView(i paramI)
  {
    super(paramI);
  }
  
  private static Paint init()
  {
    if (mBackground == null)
    {
      TextPaint localTextPaint = new TextPaint();
      mBackground = localTextPaint;
      localTextPaint.setColor(ClassWriter.get().newUTF8());
      mBackground.setStyle(Paint.Style.FILL);
    }
    return mBackground;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    if (ClassWriter.get().d()) {
      paramCanvas.drawRect(paramFloat, paramInt3, paramFloat + getCount(), paramInt5, init());
    }
    a().a(paramCanvas, paramFloat, paramInt4, paramPaint);
  }
}
