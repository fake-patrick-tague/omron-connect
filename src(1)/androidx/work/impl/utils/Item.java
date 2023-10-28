package androidx.work.impl.utils;

import androidx.work.WorkerParameters.a;
import androidx.work.impl.ClassWriter;
import androidx.work.impl.f;

public class Item
  implements Runnable
{
  private String a;
  private f d;
  private WorkerParameters.a i;
  
  public Item(f paramF, String paramString, WorkerParameters.a paramA)
  {
    d = paramF;
    a = paramString;
    i = paramA;
  }
  
  public void run()
  {
    d.get().a(a, i);
  }
}
