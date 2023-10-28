package androidx.work.impl.asm;

import android.database.Cursor;
import androidx.room.Attribute;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.work.impl.n.a;
import java.util.ArrayList;
import java.util.List;

public final class g
  implements Item
{
  private final b<a> a;
  private final RoomDatabase c;
  
  public g(RoomDatabase paramRoomDatabase)
  {
    c = paramRoomDatabase;
    a = new d(this, paramRoomDatabase);
  }
  
  public List a(String paramString)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
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
  
  public void a(x paramX)
  {
    c.size();
    c.add();
    try
    {
      a.a(paramX);
      c.remove();
      c.clear();
      return;
    }
    catch (Throwable paramX)
    {
      c.clear();
      throw paramX;
    }
  }
  
  public boolean save(String paramString)
  {
    boolean bool2 = true;
    androidx.room.Log localLog = androidx.room.Log.get("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
    if (paramString == null) {
      localLog.bindNull(1);
    } else {
      localLog.bindString(1, paramString);
    }
    c.size();
    paramString = c;
    boolean bool1 = false;
    paramString = androidx.room.core.Log.get(paramString, localLog, false, null);
    try
    {
      boolean bool3 = paramString.moveToFirst();
      if (bool3)
      {
        int i = paramString.getInt(0);
        if (i != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      paramString.close();
      localLog.release();
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      paramString.close();
      localLog.release();
      throw localThrowable;
    }
  }
  
  public boolean write(String paramString)
  {
    boolean bool2 = true;
    androidx.room.Log localLog = androidx.room.Log.get("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
    if (paramString == null) {
      localLog.bindNull(1);
    } else {
      localLog.bindString(1, paramString);
    }
    c.size();
    paramString = c;
    boolean bool1 = false;
    paramString = androidx.room.core.Log.get(paramString, localLog, false, null);
    try
    {
      boolean bool3 = paramString.moveToFirst();
      if (bool3)
      {
        int i = paramString.getInt(0);
        if (i != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      paramString.close();
      localLog.release();
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      paramString.close();
      localLog.release();
      throw localThrowable;
    }
  }
}
