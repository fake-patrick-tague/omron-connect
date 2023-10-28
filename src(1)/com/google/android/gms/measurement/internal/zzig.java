package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

final class zzig
  implements Runnable
{
  private final String groups;
  private final zzfw name;
  private final URL url;
  
  public zzig(zzih paramZzih, String paramString, URL paramURL, byte[] paramArrayOfByte1, Map paramMap, zzfw paramZzfw, byte[] paramArrayOfByte2)
  {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramURL);
    Preconditions.checkNotNull(paramZzfw);
    url = paramURL;
    name = paramZzfw;
    groups = paramString;
  }
  
  private final void onError(int paramInt, Exception paramException, byte[] paramArrayOfByte, Map paramMap)
  {
    id.this$0.zzaz().append(new zzif(this, paramInt, paramException, paramArrayOfByte, paramMap));
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/google/android/gms/measurement/internal/zzig:id	Lcom/google/android/gms/measurement/internal/zzih;
    //   4: invokevirtual 80	com/google/android/gms/measurement/internal/zzgr:zzax	()V
    //   7: aload_0
    //   8: getfield 18	com/google/android/gms/measurement/internal/zzig:id	Lcom/google/android/gms/measurement/internal/zzih;
    //   11: astore 6
    //   13: aload_0
    //   14: getfield 33	com/google/android/gms/measurement/internal/zzig:url	Ljava/net/URL;
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 86	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   24: astore 5
    //   26: aload 5
    //   28: instanceof 88
    //   31: istore 4
    //   33: iload 4
    //   35: ifeq +225 -> 260
    //   38: aload 5
    //   40: checkcast 88	java/net/HttpURLConnection
    //   43: astore 5
    //   45: aload 5
    //   47: iconst_0
    //   48: invokevirtual 92	java/net/HttpURLConnection:setDefaultUseCaches	(Z)V
    //   51: aload 6
    //   53: getfield 46	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   56: astore 7
    //   58: aload 7
    //   60: invokevirtual 95	com/google/android/gms/measurement/internal/zzfy:append	()Lcom/google/android/gms/measurement/internal/zzag;
    //   63: pop
    //   64: aload 5
    //   66: ldc 96
    //   68: invokevirtual 100	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   71: aload 6
    //   73: getfield 46	com/google/android/gms/measurement/internal/zzgr:this$0	Lcom/google/android/gms/measurement/internal/zzfy;
    //   76: astore 6
    //   78: aload 6
    //   80: invokevirtual 95	com/google/android/gms/measurement/internal/zzfy:append	()Lcom/google/android/gms/measurement/internal/zzag;
    //   83: pop
    //   84: aload 5
    //   86: ldc 101
    //   88: invokevirtual 104	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   91: aload 5
    //   93: iconst_0
    //   94: invokevirtual 107	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   97: aload 5
    //   99: iconst_1
    //   100: invokevirtual 110	java/net/HttpURLConnection:setDoInput	(Z)V
    //   103: aload 5
    //   105: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   108: istore_2
    //   109: iload_2
    //   110: istore_1
    //   111: aload 5
    //   113: invokevirtual 118	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   116: astore 8
    //   118: aload 8
    //   120: astore 6
    //   122: new 120	java/io/ByteArrayOutputStream
    //   125: dup
    //   126: invokespecial 121	java/io/ByteArrayOutputStream:<init>	()V
    //   129: astore 10
    //   131: aload 5
    //   133: invokevirtual 125	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   136: astore 9
    //   138: aload 9
    //   140: astore 7
    //   142: sipush 1024
    //   145: newarray byte
    //   147: astore 11
    //   149: aload 9
    //   151: aload 11
    //   153: invokevirtual 131	java/io/InputStream:read	([B)I
    //   156: istore_3
    //   157: iload_3
    //   158: ifle +15 -> 173
    //   161: aload 10
    //   163: aload 11
    //   165: iconst_0
    //   166: iload_3
    //   167: invokevirtual 135	java/io/ByteArrayOutputStream:write	([BII)V
    //   170: goto -21 -> 149
    //   173: aload 10
    //   175: invokevirtual 139	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   178: astore 10
    //   180: aload 9
    //   182: invokevirtual 142	java/io/InputStream:close	()V
    //   185: aload 5
    //   187: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   190: aload_0
    //   191: iload_2
    //   192: aconst_null
    //   193: aload 10
    //   195: aload 8
    //   197: invokespecial 147	com/google/android/gms/measurement/internal/zzig:onError	(ILjava/lang/Exception;[BLjava/util/Map;)V
    //   200: return
    //   201: astore 8
    //   203: goto +8 -> 211
    //   206: astore 8
    //   208: aconst_null
    //   209: astore 7
    //   211: aload 7
    //   213: ifnull +8 -> 221
    //   216: aload 7
    //   218: invokevirtual 142	java/io/InputStream:close	()V
    //   221: aload 8
    //   223: athrow
    //   224: astore 7
    //   226: goto +62 -> 288
    //   229: astore 7
    //   231: goto +97 -> 328
    //   234: astore 7
    //   236: aconst_null
    //   237: astore 6
    //   239: goto +49 -> 288
    //   242: astore 7
    //   244: aconst_null
    //   245: astore 6
    //   247: goto +81 -> 328
    //   250: astore 6
    //   252: goto +23 -> 275
    //   255: astore 6
    //   257: goto +58 -> 315
    //   260: new 77	java/io/IOException
    //   263: dup
    //   264: ldc -107
    //   266: invokespecial 152	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   269: athrow
    //   270: astore 6
    //   272: aconst_null
    //   273: astore 5
    //   275: aconst_null
    //   276: astore 8
    //   278: iconst_0
    //   279: istore_1
    //   280: aload 6
    //   282: astore 7
    //   284: aload 8
    //   286: astore 6
    //   288: aload 5
    //   290: ifnull +8 -> 298
    //   293: aload 5
    //   295: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   298: aload_0
    //   299: iload_1
    //   300: aconst_null
    //   301: aconst_null
    //   302: aload 6
    //   304: invokespecial 147	com/google/android/gms/measurement/internal/zzig:onError	(ILjava/lang/Exception;[BLjava/util/Map;)V
    //   307: aload 7
    //   309: athrow
    //   310: astore 6
    //   312: aconst_null
    //   313: astore 5
    //   315: aconst_null
    //   316: astore 8
    //   318: iconst_0
    //   319: istore_1
    //   320: aload 6
    //   322: astore 7
    //   324: aload 8
    //   326: astore 6
    //   328: aload 5
    //   330: ifnull +8 -> 338
    //   333: aload 5
    //   335: invokevirtual 145	java/net/HttpURLConnection:disconnect	()V
    //   338: aload_0
    //   339: iload_1
    //   340: aload 7
    //   342: checkcast 154	java/lang/Exception
    //   345: aconst_null
    //   346: aload 6
    //   348: invokespecial 147	com/google/android/gms/measurement/internal/zzig:onError	(ILjava/lang/Exception;[BLjava/util/Map;)V
    //   351: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	zzig
    //   110	230	1	i	int
    //   108	84	2	j	int
    //   156	11	3	k	int
    //   31	3	4	bool	boolean
    //   17	317	5	localObject1	Object
    //   11	235	6	localObject2	Object
    //   250	1	6	localThrowable1	Throwable
    //   255	1	6	localIOException1	java.io.IOException
    //   270	11	6	localThrowable2	Throwable
    //   286	17	6	localObject3	Object
    //   310	11	6	localIOException2	java.io.IOException
    //   326	21	6	localObject4	Object
    //   56	161	7	localObject5	Object
    //   224	1	7	localThrowable3	Throwable
    //   229	1	7	localIOException3	java.io.IOException
    //   234	1	7	localThrowable4	Throwable
    //   242	1	7	localIOException4	java.io.IOException
    //   282	59	7	localObject6	Object
    //   116	80	8	localMap	Map
    //   201	1	8	localThrowable5	Throwable
    //   206	16	8	localThrowable6	Throwable
    //   276	49	8	localObject7	Object
    //   136	45	9	localInputStream	java.io.InputStream
    //   129	65	10	localObject8	Object
    //   147	17	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   142	149	201	java/lang/Throwable
    //   149	157	201	java/lang/Throwable
    //   161	170	201	java/lang/Throwable
    //   173	180	201	java/lang/Throwable
    //   122	138	206	java/lang/Throwable
    //   180	185	224	java/lang/Throwable
    //   216	221	224	java/lang/Throwable
    //   221	224	224	java/lang/Throwable
    //   180	185	229	java/io/IOException
    //   216	221	229	java/io/IOException
    //   221	224	229	java/io/IOException
    //   111	118	234	java/lang/Throwable
    //   111	118	242	java/io/IOException
    //   103	109	250	java/lang/Throwable
    //   103	109	255	java/io/IOException
    //   7	19	270	java/lang/Throwable
    //   19	26	270	java/lang/Throwable
    //   26	33	270	java/lang/Throwable
    //   38	45	270	java/lang/Throwable
    //   45	51	270	java/lang/Throwable
    //   51	58	270	java/lang/Throwable
    //   58	71	270	java/lang/Throwable
    //   78	103	270	java/lang/Throwable
    //   260	270	270	java/lang/Throwable
    //   19	26	310	java/io/IOException
    //   45	51	310	java/io/IOException
    //   58	71	310	java/io/IOException
    //   78	103	310	java/io/IOException
    //   260	270	310	java/io/IOException
  }
}
