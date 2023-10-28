package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.ContentObserver;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import v7.v7.asm.ByteVector;
import v7.v7.asm.Label;
import v7.v7.asm.h;
import v7.v7.util.Log;

class b
  implements Attribute
{
  private final c a;
  private final h b;
  private final Context c;
  Paint d;
  private final Object e = new Object();
  private ContentObserver f;
  private IntegerPolynomial h;
  private ThreadPoolExecutor handler;
  private android.os.Handler out;
  private Executor state;
  private Runnable timer;
  
  b(Context paramContext, h paramH, c paramC)
  {
    Log.get(paramContext, "Context cannot be null");
    Log.get(paramH, "FontRequest cannot be null");
    c = paramContext.getApplicationContext();
    b = paramH;
    a = paramC;
  }
  
  private Label b()
  {
    Object localObject1 = a;
    Object localObject2 = c;
    h localH = b;
    try
    {
      localObject1 = ((c)localObject1).a((Context)localObject2, localH);
      if (((ByteVector)localObject1).a() == 0)
      {
        localObject1 = ((ByteVector)localObject1).b();
        if ((localObject1 != null) && (localObject1.length != 0)) {
          return localObject1[0];
        }
        throw new RuntimeException("fetchFonts failed (empty result)");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fetchFonts failed (");
      ((StringBuilder)localObject2).append(((ByteVector)localObject1).a());
      ((StringBuilder)localObject2).append(")");
      throw new RuntimeException(((StringBuilder)localObject2).toString());
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException("provider not found", localNameNotFoundException);
    }
  }
  
  private void close()
  {
    Object localObject1 = e;
    try
    {
      d = null;
      Object localObject2 = f;
      if (localObject2 != null)
      {
        a.add(c, (ContentObserver)localObject2);
        f = null;
      }
      localObject2 = out;
      if (localObject2 != null) {
        ((android.os.Handler)localObject2).removeCallbacks(timer);
      }
      out = null;
      localObject2 = handler;
      if (localObject2 != null) {
        ((ThreadPoolExecutor)localObject2).shutdown();
      }
      state = null;
      handler = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	androidx/emoji2/text/b:e	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 111	androidx/emoji2/text/b:d	Landroidx/emoji2/text/Paint;
    //   11: ifnonnull +6 -> 17
    //   14: aload_2
    //   15: monitorexit
    //   16: return
    //   17: aload_2
    //   18: monitorexit
    //   19: aload_0
    //   20: invokespecial 138	androidx/emoji2/text/b:b	()Lv7/v7/asm/Label;
    //   23: astore_2
    //   24: aload_2
    //   25: invokevirtual 142	v7/v7/asm/Label:c	()I
    //   28: istore_1
    //   29: iload_1
    //   30: iconst_2
    //   31: if_icmpne +37 -> 68
    //   34: aload_0
    //   35: getfield 37	androidx/emoji2/text/b:e	Ljava/lang/Object;
    //   38: astore_3
    //   39: aload_3
    //   40: monitorenter
    //   41: aload_0
    //   42: getfield 144	androidx/emoji2/text/b:h	Landroidx/emoji2/text/IntegerPolynomial;
    //   45: ifnonnull +8 -> 53
    //   48: aload_3
    //   49: monitorexit
    //   50: goto +18 -> 68
    //   53: new 146	java/lang/NullPointerException
    //   56: dup
    //   57: ldc -108
    //   59: invokespecial 149	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: astore_2
    //   64: aload_3
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    //   68: iload_1
    //   69: ifne +103 -> 172
    //   72: ldc -105
    //   74: invokestatic 156	v7/v7/menu/TraceCompat:beginSection	(Ljava/lang/String;)V
    //   77: aload_0
    //   78: getfield 59	androidx/emoji2/text/b:a	Landroidx/emoji2/text/c;
    //   81: aload_0
    //   82: getfield 55	androidx/emoji2/text/b:c	Landroid/content/Context;
    //   85: aload_2
    //   86: invokevirtual 159	androidx/emoji2/text/c:a	(Landroid/content/Context;Lv7/v7/asm/Label;)Landroid/graphics/Typeface;
    //   89: astore_3
    //   90: aload_0
    //   91: getfield 55	androidx/emoji2/text/b:c	Landroid/content/Context;
    //   94: aconst_null
    //   95: aload_2
    //   96: invokevirtual 163	v7/v7/asm/Label:getName	()Landroid/net/Uri;
    //   99: invokestatic 169	androidx/core/graphics/a:read	(Landroid/content/Context;Landroid/os/CancellationSignal;Landroid/net/Uri;)Ljava/nio/ByteBuffer;
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +52 -> 156
    //   107: aload_3
    //   108: ifnull +48 -> 156
    //   111: aload_3
    //   112: aload_2
    //   113: invokestatic 174	androidx/emoji2/text/h:a	(Landroid/graphics/Typeface;Ljava/nio/ByteBuffer;)Landroidx/emoji2/text/h;
    //   116: astore_3
    //   117: invokestatic 176	v7/v7/menu/TraceCompat:beginSection	()V
    //   120: aload_0
    //   121: getfield 37	androidx/emoji2/text/b:e	Ljava/lang/Object;
    //   124: astore_2
    //   125: aload_2
    //   126: monitorenter
    //   127: aload_0
    //   128: getfield 111	androidx/emoji2/text/b:d	Landroidx/emoji2/text/Paint;
    //   131: astore 4
    //   133: aload 4
    //   135: ifnull +9 -> 144
    //   138: aload 4
    //   140: aload_3
    //   141: invokevirtual 181	androidx/emoji2/text/Paint:b	(Landroidx/emoji2/text/h;)V
    //   144: aload_2
    //   145: monitorexit
    //   146: aload_0
    //   147: invokespecial 183	androidx/emoji2/text/b:close	()V
    //   150: return
    //   151: astore_3
    //   152: aload_2
    //   153: monitorexit
    //   154: aload_3
    //   155: athrow
    //   156: new 78	java/lang/RuntimeException
    //   159: dup
    //   160: ldc -71
    //   162: invokespecial 83	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   165: athrow
    //   166: astore_2
    //   167: invokestatic 176	v7/v7/menu/TraceCompat:beginSection	()V
    //   170: aload_2
    //   171: athrow
    //   172: new 85	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   179: astore_2
    //   180: aload_2
    //   181: ldc -69
    //   183: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_2
    //   188: iload_1
    //   189: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_2
    //   194: ldc 97
    //   196: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: new 78	java/lang/RuntimeException
    //   203: dup
    //   204: aload_2
    //   205: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokespecial 83	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   211: athrow
    //   212: astore_3
    //   213: aload_0
    //   214: getfield 37	androidx/emoji2/text/b:e	Ljava/lang/Object;
    //   217: astore_2
    //   218: aload_2
    //   219: monitorenter
    //   220: aload_0
    //   221: getfield 111	androidx/emoji2/text/b:d	Landroidx/emoji2/text/Paint;
    //   224: astore 4
    //   226: aload 4
    //   228: ifnull +9 -> 237
    //   231: aload 4
    //   233: aload_3
    //   234: invokevirtual 190	androidx/emoji2/text/Paint:b	(Ljava/lang/Throwable;)V
    //   237: aload_2
    //   238: monitorexit
    //   239: aload_0
    //   240: invokespecial 183	androidx/emoji2/text/b:close	()V
    //   243: return
    //   244: astore_3
    //   245: aload_2
    //   246: monitorexit
    //   247: aload_3
    //   248: athrow
    //   249: astore_3
    //   250: aload_2
    //   251: monitorexit
    //   252: aload_3
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	b
    //   28	161	1	i	int
    //   4	21	2	localObject1	Object
    //   63	33	2	localThrowable1	Throwable
    //   102	51	2	localObject2	Object
    //   166	5	2	localThrowable2	Throwable
    //   179	72	2	localObject3	Object
    //   38	103	3	localObject4	Object
    //   151	4	3	localThrowable3	Throwable
    //   212	22	3	localThrowable4	Throwable
    //   244	4	3	localThrowable5	Throwable
    //   249	4	3	localThrowable6	Throwable
    //   131	101	4	localPaint	Paint
    // Exception table:
    //   from	to	target	type
    //   41	50	63	java/lang/Throwable
    //   53	63	63	java/lang/Throwable
    //   64	66	63	java/lang/Throwable
    //   127	133	151	java/lang/Throwable
    //   138	144	151	java/lang/Throwable
    //   144	146	151	java/lang/Throwable
    //   152	154	151	java/lang/Throwable
    //   72	103	166	java/lang/Throwable
    //   111	117	166	java/lang/Throwable
    //   156	166	166	java/lang/Throwable
    //   19	29	212	java/lang/Throwable
    //   34	41	212	java/lang/Throwable
    //   66	68	212	java/lang/Throwable
    //   117	127	212	java/lang/Throwable
    //   146	150	212	java/lang/Throwable
    //   154	156	212	java/lang/Throwable
    //   167	172	212	java/lang/Throwable
    //   172	212	212	java/lang/Throwable
    //   220	226	244	java/lang/Throwable
    //   231	237	244	java/lang/Throwable
    //   237	239	244	java/lang/Throwable
    //   245	247	244	java/lang/Throwable
    //   7	16	249	java/lang/Throwable
    //   17	19	249	java/lang/Throwable
    //   250	252	249	java/lang/Throwable
  }
  
  public void a(Paint paramPaint)
  {
    Log.get(paramPaint, "LoaderCallback cannot be null");
    Object localObject = e;
    try
    {
      d = paramPaint;
      onCreate();
      return;
    }
    catch (Throwable paramPaint)
    {
      throw paramPaint;
    }
  }
  
  public void a(Executor paramExecutor)
  {
    Object localObject = e;
    try
    {
      state = paramExecutor;
      return;
    }
    catch (Throwable paramExecutor)
    {
      throw paramExecutor;
    }
  }
  
  void onCreate()
  {
    Object localObject = e;
    try
    {
      if (d == null) {
        return;
      }
      if (state == null)
      {
        ThreadPoolExecutor localThreadPoolExecutor = Handler.create("emojiCompat");
        handler = localThreadPoolExecutor;
        state = localThreadPoolExecutor;
      }
      state.execute(new ConfigurationManager.dataDownloader(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
