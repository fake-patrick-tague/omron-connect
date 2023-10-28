package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import c.h.p.d;
import v7.v7.util.Position;

public final class Label
{
  private static final ThreadLocal<d<Rect, Rect>> d = new ThreadLocal();
  
  public static boolean a(Paint paramPaint, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return b.a(paramPaint, paramString);
    }
    int k = paramString.length();
    if ((k == 1) && (Character.isWhitespace(paramString.charAt(0)))) {
      return true;
    }
    float f2 = paramPaint.measureText("?");
    float f4 = paramPaint.measureText("m");
    float f3 = paramPaint.measureText(paramString);
    float f1 = 0.0F;
    if (f3 == 0.0F) {
      return false;
    }
    if (paramString.codePointCount(0, paramString.length()) > 1)
    {
      if (f3 > f4 * 2.0F) {
        return false;
      }
      int j;
      for (int i = 0; i < k; i = j)
      {
        j = Character.charCount(paramString.codePointAt(i)) + i;
        f1 += paramPaint.measureText(paramString, i, j);
      }
      if (f3 >= f1) {
        return false;
      }
    }
    if (f3 != f2) {
      return true;
    }
    Position localPosition = equals();
    paramPaint.getTextBounds("?", 0, 2, (Rect)a);
    paramPaint.getTextBounds(paramString, 0, k, (Rect)x);
    return ((Rect)a).equals(x) ^ true;
  }
  
  private static Position equals()
  {
    ThreadLocal localThreadLocal = d;
    Position localPosition = (Position)localThreadLocal.get();
    if (localPosition == null)
    {
      localPosition = new Position(new Rect(), new Rect());
      localThreadLocal.set(localPosition);
      return localPosition;
    }
    ((Rect)a).setEmpty();
    ((Rect)x).setEmpty();
    return localPosition;
  }
}
