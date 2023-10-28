package androidx.work.impl.asm;

import android.database.Cursor;
import androidx.room.Attribute;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.work.impl.n.d;

public final class e
  implements k
{
  private final b<d> j;
  private final RoomDatabase l;
  
  public e(RoomDatabase paramRoomDatabase)
  {
    l = paramRoomDatabase;
    j = new ByteVector(this, paramRoomDatabase);
  }
  
  public void a(Type paramType)
  {
    l.size();
    l.add();
    try
    {
      j.a(paramType);
      l.remove();
      l.clear();
      return;
    }
    catch (Throwable paramType)
    {
      l.clear();
      throw paramType;
    }
  }
  
  public Long getId(String paramString)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT long_value FROM Preference where `key`=?", 1);
    if (paramString == null) {
      localLog.bindNull(1);
    } else {
      localLog.bindString(1, paramString);
    }
    l.size();
    paramString = l;
    Object localObject = null;
    Cursor localCursor = androidx.room.core.Log.get(paramString, localLog, false, null);
    try
    {
      boolean bool = localCursor.moveToFirst();
      paramString = localObject;
      if (bool)
      {
        bool = localCursor.isNull(0);
        if (bool) {
          paramString = localObject;
        } else {
          paramString = Long.valueOf(localCursor.getLong(0));
        }
      }
      localCursor.close();
      localLog.release();
      return paramString;
    }
    catch (Throwable paramString)
    {
      localCursor.close();
      localLog.release();
      throw paramString;
    }
  }
}
