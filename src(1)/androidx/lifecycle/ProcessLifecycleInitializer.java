package androidx.lifecycle;

import android.content.Context;
import androidx.startup.b;
import androidx.startup.f;
import java.util.Collections;
import java.util.List;

public final class ProcessLifecycleInitializer
  implements b<m>
{
  public ProcessLifecycleInitializer() {}
  
  public d a(Context paramContext)
  {
    if (f.a(paramContext).add(ProcessLifecycleInitializer.class))
    {
      NotificationManager.init(paramContext);
      Tracker.send(paramContext);
      return Tracker.equals();
    }
    throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
  }
  
  public List getCandidates()
  {
    return Collections.emptyList();
  }
}
