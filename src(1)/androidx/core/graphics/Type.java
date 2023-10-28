package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.asm.i;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import v7.util.SimpleArrayMap;
import v7.v7.asm.Label;

class Type
  extends h
{
  private static final Method a;
  private static final Class<?> b;
  private static final Constructor<?> c;
  private static final Method d;
  
  static
  {
    Object localObject3 = null;
    try
    {
      Object localObject6 = Class.forName("android.graphics.FontFamily");
      Object localObject1 = localObject6;
      localObject5 = ((Class)localObject6).getConstructor(new Class[0]);
      localObject4 = Integer.TYPE;
      Class localClass = Boolean.TYPE;
      localObject4 = ((Class)localObject6).getMethod("addFontWeightStyle", new Class[] { ByteBuffer.class, localObject4, List.class, localObject4, localClass });
      localObject6 = Array.newInstance((Class)localObject6, 1);
      localObject6 = localObject6.getClass();
      localObject6 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { localObject6 });
      localObject3 = localObject5;
      localObject5 = localObject6;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Log.e("TypefaceCompatApi24Impl", localClassNotFoundException.getClass().getName(), localClassNotFoundException);
    Object localObject2 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    c = localObject3;
    b = localObject2;
    d = (Method)localObject4;
    a = (Method)localObject5;
  }
  
  Type() {}
  
  public static boolean a()
  {
    Method localMethod = d;
    if (localMethod == null) {
      Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
    }
    return localMethod != null;
  }
  
  private static boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Method localMethod = d;
    try
    {
      paramObject = localMethod.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
      paramObject = (Boolean)paramObject;
      paramBoolean = paramObject.booleanValue();
      return paramBoolean;
    }
    catch (IllegalAccessException paramObject)
    {
      return false;
    }
    catch (InvocationTargetException paramObject) {}
    return false;
  }
  
  private static Typeface get(Object paramObject)
  {
    Object localObject = b;
    try
    {
      localObject = Array.newInstance((Class)localObject, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = a;
      paramObject = paramObject.invoke(null, new Object[] { localObject });
      return (Typeface)paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      return null;
    }
    catch (InvocationTargetException paramObject) {}
    return null;
  }
  
  private static Object valueOf()
  {
    Object localObject = c;
    try
    {
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, Label[] paramArrayOfLabel, int paramInt)
  {
    Object localObject = valueOf();
    if (localObject == null) {
      return null;
    }
    SimpleArrayMap localSimpleArrayMap = new SimpleArrayMap();
    int j = paramArrayOfLabel.length;
    int i = 0;
    while (i < j)
    {
      Label localLabel = paramArrayOfLabel[i];
      Uri localUri = localLabel.getName();
      ByteBuffer localByteBuffer2 = (ByteBuffer)localSimpleArrayMap.get(localUri);
      ByteBuffer localByteBuffer1 = localByteBuffer2;
      if (localByteBuffer2 == null)
      {
        localByteBuffer2 = a.read(paramContext, paramCancellationSignal, localUri);
        localByteBuffer1 = localByteBuffer2;
        localSimpleArrayMap.put(localUri, localByteBuffer2);
      }
      if (localByteBuffer1 == null) {
        return null;
      }
      if (!a(localObject, localByteBuffer1, localLabel.a(), localLabel.e(), localLabel.b())) {
        return null;
      }
      i += 1;
    }
    paramContext = get(localObject);
    if (paramContext == null) {
      return null;
    }
    return Typeface.create(paramContext, paramInt);
  }
  
  public Typeface a(Context paramContext, i paramI, Resources paramResources, int paramInt)
  {
    Object localObject1 = valueOf();
    if (localObject1 == null) {
      return null;
    }
    paramI = paramI.a();
    int i = paramI.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject2 = paramI[paramInt];
      ByteBuffer localByteBuffer = a.a(paramContext, paramResources, localObject2.e());
      if (localByteBuffer == null) {
        return null;
      }
      if (!a(localObject1, localByteBuffer, localObject2.a(), localObject2.c(), localObject2.k())) {
        return null;
      }
      paramInt += 1;
    }
    return get(localObject1);
  }
}
