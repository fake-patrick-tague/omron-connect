package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
@KeepForSdk
public class LibraryVersion
{
  private static LibraryVersion DEFAULT_INSTANCE = new LibraryVersion();
  private static final GmsLogger logger = new GmsLogger("LibraryVersion", "");
  private ConcurrentHashMap this$0 = new ConcurrentHashMap();
  
  protected LibraryVersion() {}
  
  public static LibraryVersion getInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public String getVersion(String paramString)
  {
    Preconditions.checkNotEmpty(paramString, "Please provide a valid libraryName");
    if (this$0.containsKey(paramString)) {
      return (String)this$0.get(paramString);
    }
    Object localObject4 = new Properties();
    GmsLogger localGmsLogger = null;
    Object localObject1 = null;
    Object localObject2 = null;
    String str = null;
    Object localObject3;
    try
    {
      localObject3 = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", new Object[] { paramString }));
      if (localObject3 != null) {
        localObject1 = localGmsLogger;
      }
      try
      {
        ((Properties)localObject4).load((InputStream)localObject3);
        localObject1 = localGmsLogger;
        str = ((Properties)localObject4).getProperty("version", null);
        localObject2 = str;
        localGmsLogger = logger;
        localObject1 = localObject2;
        localObject4 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject4).append(paramString);
        localObject1 = localObject2;
        ((StringBuilder)localObject4).append(" version is ");
        localObject1 = localObject2;
        ((StringBuilder)localObject4).append(str);
        localObject1 = localObject2;
        localGmsLogger.append("LibraryVersion", ((StringBuilder)localObject4).toString());
        break label216;
        localObject2 = logger;
        localObject1 = localGmsLogger;
        localObject4 = new StringBuilder();
        localObject1 = localGmsLogger;
        ((StringBuilder)localObject4).append("Failed to get app version for libraryName: ");
        localObject1 = localGmsLogger;
        ((StringBuilder)localObject4).append(paramString);
        localObject1 = localGmsLogger;
        ((GmsLogger)localObject2).w("LibraryVersion", ((StringBuilder)localObject4).toString());
        localObject2 = str;
        label216:
        localObject1 = localObject2;
        if (localObject3 == null) {
          break label327;
        }
        IOUtils.closeQuietly((Closeable)localObject3);
        localObject1 = localObject2;
      }
      catch (Throwable paramString)
      {
        localObject1 = localObject3;
        break label361;
      }
      catch (IOException localIOException1)
      {
        localObject2 = localObject3;
        localObject3 = localObject1;
      }
      localObject1 = localObject2;
    }
    catch (Throwable paramString) {}catch (IOException localIOException2)
    {
      localObject3 = null;
    }
    localGmsLogger = logger;
    localObject1 = localObject2;
    localObject4 = new StringBuilder();
    localObject1 = localObject2;
    ((StringBuilder)localObject4).append("Failed to get app version for libraryName: ");
    localObject1 = localObject2;
    ((StringBuilder)localObject4).append(paramString);
    localObject1 = localObject2;
    localGmsLogger.e("LibraryVersion", ((StringBuilder)localObject4).toString(), localIOException2);
    if (localObject2 != null) {
      IOUtils.closeQuietly((Closeable)localObject2);
    }
    localObject1 = localObject3;
    label327:
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      logger.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
      localObject2 = "UNKNOWN";
    }
    this$0.put(paramString, localObject2);
    return (String)localObject2;
    label361:
    if (localObject1 != null) {
      IOUtils.closeQuietly((Closeable)localObject1);
    }
    throw paramString;
  }
}
