package androidx.work.impl.client.cache;

import androidx.work.Log;
import androidx.work.impl.asm.h;
import androidx.work.p;
import java.util.HashMap;
import java.util.Map;

public class ClassWriter
{
  static final String b = Log.getInstance("DelayedWorkTracker");
  final b c;
  private final Map<String, Runnable> m;
  private final p p;
  
  public ClassWriter(b paramB, p paramP)
  {
    c = paramB;
    p = paramP;
    m = new HashMap();
  }
  
  public void a(h paramH)
  {
    Object localObject = (Runnable)m.remove(a);
    if (localObject != null) {
      p.a((Runnable)localObject);
    }
    localObject = new Plot.a(this, paramH);
    m.put(a, localObject);
    long l1 = System.currentTimeMillis();
    long l2 = paramH.a();
    p.a(l2 - l1, (Runnable)localObject);
  }
  
  public void a(String paramString)
  {
    paramString = (Runnable)m.remove(paramString);
    if (paramString != null) {
      p.a(paramString);
    }
  }
}
