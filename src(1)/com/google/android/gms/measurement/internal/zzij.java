package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

public final class zzij
{
  public static String get(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    Preconditions.checkNotNull(paramArrayOfString1);
    Preconditions.checkNotNull(paramArrayOfString2);
    int j = Math.min(paramArrayOfString1.length, paramArrayOfString2.length);
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString1[i];
      if (((paramString == null) && (str == null)) || ((paramString != null) && (paramString.equals(str)))) {
        return paramArrayOfString2[i];
      }
      i += 1;
    }
    return null;
  }
  
  /* Error */
  public static Object put(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +100 -> 101
    //   4: new 34	java/io/ByteArrayOutputStream
    //   7: dup
    //   8: invokespecial 38	java/io/ByteArrayOutputStream:<init>	()V
    //   11: astore_1
    //   12: new 40	java/io/ObjectOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 43	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_2
    //   21: aload_2
    //   22: aload_0
    //   23: invokevirtual 47	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   26: aload_2
    //   27: invokevirtual 50	java/io/ObjectOutputStream:flush	()V
    //   30: new 52	java/io/ObjectInputStream
    //   33: dup
    //   34: new 54	java/io/ByteArrayInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokevirtual 58	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: invokespecial 61	java/io/ByteArrayInputStream:<init>	([B)V
    //   45: invokespecial 64	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 68	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   53: astore_1
    //   54: aload_2
    //   55: invokevirtual 71	java/io/ObjectOutputStream:close	()V
    //   58: aload_0
    //   59: invokevirtual 72	java/io/ObjectInputStream:close	()V
    //   62: aload_1
    //   63: areturn
    //   64: astore_1
    //   65: goto +14 -> 79
    //   68: astore_1
    //   69: aconst_null
    //   70: astore_0
    //   71: goto +8 -> 79
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_2
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_2
    //   84: invokevirtual 71	java/io/ObjectOutputStream:close	()V
    //   87: aload_0
    //   88: ifnull +7 -> 95
    //   91: aload_0
    //   92: invokevirtual 72	java/io/ObjectInputStream:close	()V
    //   95: aload_1
    //   96: athrow
    //   97: astore_0
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: aconst_null
    //   102: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramObject	Object
    //   11	52	1	localObject	Object
    //   64	1	1	localThrowable1	Throwable
    //   68	1	1	localThrowable2	Throwable
    //   74	22	1	localThrowable3	Throwable
    //   20	64	2	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   49	54	64	java/lang/Throwable
    //   21	49	68	java/lang/Throwable
    //   4	21	74	java/lang/Throwable
    //   54	62	97	java/io/IOException
    //   83	87	97	java/io/IOException
    //   91	95	97	java/io/IOException
    //   95	97	97	java/io/IOException
    //   54	62	100	java/lang/ClassNotFoundException
    //   83	87	100	java/lang/ClassNotFoundException
    //   91	95	100	java/lang/ClassNotFoundException
    //   95	97	100	java/lang/ClassNotFoundException
  }
  
  public static String put(Context paramContext, String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramContext);
    paramString1 = paramContext.getResources();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = zzfq.build(paramContext);
    }
    return zzfq.get("google_app_id", paramString1, paramString2);
  }
}
