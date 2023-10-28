package androidx.work.impl.asm;

import androidx.room.ByteVector;
import androidx.room.RoomDatabase;

class NumberPicker
  extends ByteVector
{
  NumberPicker(f paramF, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public String getSize()
  {
    return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
  }
}
