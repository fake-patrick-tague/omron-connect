package com.google.android.gms.internal.measurement;

public final class Block
{
  final zzax blocks;
  final AsyncHttpClient end;
  final Headers next;
  final Headers value;
  
  public Block()
  {
    Object localObject = new zzax();
    blocks = ((zzax)localObject);
    localObject = new Headers(null, (zzax)localObject);
    value = ((Headers)localObject);
    next = ((Headers)localObject).get();
    AsyncHttpClient localAsyncHttpClient = new AsyncHttpClient();
    end = localAsyncHttpClient;
    ((Headers)localObject).set("require", new ImmutableEnumMap(localAsyncHttpClient));
    localAsyncHttpClient.get("internal.platform", Token.PERCENT);
    ((Headers)localObject).set("runtime.counter", new zzah(Double.valueOf(0.0D)));
  }
  
  public final zzap add(Headers paramHeaders, zzgx... paramVarArgs)
  {
    Object localObject = zzap.this$0;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      zzap localZzap = TFloatList.get(paramVarArgs[i]);
      localObject = localZzap;
      ByteVector.add(value);
      if (((localZzap instanceof zzaq)) || ((localZzap instanceof zzao))) {
        localObject = blocks.add(paramHeaders, localZzap);
      }
      i += 1;
    }
    return localObject;
  }
}
