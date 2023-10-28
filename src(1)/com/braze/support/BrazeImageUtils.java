package com.braze.support;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.braze.enums.BrazeViewBounds;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import kotlin.l;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import kotlin.x.d.r;

public final class BrazeImageUtils
{
  private static final String STROKE = BrazeLogger.INSTANCE.getBrazeLogTag("BrazeImageUtils");
  
  public static final int calculateInSampleSize(BitmapFactory.Options paramOptions, final int paramInt1, final int paramInt2)
  {
    i.e(paramOptions, "options");
    if ((paramInt2 != 0) && (paramInt1 != 0))
    {
      long l4 = outHeight;
      long l1 = outWidth;
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STROKE, null, null, new b(paramOptions, paramInt1, paramInt2), 6, null);
      paramOptions = new r();
      b = 1;
      long l5 = paramInt2;
      final long l3;
      long l2;
      long l6;
      long l7;
      if ((l4 <= l5) && (l1 <= paramInt1))
      {
        l3 = l1;
      }
      else
      {
        l2 = 2;
        l6 = l4 / l2;
        l7 = l1 / l2;
      }
      for (;;)
      {
        paramInt2 = b;
        l2 = l1;
        l3 = paramInt2;
        if ((l6 / l3 < l5) && (l7 / l3 < paramInt1))
        {
          l3 = l2;
          if (l1 * l4 / (paramInt2 * paramInt2) <= 4194304L)
          {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STROKE, null, null, new c(paramOptions, l3, l4), 6, null);
            return b;
          }
        }
        b = (paramInt2 * 2);
        l1 = l2;
      }
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STROKE, null, null, a.space, 6, null);
    return 1;
  }
  
  private static final Bitmap decodeSampledBitmapFromStream(InputStream paramInputStream, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    inSampleSize = calculateInSampleSize(paramOptions, paramInt1, paramInt2);
    inJustDecodeBounds = false;
    return BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
  }
  
  public static final Bitmap getBitmap(Context paramContext, Uri paramUri, BrazeViewBounds paramBrazeViewBounds)
  {
    i.e(paramContext, "context");
    i.e(paramUri, "uri");
    i.e(paramBrazeViewBounds, "viewBounds");
    paramContext = getDestinationHeightAndWidthPixels(paramContext, paramBrazeViewBounds);
    int i = ((Number)paramContext.a()).intValue();
    int j = ((Number)paramContext.b()).intValue();
    if (BrazeFileUtils.isLocalUri(paramUri)) {
      return getLocalBitmap(paramUri, j, i);
    }
    if (BrazeFileUtils.isRemoteUri(paramUri)) {
      return getRemoteBitmap(paramUri, j, i);
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STROKE, BrazeLogger.Priority.PREPARED, null, new d(paramUri), 4, null);
    return null;
  }
  
  public static final BitmapFactory.Options getBitmapMetadataFromStream(InputStream paramInputStream)
  {
    i.e(paramInputStream, "inputStream");
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    return localOptions;
  }
  
  public static final int getDensityDpi(Context paramContext)
  {
    i.e(paramContext, "context");
    if (Build.VERSION.SDK_INT >= 17) {
      return getResourcesgetConfigurationdensityDpi;
    }
    return populateDisplayMetricsFromDisplaydensityDpi;
  }
  
  private static final l getDestinationHeightAndWidthPixels(Context paramContext, BrazeViewBounds paramBrazeViewBounds)
  {
    l localL = getDisplayHeightAndWidthPixels(paramContext);
    final int i = ((Number)localL.a()).intValue();
    int j = ((Number)localL.b()).intValue();
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STROKE, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new e(j, i), 4, null);
    if (BrazeViewBounds.NO_BOUNDS == paramBrazeViewBounds) {
      return new l(Integer.valueOf(i), Integer.valueOf(j));
    }
    int m = getDensityDpi(paramContext);
    int k = getPixelsFromDensityAndDp(m, paramBrazeViewBounds.getHeightDp());
    m = getPixelsFromDensityAndDp(m, paramBrazeViewBounds.getWidthDp());
    return new l(Integer.valueOf(Math.min(i, k)), Integer.valueOf(Math.min(j, m)));
  }
  
  public static final l getDisplayHeightAndWidthPixels(Context paramContext)
  {
    i.e(paramContext, "context");
    paramContext = paramContext.getResources().getDisplayMetrics();
    return new l(Integer.valueOf(heightPixels), Integer.valueOf(widthPixels));
  }
  
  public static final int getDisplayWidthPixels(Context paramContext)
  {
    i.e(paramContext, "context");
    return ((Number)getDisplayHeightAndWidthPixels(paramContext).d()).intValue();
  }
  
  public static final int getImageLoaderCacheSize()
  {
    return Math.max(1024, Math.min((int)Math.min(Runtime.getRuntime().maxMemory() / 8, 2147483647L), 33554432));
  }
  
  public static final Bitmap getLocalBitmap(Uri paramUri, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a19 = a18\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  public static final int getPixelsFromDensityAndDp(int paramInt1, int paramInt2)
  {
    return Math.abs(paramInt1 * paramInt2 / 160);
  }
  
  /* Error */
  private static final Bitmap getRemoteBitmap(Uri paramUri, final int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 1337
    //   3: invokestatic 317	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   6: aload_0
    //   7: invokevirtual 323	android/net/Uri:toString	()Ljava/lang/String;
    //   10: astore 12
    //   12: aload 12
    //   14: ldc_w 325
    //   17: invokestatic 327	kotlin/x/d/i:d	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: getstatic 333	com/braze/Braze:Companion	Lcom/braze/Braze$Companion;
    //   23: invokevirtual 339	com/braze/Braze$Companion:getOutboundNetworkRequestsOffline	()Z
    //   26: istore 4
    //   28: aconst_null
    //   29: astore_0
    //   30: iload 4
    //   32: ifeq +29 -> 61
    //   35: getstatic 62	com/braze/support/BrazeLogger:INSTANCE	Lcom/braze/support/BrazeLogger;
    //   38: getstatic 70	com/braze/support/BrazeImageUtils:STROKE	Ljava/lang/String;
    //   41: getstatic 342	com/braze/support/BrazeLogger$Priority:g	Lcom/braze/support/BrazeLogger$Priority;
    //   44: aconst_null
    //   45: new 34	com/braze/support/BrazeImageUtils$o
    //   48: dup
    //   49: aload 12
    //   51: invokespecial 343	com/braze/support/BrazeImageUtils$o:<init>	(Ljava/lang/String;)V
    //   54: iconst_4
    //   55: aconst_null
    //   56: invokestatic 98	com/braze/support/BrazeLogger:brazelog$default	(Lcom/braze/support/BrazeLogger;Ljava/lang/String;Lcom/braze/support/BrazeLogger$Priority;Ljava/lang/Throwable;Lkotlin/x/c/a;ILjava/lang/Object;)V
    //   59: aconst_null
    //   60: areturn
    //   61: new 345	java/net/URL
    //   64: dup
    //   65: aload 12
    //   67: invokespecial 346	java/net/URL:<init>	(Ljava/lang/String;)V
    //   70: astore 13
    //   72: getstatic 352	protect/package_9/HttpClient:logger	Lprotect/package_9/HttpClient;
    //   75: astore 16
    //   77: aload 16
    //   79: aload 13
    //   81: invokevirtual 356	protect/package_9/HttpClient:getConnection	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   84: astore 10
    //   86: aload 10
    //   88: astore_0
    //   89: aload 10
    //   91: invokevirtual 361	java/net/HttpURLConnection:getResponseCode	()I
    //   94: istore_3
    //   95: iload_3
    //   96: sipush 200
    //   99: if_icmpeq +47 -> 146
    //   102: getstatic 62	com/braze/support/BrazeLogger:INSTANCE	Lcom/braze/support/BrazeLogger;
    //   105: astore 5
    //   107: getstatic 70	com/braze/support/BrazeImageUtils:STROKE	Ljava/lang/String;
    //   110: astore 6
    //   112: getstatic 179	com/braze/support/BrazeLogger$Priority:PREPARED	Lcom/braze/support/BrazeLogger$Priority;
    //   115: astore 7
    //   117: aload 5
    //   119: aload 6
    //   121: aload 7
    //   123: aconst_null
    //   124: new 36	com/braze/support/BrazeImageUtils$p
    //   127: dup
    //   128: iload_3
    //   129: aload 13
    //   131: invokespecial 364	com/braze/support/BrazeImageUtils$p:<init>	(ILjava/net/URL;)V
    //   134: iconst_4
    //   135: aconst_null
    //   136: invokestatic 98	com/braze/support/BrazeLogger:brazelog$default	(Lcom/braze/support/BrazeLogger;Ljava/lang/String;Lcom/braze/support/BrazeLogger$Priority;Ljava/lang/Throwable;Lkotlin/x/c/a;ILjava/lang/Object;)V
    //   139: aload 10
    //   141: invokevirtual 367	java/net/HttpURLConnection:disconnect	()V
    //   144: aconst_null
    //   145: areturn
    //   146: aload 10
    //   148: invokevirtual 371	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   151: astore 11
    //   153: aload 11
    //   155: astore 7
    //   157: iload_1
    //   158: ifeq +303 -> 461
    //   161: iload_2
    //   162: ifeq +299 -> 461
    //   165: aload_0
    //   166: astore 5
    //   168: aload 7
    //   170: astore 6
    //   172: getstatic 62	com/braze/support/BrazeLogger:INSTANCE	Lcom/braze/support/BrazeLogger;
    //   175: astore 14
    //   177: aload_0
    //   178: astore 5
    //   180: aload 7
    //   182: astore 6
    //   184: getstatic 70	com/braze/support/BrazeImageUtils:STROKE	Ljava/lang/String;
    //   187: astore 15
    //   189: aload_0
    //   190: astore 9
    //   192: aload 7
    //   194: astore 8
    //   196: aload_0
    //   197: astore 5
    //   199: aload 7
    //   201: astore 6
    //   203: aload 14
    //   205: aload 15
    //   207: aconst_null
    //   208: aconst_null
    //   209: new 38	com/braze/support/BrazeImageUtils$q
    //   212: dup
    //   213: iload_2
    //   214: iload_1
    //   215: invokespecial 372	com/braze/support/BrazeImageUtils$q:<init>	(II)V
    //   218: bipush 6
    //   220: aconst_null
    //   221: invokestatic 98	com/braze/support/BrazeLogger:brazelog$default	(Lcom/braze/support/BrazeLogger;Ljava/lang/String;Lcom/braze/support/BrazeLogger$Priority;Ljava/lang/Throwable;Lkotlin/x/c/a;ILjava/lang/Object;)V
    //   224: aload_0
    //   225: astore 9
    //   227: aload 7
    //   229: astore 8
    //   231: aload_0
    //   232: astore 5
    //   234: aload 7
    //   236: astore 6
    //   238: aload 11
    //   240: invokestatic 374	com/braze/support/BrazeImageUtils:getBitmapMetadataFromStream	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   243: astore 11
    //   245: aload_0
    //   246: astore 9
    //   248: aload 7
    //   250: astore 8
    //   252: aload_0
    //   253: astore 5
    //   255: aload 7
    //   257: astore 6
    //   259: aload 10
    //   261: invokevirtual 367	java/net/HttpURLConnection:disconnect	()V
    //   264: aload_0
    //   265: astore 9
    //   267: aload 7
    //   269: astore 8
    //   271: aload_0
    //   272: astore 5
    //   274: aload 7
    //   276: astore 6
    //   278: aload 16
    //   280: aload 13
    //   282: invokevirtual 356	protect/package_9/HttpClient:getConnection	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   285: astore 10
    //   287: aload 10
    //   289: astore_0
    //   290: aload_0
    //   291: astore 9
    //   293: aload 7
    //   295: astore 8
    //   297: aload_0
    //   298: astore 5
    //   300: aload 7
    //   302: astore 6
    //   304: aload 10
    //   306: invokevirtual 371	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   309: astore 10
    //   311: aload 10
    //   313: astore 7
    //   315: aload_0
    //   316: astore 5
    //   318: aload 7
    //   320: astore 6
    //   322: aload 11
    //   324: getfield 87	android/graphics/BitmapFactory$Options:outHeight	I
    //   327: istore_3
    //   328: iload_3
    //   329: ifeq +55 -> 384
    //   332: aload_0
    //   333: astore 5
    //   335: aload 7
    //   337: astore 6
    //   339: aload 11
    //   341: getfield 90	android/graphics/BitmapFactory$Options:outWidth	I
    //   344: istore_3
    //   345: iload_3
    //   346: ifne +6 -> 352
    //   349: goto +35 -> 384
    //   352: aload_0
    //   353: astore 9
    //   355: aload 7
    //   357: astore 8
    //   359: aload_0
    //   360: astore 5
    //   362: aload 7
    //   364: astore 6
    //   366: aload 10
    //   368: aload 11
    //   370: iload_1
    //   371: iload_2
    //   372: invokestatic 376	com/braze/support/BrazeImageUtils:decodeSampledBitmapFromStream	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;II)Landroid/graphics/Bitmap;
    //   375: astore 10
    //   377: aload 10
    //   379: astore 5
    //   381: goto +105 -> 486
    //   384: aload_0
    //   385: astore 5
    //   387: aload 7
    //   389: astore 6
    //   391: getstatic 179	com/braze/support/BrazeLogger$Priority:PREPARED	Lcom/braze/support/BrazeLogger$Priority;
    //   394: astore 16
    //   396: aload_0
    //   397: astore 9
    //   399: aload 7
    //   401: astore 8
    //   403: aload_0
    //   404: astore 5
    //   406: aload 7
    //   408: astore 6
    //   410: aload 14
    //   412: aload 15
    //   414: aload 16
    //   416: aconst_null
    //   417: new 40	com/braze/support/BrazeImageUtils$r
    //   420: dup
    //   421: aload 13
    //   423: aload 11
    //   425: invokespecial 379	com/braze/support/BrazeImageUtils$r:<init>	(Ljava/net/URL;Landroid/graphics/BitmapFactory$Options;)V
    //   428: iconst_4
    //   429: aconst_null
    //   430: invokestatic 98	com/braze/support/BrazeLogger:brazelog$default	(Lcom/braze/support/BrazeLogger;Ljava/lang/String;Lcom/braze/support/BrazeLogger$Priority;Ljava/lang/Throwable;Lkotlin/x/c/a;ILjava/lang/Object;)V
    //   433: aload_0
    //   434: astore 9
    //   436: aload 7
    //   438: astore 8
    //   440: aload_0
    //   441: astore 5
    //   443: aload 7
    //   445: astore 6
    //   447: aload 10
    //   449: invokestatic 382	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   452: astore 10
    //   454: aload 10
    //   456: astore 5
    //   458: goto +28 -> 486
    //   461: aload_0
    //   462: astore 9
    //   464: aload 7
    //   466: astore 8
    //   468: aload_0
    //   469: astore 5
    //   471: aload 7
    //   473: astore 6
    //   475: aload 11
    //   477: invokestatic 382	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   480: astore 10
    //   482: aload 10
    //   484: astore 5
    //   486: aload_0
    //   487: invokevirtual 367	java/net/HttpURLConnection:disconnect	()V
    //   490: aload 7
    //   492: ifnull +231 -> 723
    //   495: aload 7
    //   497: invokevirtual 387	java/io/InputStream:close	()V
    //   500: aload 5
    //   502: areturn
    //   503: astore_0
    //   504: getstatic 62	com/braze/support/BrazeLogger:INSTANCE	Lcom/braze/support/BrazeLogger;
    //   507: getstatic 70	com/braze/support/BrazeImageUtils:STROKE	Ljava/lang/String;
    //   510: getstatic 390	com/braze/support/BrazeLogger$Priority:this$0	Lcom/braze/support/BrazeLogger$Priority;
    //   513: aload_0
    //   514: getstatic 393	com/braze/support/BrazeImageUtils$t:PREPARED	Lcom/braze/support/BrazeImageUtils$t;
    //   517: invokevirtual 397	com/braze/support/BrazeLogger:brazelog	(Ljava/lang/String;Lcom/braze/support/BrazeLogger$Priority;Ljava/lang/Throwable;Lkotlin/x/c/a;)V
    //   520: aload 5
    //   522: areturn
    //   523: astore 5
    //   525: aload 9
    //   527: astore_0
    //   528: aload 8
    //   530: astore 7
    //   532: aload 5
    //   534: astore 8
    //   536: goto +34 -> 570
    //   539: astore 7
    //   541: aconst_null
    //   542: astore 6
    //   544: goto +138 -> 682
    //   547: astore 8
    //   549: aconst_null
    //   550: astore 7
    //   552: goto +18 -> 570
    //   555: astore 7
    //   557: aconst_null
    //   558: astore 6
    //   560: goto +122 -> 682
    //   563: astore 8
    //   565: aconst_null
    //   566: astore_0
    //   567: aconst_null
    //   568: astore 7
    //   570: aload_0
    //   571: astore 5
    //   573: aload 7
    //   575: astore 6
    //   577: getstatic 62	com/braze/support/BrazeLogger:INSTANCE	Lcom/braze/support/BrazeLogger;
    //   580: astore 9
    //   582: aload_0
    //   583: astore 5
    //   585: aload 7
    //   587: astore 6
    //   589: getstatic 70	com/braze/support/BrazeImageUtils:STROKE	Ljava/lang/String;
    //   592: astore 10
    //   594: aload_0
    //   595: astore 5
    //   597: aload 7
    //   599: astore 6
    //   601: getstatic 390	com/braze/support/BrazeLogger$Priority:this$0	Lcom/braze/support/BrazeLogger$Priority;
    //   604: astore 11
    //   606: aload_0
    //   607: astore 5
    //   609: aload 7
    //   611: astore 6
    //   613: aload 9
    //   615: aload 10
    //   617: aload 11
    //   619: aload 8
    //   621: new 42	com/braze/support/BrazeImageUtils$s
    //   624: dup
    //   625: aload 12
    //   627: aload 8
    //   629: checkcast 307	java/lang/Exception
    //   632: invokespecial 400	com/braze/support/BrazeImageUtils$s:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   635: invokevirtual 397	com/braze/support/BrazeLogger:brazelog	(Ljava/lang/String;Lcom/braze/support/BrazeLogger$Priority;Ljava/lang/Throwable;Lkotlin/x/c/a;)V
    //   638: aload_0
    //   639: ifnull +7 -> 646
    //   642: aload_0
    //   643: invokevirtual 367	java/net/HttpURLConnection:disconnect	()V
    //   646: aload 7
    //   648: ifnull +78 -> 726
    //   651: aload 7
    //   653: invokevirtual 387	java/io/InputStream:close	()V
    //   656: aconst_null
    //   657: areturn
    //   658: astore_0
    //   659: getstatic 62	com/braze/support/BrazeLogger:INSTANCE	Lcom/braze/support/BrazeLogger;
    //   662: getstatic 70	com/braze/support/BrazeImageUtils:STROKE	Ljava/lang/String;
    //   665: getstatic 390	com/braze/support/BrazeLogger$Priority:this$0	Lcom/braze/support/BrazeLogger$Priority;
    //   668: aload_0
    //   669: getstatic 393	com/braze/support/BrazeImageUtils$t:PREPARED	Lcom/braze/support/BrazeImageUtils$t;
    //   672: invokevirtual 397	com/braze/support/BrazeLogger:brazelog	(Ljava/lang/String;Lcom/braze/support/BrazeLogger$Priority;Ljava/lang/Throwable;Lkotlin/x/c/a;)V
    //   675: aconst_null
    //   676: areturn
    //   677: astore 7
    //   679: aload 5
    //   681: astore_0
    //   682: aload_0
    //   683: ifnull +7 -> 690
    //   686: aload_0
    //   687: invokevirtual 367	java/net/HttpURLConnection:disconnect	()V
    //   690: aload 6
    //   692: ifnull +28 -> 720
    //   695: aload 6
    //   697: invokevirtual 387	java/io/InputStream:close	()V
    //   700: goto +20 -> 720
    //   703: astore_0
    //   704: getstatic 62	com/braze/support/BrazeLogger:INSTANCE	Lcom/braze/support/BrazeLogger;
    //   707: getstatic 70	com/braze/support/BrazeImageUtils:STROKE	Ljava/lang/String;
    //   710: getstatic 390	com/braze/support/BrazeLogger$Priority:this$0	Lcom/braze/support/BrazeLogger$Priority;
    //   713: aload_0
    //   714: getstatic 393	com/braze/support/BrazeImageUtils$t:PREPARED	Lcom/braze/support/BrazeImageUtils$t;
    //   717: invokevirtual 397	com/braze/support/BrazeLogger:brazelog	(Ljava/lang/String;Lcom/braze/support/BrazeLogger$Priority;Ljava/lang/Throwable;Lkotlin/x/c/a;)V
    //   720: aload 7
    //   722: athrow
    //   723: aload 5
    //   725: areturn
    //   726: aconst_null
    //   727: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	728	0	paramUri	Uri
    //   0	728	1	paramInt1	int
    //   0	728	2	paramInt2	int
    //   94	252	3	i	int
    //   26	5	4	bool	boolean
    //   105	416	5	localObject1	Object
    //   523	10	5	localException1	Exception
    //   571	153	5	localUri	Uri
    //   110	586	6	localObject2	Object
    //   115	416	7	localObject3	Object
    //   539	1	7	localThrowable1	Throwable
    //   550	1	7	localObject4	Object
    //   555	1	7	localThrowable2	Throwable
    //   568	84	7	localObject5	Object
    //   677	44	7	localThrowable3	Throwable
    //   194	341	8	localObject6	Object
    //   547	1	8	localException2	Exception
    //   563	65	8	localException3	Exception
    //   190	424	9	localObject7	Object
    //   84	532	10	localObject8	Object
    //   151	467	11	localObject9	Object
    //   10	616	12	str1	String
    //   70	352	13	localURL	URL
    //   175	236	14	localBrazeLogger	BrazeLogger
    //   187	226	15	str2	String
    //   75	340	16	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   495	500	503	java/io/IOException
    //   203	224	523	java/lang/Exception
    //   238	245	523	java/lang/Exception
    //   259	264	523	java/lang/Exception
    //   278	287	523	java/lang/Exception
    //   304	311	523	java/lang/Exception
    //   366	377	523	java/lang/Exception
    //   410	433	523	java/lang/Exception
    //   447	454	523	java/lang/Exception
    //   475	482	523	java/lang/Exception
    //   89	95	539	java/lang/Throwable
    //   102	117	539	java/lang/Throwable
    //   117	139	539	java/lang/Throwable
    //   146	153	539	java/lang/Throwable
    //   89	95	547	java/lang/Exception
    //   117	139	547	java/lang/Exception
    //   146	153	547	java/lang/Exception
    //   61	72	555	java/lang/Throwable
    //   77	86	555	java/lang/Throwable
    //   61	72	563	java/lang/Exception
    //   77	86	563	java/lang/Exception
    //   651	656	658	java/io/IOException
    //   172	177	677	java/lang/Throwable
    //   184	189	677	java/lang/Throwable
    //   203	224	677	java/lang/Throwable
    //   238	245	677	java/lang/Throwable
    //   259	264	677	java/lang/Throwable
    //   278	287	677	java/lang/Throwable
    //   304	311	677	java/lang/Throwable
    //   322	328	677	java/lang/Throwable
    //   339	345	677	java/lang/Throwable
    //   366	377	677	java/lang/Throwable
    //   391	396	677	java/lang/Throwable
    //   410	433	677	java/lang/Throwable
    //   447	454	677	java/lang/Throwable
    //   475	482	677	java/lang/Throwable
    //   577	582	677	java/lang/Throwable
    //   589	594	677	java/lang/Throwable
    //   601	606	677	java/lang/Throwable
    //   613	638	677	java/lang/Throwable
    //   695	700	703	java/io/IOException
  }
  
  private static final DisplayMetrics populateDisplayMetricsFromDisplay(Context paramContext)
  {
    paramContext = paramContext.getSystemService("window");
    Objects.requireNonNull(paramContext, "null cannot be cast to non-null type android.view.WindowManager");
    paramContext = (WindowManager)paramContext;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static final void resizeImageViewToBitmapDimensions(Bitmap paramBitmap, ImageView paramImageView)
  {
    i.e(paramImageView, "imageView");
    resizeToBitmapDimensions(paramImageView, paramBitmap);
  }
  
  public static final void resizeToBitmapDimensions(ImageView paramImageView, Bitmap paramBitmap)
  {
    i.e(paramImageView, "<this>");
    if (paramBitmap == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STROKE, BrazeLogger.Priority.PREPARED, null, u.PLAYING, 4, null);
      return;
    }
    if ((paramBitmap.getWidth() != 0) && (paramBitmap.getHeight() != 0))
    {
      if ((paramImageView.getWidth() != 0) && (paramImageView.getHeight() != 0))
      {
        float f = paramBitmap.getWidth() / paramBitmap.getHeight();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STROKE, null, null, new x(f), 6, null);
        getLayoutParamsheight = ((int)(paramImageView.getWidth() / f));
        return;
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STROKE, BrazeLogger.Priority.PREPARED, null, w.PLAYING, 4, null);
      return;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STROKE, BrazeLogger.Priority.PREPARED, null, v.STARTED, 4, null);
  }
  
  static final class a
    extends j
    implements a<String>
  {
    public static final a space = new a();
    
    a()
    {
      super();
    }
    
    public final String getText()
    {
      return "Not sampling on 0 destination width or height";
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
    {
      super();
    }
    
    public final String load()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Calculating sample size for source image bounds: (width ");
      localStringBuilder.append(mOptions.outWidth);
      localStringBuilder.append(" height ");
      localStringBuilder.append(mOptions.outHeight);
      localStringBuilder.append(") and destination image bounds: (width ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" height ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    c(r paramR, long paramLong1, long paramLong2)
    {
      super();
    }
    
    public final String a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Using image sample size of ");
      localStringBuilder.append(j.b);
      localStringBuilder.append(". Image will be scaled to width: ");
      localStringBuilder.append(l3 / j.b);
      localStringBuilder.append(" and height: ");
      localStringBuilder.append(d / j.b);
      return localStringBuilder.toString();
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    d(Uri paramUri)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Uri with unknown scheme received. Not getting image. Uri: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    e(int paramInt1, int paramInt2)
    {
      super();
    }
    
    public final String encode()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Display width: ");
      localStringBuilder.append(wordCount);
      localStringBuilder.append(" and height ");
      localStringBuilder.append(i);
      return localStringBuilder.toString();
    }
  }
  
  static final class f
    extends j
    implements a<String>
  {
    f(Uri paramUri)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Local bitmap path is null. URI: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class g
    extends j
    implements a<String>
  {
    g(Uri paramUri)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Local bitmap file does not exist. URI: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class h
    extends j
    implements a<String>
  {
    h(File paramFile)
    {
      super();
    }
    
    public final String extract()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Retrieving image from local path: ");
      localStringBuilder.append(dest.getAbsolutePath());
      return localStringBuilder.toString();
    }
  }
  
  static final class i
    extends j
    implements a<String>
  {
    public static final i PLAYING = new i();
    
    i()
    {
      super();
    }
    
    public final String getText()
    {
      return "Destination bounds unset. Loading entire bitmap into memory.";
    }
  }
  
  static final class j
    extends j
    implements a<String>
  {
    j(int paramInt1, int paramInt2)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Sampling bitmap with destination image bounds: (width ");
      localStringBuilder.append(k);
      localStringBuilder.append(" height ");
      localStringBuilder.append(j);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
  
  static final class k
    extends j
    implements a<String>
  {
    k(Uri paramUri, BitmapFactory.Options paramOptions)
    {
      super();
    }
    
    public final String doInBackground()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The bitmap metadata with image uri ");
      localStringBuilder.append(mUsername);
      localStringBuilder.append(" had bounds: (height ");
      localStringBuilder.append(mOptions.outHeight);
      localStringBuilder.append(" width ");
      localStringBuilder.append(mOptions.outWidth);
      localStringBuilder.append("). Returning a bitmap with no sampling.");
      return localStringBuilder.toString();
    }
  }
  
  static final class l
    extends j
    implements a<String>
  {
    public static final l PREPARING = new l();
    
    l()
    {
      super();
    }
    
    public final String getText()
    {
      return "Decoding sampled bitmap";
    }
  }
  
  static final class m
    extends j
    implements a<String>
  {
    m(Exception paramException)
    {
      super();
    }
    
    public final String handleResponse()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception occurred when attempting to retrieve local bitmap. ");
      localStringBuilder.append(val$ex.getMessage());
      return localStringBuilder.toString();
    }
  }
  
  static final class n
    extends j
    implements a<String>
  {
    public static final n PREPARED = new n();
    
    n()
    {
      super();
    }
    
    public final String getText()
    {
      return "IOException during closing of bitmap metadata image stream.";
    }
  }
  
  static final class o
    extends j
    implements a<String>
  {
    o(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SDK is in offline mode, not downloading remote bitmap with uri: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class p
    extends j
    implements a<String>
  {
    p(int paramInt, URL paramURL)
    {
      super();
    }
    
    public final String encode()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HTTP response code was ");
      localStringBuilder.append(wordCount);
      localStringBuilder.append(". Bitmap with url ");
      localStringBuilder.append(localURL);
      localStringBuilder.append(" could not be downloaded.");
      return localStringBuilder.toString();
    }
  }
  
  static final class q
    extends j
    implements a<String>
  {
    q(int paramInt1, int paramInt2)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Sampling bitmap with destination image bounds: (height ");
      localStringBuilder.append(k);
      localStringBuilder.append(" width ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
  
  static final class r
    extends j
    implements a<String>
  {
    r(URL paramURL, BitmapFactory.Options paramOptions)
    {
      super();
    }
    
    public final String doInBackground()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The bitmap metadata with image url ");
      localStringBuilder.append(mUsername);
      localStringBuilder.append(" had bounds: (height ");
      localStringBuilder.append(mOptions.outHeight);
      localStringBuilder.append(" width ");
      localStringBuilder.append(mOptions.outWidth);
      localStringBuilder.append("). Returning a bitmap with no sampling.");
      return localStringBuilder.toString();
    }
  }
  
  static final class s
    extends j
    implements a<String>
  {
    s(String paramString, Exception paramException)
    {
      super();
    }
    
    public final String getValue()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception in image bitmap download for Uri: ");
      localStringBuilder.append(d);
      localStringBuilder.append(' ');
      localStringBuilder.append(e.getMessage());
      return localStringBuilder.toString();
    }
  }
  
  static final class t
    extends j
    implements a<String>
  {
    public static final t PREPARED = new t();
    
    t()
    {
      super();
    }
    
    public final String getText()
    {
      return "IOException during closing of bitmap metadata download stream.";
    }
  }
  
  static final class u
    extends j
    implements a<String>
  {
    public static final u PLAYING = new u();
    
    u()
    {
      super();
    }
    
    public final String getText()
    {
      return "Neither source bitmap nor ImageView may be null. Not resizing ImageView";
    }
  }
  
  static final class v
    extends j
    implements a<String>
  {
    public static final v STARTED = new v();
    
    v()
    {
      super();
    }
    
    public final String getText()
    {
      return "Bitmap dimensions cannot be 0. Not resizing ImageView";
    }
  }
  
  static final class w
    extends j
    implements a<String>
  {
    public static final w PLAYING = new w();
    
    w()
    {
      super();
    }
    
    public final String getText()
    {
      return "ImageView dimensions cannot be 0. Not resizing ImageView";
    }
  }
  
  static final class x
    extends j
    implements a<String>
  {
    x(float paramFloat)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Resizing ImageView to aspect ratio: ");
      localStringBuilder.append(line);
      return localStringBuilder.toString();
    }
  }
}
