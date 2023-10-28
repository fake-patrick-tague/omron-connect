package androidx.work.impl.utils;

import androidx.work.WorkInfo.State;
import androidx.work.b;
import androidx.work.impl.ClassWriter;
import androidx.work.impl.Log;
import androidx.work.impl.Pair;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.Item;
import androidx.work.impl.asm.i;
import androidx.work.impl.f;
import androidx.work.impl.l;
import androidx.work.l.b.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class c
  implements Runnable
{
  private final Pair c = new Pair();
  
  public c() {}
  
  public static c a(String paramString, f paramF)
  {
    return new x(paramF, paramString);
  }
  
  public static c a(String paramString, f paramF, boolean paramBoolean)
  {
    return new e(paramF, paramString, paramBoolean);
  }
  
  public static c a(UUID paramUUID, f paramF)
  {
    return new w(paramF, paramUUID);
  }
  
  private void a(WorkDatabase paramWorkDatabase, String paramString)
  {
    i localI = paramWorkDatabase.a();
    paramWorkDatabase = paramWorkDatabase.b();
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    while (!localLinkedList.isEmpty())
    {
      paramString = (String)localLinkedList.remove();
      WorkInfo.State localState = localI.get(paramString);
      if ((localState != WorkInfo.State.i) && (localState != WorkInfo.State.d)) {
        localI.a(WorkInfo.State.c, new String[] { paramString });
      }
      localLinkedList.addAll(paramWorkDatabase.a(paramString));
    }
  }
  
  abstract void a();
  
  void a(f paramF)
  {
    Log.a(paramF.b(), paramF.a(), paramF.d());
  }
  
  void a(f paramF, String paramString)
  {
    a(paramF.a(), paramString);
    paramF.get().add(paramString);
    paramF = paramF.d().iterator();
    while (paramF.hasNext()) {
      ((l)paramF.next()).a(paramString);
    }
  }
  
  public b b()
  {
    return c;
  }
  
  public void run()
  {
    try
    {
      a();
      c.add(b.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.add(new l.b.a(localThrowable));
    }
  }
}
