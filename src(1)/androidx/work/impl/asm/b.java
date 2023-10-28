package androidx.work.impl.asm;

import android.database.Cursor;
import androidx.room.Attribute;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements l
{
  private final androidx.room.b<androidx.work.impl.n.j> a;
  private final RoomDatabase c;
  
  public b(RoomDatabase paramRoomDatabase)
  {
    c = paramRoomDatabase;
    a = new AnnotationWriter(this, paramRoomDatabase);
  }
  
  public void a(j paramJ)
  {
    c.size();
    c.add();
    try
    {
      a.a(paramJ);
      c.remove();
      c.clear();
      return;
    }
    catch (Throwable paramJ)
    {
      c.clear();
      throw paramJ;
    }
  }
  
  public List write(String paramString)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT name FROM workname WHERE work_spec_id=?", 1);
    if (paramString == null) {
      localLog.bindNull(1);
    } else {
      localLog.bindString(1, paramString);
    }
    c.size();
    paramString = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      ArrayList localArrayList = new ArrayList(paramString.getCount());
      for (;;)
      {
        boolean bool = paramString.moveToNext();
        if (!bool) {
          break;
        }
        localArrayList.add(paramString.getString(0));
      }
      paramString.close();
      localLog.release();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      paramString.close();
      localLog.release();
      throw localThrowable;
    }
  }
}
