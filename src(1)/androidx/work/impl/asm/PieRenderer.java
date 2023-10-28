package androidx.work.impl.asm;

import androidx.room.ByteVector;
import androidx.room.RoomDatabase;

class PieRenderer
  extends ByteVector
{
  PieRenderer(f paramF, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public String getSize()
  {
    return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
  }
}
