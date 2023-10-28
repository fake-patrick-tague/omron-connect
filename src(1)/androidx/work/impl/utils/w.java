package androidx.work.impl.utils;

import androidx.room.RoomDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.f;
import java.util.UUID;

class w
  extends c
{
  w(f paramF, UUID paramUUID) {}
  
  void a()
  {
    WorkDatabase localWorkDatabase = c.a();
    localWorkDatabase.add();
    try
    {
      a(c, a.toString());
      localWorkDatabase.remove();
      localWorkDatabase.clear();
      a(c);
      return;
    }
    catch (Throwable localThrowable)
    {
      localWorkDatabase.clear();
      throw localThrowable;
    }
  }
}
