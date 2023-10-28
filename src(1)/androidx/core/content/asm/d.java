package androidx.core.content.asm;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

public abstract class d
{
  public d() {}
  
  public static Handler a(Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    return localHandler;
  }
  
  public final void a(int paramInt, Handler paramHandler)
  {
    a(paramHandler).post(new b(this, paramInt));
  }
  
  public final void a(Typeface paramTypeface, Handler paramHandler)
  {
    a(paramHandler).post(new Plot.a(this, paramTypeface));
  }
  
  public abstract void b(int paramInt);
  
  public abstract void b(Typeface paramTypeface);
}
