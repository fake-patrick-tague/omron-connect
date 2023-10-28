package com.google.android.gms.internal.oss_licenses;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Collections;

public final class Utils
{
  public static ArrayList doInBackground(Context paramContext)
  {
    String[] arrayOfString1 = init(paramContext.getApplicationContext(), "third_party_license_metadata", 0L, -1).split("\n");
    ArrayList localArrayList = new ArrayList(arrayOfString1.length);
    int k = arrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString1[i];
      int m = str.indexOf(' ');
      String[] arrayOfString2 = str.substring(0, m).split(":");
      int j;
      if ((arrayOfString2.length == 2) && (m > 0)) {
        j = 1;
      } else {
        j = 0;
      }
      if (str.length() != 0) {
        paramContext = "Invalid license meta-data line:\n".concat(str);
      } else {
        paramContext = new String("Invalid license meta-data line:\n");
      }
      if (j != 0)
      {
        long l = Long.parseLong(arrayOfString2[0]);
        j = Integer.parseInt(arrayOfString2[1]);
        localArrayList.add(Server.join(str.substring(m + 1), l, j, ""));
        i += 1;
      }
      else
      {
        throw new IllegalStateException(String.valueOf(paramContext));
      }
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  public static String init(Context paramContext, Server paramServer)
  {
    long l = paramServer.getPassword();
    int i = paramServer.getType();
    paramServer = paramServer.getPath();
    if (paramServer.isEmpty()) {
      return init(paramContext, "third_party_licenses", l, i);
    }
    paramContext = load("res/raw/third_party_licenses", paramServer, l, i);
    if (paramContext != null) {
      return paramContext;
    }
    paramContext = new StringBuilder(paramServer.length() + 46);
    paramContext.append(paramServer);
    paramContext.append(" does not contain res/raw/third_party_licenses");
    throw new RuntimeException(paramContext.toString());
  }
  
  private static String init(Context paramContext, String paramString, long paramLong, int paramInt)
  {
    paramContext = paramContext.getApplicationContext().getResources();
    return parse(paramContext.openRawResource(paramContext.getIdentifier(paramString, "raw", paramContext.getResourcePackageName(R.id.dummy_placeholder))), paramLong, paramInt);
  }
  
  /* Error */
  private static String load(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 170	java/util/jar/JarFile
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 171	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 175	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnonnull +9 -> 31
    //   25: aload_1
    //   26: invokevirtual 179	java/util/jar/JarFile:close	()V
    //   29: aconst_null
    //   30: areturn
    //   31: aload_1
    //   32: aload_0
    //   33: invokevirtual 183	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   36: lload_2
    //   37: iload 4
    //   39: invokestatic 164	com/google/android/gms/internal/oss_licenses/Utils:parse	(Ljava/io/InputStream;JI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_1
    //   44: invokevirtual 179	java/util/jar/JarFile:close	()V
    //   47: aload_0
    //   48: areturn
    //   49: astore_0
    //   50: aload_1
    //   51: astore 5
    //   53: goto +30 -> 83
    //   56: astore_0
    //   57: aload_1
    //   58: astore 5
    //   60: goto +12 -> 72
    //   63: astore_0
    //   64: goto +19 -> 83
    //   67: astore_0
    //   68: aload 6
    //   70: astore 5
    //   72: new 131	java/lang/RuntimeException
    //   75: dup
    //   76: ldc -71
    //   78: aload_0
    //   79: invokespecial 188	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   82: athrow
    //   83: aload 5
    //   85: ifnull +8 -> 93
    //   88: aload 5
    //   90: invokevirtual 179	java/util/jar/JarFile:close	()V
    //   93: aload_0
    //   94: athrow
    //   95: astore_0
    //   96: aconst_null
    //   97: areturn
    //   98: astore_1
    //   99: aload_0
    //   100: areturn
    //   101: astore_1
    //   102: goto -9 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramString1	String
    //   0	105	1	paramString2	String
    //   0	105	2	paramLong	long
    //   0	105	4	paramInt	int
    //   4	85	5	localObject1	Object
    //   1	68	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	21	49	java/lang/Throwable
    //   31	43	49	java/lang/Throwable
    //   15	21	56	java/io/IOException
    //   31	43	56	java/io/IOException
    //   6	15	63	java/lang/Throwable
    //   72	83	63	java/lang/Throwable
    //   6	15	67	java/io/IOException
    //   25	29	95	java/io/IOException
    //   43	47	98	java/io/IOException
    //   88	93	101	java/io/IOException
  }
  
  /* Error */
  private static String parse(java.io.InputStream paramInputStream, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray byte
    //   5: astore 5
    //   7: new 192	java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial 194	java/io/ByteArrayOutputStream:<init>	()V
    //   14: astore 6
    //   16: aload_0
    //   17: lload_1
    //   18: invokevirtual 200	java/io/InputStream:skip	(J)J
    //   21: pop2
    //   22: iload_3
    //   23: ifle +6 -> 29
    //   26: goto +6 -> 32
    //   29: ldc -55
    //   31: istore_3
    //   32: iload_3
    //   33: ifle +43 -> 76
    //   36: aload_0
    //   37: aload 5
    //   39: iconst_0
    //   40: iload_3
    //   41: sipush 1024
    //   44: invokestatic 207	java/lang/Math:min	(II)I
    //   47: invokevirtual 211	java/io/InputStream:read	([BII)I
    //   50: istore 4
    //   52: iload 4
    //   54: iconst_m1
    //   55: if_icmpeq +21 -> 76
    //   58: aload 6
    //   60: aload 5
    //   62: iconst_0
    //   63: iload 4
    //   65: invokevirtual 215	java/io/ByteArrayOutputStream:write	([BII)V
    //   68: iload_3
    //   69: iload 4
    //   71: isub
    //   72: istore_3
    //   73: goto -41 -> 32
    //   76: aload_0
    //   77: invokevirtual 216	java/io/InputStream:close	()V
    //   80: aload 6
    //   82: ldc -38
    //   84: invokevirtual 220	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload_0
    //   89: areturn
    //   90: astore_0
    //   91: new 131	java/lang/RuntimeException
    //   94: dup
    //   95: ldc -34
    //   97: aload_0
    //   98: invokespecial 188	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: athrow
    //   102: astore_0
    //   103: new 131	java/lang/RuntimeException
    //   106: dup
    //   107: ldc -32
    //   109: aload_0
    //   110: invokespecial 188	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramInputStream	java.io.InputStream
    //   0	114	1	paramLong	long
    //   0	114	3	paramInt	int
    //   50	22	4	i	int
    //   5	56	5	arrayOfByte	byte[]
    //   14	67	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   80	88	90	java/io/UnsupportedEncodingException
    //   16	22	102	java/io/IOException
    //   36	52	102	java/io/IOException
    //   58	68	102	java/io/IOException
    //   76	80	102	java/io/IOException
  }
}
