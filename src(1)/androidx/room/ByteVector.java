package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;
import v7.td.data.Item;

public abstract class ByteVector
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  private final RoomDatabase b;
  private volatile Item n;
  
  public ByteVector(RoomDatabase paramRoomDatabase)
  {
    b = paramRoomDatabase;
  }
  
  private Item a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (n == null) {
        n = read();
      }
      return n;
    }
    return read();
  }
  
  private Item read()
  {
    String str = getSize();
    return b.get(str);
  }
  
  public void a(Item paramItem)
  {
    if (paramItem == n) {
      a.set(false);
    }
  }
  
  public Item get()
  {
    put();
    return a(a.compareAndSet(false, true));
  }
  
  protected abstract String getSize();
  
  protected void put()
  {
    b.removeFirst();
  }
}
