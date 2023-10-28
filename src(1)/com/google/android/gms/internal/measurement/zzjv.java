package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

final class zzjv
{
  private static final zzjv magenta = new zzjv(true);
  final zzmj fields;
  private boolean hasLazyField;
  private boolean isImmutable;
  
  private zzjv()
  {
    fields = new zzlz(16);
  }
  
  private zzjv(boolean paramBoolean)
  {
    fields = localZzlz;
    makeImmutable();
    makeImmutable();
  }
  
  private static final void add(zzju paramZzju, Object paramObject)
  {
    zznd localZznd = paramZzju.resolve();
    zzkm.get(paramObject);
    Object localObject = zznd.mMap;
    localObject = zzne.mMap;
    boolean bool;
    switch (localZznd.handle().ordinal())
    {
    default: 
      break;
    case 8: 
      if ((paramObject instanceof zzll)) {
        return;
      }
      if (!(paramObject instanceof zzkq)) {
        break label213;
      }
      return;
    case 7: 
      if ((paramObject instanceof Integer)) {
        return;
      }
      if (!(paramObject instanceof zzkg)) {
        break label213;
      }
      return;
    case 6: 
      if ((paramObject instanceof zzjd)) {
        return;
      }
      if (!(paramObject instanceof byte[])) {
        break label213;
      }
      return;
    case 5: 
      bool = paramObject instanceof String;
      break;
    case 4: 
      bool = paramObject instanceof Boolean;
      break;
    case 3: 
      bool = paramObject instanceof Double;
      break;
    case 2: 
      bool = paramObject instanceof Float;
      break;
    case 1: 
      bool = paramObject instanceof Long;
      break;
    case 0: 
      bool = paramObject instanceof Integer;
    }
    if (bool) {
      return;
    }
    label213:
    throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[] { Integer.valueOf(paramZzju.getEndHour()), paramZzju.resolve().handle(), paramObject.getClass().getName() }));
  }
  
  public static zzjv findFirst()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzjv)) {
      return false;
    }
    paramObject = (zzjv)paramObject;
    return fields.equals(fields);
  }
  
  public final int hashCode()
  {
    return fields.hashCode();
  }
  
  public final void makeImmutable()
  {
    if (isImmutable) {
      return;
    }
    fields.makeImmutable();
    isImmutable = true;
  }
  
  public final void setField(zzju paramZzju, Object paramObject)
  {
    if (paramZzju.isRepeated())
    {
      if ((paramObject instanceof List))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((List)paramObject);
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          add(paramZzju, localArrayList.get(i));
          i += 1;
        }
        paramObject = localArrayList;
      }
      else
      {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    else {
      add(paramZzju, paramObject);
    }
    if ((paramObject instanceof zzkq)) {
      hasLazyField = true;
    }
    fields.put(paramZzju, paramObject);
  }
}
