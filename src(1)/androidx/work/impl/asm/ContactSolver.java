package androidx.work.impl.asm;

import androidx.room.ByteVector;
import androidx.room.RoomDatabase;

class ContactSolver
  extends ByteVector
{
  ContactSolver(ClassWriter paramClassWriter, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public String getSize()
  {
    return "DELETE FROM SystemIdInfo where work_spec_id=?";
  }
}
