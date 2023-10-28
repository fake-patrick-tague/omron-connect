package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzao
  extends zzai
  implements zzal
{
  protected final List path;
  protected final List pressure;
  protected Headers size;
  
  private zzao(zzao paramZzao)
  {
    super(value);
    ArrayList localArrayList = new ArrayList(path.size());
    path = localArrayList;
    localArrayList.addAll(path);
    localArrayList = new ArrayList(pressure.size());
    pressure = localArrayList;
    localArrayList.addAll(pressure);
    size = size;
  }
  
  public zzao(String paramString, List paramList1, List paramList2, Headers paramHeaders)
  {
    super(paramString);
    path = new ArrayList();
    size = paramHeaders;
    if (!paramList1.isEmpty())
    {
      paramString = paramList1.iterator();
      while (paramString.hasNext())
      {
        paramList1 = (zzap)paramString.next();
        path.add(paramList1.getValue());
      }
    }
    pressure = new ArrayList(paramList2);
  }
  
  public final zzap get(Headers paramHeaders, List paramList)
  {
    Headers localHeaders = size.get();
    int i = 0;
    while (i < path.size())
    {
      if (i < paramList.size()) {
        localHeaders.add((String)path.get(i), paramHeaders.get((zzap)paramList.get(i)));
      } else {
        localHeaders.add((String)path.get(i), zzap.this$0);
      }
      i += 1;
    }
    Iterator localIterator = pressure.iterator();
    while (localIterator.hasNext())
    {
      zzap localZzap = (zzap)localIterator.next();
      paramList = localHeaders.get(localZzap);
      paramHeaders = paramList;
      if ((paramList instanceof zzaq)) {
        paramHeaders = localHeaders.get(localZzap);
      }
      if ((paramHeaders instanceof zzag)) {
        return ((zzag)paramHeaders).getPolicy();
      }
    }
    return zzap.this$0;
  }
  
  public final zzap multiply()
  {
    return new zzao(this);
  }
}
