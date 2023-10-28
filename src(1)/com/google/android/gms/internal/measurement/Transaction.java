package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

public final class Transaction
  extends zzai
{
  private final Element content;
  
  public Transaction(Element paramElement)
  {
    super("internal.logger");
    content = paramElement;
    data.put("log", new Floats.FloatArrayAsList(this, false, true));
    data.put("silent", new Scorer(this, "silent"));
    ((zzai)data.get("silent")).add("log", new Floats.FloatArrayAsList(this, true, true));
    data.put("unmonitored", new CopyOnWriteMap(this, "unmonitored"));
    ((zzai)data.get("unmonitored")).add("log", new Floats.FloatArrayAsList(this, false, false));
  }
  
  public final zzap get(Headers paramHeaders, List paramList)
  {
    return zzap.this$0;
  }
}
