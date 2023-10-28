package com.google.android.gms.internal.measurement;

final class zzlv
  implements zzli
{
  private final int _capacity;
  private final Object[] _elements;
  private final String namespace;
  private final zzll qualifiedName;
  
  zzlv(zzll paramZzll, String paramString, Object[] paramArrayOfObject)
  {
    qualifiedName = paramZzll;
    namespace = paramString;
    _elements = paramArrayOfObject;
    int i = paramString.charAt(0);
    if (i < 55296)
    {
      _capacity = i;
      return;
    }
    int k = i & 0x1FFF;
    int j = 13;
    i = 1;
    int m;
    for (;;)
    {
      m = paramString.charAt(i);
      if (m < 55296) {
        break;
      }
      k |= (m & 0x1FFF) << j;
      j += 13;
      i += 1;
    }
    _capacity = (k | m << j);
  }
  
  public final boolean add()
  {
    return (_capacity & 0x2) == 2;
  }
  
  final String append()
  {
    return namespace;
  }
  
  public final int get()
  {
    if ((_capacity & 0x1) == 1) {
      return 1;
    }
    return 2;
  }
  
  public final zzll getSimpleName()
  {
    return qualifiedName;
  }
  
  final Object[] remove()
  {
    return _elements;
  }
}
