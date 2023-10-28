package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbi
  extends zzaw
{
  protected zzbi()
  {
    this$0.add(zzbl.list);
    this$0.add(zzbl.y);
    this$0.add(zzbl.data);
    this$0.add(zzbl.p);
    this$0.add(zzbl.q);
    this$0.add(zzbl.zzaa);
    this$0.add(zzbl.zzab);
    this$0.add(zzbl.zzad);
    this$0.add(zzbl.zzae);
    this$0.add(zzbl.zzah);
  }
  
  public final zzap add(String paramString, Headers paramHeaders, List paramList)
  {
    zzbl localZzbl = zzbl.list;
    int i = ByteVector.get(paramString).ordinal();
    if (i != 0)
    {
      if (i != 21)
      {
        if (i != 59)
        {
          if ((i != 52) && (i != 53))
          {
            if ((i != 55) && (i != 56))
            {
              switch (i)
              {
              default: 
                return super.add(paramString);
              case 46: 
                ByteVector.set(zzbl.q.name(), 1, paramList);
                return new zzah(Double.valueOf(-paramHeaders.get((zzap)paramList.get(0)).get().doubleValue()));
              case 45: 
                ByteVector.set(zzbl.p.name(), 2, paramList);
                return new zzah(Double.valueOf(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue() * paramHeaders.get((zzap)paramList.get(1)).get().doubleValue()));
              }
              ByteVector.set(zzbl.data.name(), 2, paramList);
              return new zzah(Double.valueOf(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue() % paramHeaders.get((zzap)paramList.get(1)).get().doubleValue()));
            }
            ByteVector.set(paramString, 1, paramList);
            return paramHeaders.get((zzap)paramList.get(0));
          }
          ByteVector.set(paramString, 2, paramList);
          paramString = paramHeaders.get((zzap)paramList.get(0));
          paramHeaders.get((zzap)paramList.get(1));
          return paramString;
        }
        ByteVector.set(zzbl.zzah.name(), 2, paramList);
        paramString = paramHeaders.get((zzap)paramList.get(0));
        paramHeaders = new zzah(Double.valueOf(-paramHeaders.get((zzap)paramList.get(1)).get().doubleValue()));
        return new zzah(Double.valueOf(paramString.get().doubleValue() + paramHeaders.get().doubleValue()));
      }
      ByteVector.set(zzbl.y.name(), 2, paramList);
      return new zzah(Double.valueOf(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue() / paramHeaders.get((zzap)paramList.get(1)).get().doubleValue()));
    }
    ByteVector.set(localZzbl.name(), 2, paramList);
    paramString = paramHeaders.get((zzap)paramList.get(0));
    paramHeaders = paramHeaders.get((zzap)paramList.get(1));
    if ((!(paramString instanceof zzal)) && (!(paramString instanceof zzat)) && (!(paramHeaders instanceof zzal)) && (!(paramHeaders instanceof zzat))) {
      return new zzah(Double.valueOf(paramString.get().doubleValue() + paramHeaders.get().doubleValue()));
    }
    return new zzat(String.valueOf(paramString.getValue()).concat(String.valueOf(paramHeaders.getValue())));
  }
}
