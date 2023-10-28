package com.alivecor.asm;

import android.util.Log;
import com.alivecor.ai.r;
import com.alivecor.ai.s;
import com.alivecor.mapsforge.core.model.Direction;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import k.a.a.f;
import org.joda.time.format.a;

public class Plot
  implements Serializable
{
  private static final String TAG = s.class.getSimpleName();
  public static final float h = 0.0F;
  public final String d;
  public final k.a.a.b e;
  public final String f;
  public final String g;
  public final Priority i;
  public final float k;
  private final Map<Class<? extends r>, r<?>> m;
  public final Direction n;
  public final boolean q;
  public final int s;
  
  private Plot(String paramString1, String paramString2, Priority paramPriority, String paramString3, Direction paramDirection, k.a.a.b paramB, float paramFloat, int paramInt, boolean paramBoolean, Collection paramCollection)
  {
    d = paramString1;
    f = paramString2;
    g = paramString3;
    n = paramDirection;
    k = paramFloat;
    s = paramInt;
    e = paramB;
    i = paramPriority;
    q = paramBoolean;
    paramString1 = new HashMap();
    m = paramString1;
    read(paramString1, paramCollection);
  }
  
  /* Error */
  public static Plot a(String paramString1, String paramString2, Priority paramPriority, float paramFloat, boolean paramBoolean, Collection paramCollection)
    throws java.io.IOException
  {
    // Byte code:
    //   0: getstatic 40	com/alivecor/asm/Plot:TAG	Ljava/lang/String;
    //   3: astore 13
    //   5: aload 13
    //   7: ldc 80
    //   9: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   12: pop
    //   13: new 87	com/alivecor/mapsforge/core/EcgFile
    //   16: dup
    //   17: invokespecial 88	com/alivecor/mapsforge/core/EcgFile:<init>	()V
    //   20: astore 11
    //   22: new 87	com/alivecor/mapsforge/core/EcgFile
    //   25: dup
    //   26: invokespecial 88	com/alivecor/mapsforge/core/EcgFile:<init>	()V
    //   29: astore 12
    //   31: aload 11
    //   33: new 90	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: invokevirtual 97	com/alivecor/mapsforge/core/EcgFile:open	(Ljava/io/File;)Z
    //   44: istore 7
    //   46: aload 12
    //   48: new 90	java/io/File
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: invokevirtual 97	com/alivecor/mapsforge/core/EcgFile:open	(Ljava/io/File;)Z
    //   59: istore 8
    //   61: iload 7
    //   63: ifeq +120 -> 183
    //   66: iload 8
    //   68: ifeq +115 -> 183
    //   71: aload 11
    //   73: getfield 101	com/alivecor/mapsforge/core/EcgFile:mAliveInfo	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileInfo;
    //   76: getfield 106	com/alivecor/mapsforge/core/EcgFile$AliveFileInfo:recordingUUID	Ljava/lang/String;
    //   79: astore_1
    //   80: aload 11
    //   82: getstatic 112	com/alivecor/mapsforge/core/EcgFile$Lead:LEAD_2	Lcom/alivecor/mapsforge/core/EcgFile$Lead;
    //   85: invokevirtual 116	com/alivecor/mapsforge/core/EcgFile:samplesForLead	(Lcom/alivecor/mapsforge/core/EcgFile$Lead;)J
    //   88: lstore 9
    //   90: lload 9
    //   92: lconst_0
    //   93: lcmp
    //   94: ifne +10 -> 104
    //   97: getstatic 121	com/alivecor/mapsforge/core/model/Direction:S	Lcom/alivecor/mapsforge/core/model/Direction;
    //   100: astore_0
    //   101: goto +10 -> 111
    //   104: getstatic 124	com/alivecor/mapsforge/core/model/Direction:W	Lcom/alivecor/mapsforge/core/model/Direction;
    //   107: astore_0
    //   108: goto -7 -> 101
    //   111: aload 11
    //   113: getstatic 127	com/alivecor/mapsforge/core/EcgFile$Lead:LEAD_1	Lcom/alivecor/mapsforge/core/EcgFile$Lead;
    //   116: invokevirtual 116	com/alivecor/mapsforge/core/EcgFile:samplesForLead	(Lcom/alivecor/mapsforge/core/EcgFile$Lead;)J
    //   119: l2i
    //   120: istore 6
    //   122: invokestatic 133	k/a/a/b:H	()Lk/a/a/b;
    //   125: astore 14
    //   127: aload 13
    //   129: ldc -121
    //   131: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   134: pop
    //   135: new 2	com/alivecor/asm/Plot
    //   138: dup
    //   139: aload 11
    //   141: getfield 139	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   144: invokevirtual 142	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   147: aload 12
    //   149: getfield 139	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   152: invokevirtual 142	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   155: aload_2
    //   156: aload_1
    //   157: aload_0
    //   158: aload 14
    //   160: fload_3
    //   161: iload 6
    //   163: iload 4
    //   165: aload 5
    //   167: invokespecial 144	com/alivecor/asm/Plot:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/alivecor/asm/Priority;Ljava/lang/String;Lcom/alivecor/mapsforge/core/model/Direction;Lk/a/a/b;FIZLjava/util/Collection;)V
    //   170: astore_0
    //   171: aload 12
    //   173: invokevirtual 147	com/alivecor/mapsforge/core/EcgFile:close	()V
    //   176: aload 11
    //   178: invokevirtual 147	com/alivecor/mapsforge/core/EcgFile:close	()V
    //   181: aload_0
    //   182: areturn
    //   183: new 76	java/io/IOException
    //   186: dup
    //   187: ldc -107
    //   189: iconst_2
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: iload 7
    //   197: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   200: aastore
    //   201: dup
    //   202: iconst_1
    //   203: iload 8
    //   205: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   208: aastore
    //   209: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   212: invokespecial 162	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   215: athrow
    //   216: astore_0
    //   217: aload 12
    //   219: invokevirtual 147	com/alivecor/mapsforge/core/EcgFile:close	()V
    //   222: goto +9 -> 231
    //   225: astore_1
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual 166	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   231: aload_0
    //   232: athrow
    //   233: astore_0
    //   234: aload 11
    //   236: invokevirtual 147	com/alivecor/mapsforge/core/EcgFile:close	()V
    //   239: goto +9 -> 248
    //   242: astore_1
    //   243: aload_0
    //   244: aload_1
    //   245: invokevirtual 166	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   248: aload_0
    //   249: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramString1	String
    //   0	250	1	paramString2	String
    //   0	250	2	paramPriority	Priority
    //   0	250	3	paramFloat	float
    //   0	250	4	paramBoolean	boolean
    //   0	250	5	paramCollection	Collection
    //   120	42	6	j	int
    //   44	152	7	bool1	boolean
    //   59	145	8	bool2	boolean
    //   88	3	9	l	long
    //   20	215	11	localEcgFile1	com.alivecor.mapsforge.core.EcgFile
    //   29	189	12	localEcgFile2	com.alivecor.mapsforge.core.EcgFile
    //   3	125	13	str	String
    //   125	34	14	localB	k.a.a.b
    // Exception table:
    //   from	to	target	type
    //   31	61	216	java/lang/Throwable
    //   71	90	216	java/lang/Throwable
    //   97	101	216	java/lang/Throwable
    //   104	108	216	java/lang/Throwable
    //   111	171	216	java/lang/Throwable
    //   183	216	216	java/lang/Throwable
    //   217	222	225	java/lang/Throwable
    //   22	31	233	java/lang/Throwable
    //   171	176	233	java/lang/Throwable
    //   226	231	233	java/lang/Throwable
    //   231	233	233	java/lang/Throwable
    //   234	239	242	java/lang/Throwable
  }
  
  private static k.a.a.b parse(String paramString)
  {
    Log.e(TAG, "Inside toDateTime");
    Object localObject2 = paramString.replace("Z", "+00:00");
    try
    {
      localObject1 = ((String)localObject2).substring(23);
      if (((String)localObject2).contains(".")) {
        paramString = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
      } else {
        paramString = "yyyy-MM-dd'T'HH:mm:ssZ";
      }
      paramString = a.d(paramString).p(Locale.US).e((String)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("GMT");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString.Q(f.m(TimeZone.getTimeZone(((StringBuilder)localObject2).toString())));
      return paramString;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      Object localObject1;
      for (;;) {}
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Failed to parse string: ");
    ((StringBuilder)localObject1).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  private void read(Map paramMap, Collection paramCollection)
  {
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Label localLabel = (Label)paramCollection.next();
        paramMap.put(localLabel.getClass(), localLabel);
      }
    }
  }
  
  public Label a(Class paramClass)
  {
    if (m.containsKey(paramClass)) {
      return (Label)m.get(paramClass);
    }
    return null;
  }
  
  public void a(Label paramLabel)
  {
    m.put(paramLabel.getClass(), paramLabel);
  }
  
  public Collection b()
  {
    return m.values();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EvaluationResult{rawAtcPath='");
    localStringBuilder.append(d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", enhancedAtcPath='");
    localStringBuilder.append(f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recordingUuid='");
    localStringBuilder.append(g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", leadsConfig=");
    localStringBuilder.append(n);
    localStringBuilder.append(", averageHeartRate=");
    localStringBuilder.append(k);
    localStringBuilder.append(", finalDetermination=");
    localStringBuilder.append(i);
    localStringBuilder.append(", lead1SampleCount=");
    localStringBuilder.append(s);
    localStringBuilder.append(", recordingDate=");
    localStringBuilder.append(e);
    localStringBuilder.append(", evaluationData=");
    localStringBuilder.append(m);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
