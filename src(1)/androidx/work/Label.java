package androidx.work;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Label
{
  private static final String a = Log.getInstance("Data");
  public static final Label c = new Item().a();
  Map<String, Object> values;
  
  Label() {}
  
  public Label(Label paramLabel)
  {
    values = new HashMap(values);
  }
  
  public Label(Map paramMap)
  {
    values = new HashMap(paramMap);
  }
  
  /* Error */
  public static Label read(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: sipush 10240
    //   5: if_icmpgt +224 -> 229
    //   8: new 38	java/util/HashMap
    //   11: dup
    //   12: invokespecial 52	java/util/HashMap:<init>	()V
    //   15: astore 5
    //   17: new 54	java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 57	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: astore 4
    //   27: new 59	java/io/ObjectInputStream
    //   30: dup
    //   31: aload 4
    //   33: invokespecial 62	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_2
    //   37: aload_2
    //   38: astore_0
    //   39: aload_2
    //   40: invokevirtual 66	java/io/ObjectInputStream:readInt	()I
    //   43: istore_1
    //   44: iload_1
    //   45: ifle +28 -> 73
    //   48: aload_2
    //   49: astore_0
    //   50: aload 5
    //   52: aload_2
    //   53: invokevirtual 70	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   56: aload_2
    //   57: invokevirtual 74	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   60: invokeinterface 80 3 0
    //   65: pop
    //   66: iload_1
    //   67: iconst_1
    //   68: isub
    //   69: istore_1
    //   70: goto -26 -> 44
    //   73: aload_2
    //   74: invokevirtual 83	java/io/ObjectInputStream:close	()V
    //   77: goto +14 -> 91
    //   80: astore_0
    //   81: getstatic 25	androidx/work/Label:a	Ljava/lang/String;
    //   84: ldc 85
    //   86: aload_0
    //   87: invokestatic 91	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   90: pop
    //   91: aload 4
    //   93: invokevirtual 92	java/io/ByteArrayInputStream:close	()V
    //   96: goto +79 -> 175
    //   99: astore_3
    //   100: goto +22 -> 122
    //   103: astore_3
    //   104: goto +18 -> 122
    //   107: astore_2
    //   108: aconst_null
    //   109: astore_0
    //   110: goto +76 -> 186
    //   113: astore_0
    //   114: goto +4 -> 118
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_0
    //   121: astore_3
    //   122: aload_2
    //   123: astore_0
    //   124: getstatic 25	androidx/work/Label:a	Ljava/lang/String;
    //   127: ldc 85
    //   129: aload_3
    //   130: invokestatic 91	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   133: pop
    //   134: aload_2
    //   135: ifnull +21 -> 156
    //   138: aload_2
    //   139: invokevirtual 83	java/io/ObjectInputStream:close	()V
    //   142: goto +14 -> 156
    //   145: astore_0
    //   146: getstatic 25	androidx/work/Label:a	Ljava/lang/String;
    //   149: ldc 85
    //   151: aload_0
    //   152: invokestatic 91	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   155: pop
    //   156: aload 4
    //   158: invokevirtual 92	java/io/ByteArrayInputStream:close	()V
    //   161: goto +14 -> 175
    //   164: astore_0
    //   165: getstatic 25	androidx/work/Label:a	Ljava/lang/String;
    //   168: ldc 85
    //   170: aload_0
    //   171: invokestatic 91	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   174: pop
    //   175: new 2	androidx/work/Label
    //   178: dup
    //   179: aload 5
    //   181: invokespecial 93	androidx/work/Label:<init>	(Ljava/util/Map;)V
    //   184: areturn
    //   185: astore_2
    //   186: aload_0
    //   187: ifnull +21 -> 208
    //   190: aload_0
    //   191: invokevirtual 83	java/io/ObjectInputStream:close	()V
    //   194: goto +14 -> 208
    //   197: astore_0
    //   198: getstatic 25	androidx/work/Label:a	Ljava/lang/String;
    //   201: ldc 85
    //   203: aload_0
    //   204: invokestatic 91	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   207: pop
    //   208: aload 4
    //   210: invokevirtual 92	java/io/ByteArrayInputStream:close	()V
    //   213: goto +14 -> 227
    //   216: astore_0
    //   217: getstatic 25	androidx/work/Label:a	Ljava/lang/String;
    //   220: ldc 85
    //   222: aload_0
    //   223: invokestatic 91	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   226: pop
    //   227: aload_2
    //   228: athrow
    //   229: new 95	java/lang/IllegalStateException
    //   232: dup
    //   233: ldc 97
    //   235: invokespecial 100	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   238: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramArrayOfByte	byte[]
    //   43	27	1	i	int
    //   36	38	2	localObjectInputStream	java.io.ObjectInputStream
    //   107	1	2	localThrowable1	Throwable
    //   119	20	2	localObject	Object
    //   185	43	2	localThrowable2	Throwable
    //   99	1	3	localClassNotFoundException	ClassNotFoundException
    //   103	1	3	localIOException	IOException
    //   121	9	3	arrayOfByte	byte[]
    //   25	184	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   15	165	5	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   73	77	80	java/io/IOException
    //   39	44	99	java/lang/ClassNotFoundException
    //   50	66	99	java/lang/ClassNotFoundException
    //   39	44	103	java/io/IOException
    //   50	66	103	java/io/IOException
    //   27	37	107	java/lang/Throwable
    //   27	37	113	java/lang/ClassNotFoundException
    //   27	37	117	java/io/IOException
    //   138	142	145	java/io/IOException
    //   91	96	164	java/io/IOException
    //   156	161	164	java/io/IOException
    //   39	44	185	java/lang/Throwable
    //   50	66	185	java/lang/Throwable
    //   124	134	185	java/lang/Throwable
    //   190	194	197	java/io/IOException
    //   208	213	216	java/io/IOException
  }
  
  public static Boolean[] toObject(boolean[] paramArrayOfBoolean)
  {
    Boolean[] arrayOfBoolean = new Boolean[paramArrayOfBoolean.length];
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      arrayOfBoolean[i] = Boolean.valueOf(paramArrayOfBoolean[i]);
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  public static Double[] toObject(double[] paramArrayOfDouble)
  {
    Double[] arrayOfDouble = new Double[paramArrayOfDouble.length];
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      arrayOfDouble[i] = Double.valueOf(paramArrayOfDouble[i]);
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public static Float[] toObject(float[] paramArrayOfFloat)
  {
    Float[] arrayOfFloat = new Float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfFloat[i] = Float.valueOf(paramArrayOfFloat[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static Integer[] toObject(int[] paramArrayOfInt)
  {
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
    return arrayOfInteger;
  }
  
  public static Long[] toObject(long[] paramArrayOfLong)
  {
    Long[] arrayOfLong = new Long[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfLong[i] = Long.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    return arrayOfLong;
  }
  
  public static Byte[] valueOf(byte[] paramArrayOfByte)
  {
    Byte[] arrayOfByte = new Byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = Byte.valueOf(paramArrayOfByte[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] write(Label paramLabel)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Object localObject2 = new ObjectOutputStream(localByteArrayOutputStream);
      try
      {
        ((ObjectOutputStream)localObject2).writeInt(paramLabel.getColor());
        paramLabel = values;
        paramLabel = paramLabel.entrySet().iterator();
        for (;;)
        {
          boolean bool = paramLabel.hasNext();
          if (!bool) {
            break;
          }
          localObject1 = paramLabel.next();
          localObject1 = (Map.Entry)localObject1;
          localObject3 = ((Map.Entry)localObject1).getKey();
          localObject3 = (String)localObject3;
          ((ObjectOutputStream)localObject2).writeUTF((String)localObject3);
          ((ObjectOutputStream)localObject2).writeObject(((Map.Entry)localObject1).getValue());
        }
        try
        {
          ((ObjectOutputStream)localObject2).close();
        }
        catch (IOException paramLabel)
        {
          android.util.Log.e(a, "Error in Data#toByteArray: ", paramLabel);
        }
        try
        {
          localByteArrayOutputStream.close();
        }
        catch (IOException paramLabel)
        {
          android.util.Log.e(a, "Error in Data#toByteArray: ", paramLabel);
        }
        if (localByteArrayOutputStream.size() <= 10240) {
          return localByteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
      }
      catch (Throwable paramLabel)
      {
        localObject1 = localObject2;
        break label254;
      }
      catch (IOException localIOException1)
      {
        paramLabel = (Label)localObject2;
        localObject2 = localIOException1;
      }
      localLabel = paramLabel;
    }
    catch (Throwable paramLabel) {}catch (IOException localIOException4)
    {
      paramLabel = (Label)localObject3;
    }
    android.util.Log.e(a, "Error in Data#toByteArray: ", localIOException4);
    Label localLabel = paramLabel;
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    if (paramLabel != null) {
      try
      {
        paramLabel.close();
      }
      catch (IOException paramLabel)
      {
        android.util.Log.e(a, "Error in Data#toByteArray: ", paramLabel);
      }
    }
    try
    {
      localByteArrayOutputStream.close();
      return arrayOfByte;
    }
    catch (IOException paramLabel)
    {
      android.util.Log.e(a, "Error in Data#toByteArray: ", paramLabel);
      return arrayOfByte;
    }
    label254:
    if (localLabel != null) {
      try
      {
        localLabel.close();
      }
      catch (IOException localIOException2)
      {
        android.util.Log.e(a, "Error in Data#toByteArray: ", localIOException2);
      }
    }
    try
    {
      localByteArrayOutputStream.close();
    }
    catch (IOException localIOException3)
    {
      android.util.Log.e(a, "Error in Data#toByteArray: ", localIOException3);
    }
    throw paramLabel;
  }
  
  public Map build()
  {
    return Collections.unmodifiableMap(values);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (d.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (Label)paramObject;
      Object localObject1 = values.keySet();
      if (!((Set)localObject1).equals(values.keySet())) {
        return false;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        Object localObject2 = values.get(localObject3);
        localObject3 = values.get(localObject3);
        boolean bool;
        if ((localObject2 != null) && (localObject3 != null))
        {
          if (((localObject2 instanceof Object[])) && ((localObject3 instanceof Object[]))) {
            bool = Arrays.deepEquals((Object[])localObject2, (Object[])localObject3);
          } else {
            bool = localObject2.equals(localObject3);
          }
        }
        else if (localObject2 == localObject3) {
          bool = true;
        } else {
          bool = false;
        }
        if (!bool) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public int getColor()
  {
    return values.size();
  }
  
  public String getText(String paramString)
  {
    paramString = values.get(paramString);
    if ((paramString instanceof String)) {
      return (String)paramString;
    }
    return null;
  }
  
  public int hashCode()
  {
    return values.hashCode() * 31;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Data {");
    if (!values.isEmpty())
    {
      Iterator localIterator = values.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" : ");
        localObject = values.get(localObject);
        if ((localObject instanceof Object[])) {
          localStringBuilder.append(Arrays.toString((Object[])localObject));
        } else {
          localStringBuilder.append(localObject);
        }
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
