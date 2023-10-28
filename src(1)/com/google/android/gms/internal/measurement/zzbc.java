package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbc
  extends zzaw
{
  protected zzbc()
  {
    this$0.add(zzbl.id);
    this$0.add(zzbl.x);
    this$0.add(zzbl.item);
  }
  
  public final zzap add(String paramString, Headers paramHeaders, List paramList)
  {
    zzbl localZzbl = zzbl.list;
    int i = ByteVector.get(paramString).ordinal();
    if (i != 1)
    {
      if (i != 47)
      {
        if (i != 50) {
          return super.add(paramString);
        }
        ByteVector.set(zzbl.item.name(), 2, paramList);
        paramString = paramHeaders.get((zzap)paramList.get(0));
        if (paramString.value().booleanValue()) {
          return paramString;
        }
        return paramHeaders.get((zzap)paramList.get(1));
      }
      ByteVector.set(zzbl.x.name(), 1, paramList);
      return new zzaf(Boolean.valueOf(paramHeaders.get((zzap)paramList.get(0)).value().booleanValue() ^ true));
    }
    ByteVector.set(zzbl.id.name(), 2, paramList);
    paramString = paramHeaders.get((zzap)paramList.get(0));
    if (!paramString.value().booleanValue()) {
      return paramString;
    }
    return paramHeaders.get((zzap)paramList.get(1));
  }
}
