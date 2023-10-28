package androidx.room;

import v7.td.data.Item;

public abstract class Attribute<T>
  extends n
{
  public Attribute(RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public final void a(Object paramObject)
  {
    Item localItem = get();
    try
    {
      a(localItem, paramObject);
      localItem.executeInsert();
      a(localItem);
      return;
    }
    catch (Throwable paramObject)
    {
      a(localItem);
      throw paramObject;
    }
  }
  
  protected abstract void a(Item paramItem, Object paramObject);
}
