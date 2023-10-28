package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

public final class Menu
  extends zzai
{
  public Menu()
  {
    super("internal.platform");
    data.put("getVersion", new Collector(this, "getVersion"));
  }
  
  public final zzap get(Headers paramHeaders, List paramList)
  {
    return zzap.this$0;
  }
}
