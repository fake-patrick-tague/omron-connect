package com.google.android.gms.internal.measurement;

import java.util.List;

final class Query
  extends zzai
{
  Query(TokenStream paramTokenStream, String paramString, ResultSet paramResultSet)
  {
    super("getValue");
  }
  
  public final zzap get(Headers paramHeaders, List paramList)
  {
    ByteVector.set("getValue", 2, paramList);
    zzap localZzap = paramHeaders.get((zzap)paramList.get(0));
    paramHeaders = paramHeaders.get((zzap)paramList.get(1));
    paramList = localZzap.getValue();
    paramList = results.get(paramList);
    if (paramList != null) {
      return new zzat(paramList);
    }
    return paramHeaders;
  }
}
