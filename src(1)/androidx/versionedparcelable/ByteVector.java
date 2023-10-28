package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;

public abstract class ByteVector
{
  protected final c.e.a<String, Class> buffer;
  protected final c.e.a<String, Method> data;
  protected final c.e.a<String, Method> this$0;
  
  public ByteVector(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2, ArrayMap paramArrayMap3)
  {
    this$0 = paramArrayMap1;
    data = paramArrayMap2;
    buffer = paramArrayMap3;
  }
  
  private Class get(Class paramClass)
    throws ClassNotFoundException
  {
    Class localClass2 = (Class)buffer.get(paramClass.getName());
    Class localClass1 = localClass2;
    if (localClass2 == null)
    {
      localClass1 = Class.forName(String.format("%s.%sParcelizer", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() }), false, paramClass.getClassLoader());
      buffer.put(paramClass.getName(), localClass1);
    }
    return localClass1;
  }
  
  private Method get(String paramString)
    throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException
  {
    Method localMethod2 = (Method)this$0.get(paramString);
    Method localMethod1 = localMethod2;
    if (localMethod2 == null)
    {
      System.currentTimeMillis();
      localMethod1 = Class.forName(paramString, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[] { a.class });
      this$0.put(paramString, localMethod1);
    }
    return localMethod1;
  }
  
  private Method write(Class paramClass)
    throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException
  {
    Method localMethod = (Method)data.get(paramClass.getName());
    Object localObject = localMethod;
    if (localMethod == null)
    {
      localObject = get(paramClass);
      System.currentTimeMillis();
      localObject = ((Class)localObject).getDeclaredMethod("write", new Class[] { paramClass, a.class });
      data.put(paramClass.getName(), localObject);
    }
    return localObject;
  }
  
  private void write(Message paramMessage)
  {
    try
    {
      Class localClass = get(paramMessage.getClass());
      write(localClass.getName());
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessage.getClass().getSimpleName());
      localStringBuilder.append(" does not have a Parcelizer");
      throw new RuntimeException(localStringBuilder.toString(), localClassNotFoundException);
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (!b(paramInt2)) {
      return paramInt1;
    }
    return b();
  }
  
  protected abstract ByteVector a();
  
  public CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    if (!b(paramInt)) {
      return paramCharSequence;
    }
    return getQueueTitle();
  }
  
  public String a(String paramString, int paramInt)
  {
    if (!b(paramInt)) {
      return paramString;
    }
    return getValue();
  }
  
  protected abstract void a(int paramInt);
  
  protected abstract void a(Parcelable paramParcelable);
  
  public void a(Message paramMessage, int paramInt)
  {
    a(paramInt);
    add(paramMessage);
  }
  
  protected void a(Message paramMessage, ByteVector paramByteVector)
  {
    try
    {
      Method localMethod = write(paramMessage.getClass());
      localMethod.invoke(null, new Object[] { paramMessage, paramByteVector });
      return;
    }
    catch (ClassNotFoundException paramMessage)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramMessage);
    }
    catch (NoSuchMethodException paramMessage)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramMessage);
    }
    catch (InvocationTargetException paramMessage)
    {
      if ((paramMessage.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramMessage.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramMessage);
    }
    catch (IllegalAccessException paramMessage)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramMessage);
    }
  }
  
  protected abstract void a(CharSequence paramCharSequence);
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    if (!b(paramInt)) {
      return paramBoolean;
    }
    return c();
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (!b(paramInt)) {
      return paramArrayOfByte;
    }
    return read();
  }
  
  protected Message add()
  {
    String str = getValue();
    if (str == null) {
      return null;
    }
    return get(str, a());
  }
  
  public Message add(Message paramMessage, int paramInt)
  {
    if (!b(paramInt)) {
      return paramMessage;
    }
    return add();
  }
  
  public void add(int paramInt1, int paramInt2)
  {
    a(paramInt2);
    write(paramInt1);
  }
  
  public void add(Parcelable paramParcelable, int paramInt)
  {
    a(paramInt);
    a(paramParcelable);
  }
  
  protected void add(Message paramMessage)
  {
    if (paramMessage == null)
    {
      write(null);
      return;
    }
    write(paramMessage);
    ByteVector localByteVector = a();
    a(paramMessage, localByteVector);
    localByteVector.write();
  }
  
  public void add(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void add(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramInt);
    write(paramArrayOfByte);
  }
  
  protected abstract int b();
  
  protected abstract boolean b(int paramInt);
  
  protected abstract boolean c();
  
  protected abstract Parcelable get();
  
  protected Message get(String paramString, ByteVector paramByteVector)
  {
    try
    {
      paramString = get(paramString);
      paramString = paramString.invoke(null, new Object[] { paramByteVector });
      return (Message)paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramString);
    }
    catch (NoSuchMethodException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramString);
    }
    catch (InvocationTargetException paramString)
    {
      if ((paramString.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramString.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramString);
    }
  }
  
  protected abstract CharSequence getQueueTitle();
  
  protected abstract String getValue();
  
  public void put(String paramString, int paramInt)
  {
    a(paramInt);
    write(paramString);
  }
  
  public void put(boolean paramBoolean, int paramInt)
  {
    a(paramInt);
    write(paramBoolean);
  }
  
  public boolean put()
  {
    return false;
  }
  
  public Parcelable read(Parcelable paramParcelable, int paramInt)
  {
    if (!b(paramInt)) {
      return paramParcelable;
    }
    return get();
  }
  
  protected abstract byte[] read();
  
  protected abstract void write();
  
  protected abstract void write(int paramInt);
  
  public void write(CharSequence paramCharSequence, int paramInt)
  {
    a(paramInt);
    a(paramCharSequence);
  }
  
  protected abstract void write(String paramString);
  
  protected abstract void write(boolean paramBoolean);
  
  protected abstract void write(byte[] paramArrayOfByte);
}
