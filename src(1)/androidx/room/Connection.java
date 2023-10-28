package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import v7.support.v7.asm.f;
import v7.td.data.Context;
import v7.td.data.Item;
import v7.td.data.d;

class Connection
  implements Runnable
{
  Connection(i paramI) {}
  
  private Set search()
  {
    HashSet localHashSet = new HashSet();
    Cursor localCursor = c.a.query(new d("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
    try
    {
      for (;;)
      {
        boolean bool = localCursor.moveToNext();
        if (!bool) {
          break;
        }
        localHashSet.add(Integer.valueOf(localCursor.getInt(0)));
      }
      localCursor.close();
      if (!localHashSet.isEmpty())
      {
        c.g.executeUpdateDelete();
        return localHashSet;
      }
    }
    catch (Throwable localThrowable)
    {
      localCursor.close();
      throw localThrowable;
    }
    return localThrowable;
  }
  
  public void run()
  {
    Object localObject1 = c;
    Object localObject4 = this;
    Lock localLock = a.containsKey();
    Object localObject6 = null;
    Object localObject7 = null;
    Set localSet = null;
    Object localObject3 = localObject6;
    localObject1 = localObject7;
    try
    {
      localLock.lock();
      Object localObject8 = c;
      localObject3 = localObject6;
      localObject1 = localObject7;
      boolean bool = ((i)localObject8).add();
      if (!bool)
      {
        localLock.unlock();
        return;
      }
      localObject1 = c;
      localObject8 = c;
      localObject3 = localObject6;
      localObject1 = localObject7;
      bool = ((AtomicBoolean)localObject8).compareAndSet(true, false);
      if (!bool)
      {
        localLock.unlock();
        return;
      }
      localObject1 = c;
      localObject8 = a;
      localObject3 = localObject6;
      localObject1 = localObject7;
      bool = ((RoomDatabase)localObject8).close();
      if (bool)
      {
        localLock.unlock();
        return;
      }
      localObject1 = c;
      localObject8 = localObject4;
      localObject4 = a;
      bool = d;
      if (bool)
      {
        localObject3 = localObject6;
        localObject1 = localObject7;
        Context localContext = ((RoomDatabase)localObject4).getParent().getWritableDatabase();
        localObject3 = localObject6;
        localObject1 = localObject7;
        localContext.beginTransaction();
        localObject4 = localSet;
        try
        {
          localSet = ((Connection)localObject8).search();
          localObject4 = localSet;
          localContext.setTransactionSuccessful();
          localObject3 = localSet;
          localObject1 = localSet;
          localContext.endTransaction();
        }
        catch (Throwable localThrowable3)
        {
          localObject3 = localObject4;
          localObject1 = localObject4;
          localContext.endTransaction();
          localObject3 = localObject4;
          localObject1 = localObject4;
          throw localThrowable3;
        }
      }
      else
      {
        localObject3 = localObject6;
        localObject1 = localObject7;
        localObject5 = ((Connection)localObject8).search();
      }
    }
    catch (Throwable localThrowable1)
    {
      break label396;
    }
    catch (SQLiteException localSQLiteException)
    {
      localObject2 = localObject3;
      localObject3 = localSQLiteException;
    }
    catch (IllegalStateException localIllegalStateException) {}
    android.util.Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", (Throwable)localIllegalStateException);
    Object localObject5 = localObject2;
    Object localObject2 = this;
    localLock.unlock();
    if ((localObject5 != null) && (!((Set)localObject5).isEmpty()))
    {
      f localF = c.b;
      try
      {
        localObject2 = c.b.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((h)((Map.Entry)((Iterator)localObject2).next()).getValue()).a((Set)localObject5);
        }
        return;
      }
      catch (Throwable localThrowable2)
      {
        throw localThrowable2;
      }
      label396:
      localLock.unlock();
      throw localThrowable2;
    }
  }
}
