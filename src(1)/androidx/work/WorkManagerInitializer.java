package androidx.work;

import android.content.Context;
import androidx.startup.b;
import java.util.Collections;
import java.util.List;

public final class WorkManagerInitializer
  implements b<r>
{
  private static final String q = Log.getInstance("WrkMgrInitializer");
  
  public WorkManagerInitializer() {}
  
  public ExtensionData a(Context paramContext)
  {
    Log.get().append(q, "Initializing WorkManager with default configuration.", new Throwable[0]);
    ExtensionData.a(paramContext, new ClassWriter().a());
    return ExtensionData.b(paramContext);
  }
  
  public List getCandidates()
  {
    return Collections.emptyList();
  }
}
