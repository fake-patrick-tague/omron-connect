package androidx.work.impl.asm;

import android.database.Cursor;
import androidx.room.ByteVector;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.room.core.Set;
import androidx.work.impl.n.g;
import java.util.ArrayList;
import java.util.List;
import v7.td.data.Item;

public final class ClassWriter
  implements Frame
{
  private final b<g> a;
  private final RoomDatabase c;
  private final ByteVector r;
  
  public ClassWriter(RoomDatabase paramRoomDatabase)
  {
    c = paramRoomDatabase;
    a = new p(this, paramRoomDatabase);
    r = new ContactSolver(this, paramRoomDatabase);
  }
  
  public void a(Attribute paramAttribute)
  {
    c.size();
    c.add();
    try
    {
      a.a(paramAttribute);
      c.remove();
      c.clear();
      return;
    }
    catch (Throwable paramAttribute)
    {
      c.clear();
      throw paramAttribute;
    }
  }
  
  public void a(String paramString)
  {
    c.size();
    Item localItem = r.get();
    if (paramString == null) {
      localItem.bindNull(1);
    } else {
      localItem.bindString(1, paramString);
    }
    c.add();
    try
    {
      localItem.executeUpdateDelete();
      c.remove();
      c.clear();
      r.a(localItem);
      return;
    }
    catch (Throwable paramString)
    {
      c.clear();
      r.a(localItem);
      throw paramString;
    }
  }
  
  public Attribute get(String paramString)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
    if (paramString == null) {
      localLog.bindNull(1);
    } else {
      localLog.bindString(1, paramString);
    }
    c.size();
    java.lang.Object localObject = c;
    paramString = null;
    localObject = androidx.room.core.Log.get((RoomDatabase)localObject, localLog, false, null);
    try
    {
      int i = Set.getValue((Cursor)localObject, "work_spec_id");
      int j = Set.getValue((Cursor)localObject, "system_id");
      boolean bool = ((Cursor)localObject).moveToFirst();
      if (bool) {
        paramString = new Attribute(((Cursor)localObject).getString(i), ((Cursor)localObject).getInt(j));
      }
      ((Cursor)localObject).close();
      localLog.release();
      return paramString;
    }
    catch (Throwable paramString)
    {
      ((Cursor)localObject).close();
      localLog.release();
      throw paramString;
    }
  }
  
  public List get()
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
    c.size();
    Cursor localCursor = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      for (;;)
      {
        boolean bool = localCursor.moveToNext();
        if (!bool) {
          break;
        }
        localArrayList.add(localCursor.getString(0));
      }
      localCursor.close();
      localLog.release();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      localCursor.close();
      localLog.release();
      throw localThrowable;
    }
  }
}
