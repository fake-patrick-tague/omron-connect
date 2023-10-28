package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.ExtensionData;
import androidx.work.File;
import androidx.work.Log;
import androidx.work.impl.workers.DiagnosticsWorker;

public class DiagnosticsReceiver
  extends BroadcastReceiver
{
  private static final String a = Log.getInstance("DiagnosticsRcvr");
  
  public DiagnosticsReceiver() {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    Log.get().append(a, "Requesting diagnostics", new Throwable[0]);
    try
    {
      ExtensionData.b(paramContext).a(File.d(DiagnosticsWorker.class));
      return;
    }
    catch (IllegalStateException paramContext)
    {
      Log.get().get(a, "WorkManager is not initialized", (Throwable[])new Throwable[] { paramContext });
    }
  }
}
