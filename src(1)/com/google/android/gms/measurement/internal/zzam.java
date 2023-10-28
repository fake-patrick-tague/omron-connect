package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzeg;
import com.google.android.gms.internal.measurement.zzeh;
import com.google.android.gms.internal.measurement.zzei;
import com.google.android.gms.internal.measurement.zzek;
import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzes;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzke;
import com.google.android.gms.internal.measurement.zzns;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzam
  extends zzkn
{
  private static final String[] CREATE_HITS_TABLE = { "last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;" };
  private static final String[] P;
  private static final String[] S = { "origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;" };
  private static final String[] data;
  private static final String[] filters = { "previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;" };
  private static final String[] receiver;
  private static final String[] result;
  private static final String[] s;
  private final zzkj mClock = new zzkj(this$0.zzav());
  private final zzal mDB;
  
  static
  {
    P = new String[] { "app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;" };
    s = new String[] { "realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;" };
    result = new String[] { "has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;" };
    data = new String[] { "session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;" };
    receiver = new String[] { "session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;" };
  }
  
  zzam(zzkz paramZzkz)
  {
    super(paramZzkz);
    this$0.append();
    mDB = new zzal(this, this$0.zzau(), "google_app_measurement.db");
  }
  
  private final long get(String paramString, String[] paramArrayOfString)
  {
    Object localObject = get();
    String[] arrayOfString2 = null;
    String[] arrayOfString1 = null;
    try
    {
      localObject = ((SQLiteDatabase)localObject).rawQuery(paramString, paramArrayOfString);
      paramArrayOfString = (String[])localObject;
      arrayOfString1 = paramArrayOfString;
      arrayOfString2 = paramArrayOfString;
      boolean bool = ((Cursor)localObject).moveToFirst();
      if (bool)
      {
        arrayOfString1 = paramArrayOfString;
        arrayOfString2 = paramArrayOfString;
        long l = ((Cursor)localObject).getLong(0);
        ((Cursor)localObject).close();
        return l;
      }
      arrayOfString1 = paramArrayOfString;
      arrayOfString2 = paramArrayOfString;
      throw new SQLiteException("Database returned empty set");
    }
    catch (Throwable paramString) {}catch (SQLiteException paramArrayOfString)
    {
      arrayOfString1 = arrayOfString2;
      this$0.zzay().iterator().append("Database error", paramString, paramArrayOfString);
      arrayOfString1 = arrayOfString2;
      throw paramArrayOfString;
    }
    if (arrayOfString1 != null) {
      arrayOfString1.close();
    }
    throw paramString;
  }
  
  static final void put(ContentValues paramContentValues, String paramString, Object paramObject)
  {
    Preconditions.checkNotEmpty("value");
    Preconditions.checkNotNull(paramObject);
    if ((paramObject instanceof String))
    {
      paramContentValues.put("value", (String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramContentValues.put("value", (Long)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramContentValues.put("value", (Double)paramObject);
      return;
    }
    throw new IllegalArgumentException("Invalid value type");
  }
  
  private final long zzaa(String paramString, String[] paramArrayOfString, long paramLong)
  {
    Object localObject = get();
    String[] arrayOfString2 = null;
    String[] arrayOfString1 = null;
    try
    {
      localObject = ((SQLiteDatabase)localObject).rawQuery(paramString, paramArrayOfString);
      paramArrayOfString = (String[])localObject;
      arrayOfString1 = paramArrayOfString;
      arrayOfString2 = paramArrayOfString;
      boolean bool = ((Cursor)localObject).moveToFirst();
      if (bool)
      {
        arrayOfString1 = paramArrayOfString;
        arrayOfString2 = paramArrayOfString;
        paramLong = ((Cursor)localObject).getLong(0);
        ((Cursor)localObject).close();
        return paramLong;
      }
      ((Cursor)localObject).close();
      return paramLong;
    }
    catch (Throwable paramString) {}catch (SQLiteException paramArrayOfString)
    {
      arrayOfString1 = arrayOfString2;
      this$0.zzay().iterator().append("Database error", paramString, paramArrayOfString);
      arrayOfString1 = arrayOfString2;
      throw paramArrayOfString;
    }
    if (arrayOfString1 != null) {
      arrayOfString1.close();
    }
    throw paramString;
  }
  
  public final void add(zzas paramZzas)
  {
    Preconditions.checkNotNull(paramZzas);
    append();
    size();
    Object localObject2 = new ContentValues();
    ((ContentValues)localObject2).put("app_id", code);
    ((ContentValues)localObject2).put("name", length);
    ((ContentValues)localObject2).put("lifetime_count", Long.valueOf(type));
    ((ContentValues)localObject2).put("current_bundle_count", Long.valueOf(nodeId));
    ((ContentValues)localObject2).put("last_fire_timestamp", Long.valueOf(index));
    ((ContentValues)localObject2).put("last_bundled_timestamp", Long.valueOf(date));
    ((ContentValues)localObject2).put("last_bundled_day", left);
    ((ContentValues)localObject2).put("last_sampled_complex_event_id", width);
    ((ContentValues)localObject2).put("last_sampling_rate", height);
    ((ContentValues)localObject2).put("current_session_count", Long.valueOf(name));
    Object localObject1 = top;
    if ((localObject1 != null) && (((Boolean)localObject1).booleanValue())) {
      localObject1 = Long.valueOf(1L);
    } else {
      localObject1 = null;
    }
    ((ContentValues)localObject2).put("last_exempt_from_sampling", (Long)localObject1);
    try
    {
      long l = get().insertWithOnConflict("events", null, (ContentValues)localObject2, 5);
      if (l == -1L)
      {
        localObject1 = this$0;
        localObject1 = ((zzfy)localObject1).zzay().iterator();
        localObject2 = code;
        ((zzem)localObject1).append("Failed to insert/update event aggregates (got -1). appId", zzeo.get((String)localObject2));
        return;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      this$0.zzay().iterator().append("Error storing event aggregates. appId", zzeo.get(code), localSQLiteException);
    }
  }
  
  public final void add(String paramString1, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    append();
    size();
    try
    {
      SQLiteDatabase localSQLiteDatabase = get();
      localSQLiteDatabase.delete("user_attributes", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      this$0.zzay().iterator().append("Error deleting user property. appId", zzeo.get(paramString1), this$0.next().get(paramString2), localSQLiteException);
    }
  }
  
  final void clean(List paramList)
  {
    append();
    size();
    Preconditions.checkNotNull(paramList);
    Preconditions.checkNotZero(paramList.size());
    if (!getWritableDatabase()) {
      return;
    }
    paramList = TextUtils.join(",", paramList);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append(")");
    paramList = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append(" AND retry_count =  2147483647 LIMIT 1");
    if (get(((StringBuilder)localObject).toString(), null) > 0L) {
      this$0.zzay().hasNext().append("The number of upload retries exceeds the limit. Will remain unchanged.");
    }
    try
    {
      localObject = get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
      localStringBuilder.append(paramList);
      localStringBuilder.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
      ((SQLiteDatabase)localObject).execSQL(localStringBuilder.toString());
      return;
    }
    catch (SQLiteException paramList)
    {
      this$0.zzay().iterator().append("Error incrementing retry count. error", paramList);
    }
  }
  
  public final boolean doAssert()
  {
    return get("select count(1) > 0 from raw_events", null) != 0L;
  }
  
  public final List doInBackground(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    append();
    size();
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    try
    {
      Object localObject5 = get();
      Object localObject6 = this$0;
      localObject1 = localObject3;
      localObject2 = localObject4;
      ((zzfy)localObject6).append();
      localObject1 = localObject3;
      localObject2 = localObject4;
      localObject5 = ((SQLiteDatabase)localObject5).query("user_attributes", new String[] { "name", "origin", "set_timestamp", "value" }, "app_id=?", new String[] { paramString }, null, null, "rowid", "1000");
      localObject3 = localObject5;
      localObject1 = localObject3;
      localObject2 = localObject3;
      boolean bool = ((Cursor)localObject5).moveToFirst();
      if (bool)
      {
        do
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          String str = ((Cursor)localObject5).getString(0);
          localObject1 = localObject3;
          localObject2 = localObject3;
          localObject6 = ((Cursor)localObject5).getString(1);
          localObject4 = localObject6;
          if (localObject6 == null) {
            localObject4 = "";
          }
          localObject1 = localObject3;
          localObject2 = localObject3;
          long l = ((Cursor)localObject5).getLong(2);
          localObject1 = localObject3;
          localObject2 = localObject3;
          localObject6 = format((Cursor)localObject5, 3);
          if (localObject6 == null)
          {
            localObject4 = this$0;
            localObject1 = localObject3;
            localObject2 = localObject3;
            ((zzfy)localObject4).zzay().iterator().append("Read invalid user property value, ignoring it. appId", zzeo.get(paramString));
          }
          else
          {
            localObject1 = localObject3;
            localObject2 = localObject3;
            localArrayList.add(new zzle(paramString, (String)localObject4, str, l, localObject6));
          }
          localObject1 = localObject3;
          localObject2 = localObject3;
          bool = ((Cursor)localObject5).moveToNext();
        } while (bool);
        ((Cursor)localObject5).close();
        return localArrayList;
      }
      ((Cursor)localObject5).close();
      return localArrayList;
    }
    catch (Throwable paramString) {}catch (SQLiteException localSQLiteException)
    {
      localObject1 = localObject2;
      this$0.zzay().iterator().append("Error querying user properties. appId", zzeo.get(paramString), localSQLiteException);
      localObject1 = localObject2;
      paramString = Collections.emptyList();
      if (localObject2 == null) {
        return paramString;
      }
    }
    localObject2.close();
    return paramString;
    if (localObject1 != null) {
      localObject1.close();
    }
    throw paramString;
    return paramString;
  }
  
  /* Error */
  public final List doInBackground(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 313	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 345	com/google/android/gms/measurement/internal/zzgr:append	()V
    //   9: aload_0
    //   10: invokevirtual 348	com/google/android/gms/measurement/internal/zzkn:size	()V
    //   13: new 510	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 511	java/util/ArrayList:<init>	()V
    //   20: astore 14
    //   22: aconst_null
    //   23: astore 13
    //   25: aconst_null
    //   26: astore 10
    //   28: aconst_null
    //   29: astore 12
    //   31: aload 13
    //   33: astore 9
    //   35: new 510	java/util/ArrayList
    //   38: dup
    //   39: iconst_3
    //   40: invokespecial 558	java/util/ArrayList:<init>	(I)V
    //   43: astore 16
    //   45: aload 13
    //   47: astore 9
    //   49: aload 16
    //   51: aload_1
    //   52: invokeinterface 543 2 0
    //   57: pop
    //   58: aload 13
    //   60: astore 9
    //   62: new 469	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 515
    //   69: invokespecial 559	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: astore 15
    //   74: aload 13
    //   76: astore 9
    //   78: aload_2
    //   79: invokestatic 563	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: istore 5
    //   84: iload 5
    //   86: ifne +51 -> 137
    //   89: aload_2
    //   90: astore 11
    //   92: aload 12
    //   94: astore 10
    //   96: aload 11
    //   98: astore 8
    //   100: aload 13
    //   102: astore 9
    //   104: aload 16
    //   106: aload_2
    //   107: invokeinterface 543 2 0
    //   112: pop
    //   113: aload 12
    //   115: astore 10
    //   117: aload 11
    //   119: astore 8
    //   121: aload 13
    //   123: astore 9
    //   125: aload 15
    //   127: ldc_w 565
    //   130: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: goto +3 -> 137
    //   137: aload 12
    //   139: astore 10
    //   141: aload_2
    //   142: astore 8
    //   144: aload 13
    //   146: astore 9
    //   148: aload_3
    //   149: invokestatic 563	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: istore 5
    //   154: iload 5
    //   156: ifne +105 -> 261
    //   159: aload 12
    //   161: astore 10
    //   163: aload_2
    //   164: astore 8
    //   166: aload 13
    //   168: astore 9
    //   170: new 469	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 470	java/lang/StringBuilder:<init>	()V
    //   177: astore 11
    //   179: aload 12
    //   181: astore 10
    //   183: aload_2
    //   184: astore 8
    //   186: aload 13
    //   188: astore 9
    //   190: aload 11
    //   192: aload_3
    //   193: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 12
    //   199: astore 10
    //   201: aload_2
    //   202: astore 8
    //   204: aload 13
    //   206: astore 9
    //   208: aload 11
    //   210: ldc_w 567
    //   213: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 12
    //   219: astore 10
    //   221: aload_2
    //   222: astore 8
    //   224: aload 13
    //   226: astore 9
    //   228: aload 16
    //   230: aload 11
    //   232: invokevirtual 481	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokeinterface 543 2 0
    //   240: pop
    //   241: aload 12
    //   243: astore 10
    //   245: aload_2
    //   246: astore 8
    //   248: aload 13
    //   250: astore 9
    //   252: aload 15
    //   254: ldc_w 569
    //   257: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 12
    //   263: astore 10
    //   265: aload_2
    //   266: astore 8
    //   268: aload 13
    //   270: astore 9
    //   272: aload 16
    //   274: invokeinterface 452 1 0
    //   279: istore 4
    //   281: aload 13
    //   283: astore 9
    //   285: iload 4
    //   287: anewarray 21	java/lang/String
    //   290: astore 11
    //   292: aload 12
    //   294: astore 10
    //   296: aload_2
    //   297: astore 8
    //   299: aload 13
    //   301: astore 9
    //   303: aload 16
    //   305: aload 11
    //   307: invokeinterface 573 2 0
    //   312: astore 11
    //   314: aload 13
    //   316: astore 9
    //   318: aload 11
    //   320: checkcast 574	[Ljava/lang/String;
    //   323: astore 11
    //   325: aload 12
    //   327: astore 10
    //   329: aload_2
    //   330: astore 8
    //   332: aload 13
    //   334: astore 9
    //   336: aload_0
    //   337: invokevirtual 259	com/google/android/gms/measurement/internal/zzam:get	()Landroid/database/sqlite/SQLiteDatabase;
    //   340: astore 16
    //   342: aload 12
    //   344: astore 10
    //   346: aload_2
    //   347: astore 8
    //   349: aload 13
    //   351: astore 9
    //   353: aload 15
    //   355: invokevirtual 481	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: astore 15
    //   360: aload_0
    //   361: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   364: astore 17
    //   366: aload 12
    //   368: astore 10
    //   370: aload_2
    //   371: astore 8
    //   373: aload 13
    //   375: astore 9
    //   377: aload 17
    //   379: invokevirtual 231	com/google/android/gms/measurement/internal/zzfy:append	()Lcom/google/android/gms/measurement/internal/zzag;
    //   382: pop
    //   383: aload 12
    //   385: astore 10
    //   387: aload_2
    //   388: astore 8
    //   390: aload 13
    //   392: astore 9
    //   394: aload 16
    //   396: ldc_w 426
    //   399: iconst_4
    //   400: anewarray 21	java/lang/String
    //   403: dup
    //   404: iconst_0
    //   405: ldc_w 360
    //   408: aastore
    //   409: dup
    //   410: iconst_1
    //   411: ldc_w 513
    //   414: aastore
    //   415: dup
    //   416: iconst_2
    //   417: ldc_w 307
    //   420: aastore
    //   421: dup
    //   422: iconst_3
    //   423: ldc 49
    //   425: aastore
    //   426: aload 15
    //   428: aload 11
    //   430: aconst_null
    //   431: aconst_null
    //   432: ldc_w 517
    //   435: ldc_w 576
    //   438: invokevirtual 523	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   441: astore 12
    //   443: aload 12
    //   445: astore 11
    //   447: aload 11
    //   449: astore 10
    //   451: aload_2
    //   452: astore 8
    //   454: aload 11
    //   456: astore 9
    //   458: aload 12
    //   460: invokeinterface 271 1 0
    //   465: istore 5
    //   467: iload 5
    //   469: ifne +13 -> 482
    //   472: aload 12
    //   474: invokeinterface 278 1 0
    //   479: aload 14
    //   481: areturn
    //   482: aload 11
    //   484: astore 10
    //   486: aload_2
    //   487: astore 8
    //   489: aload 11
    //   491: astore 9
    //   493: aload 14
    //   495: invokeinterface 452 1 0
    //   500: istore 4
    //   502: aload_0
    //   503: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   506: astore 13
    //   508: aload 11
    //   510: astore 10
    //   512: aload_2
    //   513: astore 8
    //   515: aload 11
    //   517: astore 9
    //   519: aload 13
    //   521: invokevirtual 231	com/google/android/gms/measurement/internal/zzfy:append	()Lcom/google/android/gms/measurement/internal/zzag;
    //   524: pop
    //   525: iload 4
    //   527: sipush 1000
    //   530: if_icmplt +81 -> 611
    //   533: aload 11
    //   535: astore 9
    //   537: aload_0
    //   538: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   541: astore_3
    //   542: aload 11
    //   544: astore 10
    //   546: aload_2
    //   547: astore 8
    //   549: aload 11
    //   551: astore 9
    //   553: aload_3
    //   554: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   557: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   560: astore_3
    //   561: aload_0
    //   562: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   565: astore 13
    //   567: aload 11
    //   569: astore 10
    //   571: aload_2
    //   572: astore 8
    //   574: aload 11
    //   576: astore 9
    //   578: aload 13
    //   580: invokevirtual 231	com/google/android/gms/measurement/internal/zzfy:append	()Lcom/google/android/gms/measurement/internal/zzag;
    //   583: pop
    //   584: aload 11
    //   586: astore 10
    //   588: aload_2
    //   589: astore 8
    //   591: aload 11
    //   593: astore 9
    //   595: aload_3
    //   596: ldc_w 578
    //   599: sipush 1000
    //   602: invokestatic 583	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   605: invokevirtual 422	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   608: goto +198 -> 806
    //   611: aload 11
    //   613: astore 10
    //   615: aload_2
    //   616: astore 8
    //   618: aload 11
    //   620: astore 9
    //   622: aload 12
    //   624: iconst_0
    //   625: invokeinterface 527 2 0
    //   630: astore 15
    //   632: aload 11
    //   634: astore 10
    //   636: aload_2
    //   637: astore 8
    //   639: aload 11
    //   641: astore 9
    //   643: aload 12
    //   645: iconst_1
    //   646: invokeinterface 275 2 0
    //   651: lstore 6
    //   653: aload 11
    //   655: astore 10
    //   657: aload_2
    //   658: astore 8
    //   660: aload 11
    //   662: astore 9
    //   664: aload_0
    //   665: aload 12
    //   667: iconst_2
    //   668: invokevirtual 533	com/google/android/gms/measurement/internal/zzam:format	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   671: astore 16
    //   673: aload 11
    //   675: astore 10
    //   677: aload_2
    //   678: astore 8
    //   680: aload 11
    //   682: astore 9
    //   684: aload 12
    //   686: iconst_3
    //   687: invokeinterface 527 2 0
    //   692: astore 13
    //   694: aload 13
    //   696: astore_2
    //   697: aload 16
    //   699: ifnonnull +44 -> 743
    //   702: aload_0
    //   703: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   706: astore 15
    //   708: aload 11
    //   710: astore 10
    //   712: aload_2
    //   713: astore 8
    //   715: aload 11
    //   717: astore 9
    //   719: aload 15
    //   721: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   724: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   727: ldc_w 585
    //   730: aload_1
    //   731: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   734: aload 13
    //   736: aload_3
    //   737: invokevirtual 445	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   740: goto +38 -> 778
    //   743: aload 11
    //   745: astore 10
    //   747: aload_2
    //   748: astore 8
    //   750: aload 11
    //   752: astore 9
    //   754: aload 14
    //   756: new 537	com/google/android/gms/measurement/internal/zzle
    //   759: dup
    //   760: aload_1
    //   761: aload 13
    //   763: aload 15
    //   765: lload 6
    //   767: aload 16
    //   769: invokespecial 540	com/google/android/gms/measurement/internal/zzle:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   772: invokeinterface 543 2 0
    //   777: pop
    //   778: aload 11
    //   780: astore 10
    //   782: aload_2
    //   783: astore 8
    //   785: aload 11
    //   787: astore 9
    //   789: aload 12
    //   791: invokeinterface 546 1 0
    //   796: istore 5
    //   798: iload 5
    //   800: ifeq +6 -> 806
    //   803: goto -321 -> 482
    //   806: aload 12
    //   808: invokeinterface 278 1 0
    //   813: aload 14
    //   815: areturn
    //   816: astore_3
    //   817: goto +15 -> 832
    //   820: astore_1
    //   821: goto +60 -> 881
    //   824: astore_3
    //   825: goto +4 -> 829
    //   828: astore_3
    //   829: aload_2
    //   830: astore 8
    //   832: aload 10
    //   834: astore 9
    //   836: aload_0
    //   837: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   840: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   843: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   846: ldc_w 587
    //   849: aload_1
    //   850: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   853: aload 8
    //   855: aload_3
    //   856: invokevirtual 445	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   859: aload 10
    //   861: astore 9
    //   863: invokestatic 554	java/util/Collections:emptyList	()Ljava/util/List;
    //   866: astore_1
    //   867: aload 10
    //   869: ifnull +26 -> 895
    //   872: aload 10
    //   874: invokeinterface 278 1 0
    //   879: aload_1
    //   880: areturn
    //   881: aload 9
    //   883: ifnull +10 -> 893
    //   886: aload 9
    //   888: invokeinterface 278 1 0
    //   893: aload_1
    //   894: athrow
    //   895: aload_1
    //   896: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	897	0	this	zzam
    //   0	897	1	paramString1	String
    //   0	897	2	paramString2	String
    //   0	897	3	paramString3	String
    //   279	252	4	i	int
    //   82	717	5	bool	boolean
    //   651	115	6	l	long
    //   98	756	8	localObject1	Object
    //   33	854	9	localObject2	Object
    //   26	847	10	localObject3	Object
    //   90	696	11	localObject4	Object
    //   29	778	12	localCursor	Cursor
    //   23	739	13	localObject5	Object
    //   20	794	14	localArrayList	ArrayList
    //   72	692	15	localObject6	Object
    //   43	725	16	localObject7	Object
    //   364	14	17	localZzfy	zzfy
    // Exception table:
    //   from	to	target	type
    //   104	113	816	android/database/sqlite/SQLiteException
    //   125	134	816	android/database/sqlite/SQLiteException
    //   148	154	816	android/database/sqlite/SQLiteException
    //   170	179	816	android/database/sqlite/SQLiteException
    //   190	197	816	android/database/sqlite/SQLiteException
    //   208	217	816	android/database/sqlite/SQLiteException
    //   228	241	816	android/database/sqlite/SQLiteException
    //   252	261	816	android/database/sqlite/SQLiteException
    //   272	281	816	android/database/sqlite/SQLiteException
    //   303	314	816	android/database/sqlite/SQLiteException
    //   336	342	816	android/database/sqlite/SQLiteException
    //   353	360	816	android/database/sqlite/SQLiteException
    //   377	383	816	android/database/sqlite/SQLiteException
    //   394	443	816	android/database/sqlite/SQLiteException
    //   458	467	816	android/database/sqlite/SQLiteException
    //   493	502	816	android/database/sqlite/SQLiteException
    //   519	525	816	android/database/sqlite/SQLiteException
    //   553	561	816	android/database/sqlite/SQLiteException
    //   578	584	816	android/database/sqlite/SQLiteException
    //   595	608	816	android/database/sqlite/SQLiteException
    //   622	632	816	android/database/sqlite/SQLiteException
    //   643	653	816	android/database/sqlite/SQLiteException
    //   664	673	816	android/database/sqlite/SQLiteException
    //   684	694	816	android/database/sqlite/SQLiteException
    //   719	740	816	android/database/sqlite/SQLiteException
    //   754	778	816	android/database/sqlite/SQLiteException
    //   789	798	816	android/database/sqlite/SQLiteException
    //   35	45	820	java/lang/Throwable
    //   49	58	820	java/lang/Throwable
    //   62	74	820	java/lang/Throwable
    //   78	84	820	java/lang/Throwable
    //   104	113	820	java/lang/Throwable
    //   125	134	820	java/lang/Throwable
    //   148	154	820	java/lang/Throwable
    //   170	179	820	java/lang/Throwable
    //   190	197	820	java/lang/Throwable
    //   208	217	820	java/lang/Throwable
    //   228	241	820	java/lang/Throwable
    //   252	261	820	java/lang/Throwable
    //   272	281	820	java/lang/Throwable
    //   285	292	820	java/lang/Throwable
    //   303	314	820	java/lang/Throwable
    //   318	325	820	java/lang/Throwable
    //   336	342	820	java/lang/Throwable
    //   353	360	820	java/lang/Throwable
    //   377	383	820	java/lang/Throwable
    //   394	443	820	java/lang/Throwable
    //   458	467	820	java/lang/Throwable
    //   493	502	820	java/lang/Throwable
    //   519	525	820	java/lang/Throwable
    //   537	542	820	java/lang/Throwable
    //   553	561	820	java/lang/Throwable
    //   578	584	820	java/lang/Throwable
    //   595	608	820	java/lang/Throwable
    //   622	632	820	java/lang/Throwable
    //   643	653	820	java/lang/Throwable
    //   664	673	820	java/lang/Throwable
    //   684	694	820	java/lang/Throwable
    //   719	740	820	java/lang/Throwable
    //   754	778	820	java/lang/Throwable
    //   789	798	820	java/lang/Throwable
    //   836	859	820	java/lang/Throwable
    //   863	867	820	java/lang/Throwable
    //   49	58	824	android/database/sqlite/SQLiteException
    //   62	74	824	android/database/sqlite/SQLiteException
    //   78	84	824	android/database/sqlite/SQLiteException
    //   35	45	828	android/database/sqlite/SQLiteException
  }
  
  final void doInBackground(String paramString, List paramList)
  {
    Preconditions.checkNotNull(paramList);
    int j = 0;
    Object localObject1;
    int k;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    int i;
    Object localObject8;
    while (j < paramList.size())
    {
      localObject1 = (zzeg)((zzeh)paramList.get(j)).zzby();
      if (((zzeg)localObject1).download() != 0)
      {
        localObject4 = localObject1;
        k = 0;
        while (k < ((zzeg)localObject4).download())
        {
          localObject5 = (zzei)((zzeg)localObject4).openConnection(k).zzby();
          localObject6 = (zzei)((zzka)localObject5).zzaB();
          localObject7 = zzgv.get(((zzei)localObject5).getFile());
          if (localObject7 != null)
          {
            ((zzei)localObject6).descend((String)localObject7);
            i = 1;
          }
          else
          {
            i = 0;
          }
          int n = 0;
          int m = i;
          i = n;
          while (i < ((zzei)localObject5).clientCount())
          {
            localObject8 = ((zzei)localObject5).getContent(i);
            localObject7 = zzij.get(((zzel)localObject8).get(), zzgw.type, zzgw.text);
            if (localObject7 != null)
            {
              localObject8 = (zzek)((zzke)localObject8).zzby();
              ((zzek)localObject8).descend((String)localObject7);
              ((zzei)localObject6).append(i, (zzel)((zzka)localObject8).zzaE());
              m = 1;
            }
            i += 1;
          }
          localObject5 = localObject4;
          if (m != 0)
          {
            ((zzeg)localObject4).remainder(k, (zzei)localObject6);
            paramList.set(j, (zzeh)((zzka)localObject1).zzaE());
            localObject5 = localObject1;
          }
          k += 1;
          localObject4 = localObject5;
        }
      }
      else
      {
        localObject4 = localObject1;
      }
      if (((zzeg)localObject4).execute() != 0)
      {
        i = 0;
        while (i < ((zzeg)localObject4).execute())
        {
          localObject7 = ((zzeg)localObject4).post(i);
          localObject6 = zzij.get(((zzes)localObject7).getString(), zzgx.name, zzgx.GIVEN);
          localObject5 = localObject4;
          if (localObject6 != null)
          {
            localObject5 = (zzer)((zzke)localObject7).zzby();
            ((zzer)localObject5).descend((String)localObject6);
            ((zzeg)localObject4).add(i, (zzer)localObject5);
            paramList.set(j, (zzeh)((zzka)localObject1).zzaE());
            localObject5 = localObject1;
          }
          i += 1;
          localObject4 = localObject5;
        }
      }
      j += 1;
    }
    size();
    append();
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramList);
    Object localObject4 = get();
    ((SQLiteDatabase)localObject4).beginTransaction();
    try
    {
      size();
      append();
      Preconditions.checkNotEmpty(paramString);
      localObject1 = get();
      ((SQLiteDatabase)localObject1).delete("property_filters", "app_id=?", new String[] { paramString });
      ((SQLiteDatabase)localObject1).delete("event_filters", "app_id=?", new String[] { paramString });
      localObject5 = paramList.iterator();
      boolean bool;
      label1424:
      label1500:
      for (;;)
      {
        bool = ((Iterator)localObject5).hasNext();
        if (!bool) {
          break;
        }
        localObject6 = (zzeh)((Iterator)localObject5).next();
        size();
        append();
        Preconditions.checkNotEmpty(paramString);
        Preconditions.checkNotNull(localObject6);
        bool = ((zzeh)localObject6).deleteDirectory();
        if (!bool) {}
        try
        {
          this$0.zzay().hasNext().append("Audience with no ID. appId", zzeo.get(paramString));
        }
        catch (Throwable paramString)
        {
          Object localObject9;
          long l1;
          Object localObject3;
          long l2;
          break label1882;
        }
        i = ((zzeh)localObject6).getNumAlbum();
        localObject1 = ((zzeh)localObject6).isAdded().iterator();
        do
        {
          bool = ((Iterator)localObject1).hasNext();
          if (!bool) {
            break;
          }
          bool = ((com.google.android.gms.internal.measurement.zzej)((Iterator)localObject1).next()).addElement();
        } while (bool);
        this$0.zzay().hasNext().append("Event filter with no ID. Audience definition ignored. appId, audienceId", zzeo.get(paramString), Integer.valueOf(i));
        continue;
        localObject1 = ((zzeh)localObject6).getAll().iterator();
        do
        {
          bool = ((Iterator)localObject1).hasNext();
          if (!bool) {
            break;
          }
          bool = ((zzes)((Iterator)localObject1).next()).prepare();
        } while (bool);
        this$0.zzay().hasNext().append("Property filter with no ID. Audience definition ignored. appId, audienceId", zzeo.get(paramString), Integer.valueOf(i));
        continue;
        localObject7 = ((zzeh)localObject6).isAdded().iterator();
        for (;;)
        {
          bool = ((Iterator)localObject7).hasNext();
          if (bool)
          {
            com.google.android.gms.internal.measurement.zzej localZzej = (com.google.android.gms.internal.measurement.zzej)((Iterator)localObject7).next();
            size();
            append();
            Preconditions.checkNotEmpty(paramString);
            Preconditions.checkNotNull(localZzej);
            bool = localZzej.getEntry().isEmpty();
            if (bool)
            {
              localObject6 = this$0.zzay().hasNext();
              localObject7 = zzeo.get(paramString);
              bool = localZzej.addElement();
              if (bool) {
                localObject1 = Integer.valueOf(localZzej.format());
              } else {
                localObject1 = null;
              }
              ((zzem)localObject6).append("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", localObject7, Integer.valueOf(i), String.valueOf(localObject1));
              break label1424;
            }
            localObject8 = localZzej.zzbv();
            localObject9 = new ContentValues();
            ((ContentValues)localObject9).put("app_id", paramString);
            ((ContentValues)localObject9).put("audience_id", Integer.valueOf(i));
            bool = localZzej.addElement();
            if (bool) {
              localObject1 = Integer.valueOf(localZzej.format());
            } else {
              localObject1 = null;
            }
            ((ContentValues)localObject9).put("filter_id", (Integer)localObject1);
            ((ContentValues)localObject9).put("event_name", localZzej.getEntry());
            bool = localZzej.isMovable();
            if (bool) {
              localObject1 = Boolean.valueOf(localZzej.getSerieId());
            } else {
              localObject1 = null;
            }
            ((ContentValues)localObject9).put("session_scoped", (Boolean)localObject1);
            ((ContentValues)localObject9).put("data", (byte[])localObject8);
            try
            {
              l1 = get().insertWithOnConflict("event_filters", null, (ContentValues)localObject9, 5);
              if (l1 == -1L)
              {
                localObject1 = this$0;
                ((zzfy)localObject1).zzay().iterator().append("Failed to insert event filter (got -1). appId", zzeo.get(paramString));
              }
            }
            catch (SQLiteException localSQLiteException1)
            {
              this$0.zzay().iterator().append("Error storing event filter. appId", zzeo.get(paramString), localSQLiteException1);
              break label1424;
            }
          }
        }
        localObject6 = ((zzeh)localObject6).getAll().iterator();
        for (;;)
        {
          bool = ((Iterator)localObject6).hasNext();
          if (!bool) {
            break label1500;
          }
          localObject9 = (zzes)((Iterator)localObject6).next();
          size();
          append();
          Preconditions.checkNotEmpty(paramString);
          Preconditions.checkNotNull(localObject9);
          bool = ((zzes)localObject9).getString().isEmpty();
          Object localObject2;
          if (bool)
          {
            localObject6 = this$0.zzay().hasNext();
            localObject7 = zzeo.get(paramString);
            bool = ((zzes)localObject9).prepare();
            if (bool) {
              localObject2 = Integer.valueOf(((zzes)localObject9).getData());
            } else {
              localObject2 = null;
            }
            ((zzem)localObject6).append("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", localObject7, Integer.valueOf(i), String.valueOf(localObject2));
          }
          else
          {
            localObject7 = ((zzin)localObject9).zzbv();
            localObject8 = new ContentValues();
            ((ContentValues)localObject8).put("app_id", paramString);
            ((ContentValues)localObject8).put("audience_id", Integer.valueOf(i));
            bool = ((zzes)localObject9).prepare();
            if (bool) {
              localObject2 = Integer.valueOf(((zzes)localObject9).getData());
            } else {
              localObject2 = null;
            }
            ((ContentValues)localObject8).put("filter_id", (Integer)localObject2);
            ((ContentValues)localObject8).put("property_name", ((zzes)localObject9).getString());
            bool = ((zzes)localObject9).refresh();
            if (bool) {
              localObject2 = Boolean.valueOf(((zzes)localObject9).format());
            } else {
              localObject2 = null;
            }
            ((ContentValues)localObject8).put("session_scoped", (Boolean)localObject2);
            ((ContentValues)localObject8).put("data", (byte[])localObject7);
            try
            {
              l1 = get().insertWithOnConflict("property_filters", null, (ContentValues)localObject8, 5);
              if (l1 == -1L)
              {
                localObject2 = this$0;
                ((zzfy)localObject2).zzay().iterator().append("Failed to insert property filter (got -1). appId", zzeo.get(paramString));
              }
            }
            catch (SQLiteException localSQLiteException2)
            {
              this$0.zzay().iterator().append("Error storing property filter. appId", zzeo.get(paramString), localSQLiteException2);
            }
          }
        }
        size();
        append();
        Preconditions.checkNotEmpty(paramString);
        localObject3 = get();
        ((SQLiteDatabase)localObject3).delete("property_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(i) });
        ((SQLiteDatabase)localObject3).delete("event_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(i) });
      }
      localObject3 = new ArrayList();
      localObject5 = paramList.iterator();
      for (;;)
      {
        bool = ((Iterator)localObject5).hasNext();
        if (!bool) {
          break;
        }
        paramList = (zzeh)((Iterator)localObject5).next();
        bool = paramList.deleteDirectory();
        if (bool) {
          paramList = Integer.valueOf(paramList.getNumAlbum());
        } else {
          paramList = null;
        }
        ((List)localObject3).add(paramList);
      }
      Preconditions.checkNotEmpty(paramString);
      size();
      append();
      paramList = get();
      try
      {
        l1 = get("select count(1) from audience_filter_values where app_id=?", new String[] { paramString });
        j = Math.max(0, Math.min(2000, this$0.append().add(paramString, zzeb.dialog)));
        l2 = j;
        if (l1 > l2)
        {
          localObject5 = new ArrayList();
          i = 0;
          for (;;)
          {
            k = ((List)localObject3).size();
            if (i >= k) {
              break;
            }
            localObject6 = (Integer)((List)localObject3).get(i);
            if (localObject6 == null) {
              break label1866;
            }
            ((List)localObject5).add(Integer.toString(((Integer)localObject6).intValue()));
            i += 1;
          }
          localObject5 = TextUtils.join(",", (Iterable)localObject5);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append((String)localObject5);
          ((StringBuilder)localObject3).append(")");
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
          ((StringBuilder)localObject5).append(((StringBuilder)localObject3).toString());
          ((StringBuilder)localObject5).append(" order by rowid desc limit -1 offset ?)");
          localObject3 = Integer.toString(j);
          paramList.delete("audience_filter_values", ((StringBuilder)localObject5).toString(), new String[] { paramString, localObject3 });
        }
      }
      catch (SQLiteException paramList)
      {
        this$0.zzay().iterator().append("Database error querying filters. appId", zzeo.get(paramString), paramList);
      }
      label1866:
      ((SQLiteDatabase)localObject4).setTransactionSuccessful();
      ((SQLiteDatabase)localObject4).endTransaction();
      return;
    }
    catch (Throwable paramString) {}
    label1882:
    ((SQLiteDatabase)localObject4).endTransaction();
    throw paramString;
  }
  
  public final boolean downloadAttachment()
  {
    return get("select count(1) > 0 from queue where has_realtime = 1", null) != 0L;
  }
  
  public final void equals()
  {
    size();
    get().setTransactionSuccessful();
  }
  
  final Object format(Cursor paramCursor, int paramInt)
  {
    int i = paramCursor.getType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              this$0.zzay().iterator().append("Loaded invalid unknown value type, ignoring it", Integer.valueOf(i));
              return null;
            }
            this$0.zzay().iterator().append("Loaded invalid blob type value, ignoring it");
            return null;
          }
          return paramCursor.getString(paramInt);
        }
        return Double.valueOf(paramCursor.getDouble(paramInt));
      }
      return Long.valueOf(paramCursor.getLong(paramInt));
    }
    this$0.zzay().iterator().append("Loaded invalid null value from database");
    return null;
  }
  
  final SQLiteDatabase get()
  {
    append();
    Object localObject = mDB;
    try
    {
      localObject = ((zzal)localObject).getWritableDatabase();
      return localObject;
    }
    catch (SQLiteException localSQLiteException)
    {
      this$0.zzay().hasNext().append("Error opening database", localSQLiteException);
      throw localSQLiteException;
    }
  }
  
  public final zzas get(String paramString1, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    append();
    size();
    Object localObject3 = new ArrayList(Arrays.asList(new String[] { "lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count" }));
    Object localObject2 = null;
    Object localObject1;
    try
    {
      localObject1 = get();
      boolean bool1 = false;
      localObject3 = ((ArrayList)localObject3).toArray(new String[0]);
      localObject3 = (String[])localObject3;
      localObject1 = ((SQLiteDatabase)localObject1).query("events", (String[])localObject3, "app_id=? and name=?", new String[] { paramString1, paramString2 }, null, null, null);
      try
      {
        boolean bool2 = ((Cursor)localObject1).moveToFirst();
        if (!bool2)
        {
          ((Cursor)localObject1).close();
          return null;
        }
        long l3 = ((Cursor)localObject1).getLong(0);
        long l4 = ((Cursor)localObject1).getLong(1);
        long l5 = ((Cursor)localObject1).getLong(2);
        bool2 = ((Cursor)localObject1).isNull(3);
        long l1;
        if (bool2) {
          l1 = 0L;
        } else {
          l1 = ((Cursor)localObject1).getLong(3);
        }
        bool2 = ((Cursor)localObject1).isNull(4);
        if (bool2) {
          localObject2 = null;
        } else {
          localObject2 = Long.valueOf(((Cursor)localObject1).getLong(4));
        }
        bool2 = ((Cursor)localObject1).isNull(5);
        if (bool2) {
          localObject3 = null;
        } else {
          localObject3 = Long.valueOf(((Cursor)localObject1).getLong(5));
        }
        bool2 = ((Cursor)localObject1).isNull(6);
        Long localLong;
        if (bool2) {
          localLong = null;
        } else {
          localLong = Long.valueOf(((Cursor)localObject1).getLong(6));
        }
        bool2 = ((Cursor)localObject1).isNull(7);
        long l2;
        Boolean localBoolean;
        if (!bool2)
        {
          l2 = ((Cursor)localObject1).getLong(7);
          if (l2 == 1L) {
            bool1 = true;
          }
          localBoolean = Boolean.valueOf(bool1);
        }
        else
        {
          localBoolean = null;
        }
        bool1 = ((Cursor)localObject1).isNull(8);
        if (bool1) {
          l2 = 0L;
        } else {
          l2 = ((Cursor)localObject1).getLong(8);
        }
        try
        {
          localObject2 = new zzas(paramString1, paramString2, l3, l4, l2, l5, l1, (Long)localObject2, (Long)localObject3, localLong, localBoolean);
          bool1 = ((Cursor)localObject1).moveToNext();
          if (bool1)
          {
            localObject3 = this$0;
            ((zzfy)localObject3).zzay().iterator().append("Got multiple records for event aggregates, expected one. appId", zzeo.get(paramString1));
          }
          ((Cursor)localObject1).close();
          return localObject2;
        }
        catch (Throwable paramString1) {}catch (SQLiteException localSQLiteException1) {}
      }
      catch (Throwable paramString1)
      {
        break label566;
      }
      catch (SQLiteException localSQLiteException2) {}
      try
      {
        this$0.zzay().iterator().append("Error querying events. appId", zzeo.get(paramString1), this$0.next().toString(paramString2), localSQLiteException3);
        if (localObject1 == null) {
          break label580;
        }
        ((Cursor)localObject1).close();
        return null;
      }
      catch (Throwable paramString1) {}
    }
    catch (Throwable paramString1)
    {
      localObject1 = localSQLiteException2;
    }
    catch (SQLiteException localSQLiteException3)
    {
      localObject1 = null;
    }
    label566:
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    throw paramString1;
    label580:
    return null;
  }
  
  public final List get(String paramString1, String paramString2, String paramString3)
  {
    Preconditions.checkNotEmpty(paramString1);
    append();
    size();
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(paramString1);
    paramString1 = new StringBuilder("app_id=?");
    if (!TextUtils.isEmpty(paramString2))
    {
      localArrayList.add(paramString2);
      paramString1.append(" and origin=?");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localArrayList.add(String.valueOf(paramString3).concat("*"));
      paramString1.append(" and name glob ?");
    }
    paramString2 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return load(paramString1.toString(), paramString2);
  }
  
  /* Error */
  public final String getID()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 259	com/google/android/gms/measurement/internal/zzam:get	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_3
    //   8: ldc_w 906
    //   11: aconst_null
    //   12: invokevirtual 265	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   15: astore 4
    //   17: aload 4
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload 4
    //   24: invokeinterface 271 1 0
    //   29: istore_1
    //   30: iload_1
    //   31: ifeq +25 -> 56
    //   34: aload_3
    //   35: astore_2
    //   36: aload 4
    //   38: iconst_0
    //   39: invokeinterface 527 2 0
    //   44: astore 5
    //   46: aload 4
    //   48: invokeinterface 278 1 0
    //   53: aload 5
    //   55: areturn
    //   56: aload 4
    //   58: invokeinterface 278 1 0
    //   63: aconst_null
    //   64: areturn
    //   65: astore 4
    //   67: goto +11 -> 78
    //   70: astore_3
    //   71: goto +40 -> 111
    //   74: astore 4
    //   76: aconst_null
    //   77: astore_3
    //   78: aload_3
    //   79: astore_2
    //   80: aload_0
    //   81: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   84: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   87: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   90: ldc_w 908
    //   93: aload 4
    //   95: invokevirtual 422	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   98: aload_3
    //   99: ifnull +24 -> 123
    //   102: aload_3
    //   103: invokeinterface 278 1 0
    //   108: aconst_null
    //   109: areturn
    //   110: astore_3
    //   111: aload_2
    //   112: ifnull +9 -> 121
    //   115: aload_2
    //   116: invokeinterface 278 1 0
    //   121: aload_3
    //   122: athrow
    //   123: aconst_null
    //   124: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	zzam
    //   29	2	1	bool	boolean
    //   6	110	2	localObject1	Object
    //   4	31	3	localObject2	Object
    //   70	1	3	localThrowable1	Throwable
    //   77	26	3	localObject3	Object
    //   110	12	3	localThrowable2	Throwable
    //   15	42	4	localCursor	Cursor
    //   65	1	4	localSQLiteException1	SQLiteException
    //   74	20	4	localSQLiteException2	SQLiteException
    //   44	10	5	str	String
    // Exception table:
    //   from	to	target	type
    //   22	30	65	android/database/sqlite/SQLiteException
    //   36	46	65	android/database/sqlite/SQLiteException
    //   7	17	70	java/lang/Throwable
    //   7	17	74	android/database/sqlite/SQLiteException
    //   22	30	110	java/lang/Throwable
    //   36	46	110	java/lang/Throwable
    //   80	98	110	java/lang/Throwable
  }
  
  public final long getNextValue()
  {
    return zzaa("select max(bundle_end_timestamp) from queue", null, 0L);
  }
  
  public final long getPairs(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    return zzaa("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[] { paramString }, 0L);
  }
  
  /* Error */
  public final zzle getString(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 313	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 313	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual 345	com/google/android/gms/measurement/internal/zzgr:append	()V
    //   14: aload_0
    //   15: invokevirtual 348	com/google/android/gms/measurement/internal/zzkn:size	()V
    //   18: aconst_null
    //   19: astore 6
    //   21: aload_0
    //   22: invokevirtual 259	com/google/android/gms/measurement/internal/zzam:get	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore 7
    //   27: aload 7
    //   29: ldc_w 426
    //   32: iconst_3
    //   33: anewarray 21	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 513
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: ldc_w 307
    //   47: aastore
    //   48: dup
    //   49: iconst_2
    //   50: ldc 49
    //   52: aastore
    //   53: ldc_w 428
    //   56: iconst_2
    //   57: anewarray 21	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_2
    //   67: aastore
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual 883	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore 8
    //   76: aload 8
    //   78: astore 7
    //   80: aload 7
    //   82: astore 6
    //   84: aload 8
    //   86: invokeinterface 271 1 0
    //   91: istore_3
    //   92: iload_3
    //   93: ifne +12 -> 105
    //   96: aload 8
    //   98: invokeinterface 278 1 0
    //   103: aconst_null
    //   104: areturn
    //   105: aload 7
    //   107: astore 6
    //   109: aload 8
    //   111: iconst_0
    //   112: invokeinterface 275 2 0
    //   117: lstore 4
    //   119: aload 7
    //   121: astore 6
    //   123: aload_0
    //   124: aload 8
    //   126: iconst_1
    //   127: invokevirtual 533	com/google/android/gms/measurement/internal/zzam:format	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   130: astore 9
    //   132: aload 9
    //   134: ifnonnull +12 -> 146
    //   137: aload 8
    //   139: invokeinterface 278 1 0
    //   144: aconst_null
    //   145: areturn
    //   146: aload 7
    //   148: astore 6
    //   150: aload 8
    //   152: iconst_2
    //   153: invokeinterface 527 2 0
    //   158: astore 10
    //   160: aload 7
    //   162: astore 6
    //   164: new 537	com/google/android/gms/measurement/internal/zzle
    //   167: dup
    //   168: aload_1
    //   169: aload 10
    //   171: aload_2
    //   172: lload 4
    //   174: aload 9
    //   176: invokespecial 540	com/google/android/gms/measurement/internal/zzle:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   179: astore 9
    //   181: aload 7
    //   183: astore 6
    //   185: aload 8
    //   187: invokeinterface 546 1 0
    //   192: istore_3
    //   193: iload_3
    //   194: ifeq +31 -> 225
    //   197: aload_0
    //   198: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   201: astore 10
    //   203: aload 7
    //   205: astore 6
    //   207: aload 10
    //   209: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   212: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   215: ldc_w 921
    //   218: aload_1
    //   219: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   222: invokevirtual 422	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   225: aload 8
    //   227: invokeinterface 278 1 0
    //   232: aload 9
    //   234: areturn
    //   235: astore 8
    //   237: goto +12 -> 249
    //   240: astore_1
    //   241: goto +60 -> 301
    //   244: astore 8
    //   246: aconst_null
    //   247: astore 7
    //   249: aload 7
    //   251: astore 6
    //   253: aload_0
    //   254: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   257: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   260: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   263: ldc_w 923
    //   266: aload_1
    //   267: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   270: aload_0
    //   271: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   274: invokevirtual 438	com/google/android/gms/measurement/internal/zzfy:next	()Lcom/google/android/gms/measurement/internal/zzej;
    //   277: aload_2
    //   278: invokevirtual 442	com/google/android/gms/measurement/internal/zzej:get	(Ljava/lang/String;)Ljava/lang/String;
    //   281: aload 8
    //   283: invokevirtual 445	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   286: aload 7
    //   288: ifnull +27 -> 315
    //   291: aload 7
    //   293: invokeinterface 278 1 0
    //   298: aconst_null
    //   299: areturn
    //   300: astore_1
    //   301: aload 6
    //   303: ifnull +10 -> 313
    //   306: aload 6
    //   308: invokeinterface 278 1 0
    //   313: aload_1
    //   314: athrow
    //   315: aconst_null
    //   316: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	zzam
    //   0	317	1	paramString1	String
    //   0	317	2	paramString2	String
    //   91	103	3	bool	boolean
    //   117	56	4	l	long
    //   19	288	6	localObject1	Object
    //   25	267	7	localObject2	Object
    //   74	152	8	localCursor	Cursor
    //   235	1	8	localSQLiteException1	SQLiteException
    //   244	38	8	localSQLiteException2	SQLiteException
    //   130	103	9	localObject3	Object
    //   158	50	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   84	92	235	android/database/sqlite/SQLiteException
    //   109	119	235	android/database/sqlite/SQLiteException
    //   123	132	235	android/database/sqlite/SQLiteException
    //   150	160	235	android/database/sqlite/SQLiteException
    //   164	181	235	android/database/sqlite/SQLiteException
    //   185	193	235	android/database/sqlite/SQLiteException
    //   207	225	235	android/database/sqlite/SQLiteException
    //   21	27	240	java/lang/Throwable
    //   27	76	240	java/lang/Throwable
    //   21	27	244	android/database/sqlite/SQLiteException
    //   27	76	244	android/database/sqlite/SQLiteException
    //   84	92	300	java/lang/Throwable
    //   109	119	300	java/lang/Throwable
    //   123	132	300	java/lang/Throwable
    //   150	160	300	java/lang/Throwable
    //   164	181	300	java/lang/Throwable
    //   185	193	300	java/lang/Throwable
    //   207	225	300	java/lang/Throwable
    //   253	286	300	java/lang/Throwable
  }
  
  public final void getString()
  {
    size();
    get().beginTransaction();
  }
  
  protected final boolean getWritableDatabase()
  {
    Context localContext = this$0.zzau();
    this$0.append();
    return localContext.getDatabasePath("google_app_measurement.db").exists();
  }
  
  protected final long insert(String paramString1, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty("first_open_count");
    append();
    size();
    SQLiteDatabase localSQLiteDatabase = get();
    localSQLiteDatabase.beginTransaction();
    long l1;
    try
    {
      paramString2 = new StringBuilder();
      paramString2.append("select ");
      paramString2.append("first_open_count");
      paramString2.append(" from app2 where app_id=?");
      long l2 = zzaa(paramString2.toString(), new String[] { paramString1 }, -1L);
      l1 = l2;
      if (l2 == -1L)
      {
        paramString2 = new ContentValues();
        paramString2.put("app_id", paramString1);
        Integer localInteger = Integer.valueOf(0);
        paramString2.put("first_open_count", localInteger);
        paramString2.put("previous_install_count", localInteger);
        l1 = localSQLiteDatabase.insertWithOnConflict("app2", null, paramString2, 5);
        if (l1 == -1L)
        {
          paramString2 = this$0;
          paramString2.zzay().iterator().append("Failed to insert column (got -1). appId", zzeo.get(paramString1), "first_open_count");
          localSQLiteDatabase.endTransaction();
          return -1L;
        }
        l1 = 0L;
      }
      try
      {
        paramString2 = new ContentValues();
        paramString2.put("app_id", paramString1);
        paramString2.put("first_open_count", Long.valueOf(1L + l1));
        int i = localSQLiteDatabase.update("app2", paramString2, "app_id = ?", new String[] { paramString1 });
        if (i == 0L)
        {
          paramString2 = this$0;
          paramString2.zzay().iterator().append("Failed to update column (got 0). appId", zzeo.get(paramString1), "first_open_count");
          localSQLiteDatabase.endTransaction();
          return -1L;
        }
        localSQLiteDatabase.setTransactionSuccessful();
      }
      catch (SQLiteException paramString2) {}
      this$0.zzay().iterator().append("Error inserting column. appId", zzeo.get(paramString1), "first_open_count", paramString2);
    }
    catch (Throwable paramString1) {}catch (SQLiteException paramString2)
    {
      l1 = 0L;
    }
    localSQLiteDatabase.endTransaction();
    return l1;
    localSQLiteDatabase.endTransaction();
    throw paramString1;
  }
  
  /* Error */
  public final Buffer load(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 313	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 345	com/google/android/gms/measurement/internal/zzgr:append	()V
    //   9: aload_0
    //   10: invokevirtual 348	com/google/android/gms/measurement/internal/zzkn:size	()V
    //   13: aconst_null
    //   14: astore 8
    //   16: aload_0
    //   17: invokevirtual 259	com/google/android/gms/measurement/internal/zzam:get	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: astore 9
    //   22: iconst_1
    //   23: istore 4
    //   25: aload 9
    //   27: ldc_w 959
    //   30: bipush 29
    //   32: anewarray 21	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc_w 961
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: ldc_w 963
    //   46: aastore
    //   47: dup
    //   48: iconst_2
    //   49: ldc_w 965
    //   52: aastore
    //   53: dup
    //   54: iconst_3
    //   55: ldc_w 967
    //   58: aastore
    //   59: dup
    //   60: iconst_4
    //   61: ldc 75
    //   63: aastore
    //   64: dup
    //   65: iconst_5
    //   66: ldc_w 969
    //   69: aastore
    //   70: dup
    //   71: bipush 6
    //   73: ldc 55
    //   75: aastore
    //   76: dup
    //   77: bipush 7
    //   79: ldc 59
    //   81: aastore
    //   82: dup
    //   83: bipush 8
    //   85: ldc 63
    //   87: aastore
    //   88: dup
    //   89: bipush 9
    //   91: ldc 67
    //   93: aastore
    //   94: dup
    //   95: bipush 10
    //   97: ldc 71
    //   99: aastore
    //   100: dup
    //   101: bipush 11
    //   103: ldc 79
    //   105: aastore
    //   106: dup
    //   107: bipush 12
    //   109: ldc 83
    //   111: aastore
    //   112: dup
    //   113: bipush 13
    //   115: ldc 87
    //   117: aastore
    //   118: dup
    //   119: bipush 14
    //   121: ldc 91
    //   123: aastore
    //   124: dup
    //   125: bipush 15
    //   127: ldc 99
    //   129: aastore
    //   130: dup
    //   131: bipush 16
    //   133: ldc 103
    //   135: aastore
    //   136: dup
    //   137: bipush 17
    //   139: ldc 107
    //   141: aastore
    //   142: dup
    //   143: bipush 18
    //   145: ldc 111
    //   147: aastore
    //   148: dup
    //   149: bipush 19
    //   151: ldc 115
    //   153: aastore
    //   154: dup
    //   155: bipush 20
    //   157: ldc 119
    //   159: aastore
    //   160: dup
    //   161: bipush 21
    //   163: ldc 123
    //   165: aastore
    //   166: dup
    //   167: bipush 22
    //   169: ldc 127
    //   171: aastore
    //   172: dup
    //   173: bipush 23
    //   175: ldc -125
    //   177: aastore
    //   178: dup
    //   179: bipush 24
    //   181: ldc -117
    //   183: aastore
    //   184: dup
    //   185: bipush 25
    //   187: ldc -109
    //   189: aastore
    //   190: dup
    //   191: bipush 26
    //   193: ldc -105
    //   195: aastore
    //   196: dup
    //   197: bipush 27
    //   199: ldc -101
    //   201: aastore
    //   202: dup
    //   203: bipush 28
    //   205: ldc -89
    //   207: aastore
    //   208: ldc_w 515
    //   211: iconst_1
    //   212: anewarray 21	java/lang/String
    //   215: dup
    //   216: iconst_0
    //   217: aload_1
    //   218: aastore
    //   219: aconst_null
    //   220: aconst_null
    //   221: aconst_null
    //   222: invokevirtual 883	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   225: astore 10
    //   227: aload 10
    //   229: astore 9
    //   231: aload 9
    //   233: astore 8
    //   235: aload 10
    //   237: invokeinterface 271 1 0
    //   242: istore_3
    //   243: iload_3
    //   244: ifne +12 -> 256
    //   247: aload 10
    //   249: invokeinterface 278 1 0
    //   254: aconst_null
    //   255: areturn
    //   256: aload_0
    //   257: getfield 974	com/google/android/gms/measurement/internal/zzkm:this$0	Lcom/google/android/gms/measurement/internal/zzkz;
    //   260: astore 11
    //   262: aload 9
    //   264: astore 8
    //   266: new 976	com/google/android/gms/measurement/internal/Buffer
    //   269: dup
    //   270: aload 11
    //   272: invokevirtual 982	com/google/android/gms/measurement/internal/zzkz:context	()Lcom/google/android/gms/measurement/internal/zzfy;
    //   275: aload_1
    //   276: invokespecial 985	com/google/android/gms/measurement/internal/Buffer:<init>	(Lcom/google/android/gms/measurement/internal/zzfy;Ljava/lang/String;)V
    //   279: astore 11
    //   281: aload 9
    //   283: astore 8
    //   285: aload 11
    //   287: aload 10
    //   289: iconst_0
    //   290: invokeinterface 527 2 0
    //   295: invokevirtual 987	com/google/android/gms/measurement/internal/Buffer:set	(Ljava/lang/String;)V
    //   298: aload 9
    //   300: astore 8
    //   302: aload 11
    //   304: aload 10
    //   306: iconst_1
    //   307: invokeinterface 527 2 0
    //   312: invokevirtual 990	com/google/android/gms/measurement/internal/Buffer:encode	(Ljava/lang/String;)V
    //   315: aload 9
    //   317: astore 8
    //   319: aload 11
    //   321: aload 10
    //   323: iconst_2
    //   324: invokeinterface 527 2 0
    //   329: invokevirtual 993	com/google/android/gms/measurement/internal/Buffer:zzae	(Ljava/lang/String;)V
    //   332: aload 9
    //   334: astore 8
    //   336: aload 11
    //   338: aload 10
    //   340: iconst_3
    //   341: invokeinterface 275 2 0
    //   346: invokevirtual 996	com/google/android/gms/measurement/internal/Buffer:zzaa	(J)V
    //   349: aload 9
    //   351: astore 8
    //   353: aload 11
    //   355: aload 10
    //   357: iconst_4
    //   358: invokeinterface 275 2 0
    //   363: invokevirtual 999	com/google/android/gms/measurement/internal/Buffer:zzab	(J)V
    //   366: aload 9
    //   368: astore 8
    //   370: aload 11
    //   372: aload 10
    //   374: iconst_5
    //   375: invokeinterface 275 2 0
    //   380: invokevirtual 1001	com/google/android/gms/measurement/internal/Buffer:append	(J)V
    //   383: aload 9
    //   385: astore 8
    //   387: aload 11
    //   389: aload 10
    //   391: bipush 6
    //   393: invokeinterface 527 2 0
    //   398: invokevirtual 1003	com/google/android/gms/measurement/internal/Buffer:add	(Ljava/lang/String;)V
    //   401: aload 9
    //   403: astore 8
    //   405: aload 11
    //   407: aload 10
    //   409: bipush 7
    //   411: invokeinterface 527 2 0
    //   416: invokevirtual 1004	com/google/android/gms/measurement/internal/Buffer:append	(Ljava/lang/String;)V
    //   419: aload 9
    //   421: astore 8
    //   423: aload 11
    //   425: aload 10
    //   427: bipush 8
    //   429: invokeinterface 275 2 0
    //   434: invokevirtual 1006	com/google/android/gms/measurement/internal/Buffer:read	(J)V
    //   437: aload 9
    //   439: astore 8
    //   441: aload 11
    //   443: aload 10
    //   445: bipush 9
    //   447: invokeinterface 275 2 0
    //   452: invokevirtual 1009	com/google/android/gms/measurement/internal/Buffer:remove	(J)V
    //   455: aload 9
    //   457: astore 8
    //   459: aload 10
    //   461: bipush 10
    //   463: invokeinterface 887 2 0
    //   468: istore_3
    //   469: iload_3
    //   470: ifne +29 -> 499
    //   473: aload 9
    //   475: astore 8
    //   477: aload 10
    //   479: bipush 10
    //   481: invokeinterface 1012 2 0
    //   486: istore_2
    //   487: iload_2
    //   488: ifeq +6 -> 494
    //   491: goto +8 -> 499
    //   494: iconst_0
    //   495: istore_3
    //   496: goto +5 -> 501
    //   499: iconst_1
    //   500: istore_3
    //   501: aload 9
    //   503: astore 8
    //   505: aload 11
    //   507: iload_3
    //   508: invokevirtual 1016	com/google/android/gms/measurement/internal/Buffer:zzac	(Z)V
    //   511: aload 9
    //   513: astore 8
    //   515: aload 11
    //   517: aload 10
    //   519: bipush 11
    //   521: invokeinterface 275 2 0
    //   526: invokevirtual 1019	com/google/android/gms/measurement/internal/Buffer:putLong	(J)V
    //   529: aload 9
    //   531: astore 8
    //   533: aload 11
    //   535: aload 10
    //   537: bipush 12
    //   539: invokeinterface 275 2 0
    //   544: invokevirtual 1022	com/google/android/gms/measurement/internal/Buffer:start	(J)V
    //   547: aload 9
    //   549: astore 8
    //   551: aload 11
    //   553: aload 10
    //   555: bipush 13
    //   557: invokeinterface 275 2 0
    //   562: invokevirtual 1025	com/google/android/gms/measurement/internal/Buffer:shift	(J)V
    //   565: aload 9
    //   567: astore 8
    //   569: aload 11
    //   571: aload 10
    //   573: bipush 14
    //   575: invokeinterface 275 2 0
    //   580: invokevirtual 1028	com/google/android/gms/measurement/internal/Buffer:skip	(J)V
    //   583: aload 9
    //   585: astore 8
    //   587: aload 11
    //   589: aload 10
    //   591: bipush 15
    //   593: invokeinterface 275 2 0
    //   598: invokevirtual 1030	com/google/android/gms/measurement/internal/Buffer:encode	(J)V
    //   601: aload 9
    //   603: astore 8
    //   605: aload 11
    //   607: aload 10
    //   609: bipush 16
    //   611: invokeinterface 275 2 0
    //   616: invokevirtual 1032	com/google/android/gms/measurement/internal/Buffer:add	(J)V
    //   619: aload 9
    //   621: astore 8
    //   623: aload 10
    //   625: bipush 17
    //   627: invokeinterface 887 2 0
    //   632: istore_3
    //   633: iload_3
    //   634: ifeq +11 -> 645
    //   637: ldc2_w 1033
    //   640: lstore 6
    //   642: goto +21 -> 663
    //   645: aload 9
    //   647: astore 8
    //   649: aload 10
    //   651: bipush 17
    //   653: invokeinterface 1012 2 0
    //   658: istore_2
    //   659: iload_2
    //   660: i2l
    //   661: lstore 6
    //   663: aload 9
    //   665: astore 8
    //   667: aload 11
    //   669: lload 6
    //   671: invokevirtual 1036	com/google/android/gms/measurement/internal/Buffer:put	(J)V
    //   674: aload 9
    //   676: astore 8
    //   678: aload 11
    //   680: aload 10
    //   682: bipush 18
    //   684: invokeinterface 527 2 0
    //   689: invokevirtual 1038	com/google/android/gms/measurement/internal/Buffer:put	(Ljava/lang/String;)V
    //   692: aload 9
    //   694: astore 8
    //   696: aload 11
    //   698: aload 10
    //   700: bipush 19
    //   702: invokeinterface 275 2 0
    //   707: invokevirtual 1040	com/google/android/gms/measurement/internal/Buffer:next	(J)V
    //   710: aload 9
    //   712: astore 8
    //   714: aload 11
    //   716: aload 10
    //   718: bipush 20
    //   720: invokeinterface 275 2 0
    //   725: invokevirtual 1043	com/google/android/gms/measurement/internal/Buffer:write	(J)V
    //   728: aload 9
    //   730: astore 8
    //   732: aload 11
    //   734: aload 10
    //   736: bipush 21
    //   738: invokeinterface 527 2 0
    //   743: invokevirtual 1045	com/google/android/gms/measurement/internal/Buffer:write	(Ljava/lang/String;)V
    //   746: aload 9
    //   748: astore 8
    //   750: aload 10
    //   752: bipush 23
    //   754: invokeinterface 887 2 0
    //   759: istore 5
    //   761: iload 4
    //   763: istore_3
    //   764: iload 5
    //   766: ifne +29 -> 795
    //   769: aload 9
    //   771: astore 8
    //   773: aload 10
    //   775: bipush 23
    //   777: invokeinterface 1012 2 0
    //   782: istore_2
    //   783: iload_2
    //   784: ifeq +9 -> 793
    //   787: iload 4
    //   789: istore_3
    //   790: goto +5 -> 795
    //   793: iconst_0
    //   794: istore_3
    //   795: aload 9
    //   797: astore 8
    //   799: aload 11
    //   801: iload_3
    //   802: invokevirtual 1047	com/google/android/gms/measurement/internal/Buffer:read	(Z)V
    //   805: aload 9
    //   807: astore 8
    //   809: aload 11
    //   811: aload 10
    //   813: bipush 24
    //   815: invokeinterface 527 2 0
    //   820: invokevirtual 1049	com/google/android/gms/measurement/internal/Buffer:read	(Ljava/lang/String;)V
    //   823: aload 9
    //   825: astore 8
    //   827: aload 10
    //   829: bipush 25
    //   831: invokeinterface 887 2 0
    //   836: istore_3
    //   837: iload_3
    //   838: ifeq +9 -> 847
    //   841: lconst_0
    //   842: lstore 6
    //   844: goto +18 -> 862
    //   847: aload 9
    //   849: astore 8
    //   851: aload 10
    //   853: bipush 25
    //   855: invokeinterface 275 2 0
    //   860: lstore 6
    //   862: aload 9
    //   864: astore 8
    //   866: aload 11
    //   868: lload 6
    //   870: invokevirtual 1052	com/google/android/gms/measurement/internal/Buffer:readInt	(J)V
    //   873: aload 9
    //   875: astore 8
    //   877: aload 10
    //   879: bipush 26
    //   881: invokeinterface 887 2 0
    //   886: istore_3
    //   887: iload_3
    //   888: ifne +31 -> 919
    //   891: aload 9
    //   893: astore 8
    //   895: aload 11
    //   897: aload 10
    //   899: bipush 26
    //   901: invokeinterface 527 2 0
    //   906: ldc_w 461
    //   909: iconst_m1
    //   910: invokevirtual 1056	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   913: invokestatic 876	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   916: invokevirtual 1059	com/google/android/gms/measurement/internal/Buffer:zzaf	(Ljava/util/List;)V
    //   919: aload 9
    //   921: astore 8
    //   923: invokestatic 1062	com/google/android/gms/internal/measurement/zzoz:isEmpty	()Z
    //   926: pop
    //   927: aload 9
    //   929: astore 8
    //   931: aload_0
    //   932: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   935: astore 12
    //   937: aload 9
    //   939: astore 8
    //   941: aload 12
    //   943: invokevirtual 231	com/google/android/gms/measurement/internal/zzfy:append	()Lcom/google/android/gms/measurement/internal/zzag;
    //   946: astore 12
    //   948: getstatic 1065	com/google/android/gms/measurement/internal/zzeb:zzar	Lcom/google/android/gms/measurement/internal/zzea;
    //   951: astore 13
    //   953: aload 9
    //   955: astore 8
    //   957: aload 12
    //   959: aconst_null
    //   960: aload 13
    //   962: invokevirtual 1068	com/google/android/gms/measurement/internal/zzag:get	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzea;)Z
    //   965: istore_3
    //   966: iload_3
    //   967: ifeq +21 -> 988
    //   970: aload 9
    //   972: astore 8
    //   974: aload 11
    //   976: aload 10
    //   978: bipush 28
    //   980: invokeinterface 527 2 0
    //   985: invokevirtual 1071	com/google/android/gms/measurement/internal/Buffer:zzag	(Ljava/lang/String;)V
    //   988: aload 9
    //   990: astore 8
    //   992: aload 11
    //   994: invokevirtual 1073	com/google/android/gms/measurement/internal/Buffer:skip	()V
    //   997: aload 9
    //   999: astore 8
    //   1001: aload 10
    //   1003: invokeinterface 546 1 0
    //   1008: istore_3
    //   1009: iload_3
    //   1010: ifeq +31 -> 1041
    //   1013: aload_0
    //   1014: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   1017: astore 12
    //   1019: aload 9
    //   1021: astore 8
    //   1023: aload 12
    //   1025: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   1028: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1031: ldc_w 1075
    //   1034: aload_1
    //   1035: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1038: invokevirtual 422	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1041: aload 10
    //   1043: invokeinterface 278 1 0
    //   1048: aload 11
    //   1050: areturn
    //   1051: astore 10
    //   1053: goto +12 -> 1065
    //   1056: astore_1
    //   1057: goto +49 -> 1106
    //   1060: astore 10
    //   1062: aconst_null
    //   1063: astore 9
    //   1065: aload 9
    //   1067: astore 8
    //   1069: aload_0
    //   1070: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   1073: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   1076: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1079: ldc_w 1077
    //   1082: aload_1
    //   1083: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1086: aload 10
    //   1088: invokevirtual 300	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1091: aload 9
    //   1093: ifnull +27 -> 1120
    //   1096: aload 9
    //   1098: invokeinterface 278 1 0
    //   1103: aconst_null
    //   1104: areturn
    //   1105: astore_1
    //   1106: aload 8
    //   1108: ifnull +10 -> 1118
    //   1111: aload 8
    //   1113: invokeinterface 278 1 0
    //   1118: aload_1
    //   1119: athrow
    //   1120: aconst_null
    //   1121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1122	0	this	zzam
    //   0	1122	1	paramString	String
    //   486	298	2	i	int
    //   242	768	3	bool1	boolean
    //   23	765	4	bool2	boolean
    //   759	6	5	bool3	boolean
    //   640	229	6	l	long
    //   14	1098	8	localObject1	Object
    //   20	1077	9	localObject2	Object
    //   225	817	10	localCursor	Cursor
    //   1051	1	10	localSQLiteException1	SQLiteException
    //   1060	27	10	localSQLiteException2	SQLiteException
    //   260	789	11	localObject3	Object
    //   935	89	12	localObject4	Object
    //   951	10	13	localZzea	zzea
    // Exception table:
    //   from	to	target	type
    //   235	243	1051	android/database/sqlite/SQLiteException
    //   266	281	1051	android/database/sqlite/SQLiteException
    //   285	298	1051	android/database/sqlite/SQLiteException
    //   302	315	1051	android/database/sqlite/SQLiteException
    //   319	332	1051	android/database/sqlite/SQLiteException
    //   336	349	1051	android/database/sqlite/SQLiteException
    //   353	366	1051	android/database/sqlite/SQLiteException
    //   370	383	1051	android/database/sqlite/SQLiteException
    //   387	401	1051	android/database/sqlite/SQLiteException
    //   405	419	1051	android/database/sqlite/SQLiteException
    //   423	437	1051	android/database/sqlite/SQLiteException
    //   441	455	1051	android/database/sqlite/SQLiteException
    //   459	469	1051	android/database/sqlite/SQLiteException
    //   477	487	1051	android/database/sqlite/SQLiteException
    //   505	511	1051	android/database/sqlite/SQLiteException
    //   515	529	1051	android/database/sqlite/SQLiteException
    //   533	547	1051	android/database/sqlite/SQLiteException
    //   551	565	1051	android/database/sqlite/SQLiteException
    //   569	583	1051	android/database/sqlite/SQLiteException
    //   587	601	1051	android/database/sqlite/SQLiteException
    //   605	619	1051	android/database/sqlite/SQLiteException
    //   623	633	1051	android/database/sqlite/SQLiteException
    //   649	659	1051	android/database/sqlite/SQLiteException
    //   667	674	1051	android/database/sqlite/SQLiteException
    //   678	692	1051	android/database/sqlite/SQLiteException
    //   696	710	1051	android/database/sqlite/SQLiteException
    //   714	728	1051	android/database/sqlite/SQLiteException
    //   732	746	1051	android/database/sqlite/SQLiteException
    //   750	761	1051	android/database/sqlite/SQLiteException
    //   773	783	1051	android/database/sqlite/SQLiteException
    //   799	805	1051	android/database/sqlite/SQLiteException
    //   809	823	1051	android/database/sqlite/SQLiteException
    //   827	837	1051	android/database/sqlite/SQLiteException
    //   851	862	1051	android/database/sqlite/SQLiteException
    //   866	873	1051	android/database/sqlite/SQLiteException
    //   877	887	1051	android/database/sqlite/SQLiteException
    //   895	919	1051	android/database/sqlite/SQLiteException
    //   923	927	1051	android/database/sqlite/SQLiteException
    //   941	948	1051	android/database/sqlite/SQLiteException
    //   957	966	1051	android/database/sqlite/SQLiteException
    //   974	988	1051	android/database/sqlite/SQLiteException
    //   992	997	1051	android/database/sqlite/SQLiteException
    //   1001	1009	1051	android/database/sqlite/SQLiteException
    //   1023	1041	1051	android/database/sqlite/SQLiteException
    //   16	22	1056	java/lang/Throwable
    //   25	227	1056	java/lang/Throwable
    //   16	22	1060	android/database/sqlite/SQLiteException
    //   25	227	1060	android/database/sqlite/SQLiteException
    //   235	243	1105	java/lang/Throwable
    //   266	281	1105	java/lang/Throwable
    //   285	298	1105	java/lang/Throwable
    //   302	315	1105	java/lang/Throwable
    //   319	332	1105	java/lang/Throwable
    //   336	349	1105	java/lang/Throwable
    //   353	366	1105	java/lang/Throwable
    //   370	383	1105	java/lang/Throwable
    //   387	401	1105	java/lang/Throwable
    //   405	419	1105	java/lang/Throwable
    //   423	437	1105	java/lang/Throwable
    //   441	455	1105	java/lang/Throwable
    //   459	469	1105	java/lang/Throwable
    //   477	487	1105	java/lang/Throwable
    //   505	511	1105	java/lang/Throwable
    //   515	529	1105	java/lang/Throwable
    //   533	547	1105	java/lang/Throwable
    //   551	565	1105	java/lang/Throwable
    //   569	583	1105	java/lang/Throwable
    //   587	601	1105	java/lang/Throwable
    //   605	619	1105	java/lang/Throwable
    //   623	633	1105	java/lang/Throwable
    //   649	659	1105	java/lang/Throwable
    //   667	674	1105	java/lang/Throwable
    //   678	692	1105	java/lang/Throwable
    //   696	710	1105	java/lang/Throwable
    //   714	728	1105	java/lang/Throwable
    //   732	746	1105	java/lang/Throwable
    //   750	761	1105	java/lang/Throwable
    //   773	783	1105	java/lang/Throwable
    //   799	805	1105	java/lang/Throwable
    //   809	823	1105	java/lang/Throwable
    //   827	837	1105	java/lang/Throwable
    //   851	862	1105	java/lang/Throwable
    //   866	873	1105	java/lang/Throwable
    //   877	887	1105	java/lang/Throwable
    //   895	919	1105	java/lang/Throwable
    //   923	927	1105	java/lang/Throwable
    //   931	937	1105	java/lang/Throwable
    //   941	948	1105	java/lang/Throwable
    //   957	966	1105	java/lang/Throwable
    //   974	988	1105	java/lang/Throwable
    //   992	997	1105	java/lang/Throwable
    //   1001	1009	1105	java/lang/Throwable
    //   1023	1041	1105	java/lang/Throwable
    //   1069	1091	1105	java/lang/Throwable
  }
  
  /* Error */
  public final zzac load(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 313	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 313	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual 345	com/google/android/gms/measurement/internal/zzgr:append	()V
    //   14: aload_0
    //   15: invokevirtual 348	com/google/android/gms/measurement/internal/zzkn:size	()V
    //   18: aconst_null
    //   19: astore 13
    //   21: aload_0
    //   22: invokevirtual 259	com/google/android/gms/measurement/internal/zzam:get	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore 14
    //   27: aload 14
    //   29: ldc_w 1080
    //   32: bipush 11
    //   34: anewarray 21	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc 49
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: ldc_w 307
    //   47: aastore
    //   48: dup
    //   49: iconst_2
    //   50: ldc_w 1082
    //   53: aastore
    //   54: dup
    //   55: iconst_3
    //   56: ldc_w 1084
    //   59: aastore
    //   60: dup
    //   61: iconst_4
    //   62: ldc_w 1086
    //   65: aastore
    //   66: dup
    //   67: iconst_5
    //   68: ldc_w 1088
    //   71: aastore
    //   72: dup
    //   73: bipush 6
    //   75: ldc_w 1090
    //   78: aastore
    //   79: dup
    //   80: bipush 7
    //   82: ldc_w 1092
    //   85: aastore
    //   86: dup
    //   87: bipush 8
    //   89: ldc_w 1094
    //   92: aastore
    //   93: dup
    //   94: bipush 9
    //   96: ldc_w 1096
    //   99: aastore
    //   100: dup
    //   101: bipush 10
    //   103: ldc_w 1098
    //   106: aastore
    //   107: ldc_w 428
    //   110: iconst_2
    //   111: anewarray 21	java/lang/String
    //   114: dup
    //   115: iconst_0
    //   116: aload_1
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_2
    //   121: aastore
    //   122: aconst_null
    //   123: aconst_null
    //   124: aconst_null
    //   125: invokevirtual 883	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   128: astore 16
    //   130: aload 16
    //   132: astore 14
    //   134: aload 14
    //   136: astore 13
    //   138: aload 16
    //   140: invokeinterface 271 1 0
    //   145: istore 4
    //   147: iload 4
    //   149: ifne +12 -> 161
    //   152: aload 16
    //   154: invokeinterface 278 1 0
    //   159: aconst_null
    //   160: areturn
    //   161: aload 14
    //   163: astore 13
    //   165: aload 16
    //   167: iconst_0
    //   168: invokeinterface 527 2 0
    //   173: astore 17
    //   175: aload 17
    //   177: astore 15
    //   179: aload 17
    //   181: ifnonnull +8 -> 189
    //   184: ldc_w 529
    //   187: astore 15
    //   189: aload 14
    //   191: astore 13
    //   193: aload_0
    //   194: aload 16
    //   196: iconst_1
    //   197: invokevirtual 533	com/google/android/gms/measurement/internal/zzam:format	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   200: astore 18
    //   202: aload 14
    //   204: astore 13
    //   206: aload 16
    //   208: iconst_2
    //   209: invokeinterface 1012 2 0
    //   214: istore_3
    //   215: iload_3
    //   216: ifeq +9 -> 225
    //   219: iconst_1
    //   220: istore 4
    //   222: goto +6 -> 228
    //   225: iconst_0
    //   226: istore 4
    //   228: aload 14
    //   230: astore 13
    //   232: aload 16
    //   234: iconst_3
    //   235: invokeinterface 527 2 0
    //   240: astore 17
    //   242: aload 14
    //   244: astore 13
    //   246: aload 16
    //   248: iconst_4
    //   249: invokeinterface 275 2 0
    //   254: lstore 5
    //   256: aload 14
    //   258: astore 13
    //   260: aload_0
    //   261: getfield 974	com/google/android/gms/measurement/internal/zzkm:this$0	Lcom/google/android/gms/measurement/internal/zzkz;
    //   264: astore 19
    //   266: aload 14
    //   268: astore 13
    //   270: aload 19
    //   272: invokevirtual 1101	com/google/android/gms/measurement/internal/zzkz:next	()Lcom/google/android/gms/measurement/internal/zzlb;
    //   275: astore 20
    //   277: aload 14
    //   279: astore 13
    //   281: aload 16
    //   283: iconst_5
    //   284: invokeinterface 1105 2 0
    //   289: astore 21
    //   291: aload 14
    //   293: astore 13
    //   295: getstatic 1111	com/google/android/gms/measurement/internal/zzaw:CREATOR	Landroid/os/Parcelable$Creator;
    //   298: astore 19
    //   300: aload 14
    //   302: astore 13
    //   304: aload 20
    //   306: aload 21
    //   308: aload 19
    //   310: invokevirtual 1116	com/google/android/gms/measurement/internal/zzlb:get	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   313: astore 20
    //   315: aload 14
    //   317: astore 13
    //   319: aload 20
    //   321: checkcast 1107	com/google/android/gms/measurement/internal/zzaw
    //   324: astore 20
    //   326: aload 14
    //   328: astore 13
    //   330: aload 16
    //   332: bipush 6
    //   334: invokeinterface 275 2 0
    //   339: lstore 7
    //   341: aload 14
    //   343: astore 13
    //   345: aload_0
    //   346: getfield 974	com/google/android/gms/measurement/internal/zzkm:this$0	Lcom/google/android/gms/measurement/internal/zzkz;
    //   349: astore 21
    //   351: aload 14
    //   353: astore 13
    //   355: aload 21
    //   357: invokevirtual 1101	com/google/android/gms/measurement/internal/zzkz:next	()Lcom/google/android/gms/measurement/internal/zzlb;
    //   360: aload 16
    //   362: bipush 7
    //   364: invokeinterface 1105 2 0
    //   369: aload 19
    //   371: invokevirtual 1116	com/google/android/gms/measurement/internal/zzlb:get	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   374: astore 21
    //   376: aload 14
    //   378: astore 13
    //   380: aload 21
    //   382: checkcast 1107	com/google/android/gms/measurement/internal/zzaw
    //   385: astore 21
    //   387: aload 14
    //   389: astore 13
    //   391: aload 16
    //   393: bipush 8
    //   395: invokeinterface 275 2 0
    //   400: lstore 9
    //   402: aload 14
    //   404: astore 13
    //   406: aload 16
    //   408: bipush 9
    //   410: invokeinterface 275 2 0
    //   415: lstore 11
    //   417: aload 14
    //   419: astore 13
    //   421: aload_0
    //   422: getfield 974	com/google/android/gms/measurement/internal/zzkm:this$0	Lcom/google/android/gms/measurement/internal/zzkz;
    //   425: astore 22
    //   427: aload 14
    //   429: astore 13
    //   431: aload 22
    //   433: invokevirtual 1101	com/google/android/gms/measurement/internal/zzkz:next	()Lcom/google/android/gms/measurement/internal/zzlb;
    //   436: aload 16
    //   438: bipush 10
    //   440: invokeinterface 1105 2 0
    //   445: aload 19
    //   447: invokevirtual 1116	com/google/android/gms/measurement/internal/zzlb:get	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   450: astore 19
    //   452: aload 14
    //   454: astore 13
    //   456: aload 19
    //   458: checkcast 1107	com/google/android/gms/measurement/internal/zzaw
    //   461: astore 19
    //   463: aload 14
    //   465: astore 13
    //   467: new 1118	com/google/android/gms/measurement/internal/zzlc
    //   470: dup
    //   471: aload_2
    //   472: lload 9
    //   474: aload 18
    //   476: aload 15
    //   478: invokespecial 1121	com/google/android/gms/measurement/internal/zzlc:<init>	(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
    //   481: astore 18
    //   483: aload 14
    //   485: astore 13
    //   487: new 1123	com/google/android/gms/measurement/internal/zzac
    //   490: dup
    //   491: aload_1
    //   492: aload 15
    //   494: aload 18
    //   496: lload 7
    //   498: iload 4
    //   500: aload 17
    //   502: aload 20
    //   504: lload 5
    //   506: aload 21
    //   508: lload 11
    //   510: aload 19
    //   512: invokespecial 1126	com/google/android/gms/measurement/internal/zzac:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzlc;JZLjava/lang/String;Lcom/google/android/gms/measurement/internal/zzaw;JLcom/google/android/gms/measurement/internal/zzaw;JLcom/google/android/gms/measurement/internal/zzaw;)V
    //   515: astore 15
    //   517: aload 14
    //   519: astore 13
    //   521: aload 16
    //   523: invokeinterface 546 1 0
    //   528: istore 4
    //   530: iload 4
    //   532: ifeq +66 -> 598
    //   535: aload 14
    //   537: astore 13
    //   539: aload_0
    //   540: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   543: astore 17
    //   545: aload 14
    //   547: astore 13
    //   549: aload 17
    //   551: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   554: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   557: astore 17
    //   559: aload 14
    //   561: astore 13
    //   563: aload_1
    //   564: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   567: astore 18
    //   569: aload_0
    //   570: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   573: astore 19
    //   575: aload 14
    //   577: astore 13
    //   579: aload 17
    //   581: ldc_w 1128
    //   584: aload 18
    //   586: aload 19
    //   588: invokevirtual 438	com/google/android/gms/measurement/internal/zzfy:next	()Lcom/google/android/gms/measurement/internal/zzej;
    //   591: aload_2
    //   592: invokevirtual 442	com/google/android/gms/measurement/internal/zzej:get	(Ljava/lang/String;)Ljava/lang/String;
    //   595: invokevirtual 300	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   598: aload 16
    //   600: invokeinterface 278 1 0
    //   605: aload 15
    //   607: areturn
    //   608: astore 15
    //   610: goto +12 -> 622
    //   613: astore_1
    //   614: goto +60 -> 674
    //   617: astore 15
    //   619: aconst_null
    //   620: astore 14
    //   622: aload 14
    //   624: astore 13
    //   626: aload_0
    //   627: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   630: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   633: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   636: ldc_w 1130
    //   639: aload_1
    //   640: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   643: aload_0
    //   644: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   647: invokevirtual 438	com/google/android/gms/measurement/internal/zzfy:next	()Lcom/google/android/gms/measurement/internal/zzej;
    //   650: aload_2
    //   651: invokevirtual 442	com/google/android/gms/measurement/internal/zzej:get	(Ljava/lang/String;)Ljava/lang/String;
    //   654: aload 15
    //   656: invokevirtual 445	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   659: aload 14
    //   661: ifnull +27 -> 688
    //   664: aload 14
    //   666: invokeinterface 278 1 0
    //   671: aconst_null
    //   672: areturn
    //   673: astore_1
    //   674: aload 13
    //   676: ifnull +10 -> 686
    //   679: aload 13
    //   681: invokeinterface 278 1 0
    //   686: aload_1
    //   687: athrow
    //   688: aconst_null
    //   689: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	690	0	this	zzam
    //   0	690	1	paramString1	String
    //   0	690	2	paramString2	String
    //   214	2	3	i	int
    //   145	386	4	bool	boolean
    //   254	251	5	l1	long
    //   339	158	7	l2	long
    //   400	73	9	l3	long
    //   415	94	11	l4	long
    //   19	661	13	localObject1	Object
    //   25	640	14	localObject2	Object
    //   177	429	15	localObject3	Object
    //   608	1	15	localSQLiteException1	SQLiteException
    //   617	38	15	localSQLiteException2	SQLiteException
    //   128	471	16	localCursor	Cursor
    //   173	407	17	localObject4	Object
    //   200	385	18	localObject5	Object
    //   264	323	19	localObject6	Object
    //   275	228	20	localObject7	Object
    //   289	218	21	localObject8	Object
    //   425	7	22	localZzkz	zzkz
    // Exception table:
    //   from	to	target	type
    //   138	147	608	android/database/sqlite/SQLiteException
    //   165	175	608	android/database/sqlite/SQLiteException
    //   193	202	608	android/database/sqlite/SQLiteException
    //   206	215	608	android/database/sqlite/SQLiteException
    //   232	242	608	android/database/sqlite/SQLiteException
    //   246	256	608	android/database/sqlite/SQLiteException
    //   270	277	608	android/database/sqlite/SQLiteException
    //   281	291	608	android/database/sqlite/SQLiteException
    //   304	315	608	android/database/sqlite/SQLiteException
    //   330	341	608	android/database/sqlite/SQLiteException
    //   355	376	608	android/database/sqlite/SQLiteException
    //   391	402	608	android/database/sqlite/SQLiteException
    //   406	417	608	android/database/sqlite/SQLiteException
    //   431	452	608	android/database/sqlite/SQLiteException
    //   467	483	608	android/database/sqlite/SQLiteException
    //   487	517	608	android/database/sqlite/SQLiteException
    //   521	530	608	android/database/sqlite/SQLiteException
    //   549	559	608	android/database/sqlite/SQLiteException
    //   563	569	608	android/database/sqlite/SQLiteException
    //   579	598	608	android/database/sqlite/SQLiteException
    //   21	27	613	java/lang/Throwable
    //   27	130	613	java/lang/Throwable
    //   21	27	617	android/database/sqlite/SQLiteException
    //   27	130	617	android/database/sqlite/SQLiteException
    //   138	147	673	java/lang/Throwable
    //   165	175	673	java/lang/Throwable
    //   193	202	673	java/lang/Throwable
    //   206	215	673	java/lang/Throwable
    //   232	242	673	java/lang/Throwable
    //   246	256	673	java/lang/Throwable
    //   260	266	673	java/lang/Throwable
    //   270	277	673	java/lang/Throwable
    //   281	291	673	java/lang/Throwable
    //   295	300	673	java/lang/Throwable
    //   304	315	673	java/lang/Throwable
    //   319	326	673	java/lang/Throwable
    //   330	341	673	java/lang/Throwable
    //   345	351	673	java/lang/Throwable
    //   355	376	673	java/lang/Throwable
    //   380	387	673	java/lang/Throwable
    //   391	402	673	java/lang/Throwable
    //   406	417	673	java/lang/Throwable
    //   421	427	673	java/lang/Throwable
    //   431	452	673	java/lang/Throwable
    //   456	463	673	java/lang/Throwable
    //   467	483	673	java/lang/Throwable
    //   487	517	673	java/lang/Throwable
    //   521	530	673	java/lang/Throwable
    //   539	545	673	java/lang/Throwable
    //   549	559	673	java/lang/Throwable
    //   563	569	673	java/lang/Throwable
    //   579	598	673	java/lang/Throwable
    //   626	659	673	java/lang/Throwable
  }
  
  public final List load(String paramString, String[] paramArrayOfString)
  {
    append();
    size();
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    try
    {
      Object localObject5 = get();
      Object localObject6 = this$0;
      localObject1 = localObject3;
      localObject2 = localObject4;
      ((zzfy)localObject6).append();
      localObject1 = localObject3;
      localObject2 = localObject4;
      paramArrayOfString = ((SQLiteDatabase)localObject5).query("conditional_properties", new String[] { "app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event" }, paramString, paramArrayOfString, null, null, "rowid", "1001");
      paramString = paramArrayOfString;
      localObject1 = paramString;
      localObject2 = paramString;
      boolean bool = paramArrayOfString.moveToFirst();
      if (bool)
      {
        do
        {
          localObject1 = paramString;
          localObject2 = paramString;
          int i = localArrayList.size();
          localObject3 = this$0;
          localObject1 = paramString;
          localObject2 = paramString;
          ((zzfy)localObject3).append();
          if (i >= 1000)
          {
            localObject1 = paramString;
            localObject3 = this$0;
            localObject1 = paramString;
            localObject2 = paramString;
            localObject3 = ((zzfy)localObject3).zzay().iterator();
            localObject4 = this$0;
            localObject1 = paramString;
            localObject2 = paramString;
            ((zzfy)localObject4).append();
            localObject1 = paramString;
            localObject2 = paramString;
            ((zzem)localObject3).append("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(1000));
            break;
          }
          localObject1 = paramString;
          localObject2 = paramString;
          localObject3 = paramArrayOfString.getString(0);
          localObject1 = paramString;
          localObject2 = paramString;
          localObject4 = paramArrayOfString.getString(1);
          localObject1 = paramString;
          localObject2 = paramString;
          localObject6 = paramArrayOfString.getString(2);
          localObject1 = paramString;
          localObject2 = paramString;
          Object localObject7 = format(paramArrayOfString, 3);
          localObject1 = paramString;
          localObject2 = paramString;
          i = paramArrayOfString.getInt(4);
          if (i != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localObject1 = paramString;
          localObject2 = paramString;
          localObject5 = paramArrayOfString.getString(5);
          localObject1 = paramString;
          localObject2 = paramString;
          long l1 = paramArrayOfString.getLong(6);
          localObject1 = paramString;
          Object localObject8 = this$0;
          localObject1 = paramString;
          localObject2 = paramString;
          Object localObject9 = ((zzkz)localObject8).next();
          localObject1 = paramString;
          localObject2 = paramString;
          Object localObject10 = paramArrayOfString.getBlob(7);
          localObject1 = paramString;
          localObject8 = zzaw.CREATOR;
          localObject1 = paramString;
          localObject2 = paramString;
          localObject9 = ((zzlb)localObject9).get((byte[])localObject10, (Parcelable.Creator)localObject8);
          localObject1 = paramString;
          localObject9 = (zzaw)localObject9;
          localObject1 = paramString;
          localObject2 = paramString;
          long l2 = paramArrayOfString.getLong(8);
          localObject1 = paramString;
          localObject10 = this$0;
          localObject1 = paramString;
          localObject2 = paramString;
          localObject10 = ((zzkz)localObject10).next().get(paramArrayOfString.getBlob(9), (Parcelable.Creator)localObject8);
          localObject1 = paramString;
          localObject10 = (zzaw)localObject10;
          localObject1 = paramString;
          localObject2 = paramString;
          long l3 = paramArrayOfString.getLong(10);
          localObject1 = paramString;
          localObject2 = paramString;
          long l4 = paramArrayOfString.getLong(11);
          localObject1 = paramString;
          zzkz localZzkz = this$0;
          localObject1 = paramString;
          localObject2 = paramString;
          localObject8 = localZzkz.next().get(paramArrayOfString.getBlob(12), (Parcelable.Creator)localObject8);
          localObject1 = paramString;
          localObject8 = (zzaw)localObject8;
          localObject1 = paramString;
          localObject2 = paramString;
          localObject6 = new zzlc((String)localObject6, l3, localObject7, (String)localObject4);
          localObject1 = paramString;
          localObject2 = paramString;
          localArrayList.add(new zzac((String)localObject3, (String)localObject4, (zzlc)localObject6, l2, bool, (String)localObject5, (zzaw)localObject9, l1, (zzaw)localObject10, l4, (zzaw)localObject8));
          localObject1 = paramString;
          localObject2 = paramString;
          bool = paramArrayOfString.moveToNext();
        } while (bool);
        paramArrayOfString.close();
        return localArrayList;
      }
      paramArrayOfString.close();
      return localArrayList;
    }
    catch (Throwable paramString) {}catch (SQLiteException paramString)
    {
      localObject1 = localObject2;
      this$0.zzay().iterator().append("Error querying conditional user property value", paramString);
      localObject1 = localObject2;
      paramString = Collections.emptyList();
      if (localObject2 == null) {
        return paramString;
      }
    }
    ((Cursor)localObject2).close();
    return paramString;
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    throw paramString;
    return paramString;
  }
  
  public final boolean onStep()
  {
    return get("select count(1) > 0 from raw_events where realtime = 1", null) != 0L;
  }
  
  public final boolean parse(zzle paramZzle)
  {
    Preconditions.checkNotNull(paramZzle);
    append();
    size();
    long l;
    if (getString(header, size) == null) {
      if (zzlh.zzai(size))
      {
        if (get("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[] { header }) >= this$0.append().put(header, zzeb.filename, 25, 100)) {
          return false;
        }
      }
      else if (!"_npa".equals(size))
      {
        l = get("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[] { header, type });
        this$0.append();
        if (l >= 25L) {
          return false;
        }
      }
    }
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("app_id", header);
    ((ContentValues)localObject).put("origin", type);
    ((ContentValues)localObject).put("name", size);
    ((ContentValues)localObject).put("set_timestamp", Long.valueOf(offset));
    put((ContentValues)localObject, "value", data);
    try
    {
      l = get().insertWithOnConflict("user_attributes", null, (ContentValues)localObject, 5);
      if (l == -1L)
      {
        localObject = this$0;
        localObject = ((zzfy)localObject).zzay().iterator();
        String str = header;
        ((zzem)localObject).append("Failed to insert/update user property (got -1). appId", zzeo.get(str));
        return true;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      this$0.zzay().iterator().append("Error storing user property. appId", zzeo.get(header), localSQLiteException);
    }
    return true;
  }
  
  final void parseAndAdd()
  {
    append();
    size();
    if (getWritableDatabase())
    {
      long l2 = this$0.getName().this$0.get();
      long l1 = this$0.zzav().elapsedRealtime();
      l2 = Math.abs(l1 - l2);
      this$0.append();
      if (l2 > ((Long)zzeb.table.get(null)).longValue())
      {
        this$0.getName().this$0.put(l1);
        append();
        size();
        if (!getWritableDatabase()) {
          return;
        }
        SQLiteDatabase localSQLiteDatabase = get();
        l1 = this$0.zzav().currentTimeMillis();
        this$0.append();
        int i = localSQLiteDatabase.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[] { String.valueOf(l1), String.valueOf(zzag.parseAndAdd()) });
        if (i > 0) {
          this$0.zzay().next().append("Deleted stale rows. rowsDeleted", Integer.valueOf(i));
        }
      }
    }
  }
  
  public final long pollQueue()
  {
    return zzaa("select max(timestamp) from raw_events", null, 0L);
  }
  
  public final boolean put(zzac paramZzac)
  {
    Preconditions.checkNotNull(paramZzac);
    append();
    size();
    String str = name;
    Preconditions.checkNotNull(str);
    long l;
    if (getString(str, context.type) == null)
    {
      l = get("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[] { str });
      this$0.append();
      if (l >= 1000L) {
        return false;
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", str);
    localContentValues.put("origin", type);
    localContentValues.put("name", context.type);
    put(localContentValues, "value", Preconditions.checkNotNull(context.get()));
    localContentValues.put("active", Boolean.valueOf(status));
    localContentValues.put("trigger_event_name", text);
    localContentValues.put("trigger_timeout", Long.valueOf(id));
    localContentValues.put("timed_out_event", this$0.get().zzan(source));
    localContentValues.put("creation_timestamp", Long.valueOf(value));
    localContentValues.put("triggered_event", this$0.get().zzan(count));
    localContentValues.put("triggered_timestamp", Long.valueOf(context.size));
    localContentValues.put("time_to_live", Long.valueOf(size));
    localContentValues.put("expired_event", this$0.get().zzan(data));
    try
    {
      l = get().insertWithOnConflict("conditional_properties", null, localContentValues, 5);
      if (l == -1L)
      {
        paramZzac = this$0;
        paramZzac.zzay().iterator().append("Failed to insert/update conditional user property (got -1)", zzeo.get(str));
        return true;
      }
    }
    catch (SQLiteException paramZzac)
    {
      this$0.zzay().iterator().append("Error storing conditional user property", zzeo.get(str), paramZzac);
    }
    return true;
  }
  
  public final boolean put(String paramString, Long paramLong, long paramLong1, zzfs paramZzfs)
  {
    append();
    size();
    Preconditions.checkNotNull(paramZzfs);
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramLong);
    paramZzfs = paramZzfs.zzbv();
    this$0.zzay().next().append("Saving complex main event, appId, data size", this$0.next().toString(paramString), Integer.valueOf(paramZzfs.length));
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramString);
    localContentValues.put("event_id", paramLong);
    localContentValues.put("children_to_process", Long.valueOf(paramLong1));
    localContentValues.put("main_event", paramZzfs);
    try
    {
      paramLong1 = get().insertWithOnConflict("main_event_params", null, localContentValues, 5);
      if (paramLong1 == -1L)
      {
        paramLong = this$0;
        paramLong.zzay().iterator().append("Failed to insert complex main event (got -1). appId", zzeo.get(paramString));
        return false;
      }
      return true;
    }
    catch (SQLiteException paramLong)
    {
      this$0.zzay().iterator().append("Error storing complex main event. appId", zzeo.get(paramString), paramLong);
    }
    return false;
  }
  
  public final void read(Buffer paramBuffer)
  {
    Preconditions.checkNotNull(paramBuffer);
    append();
    size();
    String str = paramBuffer.getValue();
    Preconditions.checkNotNull(str);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", str);
    localContentValues.put("app_instance_id", paramBuffer.get());
    localContentValues.put("gmp_app_id", paramBuffer.encode());
    localContentValues.put("resettable_device_id_hash", paramBuffer.getTitle());
    localContentValues.put("last_bundle_index", Long.valueOf(paramBuffer.set()));
    localContentValues.put("last_bundle_start_timestamp", Long.valueOf(paramBuffer.available()));
    localContentValues.put("last_bundle_end_timestamp", Long.valueOf(paramBuffer.peek()));
    localContentValues.put("app_version", paramBuffer.getString());
    localContentValues.put("app_store", paramBuffer.getContent());
    localContentValues.put("gmp_version", Long.valueOf(paramBuffer.next()));
    localContentValues.put("dev_cert_hash", Long.valueOf(paramBuffer.getKey()));
    localContentValues.put("measurement_enabled", Boolean.valueOf(paramBuffer.zzai()));
    localContentValues.put("day", Long.valueOf(paramBuffer.getLength()));
    localContentValues.put("daily_public_events_count", Long.valueOf(paramBuffer.writeTo()));
    localContentValues.put("daily_events_count", Long.valueOf(paramBuffer.offset()));
    localContentValues.put("daily_conversions_count", Long.valueOf(paramBuffer.read()));
    localContentValues.put("config_fetched_time", Long.valueOf(paramBuffer.getPos()));
    localContentValues.put("failed_config_fetch_time", Long.valueOf(paramBuffer.getOffset()));
    localContentValues.put("app_version_int", Long.valueOf(paramBuffer.size()));
    localContentValues.put("firebase_instance_id", paramBuffer.format());
    localContentValues.put("daily_error_events_count", Long.valueOf(paramBuffer.copyTo()));
    localContentValues.put("daily_realtime_events_count", Long.valueOf(paramBuffer.getID()));
    localContentValues.put("health_monitor_sample", paramBuffer.getLabel());
    paramBuffer.put();
    localContentValues.put("android_id", Long.valueOf(0L));
    localContentValues.put("adid_reporting_enabled", Boolean.valueOf(paramBuffer.zzah()));
    localContentValues.put("admob_app_id", paramBuffer.name());
    localContentValues.put("dynamite_version", Long.valueOf(paramBuffer.readLong()));
    localContentValues.put("session_stitching_token", paramBuffer.getDate());
    paramBuffer = paramBuffer.getName();
    if (paramBuffer != null) {
      if (paramBuffer.isEmpty()) {
        this$0.zzay().hasNext().append("Safelisted events should not be an empty list. appId", str);
      } else {
        localContentValues.put("safelisted_events", TextUtils.join(",", paramBuffer));
      }
    }
    zzns.showMessageDetails();
    if ((this$0.append().get(null, zzeb.zzai)) && (!localContentValues.containsKey("safelisted_events"))) {
      localContentValues.put("safelisted_events", null);
    }
    try
    {
      paramBuffer = get();
      int i = paramBuffer.update("apps", localContentValues, "app_id = ?", new String[] { str });
      if (i == 0L)
      {
        long l = paramBuffer.insertWithOnConflict("apps", null, localContentValues, 5);
        if (l == -1L)
        {
          paramBuffer = this$0;
          paramBuffer.zzay().iterator().append("Failed to insert/update app (got -1). appId", zzeo.get(str));
          return;
        }
      }
    }
    catch (SQLiteException paramBuffer)
    {
      this$0.zzay().iterator().append("Error storing app. appId", zzeo.get(str), paramBuffer);
    }
  }
  
  protected final boolean registerAlarm()
  {
    return false;
  }
  
  /* Error */
  public final void reload(String paramString, long paramLong1, long paramLong2, zzkw paramZzkw)
  {
    // Byte code:
    //   0: aload 6
    //   2: invokestatic 317	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5: pop
    //   6: aload_0
    //   7: invokevirtual 345	com/google/android/gms/measurement/internal/zzgr:append	()V
    //   10: aload_0
    //   11: invokevirtual 348	com/google/android/gms/measurement/internal/zzkn:size	()V
    //   14: aconst_null
    //   15: astore 14
    //   17: aconst_null
    //   18: astore 11
    //   20: aconst_null
    //   21: astore 10
    //   23: aconst_null
    //   24: astore 13
    //   26: aload_0
    //   27: invokevirtual 259	com/google/android/gms/measurement/internal/zzam:get	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 16
    //   32: aconst_null
    //   33: invokestatic 563	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: istore 8
    //   38: ldc_w 529
    //   41: astore_1
    //   42: iload 8
    //   44: ifeq +225 -> 269
    //   47: lload 4
    //   49: ldc2_w 413
    //   52: lcmp
    //   53: istore 7
    //   55: iload 7
    //   57: ifeq +29 -> 86
    //   60: iconst_2
    //   61: anewarray 21	java/lang/String
    //   64: astore 9
    //   66: aload 9
    //   68: iconst_0
    //   69: lload 4
    //   71: invokestatic 1226	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   74: aastore
    //   75: aload 9
    //   77: iconst_1
    //   78: lload_2
    //   79: invokestatic 1226	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   82: aastore
    //   83: goto +17 -> 100
    //   86: iconst_1
    //   87: anewarray 21	java/lang/String
    //   90: astore 9
    //   92: aload 9
    //   94: iconst_0
    //   95: lload_2
    //   96: invokestatic 1226	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   99: aastore
    //   100: iload 7
    //   102: ifeq +7 -> 109
    //   105: ldc_w 1393
    //   108: astore_1
    //   109: new 469	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 470	java/lang/StringBuilder:<init>	()V
    //   116: astore 12
    //   118: aload 12
    //   120: ldc_w 1395
    //   123: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 12
    //   129: aload_1
    //   130: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 12
    //   136: ldc_w 1397
    //   139: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 16
    //   145: aload 12
    //   147: invokevirtual 481	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: aload 9
    //   152: invokevirtual 265	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   155: astore 14
    //   157: aload 14
    //   159: astore 12
    //   161: aload 13
    //   163: astore 11
    //   165: aload 12
    //   167: astore 10
    //   169: aload 12
    //   171: astore_1
    //   172: aload 14
    //   174: invokeinterface 271 1 0
    //   179: istore 8
    //   181: iload 8
    //   183: ifne +11 -> 194
    //   186: aload 14
    //   188: invokeinterface 278 1 0
    //   193: return
    //   194: aload 13
    //   196: astore 11
    //   198: aload 12
    //   200: astore 10
    //   202: aload 12
    //   204: astore_1
    //   205: aload 14
    //   207: iconst_0
    //   208: invokeinterface 527 2 0
    //   213: astore 9
    //   215: aload 9
    //   217: astore 11
    //   219: aload 12
    //   221: astore 10
    //   223: aload 12
    //   225: astore_1
    //   226: aload 14
    //   228: iconst_1
    //   229: invokeinterface 527 2 0
    //   234: astore 13
    //   236: aload 9
    //   238: astore 11
    //   240: aload 12
    //   242: astore 10
    //   244: aload 12
    //   246: astore_1
    //   247: aload 14
    //   249: invokeinterface 278 1 0
    //   254: aload 13
    //   256: astore_1
    //   257: goto +199 -> 456
    //   260: astore 9
    //   262: aload 10
    //   264: astore 6
    //   266: goto +1014 -> 1280
    //   269: lload 4
    //   271: ldc2_w 413
    //   274: lcmp
    //   275: istore 7
    //   277: iload 7
    //   279: ifeq +26 -> 305
    //   282: iconst_2
    //   283: anewarray 21	java/lang/String
    //   286: astore 9
    //   288: aload 9
    //   290: iconst_0
    //   291: aconst_null
    //   292: aastore
    //   293: aload 9
    //   295: iconst_1
    //   296: lload 4
    //   298: invokestatic 1226	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   301: aastore
    //   302: goto +14 -> 316
    //   305: iconst_1
    //   306: anewarray 21	java/lang/String
    //   309: astore 9
    //   311: aload 9
    //   313: iconst_0
    //   314: aconst_null
    //   315: aastore
    //   316: iload 7
    //   318: ifeq +7 -> 325
    //   321: ldc_w 1399
    //   324: astore_1
    //   325: new 469	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 470	java/lang/StringBuilder:<init>	()V
    //   332: astore 12
    //   334: aload 12
    //   336: ldc_w 1401
    //   339: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 12
    //   345: aload_1
    //   346: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 12
    //   352: ldc_w 1403
    //   355: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 16
    //   361: aload 12
    //   363: invokevirtual 481	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: aload 9
    //   368: invokevirtual 265	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   371: astore 15
    //   373: aload 15
    //   375: astore 12
    //   377: aload 13
    //   379: astore 11
    //   381: aload 12
    //   383: astore 10
    //   385: aload 12
    //   387: astore_1
    //   388: aload 15
    //   390: invokeinterface 271 1 0
    //   395: istore 8
    //   397: iload 8
    //   399: ifne +11 -> 410
    //   402: aload 15
    //   404: invokeinterface 278 1 0
    //   409: return
    //   410: aload 13
    //   412: astore 11
    //   414: aload 12
    //   416: astore 10
    //   418: aload 12
    //   420: astore_1
    //   421: aload 15
    //   423: iconst_0
    //   424: invokeinterface 527 2 0
    //   429: astore 9
    //   431: aload 13
    //   433: astore 11
    //   435: aload 12
    //   437: astore 10
    //   439: aload 12
    //   441: astore_1
    //   442: aload 15
    //   444: invokeinterface 278 1 0
    //   449: aload 9
    //   451: astore_1
    //   452: aload 14
    //   454: astore 9
    //   456: iconst_2
    //   457: anewarray 21	java/lang/String
    //   460: dup
    //   461: iconst_0
    //   462: aload 9
    //   464: aastore
    //   465: dup
    //   466: iconst_1
    //   467: aload_1
    //   468: aastore
    //   469: checkcast 574	[Ljava/lang/String;
    //   472: astore 10
    //   474: aload 16
    //   476: ldc_w 1405
    //   479: iconst_1
    //   480: anewarray 21	java/lang/String
    //   483: dup
    //   484: iconst_0
    //   485: ldc_w 1407
    //   488: aastore
    //   489: ldc_w 1409
    //   492: aload 10
    //   494: aconst_null
    //   495: aconst_null
    //   496: ldc_w 517
    //   499: ldc_w 1411
    //   502: invokevirtual 523	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   505: astore 10
    //   507: aload 10
    //   509: invokeinterface 271 1 0
    //   514: istore 8
    //   516: iload 8
    //   518: ifne +43 -> 561
    //   521: aload_0
    //   522: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   525: astore_1
    //   526: aload_1
    //   527: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   530: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   533: astore_1
    //   534: aload 9
    //   536: checkcast 21	java/lang/String
    //   539: astore 6
    //   541: aload_1
    //   542: ldc_w 1413
    //   545: aload 6
    //   547: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   550: invokevirtual 422	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   553: aload 10
    //   555: invokeinterface 278 1 0
    //   560: return
    //   561: aload 10
    //   563: iconst_0
    //   564: invokeinterface 1105 2 0
    //   569: astore 11
    //   571: invokestatic 1418	com/google/android/gms/internal/measurement/zzgc:split	()Lcom/google/android/gms/internal/measurement/zzgb;
    //   574: aload 11
    //   576: invokestatic 1421	com/google/android/gms/measurement/internal/zzlb:equals	(Lcom/google/android/gms/internal/measurement/zzlk;[B)Lcom/google/android/gms/internal/measurement/zzlk;
    //   579: astore 11
    //   581: aload 11
    //   583: checkcast 1423	com/google/android/gms/internal/measurement/zzgb
    //   586: astore 11
    //   588: aload 11
    //   590: invokevirtual 657	com/google/android/gms/internal/measurement/zzka:zzaE	()Lcom/google/android/gms/internal/measurement/zzke;
    //   593: astore 11
    //   595: aload 11
    //   597: checkcast 1415	com/google/android/gms/internal/measurement/zzgc
    //   600: astore 11
    //   602: aload 10
    //   604: invokeinterface 546 1 0
    //   609: istore 8
    //   611: iload 8
    //   613: ifeq +39 -> 652
    //   616: aload_0
    //   617: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   620: astore 12
    //   622: aload 12
    //   624: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   627: invokevirtual 490	com/google/android/gms/measurement/internal/zzeo:hasNext	()Lcom/google/android/gms/measurement/internal/zzem;
    //   630: astore 12
    //   632: aload 9
    //   634: checkcast 21	java/lang/String
    //   637: astore 13
    //   639: aload 12
    //   641: ldc_w 1425
    //   644: aload 13
    //   646: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   649: invokevirtual 422	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   652: aload 10
    //   654: invokeinterface 278 1 0
    //   659: aload 11
    //   661: invokestatic 317	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   664: pop
    //   665: aload 6
    //   667: aload 11
    //   669: putfield 1430	com/google/android/gms/measurement/internal/zzkw:this$0	Lcom/google/android/gms/internal/measurement/zzgc;
    //   672: lload 4
    //   674: ldc2_w 413
    //   677: lcmp
    //   678: ifeq +36 -> 714
    //   681: iconst_3
    //   682: anewarray 21	java/lang/String
    //   685: astore 11
    //   687: aload 11
    //   689: iconst_0
    //   690: aload 9
    //   692: aastore
    //   693: aload 11
    //   695: iconst_1
    //   696: aload_1
    //   697: aastore
    //   698: aload 11
    //   700: iconst_2
    //   701: lload 4
    //   703: invokestatic 1226	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   706: aastore
    //   707: ldc_w 1432
    //   710: astore_1
    //   711: goto +24 -> 735
    //   714: iconst_2
    //   715: anewarray 21	java/lang/String
    //   718: astore 11
    //   720: aload 11
    //   722: iconst_0
    //   723: aload 9
    //   725: aastore
    //   726: aload 11
    //   728: iconst_1
    //   729: aload_1
    //   730: aastore
    //   731: ldc_w 1409
    //   734: astore_1
    //   735: aload 11
    //   737: checkcast 574	[Ljava/lang/String;
    //   740: astore 11
    //   742: aload 16
    //   744: ldc_w 1434
    //   747: iconst_4
    //   748: anewarray 21	java/lang/String
    //   751: dup
    //   752: iconst_0
    //   753: ldc_w 517
    //   756: aastore
    //   757: dup
    //   758: iconst_1
    //   759: ldc_w 360
    //   762: aastore
    //   763: dup
    //   764: iconst_2
    //   765: ldc_w 1436
    //   768: aastore
    //   769: dup
    //   770: iconst_3
    //   771: ldc_w 777
    //   774: aastore
    //   775: aload_1
    //   776: aload 11
    //   778: aconst_null
    //   779: aconst_null
    //   780: ldc_w 517
    //   783: aconst_null
    //   784: invokevirtual 523	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   787: astore 13
    //   789: aload 13
    //   791: astore 12
    //   793: aload 9
    //   795: astore 11
    //   797: aload 12
    //   799: astore 10
    //   801: aload 12
    //   803: astore_1
    //   804: aload 13
    //   806: invokeinterface 271 1 0
    //   811: istore 8
    //   813: iload 8
    //   815: ifeq +282 -> 1097
    //   818: aload 9
    //   820: astore 11
    //   822: aload 12
    //   824: astore 10
    //   826: aload 12
    //   828: astore_1
    //   829: aload 13
    //   831: iconst_0
    //   832: invokeinterface 275 2 0
    //   837: lstore_2
    //   838: aload 9
    //   840: astore 11
    //   842: aload 12
    //   844: astore 10
    //   846: aload 12
    //   848: astore_1
    //   849: aload 13
    //   851: iconst_3
    //   852: invokeinterface 1105 2 0
    //   857: astore 14
    //   859: aload 9
    //   861: astore 11
    //   863: aload 12
    //   865: astore 10
    //   867: aload 12
    //   869: astore_1
    //   870: invokestatic 1441	com/google/android/gms/internal/measurement/zzfs:getKey	()Lcom/google/android/gms/internal/measurement/zzfr;
    //   873: aload 14
    //   875: invokestatic 1421	com/google/android/gms/measurement/internal/zzlb:equals	(Lcom/google/android/gms/internal/measurement/zzlk;[B)Lcom/google/android/gms/internal/measurement/zzlk;
    //   878: astore 14
    //   880: aload 12
    //   882: astore_1
    //   883: aload 14
    //   885: checkcast 1443	com/google/android/gms/internal/measurement/zzfr
    //   888: astore 14
    //   890: aload 9
    //   892: astore 11
    //   894: aload 12
    //   896: astore 10
    //   898: aload 12
    //   900: astore_1
    //   901: aload 14
    //   903: aload 13
    //   905: iconst_1
    //   906: invokeinterface 527 2 0
    //   911: invokevirtual 1446	com/google/android/gms/internal/measurement/zzfr:put	(Ljava/lang/String;)Lcom/google/android/gms/internal/measurement/zzfr;
    //   914: pop
    //   915: aload 9
    //   917: astore 11
    //   919: aload 12
    //   921: astore 10
    //   923: aload 12
    //   925: astore_1
    //   926: aload 14
    //   928: aload 13
    //   930: iconst_2
    //   931: invokeinterface 275 2 0
    //   936: invokevirtual 1449	com/google/android/gms/internal/measurement/zzfr:append	(J)Lcom/google/android/gms/internal/measurement/zzfr;
    //   939: pop
    //   940: aload 9
    //   942: astore 11
    //   944: aload 12
    //   946: astore 10
    //   948: aload 12
    //   950: astore_1
    //   951: aload 14
    //   953: invokevirtual 657	com/google/android/gms/internal/measurement/zzka:zzaE	()Lcom/google/android/gms/internal/measurement/zzke;
    //   956: astore 14
    //   958: aload 14
    //   960: checkcast 1438	com/google/android/gms/internal/measurement/zzfs
    //   963: astore 14
    //   965: aload 9
    //   967: astore 11
    //   969: aload 12
    //   971: astore 10
    //   973: aload 12
    //   975: astore_1
    //   976: aload 6
    //   978: lload_2
    //   979: aload 14
    //   981: invokevirtual 1452	com/google/android/gms/measurement/internal/zzkw:add	(JLcom/google/android/gms/internal/measurement/zzfs;)Z
    //   984: istore 8
    //   986: iload 8
    //   988: ifne +76 -> 1064
    //   991: aload 13
    //   993: invokeinterface 278 1 0
    //   998: return
    //   999: astore 14
    //   1001: aload 12
    //   1003: astore_1
    //   1004: aload_0
    //   1005: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   1008: astore 15
    //   1010: aload 9
    //   1012: astore 11
    //   1014: aload 12
    //   1016: astore 10
    //   1018: aload 12
    //   1020: astore_1
    //   1021: aload 15
    //   1023: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   1026: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1029: astore 15
    //   1031: aload 9
    //   1033: checkcast 21	java/lang/String
    //   1036: astore 16
    //   1038: aload 9
    //   1040: astore 11
    //   1042: aload 12
    //   1044: astore 10
    //   1046: aload 12
    //   1048: astore_1
    //   1049: aload 15
    //   1051: ldc_w 1454
    //   1054: aload 16
    //   1056: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1059: aload 14
    //   1061: invokevirtual 300	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1064: aload 9
    //   1066: astore 11
    //   1068: aload 12
    //   1070: astore 10
    //   1072: aload 12
    //   1074: astore_1
    //   1075: aload 13
    //   1077: invokeinterface 546 1 0
    //   1082: istore 8
    //   1084: iload 8
    //   1086: ifne -268 -> 818
    //   1089: aload 13
    //   1091: invokeinterface 278 1 0
    //   1096: return
    //   1097: aload 12
    //   1099: astore_1
    //   1100: aload_0
    //   1101: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   1104: astore 6
    //   1106: aload 9
    //   1108: astore 11
    //   1110: aload 12
    //   1112: astore 10
    //   1114: aload 12
    //   1116: astore_1
    //   1117: aload 6
    //   1119: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   1122: invokevirtual 490	com/google/android/gms/measurement/internal/zzeo:hasNext	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1125: astore 6
    //   1127: aload 9
    //   1129: checkcast 21	java/lang/String
    //   1132: astore 14
    //   1134: aload 9
    //   1136: astore 11
    //   1138: aload 12
    //   1140: astore 10
    //   1142: aload 12
    //   1144: astore_1
    //   1145: aload 6
    //   1147: ldc_w 1456
    //   1150: aload 14
    //   1152: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1155: invokevirtual 422	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1158: aload 13
    //   1160: invokeinterface 278 1 0
    //   1165: return
    //   1166: astore_1
    //   1167: aload_0
    //   1168: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   1171: astore 6
    //   1173: aload 6
    //   1175: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   1178: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1181: astore 6
    //   1183: aload 9
    //   1185: checkcast 21	java/lang/String
    //   1188: astore 11
    //   1190: aload 6
    //   1192: ldc_w 1458
    //   1195: aload 11
    //   1197: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1200: aload_1
    //   1201: invokevirtual 300	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1204: aload 10
    //   1206: invokeinterface 278 1 0
    //   1211: return
    //   1212: astore 6
    //   1214: goto +9 -> 1223
    //   1217: astore_1
    //   1218: goto +12 -> 1230
    //   1221: astore 6
    //   1223: aload 10
    //   1225: astore_1
    //   1226: goto +98 -> 1324
    //   1229: astore_1
    //   1230: aload 10
    //   1232: astore 6
    //   1234: aload 9
    //   1236: astore 11
    //   1238: aload_1
    //   1239: astore 9
    //   1241: goto +39 -> 1280
    //   1244: astore 6
    //   1246: aload 12
    //   1248: astore_1
    //   1249: goto +75 -> 1324
    //   1252: astore_1
    //   1253: aload 9
    //   1255: astore 11
    //   1257: aload 12
    //   1259: astore 6
    //   1261: aload_1
    //   1262: astore 9
    //   1264: goto +16 -> 1280
    //   1267: astore 6
    //   1269: aload 10
    //   1271: astore_1
    //   1272: goto +52 -> 1324
    //   1275: astore 9
    //   1277: aconst_null
    //   1278: astore 6
    //   1280: aload 6
    //   1282: astore_1
    //   1283: aload_0
    //   1284: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   1287: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   1290: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1293: ldc_w 1460
    //   1296: aload 11
    //   1298: checkcast 21	java/lang/String
    //   1301: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1304: aload 9
    //   1306: invokevirtual 300	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1309: aload 6
    //   1311: ifnull +29 -> 1340
    //   1314: aload 6
    //   1316: invokeinterface 278 1 0
    //   1321: return
    //   1322: astore 6
    //   1324: aload_1
    //   1325: ifnull +12 -> 1337
    //   1328: aload_1
    //   1329: checkcast 267	android/database/Cursor
    //   1332: invokeinterface 278 1 0
    //   1337: aload 6
    //   1339: athrow
    //   1340: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1341	0	this	zzam
    //   0	1341	1	paramString	String
    //   0	1341	2	paramLong1	long
    //   0	1341	4	paramLong2	long
    //   0	1341	6	paramZzkw	zzkw
    //   53	264	7	bool1	boolean
    //   36	1049	8	bool2	boolean
    //   64	173	9	localObject1	Object
    //   260	1	9	localSQLiteException1	SQLiteException
    //   286	977	9	localObject2	Object
    //   1275	30	9	localSQLiteException2	SQLiteException
    //   21	1249	10	localObject3	Object
    //   18	1279	11	localObject4	Object
    //   116	1142	12	localObject5	Object
    //   24	1135	13	localObject6	Object
    //   15	965	14	localObject7	Object
    //   999	61	14	localIOException	java.io.IOException
    //   1132	19	14	str	String
    //   371	679	15	localObject8	Object
    //   30	1025	16	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   172	181	260	android/database/sqlite/SQLiteException
    //   205	215	260	android/database/sqlite/SQLiteException
    //   226	236	260	android/database/sqlite/SQLiteException
    //   247	254	260	android/database/sqlite/SQLiteException
    //   388	397	260	android/database/sqlite/SQLiteException
    //   421	431	260	android/database/sqlite/SQLiteException
    //   442	449	260	android/database/sqlite/SQLiteException
    //   804	813	260	android/database/sqlite/SQLiteException
    //   829	838	260	android/database/sqlite/SQLiteException
    //   849	859	260	android/database/sqlite/SQLiteException
    //   870	880	260	android/database/sqlite/SQLiteException
    //   901	915	260	android/database/sqlite/SQLiteException
    //   926	940	260	android/database/sqlite/SQLiteException
    //   951	958	260	android/database/sqlite/SQLiteException
    //   976	986	260	android/database/sqlite/SQLiteException
    //   1021	1031	260	android/database/sqlite/SQLiteException
    //   1049	1064	260	android/database/sqlite/SQLiteException
    //   1075	1084	260	android/database/sqlite/SQLiteException
    //   1117	1127	260	android/database/sqlite/SQLiteException
    //   1145	1158	260	android/database/sqlite/SQLiteException
    //   870	880	999	java/io/IOException
    //   571	581	1166	java/io/IOException
    //   588	595	1166	java/io/IOException
    //   742	789	1212	java/lang/Throwable
    //   1167	1173	1212	java/lang/Throwable
    //   1173	1183	1212	java/lang/Throwable
    //   1190	1204	1212	java/lang/Throwable
    //   742	789	1217	android/database/sqlite/SQLiteException
    //   1173	1183	1217	android/database/sqlite/SQLiteException
    //   1190	1204	1217	android/database/sqlite/SQLiteException
    //   507	516	1221	java/lang/Throwable
    //   521	526	1221	java/lang/Throwable
    //   526	534	1221	java/lang/Throwable
    //   541	553	1221	java/lang/Throwable
    //   561	571	1221	java/lang/Throwable
    //   571	581	1221	java/lang/Throwable
    //   581	588	1221	java/lang/Throwable
    //   588	595	1221	java/lang/Throwable
    //   595	602	1221	java/lang/Throwable
    //   602	611	1221	java/lang/Throwable
    //   616	622	1221	java/lang/Throwable
    //   622	632	1221	java/lang/Throwable
    //   632	639	1221	java/lang/Throwable
    //   639	652	1221	java/lang/Throwable
    //   652	665	1221	java/lang/Throwable
    //   665	672	1221	java/lang/Throwable
    //   681	687	1221	java/lang/Throwable
    //   714	720	1221	java/lang/Throwable
    //   507	516	1229	android/database/sqlite/SQLiteException
    //   526	534	1229	android/database/sqlite/SQLiteException
    //   541	553	1229	android/database/sqlite/SQLiteException
    //   561	571	1229	android/database/sqlite/SQLiteException
    //   571	581	1229	android/database/sqlite/SQLiteException
    //   588	595	1229	android/database/sqlite/SQLiteException
    //   602	611	1229	android/database/sqlite/SQLiteException
    //   622	632	1229	android/database/sqlite/SQLiteException
    //   639	652	1229	android/database/sqlite/SQLiteException
    //   652	665	1229	android/database/sqlite/SQLiteException
    //   474	507	1244	java/lang/Throwable
    //   474	507	1252	android/database/sqlite/SQLiteException
    //   26	38	1267	java/lang/Throwable
    //   60	66	1267	java/lang/Throwable
    //   86	92	1267	java/lang/Throwable
    //   109	157	1267	java/lang/Throwable
    //   282	288	1267	java/lang/Throwable
    //   305	311	1267	java/lang/Throwable
    //   325	373	1267	java/lang/Throwable
    //   26	38	1275	android/database/sqlite/SQLiteException
    //   109	157	1275	android/database/sqlite/SQLiteException
    //   325	373	1275	android/database/sqlite/SQLiteException
    //   172	181	1322	java/lang/Throwable
    //   205	215	1322	java/lang/Throwable
    //   226	236	1322	java/lang/Throwable
    //   247	254	1322	java/lang/Throwable
    //   388	397	1322	java/lang/Throwable
    //   421	431	1322	java/lang/Throwable
    //   442	449	1322	java/lang/Throwable
    //   804	813	1322	java/lang/Throwable
    //   829	838	1322	java/lang/Throwable
    //   849	859	1322	java/lang/Throwable
    //   870	880	1322	java/lang/Throwable
    //   883	890	1322	java/lang/Throwable
    //   901	915	1322	java/lang/Throwable
    //   926	940	1322	java/lang/Throwable
    //   951	958	1322	java/lang/Throwable
    //   976	986	1322	java/lang/Throwable
    //   1004	1010	1322	java/lang/Throwable
    //   1021	1031	1322	java/lang/Throwable
    //   1049	1064	1322	java/lang/Throwable
    //   1075	1084	1322	java/lang/Throwable
    //   1100	1106	1322	java/lang/Throwable
    //   1117	1127	1322	java/lang/Throwable
    //   1145	1158	1322	java/lang/Throwable
    //   1283	1309	1322	java/lang/Throwable
  }
  
  public final int remove(String paramString1, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    append();
    size();
    try
    {
      SQLiteDatabase localSQLiteDatabase = get();
      int i = localSQLiteDatabase.delete("conditional_properties", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      return i;
    }
    catch (SQLiteException localSQLiteException)
    {
      this$0.zzay().iterator().append("Error deleting conditional property", zzeo.get(paramString1), this$0.next().get(paramString2), localSQLiteException);
    }
    return 0;
  }
  
  public final zzak remove(long paramLong1, String paramString, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    Preconditions.checkNotEmpty(paramString);
    append();
    size();
    zzak localZzak = new zzak();
    Cursor localCursor3 = null;
    Cursor localCursor2 = null;
    Object localObject1 = localCursor2;
    Cursor localCursor1 = localCursor3;
    try
    {
      Object localObject2 = get();
      localObject1 = localCursor2;
      localCursor1 = localCursor3;
      localCursor3 = ((SQLiteDatabase)localObject2).query("apps", new String[] { "day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count" }, "app_id=?", new String[] { paramString }, null, null, null);
      localCursor2 = localCursor3;
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      boolean bool = localCursor3.moveToFirst();
      if (!bool)
      {
        localObject2 = this$0;
        localObject1 = localCursor2;
        localCursor1 = localCursor2;
        ((zzfy)localObject2).zzay().hasNext().append("Not updating daily counts, app is not known. appId", zzeo.get(paramString));
        localCursor3.close();
        return localZzak;
      }
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      long l = localCursor3.getLong(0);
      if (l == paramLong1)
      {
        localObject1 = localCursor2;
        localCursor1 = localCursor2;
        l = localCursor3.getLong(1);
        localObject1 = localCursor2;
        size = l;
        localObject1 = localCursor2;
        localCursor1 = localCursor2;
        l = localCursor3.getLong(2);
        localObject1 = localCursor2;
        value = l;
        localObject1 = localCursor2;
        localCursor1 = localCursor2;
        l = localCursor3.getLong(3);
        localObject1 = localCursor2;
        offset = l;
        localObject1 = localCursor2;
        localCursor1 = localCursor2;
        l = localCursor3.getLong(4);
        localObject1 = localCursor2;
        length = l;
        localObject1 = localCursor2;
        localCursor1 = localCursor2;
        l = localCursor3.getLong(5);
        localObject1 = localCursor2;
        key = l;
      }
      if (paramBoolean1)
      {
        localObject1 = localCursor2;
        l = size;
        localObject1 = localCursor2;
        size = (l + paramLong2);
      }
      if (paramBoolean2)
      {
        localObject1 = localCursor2;
        l = value;
        localObject1 = localCursor2;
        value = (l + paramLong2);
      }
      if (paramBoolean3)
      {
        localObject1 = localCursor2;
        l = offset;
        localObject1 = localCursor2;
        offset = (l + paramLong2);
      }
      if (paramBoolean4)
      {
        localObject1 = localCursor2;
        l = length;
        localObject1 = localCursor2;
        length = (l + paramLong2);
      }
      if (paramBoolean5)
      {
        localObject1 = localCursor2;
        l = key;
        localObject1 = localCursor2;
        key = (l + paramLong2);
      }
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      ContentValues localContentValues = new ContentValues();
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("day", Long.valueOf(paramLong1));
      localObject1 = localCursor2;
      paramLong1 = value;
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("daily_public_events_count", Long.valueOf(paramLong1));
      localObject1 = localCursor2;
      paramLong1 = size;
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("daily_events_count", Long.valueOf(paramLong1));
      localObject1 = localCursor2;
      paramLong1 = offset;
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("daily_conversions_count", Long.valueOf(paramLong1));
      localObject1 = localCursor2;
      paramLong1 = length;
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("daily_error_events_count", Long.valueOf(paramLong1));
      paramLong1 = key;
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("daily_realtime_events_count", Long.valueOf(paramLong1));
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      ((SQLiteDatabase)localObject2).update("apps", localContentValues, "app_id=?", new String[] { paramString });
      localCursor3.close();
      return localZzak;
    }
    catch (Throwable paramString) {}catch (SQLiteException localSQLiteException)
    {
      localObject1 = localCursor1;
      this$0.zzay().iterator().append("Error updating daily counts. appId", zzeo.get(paramString), localSQLiteException);
      if (localCursor1 == null) {
        break label775;
      }
    }
    localCursor1.close();
    return localZzak;
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    throw paramString;
    label775:
    return localZzak;
  }
  
  public final zzak reset(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    return remove(paramLong, paramString, 1L, false, false, paramBoolean3, false, paramBoolean5);
  }
  
  public final void resolve()
  {
    size();
    get().endTransaction();
  }
  
  /* Error */
  public final android.os.Bundle write(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 345	com/google/android/gms/measurement/internal/zzgr:append	()V
    //   4: aload_0
    //   5: invokevirtual 348	com/google/android/gms/measurement/internal/zzkn:size	()V
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: invokevirtual 259	com/google/android/gms/measurement/internal/zzam:get	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 4
    //   16: aload 4
    //   18: ldc_w 1487
    //   21: iconst_1
    //   22: anewarray 21	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aastore
    //   29: invokevirtual 265	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 5
    //   34: aload 5
    //   36: astore 4
    //   38: aload 4
    //   40: astore_3
    //   41: aload 5
    //   43: invokeinterface 271 1 0
    //   48: istore_2
    //   49: iload_2
    //   50: ifne +33 -> 83
    //   53: aload_0
    //   54: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   57: astore_1
    //   58: aload 4
    //   60: astore_3
    //   61: aload_1
    //   62: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   65: invokevirtual 1230	com/google/android/gms/measurement/internal/zzeo:next	()Lcom/google/android/gms/measurement/internal/zzem;
    //   68: ldc_w 1489
    //   71: invokevirtual 494	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;)V
    //   74: aload 5
    //   76: invokeinterface 278 1 0
    //   81: aconst_null
    //   82: areturn
    //   83: aload 4
    //   85: astore_3
    //   86: aload 5
    //   88: iconst_0
    //   89: invokeinterface 1105 2 0
    //   94: astore 6
    //   96: aload 4
    //   98: astore_3
    //   99: invokestatic 1441	com/google/android/gms/internal/measurement/zzfs:getKey	()Lcom/google/android/gms/internal/measurement/zzfr;
    //   102: aload 6
    //   104: invokestatic 1421	com/google/android/gms/measurement/internal/zzlb:equals	(Lcom/google/android/gms/internal/measurement/zzlk;[B)Lcom/google/android/gms/internal/measurement/zzlk;
    //   107: astore 6
    //   109: aload 4
    //   111: astore_3
    //   112: aload 6
    //   114: checkcast 1443	com/google/android/gms/internal/measurement/zzfr
    //   117: astore 6
    //   119: aload 4
    //   121: astore_3
    //   122: aload 6
    //   124: invokevirtual 657	com/google/android/gms/internal/measurement/zzka:zzaE	()Lcom/google/android/gms/internal/measurement/zzke;
    //   127: astore 6
    //   129: aload 4
    //   131: astore_3
    //   132: aload 6
    //   134: checkcast 1438	com/google/android/gms/internal/measurement/zzfs
    //   137: astore_1
    //   138: aload 4
    //   140: astore_3
    //   141: aload_0
    //   142: getfield 974	com/google/android/gms/measurement/internal/zzkm:this$0	Lcom/google/android/gms/measurement/internal/zzkz;
    //   145: astore 6
    //   147: aload 4
    //   149: astore_3
    //   150: aload 6
    //   152: invokevirtual 1101	com/google/android/gms/measurement/internal/zzkz:next	()Lcom/google/android/gms/measurement/internal/zzlb;
    //   155: pop
    //   156: aload 4
    //   158: astore_3
    //   159: aload_1
    //   160: invokevirtual 1491	com/google/android/gms/internal/measurement/zzfs:get	()Ljava/util/List;
    //   163: astore 6
    //   165: aload 4
    //   167: astore_3
    //   168: new 1493	android/os/Bundle
    //   171: dup
    //   172: invokespecial 1494	android/os/Bundle:<init>	()V
    //   175: astore_1
    //   176: aload 4
    //   178: astore_3
    //   179: aload 6
    //   181: invokeinterface 704 1 0
    //   186: astore 6
    //   188: aload 4
    //   190: astore_3
    //   191: aload 6
    //   193: invokeinterface 708 1 0
    //   198: istore_2
    //   199: iload_2
    //   200: ifeq +152 -> 352
    //   203: aload 4
    //   205: astore_3
    //   206: aload 6
    //   208: invokeinterface 711 1 0
    //   213: astore 7
    //   215: aload 7
    //   217: checkcast 1496	com/google/android/gms/internal/measurement/zzfw
    //   220: astore 7
    //   222: aload 4
    //   224: astore_3
    //   225: aload 7
    //   227: invokevirtual 1497	com/google/android/gms/internal/measurement/zzfw:getValue	()Ljava/lang/String;
    //   230: astore 8
    //   232: aload 4
    //   234: astore_3
    //   235: aload 7
    //   237: invokevirtual 1498	com/google/android/gms/internal/measurement/zzfw:booleanValue	()Z
    //   240: istore_2
    //   241: iload_2
    //   242: ifeq +20 -> 262
    //   245: aload 4
    //   247: astore_3
    //   248: aload_1
    //   249: aload 8
    //   251: aload 7
    //   253: invokevirtual 1501	com/google/android/gms/internal/measurement/zzfw:split	()D
    //   256: invokevirtual 1507	android/os/BaseBundle:putDouble	(Ljava/lang/String;D)V
    //   259: goto -71 -> 188
    //   262: aload 4
    //   264: astore_3
    //   265: aload 7
    //   267: invokevirtual 1510	com/google/android/gms/internal/measurement/zzfw:sendChar	()Z
    //   270: istore_2
    //   271: iload_2
    //   272: ifeq +20 -> 292
    //   275: aload 4
    //   277: astore_3
    //   278: aload_1
    //   279: aload 8
    //   281: aload 7
    //   283: invokevirtual 1513	com/google/android/gms/internal/measurement/zzfw:getKey	()F
    //   286: invokevirtual 1517	android/os/Bundle:putFloat	(Ljava/lang/String;F)V
    //   289: goto -101 -> 188
    //   292: aload 4
    //   294: astore_3
    //   295: aload 7
    //   297: invokevirtual 1519	com/google/android/gms/internal/measurement/zzfw:add	()Z
    //   300: istore_2
    //   301: iload_2
    //   302: ifeq +20 -> 322
    //   305: aload 4
    //   307: astore_3
    //   308: aload_1
    //   309: aload 8
    //   311: aload 7
    //   313: invokevirtual 1520	com/google/android/gms/internal/measurement/zzfw:getLabel	()Ljava/lang/String;
    //   316: invokevirtual 1523	android/os/BaseBundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: goto -131 -> 188
    //   322: aload 4
    //   324: astore_3
    //   325: aload 7
    //   327: invokevirtual 1525	com/google/android/gms/internal/measurement/zzfw:remove	()Z
    //   330: istore_2
    //   331: iload_2
    //   332: ifeq -144 -> 188
    //   335: aload 4
    //   337: astore_3
    //   338: aload_1
    //   339: aload 8
    //   341: aload 7
    //   343: invokevirtual 1526	com/google/android/gms/internal/measurement/zzfw:currentTimeMillis	()J
    //   346: invokevirtual 1529	android/os/BaseBundle:putLong	(Ljava/lang/String;J)V
    //   349: goto -161 -> 188
    //   352: aload 5
    //   354: invokeinterface 278 1 0
    //   359: aload_1
    //   360: areturn
    //   361: astore 6
    //   363: aload_0
    //   364: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   367: astore 7
    //   369: aload 4
    //   371: astore_3
    //   372: aload 7
    //   374: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   377: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   380: ldc_w 1531
    //   383: aload_1
    //   384: invokestatic 419	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   387: aload 6
    //   389: invokevirtual 300	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   392: aload 5
    //   394: invokeinterface 278 1 0
    //   399: aconst_null
    //   400: areturn
    //   401: astore_1
    //   402: goto +11 -> 413
    //   405: astore_1
    //   406: goto +42 -> 448
    //   409: astore_1
    //   410: aconst_null
    //   411: astore 4
    //   413: aload 4
    //   415: astore_3
    //   416: aload_0
    //   417: getfield 216	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   420: invokevirtual 287	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   423: invokevirtual 293	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   426: ldc_w 1533
    //   429: aload_1
    //   430: invokevirtual 422	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   433: aload 4
    //   435: ifnull +25 -> 460
    //   438: aload 4
    //   440: invokeinterface 278 1 0
    //   445: aconst_null
    //   446: areturn
    //   447: astore_1
    //   448: aload_3
    //   449: ifnull +9 -> 458
    //   452: aload_3
    //   453: invokeinterface 278 1 0
    //   458: aload_1
    //   459: athrow
    //   460: aconst_null
    //   461: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	zzam
    //   0	462	1	paramString	String
    //   48	284	2	bool	boolean
    //   9	444	3	localObject1	Object
    //   14	425	4	localObject2	Object
    //   32	361	5	localCursor	Cursor
    //   94	113	6	localObject3	Object
    //   361	27	6	localIOException	java.io.IOException
    //   213	160	7	localObject4	Object
    //   230	110	8	str	String
    // Exception table:
    //   from	to	target	type
    //   99	109	361	java/io/IOException
    //   122	129	361	java/io/IOException
    //   41	49	401	android/database/sqlite/SQLiteException
    //   61	74	401	android/database/sqlite/SQLiteException
    //   86	96	401	android/database/sqlite/SQLiteException
    //   99	109	401	android/database/sqlite/SQLiteException
    //   122	129	401	android/database/sqlite/SQLiteException
    //   150	156	401	android/database/sqlite/SQLiteException
    //   159	165	401	android/database/sqlite/SQLiteException
    //   168	176	401	android/database/sqlite/SQLiteException
    //   179	188	401	android/database/sqlite/SQLiteException
    //   191	199	401	android/database/sqlite/SQLiteException
    //   206	215	401	android/database/sqlite/SQLiteException
    //   225	232	401	android/database/sqlite/SQLiteException
    //   235	241	401	android/database/sqlite/SQLiteException
    //   248	259	401	android/database/sqlite/SQLiteException
    //   265	271	401	android/database/sqlite/SQLiteException
    //   278	289	401	android/database/sqlite/SQLiteException
    //   295	301	401	android/database/sqlite/SQLiteException
    //   308	319	401	android/database/sqlite/SQLiteException
    //   325	331	401	android/database/sqlite/SQLiteException
    //   338	349	401	android/database/sqlite/SQLiteException
    //   372	392	401	android/database/sqlite/SQLiteException
    //   10	16	405	java/lang/Throwable
    //   16	34	405	java/lang/Throwable
    //   10	16	409	android/database/sqlite/SQLiteException
    //   16	34	409	android/database/sqlite/SQLiteException
    //   41	49	447	java/lang/Throwable
    //   61	74	447	java/lang/Throwable
    //   86	96	447	java/lang/Throwable
    //   99	109	447	java/lang/Throwable
    //   112	119	447	java/lang/Throwable
    //   122	129	447	java/lang/Throwable
    //   132	138	447	java/lang/Throwable
    //   141	147	447	java/lang/Throwable
    //   150	156	447	java/lang/Throwable
    //   159	165	447	java/lang/Throwable
    //   168	176	447	java/lang/Throwable
    //   179	188	447	java/lang/Throwable
    //   191	199	447	java/lang/Throwable
    //   206	215	447	java/lang/Throwable
    //   225	232	447	java/lang/Throwable
    //   235	241	447	java/lang/Throwable
    //   248	259	447	java/lang/Throwable
    //   265	271	447	java/lang/Throwable
    //   278	289	447	java/lang/Throwable
    //   295	301	447	java/lang/Throwable
    //   308	319	447	java/lang/Throwable
    //   325	331	447	java/lang/Throwable
    //   338	349	447	java/lang/Throwable
    //   372	392	447	java/lang/Throwable
    //   416	433	447	java/lang/Throwable
  }
}
