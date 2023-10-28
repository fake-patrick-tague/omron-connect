package androidx.room;

import android.content.res.AssetManager;
import androidx.room.core.KryoCopyable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import v7.td.data.Log;

class SQLiteAssetHelper
  implements Log
{
  private a d;
  private final int e;
  private final String filename;
  private final Log mDatabase;
  private boolean mIsInitializing;
  private final File size;
  private final android.content.Context this$0;
  
  SQLiteAssetHelper(android.content.Context paramContext, String paramString, File paramFile, int paramInt, Log paramLog)
  {
    this$0 = paramContext;
    filename = paramString;
    size = paramFile;
    e = paramInt;
    mDatabase = paramLog;
  }
  
  private void copy(File paramFile)
    throws IOException
  {
    Object localObject2 = filename;
    Object localObject1 = this;
    if (localObject2 != null)
    {
      localObject1 = Channels.newChannel(this$0.getAssets().open(filename));
    }
    else
    {
      if (size == null) {
        break label225;
      }
      localObject1 = new FileInputStream(size).getChannel();
    }
    localObject2 = File.createTempFile("room-copy-helper", ".tmp", this$0.getCacheDir());
    ((File)localObject2).deleteOnExit();
    FileChannel localFileChannel = new FileOutputStream((File)localObject2).getChannel();
    KryoCopyable.copy((ReadableByteChannel)localObject1, localFileChannel);
    localObject1 = paramFile.getParentFile();
    if ((localObject1 != null) && (!((File)localObject1).exists()) && (!((File)localObject1).mkdirs()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Failed to create directories for ");
      ((StringBuilder)localObject1).append(paramFile.getAbsolutePath());
      throw new IOException(((StringBuilder)localObject1).toString());
    }
    if (((File)localObject2).renameTo(paramFile)) {
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Failed to move intermediate file (");
    ((StringBuilder)localObject1).append(((File)localObject2).getAbsolutePath());
    ((StringBuilder)localObject1).append(") to destination (");
    ((StringBuilder)localObject1).append(paramFile.getAbsolutePath());
    ((StringBuilder)localObject1).append(").");
    throw new IOException(((StringBuilder)localObject1).toString());
    label225:
    throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
  }
  
  /* Error */
  private void onCreate()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 145	androidx/room/SQLiteAssetHelper:getDatabaseName	()Ljava/lang/String;
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 27	androidx/room/SQLiteAssetHelper:this$0	Landroid/content/Context;
    //   10: aload 5
    //   12: invokevirtual 149	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   15: astore 6
    //   17: aload_0
    //   18: getfield 151	androidx/room/SQLiteAssetHelper:d	Landroidx/room/a;
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +19 -> 44
    //   28: aload 4
    //   30: getfield 156	androidx/room/a:i	Z
    //   33: ifeq +6 -> 39
    //   36: goto +8 -> 44
    //   39: iconst_0
    //   40: istore_3
    //   41: goto +5 -> 46
    //   44: iconst_1
    //   45: istore_3
    //   46: new 158	androidx/room/core/b
    //   49: dup
    //   50: aload 5
    //   52: aload_0
    //   53: getfield 27	androidx/room/SQLiteAssetHelper:this$0	Landroid/content/Context;
    //   56: invokevirtual 161	android/content/Context:getFilesDir	()Ljava/io/File;
    //   59: iload_3
    //   60: invokespecial 164	androidx/room/core/b:<init>	(Ljava/lang/String;Ljava/io/File;Z)V
    //   63: astore 4
    //   65: aload 4
    //   67: invokevirtual 166	androidx/room/core/b:onCreate	()V
    //   70: aload 6
    //   72: invokevirtual 101	java/io/File:exists	()Z
    //   75: istore_3
    //   76: iload_3
    //   77: ifne +29 -> 106
    //   80: aload_0
    //   81: aload 6
    //   83: invokespecial 168	androidx/room/SQLiteAssetHelper:copy	(Ljava/io/File;)V
    //   86: aload 4
    //   88: invokevirtual 171	androidx/room/core/b:close	()V
    //   91: return
    //   92: astore 5
    //   94: new 173	java/lang/RuntimeException
    //   97: dup
    //   98: ldc -81
    //   100: aload 5
    //   102: invokespecial 178	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: athrow
    //   106: aload_0
    //   107: getfield 151	androidx/room/SQLiteAssetHelper:d	Landroidx/room/a;
    //   110: astore 7
    //   112: aload 7
    //   114: ifnonnull +9 -> 123
    //   117: aload 4
    //   119: invokevirtual 171	androidx/room/core/b:close	()V
    //   122: return
    //   123: aload 6
    //   125: invokestatic 184	androidx/room/core/Log:read	(Ljava/io/File;)I
    //   128: istore_1
    //   129: aload_0
    //   130: getfield 33	androidx/room/SQLiteAssetHelper:e	I
    //   133: istore_2
    //   134: iload_1
    //   135: iload_2
    //   136: if_icmpne +9 -> 145
    //   139: aload 4
    //   141: invokevirtual 171	androidx/room/core/b:close	()V
    //   144: return
    //   145: aload_0
    //   146: getfield 151	androidx/room/SQLiteAssetHelper:d	Landroidx/room/a;
    //   149: iload_1
    //   150: iload_2
    //   151: invokevirtual 188	androidx/room/a:a	(II)Z
    //   154: istore_3
    //   155: iload_3
    //   156: ifeq +9 -> 165
    //   159: aload 4
    //   161: invokevirtual 171	androidx/room/core/b:close	()V
    //   164: return
    //   165: aload_0
    //   166: getfield 27	androidx/room/SQLiteAssetHelper:this$0	Landroid/content/Context;
    //   169: aload 5
    //   171: invokevirtual 192	android/content/Context:deleteDatabase	(Ljava/lang/String;)Z
    //   174: istore_3
    //   175: iload_3
    //   176: ifeq +27 -> 203
    //   179: aload_0
    //   180: aload 6
    //   182: invokespecial 168	androidx/room/SQLiteAssetHelper:copy	(Ljava/io/File;)V
    //   185: goto +62 -> 247
    //   188: astore 5
    //   190: ldc -62
    //   192: ldc -81
    //   194: aload 5
    //   196: invokestatic 200	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   199: pop
    //   200: goto +47 -> 247
    //   203: new 106	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   210: astore 6
    //   212: aload 6
    //   214: ldc -54
    //   216: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 6
    //   222: aload 5
    //   224: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 6
    //   230: ldc -52
    //   232: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: ldc -62
    //   238: aload 6
    //   240: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 207	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   246: pop
    //   247: aload 4
    //   249: invokevirtual 171	androidx/room/core/b:close	()V
    //   252: return
    //   253: astore 5
    //   255: ldc -62
    //   257: ldc -47
    //   259: aload 5
    //   261: invokestatic 200	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   264: pop
    //   265: aload 4
    //   267: invokevirtual 171	androidx/room/core/b:close	()V
    //   270: return
    //   271: astore 5
    //   273: aload 4
    //   275: invokevirtual 171	androidx/room/core/b:close	()V
    //   278: aload 5
    //   280: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	SQLiteAssetHelper
    //   128	22	1	i	int
    //   133	18	2	j	int
    //   40	136	3	bool	boolean
    //   21	253	4	localObject1	Object
    //   4	47	5	str	String
    //   92	78	5	localIOException1	IOException
    //   188	35	5	localIOException2	IOException
    //   253	7	5	localIOException3	IOException
    //   271	8	5	localThrowable	Throwable
    //   15	224	6	localObject2	Object
    //   110	3	7	localA	a
    // Exception table:
    //   from	to	target	type
    //   80	86	92	java/io/IOException
    //   179	185	188	java/io/IOException
    //   123	129	253	java/io/IOException
    //   65	76	271	java/lang/Throwable
    //   80	86	271	java/lang/Throwable
    //   94	106	271	java/lang/Throwable
    //   106	112	271	java/lang/Throwable
    //   123	129	271	java/lang/Throwable
    //   129	134	271	java/lang/Throwable
    //   145	155	271	java/lang/Throwable
    //   165	175	271	java/lang/Throwable
    //   179	185	271	java/lang/Throwable
    //   190	200	271	java/lang/Throwable
    //   203	247	271	java/lang/Throwable
    //   255	265	271	java/lang/Throwable
  }
  
  public void close()
  {
    try
    {
      mDatabase.close();
      mIsInitializing = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  void close(a paramA)
  {
    d = paramA;
  }
  
  public String getDatabaseName()
  {
    return mDatabase.getDatabaseName();
  }
  
  public v7.td.data.Context getWritableDatabase()
  {
    try
    {
      if (!mIsInitializing)
      {
        onCreate();
        mIsInitializing = true;
      }
      v7.td.data.Context localContext = mDatabase.getWritableDatabase();
      return localContext;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    mDatabase.setWriteAheadLoggingEnabled(paramBoolean);
  }
}
