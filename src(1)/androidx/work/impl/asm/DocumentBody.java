package androidx.work.impl.asm;

import android.database.Cursor;
import androidx.room.Attribute;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.work.impl.n.s;
import java.util.ArrayList;
import java.util.List;

public final class DocumentBody
  implements Object
{
  private final b<s> a;
  private final RoomDatabase c;
  
  public DocumentBody(RoomDatabase paramRoomDatabase)
  {
    c = paramRoomDatabase;
    a = new w(this, paramRoomDatabase);
  }
  
  public List get(String paramString)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
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
  
  public void write(Segment paramSegment)
  {
    c.size();
    c.add();
    try
    {
      a.a(paramSegment);
      c.remove();
      c.clear();
      return;
    }
    catch (Throwable paramSegment)
    {
      c.clear();
      throw paramSegment;
    }
  }
}
