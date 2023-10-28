package com.google.android.gms.internal.common;

import java.util.AbstractCollection;
import java.util.List;

final class zzae
  extends LinkedListMultimap.NodeIterator
{
  private final zzag objectsMap;
  
  zzae(zzag paramZzag, int paramInt)
  {
    super(paramZzag.size(), paramInt);
    objectsMap = paramZzag;
  }
  
  protected final Object add(int paramInt)
  {
    return objectsMap.get(paramInt);
  }
}
