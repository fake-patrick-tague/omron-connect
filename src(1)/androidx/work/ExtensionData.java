package androidx.work;

import android.content.Context;
import java.util.Collections;
import java.util.List;

public abstract class ExtensionData
{
  protected ExtensionData() {}
  
  public static void a(Context paramContext, f paramF)
  {
    androidx.work.impl.f.a(paramContext, paramF);
  }
  
  public static ExtensionData b(Context paramContext)
  {
    return androidx.work.impl.f.a(paramContext);
  }
  
  public final b a(h paramH)
  {
    return a(Collections.singletonList(paramH));
  }
  
  public abstract b a(String paramString);
  
  public abstract b a(List paramList);
  
  public abstract com.google.common.util.concurrent.Object b(String paramString);
}
