package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;

final class Database
{
  static final Value BOOLEAN = new DERSet(Type.encode("0?\004?0?\003??\003\002\001\002\002\t\000???l}?N?0"));
  static final Value DATE;
  static final Value DATE_TIME = new AbstractMultipartForm(Type.encode("0?\005?0?\003??\003\002\001\002\002\024\020?e\bs?/?Q?"));
  static final Value TIME = new NullEncoder(Type.encode("0?\006\0040?\003??\003\002\001\002\002\024\003?????r?k?"));
  private static volatile zzaf builder;
  private static Context context;
  private static final Object list = new Object();
  
  static
  {
    DATE = new UriComponents.1(Type.encode("0?\004C0?\003+?\003\002\001\002\002\t\000???FdJ0?0"));
  }
  
  private static Headers add(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a18 = a17\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private static void create()
    throws DynamiteModule.LoadingException
  {
    if (builder != null) {
      return;
    }
    Preconditions.checkNotNull(context);
    Object localObject = list;
    try
    {
      if (builder == null) {
        builder = zzae.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  static Headers get(String paramString, Type paramType, boolean paramBoolean1, boolean paramBoolean2)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      paramString = parse(paramString, paramType, paramBoolean1, paramBoolean2);
      StrictMode.setThreadPolicy(localThreadPolicy);
      return paramString;
    }
    catch (Throwable paramString)
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
      throw paramString;
    }
  }
  
  static Headers getAll(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return add(paramString, paramBoolean1, false, false, false);
  }
  
  static void init(Context paramContext)
  {
    try
    {
      if (context == null)
      {
        if (paramContext != null)
        {
          context = paramContext.getApplicationContext();
          return;
        }
        return;
      }
      Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  static boolean init()
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      create();
      zzaf localZzaf = builder;
      boolean bool = localZzaf.init();
      StrictMode.setThreadPolicy(localThreadPolicy);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      break label51;
    }
    catch (RemoteException localRemoteException) {}catch (DynamiteModule.LoadingException localLoadingException) {}
    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)localLoadingException);
    StrictMode.setThreadPolicy(localThreadPolicy);
    return false;
    label51:
    StrictMode.setThreadPolicy(localThreadPolicy);
    throw localLoadingException;
  }
  
  private static Headers parse(String paramString, Type paramType, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      create();
      Preconditions.checkNotNull(context);
      Command localCommand = new Command(paramString, paramType, paramBoolean1, paramBoolean2);
      zzaf localZzaf = builder;
      Context localContext = context;
      try
      {
        paramBoolean2 = localZzaf.execute(localCommand, ObjectWrapper.wrap(localContext.getPackageManager()));
        if (paramBoolean2) {
          return Headers.get();
        }
        return new HashBiMap.Inverse.1.1.InverseEntry(new IntegerPolynomial.CombineTask(paramBoolean1, paramString, paramType), null);
      }
      catch (RemoteException paramString)
      {
        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", paramString);
        return Headers.create("module call", paramString);
      }
      return Headers.create("module init: ".concat(String.valueOf(paramString.getMessage())), paramString);
    }
    catch (DynamiteModule.LoadingException paramString)
    {
      Log.e("GoogleCertificates", "Failed to get Google certificates from remote", paramString);
    }
  }
  
  static boolean run()
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      create();
      zzaf localZzaf = builder;
      boolean bool = localZzaf.execute();
      StrictMode.setThreadPolicy(localThreadPolicy);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      break label51;
    }
    catch (RemoteException localRemoteException) {}catch (DynamiteModule.LoadingException localLoadingException) {}
    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)localLoadingException);
    StrictMode.setThreadPolicy(localThreadPolicy);
    return false;
    label51:
    StrictMode.setThreadPolicy(localThreadPolicy);
    throw localLoadingException;
  }
  
  static Headers set(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return add(paramString, paramBoolean1, false, false, true);
  }
}
