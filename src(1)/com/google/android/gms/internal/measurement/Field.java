package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public final class Field
{
  private final IntArray delegate;
  final Block next;
  final zzab this$0;
  Headers value;
  
  public Field()
  {
    next = localBlock;
    value = next.get();
    this$0 = new zzab();
    delegate = new IntArray();
    Object localObject = new PhotoDataAdapter.GetUpdateInfo(this);
    end.get("internal.registerCallback", (Callable)localObject);
    localObject = new IntegerPolynomial.CombineTask(this);
    end.get("internal.eventLogger", (Callable)localObject);
  }
  
  public final boolean add(zzaa paramZzaa)
    throws Converters
  {
    try
    {
      this$0.clear(paramZzaa);
      next.value.set("runtime.counter", new zzah(Double.valueOf(0.0D)));
      delegate.add(value.get(), this$0);
      boolean bool = equals();
      if (!bool)
      {
        bool = isEmpty();
        if (!bool) {
          return false;
        }
      }
      return true;
    }
    catch (Throwable paramZzaa)
    {
      throw new Converters(paramZzaa);
    }
  }
  
  public final boolean equals()
  {
    zzab localZzab = this$0;
    return !localZzab.get().equals(localZzab.asMap());
  }
  
  public final zzab get()
  {
    return this$0;
  }
  
  public final boolean isEmpty()
  {
    return !this$0.getText().isEmpty();
  }
  
  public final void process(zzgs paramZzgs)
    throws Converters
  {
    try
    {
      value = next.next.get();
      Object localObject1 = paramZzgs.intersect();
      boolean bool = next.add(value, (zzgx[])((List)localObject1).toArray(new zzgx[0])) instanceof zzag;
      if (!bool)
      {
        localObject1 = paramZzgs.getContextRef().getElements().iterator();
        bool = ((Iterator)localObject1).hasNext();
        if (bool)
        {
          Object localObject2 = (zzgq)((Iterator)localObject1).next();
          paramZzgs = ((zzgq)localObject2).get();
          localObject2 = ((zzgq)localObject2).parseDate();
          Iterator localIterator = paramZzgs.iterator();
          for (;;)
          {
            bool = localIterator.hasNext();
            if (!bool) {
              break;
            }
            paramZzgs = (zzgx)localIterator.next();
            zzap localZzap = next.add(value, new zzgx[] { paramZzgs });
            bool = localZzap instanceof zzam;
            if (!bool) {
              break label260;
            }
            paramZzgs = value;
            bool = paramZzgs.set((String)localObject2);
            if (!bool)
            {
              paramZzgs = null;
            }
            else
            {
              paramZzgs = paramZzgs.get((String)localObject2);
              bool = paramZzgs instanceof zzai;
              if (!bool) {
                break label242;
              }
              paramZzgs = (zzai)paramZzgs;
            }
            if (paramZzgs == null) {
              break label224;
            }
            paramZzgs.get(value, Collections.singletonList(localZzap));
          }
          label224:
          throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(localObject2)));
          label242:
          throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(localObject2)));
          label260:
          throw new IllegalArgumentException("Invalid rule definition");
        }
      }
      else
      {
        throw new IllegalStateException("Program loading failed");
      }
    }
    catch (Throwable paramZzgs)
    {
      throw new Converters(paramZzgs);
    }
  }
  
  public final void process(String paramString, Callable paramCallable)
  {
    next.end.get(paramString, paramCallable);
  }
}
