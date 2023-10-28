package com.google.android.gms.internal.fitness;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzhs
  extends zzfs<String>
  implements zzhr, RandomAccess
{
  private static final zzhs zzzi;
  private static final zzhr zzzj;
  private final List<Object> zzzk;
  
  static
  {
    zzhs localZzhs = new zzhs();
    zzzi = localZzhs;
    localZzhs.zzar();
    zzzj = localZzhs;
  }
  
  public zzhs()
  {
    this(10);
  }
  
  public zzhs(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  private zzhs(ArrayList paramArrayList)
  {
    zzzk = paramArrayList;
  }
  
  private static String asString(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof zzfx)) {
      return ((zzfx)paramObject).zzav();
    }
    return zzhc.create((byte[])paramObject);
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    zzas();
    Object localObject = paramCollection;
    if ((paramCollection instanceof zzhr)) {
      localObject = ((zzhr)paramCollection).zzch();
    }
    boolean bool = zzzk.addAll(paramInt, (Collection)localObject);
    modCount += 1;
    return bool;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public final void clear()
  {
    zzas();
    zzzk.clear();
    modCount += 1;
  }
  
  public final int size()
  {
    return zzzk.size();
  }
  
  public final Object zzaf(int paramInt)
  {
    return zzzk.get(paramInt);
  }
  
  public final List zzch()
  {
    return Collections.unmodifiableList(zzzk);
  }
  
  public final zzhr zzci()
  {
    if (zzaq()) {
      return new zzjt(this);
    }
    return this;
  }
}
