package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzes;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzny;

final class BitmapCache
  extends TFloatLinkedList
{
  private final zzes this$0;
  
  BitmapCache(zzaa paramZzaa, String paramString, int paramInt, zzes paramZzes)
  {
    super(paramString, paramInt);
    this$0 = paramZzes;
  }
  
  final boolean add()
  {
    return false;
  }
  
  final boolean add(Long paramLong1, Long paramLong2, zzgl paramZzgl, boolean paramBoolean)
  {
    zzny.download();
    boolean bool1 = cache.this$0.append().get(size, zzeb.offset);
    boolean bool3 = this$0.convert();
    boolean bool4 = this$0.getContent();
    boolean bool2 = this$0.format();
    int i;
    if ((!bool3) && (!bool4) && (!bool2)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramBoolean) && (i == 0))
    {
      paramLong2 = cache.this$0.zzay().next();
      i = type;
      paramLong1 = (Long)localObject1;
      if (this$0.prepare()) {
        paramLong1 = Integer.valueOf(this$0.getData());
      }
      paramLong2.append("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(i), paramLong1);
      return true;
    }
    localObject1 = this$0.get();
    bool3 = ((zzel)localObject1).update();
    if (paramZzgl.match())
    {
      if (!((zzel)localObject1).add())
      {
        cache.this$0.zzay().hasNext().append("No number filter for long property. property", cache.this$0.next().get(paramZzgl.next()));
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = TFloatLinkedList.set(TFloatLinkedList.valueOf(paramZzgl.length(), ((zzel)localObject1).toArray()), bool3);
      }
    }
    else if (paramZzgl.remove())
    {
      if (!((zzel)localObject1).add())
      {
        cache.this$0.zzay().hasNext().append("No number filter for double property. property", cache.this$0.next().get(paramZzgl.next()));
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = TFloatLinkedList.set(TFloatLinkedList.toString(paramZzgl.getValue(), ((zzel)localObject1).toArray()), bool3);
      }
    }
    else if (paramZzgl.a())
    {
      if (!((zzel)localObject1).isEmpty())
      {
        if (!((zzel)localObject1).add())
        {
          cache.this$0.zzay().hasNext().append("No string or number filter defined. property", cache.this$0.next().get(paramZzgl.next()));
          localObject1 = localObject2;
        }
        else if (zzlb.get(paramZzgl.intValue()))
        {
          localObject1 = TFloatLinkedList.set(TFloatLinkedList.get(paramZzgl.intValue(), ((zzel)localObject1).toArray()), bool3);
        }
        else
        {
          cache.this$0.zzay().hasNext().append("Invalid user property value for Numeric number filter. property, value", cache.this$0.next().get(paramZzgl.next()), paramZzgl.intValue());
          localObject1 = localObject2;
        }
      }
      else {
        localObject1 = TFloatLinkedList.set(TFloatLinkedList.get(paramZzgl.intValue(), ((zzel)localObject1).getInstance(), cache.this$0.zzay()), bool3);
      }
    }
    else
    {
      cache.this$0.zzay().hasNext().append("User property has no value, property", cache.this$0.next().get(paramZzgl.next()));
      localObject1 = localObject2;
    }
    zzem localZzem = cache.this$0.zzay().next();
    if (localObject1 == null) {
      localObject2 = "null";
    } else {
      localObject2 = localObject1;
    }
    localZzem.append("Property filter result", localObject2);
    if (localObject1 == null) {
      return false;
    }
    start = Boolean.TRUE;
    if ((bool2) && (!((Boolean)localObject1).booleanValue())) {
      return true;
    }
    if ((!paramBoolean) || (this$0.convert())) {
      a = ((Boolean)localObject1);
    }
    if ((((Boolean)localObject1).booleanValue()) && (i != 0) && (paramZzgl.execute()))
    {
      long l1 = paramZzgl.getKey();
      if (paramLong1 != null) {
        l1 = paramLong1.longValue();
      }
      long l2 = l1;
      if (bool1)
      {
        l2 = l1;
        if (this$0.convert())
        {
          l2 = l1;
          if (!this$0.getContent())
          {
            l2 = l1;
            if (paramLong2 != null) {
              l2 = paramLong2.longValue();
            }
          }
        }
      }
      if (this$0.getContent())
      {
        b = Long.valueOf(l2);
        return true;
      }
      c = Long.valueOf(l2);
    }
    return true;
  }
  
  final int get()
  {
    return this$0.getData();
  }
  
  final boolean remove()
  {
    return true;
  }
}
