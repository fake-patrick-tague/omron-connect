package com.google.android.gms.measurement.internal;

import android.util.Log;
import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzny;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v7.util.ArrayMap;

final class State
  extends TFloatLinkedList
{
  private final com.google.android.gms.internal.measurement.zzej this$0;
  
  State(zzaa paramZzaa, String paramString, int paramInt, com.google.android.gms.internal.measurement.zzej paramZzej)
  {
    super(paramString, paramInt);
    this$0 = paramZzej;
  }
  
  final boolean add()
  {
    return this$0.add();
  }
  
  final boolean doInBackground(Long paramLong1, Long paramLong2, zzfs paramZzfs, long paramLong, zzas paramZzas, boolean paramBoolean)
  {
    zzny.download();
    boolean bool1 = items.this$0.append().get(size, zzeb.names);
    if (this$0.getSerieId()) {
      paramLong = name;
    }
    boolean bool2 = Log.isLoggable(items.this$0.zzay().read(), 2);
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4;
    int i;
    if (bool2)
    {
      localObject4 = items.this$0.zzay().next();
      i = type;
      if (this$0.addElement()) {
        paramZzas = Integer.valueOf(this$0.format());
      } else {
        paramZzas = null;
      }
      ((zzem)localObject4).append("Evaluating filter. audience, filter, event", Integer.valueOf(i), paramZzas, items.this$0.next().toString(this$0.getEntry()));
      items.this$0.zzay().next().append("Filter definition", items.this$0.next().toString(this$0));
    }
    if ((this$0.addElement()) && (this$0.format() <= 256))
    {
      bool2 = this$0.doSearch();
      boolean bool3 = this$0.parseInt();
      boolean bool4 = this$0.getSerieId();
      if ((!bool2) && (!bool3) && (!bool4)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((paramBoolean) && (i == 0))
      {
        paramLong2 = items.this$0.zzay().next();
        i = type;
        paramLong1 = (Long)localObject3;
        if (this$0.addElement()) {
          paramLong1 = Integer.valueOf(this$0.format());
        }
        paramLong2.append("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(i), paramLong1);
        return true;
      }
      localObject4 = this$0;
      localObject2 = paramZzfs.getValue();
      if (((com.google.android.gms.internal.measurement.zzej)localObject4).add())
      {
        paramZzas = TFloatLinkedList.valueOf(paramLong, ((com.google.android.gms.internal.measurement.zzej)localObject4).getParameter());
        if (paramZzas == null)
        {
          paramZzas = (zzas)localObject1;
          break label1478;
        }
        if (!paramZzas.booleanValue())
        {
          paramZzas = Boolean.FALSE;
          break label1478;
        }
      }
      Object localObject5 = new HashSet();
      paramZzas = ((com.google.android.gms.internal.measurement.zzej)localObject4).get().iterator();
      while (paramZzas.hasNext())
      {
        localObject3 = (zzel)paramZzas.next();
        if (((zzel)localObject3).get().isEmpty())
        {
          items.this$0.zzay().hasNext().append("null or empty param name in filter. event", items.this$0.next().toString((String)localObject2));
          paramZzas = (zzas)localObject1;
          break label1478;
        }
        ((Set)localObject5).add(((zzel)localObject3).get());
      }
      localObject3 = new ArrayMap();
      Object localObject6 = paramZzfs.get().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        paramZzas = (zzfw)((Iterator)localObject6).next();
        if (((Set)localObject5).contains(paramZzas.getValue()))
        {
          String str;
          if (paramZzas.remove())
          {
            str = paramZzas.getValue();
            if (paramZzas.remove()) {
              paramZzas = Long.valueOf(paramZzas.currentTimeMillis());
            } else {
              paramZzas = null;
            }
            ((Map)localObject3).put(str, paramZzas);
          }
          else if (paramZzas.booleanValue())
          {
            str = paramZzas.getValue();
            if (paramZzas.booleanValue()) {
              paramZzas = Double.valueOf(paramZzas.split());
            } else {
              paramZzas = null;
            }
            ((Map)localObject3).put(str, paramZzas);
          }
          else if (paramZzas.add())
          {
            ((Map)localObject3).put(paramZzas.getValue(), paramZzas.getLabel());
          }
          else
          {
            items.this$0.zzay().hasNext().append("Unknown value for param. event, param", items.this$0.next().toString((String)localObject2), items.this$0.next().next(paramZzas.getValue()));
            paramZzas = (zzas)localObject1;
            break label1478;
          }
        }
      }
      localObject4 = ((com.google.android.gms.internal.measurement.zzej)localObject4).get().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        paramZzas = (zzel)((Iterator)localObject4).next();
        if ((paramZzas.size()) && (paramZzas.update())) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        localObject5 = paramZzas.get();
        if (((String)localObject5).isEmpty())
        {
          items.this$0.zzay().hasNext().append("Event has empty param name. event", items.this$0.next().toString((String)localObject2));
          paramZzas = (zzas)localObject1;
          break label1478;
        }
        localObject6 = ((Map)localObject3).get(localObject5);
        if ((localObject6 instanceof Long))
        {
          if (!paramZzas.add())
          {
            items.this$0.zzay().hasNext().append("No number filter for long param. event, param", items.this$0.next().toString((String)localObject2), items.this$0.next().next((String)localObject5));
            paramZzas = (zzas)localObject1;
            break label1478;
          }
          paramZzas = TFloatLinkedList.valueOf(((Long)localObject6).longValue(), paramZzas.toArray());
          if (paramZzas == null)
          {
            paramZzas = (zzas)localObject1;
            break label1478;
          }
          if (paramZzas.booleanValue() == paramBoolean)
          {
            paramZzas = Boolean.FALSE;
            break label1478;
          }
        }
        else if ((localObject6 instanceof Double))
        {
          if (!paramZzas.add())
          {
            items.this$0.zzay().hasNext().append("No number filter for double param. event, param", items.this$0.next().toString((String)localObject2), items.this$0.next().next((String)localObject5));
            paramZzas = (zzas)localObject1;
            break label1478;
          }
          paramZzas = TFloatLinkedList.toString(((Double)localObject6).doubleValue(), paramZzas.toArray());
          if (paramZzas == null)
          {
            paramZzas = (zzas)localObject1;
            break label1478;
          }
          if (paramZzas.booleanValue() == paramBoolean)
          {
            paramZzas = Boolean.FALSE;
            break label1478;
          }
        }
        else if ((localObject6 instanceof String))
        {
          if (paramZzas.isEmpty())
          {
            paramZzas = TFloatLinkedList.get((String)localObject6, paramZzas.getInstance(), items.this$0.zzay());
          }
          else
          {
            if (!paramZzas.add()) {
              break label1299;
            }
            localObject6 = (String)localObject6;
            if (!zzlb.get((String)localObject6)) {
              break label1243;
            }
            paramZzas = TFloatLinkedList.get((String)localObject6, paramZzas.toArray());
          }
          if (paramZzas == null)
          {
            paramZzas = (zzas)localObject1;
            break label1478;
          }
          if (paramZzas.booleanValue() == paramBoolean)
          {
            paramZzas = Boolean.FALSE;
            break label1478;
            label1243:
            items.this$0.zzay().hasNext().append("Invalid param value for number filter. event, param", items.this$0.next().toString((String)localObject2), items.this$0.next().next((String)localObject5));
            paramZzas = (zzas)localObject1;
            break label1478;
            label1299:
            items.this$0.zzay().hasNext().append("No filter for String param. event, param", items.this$0.next().toString((String)localObject2), items.this$0.next().next((String)localObject5));
            paramZzas = (zzas)localObject1;
            break label1478;
          }
        }
        else
        {
          if (localObject6 == null)
          {
            items.this$0.zzay().next().append("Missing param for filter. event, param", items.this$0.next().toString((String)localObject2), items.this$0.next().next((String)localObject5));
            paramZzas = Boolean.FALSE;
            break label1478;
          }
          items.this$0.zzay().hasNext().append("Unknown param type. event, param", items.this$0.next().toString((String)localObject2), items.this$0.next().next((String)localObject5));
          paramZzas = (zzas)localObject1;
          break label1478;
        }
      }
      paramZzas = Boolean.TRUE;
      label1478:
      localObject2 = items.this$0.zzay().next();
      if (paramZzas == null) {
        localObject1 = "null";
      } else {
        localObject1 = paramZzas;
      }
      ((zzem)localObject2).append("Event filter result", localObject1);
      if (paramZzas == null) {
        return false;
      }
      localObject1 = Boolean.TRUE;
      start = ((Boolean)localObject1);
      if (!((Boolean)paramZzas).booleanValue()) {
        return true;
      }
      a = ((Boolean)localObject1);
      if ((i != 0) && (paramZzfs.equals()))
      {
        paramZzfs = Long.valueOf(paramZzfs.read());
        if (this$0.parseInt())
        {
          paramLong2 = paramZzfs;
          if (bool1) {
            if (!this$0.add()) {
              paramLong2 = paramZzfs;
            } else {
              paramLong2 = paramLong1;
            }
          }
          b = paramLong2;
          return true;
        }
        paramLong1 = paramZzfs;
        if (bool1)
        {
          paramLong1 = paramZzfs;
          if (this$0.add()) {
            paramLong1 = paramLong2;
          }
        }
        c = paramLong1;
        return true;
      }
    }
    else
    {
      paramLong2 = items.this$0.zzay().hasNext();
      paramZzfs = zzeo.get(size);
      paramLong1 = (Long)localObject2;
      if (this$0.addElement()) {
        paramLong1 = Integer.valueOf(this$0.format());
      }
      paramLong2.append("Invalid event filter ID. appId, id", paramZzfs, String.valueOf(paramLong1));
      return false;
    }
    return true;
  }
  
  final int get()
  {
    return this$0.format();
  }
  
  final boolean remove()
  {
    return false;
  }
}
