package androidx.emoji2.text;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.text.TextPaint;
import androidx.core.graphics.Label;

class k
  implements g
{
  private static final ThreadLocal<StringBuilder> chars = new ThreadLocal();
  private final TextPaint a;
  
  k()
  {
    TextPaint localTextPaint = new TextPaint();
    a = localTextPaint;
    localTextPaint.setTextSize(10.0F);
  }
  
  private static StringBuilder append()
  {
    ThreadLocal localThreadLocal = chars;
    if (localThreadLocal.get() == null) {
      localThreadLocal.set(new StringBuilder());
    }
    return (StringBuilder)localThreadLocal.get();
  }
  
  public boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i < 23) && (paramInt3 > i)) {
      return false;
    }
    StringBuilder localStringBuilder = append();
    localStringBuilder.setLength(0);
    while (paramInt1 < paramInt2)
    {
      localStringBuilder.append(paramCharSequence.charAt(paramInt1));
      paramInt1 += 1;
    }
    return Label.a(a, localStringBuilder.toString());
  }
}
