package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import v7.v7.menu.Label;

class Item
{
  static void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 33)
    {
      ComponentName localComponentName = new ComponentName(paramContext, "androidx.appcompat.app.AppLocalesMetadataHolderService");
      if (paramContext.getPackageManager().getComponentEnabledSetting(localComponentName) != 1)
      {
        if (f.b().a())
        {
          String str = parse(paramContext);
          Object localObject = paramContext.getSystemService("locale");
          if (localObject != null) {
            m.a(localObject, b.e(str));
          }
        }
        paramContext.getPackageManager().setComponentEnabledSetting(localComponentName, 1, 1);
      }
    }
  }
  
  /* Error */
  static String parse(Context paramContext)
  {
    // Byte code:
    //   0: ldc 83
    //   2: astore 6
    //   4: aload_0
    //   5: ldc 85
    //   7: invokevirtual 89	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   10: astore 8
    //   12: invokestatic 95	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore 7
    //   17: aload 7
    //   19: aload 8
    //   21: ldc 97
    //   23: invokeinterface 103 3 0
    //   28: aload 7
    //   30: invokeinterface 107 1 0
    //   35: istore_1
    //   36: aload 7
    //   38: invokeinterface 110 1 0
    //   43: istore_2
    //   44: aload 6
    //   46: astore 5
    //   48: iload_2
    //   49: iconst_1
    //   50: if_icmpeq +69 -> 119
    //   53: iload_2
    //   54: iconst_3
    //   55: if_icmpne +20 -> 75
    //   58: aload 7
    //   60: invokeinterface 107 1 0
    //   65: istore_3
    //   66: aload 6
    //   68: astore 5
    //   70: iload_3
    //   71: iload_1
    //   72: if_icmple +47 -> 119
    //   75: iload_2
    //   76: iconst_3
    //   77: if_icmpeq -41 -> 36
    //   80: iload_2
    //   81: iconst_4
    //   82: if_icmpne +6 -> 88
    //   85: goto -49 -> 36
    //   88: aload 7
    //   90: invokeinterface 114 1 0
    //   95: ldc 116
    //   97: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: istore 4
    //   102: iload 4
    //   104: ifeq -68 -> 36
    //   107: aload 7
    //   109: aconst_null
    //   110: ldc 124
    //   112: invokeinterface 128 3 0
    //   117: astore 5
    //   119: aload 5
    //   121: astore 7
    //   123: aload 8
    //   125: ifnull +43 -> 168
    //   128: aload 8
    //   130: invokevirtual 134	java/io/FileInputStream:close	()V
    //   133: aload 5
    //   135: astore 7
    //   137: goto +31 -> 168
    //   140: astore_0
    //   141: goto +80 -> 221
    //   144: ldc -120
    //   146: ldc -118
    //   148: invokestatic 144	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   151: pop
    //   152: aload 6
    //   154: astore 7
    //   156: aload 8
    //   158: ifnull +10 -> 168
    //   161: aload 6
    //   163: astore 5
    //   165: goto -37 -> 128
    //   168: aload 7
    //   170: invokevirtual 147	java/lang/String:isEmpty	()Z
    //   173: ifne +38 -> 211
    //   176: new 149	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   183: astore_0
    //   184: aload_0
    //   185: ldc -103
    //   187: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_0
    //   192: aload 7
    //   194: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: ldc -120
    //   200: aload_0
    //   201: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   207: pop
    //   208: aload 7
    //   210: areturn
    //   211: aload_0
    //   212: ldc 85
    //   214: invokevirtual 167	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   217: pop
    //   218: aload 7
    //   220: areturn
    //   221: aload 8
    //   223: ifnull +8 -> 231
    //   226: aload 8
    //   228: invokevirtual 134	java/io/FileInputStream:close	()V
    //   231: aload_0
    //   232: athrow
    //   233: ldc -120
    //   235: ldc -87
    //   237: invokestatic 144	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   240: pop
    //   241: ldc 83
    //   243: areturn
    //   244: astore_0
    //   245: goto -12 -> 233
    //   248: astore 5
    //   250: goto -106 -> 144
    //   253: astore 5
    //   255: goto -111 -> 144
    //   258: astore 6
    //   260: aload 5
    //   262: astore 7
    //   264: goto -96 -> 168
    //   267: astore 5
    //   269: goto -38 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramContext	Context
    //   35	38	1	i	int
    //   43	40	2	j	int
    //   65	8	3	k	int
    //   100	3	4	bool	boolean
    //   46	118	5	str1	String
    //   248	1	5	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   253	8	5	localIOException1	java.io.IOException
    //   267	1	5	localIOException2	java.io.IOException
    //   2	160	6	str2	String
    //   258	1	6	localIOException3	java.io.IOException
    //   15	248	7	localObject	Object
    //   10	217	8	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   12	36	140	java/lang/Throwable
    //   36	44	140	java/lang/Throwable
    //   58	66	140	java/lang/Throwable
    //   88	102	140	java/lang/Throwable
    //   107	119	140	java/lang/Throwable
    //   144	152	140	java/lang/Throwable
    //   4	12	244	java/io/FileNotFoundException
    //   12	36	248	org/xmlpull/v1/XmlPullParserException
    //   36	44	248	org/xmlpull/v1/XmlPullParserException
    //   58	66	248	org/xmlpull/v1/XmlPullParserException
    //   88	102	248	org/xmlpull/v1/XmlPullParserException
    //   107	119	248	org/xmlpull/v1/XmlPullParserException
    //   12	36	253	java/io/IOException
    //   36	44	253	java/io/IOException
    //   58	66	253	java/io/IOException
    //   88	102	253	java/io/IOException
    //   107	119	253	java/io/IOException
    //   128	133	258	java/io/IOException
    //   226	231	267	java/io/IOException
  }
  
  /* Error */
  static void save(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 83
    //   3: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +11 -> 17
    //   9: aload_0
    //   10: ldc 85
    //   12: invokevirtual 167	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   15: pop
    //   16: return
    //   17: aload_0
    //   18: ldc 85
    //   20: iconst_0
    //   21: invokevirtual 176	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   24: astore_0
    //   25: invokestatic 180	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   28: astore_2
    //   29: aload_2
    //   30: aload_0
    //   31: aconst_null
    //   32: invokeinterface 186 3 0
    //   37: getstatic 192	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   40: astore_3
    //   41: aload_2
    //   42: ldc 97
    //   44: aload_3
    //   45: invokeinterface 196 3 0
    //   50: aload_2
    //   51: aconst_null
    //   52: ldc 116
    //   54: invokeinterface 200 3 0
    //   59: pop
    //   60: aload_2
    //   61: aconst_null
    //   62: ldc 124
    //   64: aload_1
    //   65: invokeinterface 204 4 0
    //   70: pop
    //   71: aload_2
    //   72: aconst_null
    //   73: ldc 116
    //   75: invokeinterface 207 3 0
    //   80: pop
    //   81: aload_2
    //   82: invokeinterface 210 1 0
    //   87: new 149	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   94: astore_2
    //   95: aload_2
    //   96: ldc -44
    //   98: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_2
    //   103: aload_1
    //   104: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_2
    //   109: ldc -42
    //   111: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: ldc -120
    //   117: aload_2
    //   118: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 163	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   124: pop
    //   125: aload_0
    //   126: ifnull +52 -> 178
    //   129: aload_0
    //   130: invokevirtual 217	java/io/FileOutputStream:close	()V
    //   133: return
    //   134: astore_1
    //   135: goto +44 -> 179
    //   138: astore_2
    //   139: new 149	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   146: astore_3
    //   147: aload_3
    //   148: ldc -37
    //   150: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_3
    //   155: aload_1
    //   156: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: ldc -120
    //   162: aload_3
    //   163: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: aload_2
    //   167: invokestatic 222	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   170: pop
    //   171: aload_0
    //   172: ifnull +48 -> 220
    //   175: goto -46 -> 129
    //   178: return
    //   179: aload_0
    //   180: ifnull +7 -> 187
    //   183: aload_0
    //   184: invokevirtual 217	java/io/FileOutputStream:close	()V
    //   187: aload_1
    //   188: athrow
    //   189: ldc -120
    //   191: ldc -32
    //   193: iconst_1
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: ldc 85
    //   201: aastore
    //   202: invokestatic 228	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   205: invokestatic 144	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   208: pop
    //   209: return
    //   210: astore_0
    //   211: goto -22 -> 189
    //   214: astore_0
    //   215: return
    //   216: astore_0
    //   217: goto -30 -> 187
    //   220: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	paramContext	Context
    //   0	221	1	paramString	String
    //   28	90	2	localObject1	Object
    //   138	29	2	localException	Exception
    //   40	123	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	37	134	java/lang/Throwable
    //   37	41	134	java/lang/Throwable
    //   41	87	134	java/lang/Throwable
    //   87	125	134	java/lang/Throwable
    //   139	171	134	java/lang/Throwable
    //   29	37	138	java/lang/Exception
    //   41	87	138	java/lang/Exception
    //   87	125	138	java/lang/Exception
    //   17	25	210	java/io/FileNotFoundException
    //   129	133	214	java/io/IOException
    //   183	187	216	java/io/IOException
  }
}
