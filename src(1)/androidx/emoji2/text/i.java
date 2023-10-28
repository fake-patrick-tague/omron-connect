package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.asm.Attribute;
import androidx.emoji2.text.q.a;

public class i
{
  private static final ThreadLocal<a> t = new ThreadLocal();
  private final h b;
  private final int d;
  private volatile int h = 0;
  
  i(h paramH, int paramInt)
  {
    b = paramH;
    d = paramInt;
  }
  
  private androidx.emoji2.text.asm.i a()
  {
    ThreadLocal localThreadLocal = t;
    androidx.emoji2.text.asm.i localI2 = (androidx.emoji2.text.asm.i)localThreadLocal.get();
    androidx.emoji2.text.asm.i localI1 = localI2;
    if (localI2 == null)
    {
      localI1 = new androidx.emoji2.text.asm.i();
      localThreadLocal.set(localI1);
    }
    b.b().a(localI1, d);
    return localI1;
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    Typeface localTypeface1 = b.n();
    Typeface localTypeface2 = paramPaint.getTypeface();
    paramPaint.setTypeface(localTypeface1);
    int i = d;
    paramCanvas.drawText(b.j(), i * 2, 2, paramFloat1, paramFloat2, paramPaint);
    paramPaint.setTypeface(localTypeface2);
  }
  
  public int add()
  {
    return a().a();
  }
  
  public short b()
  {
    return a().c();
  }
  
  public void b(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    h = i;
  }
  
  public boolean c()
  {
    return a().f();
  }
  
  public short close()
  {
    return a().b();
  }
  
  public int d()
  {
    return h;
  }
  
  public int e()
  {
    return a().e();
  }
  
  public int e(int paramInt)
  {
    return a().c(paramInt);
  }
  
  public short i()
  {
    return a().add();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", id:");
    localStringBuilder.append(Integer.toHexString(e()));
    localStringBuilder.append(", codepoints:");
    int j = add();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(Integer.toHexString(e(i)));
      localStringBuilder.append(" ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}
