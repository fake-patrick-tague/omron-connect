package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

public final class TokenStream
  extends zzai
{
  private final ResultSet resultSet;
  
  public TokenStream(String paramString, ResultSet paramResultSet)
  {
    super("internal.remoteConfig");
    resultSet = paramResultSet;
    data.put("getValue", new Query(this, "getValue", paramResultSet));
  }
  
  public final zzap get(Headers paramHeaders, List paramList)
  {
    return zzap.this$0;
  }
}
