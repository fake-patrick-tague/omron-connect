package androidx.room;

import android.database.Cursor;
import java.util.Iterator;
import java.util.List;
import v7.td.data.Context;
import v7.td.data.Database;
import v7.td.data.d;

public class MethodWriter
  extends Database
{
  private final String b;
  private final String c;
  private a j;
  private final f l;
  
  public MethodWriter(a paramA, f paramF, String paramString1, String paramString2)
  {
    super(a);
    j = paramA;
    l = paramF;
    c = paramString1;
    b = paramString2;
  }
  
  private void b(Context paramContext)
  {
    if (exists(paramContext))
    {
      localItem = null;
      Cursor localCursor = paramContext.query(new d("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
      try
      {
        boolean bool = localCursor.moveToFirst();
        paramContext = localItem;
        if (bool) {
          paramContext = localCursor.getString(0);
        }
        localCursor.close();
        if (c.equals(paramContext)) {
          return;
        }
        if (b.equals(paramContext)) {
          return;
        }
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
      }
      catch (Throwable paramContext)
      {
        localCursor.close();
        throw paramContext;
      }
    }
    Item localItem = l.add(paramContext);
    if (a)
    {
      l.p(paramContext);
      c(paramContext);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("Pre-packaged database has an invalid schema: ");
    paramContext.append(b);
    throw new IllegalStateException(paramContext.toString());
  }
  
  private void c(Context paramContext)
  {
    delete(paramContext);
    paramContext.execSQL(Resources.toString(c));
  }
  
  private void delete(Context paramContext)
  {
    paramContext.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
  }
  
  private static boolean exists(Context paramContext)
  {
    paramContext = paramContext.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
    try
    {
      boolean bool3 = paramContext.moveToFirst();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        int i = paramContext.getInt(0);
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
      paramContext.close();
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      paramContext.close();
      throw localThrowable;
    }
  }
  
  private static boolean f(Context paramContext)
  {
    paramContext = paramContext.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
    try
    {
      boolean bool3 = paramContext.moveToFirst();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        int i = paramContext.getInt(0);
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      paramContext.close();
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      paramContext.close();
      throw localThrowable;
    }
  }
  
  public void a(Context paramContext)
  {
    boolean bool = f(paramContext);
    l.clear(paramContext);
    if (!bool)
    {
      Item localItem = l.add(paramContext);
      if (!a)
      {
        paramContext = new StringBuilder();
        paramContext.append("Pre-packaged database has an invalid schema: ");
        paramContext.append(b);
        throw new IllegalStateException(paramContext.toString());
      }
    }
    c(paramContext);
    l.c(paramContext);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject = j;
    if (localObject != null)
    {
      localObject = b.getText(paramInt1, paramInt2);
      if (localObject != null)
      {
        l.i(paramContext);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((androidx.room.asm.Item)((Iterator)localObject).next()).initialize(paramContext);
        }
        localObject = l.add(paramContext);
        if (a)
        {
          l.p(paramContext);
          c(paramContext);
          i = 1;
          break label149;
        }
        paramContext = new StringBuilder();
        paramContext.append("Migration didn't properly handle: ");
        paramContext.append(b);
        throw new IllegalStateException(paramContext.toString());
      }
    }
    int i = 0;
    label149:
    if (i == 0)
    {
      localObject = j;
      if ((localObject != null) && (!((a)localObject).a(paramInt1, paramInt2)))
      {
        l.b(paramContext);
        l.clear(paramContext);
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("A migration from ");
      paramContext.append(paramInt1);
      paramContext.append(" to ");
      paramContext.append(paramInt2);
      paramContext.append(" was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
      throw new IllegalStateException(paramContext.toString());
    }
  }
  
  public void d(Context paramContext)
  {
    super.d(paramContext);
    b(paramContext);
    l.d(paramContext);
    j = null;
  }
  
  public void onUpgrade(Context paramContext)
  {
    super.onUpgrade(paramContext);
  }
  
  public void onUpgrade(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2);
  }
}
