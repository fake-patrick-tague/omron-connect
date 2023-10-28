package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import java.io.File;

public class Volley
{
  private static final String DEFAULT_CACHE_DIR = "volley";
  
  public Volley() {}
  
  public static RequestQueue newRequestQueue(Context paramContext)
  {
    return newRequestQueue(paramContext, null);
  }
  
  private static RequestQueue newRequestQueue(Context paramContext, Network paramNetwork)
  {
    paramContext = new RequestQueue(new DiskBasedCache(new DiskBasedCache.FileSupplier()
    {
      private File cacheDir = null;
      
      public File getCacheDir()
      {
        if (cacheDir == null) {
          cacheDir = new File(Volley.this.getCacheDir(), "volley");
        }
        return cacheDir;
      }
    }), paramNetwork);
    paramContext.start();
    return paramContext;
  }
  
  public static RequestQueue newRequestQueue(Context paramContext, BaseHttpStack paramBaseHttpStack)
  {
    if (paramBaseHttpStack == null) {
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramBaseHttpStack = new BasicNetwork(new HurlStack());
        break label124;
      }
    }
    try
    {
      paramBaseHttpStack = paramContext.getPackageName();
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramBaseHttpStack, 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBaseHttpStack);
      localStringBuilder.append("/");
      int i = versionCode;
      localStringBuilder.append(i);
      paramBaseHttpStack = localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException paramBaseHttpStack)
    {
      for (;;) {}
    }
    paramBaseHttpStack = "volley/0";
    paramBaseHttpStack = new BasicNetwork(new HttpClientStack(AndroidHttpClient.newInstance(paramBaseHttpStack)));
    break label124;
    paramBaseHttpStack = new BasicNetwork(paramBaseHttpStack);
    label124:
    return newRequestQueue(paramContext, paramBaseHttpStack);
  }
  
  public static RequestQueue newRequestQueue(Context paramContext, HttpStack paramHttpStack)
  {
    if (paramHttpStack == null) {
      return newRequestQueue(paramContext, null);
    }
    return newRequestQueue(paramContext, new BasicNetwork(paramHttpStack));
  }
}
