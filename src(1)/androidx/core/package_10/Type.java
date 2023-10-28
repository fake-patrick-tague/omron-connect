package androidx.core.package_10;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class Type
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  protected static final Method b;
  protected static final Method c;
  protected static final Class<?> codecCapabilitiesClass;
  protected static final Field d;
  protected static final Field h;
  protected static final Method s;
  
  static
  {
    Class localClass = forName();
    codecCapabilitiesClass = localClass;
    d = getInheritableThreadLocalsField();
    h = findField();
    b = get(localClass);
    c = getMethod(localClass);
    s = create(localClass);
  }
  
  /* Error */
  static boolean a(Activity paramActivity)
  {
    // Byte code:
    //   0: getstatic 77	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 28
    //   5: if_icmplt +9 -> 14
    //   8: aload_0
    //   9: invokevirtual 82	android/app/Activity:recreate	()V
    //   12: iconst_1
    //   13: ireturn
    //   14: invokestatic 86	androidx/core/package_10/Type:getType	()Z
    //   17: ifeq +11 -> 28
    //   20: getstatic 67	androidx/core/package_10/Type:s	Ljava/lang/reflect/Method;
    //   23: ifnonnull +5 -> 28
    //   26: iconst_0
    //   27: ireturn
    //   28: getstatic 62	androidx/core/package_10/Type:c	Ljava/lang/reflect/Method;
    //   31: ifnonnull +11 -> 42
    //   34: getstatic 57	androidx/core/package_10/Type:b	Ljava/lang/reflect/Method;
    //   37: ifnonnull +5 -> 42
    //   40: iconst_0
    //   41: ireturn
    //   42: getstatic 51	androidx/core/package_10/Type:h	Ljava/lang/reflect/Field;
    //   45: aload_0
    //   46: invokevirtual 91	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnonnull +5 -> 58
    //   56: iconst_0
    //   57: ireturn
    //   58: getstatic 46	androidx/core/package_10/Type:d	Ljava/lang/reflect/Field;
    //   61: aload_0
    //   62: invokevirtual 91	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: astore 5
    //   67: aload 5
    //   69: ifnonnull +5 -> 74
    //   72: iconst_0
    //   73: ireturn
    //   74: aload_0
    //   75: invokevirtual 95	android/app/Activity:getApplication	()Landroid/app/Application;
    //   78: astore_2
    //   79: new 6	androidx/core/package_10/ActivityLifecycleCallbacksWrapper
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 98	androidx/core/package_10/ActivityLifecycleCallbacksWrapper:<init>	(Landroid/app/Activity;)V
    //   87: astore_3
    //   88: aload_2
    //   89: aload_3
    //   90: invokevirtual 104	android/app/Application:registerActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   93: getstatic 34	androidx/core/package_10/Type:a	Landroid/os/Handler;
    //   96: astore 6
    //   98: aload 6
    //   100: new 106	androidx/core/package_10/SMTPAppenderBase$SenderRunnable
    //   103: dup
    //   104: aload_3
    //   105: aload 4
    //   107: invokespecial 109	androidx/core/package_10/SMTPAppenderBase$SenderRunnable:<init>	(Landroidx/core/package_10/ActivityLifecycleCallbacksWrapper;Ljava/lang/Object;)V
    //   110: invokevirtual 113	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   113: pop
    //   114: invokestatic 86	androidx/core/package_10/Type:getType	()Z
    //   117: istore_1
    //   118: iload_1
    //   119: ifeq +73 -> 192
    //   122: getstatic 67	androidx/core/package_10/Type:s	Ljava/lang/reflect/Method;
    //   125: astore_0
    //   126: getstatic 119	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   129: astore 7
    //   131: aload_0
    //   132: aload 5
    //   134: bipush 9
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload 4
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aconst_null
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: aconst_null
    //   151: aastore
    //   152: dup
    //   153: iconst_3
    //   154: iconst_0
    //   155: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: aastore
    //   159: dup
    //   160: iconst_4
    //   161: aload 7
    //   163: aastore
    //   164: dup
    //   165: iconst_5
    //   166: aconst_null
    //   167: aastore
    //   168: dup
    //   169: bipush 6
    //   171: aconst_null
    //   172: aastore
    //   173: dup
    //   174: bipush 7
    //   176: aload 7
    //   178: aastore
    //   179: dup
    //   180: bipush 8
    //   182: aload 7
    //   184: aastore
    //   185: invokevirtual 131	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: goto +7 -> 196
    //   192: aload_0
    //   193: invokevirtual 82	android/app/Activity:recreate	()V
    //   196: aload 6
    //   198: new 133	androidx/core/package_10/MonthByWeekFragment$2
    //   201: dup
    //   202: aload_2
    //   203: aload_3
    //   204: invokespecial 136	androidx/core/package_10/MonthByWeekFragment$2:<init>	(Landroid/app/Application;Landroidx/core/package_10/ActivityLifecycleCallbacksWrapper;)V
    //   207: invokevirtual 113	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   210: pop
    //   211: iconst_1
    //   212: ireturn
    //   213: astore_0
    //   214: getstatic 34	androidx/core/package_10/Type:a	Landroid/os/Handler;
    //   217: new 133	androidx/core/package_10/MonthByWeekFragment$2
    //   220: dup
    //   221: aload_2
    //   222: aload_3
    //   223: invokespecial 136	androidx/core/package_10/MonthByWeekFragment$2:<init>	(Landroid/app/Application;Landroidx/core/package_10/ActivityLifecycleCallbacksWrapper;)V
    //   226: invokevirtual 113	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   229: pop
    //   230: aload_0
    //   231: athrow
    //   232: astore_0
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_0
    //   236: iconst_0
    //   237: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramActivity	Activity
    //   117	2	1	bool	boolean
    //   78	144	2	localApplication	android.app.Application
    //   87	136	3	localActivityLifecycleCallbacksWrapper	ActivityLifecycleCallbacksWrapper
    //   49	93	4	localObject1	Object
    //   65	68	5	localObject2	Object
    //   96	101	6	localHandler	Handler
    //   129	54	7	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   114	118	213	java/lang/Throwable
    //   122	189	213	java/lang/Throwable
    //   192	196	213	java/lang/Throwable
    //   42	51	232	java/lang/Throwable
    //   58	67	232	java/lang/Throwable
    //   74	114	232	java/lang/Throwable
    //   196	211	235	java/lang/Throwable
    //   214	232	235	java/lang/Throwable
  }
  
  protected static boolean a(Object paramObject, int paramInt, Activity paramActivity)
  {
    try
    {
      Object localObject = h.get(paramActivity);
      if (localObject == paramObject)
      {
        int i = paramActivity.hashCode();
        if (i != paramInt) {
          return false;
        }
        paramObject = d.get(paramActivity);
        a.postAtFrontOfQueue(new Plot.a(paramObject, localObject));
        return true;
      }
      return false;
    }
    catch (Throwable paramObject)
    {
      Log.e("ActivityRecreator", "Exception while fetching field values", paramObject);
    }
    return false;
  }
  
  private static Method create(Class paramClass)
  {
    if (getType()) {
      if (paramClass == null) {
        return null;
      }
    }
    try
    {
      Class localClass1 = Integer.TYPE;
      Class localClass2 = Boolean.TYPE;
      paramClass = paramClass.getDeclaredMethod("requestRelaunchActivity", new Class[] { IBinder.class, List.class, List.class, localClass1, localClass2, Configuration.class, Configuration.class, localClass2, localClass2 });
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (Throwable paramClass) {}
    return null;
    return null;
  }
  
  private static Field findField()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mToken");
      localField.setAccessible(true);
      return localField;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Class forName()
  {
    try
    {
      Class localClass = Class.forName("android.app.ActivityThread");
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Method get(Class paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, Boolean.TYPE, String.class });
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (Throwable paramClass) {}
    return null;
  }
  
  private static Field getInheritableThreadLocalsField()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mMainThread");
      localField.setAccessible(true);
      return localField;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Method getMethod(Class paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, Boolean.TYPE });
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (Throwable paramClass) {}
    return null;
  }
  
  private static boolean getType()
  {
    int i = Build.VERSION.SDK_INT;
    return (i == 26) || (i == 27);
  }
}
