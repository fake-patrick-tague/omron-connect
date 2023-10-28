package androidx.work.impl.utils;

import androidx.room.RoomDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.i;
import androidx.work.impl.f;
import java.util.Iterator;
import java.util.List;

class e
  extends c
{
  e(f paramF, String paramString, boolean paramBoolean) {}
  
  void a()
  {
    WorkDatabase localWorkDatabase = d.a();
    localWorkDatabase.add();
    try
    {
      Iterator localIterator = localWorkDatabase.a().write(a).iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        String str = (String)localIterator.next();
        a(d, str);
      }
      localWorkDatabase.remove();
      localWorkDatabase.clear();
      if (f)
      {
        a(d);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localWorkDatabase.clear();
      throw localThrowable;
    }
  }
}
