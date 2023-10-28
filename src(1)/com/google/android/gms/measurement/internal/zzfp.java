package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.Converters;
import com.google.android.gms.internal.measurement.Element;
import com.google.android.gms.internal.measurement.Field;
import com.google.android.gms.internal.measurement.zzfa;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzgo;
import com.google.android.gms.internal.measurement.zzgq;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzke;
import com.google.android.gms.internal.measurement.zzko;
import com.google.android.gms.internal.measurement.zzow;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v7.util.ArrayMap;
import v7.util.LruCache;

public final class zzfp
  extends zzkn
  implements zzaf
{
  final Element current = new zzfn(this);
  private final Map data = new ArrayMap();
  @VisibleForTesting
  final Map elements = new ArrayMap();
  @VisibleForTesting
  final LruCache list = new zzfm(this, 20);
  private final Map m = new ArrayMap();
  private final Map order = new ArrayMap();
  private final Map pool = new ArrayMap();
  @VisibleForTesting
  final Map positions = new ArrayMap();
  private final Map state = new ArrayMap();
  @VisibleForTesting
  final Map this$0 = new ArrayMap();
  private final Map values = new ArrayMap();
  
  zzfp(zzkz paramZzkz)
  {
    super(paramZzkz);
  }
  
  private final void add(String paramString, zzfd paramZzfd)
  {
    HashSet localHashSet = new HashSet();
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    ArrayMap localArrayMap3 = new ArrayMap();
    if (paramZzfd != null)
    {
      zzow.offer();
      boolean bool = this$0.append().get(null, zzeb.zzal);
      int j = 0;
      int i = j;
      Object localObject;
      if (bool)
      {
        localObject = paramZzfd.getAllCommands().iterator();
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localHashSet.add(((zzfa)((Iterator)localObject).next()).getFilename());
        }
      }
      while (i < paramZzfd.removeLast())
      {
        localObject = (zzfb)paramZzfd.add(i).zzby();
        if (((zzfb)localObject).getType().isEmpty())
        {
          this$0.zzay().hasNext().append("EventConfig contained null event name");
        }
        else
        {
          String str1 = ((zzfb)localObject).getType();
          String str2 = zzgv.get(((zzfb)localObject).getType());
          if (!TextUtils.isEmpty(str2))
          {
            ((zzfb)localObject).remove(str2);
            paramZzfd.inc(i, (zzfb)localObject);
          }
          if ((((zzfb)localObject).next()) && (((zzfb)localObject).newSession())) {
            localArrayMap1.put(str1, Boolean.TRUE);
          }
          if ((((zzfb)localObject).isEmpty()) && (((zzfb)localObject).is3D())) {
            localArrayMap2.put(((zzfb)localObject).getType(), Boolean.TRUE);
          }
          if (((zzfb)localObject).last()) {
            if ((((zzfb)localObject).iterator() >= 2) && (((zzfb)localObject).iterator() <= 65535)) {
              localArrayMap3.put(((zzfb)localObject).getType(), Integer.valueOf(((zzfb)localObject).iterator()));
            } else {
              this$0.zzay().hasNext().append("Invalid sampling rate. Event name, sample rate", ((zzfb)localObject).getType(), Integer.valueOf(((zzfb)localObject).iterator()));
            }
          }
        }
        i += 1;
      }
    }
    this$0.put(paramString, localHashSet);
    elements.put(paramString, localArrayMap1);
    positions.put(paramString, localArrayMap2);
    pool.put(paramString, localArrayMap3);
  }
  
  /* Error */
  private final void get(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 231	com/google/android/gms/measurement/internal/zzkn:size	()V
    //   4: aload_0
    //   5: invokevirtual 268	com/google/android/gms/measurement/internal/zzgr:append	()V
    //   8: aload_1
    //   9: invokestatic 236	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: getfield 40	com/google/android/gms/measurement/internal/zzfp:values	Ljava/util/Map;
    //   17: aload_1
    //   18: invokeinterface 246 2 0
    //   23: ifnonnull +574 -> 597
    //   26: aload_0
    //   27: getfield 273	com/google/android/gms/measurement/internal/zzkm:this$0	Lcom/google/android/gms/measurement/internal/zzkz;
    //   30: invokevirtual 279	com/google/android/gms/measurement/internal/zzkz:create	()Lcom/google/android/gms/measurement/internal/zzam;
    //   33: astore 7
    //   35: aload_1
    //   36: invokestatic 236	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   39: pop
    //   40: aload 7
    //   42: invokevirtual 268	com/google/android/gms/measurement/internal/zzgr:append	()V
    //   45: aload 7
    //   47: invokevirtual 231	com/google/android/gms/measurement/internal/zzkn:size	()V
    //   50: aconst_null
    //   51: astore 4
    //   53: aload 7
    //   55: invokevirtual 284	com/google/android/gms/measurement/internal/zzam:get	()Landroid/database/sqlite/SQLiteDatabase;
    //   58: astore_3
    //   59: aload_3
    //   60: ldc_w 286
    //   63: iconst_3
    //   64: anewarray 151	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: ldc_w 288
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: ldc_w 290
    //   78: aastore
    //   79: dup
    //   80: iconst_2
    //   81: ldc_w 292
    //   84: aastore
    //   85: ldc_w 294
    //   88: iconst_1
    //   89: anewarray 151	java/lang/String
    //   92: dup
    //   93: iconst_0
    //   94: aload_1
    //   95: aastore
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokevirtual 300	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   102: astore 6
    //   104: aload 6
    //   106: astore_3
    //   107: aload_3
    //   108: astore 4
    //   110: aload 6
    //   112: invokeinterface 305 1 0
    //   117: istore_2
    //   118: iload_2
    //   119: ifne +6 -> 125
    //   122: goto +214 -> 336
    //   125: aload_3
    //   126: astore 4
    //   128: aload 6
    //   130: iconst_0
    //   131: invokeinterface 309 2 0
    //   136: astore 8
    //   138: aload_3
    //   139: astore 4
    //   141: aload 6
    //   143: iconst_1
    //   144: invokeinterface 313 2 0
    //   149: astore 9
    //   151: aload_3
    //   152: astore 4
    //   154: aload 7
    //   156: getfield 81	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   159: astore 5
    //   161: aload_3
    //   162: astore 4
    //   164: aload 5
    //   166: invokevirtual 87	com/google/android/gms/measurement/internal/zzfy:append	()Lcom/google/android/gms/measurement/internal/zzag;
    //   169: astore 5
    //   171: getstatic 316	com/google/android/gms/measurement/internal/zzeb:zzaw	Lcom/google/android/gms/measurement/internal/zzea;
    //   174: astore 10
    //   176: aload_3
    //   177: astore 4
    //   179: aload 5
    //   181: aconst_null
    //   182: aload 10
    //   184: invokevirtual 99	com/google/android/gms/measurement/internal/zzag:get	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzea;)Z
    //   187: istore_2
    //   188: iload_2
    //   189: ifeq +19 -> 208
    //   192: aload_3
    //   193: astore 4
    //   195: aload 6
    //   197: iconst_2
    //   198: invokeinterface 313 2 0
    //   203: astore 5
    //   205: goto +6 -> 211
    //   208: aconst_null
    //   209: astore 5
    //   211: aload_3
    //   212: astore 4
    //   214: aload 6
    //   216: invokeinterface 319 1 0
    //   221: istore_2
    //   222: iload_2
    //   223: ifeq +31 -> 254
    //   226: aload 7
    //   228: getfield 81	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   231: astore 10
    //   233: aload_3
    //   234: astore 4
    //   236: aload 10
    //   238: invokevirtual 158	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   241: invokevirtual 321	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   244: ldc_w 323
    //   247: aload_1
    //   248: invokestatic 326	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   251: invokevirtual 329	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   254: aload 8
    //   256: ifnonnull +6 -> 262
    //   259: goto +77 -> 336
    //   262: aload_3
    //   263: astore 4
    //   265: new 331	com/google/android/gms/measurement/internal/zzaj
    //   268: dup
    //   269: aload 8
    //   271: aload 9
    //   273: aload 5
    //   275: invokespecial 334	com/google/android/gms/measurement/internal/zzaj:<init>	([BLjava/lang/String;Ljava/lang/String;)V
    //   278: astore 5
    //   280: aload 6
    //   282: invokeinterface 337 1 0
    //   287: aload 5
    //   289: astore_3
    //   290: goto +54 -> 344
    //   293: astore 5
    //   295: goto +11 -> 306
    //   298: astore_1
    //   299: goto +284 -> 583
    //   302: astore 5
    //   304: aconst_null
    //   305: astore_3
    //   306: aload_3
    //   307: astore 4
    //   309: aload 7
    //   311: getfield 81	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   314: invokevirtual 158	com/google/android/gms/measurement/internal/zzfy:zzay	()Lcom/google/android/gms/measurement/internal/zzeo;
    //   317: invokevirtual 321	com/google/android/gms/measurement/internal/zzeo:iterator	()Lcom/google/android/gms/measurement/internal/zzem;
    //   320: ldc_w 339
    //   323: aload_1
    //   324: invokestatic 326	com/google/android/gms/measurement/internal/zzeo:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   327: aload 5
    //   329: invokevirtual 226	com/google/android/gms/measurement/internal/zzem:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   332: aload_3
    //   333: ifnull +9 -> 342
    //   336: aload_3
    //   337: invokeinterface 337 1 0
    //   342: aconst_null
    //   343: astore_3
    //   344: aload_3
    //   345: ifnonnull +112 -> 457
    //   348: aload_0
    //   349: getfield 32	com/google/android/gms/measurement/internal/zzfp:order	Ljava/util/Map;
    //   352: aload_1
    //   353: aconst_null
    //   354: invokeinterface 205 3 0
    //   359: pop
    //   360: aload_0
    //   361: getfield 36	com/google/android/gms/measurement/internal/zzfp:elements	Ljava/util/Map;
    //   364: aload_1
    //   365: aconst_null
    //   366: invokeinterface 205 3 0
    //   371: pop
    //   372: aload_0
    //   373: getfield 34	com/google/android/gms/measurement/internal/zzfp:this$0	Ljava/util/Map;
    //   376: aload_1
    //   377: aconst_null
    //   378: invokeinterface 205 3 0
    //   383: pop
    //   384: aload_0
    //   385: getfield 38	com/google/android/gms/measurement/internal/zzfp:positions	Ljava/util/Map;
    //   388: aload_1
    //   389: aconst_null
    //   390: invokeinterface 205 3 0
    //   395: pop
    //   396: aload_0
    //   397: getfield 40	com/google/android/gms/measurement/internal/zzfp:values	Ljava/util/Map;
    //   400: aload_1
    //   401: aconst_null
    //   402: invokeinterface 205 3 0
    //   407: pop
    //   408: aload_0
    //   409: getfield 42	com/google/android/gms/measurement/internal/zzfp:m	Ljava/util/Map;
    //   412: aload_1
    //   413: aconst_null
    //   414: invokeinterface 205 3 0
    //   419: pop
    //   420: aload_0
    //   421: getfield 44	com/google/android/gms/measurement/internal/zzfp:data	Ljava/util/Map;
    //   424: aload_1
    //   425: aconst_null
    //   426: invokeinterface 205 3 0
    //   431: pop
    //   432: aload_0
    //   433: getfield 46	com/google/android/gms/measurement/internal/zzfp:state	Ljava/util/Map;
    //   436: aload_1
    //   437: aconst_null
    //   438: invokeinterface 205 3 0
    //   443: pop
    //   444: aload_0
    //   445: getfield 48	com/google/android/gms/measurement/internal/zzfp:pool	Ljava/util/Map;
    //   448: aload_1
    //   449: aconst_null
    //   450: invokeinterface 205 3 0
    //   455: pop
    //   456: return
    //   457: aload_0
    //   458: aload_1
    //   459: aload_3
    //   460: getfield 342	com/google/android/gms/measurement/internal/zzaj:data	[B
    //   463: invokespecial 346	com/google/android/gms/measurement/internal/zzfp:subtract	(Ljava/lang/String;[B)Lcom/google/android/gms/internal/measurement/zzfe;
    //   466: invokevirtual 144	com/google/android/gms/internal/measurement/zzke:zzby	()Lcom/google/android/gms/internal/measurement/zzka;
    //   469: checkcast 101	com/google/android/gms/internal/measurement/zzfd
    //   472: astore 4
    //   474: aload_0
    //   475: aload_1
    //   476: aload 4
    //   478: invokespecial 348	com/google/android/gms/measurement/internal/zzfp:add	(Ljava/lang/String;Lcom/google/android/gms/internal/measurement/zzfd;)V
    //   481: aload_0
    //   482: getfield 32	com/google/android/gms/measurement/internal/zzfp:order	Ljava/util/Map;
    //   485: aload_1
    //   486: aload 4
    //   488: invokevirtual 354	com/google/android/gms/internal/measurement/zzka:zzaE	()Lcom/google/android/gms/internal/measurement/zzke;
    //   491: checkcast 248	com/google/android/gms/internal/measurement/zzfe
    //   494: invokestatic 358	com/google/android/gms/measurement/internal/zzfp:save	(Lcom/google/android/gms/internal/measurement/zzfe;)Ljava/util/Map;
    //   497: invokeinterface 205 3 0
    //   502: pop
    //   503: aload_0
    //   504: getfield 40	com/google/android/gms/measurement/internal/zzfp:values	Ljava/util/Map;
    //   507: aload_1
    //   508: aload 4
    //   510: invokevirtual 354	com/google/android/gms/internal/measurement/zzka:zzaE	()Lcom/google/android/gms/internal/measurement/zzke;
    //   513: checkcast 248	com/google/android/gms/internal/measurement/zzfe
    //   516: invokeinterface 205 3 0
    //   521: pop
    //   522: aload_0
    //   523: aload_1
    //   524: aload 4
    //   526: invokevirtual 354	com/google/android/gms/internal/measurement/zzka:zzaE	()Lcom/google/android/gms/internal/measurement/zzke;
    //   529: checkcast 248	com/google/android/gms/internal/measurement/zzfe
    //   532: invokespecial 252	com/google/android/gms/measurement/internal/zzfp:process	(Ljava/lang/String;Lcom/google/android/gms/internal/measurement/zzfe;)V
    //   535: aload_0
    //   536: getfield 42	com/google/android/gms/measurement/internal/zzfp:m	Ljava/util/Map;
    //   539: aload_1
    //   540: aload 4
    //   542: invokevirtual 360	com/google/android/gms/internal/measurement/zzfd:getString	()Ljava/lang/String;
    //   545: invokeinterface 205 3 0
    //   550: pop
    //   551: aload_0
    //   552: getfield 44	com/google/android/gms/measurement/internal/zzfp:data	Ljava/util/Map;
    //   555: aload_1
    //   556: aload_3
    //   557: getfield 364	com/google/android/gms/measurement/internal/zzaj:first	Ljava/lang/String;
    //   560: invokeinterface 205 3 0
    //   565: pop
    //   566: aload_0
    //   567: getfield 46	com/google/android/gms/measurement/internal/zzfp:state	Ljava/util/Map;
    //   570: aload_1
    //   571: aload_3
    //   572: getfield 367	com/google/android/gms/measurement/internal/zzaj:element	Ljava/lang/String;
    //   575: invokeinterface 205 3 0
    //   580: pop
    //   581: return
    //   582: astore_1
    //   583: aload 4
    //   585: ifnull +10 -> 595
    //   588: aload 4
    //   590: invokeinterface 337 1 0
    //   595: aload_1
    //   596: athrow
    //   597: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	this	zzfp
    //   0	598	1	paramString	String
    //   117	106	2	bool	boolean
    //   58	514	3	localObject1	Object
    //   51	538	4	localObject2	Object
    //   159	129	5	localObject3	Object
    //   293	1	5	localSQLiteException1	SQLiteException
    //   302	26	5	localSQLiteException2	SQLiteException
    //   102	179	6	localCursor	android.database.Cursor
    //   33	277	7	localZzam	zzam
    //   136	134	8	arrayOfByte	byte[]
    //   149	123	9	str	String
    //   174	63	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   110	118	293	android/database/sqlite/SQLiteException
    //   128	138	293	android/database/sqlite/SQLiteException
    //   141	151	293	android/database/sqlite/SQLiteException
    //   164	171	293	android/database/sqlite/SQLiteException
    //   179	188	293	android/database/sqlite/SQLiteException
    //   195	205	293	android/database/sqlite/SQLiteException
    //   214	222	293	android/database/sqlite/SQLiteException
    //   236	254	293	android/database/sqlite/SQLiteException
    //   265	280	293	android/database/sqlite/SQLiteException
    //   53	59	298	java/lang/Throwable
    //   59	104	298	java/lang/Throwable
    //   53	59	302	android/database/sqlite/SQLiteException
    //   59	104	302	android/database/sqlite/SQLiteException
    //   110	118	582	java/lang/Throwable
    //   128	138	582	java/lang/Throwable
    //   141	151	582	java/lang/Throwable
    //   154	161	582	java/lang/Throwable
    //   164	171	582	java/lang/Throwable
    //   179	188	582	java/lang/Throwable
    //   195	205	582	java/lang/Throwable
    //   214	222	582	java/lang/Throwable
    //   236	254	582	java/lang/Throwable
    //   265	280	582	java/lang/Throwable
    //   309	332	582	java/lang/Throwable
  }
  
  private final void process(String paramString, zzfe paramZzfe)
  {
    if (paramZzfe.write() != 0)
    {
      this$0.zzay().next().append("EES programs found", Integer.valueOf(paramZzfe.write()));
      paramZzfe = (zzgs)paramZzfe.getRoster().get(0);
    }
    try
    {
      Object localObject1 = new Field();
      ((Field)localObject1).process("internal.remoteConfig", new zzfj(this, paramString));
      ((Field)localObject1).process("internal.appMetadata", new zzfk(this, paramString));
      ((Field)localObject1).process("internal.logger", new zzfl(this));
      ((Field)localObject1).process(paramZzfe);
      Object localObject2 = list;
      ((LruCache)localObject2).put(paramString, localObject1);
      localObject1 = this$0;
      ((zzfy)localObject1).zzay().next().append("EES program loaded for appId, activities", paramString, Integer.valueOf(paramZzfe.getContextRef().getSize()));
      paramZzfe = paramZzfe.getContextRef().getElements().iterator();
      for (;;)
      {
        boolean bool = paramZzfe.hasNext();
        if (!bool) {
          break;
        }
        localObject1 = paramZzfe.next();
        localObject1 = (zzgq)localObject1;
        localObject2 = this$0;
        ((zzfy)localObject2).zzay().next().append("EES program activity", ((zzgq)localObject1).parseDate());
      }
      return;
    }
    catch (Converters paramZzfe)
    {
      for (;;) {}
    }
    this$0.zzay().iterator().append("Failed to load EES program. appId", paramString);
    return;
    list.remove(paramString);
  }
  
  private static final Map save(zzfe paramZzfe)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (paramZzfe != null)
    {
      paramZzfe = paramZzfe.getContentValues().iterator();
      while (paramZzfe.hasNext())
      {
        zzfi localZzfi = (zzfi)paramZzfe.next();
        localArrayMap.put(localZzfi.getTemperatureUnit(), localZzfi.getImagePath());
      }
    }
    return localArrayMap;
  }
  
  private final zzfe subtract(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return zzfe.negated();
    }
    try
    {
      paramArrayOfByte = zzlb.equals(zzfe.negate(), paramArrayOfByte);
      paramArrayOfByte = (zzfd)paramArrayOfByte;
      paramArrayOfByte = paramArrayOfByte.zzaE();
      zzfe localZzfe = (zzfe)paramArrayOfByte;
      paramArrayOfByte = this$0;
      zzem localZzem = paramArrayOfByte.zzay().next();
      boolean bool = localZzfe.equals();
      String str = null;
      if (bool) {
        paramArrayOfByte = Long.valueOf(localZzfe.getZ());
      } else {
        paramArrayOfByte = null;
      }
      bool = localZzfe.add();
      if (bool) {
        str = localZzfe.getCaption();
      }
      localZzem.append("Parsed config. version, gmp_app_id", paramArrayOfByte, str);
      return localZzfe;
    }
    catch (RuntimeException paramArrayOfByte)
    {
      this$0.zzay().hasNext().append("Unable to merge remote config. appId", zzeo.get(paramString), paramArrayOfByte);
      return zzfe.negated();
    }
    catch (zzko paramArrayOfByte)
    {
      this$0.zzay().hasNext().append("Unable to merge remote config. appId", zzeo.get(paramString), paramArrayOfByte);
    }
    return zzfe.negated();
  }
  
  final boolean add(String paramString)
  {
    append();
    get(paramString);
    if (this$0.get(paramString) != null)
    {
      if (((Set)this$0.get(paramString)).contains("os_version")) {
        break label77;
      }
      if (((Set)this$0.get(paramString)).contains("device_info")) {
        return true;
      }
    }
    return false;
    label77:
    return true;
  }
  
  final boolean add(String paramString1, String paramString2)
  {
    append();
    get(paramString1);
    if ("ecommerce_purchase".equals(paramString2)) {
      return true;
    }
    if (!"purchase".equals(paramString2))
    {
      if ("refund".equals(paramString2)) {
        return true;
      }
      paramString1 = (Map)positions.get(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (Boolean)paramString1.get(paramString2);
        if (paramString1 == null) {
          return false;
        }
        return paramString1.booleanValue();
      }
      return false;
    }
    return true;
  }
  
  protected final boolean add(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    size();
    append();
    Preconditions.checkNotEmpty(paramString1);
    zzfd localZzfd = (zzfd)subtract(paramString1, paramArrayOfByte).zzby();
    if (localZzfd == null) {
      return false;
    }
    add(paramString1, localZzfd);
    process(paramString1, (zzfe)localZzfd.zzaE());
    values.put(paramString1, (zzfe)localZzfd.zzaE());
    m.put(paramString1, localZzfd.getString());
    data.put(paramString1, paramString2);
    state.put(paramString1, paramString3);
    order.put(paramString1, save((zzfe)localZzfd.zzaE()));
    this$0.create().doInBackground(paramString1, new ArrayList(localZzfd.getTerms()));
    try
    {
      localZzfd.inc();
      byte[] arrayOfByte = ((zzfe)localZzfd.zzaE()).zzbv();
      paramArrayOfByte = arrayOfByte;
    }
    catch (RuntimeException localRuntimeException)
    {
      this$0.zzay().hasNext().append("Unable to serialize reduced-size config. Storing full config instead. appId", zzeo.get(paramString1), localRuntimeException);
    }
    zzam localZzam = this$0.create();
    Preconditions.checkNotEmpty(paramString1);
    localZzam.append();
    localZzam.size();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("remote_config", paramArrayOfByte);
    localContentValues.put("config_last_modified_time", paramString2);
    if (this$0.append().get(null, zzeb.zzaw)) {
      localContentValues.put("e_tag", paramString3);
    }
    try
    {
      paramArrayOfByte = localZzam.get();
      int i = paramArrayOfByte.update("apps", localContentValues, "app_id = ?", new String[] { paramString1 });
      if (i == 0L)
      {
        paramArrayOfByte = this$0;
        paramArrayOfByte.zzay().iterator().append("Failed to update remote config (got 0). appId", zzeo.get(paramString1));
      }
    }
    catch (SQLiteException paramArrayOfByte)
    {
      this$0.zzay().iterator().append("Error storing remote config. appId", zzeo.get(paramString1), paramArrayOfByte);
    }
    values.put(paramString1, (zzfe)localZzfd.zzaE());
    return true;
  }
  
  final boolean addOnChangeListener(String paramString)
  {
    append();
    get(paramString);
    return (this$0.get(paramString) != null) && (((Set)this$0.get(paramString)).contains("enhanced_user_id"));
  }
  
  final boolean addTag(String paramString)
  {
    append();
    get(paramString);
    return (this$0.get(paramString) != null) && (((Set)this$0.get(paramString)).contains("app_instance_id"));
  }
  
  final void config(String paramString)
  {
    append();
    values.remove(paramString);
  }
  
  final boolean d(String paramString)
  {
    return "1".equals(get(paramString, "measurement.upload.blacklist_internal"));
  }
  
  final boolean equals(String paramString)
  {
    append();
    paramString = transform(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.isEmpty();
  }
  
  public final String get(String paramString1, String paramString2)
  {
    append();
    get(paramString1);
    paramString1 = (Map)order.get(paramString1);
    if (paramString1 != null) {
      return (String)paramString1.get(paramString2);
    }
    return null;
  }
  
  public final boolean getBytes(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = (zzfe)values.get(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.write() != 0;
  }
  
  final String getCategory(String paramString)
  {
    append();
    get(paramString);
    return (String)m.get(paramString);
  }
  
  final Set getKey(String paramString)
  {
    append();
    get(paramString);
    return (Set)this$0.get(paramString);
  }
  
  protected final String getName(String paramString)
  {
    append();
    return (String)data.get(paramString);
  }
  
  final boolean getValue(String paramString)
  {
    append();
    get(paramString);
    return (this$0.get(paramString) != null) && (((Set)this$0.get(paramString)).contains("google_signals"));
  }
  
  final boolean isError(String paramString)
  {
    return "1".equals(get(paramString, "measurement.upload.blacklist_public"));
  }
  
  final boolean isSafeAttribute(String paramString)
  {
    append();
    get(paramString);
    if (this$0.get(paramString) != null)
    {
      if (((Set)this$0.get(paramString)).contains("device_model")) {
        break label77;
      }
      if (((Set)this$0.get(paramString)).contains("device_info")) {
        return true;
      }
    }
    return false;
    label77:
    return true;
  }
  
  protected final boolean registerAlarm()
  {
    return false;
  }
  
  protected final void removeColumn(String paramString)
  {
    append();
    data.put(paramString, null);
  }
  
  final int size(String paramString1, String paramString2)
  {
    append();
    get(paramString1);
    paramString1 = (Map)pool.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Integer)paramString1.get(paramString2);
      if (paramString1 == null) {
        return 1;
      }
      return paramString1.intValue();
    }
    return 1;
  }
  
  protected final String toString(String paramString)
  {
    append();
    return (String)state.get(paramString);
  }
  
  protected final zzfe transform(String paramString)
  {
    size();
    append();
    Preconditions.checkNotEmpty(paramString);
    get(paramString);
    return (zzfe)values.get(paramString);
  }
  
  final boolean update(String paramString)
  {
    append();
    get(paramString);
    return (this$0.get(paramString) != null) && (((Set)this$0.get(paramString)).contains("user_id"));
  }
  
  final boolean update(String paramString1, String paramString2)
  {
    append();
    get(paramString1);
    if ((d(paramString1)) && (zzlh.zzah(paramString2))) {
      return true;
    }
    if ((isError(paramString1)) && (zzlh.zzai(paramString2))) {
      return true;
    }
    paramString1 = (Map)elements.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Boolean)paramString1.get(paramString2);
      if (paramString1 == null) {
        return false;
      }
      return paramString1.booleanValue();
    }
    return false;
  }
}
