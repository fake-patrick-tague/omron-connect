package androidx.work.impl.asm;

import androidx.room.ByteVector;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.work.impl.n.m;
import v7.td.data.Item;

public final class o
  implements n
{
  private final b<m> a;
  private final ByteVector b;
  private final RoomDatabase c;
  private final ByteVector d;
  
  public o(RoomDatabase paramRoomDatabase)
  {
    c = paramRoomDatabase;
    a = new MethodWriter(this, paramRoomDatabase);
    b = new a(this, paramRoomDatabase);
    d = new q(this, paramRoomDatabase);
  }
  
  public void a()
  {
    c.size();
    Item localItem = d.get();
    c.add();
    try
    {
      localItem.executeUpdateDelete();
      c.remove();
      c.clear();
      d.a(localItem);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.clear();
      d.a(localItem);
      throw localThrowable;
    }
  }
  
  public void a(String paramString)
  {
    c.size();
    Item localItem = b.get();
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
      b.a(localItem);
      return;
    }
    catch (Throwable paramString)
    {
      c.clear();
      b.a(localItem);
      throw paramString;
    }
  }
}
