package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzia
{
  private static final zzic animations = new zzic(zzhs.SHOW_USER, null);
  private static final AtomicInteger generation = new AtomicInteger();
  private static final Object handler = new Object();
  private static volatile boolean showIcons;
  private static final AtomicReference sounds = new AtomicReference();
  private static volatile zzhy table;
  private volatile int key;
  private volatile Object other;
  final String rating;
  private final boolean read;
  private final Object set;
  final zzhx type;
  
  public static void clear(Context paramContext)
  {
    if (table == null)
    {
      Object localObject = handler;
      try
      {
        if (table == null) {
          try
          {
            zzhy localZzhy = table;
            Context localContext = paramContext.getApplicationContext();
            if (localContext != null) {
              paramContext = localContext;
            }
            if ((localZzhy == null) || (localZzhy.get() != paramContext))
            {
              zzhe.onDestroy();
              zzib.init();
              zzhm.stop();
              table = new zzhb(paramContext, zzil.toLowerCase(new zzhr(paramContext)));
              generation.incrementAndGet();
            }
          }
          catch (Throwable paramContext)
          {
            throw paramContext;
          }
        }
        return;
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
  }
  
  public static void invalidate()
  {
    generation.incrementAndGet();
  }
  
  public final Object equals()
  {
    if (!read) {
      Objects.requireNonNull(rating, "flagName must not be null");
    }
    int i = generation.get();
    if (key < i) {}
    for (;;)
    {
      Object localObject3;
      try
      {
        if (key < i)
        {
          zzhy localZzhy = table;
          if (localZzhy != null)
          {
            Object localObject1 = type;
            boolean bool = status;
            if (data != null)
            {
              if (!zzho.init(localZzhy.get(), type.data)) {
                break label360;
              }
              bool = type.type;
              localObject1 = zzhe.get(localZzhy.get().getContentResolver(), type.data, zzhq.code);
            }
            else
            {
              localObject1 = localZzhy.get();
              localObject3 = type.protocol;
              localObject1 = zzib.init((Context)localObject1, null, zzhq.code);
            }
            if (localObject1 == null) {
              break label365;
            }
            localObject1 = ((zzhj)localObject1).get(getObjectId());
            if (localObject1 == null) {
              break label365;
            }
            localObject1 = parse(localObject1);
            break label367;
            if (type.version) {
              break label374;
            }
            localObject3 = zzhm.get(localZzhy.get());
            if (type.version) {
              localObject1 = null;
            } else {
              localObject1 = rating;
            }
            localObject1 = ((zzhm)localObject3).toString((String)localObject1);
            if (localObject1 == null) {
              break label374;
            }
            localObject3 = parse(localObject1);
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = set;
            }
            localObject3 = (zzif)localZzhy.getName().dotProduct();
            if (((zzif)localObject3).isEmpty())
            {
              localObject1 = (zzhg)((zzif)localObject3).get();
              localObject3 = type;
              localObject1 = ((zzhg)localObject1).toString(data, null, id, rating);
              if (localObject1 == null) {
                localObject1 = set;
              } else {
                localObject1 = parse(localObject1);
              }
            }
            other = localObject1;
            key = i;
          }
          else
          {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      return other;
      label360:
      Object localObject2 = null;
      continue;
      label365:
      localObject2 = null;
      label367:
      if (localObject2 != null)
      {
        continue;
        label374:
        localObject3 = null;
      }
    }
  }
  
  public final String getObjectId()
  {
    String str = type.id;
    return rating;
  }
  
  abstract Object parse(Object paramObject);
}
