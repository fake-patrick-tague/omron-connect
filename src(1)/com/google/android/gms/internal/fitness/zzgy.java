package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzgy<MessageType extends zzgy<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>>
  extends zzfo<MessageType, BuilderType>
{
  private static Map<Object, zzgy<?, ?>> zzxv = new ConcurrentHashMap();
  protected zzjr zzxt = zzjr.zzdp();
  private int zzxu = -1;
  
  public zzgy() {}
  
  protected static void cancelRequests(Class paramClass, zzgy paramZzgy)
  {
    zzxv.put(paramClass, paramZzgy);
  }
  
  static Object get(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if (!(paramMethod instanceof RuntimeException))
      {
        if ((paramMethod instanceof Error)) {
          throw ((Error)paramMethod);
        }
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
      }
      throw ((RuntimeException)paramMethod);
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
  }
  
  protected static Object getMessage(zzik paramZzik, String paramString, Object[] paramArrayOfObject)
  {
    return new zzix(paramZzik, paramString, paramArrayOfObject);
  }
  
  static zzgy setField(Class paramClass)
  {
    zzgy localZzgy2 = (zzgy)zzxv.get(paramClass);
    zzgy localZzgy1 = localZzgy2;
    if (localZzgy2 == null) {
      try
      {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        localZzgy1 = (zzgy)zzxv.get(paramClass);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new IllegalStateException("Class initialization cannot fail.", paramClass);
      }
    }
    if (localZzgy1 == null)
    {
      localZzgy1 = (zzgy)((zzgy)zzjy.setField(paramClass)).getAsString(zze.zzyi, null, null);
      if (localZzgy1 != null)
      {
        zzxv.put(paramClass, localZzgy1);
        return localZzgy1;
      }
      throw new IllegalStateException();
    }
    return localZzgy1;
  }
  
  protected static final boolean writeValue(zzgy paramZzgy, boolean paramBoolean)
  {
    int i = ((Byte)paramZzgy.getAsString(zze.zzyd, null, null)).byteValue();
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    boolean bool = zziv.zzcy().a(paramZzgy).a(paramZzgy);
    if (paramBoolean)
    {
      i = zze.zzye;
      zzgy localZzgy;
      if (bool) {
        localZzgy = paramZzgy;
      } else {
        localZzgy = null;
      }
      paramZzgy.getAsString(i, localZzgy, null);
    }
    return bool;
  }
  
  protected static zzhg zzbq()
  {
    return (zzhg)zzha.zzcb();
  }
  
  protected static zzhi zzbr()
  {
    return (zzhi)zzhy.zzcm();
  }
  
  protected static zzhh zzbs()
  {
    return zziy.zzdb();
  }
  
  final void append(int paramInt)
  {
    zzxu = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    return zziv.zzcy().a(this).equals(this, (zzgy)paramObject);
  }
  
  public final void f(zzgk paramZzgk)
    throws IOException
  {
    zziv.zzcy().a(this).a(this, zzgn.f(paramZzgk));
  }
  
  protected abstract Object getAsString(int paramInt, Object paramObject1, Object paramObject2);
  
  public int hashCode()
  {
    int i = zztu;
    if (i != 0) {
      return i;
    }
    i = zziv.zzcy().a(this).hashCode(this);
    zztu = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return writeValue(this, true);
  }
  
  public String toString()
  {
    return zzil.safeString(this, super.toString());
  }
  
  final int zzan()
  {
    return zzxu;
  }
  
  public final int zzbp()
  {
    if (zzxu == -1) {
      zzxu = zziv.zzcy().a(this).parse(this);
    }
    return zzxu;
  }
  
  protected static final class zza<T extends zzgy<T, ?>>
    extends zzft<T>
  {
    private final T zzxx;
    
    public zza(zzgy paramZzgy)
    {
      zzxx = paramZzgy;
    }
  }
  
  public static class zzb<MessageType extends zzgy<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>>
    extends zzfr<MessageType, BuilderType>
  {
    private final MessageType zzxx;
    private MessageType zzxy;
    private boolean zzxz;
    
    protected zzb(zzgy paramZzgy)
    {
      zzxx = paramZzgy;
      zzxy = ((zzgy)paramZzgy.getAsString(zzgy.zze.zzyg, null, null));
      zzxz = false;
    }
    
    private static void visitFieldInsn(zzgy paramZzgy1, zzgy paramZzgy2)
    {
      zziv.zzcy().a(paramZzgy1).a(paramZzgy1, paramZzgy2);
    }
    
    public final boolean isInitialized()
    {
      return zzgy.writeValue(zzxy, false);
    }
    
    public final zzb subtract(zzgy paramZzgy)
    {
      if (zzxz)
      {
        zzbw();
        zzxz = false;
      }
      visitFieldInsn(zzxy, paramZzgy);
      return this;
    }
    
    protected void zzbw()
    {
      zzgy localZzgy = (zzgy)zzxy.getAsString(zzgy.zze.zzyg, null, null);
      visitFieldInsn(localZzgy, zzxy);
      zzxy = localZzgy;
    }
    
    public zzgy zzbx()
    {
      if (zzxz) {
        return zzxy;
      }
      zzgy localZzgy = zzxy;
      zziv.zzcy().a(localZzgy).moveArt(localZzgy);
      zzxz = true;
      return zzxy;
    }
    
    public final zzgy zzby()
    {
      zzgy localZzgy = (zzgy)zzbz();
      if (localZzgy.isInitialized()) {
        return localZzgy;
      }
      throw new zzjp(localZzgy);
    }
  }
  
  static final class zzc
    implements zzgv<zzc>
  {
    public final zziq createCopy(zziq paramZziq1, zziq paramZziq2)
    {
      throw new NoSuchMethodError();
    }
    
    public final int get()
    {
      throw new NoSuchMethodError();
    }
    
    public final zzij union(zzij paramZzij, zzik paramZzik)
    {
      throw new NoSuchMethodError();
    }
    
    public final zzkg zzbl()
    {
      throw new NoSuchMethodError();
    }
    
    public final zzkj zzbm()
    {
      throw new NoSuchMethodError();
    }
    
    public final boolean zzbn()
    {
      throw new NoSuchMethodError();
    }
    
    public final boolean zzbo()
    {
      throw new NoSuchMethodError();
    }
  }
  
  public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType>
    extends zzgy<MessageType, BuilderType>
    implements zzim
  {
    protected zzgt<zzgy.zzc> zzya = zzgt.zzbj();
    
    public zzd() {}
  }
  
  public static enum zze
  {
    public static int[] zzcc()
    {
      return (int[])zzyk.clone();
    }
  }
}
