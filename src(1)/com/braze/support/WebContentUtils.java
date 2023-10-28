package com.braze.support;

import android.content.Context;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.io.b;
import kotlin.io.c;
import kotlin.l;
import kotlin.t;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import kotlin.x.d.s;

public final class WebContentUtils
{
  public static final WebContentUtils INSTANCE = new WebContentUtils();
  
  private WebContentUtils() {}
  
  public static final File getHtmlInAppMessageAssetCacheDirectory(Context paramContext)
  {
    i.e(paramContext, "context");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getCacheDir().getPath());
    localStringBuilder.append('/');
    localStringBuilder.append("braze-html-inapp-messages");
    return new File(localStringBuilder.toString());
  }
  
  public static final String getLocalHtmlUrlFromRemoteUrl(final File paramFile, String paramString)
  {
    i.e(paramFile, "localDirectory");
    i.e(paramString, "remoteZipUrl");
    if (g.o(paramString))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, a.PLAYING, 2, null);
      return null;
    }
    paramFile = paramFile.getAbsolutePath();
    Object localObject1 = String.valueOf(IntentUtils.getRequestCode());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramFile);
    ((StringBuilder)localObject2).append('/');
    ((StringBuilder)localObject2).append((String)localObject1);
    paramFile = ((StringBuilder)localObject2).toString();
    localObject2 = BrazeLogger.INSTANCE;
    WebContentUtils localWebContentUtils = INSTANCE;
    BrazeLogger.brazelog$default((BrazeLogger)localObject2, localWebContentUtils, null, null, new b(paramString, paramFile), 3, null);
    try
    {
      localObject1 = BrazeFileUtils.downloadFileToPath(paramFile, paramString, (String)localObject1, ".zip");
      localObject1 = (File)((l)localObject1).a();
      BrazeLogger.brazelog$default((BrazeLogger)localObject2, localWebContentUtils, null, null, new d(paramString, paramFile), 3, null);
      if (!unpackZipIntoDirectory(paramFile, (File)localObject1))
      {
        BrazeLogger.brazelog$default((BrazeLogger)localObject2, localWebContentUtils, BrazeLogger.Priority.PREPARED, null, e.PLAYING, 2, null);
        BrazeFileUtils.deleteFileOrDirectory(new File(paramFile));
        return null;
      }
      BrazeLogger.brazelog$default((BrazeLogger)localObject2, localWebContentUtils, null, null, new f(paramFile), 3, null);
      return paramFile;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, localException, new c(paramString));
      BrazeFileUtils.deleteFileOrDirectory(new File(paramFile));
    }
    return null;
  }
  
  public static final String replacePrefetchedUrlsWithLocalAssets(String paramString, Map paramMap)
  {
    i.e(paramString, "originalString");
    i.e(paramMap, "remoteToLocalAssetMap");
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      final s localS = new s();
      b = localEntry.getValue();
      if (!new File((String)b).exists())
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, new g(localS), 2, null);
      }
      else
      {
        paramMap = (String)b;
        WebContentUtils localWebContentUtils = INSTANCE;
        if (g.v(paramMap, "file://", false, 2, null))
        {
          paramMap = (String)b;
        }
        else
        {
          paramMap = new StringBuilder();
          paramMap.append("file://");
          paramMap.append((String)b);
          paramMap = paramMap.toString();
        }
        b = paramMap;
        paramMap = (String)localEntry.getKey();
        if (g.y(paramString, paramMap, false, 2, null))
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, localWebContentUtils, null, null, new h(paramMap, localS), 3, null);
          paramString = g.r(paramString, paramMap, (String)b, false, 4, null);
        }
      }
    }
    return paramString;
  }
  
  public static final boolean unpackZipIntoDirectory(final String paramString, File paramFile)
  {
    i.e(paramString, "unpackDirectory");
    i.e(paramFile, "zipFile");
    if (g.o(paramString))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.g, null, i.q, 2, null);
      return false;
    }
    new File(paramString).mkdirs();
    try
    {
      s localS = new s();
      ZipInputStream localZipInputStream = new ZipInputStream(new FileInputStream(paramFile));
      try
      {
        for (Object localObject1 = localZipInputStream.getNextEntry(); localObject1 != null; localObject2 = localZipInputStream.getNextEntry())
        {
          Object localObject3 = ((ZipEntry)localObject1).getName();
          i.d(localObject3, "zipEntry.name");
          b = localObject3;
          Object localObject4 = Locale.US;
          i.d(localObject4, "US");
          localObject3 = ((String)localObject3).toLowerCase((Locale)localObject4);
          i.d(localObject3, "this as java.lang.String).toLowerCase(locale)");
          boolean bool = g.v((String)localObject3, "__macosx", false, 2, null);
          if (!bool) {
            try
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(paramString);
              ((StringBuilder)localObject3).append('/');
              localObject4 = (String)b;
              ((StringBuilder)localObject3).append((String)localObject4);
              localObject3 = validateChildFileExistsUnderParent(paramString, ((StringBuilder)localObject3).toString());
              bool = ((ZipEntry)localObject1).isDirectory();
              if (bool)
              {
                new File((String)localObject3).mkdirs();
              }
              else
              {
                try
                {
                  localObject1 = new File((String)localObject3).getParentFile();
                  if (localObject1 != null) {
                    ((File)localObject1).mkdirs();
                  }
                }
                catch (Exception localException1)
                {
                  localObject4 = BrazeLogger.INSTANCE;
                  WebContentUtils localWebContentUtils = INSTANCE;
                  BrazeLogger.Priority localPriority = BrazeLogger.Priority.this$0;
                  ((BrazeLogger)localObject4).brazelog(localWebContentUtils, localPriority, localException1, new j(localS));
                }
                BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((String)localObject3));
                try
                {
                  b.b(localZipInputStream, localBufferedOutputStream, 0, 2, null);
                  c.a(localBufferedOutputStream, null);
                }
                catch (Throwable localThrowable4)
                {
                  try
                  {
                    throw localThrowable4;
                  }
                  catch (Throwable localThrowable5)
                  {
                    c.a(localBufferedOutputStream, localThrowable4);
                    throw localThrowable5;
                  }
                }
              }
              localZipInputStream.closeEntry();
            }
            catch (Exception localException2)
            {
              BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, localException2, new k(localS));
            }
          }
        }
        Object localObject2 = t.a;
        c.a(localZipInputStream, null);
        return true;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          throw localThrowable1;
        }
        catch (Throwable localThrowable3)
        {
          c.a(localZipInputStream, localThrowable1);
          throw localThrowable3;
        }
      }
      return false;
    }
    catch (Throwable localThrowable2)
    {
      BrazeLogger.INSTANCE.brazelog(INSTANCE, BrazeLogger.Priority.this$0, localThrowable2, new l(paramFile, paramString));
    }
  }
  
  public static final String validateChildFileExistsUnderParent(String paramString1, String paramString2)
  {
    i.e(paramString1, "intendedParentDirectory");
    i.e(paramString2, "childFilePath");
    String str1 = new File(paramString1).getCanonicalPath();
    String str2 = new File(paramString2).getCanonicalPath();
    i.d(str2, "childFileCanonicalPath");
    i.d(str1, "parentCanonicalPath");
    if (g.v(str2, str1, false, 2, null)) {
      return str2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid file with original path: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" with canonical path: ");
    localStringBuilder.append(str2);
    localStringBuilder.append(" does not exist under intended parent with  path: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" and canonical path: ");
    localStringBuilder.append(str1);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  static final class a
    extends j
    implements a<String>
  {
    public static final a PLAYING = new a();
    
    a()
    {
      super();
    }
    
    public final String getText()
    {
      return "Remote zip url is empty. No local URL will be created.";
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    b(String paramString1, String paramString2)
    {
      super();
    }
    
    public final String doGet()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Starting download of url: ");
      localStringBuilder.append(mToken);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramFile);
      return localStringBuilder.toString();
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    c(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not download zip file to local storage. ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    d(String paramString1, String paramString2)
    {
      super();
    }
    
    public final String doGet()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Html content zip downloaded. ");
      localStringBuilder.append(mToken);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramFile);
      return localStringBuilder.toString();
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    public static final e PLAYING = new e();
    
    e()
    {
      super();
    }
    
    public final String getText()
    {
      return "Error during the zip unpack.";
    }
  }
  
  static final class f
    extends j
    implements a<String>
  {
    f(String paramString)
    {
      super();
    }
    
    public final String loadFile()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Html content zip unpacked to to ");
      localStringBuilder.append(configFile);
      localStringBuilder.append('.');
      return localStringBuilder.toString();
    }
  }
  
  static final class g
    extends j
    implements a<String>
  {
    g(s paramS)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot find local asset file at path: ");
      localStringBuilder.append((String)second.b);
      return localStringBuilder.toString();
    }
  }
  
  static final class h
    extends j
    implements a<String>
  {
    h(String paramString, s paramS)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Replacing remote url \"");
      localStringBuilder.append(p);
      localStringBuilder.append("\" with local uri \"");
      localStringBuilder.append((String)localSb);
      localStringBuilder.append('"');
      return localStringBuilder.toString();
    }
  }
  
  static final class i
    extends j
    implements a<String>
  {
    public static final i q = new i();
    
    i()
    {
      super();
    }
    
    public final String getText()
    {
      return "Unpack directory is blank. Zip file not unpacked.";
    }
  }
  
  static final class j
    extends j
    implements a<String>
  {
    j(s paramS)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error creating parent directory ");
      localStringBuilder.append((String)second.b);
      return localStringBuilder.toString();
    }
  }
  
  static final class k
    extends j
    implements a<String>
  {
    k(s paramS)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error unpacking zipEntry ");
      localStringBuilder.append((String)second.b);
      return localStringBuilder.toString();
    }
  }
  
  static final class l
    extends j
    implements a<String>
  {
    l(File paramFile, String paramString)
    {
      super();
    }
    
    public final String extract()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error during unpack of zip file ");
      localStringBuilder.append(source.getAbsolutePath());
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramString);
      localStringBuilder.append('.');
      return localStringBuilder.toString();
    }
  }
}
