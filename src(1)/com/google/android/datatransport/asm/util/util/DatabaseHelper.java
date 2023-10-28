package com.google.android.datatransport.asm.util.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;

final class DatabaseHelper
  extends SQLiteOpenHelper
{
  private static final String TABLE_ACCOUNTS;
  static int b;
  private static final t0.a c;
  private static final t0.a context;
  private static final t0.a g;
  private static final t0.a h;
  private static final t0.a lock;
  private static final List<com.google.android.datatransport.h.y.j.t0.a> m;
  private final int app;
  private boolean done = false;
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("INSERT INTO global_log_event_state VALUES (");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(")");
    TABLE_ACCOUNTS = ((StringBuilder)localObject).toString();
    b = 5;
    localObject = Edge.c;
    c = (t0.a)localObject;
    FlurryAdSize localFlurryAdSize = FlurryAdSize.BANNER_TOP;
    context = localFlurryAdSize;
    Level localLevel = Level.I;
    lock = localLevel;
    Target localTarget = Target.a;
    g = localTarget;
    ChildNumber localChildNumber = ChildNumber.ONE;
    h = localChildNumber;
    m = Arrays.asList(new t0.a[] { localObject, localFlurryAdSize, localLevel, localTarget, localChildNumber });
  }
  
  DatabaseHelper(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
    app = paramInt;
  }
  
  private void close(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!done) {
      onConfigure(paramSQLiteDatabase);
    }
  }
  
  private void copy(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    List localList = m;
    if (paramInt2 <= localList.size())
    {
      while (paramInt1 < paramInt2)
      {
        ((t0.a)m.get(paramInt1)).onCreate(paramSQLiteDatabase);
        paramInt1 += 1;
      }
      return;
    }
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("Migration from ");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(" to ");
    paramSQLiteDatabase.append(paramInt2);
    paramSQLiteDatabase.append(" was requested, but cannot be performed. Only ");
    paramSQLiteDatabase.append(localList.size());
    paramSQLiteDatabase.append(" migrations are provided");
    throw new IllegalArgumentException(paramSQLiteDatabase.toString());
  }
  
  private void onCreate(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    close(paramSQLiteDatabase);
    copy(paramSQLiteDatabase, 0, paramInt);
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    done = true;
    paramSQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
    if (Build.VERSION.SDK_INT >= 16) {
      paramSQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    onCreate(paramSQLiteDatabase, app);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE events");
    paramSQLiteDatabase.execSQL("DROP TABLE event_metadata");
    paramSQLiteDatabase.execSQL("DROP TABLE transport_contexts");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
    onCreate(paramSQLiteDatabase, paramInt2);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    close(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    close(paramSQLiteDatabase);
    copy(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}
