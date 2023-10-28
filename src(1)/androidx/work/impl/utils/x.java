package androidx.work.impl.utils;

import androidx.room.RoomDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.i;
import androidx.work.impl.f;
import java.util.Iterator;
import java.util.List;

class x
  extends c
{
  x(f paramF, String paramString) {}
  
  void a()
  {
    WorkDatabase localWorkDatabase = d.a();
    localWorkDatabase.add();
    try
    {
      Iterator localIterator = localWorkDatabase.a().getSeasons(c).iterator();
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
      a(d);
      return;
    }
    catch (Throwable localThrowable)
    {
      localWorkDatabase.clear();
      throw localThrowable;
    }
  }
}
