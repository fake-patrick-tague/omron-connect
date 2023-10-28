package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

public final class zzan
{
  static void extract(zzeo paramZzeo, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramZzeo != null)
    {
      paramSQLiteDatabase = new File(paramSQLiteDatabase.getPath());
      if (!paramSQLiteDatabase.setReadable(false, false)) {
        paramZzeo.hasNext().append("Failed to turn off database read permission");
      }
      if (!paramSQLiteDatabase.setWritable(false, false)) {
        paramZzeo.hasNext().append("Failed to turn off database write permission");
      }
      if (!paramSQLiteDatabase.setReadable(true, true)) {
        paramZzeo.hasNext().append("Failed to turn on database read permission for owner");
      }
      if (!paramSQLiteDatabase.setWritable(true, true)) {
        paramZzeo.hasNext().append("Failed to turn on database write permission for owner");
      }
    }
    else
    {
      throw new IllegalArgumentException("Monitor must not be null");
    }
  }
  
  /* Error */
  static void update(zzeo paramZzeo, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
    throws android.database.sqlite.SQLiteException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +422 -> 423
    //   4: iconst_0
    //   5: istore 7
    //   7: aconst_null
    //   8: astore 10
    //   10: aload_1
    //   11: ldc 58
    //   13: iconst_1
    //   14: anewarray 60	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc 62
    //   21: aastore
    //   22: ldc 64
    //   24: iconst_1
    //   25: anewarray 60	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_2
    //   31: aastore
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 68	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore 12
    //   40: aload 12
    //   42: astore 11
    //   44: aload 11
    //   46: astore 10
    //   48: aload 12
    //   50: invokeinterface 74 1 0
    //   55: istore 9
    //   57: aload 12
    //   59: invokeinterface 78 1 0
    //   64: iload 9
    //   66: ifne +53 -> 119
    //   69: goto +45 -> 114
    //   72: astore 12
    //   74: goto +12 -> 86
    //   77: astore_0
    //   78: goto +331 -> 409
    //   81: astore 12
    //   83: aconst_null
    //   84: astore 11
    //   86: aload 11
    //   88: astore 10
    //   90: aload_0
    //   91: invokevirtual 28	com/google/android/gms/measurement/internal/zzeo:hasNext	()Lcom/google/android/gms/measurement/internal/zzem;
    //   94: ldc 80
    //   96: aload_2
    //   97: aload 12
    //   99: invokevirtual 83	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   102: aload 11
    //   104: ifnull +10 -> 114
    //   107: aload 11
    //   109: invokeinterface 78 1 0
    //   114: aload_1
    //   115: aload_3
    //   116: invokevirtual 86	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   119: new 88	java/util/HashSet
    //   122: dup
    //   123: invokespecial 90	java/util/HashSet:<init>	()V
    //   126: astore_3
    //   127: new 92	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   134: astore 10
    //   136: aload 10
    //   138: ldc 95
    //   140: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 10
    //   146: aload_2
    //   147: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 10
    //   153: ldc 100
    //   155: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: aload 10
    //   162: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: aconst_null
    //   166: invokevirtual 107	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   169: astore 10
    //   171: aload_3
    //   172: aload 10
    //   174: invokeinterface 111 1 0
    //   179: invokestatic 117	java/util/Collections:addAll	(Ljava/util/Collection;[Ljava/lang/Object;)Z
    //   182: pop
    //   183: aload 10
    //   185: invokeinterface 78 1 0
    //   190: aload 4
    //   192: ldc 119
    //   194: invokevirtual 123	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   197: astore 10
    //   199: aload 10
    //   201: arraylength
    //   202: istore 8
    //   204: iconst_0
    //   205: istore 6
    //   207: iload 6
    //   209: iload 8
    //   211: if_icmpge +81 -> 292
    //   214: aload 10
    //   216: iload 6
    //   218: aaload
    //   219: astore 4
    //   221: aload_3
    //   222: aload 4
    //   224: invokeinterface 129 2 0
    //   229: istore 9
    //   231: iload 9
    //   233: ifeq +12 -> 245
    //   236: iload 6
    //   238: iconst_1
    //   239: iadd
    //   240: istore 6
    //   242: goto -35 -> 207
    //   245: new 92	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   252: astore_1
    //   253: aload_1
    //   254: ldc -125
    //   256: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_1
    //   261: aload_2
    //   262: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_1
    //   267: ldc -123
    //   269: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload_1
    //   274: aload 4
    //   276: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: new 54	android/database/sqlite/SQLiteException
    //   283: dup
    //   284: aload_1
    //   285: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokespecial 134	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   291: athrow
    //   292: aload 5
    //   294: ifnull +61 -> 355
    //   297: iload 7
    //   299: istore 6
    //   301: iload 6
    //   303: aload 5
    //   305: arraylength
    //   306: if_icmpge +49 -> 355
    //   309: aload 5
    //   311: iload 6
    //   313: aaload
    //   314: astore 4
    //   316: aload_3
    //   317: aload 4
    //   319: invokeinterface 129 2 0
    //   324: istore 9
    //   326: iload 9
    //   328: ifne +18 -> 346
    //   331: aload 5
    //   333: iload 6
    //   335: iconst_1
    //   336: iadd
    //   337: aaload
    //   338: astore 4
    //   340: aload_1
    //   341: aload 4
    //   343: invokevirtual 86	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   346: iload 6
    //   348: iconst_2
    //   349: iadd
    //   350: istore 6
    //   352: goto -51 -> 301
    //   355: aload_3
    //   356: invokeinterface 137 1 0
    //   361: istore 9
    //   363: iload 9
    //   365: ifne +68 -> 433
    //   368: aload_0
    //   369: invokevirtual 28	com/google/android/gms/measurement/internal/zzeo:hasNext	()Lcom/google/android/gms/measurement/internal/zzem;
    //   372: ldc -117
    //   374: aload_2
    //   375: ldc -115
    //   377: aload_3
    //   378: invokestatic 147	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   381: invokevirtual 83	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   384: return
    //   385: astore_1
    //   386: aload 10
    //   388: invokeinterface 78 1 0
    //   393: aload_1
    //   394: athrow
    //   395: astore_1
    //   396: aload_0
    //   397: invokevirtual 150	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   400: ldc -104
    //   402: aload_2
    //   403: invokevirtual 155	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   406: aload_1
    //   407: athrow
    //   408: astore_0
    //   409: aload 10
    //   411: ifnull +10 -> 421
    //   414: aload 10
    //   416: invokeinterface 78 1 0
    //   421: aload_0
    //   422: athrow
    //   423: new 46	java/lang/IllegalArgumentException
    //   426: dup
    //   427: ldc 48
    //   429: invokespecial 49	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   432: athrow
    //   433: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	paramZzeo	zzeo
    //   0	434	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	434	2	paramString1	String
    //   0	434	3	paramString2	String
    //   0	434	4	paramString3	String
    //   0	434	5	paramArrayOfString	String[]
    //   205	146	6	i	int
    //   5	293	7	j	int
    //   202	10	8	k	int
    //   55	309	9	bool	boolean
    //   8	407	10	localObject	Object
    //   42	66	11	localCursor1	android.database.Cursor
    //   38	20	12	localCursor2	android.database.Cursor
    //   72	1	12	localSQLiteException1	android.database.sqlite.SQLiteException
    //   81	17	12	localSQLiteException2	android.database.sqlite.SQLiteException
    // Exception table:
    //   from	to	target	type
    //   48	57	72	android/database/sqlite/SQLiteException
    //   10	40	77	java/lang/Throwable
    //   10	40	81	android/database/sqlite/SQLiteException
    //   171	183	385	java/lang/Throwable
    //   119	127	395	android/database/sqlite/SQLiteException
    //   127	171	395	android/database/sqlite/SQLiteException
    //   183	199	395	android/database/sqlite/SQLiteException
    //   221	231	395	android/database/sqlite/SQLiteException
    //   245	292	395	android/database/sqlite/SQLiteException
    //   316	326	395	android/database/sqlite/SQLiteException
    //   340	346	395	android/database/sqlite/SQLiteException
    //   355	363	395	android/database/sqlite/SQLiteException
    //   368	384	395	android/database/sqlite/SQLiteException
    //   386	395	395	android/database/sqlite/SQLiteException
    //   48	57	408	java/lang/Throwable
    //   90	102	408	java/lang/Throwable
  }
}
