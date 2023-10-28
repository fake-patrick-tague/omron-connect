package com.google.android.datatransport.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.google.android.datatransport.Type;
import com.google.android.datatransport.api.internal.ClientInfo;
import com.google.android.datatransport.api.internal.ClientInfo.ClientType;
import com.google.android.datatransport.api.internal.ClientInfo.a;
import com.google.android.datatransport.api.internal.DfsRefDatabase.RefCache;
import com.google.android.datatransport.api.internal.NetworkConnectionInfo;
import com.google.android.datatransport.api.internal.NetworkConnectionInfo.MobileSubtype;
import com.google.android.datatransport.api.internal.NetworkConnectionInfo.NetworkType;
import com.google.android.datatransport.api.internal.NetworkConnectionInfo.a;
import com.google.android.datatransport.api.internal.QosTier;
import com.google.android.datatransport.api.internal.p;
import com.google.android.datatransport.asm.ByteBufferList;
import com.google.android.datatransport.asm.Edge;
import com.google.android.datatransport.asm.io.Procedure4;
import com.google.android.datatransport.asm.io.x;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.firebase.common.ByteVector;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;

final class ClassWriter
  implements com.google.android.datatransport.runtime.backends.e
{
  private final com.google.android.datatransport.asm.asm.Label a;
  private final int b;
  private final com.google.android.datatransport.asm.asm.Label c;
  private final Context g;
  private final ByteVector q = com.google.android.datatransport.api.internal.Item.a();
  final URL u;
  private final ConnectivityManager v;
  
  ClassWriter(Context paramContext, com.google.android.datatransport.asm.asm.Label paramLabel1, com.google.android.datatransport.asm.asm.Label paramLabel2)
  {
    this(paramContext, paramLabel1, paramLabel2, 130000);
  }
  
  ClassWriter(Context paramContext, com.google.android.datatransport.asm.asm.Label paramLabel1, com.google.android.datatransport.asm.asm.Label paramLabel2, int paramInt)
  {
    g = paramContext;
    v = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    u = a(i.e);
    a = paramLabel2;
    c = paramLabel1;
    b = paramInt;
  }
  
  private com.google.android.datatransport.api.internal.Item a(com.google.android.datatransport.runtime.backends.d paramD)
  {
    Object localObject2 = new HashMap();
    paramD = paramD.getName().iterator();
    Object localObject3;
    Object localObject4;
    while (paramD.hasNext())
    {
      localObject1 = (com.google.android.datatransport.asm.Item)paramD.next();
      localObject3 = ((com.google.android.datatransport.asm.Item)localObject1).getId();
      if (!((HashMap)localObject2).containsKey(localObject3))
      {
        localObject4 = new ArrayList();
        ((List)localObject4).add(localObject1);
        ((HashMap)localObject2).put(localObject3, localObject4);
      }
      else
      {
        ((List)((HashMap)localObject2).get(localObject3)).add(localObject1);
      }
    }
    Object localObject1 = new ArrayList();
    localObject2 = ((HashMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramD = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = (com.google.android.datatransport.asm.Item)((List)paramD.getValue()).get(0);
      localObject3 = p.a().a(QosTier.e).a(c.a()).b(a.a()).a(ClientInfo.a().a(ClientInfo.ClientType.c).a(com.google.android.datatransport.api.internal.Label.a().a(Integer.valueOf(((com.google.android.datatransport.asm.Item)localObject3).a("sdk-version"))).b(((com.google.android.datatransport.asm.Item)localObject3).toString("model")).i(((com.google.android.datatransport.asm.Item)localObject3).toString("hardware")).e(((com.google.android.datatransport.asm.Item)localObject3).toString("device")).d(((com.google.android.datatransport.asm.Item)localObject3).toString("product")).l(((com.google.android.datatransport.asm.Item)localObject3).toString("os-uild")).q(((com.google.android.datatransport.asm.Item)localObject3).toString("manufacturer")).c(((com.google.android.datatransport.asm.Item)localObject3).toString("fingerprint")).p(((com.google.android.datatransport.asm.Item)localObject3).toString("country")).a(((com.google.android.datatransport.asm.Item)localObject3).toString("locale")).h(((com.google.android.datatransport.asm.Item)localObject3).toString("mcc_mnc")).f(((com.google.android.datatransport.asm.Item)localObject3).toString("application_build")).a()).a());
      try
      {
        localObject4 = paramD.getKey();
        localObject4 = (String)localObject4;
        ((com.google.android.datatransport.api.internal.e)localObject3).a(Integer.parseInt((String)localObject4));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Iterator localIterator;
        for (;;) {}
      }
      ((com.google.android.datatransport.api.internal.e)localObject3).a((String)paramD.getKey());
      localObject4 = new ArrayList();
      localIterator = ((List)paramD.getValue()).iterator();
      while (localIterator.hasNext())
      {
        com.google.android.datatransport.asm.Item localItem = (com.google.android.datatransport.asm.Item)localIterator.next();
        paramD = localItem.getName();
        Type localType = paramD.a();
        if (localType.equals(Type.valueOf("proto")))
        {
          paramD = com.google.android.datatransport.api.internal.m.remove(paramD.get());
        }
        else
        {
          if (!localType.equals(Type.valueOf("json"))) {
            break label606;
          }
          paramD = com.google.android.datatransport.api.internal.m.remove(new String(paramD.get(), Charset.forName("UTF-8")));
        }
        paramD.get(localItem.size()).put(localItem.a()).remove(localItem.getValue("tz-offset")).remove(NetworkConnectionInfo.a().a(NetworkConnectionInfo.NetworkType.b(localItem.a("net-type"))).a(NetworkConnectionInfo.MobileSubtype.b(localItem.a("mobile-subtype"))).a());
        if (localItem.getValue() != null) {
          paramD.remove(localItem.getValue());
        }
        ((List)localObject4).add(paramD.get());
        continue;
        label606:
        com.google.android.datatransport.asm.store.f.a("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", localType);
      }
      ((com.google.android.datatransport.api.internal.e)localObject3).a((List)localObject4);
      ((List)localObject1).add(((com.google.android.datatransport.api.internal.e)localObject3).a());
    }
    return com.google.android.datatransport.api.internal.Item.a((List)localObject1);
  }
  
  private static URL a(String paramString)
  {
    try
    {
      URL localURL = new URL(paramString);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid url: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString(), localMalformedURLException);
    }
  }
  
  static long convert()
  {
    Calendar.getInstance();
    return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
  }
  
  private static int d(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      return NetworkConnectionInfo.MobileSubtype.b.b();
    }
    int i = paramNetworkInfo.getSubtype();
    if (i == -1) {
      return NetworkConnectionInfo.MobileSubtype.N.b();
    }
    if (NetworkConnectionInfo.MobileSubtype.b(i) != null) {
      return i;
    }
    return 0;
  }
  
  /* Error */
  private e doInBackground(d paramD)
    throws IOException
  {
    // Byte code:
    //   0: ldc 76
    //   2: ldc_w 489
    //   5: aload_1
    //   6: getfield 490	com/google/android/datatransport/api/d:u	Ljava/net/URL;
    //   9: invokestatic 492	com/google/android/datatransport/asm/store/f:add	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   12: aload_1
    //   13: getfield 490	com/google/android/datatransport/api/d:u	Ljava/net/URL;
    //   16: invokevirtual 496	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 498	java/net/HttpURLConnection
    //   22: astore 6
    //   24: aload 6
    //   26: sipush 30000
    //   29: invokevirtual 502	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   32: aload 6
    //   34: aload_0
    //   35: getfield 71	com/google/android/datatransport/api/ClassWriter:b	I
    //   38: invokevirtual 505	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   41: aload 6
    //   43: iconst_1
    //   44: invokevirtual 509	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   47: aload 6
    //   49: iconst_0
    //   50: invokevirtual 512	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   53: aload 6
    //   55: ldc_w 514
    //   58: invokevirtual 517	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   61: aload 6
    //   63: ldc_w 519
    //   66: ldc_w 521
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: ldc_w 523
    //   78: aastore
    //   79: invokestatic 527	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 531	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload 6
    //   87: ldc_w 533
    //   90: ldc_w 535
    //   93: invokevirtual 531	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload 6
    //   98: ldc_w 537
    //   101: ldc_w 539
    //   104: invokevirtual 531	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload 6
    //   109: ldc_w 541
    //   112: ldc_w 535
    //   115: invokevirtual 531	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_1
    //   119: getfield 543	com/google/android/datatransport/api/d:q	Ljava/lang/String;
    //   122: astore 5
    //   124: aload 5
    //   126: ifnull +13 -> 139
    //   129: aload 6
    //   131: ldc_w 545
    //   134: aload 5
    //   136: invokevirtual 531	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload 6
    //   141: invokevirtual 549	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   144: astore 5
    //   146: new 551	java/util/zip/GZIPOutputStream
    //   149: dup
    //   150: aload 5
    //   152: invokespecial 554	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   155: astore 7
    //   157: aload_0
    //   158: getfield 40	com/google/android/datatransport/api/ClassWriter:q	Lcom/google/firebase/common/ByteVector;
    //   161: astore 8
    //   163: aload_1
    //   164: getfield 557	com/google/android/datatransport/api/d:g	Lcom/google/android/datatransport/api/internal/Item;
    //   167: astore_1
    //   168: aload 8
    //   170: aload_1
    //   171: new 559	java/io/BufferedWriter
    //   174: dup
    //   175: new 561	java/io/OutputStreamWriter
    //   178: dup
    //   179: aload 7
    //   181: invokespecial 562	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   184: invokespecial 565	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   187: invokeinterface 570 3 0
    //   192: aload 7
    //   194: invokevirtual 575	java/io/OutputStream:close	()V
    //   197: aload 5
    //   199: ifnull +8 -> 207
    //   202: aload 5
    //   204: invokevirtual 575	java/io/OutputStream:close	()V
    //   207: aload 6
    //   209: invokevirtual 578	java/net/HttpURLConnection:getResponseCode	()I
    //   212: istore_2
    //   213: ldc 76
    //   215: ldc_w 580
    //   218: iload_2
    //   219: invokestatic 217	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: invokestatic 492	com/google/android/datatransport/asm/store/f:add	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   225: ldc 76
    //   227: ldc_w 582
    //   230: aload 6
    //   232: ldc_w 537
    //   235: invokevirtual 585	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokestatic 84	com/google/android/datatransport/asm/store/f:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   241: ldc 76
    //   243: ldc_w 587
    //   246: aload 6
    //   248: ldc_w 533
    //   251: invokevirtual 585	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   254: invokestatic 84	com/google/android/datatransport/asm/store/f:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   257: iload_2
    //   258: sipush 302
    //   261: if_icmpeq +164 -> 425
    //   264: iload_2
    //   265: sipush 301
    //   268: if_icmpeq +157 -> 425
    //   271: iload_2
    //   272: sipush 307
    //   275: if_icmpne +6 -> 281
    //   278: goto +147 -> 425
    //   281: iload_2
    //   282: sipush 200
    //   285: if_icmpeq +14 -> 299
    //   288: new 10	com/google/android/datatransport/api/e
    //   291: dup
    //   292: iload_2
    //   293: aconst_null
    //   294: lconst_0
    //   295: invokespecial 590	com/google/android/datatransport/api/e:<init>	(ILjava/net/URL;J)V
    //   298: areturn
    //   299: aload 6
    //   301: invokevirtual 594	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   304: astore_1
    //   305: aload_1
    //   306: aload 6
    //   308: ldc_w 533
    //   311: invokevirtual 585	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   314: invokestatic 598	com/google/android/datatransport/api/ClassWriter:read	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/io/InputStream;
    //   317: astore 5
    //   319: new 600	java/io/BufferedReader
    //   322: dup
    //   323: new 602	java/io/InputStreamReader
    //   326: dup
    //   327: aload 5
    //   329: invokespecial 605	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   332: invokespecial 608	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   335: invokestatic 613	com/google/android/datatransport/api/internal/Matrix:read	(Ljava/io/Reader;)Lcom/google/android/datatransport/api/internal/Matrix;
    //   338: invokevirtual 616	com/google/android/datatransport/api/internal/Matrix:length	()J
    //   341: lstore_3
    //   342: new 10	com/google/android/datatransport/api/e
    //   345: dup
    //   346: iload_2
    //   347: aconst_null
    //   348: lload_3
    //   349: invokespecial 590	com/google/android/datatransport/api/e:<init>	(ILjava/net/URL;J)V
    //   352: astore 6
    //   354: aload 5
    //   356: ifnull +8 -> 364
    //   359: aload 5
    //   361: invokevirtual 619	java/io/InputStream:close	()V
    //   364: aload_1
    //   365: ifnull +185 -> 550
    //   368: aload_1
    //   369: invokevirtual 619	java/io/InputStream:close	()V
    //   372: aload 6
    //   374: areturn
    //   375: astore 6
    //   377: aload 5
    //   379: ifnull +20 -> 399
    //   382: aload 5
    //   384: invokevirtual 619	java/io/InputStream:close	()V
    //   387: goto +12 -> 399
    //   390: astore 5
    //   392: aload 6
    //   394: aload 5
    //   396: invokevirtual 623	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   399: aload 6
    //   401: athrow
    //   402: astore 5
    //   404: aload_1
    //   405: ifnull +17 -> 422
    //   408: aload_1
    //   409: invokevirtual 619	java/io/InputStream:close	()V
    //   412: goto +10 -> 422
    //   415: astore_1
    //   416: aload 5
    //   418: aload_1
    //   419: invokevirtual 623	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   422: aload 5
    //   424: athrow
    //   425: new 10	com/google/android/datatransport/api/e
    //   428: dup
    //   429: iload_2
    //   430: new 423	java/net/URL
    //   433: dup
    //   434: aload 6
    //   436: ldc_w 625
    //   439: invokevirtual 585	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   442: invokespecial 426	java/net/URL:<init>	(Ljava/lang/String;)V
    //   445: lconst_0
    //   446: invokespecial 590	com/google/android/datatransport/api/e:<init>	(ILjava/net/URL;J)V
    //   449: areturn
    //   450: astore_1
    //   451: aload 7
    //   453: invokevirtual 575	java/io/OutputStream:close	()V
    //   456: goto +11 -> 467
    //   459: astore 6
    //   461: aload_1
    //   462: aload 6
    //   464: invokevirtual 623	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   467: aload_1
    //   468: athrow
    //   469: astore_1
    //   470: aload 5
    //   472: ifnull +19 -> 491
    //   475: aload 5
    //   477: invokevirtual 575	java/io/OutputStream:close	()V
    //   480: goto +11 -> 491
    //   483: astore 5
    //   485: aload_1
    //   486: aload 5
    //   488: invokevirtual 623	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   491: aload_1
    //   492: athrow
    //   493: astore_1
    //   494: goto +4 -> 498
    //   497: astore_1
    //   498: ldc 76
    //   500: ldc_w 627
    //   503: aload_1
    //   504: checkcast 487	java/lang/Throwable
    //   507: invokestatic 630	com/google/android/datatransport/asm/store/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   510: new 10	com/google/android/datatransport/api/e
    //   513: dup
    //   514: sipush 400
    //   517: aconst_null
    //   518: lconst_0
    //   519: invokespecial 590	com/google/android/datatransport/api/e:<init>	(ILjava/net/URL;J)V
    //   522: areturn
    //   523: astore_1
    //   524: goto +4 -> 528
    //   527: astore_1
    //   528: ldc 76
    //   530: ldc_w 632
    //   533: aload_1
    //   534: invokestatic 630	com/google/android/datatransport/asm/store/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   537: new 10	com/google/android/datatransport/api/e
    //   540: dup
    //   541: sipush 500
    //   544: aconst_null
    //   545: lconst_0
    //   546: invokespecial 590	com/google/android/datatransport/api/e:<init>	(ILjava/net/URL;J)V
    //   549: areturn
    //   550: aload 6
    //   552: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	553	0	this	ClassWriter
    //   0	553	1	paramD	d
    //   212	218	2	i	int
    //   341	8	3	l	long
    //   122	261	5	localObject1	Object
    //   390	5	5	localThrowable1	Throwable
    //   402	74	5	localThrowable2	Throwable
    //   483	4	5	localThrowable3	Throwable
    //   22	351	6	localObject2	Object
    //   375	60	6	localThrowable4	Throwable
    //   459	92	6	localThrowable5	Throwable
    //   155	297	7	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   161	8	8	localByteVector	ByteVector
    // Exception table:
    //   from	to	target	type
    //   319	342	375	java/lang/Throwable
    //   342	354	375	java/lang/Throwable
    //   382	387	390	java/lang/Throwable
    //   305	319	402	java/lang/Throwable
    //   359	364	402	java/lang/Throwable
    //   392	399	402	java/lang/Throwable
    //   399	402	402	java/lang/Throwable
    //   408	412	415	java/lang/Throwable
    //   157	168	450	java/lang/Throwable
    //   168	192	450	java/lang/Throwable
    //   451	456	459	java/lang/Throwable
    //   146	157	469	java/lang/Throwable
    //   192	197	469	java/lang/Throwable
    //   461	467	469	java/lang/Throwable
    //   467	469	469	java/lang/Throwable
    //   475	480	483	java/lang/Throwable
    //   139	146	493	java/io/IOException
    //   202	207	493	java/io/IOException
    //   485	491	493	java/io/IOException
    //   491	493	493	java/io/IOException
    //   139	146	497	com/google/firebase/common/Number
    //   202	207	497	com/google/firebase/common/Number
    //   485	491	497	com/google/firebase/common/Number
    //   491	493	497	com/google/firebase/common/Number
    //   139	146	523	java/net/UnknownHostException
    //   202	207	523	java/net/UnknownHostException
    //   485	491	523	java/net/UnknownHostException
    //   491	493	523	java/net/UnknownHostException
    //   139	146	527	java/net/ConnectException
    //   202	207	527	java/net/ConnectException
    //   485	491	527	java/net/ConnectException
    //   491	493	527	java/net/ConnectException
  }
  
  private static TelephonyManager get(Context paramContext)
  {
    return (TelephonyManager)paramContext.getSystemService("phone");
  }
  
  private static int getType(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      return NetworkConnectionInfo.NetworkType.CREATION.getType();
    }
    return paramNetworkInfo.getType();
  }
  
  private static int getVersionCode(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      return versionCode;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      com.google.android.datatransport.asm.store.f.e("CctTransportBackend", "Unable to find version code for package", paramContext);
    }
    return -1;
  }
  
  private static InputStream read(InputStream paramInputStream, String paramString)
    throws IOException
  {
    if ("gzip".equals(paramString)) {
      return new GZIPInputStream(paramInputStream);
    }
    return paramInputStream;
  }
  
  public BackendResponse b(com.google.android.datatransport.runtime.backends.d paramD)
  {
    com.google.android.datatransport.api.internal.Item localItem = a(paramD);
    URL localURL = u;
    Object localObject3 = paramD.a();
    Object localObject2 = null;
    String str = null;
    Object localObject1 = localURL;
    if (localObject3 != null) {}
    try
    {
      localObject3 = i.a(paramD.a());
      localObject1 = ((i)localObject3).c();
      paramD = str;
      if (localObject1 != null) {
        paramD = ((i)localObject3).c();
      }
      str = ((i)localObject3).b();
      localObject1 = localURL;
      localObject2 = paramD;
      if (str == null) {
        break label103;
      }
      localObject1 = a(((i)localObject3).b());
      localObject2 = paramD;
    }
    catch (IllegalArgumentException paramD)
    {
      label103:
      for (;;) {}
    }
    return BackendResponse.b();
    try
    {
      paramD = new d((URL)localObject1, localItem, (String)localObject2);
      localObject1 = new QCandidates.3(this);
      localObject2 = c.c;
      paramD = com.google.android.datatransport.asm.io.m.a(5, paramD, (Procedure4)localObject1, (x)localObject2);
      paramD = (e)paramD;
      int i = d;
      if (i == 200)
      {
        long l = b;
        paramD = BackendResponse.b(l);
        return paramD;
      }
      if ((i < 500) && (i != 404))
      {
        if (i == 400)
        {
          paramD = BackendResponse.a();
          return paramD;
        }
        paramD = BackendResponse.b();
        return paramD;
      }
      paramD = BackendResponse.e();
      return paramD;
    }
    catch (IOException paramD)
    {
      com.google.android.datatransport.asm.store.f.e("CctTransportBackend", "Could not make request to the backend", paramD);
      return BackendResponse.e();
    }
  }
  
  public com.google.android.datatransport.asm.Item get(com.google.android.datatransport.asm.Item paramItem)
  {
    NetworkInfo localNetworkInfo = v.getActiveNetworkInfo();
    return paramItem.add().add("sdk-version", Build.VERSION.SDK_INT).append("model", Build.MODEL).append("hardware", Build.HARDWARE).append("device", Build.DEVICE).append("product", Build.PRODUCT).append("os-uild", Build.ID).append("manufacturer", Build.MANUFACTURER).append("fingerprint", Build.FINGERPRINT).add("tz-offset", convert()).add("net-type", getType(localNetworkInfo)).add("mobile-subtype", d(localNetworkInfo)).append("country", Locale.getDefault().getCountry()).append("locale", Locale.getDefault().getLanguage()).append("mcc_mnc", get(g).getSimOperator()).append("application_build", Integer.toString(getVersionCode(g))).add();
  }
}
