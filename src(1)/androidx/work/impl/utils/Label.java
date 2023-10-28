package androidx.work.impl.utils;

import androidx.work.Handle;
import androidx.work.LayoutManager;
import androidx.work.Log;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.i;
import androidx.work.impl.foreground.Item;
import androidx.work.impl.utils.asm.f;
import java.util.UUID;

public class Label
  implements LayoutManager
{
  private static final String g = Log.getInstance("WMFgUpdater");
  private final f b;
  final i d;
  final Item h;
  
  public Label(WorkDatabase paramWorkDatabase, Item paramItem, f paramF)
  {
    h = paramItem;
    b = paramF;
    d = paramWorkDatabase.a();
  }
  
  public com.google.common.util.concurrent.Object a(android.content.Context paramContext, UUID paramUUID, Handle paramHandle)
  {
    androidx.work.impl.utils.futures.Context localContext = androidx.work.impl.utils.futures.Context.getInstance();
    b.get(new AsyncHttpClient.1(this, localContext, paramUUID, paramHandle, paramContext));
    return localContext;
  }
}
