package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzax
{
  final zzbj manipulate = new zzbj();
  final Map this$0 = new HashMap();
  
  public zzax()
  {
    upgradeDatabase(new zzav());
    upgradeDatabase(new zzay());
    upgradeDatabase(new zzaz());
    upgradeDatabase(new zzbc());
    upgradeDatabase(new zzbh());
    upgradeDatabase(new zzbi());
    upgradeDatabase(new zzbk());
  }
  
  public final zzap add(Headers paramHeaders, zzap paramZzap)
  {
    ByteVector.add(paramHeaders);
    Object localObject = paramZzap;
    if ((paramZzap instanceof zzaq))
    {
      paramZzap = (zzaq)paramZzap;
      localObject = paramZzap.remove();
      String str = paramZzap.getKey();
      if (this$0.containsKey(str)) {
        paramZzap = (zzaw)this$0.get(str);
      } else {
        paramZzap = manipulate;
      }
      localObject = paramZzap.add(str, paramHeaders, (List)localObject);
    }
    return localObject;
  }
  
  final void upgradeDatabase(zzaw paramZzaw)
  {
    Iterator localIterator = this$0.iterator();
    while (localIterator.hasNext())
    {
      String str = ((zzbl)localIterator.next()).next().toString();
      this$0.put(str, paramZzaw);
    }
  }
}
