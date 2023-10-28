package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;

@VisibleForTesting
final class zzeg
  extends SQLiteOpenHelper
{
  zzeg(zzeh paramZzeh, Context paramContext, String paramString)
  {
    super(paramContext, "google_app_measurement_local.db", null, 1);
  }
  
  public final SQLiteDatabase getWritableDatabase()
    throws SQLiteException
  {
    try
    {
      localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      SQLiteDatabase localSQLiteDatabase;
      throw localSQLiteDatabaseLockedException;
    }
    catch (SQLiteException localSQLiteException2)
    {
      for (;;) {}
    }
    database.this$0.zzay().iterator().append("Opening the local database failed, dropping and recreating it");
    database.this$0.append();
    if (!database.this$0.zzau().getDatabasePath("google_app_measurement_local.db").delete()) {
      database.this$0.zzay().iterator().append("Failed to delete corrupted local db file", "google_app_measurement_local.db");
    }
    try
    {
      localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException1)
    {
      database.this$0.zzay().iterator().append("Failed to open local database. Events will bypass local storage", localSQLiteException1);
      return null;
    }
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    zzan.extract(database.this$0.zzay(), paramSQLiteDatabase);
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    zzan.update(database.this$0.zzay(), paramSQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}
