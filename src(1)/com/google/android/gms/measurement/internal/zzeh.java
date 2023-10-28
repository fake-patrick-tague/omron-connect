package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import java.io.File;

public final class zzeh
  extends Log
{
  private final zzeg dbHelper;
  private boolean text;
  
  zzeh(zzfy paramZzfy)
  {
    super(paramZzfy);
    paramZzfy = this$0.zzau();
    this$0.append();
    dbHelper = new zzeg(this, paramZzfy, "google_app_measurement_local.db");
  }
  
  /* Error */
  private final boolean update(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 51	com/google/android/gms/measurement/internal/zzgr:append	()V
    //   4: aload_0
    //   5: getfield 53	com/google/android/gms/measurement/internal/zzeh:text	Z
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: new 55	android/content/ContentValues
    //   16: dup
    //   17: invokespecial 57	android/content/ContentValues:<init>	()V
    //   20: astore 15
    //   22: aload 15
    //   24: ldc 59
    //   26: iload_1
    //   27: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: invokevirtual 69	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   33: aload 15
    //   35: ldc 71
    //   37: aload_2
    //   38: invokevirtual 74	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   41: aload_0
    //   42: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   45: invokevirtual 28	com/google/android/gms/measurement/internal/zzfy:append	()Lcom/google/android/gms/measurement/internal/zzag;
    //   48: pop
    //   49: iconst_0
    //   50: istore_1
    //   51: iconst_5
    //   52: istore_3
    //   53: iload_1
    //   54: iconst_5
    //   55: if_icmpge +648 -> 703
    //   58: aconst_null
    //   59: astore_2
    //   60: aconst_null
    //   61: astore 14
    //   63: aconst_null
    //   64: astore 10
    //   66: aconst_null
    //   67: astore 12
    //   69: aconst_null
    //   70: astore 13
    //   72: aload_0
    //   73: invokevirtual 78	com/google/android/gms/measurement/internal/zzeh:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   76: astore 11
    //   78: aload 11
    //   80: astore_2
    //   81: aload 11
    //   83: ifnonnull +17 -> 100
    //   86: aload 13
    //   88: astore 12
    //   90: aload_2
    //   91: astore 10
    //   93: aload_0
    //   94: iconst_1
    //   95: putfield 53	com/google/android/gms/measurement/internal/zzeh:text	Z
    //   98: iconst_0
    //   99: ireturn
    //   100: aload 13
    //   102: astore 12
    //   104: aload_2
    //   105: astore 10
    //   107: aload 11
    //   109: invokevirtual 83	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   112: aload 13
    //   114: astore 12
    //   116: aload_2
    //   117: astore 10
    //   119: aload 11
    //   121: ldc 85
    //   123: aconst_null
    //   124: invokevirtual 89	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   127: astore 13
    //   129: aload 13
    //   131: astore 10
    //   133: lconst_0
    //   134: lstore 7
    //   136: lload 7
    //   138: lstore 5
    //   140: aload 13
    //   142: ifnull +61 -> 203
    //   145: aload 13
    //   147: invokeinterface 95 1 0
    //   152: istore 9
    //   154: lload 7
    //   156: lstore 5
    //   158: iload 9
    //   160: ifeq +43 -> 203
    //   163: aload 13
    //   165: iconst_0
    //   166: invokeinterface 99 2 0
    //   171: lstore 5
    //   173: goto +30 -> 203
    //   176: astore 11
    //   178: goto +492 -> 670
    //   181: astore_2
    //   182: aload 10
    //   184: astore 12
    //   186: aload_2
    //   187: astore 10
    //   189: goto +193 -> 382
    //   192: astore_2
    //   193: aload 10
    //   195: astore 12
    //   197: aload_2
    //   198: astore 10
    //   200: goto +197 -> 397
    //   203: lload 5
    //   205: ldc2_w 100
    //   208: lcmp
    //   209: iflt +113 -> 322
    //   212: aload_0
    //   213: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   216: astore 12
    //   218: aload 12
    //   220: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   223: invokevirtual 111	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   226: ldc 113
    //   228: invokevirtual 118	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;)V
    //   231: ldc2_w 100
    //   234: lload 5
    //   236: lsub
    //   237: lconst_1
    //   238: ladd
    //   239: lstore 5
    //   241: lload 5
    //   243: invokestatic 124	java/lang/Long:toString	(J)Ljava/lang/String;
    //   246: astore 12
    //   248: aload 11
    //   250: ldc 126
    //   252: ldc -128
    //   254: iconst_1
    //   255: anewarray 130	java/lang/String
    //   258: dup
    //   259: iconst_0
    //   260: aload 12
    //   262: aastore
    //   263: invokevirtual 134	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   266: istore 4
    //   268: iload 4
    //   270: i2l
    //   271: lstore 7
    //   273: lload 7
    //   275: lload 5
    //   277: lcmp
    //   278: ifeq +44 -> 322
    //   281: aload_0
    //   282: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   285: astore 12
    //   287: aload 12
    //   289: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   292: invokevirtual 111	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   295: astore 12
    //   297: aload 12
    //   299: ldc -120
    //   301: lload 5
    //   303: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   306: lload 7
    //   308: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   311: lload 5
    //   313: lload 7
    //   315: lsub
    //   316: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   319: invokevirtual 142	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   322: aload 11
    //   324: ldc 126
    //   326: aconst_null
    //   327: aload 15
    //   329: invokevirtual 146	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   332: pop2
    //   333: aload 11
    //   335: invokevirtual 149	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   338: aload 11
    //   340: invokevirtual 152	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   343: aload 13
    //   345: ifnull +10 -> 355
    //   348: aload 13
    //   350: invokeinterface 155 1 0
    //   355: aload 11
    //   357: invokevirtual 158	android/database/sqlite/SQLiteClosable:close	()V
    //   360: iconst_1
    //   361: ireturn
    //   362: aload 13
    //   364: astore 11
    //   366: goto +156 -> 522
    //   369: astore 11
    //   371: aload 10
    //   373: astore_2
    //   374: goto +300 -> 674
    //   377: astore 10
    //   379: aconst_null
    //   380: astore 12
    //   382: aload 11
    //   384: astore_2
    //   385: aload 10
    //   387: astore 13
    //   389: goto +30 -> 419
    //   392: astore 10
    //   394: aconst_null
    //   395: astore 12
    //   397: aload 11
    //   399: astore_2
    //   400: aload 10
    //   402: astore 13
    //   404: goto +182 -> 586
    //   407: astore 11
    //   409: aconst_null
    //   410: astore_2
    //   411: goto +263 -> 674
    //   414: astore 13
    //   416: aconst_null
    //   417: astore 12
    //   419: aload_2
    //   420: ifnull +38 -> 458
    //   423: aload_2
    //   424: astore 11
    //   426: aload 12
    //   428: astore 10
    //   430: aload_2
    //   431: checkcast 80	android/database/sqlite/SQLiteDatabase
    //   434: invokevirtual 161	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   437: istore 9
    //   439: iload 9
    //   441: ifeq +17 -> 458
    //   444: aload_2
    //   445: astore 11
    //   447: aload 12
    //   449: astore 10
    //   451: aload_2
    //   452: checkcast 80	android/database/sqlite/SQLiteDatabase
    //   455: invokevirtual 152	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   458: aload_2
    //   459: astore 11
    //   461: aload 12
    //   463: astore 10
    //   465: aload_0
    //   466: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   469: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   472: invokevirtual 111	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   475: ldc -93
    //   477: aload 13
    //   479: invokevirtual 166	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   482: aload_2
    //   483: astore 11
    //   485: aload 12
    //   487: astore 10
    //   489: aload_0
    //   490: iconst_1
    //   491: putfield 53	com/google/android/gms/measurement/internal/zzeh:text	Z
    //   494: aload 12
    //   496: ifnull +10 -> 506
    //   499: aload 12
    //   501: invokeinterface 155 1 0
    //   506: iload_3
    //   507: istore 4
    //   509: aload_2
    //   510: ifnull +141 -> 651
    //   513: goto +128 -> 641
    //   516: aconst_null
    //   517: astore_2
    //   518: aload 14
    //   520: astore 11
    //   522: iload_3
    //   523: i2l
    //   524: lstore 5
    //   526: aload 11
    //   528: astore 12
    //   530: aload_2
    //   531: astore 10
    //   533: lload 5
    //   535: invokestatic 172	android/os/SystemClock:sleep	(J)V
    //   538: iload_3
    //   539: bipush 20
    //   541: iadd
    //   542: istore_3
    //   543: aload 11
    //   545: ifnull +13 -> 558
    //   548: aload 11
    //   550: checkcast 91	android/database/Cursor
    //   553: invokeinterface 155 1 0
    //   558: iload_3
    //   559: istore 4
    //   561: aload_2
    //   562: ifnull +89 -> 651
    //   565: aload_2
    //   566: checkcast 80	android/database/sqlite/SQLiteDatabase
    //   569: invokevirtual 158	android/database/sqlite/SQLiteClosable:close	()V
    //   572: iload_3
    //   573: istore 4
    //   575: goto +76 -> 651
    //   578: astore 13
    //   580: aconst_null
    //   581: astore 12
    //   583: aload 10
    //   585: astore_2
    //   586: aload_2
    //   587: astore 11
    //   589: aload 12
    //   591: astore 10
    //   593: aload_0
    //   594: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   597: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   600: invokevirtual 111	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   603: ldc -82
    //   605: aload 13
    //   607: invokevirtual 166	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   610: aload_2
    //   611: astore 11
    //   613: aload 12
    //   615: astore 10
    //   617: aload_0
    //   618: iconst_1
    //   619: putfield 53	com/google/android/gms/measurement/internal/zzeh:text	Z
    //   622: aload 12
    //   624: ifnull +10 -> 634
    //   627: aload 12
    //   629: invokeinterface 155 1 0
    //   634: iload_3
    //   635: istore 4
    //   637: aload_2
    //   638: ifnull +13 -> 651
    //   641: aload_2
    //   642: checkcast 80	android/database/sqlite/SQLiteDatabase
    //   645: invokevirtual 158	android/database/sqlite/SQLiteClosable:close	()V
    //   648: iload_3
    //   649: istore 4
    //   651: iload_1
    //   652: iconst_1
    //   653: iadd
    //   654: istore_1
    //   655: iload 4
    //   657: istore_3
    //   658: goto -605 -> 53
    //   661: astore 12
    //   663: aload 11
    //   665: astore_2
    //   666: aload 12
    //   668: astore 11
    //   670: aload 10
    //   672: astore 12
    //   674: aload 12
    //   676: ifnull +13 -> 689
    //   679: aload 12
    //   681: checkcast 91	android/database/Cursor
    //   684: invokeinterface 155 1 0
    //   689: aload_2
    //   690: ifnull +10 -> 700
    //   693: aload_2
    //   694: checkcast 80	android/database/sqlite/SQLiteDatabase
    //   697: invokevirtual 158	android/database/sqlite/SQLiteClosable:close	()V
    //   700: aload 11
    //   702: athrow
    //   703: aload_0
    //   704: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   707: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   710: invokevirtual 177	com/google/android/gms/measurement/internal/zzeo:next	()Lcom/google/android/gms/measurement/internal/zzem;
    //   713: ldc -77
    //   715: invokevirtual 118	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;)V
    //   718: iconst_0
    //   719: ireturn
    //   720: astore_2
    //   721: goto -205 -> 516
    //   724: astore 10
    //   726: aload 14
    //   728: astore 11
    //   730: goto -208 -> 522
    //   733: astore 10
    //   735: goto -373 -> 362
    //   738: astore 10
    //   740: goto -378 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	this	zzeh
    //   0	743	1	paramInt	int
    //   0	743	2	paramArrayOfByte	byte[]
    //   52	606	3	i	int
    //   266	390	4	j	int
    //   138	396	5	l1	long
    //   134	180	7	l2	long
    //   152	288	9	bool	boolean
    //   64	308	10	localObject1	Object
    //   377	9	10	localSQLiteException1	SQLiteException
    //   392	9	10	localSQLiteFullException1	SQLiteFullException
    //   428	243	10	localObject2	Object
    //   724	1	10	localSQLiteDatabaseLockedException1	SQLiteDatabaseLockedException
    //   733	1	10	localSQLiteDatabaseLockedException2	SQLiteDatabaseLockedException
    //   738	1	10	localSQLiteDatabaseLockedException3	SQLiteDatabaseLockedException
    //   76	44	11	localSQLiteDatabase	SQLiteDatabase
    //   176	180	11	localThrowable1	Throwable
    //   364	1	11	localObject3	Object
    //   369	29	11	localThrowable2	Throwable
    //   407	1	11	localThrowable3	Throwable
    //   424	305	11	localObject4	Object
    //   67	561	12	localObject5	Object
    //   661	6	12	localThrowable4	Throwable
    //   672	8	12	localObject6	Object
    //   70	333	13	localObject7	Object
    //   414	64	13	localSQLiteException2	SQLiteException
    //   578	28	13	localSQLiteFullException2	SQLiteFullException
    //   61	666	14	localObject8	Object
    //   20	308	15	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   145	154	176	java/lang/Throwable
    //   163	173	176	java/lang/Throwable
    //   218	231	176	java/lang/Throwable
    //   241	248	176	java/lang/Throwable
    //   248	268	176	java/lang/Throwable
    //   287	297	176	java/lang/Throwable
    //   297	322	176	java/lang/Throwable
    //   322	343	176	java/lang/Throwable
    //   145	154	181	android/database/sqlite/SQLiteException
    //   163	173	181	android/database/sqlite/SQLiteException
    //   218	231	181	android/database/sqlite/SQLiteException
    //   241	248	181	android/database/sqlite/SQLiteException
    //   248	268	181	android/database/sqlite/SQLiteException
    //   287	297	181	android/database/sqlite/SQLiteException
    //   297	322	181	android/database/sqlite/SQLiteException
    //   322	343	181	android/database/sqlite/SQLiteException
    //   145	154	192	android/database/sqlite/SQLiteFullException
    //   163	173	192	android/database/sqlite/SQLiteFullException
    //   218	231	192	android/database/sqlite/SQLiteFullException
    //   241	248	192	android/database/sqlite/SQLiteFullException
    //   248	268	192	android/database/sqlite/SQLiteFullException
    //   287	297	192	android/database/sqlite/SQLiteFullException
    //   297	322	192	android/database/sqlite/SQLiteFullException
    //   322	343	192	android/database/sqlite/SQLiteFullException
    //   93	98	369	java/lang/Throwable
    //   107	112	369	java/lang/Throwable
    //   119	129	369	java/lang/Throwable
    //   533	538	369	java/lang/Throwable
    //   107	112	377	android/database/sqlite/SQLiteException
    //   119	129	377	android/database/sqlite/SQLiteException
    //   107	112	392	android/database/sqlite/SQLiteFullException
    //   119	129	392	android/database/sqlite/SQLiteFullException
    //   72	78	407	java/lang/Throwable
    //   72	78	414	android/database/sqlite/SQLiteException
    //   72	78	578	android/database/sqlite/SQLiteFullException
    //   430	439	661	java/lang/Throwable
    //   451	458	661	java/lang/Throwable
    //   465	482	661	java/lang/Throwable
    //   489	494	661	java/lang/Throwable
    //   593	610	661	java/lang/Throwable
    //   617	622	661	java/lang/Throwable
    //   72	78	720	android/database/sqlite/SQLiteDatabaseLockedException
    //   107	112	724	android/database/sqlite/SQLiteDatabaseLockedException
    //   119	129	724	android/database/sqlite/SQLiteDatabaseLockedException
    //   145	154	733	android/database/sqlite/SQLiteDatabaseLockedException
    //   163	173	733	android/database/sqlite/SQLiteDatabaseLockedException
    //   218	231	738	android/database/sqlite/SQLiteDatabaseLockedException
    //   241	248	738	android/database/sqlite/SQLiteDatabaseLockedException
    //   248	268	738	android/database/sqlite/SQLiteDatabaseLockedException
    //   287	297	738	android/database/sqlite/SQLiteDatabaseLockedException
    //   297	322	738	android/database/sqlite/SQLiteDatabaseLockedException
    //   322	343	738	android/database/sqlite/SQLiteDatabaseLockedException
  }
  
  /* Error */
  public final java.util.List doInBackground(int arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 51	com/google/android/gms/measurement/internal/zzgr:append	()V
    //   4: aload_0
    //   5: getfield 53	com/google/android/gms/measurement/internal/zzeh:text	Z
    //   8: istore 5
    //   10: aconst_null
    //   11: astore 16
    //   13: aconst_null
    //   14: astore 15
    //   16: iload 5
    //   18: ifeq +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: new 185	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 186	java/util/ArrayList:<init>	()V
    //   30: astore 17
    //   32: aload_0
    //   33: invokevirtual 189	com/google/android/gms/measurement/internal/zzeh:exists	()Z
    //   36: ifeq +1283 -> 1319
    //   39: iconst_5
    //   40: istore_1
    //   41: iconst_0
    //   42: istore_3
    //   43: iload_3
    //   44: iconst_5
    //   45: if_icmpge +1256 -> 1301
    //   48: aload_0
    //   49: invokevirtual 78	com/google/android/gms/measurement/internal/zzeh:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   52: astore 11
    //   54: aload 11
    //   56: ifnonnull +10 -> 66
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 53	com/google/android/gms/measurement/internal/zzeh:text	Z
    //   64: aconst_null
    //   65: areturn
    //   66: aload 11
    //   68: invokevirtual 83	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   71: aload 11
    //   73: ldc 126
    //   75: iconst_1
    //   76: anewarray 130	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: ldc -65
    //   83: aastore
    //   84: ldc -63
    //   86: iconst_1
    //   87: anewarray 130	java/lang/String
    //   90: dup
    //   91: iconst_0
    //   92: ldc -61
    //   94: aastore
    //   95: aconst_null
    //   96: aconst_null
    //   97: ldc -59
    //   99: ldc -57
    //   101: invokevirtual 203	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore 12
    //   106: aload 12
    //   108: astore 10
    //   110: aload 12
    //   112: invokeinterface 95 1 0
    //   117: istore 5
    //   119: ldc2_w 204
    //   122: lstore 8
    //   124: iload 5
    //   126: ifeq +23 -> 149
    //   129: aload 12
    //   131: iconst_0
    //   132: invokeinterface 99 2 0
    //   137: lstore 6
    //   139: aload 12
    //   141: invokeinterface 155 1 0
    //   146: goto +15 -> 161
    //   149: aload 12
    //   151: invokeinterface 155 1 0
    //   156: ldc2_w 204
    //   159: lstore 6
    //   161: lload 6
    //   163: ldc2_w 204
    //   166: lcmp
    //   167: ifeq +25 -> 192
    //   170: iconst_1
    //   171: anewarray 130	java/lang/String
    //   174: astore 10
    //   176: aload 10
    //   178: iconst_0
    //   179: lload 6
    //   181: invokestatic 207	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   184: aastore
    //   185: ldc -47
    //   187: astore 12
    //   189: goto +9 -> 198
    //   192: aconst_null
    //   193: astore 12
    //   195: aconst_null
    //   196: astore 10
    //   198: bipush 100
    //   200: invokestatic 212	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   203: astore 13
    //   205: aload 11
    //   207: ldc 126
    //   209: iconst_3
    //   210: anewarray 130	java/lang/String
    //   213: dup
    //   214: iconst_0
    //   215: ldc -65
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: ldc 59
    //   222: aastore
    //   223: dup
    //   224: iconst_2
    //   225: ldc 71
    //   227: aastore
    //   228: aload 12
    //   230: aload 10
    //   232: aconst_null
    //   233: aconst_null
    //   234: ldc -42
    //   236: aload 13
    //   238: invokevirtual 203	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   241: astore 12
    //   243: aload 12
    //   245: astore 10
    //   247: lload 8
    //   249: lstore 6
    //   251: aload 12
    //   253: invokeinterface 217 1 0
    //   258: istore 5
    //   260: iload 5
    //   262: ifeq +460 -> 722
    //   265: aload 12
    //   267: iconst_0
    //   268: invokeinterface 99 2 0
    //   273: lstore 8
    //   275: aload 12
    //   277: iconst_1
    //   278: invokeinterface 221 2 0
    //   283: istore_2
    //   284: aload 12
    //   286: iconst_2
    //   287: invokeinterface 225 2 0
    //   292: astore 18
    //   294: iload_2
    //   295: ifne +122 -> 417
    //   298: invokestatic 231	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   301: astore 13
    //   303: aload 18
    //   305: arraylength
    //   306: istore_2
    //   307: aload 13
    //   309: aload 18
    //   311: iconst_0
    //   312: iload_2
    //   313: invokevirtual 235	android/os/Parcel:unmarshall	([BII)V
    //   316: aload 13
    //   318: iconst_0
    //   319: invokevirtual 239	android/os/Parcel:setDataPosition	(I)V
    //   322: getstatic 245	com/google/android/gms/measurement/internal/zzaw:CREATOR	Landroid/os/Parcelable$Creator;
    //   325: astore 14
    //   327: aload 14
    //   329: aload 13
    //   331: invokeinterface 251 2 0
    //   336: astore 14
    //   338: aload 14
    //   340: checkcast 241	com/google/android/gms/measurement/internal/zzaw
    //   343: astore 14
    //   345: aload 13
    //   347: invokevirtual 254	android/os/Parcel:recycle	()V
    //   350: lload 8
    //   352: lstore 6
    //   354: aload 14
    //   356: ifnull -105 -> 251
    //   359: aload 17
    //   361: aload 14
    //   363: invokeinterface 260 2 0
    //   368: pop
    //   369: lload 8
    //   371: lstore 6
    //   373: goto -122 -> 251
    //   376: astore 14
    //   378: goto +31 -> 409
    //   381: aload_0
    //   382: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   385: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   388: invokevirtual 111	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   391: ldc_w 262
    //   394: invokevirtual 118	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;)V
    //   397: aload 13
    //   399: invokevirtual 254	android/os/Parcel:recycle	()V
    //   402: lload 8
    //   404: lstore 6
    //   406: goto -155 -> 251
    //   409: aload 13
    //   411: invokevirtual 254	android/os/Parcel:recycle	()V
    //   414: aload 14
    //   416: athrow
    //   417: iload_2
    //   418: iconst_1
    //   419: if_icmpne +121 -> 540
    //   422: invokestatic 231	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   425: astore 14
    //   427: aload 18
    //   429: arraylength
    //   430: istore_2
    //   431: aload 14
    //   433: aload 18
    //   435: iconst_0
    //   436: iload_2
    //   437: invokevirtual 235	android/os/Parcel:unmarshall	([BII)V
    //   440: aload 14
    //   442: iconst_0
    //   443: invokevirtual 239	android/os/Parcel:setDataPosition	(I)V
    //   446: getstatic 265	com/google/android/gms/measurement/internal/zzlc:CREATOR	Landroid/os/Parcelable$Creator;
    //   449: astore 13
    //   451: aload 13
    //   453: aload 14
    //   455: invokeinterface 251 2 0
    //   460: astore 13
    //   462: aload 13
    //   464: checkcast 264	com/google/android/gms/measurement/internal/zzlc
    //   467: astore 13
    //   469: aload 14
    //   471: invokevirtual 254	android/os/Parcel:recycle	()V
    //   474: goto +32 -> 506
    //   477: astore 13
    //   479: goto +53 -> 532
    //   482: aload_0
    //   483: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   486: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   489: invokevirtual 111	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   492: ldc_w 267
    //   495: invokevirtual 118	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;)V
    //   498: aload 14
    //   500: invokevirtual 254	android/os/Parcel:recycle	()V
    //   503: aconst_null
    //   504: astore 13
    //   506: lload 8
    //   508: lstore 6
    //   510: aload 13
    //   512: ifnull -261 -> 251
    //   515: aload 17
    //   517: aload 13
    //   519: invokeinterface 260 2 0
    //   524: pop
    //   525: lload 8
    //   527: lstore 6
    //   529: goto -278 -> 251
    //   532: aload 14
    //   534: invokevirtual 254	android/os/Parcel:recycle	()V
    //   537: aload 13
    //   539: athrow
    //   540: iload_2
    //   541: iconst_2
    //   542: if_icmpne +121 -> 663
    //   545: invokestatic 231	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   548: astore 14
    //   550: aload 18
    //   552: arraylength
    //   553: istore_2
    //   554: aload 14
    //   556: aload 18
    //   558: iconst_0
    //   559: iload_2
    //   560: invokevirtual 235	android/os/Parcel:unmarshall	([BII)V
    //   563: aload 14
    //   565: iconst_0
    //   566: invokevirtual 239	android/os/Parcel:setDataPosition	(I)V
    //   569: getstatic 270	com/google/android/gms/measurement/internal/zzac:CREATOR	Landroid/os/Parcelable$Creator;
    //   572: astore 13
    //   574: aload 13
    //   576: aload 14
    //   578: invokeinterface 251 2 0
    //   583: astore 13
    //   585: aload 13
    //   587: checkcast 269	com/google/android/gms/measurement/internal/zzac
    //   590: astore 13
    //   592: aload 14
    //   594: invokevirtual 254	android/os/Parcel:recycle	()V
    //   597: goto +32 -> 629
    //   600: astore 13
    //   602: goto +53 -> 655
    //   605: aload_0
    //   606: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   609: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   612: invokevirtual 111	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   615: ldc_w 272
    //   618: invokevirtual 118	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;)V
    //   621: aload 14
    //   623: invokevirtual 254	android/os/Parcel:recycle	()V
    //   626: aconst_null
    //   627: astore 13
    //   629: lload 8
    //   631: lstore 6
    //   633: aload 13
    //   635: ifnull -384 -> 251
    //   638: aload 17
    //   640: aload 13
    //   642: invokeinterface 260 2 0
    //   647: pop
    //   648: lload 8
    //   650: lstore 6
    //   652: goto -401 -> 251
    //   655: aload 14
    //   657: invokevirtual 254	android/os/Parcel:recycle	()V
    //   660: aload 13
    //   662: athrow
    //   663: iload_2
    //   664: iconst_3
    //   665: if_icmpne +30 -> 695
    //   668: aload_0
    //   669: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   672: astore 13
    //   674: aload 13
    //   676: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   679: invokevirtual 275	com/google/android/gms/measurement/internal/zzeo:hasNext	()Lcom/google/android/gms/measurement/internal/zzem;
    //   682: ldc_w 277
    //   685: invokevirtual 118	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;)V
    //   688: lload 8
    //   690: lstore 6
    //   692: goto -441 -> 251
    //   695: aload_0
    //   696: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   699: astore 13
    //   701: aload 13
    //   703: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   706: invokevirtual 111	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   709: ldc_w 279
    //   712: invokevirtual 118	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;)V
    //   715: lload 8
    //   717: lstore 6
    //   719: goto -468 -> 251
    //   722: lload 6
    //   724: invokestatic 124	java/lang/Long:toString	(J)Ljava/lang/String;
    //   727: astore 13
    //   729: aload 11
    //   731: ldc 126
    //   733: ldc_w 281
    //   736: iconst_1
    //   737: anewarray 130	java/lang/String
    //   740: dup
    //   741: iconst_0
    //   742: aload 13
    //   744: aastore
    //   745: invokevirtual 134	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   748: istore_2
    //   749: aload 17
    //   751: invokeinterface 285 1 0
    //   756: istore 4
    //   758: iload_2
    //   759: iload 4
    //   761: if_icmpge +23 -> 784
    //   764: aload_0
    //   765: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   768: astore 13
    //   770: aload 13
    //   772: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   775: invokevirtual 111	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   778: ldc_w 287
    //   781: invokevirtual 118	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;)V
    //   784: aload 11
    //   786: invokevirtual 149	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   789: aload 11
    //   791: invokevirtual 152	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   794: aload 12
    //   796: invokeinterface 155 1 0
    //   801: aload 11
    //   803: invokevirtual 158	android/database/sqlite/SQLiteClosable:close	()V
    //   806: aload 17
    //   808: areturn
    //   809: astore 10
    //   811: goto +31 -> 842
    //   814: astore 12
    //   816: aload 10
    //   818: astore 13
    //   820: aload 12
    //   822: astore 10
    //   824: goto +147 -> 971
    //   827: astore 12
    //   829: aload 10
    //   831: astore 13
    //   833: aload 12
    //   835: astore 10
    //   837: goto +164 -> 1001
    //   840: astore 10
    //   842: goto +117 -> 959
    //   845: astore 12
    //   847: aload 10
    //   849: astore 13
    //   851: aload 12
    //   853: astore 10
    //   855: goto +116 -> 971
    //   858: goto +127 -> 985
    //   861: astore 12
    //   863: aload 10
    //   865: astore 13
    //   867: aload 12
    //   869: astore 10
    //   871: goto +130 -> 1001
    //   874: astore 10
    //   876: aload 15
    //   878: astore 12
    //   880: goto +79 -> 959
    //   883: astore 10
    //   885: goto +83 -> 968
    //   888: goto +94 -> 982
    //   891: astore 10
    //   893: goto +105 -> 998
    //   896: astore 12
    //   898: goto +21 -> 919
    //   901: astore 10
    //   903: goto +5 -> 908
    //   906: astore 12
    //   908: aconst_null
    //   909: astore 13
    //   911: aload 10
    //   913: astore 12
    //   915: aload 13
    //   917: astore 10
    //   919: aload 10
    //   921: ifnull +10 -> 931
    //   924: aload 10
    //   926: invokeinterface 155 1 0
    //   931: aload 12
    //   933: athrow
    //   934: astore 10
    //   936: aload 15
    //   938: astore 12
    //   940: goto +19 -> 959
    //   943: astore 10
    //   945: goto +23 -> 968
    //   948: astore 10
    //   950: goto +48 -> 998
    //   953: astore 10
    //   955: aload 15
    //   957: astore 12
    //   959: aload 10
    //   961: astore 13
    //   963: goto +313 -> 1276
    //   966: astore 10
    //   968: aconst_null
    //   969: astore 13
    //   971: aload 11
    //   973: astore 12
    //   975: aload 10
    //   977: astore 14
    //   979: goto +53 -> 1032
    //   982: aconst_null
    //   983: astore 10
    //   985: aload 11
    //   987: astore 12
    //   989: aload 10
    //   991: astore 13
    //   993: goto +144 -> 1137
    //   996: astore 10
    //   998: aconst_null
    //   999: astore 13
    //   1001: aload 11
    //   1003: astore 12
    //   1005: aload 10
    //   1007: astore 14
    //   1009: goto +187 -> 1196
    //   1012: astore 13
    //   1014: aconst_null
    //   1015: astore 11
    //   1017: aload 16
    //   1019: astore 12
    //   1021: goto +255 -> 1276
    //   1024: astore 14
    //   1026: aconst_null
    //   1027: astore 13
    //   1029: aconst_null
    //   1030: astore 12
    //   1032: aload 12
    //   1034: ifnull +36 -> 1070
    //   1037: aload 12
    //   1039: astore 10
    //   1041: aload 13
    //   1043: astore 11
    //   1045: aload 12
    //   1047: invokevirtual 161	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   1050: istore 5
    //   1052: iload 5
    //   1054: ifeq +16 -> 1070
    //   1057: aload 12
    //   1059: astore 10
    //   1061: aload 13
    //   1063: astore 11
    //   1065: aload 12
    //   1067: invokevirtual 152	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1070: aload 12
    //   1072: astore 10
    //   1074: aload 13
    //   1076: astore 11
    //   1078: aload_0
    //   1079: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   1082: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   1085: invokevirtual 111	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1088: ldc_w 289
    //   1091: aload 14
    //   1093: invokevirtual 166	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1096: aload 12
    //   1098: astore 10
    //   1100: aload 13
    //   1102: astore 11
    //   1104: aload_0
    //   1105: iconst_1
    //   1106: putfield 53	com/google/android/gms/measurement/internal/zzeh:text	Z
    //   1109: aload 13
    //   1111: ifnull +10 -> 1121
    //   1114: aload 13
    //   1116: invokeinterface 155 1 0
    //   1121: iload_1
    //   1122: istore_2
    //   1123: aload 12
    //   1125: ifnull +132 -> 1257
    //   1128: goto +50 -> 1178
    //   1131: aconst_null
    //   1132: astore 13
    //   1134: aconst_null
    //   1135: astore 12
    //   1137: iload_1
    //   1138: i2l
    //   1139: lstore 6
    //   1141: aload 12
    //   1143: astore 10
    //   1145: aload 13
    //   1147: astore 11
    //   1149: lload 6
    //   1151: invokestatic 172	android/os/SystemClock:sleep	(J)V
    //   1154: iload_1
    //   1155: bipush 20
    //   1157: iadd
    //   1158: istore_1
    //   1159: aload 13
    //   1161: ifnull +10 -> 1171
    //   1164: aload 13
    //   1166: invokeinterface 155 1 0
    //   1171: iload_1
    //   1172: istore_2
    //   1173: aload 12
    //   1175: ifnull +82 -> 1257
    //   1178: aload 12
    //   1180: invokevirtual 158	android/database/sqlite/SQLiteClosable:close	()V
    //   1183: iload_1
    //   1184: istore_2
    //   1185: goto +72 -> 1257
    //   1188: astore 14
    //   1190: aconst_null
    //   1191: astore 13
    //   1193: aconst_null
    //   1194: astore 12
    //   1196: aload 12
    //   1198: astore 10
    //   1200: aload 13
    //   1202: astore 11
    //   1204: aload_0
    //   1205: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   1208: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   1211: invokevirtual 111	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1214: ldc_w 289
    //   1217: aload 14
    //   1219: invokevirtual 166	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1222: aload 12
    //   1224: astore 10
    //   1226: aload 13
    //   1228: astore 11
    //   1230: aload_0
    //   1231: iconst_1
    //   1232: putfield 53	com/google/android/gms/measurement/internal/zzeh:text	Z
    //   1235: aload 13
    //   1237: ifnull +10 -> 1247
    //   1240: aload 13
    //   1242: invokeinterface 155 1 0
    //   1247: iload_1
    //   1248: istore_2
    //   1249: aload 12
    //   1251: ifnull +6 -> 1257
    //   1254: goto -76 -> 1178
    //   1257: iload_3
    //   1258: iconst_1
    //   1259: iadd
    //   1260: istore_3
    //   1261: iload_2
    //   1262: istore_1
    //   1263: goto -1220 -> 43
    //   1266: astore 13
    //   1268: aload 11
    //   1270: astore 12
    //   1272: aload 10
    //   1274: astore 11
    //   1276: aload 12
    //   1278: ifnull +10 -> 1288
    //   1281: aload 12
    //   1283: invokeinterface 155 1 0
    //   1288: aload 11
    //   1290: ifnull +8 -> 1298
    //   1293: aload 11
    //   1295: invokevirtual 158	android/database/sqlite/SQLiteClosable:close	()V
    //   1298: aload 13
    //   1300: athrow
    //   1301: aload_0
    //   1302: getfield 18	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   1305: invokevirtual 105	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   1308: invokevirtual 275	com/google/android/gms/measurement/internal/zzeo:hasNext	()Lcom/google/android/gms/measurement/internal/zzem;
    //   1311: ldc_w 291
    //   1314: invokevirtual 118	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;)V
    //   1317: aconst_null
    //   1318: areturn
    //   1319: aload 17
    //   1321: areturn
    //   1322: astore 10
    //   1324: goto -193 -> 1131
    //   1327: astore 10
    //   1329: goto -347 -> 982
    //   1332: astore 10
    //   1334: goto -446 -> 888
    //   1337: astore 12
    //   1339: goto -481 -> 858
    //   1342: astore 14
    //   1344: goto -963 -> 381
    //   1347: astore 12
    //   1349: goto -491 -> 858
    //   1352: astore 12
    //   1354: goto -496 -> 858
    //   1357: astore 13
    //   1359: goto -877 -> 482
    //   1362: astore 12
    //   1364: goto -506 -> 858
    //   1367: astore 12
    //   1369: goto -511 -> 858
    //   1372: astore 13
    //   1374: goto -769 -> 605
    //   1377: astore 12
    //   1379: goto -521 -> 858
    //   1382: astore 12
    //   1384: goto -526 -> 858
    //   1387: astore 12
    //   1389: goto -404 -> 985
    //   1392: astore 10
    //   1394: goto -412 -> 982
    // Exception table:
    //   from	to	target	type
    //   303	307	376	java/lang/Throwable
    //   307	322	376	java/lang/Throwable
    //   322	327	376	java/lang/Throwable
    //   327	338	376	java/lang/Throwable
    //   338	345	376	java/lang/Throwable
    //   381	397	376	java/lang/Throwable
    //   427	431	477	java/lang/Throwable
    //   431	446	477	java/lang/Throwable
    //   446	451	477	java/lang/Throwable
    //   451	462	477	java/lang/Throwable
    //   462	469	477	java/lang/Throwable
    //   482	498	477	java/lang/Throwable
    //   550	554	600	java/lang/Throwable
    //   554	569	600	java/lang/Throwable
    //   569	574	600	java/lang/Throwable
    //   574	585	600	java/lang/Throwable
    //   585	592	600	java/lang/Throwable
    //   605	621	600	java/lang/Throwable
    //   729	758	809	java/lang/Throwable
    //   770	784	809	java/lang/Throwable
    //   784	794	809	java/lang/Throwable
    //   729	758	814	android/database/sqlite/SQLiteException
    //   770	784	814	android/database/sqlite/SQLiteException
    //   784	794	814	android/database/sqlite/SQLiteException
    //   729	758	827	android/database/sqlite/SQLiteFullException
    //   770	784	827	android/database/sqlite/SQLiteFullException
    //   784	794	827	android/database/sqlite/SQLiteFullException
    //   251	260	840	java/lang/Throwable
    //   265	294	840	java/lang/Throwable
    //   298	303	840	java/lang/Throwable
    //   345	350	840	java/lang/Throwable
    //   359	369	840	java/lang/Throwable
    //   397	402	840	java/lang/Throwable
    //   409	417	840	java/lang/Throwable
    //   422	427	840	java/lang/Throwable
    //   469	474	840	java/lang/Throwable
    //   498	503	840	java/lang/Throwable
    //   515	525	840	java/lang/Throwable
    //   532	540	840	java/lang/Throwable
    //   545	550	840	java/lang/Throwable
    //   592	597	840	java/lang/Throwable
    //   621	626	840	java/lang/Throwable
    //   638	648	840	java/lang/Throwable
    //   655	663	840	java/lang/Throwable
    //   674	688	840	java/lang/Throwable
    //   701	715	840	java/lang/Throwable
    //   722	729	840	java/lang/Throwable
    //   251	260	845	android/database/sqlite/SQLiteException
    //   265	294	845	android/database/sqlite/SQLiteException
    //   298	303	845	android/database/sqlite/SQLiteException
    //   345	350	845	android/database/sqlite/SQLiteException
    //   359	369	845	android/database/sqlite/SQLiteException
    //   397	402	845	android/database/sqlite/SQLiteException
    //   409	417	845	android/database/sqlite/SQLiteException
    //   422	427	845	android/database/sqlite/SQLiteException
    //   469	474	845	android/database/sqlite/SQLiteException
    //   498	503	845	android/database/sqlite/SQLiteException
    //   515	525	845	android/database/sqlite/SQLiteException
    //   532	540	845	android/database/sqlite/SQLiteException
    //   545	550	845	android/database/sqlite/SQLiteException
    //   592	597	845	android/database/sqlite/SQLiteException
    //   621	626	845	android/database/sqlite/SQLiteException
    //   638	648	845	android/database/sqlite/SQLiteException
    //   655	663	845	android/database/sqlite/SQLiteException
    //   674	688	845	android/database/sqlite/SQLiteException
    //   701	715	845	android/database/sqlite/SQLiteException
    //   722	729	845	android/database/sqlite/SQLiteException
    //   251	260	861	android/database/sqlite/SQLiteFullException
    //   265	294	861	android/database/sqlite/SQLiteFullException
    //   298	303	861	android/database/sqlite/SQLiteFullException
    //   345	350	861	android/database/sqlite/SQLiteFullException
    //   359	369	861	android/database/sqlite/SQLiteFullException
    //   397	402	861	android/database/sqlite/SQLiteFullException
    //   409	417	861	android/database/sqlite/SQLiteFullException
    //   422	427	861	android/database/sqlite/SQLiteFullException
    //   469	474	861	android/database/sqlite/SQLiteFullException
    //   498	503	861	android/database/sqlite/SQLiteFullException
    //   515	525	861	android/database/sqlite/SQLiteFullException
    //   532	540	861	android/database/sqlite/SQLiteFullException
    //   545	550	861	android/database/sqlite/SQLiteFullException
    //   592	597	861	android/database/sqlite/SQLiteFullException
    //   621	626	861	android/database/sqlite/SQLiteFullException
    //   638	648	861	android/database/sqlite/SQLiteFullException
    //   655	663	861	android/database/sqlite/SQLiteFullException
    //   674	688	861	android/database/sqlite/SQLiteFullException
    //   701	715	861	android/database/sqlite/SQLiteFullException
    //   722	729	861	android/database/sqlite/SQLiteFullException
    //   139	146	874	java/lang/Throwable
    //   149	156	874	java/lang/Throwable
    //   170	176	874	java/lang/Throwable
    //   198	243	874	java/lang/Throwable
    //   139	146	883	android/database/sqlite/SQLiteException
    //   149	156	883	android/database/sqlite/SQLiteException
    //   198	243	883	android/database/sqlite/SQLiteException
    //   139	146	891	android/database/sqlite/SQLiteFullException
    //   149	156	891	android/database/sqlite/SQLiteFullException
    //   198	243	891	android/database/sqlite/SQLiteFullException
    //   110	119	896	java/lang/Throwable
    //   129	139	896	java/lang/Throwable
    //   71	106	901	java/lang/Throwable
    //   924	931	934	java/lang/Throwable
    //   931	934	934	java/lang/Throwable
    //   924	931	943	android/database/sqlite/SQLiteException
    //   931	934	943	android/database/sqlite/SQLiteException
    //   924	931	948	android/database/sqlite/SQLiteFullException
    //   931	934	948	android/database/sqlite/SQLiteFullException
    //   59	64	953	java/lang/Throwable
    //   66	71	953	java/lang/Throwable
    //   66	71	966	android/database/sqlite/SQLiteException
    //   66	71	996	android/database/sqlite/SQLiteFullException
    //   48	54	1012	java/lang/Throwable
    //   48	54	1024	android/database/sqlite/SQLiteException
    //   48	54	1188	android/database/sqlite/SQLiteFullException
    //   1045	1052	1266	java/lang/Throwable
    //   1065	1070	1266	java/lang/Throwable
    //   1078	1096	1266	java/lang/Throwable
    //   1104	1109	1266	java/lang/Throwable
    //   1149	1154	1266	java/lang/Throwable
    //   1204	1222	1266	java/lang/Throwable
    //   1230	1235	1266	java/lang/Throwable
    //   48	54	1322	android/database/sqlite/SQLiteDatabaseLockedException
    //   66	71	1327	android/database/sqlite/SQLiteDatabaseLockedException
    //   139	146	1332	android/database/sqlite/SQLiteDatabaseLockedException
    //   149	156	1332	android/database/sqlite/SQLiteDatabaseLockedException
    //   198	243	1332	android/database/sqlite/SQLiteDatabaseLockedException
    //   251	260	1337	android/database/sqlite/SQLiteDatabaseLockedException
    //   265	294	1337	android/database/sqlite/SQLiteDatabaseLockedException
    //   298	303	1337	android/database/sqlite/SQLiteDatabaseLockedException
    //   307	322	1342	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   327	338	1342	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   345	350	1347	android/database/sqlite/SQLiteDatabaseLockedException
    //   359	369	1347	android/database/sqlite/SQLiteDatabaseLockedException
    //   397	402	1352	android/database/sqlite/SQLiteDatabaseLockedException
    //   409	417	1352	android/database/sqlite/SQLiteDatabaseLockedException
    //   422	427	1352	android/database/sqlite/SQLiteDatabaseLockedException
    //   431	446	1357	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   451	462	1357	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   469	474	1362	android/database/sqlite/SQLiteDatabaseLockedException
    //   498	503	1367	android/database/sqlite/SQLiteDatabaseLockedException
    //   515	525	1367	android/database/sqlite/SQLiteDatabaseLockedException
    //   532	540	1367	android/database/sqlite/SQLiteDatabaseLockedException
    //   545	550	1367	android/database/sqlite/SQLiteDatabaseLockedException
    //   554	569	1372	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   574	585	1372	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   592	597	1377	android/database/sqlite/SQLiteDatabaseLockedException
    //   621	626	1382	android/database/sqlite/SQLiteDatabaseLockedException
    //   638	648	1382	android/database/sqlite/SQLiteDatabaseLockedException
    //   655	663	1382	android/database/sqlite/SQLiteDatabaseLockedException
    //   674	688	1382	android/database/sqlite/SQLiteDatabaseLockedException
    //   701	715	1382	android/database/sqlite/SQLiteDatabaseLockedException
    //   722	729	1382	android/database/sqlite/SQLiteDatabaseLockedException
    //   729	758	1387	android/database/sqlite/SQLiteDatabaseLockedException
    //   770	784	1387	android/database/sqlite/SQLiteDatabaseLockedException
    //   784	794	1387	android/database/sqlite/SQLiteDatabaseLockedException
    //   924	931	1392	android/database/sqlite/SQLiteDatabaseLockedException
    //   931	934	1392	android/database/sqlite/SQLiteDatabaseLockedException
  }
  
  public final boolean doInBackground()
  {
    append();
    if (text) {
      return false;
    }
    if (exists())
    {
      int j = 5;
      int k = 0;
      while (k < 5)
      {
        Object localObject2 = null;
        Object localObject3 = null;
        Object localObject4 = null;
        Object localObject1 = null;
        try
        {
          try
          {
            SQLiteDatabase localSQLiteDatabase2 = getWritableDatabase();
            SQLiteDatabase localSQLiteDatabase1 = localSQLiteDatabase2;
            if (localSQLiteDatabase2 == null)
            {
              localObject1 = localSQLiteDatabase1;
              text = true;
              return false;
            }
            localObject1 = localSQLiteDatabase1;
            localObject2 = localSQLiteDatabase1;
            localObject3 = localSQLiteDatabase1;
            localObject4 = localSQLiteDatabase1;
            localSQLiteDatabase2.beginTransaction();
            localObject1 = localSQLiteDatabase1;
            localObject2 = localSQLiteDatabase1;
            localObject3 = localSQLiteDatabase1;
            localObject4 = localSQLiteDatabase1;
            String str = Integer.toString(3);
            localObject1 = localSQLiteDatabase1;
            localObject2 = localSQLiteDatabase1;
            localObject3 = localSQLiteDatabase1;
            localObject4 = localSQLiteDatabase1;
            localSQLiteDatabase2.delete("messages", "type == ?", new String[] { str });
            localObject1 = localSQLiteDatabase1;
            localObject2 = localSQLiteDatabase1;
            localObject3 = localSQLiteDatabase1;
            localObject4 = localSQLiteDatabase1;
            localSQLiteDatabase2.setTransactionSuccessful();
            localObject1 = localSQLiteDatabase1;
            localObject2 = localSQLiteDatabase1;
            localObject3 = localSQLiteDatabase1;
            localObject4 = localSQLiteDatabase1;
            localSQLiteDatabase2.endTransaction();
            localSQLiteDatabase2.close();
            return true;
          }
          catch (Throwable localThrowable)
          {
            break label374;
          }
          catch (SQLiteException localSQLiteException) {}catch (SQLiteFullException localSQLiteFullException) {}
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            boolean bool = localObject2.inTransaction();
            if (bool)
            {
              localObject1 = localObject2;
              localObject2.endTransaction();
            }
          }
          localObject1 = localObject2;
          this$0.zzay().iterator().append("Error deleting app launch break from local database", localSQLiteFullException);
          localObject1 = localObject2;
          text = true;
          i = j;
          if (localObject2 == null) {
            break label365;
          }
          i = j;
        }
        catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
        {
          int i;
          for (;;) {}
        }
        localObject1 = localObject4;
        SystemClock.sleep(j);
        j += 20;
        i = j;
        if (localObject4 != null)
        {
          localObject2 = localObject4;
          i = j;
          for (;;)
          {
            localObject2.close();
            break;
            localObject1 = localObject3;
            this$0.zzay().iterator().append("Error deleting app launch break from local database", localSQLiteFullException);
            localObject1 = localObject3;
            text = true;
            i = j;
            if (localObject3 == null) {
              break;
            }
            i = j;
            localObject2 = localObject3;
          }
        }
        label365:
        k += 1;
        j = i;
        continue;
        label374:
        if (localObject1 != null) {
          localObject1.close();
        }
        throw localSQLiteFullException;
      }
      this$0.zzay().hasNext().append("Error deleting app launch break from local database in reasonable time");
      return false;
    }
    return false;
  }
  
  final boolean exists()
  {
    Context localContext = this$0.zzau();
    this$0.append();
    return localContext.getDatabasePath("google_app_measurement_local.db").exists();
  }
  
  final SQLiteDatabase getWritableDatabase()
    throws SQLiteException
  {
    if (text) {
      return null;
    }
    SQLiteDatabase localSQLiteDatabase = dbHelper.getWritableDatabase();
    if (localSQLiteDatabase == null)
    {
      text = true;
      return null;
    }
    return localSQLiteDatabase;
  }
  
  protected final boolean isMapped()
  {
    return false;
  }
  
  public final boolean next(zzaw paramZzaw)
  {
    Parcel localParcel = Parcel.obtain();
    zzax.writeValue(paramZzaw, localParcel, 0);
    paramZzaw = localParcel.marshall();
    localParcel.recycle();
    if (paramZzaw.length > 131072)
    {
      this$0.zzay().getText().append("Event is too long for local database. Sending event directly to service");
      return false;
    }
    return update(0, paramZzaw);
  }
  
  public final boolean next(zzlc paramZzlc)
  {
    Parcel localParcel = Parcel.obtain();
    zzld.writeValue(paramZzlc, localParcel, 0);
    paramZzlc = localParcel.marshall();
    localParcel.recycle();
    if (paramZzlc.length > 131072)
    {
      this$0.zzay().getText().append("User property too long for local database. Sending directly to service");
      return false;
    }
    return update(1, paramZzlc);
  }
  
  public final boolean setTime(zzac paramZzac)
  {
    paramZzac = this$0.get().zzan(paramZzac);
    if (paramZzac.length > 131072)
    {
      this$0.zzay().getText().append("Conditional user property too long for local database. Sending directly to service");
      return false;
    }
    return update(2, paramZzac);
  }
  
  public final void trim()
  {
    append();
    try
    {
      Object localObject = getWritableDatabase();
      if (localObject != null)
      {
        int i = ((SQLiteDatabase)localObject).delete("messages", null, null);
        if (i > 0)
        {
          localObject = this$0;
          ((zzfy)localObject).zzay().next().append("Reset local analytics data. records", Integer.valueOf(i));
          return;
        }
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      this$0.zzay().iterator().append("Error resetting local analytics data. error", localSQLiteException);
    }
  }
  
  public final boolean updateMetadata()
  {
    return update(3, new byte[0]);
  }
}
