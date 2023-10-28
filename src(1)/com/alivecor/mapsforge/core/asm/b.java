package com.alivecor.mapsforge.core.asm;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.Arrays;

public final class b
{
  public static final int CHANGE_CURRENT_BY_ONE_SCROLL_DURATION = 300;
  public static final int META_SAVEDC = 30;
  public static final int PREF_SIZE = 300;
  private static final String TAG = "b";
  public static final float a = 2.54F;
  private static final boolean d = false;
  public static final float e = 0.453592F;
  private static File f;
  private static File g;
  private static File j;
  
  public b() {}
  
  /* Error */
  public static File a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 39	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 45	android/content/Context:getCacheDir	()Ljava/io/File;
    //   8: aload_1
    //   9: invokespecial 48	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 52	java/io/File:exists	()Z
    //   17: ifne +156 -> 173
    //   20: aload_3
    //   21: invokevirtual 55	java/io/File:getParentFile	()Ljava/io/File;
    //   24: invokevirtual 58	java/io/File:mkdirs	()Z
    //   27: pop
    //   28: aload_0
    //   29: invokevirtual 62	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   32: aload_1
    //   33: invokevirtual 68	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore_0
    //   37: new 70	java/io/FileOutputStream
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 73	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore 4
    //   47: ldc 74
    //   49: newarray byte
    //   51: astore 5
    //   53: aload_0
    //   54: aload 5
    //   56: invokevirtual 80	java/io/InputStream:read	([B)I
    //   59: istore_2
    //   60: iload_2
    //   61: ifle +15 -> 76
    //   64: aload 4
    //   66: aload 5
    //   68: iconst_0
    //   69: iload_2
    //   70: invokevirtual 84	java/io/FileOutputStream:write	([BII)V
    //   73: goto -20 -> 53
    //   76: aload 4
    //   78: invokevirtual 87	java/io/FileOutputStream:close	()V
    //   81: aload_0
    //   82: invokevirtual 88	java/io/InputStream:close	()V
    //   85: aload_3
    //   86: areturn
    //   87: astore 5
    //   89: aload 4
    //   91: invokevirtual 87	java/io/FileOutputStream:close	()V
    //   94: aload 5
    //   96: athrow
    //   97: astore 4
    //   99: aload_0
    //   100: invokevirtual 88	java/io/InputStream:close	()V
    //   103: aload 4
    //   105: athrow
    //   106: astore_0
    //   107: new 90	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   114: astore 4
    //   116: aload 4
    //   118: ldc 93
    //   120: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 4
    //   126: aload_1
    //   127: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: ldc 99
    //   133: aload 4
    //   135: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 109	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   141: pop
    //   142: new 90	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   149: astore_1
    //   150: aload_1
    //   151: ldc 111
    //   153: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: aload_0
    //   159: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: ldc 99
    //   165: aload_1
    //   166: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 109	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   172: pop
    //   173: aload_3
    //   174: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramContext	Context
    //   0	175	1	paramString	String
    //   59	11	2	i	int
    //   12	162	3	localFile	File
    //   45	45	4	localFileOutputStream	java.io.FileOutputStream
    //   97	7	4	localThrowable1	Throwable
    //   114	20	4	localStringBuilder	StringBuilder
    //   51	16	5	arrayOfByte	byte[]
    //   87	8	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   47	53	87	java/lang/Throwable
    //   53	60	87	java/lang/Throwable
    //   64	73	87	java/lang/Throwable
    //   37	47	97	java/lang/Throwable
    //   76	81	97	java/lang/Throwable
    //   89	97	97	java/lang/Throwable
    //   28	37	106	java/io/IOException
    //   81	85	106	java/io/IOException
    //   99	106	106	java/io/IOException
  }
  
  public static File a(File paramFile, String paramString)
  {
    return new File(paramFile, getId(paramString));
  }
  
  public static File a(String paramString)
  {
    File localFile = write();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ecg-");
    localStringBuilder.append(paramString);
    localStringBuilder.append("-enhanced.atc");
    return new File(localFile, localStringBuilder.toString());
  }
  
  public static void a()
  {
    try
    {
      Object localObject1 = getCacheDir();
      boolean bool = ((File)localObject1).isDirectory();
      if (bool)
      {
        long l = System.currentTimeMillis();
        localObject1 = ((File)localObject1).listFiles(new ClassReader(l - 172800000L));
        int i = 0;
        while (i < localObject1.length)
        {
          Object localObject2 = localObject1[i];
          localObject2.delete();
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void a(Context paramContext)
  {
    g = paramContext.getFilesDir();
    f = paramContext.getExternalCacheDir();
    j = paramContext.getCacheDir();
  }
  
  public static double[] a(double[] paramArrayOfDouble, int paramInt)
  {
    double d1 = 1000000.0D / paramInt;
    paramInt = 0;
    while (paramInt < paramArrayOfDouble.length)
    {
      paramArrayOfDouble[paramInt] /= d1;
      paramInt += 1;
    }
    return paramArrayOfDouble;
  }
  
  public static double[] a(short[] paramArrayOfShort)
  {
    int k = paramArrayOfShort.length;
    double[] arrayOfDouble = new double[k];
    int i = 0;
    while (i < k)
    {
      arrayOfDouble[i] = paramArrayOfShort[i];
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public static double[] add(double[] paramArrayOfDouble, int paramInt)
  {
    double d1 = 1000000.0D / paramInt;
    paramInt = 0;
    while (paramInt < paramArrayOfDouble.length)
    {
      paramArrayOfDouble[paramInt] *= d1;
      paramInt += 1;
    }
    return paramArrayOfDouble;
  }
  
  public static short[] add(double[] paramArrayOfDouble)
  {
    int k = paramArrayOfDouble.length;
    short[] arrayOfShort = new short[k];
    int i = 0;
    while (i < k)
    {
      double d2 = paramArrayOfDouble[i];
      double d1;
      if (d2 > 32767.0D)
      {
        d1 = 32767.0D;
      }
      else
      {
        d1 = d2;
        if (d2 < -32768.0D) {
          d1 = -32768.0D;
        }
      }
      arrayOfShort[i] = ((short)(int)d1);
      i += 1;
    }
    return arrayOfShort;
  }
  
  public static File copyFile(String paramString)
  {
    return new File(write(), toString(paramString));
  }
  
  public static File d()
  {
    return f;
  }
  
  public static File d(File paramFile, String paramString)
  {
    return new File(paramFile, toString(paramString));
  }
  
  public static void doInBackground()
  {
    try
    {
      Object localObject1 = e();
      long l1 = System.currentTimeMillis();
      boolean bool = ((File)localObject1).isDirectory();
      if (bool)
      {
        localObject1 = ((File)localObject1).listFiles(new FileChooser(l1 - 172800000L));
        l1 = 0L;
        int k = 0;
        int i = 0;
        Object localObject2;
        long l2;
        while (i < localObject1.length)
        {
          localObject2 = localObject1[i];
          l2 = localObject2.length();
          l1 += l2;
          i += 1;
        }
        if (l1 > 2000000L)
        {
          Arrays.sort((Object[])localObject1, new AbstractListArretByPosition.3.1());
          i = k;
          while (i < localObject1.length)
          {
            localObject2 = localObject1[i];
            l2 = localObject2.length();
            l1 -= l2;
            localObject2 = localObject1[i];
            localObject2.delete();
            if (l1 < 1000000L) {
              return;
            }
            i += 1;
          }
        }
      }
      else {}
    }
    catch (Exception localException) {}
  }
  
  public static File e()
  {
    return j;
  }
  
  public static File getCacheDir()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(g);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    return new File(localStringBuilder.toString());
  }
  
  public static String getId(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ecg-");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".atc");
    return localStringBuilder.toString();
  }
  
  public static File run(String paramString)
  {
    return new File(write(), getId(paramString));
  }
  
  public static String toString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ecg-enhanced-");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".atc");
    return localStringBuilder.toString();
  }
  
  public static File write()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(g);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("ecgs");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ecgBasePath.mkdirs(): could not create directory at ");
      localStringBuilder.append(((File)localObject).getPath());
      Log.e(str, localStringBuilder.toString());
    }
    return localObject;
  }
}
