package com.alivecor.asm;

import android.util.Log;
import com.alivecor.mapsforge.core.EcgFile;
import com.alivecor.mapsforge.core.EcgFile.AliveFileFormat;
import com.alivecor.mapsforge.core.EcgFile.Lead;
import com.alivecor.mapsforge.core.asm.b;
import com.alivecor.mapsforge.core.model.Direction;
import java.io.IOException;

class aa
  implements Attribute
{
  private static final String a = "j";
  private final f b;
  private final c c;
  
  public aa(c paramC, f paramF)
  {
    c = paramC;
    b = paramF;
  }
  
  private Type a(EcgFile paramEcgFile, Direction paramDirection)
    throws IOException
  {
    paramEcgFile = b.a(b.a(paramEcgFile.readEcgSamples(EcgFile.Lead.LEAD_1)), mAliveFormat.resolution_nV);
    StringBuilder localStringBuilder;
    if (paramDirection == Direction.S)
    {
      paramEcgFile = b.a(paramEcgFile);
      paramDirection = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("runNeuralSuite: Ran Inversion: ");
      localStringBuilder.append(paramEcgFile);
      Log.i(paramDirection, localStringBuilder.toString());
      if (paramEcgFile.a()) {
        return paramEcgFile;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to run the inversion network: ");
      localStringBuilder.append(paramEcgFile);
      Log.e(paramDirection, localStringBuilder.toString());
    }
    else
    {
      paramEcgFile = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("runNeuralSuite: Didn't run inversion for recording with leads ");
      localStringBuilder.append(paramDirection);
      Log.i(paramEcgFile, localStringBuilder.toString());
    }
    return null;
  }
  
  /* Error */
  public Plot a(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: new 36	com/alivecor/mapsforge/core/EcgFile
    //   3: dup
    //   4: invokespecial 110	com/alivecor/mapsforge/core/EcgFile:<init>	()V
    //   7: astore 6
    //   9: new 36	com/alivecor/mapsforge/core/EcgFile
    //   12: dup
    //   13: invokespecial 110	com/alivecor/mapsforge/core/EcgFile:<init>	()V
    //   16: astore 7
    //   18: aload 6
    //   20: new 112	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: invokevirtual 119	com/alivecor/mapsforge/core/EcgFile:open	(Ljava/io/File;)Z
    //   31: istore_3
    //   32: iload_3
    //   33: ifeq +323 -> 356
    //   36: aload 7
    //   38: new 112	java/io/File
    //   41: dup
    //   42: aload_2
    //   43: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 119	com/alivecor/mapsforge/core/EcgFile:open	(Ljava/io/File;)Z
    //   49: istore_3
    //   50: iload_3
    //   51: ifeq +284 -> 335
    //   54: aload 6
    //   56: getstatic 122	com/alivecor/mapsforge/core/EcgFile$Lead:LEAD_2	Lcom/alivecor/mapsforge/core/EcgFile$Lead;
    //   59: invokevirtual 126	com/alivecor/mapsforge/core/EcgFile:samplesForLead	(Lcom/alivecor/mapsforge/core/EcgFile$Lead;)J
    //   62: lstore 4
    //   64: lload 4
    //   66: lconst_0
    //   67: lcmp
    //   68: ifle +10 -> 78
    //   71: getstatic 129	com/alivecor/mapsforge/core/model/Direction:W	Lcom/alivecor/mapsforge/core/model/Direction;
    //   74: astore_2
    //   75: goto +7 -> 82
    //   78: getstatic 64	com/alivecor/mapsforge/core/model/Direction:S	Lcom/alivecor/mapsforge/core/model/Direction;
    //   81: astore_2
    //   82: aload_0
    //   83: getfield 23	com/alivecor/asm/aa:c	Lcom/alivecor/asm/c;
    //   86: new 112	java/io/File
    //   89: dup
    //   90: aload_1
    //   91: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: invokeinterface 134 2 0
    //   99: astore_1
    //   100: getstatic 71	com/alivecor/asm/aa:a	Ljava/lang/String;
    //   103: astore 8
    //   105: new 73	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   112: astore 9
    //   114: aload 9
    //   116: ldc -120
    //   118: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 9
    //   124: aload_1
    //   125: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 8
    //   131: aload 9
    //   133: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 93	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   139: pop
    //   140: aload_1
    //   141: invokevirtual 139	com/alivecor/asm/Item:a	()Z
    //   144: istore_3
    //   145: iload_3
    //   146: ifeq +110 -> 256
    //   149: new 141	java/util/ArrayList
    //   152: dup
    //   153: invokespecial 142	java/util/ArrayList:<init>	()V
    //   156: astore 8
    //   158: aload 8
    //   160: aload_1
    //   161: getfield 145	com/alivecor/asm/Item:b	Lcom/alivecor/asm/ClassifierData;
    //   164: invokeinterface 151 2 0
    //   169: pop
    //   170: aload_0
    //   171: aload 7
    //   173: aload_2
    //   174: invokespecial 153	com/alivecor/asm/aa:a	(Lcom/alivecor/mapsforge/core/EcgFile;Lcom/alivecor/mapsforge/core/model/Direction;)Lcom/alivecor/asm/Type;
    //   177: astore_2
    //   178: aload_2
    //   179: ifnull +24 -> 203
    //   182: aload_2
    //   183: invokevirtual 98	com/alivecor/asm/Type:a	()Z
    //   186: istore_3
    //   187: iload_3
    //   188: ifeq +15 -> 203
    //   191: aload 8
    //   193: aload_2
    //   194: getfield 156	com/alivecor/asm/Type:a	Lcom/alivecor/asm/Series;
    //   197: invokeinterface 151 2 0
    //   202: pop
    //   203: aload 6
    //   205: getfield 160	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   208: invokevirtual 163	java/io/File:getPath	()Ljava/lang/String;
    //   211: aload 7
    //   213: getfield 160	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   216: invokevirtual 163	java/io/File:getPath	()Ljava/lang/String;
    //   219: aload_1
    //   220: getfield 145	com/alivecor/asm/Item:b	Lcom/alivecor/asm/ClassifierData;
    //   223: invokevirtual 169	com/alivecor/asm/Label:newUTF8	()Ljava/io/Serializable;
    //   226: checkcast 171	com/alivecor/asm/ClassifierData$b
    //   229: invokevirtual 175	com/alivecor/asm/ClassifierData$b:getDetermination	()Lcom/alivecor/asm/Priority;
    //   232: aload_1
    //   233: getfield 177	com/alivecor/asm/Item:c	I
    //   236: i2f
    //   237: iconst_0
    //   238: aload 8
    //   240: invokestatic 182	com/alivecor/asm/Plot:a	(Ljava/lang/String;Ljava/lang/String;Lcom/alivecor/asm/Priority;FZLjava/util/Collection;)Lcom/alivecor/asm/Plot;
    //   243: astore_1
    //   244: aload 7
    //   246: invokevirtual 185	com/alivecor/mapsforge/core/EcgFile:close	()V
    //   249: aload 6
    //   251: invokevirtual 185	com/alivecor/mapsforge/core/EcgFile:close	()V
    //   254: aload_1
    //   255: areturn
    //   256: new 73	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   263: astore_2
    //   264: aload_2
    //   265: ldc -69
    //   267: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_2
    //   272: aload_1
    //   273: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 8
    //   279: aload_2
    //   280: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 103	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   286: pop
    //   287: aload 6
    //   289: getfield 160	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   292: invokevirtual 163	java/io/File:getPath	()Ljava/lang/String;
    //   295: aload 7
    //   297: getfield 160	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   300: invokevirtual 163	java/io/File:getPath	()Ljava/lang/String;
    //   303: aload_1
    //   304: getfield 145	com/alivecor/asm/Item:b	Lcom/alivecor/asm/ClassifierData;
    //   307: invokevirtual 169	com/alivecor/asm/Label:newUTF8	()Ljava/io/Serializable;
    //   310: checkcast 171	com/alivecor/asm/ClassifierData$b
    //   313: invokevirtual 175	com/alivecor/asm/ClassifierData$b:getDetermination	()Lcom/alivecor/asm/Priority;
    //   316: fconst_0
    //   317: iconst_0
    //   318: aconst_null
    //   319: invokestatic 182	com/alivecor/asm/Plot:a	(Ljava/lang/String;Ljava/lang/String;Lcom/alivecor/asm/Priority;FZLjava/util/Collection;)Lcom/alivecor/asm/Plot;
    //   322: astore_1
    //   323: aload 7
    //   325: invokevirtual 185	com/alivecor/mapsforge/core/EcgFile:close	()V
    //   328: aload 6
    //   330: invokevirtual 185	com/alivecor/mapsforge/core/EcgFile:close	()V
    //   333: aload_1
    //   334: areturn
    //   335: new 28	java/io/IOException
    //   338: dup
    //   339: ldc -67
    //   341: iconst_1
    //   342: anewarray 4	java/lang/Object
    //   345: dup
    //   346: iconst_0
    //   347: aload_2
    //   348: aastore
    //   349: invokestatic 195	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   352: invokespecial 196	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   355: athrow
    //   356: new 28	java/io/IOException
    //   359: dup
    //   360: ldc -58
    //   362: iconst_1
    //   363: anewarray 4	java/lang/Object
    //   366: dup
    //   367: iconst_0
    //   368: aload_1
    //   369: aastore
    //   370: invokestatic 195	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   373: invokespecial 196	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   376: athrow
    //   377: astore_1
    //   378: aload 7
    //   380: invokevirtual 185	com/alivecor/mapsforge/core/EcgFile:close	()V
    //   383: goto +9 -> 392
    //   386: astore_2
    //   387: aload_1
    //   388: aload_2
    //   389: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   392: aload_1
    //   393: athrow
    //   394: astore_1
    //   395: aload 6
    //   397: invokevirtual 185	com/alivecor/mapsforge/core/EcgFile:close	()V
    //   400: goto +9 -> 409
    //   403: astore_2
    //   404: aload_1
    //   405: aload_2
    //   406: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   409: aload_1
    //   410: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	aa
    //   0	411	1	paramString1	String
    //   0	411	2	paramString2	String
    //   31	157	3	bool	boolean
    //   62	3	4	l	long
    //   7	389	6	localEcgFile1	EcgFile
    //   16	363	7	localEcgFile2	EcgFile
    //   103	175	8	localObject	Object
    //   112	20	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   18	32	377	java/lang/Throwable
    //   36	50	377	java/lang/Throwable
    //   54	64	377	java/lang/Throwable
    //   71	75	377	java/lang/Throwable
    //   78	82	377	java/lang/Throwable
    //   82	145	377	java/lang/Throwable
    //   149	178	377	java/lang/Throwable
    //   182	187	377	java/lang/Throwable
    //   191	203	377	java/lang/Throwable
    //   203	244	377	java/lang/Throwable
    //   256	323	377	java/lang/Throwable
    //   335	356	377	java/lang/Throwable
    //   356	377	377	java/lang/Throwable
    //   378	383	386	java/lang/Throwable
    //   9	18	394	java/lang/Throwable
    //   244	249	394	java/lang/Throwable
    //   323	328	394	java/lang/Throwable
    //   387	392	394	java/lang/Throwable
    //   392	394	394	java/lang/Throwable
    //   395	400	403	java/lang/Throwable
  }
}
