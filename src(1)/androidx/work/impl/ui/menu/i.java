package androidx.work.impl.ui.menu;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.Log;
import androidx.work.NetworkType;
import androidx.work.impl.m.b;
import androidx.work.impl.m.e.c;
import androidx.work.impl.ui.Handle;
import androidx.work.impl.utils.asm.f;

public class i
  extends c<b>
{
  private static final String b = Log.getInstance("NetworkMeteredCtrlr");
  
  public i(Context paramContext, f paramF)
  {
    super(androidx.work.impl.ui.views.h.a(paramContext, paramF).j());
  }
  
  boolean a(androidx.work.impl.asm.h paramH)
  {
    return b.p() == NetworkType.r;
  }
  
  boolean a(Handle paramHandle)
  {
    if (Build.VERSION.SDK_INT < 26)
    {
      Log.get().append(b, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
      return paramHandle.equals() ^ true;
    }
    if (paramHandle.equals()) {
      return !paramHandle.getName();
    }
    return true;
  }
}
