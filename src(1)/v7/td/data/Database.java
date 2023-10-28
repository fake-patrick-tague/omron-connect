package v7.td.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public abstract class Database
{
  public final int name;
  
  public Database(int paramInt)
  {
    name = paramInt;
  }
  
  private void create(String paramString)
  {
    if (!paramString.equalsIgnoreCase(":memory:"))
    {
      if (paramString.trim().length() == 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleting the database file: ");
      localStringBuilder.append(paramString);
      Log.w("SupportSQLite", localStringBuilder.toString());
      if (Build.VERSION.SDK_INT >= 16) {}
      try
      {
        SQLiteDatabase.deleteDatabase(new File(paramString));
        return;
      }
      catch (Exception paramString)
      {
        boolean bool;
        Log.w("SupportSQLite", "delete failed: ", paramString);
      }
      try
      {
        bool = new File(paramString).delete();
        if (!bool)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Could not delete the database file ");
          localStringBuilder.append(paramString);
          Log.e("SupportSQLite", localStringBuilder.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        Log.e("SupportSQLite", "error while deleting corrupted database file", paramString);
        return;
      }
    }
  }
  
  public abstract void a(Context paramContext);
  
  public abstract void a(Context paramContext, int paramInt1, int paramInt2);
  
  public void d(Context paramContext) {}
  
  public void onUpgrade(Context paramContext) {}
  
  public abstract void onUpgrade(Context paramContext, int paramInt1, int paramInt2);
  
  public void toString(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Corruption reported by sqlite on database: ");
    ((StringBuilder)localObject).append(paramContext.getPath());
    Log.e("SupportSQLite", ((StringBuilder)localObject).toString());
    if (!paramContext.isOpen())
    {
      create(paramContext.getPath());
      return;
    }
    localObject = null;
    Throwable localThrowable2 = null;
    try
    {
      try
      {
        List localList = paramContext.getAttachedDbs();
        localObject = localList;
      }
      catch (Throwable localThrowable1)
      {
        break label89;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;) {}
    }
    localThrowable2 = localThrowable1;
    try
    {
      paramContext.close();
    }
    catch (IOException localIOException)
    {
      label89:
      for (;;) {}
    }
    if (localThrowable2 != null)
    {
      paramContext = localThrowable2.iterator();
      while (paramContext.hasNext()) {
        create((String)nextsecond);
      }
    }
    create(paramContext.getPath());
    throw localThrowable1;
    if (localThrowable1 != null)
    {
      paramContext = localThrowable1.iterator();
      while (paramContext.hasNext()) {
        create((String)nextsecond);
      }
    }
    create(paramContext.getPath());
    return;
  }
}
