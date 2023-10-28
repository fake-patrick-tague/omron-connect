package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import v7.v7.asm.Label;

public class a
{
  public static File a(Context paramContext)
  {
    paramContext = paramContext.getCacheDir();
    if (paramContext == null) {
      return null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(".font");
    ((StringBuilder)localObject1).append(Process.myPid());
    ((StringBuilder)localObject1).append("-");
    ((StringBuilder)localObject1).append(Process.myTid());
    ((StringBuilder)localObject1).append("-");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 0;
    while (i < 100)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(i);
      localObject2 = new File(paramContext, ((StringBuilder)localObject2).toString());
      try
      {
        boolean bool = ((File)localObject2).createNewFile();
        if (bool) {
          return localObject2;
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return null;
  }
  
  public static ByteBuffer a(Context paramContext, Resources paramResources, int paramInt)
  {
    paramContext = a(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = a(paramContext, paramResources, paramInt);
      if (!bool)
      {
        paramContext.delete();
        return null;
      }
      paramResources = read(paramContext);
      paramContext.delete();
      return paramResources;
    }
    catch (Throwable paramResources)
    {
      paramContext.delete();
      throw paramResources;
    }
  }
  
  public static Map a(Context paramContext, Label[] paramArrayOfLabel, CancellationSignal paramCancellationSignal)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfLabel.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfLabel[i];
      if (((Label)localObject).c() == 0)
      {
        localObject = ((Label)localObject).getName();
        if (!localHashMap.containsKey(localObject)) {
          localHashMap.put(localObject, read(paramContext, paramCancellationSignal, (Uri)localObject));
        }
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static boolean a(File paramFile, Resources paramResources, int paramInt)
  {
    try
    {
      InputStream localInputStream = paramResources.openRawResource(paramInt);
      paramResources = localInputStream;
      try
      {
        boolean bool = a(paramFile, localInputStream);
        close(localInputStream);
        return bool;
      }
      catch (Throwable paramFile) {}
      close(paramResources);
    }
    catch (Throwable paramFile)
    {
      paramResources = null;
    }
    throw paramFile;
  }
  
  public static boolean a(File paramFile, InputStream paramInputStream)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskWrites();
    StringBuilder localStringBuilder = null;
    Object localObject = null;
    try
    {
      paramFile = new FileOutputStream(paramFile, false);
      localObject = new byte['?'];
      try
      {
        for (;;)
        {
          int i = paramInputStream.read((byte[])localObject);
          if (i == -1) {
            break;
          }
          paramFile.write((byte[])localObject, 0, i);
        }
        close(paramFile);
        StrictMode.setThreadPolicy(localThreadPolicy);
        return true;
      }
      catch (Throwable paramInputStream)
      {
        localObject = paramFile;
        paramFile = paramInputStream;
        break label135;
      }
      catch (IOException paramInputStream) {}
      localObject = paramFile;
    }
    catch (Throwable paramFile) {}catch (IOException paramInputStream)
    {
      paramFile = localStringBuilder;
    }
    localStringBuilder = new StringBuilder();
    localObject = paramFile;
    localStringBuilder.append("Error copying resource contents to temp file: ");
    localObject = paramFile;
    localStringBuilder.append(paramInputStream.getMessage());
    localObject = paramFile;
    Log.e("TypefaceCompatUtil", localStringBuilder.toString());
    close(paramFile);
    StrictMode.setThreadPolicy(localThreadPolicy);
    return false;
    label135:
    close((Closeable)localObject);
    StrictMode.setThreadPolicy(localThreadPolicy);
    throw paramFile;
  }
  
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable) {}
    }
  }
  
  /* Error */
  public static ByteBuffer read(Context paramContext, CancellationSignal paramCancellationSignal, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 159	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_2
    //   7: ldc -95
    //   9: aload_1
    //   10: invokestatic 165	androidx/core/graphics/IOUtils:openFile	(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +13 -> 28
    //   18: aload_0
    //   19: ifnull +90 -> 109
    //   22: aload_0
    //   23: invokevirtual 168	android/os/ParcelFileDescriptor:close	()V
    //   26: aconst_null
    //   27: areturn
    //   28: new 170	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 174	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   36: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 181	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 187	java/nio/channels/FileChannel:size	()J
    //   49: lstore_3
    //   50: aload_2
    //   51: getstatic 193	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   54: lconst_0
    //   55: lload_3
    //   56: invokevirtual 197	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   59: astore_2
    //   60: aload_1
    //   61: invokevirtual 198	java/io/FileInputStream:close	()V
    //   64: aload_0
    //   65: invokevirtual 168	android/os/ParcelFileDescriptor:close	()V
    //   68: aload_2
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 198	java/io/FileInputStream:close	()V
    //   75: goto +9 -> 84
    //   78: astore_1
    //   79: aload_2
    //   80: aload_1
    //   81: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   84: aload_2
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: invokevirtual 168	android/os/ParcelFileDescriptor:close	()V
    //   91: goto +9 -> 100
    //   94: astore_0
    //   95: aload_1
    //   96: aload_0
    //   97: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   100: aload_1
    //   101: athrow
    //   102: astore_0
    //   103: aconst_null
    //   104: areturn
    //   105: astore_0
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: aconst_null
    //   110: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramContext	Context
    //   0	111	1	paramCancellationSignal	CancellationSignal
    //   0	111	2	paramUri	Uri
    //   49	7	3	l	long
    // Exception table:
    //   from	to	target	type
    //   40	60	70	java/lang/Throwable
    //   71	75	78	java/lang/Throwable
    //   28	40	86	java/lang/Throwable
    //   60	64	86	java/lang/Throwable
    //   79	84	86	java/lang/Throwable
    //   84	86	86	java/lang/Throwable
    //   87	91	94	java/lang/Throwable
    //   5	14	102	java/io/IOException
    //   22	26	102	java/io/IOException
    //   64	68	105	java/io/IOException
    //   95	100	108	java/io/IOException
    //   100	102	108	java/io/IOException
  }
  
  private static ByteBuffer read(File paramFile)
  {
    try
    {
      paramFile = new FileInputStream(paramFile);
      try
      {
        Object localObject = paramFile.getChannel();
        long l = ((FileChannel)localObject).size();
        localObject = ((FileChannel)localObject).map(FileChannel.MapMode.READ_ONLY, 0L, l);
        try
        {
          localThrowable.addSuppressed(paramFile);
          throw localThrowable;
        }
        catch (IOException paramFile)
        {
          for (;;) {}
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          paramFile.close();
          return localObject;
        }
        catch (IOException paramFile)
        {
          for (;;) {}
        }
        localThrowable = localThrowable;
        try
        {
          paramFile.close();
        }
        catch (Throwable paramFile) {}
      }
    }
    catch (IOException paramFile)
    {
      for (;;) {}
    }
    return null;
  }
}
