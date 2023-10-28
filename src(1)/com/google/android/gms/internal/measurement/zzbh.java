package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzbh
  extends zzaw
{
  protected zzbh()
  {
    this$0.add(zzbl.order);
    this$0.add(zzbl.type);
    this$0.add(zzbl.values);
    this$0.add(zzbl.NONE);
    this$0.add(zzbl.ZERO);
    this$0.add(zzbl.ONE);
    this$0.add(zzbl.head);
    this$0.add(zzbl.zzan);
  }
  
  private static zzap addElement(zzbf paramZzbf, zzap paramZzap1, zzap paramZzap2)
  {
    return get(paramZzbf, paramZzap1.toXml(), paramZzap2);
  }
  
  private static zzap get(zzbf paramZzbf, zzap paramZzap1, zzap paramZzap2)
  {
    if ((paramZzap1 instanceof Iterable)) {
      return get(paramZzbf, ((Iterable)paramZzap1).iterator(), paramZzap2);
    }
    throw new IllegalArgumentException("Non-iterable type in for...of loop.");
  }
  
  private static zzap get(zzbf paramZzbf, Iterator paramIterator, zzap paramZzap)
  {
    if (paramIterator != null) {
      while (paramIterator.hasNext())
      {
        Object localObject = paramZzbf.get((zzap)paramIterator.next()).get((zzae)paramZzap);
        if ((localObject instanceof zzag))
        {
          localObject = (zzag)localObject;
          if ("break".equals(((zzag)localObject).getEntry())) {
            return zzap.this$0;
          }
          if ("return".equals(((zzag)localObject).getEntry())) {
            return localObject;
          }
        }
      }
    }
    return zzap.this$0;
  }
  
  public final zzap add(String paramString, Headers paramHeaders, List paramList)
  {
    Object localObject1 = zzbl.list;
    int i = ByteVector.get(paramString).ordinal();
    if (i != 65)
    {
      switch (i)
      {
      default: 
        return super.add(paramString);
      case 32: 
        ByteVector.set(zzbl.head.name(), 3, paramList);
        if ((paramList.get(0) instanceof zzat))
        {
          paramString = ((zzap)paramList.get(0)).getValue();
          localObject1 = paramHeaders.get((zzap)paramList.get(1));
          paramList = paramHeaders.get((zzap)paramList.get(2));
          return get(new zzbe(paramHeaders, paramString), (zzap)localObject1, paramList);
        }
        throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
      case 31: 
        ByteVector.set(zzbl.ONE.name(), 3, paramList);
        if ((paramList.get(0) instanceof zzat))
        {
          paramString = ((zzap)paramList.get(0)).getValue();
          localObject1 = paramHeaders.get((zzap)paramList.get(1));
          paramList = paramHeaders.get((zzap)paramList.get(2));
          return get(new zzbd(paramHeaders, paramString), (zzap)localObject1, paramList);
        }
        throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
      case 30: 
        ByteVector.set(zzbl.ZERO.name(), 3, paramList);
        if ((paramList.get(0) instanceof zzat))
        {
          paramString = ((zzap)paramList.get(0)).getValue();
          localObject1 = paramHeaders.get((zzap)paramList.get(1));
          paramList = paramHeaders.get((zzap)paramList.get(2));
          return get(new zzbg(paramHeaders, paramString), (zzap)localObject1, paramList);
        }
        throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
      case 29: 
        ByteVector.set(zzbl.NONE.name(), 4, paramList);
        paramString = paramHeaders.get((zzap)paramList.get(0));
        if ((paramString instanceof zzae))
        {
          localObject2 = (zzae)paramString;
          zzap localZzap1 = (zzap)paramList.get(1);
          zzap localZzap2 = (zzap)paramList.get(2);
          zzap localZzap3 = paramHeaders.get((zzap)paramList.get(3));
          localObject1 = paramHeaders.get();
          paramList = (List)localObject1;
          i = 0;
          for (;;)
          {
            paramString = paramList;
            if (i >= ((zzae)localObject2).next()) {
              break;
            }
            paramString = ((zzae)localObject2).get(i).getValue();
            ((Headers)localObject1).set(paramString, paramHeaders.get(paramString));
            i += 1;
          }
          while (paramHeaders.get(localZzap1).value().booleanValue())
          {
            paramList = paramHeaders.get((zzae)localZzap3);
            if ((paramList instanceof zzag))
            {
              paramList = (zzag)paramList;
              if ("break".equals(paramList.getEntry())) {
                return zzap.this$0;
              }
              if ("return".equals(paramList.getEntry())) {
                return paramList;
              }
            }
            paramList = paramHeaders.get();
            i = 0;
            while (i < ((zzae)localObject2).next())
            {
              localObject1 = ((zzae)localObject2).get(i).getValue();
              paramList.set((String)localObject1, paramString.get((String)localObject1));
              i += 1;
            }
            paramList.get(localZzap2);
            paramString = paramList;
          }
          return zzap.this$0;
        }
        throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
      case 28: 
        ByteVector.set(zzbl.values.name(), 3, paramList);
        if ((paramList.get(0) instanceof zzat))
        {
          paramString = ((zzap)paramList.get(0)).getValue();
          localObject1 = paramHeaders.get((zzap)paramList.get(1));
          paramList = paramHeaders.get((zzap)paramList.get(2));
          return addElement(new zzbe(paramHeaders, paramString), (zzap)localObject1, paramList);
        }
        throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
      case 27: 
        ByteVector.set(zzbl.type.name(), 3, paramList);
        if ((paramList.get(0) instanceof zzat))
        {
          paramString = ((zzap)paramList.get(0)).getValue();
          localObject1 = paramHeaders.get((zzap)paramList.get(1));
          paramList = paramHeaders.get((zzap)paramList.get(2));
          return addElement(new zzbd(paramHeaders, paramString), (zzap)localObject1, paramList);
        }
        throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
      }
      ByteVector.set(zzbl.order.name(), 3, paramList);
      if ((paramList.get(0) instanceof zzat))
      {
        paramString = ((zzap)paramList.get(0)).getValue();
        localObject1 = paramHeaders.get((zzap)paramList.get(1));
        paramList = paramHeaders.get((zzap)paramList.get(2));
        return addElement(new zzbg(paramHeaders, paramString), (zzap)localObject1, paramList);
      }
      throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
    }
    ByteVector.set(zzbl.zzan.name(), 4, paramList);
    paramString = (zzap)paramList.get(0);
    localObject1 = (zzap)paramList.get(1);
    Object localObject2 = (zzap)paramList.get(2);
    paramList = paramHeaders.get((zzap)paramList.get(3));
    if (paramHeaders.get((zzap)localObject2).value().booleanValue())
    {
      localObject2 = paramHeaders.get((zzae)paramList);
      if ((localObject2 instanceof zzag))
      {
        localObject2 = (zzag)localObject2;
        if ("break".equals(((zzag)localObject2).getEntry())) {
          return zzap.this$0;
        }
        if ("return".equals(((zzag)localObject2).getEntry())) {
          return localObject2;
        }
      }
    }
    while (paramHeaders.get(paramString).value().booleanValue())
    {
      localObject2 = paramHeaders.get((zzae)paramList);
      if ((localObject2 instanceof zzag))
      {
        localObject2 = (zzag)localObject2;
        if ("break".equals(((zzag)localObject2).getEntry())) {
          return zzap.this$0;
        }
        if ("return".equals(((zzag)localObject2).getEntry())) {
          return localObject2;
        }
      }
      paramHeaders.get((zzap)localObject1);
    }
    return zzap.this$0;
  }
}
