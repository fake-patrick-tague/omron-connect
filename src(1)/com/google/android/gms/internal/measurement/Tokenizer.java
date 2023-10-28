package com.google.android.gms.internal.measurement;

import java.util.List;

public final class Tokenizer
  extends zzai
{
  private final IntArray x;
  
  public Tokenizer(IntArray paramIntArray)
  {
    super("internal.registerCallback");
    x = paramIntArray;
  }
  
  public final zzap get(Headers paramHeaders, List paramList)
  {
    ByteVector.set(value, 3, paramList);
    String str = paramHeaders.get((zzap)paramList.get(0)).getValue();
    zzap localZzap = paramHeaders.get((zzap)paramList.get(1));
    if ((localZzap instanceof zzao))
    {
      paramHeaders = paramHeaders.get((zzap)paramList.get(2));
      if ((paramHeaders instanceof zzam))
      {
        paramHeaders = (zzam)paramHeaders;
        if (paramHeaders.has("type"))
        {
          paramList = paramHeaders.get("type").getValue();
          int i;
          if (paramHeaders.has("priority")) {
            i = ByteVector.add(paramHeaders.get("priority").get().doubleValue());
          } else {
            i = 1000;
          }
          x.add(str, i, (zzao)localZzap, paramList);
          return zzap.this$0;
        }
        throw new IllegalArgumentException("Undefined rule type");
      }
      throw new IllegalArgumentException("Invalid callback params");
    }
    throw new IllegalArgumentException("Invalid callback type");
  }
}
