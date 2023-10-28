package androidx.work.impl.ui.menu;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.Log;
import androidx.work.NetworkType;
import androidx.work.i;
import androidx.work.impl.m.b;
import androidx.work.impl.m.e.c;
import androidx.work.impl.ui.Handle;

public class f
  extends c<b>
{
  private static final String b = Log.getInstance("NetworkNotRoamingCtrlr");
  
  public f(Context paramContext, androidx.work.impl.utils.asm.f paramF)
  {
    super(androidx.work.impl.ui.views.h.a(paramContext, paramF).j());
  }
  
  boolean a(androidx.work.impl.asm.h paramH)
  {
    return b.p() == NetworkType.d;
  }
  
  boolean a(Handle paramHandle)
  {
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.get().append(b, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
      return paramHandle.equals() ^ true;
    }
    if (paramHandle.equals()) {
      return !paramHandle.a();
    }
    return true;
  }
}
