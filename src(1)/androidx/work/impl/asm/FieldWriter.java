package androidx.work.impl.asm;

import androidx.room.ByteVector;
import androidx.room.RoomDatabase;

class FieldWriter
  extends ByteVector
{
  FieldWriter(f paramF, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public String getSize()
  {
    return "UPDATE workspec SET period_start_time=? WHERE id=?";
  }
}
