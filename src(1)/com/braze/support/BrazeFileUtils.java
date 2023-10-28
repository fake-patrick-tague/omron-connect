package com.braze.support;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build.VERSION;
import com.braze.Braze;
import com.braze.Braze.Companion;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import kotlin.io.b;
import kotlin.x.c.a;
import kotlin.x.d.j;
import protect.package_9.Handler;
import protect.package_9.HttpClient;

public final class BrazeFileUtils
{
  private static final String PLAYING = BrazeLogger.INSTANCE.getBrazeLogTag("BrazeFileUtils");
  public static final List<String> REMOTE_SCHEMES = kotlin.collections.i.f(new String[] { "http", "https", "ftp", "ftps", "about", "javascript" });
  
  public static final void deleteFileOrDirectory(File paramFile)
  {
    kotlin.x.d.i.e(paramFile, "fileOrDirectory");
    if (!kotlin.io.g.c(paramFile)) {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.PREPARED, null, new a(paramFile), 4, null);
    }
  }
  
  public static final void deleteSharedPreferencesFile(Context paramContext, File paramFile)
  {
    kotlin.x.d.i.e(paramContext, "context");
    kotlin.x.d.i.e(paramFile, "file");
    if (!paramFile.exists())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.PREPARED, null, new b(paramFile), 4, null);
      return;
    }
    String str = paramFile.getName();
    kotlin.x.d.i.d(str, "fileName");
    if (!kotlin.text.g.m(str, ".xml", false, 2, null))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.PREPARED, null, new c(paramFile), 4, null);
      return;
    }
    str = kotlin.text.g.V(str, ".xml");
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramContext.deleteSharedPreferences(str);
      return;
    }
    paramContext.getSharedPreferences(str, 0).edit().clear().commit();
    deleteFileOrDirectory(paramFile);
  }
  
  public static final kotlin.l downloadFileToPath(String paramString1, final String paramString2, String paramString3, String paramString4)
  {
    kotlin.x.d.i.e(paramString1, "downloadDirectoryAbsolutePath");
    kotlin.x.d.i.e(paramString2, "remoteFileUrl");
    kotlin.x.d.i.e(paramString3, "outputFilename");
    TrafficStats.setThreadStatsTag(1337);
    if (!Braze.Companion.getOutboundNetworkRequestsOffline())
    {
      if (!kotlin.text.g.o(paramString1))
      {
        if (!kotlin.text.g.o(paramString2))
        {
          if (!kotlin.text.g.o(paramString3))
          {
            Object localObject3 = null;
            Object localObject4 = null;
            Object localObject1 = localObject4;
            try
            {
              new File(paramString1).mkdirs();
              if (paramString4 != null)
              {
                localObject1 = localObject4;
                boolean bool = kotlin.text.g.o(paramString4);
                if (!bool)
                {
                  i = 0;
                  break label107;
                }
              }
              int i = 1;
              label107:
              Object localObject2 = paramString3;
              if (i == 0)
              {
                localObject1 = localObject4;
                localObject2 = new StringBuilder();
                localObject1 = localObject4;
                ((StringBuilder)localObject2).append(paramString3);
                localObject1 = localObject4;
                ((StringBuilder)localObject2).append(paramString4);
                localObject1 = localObject4;
                localObject2 = ((StringBuilder)localObject2).toString();
              }
              localObject1 = localObject4;
              paramString3 = new File(paramString1, (String)localObject2);
              localObject1 = localObject4;
              paramString1 = new URL(paramString2);
              paramString4 = HttpClient.logger;
              localObject1 = localObject4;
              paramString1 = paramString4.getConnection(paramString1);
              try
              {
                i = paramString1.getResponseCode();
                if (i == 200)
                {
                  paramString4 = new DataInputStream(paramString1.getInputStream());
                  try
                  {
                    localObject1 = new FileOutputStream(paramString3);
                    try
                    {
                      b.b(paramString4, (OutputStream)localObject1, 0, 2, null);
                      kotlin.io.c.a((Closeable)localObject1, null);
                      kotlin.io.c.a(paramString4, null);
                      paramString4 = paramString1.getHeaderFields();
                      kotlin.x.d.i.d(paramString4, "urlConnection.headerFields");
                      paramString4 = Handler.filter(paramString4);
                      paramString1.disconnect();
                      return new kotlin.l(paramString3, paramString4);
                    }
                    catch (Throwable paramString3)
                    {
                      try
                      {
                        throw paramString3;
                      }
                      catch (Throwable localThrowable2)
                      {
                        kotlin.io.c.a((Closeable)localObject1, paramString3);
                        throw localThrowable2;
                      }
                    }
                    paramString3 = BrazeLogger.INSTANCE;
                  }
                  catch (Throwable paramString3)
                  {
                    try
                    {
                      throw paramString3;
                    }
                    catch (Throwable localThrowable1)
                    {
                      kotlin.io.c.a(paramString4, paramString3);
                      throw localThrowable1;
                    }
                  }
                }
                paramString4 = PLAYING;
                BrazeLogger.brazelog$default(paramString3, paramString4, null, null, new h(i, paramString2), 6, null);
                paramString3 = new StringBuilder();
                paramString3.append("HTTP response code was ");
                paramString3.append(i);
                paramString3.append(". File with url ");
                paramString3.append(paramString2);
                paramString3.append(" could not be downloaded.");
                throw new Exception(paramString3.toString());
              }
              catch (Throwable paramString2)
              {
                break label492;
              }
              catch (Exception paramString3) {}
              str = paramString1;
            }
            catch (Throwable paramString2)
            {
              paramString1 = localThrowable1;
            }
            catch (Exception paramString3)
            {
              paramString1 = localObject3;
            }
            BrazeLogger.INSTANCE.brazelog(PLAYING, BrazeLogger.Priority.this$0, paramString3, new i(paramString2));
            String str = paramString1;
            paramString3 = new StringBuilder();
            str = paramString1;
            paramString3.append("Exception during download of file from url : ");
            str = paramString1;
            paramString3.append(paramString2);
            str = paramString1;
            throw new Exception(paramString3.toString());
            label492:
            if (paramString1 != null) {
              paramString1.disconnect();
            }
            throw paramString2;
          }
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.g, null, g.components, 4, null);
          throw new Exception("Output filename is blank. File not downloaded.");
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.g, null, f.components, 4, null);
        throw new Exception("Zip file url is blank. File not downloaded.");
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.g, null, e.components, 4, null);
      throw new Exception("Download directory is blank. File not downloaded.");
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.g, null, new d(paramString2), 4, null);
    paramString1 = new StringBuilder();
    paramString1.append("SDK is offline. File not downloaded for url: ");
    paramString1.append(paramString2);
    throw new Exception(paramString1.toString());
  }
  
  public static final String getAssetFileStringContents(AssetManager paramAssetManager, String paramString)
  {
    kotlin.x.d.i.e(paramAssetManager, "<this>");
    kotlin.x.d.i.e(paramString, "assetPath");
    paramAssetManager = paramAssetManager.open(paramString);
    kotlin.x.d.i.d(paramAssetManager, "this.open(assetPath)");
    paramAssetManager = new InputStreamReader(paramAssetManager, kotlin.text.c.b);
    if ((paramAssetManager instanceof BufferedReader)) {
      paramAssetManager = (BufferedReader)paramAssetManager;
    } else {
      paramAssetManager = new BufferedReader(paramAssetManager, 8192);
    }
    try
    {
      paramString = kotlin.io.l.c(paramAssetManager);
      kotlin.io.c.a(paramAssetManager, null);
      return paramString;
    }
    catch (Throwable paramString)
    {
      try
      {
        throw paramString;
      }
      catch (Throwable localThrowable)
      {
        kotlin.io.c.a(paramAssetManager, paramString);
        throw localThrowable;
      }
    }
  }
  
  public static final boolean isLocalUri(Uri paramUri)
  {
    kotlin.x.d.i.e(paramUri, "<this>");
    paramUri = paramUri.getScheme();
    int i;
    if ((paramUri != null) && (!kotlin.text.g.o(paramUri))) {
      i = 0;
    } else {
      i = 1;
    }
    return (i != 0) || (kotlin.x.d.i.a(paramUri, "file"));
  }
  
  public static final boolean isRemoteUri(Uri paramUri)
  {
    kotlin.x.d.i.e(paramUri, "<this>");
    paramUri = paramUri.getScheme();
    int i;
    if ((paramUri != null) && (!kotlin.text.g.o(paramUri))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.g, null, j.components, 4, null);
      return false;
    }
    return REMOTE_SCHEMES.contains(paramUri);
  }
  
  static final class a
    extends j
    implements a<String>
  {
    a(File paramFile)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not recursively delete ");
      localStringBuilder.append(source.getName());
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    b(File paramFile)
    {
      super();
    }
    
    public final String extract()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot delete SharedPreferences that does not exist. Path: ");
      localStringBuilder.append(dest.getAbsolutePath());
      return localStringBuilder.toString();
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    c(File paramFile)
    {
      super();
    }
    
    public final String extract()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences file is expected to end in .xml. Path: ");
      localStringBuilder.append(dest.getAbsolutePath());
      return localStringBuilder.toString();
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    d(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SDK is offline. File not downloaded for url: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    public static final e components = new e();
    
    e()
    {
      super();
    }
    
    public final String getText()
    {
      return "Download directory null or blank. File not downloaded.";
    }
  }
  
  static final class f
    extends j
    implements a<String>
  {
    public static final f components = new f();
    
    f()
    {
      super();
    }
    
    public final String getText()
    {
      return "Zip file url null or blank. File not downloaded.";
    }
  }
  
  static final class g
    extends j
    implements a<String>
  {
    public static final g components = new g();
    
    g()
    {
      super();
    }
    
    public final String getText()
    {
      return "Output filename null or blank. File not downloaded.";
    }
  }
  
  static final class h
    extends j
    implements a<String>
  {
    h(int paramInt, String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HTTP response code was ");
      localStringBuilder.append(subscribers);
      localStringBuilder.append(". File with url ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" could not be downloaded.");
      return localStringBuilder.toString();
    }
  }
  
  static final class i
    extends j
    implements a<String>
  {
    i(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception during download of file from url : ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class j
    extends j
    implements a<String>
  {
    public static final j components = new j();
    
    j()
    {
      super();
    }
    
    public final String getText()
    {
      return "Null or blank Uri scheme.";
    }
  }
}
