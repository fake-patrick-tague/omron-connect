package androidx.work.impl.ui.menu;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.NetworkType;
import androidx.work.i;
import androidx.work.impl.m.b;
import androidx.work.impl.m.e.c;
import androidx.work.impl.ui.Handle;
import androidx.work.impl.utils.asm.f;

public class o
  extends c<b>
{
  public o(Context paramContext, f paramF)
  {
    super(androidx.work.impl.ui.views.h.a(paramContext, paramF).j());
  }
  
  boolean a(androidx.work.impl.asm.h paramH)
  {
    return (b.p() == NetworkType.a) || ((Build.VERSION.SDK_INT >= 30) && (b.p() == NetworkType.b));
  }
  
  boolean a(Handle paramHandle)
  {
    return (!paramHandle.equals()) || (paramHandle.getName());
  }
}
