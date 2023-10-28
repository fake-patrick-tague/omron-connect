package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class i
  extends h
{
  private static Method a;
  private static Method b;
  private static Constructor<?> c;
  private static boolean f;
  private static Class<?> g;
  
  i() {}
  
  private static void a()
  {
    if (f) {
      return;
    }
    f = true;
    Object localObject3 = null;
    try
    {
      Object localObject6 = Class.forName("android.graphics.FontFamily");
      Object localObject1 = localObject6;
      localObject5 = ((Class)localObject6).getConstructor(new Class[0]);
      localObject4 = Integer.TYPE;
      Class localClass = Boolean.TYPE;
      localObject4 = ((Class)localObject6).getMethod("addFontWeightStyle", new Class[] { String.class, localObject4, localClass });
      localObject6 = Array.newInstance((Class)localObject6, 1);
      localObject6 = localObject6.getClass();
      localObject6 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { localObject6 });
      localObject3 = localObject5;
      localObject5 = localObject6;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Log.e("TypefaceCompatApi21Impl", localClassNotFoundException.getClass().getName(), localClassNotFoundException);
    Object localObject5 = null;
    Object localObject2 = null;
    Object localObject4 = null;
    c = localObject3;
    g = localObject2;
    a = (Method)localObject4;
    b = (Method)localObject5;
  }
  
  private static boolean a(Object paramObject, String paramString, int paramInt, boolean paramBoolean)
  {
    a();
    Method localMethod = a;
    try
    {
      paramObject = localMethod.invoke(paramObject, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      paramObject = (Boolean)paramObject;
      paramBoolean = paramObject.booleanValue();
      return paramBoolean;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  private static Typeface add(Object paramObject)
  {
    a();
    Object localObject = g;
    try
    {
      localObject = Array.newInstance((Class)localObject, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = b;
      paramObject = paramObject.invoke(null, new Object[] { localObject });
      return (Typeface)paramObject;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  private static Object add()
  {
    a();
    Object localObject = c;
    try
    {
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException) {}catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}
    throw new RuntimeException(localIllegalAccessException);
  }
  
  private File close(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/proc/self/fd/");
      ((StringBuilder)localObject).append(paramParcelFileDescriptor.getFd());
      paramParcelFileDescriptor = Os.readlink(((StringBuilder)localObject).toString());
      localObject = Os.stat(paramParcelFileDescriptor);
      int i = st_mode;
      boolean bool = OsConstants.S_ISREG(i);
      if (bool)
      {
        paramParcelFileDescriptor = new File(paramParcelFileDescriptor);
        return paramParcelFileDescriptor;
      }
      return null;
    }
    catch (ErrnoException paramParcelFileDescriptor) {}
    return null;
  }
  
  /* Error */
  public Typeface a(Context paramContext, android.os.CancellationSignal paramCancellationSignal, v7.v7.asm.Label[] paramArrayOfLabel, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: aload_3
    //   10: iload 4
    //   12: invokevirtual 194	androidx/core/graphics/h:a	([Lv7/v7/asm/Label;I)Lv7/v7/asm/Label;
    //   15: astore_3
    //   16: aload_1
    //   17: invokevirtual 200	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore 6
    //   22: aload 6
    //   24: aload_3
    //   25: invokevirtual 205	v7/v7/asm/Label:getName	()Landroid/net/Uri;
    //   28: ldc -49
    //   30: aload_2
    //   31: invokevirtual 213	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnonnull +13 -> 49
    //   39: aload_2
    //   40: ifnull +115 -> 155
    //   43: aload_2
    //   44: invokevirtual 215	android/os/ParcelFileDescriptor:close	()V
    //   47: aconst_null
    //   48: areturn
    //   49: aload_0
    //   50: aload_2
    //   51: invokespecial 217	androidx/core/graphics/i:close	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull +28 -> 84
    //   59: aload_3
    //   60: invokevirtual 220	java/io/File:canRead	()Z
    //   63: istore 5
    //   65: iload 5
    //   67: ifne +6 -> 73
    //   70: goto +14 -> 84
    //   73: aload_3
    //   74: invokestatic 224	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   77: astore_1
    //   78: aload_2
    //   79: invokevirtual 215	android/os/ParcelFileDescriptor:close	()V
    //   82: aload_1
    //   83: areturn
    //   84: new 226	java/io/FileInputStream
    //   87: dup
    //   88: aload_2
    //   89: invokevirtual 230	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   92: invokespecial 233	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   95: astore_3
    //   96: aload_0
    //   97: aload_1
    //   98: aload_3
    //   99: invokespecial 236	androidx/core/graphics/h:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 237	java/io/FileInputStream:close	()V
    //   107: aload_2
    //   108: invokevirtual 215	android/os/ParcelFileDescriptor:close	()V
    //   111: aload_1
    //   112: areturn
    //   113: astore_1
    //   114: aload_3
    //   115: invokevirtual 237	java/io/FileInputStream:close	()V
    //   118: goto +9 -> 127
    //   121: astore_3
    //   122: aload_1
    //   123: aload_3
    //   124: invokevirtual 240	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: aload_2
    //   131: invokevirtual 215	android/os/ParcelFileDescriptor:close	()V
    //   134: goto +9 -> 143
    //   137: astore_2
    //   138: aload_1
    //   139: aload_2
    //   140: invokevirtual 240	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: aconst_null
    //   147: areturn
    //   148: astore_1
    //   149: aconst_null
    //   150: areturn
    //   151: astore_1
    //   152: aconst_null
    //   153: areturn
    //   154: astore_1
    //   155: aconst_null
    //   156: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	i
    //   0	157	1	paramContext	Context
    //   0	157	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	157	3	paramArrayOfLabel	v7.v7.asm.Label[]
    //   0	157	4	paramInt	int
    //   63	3	5	bool	boolean
    //   20	3	6	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   96	103	113	java/lang/Throwable
    //   114	118	121	java/lang/Throwable
    //   49	55	129	java/lang/Throwable
    //   59	65	129	java/lang/Throwable
    //   73	78	129	java/lang/Throwable
    //   84	96	129	java/lang/Throwable
    //   103	107	129	java/lang/Throwable
    //   122	127	129	java/lang/Throwable
    //   127	129	129	java/lang/Throwable
    //   130	134	137	java/lang/Throwable
    //   22	35	145	java/io/IOException
    //   43	47	145	java/io/IOException
    //   78	82	148	java/io/IOException
    //   107	111	151	java/io/IOException
    //   138	143	154	java/io/IOException
    //   143	145	154	java/io/IOException
  }
  
  public Typeface a(Context paramContext, androidx.core.content.asm.i paramI, Resources paramResources, int paramInt)
  {
    Object localObject = add();
    androidx.core.content.asm.h[] arrayOfH = paramI.a();
    int i = arrayOfH.length;
    paramInt = 0;
    for (;;)
    {
      androidx.core.content.asm.h localH;
      if (paramInt < i)
      {
        localH = arrayOfH[paramInt];
        paramI = a.a(paramContext);
        if (paramI == null) {
          return null;
        }
      }
      try
      {
        bool = a.a(paramI, paramResources, localH.e());
        if (!bool)
        {
          paramI.delete();
          return null;
        }
      }
      catch (Throwable paramContext)
      {
        try
        {
          boolean bool = a(localObject, paramI.getPath(), localH.c(), localH.k());
          if (!bool)
          {
            paramI.delete();
            return null;
          }
          paramI.delete();
          paramInt += 1;
        }
        catch (RuntimeException paramContext)
        {
          for (;;) {}
        }
        paramContext = paramContext;
        paramI.delete();
        throw paramContext;
        paramI.delete();
        return null;
        return add(localObject);
      }
      catch (RuntimeException paramContext)
      {
        for (;;) {}
      }
    }
  }
}
