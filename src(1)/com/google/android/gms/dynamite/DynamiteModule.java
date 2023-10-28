package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;

@KeepForSdk
public final class DynamiteModule
{
  @KeepForSdk
  public static final int LOCAL = -1;
  @KeepForSdk
  public static final int NONE = 0;
  @KeepForSdk
  public static final int NO_SELECTION = 0;
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new NameFilter();
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new Constants.3();
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new SolidColor();
  @KeepForSdk
  public static final VersionPolicy PREFER_LOCAL;
  @KeepForSdk
  public static final VersionPolicy PREFER_REMOTE;
  @KeepForSdk
  public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING;
  @KeepForSdk
  public static final int REMOTE = 1;
  public static final VersionPolicy TYPE_PLAYLIST = new UnsignedInteger();
  private static Target a;
  private static Boolean available;
  private static final DynamiteModule.VersionPolicy.IVersions backupManager;
  private static final ThreadLocal context;
  private static int current;
  private static Table nextToken;
  private static Boolean packageName;
  private static boolean state;
  private static String url;
  private static final ThreadLocal view = new ThreadLocal();
  private final Context mContext;
  
  static
  {
    context = new BitmapHunter.1();
    backupManager = new Configurator();
    PREFER_REMOTE = new Macro();
    PREFER_LOCAL = new Log();
    PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new NumberPicker.TwoDigitFormatter();
  }
  
  private DynamiteModule(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    mContext = paramContext;
  }
  
  public static int get(Context paramContext, String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a19 = a18\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  /* Error */
  private static Table get(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 138	com/google/android/gms/dynamite/DynamiteModule:nextToken	Lcom/google/android/gms/dynamite/Table;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +8 -> 16
    //   11: ldc 2
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: ldc -116
    //   19: iconst_3
    //   20: invokevirtual 146	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   23: invokevirtual 150	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   26: ldc -104
    //   28: invokevirtual 158	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   31: invokevirtual 164	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   34: astore_0
    //   35: aload_0
    //   36: checkcast 166	android/os/IBinder
    //   39: astore_0
    //   40: aload_0
    //   41: ifnonnull +8 -> 49
    //   44: aconst_null
    //   45: astore_0
    //   46: goto +36 -> 82
    //   49: aload_0
    //   50: ldc -88
    //   52: invokeinterface 172 2 0
    //   57: astore_1
    //   58: aload_1
    //   59: instanceof 174
    //   62: ifeq +11 -> 73
    //   65: aload_1
    //   66: checkcast 174	com/google/android/gms/dynamite/Table
    //   69: astore_0
    //   70: goto +12 -> 82
    //   73: new 174	com/google/android/gms/dynamite/Table
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 177	com/google/android/gms/dynamite/Table:<init>	(Landroid/os/IBinder;)V
    //   81: astore_0
    //   82: aload_0
    //   83: ifnull +49 -> 132
    //   86: aload_0
    //   87: putstatic 138	com/google/android/gms/dynamite/DynamiteModule:nextToken	Lcom/google/android/gms/dynamite/Table;
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_0
    //   94: areturn
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   100: astore_0
    //   101: new 183	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   108: astore_1
    //   109: aload_1
    //   110: ldc -70
    //   112: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_1
    //   117: aload_0
    //   118: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc -64
    //   124: aload_1
    //   125: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: ldc 2
    //   134: monitorexit
    //   135: aconst_null
    //   136: areturn
    //   137: astore_0
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload_0
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramContext	Context
    //   6	119	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	35	95	java/lang/Exception
    //   49	58	95	java/lang/Exception
    //   73	82	95	java/lang/Exception
    //   3	7	137	java/lang/Throwable
    //   11	14	137	java/lang/Throwable
    //   16	35	137	java/lang/Throwable
    //   35	40	137	java/lang/Throwable
    //   49	58	137	java/lang/Throwable
    //   58	70	137	java/lang/Throwable
    //   73	82	137	java/lang/Throwable
    //   86	93	137	java/lang/Throwable
    //   96	132	137	java/lang/Throwable
    //   132	135	137	java/lang/Throwable
    //   138	141	137	java/lang/Throwable
  }
  
  private static void getInstance(ClassLoader paramClassLoader)
    throws DynamiteModule.LoadingException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a9 = a8\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static int getLocalVersion(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getApplicationContext().getClassLoader();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("com.google.android.gms.dynamite.descriptors.");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".ModuleDescriptor");
      localObject = paramContext.loadClass(((StringBuilder)localObject).toString());
      paramContext = ((Class)localObject).getDeclaredField("MODULE_ID");
      localObject = ((Class)localObject).getDeclaredField("MODULE_VERSION");
      boolean bool = Objects.equal(paramContext.get(null), paramString);
      if (!bool)
      {
        paramContext = String.valueOf(paramContext.get(null));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Module descriptor id '");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("' didn't match expected id '");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("'");
        android.util.Log.e("DynamiteModule", ((StringBuilder)localObject).toString());
        return 0;
      }
      int i = ((Field)localObject).getInt(null);
      return i;
    }
    catch (Exception paramContext)
    {
      android.util.Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(paramContext.getMessage())));
      return 0;
      paramContext = new StringBuilder();
      paramContext.append("Local module descriptor class for ");
      paramContext.append(paramString);
      paramContext.append(" not found.");
      android.util.Log.w("DynamiteModule", paramContext.toString());
      return 0;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;) {}
    }
  }
  
  public static int getRemoteVersion(Context paramContext, String paramString)
  {
    return get(paramContext, paramString, false);
  }
  
  private static boolean init(Context paramContext)
  {
    Object localObject = Boolean.TRUE;
    if (((Boolean)localObject).equals(null)) {
      return true;
    }
    if (((Boolean)localObject).equals(packageName)) {
      return true;
    }
    localObject = packageName;
    boolean bool1 = false;
    boolean bool2 = false;
    if (localObject == null)
    {
      localObject = paramContext.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
      bool1 = bool2;
      if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, 10000000) == 0)
      {
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if ("com.google.android.gms".equals(packageName)) {
            bool1 = true;
          }
        }
      }
      paramContext = Boolean.valueOf(bool1);
      packageName = paramContext;
      boolean bool3 = paramContext.booleanValue();
      bool2 = bool3;
      bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (localObject != null)
        {
          paramContext = applicationInfo;
          bool1 = bool2;
          if (paramContext != null)
          {
            bool1 = bool2;
            if ((flags & 0x81) == 0)
            {
              android.util.Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
              state = true;
              bool1 = bool2;
            }
          }
        }
      }
    }
    if (!bool1) {
      android.util.Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
    }
    return bool1;
  }
  
  /* Error */
  private static int load(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws DynamiteModule.LoadingException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: getstatic 69	com/google/android/gms/dynamite/DynamiteModule:context	Ljava/lang/ThreadLocal;
    //   6: astore 11
    //   8: aload 11
    //   10: invokevirtual 339	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   13: astore 11
    //   15: aload 11
    //   17: checkcast 341	java/lang/Long
    //   20: astore 11
    //   22: aload 11
    //   24: invokevirtual 345	java/lang/Long:longValue	()J
    //   27: lstore 8
    //   29: aload_0
    //   30: invokevirtual 349	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   33: astore 11
    //   35: ldc_w 351
    //   38: astore_0
    //   39: iconst_1
    //   40: istore 7
    //   42: iconst_1
    //   43: iload_2
    //   44: if_icmpeq +7 -> 51
    //   47: ldc_w 353
    //   50: astore_0
    //   51: aload 11
    //   53: new 355	android/net/Uri$Builder
    //   56: dup
    //   57: invokespecial 356	android/net/Uri$Builder:<init>	()V
    //   60: ldc_w 358
    //   63: invokevirtual 362	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   66: ldc_w 287
    //   69: invokevirtual 365	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   72: aload_0
    //   73: invokevirtual 368	android/net/Uri$Builder:path	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   76: aload_1
    //   77: invokevirtual 371	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   80: ldc_w 373
    //   83: lload 8
    //   85: invokestatic 376	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   88: invokevirtual 380	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   91: invokevirtual 384	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   94: aconst_null
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: invokevirtual 390	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore 12
    //   103: aload 12
    //   105: astore_1
    //   106: aload 12
    //   108: ifnull +235 -> 343
    //   111: aload_1
    //   112: astore 11
    //   114: aload_1
    //   115: astore_0
    //   116: aload 12
    //   118: invokeinterface 395 1 0
    //   123: istore_2
    //   124: iload_2
    //   125: ifeq +218 -> 343
    //   128: iconst_0
    //   129: istore 6
    //   131: iconst_0
    //   132: istore_2
    //   133: aload_1
    //   134: astore 11
    //   136: aload_1
    //   137: astore_0
    //   138: aload 12
    //   140: iconst_0
    //   141: invokeinterface 398 2 0
    //   146: istore 4
    //   148: aload_1
    //   149: astore 10
    //   151: iload 4
    //   153: ifle +135 -> 288
    //   156: aload_1
    //   157: astore_0
    //   158: ldc 2
    //   160: monitorenter
    //   161: aload 12
    //   163: iconst_2
    //   164: invokeinterface 402 2 0
    //   169: putstatic 404	com/google/android/gms/dynamite/DynamiteModule:url	Ljava/lang/String;
    //   172: aload 12
    //   174: ldc_w 406
    //   177: invokeinterface 410 2 0
    //   182: istore 5
    //   184: iload 5
    //   186: iflt +15 -> 201
    //   189: aload 12
    //   191: iload 5
    //   193: invokeinterface 398 2 0
    //   198: putstatic 412	com/google/android/gms/dynamite/DynamiteModule:current	I
    //   201: aload 12
    //   203: ldc_w 414
    //   206: invokeinterface 410 2 0
    //   211: istore 5
    //   213: iload 5
    //   215: iflt +25 -> 240
    //   218: aload 12
    //   220: iload 5
    //   222: invokeinterface 398 2 0
    //   227: ifeq +226 -> 453
    //   230: iload 7
    //   232: istore_2
    //   233: goto +3 -> 236
    //   236: iload_2
    //   237: putstatic 333	com/google/android/gms/dynamite/DynamiteModule:state	Z
    //   240: ldc 2
    //   242: monitorexit
    //   243: aload_1
    //   244: astore 11
    //   246: aload_1
    //   247: astore_0
    //   248: aload 12
    //   250: invokestatic 417	com/google/android/gms/dynamite/DynamiteModule:load	(Landroid/database/Cursor;)Z
    //   253: istore 7
    //   255: aload_1
    //   256: astore 10
    //   258: iload_2
    //   259: istore 6
    //   261: iload 7
    //   263: ifeq +25 -> 288
    //   266: aconst_null
    //   267: astore 10
    //   269: iload_2
    //   270: istore 6
    //   272: goto +16 -> 288
    //   275: astore 10
    //   277: ldc 2
    //   279: monitorexit
    //   280: aload_1
    //   281: astore 11
    //   283: aload_1
    //   284: astore_0
    //   285: aload 10
    //   287: athrow
    //   288: iload_3
    //   289: ifeq +39 -> 328
    //   292: iload 6
    //   294: ifne +6 -> 300
    //   297: goto +31 -> 328
    //   300: aload 10
    //   302: astore 11
    //   304: aload 10
    //   306: astore_0
    //   307: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   310: dup
    //   311: ldc_w 419
    //   314: aconst_null
    //   315: invokespecial 422	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/RotateGestureDetector$OnRotateGestureListener;)V
    //   318: astore_1
    //   319: aload 10
    //   321: astore_0
    //   322: aload_1
    //   323: athrow
    //   324: astore_1
    //   325: goto +69 -> 394
    //   328: aload 10
    //   330: ifnull +120 -> 450
    //   333: aload 10
    //   335: invokeinterface 425 1 0
    //   340: iload 4
    //   342: ireturn
    //   343: aload_1
    //   344: astore 11
    //   346: aload_1
    //   347: astore_0
    //   348: ldc -64
    //   350: ldc_w 427
    //   353: invokestatic 265	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   356: pop
    //   357: aload_1
    //   358: astore 11
    //   360: aload_1
    //   361: astore_0
    //   362: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   365: dup
    //   366: ldc_w 429
    //   369: aconst_null
    //   370: invokespecial 422	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/RotateGestureDetector$OnRotateGestureListener;)V
    //   373: astore 10
    //   375: aload_1
    //   376: astore_0
    //   377: aload 10
    //   379: athrow
    //   380: astore_0
    //   381: aload 10
    //   383: astore_1
    //   384: aload_0
    //   385: astore 10
    //   387: goto +50 -> 437
    //   390: astore_1
    //   391: aconst_null
    //   392: astore 11
    //   394: aload 11
    //   396: astore_0
    //   397: aload_1
    //   398: instanceof 9
    //   401: istore_2
    //   402: iload_2
    //   403: ifeq +11 -> 414
    //   406: aload 11
    //   408: astore_0
    //   409: aload_1
    //   410: checkcast 134	java/lang/Throwable
    //   413: athrow
    //   414: aload 11
    //   416: astore_0
    //   417: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   420: dup
    //   421: ldc_w 431
    //   424: aload_1
    //   425: checkcast 134	java/lang/Throwable
    //   428: aconst_null
    //   429: invokespecial 434	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/RotateGestureDetector$OnRotateGestureListener;)V
    //   432: athrow
    //   433: astore 10
    //   435: aload_0
    //   436: astore_1
    //   437: aload_1
    //   438: ifnull +9 -> 447
    //   441: aload_1
    //   442: invokeinterface 425 1 0
    //   447: aload 10
    //   449: athrow
    //   450: iload 4
    //   452: ireturn
    //   453: iconst_0
    //   454: istore_2
    //   455: goto -219 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	paramContext	Context
    //   0	458	1	paramString	String
    //   0	458	2	paramBoolean1	boolean
    //   0	458	3	paramBoolean2	boolean
    //   146	305	4	i	int
    //   182	39	5	j	int
    //   129	164	6	bool1	boolean
    //   40	222	7	bool2	boolean
    //   27	57	8	l	long
    //   1	267	10	str	String
    //   275	59	10	localThrowable1	Throwable
    //   373	13	10	localObject1	Object
    //   433	15	10	localThrowable2	Throwable
    //   6	409	11	localObject2	Object
    //   101	148	12	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   161	184	275	java/lang/Throwable
    //   189	201	275	java/lang/Throwable
    //   201	213	275	java/lang/Throwable
    //   218	230	275	java/lang/Throwable
    //   236	240	275	java/lang/Throwable
    //   240	243	275	java/lang/Throwable
    //   277	280	275	java/lang/Throwable
    //   116	124	324	java/lang/Exception
    //   138	148	324	java/lang/Exception
    //   248	255	324	java/lang/Exception
    //   285	288	324	java/lang/Exception
    //   307	319	324	java/lang/Exception
    //   348	357	324	java/lang/Exception
    //   362	375	324	java/lang/Exception
    //   3	8	380	java/lang/Throwable
    //   8	15	380	java/lang/Throwable
    //   22	35	380	java/lang/Throwable
    //   51	103	380	java/lang/Throwable
    //   8	15	390	java/lang/Exception
    //   22	35	390	java/lang/Exception
    //   51	103	390	java/lang/Exception
    //   116	124	433	java/lang/Throwable
    //   138	148	433	java/lang/Throwable
    //   158	161	433	java/lang/Throwable
    //   248	255	433	java/lang/Throwable
    //   285	288	433	java/lang/Throwable
    //   307	319	433	java/lang/Throwable
    //   322	324	433	java/lang/Throwable
    //   348	357	433	java/lang/Throwable
    //   362	375	433	java/lang/Throwable
    //   377	380	433	java/lang/Throwable
    //   397	402	433	java/lang/Throwable
    //   409	414	433	java/lang/Throwable
    //   417	433	433	java/lang/Throwable
  }
  
  public static DynamiteModule load(Context paramContext, VersionPolicy paramVersionPolicy, String paramString)
    throws DynamiteModule.LoadingException
  {
    Object localObject3 = view;
    Texture localTexture1 = (Texture)((ThreadLocal)localObject3).get();
    Texture localTexture2 = new Texture(null);
    ((ThreadLocal)localObject3).set(localTexture2);
    Object localObject4 = context;
    long l = ((Long)((ThreadLocal)localObject4).get()).longValue();
    for (;;)
    {
      try
      {
        ((ThreadLocal)localObject4).set(Long.valueOf(SystemClock.elapsedRealtime()));
        DynamiteModule.VersionPolicy.SelectionResult localSelectionResult = paramVersionPolicy.selectModule(paramContext, paramString, backupManager);
        int i = localVersion;
        int j = remoteVersion;
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Considering local module ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" and remote module ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(j);
        android.util.Log.i("DynamiteModule", ((StringBuilder)localObject1).toString());
        j = selection;
        if (j != 0)
        {
          i = j;
          if (j == -1)
          {
            i = localVersion;
            if (i != 0) {
              i = -1;
            }
          }
          else if (i == 1)
          {
            j = remoteVersion;
            if (j == 0) {}
          }
          else
          {
            if (i == -1)
            {
              paramContext = loadData(paramContext, paramString);
              if (l == 0L) {
                ((ThreadLocal)localObject4).remove();
              } else {
                ((ThreadLocal)localObject4).set(Long.valueOf(l));
              }
              paramVersionPolicy = data;
              if (paramVersionPolicy != null) {
                paramVersionPolicy.close();
              }
              ((ThreadLocal)localObject3).set(localTexture1);
              return paramContext;
            }
            if (i == 1)
            {
              i = remoteVersion;
              try
              {
                try
                {
                  if (init(paramContext))
                  {
                    localObject1 = available;
                    if (localObject1 == null) {}
                  }
                }
                catch (Throwable localThrowable3)
                {
                  Object localObject5;
                  Object localObject6;
                  Object localObject2;
                  throw localThrowable3;
                }
              }
              catch (Throwable localThrowable4) {}
              try
              {
                bool = ((Boolean)localObject1).booleanValue();
                if (bool)
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("Selected remote version of ");
                  ((StringBuilder)localObject1).append(paramString);
                  ((StringBuilder)localObject1).append(", version >= ");
                  ((StringBuilder)localObject1).append(i);
                  android.util.Log.i("DynamiteModule", ((StringBuilder)localObject1).toString());
                  try
                  {
                    localObject1 = a;
                    if (localObject1 != null)
                    {
                      localObject5 = ((ThreadLocal)localObject3).get();
                      localObject5 = (Texture)localObject5;
                      if (localObject5 != null)
                      {
                        localObject6 = data;
                        if (localObject6 != null)
                        {
                          localObject6 = paramContext.getApplicationContext();
                          localObject5 = data;
                          ObjectWrapper.wrap(null);
                          try
                          {
                            if (current < 2) {
                              break label1359;
                            }
                            bool = true;
                            bool = Boolean.valueOf(bool).booleanValue();
                            if (bool)
                            {
                              android.util.Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                              localObject1 = ((Target)localObject1).execute(ObjectWrapper.wrap(localObject6), paramString, i, ObjectWrapper.wrap(localObject5));
                            }
                            else
                            {
                              android.util.Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                              localObject1 = ((Target)localObject1).get(ObjectWrapper.wrap(localObject6), paramString, i, ObjectWrapper.wrap(localObject5));
                            }
                            localObject1 = ObjectWrapper.unwrap((IObjectWrapper)localObject1);
                            localObject1 = (Context)localObject1;
                            if (localObject1 != null)
                            {
                              localObject1 = new DynamiteModule((Context)localObject1);
                              paramContext = (Context)localObject1;
                              continue;
                            }
                            localObject1 = new LoadingException("Failed to get module context", null);
                            throw ((Throwable)localObject1);
                          }
                          catch (Throwable localThrowable1)
                          {
                            throw localThrowable1;
                          }
                        }
                      }
                      localLoadingException1 = new LoadingException("No result cursor", null);
                      throw localLoadingException1;
                    }
                    LoadingException localLoadingException1 = new LoadingException("DynamiteLoaderV2 was not cached.", null);
                    throw localLoadingException1;
                  }
                  catch (Throwable localThrowable2)
                  {
                    throw localThrowable2;
                  }
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Selected remote version of ");
                ((StringBuilder)localObject2).append(paramString);
                ((StringBuilder)localObject2).append(", version >= ");
                ((StringBuilder)localObject2).append(i);
                android.util.Log.i("DynamiteModule", ((StringBuilder)localObject2).toString());
                localObject2 = get(paramContext);
                if (localObject2 != null)
                {
                  j = ((Table)localObject2).register();
                  if (j >= 3)
                  {
                    localObject5 = ((ThreadLocal)localObject3).get();
                    localObject6 = (Texture)localObject5;
                    if (localObject6 != null)
                    {
                      localObject5 = ObjectWrapper.wrap(paramContext);
                      localObject6 = data;
                      localObject2 = ((Table)localObject2).get((IObjectWrapper)localObject5, paramString, i, ObjectWrapper.wrap(localObject6));
                    }
                    else
                    {
                      localObject2 = new LoadingException("No cached result cursor holder", null);
                      throw ((Throwable)localObject2);
                    }
                  }
                  else if (j == 2)
                  {
                    android.util.Log.w("DynamiteModule", "IDynamite loader version = 2");
                    localObject2 = ((Table)localObject2).get(ObjectWrapper.wrap(paramContext), paramString, i);
                  }
                  else
                  {
                    android.util.Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                    localObject2 = ((Table)localObject2).execute(ObjectWrapper.wrap(paramContext), paramString, i);
                  }
                  localObject2 = ObjectWrapper.unwrap((IObjectWrapper)localObject2);
                  if (localObject2 != null)
                  {
                    localObject2 = (Context)localObject2;
                    localObject2 = new DynamiteModule((Context)localObject2);
                    paramContext = (Context)localObject2;
                    if (l == 0L) {
                      ((ThreadLocal)localObject4).remove();
                    } else {
                      ((ThreadLocal)localObject4).set(Long.valueOf(l));
                    }
                    paramVersionPolicy = data;
                    if (paramVersionPolicy != null) {
                      paramVersionPolicy.close();
                    }
                    ((ThreadLocal)localObject3).set(localTexture1);
                    return paramContext;
                  }
                  localObject2 = new LoadingException("Failed to load remote module.", null);
                  throw ((Throwable)localObject2);
                }
                localObject2 = new LoadingException("Failed to create IDynamiteLoader.", null);
                throw ((Throwable)localObject2);
              }
              catch (LoadingException localLoadingException2)
              {
                try
                {
                  CrashUtils.addDynamiteErrorToDropBox(paramContext, localThrowable4);
                  throw new LoadingException("Failed to load remote module.", localThrowable4, null);
                }
                catch (LoadingException localLoadingException3)
                {
                  localObject3 = localLoadingException3.getMessage();
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("Failed to load remote module: ");
                  ((StringBuilder)localObject4).append((String)localObject3);
                  android.util.Log.w("DynamiteModule", ((StringBuilder)localObject4).toString());
                  i = localVersion;
                  if (i == 0) {
                    continue;
                  }
                  i = selectModuleByteVector0selection;
                  if (i != -1) {
                    continue;
                  }
                  paramContext = loadData(paramContext, paramString);
                  if (l != 0L) {
                    continue;
                  }
                  context.remove();
                  continue;
                  context.set(Long.valueOf(l));
                  paramVersionPolicy = data;
                  if (paramVersionPolicy == null) {
                    continue;
                  }
                  paramVersionPolicy.close();
                  view.set(localTexture1);
                  return paramContext;
                  throw new LoadingException("Remote load failed. No local fallback found.", localLoadingException3, null);
                }
                localLoadingException2 = localLoadingException2;
                throw localLoadingException2;
              }
              catch (RemoteException localRemoteException)
              {
                throw new LoadingException("Failed to load remote module.", localRemoteException, null);
              }
              localObject2 = new LoadingException("Failed to determine which loading route to use.", null);
              throw ((Throwable)localObject2);
              throw new LoadingException("Remote loading disabled", null);
            }
            paramContext = new StringBuilder();
            paramContext.append("VersionPolicy returned invalid code:");
            paramContext.append(i);
            throw new LoadingException(paramContext.toString(), null);
          }
        }
        i = localVersion;
        j = remoteVersion;
        paramContext = new StringBuilder();
        paramContext.append("No acceptable module ");
        paramContext.append(paramString);
        paramContext.append(" found. Local version is ");
        paramContext.append(i);
        paramContext.append(" and remote version is ");
        paramContext.append(j);
        paramContext.append(".");
        throw new LoadingException(paramContext.toString(), null);
      }
      catch (Throwable paramContext)
      {
        if (l == 0L) {
          context.remove();
        } else {
          context.set(Long.valueOf(l));
        }
        paramVersionPolicy = data;
        if (paramVersionPolicy != null) {
          paramVersionPolicy.close();
        }
        view.set(localTexture1);
        throw paramContext;
      }
      label1359:
      boolean bool = false;
    }
  }
  
  private static boolean load(Cursor paramCursor)
  {
    Texture localTexture = (Texture)view.get();
    if ((localTexture != null) && (data == null))
    {
      data = paramCursor;
      return true;
    }
    return false;
  }
  
  private static DynamiteModule loadData(Context paramContext, String paramString)
  {
    android.util.Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(paramString)));
    return new DynamiteModule(paramContext.getApplicationContext());
  }
  
  public Context getModuleContext()
  {
    return mContext;
  }
  
  public IBinder instantiate(String paramString)
    throws DynamiteModule.LoadingException
  {
    Object localObject = mContext;
    try
    {
      localObject = ((Context)localObject).getClassLoader().loadClass(paramString).newInstance();
      return (IBinder)localObject;
    }
    catch (IllegalAccessException localIllegalAccessException) {}catch (InstantiationException localInstantiationException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(paramString)), (Throwable)localClassNotFoundException, null);
  }
  
  @DynamiteApi
  public static class DynamiteLoaderClassLoader
  {
    public static ClassLoader sClassLoader;
    
    public DynamiteLoaderClassLoader() {}
  }
  
  @KeepForSdk
  public static class LoadingException
    extends Exception
  {}
  
  public static abstract interface VersionPolicy
  {
    public abstract SelectionResult selectModule(Context paramContext, String paramString, IVersions paramIVersions)
      throws DynamiteModule.LoadingException;
    
    @KeepForSdk
    public static abstract interface IVersions
    {
      public abstract int b(Context paramContext, String paramString);
      
      public abstract int b(Context paramContext, String paramString, boolean paramBoolean)
        throws DynamiteModule.LoadingException;
    }
    
    @KeepForSdk
    public static class SelectionResult
    {
      @KeepForSdk
      public int localVersion = 0;
      @KeepForSdk
      public int remoteVersion = 0;
      @KeepForSdk
      public int selection = 0;
      
      public SelectionResult() {}
    }
  }
}
