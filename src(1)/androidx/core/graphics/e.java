package androidx.core.graphics;

import android.graphics.Typeface;
import androidx.core.content.asm.d;
import v7.v7.asm.k;

public class e
  extends k
{
  private d e;
  
  public e(d paramD)
  {
    e = paramD;
  }
  
  public void setTitle(int paramInt)
  {
    d localD = e;
    if (localD != null) {
      localD.b(paramInt);
    }
  }
  
  public void setTitle(Typeface paramTypeface)
  {
    d localD = e;
    if (localD != null) {
      localD.b(paramTypeface);
    }
  }
}
